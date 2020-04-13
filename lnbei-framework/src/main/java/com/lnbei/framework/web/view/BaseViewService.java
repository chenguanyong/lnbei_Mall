package com.lnbei.framework.web.view;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lnbei.common.core.page.PageDomain;
import com.lnbei.common.core.page.TableDataInfo;

import com.lnbei.common.utils.StringUtils;
import com.lnbei.common.utils.sql.SqlUtil;



public class BaseViewService {
    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable(List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }
    /**
     * 设置请求分页数据
     */
    protected void startPage(Integer pageNum, Integer pageSize, String orderByColumn, String isAsc )
    {
        PageDomain pageDomain = new PageDomain();
        pageDomain.setIsAsc(isAsc);
        pageDomain.setOrderByColumn(orderByColumn);
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
        {
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }
}
