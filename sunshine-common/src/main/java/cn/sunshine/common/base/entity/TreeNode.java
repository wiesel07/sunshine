package cn.sunshine.common.base.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * <p>
 * 树型基类
 * </p>
 *
 * @author wuj
 * @since 2019年6月14日
 */
@Data
public class TreeNode implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected String id;
	protected String pid;
	protected String code;
	protected String name;
	protected boolean leaf;// 是否叶子节点
	protected Integer rank;// 级数1开始

	protected List<TreeNode> children = new ArrayList<TreeNode>();

	public void add(TreeNode node) {
		children.add(node);
	}
}



