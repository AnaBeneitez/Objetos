package dao;

import java.util.List;

public interface dao<T> {
    public void save(T d);
    public T find (int id);
    public List<T> getAll();
    public void update(T d);
    public void delete(int id);    
}
