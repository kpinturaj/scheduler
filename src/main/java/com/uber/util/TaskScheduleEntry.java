package com.uber.util;

import com.uber.command.Command;

public class TaskScheduleEntry {

    private Command command;

    private long timeStamp;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
