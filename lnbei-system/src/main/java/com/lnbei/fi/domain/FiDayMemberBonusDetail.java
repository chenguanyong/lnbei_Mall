package com.lnbei.fi.domain;

import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lnbei.common.core.domain.BaseEntity;
import com.lnbei.wf.domain.WfBase;
/**
 * 会员每日奖金记录表 fi_day_member_bonus_detail
 * 
 * @author lnbei
 * @date 2020-02-13
 */
public class FiDayMemberBonusDetail extends WfBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/** 会员id */
	private String userId;
	/** 日期 格式；yyyy-MM-dd */
	private Date today;
	/**  */
	private BigDecimal total;
	/**  */
	private BigDecimal jichajiang;
	/** 返利奖 */
	private BigDecimal fanlijiang;
	/** 直推一代 */
	private BigDecimal ztone;
	/** 直推二代 */
	private BigDecimal zttwo;
	/** 股东年底分红 */
	private BigDecimal gdndfenhongjiang;
	/** 返拥奖 */
	private BigDecimal fanyongjiang;
	/** 商城收入 */
	private BigDecimal shopshouru;

	/** 状态 */
	private String status;

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setUserId(String userId) 
	{
		this.userId = userId;
	}

	public String getUserId() 
	{
		return userId;
	}
	
	public void setTotal(BigDecimal total) 
	{
		this.total = total;
	}

	public BigDecimal getTotal() 
	{
		return total;
	}
	public void setJichajiang(BigDecimal jichajiang) 
	{
		this.jichajiang = jichajiang;
	}

	public BigDecimal getJichajiang() 
	{
		return jichajiang;
	}
	public void setFanlijiang(BigDecimal fanlijiang) 
	{
		this.fanlijiang = fanlijiang;
	}

	public BigDecimal getFanlijiang() 
	{
		return fanlijiang;
	}
	public void setZtone(BigDecimal ztone) 
	{
		this.ztone = ztone;
	}

	public BigDecimal getZtone() 
	{
		return ztone;
	}
	public void setZttwo(BigDecimal zttwo) 
	{
		this.zttwo = zttwo;
	}

	public BigDecimal getZttwo() 
	{
		return zttwo;
	}
	public void setGdndfenhongjiang(BigDecimal gdndfenhongjiang) 
	{
		this.gdndfenhongjiang = gdndfenhongjiang;
	}

	public BigDecimal getGdndfenhongjiang() 
	{
		return gdndfenhongjiang;
	}
	public void setFanyongjiang(BigDecimal fanyongjiang) 
	{
		this.fanyongjiang = fanyongjiang;
	}

	public BigDecimal getFanyongjiang() 
	{
		return fanyongjiang;
	}
	public void setShopshouru(BigDecimal shopshouru) 
	{
		this.shopshouru = shopshouru;
	}

	public BigDecimal getShopshouru() 
	{
		return shopshouru;
	}

	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("userId", getUserId())
            .append("day", getDay())
            .append("total", getTotal())
            .append("jichajiang", getJichajiang())
            .append("fanlijiang", getFanlijiang())
            .append("ztone", getZtone())
            .append("zttwo", getZttwo())
            .append("gdndfenhongjiang", getGdndfenhongjiang())
            .append("fanyongjiang", getFanyongjiang())
            .append("shopshouru", getShopshouru())
            .append("createTime", getCreateTime())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("remark", getRemark())
            .append("sort", getSort())
            .append("status", getStatus())
            .toString();
    }
}
