package dao;

import java.util.List;

public interface CrudOperationInterface <T>{
    List<T> getAll();

  //  T findById( E id);

}
