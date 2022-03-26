package com.dwt.dto;

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
@ApiModel(value = "PProductDTO对象", description = "")
public class PProductDTO extends Model<PProductDTO> {

    private static final long serialVersionUID = 1L;


    private String pProductName;


    private Integer pNumber;


    @Override
    public Serializable pkVal() {
        return null;
    }

}
