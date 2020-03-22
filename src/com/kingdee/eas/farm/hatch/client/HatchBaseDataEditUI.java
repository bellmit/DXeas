/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.event.*;
import java.util.EventListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.farm.hatch.billStatus;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class HatchBaseDataEditUI extends AbstractHatchBaseDataEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(HatchBaseDataEditUI.class);

	/**
	 * output class constructor
	 */
	public HatchBaseDataEditUI() throws Exception
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

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();

		btnCancel.setEnabled(true);
		btnCancelCancel.setEnabled(true);


		btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.prmthatchFactory.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setWarehouseFilter();
			}

			});
		//设置孵化场 字段的F7的过滤条件
		setHacthFactoryFilter();

	}
	private void setWarehouseFilter() {
		// TODO Auto-generated method stub
		//0929修改
		String storageOrgUnitID=null;
		if(prmthatchFactory.getValue()!=null) {
			storageOrgUnitID=((IPropertyContainer) prmthatchFactory.getValue()).getString("name");
		}
		//仓库
	   EntityViewInfo ev=new EntityViewInfo();
       FilterInfo filter=new FilterInfo();
//       filter.getFilterItems().add(new FilterItemInfo("storageOrg.name","%"+storageOrgUnitID+"%",CompareType.LIKE));
       ev.setFilter(filter);  
       filter.getFilterItems().add(new FilterItemInfo("WHSTATE", "1",CompareType.EQUALS)); 
       //filter.setMaskString("#0 and #1");
       prmtdefaultBabyWarehouse.setEntityViewInfo(ev);
       prmtdefaultCDWarehouse.setEntityViewInfo(ev);
       prmtdefaultEggWarehouse.setEntityViewInfo(ev);
       prmtdefaultGrandWarehouse.setEntityViewInfo(ev);
       prmtdefaultParentWarehouse.setEntityViewInfo(ev);	
	}
	/**
	 * 设置孵化场 字段的F7的过滤条件 实现
	 * 只可以选择孵化场（当前只有一个孵化场）
	 */
	private void setHacthFactoryFilter() {
		// TODO Auto-generated method stub
		EntityViewInfo entityViewInfo=new EntityViewInfo();
		FilterInfo fiterInfo=new FilterInfo();
//		fiterInfo.getFilterItems().add(new FilterItemInfo("number","303%",CompareType.LIKE));
		entityViewInfo.setFilter(fiterInfo);
		prmthatchFactory.setEntityViewInfo(entityViewInfo);
		
			
	}

	/**
	 * 审核
	 */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(!editData.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.submit))
		{
			MsgBox.showWarning("只能审核提交状态下得瑟单据");
			abort();
			}
		super.actionAudit_actionPerformed(e);
		this.setMessageText("审核通过");
		this.showMessage();
//		reloadData();		
//		this.prmtcostCenter.setEnabled(false);
//		this.prmtdefaultBabyWarehouse.setEnabled(false);
//		this.prmtdefaultCDWarehouse.setEnabled(false);
//		this.prmtdefaultEggWarehouse.setEnabled(false);
//		this.prmtdefaultGrandWarehouse.setEnabled(false);
//		this.prmtdefaultParentWarehouse.setEnabled(false);
//		this.prmthatchFactory.setEnabled(false);
//		this.txtDescription.setEnabled(false);
//		
//		this.txteggQtyPerCar.setEnabled(false);
//		this.txthatchingDays.setEnabled(false);
//		this.txtName.setEnabled(false);
//		
//		this.txtNumber.setEnabled(false);
//		this.txtsaveDays.setEnabled(false);
//		this.txtSimpleName.setEnabled(false);
//		this.txthatchingRate.setEnabled(false);
//		
//		this.defaultEggSourceType.setEnabled(false);
//		this.defaultEggType.setEnabled(false);
//		editData.setBillStatus(com.kingdee.eas.farm.hatch.billStatus.audit);
		
		
		
		
		lockUIForViewStatus();
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		reloadData();
//		super.loadFields();
	}

	/**
	 * 禁用
	 */
	@Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(!editData.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.cancelcancel))
			return;
		super.actionCancel_actionPerformed(e);
		this.setMessageText("禁用通过");
		this.showMessage();
		reloadData();
	}

	/**
	 * 启用
	 */
	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		if(!editData.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.cancel)&&!editData.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.audit))
		{
			MsgBox.showWarning("只能启用审核的资料");
			abort();
			}
		super.actionCancelCancel_actionPerformed(e);
		this.setMessageText("启用通过");
		this.showMessage();
		reloadData();
		lockUIForViewStatus();
		
	}

	/**
	 * 编辑
	 */
	@Override
	public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(!editData.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.submit)&&!editData.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.save))
		{
			MsgBox.showWarning("当前状态下的单据禁止编辑");
			abort();
			}
		super.actionEdit_actionPerformed(arg0);
	}
	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(!editData.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.submit)&&!editData.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.save))
			{
			MsgBox.showWarning("当前状态下的单据禁止删除");
			abort();
			}
		super.actionRemove_actionPerformed(arg0);
	}
	/**
	 * 保存
	 */
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(editData.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.audit)&&editData.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.cancelcancel))
		{
		MsgBox.showWarning("不能修改审核或启用状态下的单据");
		abort();
		}
		super.actionSave_actionPerformed(e);
		reloadData();
	}
	/**
	 * 提交
	 */
	@Override
	public void actionSubmit_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(editData.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.audit)&&editData.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.cancelcancel))
		{
		MsgBox.showWarning("不能修改审核或启用状态下的单据");
		abort();
		}
		super.actionSubmit_actionPerformed(arg0);
	}
	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(!editData.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.audit)&&!editData.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.cancel))
			return;
		super.actionUnAudit_actionPerformed(e);
		this.setMessageText("反审核通过");
		this.showMessage();
		reloadData();
	}

	/**
	 * 重载单据内容
	 * @throws EASBizException
	 * @throws BOSException
	 * @throws Exception
	 */
	private void reloadData() throws EASBizException, BOSException, Exception{

		if ((this.editData == null) || (this.editData.getId() == null)) {
			return;
		}
		IObjectPK pk = new ObjectUuidPK(this.editData.getId());
		setDataObject(getValue(pk));
		EventListener[] lsts = removeDetailTableListener(KDTPropertyChangeListener.class);
		loadFields();
		restoreDetailTableListener(KDTPropertyChangeListener.class, lsts);
		initOldData(this.editData);
		setSave(true);
		setSaved(true);
		// 中断
		SysUtil.abort();



	}
	public void storeFields()
	{
		super.storeFields();
	}

	/**
	 * output setDataObject method
	 */
	public void setDataObject(IObjectValue dataObject) {
		super.setDataObject(dataObject);
		if(STATUS_ADDNEW.equals(getOprtState())) {
			editData.put("treeid",(com.kingdee.eas.farm.hatch.HatchBaseDataTreeInfo)getUIContext().get(UIContext.PARENTNODE));
		}
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.hatch.HatchBaseDataInfo objectValue = new com.kingdee.eas.farm.hatch.HatchBaseDataInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBillStatus(com.kingdee.eas.farm.hatch.billStatus.Addnew);
		return objectValue;
	}

}