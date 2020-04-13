package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商铺流程表 sp_shop_flows
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpShopFlows extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/** 流程名称 */
	private String flowName;
	/** 是否显示，0隐藏，1显示 */
	private String isShow;

	/** 是否可以删除，0否，1是 */
	private String isdelete;


	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setFlowName(String flowName) 
	{
		this.flowName = flowName;
	}

	public String getFlowName() 
	{
		return flowName;
	}
	public void setIsShow(String isShow) 
	{
		this.isShow = isShow;
	}

	public String getIsShow() 
	{
		return isShow;
	}


	public void setIsdelete(String isdelete) 
	{
		this.isdelete = isdelete;
	}

	public String getIsdelete() 
	{
		return isdelete;
	}
	
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("flowName", getFlowName())
            .append("isShow", getIsShow())
            .append("sort", getSort())
            .append("isdelete", getIsdelete())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .toString();
    }
}
