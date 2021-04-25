package com.gxz.autodev.service;

/**
 * @author gxz
 * 所有执行的内容都被视为一个Task
 *
 */
public interface Task {


    /**
     * @return Task是否已经完成
     */
    boolean success();

    /**
     * 任务开始
     */
    void start();


    /**
     * @return Task是否正在执行
     */
    boolean execution();


    /**
     * @return 校验任务是否完成
     */
    boolean verify();


}
