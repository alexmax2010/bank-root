package com.base.person.repository;

import com.base.common.IQueryDslBaseRepository;
import com.base.person.entity.PersonEntity;
import com.base.vo.person.PersonUpdateVo;
import com.base.vo.person.PersonVo;

/**
 * Person repository specification.
 *
 * @author alex on 2022/09/08.
 * @version 1.0
 */
public interface IPersonRepository extends IQueryDslBaseRepository<PersonEntity> {


    /**
     * Verify existing person.
     *
     * @param personId document number
     * @return Boolean
     */
    Boolean exist(String personId);

    /**
     * Find person.
     *
     * @return person
     */
    PersonVo get(String personId);


    /**
     * Update Person.
     *
     * @param person PersonUpdateVo
     */
    void updateValues(PersonUpdateVo person);

    /**
     * Delete person.
     *
     * @param personId person id
     */
    void delete(String personId);
}
