package musicapp;

import javax.swing.JOptionPane;

public class SLList implements LinearListInterface {

    private Node head;
    private int iSize;
    private Node curNode;
    private Node prevNode;

    public SLList() {
        head = null;
        iSize = 0;
        curNode = null;
        prevNode = null;
    }

    @Override
    //returns if the list is empty or not
    public boolean isEmpty() {
        return iSize == 0;
    }

    @Override
    //returns size of List
    public int size() {
        return iSize;
    }

    @Override
    //to add an element in a specific location given by the index argument
    public void add(int iIndex, Object item) {
        //to add at the head position
        if (iIndex == 1) {
            Node newNode = new Node(item, head);
            head = newNode;
        } else {
            setCurrent(iIndex);
            Node newNode = new Node(item, curNode);
            prevNode.setNext(newNode);
        }
        // as a new one was added the size counter must be increased by 1
        iSize = iSize + 1;
    }

    @Override
    //to add an element to the end of the list as there is no index argument
    public void add(Object element) {
        Node newNode = new Node(element, null);
        if (head == null) {
            head = newNode;
        } else {
            setCurrent(iSize);
            curNode.setNext(newNode);
        }
        iSize = iSize + 1;
    }

    @Override
    public Object get(int iIndex) {
        setCurrent(iIndex);
        return curNode.getElement();
    }

    @Override
    public void remove(int iIndex) {
        // special case for removing the head of the list / first node.
        if (iIndex == 1) {
            head = head.getNext();
        } else {
            // find the previous and current nodes
            setCurrent(iIndex);
            prevNode.setNext(curNode.getNext());
        }
        // as one node was removed the size counter must be decreased by 1
        iSize = iSize - 1;
    }

    private void setCurrent(int index) {
        // sets curNode to the node at position specified by index
        // sets prevNode to the node previous to curNode
        int iCount;
        prevNode = null;
        curNode = head;
        for (iCount = 1; iCount < index; iCount++) {
            prevNode = curNode;
            curNode = curNode.getNext();
        }
    }

    @Override
    //to print out contents of the list to console
    public void printList() {
        Node aNode = head;
        while (aNode != null) {
            System.out.println(aNode.toString());
            aNode = aNode.getNext();
        }
    }

    public void search(String searchTerm) {
        if (this.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Playlist is empty. There are no songs to search.");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            Song currentSong = (Song) currentNode.getElement();
            if (currentSong.getName().equalsIgnoreCase(searchTerm)) {
                JOptionPane.showMessageDialog(null, "Song Found!\nName: " + currentSong.getName());
                break;
        }
            currentNode = currentNode.getNext();
        }
        if (currentNode == null){
            JOptionPane.showMessageDialog(null, (searchTerm + " was not be found, please double check the playlist and your search query"));
        }
    }
    public void delete(String deleteTerm) {
        Node currentNode = head;
        Node prevNode = null;
        int i = 1;
        while (currentNode != null) {
            Song currentSong = (Song) currentNode.getElement();
            if (currentSong.getName().equalsIgnoreCase(deleteTerm)) {
                if (prevNode == null) {
                    head = head.getNext();
                } else {
                    prevNode.setNext(currentNode.getNext());
                }
                iSize--;
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
            i++;
        }
        JOptionPane.showMessageDialog(null, "This List does not contain your Song");
    }

}