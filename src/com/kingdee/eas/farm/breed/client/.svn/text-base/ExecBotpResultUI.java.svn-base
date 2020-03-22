/**
 * output package name
 */
package com.kingdee.eas.farm.breed.client;

import java.awt.event.*;
import java.util.List;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.farm.breed.comm.ExecBotpResultInfo;
import com.kingdee.eas.framework.*;

/**
 * output class name
 */
public class ExecBotpResultUI extends AbstractExecBotpResultUI
{
    private static final Logger logger = CoreUIObject.getLogger(ExecBotpResultUI.class);
    
    private List<ExecBotpResultInfo> execResultInfos;
    
    /**
     * output class constructor
     */
    public ExecBotpResultUI() throws Exception
    {
        super();
        
    }
    /**
     * output class constructor
     */
    public ExecBotpResultUI(List<ExecBotpResultInfo> results) throws Exception
    {
        super();
        execResultInfos = results;
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output btnCancel_actionPerformed method
     */
    protected void btnCancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        this.uiWindow.close();
    }

    /**
     * 界面初始化
     */
	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		execResultInfos = (List<ExecBotpResultInfo>) this.getUIContext().get("resultInfos");
		kDTable1.checkParsed();
		this.kDTable1.removeRows();
		if(execResultInfos != null && execResultInfos.size() > 0){
			for(int i = 0; i < execResultInfos.size(); i++){
				ExecBotpResultInfo resultInfo = execResultInfos.get(i);
				if(i == 0){
					this.tfSrcBillNumber.setText(resultInfo.getSrcObjectNumber());
					this.tfSrcBillType.setText(resultInfo.getSrcEntiryName());
				}
				IRow newRow = this.kDTable1.addRow();
				newRow.getCell("botpNumber").setValue(resultInfo.getMappingNumber());
				newRow.getCell("botpName").setValue(resultInfo.getMappingName());
				newRow.getCell("destEntityName").setValue(resultInfo.getDestEntityName());
				newRow.getCell("destObjectNumber").setValue(resultInfo.getDestObjectNumber());
				newRow.getCell("destBillStatus").setValue(resultInfo.getDestBillStatus());
				newRow.getCell("error").setValue(resultInfo.getError());
				
			}
		}
	}

    

}