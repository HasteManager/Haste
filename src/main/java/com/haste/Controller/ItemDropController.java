package com.haste.Controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.haste.Pojo.DropInfo;
import com.haste.Pojo.ResultPage;
import com.haste.Service.ItemDropServeice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 作者：臧立昆
 * 2020/10/13 18:43
 */

@Controller
@Slf4j
@RequestMapping("/ItemDrop")
@Api(tags = "物品掉落管理")
public class ItemDropController {
    /*SQL:
    *
    *
    * EXPLAIN
SELECT DISTINCT
	itemid,
	item_basic.NAME AS itemname,
	itemRate,
	groupRate,
	BaseSell,
	dropId,
	mob_groups.NAME AS mobname,
	minLevel,
	maxLevel,
	respawntime,
	spawntype,
	zoneid,
	zone_settings.NAME AS zonename
FROM
	item_basic
	INNER JOIN mob_droplist USING ( itemid )
	INNER JOIN mob_groups  USING ( dropId )
	INNER JOIN zone_settings USING ( zoneid )
WHERE
	mob_groups.zoneid = zone_settings.zoneid
ORDER BY
	BaseSell DESC
    *
    * */
    @Autowired
    ItemDropServeice itemDropServeice;


    @ResponseBody
    @PostMapping("/getAllInfo")
    @ApiOperation("物品掉落")
    public ResultPage ItemDrop(@ApiParam("pageNum") Integer pageNum, @ApiParam("pageSize") Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<DropInfo> dropInfoPage = itemDropServeice.getAllInfo(pageNum,pageSize);
        return new ResultPage(true,"成功",dropInfoPage,getAllNum());
    }

    @ResponseBody
    @PostMapping("/getAllNum")
    @ApiOperation("获取总量")
    public Integer getAllNum(){
        //PageHelper.startPage(pageNum, pageSize);
        Integer num = itemDropServeice.getAllNum();
        return num;
    }

}
