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
    
    public Object get(int i){
        return myStack.get(i);
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
        if(!myStack.isEmpty()){
            return myStack.get(0);
        }
        else{
            return null;
        }
    }
    
    //to search and print details of song if a match is found
    public void search(String searchTerm) {
        //when there's nothing in the stack
        if (myStack.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Playlist is empty. There are no songs to search.");
            return;
        }
        //looking for song
        for (Object obj : myStack) {
            Song mySong = (Song) obj;
            if (mySong.getName().equalsIgnoreCase(searchTerm)) {
                JOptionPane.showMessageDialog(null, "Song Found!\nName: " + mySong.getName());
                return;
            }
        }
        //when song is not found
        JOptionPane.showMessageDialog(null, searchTerm + " was not found. Please double check the playlist and your search query");
    }

    
    //Tested and changed to account for ConcurrentModificationException which occured when trying to delete an Object using the for each loop
    public void delete(String deleteTerm) {
    List<Song> songsToRemove = new ArrayList<>();

    // Iterate over myStack to find songs to remove
    for (Object obj : myStack) {
        Song mySong = (Song) obj;
        if (mySong.getName().equalsIgnoreCase(deleteTerm)) {
            songsToRemove.add(mySong);
        }
    }

    // Remove the found songs after iteration
    for (Song songToRemove : songsToRemove) {
        myStack.remove(songToRemove);
    }
}
}