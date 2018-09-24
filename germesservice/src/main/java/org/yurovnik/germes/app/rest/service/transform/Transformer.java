package org.yurovnik.germes.app.rest.service.transform;

import org.yurovnik.germes.app.model.entity.base.AbstractEntity;
import org.yurovnik.germes.app.rest.dto.base.BaseDTO;

public interface Transformer {
    <T extends AbstractEntity, P extends BaseDTO<T>> P transform(T entity, Class<P> clz);
    <T extends AbstractEntity, P extends BaseDTO<T>> T unTransform(P dto, Class<T> clz);
}
