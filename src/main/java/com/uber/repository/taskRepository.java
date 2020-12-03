package com.uber.repository;

import com.uber.command.Command;
import com.uber.util.TaskScheduleEntry;
import com.uber.util.TaskScheduleEntryComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class taskRepository {
    private static taskRepository ourInstance = new taskRepository();

    private PriorityQueue<TaskScheduleEntry> tasks = new PriorityQueue<>(16, new TaskScheduleEntryComparator());

    public static taskRepository getInstance() {
        return ourInstance;
    }

    private taskRepository() {
    }

    public void addTaskToQueue(Command command, long timeStamp){
        TaskScheduleEntry t = new TaskScheduleEntry();
        t.setCommand(command);
        t.setTimeStamp(timeStamp);
    }

    public List<Command> getAllTasks(){
        long currentTime = System.currentTimeMillis();
        List<Command> commands = new ArrayList<>();
        while(!tasks.isEmpty() && tasks.peek().getTimeStamp() < currentTime)
            commands.add(tasks.poll().getCommand());

        return commands;
    }


}
