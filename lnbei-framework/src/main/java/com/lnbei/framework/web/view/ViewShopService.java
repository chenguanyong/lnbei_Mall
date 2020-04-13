package com.lnbei.framework.web.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnbei.common.utils.StringUtils;
import com.lnbei.sp.domain.SpShops;
import com.lnbei.sp.service.ISpShopCatsService;
import com.lnbei.sp.service.ISpShopsService;
import com.lnbei.system.domain.SysDictData;
import com.lnbei.system.service.ISysDictDataService;

@Service("ViewShop")
public class ViewShopService extends BaseViewService {
	@Autowired
	private ISpShopsService spShopsService;

	/**
	 * 根据字典类型查询字典数据信息
	 * 
	 * @param dictType 字典类型
	 * @return 参数键值
	 */
	public List<SpShops> getType(String pageSize, String pageNum, String orderByColumn, String isASC) {

		if (StringUtils.isEmpty(orderByColumn)) {
			orderByColumn = "sort";
		}
		if (StringUtils.isEmpty(isASC)) {
			isASC = "desc";
		}
		SpShops mmshop = new SpShops();
		mmshop.setStatus("0");
		mmshop.setDelFlag("0");
		startPage(Integer.parseInt(pageSize), Integer.parseInt(pageNum), orderByColumn, isASC);
		return spShopsService.selectSpShopsList(mmshop);
	}
}
