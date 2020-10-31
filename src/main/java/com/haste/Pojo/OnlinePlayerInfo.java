package com.haste.Pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 作者：臧立昆
 * 2020/10/9 14:25
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("在线玩家信息实体类")
public class OnlinePlayerInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value="角色Id")
    private String charid;
    @ApiModelProperty(value="队伍Id")
    private String partyid;
    @ApiModelProperty(value="角色名字")
    private String charname;
    @ApiModelProperty(value="角色所在区域")
    private String pos_zone;
    @ApiModelProperty(value="角色前区域")
    private String pos_prevzone;
    @ApiModelProperty(value="角色国家")
    private String nation;
    @ApiModelProperty(value="红国Rank")
    private String rank_sandoria;
    @ApiModelProperty(value="蓝国Rank")
    private String rank_bastok;
    @ApiModelProperty(value="黄国Rank")
    private String rank_windurst;
    @ApiModelProperty(value="主职业")
    private String mjob;
    @ApiModelProperty(value="副职业")
    private String sjob;
    @ApiModelProperty(value="主职级别")
    private String mlvl;
    @ApiModelProperty(value="副职级别")
    private String slvl;
    @ApiModelProperty(value="副职级别")
    private String race;

}
