package com.gxz.autodev.util;

import java.io.File;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
public class GroovyUtils {


    private static GroovyClassLoader groovyClassLoader = null;

    public static void initGroovyClassLoader() {
        CompilerConfiguration config = new CompilerConfiguration();
        config.setSourceEncoding("UTF-8");
        // 设置该GroovyClassLoader的父ClassLoader为当前线程的加载器(默认)
        groovyClassLoader = new GroovyClassLoader(Thread.currentThread().getContextClassLoader(), config);
    }

    /**
     * 通过GroovyClassLoader加载GroovyShell_2，并反射调用其sayHello(String name, String sex, int age)方法
     *
     */
    public static String invokeSayHello(String name, String sex, int age) {
        String result = "";

        File groovyFile = new File("/Users/gongxuanzhang/workSpace/zhwd/shirodemo/src/main/java/com/example/demo/Test.groovy");
        if (!groovyFile.exists()) {
            return result;
        }

        try {
            // 获得GroovyShell_2加载后的class
            Class<?> groovyClass = groovyClassLoader.parseClass(groovyFile);
            // 获得GroovyShell_2的实例
            GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
            // 反射调用sayHello方法得到返回值
            Object methodResult = groovyObject.invokeMethod("sayHello", new Object[] {name});
            if (methodResult != null) {
                result = methodResult.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
