/**
 * output package name
 */
package com.kingdee.eas.custom.purchasebudget.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;

/**
 * output class name
 */
public class PurBudgetEditUI extends AbstractPurBudgetEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(PurBudgetEditUI.class);

	/**
	 * output class constructor
	 */
	public PurBudgetEditUI() throws Exception
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

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.purchasebudget.PurBudgetFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{

		return null;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		kdtEntrys.getColumn("amt").getStyleAttributes().setLocked(true);
		
		setBudgetRowFilter();
	}
	/**
	 * 设置分录行的过滤条件
	 */
	private void setBudgetRowFilter() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.purchasebudget.PurBudgetInfo objectValue = new com.kingdee.eas.custom.purchasebudget.PurBudgetInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		objectValue.setBizDate(new Date());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		return objectValue;
	}
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		refreshCurPage();
		setMessageText("审核成功");
		showMessage();
	}
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(editData.getId()!=null)
			if(ClientUtils.checkBillInWorkflow(this, editData.getId().toString())){
				MsgBox.showInfo("当前单据正处于工作流中，请稍后再试");
				SysUtil.abort();
			}
		super.actionSave_actionPerformed(e);
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(editData.getId()!=null)
			if(ClientUtils.checkBillInWorkflow(this, editData.getId().toString())){
				MsgBox.showInfo("当前单据正处于工作流中，请稍后再试");
				SysUtil.abort();
			}
		super.actionSubmit_actionPerformed(e);

	}
	@Override
	public void actionRemove_actionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(editData.getId()!=null)
			if(ClientUtils.checkBillInWorkflow(this, editData.getId().toString())){
				MsgBox.showInfo("当前单据正处于工作流中，请稍后再试");
				SysUtil.abort();
			}
		super.actionRemove_actionPerformed(arg0);
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		refreshCurPage();
		setMessageText("反审核成功");
		showMessage();
	}
	/**
	 * output actionSubmit_actionPerformed
	 * 刷新操作
	 */
	protected void refreshCurPage() throws EASBizException, BOSException, Exception {
		if (editData.getId() != null) {
			com.kingdee.bos.dao.IObjectPK iObjectPk = new ObjectUuidPK(editData.getId());
			IObjectValue iObjectValue = getValue(iObjectPk);
			setDataObject(iObjectValue);
			loadFields();
			setSave(true);
		}
	}
	@Override
	protected void kdtEntrys_editStart(KDTEditEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.kdtEntrys_editStart(e);
	}
	/**
	 * 计算某分录行的金额
	 * @param rowIndex
	 * @param colIndex
	 */
	private void calculateAmt(int rowIndex, int colIndex) {
		// TODO Auto-generated method stub
		if(kdtEntrys.getCell(rowIndex, "price").getValue()!=null&&kdtEntrys.getCell(rowIndex, "qty").getValue()!=null){
			BigDecimal price = (BigDecimal)kdtEntrys.getCell(rowIndex, "price").getValue();
			BigDecimal qty = (BigDecimal)kdtEntrys.getCell(rowIndex, "qty").getValue();
			kdtEntrys.getCell(rowIndex, "amt").setValue(price.multiply(qty));
		}
	}
	@Override
	protected void kdtEntrys_editStopp(KDTEditEvent e) throws Exception {
		// TODO Auto-generated method stub
		if("price".equals(kdtEntrys.getColumn(e.getColIndex()).getKey())||"qty".equals(kdtEntrys.getColumn(e.getColIndex()).getKey()))
			calculateAmt(e.getRowIndex(),e.getColIndex());
		super.kdtEntrys_editStopp(e);
	}  
}