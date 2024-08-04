package com.base.account.service;

import java.util.List;
import com.base.account.entity.AccountEntity;
import com.base.account.repository.IAccountRepository;
import com.base.common.BaseService;
import com.base.util.ProjectUtil;
import com.base.vo.account.AccountVo;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * AccountService.
 *
 * @author Kruger on 4/8/2024.
 * @version 1.0
 */
@Transactional(readOnly = true)
@Lazy
@Service
public class AccountService extends BaseService<AccountEntity, IAccountRepository> implements
    IAccountService {

    /**
     * Constructor.
     *
     * @param repository IAccountRepository
     */
    public AccountService(IAccountRepository repository) {
        super(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void save(AccountVo account) {
        AccountEntity accountEntity = ProjectUtil.convert(account, AccountEntity.class);
        this.repository.save(accountEntity);
        account.setAccountId(accountEntity.getAccountId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean exist(String personId, String type) {
        return this.repository.exist(personId, type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<AccountVo> get(String personId) {
        return this.repository.get(personId);
    }
}
