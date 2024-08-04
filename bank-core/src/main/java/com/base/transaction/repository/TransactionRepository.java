package com.base.transaction.repository;

import static com.base.transaction.entity.QTransactionEntity.transactionEntity;
import static com.querydsl.core.types.Projections.bean;
import java.util.Date;
import java.util.List;
import com.base.common.JPAQueryDslBaseRepository;
import com.base.transaction.entity.TransactionEntity;
import com.base.vo.transaction.TransactionVo;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TransactionVo> getByAccount(Integer accountId, Date startDate, Date endDate) {
        JPQLQuery<TransactionVo> query = from(transactionEntity)
            .select(bean(TransactionVo.class,
                transactionEntity.accountId,
                transactionEntity.type,
                transactionEntity.date,
                transactionEntity.initialBalance,
                transactionEntity.movement,
                transactionEntity.availableBalance));
        BooleanBuilder where = new BooleanBuilder();
        where.and(transactionEntity.accountId.eq(accountId));
        where.and(transactionEntity.status.isTrue());
        where.and(transactionEntity.date.between(startDate, endDate));

        query.where(where);
        query.orderBy(transactionEntity.createDate.desc());
        return query.fetch();
    }
}
