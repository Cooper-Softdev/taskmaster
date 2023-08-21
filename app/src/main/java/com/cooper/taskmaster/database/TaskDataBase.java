package com.cooper.taskmaster.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.cooper.taskmaster.daos.TaskDao;
import com.cooper.taskmaster.models.Task;


@TypeConverters({TaskDataBaseClassConverter.class})
@Database(entities = {Task.class}, version = 1)
public abstract class TaskDataBase extends RoomDatabase {
    public abstract TaskDao taskDao();
}
