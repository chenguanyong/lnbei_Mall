package com.lnbei.framework.web.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnbei.sp.domain.SpGoodsCats;
import com.lnbei.sp.service.ISpGoodsCatsService;

@Service("ViewGoodsCat")
public class ViewGoodsCatService {
	@Autowired
	private ISpGoodsCatsService spGoodsCatsService;

	/**
	 * 获取商品分类列表
	 * 
	 * @param dictType 字典类型
	 * @return 参数键值
	 */
	public List<SpGoodsCats> getGoodsCatsList() {
		SpGoodsCats mGoodsCats = new SpGoodsCats();
		mGoodsCats.setStatus("1");
		mGoodsCats.setDataFlag("1");
		List<SpGoodsCats> mMCats = spGoodsCatsService.selectGoodsCatsAll(mGoodsCats);
		return mMCats;
	}
}
