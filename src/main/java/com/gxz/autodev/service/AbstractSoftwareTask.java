package com.gxz.autodev.service;

/**
 * @author gxz gongxuanzhang@foxmail.com
 **/
public abstract class AbstractSoftwareTask implements SoftwareTask{


    protected String fileDirPath;

    protected String shell;


    @Override
    public void prepared() {

    }

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

    @Override
    public String getFileDirPath() {
        return this.fileDirPath;
    }

    @Override
    public void afterTransfer() {

    }
}
