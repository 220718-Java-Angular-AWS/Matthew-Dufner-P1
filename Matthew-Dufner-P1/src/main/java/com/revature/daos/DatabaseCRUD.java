package com.revature.daos;

import java.util.List;

public interface DatabaseCRUD<T> {
    void create(T t);
    T read(int id);
    List<T> readAll();
    void update(T t);
    void delete(int id);

}
