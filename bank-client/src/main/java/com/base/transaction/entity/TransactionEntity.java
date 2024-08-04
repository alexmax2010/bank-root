package com.base.transaction.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.base.common.AbstractBaseAuditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * Transaction entity.
 *
 * @author alex on 03/08/2024.
 * @version 1.0
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TBL_TRANSACTION")
public class TransactionEntity extends AbstractBaseAuditable<String> {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "TRANSACTION_ID")
    private String transactionId;

    @Column(name = "ACCOUNT_ID")
    private Integer accountId;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "INITIAL_BALANCE")
    private BigDecimal initialBalance;

    @Column(name = "MOVEMENT")
    private BigDecimal movement;

    @Column(name = "AVAILABLE_BALANCE")
    private BigDecimal availableBalance;

    @Column(name = "TYPE")
    private String type;

    /**
     * Get entity id.
     */
    @Override
    public String getId() {
        return this.transactionId;
    }
}
