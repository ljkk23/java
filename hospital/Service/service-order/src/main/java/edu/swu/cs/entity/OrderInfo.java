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
import lombok.Setter;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author liujian
 * @since 2022-11-10
 */
@Getter
@Setter
@TableName("order_info")
@ApiModel(value = "OrderInfo对象", description = "订单表")
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单id")
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    public OrderInfo(Long productId, Long userId, Long patientId, Long updateBy) {
        this.productId = productId;
        this.userId = userId;
        this.patientId = patientId;
        this.updateBy = updateBy;
    }

    @ApiModelProperty("订单交易号")
    private Long productId;

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("就诊人id")
    private Long patientId;

    @ApiModelProperty("订单状态，0代表已下单未支付，1代表已支付未服务，2代表已服务，3代表已退号")
    private Integer orderStatus;

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

}
