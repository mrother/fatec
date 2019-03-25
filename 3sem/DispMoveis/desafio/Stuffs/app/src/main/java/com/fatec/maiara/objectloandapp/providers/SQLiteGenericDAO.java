package com.fatec.maiara.objectloandapp.providers;

import java.util.List;

public interface SQLiteGenericDAO<T> {
    public long create(T t) throws Exception;
    public void update(T t) throws Exception;
    public void delete(T t) throws Exception;

    //Read
    public List<T> searchAll() throws Exception;
    public T searchById(long id) throws Exception;




}
