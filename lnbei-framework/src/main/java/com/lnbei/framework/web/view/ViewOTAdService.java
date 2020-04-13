package com.lnbei.framework.web.view;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnbei.ot.domain.OtAdPositions;
import com.lnbei.ot.domain.OtAds;
import com.lnbei.ot.service.IOtAdPositionsService;


@Service("ViewOTAd")
public class ViewOTAdService {
    @Autowired
    private IOtAdPositionsService adPositionsService;

    /**
     * 根据字典类型查询字典数据信息
     * 
     * @param positionCode 位置代码
     * @return 参数键值
     */
    public OtAdPositions getSelectOtAdPositionsList(String positionCode)
    {
        return adPositionsService.selectOtAdPositionsByPositionCode(positionCode);
    }
    /**
     * 根据字典类型查询字典数据信息
     * 
     * @param positionCode 位置代码
     * @return 参数键值
     */
    public List<OtAds> getSelectOtAds(String positionCode)
    {
    	OtAdPositions mAdPositions = adPositionsService.selectOtAdPositionsByPositionCode(positionCode);
        return mAdPositions.getmAds();
    }    
}
