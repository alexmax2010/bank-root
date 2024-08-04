package com.base.person.service;

import com.base.common.BaseService;
import com.base.person.entity.PersonEntity;
import com.base.person.repository.IPersonRepository;
import com.base.user.entity.UserEntity;
import com.base.user.repository.IUserRepository;
import com.base.util.ProjectUtil;
import com.base.vo.person.PersonUpdateVo;
import com.base.vo.person.PersonVo;
import com.base.vo.user.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PersonService.
 *
 * @author components on 8/9/2022.
 * @version 1.0
 */
@Transactional(readOnly = true)
@Lazy
@Service
public class PersonService extends BaseService<PersonEntity, IPersonRepository> implements
    IPersonService {

    @Lazy
    @Autowired
    private IUserRepository userRepository;

    /**
     * Constructor.
     *
     * @param repository IPersonRepository
     */
    public PersonService(IPersonRepository repository) {
        super(repository);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void save(PersonVo personVo) {
        UserVo user = personVo.getUser();
        personVo.setUser(null);
        PersonEntity personEntity = ProjectUtil.convert(personVo, PersonEntity.class);
        this.repository.save(personEntity);
        UserEntity userEntity = ProjectUtil.convert(user, UserEntity.class);
        userEntity.setPersonId(personEntity.getPersonId());
        this.userRepository.save(userEntity);
        personVo.setPersonId(personEntity.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean exist(String personId) {
        return this.repository.exist(personId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PersonVo get(String personId) {
        return this.repository.get(personId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateValues(PersonUpdateVo request) {
        this.repository.updateValues(request);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void delete(String personId) {
        this.repository.delete(personId);
    }
}
