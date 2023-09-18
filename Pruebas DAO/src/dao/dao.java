package dao;

import java.util.List;

public interface dao<T> {
    public void save(T d) throws DocumentoRepetidoException;
    public T find (long documento);
    public List<T> getAll();
    public boolean update(T d);
    public boolean delete(long documento);    
}
