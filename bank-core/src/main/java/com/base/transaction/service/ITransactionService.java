package com.base.transaction.service;

import com.base.common.IBaseService;
import com.base.transaction.entity.TransactionEntity;
import com.base.vo.common.BaseResponseVo;
import com.base.vo.transaction.TransactionRegVo;

/**
 * ITransactionService.
 *
 * @author Kruger on 4/8/2024.
 * @version 1.0
 */
public interface ITransactionService extends IBaseService<TransactionEntity> {

    /**
     * Save transaction.
     *
     * @param transaction TransactionRegVo
     */
    BaseResponseVo save(TransactionRegVo transaction);
}
