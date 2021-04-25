package com.gxz.autodev.service;


/**
 * @author gxz
 * @date 2021/4/23 22:49
 * 数据迁移任务
 */
public class FlywayTask implements Task{

    private boolean success;

    private boolean execution;



    @Override
    public boolean success() {
        return success;
    }

    @Override
    public void start() {

    }

    @Override
    public boolean execution() {
        return execution;
    }

    @Override
    public boolean verify() {
        return false;
    }
}
