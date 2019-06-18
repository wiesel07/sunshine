package cn.sunshine.generator.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.hutool.core.bean.BeanUtil;
import cn.sunshine.common.api.R;
import cn.sunshine.common.base.entity.PageReq;
import cn.sunshine.common.base.entity.PageResp;
import cn.sunshine.common.enums.ApiErrorCode;
import cn.sunshine.common.exception.SunshineException;
import cn.sunshine.generator.common.config.properties.GeneratorProperties;
import cn.sunshine.generator.entity.TableInfo;
import cn.sunshine.generator.service.IGeneratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;


@Api(tags = "代码生成")
@Controller
@RequestMapping("/generator")
public class GeneratorController {
	
	private String prefix = "generator";

	@Autowired
	private IGeneratorService generatorService;

	@ApiIgnore
	@GetMapping("")
	String user() {
		return prefix + "/generator";
	}

	@ApiOperation(value = "获取列表(分页)", notes = "获取列表(分页)")
	@ResponseBody
	@GetMapping("/list")
	public 	R<PageResp<TableInfo>> list(PageReq pageReq, @RequestParam Map<String, Object> params) {
		// 查询列表数据
		PageResp<TableInfo> pageResp = generatorService.queryPage(params,pageReq);

		return new R<PageResp<TableInfo>>(pageResp);
	}


	@ApiOperation(value = "根据表名生成代码", notes = "根据表名生成代码")
	@PostMapping("/code/{tableName}")
	public void code(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("tableName") String tableName) throws IOException {
		String[] tableNames = new String[] { tableName };
		byte[] data = generatorService.generatorCode(tableNames);
		response.reset();
		response.setHeader("Content-Disposition", "attachment; filename=\"wiesel.zip\"");
		response.addHeader("Content-Length", "" + data.length);
		response.setContentType("application/octet-stream; charset=UTF-8");

		IOUtils.write(data, response.getOutputStream());
	}

	@RequestMapping("/batchCode/{tableNames}")
	public void batchCode(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("tableNames") String tableNames) throws IOException {

		String[] tableNamesArr = new String[] {};
		tableNamesArr = JSON.parseArray(tableNames).toArray(tableNamesArr);
		byte[] data = generatorService.generatorCode(tableNamesArr);
		response.reset();
		response.setHeader("Content-Disposition", "attachment; filename=\"wiesel.zip\"");
		response.addHeader("Content-Length", "" + data.length);
		response.setContentType("application/octet-stream; charset=UTF-8");

		IOUtils.write(data, response.getOutputStream());
	}

	@ApiOperation(value = "返回生成策略编辑界面", notes = "返回生成策略编辑界面")
	@GetMapping("/edit")
	String edit(Model model) {

		model.addAttribute("property", GeneratorProperties.getGeneratorProperties());
		return prefix + "/edit";
	}

	@ApiOperation(value = "更新生成策略", notes = "更新生成策略")
	@ResponseBody
	@PostMapping("/update")
	public R<String> update(GeneratorProperties generatorProperties) {
		try {
			Map<String, Object> params = BeanUtil.beanToMap(generatorProperties);
			PropertiesConfiguration conf = new PropertiesConfiguration("generator.properties");
			for (Entry<String, Object> entry : params.entrySet()) {
				conf.setProperty(entry.getKey(), entry.getValue());
			}
			conf.save();
		} catch (ConfigurationException e) {
			throw new SunshineException(ApiErrorCode.FAILED);
		}
		return new R<>();
	}
}
