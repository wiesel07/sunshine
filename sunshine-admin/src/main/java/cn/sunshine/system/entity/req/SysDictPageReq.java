package cn.sunshine.system.entity.req;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import cn.sunshine.common.base.entity.PageReq;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 数据字典分页请求对象
 * </p>
 *
 * @author wuj
 * @since 2019年6月16日
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "数据字典分页请求对象")
public class SysDictPageReq extends PageReq {

	
	@TableId(value = "DICT_ID", type = IdType.ID_WORKER)
	private Long dictId;

	@TableField("DICT_CODE")
	private String dictCode;

	@TableField("DICT_NAME")
	private String dictName;

	@TableField("REMARK")
	private String remark;
}
