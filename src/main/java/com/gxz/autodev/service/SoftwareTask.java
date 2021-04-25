package com.gxz.autodev.service;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
public interface SoftwareTask extends Task{

    /**
     * 在传输之后需要执行的内容
     * 比如传输的是一个Zip文件 需要先解压
     **/

    void prepared();

    /**
     * 拿到文件全路径（软件包是个文件夹）
     */
    String getFileDirPath();

    /**
     * 传输文件之后的操作
     */
    void afterTransfer();


}
