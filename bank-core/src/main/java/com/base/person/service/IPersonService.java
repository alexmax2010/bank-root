package com.base.person.service;

import com.base.common.IBaseService;
import com.base.person.entity.PersonEntity;
import com.base.vo.person.PersonUpdateVo;
import com.base.vo.person.PersonVo;

/**
 * Person services specification.
 *
 * @author components on 2022/09/08.
 * @version 1.0
 */
public interface IPersonService extends IBaseService<PersonEntity> {

    /**
     * Save Person.
     *
     * @param personVo person object
     */
    void save(PersonVo personVo);

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
     * @param personId document number
     * @return personVo
     */
    PersonVo get(String personId);

    /**
     * Update values.
     *
     * @param request PersonUpdateVo
     */
    void updateValues(PersonUpdateVo request);

    /**
     * Delete person.
     *
     * @param personId person id
     */
    void delete(String personId);

}
