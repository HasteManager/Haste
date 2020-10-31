package com.haste.Pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/**
 * 作者：臧立昆
 * 2020/10/9 14:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("分页属性实体类")
public class LimitPage implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value="PageNum")
    private Integer PageNum;
    @ApiModelProperty(value="PageSize")
    private Integer PageSize;

    public Integer getPageNum() {
        return PageNum;
    }

    public void setPageNum(Integer pageNum) {
        PageNum = pageNum;
    }

    public Integer getPageSize() {
        return PageSize;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }
}
