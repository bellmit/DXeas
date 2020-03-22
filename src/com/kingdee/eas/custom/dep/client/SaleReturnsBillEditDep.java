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
 * 销售退货申请单 编辑 dep
 * @author Administrator
 *
 */
public class SaleReturnsBillEditDep {

	// 编辑界面
	protected SaleReturnsEditUIPIEx ui;
	// 界面 对象
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
	 * 旧折让代码
	 */
	//	public void calLz(UIParam param) throws EASBizException, BOSException, SQLException {
	//		ui = (SaleReturnsEditUIPIEx) param.getUI();
	//		editData = (SaleReturnsInfo) ui.getEditData();
	//		
	//		CompanyOrgUnitInfo companyInfo = (CompanyOrgUnitInfo) SysContext.getSysContext().getCurrentFIUnit(); // 当前财务组织
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




	/**************************************新折让添加逻辑  wgj 20150804 begin*************************************************/

	/**
	 * 初始化
	 */
	public void afterOnload(UIParam param) throws Exception {
		ui = (SaleReturnsEditUIPIEx) param.getUI();
		editData = (SaleReturnsInfo) ui.getEditData();

		ui.setCuid(SysContext.getSysContext().getCurrentStorageUnit().getId().toString());

		boolean isEnableXXWDiscount = DiscountFacadeFactory.getRemoteInstance().isEnableDiscount(ui.getCuid());
		ui.setEnableXXWDiscount(isEnableXXWDiscount);


		// 江苏项目 添加 如果属于折让公司列表  则设置分录全部不可编辑
		IDiscountFacade discountFacade = DiscountFacadeFactory.getRemoteInstance();
		// 只有启用折让的公司才进行控制
		if(ui.isEnableXXWDiscount()){
			// 禁用复制按钮
			param.getKDWorkButton("btnCopy").setVisible(false);
			// 获取折让公司
			DiscountCompanyInfo dsCompanyInfo = discountFacade.getCompanyDSSet(ui.getCuid());
			ui.setDiscountCompanyInfo(dsCompanyInfo);
			//  只要在折让组织列表中 就停用分录编辑   只可以录入数量盒物料
			if(dsCompanyInfo != null){
				KDTable kdtEntry = param.getKDTable("kdtEntrys");
				int columnCount = kdtEntry.getColumnCount();
				// 设置除了物料和 未折扣数量外 所有列 均不可编辑
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


				//	    		// 获取 单据已经保存的折让记录日志
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
	 * 根据系统设置在提交前校验 客户余额、库存
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public void checkBeforeSubmit(UIParam param) throws BOSException, EASBizException{
		ui = (SaleReturnsEditUIPIEx) param.getUI();
		editData = (SaleReturnsInfo) ui.getEditData();

		CompanyOrgUnitInfo companyInfo = SysContext.getSysContext().getCurrentFIUnit();
		if(companyInfo != null){
			// 参数是否 启用物料库存校验
			boolean isCheckMaterialInventory = DiscountFacadeFactory.getRemoteInstance().isCheckMaterialInventory(companyInfo.getId().toString());

			boolean isEnableDiscount = DiscountFacadeFactory.getRemoteInstance().isEnableDiscount(companyInfo.getId().toString());
			if(isEnableDiscount){
				SaleOrgUnitInfo sou = (SaleOrgUnitInfo) param.getKDBizPromptBox("prmtStorageOrgUnit").getValue();
				// map暂存  库存信息 
				Map<String, MaterialInventoryInfo> mapMaterialInventory = new HashMap<String, MaterialInventoryInfo>();

				// 逐个分录 获取物料数量   然后 跟库存比较 {
				KDTable table = param.getKDTable("kdtEntrys");
				for(int i = 0 ; i < table.getRowCount(); i++){

					MaterialInfo materialInfo = (MaterialInfo) table.getRow(i).getCell("material").getValue();
					BigDecimal baseQtyO = (BigDecimal) table.getRow(i).getCell("baseQty").getValue();
					MeasureUnitInfo baseUnitO = (MeasureUnitInfo) table.getRow(i).getCell("baseUnit").getValue();
					WarehouseInfo warehouseInfo = (WarehouseInfo) table.getRow(i).getCell("warehouse").getValue();

					if(warehouseInfo == null){
						MsgBox.showInfo("分录中存在 仓库为空的分录");
						SysUtil.abort();
					}


					BigDecimal fxDiscount=(BigDecimal)table.getRow(i).getCell("FxDSAmount").getValue();
					if(fxDiscount != null && fxDiscount.compareTo(new BigDecimal("0")) != 0){
						CustomerInfo parentCustomer = (CustomerInfo)editData.getObjectValue("customerb");
						if(parentCustomer == null){
							MsgBox.showError("分销上级客户不能为空，请维护当前订单客户的上级客户后再提交订单");
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
			//			        	 * 修改原因：Bug：BT514726，信用额度分析报表，当选择“按业务分析码进行分析”时，统计显示了业务分析码中供应商的数据正确的应该是，当选择“按业务分析码进行分析”时，只统计业务分析码的数据，而不显示业务分析码中供应商和客户的数据
			//			        	 * 修改人：雷莉敏	2011-02-22
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
			//			               	BigDecimal FUnArBillOrderAmt = rs.getBigDecimal("FUnArBillOrderAmt");  // 已审核未应收订单金额
			//			               	BigDecimal UsedAmount =  rs.getBigDecimal("UsedAmount");
			//			               	BigDecimal FUnAuditPostBillAmt =  rs.getBigDecimal("FUnAuditPostBillAmt");
			//			               	BigDecimal FUnArBillIssuedAmt =  rs.getBigDecimal("FUnArBillIssuedAmt");
			//			            	BigDecimal FUnAuditIssuedAmt =  rs.getBigDecimal("FUnAuditIssuedAmt");
			//			            	BigDecimal FUnOutPostBillAmt =  rs.getBigDecimal("FUnOutPostBillAmt");
			//			            	BigDecimal FUnOutSaleReturnsBillAmt =  rs.getBigDecimal("FUnOutSaleReturnsBillAmt");
			//			               	
			//			            	BigDecimal CreditBalance =  rs.getBigDecimal("CreditBalance");    // 信用余额
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
	 * 更新挂账金额
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
		// 现金
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
		// 通存通兑
		BigDecimal txtntfTongcunTongdui = param.getKDFormattedTextField("txtntfTongcunTongdui").getBigDecimalValue();
		if(txtntfTongcunTongdui == null){
			txtntfTongcunTongdui = new BigDecimal("0");
		}
		txtntfTongcunTongdui = txtntfTongcunTongdui.divide(new BigDecimal("1"),2,RoundingMode.HALF_UP);
		param.getKDFormattedTextField("txtntfTongcunTongdui").setValue(txtntfTongcunTongdui);
		param.getKDFormattedTextField("txtntfGuaZhang").setValue(txtTotalTaxAmount.subtract(txtntfCash).subtract(txtntfPos).subtract(txtntfTongcunTongdui));
	}


	/**
	 * 分录更新
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
				MsgBox.showInfo("客户不能为空！");
				return;
			}
			MaterialInfo FMaterialInfo=(MaterialInfo)param.getKDTable("kdtEntrys").getRow(rowIndex).getCell("material").getValue();
			CustomerInfo info = (CustomerInfo)  param.getKDBizPromptBox("prmtreturnsCustomer").getData();

		}

		// 折让逻辑   录入物料和折扣前数量后 重新计算 单价 数量金额等字段
		if(ui.isEnableXXWDiscount() && ui.getDiscountCompanyInfo() != null ){
			DiscountCompanyInfo dsCompanyInfo = ui.getDiscountCompanyInfo();
			IDiscountFacade discountFacade = DiscountFacadeFactory.getRemoteInstance();
			// 销售组织
			SaleOrgUnitInfo currSaleOrgUnitInfo =  (SaleOrgUnitInfo) param.getKDBizPromptBox("prmtsaleOrgUnit").getData();
			if(currSaleOrgUnitInfo == null){
				MsgBox.showInfo("请先选择销售组织");
				return;
			}
			// 客户
			CustomerInfo currCustomerInfo =  (CustomerInfo)  param.getKDBizPromptBox("prmtreturnsCustomer").getData();
			if(currCustomerInfo == null){
				MsgBox.showInfo("请先选择退货客户");
				return;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date bizDate = param.getKDDatePicker("bizDate").getSqlDate();
			if(bizDate == null){
				MsgBox.showInfo("请先选择业务日期");
				return;
			}
			// 物料更新时 同时获得基本单价
			// 更新分录金额等数据
			if("material".equalsIgnoreCase(fieldName) ){
				//	        		updateEntryInfoByBasePriceAndNoDSQty(param,param.getKDTable("kdtEntrys"),currSaleOrgUnitInfo,currCustomerInfo,rowIndex);

			}


			if("NoDSQty".equalsIgnoreCase(fieldName) ){
				updateEntryInfoByBasePriceAndNoDSQty(param,param.getKDTable("kdtEntrys"),currSaleOrgUnitInfo,currCustomerInfo,rowIndex);
			}



			// 所有操作完成后重新设置 只有物料和未折让数量可编辑
			KDTable kdtEntry = param.getKDTable("kdtEntrys");
			int columnCount = kdtEntry.getColumnCount();
			// 设置除了物料和 未折扣数量外 所有列 均不可编辑
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
	 * 删除分录后 更新
	 * @param param
	 * @throws Exception
	 */
	public void afterRemoveEntry(UIParam param) throws Exception{

		ui = (SaleReturnsEditUIPIEx) param.getUI();
		editData = (SaleReturnsInfo) ui.getEditData();
		// 只有启用 折让管理的 公司才进行处理
		if(ui.isEnableXXWDiscount() && ui.getDiscountCompanyInfo() != null ){
			// 已经保存过的订单  分录删除后 要更新 后台 折让计算日志
			if(editData.getId() != null){
				// 分录删除后  同时将折让日志中  的相关数据  清除
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
			// 销售组织
			SaleOrgUnitInfo currSaleOrgUnitInfo =  (SaleOrgUnitInfo) param.getKDBizPromptBox("prmtsaleOrgUnit").getData();
			if(currSaleOrgUnitInfo == null){
				MsgBox.showInfo("请先选择销售组织");
				return;
			}
			// 客户
			CustomerInfo currCustomerInfo =  (CustomerInfo)  param.getKDBizPromptBox("prmtreturnsCustomer").getData();
			if(currCustomerInfo == null){
				MsgBox.showInfo("请先选择退货客户");
				return;
			}

			updateEntryInfoByBasePriceAndNoDSQty(param,param.getKDTable("kdtEntrys"),currSaleOrgUnitInfo,currCustomerInfo,0);


		}


	}

	/**
	 * 根据 基本含税单价 和 实物折扣前数量更新分录   及各种折扣数据
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
		// 当前订单id
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

		// 所有分录重算
		for(int ii = 0; ii < kdtEntry.getRowCount(); ii++){

			Object nodsQtyObj =  param.getKDTable("kdtEntrys").getCell(ii,"NoDSQty").getValue();

			BigDecimal noDSQty = new BigDecimal("0");
			if(nodsQtyObj != null){
				Class class1 = nodsQtyObj.getClass();
				if(String.class.isInstance(nodsQtyObj)){
					try{
						noDSQty = new BigDecimal((String)nodsQtyObj);
					}catch(Exception nfe){
						MsgBox.showInfo("不含实物折扣数量必须录入数字");
						return;
					}

				}else if(BigDecimal.class.isInstance(nodsQtyObj)){
					noDSQty = (BigDecimal)nodsQtyObj;
				}
			}else{
				return;
			}


			if(noDSQty.compareTo(new BigDecimal("0")) <= 0){
				MsgBox.showInfo("不含实物折扣数量必须大于0");
				return;
			}


			rowIndex = ii;
			// 重算前 先清理分录
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
				MsgBox.showInfo("请先选择物料");
				continue;
			}
			// 后台计算接口
			IDiscountFacade discountFacade = DiscountFacadeFactory.getRemoteInstance();
			// 折让计算日志 
			//				List discountLogs = new ArrayList();

			String materialID = material.getId().toString();
			// 订单数量，只是为了取价格政策而设置的
			BigDecimal orderQty = new BigDecimal("10");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date bizDate = param.getKDDatePicker("bizDate").getSqlDate();
			if(bizDate == null){
				MsgBox.showInfo("请先选择业务日期");
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
				// 没有维护基本价格的话则  设置价格为 0 然后提示用户

				MsgBox.showInfo("物料没有维护基本价格，请先维护价格政策");
				return;
			}




			BigDecimal coefficient = unit.getCoefficient();
			if(coefficient == null) coefficient = new BigDecimal("1");


			String bizDateStr = sdf.format(bizDate);

			DiscountCompanyInfo dsCompanyInfo = ui.getDiscountCompanyInfo();

			if(basePrice != null && noDSQty != null){
				// 填入不含实物折扣数量，完成后系统首先根据基本价格（不含数量*基本价格=折扣前总金额），计算出折扣前总金额写入分录【折扣前总金额】列
				BigDecimal noDSAmount = basePrice.multiply(noDSQty);
				param.getKDTable("kdtEntrys").getCell(rowIndex,"NoDSAmount").setValue(noDSAmount);

				// 厂价金额 = 实物折扣金额+折让前总金额
				BigDecimal baseAmount = new BigDecimal("0");
				baseAmount = baseAmount.add(noDSAmount);

				// 销售净额   厂价金额 减掉所有的折扣金额
				BigDecimal netAmount = new BigDecimal("0");
				netAmount = netAmount.add(noDSAmount);
				/************************************************************************************************************************/
				// 计算实物折扣后的数量
				BigDecimal qty = noDSQty;


				// 获得 比当前行 靠前的数据 的物料销量
				Map<String,BigDecimal> otherRowsQty = getOtherEntryMaterialQty(param.getKDTable("kdtEntrys"),ii);
				// 实物 折扣 
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

						// 将计算日志暂存在内存中

						//							discountLogs.addAll(swDiscountQty.getDiscountLogInfos());
					}
				}
				// 增加实物折扣数量后的 数量
				param.getKDTable("kdtEntrys").getCell(rowIndex,"qty").setValue(qty);

				KDTEditEvent editEvent=new KDTEditEvent(param.getKDTable("kdtEntrys"), null, qty, rowIndex, param.getKDTable("kdtEntrys").getCell(rowIndex,"qty").getColumnIndex(), false, 1);
				ui.kdtEntrys_editStopped(editEvent);
				//					ui.kdtEntrys_Changed(rowIndex,param.getKDTable("kdtEntrys").getCell(rowIndex,"qty").getColumnIndex());
				/************************************************************************************************************************/
				// 立折折扣 
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
						// 折扣前总金额-立折金额=总金额
						amount = amount.subtract((BigDecimal) lizheDiscountAmount.getReturnObj());
						String message = lizheDiscountAmount.getMessage();

						param.getKDTable("kdtEntrys").getCell(rowIndex,"LzAmount").setValue(lizheDiscountAmount.getReturnObj());

						param.getKDTable("kdtEntrys").getCell(rowIndex,"LzExpression").setValue(message);
						netAmount = netAmount.subtract((BigDecimal) lizheDiscountAmount.getReturnObj());
						// 将计算日志暂存在内存中
						//							discountLogs.addAll(lizheDiscountAmount.getDiscountLogInfos());
					}

				}
				param.getKDTable("kdtEntrys").getCell(rowIndex,"taxAmount").setValue(amount);
				param.getKDTable("kdtEntrys").getCell(rowIndex,"amount").setValue(amount);
				param.getKDTable("kdtEntrys").getCell(rowIndex,"localAmount").setValue(amount);
				// 根据 总金额和 数量 计算出 单价  金额/数量=实际含税单价
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
				// 月折折扣 
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
						// 折扣前总金额-立折金额=总金额
						//					amount = amount.subtract(yueDiscountAmount.getReturnObj());
						String message = yueDiscountAmount.getMessage();

						param.getKDTable("kdtEntrys").getCell(rowIndex,"MonthDSAmount").setValue(yueDiscountAmount.getReturnObj());

						param.getKDTable("kdtEntrys").getCell(rowIndex,"MonthDSExpression").setValue(message);

						netAmount = netAmount.subtract((BigDecimal) yueDiscountAmount.getReturnObj());
						// 将计算日志暂存在内存中
						//							discountLogs.addAll(yueDiscountAmount.getDiscountLogInfos());
					}

				}
				/************************************************************************************************************************/
				// 年折折扣 
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
						// 折扣前总金额-立折金额=总金额
						//					amount = amount.subtract(yearDiscountAmount.getReturnObj());
						String message = yearDiscountAmount.getMessage();

						param.getKDTable("kdtEntrys").getCell(rowIndex,"YearDSAmount").setValue(yearDiscountAmount.getReturnObj());

						param.getKDTable("kdtEntrys").getCell(rowIndex,"YearDSExpression").setValue(message);

						netAmount = netAmount.subtract((BigDecimal) yearDiscountAmount.getReturnObj());
						// 将计算日志暂存在内存中
						//							discountLogs.addAll(yearDiscountAmount.getDiscountLogInfos());
					}

				}
				/************************************************************************************************************************/
				// 分销折扣 
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
						// 折扣前总金额-立折金额=总金额
						//					amount = amount.subtract(yearDiscountAmount.getReturnObj());
						String message = fxDiscountAmount.getMessage();

						param.getKDTable("kdtEntrys").getCell(rowIndex,"FxDSAmount").setValue(fxDiscountAmount.getReturnObj());

						param.getKDTable("kdtEntrys").getCell(rowIndex,"FxDSExpression").setValue(message);

						netAmount = netAmount.subtract((BigDecimal) fxDiscountAmount.getReturnObj());
						// 将计算日志暂存在内存中
						//							discountLogs.addAll(fxDiscountAmount.getDiscountLogInfos());
					}

				}

				if(param.getKDTable("kdtEntrys").getRow(rowIndex).getCell("NetSaleAmount") != null){
					param.getKDTable("kdtEntrys").getCell(rowIndex,"NetSaleAmount").setValue(netAmount);
				}
				//					// 将计算日志暂存在ui  记录中
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
	 * 获得除当前行之前行 其他行的 物料数量 map 
	 * key 
	 * @param entrySeq
	 * @return
	 */
	private Map<String,BigDecimal> getOtherEntryMaterialQty(KDTable kdtEntry, int entrySeq){
		Map<String,BigDecimal> qtyMap = new HashMap<String, BigDecimal>();

		// 所有分录重算
		for(int ii = 0; ii < kdtEntry.getRowCount(); ii++){
			if(ii < entrySeq){
				// 获得不含实物折扣数量
				Object nodsQtyObj =  kdtEntry.getCell(ii,"NoDSQty").getValue();
				MaterialInfo material = (MaterialInfo) kdtEntry.getCell(ii,"material").getValue();
				// 获得不含实物折扣数量
				BigDecimal noDSQty = new BigDecimal("0");
				if(nodsQtyObj != null){
					Class class1 = nodsQtyObj.getClass();

					if(String.class.isInstance(nodsQtyObj)){
						try{
							noDSQty = new BigDecimal((String)nodsQtyObj);



						}catch(Exception nfe){
							nfe.printStackTrace();
							//							com.kingdee.eas.util.client.MsgBox.showInfo("不含实物折扣数量必须录入数字");
							//							continue;
						}

					}else if(BigDecimal.class.isInstance(nodsQtyObj)){
						noDSQty = (BigDecimal)nodsQtyObj;
					}
				}
				// 如果分录不含实物折扣数量为 0 则忽略该行
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
	 * 折让计算日志 将分录id或者  seq设置到日志中 
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
		// 订单分录折让前数量  换算成吨
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
		// 首先把 list中 orderentryseq相同的数据删除
		for(int i = 0; i < allDiscountLogs.size(); i++){
			DiscountGridLogEntryInfo gridLogEntryInfo = (DiscountGridLogEntryInfo) allDiscountLogs.get(i);
			if(gridLogEntryInfo != null && gridLogEntryInfo.getOrderEntrySeq() == seq){
				allDiscountLogs.remove(i);
				i--;
			}
		}
		// 新的日志加到总的日志中
		allDiscountLogs.addAll(discountLogs);
		ui.setDiscountLogs(allDiscountLogs);

	}
	/**
	 * 根据基本含税单价计算单价和其他字段
	 * @param param
	 * @param rowIndex
	 * @param colIndex
	 * @throws Exception 
	 */
	private void updatePrice(UIParam param,int rowIndex, int colIndex) throws Exception {

		ui = (SaleReturnsEditUIPIEx) param.getUI();
		editData = (SaleReturnsInfo) ui.getEditData();

		BigDecimal basePrice = (BigDecimal)param.getKDTable("kdtEntrys").getCell(rowIndex,"basePrice").getValue();
		// 获得转换系数
		BigDecimal exchangeRate = getExchangeRate(param,rowIndex);

		BigDecimal taxPrice = basePrice.multiply(exchangeRate);
		// 设置基本含税单价
		param.getKDTable("kdtEntrys").getCell(rowIndex,"taxPrice").setValue(taxPrice);

		// 增加实物折扣数量后的 数量
		param.getKDTable("kdtEntrys").getCell(rowIndex,"taxPrice").setValue(taxPrice);

		KDTEditEvent editEvent=new KDTEditEvent(param.getKDTable("kdtEntrys"), null, taxPrice, rowIndex, param.getKDTable("kdtEntrys").getCell(rowIndex,"taxPrice").getColumnIndex(), false, 1);

		ui.kdtEntrys_Changed(rowIndex,colIndex);
	}

	/**
	 * 获得指定行的  计量单位和基本计量单位间的换算系数
	 * @param param
	 * @param rowIndex
	 * @param colIndex
	 * @return 如果 计量单位和基本计量单位有一个为空则返回0，否则返回他们间由计量单位换算为基本计量单位的系数
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


	/**************************************新折让添加逻辑  wgj 20150804 end***************************************************/

	/**
	 * 销售退货申请单增加过滤
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
	 * 分录增加事件
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
