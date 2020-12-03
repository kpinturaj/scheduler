package com.uber.api;

import com.uber.command.Command;
import org.springframework.expression.spel.ast.MethodReference;

public interface Scheduler {

    void schedulerTask(Command task, Long millis);

    void schedulerTaskAtIntervals(Command task, long intervalInMillis);
}
