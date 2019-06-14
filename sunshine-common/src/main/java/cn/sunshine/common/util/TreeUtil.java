package cn.sunshine.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import cn.sunshine.common.base.entity.TreeNode;
import lombok.experimental.UtilityClass;

/**
 * <p>
 * 树型数据转换工具类
 * </p>
 *
 * @author wuj
 * @since 2019年6月14日
 */
@UtilityClass
public class TreeUtil {
	/**
	 * 
	 * @Description:创建树形结构
	 * @param <T>
	 * @param list
	 * @return
	 *
	 * @date   创建时间：2019年6月4日
	 * @author 作者：wuj
	 */
	public  <T extends TreeNode> List<T> buildTree(List<T> list) {
		List<T> resultList = new ArrayList<T>();
		
		if(list != null && list.size() > 0) {
			Map<String, String> idMap = new HashMap<String, String>();
            
			for(T treeNode : list) {

    			idMap.put(treeNode.getId(), treeNode.getId());
    		}
            
			List<T> topList = new ArrayList<T>();
            List<T> subList = new ArrayList<T>();
            for (T TreeBean : list) {
				if(TreeBean.getPid() == null || StringUtils.isEmpty(TreeBean.getPid())) {
					//节点的父类id为空则表示自己是顶层节点
					topList.add(TreeBean);
				}else {
					//如果节点的父类id不在所有节点的id中，则表示是顶层节点，否则是非顶层节点
					if(StringUtils.isEmpty(idMap.get(TreeBean.getPid()))) {
						topList.add(TreeBean);
					}else {
						subList.add(TreeBean);
					}
				}
			}
            if(topList != null && topList.size() > 0){
            	//顶层节点非空，循环顶层节点
            	for (T treeNode : topList) {
            		treeNode.setRank(1);
                    resultList.add(findChildren(treeNode, subList));
            	}
            }
		}
		return resultList;
	}

	/**
	 * 
	 * @Description:递归获取子类
	 * @param <T>
	 * @param parent 父类节点
	 * @param subList 遍历对象
	 * @return
	 *
	 * @date   创建时间：2019年6月4日
	 * @author 作者：wuj
	 */
	private <T extends TreeNode> T findChildren(T parent, List<T> subList) {
		for (T treeNode : subList) {
			if(treeNode.getPid().equals(parent.getId())) {
				treeNode.setRank(parent.getRank()+1);//级数加1
				if(parent.getChildren() == null) {
					parent.setChildren(new ArrayList<>());
				}
				parent.getChildren().add(findChildren(treeNode, subList));
			}
		}
		//判断是否是叶子节点
		if(parent.getChildren() != null && parent.getChildren().size() > 0) {
			parent.setLeaf(false);
		}else {
			parent.setLeaf(true);
		}
		return parent;
	}
	
	
	
	/**
	 * 使用递归方法建树
	 *
	 * @param treeNodes
	 * @return
	 */
//	public <T extends TreeNode> List<T> buildByRecursive(List<T> treeNodes, Object root) {
//		List<T> trees = new ArrayList<T>();
//		for (T treeNode : treeNodes) {
//			if (root.equals(treeNode.getPid())) {
//				trees.add(findChildren(treeNode, treeNodes));
//			}
//		}
//		return trees;
//	}

	/**
	 * 递归查找子节点
	 *
	 * @param treeNodes
	 * @return
	 */
//	public <T extends TreeNode> T findChildren(T treeNode, List<T> treeNodes) {
//		for (T it : treeNodes) {
//			if (treeNode.getId() == it.getPid()) {
//				if (treeNode.getChildren() == null) {
//					treeNode.setChildren(new ArrayList<>());
//				}
//				treeNode.add(findChildren(it, treeNodes));
//			}
//		}
//		return treeNode;
//	}
	
	
	/**
	 * 两层循环实现建树
	 *
	 * @param treeNodes 传入的树节点列表
	 * @return
	 */
//	public <T extends TreeNode> List<T> bulid(List<T> treeNodes, Object root) {
//
//		List<T> trees = new ArrayList<>();
//
//		for (T treeNode : treeNodes) {
//
//			if (root.equals(treeNode.getPid())) {
//				trees.add(treeNode);
//			}
//
//			for (T it : treeNodes) {
//				if (it.getPid() == treeNode.getId()) {
//					if (treeNode.getChildren() == null) {
//						treeNode.setChildren(new ArrayList<>());
//					}
//					treeNode.add(it);
//				}
//			}
//		}
//		return trees;
//	}
}







