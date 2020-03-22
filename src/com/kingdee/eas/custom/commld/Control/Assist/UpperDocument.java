package com.kingdee.eas.custom.commld.Control.Assist;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class UpperDocument extends PlainDocument {
	private static final long serialVersionUID = 1L;

	
	//�����ַ�ת���ɴ�д
	@Override
	public void insertString(int offs, String str, AttributeSet a)
	throws BadLocationException {
		// TODO Auto-generated method stub
		if (str == null)
			return;
		char[] upper = str.toCharArray();
		for (int i = 0; i < upper.length; i++){
			upper[i] = Character.toUpperCase(upper[i]);
		}
		super.insertString(offs, new String(upper), a);
	}

}
