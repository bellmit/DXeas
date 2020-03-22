/**
 * output package name
 */
package com.kingdee.eas.custom.salaryvoucher.client;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.PanelUI;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.base.filter.filtermetadata.CompareType;
import com.kingdee.eas.basedata.framework.client.GeneralKDPromptSelectorAdaptor;
import com.kingdee.eas.basedata.org.AdminOrgUnitFactory;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.AdminF7;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.person.client.PersonF7UI;
import com.kingdee.eas.basedata.person.client.PersonPromptBox;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.salaryvoucher.voucherStatus;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class PersonRelationEditUI extends AbstractPersonRelationEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(PersonRelationEditUI.class);

	/**
	 * output class constructor
	 */
	public PersonRelationEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{				
		super.loadFields();

		//界面格式调整
		setUI();

		//设置人员和财务组织左树右表
		setPersonCompanyF7();
	}

	/**
	 *界面格式调整
	 */
	private void setUI() {
		// TODO Auto-generated method stub
		btnCopy.setVisible(false);
	}
	/**
	 * 设置人员和财务组织左树右表
	 */
	private void setPersonCompanyF7() {
		// TODO Auto-generated method stub
		HashMap map = new HashMap();
		map.put(PersonF7UI.ALL_ADMIN, "YES");
		CoreUIObject ui = null;// 父界面对象
		prmtEASperson.setSelector(new PersonPromptBox(ui, map));


		//财务组织
		CompanyF7 org = new CompanyF7(ui);
		org.setRootUnitID("");
		prmtcompanyOrg.setSelector(new CompanyF7(ui));

		//行政组织
		prmtAdminOrgUnit.setSelector(new AdminF7(ui));
	}
	/**
	 * 查询当前人员是否已经录入数据
	 */
	private void valiateData() {
		// TODO Auto-generated method stub
		if(prmtEASperson.getValue()!=null&&prmtcompanyOrg.getValue()!=null){
			String str="select fid from T_sal_PersonRelation where FEASPersonNum='"+((PersonInfo)prmtEASperson.getValue()).getNumber()+"'";
			str+=" and FCompanyOrgID='"+((CompanyOrgUnitInfo)prmtcompanyOrg.getValue()).getId().toString()+"'";
			try {
				IRowSet rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
				if(rs.next()){
					if(editData.getId()!=null)
						if(!editData.getId().toString().equals(rs.getString("fid"))){
							MsgBox.showInfo("已录入当前人员的对应关系，请勿重复录入");
							SysUtil.abort();
						}
				}
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}

	/**
	 * 审核
	 */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(editData.getId()!=null&&editData.getBillStatus().equals(voucherStatus.submit))
			super.actionAudit_actionPerformed(e);
		else{
			MsgBox.showInfo("只允许审核提交状态的单据");
			SysUtil.abort();
		}			
		refreshCurPage();
	}

	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(editData.getId()!=null&&editData.getBillStatus().equals(voucherStatus.audit))
			super.actionUnAudit_actionPerformed(e);
		else{
			MsgBox.showInfo("只允许反审核 已审核的单据");
			SysUtil.abort();
		}	
		refreshCurPage();

	}
	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		valiateData();
		super.beforeStoreFields(arg0);
	}
	/**
	 * output storeFields method
	 */
	public void storeFields()
	{		
		super.storeFields();
	}


	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		txtNumber.requestFocus(true);
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();




		//行政组织必须是叶子节点,监听事件
		prmtAdminOrgUnit.addChangeListener(new ChangeListener(){


			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				if(prmtAdminOrgUnit.getValue()!=null){					
					String Str = "select FIsLeaf from T_org_admin where fid='"+((AdminOrgUnitInfo)prmtAdminOrgUnit.getValue()).getId().toString()+"'";
					IRowSet rs;
					try {
						rs = SQLExecutorFactory.getRemoteInstance(Str).executeSQL();
						if(rs.next())
							if(!rs.getBoolean("FIsLeaf")){
								MsgBox.showInfo("所选的组织必须是明细行政组织");
								prmtAdminOrgUnit.setValue(null);
							}
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}


				}
			}});

		//字段隐藏
		contPersonNatureCode.setVisible(false);
		contPersonNatureName.setVisible(false);

		//按钮隐藏
		btnCancel.setVisible(false);
		btnCancelCancel.setVisible(false);
		//按钮图标修改
		btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		btnAudit.setHideActionText(true);
		btnUnAudit.setHideActionText(true);		
		btnAudit.setToolTipText("审核");
		btnUnAudit.setToolTipText("反审核");



		//设置基础资料过滤条件
		setprmtAdminOrgFilter();
		setprmtPersonNature();




		//根据EAS员工的编码获取sHR员工的编码和姓名
		this.prmtEASperson.addDataChangeListener(new DataChangeListener(){


			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(prmtEASperson.getValue()==null){
					txtEASPersonName.setStringValue("");
					txtshrPerson.setStringValue("");
					txtshrPersonName.setStringValue("");					
				}
				else{
					PersonInfo EASPerson = (PersonInfo)prmtEASperson.getValue();

					//查询行政组织是否是叶子节点
					try {
						if(com.kingdee.eas.custom.salaryvoucher.salaryVoucherFacadeFactory.getRemoteInstance().getbooleanAdminOrgUnit(EASPerson.getNumber())){
							String str = "select t3.fid from t_bd_person t1 inner join T_HR_PersonPosition t2 on t2.FpersonID=t1.fid ";
							str+="inner join T_org_admin t3 on t3.fid=t2.FPersonDep where t1.fnumber='"+EASPerson.getNumber()+"'";
							IRowSet rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
							if(rs.next()){
								AdminOrgUnitInfo adminOrgUnit=AdminOrgUnitFactory.getRemoteInstance().getAdminOrgUnitInfo(new ObjectUuidPK(rs.getString("fid")));
								prmtAdminOrgUnit.setValue(adminOrgUnit);
							}
						}
						else
							prmtAdminOrgUnit.setValue(null);
					} catch (EASBizException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BOSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//sHR数据库连接诶测试
					String [] con=new String[5];
					String str="select * from T_SAL_ConnectServer where FStatus=3";
					IRowSet rs;
					try {
						rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
						if(rs.next()){
							con[0]=rs.getString("FIP");
							con[1]=rs.getString("FPort");
							con[2]=rs.getString("FDataBaseName");
							con[3]=rs.getString("FUserName");
							con[4]=rs.getString("FUserPassWord");
							if(com.kingdee.eas.custom.salaryvoucher.salaryVoucherFacadeFactory.getRemoteInstance().getConnection(con))
								com.kingdee.eas.custom.salaryvoucher.salaryVoucherFacadeFactory.getRemoteInstance().getSHRPerson(EASPerson.getNumber(), con);				
						}
						else{
							MsgBox.showInfo("数据库连接配置错误");
							SysUtil.abort();
						}
						//查询sHR对应的人员姓名和编码
						String[] sHRPerson = com.kingdee.eas.custom.salaryvoucher.salaryVoucherFacadeFactory.getRemoteInstance().getSHRPerson(EASPerson.getNumber(),con);
						if(sHRPerson!=null){
							txtshrPerson.setStringValue(sHRPerson[0]);
							txtshrPersonName.setStringValue(sHRPerson[1]);
						}
					} catch (BOSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});
	}


	@Override
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(!editData.getBillStatus().equals(voucherStatus.audit)&&!editData.getBillStatus().equals(voucherStatus.submit))
			super.actionRemove_actionPerformed(e);
		else{
			MsgBox.showInfo("只允许删除保存状态的单据");
			SysUtil.abort();
		}
	}
	/**
	 * 员工性质
	 */
	private void setprmtPersonNature() {
		// TODO Auto-generated method stub


		EntityViewInfo evi=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("group.name","员工性质",com.kingdee.bos.metadata.query.util.CompareType.EQUALS));
		evi.setFilter(filter);

		prmtpersonNature.setEntityViewInfo(evi);
	}

	/**
	 * 行政组织过滤
	 */
	private void setprmtAdminOrgFilter() {
		// TODO Auto-generated method stub

		prmtAdminOrgUnit.setQueryInfo("com.kingdee.eas.basedata.org.app.AdminOrgUnitQuery");

		EntityViewInfo evInfo=new EntityViewInfo();
		FilterInfo filterInfo=new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("isLeaf",1,com.kingdee.bos.metadata.query.util.CompareType.EQUALS));
		evInfo.setFilter(filterInfo);
		prmtAdminOrgUnit.setEntityViewInfo(evInfo);

	}
	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.salaryvoucher.PersonRelationFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.salaryvoucher.PersonRelationInfo objectValue = new com.kingdee.eas.custom.salaryvoucher.PersonRelationInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCompanyOrg(SysContext.getSysContext().getCurrentFIUnit());
		return objectValue;
	}
	/**
	 * 刷新界面
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

}