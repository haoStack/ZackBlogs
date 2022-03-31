package cn.rmonkey.mapper;

import cn.rmonkey.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Zack
 * @Description
 * @date 2022/3/31 22:35
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}
