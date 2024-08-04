package com.base.util;

import java.lang.reflect.InvocationTargetException;
import com.base.exception.BaseRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * ProjectUtil.
 *
 * @author components on 8/9/2022
 * @version 1.0
 */
@Slf4j
public final class ProjectUtil {

    /**
     * Constructor.
     */
    private ProjectUtil() {
    }

    /**
     * Transform to entity.
     *
     * @param source object
     * @param targetType Class type
     * @return entity
     */
    public static <T> T convert(Object source, Class<T> targetType) {
        try {
            T entity = targetType.newInstance();
            PropertyUtils.copyProperties(entity, source);
            return entity;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
            | InstantiationException e) {
            throw new BaseRuntimeException("Error convert", e);
        }
    }

}
