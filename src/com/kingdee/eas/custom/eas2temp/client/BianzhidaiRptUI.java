/**
 * output package name
 */
package com.kingdee.eas.custom.eas2temp.client;

import java.awt.Color;
import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDataRequestManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTDataRequestEvent;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.custom.eas2temp.BianzhidaiFacadeFactory;
import com.kingdee.eas.framework.report.ICommRptBase;
import com.kingdee.eas.framework.report.client.CommRptBaseConditionUI;
import com.kingdee.eas.framework.report.util.KDTableUtil;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptRowSet;

/**
 * output class name
 */
public class BianzhidaiRptUI extends AbstractBianzhidaiRptUI
{
    private static final Logger logger = CoreUIObject.getLogger(BianzhidaiRptUI.class);
    
    /**
     * output class constructor
     */
    public BianzhidaiRptUI() throws Exception
    {
        super();
    }

    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.setUITitle("编织袋报表");
		// 构造函数 新增代码
		this.kDTable1.checkParsed();
		this.kDTable1.getDataRequestManager().addDataRequestListener(this);
		this.kDTable1.getDataRequestManager().setDataRequestMode(KDTDataRequestManager.VIRTUAL_MODE_PAGE);
		enableExportExcel(this.kDTable1);
		this.kDTable1.setEditable(false);
		this.kDTable1.setEnabled(false);
	}

	/**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output actionPageSetup_actionPerformed
     */
    public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPageSetup_actionPerformed(e);
    }

    /**
     * output actionExitCurrent_actionPerformed
     */
    public void actionExitCurrent_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExitCurrent_actionPerformed(e);
    }

    /**
     * output actionHelp_actionPerformed
     */
    public void actionHelp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHelp_actionPerformed(e);
    }

    /**
     * output actionAbout_actionPerformed
     */
    public void actionAbout_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAbout_actionPerformed(e);
    }

    /**
     * output actionOnLoad_actionPerformed
     */
    public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionOnLoad_actionPerformed(e);
    }

    /**
     * output actionSendMessage_actionPerformed
     */
    public void actionSendMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMessage_actionPerformed(e);
    }

    /**
     * output actionCalculator_actionPerformed
     */
    public void actionCalculator_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCalculator_actionPerformed(e);
    }

    /**
     * output actionExport_actionPerformed
     */
    public void actionExport_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExport_actionPerformed(e);
    }

    /**
     * output actionExportSelected_actionPerformed
     */
    public void actionExportSelected_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelected_actionPerformed(e);
    }

    /**
     * output actionRegProduct_actionPerformed
     */
    public void actionRegProduct_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRegProduct_actionPerformed(e);
    }

    /**
     * output actionPersonalSite_actionPerformed
     */
    public void actionPersonalSite_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPersonalSite_actionPerformed(e);
    }

    /**
     * output actionProcductVal_actionPerformed
     */
    public void actionProcductVal_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionProcductVal_actionPerformed(e);
    }

    /**
     * output actionExportSave_actionPerformed
     */
    public void actionExportSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSave_actionPerformed(e);
    }

    /**
     * output actionExportSelectedSave_actionPerformed
     */
    public void actionExportSelectedSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelectedSave_actionPerformed(e);
    }

    /**
     * output actionKnowStore_actionPerformed
     */
    public void actionKnowStore_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionKnowStore_actionPerformed(e);
    }

    /**
     * output actionAnswer_actionPerformed
     */
    public void actionAnswer_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAnswer_actionPerformed(e);
    }

    /**
     * output actionRemoteAssist_actionPerformed
     */
    public void actionRemoteAssist_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoteAssist_actionPerformed(e);
    }

    /**
     * output actionPopupCopy_actionPerformed
     */
    public void actionPopupCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupCopy_actionPerformed(e);
    }

    /**
     * output actionHTMLForMail_actionPerformed
     */
    public void actionHTMLForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForMail_actionPerformed(e);
    }

    /**
     * output actionExcelForMail_actionPerformed
     */
    public void actionExcelForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForMail_actionPerformed(e);
    }

    /**
     * output actionHTMLForRpt_actionPerformed
     */
    public void actionHTMLForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForRpt_actionPerformed(e);
    }

    /**
     * output actionExcelForRpt_actionPerformed
     */
    public void actionExcelForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForRpt_actionPerformed(e);
    }

    /**
     * output actionLinkForRpt_actionPerformed
     */
    public void actionLinkForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLinkForRpt_actionPerformed(e);
    }

    /**
     * output actionPopupPaste_actionPerformed
     */
    public void actionPopupPaste_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupPaste_actionPerformed(e);
    }

    /**
     * output actionToolBarCustom_actionPerformed
     */
    public void actionToolBarCustom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionToolBarCustom_actionPerformed(e);
    }

    /**
     * output actionCloudFeed_actionPerformed
     */
    public void actionCloudFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudFeed_actionPerformed(e);
    }

    /**
     * output actionCloudShare_actionPerformed
     */
    public void actionCloudShare_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudShare_actionPerformed(e);
    }

    /**
     * output actionCloudScreen_actionPerformed
     */
    public void actionCloudScreen_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudScreen_actionPerformed(e);
    }

    /**
     * output actionXunTongFeed_actionPerformed
     */
    public void actionXunTongFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionXunTongFeed_actionPerformed(e);
    }

    /**
     * output actionRefresh_actionPerformed
     */
    public void actionRefresh_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRefresh_actionPerformed(e);
    }

    /**
     * output actionQuery_actionPerformed
     */
    public void actionQuery_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionQuery_actionPerformed(e);
    }

    /**
     * output actionPrint_actionPerformed
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrint_actionPerformed(e);
    }

    /**
     * output actionPrintPreview_actionPerformed
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrintPreview_actionPerformed(e);
    }

    /**
     * output actionChart_actionPerformed
     */
    public void actionChart_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionChart_actionPerformed(e);
    }

	@Override
	protected RptParams getParamsForInit() {
		// TODO Auto-generated method stub
		return params;
	}

	@Override
	protected CommRptBaseConditionUI getQueryDialogUserPanel() throws Exception {
		// TODO Auto-generated method stub
		return new BianzhidaiFilterUI();
	}

	@Override
	protected ICommRptBase getRemoteInstance() throws BOSException {
		// TODO Auto-generated method stub
		return BianzhidaiFacadeFactory.getRemoteInstance();
	}

	@Override
	protected KDTable getTableForPrintSetting() {
		// TODO Auto-generated method stub
		return this.kDTable1;
	}

	@Override
	protected void query() {
		// TODO Auto-generated method stub
		this.kDTable1.removeRows();// 触发取数
	}

	@Override
	public void tableDataRequest(KDTDataRequestEvent e) {
		// TODO Auto-generated method stub
		int from = e.getFirstRow();
		RptParams rpt;
		try {
			rpt = this.getRemoteInstance().query(params);
			RptRowSet rs = (RptRowSet) rpt.getObject("rowset");
			KDTableUtil.insertRows(rs, from, this.kDTable1);
			
			boolean onlyShowSum=params.getBoolean("onlyShowSum");
			IRow currRow,nextRow;
			
			kDTable1.getRow(this.kDTable1.getRowCount3()-1).getCell("materialName").setValue("总计");
			kDTable1.getRow(this.kDTable1.getRowCount3()-1).getStyleAttributes().setBackground(new Color(65, 112, 112));
			for(int i=0;i<this.kDTable1.getRowCount3()-1;i++){
				currRow=kDTable1.getRow(i);
				
				//设置小计行颜色
				if("小计".equals(currRow.getCell("materialName").getValue())){
					currRow.getStyleAttributes().setBackground(Color.LIGHT_GRAY);
				}
				
				if(onlyShowSum){//设置只显示小计
					nextRow=kDTable1.getRow(i+1);
					if("小计".equals(nextRow.getCell(1).getValue())){
						currRow.getCell("acutalQty").setValue(nextRow.getCell("acutalQty").getValue());
						currRow.getCell("manufacturerOrderNum").setValue("");
						currRow.getCell("costobject").setValue("");
						
					}else{
						currRow.getStyleAttributes().setHided(true);
					}
				}
			}
			
			
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		
	}
	
	
    

}