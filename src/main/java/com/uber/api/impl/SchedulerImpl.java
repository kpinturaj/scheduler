package com.uber.api.impl;

import com.uber.api.Scheduler;
import com.uber.command.Command;
import com.uber.repository.taskRepository;
import com.uber.services.ExecutorService;
import org.springframework.expression.spel.ast.MethodReference;

public class SchedulerImpl implements Scheduler {

    @Override
    public void schedulerTask(Command task, Long millis) {
        taskRepository.getInstance().addTaskToQueue(task, millis);
        ExecutorService.getInstance().startPolling();
    }

    @Override
    public void schedulerTaskAtIntervals(Command task, long intervalInMillis) {

    }
}
