package com.dwt.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@TableName("p_user")
@ApiModel(value = "PUserDTO对象", description = "")
public class PUserDTO extends Model<PUserDTO> {

    private static final long serialVersionUID = 1L;

    @TableField("p_name")
    private String pName;

    @TableField("p_age")
    private Integer pAge;


    @Override
    public Serializable pkVal() {
        return null;
    }

}
