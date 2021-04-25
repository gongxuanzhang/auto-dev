package com.gxz.autodev.service;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
public class TransferTask implements Task{

    private String filePath;


    @Override
    public boolean success() {
        return false;
    }

    @Override
    public void start() {

    }

    @Override
    public boolean execution() {
        return false;
    }

    @Override
    public boolean verify() {
        return false;
    }
}
