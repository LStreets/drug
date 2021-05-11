package com.javaclimb.drug.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 问题药品
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("problem")
@ApiModel(value="Problem对象", description="问题药品")
public class Problem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "药品名称")
    private String dname;

    @ApiModelProperty(value = "问题药品数量")
    private Integer dcount;

    @ApiModelProperty(value = "药品单价")
    private Float dprice;

    @ApiModelProperty(value = "问题原因")
    private String reason;

    @ApiModelProperty(value = "操作时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;


}
