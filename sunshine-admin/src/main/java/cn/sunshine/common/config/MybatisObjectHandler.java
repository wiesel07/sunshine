package cn.sunshine.common.config;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

/**
 * <p>
 * 公用字段自动填充 比如 更新时间 创建时间等
 * </p>
 *
 * @author wuj
 * @since 2019年6月18日
 */
@Component
public class MybatisObjectHandler implements MetaObjectHandler{

	@Override
	public void insertFill(MetaObject metaObject) {
	    //新增时需要填充字段
		setFieldValByName("createTime", new Date(), metaObject);
		setFieldValByName("modifyTime", new Date(), metaObject);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		//更新时 需要填充字段
		setFieldValByName("modifyTime", new Date(), metaObject);
	}

}



