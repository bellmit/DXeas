package com.kingdee.eas.dep.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.eas.base.permission.PermissionFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.org.PurchaseOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.fi.ap.OtherBillInfo;
import com.kingdee.eas.fi.ap.OtherBillentryInfo;
import com.kingdee.eas.scm.sm.pur.PurOrder;
import com.kingdee.eas.scm.sm.pur.PurOrderEntry;
import com.kingdee.eas.scm.sm.pur.PurOrderEntryInfo;
import com.kingdee.eas.scm.sm.pur.PurOrderInfo;
import com.kingdee.eas.scm.sm.pur.client.PurOrderEditUI;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.CommSqlFacadeFactory;
import com.kingdee.eas.wlhlcomm.client.UITools;
import com.kingdee.jdbc.rowset.IRowSet;
/**
 * �ɹ�����dep
 * @author dai_andong
 *
 */
public class PurOrderEditDep {
	private KDWorkButton btnUpdateTaxInfo;//���¿�Ʊ��Ϣ
	protected PurOrderEditUI ui;
	// ���� ����
	protected PurOrderInfo editData;
	protected KDTable kdtEntry;
	
	/**
	 * onload�� ���ý��� �ռ� ���ݣ���Ӽ���
	 * @param param
	 */
	public void afterOnload(final UIParam param){
		ui = (PurOrderEditUI) param.getUI();
		editData = (PurOrderInfo) ui.getEditData();
		kdtEntry=param.getKDTable("kdtEntries");

//		param.getKDMenuItem("mBtnUpdateTaxInfo").addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				exeUpdateTaxInfo();
//			}});
//		
//		param.getKDMenuItem("mBtnCheck").addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				exeCheck(true);
//			}});
//		
//		param.getKDMenuItem("mBtnUnCheck").addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				exeCheck(false);
//			}});
		param.getKDBizPromptBox("prmtsupplier1").addDataChangeListener(new DataChangeListener(){

			@Override
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				try {
					updateSupplier(param);
				} catch (SQLException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		param.getKDBizPromptBox("prmtsupplier2").addDataChangeListener(new DataChangeListener(){


			@Override
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				try {
					updateSuppliers(param);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			
			
		});
	}
	/**
	 * ���¿�Ʊ��Ϣ
	 */
	private void exeCheck(Boolean isCheck){
		try {
			String person="",msg="������",perKey="purOrderUnCheckIndependence";
			if(isCheck) {
				person=SysContext.getSysContext().getCurrentUserInfo().getName();
				msg="����";
				perKey="purOrderCheckIndependence";
			}
			try {
				//���Ȩ�� ����
				ObjectUuidPK userID = new ObjectUuidPK(SysContext.getSysContext().getCurrentUserInfo().getId());
				ObjectUuidPK cuID = new ObjectUuidPK(SysContext.getSysContext().getCurrentCtrlUnit().getId());
				PermissionFactory.getRemoteInstance().checkFunctionPermission(userID, cuID,perKey);
			}catch(Exception err) {
				//û��Ȩ��
				MsgBox.showWarning("��û��ִ�иù��ܵ�Ȩ�ޣ�");
				return;
			}
			IRow row = KDTableUtil.getSelectedRow(kdtEntry);
			if(row==null||row.getRowIndex()<0) {
				MsgBox.showWarning("��ѡ���¼�У�");
				return;
			}
			
			//���·�¼����
			row.getCell("checkPerson").setValue(person);
				
			if(row.getCell("id").getValue()!=null) {
				String entryID=row.getCell("id").getValue().toString();
				for(int index=0;index<editData.getEntries().size();index++) {
					if(editData.getEntries().get(index).getId().toString().equals(entryID)) {
//						entryID=editData.getEntries().get(index).getId().toString();
					 	
						editData.getEntries().get(index).setString("checkPerson",person);
						break;
					}
				}
				if(StringUtils.isEmpty(entryID)) {
					return;
				}
				//���²ɹ�����
				StringBuffer sql=new StringBuffer();
				sql.append(" update T_SM_PurOrderEntry set CFCheckPerson='").append(person).append("'")
				.append(" where fid='").append(entryID).append("'")
				.append(" and fparentid='").append(editData.getId().toString()).append("'");
//				//����Ӧ����
				sql.append(" ;update T_AP_OtherBillEntry set CFCheckPerson='").append(person).append("'")
				.append(" where FCoreBillEntryId='").append(entryID).append("'")
				.append(" and FCoreBillId='").append(editData.getId().toString()).append("'");
				CommSqlFacadeFactory.getRemoteInstance().execute(sql.toString());
				
			}
	    	MsgBox.showInfo(msg+"��ɣ�");
		}catch(Exception err) {
			
		}
	}
	/**
	 * ���¿�Ʊ��Ϣ
	 */
	private void exeUpdateTaxInfo(){
		try {
			
			try {
				//���Ȩ�� ���·�Ʊ��Ϣ
				ObjectUuidPK userID = new ObjectUuidPK(SysContext.getSysContext().getCurrentUserInfo().getId());
				ObjectUuidPK cuID = new ObjectUuidPK(SysContext.getSysContext().getCurrentCtrlUnit().getId());
				PermissionFactory.getRemoteInstance().checkFunctionPermission(userID, cuID, "purOrderUpdateTaxIndependence");
			}catch(Exception err) {
				//û��Ȩ��
				MsgBox.showWarning("��û��ִ�иù��ܵ�Ȩ�ޣ�");
				return;
			}
			
			IRow row = KDTableUtil.getSelectedRow(kdtEntry);
			if(row==null||row.getRowIndex()<0) {
				MsgBox.showWarning("��ѡ���¼�У�");
				return;
			}
			
			UIContext uiContext = new UIContext(this);
	    	IUIWindow uiWindow = null ;
	    	// UIFactoryName.MODEL Ϊ����ģʽ
	    	uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.custom.independence.client.PurOrderEditTaxUpdateUI", uiContext, null,OprtState.VIEW);
	    	//��ʼչ��UI
	    	uiWindow.show();
	    	
	    	if(!uiWindow.getUIObject().getUIContext().containsKey("isUpdate")) {
	    		return;
	    	}
	    	
	    	boolean isUpdate=(Boolean) uiWindow.getUIObject().getUIContext().get("isUpdate");
	    	
	    	String txtDateStr=(String) uiWindow.getUIObject().getUIContext().get("dateStr");
	    	String taxId=(String) uiWindow.getUIObject().getUIContext().get("id");
	    	String taxNumber=(String) uiWindow.getUIObject().getUIContext().get("number");
	    	String taxAmount=(String) uiWindow.getUIObject().getUIContext().get("amount");
	    	String person=(String) uiWindow.getUIObject().getUIContext().get("person");
	    	
	    	
	    	//�Ǹ��£�����
	    	if(!isUpdate) {
	    		String tmpStr;
	    		tmpStr=(String) row.getCell("invoiceDateStr").getValue();
	    		if(StringUtils.isNotEmpty(tmpStr)) {
	    			if(!tmpStr.endsWith(";")) {
	    				tmpStr+=";";
	    			}
    				txtDateStr=tmpStr+txtDateStr;
	    		}
	    		tmpStr=(String) row.getCell("invoiceID").getValue();
	    		if(StringUtils.isNotEmpty(tmpStr)) {
	    			if(!tmpStr.endsWith(";")) {
	    				tmpStr+=";";
	    			}
	    				taxId=tmpStr+taxId;
	    		}
	    		tmpStr=(String) row.getCell("invoiceNum").getValue();
	    		if(StringUtils.isNotEmpty(tmpStr)) {
	    			if(!tmpStr.endsWith(";")) {
	    				tmpStr+=";";
	    			}
	    				taxNumber=tmpStr+taxNumber;
	    		}
	    		tmpStr=(String) row.getCell("invoiceAmount").getValue();
	    		if(StringUtils.isNotEmpty(tmpStr)) {
	    			if(!tmpStr.endsWith(";")) {
	    				tmpStr+=";";
	    			}
	    				taxAmount=tmpStr+taxAmount;
	    		}
	    		tmpStr=(String) row.getCell("invoicePerson").getValue();
	    		if(StringUtils.isNotEmpty(tmpStr)) {
	    			if(!tmpStr.endsWith(";")) {
	    				tmpStr+=";";
	    			}
	    				person=tmpStr+person;
	    		}
	    	}

	    	BigDecimal allAmount=BigDecimal.ZERO;
	    	if(StringUtils.isNotEmpty(taxAmount)) {
		    	String[] aStr = taxAmount.split(";");
		    	for(int i=0;i<aStr.length;i++) {
		    		allAmount=allAmount.add(new BigDecimal(aStr[i]));
		    	}
	    	}
			//���·�¼����
			row.getCell("invoiceDateStr").setValue(txtDateStr);
			row.getCell("invoiceID").setValue(taxId);
			row.getCell("invoiceNum").setValue(taxNumber);
			row.getCell("invoiceAmount").setValue(taxAmount);
			row.getCell("invoiceAllAmount").setValue(allAmount);
			row.getCell("invoicePerson").setValue(person);
				
//			int seq= UIRuleUtil.getIntValue(row.getCell("seq").getValue());
//			//���>0,��¼�����Ѿ�����
//			if(seq>0) {
			if(row.getCell("id").getValue()!=null) {
				String entryID=row.getCell("id").getValue().toString();
				for(int index=0;index<editData.getEntries().size();index++) {
					if(editData.getEntries().get(index).getId().toString().equals(entryID)) {
//						entryID=editData.getEntries().get(index).getId().toString();
					 	
						editData.getEntries().get(index).setString("invoiceDateStr",txtDateStr);
						editData.getEntries().get(index).setString("invoiceID",taxId);
						editData.getEntries().get(index).setString("invoiceNum",taxNumber);
						editData.getEntries().get(index).setString("invoiceAmount",taxAmount);
						editData.getEntries().get(index).setBigDecimal("invoiceAllAmount",allAmount);
						editData.getEntries().get(index).setString("invoicePerson",person);
						break;
					}
				}
				if(StringUtils.isEmpty(entryID)) {
					return;
				}
				if(!ui.getOprtState().equals(OprtState.EDIT)&&!ui.getOprtState().equals(OprtState.ADDNEW)){
//					PurOrderFactory.getRemoteInstance().update(new ObjectUuidPK(editData.getId()), editData);
				}
				
				//���²ɹ�����
				StringBuffer sql=new StringBuffer();
				sql.append(" update T_SM_PurOrderEntry set CFInvoiceDateStr='").append(txtDateStr).append("'")
				.append(" ,CFInvoiceID='").append(taxId).append("'")
				.append(" ,CFInvoiceNum='").append(taxNumber).append("'")
				.append(" ,CFInvoiceAmount='").append(taxAmount).append("'")
				.append(" ,CFInvoiceAllAmount='").append(allAmount.toString()).append("'")
				.append(" ,CFInvoicePerson='").append(person).append("'")
				.append(" where fid='").append(entryID).append("'")
				.append(" and fparentid='").append(editData.getId().toString()).append("'");
//				CommSqlFacadeFactory.getRemoteInstance().execute(sql.toString());
//				
//				//����Ӧ����
//				sql=new StringBuffer();
				sql.append(" ;update T_AP_OtherBillEntry set CFInvoiceDateStr='").append(txtDateStr).append("'")
				.append(" ,CFInvoiceID='").append(taxId).append("'")
				.append(" ,CFInvoiceNum='").append(taxNumber).append("'")
				.append(" ,CFInvoiceAmount='").append(taxAmount).append("'")
				.append(" ,CFInvoiceAllAmount='").append(allAmount.toString()).append("'")
				.append(" ,CFInvoicePerson='").append(person).append("'")
				.append(" where FCoreBillEntryId='").append(entryID).append("'")
				.append(" and FCoreBillId='").append(editData.getId().toString()).append("'");
				CommSqlFacadeFactory.getRemoteInstance().execute(sql.toString());
				
//				ui.loadFields();
			}
	    	MsgBox.showInfo("��Ʊ��Ϣ������ɣ�");
	    	
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	
	/**
	 * ����ʱ����������
	 * @param param
	 */
	public void sumQty(final UIParam param){
		
		ui = (PurOrderEditUI) param.getUI();
		editData = (PurOrderInfo) ui.getEditData();
		BigDecimal sumQty = new BigDecimal("0");
		for(int i=0;i<editData.getEntries().size();i++){
			sumQty = sumQty.add(editData.getEntries().get(i).getQty());
		}
		String sql = "update T_SM_PurOrder set CFSumQty = "+sumQty+" where fnumber = '"+editData.getNumber()+"'";
		String sqls = "select cfisFreight,CFFreght,CFsupplier1ID,CFSendcardate from T_SM_PurOrder where fnumber = '"+editData.getNumber()+"'";		
		try {
			IRowSet rss = SQLExecutorFactory.getRemoteInstance(sqls.toString()).executeSQL();
			if(rss.next()){
				if(rss.getBoolean("cfisFreight")){
					if(StringUtils.isBlank(rss.getString("CFFreght"))||StringUtils.isBlank(rss.getString("CFsupplier1ID"))||StringUtils.isBlank(rss.getString("CFSendcardate"))){
						if(!StringUtils.isBlank(rss.getString("CFFreght"))&&new BigDecimal(rss.getString("CFFreght")).compareTo(BigDecimal.ZERO)<0){
							
						}
						MsgBox.showWarning("�����̳е��˷�ʱ���ɳ�ʱ����߳����̲���Ϊ��,�˷ѵ��۲���С��0��");
						SysUtil.abort(); 
					}
				}
			}	
			
				CommFacadeFactory.getRemoteInstance().excuteUpdateSql(sql);
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	
		
	}
	
	/**
	 * ����ʱ���������ϸ 
	 * @param param
	 */
	public void CheckCYS(final UIParam param){
		ui = (PurOrderEditUI) param.getUI();
		editData = (PurOrderInfo) ui.getEditData();
		String sqls = "select cfisFreight,CFFreght,CFsupplier1ID,CFSendcardate from T_SM_PurOrder where fnumber = '"+editData.getNumber()+"'";		
		BigDecimal sumQty = new BigDecimal("0");
		BigDecimal DetailQty = new BigDecimal("0");
		BigDecimal frightprice = editData.getBigDecimal("Freght");

		try {
		if(frightprice!=null){
			for(int i=0;i<editData.getEntries().size();i++){
				DetailQty = editData.getEntries().get(i).getQty().multiply(frightprice);
				DetailQty = DetailQty.divide(new BigDecimal("1000"), 2, BigDecimal.ROUND_HALF_UP);
				sumQty = sumQty.add(DetailQty);
				String sql = "update T_SM_PurOrderEntry set cffreightDetail = "+DetailQty+" where FID = '"+editData.getEntries().get(i).getId().toString()+"'";
				CommFacadeFactory.getRemoteInstance().excuteUpdateSql(sql);
				editData.getEntries().get(i).setBigDecimal("freightDetail", DetailQty);		
			
				param.getKDTable("kdtEntries").getRow(i).getCell("freightDetail").setValue(DetailQty);
			}
			String sumsql = "update T_SM_PurOrder set cfsumkfreight = "+sumQty+" where FID = '"+editData.getId().toString()+"'";
			param.getKDFormattedTextField("txtsumkfreight").setValue(sumQty); 
			//editData.put("sumkfreight", sumQty);
			CommFacadeFactory.getRemoteInstance().excuteUpdateSql(sumsql);
		}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		//loadFields();
	
	}
	
	private void updateSupplier(UIParam param) throws SQLException {
		// TODO Auto-generated method stub
		SupplierInfo supplierCompany = (SupplierInfo) param.getKDBizPromptBox("prmtsupplier1").getValue();
		BigDecimal StandPrice = new BigDecimal("0");
		String sql  = "select  CFFRIGHTPRICE from  T_BD_SUPPLIERCOMPANYINFO  where FSUPPLIERID = '"+supplierCompany.getId().toString()+"' ";
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.next()){
				if(StringUtils.isBlank(rs.getString("CFFRIGHTPRICE"))){
					StandPrice = new BigDecimal(rs.getString("CFFRIGHTPRICE"));
				}
			}		
			param.getKDFormattedTextField("txtStandFright").setValue(StandPrice);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void updateSuppliers(UIParam param) throws SQLException {
		// TODO Auto-generated method stub
		SupplierInfo supplierCompany = (SupplierInfo) param.getKDBizPromptBox("prmtsupplier2").getValue();
		PurchaseOrgUnitInfo pginfo = (PurchaseOrgUnitInfo) param.getKDBizPromptBox("prmtPurchaseOrgUnit").getValue();
		
		BigDecimal StandPrice = new BigDecimal("0");
		String sql  = "select  CFFRIGHTPRICE from  T_BD_SupplierPurchaseInfo  where FSupplierID = '"+supplierCompany.getId().toString()+"' and FPurchaseOrgID = '"+pginfo.getId().toString()+"'";
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
			if(rs.next()){
				if(!StringUtils.isBlank(rs.getString("CFFRIGHTPRICE"))){
					StandPrice = new BigDecimal(rs.getString("CFFRIGHTPRICE"));
				}
			}		
			param.getKDFormattedTextField("txtStandFright").setValue(StandPrice);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
