package com.lnbei.common.html;

import com.lnbei.common.utils.StringUtils;

public class FormHtml {

	private String labelHtml;

	private String inputContent;

	private String colspan;

	public FormHtml(String colspan) {

		this.colspan = colspan;
	}

	public String getLabelHtml() {
		return labelHtml;
	}

	public void setLabelHtml(String labelHtml) {
		this.labelHtml = labelHtml;
	}

	public String getInputContent() {
		return inputContent;
	}

	public void setInputContent(String inputContent) {
		this.inputContent = inputContent;
	}

	public String getColspan() {
		return colspan;
	}

	public void setColspan(String colspan) {
		this.colspan = colspan;
	}

	/**
	 * 获取标签名
	 * 
	 * @return
	 */
	public String toLabelHtml(String str) {
		String labelName = "<td class=\"label-width\">" + str + "</td>";
		this.labelHtml = labelName;
		return labelName;
	}

	/**
	 * 获取input内容
	 * 
	 * @return
	 */
	public String toInputContent(String str) {
		String colspanString = "";
		if (StringUtils.isEmpty(str)) {
			colspanString = "colspan='" + this.colspan + "'";
		}
		String inputName = "<td " + colspanString
				+ " class=\"content-width\"><div class=\"form-group\"><div class=\"col-sm-12\">" + str
				+ "</div></div></td>";
		this.inputContent = inputName;
		return inputName;
	}
}
