/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basebiz.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectBlock;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class MarginInitBillEditUI extends AbstractMarginInitBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(MarginInitBillEditUI.class);

	/**
	 * output class constructor
	 */
	public MarginInitBillEditUI() throws Exception
	{
		super();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}

	private boolean isLoadField=false;


	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);
		initControl();
	}

	private void initControl() {
		// TODO Auto-generated method stub
		kdtEntrys.getSelectManager().setSelectMode(KDTSelectManager.MULTIPLE_ROW_SELECT);
		
		if(prmtFICompany.getValue()!=null){
			String 	companyID=((IPropertyContainer) this.prmtFICompany.getValue()).getString("id");
			StockingComm.setFarmerFilter((KDBizPromptBox)kdtEntrys.getColumn("farmer").getEditor().getComponent(), companyID);
		}

		prmtFICompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent areg0) {
				if(prmtFICompany.getValue()!=null){
					String 	companyID=((IPropertyContainer) prmtFICompany.getValue()).getString("id");
					StockingComm.setFarmerFilter((KDBizPromptBox)kdtEntrys.getColumn("farmer").getEditor().getComponent(), companyID);
				}
			}	
		});

		kdtEntrys.addKDTEditListener(new KDTEditAdapter(){

			@Override
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);
				int rowIndex=e.getRowIndex();
				int colIndex=e.getColIndex();
				BigDecimal enableMargin=kdtEntrys.getCell(rowIndex, "enableMargin").getValue()==null?BigDecimal.ZERO:(BigDecimal)kdtEntrys.getCell(rowIndex, "enableMargin").getValue();
				BigDecimal occupyMargin=kdtEntrys.getCell(rowIndex, "occupyMargin").getValue()==null?BigDecimal.ZERO:(BigDecimal)kdtEntrys.getCell(rowIndex, "occupyMargin").getValue();
				BigDecimal totalMargin=enableMargin.add(occupyMargin);
				kdtEntrys.getCell(rowIndex, "totalMargin").setValue(totalMargin);
			}
		});
		kdtEntrys_detailPanel.getRemoveLinesButton().addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			KDTSelectManager selectManager = kdtEntrys.getSelectManager();
			int size = selectManager.size();
			KDTSelectBlock selectBlock = null;
			Set indexSet = new HashSet();
			for (int blockIndex = 0; blockIndex < size; ++blockIndex) {
				selectBlock = selectManager.get(blockIndex);
				int top = selectBlock.getBeginRow();
				int bottom = selectBlock.getEndRow();
				if (kdtEntrys.getRow(top) == null) {
					MsgBox.showInfo(EASResource.getString("com.kingdee.eas.framework.FrameWorkResource.Msg_NoneEntry"));
					return;
				}
				for (int i = top; i <= bottom; ++i) {
					indexSet.add(new Integer(i));
				}
			}
			Integer[] indexArr = new Integer[indexSet.size()];
			Object[] indexObj = indexSet.toArray();
			System.arraycopy(indexObj, 0, indexArr, 0, indexArr.length);
			Arrays.sort(indexArr);
			if (indexArr == null)
				return;
			for (int i = indexArr.length - 1; i >= 0; --i) {
				int rowIndex = Integer.parseInt(String.valueOf(indexArr[i]));
				if(	UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "unLockedOpMargin").getValue()).signum()>0){
					MsgBox.showWarning("包含已解锁过的初始化分录行,操作失败!");
					SysUtil.abort();
				}
			}
		}});
		
	}

	public void loadFields()
	{
		isLoadField=true;
		super.loadFields();
		isLoadField=false;

		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(true);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
		}else {
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
		}
	}



	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}

	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
	}
	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{
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
	/**
	 * output actionUnAudit_actionPerformed
	 */
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


	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub

		for(int i=0;i<kdtEntrys.getRowCount();i++){
			Object temp=kdtEntrys.getCell(i, "farmer").getValue();
			if(temp==null){
				MsgBox.showWarning("第"+(i+1)+"行分录养殖户不能为空");
				SysUtil.abort();
			}
			for (int j= i+1;j<kdtEntrys.getRowCount(); j++)
			{
				if (temp.equals(kdtEntrys.getCell(j, "farmer").getValue()))
				{
					MsgBox.showWarning("养殖户重复！");
					SysUtil.abort();
				}
			}
		}
		super.beforeStoreFields(arg0);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.basebiz.MarginInitBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.carnivorous.basebiz.MarginInitBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.basebiz.MarginInitBillInfo();
		if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));

		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		return objectValue;
	}

}