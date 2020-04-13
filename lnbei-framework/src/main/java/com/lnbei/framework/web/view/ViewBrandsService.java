package com.lnbei.framework.web.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnbei.common.utils.StringUtils;
import com.lnbei.sp.domain.SpBrands;
import com.lnbei.sp.service.ISpBrandsService;


@Service("ViewBrands")
public class ViewBrandsService extends BaseViewService {
    @Autowired
    private ISpBrandsService spBrandsService;

    /**
     * 根据字典类型查询字典数据信息
     * 
     * @param dictType 字典类型
     * @return 参数键值
     */
    public List<SpBrands> getBrandsList(String pageSize, String pageNum , String orderByColumn, String isASC, String condition)
    {
    	SpBrands mmBrands = new SpBrands();
    	if(StringUtils.isNotEmpty(condition)) {
			Map<String , Object> map = new HashMap<String, Object>();
			map.put("condition", "and " + condition);
			mmBrands.setParams(map);
    	}
    	startPage(Integer.parseInt(pageSize),Integer.parseInt(pageNum), orderByColumn , isASC );
    	List<SpBrands> vvBrands = spBrandsService.selectSpBrandsList(mmBrands);
        return vvBrands;
    }
}
