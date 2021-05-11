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
 * 药品信息
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("drug_info")
@ApiModel(value="DrugInfo对象", description="药品信息")
public class DrugInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "供应商")
    private String supplier;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "生产时间")
    private Date productTime;

    @ApiModelProperty(value = "保质期（月）")
    private String warrenty;

    @ApiModelProperty(value = "药品编码")
    private String number;

    @ApiModelProperty(value = "价格")
    private Float price;

    @ApiModelProperty(value = "库存")
    private Integer stock;

    /*生成时间转换为年月日*/
    public String getProductTime(){
        return DateUtil.dateConvert(productTime);
    }


}
