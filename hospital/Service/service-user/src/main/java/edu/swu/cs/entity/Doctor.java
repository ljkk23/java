package edu.swu.cs.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>
 * 医院用户表
 * </p>
 *
 * @author liujian
 * @since 2022-11-10
 */
@Getter
@Setter
@NoArgsConstructor
@TableName("sys_doctor")
@ApiModel(value = "Doctor对象", description = "医院用户表")
public class Doctor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("部门id")
    private Long deptId;

    @ApiModelProperty("医生职称")
    private String title;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("1代表root,2代表普通医生，3代表排版员")
    private String type;

    @ApiModelProperty("账号状态（0正常 1停用）")
    private String status;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机号")
    private String phonenumber;

    @ApiModelProperty("用户性别（0男，1女，2未知）")
    private String sex;

    @ApiModelProperty("头像地址")
    private String avatar;

    @ApiModelProperty("创建时间")
      @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新人")
    private Long updateBy;

    @ApiModelProperty("更新时间")
      @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("删除标志（0代表未删除，1代表已删除）")
    private Integer delFlag;

    @ApiModelProperty("如果是医生就是挂号费")
    private Integer amount;


    public Doctor(Long deptId, String title, String userName, String password, String type, String status, String email, String phonenumber, String sex, String avatar, Integer amount) {
        this.deptId = deptId;
        this.title = title;
        this.userName = userName;
        this.password = password;
        this.status = status;
        this.email = email;
        this.phonenumber = phonenumber;
        this.sex = sex;
        this.avatar = avatar;
        this.amount = amount;
        this.type=type;
    }
}
