package com.base.person.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.base.account.entity.AccountEntity;
import com.base.common.AbstractBaseAuditable;
import com.base.user.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Person entity.
 *
 * @author components on 03/08/2024.
 * @version 1.0
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TBL_PERSON")
public class PersonEntity extends AbstractBaseAuditable<String> {

    private static final long serialVersionUID = 2L;

    @Id
    @Column(name = "PERSON_ID")
    private String personId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "BIRTHDATE")
    private Date birtDate;

    @Column(name = "GENDER")
    private String gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "PERSON_ID", insertable = false, updatable = false)
    private UserEntity user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "personEntity")
    private List<AccountEntity> accounts;

    /**
     * Get entity id.
     */
    @Override
    public String getId() {
        return this.personId;
    }
}
