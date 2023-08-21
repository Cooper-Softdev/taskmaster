package com.cooper.taskmaster.activities;

import static com.cooper.taskmaster.MainActivity.DATABASE_NAME;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.cooper.taskmaster.R;
import com.cooper.taskmaster.database.TaskDataBase;
import com.cooper.taskmaster.models.Task;
import com.cooper.taskmaster.models.TaskStatusEnum;

import java.util.Date;

public class AddTasksActivity extends AppCompatActivity {
    TaskDataBase taskDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tasks);

        taskDataBase = Room.databaseBuilder(
                        getApplicationContext(),
                        TaskDataBase.class,
                        DATABASE_NAME)
                .allowMainThreadQueries()
                .build();

        Spinner taskStatusSpinner = (Spinner) findViewById(R.id.AddTaskStatusSpinner);

        setupTaskStatusSpinner(taskStatusSpinner);
        setupSaveButton(taskStatusSpinner);
    }

    void setupTaskStatusSpinner(Spinner taskStatusSpinner) {
        taskStatusSpinner.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                TaskStatusEnum.values()
        ));
    }

    void setupSaveButton(Spinner taskStatusSpinner) {
        Button saveButton = (Button) findViewById(R.id.AddTasksAddTaskButton);
        saveButton.setOnClickListener(v -> {
            Task taskToSave = new Task(
                    ((EditText) findViewById(R.id.AddTasksTaskDescriptionInputForm)).getText().toString(),
                    ((EditText) findViewById(R.id.AddTasksInputFieldForTaskTitle)).getText().toString(),
                    new Date(),
                    TaskStatusEnum.fromString(taskStatusSpinner.getSelectedItem().toString())
            );


            taskDataBase.taskDao().insertTask(taskToSave);

            Toast.makeText(AddTasksActivity.this, "Task Saved!", Toast.LENGTH_SHORT).show();
        });
    }
}
