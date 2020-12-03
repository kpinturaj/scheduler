package com.uber.util;

import java.util.Comparator;

public class TaskScheduleEntryComparator implements Comparator<TaskScheduleEntry> {
    @Override
    public int compare(TaskScheduleEntry t1, TaskScheduleEntry t2) {
        return (int)(t2.getTimeStamp() - t1.getTimeStamp());
    }
}
