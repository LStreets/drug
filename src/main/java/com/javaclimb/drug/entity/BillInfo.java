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
 * 账单信息
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bill_info")
@ApiModel(value="BillInfo对象", description="账单信息")
public class BillInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "供应商名称")
    private String sname;

    @ApiModelProperty(value = "药品名称")
    private String dname;

    @ApiModelProperty(value = "药品数量")
    private Integer count;

    @ApiModelProperty(value = "总金额")
    private Float total;

    @ApiModelProperty(value = "生产时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date productTime;

    /*生产时间转换成年月日*/
    public String getProductTime(){
        return DateUtil.dateConvert(productTime);
    }
}
