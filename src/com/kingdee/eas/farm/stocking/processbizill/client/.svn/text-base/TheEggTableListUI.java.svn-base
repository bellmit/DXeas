/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.data.SortType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectBlock;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDaily;
import com.kingdee.eas.farm.stocking.processbizill.ITheEggTable;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class TheEggTableListUI extends AbstractTheEggTableListUI
{
	private static final Logger logger = CoreUIObject.getLogger(TheEggTableListUI.class);

	/**
	 * output class constructor
	 */
	public TheEggTableListUI() throws Exception
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
		return com.kingdee.eas.farm.stocking.processbizill.TheEggTableFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.stocking.processbizill.TheEggTableInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.TheEggTableInfo();

		return objectValue;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub\
		//修改图标
		tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		btnCopyTo.setVisible(false);
		setUITitle("交蛋表");
		super.onLoad();
	}

	@Override
	protected void beforeExcutQuery(EntityViewInfo arg0) {
		// TODO Auto-generated method stub
		SorterItemCollection sorterItems = arg0.getSorter();
		SorterItemInfo sorterItem = null;
		if (sorterItems != null && sorterItems.size() == 0) {
			sorterItem = new SorterItemInfo(tblMain.getColumn("bizDate").getFieldName());
			sorterItem.setSortType(SortType.DESCEND);
			sorterItems.add(sorterItem);
			sorterItem = new SorterItemInfo(tblMain.getColumn("number").getFieldName());
			sorterItem.setSortType(SortType.DESCEND);
			sorterItems.add(sorterItem);
			sorterItem = new SorterItemInfo(tblMain.getColumn("id").getFieldName());
			sorterItem.setSortType(SortType.DESCEND);
			sorterItems.add(sorterItem);
			sorterItem = new SorterItemInfo(tblMain.getColumn("entrys.seq").getFieldName());
			sorterItem.setSortType(SortType.ASCEND);
			sorterItems.add(sorterItem);
		}
		super.beforeExcutQuery(arg0);
	}

	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{	
		checkSelected();
		if(!this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.SUBMITED_VALUE)){
			MsgBox.showWarning("单据尚未提交，禁止再次审核！");
			SysUtil.abort();
		}
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		
		//设置批量审核功能
		ITheEggTable purorder = (ITheEggTable) getBizInterface();
		String[] billIdlist = getSelectedListId();
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
				// 审核操作
				IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
				purorder.audit(purorder.getTheEggTableInfo(pk));
				actionRefresh_actionPerformed(null);
			
		}
		
		
		super.actionAudit_actionPerformed(e);
		this.actionRefresh_actionPerformed(null);
	}

	/**
	 * output actionUnAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{
		checkSelected();
		if(!this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
		}
		
		ITheEggTable purorder = (ITheEggTable) getBizInterface();
		String[] billIdlist = getSelectedListId();
		// 常用的弹出对话框方法
		for(int j=0;j<billIdlist.length;j++){
				// 审核操作
				IObjectPK pk = new ObjectStringPK(billIdlist[j].toString());
				purorder.unAudit(purorder.getTheEggTableInfo(pk));
				actionRefresh_actionPerformed(null);
			
		}
		super.actionUnAudit_actionPerformed(e);
		this.actionRefresh_actionPerformed(null);
	}
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
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(BillBaseStatusEnum.AUDITED_VALUE)){
			MsgBox.showWarning("单据已审核，禁止编辑！");
			SysUtil.abort();
		}
        super.actionEdit_actionPerformed(e);
    }
}