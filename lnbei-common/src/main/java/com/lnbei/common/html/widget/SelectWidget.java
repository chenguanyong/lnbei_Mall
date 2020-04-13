package com.lnbei.common.html.widget;

import java.util.Map;

import com.lnbei.common.html.HtmlBase;
import com.lnbei.common.utils.StringUtils;

public class SelectWidget extends HtmlBase {

	protected Map<String, String> optionData;

	protected String value;

	@Override
	public String toHtml() {
		return this.formHtml.toLabelHtml(toHtmlLaber()) + this.formHtml.toInputContent(toHtmlInput());
	}

	@Override
	public String toHtmlLaber() {
		// TODO Auto-generated method stub
		String laber = "";
		laber = "<laber >";
		if (this.isRequire) {
			laber += this.labelSpan;
		}
		laber += this.labelName;
		laber += "</laber>";
		return laber;
	}

	@Override
	public String toHtmlInput() {
		// TODO Auto-generated method stub
		String input = "<select ";

		if (StringUtils.isNotEmpty(this.inputId)) {
			input += "id=\"" + this.inputId + "\" ";
		}
		if (StringUtils.isNotEmpty(this.inputClass)) {
			input += "class=\"" + this.inputClass + "\" ";
		}
		if (StringUtils.isNotEmpty(this.inputName)) {
			input += "name=\"" + this.inputName + "\" ";
		}
		input += toOptionHtml();
		input += "</select>";
		return input;
	}

	private String toOptionHtml() {
		String optionString = "";
		for (Map.Entry<String, String> entry : optionData.entrySet()) {
			String mapKey = entry.getKey();
			String mapValue = entry.getValue();
			System.out.println(mapKey + ":" + mapValue);
			if (this.value.equals(mapKey)) {
				optionString += "<option value=\"" + mapValue + "\" selected >" + mapKey + "</option>";
			} else {
				optionString += "<option value=\"" + mapValue + "\">" + mapKey + "</option>";
			}
		}
		return optionString;
	}

	public SelectWidget(Map<String, String> mmMap) {
		super();
		this.optionData = mmMap;
	}

}
