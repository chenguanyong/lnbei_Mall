package com.lnbei.oa.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 接口管理表 oa_systen_interface
 * 
 * @author lnbei
 * @date 2019-03-19
 */
public class OaSystenInterface extends OaBase
{
	private static final long serialVersionUID = 1L;
	
	/**  */
	private String id;
	/**  */
	private String systemId;
	/**  */
	private String interfaceName;
	/** 参数 */
	private String param;
	/** 路径 */
	private String url;
	/**  */
	private String status;
	/**  */
	private String delFlag;
	/**  */
	private String createBy;
	/**  */
	private Date createTime;
	/**  */
	private String updateBy;
	/**  */
	private Date updateTime;
	/**  */
	private String remark;
	/**排序**/
	private Integer sort;
	private Integer type;
	private Integer method;
	public Integer getMethod() {
		return method;
	}

	public void setMethod(Integer method) {
		this.method = method;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getId() 
	{
		return id;
	}
	public void setSystemId(String systemId) 
	{
		this.systemId = systemId;
	}

	public String getSystemId() 
	{
		return systemId;
	}
	public void setInterfaceName(String interfaceName) 
	{
		this.interfaceName = interfaceName;
	}

	public String getInterfaceName() 
	{
		return interfaceName;
	}
	public void setParam(String param) 
	{
		this.param = param;
	}

	public String getParam() 
	{
		return param;
	}
	public void setUrl(String url) 
	{
		this.url = url;
	}

	public String getUrl() 
	{
		return url;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	public String getStatus() 
	{
		return status;
	}
	public void setDelFlag(String delFlag) 
	{
		this.delFlag = delFlag;
	}

	public String getDelFlag() 
	{
		return delFlag;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("systemId", getSystemId())
            .append("interfaceName", getInterfaceName())
            .append("param", getParam())
            .append("url", getUrl())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
