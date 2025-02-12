package dao;

import java.util.List;

import entity.Criteria;

public interface CrudOperationInterface <T, E>{
    List<T> getAll(int page, int size);

    List<T> filterByCriteria(List<Criteria> criteria);

    T findById( E id);

    void deleteById(E id);

}
