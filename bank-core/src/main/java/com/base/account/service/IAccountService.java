package com.base.account.service;

import java.util.Date;
import java.util.List;
import com.base.account.entity.AccountEntity;
import com.base.common.IBaseService;
import com.base.vo.account.AccountVo;

/**
 * IAccountService.
 *
 * @author Kruger on 4/8/2024.
 * @version 1.0
 */
public interface IAccountService extends IBaseService<AccountEntity> {

    /**
     * Save account.
     *
     * @param account AccountVo
     */
    void save(AccountVo account);

    /**
     * Verify existing person.
     *
     * @param personId document number
     * @param type type
     * @return Boolean
     */
    Boolean exist(String personId, String type);

    /**
     * Get accounts.
     *
     * @param personId person id
     * @return List AccountVo
     */
    List<AccountVo> get(String personId);


    /**
     * Get accounts and transactions.
     *
     * @param personId person id
     * @return List AccountVo
     */
    List<AccountVo> getReport(String personId, Date startDate, Date endDate);

}
