/**
 * output package name
 */
package com.kingdee.eas.farm.breed.business.client;

import java.awt.event.*;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.FarmException;

/**
 * output class name
 */
public class CommecialChikenApplyFodderListUI extends AbstractCommecialChikenApplyFodderListUI
{
    private static final Logger logger = CoreUIObject.getLogger(CommecialChikenApplyFodderListUI.class);
    
    /**
     * output class constructor
     */
    public CommecialChikenApplyFodderListUI() throws Exception
    {
        super();
        
        this.setUITitle("要料计划列表");
        
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
     * 审核
     */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		try{
			super.actionAudit_actionPerformed(e);
			MsgBox.showInfo("审核完成");
			
			this.refreshList();
			this.setMessageText("审核完成");
			this.showMessage();
		}catch(FarmException fe){
			MsgBox.showError(fe.getMessage());
		}
	}

	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		try{
			super.actionUnAudit_actionPerformed(e);
			MsgBox.showInfo("反审核完成");
			
			this.refreshList();
			this.setMessageText("反审核完成");
			this.showMessage();
		}catch(FarmException fe){
			MsgBox.showError(fe.getMessage());
		}
	}

    /**
     * output actionGenNextBill_actionPerformed
     */
    public void actionGenNextBill_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionGenNextBill_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.breed.business.CommecialChikenApplyFodderFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.business.CommecialChikenApplyFodderInfo objectValue = new com.kingdee.eas.farm.breed.business.CommecialChikenApplyFodderInfo();
		
        return objectValue;
    }

//
//    @Override
//	protected FilterInfo getDefaultFilterForQuery() {
//		// TODO Auto-generated method stub
//		FilterInfo filter =  super.getDefaultFilterForQuery();
//		FilterInfo filterNew = new FilterInfo();
//		filterNew.getFilterItems().add(new FilterItemInfo("entrys.seq",new Integer(1),CompareType.EQUALS));
//		filterNew.getFilterItems().add(new FilterItemInfo("entrys.seq",null,CompareType.EQUALS));
//		filterNew.setMaskString("#0 OR #1");
//		
//		try{
//			if(filter != null){
//				filter.mergeFilter(filterNew, "and");
//			}else{
//				filter = filterNew;
//			}
//			
//		}catch(BOSException e){
//			e.printStackTrace();
//			this.handleException(e);
//		}
//		return filter;
//	}
    
    

	/**
	 * 按业务日期降序排列
	 */
	@Override
	protected IQueryExecutor getQueryExecutor(IMetaDataPK queryPK,
			EntityViewInfo viewInfo) {
		SorterItemCollection sic = new SorterItemCollection();
		SorterItemInfo siInfo = new SorterItemInfo("bizDate");
		siInfo.setSortType(SortType.DESCEND);
		sic.add(siInfo);
		viewInfo.setSorter(sic);
		return super.getQueryExecutor(queryPK, viewInfo);
		
	}
	

	/**
	 * 获得默认的查询条件
	 */
   @Override
   protected FilterInfo getDefaultFilterForQuery()
   {
	   FilterInfo filter  = new FilterInfo();
     
     
     if (SysContext.getSysContext().getCurrentCtrlUnit() == null)
     {
       return filter;

     }
     filter.getFilterItems().add(new FilterItemInfo("stoOrg.id", SysContext.getSysContext().getCurrentStorageUnit().getId().toString(), CompareType.EQUALS));
     
     filter.getFilterItems().add(new FilterItemInfo("CU.id", SysContext.getSysContext().getCurrentStorageUnit().getId().toString(), CompareType.EQUALS));
//
// 
//     filter.getFilterItems().add(new FilterItemInfo("CU.id", "11111111-1111-1111-1111-111111111111CCE7AED4", CompareType.EQUALS));
// 
//     filter.getFilterItems().add(new FilterItemInfo("CU.id", "00000000-0000-0000-0000-000000000000CCE7AED4", CompareType.EQUALS));
// 
     filter.setMaskString("#0 or #1 ");
     return filter;
   }


	
	/**
	 * 是否组织隔离
	 */
	protected boolean isIgnoreCUFilter()
	{
	    return false;
	}
}