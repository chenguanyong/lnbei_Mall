package com.lnbei.framework.web.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnbei.sp.domain.SpShopCats;
import com.lnbei.sp.service.ISpShopCatsService;

@Service("ViewShopCat")
public class ViewShopCatService extends BaseViewService {

	@Autowired
	private ISpShopCatsService spShopCatsService;
	/**
	 * 获取店铺分类
	 * @param shopId
	 * @return
	 */
	public List<SpShopCats> getSpShopCatsList(String shopId){
		SpShopCats mmCats = new SpShopCats();
		mmCats.setShopId(shopId);
		List<SpShopCats> mmShopCats = spShopCatsService.getSpShopCatsAllList(mmCats);
		return mmShopCats;
	}
	
}
