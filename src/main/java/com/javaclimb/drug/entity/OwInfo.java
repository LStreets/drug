package com.javaclimb.drug.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 出入库
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ow_info")
@ApiModel(value="OwInfo对象", description="出入库")
public class OwInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "药品名称")
    private String dname;

    @ApiModelProperty(value = "出库/入库")
    private String type;

    @ApiModelProperty(value = "数量")
    private Integer count;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "操作时间")
//    @TableField(fill = FieldFill.INSERT)
    private Date createTime;


}
