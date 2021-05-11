package com.javaclimb.drug.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.javaclimb.drug.common.DateUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 收到退货
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("return_goods")
@ApiModel(value="ReturnGoods对象", description="收到退货")
public class ReturnGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "药品名称")
    private String dname;

    @ApiModelProperty(value = "数量")
    private Integer count;

    @ApiModelProperty(value = "退货原因")
    private String reason;

    @ApiModelProperty(value = "总金额")
    private Float total;

    @ApiModelProperty(value = "操作时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operatorTime;

    /*生成时间转换为年月日*/
    public String getOperatorTime(){
        return DateUtil.dateConvert(operatorTime);
    }


}
