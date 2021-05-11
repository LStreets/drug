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
 * 供应商
 * </p>
 *
 * @author LaoJie
 * @since 2021-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("supplier")
@ApiModel(value="Supplier对象", description="供应商")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "供应商名称")
    private String name;

    @ApiModelProperty(value = "供应商描述")
    private String content;

    @ApiModelProperty(value = "创建时间")
//    @TableField(fill = FieldFill.INSERT)
    private Date createTime;


}
