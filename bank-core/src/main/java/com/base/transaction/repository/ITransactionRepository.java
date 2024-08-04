package com.base.transaction.repository;

import java.util.Date;
import java.util.List;
import com.base.common.IQueryDslBaseRepository;
import com.base.transaction.entity.TransactionEntity;
import com.base.vo.transaction.TransactionVo;

/**
 * ITransactionRepository.
 *
 * @author Kruger on 4/8/2024.
 * @version 1.0
 */
public interface ITransactionRepository extends IQueryDslBaseRepository<TransactionEntity> {

    /**
     * Get transactions by account.
     *
     * @param accountId accountId
     * @return List TransactionVo
     */
    List<TransactionVo> getByAccount(Integer accountId, Date startDate, Date endDate);

}
