package com.kingdee.eas.custom.erp2tax.functions;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 電子發票到處接口
 * @author Administrator
 *
 */
public class ElcExportMainBean implements Serializable{
	private static final long serialVersionUID = 8468061002999370712L;
	
	private String serialNo;//操作流水號
	private String postTime;//請求發送時間 yyyy-MM-dd HH:mm:ss
	private ElcExportOrderBean order;//訂單信息
	private ElcExportInvoiceBean invoice;//發票信息
	private ElcExportNoticeBean notices;//通知
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getPostTime() {
		return postTime;
	}
	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}
	public ElcExportOrderBean getOrder() {
		return order;
	}
	public void setOrder(ElcExportOrderBean order) {
		this.order = order;
	}
	public ElcExportInvoiceBean getInvoice() {
		return invoice;
	}
	public void setInvoice(ElcExportInvoiceBean invoice) {
		this.invoice = invoice;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public ElcExportNoticeBean getNotices() {
		return notices;
	}
	public void setNotices(ElcExportNoticeBean notices) {
		this.notices = notices;
	}
	
}
