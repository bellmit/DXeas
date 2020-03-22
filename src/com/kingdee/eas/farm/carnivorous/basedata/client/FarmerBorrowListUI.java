/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectBlock;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.carnivorous.basedata.IDailyOutSaleCPrice;
import com.kingdee.eas.farm.carnivorous.basedata.IFarmerBorrow;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class FarmerBorrowListUI extends AbstractFarmerBorrowListUI
{
    private static final Logger logger = CoreUIObject.getLogger(FarmerBorrowListUI.class);
    
    /**
     * output class constructor
     */
    public FarmerBorrowListUI() throws Exception
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
     * output tblMain_tableClicked method
     */
    protected void tblMain_tableClicked(com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent e) throws Exception
    {
        super.tblMain_tableClicked(e);
    }

    /**
     * output menuItemImportData_actionPerformed method
     */
    protected void menuItemImportData_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.menuItemImportData_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basedata.FarmerBorrowFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basedata.FarmerBorrowInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.FarmerBorrowInfo();
		
        return objectValue;
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
//        super.actionAudit_actionPerformed(e);
    	if (this.getBizInterface().getValue(
				new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus")
				.equals(FarmBaseStatusEnum.APPROVE_VALUE)) {
			MsgBox.showInfo("单据已经核准，禁止再次核准！");
			// 状态不正确，终止处理
			SysUtil.abort();
		}
		IFarmerBorrow  intenface= (IFarmerBorrow) getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
				// 审核操作
				IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
				intenface.audit(intenface.getFarmerBorrowInfo(pk));
		}
		MsgBox.showInfo("核准成功！");
		refreshList();
    }
    
	 /**
     * output actionAudit_actionPerformed
     */
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
//        super.actionAudit_actionPerformed(e);
    	if (!this.getBizInterface().getValue(
				new ObjectUuidPK(getSelectedKeyValue())).get("baseStatus")
				.equals(FarmBaseStatusEnum.APPROVE_VALUE)) {
			MsgBox.showInfo("未核准单据不能反核准！");
			// 状态不正确，终止处理
			SysUtil.abort();
		}
    	IFarmerBorrow  intenface= (IFarmerBorrow) getBizInterface();
		ArrayList<String> list=getSelectedIdValues();
		int size=list.size();  
		String[] billIdlist = (String[])list.toArray(new String[size]);  
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
				// 反核准操作
				IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
				intenface.unAudit(intenface.getFarmerBorrowInfo(pk));		
		}
		MsgBox.showInfo("反核准成功！");
		refreshList();
    }

	

	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
//		super.actionCancelCancel_actionPerformed(e);
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
	
	protected void tblMain_tableSelectChanged(KDTSelectEvent e) throws Exception {
		// TODO Auto-generated method stub
//		super.tblMain_tableSelectChanged(e);
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
	public void actionVoucher_actionPerformed(ActionEvent e) throws Exception {

		String[] billIdlist = getSelectListId();  
		super.actionVoucher_actionPerformed(e);
		if(billIdlist==null){
			return;
		}
		for(int j=0;j<billIdlist.length;j++){
			String id=billIdlist[j];
			if(StringUtils.isEmpty(id))
				return;
			//校验生成凭证
			ArrayList<String> destObejctIDs = BOTRelationFactory.getRemoteInstance().getDestObjIdByDestType(id, "2652E01E");
//			if(destObejctIDs.size()==1){
//				CommFacadeFactory.getRemoteInstance().excuteUpdateSql("update CT_FM_MaiginBill set CFVoucherNumID='"+destObejctIDs.get(0)+"' where fid='"+id+"'");
//			}
		}
		refreshList();
		
	}
	
	

	public String[] getSelectListId(){
		String listId[] = null;
		ArrayList blocks = tblMain.getSelectManager().getBlocks();
		ArrayList idList = new ArrayList();
		Iterator iter = blocks.iterator();
		while(iter.hasNext()){
			KDTSelectBlock block = (KDTSelectBlock)iter.next();
			int top = block.getTop();
			int bottom = block.getBottom();
			for(int rowIndex = top;rowIndex<=bottom; rowIndex++){
				ICell cell = tblMain.getRow(rowIndex).getCell(getKeyFieldName());
				if(!idList.contains(cell.getValue())){
					idList.add(cell.getValue());
				}
			}
		}
		if(idList!=null&&idList.size()>0){
			Iterator iterat = idList.iterator();
			listId = new String[idList.size()];
			int index = 0 ;
			while(iterat.hasNext()){
				listId[index]=(String)iterat.next();
				index++;
			}
		}
		return listId;
	}
	
}