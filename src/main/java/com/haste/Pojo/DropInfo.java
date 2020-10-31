package com.haste.Pojo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者：臧立昆
 * 2020/10/14 18;50
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("分页属性实体类")
public class DropInfo {
    private Integer itemid;
    private String itemname;
    private Integer itemRate;
    private String groupRate;
    private Integer BaseSell;
    private Integer dropId;
    private String mobname;
    private Integer minLevel;
    private Integer maxLevel;
    private Integer respawntime;
    private Integer spawntype;
    private Integer zoneid;
    private String zonename;


}
