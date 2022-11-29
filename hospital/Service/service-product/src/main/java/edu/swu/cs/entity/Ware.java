package edu.swu.cs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 订单的库存
 * </p>
 *
 * @author liujian
 * @since 2022-11-22
 */
@Getter
@Setter
@ApiModel(value = "Ware对象", description = "订单的库存")
public class Ware implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("产品id")
    private Long productId;

    @ApiModelProperty("该产品的数量")
    private Integer amount;

    @ApiModelProperty("已经锁定的数量")
    private Integer lockAmount;


    public Ware(Long productId, Integer amount) {
        this.productId = productId;
        this.amount = amount;
    }
}
