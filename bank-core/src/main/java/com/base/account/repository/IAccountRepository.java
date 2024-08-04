package com.base.account.repository;

import java.math.BigDecimal;
import java.util.List;
import com.base.account.entity.AccountEntity;
import com.base.common.IQueryDslBaseRepository;
import com.base.vo.account.AccountVo;

/**
 * IAccountRepository.
 *
 * @author Kruger on 4/8/2024.
 * @version 1.0
 */
public interface IAccountRepository extends IQueryDslBaseRepository<AccountEntity> {

    /**
     * Verify existing person.
     *
     * @param personId document number
     * @param type type
     * @return Boolean
     */
    Boolean exist(String personId, String type);

    /**
     * Update initial balance.
     *
     * @param accountId account id
     * @param initialBalance initial balance
     */

    void updateBalance(Integer accountId, BigDecimal initialBalance);

    /**
     * Get accounts.
     *
     * @param personId person id
     * @return List AccountVo
     */
    List<AccountVo> get(String personId);

    /**
     * Get account.
     *
     * @param accountId id
     * @return AccountVo
     */
    AccountVo getById(Integer accountId);
}
