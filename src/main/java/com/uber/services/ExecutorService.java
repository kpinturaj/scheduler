package com.uber.services;


import com.uber.command.Command;
import com.uber.jobs.Task;
import com.uber.jobs.poller;
import com.uber.repository.taskRepository;
import com.uber.util.TaskScheduleEntry;
import com.uber.util.TaskScheduleEntryComparator;

import java.util.List;
import java.util.PriorityQueue;

public class ExecutorService extends Thread {

    private static ExecutorService ourInstance = new ExecutorService();

    public static ExecutorService getInstance() {
        return ourInstance;
    }

    private   ExecutorService(){

    }

    private int limit = 4;
    private Thread pollerThread = null;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }


    public void executeCommands(List<Command> commandList){
        int count = 0;
        for(Command command : commandList){
            count++;
            if(count < limit) {
                Thread t = new Task(command);
                t.start();
            } else{
                //handle failure and exceptions
            }
        }
    }

    public void startPolling(){
        if(pollerThread != null && pollerThread.isAlive()) {
         pollerThread = new Task(new poller());
         pollerThread.start();
        }
    }
}
