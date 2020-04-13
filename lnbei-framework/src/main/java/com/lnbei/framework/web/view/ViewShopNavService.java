package com.lnbei.framework.web.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnbei.common.utils.StringUtils;
import com.lnbei.sp.domain.SpShopCats;
import com.lnbei.sp.service.ISpShopCatsService;
import com.lnbei.system.domain.SysDictData;
import com.lnbei.system.service.ISysDictDataService;

@Service("ViewShopNav")
public class ViewShopNavService extends BaseViewService {
    @Autowired
    private ISpShopCatsService spShopCatsService;

    /**
     * 根据字典类型查询字典数据信息
     * 
     * @param dictType 字典类型
     * @return 参数键值
     */
    public List<SpShopCats> getShopNavList(String pageSize, String pageNum, String shopId, String orderByColumn,
			String isASC)
    {
		if (StringUtils.isEmpty(shopId)) {
			shopId = "1";
		}
		if (StringUtils.isEmpty(orderByColumn)) {
			orderByColumn = "sort";
		}
		if (StringUtils.isEmpty(isASC)) {
			isASC = "desc";
		}
		SpShopCats mCats = new SpShopCats();
		mCats.setShopId(shopId);
		mCats.setParentId("0");
		startPage(Integer.parseInt(pageSize), Integer.parseInt(pageNum), orderByColumn, isASC);
        return spShopCatsService.selectSpShopCatsList(mCats);
    }
}
