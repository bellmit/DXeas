package com.kingdee.eas.custom.commld.Control.Assist;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class RegexDocument extends PlainDocument {

	/**
	 * 限制文本框输入内容为  正则表达式
	 */
	private static final long serialVersionUID = 1L;
	private String regex = null;

	public RegexDocument()
	{
		super();
	}

	public RegexDocument(String regex)
	{
		this();
		this.regex = regex;
	}
	@Override
	public void insertString(int offs, String str, AttributeSet a)
	throws BadLocationException {
		if (str == null)
			return;
		if (regex != null){
			if (!new StringBuilder(getText(0, getLength())).insert(offs, str).toString().matches(regex)){
				return;
			}
			super.insertString(offs, str, a);
		}
		else
			super.insertString(offs, str, a);
	}
}
