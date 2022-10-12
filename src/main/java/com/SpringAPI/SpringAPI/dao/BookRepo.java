package com.SpringAPI.SpringAPI.dao;

import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository {
    public Book findById(int id);
}
