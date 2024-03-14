package musicapp;
public interface StackInterface {

    public boolean isEmpty();

    public void push(Object newItem);
    
    public Object pop();

    public int size();
    
    public void emptyStack();
    
    public Object peak();
}
