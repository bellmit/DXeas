package com.kingdee.eas.custom.dep.client;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.assistant.SystemStatusCtrolUtils;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerSaleInfoCollection;
import com.kingdee.eas.basedata.master.cssp.CustomerSaleInfoFactory;
import com.kingdee.eas.basedata.master.material.IMultiMeasureUnit;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitFactory;
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.salediscount.DiscountCompanyInfo;
import com.kingdee.eas.custom.salediscount.DiscountFacadeFactory;
import com.kingdee.eas.custom.salediscount.DiscountGridLogEntryInfo;
import com.kingdee.eas.custom.salediscount.IDiscountFacade;
//import com.kingdee.eas.custom.xszr.ZrzlEntryCollection;
//import com.kingdee.eas.custom.xszr.ZrzlFactory;
//import com.kingdee.eas.custom.xszr.ZrzlInfo;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.eas.scm.sd.sale.SaleReturnsInfo;
import com.kingdee.eas.scm.sd.sale.client.SaleReturnsEditUIPIEx;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * �����˻����뵥 �༭ dep
 * @author Administrator
 *
 */
public class SaleReturnsBillEditDep {

	// �༭����
	protected SaleReturnsEditUIPIEx ui;
	// ���� ����
	protected SaleReturnsInfo editData;



	//	public void actionAudit_actionPerformed(ActionEvent arg0) throws Exception {
	//		// TODO Auto-generated method stub
	//		this.calLz();
	//		super.actionAudit_actionPerformed(arg0);
	//	}
	//
	//	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
	//		// TODO Auto-generated method stub
	//		this.calLz();
	//		super.actionSubmit_actionPerformed(e);
	//	}

	/**
	 * �����ô���
	 */
	//	public void calLz(UIParam param) throws EASBizException, BOSException, SQLException {
	//		ui = (SaleReturnsEditUIPIEx) param.getUI();
	//		editData = (SaleReturnsInfo) ui.getEditData();
	//		
	//		CompanyOrgUnitInfo companyInfo = (CompanyOrgUnitInfo) SysContext.getSysContext().getCurrentFIUnit(); // ��ǰ������֯
	//		PeriodInfo po = (PeriodInfo) SystemStatusCtrolUtils.getCurrentPeriod(null, SystemEnum.INVENTORYMANAGEMENT, companyInfo);
	//		com.kingdee.eas.basedata.master.cssp.CustomerInfo custom = (com.kingdee.eas.basedata.master.cssp.CustomerInfo) param.getKDBizPromptBox("prmtreturnsCustomer")
	//				.getValue();
	////		for (int j = 0; j < param.getKDTable("kdtEntrys").getRowCount(); j++) {
	////			// SaleReturnsEntryInfo en=(SaleReturnsEntryInfo)
	////			// this.kdtEntries.getRow(j);
	////			MaterialInfo ma = (MaterialInfo) param.getKDTable("kdtEntrys").getRow(j).getCell("material").getValue();
	////			CompanyOrgUnitInfo cufi = SysContext.getSysContext().getCurrentFIUnit();
	////			StringBuffer lz = new StringBuffer();
	////			lz.append("select fid from CT_XSZ_Zrzl where cfcustomerid='");
	////			lz.append(custom.getId().toString() + "'");
	////			lz.append(" and cfmaterialid='");
	////			lz.append(ma.getId().toString() + "'");
	////			lz.append(" and CFFICompanyID='");
	////			lz.append(cufi.getId().toString() + "' and cfzrfs='0' ");
	////			IRowSet rrs = com.kingdee.eas.custom.xszr.CalUtilFacadeFactory.getRemoteInstance().getSqlData(lz.toString());
	////			if (rrs.next()) {
	////				ObjectUuidPK cu = new ObjectUuidPK(rrs.getString("fid"));
	////				ZrzlInfo zrzl = ZrzlFactory.getRemoteInstance().getZrzlInfo(cu);
	////				ZrzlEntryCollection zren = zrzl.getEntry();
	////				for (int i = 0, sz = zren.size(); i < sz; i++) {
	////					BigDecimal sx = (BigDecimal) zren.get(i).get("sx");
	////					BigDecimal xx = (BigDecimal) zren.get(i).get("xx");
	////					BigDecimal bl = (BigDecimal) zren.get(i).get("zrbl");
	////					BigDecimal qty = (BigDecimal) param.getKDTable("kdtEntrys").getRow(j).getCell("qty").getValue();
	////					if (qty == null)
	////						qty = new BigDecimal(0);
	////					if (qty.compareTo(sx) <= 0 && qty.compareTo(xx) >= 0) {
	////						BigDecimal enlz = qty.multiply(bl);
	////						param.getKDTable("kdtEntrys").getRow(j).getCell("lz").setValue(enlz);
	////						break;
	////					}
	////				}
	////			}
	////		}
	//	}




	/**************************************����������߼�  wgj 20150804 begin*************************************************/

	/**
	 * ��ʼ��
	 */
	public void afterOnload(UIParam param) throws Exception {
		ui = (SaleReturnsEditUIPIEx) param.getUI();
		editData = (SaleReturnsInfo) ui.getEditData();

		ui.setCuid(SysContext.getSysContext().getCurrentStorageUnit().getId().toString());

		boolean isEnableXXWDiscount = DiscountFacadeFactory.getRemoteInstance().isEnableDiscount(ui.getCuid());
		ui.setEnableXXWDiscount(isEnableXXWDiscount);


		// ������Ŀ ��� ����������ù�˾�б�  �����÷�¼ȫ�����ɱ༭
		IDiscountFacade discountFacade = DiscountFacadeFactory.getRemoteInstance();
		// ֻ���������õĹ�˾�Ž��п���
		if(ui.isEnableXXWDiscount()){
			// ���ø��ư�ť
			param.getKDWorkButton("btnCopy").setVisible(false);
			// ��ȡ���ù�˾
			DiscountCompanyInfo dsCompanyInfo = discountFacade.getCompanyDSSet(ui.getCuid());
			ui.setDiscountCompanyInfo(dsCompanyInfo);
			//  ֻҪ��������֯�б��� ��ͣ�÷�¼�༭   ֻ����¼������������
			if(dsCompanyInfo != null){
				KDTable kdtEntry = param.getKDTable("kdtEntrys");
				int columnCount = kdtEntry.getColumnCount();
				// ���ó������Ϻ� δ�ۿ������� ������ �����ɱ༭
				for(int i = 0;i < columnCount; i++){
					String columnName = kdtEntry.getColumnKey(i);
					if(!"material".equals(columnName) &&
							!"NoDSQty".equals(columnName)  &&
							!"unit".equals(columnName) && 
							!"remark".equals(columnName)){
						kdtEntry.getColumn(i).getStyleAttributes().setLocked(true);
					}else{
						kdtEntry.getColumn(i).getStyleAttributes().setLocked(false);
					}
				}


				//	    		// ��ȡ �����Ѿ���������ü�¼��־
				//	    		if(ui.getEditData() != null && ui.getEditData().getId() != null){
				//	    			List discountGridLogs = DiscountFacadeFactory.getRemoteInstance().getOrderDiscountGridLogs(ui.getEditData().getId().toString());
				//	    			if(discountGridLogs != null && discountGridLogs.size() > 0){
				//	    				ui.setDiscountLogs(discountGridLogs);
				//	    			}
				//	    		}
			}
		}


	}


	/**
	 * ����ϵͳ�������ύǰУ�� �ͻ������
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public void checkBeforeSubmit(UIParam param) throws BOSException, EASBizException{
		ui = (SaleReturnsEditUIPIEx) param.getUI();
		editData = (SaleReturnsInfo) ui.getEditData();

		CompanyOrgUnitInfo companyInfo = SysContext.getSysContext().getCurrentFIUnit();
		if(companyInfo != null){
			// �����Ƿ� �������Ͽ��У��
			boolean isCheckMaterialInventory = DiscountFacadeFactory.getRemoteInstance().isCheckMaterialInventory(companyInfo.getId().toString());

			boolean isEnableDiscount = DiscountFacadeFactory.getRemoteInstance().isEnableDiscount(companyInfo.getId().toString());
			if(isEnableDiscount){
				SaleOrgUnitInfo sou = (SaleOrgUnitInfo) param.getKDBizPromptBox("prmtStorageOrgUnit").getValue();
				// map�ݴ�  �����Ϣ 
				Map<String, MaterialInventoryInfo> mapMaterialInventory = new HashMap<String, MaterialInventoryInfo>();

				// �����¼ ��ȡ��������   Ȼ�� �����Ƚ� {
				KDTable table = param.getKDTable("kdtEntrys");
				for(int i = 0 ; i < table.getRowCount(); i++){

					MaterialInfo materialInfo = (MaterialInfo) table.getRow(i).getCell("material").getValue();
					BigDecimal baseQtyO = (BigDecimal) table.getRow(i).getCell("baseQty").getValue();
					MeasureUnitInfo baseUnitO = (MeasureUnitInfo) table.getRow(i).getCell("baseUnit").getValue();
					WarehouseInfo warehouseInfo = (WarehouseInfo) table.getRow(i).getCell("warehouse").getValue();

					if(warehouseInfo == null){
						MsgBox.showInfo("��¼�д��� �ֿ�Ϊ�յķ�¼");
						SysUtil.abort();
					}


					BigDecimal fxDiscount=(BigDecimal)table.getRow(i).getCell("FxDSAmount").getValue();
					if(fxDiscount != null && fxDiscount.compareTo(new BigDecimal("0")) != 0){
						CustomerInfo parentCustomer = (CustomerInfo)editData.getObjectValue("customerb");
						if(parentCustomer == null){
							MsgBox.showError("�����ϼ��ͻ�����Ϊ�գ���ά����ǰ�����ͻ����ϼ��ͻ������ύ����");
							SysUtil.abort();
						}
					}

				}	
			}
			//				boolean isCheckCustomerBalance = DiscountFacadeFactory.getRemoteInstance().isCheckCustomerBalance(companyInfo.getId().toString());
			//				if(isCheckCustomerBalance){
			//					
			//					CustomerInfo orderCustomer  = (CustomerInfo) this.prmtOrderCustomer").getData();
			//					
			//					if(orderCustomer != null){
			//						
			//						RptParams pp = new RptParams();
			//						pp.setInt("ControlScene", 1);
			//						pp.setObject("TempTableName", null);
			//						pp.setBoolean("cbBizCode", false);
			//						pp.setObject("company", companyInfo);
			//						pp.setString("customerFrom", orderCustomer.getNumber());
			//						pp.setString("customerTo", orderCustomer.getNumber());
			//						pp.setBoolean("isFromSaleReturnsQuery", true);
			//						ICreditAnalysisRptFacade rptFacade =  CreditAnalysisRptFacadeFactory.getRemoteInstance();
			//						RptParams retParams = rptFacade.createTempTable(pp);
			//						String tempTableName = retParams.getString("TempTableName");
			//						pp.setString("TempTableName",tempTableName);
			//			            pp.setBoolean("isByBizCode",false);
			//			            /*
			//			        	 * �޸�ԭ��Bug��BT514726�����ö�ȷ���������ѡ�񡰰�ҵ���������з�����ʱ��ͳ����ʾ��ҵ��������й�Ӧ�̵�������ȷ��Ӧ���ǣ���ѡ�񡰰�ҵ���������з�����ʱ��ֻͳ��ҵ�����������ݣ�������ʾҵ��������й�Ӧ�̺Ϳͻ�������
			//			        	 * �޸��ˣ�������	2011-02-22
			//			        	 * */
			//			            pp.setBoolean("isByBizCode_Param", false);
			//			            retParams = rptFacade.query(pp,0,1);
			//			            RptRowSet rs = (RptRowSet) retParams.getObject("rowset");
			//			            if(rs.next()){
			//			            	BigDecimal FCreditAmount =  rs.getBigDecimal("FAmount");
			//			            	
			//			            	BigDecimal PayAmt = rs.getBigDecimal("PayAmt");
			//			            	BigDecimal FArBalance = rs.getBigDecimal("FArBalance");
			//			            
			//			               	BigDecimal FUnArBillOrderAmt = rs.getBigDecimal("FUnArBillOrderAmt");  // �����δӦ�ն������
			//			               	BigDecimal UsedAmount =  rs.getBigDecimal("UsedAmount");
			//			               	BigDecimal FUnAuditPostBillAmt =  rs.getBigDecimal("FUnAuditPostBillAmt");
			//			               	BigDecimal FUnArBillIssuedAmt =  rs.getBigDecimal("FUnArBillIssuedAmt");
			//			            	BigDecimal FUnAuditIssuedAmt =  rs.getBigDecimal("FUnAuditIssuedAmt");
			//			            	BigDecimal FUnOutPostBillAmt =  rs.getBigDecimal("FUnOutPostBillAmt");
			//			            	BigDecimal FUnOutSaleReturnsBillAmt =  rs.getBigDecimal("FUnOutSaleReturnsBillAmt");
			//			               	
			//			            	BigDecimal CreditBalance =  rs.getBigDecimal("CreditBalance");    // �������
			//			            	
			//			            	
			//			            	
			//							
			//			            }
			//						
			//					}
			//				}
		}
	}



	/**
	 * ���¹��˽��
	 * @param param
	 * @throws Exception
	 */
	public void updateGuazhangAmount(UIParam param) throws Exception
	{
		ui = (SaleReturnsEditUIPIEx) param.getUI();
		editData = (SaleReturnsInfo) ui.getEditData();
		//			this.txtntfGuaZhang").setValue(UIRuleUtil.getBigDecimal(
		//					UIRuleUtil.getBigDecimalValue(param.getKDFormattedTextField("txttotalTaxPrice")").getValue())- 
		//					UIRuleUtil.getBigDecimalValue(this.txtntfCash").getValue()) -
		//					UIRuleUtil.getBigDecimalValue(this.txtntfPos").getValue())-
		//					UIRuleUtil.getBigDecimalValue(this.txtntfTongcunTongdui").getValue())));
		//			


		BigDecimal txtTotalTaxAmount = param.getKDFormattedTextField("txttotalTaxPrice").getBigDecimalValue();
		if(txtTotalTaxAmount == null){
			txtTotalTaxAmount = new BigDecimal("0");
		}
		// �ֽ�
		BigDecimal txtntfCash = param.getKDFormattedTextField("txtntfCash").getBigDecimalValue();
		if(txtntfCash == null){
			txtntfCash = new BigDecimal("0");
		}
		txtntfCash = txtntfCash.divide(new BigDecimal("1"),2,RoundingMode.HALF_UP);
		param.getKDFormattedTextField("txtntfCash").setValue(txtntfCash);
		// pos
		BigDecimal txtntfPos = param.getKDFormattedTextField("txtntfPos").getBigDecimalValue();
		if(txtntfPos == null){
			txtntfPos = new BigDecimal("0");
		}
		txtntfPos = txtntfPos.divide(new BigDecimal("1"),2,RoundingMode.HALF_UP);
		param.getKDFormattedTextField("txtntfPos").setValue(txtntfPos);
		// ͨ��ͨ��
		BigDecimal txtntfTongcunTongdui = param.getKDFormattedTextField("txtntfTongcunTongdui").getBigDecimalValue();
		if(txtntfTongcunTongdui == null){
			txtntfTongcunTongdui = new BigDecimal("0");
		}
		txtntfTongcunTongdui = txtntfTongcunTongdui.divide(new BigDecimal("1"),2,RoundingMode.HALF_UP);
		param.getKDFormattedTextField("txtntfTongcunTongdui").setValue(txtntfTongcunTongdui);
		param.getKDFormattedTextField("txtntfGuaZhang").setValue(txtTotalTaxAmount.subtract(txtntfCash).subtract(txtntfPos).subtract(txtntfTongcunTongdui));
	}


	/**
	 * ��¼����
	 * @param param
	 * @param rowIndex
	 * @param colIndex
	 * @throws Exception
	 */
	public void kdtEntrys_Changed(UIParam param,KDTEditEvent e) throws Exception{

		ui = (SaleReturnsEditUIPIEx) param.getUI();
		editData = (SaleReturnsInfo) ui.getEditData();

		int rowIndex = e.getRowIndex();
		int colIndex = e.getColIndex();

		String fieldName = param.getKDTable("kdtEntrys").getColumnKey(colIndex);
		if ("material".equalsIgnoreCase(fieldName)) {
			if( param.getKDBizPromptBox("prmtreturnsCustomer").getData()==null){
				MsgBox.showInfo("�ͻ�����Ϊ�գ�");
				return;
			}
			MaterialInfo FMaterialInfo=(MaterialInfo)param.getKDTable("kdtEntrys").getRow(rowIndex).getCell("material").getValue();
			CustomerInfo info = (CustomerInfo)  param.getKDBizPromptBox("prmtreturnsCustomer").getData();

		}

		// �����߼�   ¼�����Ϻ��ۿ�ǰ������ ���¼��� ���� ���������ֶ�
		if(ui.isEnableXXWDiscount() && ui.getDiscountCompanyInfo() != null ){
			DiscountCompanyInfo dsCompanyInfo = ui.getDiscountCompanyInfo();
			IDiscountFacade discountFacade = DiscountFacadeFactory.getRemoteInstance();
			// ������֯
			SaleOrgUnitInfo currSaleOrgUnitInfo =  (SaleOrgUnitInfo) param.getKDBizPromptBox("prmtsaleOrgUnit").getData();
			if(currSaleOrgUnitInfo == null){
				MsgBox.showInfo("����ѡ��������֯");
				return;
			}
			// �ͻ�
			CustomerInfo currCustomerInfo =  (CustomerInfo)  param.getKDBizPromptBox("prmtreturnsCustomer").getData();
			if(currCustomerInfo == null){
				MsgBox.showInfo("����ѡ���˻��ͻ�");
				return;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date bizDate = param.getKDDatePicker("bizDate").getSqlDate();
			if(bizDate == null){
				MsgBox.showInfo("����ѡ��ҵ������");
				return;
			}
			// ���ϸ���ʱ ͬʱ��û�������
			// ���·�¼��������
			if("material".equalsIgnoreCase(fieldName) ){
				//	        		updateEntryInfoByBasePriceAndNoDSQty(param,param.getKDTable("kdtEntrys"),currSaleOrgUnitInfo,currCustomerInfo,rowIndex);

			}


			if("NoDSQty".equalsIgnoreCase(fieldName) ){
				updateEntryInfoByBasePriceAndNoDSQty(param,param.getKDTable("kdtEntrys"),currSaleOrgUnitInfo,currCustomerInfo,rowIndex);
			}



			// ���в�����ɺ��������� ֻ�����Ϻ�δ���������ɱ༭
			KDTable kdtEntry = param.getKDTable("kdtEntrys");
			int columnCount = kdtEntry.getColumnCount();
			// ���ó������Ϻ� δ�ۿ������� ������ �����ɱ༭
			for(int i = 0;i < columnCount; i++){
				String columnName = param.getKDTable("kdtEntrys").getColumnKey(i);
				if(!"material".equals(columnName) && !"NoDSQty".equals(columnName) &&  !"unit".equals(columnName)){
					kdtEntry.getColumn(i).getStyleAttributes().setLocked(true);
				}else{
					kdtEntry.getColumn(i).getStyleAttributes().setLocked(false);
				}
			}
		}


		updateGuazhangAmount(param);
	}


	/**
	 * ɾ����¼�� ����
	 * @param param
	 * @throws Exception
	 */
	public void afterRemoveEntry(UIParam param) throws Exception{

		ui = (SaleReturnsEditUIPIEx) param.getUI();
		editData = (SaleReturnsInfo) ui.getEditData();
		// ֻ������ ���ù���� ��˾�Ž��д���
		if(ui.isEnableXXWDiscount() && ui.getDiscountCompanyInfo() != null ){
			// �Ѿ�������Ķ���  ��¼ɾ���� Ҫ���� ��̨ ���ü�����־
			if(editData.getId() != null){
				// ��¼ɾ����  ͬʱ��������־��  ���������  ���
				StringBuilder entryIDs = new StringBuilder("");
				for(int i = 0; i < param.getKDTable("kdtEntrys").getRowCount(); i++){
					BOSUuid entryID = (BOSUuid) param.getKDTable("kdtEntrys").getCell(i, "id").getValue();
					if(entryID != null){
						entryIDs.append(",'").append(entryID.toString()).append("'");
					}


				}
				String validEntryIDs = "";
				if(entryIDs.length() > 0){
					validEntryIDs = entryIDs.substring(1);
				}
				ui.setValieOrderEntryIDs(validEntryIDs);
				//					DiscountFacadeFactory.getRemoteInstance().removeOrderEntryDsgridLogs(editData.getId().toString(),validEntryIDs);
			}
			// ������֯
			SaleOrgUnitInfo currSaleOrgUnitInfo =  (SaleOrgUnitInfo) param.getKDBizPromptBox("prmtsaleOrgUnit").getData();
			if(currSaleOrgUnitInfo == null){
				MsgBox.showInfo("����ѡ��������֯");
				return;
			}
			// �ͻ�
			CustomerInfo currCustomerInfo =  (CustomerInfo)  param.getKDBizPromptBox("prmtreturnsCustomer").getData();
			if(currCustomerInfo == null){
				MsgBox.showInfo("����ѡ���˻��ͻ�");
				return;
			}

			updateEntryInfoByBasePriceAndNoDSQty(param,param.getKDTable("kdtEntrys"),currSaleOrgUnitInfo,currCustomerInfo,0);


		}


	}

	/**
	 * ���� ������˰���� �� ʵ���ۿ�ǰ�������·�¼   �������ۿ�����
	 * @param param
	 * @param kdtEntry
	 * @param rowIndex
	 * @throws Exception 
	 */
	private void updateEntryInfoByBasePriceAndNoDSQty(
			UIParam param,
			KDTable kdtEntry,
			SaleOrgUnitInfo currSaleOrgUnitInfo,
			CustomerInfo currCustomerInfo,
			int rowIndex) throws Exception{

		ui = (SaleReturnsEditUIPIEx) param.getUI();
		editData = (SaleReturnsInfo) ui.getEditData();
		// ��ǰ����id
		String SaleReturnsID = "";
		if(editData != null && editData.getId() != null){
			SaleReturnsID = editData.getId().toString();
		}
		List discountLogsEver = ui.getDiscountLogs();
		if(discountLogsEver == null){
			discountLogsEver = new ArrayList();
		}else if(discountLogsEver.size() > 0){
			discountLogsEver.clear(); 
		}

		// ���з�¼����
		for(int ii = 0; ii < kdtEntry.getRowCount(); ii++){

			Object nodsQtyObj =  param.getKDTable("kdtEntrys").getCell(ii,"NoDSQty").getValue();

			BigDecimal noDSQty = new BigDecimal("0");
			if(nodsQtyObj != null){
				Class class1 = nodsQtyObj.getClass();
				if(String.class.isInstance(nodsQtyObj)){
					try{
						noDSQty = new BigDecimal((String)nodsQtyObj);
					}catch(Exception nfe){
						MsgBox.showInfo("����ʵ���ۿ���������¼������");
						return;
					}

				}else if(BigDecimal.class.isInstance(nodsQtyObj)){
					noDSQty = (BigDecimal)nodsQtyObj;
				}
			}else{
				return;
			}


			if(noDSQty.compareTo(new BigDecimal("0")) <= 0){
				MsgBox.showInfo("����ʵ���ۿ������������0");
				return;
			}


			rowIndex = ii;
			// ����ǰ �������¼
			param.getKDTable("kdtEntrys").getCell(rowIndex,"SwDSQty").setValue(null);
			param.getKDTable("kdtEntrys").getCell(rowIndex,"SwDSamount").setValue(null);
			param.getKDTable("kdtEntrys").getCell(rowIndex,"SwDSExpression").setValue("");

			param.getKDTable("kdtEntrys").getCell(rowIndex,"LzAmount").setValue(null);
			param.getKDTable("kdtEntrys").getCell(rowIndex,"LzExpression").setValue("");

			param.getKDTable("kdtEntrys").getCell(rowIndex,"MonthDSAmount").setValue(null);
			param.getKDTable("kdtEntrys").getCell(rowIndex,"MonthDSExpression").setValue("");

			param.getKDTable("kdtEntrys").getCell(rowIndex,"YearDSAmount").setValue(null);
			param.getKDTable("kdtEntrys").getCell(rowIndex,"YearDSExpression").setValue("");

			param.getKDTable("kdtEntrys").getCell(rowIndex,"FxDSAmount").setValue(null);
			param.getKDTable("kdtEntrys").getCell(rowIndex,"FxDSExpression").setValue("");


			//		BigDecimal basePrice = (BigDecimal) param.getKDTable("kdtEntrys").getCell(rowIndex,"price").getValue();
			//		BigDecimal basePrice = (BigDecimal) param.getKDTable("kdtEntrys").getCell(rowIndex,"DsBasePrice").getValue();

			MeasureUnitInfo unit = (MeasureUnitInfo) param.getKDTable("kdtEntrys").getCell(rowIndex,"unit").getValue();
			if(nodsQtyObj == null ){

				continue;
			}
			if(unit == null ){

				continue;
			}else{
				if(unit.getCoefficient() == null){
					unit = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK(unit.getId()));
				}
			}
			MaterialInfo material = (MaterialInfo)param.getKDTable("kdtEntrys").getRow(rowIndex).getCell("material").getValue();
			//		param.getKDTable("kdtEntrys").getRow(rowIndex).getUserObject();
			//		param.getKDTable("kdtEntrys").getCell(rowIndex, "id").getValue();
			BOSUuid entryID = (BOSUuid) param.getKDTable("kdtEntrys").getCell(rowIndex, "id").getValue();
			if(material == null){
				MsgBox.showInfo("����ѡ������");
				continue;
			}
			// ��̨����ӿ�
			IDiscountFacade discountFacade = DiscountFacadeFactory.getRemoteInstance();
			// ���ü�����־ 
			//				List discountLogs = new ArrayList();

			String materialID = material.getId().toString();
			// ����������ֻ��Ϊ��ȡ�۸����߶����õ�
			BigDecimal orderQty = new BigDecimal("10");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date bizDate = param.getKDDatePicker("bizDate").getSqlDate();
			if(bizDate == null){
				MsgBox.showInfo("����ѡ��ҵ������");
				return;
			}
			BigDecimal basePrice = discountFacade.getMaterialPolicyPrice(ui.getCuid(),
					currCustomerInfo.getId().toString(),
					materialID,
					sdf.format(bizDate),
					orderQty,
					unit.getId().toString());
			if(basePrice != null){
				param.getKDTable("kdtEntrys").getCell(rowIndex,"DsBasePrice").setValue(basePrice);

			}else{
				// û��ά�������۸�Ļ���  ���ü۸�Ϊ 0 Ȼ����ʾ�û�

				MsgBox.showInfo("����û��ά�������۸�����ά���۸�����");
				return;
			}




			BigDecimal coefficient = unit.getCoefficient();
			if(coefficient == null) coefficient = new BigDecimal("1");


			String bizDateStr = sdf.format(bizDate);

			DiscountCompanyInfo dsCompanyInfo = ui.getDiscountCompanyInfo();

			if(basePrice != null && noDSQty != null){
				// ���벻��ʵ���ۿ���������ɺ�ϵͳ���ȸ��ݻ����۸񣨲�������*�����۸�=�ۿ�ǰ�ܽ���������ۿ�ǰ�ܽ��д���¼���ۿ�ǰ�ܽ���
				BigDecimal noDSAmount = basePrice.multiply(noDSQty);
				param.getKDTable("kdtEntrys").getCell(rowIndex,"NoDSAmount").setValue(noDSAmount);

				// ���۽�� = ʵ���ۿ۽��+����ǰ�ܽ��
				BigDecimal baseAmount = new BigDecimal("0");
				baseAmount = baseAmount.add(noDSAmount);

				// ���۾���   ���۽�� �������е��ۿ۽��
				BigDecimal netAmount = new BigDecimal("0");
				netAmount = netAmount.add(noDSAmount);
				/************************************************************************************************************************/
				// ����ʵ���ۿۺ������
				BigDecimal qty = noDSQty;


				// ��� �ȵ�ǰ�� ��ǰ������ ����������
				Map<String,BigDecimal> otherRowsQty = getOtherEntryMaterialQty(param.getKDTable("kdtEntrys"),ii);
				// ʵ�� �ۿ� 
				if(dsCompanyInfo.isEnableSWDiscount()){
					com.kingdee.eas.custom.ResultInfo  swDiscountQty = discountFacade.getZengBaoDiscountValue(currSaleOrgUnitInfo.getId().toString(),
							currCustomerInfo.getId().toString(), 
							material.getId().toString(),
							noDSQty,
							basePrice,
							bizDateStr,
							coefficient,
							ui.getDiscountLogs(),
							rowIndex + 1,
							SaleReturnsID,
							ui.getValieOrderEntryIDs(),
							true,
							otherRowsQty);

					if(swDiscountQty != null){
						qty = qty.add((BigDecimal) swDiscountQty.getReturnObj());
						String message = swDiscountQty.getMessage();

						BigDecimal dsAmount = basePrice.multiply((BigDecimal) swDiscountQty.getReturnObj());

						param.getKDTable("kdtEntrys").getCell(rowIndex,"SwDSQty").setValue(swDiscountQty.getReturnObj());
						param.getKDTable("kdtEntrys").getCell(rowIndex,"SwDSamount").setValue(dsAmount);

						param.getKDTable("kdtEntrys").getCell(rowIndex,"SwDSExpression").setValue(message);

						baseAmount = baseAmount.add(dsAmount);
						if(param.getKDTable("kdtEntrys").getRow(rowIndex).getCell("BaseAmount") != null){
							param.getKDTable("kdtEntrys").getCell(rowIndex,"BaseAmount").setValue(baseAmount);
						}

						// ��������־�ݴ����ڴ���

						//							discountLogs.addAll(swDiscountQty.getDiscountLogInfos());
					}
				}
				// ����ʵ���ۿ�������� ����
				param.getKDTable("kdtEntrys").getCell(rowIndex,"qty").setValue(qty);

				KDTEditEvent editEvent=new KDTEditEvent(param.getKDTable("kdtEntrys"), null, qty, rowIndex, param.getKDTable("kdtEntrys").getCell(rowIndex,"qty").getColumnIndex(), false, 1);
				ui.kdtEntrys_editStopped(editEvent);
				//					ui.kdtEntrys_Changed(rowIndex,param.getKDTable("kdtEntrys").getCell(rowIndex,"qty").getColumnIndex());
				/************************************************************************************************************************/
				// �����ۿ� 
				BigDecimal amount = noDSAmount;
				if(dsCompanyInfo.isEnableLZdiscount()){
					com.kingdee.eas.custom.ResultInfo  lizheDiscountAmount = discountFacade.getLiDiscountValue(currSaleOrgUnitInfo.getId().toString(),
							currCustomerInfo.getId().toString(), 
							material.getId().toString(),
							noDSQty,
							basePrice,
							bizDateStr,
							coefficient,
							ui.getDiscountLogs(),
							rowIndex + 1,
							SaleReturnsID,
							ui.getValieOrderEntryIDs(),
							true,
							otherRowsQty);
					if(lizheDiscountAmount != null){
						// �ۿ�ǰ�ܽ��-���۽��=�ܽ��
						amount = amount.subtract((BigDecimal) lizheDiscountAmount.getReturnObj());
						String message = lizheDiscountAmount.getMessage();

						param.getKDTable("kdtEntrys").getCell(rowIndex,"LzAmount").setValue(lizheDiscountAmount.getReturnObj());

						param.getKDTable("kdtEntrys").getCell(rowIndex,"LzExpression").setValue(message);
						netAmount = netAmount.subtract((BigDecimal) lizheDiscountAmount.getReturnObj());
						// ��������־�ݴ����ڴ���
						//							discountLogs.addAll(lizheDiscountAmount.getDiscountLogInfos());
					}

				}
				param.getKDTable("kdtEntrys").getCell(rowIndex,"taxAmount").setValue(amount);
				param.getKDTable("kdtEntrys").getCell(rowIndex,"amount").setValue(amount);
				param.getKDTable("kdtEntrys").getCell(rowIndex,"localAmount").setValue(amount);
				// ���� �ܽ��� ���� ����� ����  ���/����=ʵ�ʺ�˰����
				BigDecimal taxPrice = amount.divide(qty,10,RoundingMode.HALF_UP);
				editEvent=new KDTEditEvent(param.getKDTable("kdtEntrys"), null, amount, rowIndex, param.getKDTable("kdtEntrys").getCell(rowIndex,"amount").getColumnIndex(), false, 1);

				ui.kdtEntrys_editStopped(editEvent);
				//					ui.kdtEntrys_Changed(rowIndex,param.getKDTable("kdtEntrys").getCell(rowIndex,"taxAmount").getColumnIndex());
				//			param.getKDTable("kdtEntrys").getCell(rowIndex,"taxPrice").setValue(taxPrice);
				//			
				int colIndex = param.getKDTable("kdtEntrys").getColumn("taxRate").getColumnIndex();
				//			ui.calByEntryTaxPriceChange(rowIndex,colIndex);
				//			ui.calEntryLocalAmount(rowIndex, 0);
				//			ui.qtyChage(rowIndex,null);
				/************************************************************************************************************************/

				/************************************************************************************************************************/
				// �����ۿ� 
				if(dsCompanyInfo.isEnableMonthDiscount()){
					com.kingdee.eas.custom.ResultInfo  yueDiscountAmount = discountFacade.getMonthDiscountValue(currSaleOrgUnitInfo.getId().toString(),
							currCustomerInfo.getId().toString(), 
							material.getId().toString(),
							noDSQty,
							basePrice,
							bizDateStr,
							coefficient,
							ui.getDiscountLogs(),
							rowIndex + 1,
							SaleReturnsID,
							ui.getValieOrderEntryIDs(),
							true,
							otherRowsQty);
					if(yueDiscountAmount != null){
						// �ۿ�ǰ�ܽ��-���۽��=�ܽ��
						//					amount = amount.subtract(yueDiscountAmount.getReturnObj());
						String message = yueDiscountAmount.getMessage();

						param.getKDTable("kdtEntrys").getCell(rowIndex,"MonthDSAmount").setValue(yueDiscountAmount.getReturnObj());

						param.getKDTable("kdtEntrys").getCell(rowIndex,"MonthDSExpression").setValue(message);

						netAmount = netAmount.subtract((BigDecimal) yueDiscountAmount.getReturnObj());
						// ��������־�ݴ����ڴ���
						//							discountLogs.addAll(yueDiscountAmount.getDiscountLogInfos());
					}

				}
				/************************************************************************************************************************/
				// �����ۿ� 
				if(dsCompanyInfo.isEnableYearDiscount()){
					com.kingdee.eas.custom.ResultInfo  yearDiscountAmount = discountFacade.getYearDiscountValue(currSaleOrgUnitInfo.getId().toString(),
							currCustomerInfo.getId().toString(), 
							material.getId().toString(),
							noDSQty,
							basePrice,
							bizDateStr,
							coefficient,
							ui.getDiscountLogs(),
							rowIndex + 1,
							SaleReturnsID,
							ui.getValieOrderEntryIDs(),
							true,
							otherRowsQty);
					if(yearDiscountAmount != null){
						// �ۿ�ǰ�ܽ��-���۽��=�ܽ��
						//					amount = amount.subtract(yearDiscountAmount.getReturnObj());
						String message = yearDiscountAmount.getMessage();

						param.getKDTable("kdtEntrys").getCell(rowIndex,"YearDSAmount").setValue(yearDiscountAmount.getReturnObj());

						param.getKDTable("kdtEntrys").getCell(rowIndex,"YearDSExpression").setValue(message);

						netAmount = netAmount.subtract((BigDecimal) yearDiscountAmount.getReturnObj());
						// ��������־�ݴ����ڴ���
						//							discountLogs.addAll(yearDiscountAmount.getDiscountLogInfos());
					}

				}
				/************************************************************************************************************************/
				// �����ۿ� 
				if(dsCompanyInfo.isEnableFXDiscount()){
					com.kingdee.eas.custom.ResultInfo  fxDiscountAmount = discountFacade.getFenxiaoDiscountValue(currSaleOrgUnitInfo.getId().toString(),
							currCustomerInfo.getId().toString(), 
							material.getId().toString(),
							noDSQty,
							basePrice,
							bizDateStr,
							coefficient,
							ui.getDiscountLogs(),
							rowIndex + 1,
							SaleReturnsID,
							ui.getValieOrderEntryIDs(),
							true,
							otherRowsQty);
					if(fxDiscountAmount != null){
						// �ۿ�ǰ�ܽ��-���۽��=�ܽ��
						//					amount = amount.subtract(yearDiscountAmount.getReturnObj());
						String message = fxDiscountAmount.getMessage();

						param.getKDTable("kdtEntrys").getCell(rowIndex,"FxDSAmount").setValue(fxDiscountAmount.getReturnObj());

						param.getKDTable("kdtEntrys").getCell(rowIndex,"FxDSExpression").setValue(message);

						netAmount = netAmount.subtract((BigDecimal) fxDiscountAmount.getReturnObj());
						// ��������־�ݴ����ڴ���
						//							discountLogs.addAll(fxDiscountAmount.getDiscountLogInfos());
					}

				}

				if(param.getKDTable("kdtEntrys").getRow(rowIndex).getCell("NetSaleAmount") != null){
					param.getKDTable("kdtEntrys").getCell(rowIndex,"NetSaleAmount").setValue(netAmount);
				}
				//					// ��������־�ݴ���ui  ��¼��
				//					this.addDiscountLogLinkedInfo(param, 
				//									entryID==null?"":entryID.toString(), 
				//									rowIndex + 1, 
				//									noDSQty, 
				//									coefficient,
				//									noDSAmount, 
				//									discountLogs);

				//			ui.setDiscountLogs(discountLogs);
			}
		}
	}

	/**
	 * ��ó���ǰ��֮ǰ�� �����е� �������� map 
	 * key 
	 * @param entrySeq
	 * @return
	 */
	private Map<String,BigDecimal> getOtherEntryMaterialQty(KDTable kdtEntry, int entrySeq){
		Map<String,BigDecimal> qtyMap = new HashMap<String, BigDecimal>();

		// ���з�¼����
		for(int ii = 0; ii < kdtEntry.getRowCount(); ii++){
			if(ii < entrySeq){
				// ��ò���ʵ���ۿ�����
				Object nodsQtyObj =  kdtEntry.getCell(ii,"NoDSQty").getValue();
				MaterialInfo material = (MaterialInfo) kdtEntry.getCell(ii,"material").getValue();
				// ��ò���ʵ���ۿ�����
				BigDecimal noDSQty = new BigDecimal("0");
				if(nodsQtyObj != null){
					Class class1 = nodsQtyObj.getClass();

					if(String.class.isInstance(nodsQtyObj)){
						try{
							noDSQty = new BigDecimal((String)nodsQtyObj);



						}catch(Exception nfe){
							nfe.printStackTrace();
							//							com.kingdee.eas.util.client.MsgBox.showInfo("����ʵ���ۿ���������¼������");
							//							continue;
						}

					}else if(BigDecimal.class.isInstance(nodsQtyObj)){
						noDSQty = (BigDecimal)nodsQtyObj;
					}
				}
				// �����¼����ʵ���ۿ�����Ϊ 0 ����Ը���
				if(noDSQty.equals(new BigDecimal("0"))){
					continue;
				}
				if(material == null){
					continue;
				}else{
					if(qtyMap.containsKey(material.getId().toString())){
						BigDecimal qty = qtyMap.get(material.getId().toString());
						qty = qty.add(noDSQty);
						qtyMap.put(material.getId().toString(), noDSQty);
					}else{

						qtyMap.put(material.getId().toString(), noDSQty);
					}
				}


			}
		}


		return qtyMap;
	}
	/**
	 * ���ü�����־ ����¼id����  seq���õ���־�� 
	 * @param param
	 * @param entryID
	 * @param seq
	 * @param discountLogs
	 * @return
	 */
	private void addDiscountLogLinkedInfo(UIParam param,String entryID,int seq,BigDecimal noDsQty,BigDecimal coefficient, BigDecimal noDsAmount,List discountLogs){
		ui = (SaleReturnsEditUIPIEx) param.getUI();
		editData = (SaleReturnsInfo) ui.getEditData();

		List allDiscountLogs = ui.getDiscountLogs();
		if(allDiscountLogs == null){
			allDiscountLogs = new ArrayList();
		}
		// ������¼����ǰ����  ����ɶ�
		BigDecimal baseQtyT = noDsQty.multiply(coefficient).divide(new BigDecimal("1000"));

		//		editData = (SaleReturnsInfo) this.getEditData();
		for(int i  = 0; i < discountLogs.size(); i++){

			DiscountGridLogEntryInfo gridLogEntryInfo = (DiscountGridLogEntryInfo) discountLogs.get(i);

			if(gridLogEntryInfo.getDsQuantity() != null){
				gridLogEntryInfo.setDsQuantityKg(gridLogEntryInfo.getDsQuantity().multiply(coefficient));
			}
			gridLogEntryInfo.setOrderQtyT(baseQtyT);
			gridLogEntryInfo.setOrderEntryQty(noDsQty);
			gridLogEntryInfo.setOrderEntryAmount(noDsAmount);
			gridLogEntryInfo.setOrderEntryID(entryID);
			gridLogEntryInfo.setOrderEntrySeq(seq);

		}
		// ���Ȱ� list�� orderentryseq��ͬ������ɾ��
		for(int i = 0; i < allDiscountLogs.size(); i++){
			DiscountGridLogEntryInfo gridLogEntryInfo = (DiscountGridLogEntryInfo) allDiscountLogs.get(i);
			if(gridLogEntryInfo != null && gridLogEntryInfo.getOrderEntrySeq() == seq){
				allDiscountLogs.remove(i);
				i--;
			}
		}
		// �µ���־�ӵ��ܵ���־��
		allDiscountLogs.addAll(discountLogs);
		ui.setDiscountLogs(allDiscountLogs);

	}
	/**
	 * ���ݻ�����˰���ۼ��㵥�ۺ������ֶ�
	 * @param param
	 * @param rowIndex
	 * @param colIndex
	 * @throws Exception 
	 */
	private void updatePrice(UIParam param,int rowIndex, int colIndex) throws Exception {

		ui = (SaleReturnsEditUIPIEx) param.getUI();
		editData = (SaleReturnsInfo) ui.getEditData();

		BigDecimal basePrice = (BigDecimal)param.getKDTable("kdtEntrys").getCell(rowIndex,"basePrice").getValue();
		// ���ת��ϵ��
		BigDecimal exchangeRate = getExchangeRate(param,rowIndex);

		BigDecimal taxPrice = basePrice.multiply(exchangeRate);
		// ���û�����˰����
		param.getKDTable("kdtEntrys").getCell(rowIndex,"taxPrice").setValue(taxPrice);

		// ����ʵ���ۿ�������� ����
		param.getKDTable("kdtEntrys").getCell(rowIndex,"taxPrice").setValue(taxPrice);

		KDTEditEvent editEvent=new KDTEditEvent(param.getKDTable("kdtEntrys"), null, taxPrice, rowIndex, param.getKDTable("kdtEntrys").getCell(rowIndex,"taxPrice").getColumnIndex(), false, 1);

		ui.kdtEntrys_Changed(rowIndex,colIndex);
	}

	/**
	 * ���ָ���е�  ������λ�ͻ���������λ��Ļ���ϵ��
	 * @param param
	 * @param rowIndex
	 * @param colIndex
	 * @return ��� ������λ�ͻ���������λ��һ��Ϊ���򷵻�0�����򷵻����Ǽ��ɼ�����λ����Ϊ����������λ��ϵ��
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private BigDecimal getExchangeRate(UIParam param,int rowIndex) throws BOSException, EASBizException{
		ui = (SaleReturnsEditUIPIEx) param.getUI();
		editData = (SaleReturnsInfo) ui.getEditData();

		BigDecimal exchangeRate = new BigDecimal("1.00");
		MaterialInfo materialInfo = (MaterialInfo) param.getKDTable("kdtEntrys").getCell(rowIndex,"material").getValue();
		MeasureUnitInfo unitInfo = (MeasureUnitInfo)param.getKDTable("kdtEntrys").getCell(rowIndex,"unit").getValue();
		MeasureUnitInfo baseUnitInfo = (MeasureUnitInfo)param.getKDTable("kdtEntrys").getCell(rowIndex,"baseUnit").getValue();
		if(unitInfo != null && baseUnitInfo != null && materialInfo!= null){
			String materialID = materialInfo.getId().toString();
			IMultiMeasureUnit multiUnit = MultiMeasureUnitFactory.getRemoteInstance();

			//				MultiMeasureUnitInfo multiUnifInfo = multiUnit.getMultiUnit(materialID, baseUnitInfo.getId().toString());

			MultiMeasureUnitInfo othermultiUnifInfo = multiUnit.getMultiUnit(materialID, unitInfo.getId().toString());

			if ((othermultiUnifInfo != null)) {

				//					BigDecimal baseExchangeRate1 = multiUnifInfo.getBaseConvsRate();
				exchangeRate= othermultiUnifInfo.getBaseConvsRate();
				//					if (baseExchangeRate1 == null) {
				//						baseExchangeRate1 = new BigDecimal("1.00");
				//					}
				if (exchangeRate == null) {
					exchangeRate = new BigDecimal("1.00");
				}

			}

		}
		return exchangeRate;
	}


	/**************************************����������߼�  wgj 20150804 end***************************************************/

	/**
	 * �����˻����뵥���ӹ���
	 * @throws BOSException 
	 * @throws DataAccessException 
	 */
	public void afterLoadFields(UIParam param) throws DataAccessException, BOSException {
		if(param.getKDBizPromptBox("prmtsaleOrgUnit").getValue()!=null){
			param.getKDBizPromptBox("prmtsaleCustomer").getQueryInfo();
			param.getKDBizPromptBox("prmtsaleCustomer").setCommitFormat("$name$");
			String saleOrgUnitID = UIRuleUtil.getProperty((IObjectValue) param.getKDBizPromptBox("prmtsaleOrgUnit").getValue(),"id").toString();
			HashSet<String> set=new HashSet<String>();
			EntityViewInfo evis=new EntityViewInfo();
			FilterInfo filters=new FilterInfo();
			filters.getFilterItems().add(new FilterItemInfo("saleOrgUnit",saleOrgUnitID,CompareType.EQUALS));
			evis.setFilter(filters);
			CustomerSaleInfoCollection coll = CustomerSaleInfoFactory.getRemoteInstance().getCustomerSaleInfoCollection(evis);
			for(int i=0;i<coll.size();i++){
				set.add((UIRuleUtil.getProperty(coll.get(i).getCustomer(),"id").toString()));
			}
			EntityViewInfo evi=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("id",set,CompareType.INCLUDE));
			evi.setFilter(filter);
			param.getKDBizPromptBox("prmtsaleCustomer").setEntityViewInfo(evi);

		}
	}
	/**
	 * ��¼�����¼�
	 * @param param
	 */
	public void afterLoadListener(final UIParam param){
		param.getKDTable("kdtEntrys").addKDTEditListener(new KDTEditAdapter(){

			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);
				if("qty".equals(param.getKDTable("kdtEntrys").getColumnKey(e.getColIndex()))){
					param.getKDTable("kdtEntrys").getCell(e.getRowIndex(), "roadLossQty").setValue(UIRuleUtil.getInt(param.getKDTable("kdtEntrys").getCell(e.getRowIndex(), "qty").getValue())/100);
				}
				if("qty".equals(param.getKDTable("kdtEntrys").getColumnKey(e.getColIndex()))||"roadLossQty".equals(param.getKDTable("kdtEntrys").getColumnKey(e.getColIndex()))||"otherQty".equals(param.getKDTable("kdtEntrys").getColumnKey(e.getColIndex()))){
					param.getKDTable("kdtEntrys").getCell(e.getRowIndex(), "actualQty").setValue(UIRuleUtil.getInt(param.getKDTable("kdtEntrys").getCell(e.getRowIndex(), "qty").getValue())+UIRuleUtil.getInt(param.getKDTable("kdtEntrys").getCell(e.getRowIndex(), "roadLossQty").getValue())+UIRuleUtil.getInt(param.getKDTable("kdtEntrys").getCell(e.getRowIndex(), "otherQty").getValue()));
				}
			}
			
		});
	}
}
