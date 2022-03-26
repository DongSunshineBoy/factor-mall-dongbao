package com.dwt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author dongwentao
 * @since 2022-03-06
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("p_product")
@ApiModel(value = "PProductEntity对象", description = "")
public class PProductEntity extends Model<PProductEntity> {

    private static final long serialVersionUID = 1L;

    @TableField("p_product_name")
    private String pProductName;

    @TableField("p_number")
    private Integer pNumber;


    @Override
    public Serializable pkVal() {
        return null;
    }

}
