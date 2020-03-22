/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.basedata.client;

import java.awt.event.ActionEvent;
import java.util.*;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectBlock;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.IFarm;
import com.kingdee.eas.farm.stocking.basedata.IFarmers;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class FarmListUI extends AbstractFarmListUI
{
    private static final Logger logger = CoreUIObject.getLogger(FarmListUI.class);
    
    /**
     * output class constructor
     */
    public FarmListUI() throws Exception
    {
        super();
    }


    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmFactory.getRemoteInstance();
    }

    /**
     * output getTreeInterface method
     */
    protected ITreeBase getTreeInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmTreeFactory.getRemoteInstance();
    }

    /**
     * output getGroupEditUIName method
     */
    protected String getGroupEditUIName()
    {
        return com.kingdee.eas.farm.stocking.basedata.client.FarmTreeEditUI.class.getName();
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
        return "养殖场信息";
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.basedata.FarmInfo objectValue = new com.kingdee.eas.farm.stocking.basedata.FarmInfo();
		
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
		
	}


	@Override
	protected void tblMain_tableSelectChanged(KDTSelectEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.tblMain_tableSelectChanged(e);
		String baseStatus=StockingClientComm.getSelectedKeyValue(tblMain, "baseStatus").toString();
		if(baseStatus.equals("启用")) {
			this.actionCancel.setEnabled(true);
			this.actionCancelCancel.setEnabled(false);
			this.actionEdit.setEnabled(false);
		}else if(baseStatus.equals("核准")) {
			this.actionCancel.setEnabled(false);
			this.actionCancelCancel.setEnabled(true);
			this.actionEdit.setEnabled(false);
		}else{
			this.actionCancel.setEnabled(false);
			this.actionCancelCancel.setEnabled(false);
			this.actionEdit.setEnabled(true);
			}
	}
	 /**
     * output actionAudit_actionPerformed
     */
    public void actionAudit_actionPerformed(ActionEvent e) throws Exception
    {
//        super.actionAudit_actionPerformed(e);
    	if (this.getBizInterface().getValue(
				new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus")
				.equals(FarmBaseStatusEnum.APPROVE_VALUE)) {
			MsgBox.showInfo("单据已经核准，禁止再次核准！");
			// 状态不正确，终止处理
			SysUtil.abort();
		}
		IFarm  farm= (IFarm) getBizInterface();
		String[] billIdlist = getSelectedListId();
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
				// 审核操作
				IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
				farm.audit(farm.getFarmInfo(pk));
				actionRefresh_actionPerformed(null);
			
		}
		MsgBox.showInfo("核准成功！");
    }
 // 得到当前选中行的 id
	public String[] getSelectedListId() {
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
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCancel_actionPerformed(e);
		actionRefresh_actionPerformed(e);
	}


	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
//		super.actionCancelCancel_actionPerformed(e);
//		checkSelected();
//		String cancelMsg = EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Confirm_CancelCancel");
//		if (!(confirmDialog(cancelMsg)))
//		  return;
//		if (UtilRequest.isPrepare("ActionCancelCancel", this)) {
//		  prepareCancel(null).callHandler();
//		}
//		cancelCancel();
//		actionRefresh_actionPerformed(e);
		if (this.getBizInterface().getValue(
				new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus")
				.equals(FarmBaseStatusEnum.ENABLE_VALUE)) {
			MsgBox.showInfo("单据已经启用，禁止再次启用！");
			// 状态不正确，终止处理
			SysUtil.abort();
		}
		IFarm  farm= (IFarm) getBizInterface();
		String[] billIdlist = getSelectedListId();
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
				// 审核操作
				IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
				farm.cancelCancel(pk,farm.getFarmInfo(pk));
				actionRefresh_actionPerformed(null);
			
		}
		MsgBox.showInfo("启用成功！");
	}

}