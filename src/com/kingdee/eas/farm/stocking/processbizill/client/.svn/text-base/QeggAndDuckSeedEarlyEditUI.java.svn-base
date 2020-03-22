/**
 * output package name
 */
package com.kingdee.eas.farm.stocking.processbizill.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.GroupLayout.Alignment;

import org.apache.log4j.Logger;
//import org.mozilla.javascript.edu.emory.mathcs.backport.java.util.Arrays;

import com.ibm.db2.jcc.am.kd;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.ncm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;

/**
 * output class name
 */
public class QeggAndDuckSeedEarlyEditUI extends AbstractQeggAndDuckSeedEarlyEditUI
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2238507561828523047L;
	private static final Logger logger = CoreUIObject.getLogger(QeggAndDuckSeedEarlyEditUI.class);


	public QeggAndDuckSeedEarlyEditUI() throws Exception
	{
		super();
	}
	@Override
	public void onLoad() throws Exception {
		setUITitle("2018年5.1日各区合格蛋、鸭苗库存");
		innitUI();
		super.onLoad();
	}


	@Override
	protected void setTableToSumField() {
		setTableToSumField(kdtEntrys,new String[]{"qEggLevel1","qEggLevelB2","qEggLevel2","seedLevel1","seedLevelSmall","seedLevel2","seedLevel3","seedLevelNo","seedLevelDead","seedInventorytotal","seedDuck","hatchLevel1","hatchLevelB2","hatchLevel2"});
	}

	private void innitUI() {
		this.actionAudit.setEnabled(true);
		this.actionUnAudit.setEnabled(true);
		kdtEntrys.getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);
		kdtEntrys.getColumn("seedInventorytotal").getStyleAttributes().setLocked(true);
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		kdtEntrys.addKDTEditListener(new KDTEditAdapter(){
			private int rowIndex;
			private int colIndex;

			@Override
			public void editStopped(KDTEditEvent e) {
				rowIndex = e.getRowIndex();
				colIndex = e.getColIndex();
				String[] seed={"seedLevel1","seedLevelSmall","seedLevel2","seedLevel3","seedLevelNo","seedLevelDead","seedDuck"};
				List<String> seedList=Arrays.asList(seed);
				if(seedList.contains(kdtEntrys.getColumnKey(colIndex))){
					BigDecimal seedLevel1 = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "seedLevel1").getValue());
					BigDecimal seedLevelSmall = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "seedLevelSmall").getValue());
					BigDecimal seedLevel2 = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "seedLevel2").getValue());
					BigDecimal seedLevel3 = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "seedLevel3").getValue());
					BigDecimal seedLevelNo = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "seedLevelNo").getValue());
					BigDecimal seedLevelDead = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "seedLevelDead").getValue());
					BigDecimal seedDuck = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "seedDuck").getValue());
					kdtEntrys.getCell(rowIndex, "seedInventorytotal").setValue(seedLevel1.add(seedLevelSmall).add(seedLevel2).add(seedLevel3).add(seedLevelNo).add(seedLevelDead).add(seedDuck));
				}
				super.editStopped(e);
			}
		});
	}

	@Override
	public void actionEdit_actionPerformed(ActionEvent arg0) throws Exception { 	
			if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
				MsgBox.showWarning("单据已经审核，禁止修改！");
				SysUtil.abort();
			}
		super.actionEdit_actionPerformed(arg0);
	}
	
	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止删除！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(arg0);
	}
	
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止保存！");
			SysUtil.abort();
		}
		super.actionSave_actionPerformed(e);
	}
	
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止提交！");
			SysUtil.abort();
		}
		super.actionSubmit_actionPerformed(e);
	}
	
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
    	if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据已经审核，禁止再次审核！");
    		SysUtil.abort();
    	}
    	if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
    		MsgBox.showWarning("单据尚未提交，禁止审核！");
    		SysUtil.abort();
    	}
		super.actionAudit_actionPerformed(e);
		
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	
    public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
    {
    	if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
    		MsgBox.showWarning("单据尚未审核，禁止反审核！");
    		SysUtil.abort();
    	}
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
    }
    

	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.stocking.processbizill.QeggAndDuckSeedEarlyInfo objectValue = new com.kingdee.eas.farm.stocking.processbizill.QeggAndDuckSeedEarlyInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		return objectValue;
	}

	@Override
	protected IObjectValue createNewDetailData(KDTable arg0) {
		return null;
	}

}