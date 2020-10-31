package com.haste.Pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者：臧立昆
 * 2020/10/9 15:44
 */

@ApiModel("结果实体类")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultPage<T> {
    @ApiModelProperty(value = "结果")
    private Boolean flag;
    @ApiModelProperty(value = "信息")
    private String Msg;
    @ApiModelProperty(value = "数据")
    private T data;
    @ApiModelProperty(value = "数据数量")
    private Integer total;

    public ResultPage(Boolean flag, String msg, T data) {
        this.flag = flag;
        Msg = msg;
        this.data = data;
    }
}
