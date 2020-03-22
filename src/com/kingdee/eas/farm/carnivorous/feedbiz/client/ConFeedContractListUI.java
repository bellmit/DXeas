/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.feedbiz.client;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectBlock;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.farm.carnivorous.feedbiz.IBatchContractBill;
import com.kingdee.eas.farm.carnivorous.feedbiz.IConFeedContract;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;

/**
 * output class name
 */
public class ConFeedContractListUI extends AbstractConFeedContractListUI
{
    private static final Logger logger = CoreUIObject.getLogger(ConFeedContractListUI.class);
    
    /**
     * output class constructor
     */
    public ConFeedContractListUI() throws Exception
    {
        super();
    }
    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);
		
		this.tblMain.addKDTSelectListener(new KDTSelectListener(){
			public void tableSelectChanged(KDTSelectEvent e) {
				selectedRowChanged(e.getSelectBlock().getBeginRow());
			}});
	}

    @Override
	protected boolean isIgnoreCUFilter() {
		// TODO Auto-generated method stub
		return true;
	}
    
    /**
	 * 行选择 改变事件
	 * @param rowIndex
	 */
	private void selectedRowChanged(int rowIndex) {
		ArrayList list = this.getSelectedFieldValues("billStatus");
		if(list.size()>0) {
			if(list.get(0).equals("禁用")) {
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(false);
				this.actionEdit.setEnabled(false);
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(true);
			}else if(list.get(0).equals("审核")) {
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(true);
				this.actionEdit.setEnabled(false);
				this.actionCancel.setEnabled(true);
				this.actionCancelCancel.setEnabled(false);
			}else if(list.get(0).equals("提交")) {
				this.actionAudit.setEnabled(true);
				this.actionUnAudit.setEnabled(false);
				this.actionEdit.setEnabled(true);
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
			}else{
				this.actionAudit.setEnabled(false);
				this.actionUnAudit.setEnabled(false);
				this.actionEdit.setEnabled(true);
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
			}
		}
	}
    
    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo objectValue = new com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo();
		
        return objectValue;
    }
    
    @Override
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
    	// TODO Auto-generated method stub
    	super.actionCancel_actionPerformed(e);
    	refreshList();
    }
    
    @Override
    public void actionCancelCancel_actionPerformed(ActionEvent e)
    		throws Exception {
    	// TODO Auto-generated method stub
    	super.actionCancelCancel_actionPerformed(e);
		checkSelected();
		String cancelMsg = EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Confirm_CancelCancel");
		if (!(confirmDialog(cancelMsg)))
		  return;
		if (UtilRequest.isPrepare("ActionCancelCancel", this)) {
		  prepareCancel(null).callHandler();
		}
		cancelCancel();
    	refreshList();
    }
    
    @Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
//    	checkSelected();
//    	if(WorkFlowUtil.checkBillInWorkflow(null,getSelectedKeyValue())){
//			MsgBox.showWarning("当前单据尚在工作流执行过程,不能执行该操作");
//			SysUtil.abort();
//		}
//		super.actionAudit_actionPerformed(e);
//		refreshList();
//		MsgBox.showInfo("审核完成");
    	
    	IConFeedContract purorder = (IConFeedContract) getBizInterface();
		String[] billIdlist = getSelectedListId();
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
			// 审核操作
			IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());

			if(!this.getBizInterface().getValue(pk).get("billStatus").equals(BillBaseStatusEnum.SUBMITED_VALUE)){
				MsgBox.showWarning("单据尚未提交，不能审核！");
				SysUtil.abort();
			}

			purorder.audit(purorder.getConFeedContractInfo(pk));
			actionRefresh_actionPerformed(null);

		}
    	
	}


	private String[] getSelectedListId() {
		checkSelected();
		// SelectManager 是 kdtable 中行管理类
		ArrayList blocks =tblMain.getSelectManager().getBlocks();
		ArrayList idList = new ArrayList();
		Iterator iter = blocks.iterator();
		while (iter.hasNext()) {
			KDTSelectBlock block = (KDTSelectBlock) iter.next();
			int top = block.getTop();
			int bottom = block.getBottom();
			for (int rowIndex = top; rowIndex <= bottom; rowIndex++) {
				ICell cell = tblMain.getRow(rowIndex)
				.getCell(getKeyFieldName());
				if (!idList.contains(cell.getValue())) {
					idList.add(cell.getValue());
				}
			}
		}
		String[] listId = null;
		if (idList != null && idList.size() > 0) {
			Iterator iterat = idList.iterator();
			listId = new String[idList.size()];
			int index = 0;
			while (iterat.hasNext()) {
				listId[index] = (String) iterat.next();
				index++;
			}
		}
		return listId;
	
		
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
//		super.actionUnAudit_actionPerformed(e);
//		refreshList();
//		MsgBox.showInfo("反审核完成");
		
		
		IConFeedContract purorder = (IConFeedContract) getBizInterface();
		String[] billIdlist = getSelectedListId();
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
			// 审核操作
			IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());

			if(!this.getBizInterface().getValue(pk).get("billStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
				MsgBox.showWarning("单据尚未审核，禁止反审核！");
				SysUtil.abort();
			}

			purorder.unAudit(purorder.getConFeedContractInfo(pk));
			actionRefresh_actionPerformed(null);

		}
		
		
		
		
	}

}