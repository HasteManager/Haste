package com.haste.Controller;

import com.haste.Pojo.AuctionHouse;
import com.haste.Pojo.ResultPage;
import com.haste.Service.AuctionHouseService;
import com.haste.Service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 作者：臧立昆
 * 2020/10/14 14:10
 */

@Controller
@Api(tags = "AH管理")
@RequestMapping("/AH")
@Slf4j
public class AuctionHouseController {

    @Autowired
    AuctionHouseService itemService;

    @ResponseBody
    @ApiOperation(value = "添加物品至AH")
    @PostMapping("/AddOne")
    @ApiImplicitParam
    public ResultPage getAllImage(AuctionHouse auctionHouse, @ApiParam("数量") Integer num) {
        try {
            if (num == null || num <= 99)
            for (Integer integer = 0; integer < num; integer++) {
                itemService.insertSelective(auctionHouse);
            }
            return new ResultPage(true, "添加物品至AH成功", null);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("添加物品至AH失败了");
        }
        return new ResultPage(false, "添加物品至AH失败", null);
    }


}
