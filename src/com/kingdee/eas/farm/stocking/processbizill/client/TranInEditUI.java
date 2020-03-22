/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntryCollection;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.processbizill.wzBillBaseStatus;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;

/**
 * output class name
 */
public class TranInEditUI extends AbstractTranInEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(TranInEditUI.class);
    
    /**
     * output class constructor
     */
    public TranInEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    @Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.actionAddNew.setVisible(false);
		
		this.baseStatus.setEditable(false);
		this.baseStatus.setEnabled(false);
		
		//设置棚舍的Query
		KDBizPromptBox kdtEntrys_material_PromptBox1 = new KDBizPromptBox();
		kdtEntrys_material_PromptBox1.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
		kdtEntrys_material_PromptBox1.setVisible(true);
		kdtEntrys_material_PromptBox1.setEditable(true);
		kdtEntrys_material_PromptBox1.setDisplayFormat("$name$");
		kdtEntrys_material_PromptBox1.setEditFormat("$name$");
		kdtEntrys_material_PromptBox1.setCommitFormat("$name$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor1 = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox1);
		ObjectValueRender kdtEntrys_material_OVR1 = new ObjectValueRender();
		kdtEntrys_material_OVR1.setFormat(new BizDataFormat("$name$"));
		this.kdtEntrys.getColumn("outHouse").setEditor(kdtEntrys_material_CellEditor1);  
		this.kdtEntrys.getColumn("outHouse").setRenderer(kdtEntrys_material_OVR1);
		
		
		KDBizPromptBox kdtEntrys_material_PromptBox2 = new KDBizPromptBox();
		kdtEntrys_material_PromptBox2.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.FarmHouseQuery");
		kdtEntrys_material_PromptBox2.setVisible(true);
		kdtEntrys_material_PromptBox2.setEditable(true);
		kdtEntrys_material_PromptBox2.setDisplayFormat("$name$");
		kdtEntrys_material_PromptBox2.setEditFormat("$name$");
		kdtEntrys_material_PromptBox2.setCommitFormat("$name$");
		KDTDefaultCellEditor kdtEntrys_material_CellEditor2 = new KDTDefaultCellEditor(kdtEntrys_material_PromptBox2);
		ObjectValueRender kdtEntrys_material_OVR2 = new ObjectValueRender();
		kdtEntrys_material_OVR2.setFormat(new BizDataFormat("$name$"));
		this.kdtEntrys.getColumn("inHouse").setEditor(kdtEntrys_material_CellEditor2);  
		this.kdtEntrys.getColumn("inHouse").setRenderer(kdtEntrys_material_OVR2);
		
		//分录中养殖场和批次添加监听事件
		this.kdtEntrys.addKDTEditListener(new KDTEditAdapter(){
			@Override
			public void editStarting(KDTEditEvent e) {
				inFarmField(e);
				super.editStarting(e);
			}
			
			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub

//				转出养殖场添加监听事件，选中养殖场自动过滤棚舍
//				if("outFarm".equalsIgnoreCase(kdtEntrys.getColumn(e.getColIndex()).getKey())){
//					farmField(e);
//				}

				//转入养殖场添加监听事件
				//转出养殖场添加监听事件，选中养殖场自动过滤棚舍
				if("inFarm".equalsIgnoreCase(kdtEntrys.getColumn(e.getColIndex()).getKey())){
					inFarmField(e);
				}

//				//转入批次添加监听事件
//				if("inBatch".equalsIgnoreCase(kdtEntrys.getColumn(e.getColIndex()).getKey())){
//					inBatchField(e);
//				}

				super.editStopped(e);
			}
		});
	}
 
    
    /**
	 * 转入养殖场添加监听事件
	 * @param e
	 */
	protected void inFarmField(KDTEditEvent e) {

		String farmId = null;
		KDBizPromptBox inHouseF7 = (KDBizPromptBox)this.kdtEntrys.getColumn("inHouse").getEditor().getComponent();
		KDBizPromptBox inBatchF7 = (KDBizPromptBox)this.kdtEntrys.getColumn("inBbatch").getEditor().getComponent();
		
		if(kdtEntrys.getCell(e.getRowIndex(), "inFarm").getValue() != null){
			farmId = ((FarmInfo) kdtEntrys.getCell(e.getRowIndex(), "inFarm").getValue()).getId().toString();
			//创建一个新的视图对象
			EntityViewInfo view = new EntityViewInfo(); 
			//设置过滤条件
			FilterInfo filter = new FilterInfo(); 
			//添加参数
			filter.getFilterItems().add(new FilterItemInfo("parent.id", farmId,CompareType.EQUALS)); 
			view.setFilter(filter);
			inHouseF7.setEntityViewInfo(view);
			
			view = new EntityViewInfo(); 
			filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("farm.id", farmId,CompareType.EQUALS)); 
			view.setFilter(filter);
			inBatchF7.setEntityViewInfo(view);
			
		}

	}
    
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
    	
    	if (this.editData.getBaseStatus().equals(wzBillBaseStatus.audit)) {
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
		}
		if (!this.editData.getBaseStatus().equals(wzBillBaseStatus.submit)) {
			MsgBox.showWarning("单据尚未提交，禁止审核！");
			SysUtil.abort();
		}
		super.actionAudit_actionPerformed(e);
		refreshCurPage();
	
	}
	/**
	 * 刷新方法
	 */
	private void refreshCurPage() {

		if (editData.getId() != null) {
			BOSUuid pk = editData.getId();
			try {
				super.doAfterSave(new ObjectUuidPK(editData.getId()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			editData.setId(pk);
		}else{
			try {
				this.loadData();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	@Override
	public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if (this.editData.getBaseStatus().equals(wzBillBaseStatus.audit)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(arg0);
	
	}
	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {

		if (this.editData.getBaseStatus().equals(wzBillBaseStatus.audit)) {
			MsgBox.showWarning("单据已经审核，禁止删除！");
			SysUtil.abort();
		}
		
		super.actionRemove_actionPerformed(arg0);
	
	
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {

		if (!this.editData.getBaseStatus().equals(wzBillBaseStatus.audit)) {
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		refreshCurPage();
	}
	/**
     * output btnAddLine_actionPerformed method
     */
    protected void btnAddLine_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.btnAddLine_actionPerformed(e);
    }

    /**
     * output menuItemEnterToNextRow_itemStateChanged method
     */
    protected void menuItemEnterToNextRow_itemStateChanged(java.awt.event.ItemEvent e) throws Exception
    {
        super.menuItemEnterToNextRow_itemStateChanged(e);
    }

    /**
     * output MenuItemPCVoucher_actionPerformed method
     */
    protected void MenuItemPCVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.MenuItemPCVoucher_actionPerformed(e);
    }

    /**
     * output menuItemDelPCVoucher_actionPerformed method
     */
    protected void menuItemDelPCVoucher_actionPerformed(java.awt.event.ActionEvent e) throws Exception
    {
        super.menuItemDelPCVoucher_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.stocking.processbizill.TranInFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.stocking.processbizill.TranInInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.TranInInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBaseStatus(wzBillBaseStatus.add);
		objectValue.setBizDate(new Date());
        return objectValue;
    }

}