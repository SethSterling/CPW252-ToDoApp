package com.example.cpw252_todoapp;

public class ToDoItem {
    private String Title;
    private String DueDate;
    private String Description;

    public ToDoItem(String title, String dueDate, String description){
        Title = title;
        Description = description;
        DueDate = dueDate;
    }

    public ToDoItem(String title, String dueDate){
        this(title, dueDate, "No Description");
    }
    public ToDoItem(String title){
        this(title, "No Due Date", "No Description");
    }

    public String getTitle(){
        return Title;
    }

    public String getDescription(){
        return Description;
    }

    public String getDueDate(){
        return DueDate;
    }
}
