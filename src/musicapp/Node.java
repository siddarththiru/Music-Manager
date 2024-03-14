package musicapp;

public class Node {

    private Object element;
    private Node next;

    //Defining features of a Node object
    public Node(Object inElement, Node inNode) {
        this.element = inElement;
        this.next = inNode;
    }

    //Getters and Setters for the private data members
    public Node getNext() {
        return next;
    }

    public void setNext(Node inNode) {
        this.next = inNode;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object inElement) {
        this.element = inElement;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
