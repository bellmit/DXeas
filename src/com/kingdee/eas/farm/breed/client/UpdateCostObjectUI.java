/**
 * output package name
 */
package com.kingdee.eas.farm.breed.client;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.IToolFacade;
import com.kingdee.eas.wlhlcomm.ToolFacadeFactory;

/**
 * output class name
 */
public class UpdateCostObjectUI extends AbstractUpdateCostObjectUI
{
    private static final Logger logger = CoreUIObject.getLogger(UpdateCostObjectUI.class);
    
    private ArrayList selectedIDs;
    /**
     * output class constructor
     */
    public UpdateCostObjectUI() throws Exception
    {
        super();
        
        this.prmtCostObject.setQueryInfo("com.kingdee.eas.basedata.assistant.app.F7CostObjectQuery");		
        this.prmtCostObject.setEditable(true);		
        this.prmtCostObject.setDisplayFormat("$name$");		
        this.prmtCostObject.setEditFormat("$number$");		
        this.prmtCostObject.setCommitFormat("$number$");		
        this.prmtCostObject.setRequired(true);
    }
    
    /**
     * ��ʼ���������� ��������ID����ǰ�����֯
     */
    @Override
	public void onLoad() throws Exception {
		
		super.onLoad();
		if(this.getUIContext().get("selectedIDs") != null){
			selectedIDs = (ArrayList) this.getUIContext().get("selectedIDs");
		}
	}

	/**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output btnConfirm_actionPerformed method
     */
    protected void btnConfirm_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        CostObjectInfo coInfo = (CostObjectInfo) this.prmtCostObject.getValue();
        if(selectedIDs == null || selectedIDs.size() == 0){
        	MsgBox.showConfirm2("δѡ���κο������������ܸ���");
        }else{
	        if(MsgBox.showConfirm2("����ѡ�еĿ��������ɱ�����Ϊ��ǰ���óɱ�����") == MsgBox.OK){
	        	String id = "";
	        	if(coInfo != null){
	        		id = coInfo.getId().toString();
	        	}
	        	IToolFacade toolFacade  =ToolFacadeFactory.getRemoteInstance();
	        	for(int i = 0; i < selectedIDs.size(); i++){
	        		String stbillID = (String) selectedIDs.get(i);
	        		String sql = "update t_im_stocktransferbill set CFCOSTOBJECTID = ? where fid = ?";
	        		Object[] args = {id,stbillID};
	        		// ����
	        		toolFacade.execute(sql, args);
	        	}
	        	
	        	
	        	MsgBox.showInfo("�������");
	        	this.getUIWindow().close();
	        }
        }
    }

    /**
     * output btnCancel_actionPerformed method
     */
    protected void btnCancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	this.getUIWindow().close();
    }

}