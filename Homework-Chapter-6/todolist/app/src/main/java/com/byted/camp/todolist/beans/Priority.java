package com.byted.camp.todolist.beans;

import android.graphics.Color;

/**
 * Created on 2019/1/23.
 *
 * @author xuyingyi@bytedance.com (Yingyi Xu)
 */
public enum Priority {
    High(2,Color.rgb(255,193,193)),
    Medium(1, Color.rgb(255,248,220) ),
    Low(0, Color.rgb(173,216,230));

    public final int intValue;
    public final int color;

    Priority(int intValue, int color) {
        this.intValue = intValue;
        this.color = color;
    }

    public static Priority from(int intValue) {
        for (Priority priority : Priority.values()) {
            if (priority.intValue == intValue) {
                return priority;
            }
        }
        return Priority.Low; // default
    }
}
