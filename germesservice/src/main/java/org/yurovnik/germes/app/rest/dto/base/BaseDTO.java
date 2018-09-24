package org.yurovnik.germes.app.rest.dto.base;

import org.yurovnik.germes.app.model.entity.base.AbstractEntity;

public abstract class BaseDTO<T extends AbstractEntity> {

    private int id;

    public void transform(T t){
        id = t.getId();
    }

    public T unTransform(T t){
        t.setId(getId());
        return t;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
