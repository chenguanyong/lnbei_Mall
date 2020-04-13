package com.lnbei.sp.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商家审核表 sp_shop_bases
 * 
 * @author lnbei
 * @date 2020-02-05
 */
public class SpShopBases extends SpBase
{
	private static final long serialVersionUID = 1L;
	
	/** 自增id */
	private String mid;
	/** 流程id */
	private String flowId;
	/** 表单字段 */
	private String fieldName;
	/** 数据类型 */
	private String dataType;
	/** 表单标题 */
	private String fieldTitle;
	/** 数据长度 */
	private Integer dataLength;
	/** 显示排序 */
	private String fieldSort;
	/** 是否必填，0否，1是 */
	private String isRequire;
	/** 表单注释 */
	private String fieldComment;
	/** 表单类型 */
	private String fieldType;
	/** 表单属性 */
	private String fieldAttr;
	/** 是否关联字段，0否，1是 */
	private String isRelevance;
	/** 关联字段 */
	private String fieldRelevance;
	/** 日期关联字段 */
	private String dateRelevance;
	/** 时间关联字段 */
	private String timeRelevance;
	/** 是否显示，0隐藏，1显示 */
	private String isShow;
	/** 是否显示地图，0隐藏，1显示 */
	private String isMap;
	/** 是否可以删除，0否，1是 */
	private String isDelete;
	/** 是否在sp_shops表，0不是，1是 */
	private String isShopsTable;


	public void setMid(String mid) 
	{
		this.mid = mid;
	}

	public String getMid() 
	{
		return mid;
	}
	public void setFlowId(String flowId) 
	{
		this.flowId = flowId;
	}

	public String getFlowId() 
	{
		return flowId;
	}
	public void setFieldName(String fieldName) 
	{
		this.fieldName = fieldName;
	}

	public String getFieldName() 
	{
		return fieldName;
	}
	public void setDataType(String dataType) 
	{
		this.dataType = dataType;
	}

	public String getDataType() 
	{
		return dataType;
	}
	public void setFieldTitle(String fieldTitle) 
	{
		this.fieldTitle = fieldTitle;
	}

	public String getFieldTitle() 
	{
		return fieldTitle;
	}
	public void setDataLength(Integer dataLength) 
	{
		this.dataLength = dataLength;
	}

	public Integer getDataLength() 
	{
		return dataLength;
	}
	public void setFieldSort(String fieldSort) 
	{
		this.fieldSort = fieldSort;
	}

	public String getFieldSort() 
	{
		return fieldSort;
	}
	public void setIsRequire(String isRequire) 
	{
		this.isRequire = isRequire;
	}

	public String getIsRequire() 
	{
		return isRequire;
	}
	public void setFieldComment(String fieldComment) 
	{
		this.fieldComment = fieldComment;
	}

	public String getFieldComment() 
	{
		return fieldComment;
	}
	public void setFieldType(String fieldType) 
	{
		this.fieldType = fieldType;
	}

	public String getFieldType() 
	{
		return fieldType;
	}
	public void setFieldAttr(String fieldAttr) 
	{
		this.fieldAttr = fieldAttr;
	}

	public String getFieldAttr() 
	{
		return fieldAttr;
	}
	public void setIsRelevance(String isRelevance) 
	{
		this.isRelevance = isRelevance;
	}

	public String getIsRelevance() 
	{
		return isRelevance;
	}
	public void setFieldRelevance(String fieldRelevance) 
	{
		this.fieldRelevance = fieldRelevance;
	}

	public String getFieldRelevance() 
	{
		return fieldRelevance;
	}
	public void setDateRelevance(String dateRelevance) 
	{
		this.dateRelevance = dateRelevance;
	}

	public String getDateRelevance() 
	{
		return dateRelevance;
	}
	public void setTimeRelevance(String timeRelevance) 
	{
		this.timeRelevance = timeRelevance;
	}

	public String getTimeRelevance() 
	{
		return timeRelevance;
	}
	public void setIsShow(String isShow) 
	{
		this.isShow = isShow;
	}

	public String getIsShow() 
	{
		return isShow;
	}
	public void setIsMap(String isMap) 
	{
		this.isMap = isMap;
	}

	public String getIsMap() 
	{
		return isMap;
	}
	public void setIsDelete(String isDelete) 
	{
		this.isDelete = isDelete;
	}

	public String getIsDelete() 
	{
		return isDelete;
	}
	public void setIsShopsTable(String isShopsTable) 
	{
		this.isShopsTable = isShopsTable;
	}

	public String getIsShopsTable() 
	{
		return isShopsTable;
	}
	

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("mid", getMid())
            .append("flowId", getFlowId())
            .append("fieldName", getFieldName())
            .append("dataType", getDataType())
            .append("fieldTitle", getFieldTitle())
            .append("dataLength", getDataLength())
            .append("fieldSort", getFieldSort())
            .append("isRequire", getIsRequire())
            .append("fieldComment", getFieldComment())
            .append("fieldType", getFieldType())
            .append("fieldAttr", getFieldAttr())
            .append("isRelevance", getIsRelevance())
            .append("fieldRelevance", getFieldRelevance())
            .append("dateRelevance", getDateRelevance())
            .append("timeRelevance", getTimeRelevance())
            .append("isShow", getIsShow())
            .append("isMap", getIsMap())
            .append("isDelete", getIsDelete())
            .append("isShopsTable", getIsShopsTable())
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
