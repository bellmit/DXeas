/**
 * output package name
 */
package com.kingdee.eas.wlhlcomm.client;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.swing.KDCheckBox;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.base.job.util.JobResourceUtil;
import com.kingdee.eas.base.job.util.JobUtils;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.ToolFacadeFactory;
import com.kingdee.eas.wlhlcomm.bean.JobInfo;

/**
 * output class name
 */
public class ExecJobUI extends AbstractExecJobUI
{
    private static final Logger logger = CoreUIObject.getLogger(ExecJobUI.class);
    
    /**
     * output class constructor
     */
    public ExecJobUI() throws Exception
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
     * 初始化界面
     */
    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		// 
		this.kDTable1.checkParsed();
		KDCheckBox selected_CheckBox = new KDCheckBox();
		selected_CheckBox.setName("kdtPerson_selected_CheckBox");
        KDTDefaultCellEditor selected_CellEditor = new KDTDefaultCellEditor(selected_CheckBox);
        this.kDTable1.getColumn("selected").setEditor(selected_CellEditor);
		
		// 清空后 根据传入条件查询符合条件的 后台事务列表
		this.kDTable1.removeRows();
		String[] jobNames = null;
		if(this.getUIContext() != null && this.getUIContext().containsKey("jobNames")){
			jobNames = (String[]) this.getUIContext().get("jobNames");
		}
		
		// 加载符合条件的 后台事务列表
		List<JobInfo> enableJobs = ToolFacadeFactory.getRemoteInstance().getJobByNames(jobNames);
		for(int i = 0; i < enableJobs.size(); i++){
			JobInfo jobInfo = enableJobs.get(i);
			IRow newRow = this.kDTable1.addRow();
			newRow.getCell("selected").setValue(false);
			newRow.getCell("name").setValue(jobInfo.getJobName());
			newRow.getCell("id").setValue(jobInfo.getJobID());
		}
		
		// 如果只有一行数据符合条件 直接选中
		if(this.kDTable1.getRowCount() == 1){
			this.kDTable1.getCell(0, "selected").setValue(true);
		}
	}
    
	/**
     * output btnConfirm_actionPerformed method
     */
    protected void btnConfirm_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
    	List<String> selectedIDs = new LinkedList<String>();
        for(int i = 0; i < this.kDTable1.getRowCount(); i++){
        	Object selectedValue = this.kDTable1.getCell(i,"selected").getValue();
        	if(selectedValue instanceof Boolean){
        		if((Boolean) selectedValue){
        			selectedIDs.add((String) this.kDTable1.getCell(i,"id").getValue());
        		}
        	}
        }
        
        if(selectedIDs.size() > 0){
        	if (MsgBox.showConfirm2(JobResourceUtil.getJobResource("confirmStart")) != 0) {
        		SysUtil.abort();
        	}else{
        		for(int i = 0; i < selectedIDs.size(); i++){
        			String id = selectedIDs.get(i);
        			JobUtils.getJobServiceFacade().createJobInstance(id, null, null);
        		}
        		
        		MsgBox.showInfo(JobResourceUtil.getJobResource("startSuccess"));
        	}
        }else{
        	MsgBox.showInfo("未选中任何事务");
        	SysUtil.abort();
        }
    }

    /**
     * output btnCancel_actionPerformed method
     */
    protected void btnCancel_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        this.uiWindow.close();
    }
    
}