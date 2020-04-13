package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 店铺申请表 sp_shop_applys
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpShopApplys extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/** 用户id */
	private String memberId;
	/**  申请联系电话 */
	private String linkPhone;
	/** 申请联系人 */
	private String linkMan;
	/** 申请意向 */
	private String applyIntention;
	/** 店铺名称 */
	private String shopName;
	/**  */
	private String handleReamrk;
	/** 申请状态 0:待处理  1:已处理  -1:无效 */
	private String applyStatus;


	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setMemberId(String memberId) 
	{
		this.memberId = memberId;
	}

	public String getMemberId() 
	{
		return memberId;
	}
	public void setLinkPhone(String linkPhone) 
	{
		this.linkPhone = linkPhone;
	}

	public String getLinkPhone() 
	{
		return linkPhone;
	}
	public void setLinkMan(String linkMan) 
	{
		this.linkMan = linkMan;
	}

	public String getLinkMan() 
	{
		return linkMan;
	}
	public void setApplyIntention(String applyIntention) 
	{
		this.applyIntention = applyIntention;
	}

	public String getApplyIntention() 
	{
		return applyIntention;
	}
	public void setShopName(String shopName) 
	{
		this.shopName = shopName;
	}

	public String getShopName() 
	{
		return shopName;
	}
	public void setHandleReamrk(String handleReamrk) 
	{
		this.handleReamrk = handleReamrk;
	}

	public String getHandleReamrk() 
	{
		return handleReamrk;
	}
	public void setApplyStatus(String applyStatus) 
	{
		this.applyStatus = applyStatus;
	}

	public String getApplyStatus() 
	{
		return applyStatus;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("memberId", getMemberId())
            .append("linkPhone", getLinkPhone())
            .append("linkMan", getLinkMan())
            .append("applyIntention", getApplyIntention())
            .append("shopName", getShopName())
            .append("handleReamrk", getHandleReamrk())
            .append("applyStatus", getApplyStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .append("sort", getSort())
            .toString();
    }
}
