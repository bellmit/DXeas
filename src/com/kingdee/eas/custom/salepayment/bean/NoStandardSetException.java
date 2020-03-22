package com.kingdee.eas.custom.salepayment.bean;


/**
 * �Ҳ�����Ʒ��׼�ɱ� 
 * 
 * @author USER
 *
 */
public class NoStandardSetException extends SalePaymentException {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7672585135250556443L;
//	private String companyName;
	private int year;
	private String productNames;
	
	public NoStandardSetException(String materialName,int currYear){
		productNames = materialName;
		year = currYear;
	}
	
	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("�ڶ�Ӧ��˾�Ҳ������õ�");
		sb.append(year);
		sb.append("���������ϵı�׼�ɱ���");
		sb.append(productNames);
		return sb.toString();
	}

	public String getProductNames() {
		return productNames;
	}

	public void setProductNames(String productNames) {
		this.productNames = productNames;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
}
