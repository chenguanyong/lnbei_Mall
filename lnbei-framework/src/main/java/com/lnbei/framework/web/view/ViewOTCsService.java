package com.lnbei.framework.web.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnbei.ot.domain.OtCarousel;
import com.lnbei.ot.domain.OtCarouselPositions;
import com.lnbei.ot.service.IOtAdPositionsService;
import com.lnbei.ot.service.IOtCarouselPositionsService;
import com.lnbei.system.domain.SysDictData;
import com.lnbei.system.service.ISysDictDataService;

@Service("ViewOTCs")
public class ViewOTCsService {
    @Autowired
    private IOtCarouselPositionsService otCarouselPositionsService;

    /**
     * 根据轮播图code获取轮播图
     * 
     * @param positionCode 
     * @return 参数键值
     */
    public OtCarouselPositions getCarouselPositions(String positionCode)
    {
        return otCarouselPositionsService.selectOtCarouselPositionsByPostionCode(positionCode);//
    }
    /**
     * 根据轮播图code获取轮播图
     * 
     * @param positionCode
     * @return 参数键值
     */
    public List<OtCarousel> getCarouselLis(String positionCode)
    {
    	
        return getCarouselPositions(positionCode).getOtCarousel();
    }  
    /**
     * 根据店铺ID和位置代码获取轮播图
     * @param shopId
     * @param positionCode
     * @return
     */
    public OtCarouselPositions getCarouselsByShopId(String shopId, String positionCode){
    	OtCarouselPositions mmCarouselPositions = new OtCarouselPositions();
    	mmCarouselPositions.setShopId(shopId);
    	mmCarouselPositions.setPositionCode(positionCode);
    	List<OtCarouselPositions> mCarouselPositions =  otCarouselPositionsService.selectOtCarouselPositionsList(mmCarouselPositions);
        return mCarouselPositions.get(0);
    }
    /**
     * 根据店铺ID和位置代码获取轮播图
     * @param shopId
     * @param positionCode
     * @return
     */
    public List<OtCarousel> getCarouselsByShopIdCode(String shopId, String positionCode){
    	OtCarouselPositions mmCarouselPositions = new OtCarouselPositions();
    	mmCarouselPositions.setShopId(shopId);
    	mmCarouselPositions.setPositionCode(positionCode);
    	List<OtCarouselPositions> mCarouselPositions =  otCarouselPositionsService.selectOtCarouselPositionsList(mmCarouselPositions);
        if(mCarouselPositions.size() == 1) {
        	OtCarouselPositions mOtCarouselPositions = mCarouselPositions.get(0);
        	return mOtCarouselPositions.getOtCarousel();
        }else {
        	return null;
        }
    	
    }
}
