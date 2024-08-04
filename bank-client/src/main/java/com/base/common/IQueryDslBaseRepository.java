package com.base.common;

/**
 * Repository interface with querydsl.
 *
 * @param <T> Entity
 * @author alex on 2022/09/26
 * @version 1.0
 */
public interface IQueryDslBaseRepository<T> {

    /**
     * Save entity
     *
     * @param obj Entity to save
     */
    void save(T obj);

}
