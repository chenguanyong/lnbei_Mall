package com.lnbei.common.html.widget;

import com.lnbei.common.core.text.Convert;
import com.lnbei.common.html.HtmlBase;
import com.lnbei.common.utils.StringUtils;

public class InputCheckboxWidget extends HtmlBase {

	@Override
	public String toHtml() {
		// TODO Auto-generated method stub
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

	/**
	 * name:"",value:"";
	 */
	@Override
	public String toHtmlInput() {
		// TODO Auto-generated method stub
		String inputCheckString = "";
		String[] mStrings = Convert.toStrArray(";", this.objecString);
		int a = 0;
		for (String string : mStrings) {

			String[] tempStrings = Convert.toStrArray(",", string);
			String nameString = "";
			String valueString = "";
			for (int i = 0; i < tempStrings.length; i++) {
				String[] mmString = Convert.toStrArray(":", tempStrings[i]);
				if (i == 0) {
					nameString = mmString[1];
				} else if (i == 0) {
					valueString = mmString[1];
				}
			}

			String input = " ";
			if (StringUtils.isNotEmpty(this.inputId)) {
				input += "id=\"" + this.inputId + "_" + a + "\" ";
			}
			if (StringUtils.isNotEmpty(this.inputClass)) {
				input += "class=\"" + this.inputClass + "_" + a + "\" ";
			}

			if (valueString == this.defaultValue) {
				inputCheckString += nameString + "<input type='checkbox' " + input + " name=\"" + this.inputName + "_"
						+ a + "\"" + "value=" + "'" + valueString + "'" + " checked=\"checked\"  />";
			} else {
				inputCheckString += nameString + "<input type='checkbox' " + input + " name=\"" + this.inputName + "_"
						+ a + "\"" + "value=" + "'" + valueString + "'" + "/>";
			}
			a++;
		}

		return inputCheckString;
	}

	public InputCheckboxWidget() {

		super();
	}
}
