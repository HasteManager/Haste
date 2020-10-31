package com.haste.Pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel(value = "com-haste-Pojo-AuctionHouse")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuctionHouse implements Serializable {
    @ApiModelProperty(value = "")
    private Integer id;

    @ApiModelProperty(value = "")
    private Short itemid;

    @ApiModelProperty(value = "")
    private Boolean stack;

    @ApiModelProperty(value = "")
    private Integer seller;

    @ApiModelProperty(value = "")
    private String sellerName;

    @ApiModelProperty(value = "")
    private Integer date;

    @ApiModelProperty(value = "")
    private Integer price;

    @ApiModelProperty(value = "")
    private String buyerName;

    @ApiModelProperty(value = "")
    private Integer sale;

    @ApiModelProperty(value = "")
    private Integer sellDate;

    private static final long serialVersionUID = 1L;
}