package cn.sunshine.common.util;

import java.util.UUID;

/**
 *
 * @ClassName 类名：IDUtils
 * @Description 功能说明：来源mybatisPlus
 * <p>
 * 高效GUID产生算法(sequence),基于Snowflake实现64位自增ID算法。 <br>
 * 优化开源项目 http://git.oschina.net/yu120/sequence
 * </p>
 ************************************************************************
 * @date 创建日期：2018年7月31日
 * @author 创建人：wuj
 * @version 版本号：V1.0
 *          <p>
 ***************************修订记录*************************************
 * 
 *          2018年7月31日 wuj 创建该类功能。
 *
 ***********************************************************************
 *          </p>
 */
public class IDUtils {

	/**
	 * 主机和进程的机器码
	 */
	private static final Sequence worker = new Sequence();

	public static long newID() {
		return worker.nextId();
	}

	public static String newIDStr() {
		return String.valueOf(worker.nextId());
	}

	/**
	 * <p>
	 * 获取去掉"-" UUID
	 * </p>
	 */
	public static synchronized String new32UUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
