package com.example.cpw252_todoapp;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements CreateToDoItemFragment.AddToDoListener{

    private Button addButton;
    private FragmentManager fragmentManager;
    private DisplayToDoItemListFragment display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        display  = (DisplayToDoItemListFragment) fragmentManager.findFragmentById(R.id.list_to_do_fragment);


        addButton = findViewById(R.id.clear_button);
        addButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                clearToDoItemList(v);
            }
        });
    }

    public void clearToDoItemList(View v){
        display.clearToDoList();
    }

    public void AddToDo(ToDoItem toDoItem){
        display.addToDoItemToList(toDoItem);
    }
}