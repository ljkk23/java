package swu.lj.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author liujian
 * @since 2022-05-17
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
      @TableId(value = "u_id", type = IdType.AUTO)
    private Long uId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 直属上级id
     */
    private Long managerId;

    /**
     * 创建时间
     */
      @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}
