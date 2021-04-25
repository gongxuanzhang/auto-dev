package com.gxz.autodev.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
public class NacosTask extends AbstractSoftwareTask{
    @RequestMapping("/copy/database")
    @ResponseBody
    public String copyDatabase(HttpServletRequest request, String dbCode, String targetPath){
        JSONObject result = new JSONObject();

        //脚本路径
        String shellPath = request.getServletContext().getRealPath("/")+"WEB-INF/classes";
        String cmd = shellPath + "/copyDB.sh "+ dir + " " + targetPath;
        ProcessBuilder builder = new ProcessBuilder("/bin/sh","-c",cmd);
        builder.directory(new File(shellPath));

        int runningStatus = 0;
        String s = null;
        StringBuffer sb = new StringBuffer();
        try {
            Process p = builder.start();

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((s = stdInput.readLine()) != null) {
                LOG.info("shell log info ...." + s);
                sb.append(s);
            }
            while ((s = stdError.readLine()) != null) {
                LOG.error("shell log error...." + s);
                sb.append(s);
            }
            try {
                runningStatus = p.waitFor();
            } catch (InterruptedException e) {
                runningStatus = 1;
                LOG.error("等待shell脚本执行状态时，报错...",e);
                sb.append(e.getMessage());
            }

            closeStream(stdInput);
            closeStream(stdError);

        } catch (Exception e) {
            LOG.error("执行shell脚本出错...",e);
            sb.append(e.getMessage());
            runningStatus =1;
        }
        LOG.info("runningStatus = " + runningStatus);
        if(runningStatus == 0){
            //成功
            result.put("code", "1");
            result.put("msg", "成功");
            return result.toJSONString();
        }else{
            result.put("code", "0");
            result.put("msg", "调用shell脚本复制数据库时失败..." + sb.toString());
            return result.toJSONString();
        }
    }

    private void closeStream(BufferedReader reader){
        try {
            if(reader != null){
                reader.close();
            }
        } catch (Exception e) {
            reader = null;
        }
    }}
