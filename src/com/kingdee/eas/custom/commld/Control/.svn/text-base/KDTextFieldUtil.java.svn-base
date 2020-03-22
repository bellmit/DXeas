package com.kingdee.eas.custom.commld.Control;

import com.kingdee.bos.ctrl.swing.KDTextField;
import com.kingdee.eas.custom.commld.Control.Assist.LowerDocument;
import com.kingdee.eas.custom.commld.Control.Assist.RegexDocument;
import com.kingdee.eas.custom.commld.Control.Assist.UpperDocument;

public class KDTextFieldUtil {

	private static int StringUpper=1;
	private static int StringLower=2;
	private static int StringRegex=3;
	/**
	 * 设置KDTextField输入格式
	 * @param textField1
	 * @param regex
	 */
	public static void setInputModel(KDTextField textField1, int model,String regex) {
		// TODO Auto-generated method stub
		if(1==StringUpper)
			textField1.setDocument(new UpperDocument());
		if(2==StringLower)
			textField1.setDocument(new LowerDocument());
		if(3==StringRegex)
			textField1.setDocument(new RegexDocument(regex));
	}

}
