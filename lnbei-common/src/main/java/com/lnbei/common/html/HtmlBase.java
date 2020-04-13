package com.lnbei.common.html;

import java.util.HashMap;
import java.util.Map;

public abstract class HtmlBase {


	/**
	 * 标签名称
	 */
	protected String labelName;
	
	/**
	 * input标签Name属性
	 */
	protected String inputName;
	
	/**
	 * input标签默认值
	 */
	protected String defaultValue;
	
	/**
	 * input 标签类型
	 */
	protected String inputType;
	
	/**
	 * input 是否必填
	 */
	protected boolean isRequire;
	/**
	 * 是否必填标志
	 */
	protected final String labelSpan="<span style='color:red'>*</span>";
	
	/**
	 * input 标签属性列表
	 */
	protected Map<String, String> attrMap;
	/**
	 * 必填标志
	 */
	protected String require= "require";
	
	/**
	 * input标签的ID
	 */
	protected String inputId;
	
	protected String inputClass;
	/**
	 * 外围html代码
	 */
	protected FormHtml formHtml;
	/**
	 * 值
	 */
	protected String objecString;
	

	public String getObjecString() {
		return objecString;
	}
	public void setObjecString(String objecString) {
		this.objecString = objecString;
	}
	public FormHtml getFormHtml() {
		return formHtml;
	}
	public void setFormHtml(FormHtml formHtml) {
		this.formHtml = formHtml;
	}
	public String getInputId() {
		return inputId;
	}
	public void setInputId(String inputId) {
		this.inputId = inputId;
	}
	public String getInputClass() {
		return inputClass;
	}
	public void setInputClass(String inputClass) {
		this.inputClass = inputClass;
	}
	public String getLabelName() {
		return labelName;
	}
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	public String getInputName() {
		return inputName;
	}
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public String getInputType() {
		return inputType;
	}
	public void setInputType(String inputType) {
		this.inputType = inputType;
	}
	public boolean isRequire() {
		return isRequire;
	}
	public void setRequire(boolean isRequire) {
		this.isRequire = isRequire;
	}
	public Map<String, String> getAttrMap() {
		return attrMap;
	}
	public void setAttrMap(Map<String, String> attrMap) {
		this.attrMap = attrMap;
	}
	public String getRequire() {
		return require;
	}
	public void setRequire(String require) {
		this.require = require;
	}
	public String getLabelSpan() {
		return labelSpan;
	}
	/**
	 * 生成html
	 * @return
	 */
	public abstract String toHtml() ;
	/**
	 * 生成laber
	 * @return
	 */
	public abstract String toHtmlLaber() ;
	/**
	 * 生成input
	 * @return
	 */
	public abstract String toHtmlInput() ;
	
	public HtmlBase() {
		
		this.attrMap = new HashMap<String, String>();
		
		this.isRequire = true;
		
		this.defaultValue = "";
		this.labelName = "";
		this.inputName = "";
		this.inputType="text";
		
		this.inputClass = "";
		
		this.inputId = "";
		
	}
}
