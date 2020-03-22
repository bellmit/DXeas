/**
 * output package name
 */
package com.kingdee.eas.custom.lhsm.client;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.commUtils;

/**
 * output class name
 */
public class SaleConditionsEditUI extends AbstractSaleConditionsEditUI
{
	public SaleConditionsEditUI() throws Exception {
		super();
	}

	private static final Logger logger = CoreUIObject.getLogger(SaleConditionsEditUI.class);


	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		initUI();
		kdtAREntry_detailPanel.getAddNewLineButton().setVisible(false);
		kdtAREntry_detailPanel.getInsertLineButton().setVisible(false);
		kdtAREntry_detailPanel.getRemoveLinesButton().setVisible(false);
		kdtEntry_detailPanel.getAddNewLineButton().setVisible(false);
		kdtEntry_detailPanel.getInsertLineButton().setVisible(false);
		kdtEntry_detailPanel.getRemoveLinesButton().setVisible(false);
	}


	private void initUI() {
		// TODO Auto-generated method stub
		kdtEntry.getColumn("seq").getStyleAttributes().setHided(true);
		kdtAREntry.getColumn("seq").getStyleAttributes().setHided(true);
		prmtuser.setEnabled(false);
		if(kdtAREntry.getRowCount()==0){
			addArBillCondition();
			}
	}



	@Override
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionEdit_actionPerformed(e);
		prmtuser.setEnabled(false);
	}


	@Override
	public void loadFields() {
		// TODO Auto-generated method stub
		super.loadFields();
	}



	/**
	 * 销售预报单 默认字段
	 */
	private void addSaleForecastCondition() {
		String[] conditionArray = {
				"单号","每年","购货客户","结账客户","物料","单据状态","订货时间","销售部门",
				"仓库","配送方式","规格","辅数量","辅单位","单价","价内费用","销售净价","金额","政策单价",
				"摘要","订单数量","备注"
		};

		String[] fieldArray = {
				"number","year(bizDate)","customer.name","salecustomer.name","entrys.materialname","state","bizDate","department.name",
				"entrys.warehouse.name","wayoftakingdelivery","entrys.model","entrys.assistunitqty",
				"entrys.assistunit.name","entrys.price","entrys.internalcost",
				"entrys.suttleprice","entrys.amount","entrys.srcprice","description","entrys.qty","entrys.remark"
		};

		String[] defaultArray = {
				"customer.name","salecustomer.name","state","bizDate"
		};

		String[] sqlArray = {
				"","",
				"select distinct t2.FID,t2.FName_l2 fname,t2.FNumber from CT_LHS_SaleForecast t1 inner join T_BD_Customer  t2 on t2.FID=t1.CFCustomerID where t2.Fname_l2 like '%%'  order by t2.FNumber",
				"select distinct t2.FID,t2.FName_l2 fname,t2.FNumber from CT_LHS_SaleForecast t1 inner join T_BD_Customer  t2 on t2.FID=t1.FSaleCustomerID where t2.Fname_l2 like '%%'  order by t2.FNumber",
				"select distinct t3.FID,t3.FName_l2 fname,t3.FNumber sto from CT_LHS_SaleForecast t1 inner join CT_LHS_SaleForecastEntry   t2 on t1.FID=t2.FParentID inner join T_BD_Material   t3 on t3.FID=t2.CFMaterialNumberID where t3.Fname_l2 like '%%'  order by t3.FNumber",
				"","",
				"select t2.FID,t2.FName_l2 fname,t2.FNumber from CT_LHS_SaleForecast t1 inner join T_ORG_Admin   t2 on t2.FID=t1.FDEPARTMENTID where t2.Fname_l2 like '%%'  order by t2.FNumber",
				"select distinct t3.FID,t3.FName_l2 fname,t3.FNumber,t4.FName_l2 sto from CT_LHS_SaleForecast t1 inner join CT_LHS_SaleForecastEntry   t2 on t1.FID=t2.FParentID inner join T_DB_WAREHOUSE             t3 on t3.FID=t2.FWareHouseID inner join T_ORG_Storage              t4 on t4.FID=t3.FstorageOrgID where t3.Fname_l2 like '%%'  order by t3.FNumber",
				"","","",
				"select distinct t3.FID,t3.FName_l2 fname,t3.FNumber from CT_LHS_SaleForecast t1 inner join CT_LHS_SaleForecastEntry   t2 on t1.FID=t2.FParentID inner join T_BD_MeasureUnit             t3 on t3.FID=t2.FAssistUnitID  where t3.Fname_l2 like '%%'  order by t3.FNumber",
				"","","","","","","",""
		};


		IRow newRow;
		for(int i = 0;i < conditionArray.length;i++){
			newRow = kdtEntry.addRow();
			newRow.getCell("condition").setValue(conditionArray[i]);
			if(commUtils.arrayListContainsElement(fieldArray[i], defaultArray))
				newRow.getCell("choose").setValue(true);
			else
				newRow.getCell("choose").setValue(false);
			newRow.getCell("fieldName").setValue(fieldArray[i]);
			newRow.getCell("sqlString").setValue(sqlArray[i]);
		}
	}



	/**
	 * 应收单 默认字段
	 */
	private void addArBillCondition() {
		String[] conditionArray = {
				"单号","每年","往来户","购货客户","物料","单据状态","销售部门",
				"仓库","规格","辅数量","辅单位","单价","金额","政策单价","已开金额","赠品","折扣","折扣金额",
				"摘要","订单数量","备注"
		};

		String[] fieldArray = {
				"number","year(bizDate)","asstActName","entry.ordCustName","material.name","billStatus","saleGroup.name",
				"Warehouse.name","material.model","entrys.assistunitqty",
				"entrys.assistunit.name","entrys.price","totalAmount","entrys.srcprice","entry.invoicedAmt",
				"entrys.isPresent","entry.discountType","entry.discountAmount","abstractName","entry.qty","entrys.remark"
		};

		String[] defaultArray = {
				"entry.ordCustName","billStatus","bizDate"
		};

		String[] sqlArray = {
				"","",
				"",
				"",
				"",
				"","",
				"",
				"",
				"","","",
				"",
				"","","","","","","",""
		};


		IRow newRow;
		for(int i = 0;i < conditionArray.length;i++){
			newRow = kdtAREntry.addRow();
			newRow.getCell("condition").setValue(conditionArray[i]);
			if(commUtils.arrayListContainsElement(fieldArray[i], defaultArray))
				newRow.getCell("choose").setValue(true);
			else
				newRow.getCell("choose").setValue(false);
			newRow.getCell("fieldName").setValue(fieldArray[i]);
			newRow.getCell("sqlString").setValue(sqlArray[i]);
		}
	}



	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		if(oprtState.equals("ADDNEW")){
			addSaleForecastCondition();
		}
	}

	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.lhsm.SaleConditionsInfo objectValue = new com.kingdee.eas.custom.lhsm.SaleConditionsInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setUser(SysContext.getSysContext().getCurrentUserInfo());
		return objectValue;
	}

}