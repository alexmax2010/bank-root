package com.base.account.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import com.base.common.AbstractBaseAuditable;
import com.base.person.entity.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Account entity.
 *
 * @author components on 03/08/2024.
 * @version 1.0
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TBL_ACCOUNT")
public class AccountEntity extends AbstractBaseAuditable<String> {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNTSEQ")
    @SequenceGenerator(name = "ACCOUNTSEQ", sequenceName = "ACCOUNTSEQ", allocationSize = 1)
    @Column(name = "ACCOUNT_ID")
    private String accountId;

    @Column(name = "PERSON_ID")
    private String personId;

    @Column(name = "TYPE")
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "PERSON_ID", insertable = false, updatable = false)
    private PersonEntity personEntity;

    /**
     * Get entity id.
     */
    @Override
    public String getId() {
        return this.accountId;
    }
}
