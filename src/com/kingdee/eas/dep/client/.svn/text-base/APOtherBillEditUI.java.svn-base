package com.kingdee.eas.dep.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.fi.ap.OtherBillInfo;
import com.kingdee.eas.fi.ap.client.OtherBillEditUI;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 应付单编辑界面dep
 * @author dai_andong
 *
 */
public class APOtherBillEditUI {
	protected OtherBillEditUI ui;
	// 界面 对象
	protected OtherBillInfo editData;
	/**
	 * onload后 设置界面 空间 内容；添加监听
	 * @param param
	 */
	public void afterOnload(final UIParam param){
		ui = (OtherBillEditUI) param.getUI();
		editData = (OtherBillInfo) ui.getEditData();
		
		param.getKDMenuItem("btnUpdateTaxInfo").addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				exeUupdateTaxInfo(param.getKDTable("kdtEntry"));
			}});
		
	}
	
	private void exeUupdateTaxInfo(KDTable kdtEntry) {
		String entryID,srcBillID,srcBillEntryID;
		InvoceBean result;
		for(int rowIndex=0;rowIndex<kdtEntry.getRowCount();rowIndex++) {
			if(kdtEntry.getCell(rowIndex,"entryId").getValue()==null) {
				continue;
			}
			entryID=kdtEntry.getCell(rowIndex,"entryId").getValue().toString();
			for(int index=0;index<editData.getEntry().size();index++) {
				if(entryID.equals(editData.getEntry().get(index).getId().toString())) {
					srcBillID=editData.getEntry().get(index).getCoreBillId();
					srcBillEntryID=editData.getEntry().get(index).getCoreBillEntryId();
					result=getInvoiceInfo(srcBillID, srcBillEntryID);
					kdtEntry.getCell(rowIndex, "invoiceDateStr").setValue(result.getInvoiceDateStr());
					kdtEntry.getCell(rowIndex, "invoiceID").setValue(result.getInvoiceID());
					kdtEntry.getCell(rowIndex, "invoiceNum").setValue(result.getInvoiceNum());
					kdtEntry.getCell(rowIndex, "invoiceAmount").setValue(result.getInvoiceAmout());
					kdtEntry.getCell(rowIndex, "invoiceAllAmount").setValue(result.getInvoiceAllAmout());
					kdtEntry.getCell(rowIndex, "checkPerson").setValue(result.getCheckPerson());
					break;
				}
			}
		}
	}
	
	private class InvoceBean {
		private String invoiceDateStr;
		private String invoiceID;
		private String invoiceNum;
		private String invoiceAmout;
		private BigDecimal invoiceAllAmout;
		private String checkPerson;
		public String getInvoiceDateStr() {
			return invoiceDateStr;
		}
		public void setInvoiceDateStr(String invoiceDateStr) {
			this.invoiceDateStr = invoiceDateStr;
		}
		public String getInvoiceID() {
			return invoiceID;
		}
		public void setInvoiceID(String invoiceID) {
			this.invoiceID = invoiceID;
		}
		public String getInvoiceNum() {
			return invoiceNum;
		}
		public void setInvoiceNum(String invoiceNum) {
			this.invoiceNum = invoiceNum;
		}
		public String getInvoiceAmout() {
			return invoiceAmout;
		}
		public void setInvoiceAmout(String invoiceAmout) {
			this.invoiceAmout = invoiceAmout;
		}
		public BigDecimal getInvoiceAllAmout() {
			return invoiceAllAmout;
		}
		public void setInvoiceAllAmout(BigDecimal invoiceAllAmout) {
			this.invoiceAllAmout = invoiceAllAmout;
		}
		public String getCheckPerson() {
			return checkPerson;
		}
		public void setCheckPerson(String checkPerson) {
			this.checkPerson = checkPerson;
		}
		
	}
	
	private InvoceBean getInvoiceInfo(String billID,String entryID) {
		InvoceBean bean=new InvoceBean();
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select cfinvoiceDateStr,cfinvoiceID,cfinvoiceNum,cfinvoiceAmount,cfinvoiceAllAmount,cfcheckPerson")
			.append(" from T_SM_PurOrderEntry")
			.append(" where fparentid='").append(billID).append("'")
			.append(" and fid='").append(entryID).append("'")
			;
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.next()) {
				bean.setInvoiceDateStr(rs.getString("cfinvoiceDateStr"));
				bean.setInvoiceID(rs.getString("cfinvoiceID"));
				bean.setInvoiceNum(rs.getString("cfinvoiceNum"));
				bean.setInvoiceAmout(rs.getString("cfinvoiceAmount"));
				bean.setInvoiceAllAmout(rs.getBigDecimal("cfinvoiceAllAmount"));
				bean.setCheckPerson(rs.getString("cfcheckPerson"));
			}
			rs.close();
		}catch(Exception err) {
			err.printStackTrace();
		}
		
		return bean;
	}
}
