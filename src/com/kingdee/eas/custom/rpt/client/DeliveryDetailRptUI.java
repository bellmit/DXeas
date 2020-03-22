/**
 * output package name
 */
package com.kingdee.eas.custom.rpt.client;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.KDTDataRequestManager;
import com.kingdee.bos.ctrl.kdf.table.KDTMergeManager;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTDataRequestEvent;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.custom.rpt.DeliveryDetailFacadeFactory;
import com.kingdee.eas.framework.report.ICommRptBase;
import com.kingdee.eas.framework.report.client.CommRptBaseConditionUI;
import com.kingdee.eas.framework.report.util.KDTableUtil;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptRowSet;
import com.kingdee.eas.framework.report.util.RptTableHeader;

/**
 * output class name
 */
public class DeliveryDetailRptUI extends AbstractDeliveryDetailRptUI
{
    private static final Logger logger = CoreUIObject.getLogger(DeliveryDetailRptUI.class);
    
    /**
     * output class constructor
     */
    public DeliveryDetailRptUI() throws Exception
    {
        super();
        this.setUITitle("发运单汇总查询");
        kDTable1.checkParsed();    
        this.kDTable1.getStyleAttributes().setLocked(true); 
        kDTable1.getDataRequestManager().addDataRequestListener(this);        
        kDTable1.getDataRequestManager().setDataRequestMode(KDTDataRequestManager.VIRTUAL_MODE_PAGE);
        enableExportExcel(kDTable1);  
        this.kDTable1.getSelectManager().setSelectMode(KDTSelectManager.ROW_SELECT);
        this.kDTable1.getGroupManager().setGroup(true);
        this.kDTable1.getMergeManager().setMergeMode(KDTMergeManager.FREE_ROW_MERGE);
    }


	@Override
	protected RptParams getParamsForInit() {
		return this.params;
	}

	@Override
	protected CommRptBaseConditionUI getQueryDialogUserPanel() throws Exception {
		return new DeliveryDetailQueryUI();
	}

	@Override
	protected ICommRptBase getRemoteInstance() throws BOSException {
		return DeliveryDetailFacadeFactory.getRemoteInstance();
	}

	@Override
	protected KDTable getTableForPrintSetting() {
		return this.kDTable1;
	}

	@Override
	protected void query() {
		// TODO Auto-generated method stub
		kDTable1.removeColumns();
		kDTable1.removeRows();//触发取数
	}
	public void tableDataRequest(KDTDataRequestEvent e){		
		try {
			int from=e.getFirstRow();
			int len=e.getLastRow()-from+1;
			RptParams pp=this.getParamsForInit();	
			
			if(from==0){
				//临时表/表头
				RptParams rpt=this.getRemoteInstance().createTempTable(pp);
				this.setTempTable(rpt.getString("tempTable"));
				RptTableHeader header=(RptTableHeader)rpt.getObject("header");
				KDTableUtil.setHeader(header,kDTable1);
				kDTable1.setRowCount(rpt.getInt("verticalCount"));				
			}
			
			//查询并填充数据
			pp.setString("tempTable",this.getTempTable());
			RptParams rpt=this.getRemoteInstance().query(pp,from,len);
			RptRowSet rs=(RptRowSet)rpt.getObject("rowset");
			KDTableUtil.insertRows(rs,from,kDTable1);	
			this.kDTable1.getColumn(0).setGroup(true);
			for(int i=1;i<this.kDTable1.getColumnCount();i++) {
				this.kDTable1.getColumn(i).setMergeable(false);
			}
			//this.kDTable1.getColumn(2).setMergeable(true);
			this.kDTable1.getViewManager().freezeColumn(1);
		} catch (Exception ex) {
			this.handleException(ex);			
		}
	}

}