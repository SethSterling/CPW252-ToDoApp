package com.example.cpw252_todoapp;
public class ToDoItem {
    private String Title;
    private String DueDate;
    private String Description;

    public ToDoItem(){
        this("No title", "No Due Date", "No Description");
    }
    public ToDoItem(String title, String dueDate, String description){
        Title = title;
        if(description.isEmpty()) {
            Description = "No Description";
        }
        else {
            Description = description;
        }
        if (dueDate.isEmpty()){
            DueDate = "No Due Date";
        }
        else {
            DueDate = dueDate;
        }
    }

    public String getTitle(){ return Title; }
    public void setTitle(String title){ Title = title;}

    public String getDescription(){
        return Description;
    }
    public void setDescription(String description){ Description = description;}

    public String getDueDate(){ return DueDate; }
    public void setDueDate(String dueDate){ DueDate = dueDate;}

    @Override
    public String toString(){
        return getTitle() + "\n" + getDescription() + "\n" + getDueDate();
    }
}
