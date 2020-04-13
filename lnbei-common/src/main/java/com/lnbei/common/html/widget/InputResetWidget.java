package com.lnbei.common.html.widget;

import com.lnbei.common.html.HtmlBase;
import com.lnbei.common.utils.StringUtils;

public class InputResetWidget extends HtmlBase {

	@Override
	public String toHtml() {
		// TODO Auto-generated method stub
		return this.formHtml.toLabelHtml(toHtmlLaber()) + this.formHtml.toInputContent(toHtmlInput());
	}

	@Override
	public String toHtmlLaber() {

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
		String input = "";
		if (StringUtils.isNotEmpty(this.inputId)) {
			input += "id=\"" + this.inputId + "\" ";
		}
		if (StringUtils.isNotEmpty(this.inputClass)) {
			input += "class=\"" + this.inputClass + "\" ";
		}
		if (StringUtils.isNotEmpty(this.inputName)) {
			input += "name=\"" + this.inputName + "\" ";
		}
		return "<input " + input + " type='reset' />";
	}

	public InputResetWidget() {

		super();
	}
}
