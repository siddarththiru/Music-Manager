package musicapp;

import java.util.*;
import javax.swing.JOptionPane;

public class MyStack implements StackInterface {

    private ArrayList<Object> myStack;

    //Creating an instance of Stack
    public MyStack() {
        myStack = new ArrayList<Object>();
    }

    @Override
    //returns size of Stack
    public int size() {
        return myStack.size();
    }

    @Override
    //returns boolean if the stack is empty or not
    public boolean isEmpty() {
        return myStack.isEmpty();
    }
    
    @Override
    //removes and returns the top element of the stack
    public Object pop() {
        if (!(myStack.isEmpty())) {
            return myStack.remove(0);
        } else {
            return null;
        }
    }
    
    @Override
    //pushes an item to the top of the stack
    public void push(Object newItem) {
        myStack.add(0, (Object) newItem);

    }

    @Override
    // removes all elements from the stack
    public void emptyStack() {
        while(!myStack.isEmpty()){
            myStack.remove(0);
        }
    }
    
    @Override
    //returns the top element of the stack without removing it
    public Object peek(){
        return myStack.get(0);
    }
    
    //to search and print details of song if a match is found
    public void search(String searchTerm){
        for (Object obj:myStack){
            Song mySong = (Song)obj;
            if(mySong.getName().equalsIgnoreCase(searchTerm)){
                JOptionPane.showMessageDialog(null, "Name: " + mySong.getName() + "\nGenre: " + mySong.getGenre());
            }
        }
    }
}