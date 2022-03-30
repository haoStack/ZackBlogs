package cn.rmonkey.commons.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Zack
 * @Description 定义所有类基类
 * @date 2022/3/28 17:01
 */
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

    protected Integer id;

}
