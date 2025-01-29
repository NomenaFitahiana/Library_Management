package dao;

import java.util.List;

public interface CrudOperationInterface <T, E>{
    List<T> getAll();

    T findById( E id);

}
