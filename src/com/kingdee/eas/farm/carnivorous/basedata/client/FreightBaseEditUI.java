/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.ep.client.editor.kdtable.KDTTableView;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.client.EASResource;

/**
 * output class name
 */
public class FreightBaseEditUI extends AbstractFreightBaseEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(FreightBaseEditUI.class);

	/**
	 * output class constructor
	 */
	public FreightBaseEditUI() throws Exception
	{
		super();
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		initTable();
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		kdtEntry.getColumn("seq").getStyleAttributes().setHided(true);
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
		if(oprtState.equals("ADDNEW")){
			kDTabbedPane1.setSelectedIndex(1);
			kDTabbedPane1.setEnabledAt(0, false);
		}

		if(this.editData.getBillStatus()!=null) {
			if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
				this.actionCancel.setEnabled(true);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(false);
			}
			else if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(true);
				this.actionEdit.setEnabled(false);
			} else {
				this.actionCancel.setEnabled(false);
				this.actionCancelCancel.setEnabled(false);
				this.actionEdit.setEnabled(true);
			}
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
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.basedata.FreightBaseFactory.getRemoteInstance();
	}


	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.basedata.FreightBaseInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.FreightBaseInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setBeginDate(DateUtilsComm.getCurrentPeriodInfo().getBeginDate());
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.YEAR, 1);
		objectValue.setEndDate(cal.getTime());
		return objectValue;
	}

	private void initTable() {
		// TODO Auto-generated method stub
		kDTable1.addRows(3);
		kDTable1.getCell(0, 0).setValue("如果");
		kDTable1.getCell(1, 0).setValue("那么");
		kDTable1.getCell(2, 0).setValue("否则");

		kDTable2.addRows(3);
		kDTable2.getCell(0, 0).setValue("运费金额");
		kDTable2.getCell(1, 0).setValue("运费里程");
		kDTable2.getCell(2, 0).setValue("运费吨数");

		kDTable1.getStyleAttributes().setLocked(true);
		kDTable2.getStyleAttributes().setLocked(true);

		kDTable1.addKDTMouseListener(new KDTMouseListener(){

			public void tableClicked(KDTMouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount()==2){
					String str=kDTable1.getCell(kDTable1.getSelectManager().getActiveRowIndex(), kDTable1.getSelectManager().getActiveColumnIndex()).getValue().toString();
					txtformalText.insert(str, txtformalText.getSelectionStart());
				}
			}});
		
		kDTable2.addKDTMouseListener(new KDTMouseListener(){

			public void tableClicked(KDTMouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount()==2){
					String str=kDTable2.getCell(kDTable2.getSelectManager().getActiveRowIndex(), kDTable2.getSelectManager().getActiveColumnIndex()).getValue().toString();
					txtformalText.insert(str, txtformalText.getSelectionStart());
				}
			}});
	}
	
	 @Override
		public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
			// TODO Auto-generated method stub
			super.actionAudit_actionPerformed(e);
			this.doAfterSave(new ObjectUuidPK(editData.getId()));
			setOprtState(STATUS_VIEW);
			lockUIForViewStatus();
			setNextMessageText("审核成功");
			setShowMessagePolicy(0);
			setIsShowTextOnly(false);
			showMessage();
		}
		@Override
		public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
			// TODO Auto-generated method stub
			super.actionUnAudit_actionPerformed(e);
			this.doAfterSave(new ObjectUuidPK(editData.getId()));
			setOprtState(STATUS_VIEW);
			lockUIForViewStatus();
			setNextMessageText("反审核成功");
			setShowMessagePolicy(0);
			setIsShowTextOnly(false);
			showMessage();
		}

}