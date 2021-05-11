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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 退货给供应商
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("return_supplier")
@ApiModel(value="ReturnSupplier对象", description="退货给供应商")
public class ReturnSupplier implements Serializable {

    private static final long serialVersionUID = 1L;


    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "药品名称")
    private String dname;

    @ApiModelProperty(value = "数量")
    private Integer dcount;

    @ApiModelProperty(value = "供应商名称")
    private String sname;

    @ApiModelProperty(value = "生产时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buyTime;

    @ApiModelProperty(value = "退货原因")
    private String reason;

    @ApiModelProperty(value = "操作时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /*进货时间转换成年月日*/
    public String getBuyTimeStr(){
        return DateUtil.dateConvert(buyTime);
    }

    /*退货时间转换成年月日*/

    public String getCreateTime(){
        return DateUtil.dateConvert(createTime);
    }
}
