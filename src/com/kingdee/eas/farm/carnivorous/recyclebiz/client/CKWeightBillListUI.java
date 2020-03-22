/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTSelectListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.base.commonquery.client.CommonQueryDialog;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.WeighBaseStatus;

/**
 * output class name
 */
public class CKWeightBillListUI extends AbstractCKWeightBillListUI
{
	private static final Logger logger = CoreUIObject.getLogger(CKWeightBillListUI.class);

	/**
	 * output class constructor
	 */
	public CKWeightBillListUI() throws Exception
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
	 * output actionEdit_actionPerformed
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception
	{
		checkSelected();
		if(this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(WeighBaseStatus.AUDIT_VALUE)||this.getBizInterface().getValue(new ObjectUuidPK(getSelectedKeyValue())).get("billStatus").equals(WeighBaseStatus.FINISH_VALUE)){
			MsgBox.showWarning("�����Ѿ���ɻ���ˣ���ֹ�޸ģ�");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
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
	protected FilterInfo getDefaultFilterForQuery() {
		// TODO Auto-generated method stub
		String orgID="filterOrgNumber";
		OrgUnitInfo orgInfo = SysContext.getSysContext().getCurrentOrgUnit();
		orgID=orgInfo.getId().toString();
		FilterInfo fliterInfo=super.getDefaultFilterForQuery();
		fliterInfo.getFilterItems().clear();
		fliterInfo.getFilterItems().add(new FilterItemInfo("storageOrgUnit.id",orgID,CompareType.EQUALS));
		if(orgInfo.isIsCompanyOrgUnit()) {
			fliterInfo.getFilterItems().add(new FilterItemInfo("company.id",orgID,CompareType.EQUALS));
			fliterInfo.setMaskString("#0 OR #1");
		}
		return fliterInfo;
	}

	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		initControl();
	}
	
	private void initControl() throws Exception{
		this.mBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.mBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.tBtnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.tBtnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

        this.btnAddNew.setVisible(false);	
        this.btnEdit.setVisible(false);	
		
		this.btnCancel.setVisible(true);
		this.btnCancelCancel.setVisible(true);

		this.tblMain.addKDTSelectListener(new KDTSelectListener(){
			public void tableSelectChanged(KDTSelectEvent e) {
				selectedRowChanged(e.getSelectBlock().getBeginRow());
			}});
	}

	/**
	 * ��ѡ�� �ı��¼�
	 * @param rowIndex
	 */
	private void selectedRowChanged(int rowIndex) {
		ArrayList list = this.getSelectedFieldValues("billStatus");
		if(list.size()>0) {
			if(list.get(0).equals(WeighBaseStatus.audit.getAlias())) {
				this.mBtnAudit.setEnabled(false);
				this.mBtnUnAudit.setEnabled(true);
				this.tBtnAudit.setEnabled(false);
				this.tBtnUnAudit.setEnabled(true);
				this.btnEdit.setEnabled(false);
				this.menuItemEdit.setEnabled(false);
			} else if(list.get(0).equals(WeighBaseStatus.finish.getAlias())) {
				this.mBtnAudit.setEnabled(true);
				this.mBtnUnAudit.setEnabled(false);
				this.tBtnAudit.setEnabled(true);
				this.tBtnUnAudit.setEnabled(false);
				this.btnEdit.setEnabled(true);
				this.menuItemEdit.setEnabled(true);
			}else{
				this.mBtnAudit.setEnabled(false);
				this.mBtnUnAudit.setEnabled(false);
				this.tBtnAudit.setEnabled(false);
				this.tBtnUnAudit.setEnabled(false);
				this.btnEdit.setEnabled(true);
				this.menuItemEdit.setEnabled(true);
			}
		}
	}

	protected boolean initDefaultFilter() {
		return true;
	}

	@Override
	protected CommonQueryDialog initCommonQueryDialog() {
		// TODO Auto-generated method stub
		CommonQueryDialog ds = super.initCommonQueryDialog();
		Date nowDate = new java.util.Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(sdf.format(nowDate)));
			cal.set(Calendar.DAY_OF_MONTH,1);//����Ϊ1��,��ǰ���ڼ�Ϊ���µ�һ�� 
			Date beginDate = cal.getTime();
			cal.add(Calendar.MONTH,1);//������1�� 
			cal.add(Calendar.DAY_OF_MONTH,-1);//���ڵ���һ��,�ȵõ��������һ�� 
			Date endDate = cal.getTime();
			EntityViewInfo ev=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("bizDate",beginDate,CompareType.GREATER_EQUALS));
			filter.getFilterItems().add(new FilterItemInfo("bizDate",endDate,CompareType.LESS_EQUALS));
			ev.setFilter(filter);
			ds.setDefalutEntityViewInfo(ev);		} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ds;
	}
	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.recyclebiz.CKWeightBillInfo();

		return objectValue;
	}

}