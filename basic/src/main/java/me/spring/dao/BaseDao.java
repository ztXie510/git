package me.spring.dao;

import me.spring.entity.IdEntity;
import java.util.List;

/**
 * Generic CRUD DAO interface.
 * MyBatis mappers implement this for basic operations.
 */
public interface BaseDao<T extends IdEntity> {

    T getById(Integer id);

    List<T> list();

    int insert(T entity);

    int update(T entity);

    int delete(Integer id);
}
