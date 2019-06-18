package cn.sunshine.system.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.sunshine.common.constant.UpmsUrlConstant;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;


/**
 * <p>
 * 数据字典 前端控制器
 * </p>
 *
 * @author wuj
 * @since 2019-06-16
 */
@Slf4j
@RestController
@RequestMapping(UpmsUrlConstant.SYSTEM_DICT)
@Api(tags = "数据字典")
public class SysDictController {

}
