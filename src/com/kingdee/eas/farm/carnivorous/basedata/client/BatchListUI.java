/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.farm.carnivorous.basedata.IBatch;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;

/**
 * output class name
 */
public class BatchListUI extends AbstractBatchListUI
{
    private static final Logger logger = CoreUIObject.getLogger(BatchListUI.class);
    
    /**
     * output class constructor
     */
    public BatchListUI() throws Exception
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
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basedata.BatchFactory.getRemoteInstance();
    }

    /**
     * output getTreeInterface method
     */
    protected ITreeBase getTreeInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basedata.BatchTreeFactory.getRemoteInstance();
    }

    /**
     * output getGroupEditUIName method
     */
    protected String getGroupEditUIName()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.client.BatchTreeEditUI.class.getName();
    }

    /**
     * output getQueryFieldName method
     */
    protected String getQueryFieldName()
    {
        return "treeid.id";
    }

    /**
     * output getKeyFieldName method
     */
    protected String getKeyFieldName()
    {
        return "id";
    }

    /**
     * output getRootName method
     */
    protected String getRootName()
    {
        return "批次信息";
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basedata.BatchInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.BatchInfo();
		
        return objectValue;
    }

    @Override
	protected boolean isIgnoreCUFilter() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean isIgnoreTreeCUFilter() {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.actionCancel.setVisible(true);
		this.actionCancelCancel.setVisible(true);
		
		this.btnAddNew.setVisible(true);
		this.btnAddNew.setEnabled(true);
		
		
		
		
		menuBiz.setVisible(true);
		menuBiz.setEnabled(true);
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));		
		
		this.btnCreateToCostObject.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
//				try {
//					UIContext uiContext = new UIContext(this);
//			    	IUIWindow uiWindow = null ;
//			    	// UIFactoryName.MODEL 为弹出模式
//			    	uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create("com.kingdee.eas.farm.stocking.basedata.client.CreateCostObjectUI", uiContext, null,OprtState.VIEW);
//			    	//开始展现UI
//			    	uiWindow.show();
//			    	actionRefresh_actionPerformed(null);
//				}catch(Exception err) {
//					err.printStackTrace();
//				}
			}});
	}




		protected void tblMain_tableSelectChanged(KDTSelectEvent e) throws Exception {
			// TODO Auto-generated method stub
			super.tblMain_tableSelectChanged(e);
			String baseStatus=StockingClientComm.getSelectedKeyValue(tblMain, "baseStatus").toString();
			if(baseStatus.equals("禁用")) {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(true);
				this.actionEdit.setEnabled(false);
			}else if(baseStatus.equals("核准")) {
				this.actionCancel.setEnabled(true);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(false);
			}else{
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(true);
			}
		}


		@Override
		public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
			// TODO Auto-generated method stub
			super.actionCancel_actionPerformed(e);
			actionRefresh_actionPerformed(e);
		}

		
		 /**
	     * output actionAudit_actionPerformed
	     */
	    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	    {
//	        super.actionAudit_actionPerformed(e);
	    	if (this.getBizInterface().getValue(
					new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus")
					.equals(FarmBaseStatusEnum.APPROVE_VALUE)) {
				MsgBox.showInfo("单据已经核准，禁止再次核准！");
				// 状态不正确，终止处理
				SysUtil.abort();
			}
	    	IBatch  intenface= (IBatch) getBizInterface();
			ArrayList<String> list=getSelectedIdValues();
			int size=list.size();  
			String[] billIdlist = (String[])list.toArray(new String[size]);  
			// 常用的弹出对话框方法
			for(int j=0;j<billIdlist.length;j++){
					// 审核操作
					IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
					intenface.audit(intenface.getBatchInfo(pk));
			}
			MsgBox.showInfo("核准成功！");
			refreshList();
	    }
	    
		 /**
	     * output actionAudit_actionPerformed
	     */
	    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	    {
//	        super.actionAudit_actionPerformed(e);
	    	if (!this.getBizInterface().getValue(
					new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus")
					.equals(FarmBaseStatusEnum.APPROVE_VALUE)) {
				MsgBox.showInfo("未核准单据不能反核准！");
				// 状态不正确，终止处理
				SysUtil.abort();
			}
	    	IBatch intenface= (IBatch) getBizInterface();
			ArrayList<String> list=getSelectedIdValues();
			int size=list.size();  
			String[] billIdlist = (String[])list.toArray(new String[size]);  
			// 常用的弹出对话框方法
			for(int j=0;j<billIdlist.length;j++){
					// 反核准操作
					IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
					intenface.unAudit(intenface.getBatchInfo(pk));		
			}
			MsgBox.showInfo("反核准成功！");
			refreshList();
	    }

		

		@Override
		public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception {
			// TODO Auto-generated method stub
//			super.actionCancelCancel_actionPerformed(e);
			checkSelected();
			String cancelMsg = EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Confirm_CancelCancel");
			if (!(confirmDialog(cancelMsg)))
			  return;
			if (UtilRequest.isPrepare("ActionCancelCancel", this)) {
			  prepareCancel(null).callHandler();
			}
			cancelCancel();
			actionRefresh_actionPerformed(e);
		}


}