package com.uber.jobs;

import com.uber.command.Command;

public class Task  extends Thread{

    private Command command;

    public  Task(Command task){

        this.command = task;
    }

    @Override
    public void run() {
        command.task();
    }
}
