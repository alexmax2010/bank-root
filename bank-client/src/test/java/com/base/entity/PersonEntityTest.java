package com.base.entity;


import com.base.person.entity.PersonEntity;
import org.junit.Assert;
import org.junit.Test;

public class PersonEntityTest {

    @Test
    public void testGetId() {
        String personId = "17123456";
        PersonEntity personEntity = PersonEntity.builder()
            .personId(personId)
            .build();
        Assert.assertEquals(personEntity.getPersonId(), personId);
    }
}
