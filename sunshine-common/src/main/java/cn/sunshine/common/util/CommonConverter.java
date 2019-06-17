package cn.sunshine.common.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.baomidou.mybatisplus.plugins.Page;

import cn.sunshine.common.api.R;
import cn.sunshine.common.base.entity.PageResp;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * 通用转换器
 * </p>
 *
 * @author wuj
 * @since 2019年6月17日
 */
@Slf4j
public class CommonConverter<S, T> {
    /**
     * 对象拷贝
     * @param s
     * @param t
     * @return
     */
    public T copyObject(Object s,Class<T> t){
        T target = null;
        try {
            target = t.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            log.info(e.getMessage());
        }
        if (s==null){
            return target;
        }
        BeanUtils.copyProperties(s,target);
        return target;
    }

    /**
     * 列表拷贝
     * @param sList
     * @param t
     * @return
     */
    public List<T> copyList(List<S> sList, Class<T> t){
        List<T> tList = new ArrayList<>();
        if (sList==null||sList.size()==0){
            return tList;
        }
        for (S s : sList){
            tList.add(copyObject(s,t));
        }
        return tList;
    }

    /**
     * 分页拷贝
     * @param page
     * @param t
     * @return
     */
    public PageResp<T> copyPage(Page<S> page, Class<T> t){
        PageResp<T> pageResp = new PageResp<>();
        List<T> list = null;
        if (page.getRecords()!=null && page.getRecords().size()>0){
            list = copyList(page.getRecords(),t);
        }else {
            list = new ArrayList<>();
        }
        pageResp.setRows(list);
        pageResp.setTotal(page.getTotal());
        pageResp.setCurrent(page.getCurrent());
        pageResp.setSize(page.getSize());
        return pageResp;
    }

    /**
     * 分页拷贝
     * @param sPage
     * @param t
     * @return
     */
    public PageResp<T> copyPage(PageResp<S> sPage, Class<T> t){
        PageResp<T> pageResp = new PageResp<>();
        List<T> list = null;
        if (sPage.getRows()!=null && sPage.getRows().size()>0){
            list = copyList(sPage.getRows(),t);
        }else {
            list = new ArrayList<>();
        }
        pageResp.setRows(list);
        return pageResp;
    }

    /**
     * 公共返回
     * @param page
     * @param t
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public R<T> copyCommonPage(Page<S> page, Class<T> t){
        return new R(copyPage(page,t));
    }

    /**
     * 公共返回
     * @param s
     * @param t
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public R<T> copyCommonObject(Object s,Class<T> t){
        return new R(copyObject(s,t));
    }

}




