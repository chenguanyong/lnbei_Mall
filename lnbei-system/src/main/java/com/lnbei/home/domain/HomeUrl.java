package com.lnbei.home.domain;



import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;



/**
 * 链接详情表 home_url
 * 
 * @author lnbei
 * @date 2020-01-24
 */
public class HomeUrl extends HomeBase
{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID */
	private String mid;
	/** url名称 */
	private String urlName;
	/** url链接 */
	private String url;
	/** 链接类型 */
	private String urlType;
	
	private String urlTypeId;

	/** 分类ID */
	private String classifyId;
	/**
	 * 分类名称
	 */
	private String classify;
	/** 访问类型 */
	private String accessType;

	/** 点击量 */
	private Long clicks;
	/** 状态 */
	private String status;

	private HomeUrlInfo mHomeUrlInfo;

	public HomeUrlInfo getmHomeUrlInfo() {
		return mHomeUrlInfo;
	}

	public void setmHomeUrlInfo(HomeUrlInfo mHomeUrlInfo) {
		this.mHomeUrlInfo = mHomeUrlInfo;
	}

	public String getUrlTypeId() {
		return urlTypeId;
	}

	public void setUrlTypeId(String urlTypeId) {
		this.urlTypeId = urlTypeId;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setUrlName(String urlName) 
	{
		this.urlName = urlName;
	}

	public String getUrlName() 
	{
		return urlName;
	}
	public void setUrl(String url) 
	{
		this.url = url;
	}

	public String getUrl() 
	{
		return url;
	}
	public void setUrlType(String urlType) 
	{
		this.urlType = urlType;
	}

	public String getUrlType() 
	{
		return urlType;
	}

	public void setClassifyId(String classifyId) 
	{
		this.classifyId = classifyId;
	}

	public String getClassifyId() 
	{
		return classifyId;
	}
	public void setAccessType(String accessType) 
	{
		this.accessType = accessType;
	}

	public String getAccessType() 
	{
		return accessType;
	}

	
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	
	
	public void setClicks(Long clicks) 
	{
		this.clicks = clicks;
	}

	public Long getClicks() 
	{
		return clicks;
	}
	

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("urlName", getUrlName())
            .append("url", getUrl())
            .append("urlType", getUrlType())
            .append("memberId", getMemberId())
            .append("classifyId", getClassifyId())
            .append("accessType", getAccessType())
            .append("userId", getUserId())
            .append("delFlag", getDelFlag())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateUp", getUpdateUp())
            .append("remark", getRemark())
            .append("sort", getSort())
            .append("year", getYear())
            .append("month", getMonth())
            .append("clicks", getClicks())
            .append("day", getDay())
            .toString();
    }
}
