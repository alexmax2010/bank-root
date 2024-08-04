package com.base.person.repository;

import static com.base.person.entity.QPersonEntity.personEntity;
import static com.base.user.entity.QUserEntity.userEntity;
import static com.querydsl.core.types.Projections.bean;
import com.base.common.JPAQueryDslBaseRepository;
import com.base.person.entity.PersonEntity;
import com.base.vo.person.PersonUpdateVo;
import com.base.vo.person.PersonVo;
import com.base.vo.user.UserVo;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

/**
 * PersonRepository.
 *
 * @author alex on 8/9/2022.
 * @version 1.0
 */
@Lazy
@Repository
public class PersonRepository extends JPAQueryDslBaseRepository<PersonEntity> implements
    IPersonRepository {

    /**
     * Constructor.
     */
    public PersonRepository() {
        super(PersonEntity.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean exist(String personId) {
        JPQLQuery<String> query = from(personEntity)
            .select(personEntity.personId)
            .where(personEntity.personId.eq(personId));
        String response = query.fetchFirst();
        return StringUtils.isNotBlank(response);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonVo get(String personId) {
        JPQLQuery<PersonVo> query = from(personEntity)
            .select(bean(PersonVo.class,
                personEntity.personId,
                personEntity.name,
                personEntity.address,
                personEntity.phone,
                personEntity.birtDate,
                personEntity.gender,
                bean(UserVo.class, userEntity.userName).as("user")));
        query.innerJoin(personEntity.user, userEntity);
        BooleanBuilder where = new BooleanBuilder();
        where.and(personEntity.personId.eq(personId));
        where.and(personEntity.status.isTrue());
        query.where(where);
        return query.fetchFirst();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateValues(PersonUpdateVo personVo) {
        BooleanBuilder where = new BooleanBuilder();
        where.and(personEntity.personId.eq(personVo.getPersonId()));
        where.and(personEntity.status.isTrue());
        updateWithAudit(personEntity).where(where)
            .set(personEntity.address, personVo.getAddress())
            .set(personEntity.phone, personVo.getPhone())
            .set(personEntity.gender, personVo.getGender()).execute();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(String personId) {
        BooleanBuilder where = new BooleanBuilder();
        where.and(personEntity.personId.eq(personId));
        where.and(personEntity.status.isTrue());
        updateWithAudit(personEntity).where(where)
            .set(personEntity.status, false).execute();
    }
}
