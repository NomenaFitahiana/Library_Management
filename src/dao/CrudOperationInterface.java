package dao;

import java.util.List;

public interface CrudOperationInterface <T, E>{
    List<T> getAll(int size);

    T findById( E id);

    void deleteById(E id);

}
