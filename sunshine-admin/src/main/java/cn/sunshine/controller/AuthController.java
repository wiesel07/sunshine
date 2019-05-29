package cn.sunshine.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @Description
 * @date 2019年5月29日
 * @author wuj
 * @version V1.0
 */

@Api(tags = "权限控制 API")
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {

	@PostMapping("/login")
	@ApiOperation(value = "登录api", notes = "第一次登录异常后，需要获取验证码(启动验证码时)")
	public String login(HttpServletRequest request, HttpServletResponse response) {

		return "TEST";

	}

}
