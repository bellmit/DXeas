/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.contract.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.bdm.bdapply.ISupplierReq;
import com.kingdee.eas.bdm.bdapply.SupplierReqFactory;
import com.kingdee.eas.bdm.bdapply.SupplierReqInfo;
import com.kingdee.eas.bdm.bdapply.bdaApplyBillStatus;
import com.kingdee.eas.bdm.bdapply.util.BaseDataHandleUtil;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.taihe.contract.BatchContractFactory;
import com.kingdee.eas.custom.taihe.contract.BatchContractInfo;
import com.kingdee.eas.custom.taihe.contract.IBatchContract;
import com.kingdee.eas.custom.wlhllicensemanager.DynamicFacadeFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * output class name
 */
public class BatchContractListUI extends AbstractBatchContractListUI
{
    private static final Logger logger = CoreUIObject.getLogger(BatchContractListUI.class);
    
    /**
     * output class constructor
     */
    public BatchContractListUI() throws Exception
    {
        super();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output tblMain_tableClicked method
     */
    protected void tblMain_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
        super.tblMain_tableClicked(e);
    }

    /**
     * output tblMain_tableSelectChanged method
     */
    protected void tblMain_tableSelectChanged(com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent e) throws Exception
    {
        super.tblMain_tableSelectChanged(e);
    }

    /**
     * output menuItemImportData_actionPerformed method
     */
    protected void menuItemImportData_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.menuItemImportData_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.taihe.contract.BatchContractFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.taihe.contract.BatchContractInfo objectValue = new com.kingdee.eas.custom.taihe.contract.BatchContractInfo();
		
        return objectValue;
    }
/*    @Override
	protected FilterInfo getDefaultFilterForQuery() {
		String companyID="";
		if(SysContext.getSysContext().getCurrentFIUnit()!=null) {
			companyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		}
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
		return filter;
	}*/
    protected boolean isNeedQuickQueryFilter() {
    	return true;
    }
	@Override
	protected FilterInfo getDefaultFilterForQuery() {
		String companyID="";
		FilterInfo filter=new FilterInfo();
		if(SysContext.getSysContext().getCurrentFIUnit()!=null) {
			companyID=SysContext.getSysContext().getCurrentFIUnit().getLongNumber();
			filter.getFilterItems().add(new FilterItemInfo("company.id","select fid from t_org_company where flongnumber like '"+companyID+"%'",CompareType.INNER));
		}else{
			filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
		}
		return filter;
	}
   public void actionAllAudit_actionPerformed(ActionEvent e) throws Exception {
    	checkSelected();
		ArrayList ids = getSelectedIdValues();
		String number = "";
		IBatchContract is = BatchContractFactory.getRemoteInstance();
		BatchContractInfo info ;
		for (int i = 0; i < ids.size(); ++i) {
			if (ids.get(i) == null)
				continue;
			info = is.getBatchContractInfo(new ObjectUuidPK(ids.get(i).toString()));
			//if (info.getBillStatus().equals(bdaApplyBillStatus.Audit)|| info.getBillStatus().equals(bdaApplyBillStatus.unAudit)) {// 已经审核或审核不通过
			//操作已经提交的单据
			
			if (info.getBillStatus()!=BillBaseStatusEnum.SUBMITED||supplierContract(info)) {
				if (StringUtils.isNotBlank(number)) 
					number +=",";
				if (StringUtils.isNotBlank(info.getNumber())) {
					number += info.getNumber();
				}
				else {
					number +="选择的第"+(i+1)+"行";
				}
			} else {
				is.audit(info);
			}
		}
        if(StringUtils.isBlank(number)){
        	MsgBox.showInfo("批量审核成功！");
        }else{
        	MsgBox.showError(number+"\n非提交状态单据或保证金不足，审核不通过！");
        }
        refresh(e);
	}
   //判断供应商保证金
   private boolean supplierContract(BatchContractInfo binfo){
	   BatchContractInfo info = binfo;
		//保证金正数
		StringBuffer beforePositive = new StringBuffer();
		beforePositive.append("/*dialect*/ select nvl(sum(CFPayAmount),0)	moneys from CT_CON_BailAmount where  CFMoneytypes= '0' and FcompanyID = '")
		.append(info.getCompany().getId())
		.append("' and FBillStatus = '4' and CFpartyBID = '")
		.append(info.getSupplier().getId())
		.append("'");
		//保证金负数
		StringBuffer beforeNegative = new StringBuffer();
		beforeNegative.append("/*dialect*/ select nvl(sum(CFPayAmount),0)	moneys from CT_CON_BailAmount where  CFMoneytypes <> '0' and FcompanyID = '")
		.append(info.getCompany().getId())
		.append("' and FBillStatus = '4' and CFpartyBID = '")
		.append(info.getSupplier().getId())
		.append("'");
		//供应商所有批次合同之和
		StringBuffer supplier = new StringBuffer();
		supplier.append("/*dialect*/ select nvl(sum(CFRECEIVEAMT),0) moneys from CT_CON_BatchContract where CFWHETHERCLOSE = '0' and CFSupplierID = '")
		.append(info.getSupplier().getId())
		.append("' and CFCompanyID = '")
		.append(info.getCompany().getId())
		.append("' and FBillStatus = '4'");
			try {
			IRowSet rsPositive = SQLExecutorFactory.getRemoteInstance(beforePositive.toString()).executeSQL();
			IRowSet rsNegative = SQLExecutorFactory.getRemoteInstance(beforeNegative.toString()).executeSQL();
			IRowSet rsSupplier = SQLExecutorFactory.getRemoteInstance(supplier.toString()).executeSQL();
			BigDecimal bdPositive = null ;
			BigDecimal bdNegative = null ;
			BigDecimal bdSupplier = null ;
			
				if(rsPositive.next()){
					bdPositive=new BigDecimal(rsPositive.getString("moneys")); 
				}
				if(rsNegative.next()){
					bdNegative=new BigDecimal(rsNegative.getString("moneys")); 
				}
				if(rsSupplier.next()){
					bdSupplier=new BigDecimal(rsSupplier.getString("moneys")); 
				}
				BigDecimal thismoney = null;
				if(info.getReceiveAmt()==null){
					thismoney = new BigDecimal(0);
				}else{
					thismoney = info.getReceiveAmt();
				}
				
				if(bdPositive.compareTo(thismoney.add(bdNegative).add(bdSupplier))>=0){
				  System.out.print("够了");
				  return false;
				}else{
					return true;
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
   }
   
}