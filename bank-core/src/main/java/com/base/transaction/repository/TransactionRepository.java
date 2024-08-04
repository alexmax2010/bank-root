package com.base.transaction.repository;

import com.base.common.JPAQueryDslBaseRepository;
import com.base.transaction.entity.TransactionEntity;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * TransactionRepository.
 *
 * @author Kruger on 4/8/2024.
 * @version 1.0
 */
@Lazy
@Repository
public class TransactionRepository extends JPAQueryDslBaseRepository<TransactionEntity> implements
    ITransactionRepository {

    /**
     * Constructor.
     */
    public TransactionRepository() {
        super(TransactionEntity.class);
    }
}
