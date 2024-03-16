package musicapp;

public interface LinearListInterface {

    public boolean isEmpty();

    public int size();

    public Object get(int index);

    public void remove(int index);

    public void add(int index, Object theElement);

    public void add(Object element);

    public void printList();
    
    public void search(String searchTerm);
    
    public void delete(String deleteTerm);
    
    public Object findAndRemove(String songName);
}
