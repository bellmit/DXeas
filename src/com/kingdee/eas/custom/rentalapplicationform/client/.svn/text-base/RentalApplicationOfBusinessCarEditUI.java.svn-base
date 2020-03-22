/**
 * output package name
 */
package com.kingdee.eas.custom.rentalapplicationform.client;

import java.awt.event.*;
import java.util.Date;
import java.util.EventListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.workflow.client.Client;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.master.cssp.client.ClientUtil;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.gpgc.client.FDCaptialChartUI;
import com.kingdee.eas.fi.cas.client.ClientUtils;
import com.kingdee.eas.fm.ecore.app.util.MsgBean;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.hr.emp.PersonPosition;
import com.kingdee.eas.hr.emp.PersonPositionCollection;
import com.kingdee.eas.hr.emp.PersonPositionFactory;
import com.kingdee.eas.hr.emp.PersonPositionInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;

/**
 * output class name
 */
public class RentalApplicationOfBusinessCarEditUI extends AbstractRentalApplicationOfBusinessCarEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(RentalApplicationOfBusinessCarEditUI.class);

	/**
	 * output class constructor
	 */
	public RentalApplicationOfBusinessCarEditUI() throws Exception
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
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarFactory.getRemoteInstance();
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
		com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarInfo objectValue = new com.kingdee.eas.custom.rentalapplicationform.RentalApplicationOfBusinessCarInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		if(SysContext.getSysContext().getCurrentUserInfo()!=null){
			objectValue.setApplier(SysContext.getSysContext().getCurrentUserInfo().getPerson());
			if(SysContext.getSysContext().getCurrentUserInfo().getPerson()!=null)
				objectValue.setContact(SysContext.getSysContext().getCurrentUserInfo().getPerson().getCell());
			objectValue.setPickUpInCompany(SysContext.getSysContext().getCurrentUserInfo().getPerson());//本公司接送人员
			try {
				objectValue.setApplyDepartment(this.getAdminOrgUnit(SysContext.getSysContext().getCurrentUserInfo().getPerson()));
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		objectValue.setUsedDate(new Date());


		return objectValue;
	}
	/**
	 * 获得当前员工的行政组织
	 * @param person
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private AdminOrgUnitInfo getAdminOrgUnit(PersonInfo person) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		AdminOrgUnitInfo adminOrgUnitInfo=null;
		if(person==null)
			return null;
		CoreBaseCollection coll = PersonPositionFactory.getRemoteInstance().getCollection(" where person='"+person.getId().toString()+"'");
		if(coll.size()<=0)
			return null;
		PersonPositionInfo personPosition = (PersonPositionInfo)coll.get(0);
		String id = personPosition.getPersonDep().getId().toString();
		if(!id.equals("")&&id!=null)
			adminOrgUnitInfo=AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(id));
		return adminOrgUnitInfo;
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		contLastUpdateTime.setVisible(true);
		contLastUpdateUser.setVisible(true);
		btnWorkFlowG.setVisible(false);
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		super.onLoad();
	}
	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		checkBillInWorkFlow();
		super.beforeStoreFields(arg0);
	}
	/**
	 * 检查单据
	 */
	private void checkBillInWorkFlow() {
		// TODO Auto-generated method stub

	}
	/**
	 * 重载单据内容
	 * @throws Exception 
	 * @throws BOSException 
	 * @throws EASBizException 
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

	/**
	 * 审核
	 */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		MsgBox.showInfo("审核成功");
		reloadData();
	}
	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		MsgBox.showInfo("反审核成功");
		reloadData();
	}
	
	/**
	 * 申请人修改时自动变更 申请部门和联系方式
	 */
	@Override
	protected void prmtapplier_dataChang(DataChangeEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(prmtapplier.getValue()==null)
			return;
		AdminOrgUnitInfo adminOrgUnit = commUtils.getAdminOrgUnit((PersonInfo)prmtapplier.getValue());
		if(adminOrgUnit!=null)
			prmtapplyDepartment.setValue(adminOrgUnit);//部门
		if(((PersonInfo)prmtapplier.getValue()).getCell()!=null&&!((PersonInfo)prmtapplier.getValue()).getCell().equals(""))
			txtcontact.setStringValue(((PersonInfo)prmtapplier.getValue()).getCell());
		else
			txtcontact.setStringValue("");//联系方式
			
		super.prmtapplier_dataChang(e);
	}

}