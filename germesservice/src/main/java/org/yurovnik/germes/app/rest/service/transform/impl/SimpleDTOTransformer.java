package org.yurovnik.germes.app.rest.service.transform.impl;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yurovnik.germes.app.infra.util.Checks;
import org.yurovnik.germes.app.infra.util.ReflectionUtil;
import org.yurovnik.germes.app.model.entity.base.AbstractEntity;
import org.yurovnik.germes.app.rest.dto.base.BaseDTO;
import org.yurovnik.germes.app.rest.service.transform.Transformer;

public class SimpleDTOTransformer implements Transformer {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleDTOTransformer.class);

    @Override
    public <T extends AbstractEntity, P extends BaseDTO<T>> P transform(T entity, Class<P> clz) {
        checkParams(entity, clz);
        P dto = ReflectionUtil.createInstance(clz);
        ReflectionUtil.copyFields(entity, dto, ReflectionUtil.findSimilarFields(entity.getClass(), clz));
        dto.transform(entity);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("SimpleDTOTransformer.transform: {} DTO object", toString(dto));
        }

        return dto;
    }

    private void checkParams(final Object param, final Class<?> clz) {
        Checks.checkParameter(param != null, "Source transformation object is not initialized");
        Checks.checkParameter(clz != null, "No class is defined for transformation");
    }

    @Override
    public <T extends AbstractEntity, P extends BaseDTO<T>> T unTransform(final P dto, final Class<T> clz) {
        checkParams(dto, clz);
        T entity = ReflectionUtil.createInstance(clz);
        ReflectionUtil.copyFields(dto, entity, ReflectionUtil.findSimilarFields(dto.getClass(), clz));
        dto.unTransform(entity);

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("SimpleDTOTransformer.transform: {} entity", toString(entity));
        }

        return entity;
    }

    public static String toString(Object param){
        return ReflectionToStringBuilder.toString(param, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
