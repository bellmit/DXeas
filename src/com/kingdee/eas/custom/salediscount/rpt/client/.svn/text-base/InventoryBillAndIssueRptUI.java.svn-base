/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.rpt.client;

import java.awt.event.*;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.KDTDataRequestManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTDataRequestEvent;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.custom.salediscount.rpt.ReqTheoryAndFactureRptFacadeFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.report.ICommRptBase;
import com.kingdee.eas.framework.report.client.CommRptBaseConditionUI;
import com.kingdee.eas.framework.report.util.KDTableUtil;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptRowSet;
import com.kingdee.eas.framework.report.util.RptTableHeader;

/**
 * output class name
 */
public class InventoryBillAndIssueRptUI extends AbstractInventoryBillAndIssueRptUI
{
    private static final Logger logger = CoreUIObject.getLogger(InventoryBillAndIssueRptUI.class);
    
    /**
     * output class constructor
     */
    public InventoryBillAndIssueRptUI() throws Exception
    {
        super();
        this.kDTable1.getStyleAttributes().setLocked(true);
        this.kDTable1.checkParsed();     
  		this.kDTable1.getDataRequestManager().addDataRequestListener(this); 
  		this.kDTable1.getDataRequestManager().setDataRequestMode(KDTDataRequestManager.VIRTUAL_MODE_PAGE);
  		enableExportExcel(this.kDTable1);
  		
  		this.setUITitle("理论与实际耗用对比表");
     }

     /**
      * output storeFields method
      */
     public void storeFields()
     {
         super.storeFields();
     }


 	@Override
 	protected RptParams getParamsForInit() {
 		// TODO Auto-generated method stub
 		return params;
 	}

 	@Override
 	protected CommRptBaseConditionUI getQueryDialogUserPanel() throws Exception {
 		// TODO Auto-generated method stub
 		return new ReqTheoryAndFactureRptFilterUI();
 	}

 	@Override
 	protected ICommRptBase getRemoteInstance() throws BOSException {
 		// TODO Auto-generated method stub
 		return ReqTheoryAndFactureRptFacadeFactory.getRemoteInstance();
 	}

 	@Override
 	protected KDTable getTableForPrintSetting() {
 		// TODO Auto-generated method stub
 		return this.kDTable1;
 	}

 	@Override
 	protected void query() {
 		// TODO Auto-generated method stub
 		this.kDTable1.removeColumns();
 		this.kDTable1.removeRows();//触发取数
 	}

 	@Override
 	public void tableDataRequest(KDTDataRequestEvent e) {
 		// TODO Auto-generated method stub
 		try {
 			int from=e.getFirstRow();
 			int len=e.getLastRow()-from+1;	
 			
 			
 			//查询并填充数据
 			
 			RptParams rpt=getRemoteInstance().query(params);
 			
 			RptTableHeader header=(RptTableHeader)rpt.getObject("header");
			KDTableUtil.setHeader(header,this.kDTable1);
			
 			RptRowSet rs=(RptRowSet)rpt.getObject("rowset");
 			KDTableUtil.insertRows(rs,from,kDTable1);		
 			
 			
 			
 		} catch (Exception ex) {
 			this.handleException(ex);			
 		}
 	}

}