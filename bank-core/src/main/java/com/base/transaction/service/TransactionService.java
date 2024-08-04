package com.base.transaction.service;

import java.math.BigDecimal;
import com.base.account.repository.IAccountRepository;
import com.base.common.BaseService;
import com.base.transaction.entity.TransactionEntity;
import com.base.transaction.repository.ITransactionRepository;
import com.base.util.ProjectUtil;
import com.base.vo.account.AccountVo;
import com.base.vo.common.BaseResponseVo;
import com.base.vo.transaction.TransactionRegVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TransactionService.
 *
 * @author Kruger on 4/8/2024.
 * @version 1.0
 */

@Transactional(readOnly = true)
@Lazy
@Service
public class TransactionService extends
    BaseService<TransactionEntity, ITransactionRepository> implements
    ITransactionService {

    @Lazy
    @Autowired
    private IAccountRepository accountRepository;

    /**
     * Constructor.
     *
     * @param repository ITransactionRepositoryl
     */
    public TransactionService(ITransactionRepository repository) {
        super(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public BaseResponseVo save(TransactionRegVo transaction) {
        TransactionEntity transactionEntity = ProjectUtil.convert(transaction,
            TransactionEntity.class);
        AccountVo account = this.accountRepository.getById(transaction.getAccountId());
        if (null == account.getInitialBalance() && "D".equals(transaction.getType())) {
            transactionEntity.setInitialBalance(transaction.getMovement());
            transactionEntity.setAvailableBalance(transaction.getMovement());
            this.repository.save(transactionEntity);
            this.accountRepository.updateBalance(account.getAccountId(), transaction.getMovement());
            return BaseResponseVo.builder().build();
        }
        transactionEntity.setInitialBalance(account.getInitialBalance());
        if ("D".equals(transactionEntity.getType())) {
            BigDecimal availableBalance = account.getInitialBalance()
                .add(transactionEntity.getMovement());
            transactionEntity.setAvailableBalance(availableBalance);
            this.repository.save(transactionEntity);
            this.accountRepository.updateBalance(account.getAccountId(), availableBalance);
            return BaseResponseVo.builder().build();
        }
        if (-1 == account.getInitialBalance().compareTo(transaction.getMovement())) {
            return BaseResponseVo.builder().code(2).message("Fondos insuficientes.").build();
        }
        BigDecimal availableBalance = account.getInitialBalance()
            .subtract(transactionEntity.getMovement());
        transactionEntity.setAvailableBalance(availableBalance);
        transactionEntity.setMovement(transactionEntity.getMovement().negate());
        this.repository.save(transactionEntity);
        this.accountRepository.updateBalance(account.getAccountId(), availableBalance);
        return BaseResponseVo.builder().build();
    }
}
