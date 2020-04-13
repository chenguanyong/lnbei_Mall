package com.lnbei.home.domain;



import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;



/**
 * 链接内容表 home_url_info
 * 
 * @author lnbei
 * @date 2020-01-24
 */
public class HomeUrlInfo extends HomeBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String mid;
	/** 创始人 */
	private String urlId;
	/**  */
	private String founder;
	/** 描述 */
	private String describes;

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setUrlId(String urlId) 
	{
		this.urlId = urlId;
	}

	public String getUrlId() 
	{
		return urlId;
	}
	public void setFounder(String founder) 
	{
		this.founder = founder;
	}

	public String getFounder() 
	{
		return founder;
	}
	public void setDescribes(String describes) 
	{
		this.describes = describes;
	}

	public String getDescribes() 
	{
		return describes;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("urlId", getUrlId())
            .append("founder", getFounder())
            .append("describe", getDescribes())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("sort", getSort())
            .toString();
    }
}
