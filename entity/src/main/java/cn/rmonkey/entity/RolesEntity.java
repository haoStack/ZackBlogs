package cn.rmonkey.entity;

import cn.rmonkey.commons.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Zack
 * @Description
 * @date 2022/4/2 14:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("blog_role")
public class RolesEntity extends BaseEntity {
    //角色名称
    private String roleName;
}
