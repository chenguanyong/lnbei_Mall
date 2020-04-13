package com.lnbei.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lnbei.common.annotation.Excel;
import com.lnbei.common.core.domain.BaseEntity;
import com.lnbei.common.html.HtmlBase;
import com.lnbei.common.html.widget.InputCheckboxWidget;
import com.lnbei.common.html.widget.InputFileWidget;
import com.lnbei.common.html.widget.InputHiddenWidget;
import com.lnbei.common.html.widget.InputImgWidget;
import com.lnbei.common.html.widget.InputPasswordWidget;
import com.lnbei.common.html.widget.InputRadioWidget;
import com.lnbei.common.html.widget.InputResetWidget;
import com.lnbei.common.html.widget.InputSubmitWidget;
import com.lnbei.common.html.widget.InputTextWidget;

/**
 * 参数配置表 sys_config
 * 
 * @author lnbei
 */
public class SysConfig extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 参数主键 */
	@Excel(name = "参数主键")
	private String configId;

	/** 参数名称 */
	@Excel(name = "参数名称")
	private String configName;

	/** 参数键名 */
	@Excel(name = "参数键名")
	private String configKey;

	/** 参数键值 */
	@Excel(name = "参数键值")
	private String configValue;

	/** 系统内置（Y是 N否） */
	@Excel(name = "系统内置", readConverterExp = "Y=是,N=否")
	private String configType;
	/**
	 * 配置树Id
	 */
	private String ctreeId;

	private Integer configVtype;

	private String status;

	private Integer qxtype;

	private Integer sort;

	private String dictType;
	private String configObj;
	/**
	 * html内容
	 */
	private String eleHtml;

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getConfigVtype() {
		return configVtype;
	}

	public void setConfigVtype(Integer configVtype) {
		this.configVtype = configVtype;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getQxtype() {
		return qxtype;
	}

	public void setQxtype(Integer qxtype) {
		this.qxtype = qxtype;
	}

	public String getCtreeId() {
		return this.ctreeId;
	}

	public void setCtreeId(String ctreeId) {
		this.ctreeId = ctreeId;
	}

	public String getConfigId() {
		return configId;
	}

	public void setConfigId(String configId) {
		this.configId = configId;
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getConfigKey() {
		return configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public String getConfigType() {
		return configType;
	}

	public void setConfigType(String configType) {
		this.configType = configType;
	}

	public String getEleHtml() {
		return eleHtml;
	}

	public void setEleHtml(String eleHtml) {
		this.eleHtml = eleHtml;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("configId", getConfigId())
				.append("configName", getConfigName()).append("configKey", getConfigKey())
				.append("configValue", getConfigValue()).append("configType", getConfigType())
				.append("createBy", getCreateBy()).append("createTime", getCreateTime())
				.append("updateBy", getUpdateBy()).append("updateTime", getUpdateTime()).append("remark", getRemark())
				.toString();
	}

	/**
	 * 转换成Html
	 * 
	 * @return
	 */
	public void toHtml() {

		switch (this.configVtype) {
		case 0:
			InputCheckboxWidget mCheckboxWidget = new InputCheckboxWidget();
			initHtmlBase(mCheckboxWidget);
			this.eleHtml = mCheckboxWidget.toHtml();
			break;
		case 1:
			InputFileWidget mFileWidget = new InputFileWidget();
			initHtmlBase(mFileWidget);
			this.eleHtml = mFileWidget.toHtml();
			break;
		case 2:// hidden
			InputHiddenWidget mFileWidgets = new InputHiddenWidget();
			initHtmlBase(mFileWidgets);
			this.eleHtml = mFileWidgets.toHtml();
			break;
		case 3:// image
			InputImgWidget mImgWidget = new InputImgWidget();
			initHtmlBase(mImgWidget);
			this.eleHtml = mImgWidget.toHtml();
			break;
		case 4:// password
			InputPasswordWidget mInputPasswordWidget = new InputPasswordWidget();
			initHtmlBase(mInputPasswordWidget);
			this.eleHtml = mInputPasswordWidget.toHtml();
			break;
		case 5:// radio
			InputRadioWidget inputRadioWidget = new InputRadioWidget();
			initHtmlBase(inputRadioWidget);
			this.eleHtml = inputRadioWidget.toHtml();
			break;
		case 6:// reset
			InputResetWidget mInputResetWidget = new InputResetWidget();
			initHtmlBase(mInputResetWidget);
			this.eleHtml = mInputResetWidget.toHtml();
			break;
		case 7:// submit
			InputSubmitWidget mInputSubmitWidget = new InputSubmitWidget();
			initHtmlBase(mInputSubmitWidget);
			this.eleHtml = mInputSubmitWidget.toHtml();
			break;
		case 8:// text
			InputTextWidget mInputTextWidget = new InputTextWidget();
			initHtmlBase(mInputTextWidget);
			this.eleHtml = mInputTextWidget.toHtml();
			break;
		}

	}
	
	private void initHtmlBase(HtmlBase mBase) {
		mBase.setInputClass("");
		mBase.setInputName(this.configKey);
		mBase.setDefaultValue(this.configValue);
		mBase.setLabelName(this.configName);
		mBase.setObjecString(this.configObj);
	}
}
