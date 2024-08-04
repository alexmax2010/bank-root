package com.base.account.repository;

import static com.base.account.entity.QAccountEntity.accountEntity;
import static com.querydsl.core.types.Projections.bean;
import java.math.BigDecimal;
import java.util.List;
import com.base.account.entity.AccountEntity;
import com.base.common.JPAQueryDslBaseRepository;
import com.base.vo.account.AccountUpdateVo;
import com.base.vo.account.AccountVo;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * AccountRepository.
 *
 * @author Kruger on 4/8/2024.
 * @version 1.0
 */
@Lazy
@Repository
public class AccountRepository extends JPAQueryDslBaseRepository<AccountEntity> implements
    IAccountRepository {

    /**
     * Constructor.
     */
    public AccountRepository() {
        super(AccountEntity.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean exist(String personId, String type) {
        JPQLQuery<Integer> query = from(accountEntity)
            .select(accountEntity.accountId);
        BooleanBuilder where = new BooleanBuilder();
        where.and(accountEntity.personId.eq(personId));
        where.and(accountEntity.type.eq(type));
        query.where(where);
        Integer response = query.fetchFirst();
        return null != response;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateBalance(Integer accountId, BigDecimal initialBalance) {
        BooleanBuilder where = new BooleanBuilder();
        where.and(accountEntity.accountId.eq(accountId));
        where.and(accountEntity.status.isTrue());
        updateWithAudit(accountEntity).where(where)
            .set(accountEntity.initialBalance, initialBalance).execute();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<AccountVo> get(String personId) {
        JPQLQuery<AccountVo> query = from(accountEntity)
            .select(bean(AccountVo.class,
                accountEntity.accountId,
                accountEntity.type,
                accountEntity.initialBalance));
        BooleanBuilder where = new BooleanBuilder();
        where.and(accountEntity.personId.eq(personId));
        where.and(accountEntity.status.isTrue());
        query.where(where);
        return query.fetch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountVo getById(Integer accountId) {
        JPQLQuery<AccountVo> query = from(accountEntity)
            .select(bean(AccountVo.class,
                accountEntity.accountId,
                accountEntity.type,
                accountEntity.initialBalance));
        BooleanBuilder where = new BooleanBuilder();
        where.and(accountEntity.accountId.eq(accountId));
        where.and(accountEntity.status.isTrue());
        query.where(where);
        return query.fetchFirst();
    }
}
