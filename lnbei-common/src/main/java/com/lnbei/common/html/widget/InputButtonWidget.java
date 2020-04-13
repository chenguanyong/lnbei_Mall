package com.lnbei.common.html.widget;

import com.lnbei.common.html.HtmlBase;

public class InputButtonWidget extends HtmlBase {

	@Override
	public String toHtml() {
		// TODO Auto-generated method stub
		return this.formHtml.toLabelHtml(toHtmlLaber()) + this.formHtml.toInputContent(toHtmlInput());
	}

	@Override
	public String toHtmlLaber() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String toHtmlInput() {
		// TODO Auto-generated method stub
		return "<button type=\"button\" >" + this.labelName + "</button>";
	}
	public InputButtonWidget() {
		
		super();
	}
}
