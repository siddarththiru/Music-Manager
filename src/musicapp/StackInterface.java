package musicapp;
public interface StackInterface {

    public boolean isEmpty();

    public void push(Object newItem);
    
    public Object pop();

    public int size();
    
    public void emptyStack();
    
    public Object peek();
    
    public void search(String searchTerm);
    
    public void delete(String deleteTerm);
}
