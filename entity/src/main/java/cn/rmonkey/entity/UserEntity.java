package cn.rmonkey.entity;

import cn.rmonkey.commons.entity.IdBaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @author Zack
 * @Description 定义用户实体类
 * @date 2022/3/28 17:01
 */
@TableName("blog_user")
public class UserEntity extends IdBaseEntity {
    //用户openid
    private Long openid;

    //用户昵称
    private String nickName;

    //用户头像地址
    private String headImgUrl;

    //用户密码
    private String password;

    //用户注册时间
    @JsonFormat(pattern = "YYYY-MM-DD", timezone = "GMT+8")
    private Date registerTime;

    //用户状态(0:取消关注，1:在关注）也可理解成用户注销
    private Integer status;

    //用户收藏
    @TableField(exist = false)
    private List<ArticleEntity> collections;

    //用户查看历史
    @TableField(exist = false)
    private List<ArticleEntity> viewHistory;

}