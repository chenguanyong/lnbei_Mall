package com.lnbei.fi.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.lnbei.wf.domain.WfBase;
/**
 * 每日奖金记录表 fi_day_bouns_detail
 * 
 * @author lnbei
 * @date 2020-02-13
 */
public class FiDayBounsDetail extends WfBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/** 日期 格式；yyyy-MM-dd */
	private Date today;
	/**  */
	private Float total;
	/** 支出 */
	private Float expend;
	/** 极差奖 */
	private Float jichajiang;
	/** 返利奖 */
	private Float fanlijiang;
	/** 直推一代 */
	private Float ztone;
	/** 直推二代 */
	private Float zttwo;
	/** 股东年底分红 */
	private Float gdndfenhongjiang;
	/** 返拥奖 */
	private Float fanyongjiang;
	/** 商城收入 */
	private Float shopshouru;

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
	
	public void setTotal(Float total) 
	{
		this.total = total;
	}

	public Float getTotal() 
	{
		return total;
	}
	public void setExpend(Float expend) 
	{
		this.expend = expend;
	}

	public Float getExpend() 
	{
		return expend;
	}
	public void setJichajiang(Float jichajiang) 
	{
		this.jichajiang = jichajiang;
	}

	public Float getJichajiang() 
	{
		return jichajiang;
	}
	public void setFanlijiang(Float fanlijiang) 
	{
		this.fanlijiang = fanlijiang;
	}

	public Float getFanlijiang() 
	{
		return fanlijiang;
	}
	public void setZtone(Float ztone) 
	{
		this.ztone = ztone;
	}

	public Float getZtone() 
	{
		return ztone;
	}
	public void setZttwo(Float zttwo) 
	{
		this.zttwo = zttwo;
	}

	public Float getZttwo() 
	{
		return zttwo;
	}
	public void setGdndfenhongjiang(Float gdndfenhongjiang) 
	{
		this.gdndfenhongjiang = gdndfenhongjiang;
	}

	public Float getGdndfenhongjiang() 
	{
		return gdndfenhongjiang;
	}
	public void setFanyongjiang(Float fanyongjiang) 
	{
		this.fanyongjiang = fanyongjiang;
	}

	public Float getFanyongjiang() 
	{
		return fanyongjiang;
	}
	public void setShopshouru(Float shopshouru) 
	{
		this.shopshouru = shopshouru;
	}

	public Float getShopshouru() 
	{
		return shopshouru;
	}

	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
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
            .append("today", getToday())
            .append("total", getTotal())
            .append("expend", getExpend())
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
