package cn.rmonkey.commons.entity;

import cn.rmonkey.commons.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class IdBaseEntity extends BaseEntity implements Serializable {

    protected Integer id;
}
