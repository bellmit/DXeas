/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import bsh.ParseException;

import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.hatch.EarlyEggStockFactory;
import com.kingdee.eas.farm.hatch.EarlyEggStockInfo;
import com.kingdee.eas.farm.hatch.IEarlyEggStock;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.ncm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class EarlyEggStockEditUI extends AbstractEarlyEggStockEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(EarlyEggStockEditUI.class);
	private Dimension screenSize;

	/**
	 * output class constructor
	 */
	public EarlyEggStockEditUI() throws Exception
	{
		super();
		//界面最大化
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();  
		this.setPreferredSize(screenSize);
	}
	
	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		btnAudit.setEnabled(false);
		if (editData.getId()!=null) {
			btnAudit.setEnabled(true);
		}
		CompanyOrgUnitInfo currOrgUnitInfo = (CompanyOrgUnitInfo)SysContext.getSysContext().getCurrentOrgUnit(OrgType.Company);
        
//      currOrgUnitInfo = SysContext.getSysContext().getCurrentFIUnit();
      String cuid;
      cuid = currOrgUnitInfo.getId().toString().trim();
      if (cuid.equals("00000000-0000-0000-0000-000000000000CCE7AED4")) {
	        MsgBox.showInfo("当前公司为虚体，不允许使用该功能。请选择实体公司！");
	        SysUtil.abort();
      }
	}

	public void actionSave_actionPerformed(ActionEvent e) throws Exception
	{
		storeFields();
		if(this.editData.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.audit)) {
			MsgBox.showWarning("单据已经审核，无需保存！");
			SysUtil.abort();
		}
		super.actionSave_actionPerformed(e);
	}

	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.audit)) {
			MsgBox.showWarning("单据已经审核，不能提交！");
			SysUtil.abort();
		}
		super.actionSubmit_actionPerformed(e);
	}


	public void actionEdit_actionPerformed(ActionEvent e) throws Exception
	{
		if(this.editData.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.submit)) {
			MsgBox.showWarning("单据已经提交，禁止修改！");
			SysUtil.abort();
		}
		if(this.editData.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.audit)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	/**
	 * output actionRemove_actionPerformed
	 */
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception
	{
		if(this.editData.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.submit)) {
			MsgBox.showWarning("单据已经提交，禁止删除！");
			SysUtil.abort();
		}
		if(this.editData.getBillStatus().equals(com.kingdee.eas.farm.hatch.billStatus.audit) ){
			MsgBox.showWarning("单据已经审核，禁止删除！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
	}

	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if(editData.getId()!=null){
			String id= editData.getId().toString();
			IEarlyEggStock instance= EarlyEggStockFactory.getRemoteInstance();
			EarlyEggStockInfo info=instance.getEarlyEggStockInfo(new ObjectUuidPK(id));
			if (com.kingdee.eas.farm.hatch.billStatus.submit.equals(info.getBillStatus())) {
				instance.audit(editData);
				//				this.setDataObject(getValue(new ObjectUuidPK(editData.getId())));
				//				this.setOprtState(OprtState.VIEW);  
				//				this.loadFields();  
				this.doAfterSave(new ObjectUuidPK(editData.getId()));
				MsgBox.showInfo("审核成功");
				//             	getUIWindow().close();
			}else if(com.kingdee.eas.farm.hatch.billStatus.audit.equals(info.getBillStatus())){
				MsgBox.showWarning("单据已经审核，禁止再次审核！");
				SysUtil.abort();
			}
			else{
				MsgBox.showWarning("未提交，不能审核");
				SysUtil.abort();
			}
			super.actionAudit_actionPerformed(e);
		}
	}


	@Override
	protected IObjectValue createNewData() {
		EarlyEggStockInfo objectValue = new EarlyEggStockInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setFICompany((CompanyOrgUnitInfo) SysContext.getSysContext().getCurrentOrgUnit(OrgType.Company));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		Date bizDate;
		try {
			bizDate = sdf.parse(sdf.format(new Date()));
			objectValue.setBizDate(bizDate);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return objectValue;
	}
	@Override
	protected IObjectValue createNewDetailData(KDTable arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}