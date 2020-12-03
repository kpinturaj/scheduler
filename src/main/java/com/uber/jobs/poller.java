package com.uber.jobs;

import com.uber.command.Command;
import com.uber.repository.taskRepository;
import com.uber.services.ExecutorService;

import java.util.List;

public class poller implements Command {

    //private long pollerIntervalInMillis;


    public void startPolling(long pollerIntervalInMillis){

        while (true){
            pollQueue();
            try {
                Thread.sleep(pollerIntervalInMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void pollQueue(){
        List<Command> commands = taskRepository.getInstance().getAllTasks();
        ExecutorService.getInstance().executeCommands(commands);
    }

    @Override
    public void task() {
        startPolling(10l);
    }
}
