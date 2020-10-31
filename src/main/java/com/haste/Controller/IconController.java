package com.haste.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * 作者：臧立昆
 * 2020/10/14 14:10
 */

@Controller
@Api(tags = "Icon管理")
@RequestMapping("/Icon")
public class IconController {

    @ResponseBody
    @ApiOperation(value = "获取所有装备Icon")
    @PostMapping("/all")
    public void getAllImage(){

    }
}
