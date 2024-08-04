package com.base.common;

/**
 * IBaseService.
 *
 * @param <T>
 * @author alex on 2022/09/26
 * @version 1.0
 */
public interface IBaseService<T> {

    /**
     * Save entity
     *
     * @param obj Entity to save
     */
    void save(T obj);
}
