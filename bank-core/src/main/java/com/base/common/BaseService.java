package com.base.common;

import org.springframework.transaction.annotation.Transactional;

/**
 * BaseService.
 *
 * @param <T> class
 * @param <R> repository
 * @author components on 2022/09/26
 */
public class BaseService<T, R extends IQueryDslBaseRepository<T>> implements IBaseService<T> {

    /**
     * Repository.
     */
    protected transient final R repository;

    /**
     * Constructor.
     *
     * @param repository repository
     * @author components on 2022/09/26
     */
    public BaseService(R repository) {
        this.repository = repository;
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public void save(T obj) {
        this.repository.save(obj);
    }

}
