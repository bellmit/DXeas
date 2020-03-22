package com.kingdee.eas.custom.commld;


public class ExceptionUtils {

	/**
	 * 获取异常的位置1
	 * @param e
	 * @return
	 */
	public static String getExceptionLocation(Exception e) {
		// TODO Auto-generated method stub
		return e.getStackTrace()[0].getFileName()+"\n"+e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getMethodName()+"\n"+e.getStackTrace()[0].getLineNumber();
	}
	/**
	 * 获取异常的位置 仅仅包含类名和行号
	 * @param e
	 * @return
	 */
	public static String getExceptionLocationSimple(Exception e) {
		// TODO Auto-generated method stub
		return e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber();
	}

	/**
	 * 获取抛出的异常文字
	 * @param e
	 * @return
	 */
	public static String getExceptionStatement(Exception e) {
		// TODO Auto-generated method stub
		return e.getCause()==null?e.getMessage():e.getCause().getMessage();
	}

}
