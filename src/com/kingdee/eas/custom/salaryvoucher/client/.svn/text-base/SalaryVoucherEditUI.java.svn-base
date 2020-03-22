/**
 * output package name
 */
package com.kingdee.eas.custom.salaryvoucher.client;

import java.awt.Component;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import chrriis.common.Filter;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.master.account.AccountViewInfo;
import com.kingdee.eas.basedata.master.account.client.AccountPromptBox;
import com.kingdee.eas.basedata.master.auxacct.AsstActTypeFactory;
import com.kingdee.eas.basedata.master.auxacct.AsstActTypeInfo;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeGroupCollection;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeGroupFactory;
import com.kingdee.eas.basedata.master.auxacct.IGeneralAsstActTypeGroup;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.salaryvoucher.PersonRelationFactory;
import com.kingdee.eas.custom.salaryvoucher.PersonRelationInfo;
import com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntry;
import com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryAssistActItemInfo;
import com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryCmpItem;
import com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryCmpItemInfo;
import com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryInfo;
import com.kingdee.eas.fi.fa.manage.AssistActItemFactory;
import com.kingdee.eas.fi.fa.manage.AssistActItemInfo;
import com.kingdee.eas.fi.gl.WSVoucher;
import com.kingdee.eas.fi.gl.WSVoucherFactory;
import com.kingdee.eas.fi.gl.WSVoucherInfo;
import com.kingdee.eas.fi.gl.common.GLf7Utils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.ctrl.extendcontrols.IDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.KDCheckBox;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;

/**
 * output class name
 */
public class SalaryVoucherEditUI extends AbstractSalaryVoucherEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(SalaryVoucherEditUI.class);

	/**
	 * output class constructor
	 */
	public SalaryVoucherEditUI() throws Exception
	{
		super();
	}
	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		valiate();
		super.beforeStoreFields(arg0);
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
		//设定一个监听事件，由科目带出核算项目
		setAccountEntryListener();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{		
		super.storeFields();
	}

	/**
	 * 保存事件校验
	 */
	private void valiate() {
		// TODO Auto-generated method stub
		if(txtname.getStringValue().equals("")){
			MsgBox.showInfo("模板名称不允许为空");
			SysUtil.abort();
		}	

		if(kdtEntrys.getRowCount()<2){
			MsgBox.showInfo("科目分录至少要有借贷两项");
			SysUtil.abort();
		}





		//科目必须包含薪酬项目
		for(int i=0;i<kdtEntrys.getRowCount();i++){
			SalaryVoucherEntryInfo entryInfo = (SalaryVoucherEntryInfo)kdtEntrys.getRow(i).getUserObject();
			if(!entryInfo.getBoolean("isAllCmpItem"))
				if(entryInfo.getCmpItem().size()==0){
					MsgBox.showInfo("科目分录"+String.valueOf(i+1)+"没有薪酬项目");
					SysUtil.abort();
				}
		}

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
		return com.kingdee.eas.custom.salaryvoucher.SalaryVoucherFactory.getRemoteInstance();
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


		//UI界面各字段格式设置
		setUIformat();

		//设定一个监听事件，由科目带出核算项目
		setAccountEntryListener();		

	}

	protected void setAccountEntryListener() {
		// TODO Auto-generated method stub

		//会计科目自动带出核算项目的监听事件
		kdtEntrys.addKDTEditListener(new KDTEditAdapter() {
			public void editStopped(KDTEditEvent e) {
				try {
					kdtEntrys_Changed(e.getRowIndex(),e.getColIndex());
				}
				catch (Exception exc) {
					handUIException(exc);
				}
			}

			private void kdtEntrys_Changed(int rowIndex, int colIndex) {
				// TODO Auto-generated method stub
				if(kdtEntrys.getColumn(colIndex).getKey().equalsIgnoreCase("Accounting")&&kdtEntrys.getCell(rowIndex, colIndex).getValue()!=null){
					ArrayList<AsstActTypeInfo> AAII=this.getassistActItem((AccountViewInfo)kdtEntrys.getCell(rowIndex,colIndex).getValue());
					SalaryVoucherEntryInfo entryInfo = (SalaryVoucherEntryInfo) kdtEntrys.getRow(rowIndex).getUserObject();

					for(int j=0;j<entryInfo.getAssistActItem().size();j++)
						entryInfo.getAssistActItem().remove(entryInfo.getAssistActItem().get(j));

					for(int i=0;i<AAII.size();i++){

						SalaryVoucherEntryAssistActItemInfo item = new SalaryVoucherEntryAssistActItemInfo();

						item.setAssistActItemName(AAII.get(i).getName());
						item.setAssistActItemNum(AAII.get(i).getNumber());
						//						item.setParent1(entryInfo);
						if(!isExist(entryInfo,item))
							entryInfo.getAssistActItem().add(item);
					}
				}				
			}




			private boolean isExist(SalaryVoucherEntryInfo entryInfo,
					SalaryVoucherEntryAssistActItemInfo item) {
				// TODO Auto-generated method stub
				for(int i=0;i<entryInfo.getAssistActItem().size();i++){
					if(item.getAssistActItemName().equalsIgnoreCase(entryInfo.getAssistActItem().get(i).getAssistActItemName()))
						if(item.getAssistActItemNum().equalsIgnoreCase(entryInfo.getAssistActItem().get(i).getAssistActItemNum()))
							return true;
				}
				return false;
			}

			/**
			 * 根据会计及科目得到会计科目对应的核算项目类别
			 * @param value 会计科目
			 * @return      核算项目类别的集合
			 */
			private ArrayList<AsstActTypeInfo> getassistActItem(AccountViewInfo value) {
				// TODO Auto-generated method stub

				ArrayList<AsstActTypeInfo> AAII = new ArrayList<AsstActTypeInfo>();
				StringBuffer sb=new StringBuffer();
				sb.append(" select t4.fid,t4.fname_l2 from T_BD_AccountView t1");
				sb.append(" inner join T_BD_AsstAccount t2 on t2.fid=t1.FCAA");
				sb.append(" inner join T_BD_AsstActGroupDetail t3 on t3.FAsstAccountID=t2.fid");
				sb.append(" inner join T_BD_AsstActType t4 on t4.fid=t3.FAsstActTypeID");
				sb.append(" where t1.fid='").append(value.getId().toString()).append("'");
				sb.append(" group by t4.fid,t4.fname_l2");
				try {
					IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
					while(rs.next()){
						String fid=rs.getString("fid");
						AsstActTypeInfo AAIInfo = AsstActTypeFactory.getRemoteInstance().getAsstActTypeInfo(new ObjectUuidPK(fid));
						AAII.add(AAIInfo);
					}
					return AAII;
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
		});

	}

	/**
	 * 界面字段的格式设置
	 */
	private void setUIformat() throws EASBizException, BOSException, SQLException {
		// TODO Auto-generated method stub


		//按钮设置
		btnVoucher.setVisible(true);

		//表头格式设置
		contcompanyOrg.setEnabled(false);
		contBizDate.setVisible(false);
		contDescription.setVisible(false);
		txtname.setRequired(true);
		contstatus.setEnabled(false);







		//第一标题(科目)格式设置

		//仅选择当前财务组织的会计科目
		CompanyOrgUnitInfo FIUnit = SysContext.getSysContext().getCurrentFIUnit();
		String FIUnitNumber = SysContext.getSysContext().getCurrentFIUnit().getNumber();		
		Object objAccouting=kdtEntrys.getColumn("Accounting").getEditor().getComponent();
		if(objAccouting instanceof KDBizPromptBox){
			KDBizPromptBox prmtF7Accounting = (KDBizPromptBox)objAccouting;

			//设置科目F7左树右表
			CoreUIObject ui=null;
			prmtF7Accounting.setSelector(new AccountPromptBox(ui, FIUnit, new FilterInfo()));


			EntityViewInfo evi=new EntityViewInfo();
			FilterInfo filter=new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("companyID.number",FIUnitNumber,CompareType.EQUALS));
			evi.setFilter(filter);
			prmtF7Accounting.setEntityViewInfo(evi);
		}


		//第二表体(核算项目)格式设置
		kdtAssistActItem.getColumn("seq").getStyleAttributes().setHided(true);
		kdtAssistActItem.getColumn("assistActItemName").getStyleAttributes().setLocked(true);
		kdtAssistActItem.getColumn("assistActItemNum").getStyleAttributes().setLocked(true);
		kdtAssistActItem_detailPanel.getAddNewLineButton().setEnabled(false);
		kdtAssistActItem_detailPanel.getInsertLineButton().setEnabled(false);



		//第三表体(薪酬项目)格式设置
		kdtCmpItem.getColumn("seq").getStyleAttributes().setHided(true);

		//第四表体人员格式设置
		if(kdtPerson.getRowCount()==0)
			loadPersonnel();//加载人员列表

		//设置研发项目的过滤条件
		setGreenDreamProjectFilter();


		kdtPerson.getColumn("seq").getStyleAttributes().setHided(true);
		kdtPerson.getStyleAttributes().setLocked(true);
		kdtPerson.getColumn("selected").getStyleAttributes().setLocked(false);

		kdtPerson.getColumn("GreenDreamProject").getStyleAttributes().setLocked(false);
		kdtPerson_detailPanel.getAddNewLineButton().setEnabled(false);
		kdtPerson_detailPanel.getInsertLineButton().setEnabled(false);
		kdtPerson_detailPanel.getRemoveLinesButton().setEnabled(false);


		//全选和反选  按钮的实现
		btnSelectAll.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<kdtPerson.getRowCount();i++){
					kdtPerson.getCell(i, "selected").setValue(true);
				}
			}});

		btnSelectNull.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<kdtPerson.getRowCount();i++){
					kdtPerson.getCell(i, "selected").setValue(false);
				}
			}});


		//表尾字段设置
		contLastUpdateTime.setVisible(true);
		contLastUpdateUser.setVisible(true);
	}

	/**
	 * 设置职员分录的研发项目f7的过滤条件
	 */
	private void setGreenDreamProjectFilter() {
		// TODO Auto-generated method stub
		Component obj = kdtPerson.getColumn("GreenDreamProject").getEditor().getComponent();
		KDBizPromptBox f7 = null;
		if(obj instanceof KDBizPromptBox)
			f7=(KDBizPromptBox)obj;
		EntityViewInfo evi=new EntityViewInfo();
		FilterInfo filterInfo=new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("group.name","研发项目",CompareType.EQUALS));
		evi.setFilter(filterInfo);

		f7.setEntityViewInfo(evi);	


	}
	/**
	 * 生成凭证
	 */
	@Override
	public void actionVoucher_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(editData.getId()==null)		{
			MsgBox.showWarning("该凭证模板尚未保存");
			abort();
		}
		String destBillEditUIClassName ="com.kingdee.eas.custom.salaryvoucher.client.SwitchToVoucher";
		Map map = new UIContext(this);
		map.put("srcBillID",editData.getId().toString());
		map.put(UIContext.OWNER, this);
		IUIWindow uiWindow = null ;
		uiWindow = UIFactory.createUIFactory(UIFactoryName.MODEL).create(destBillEditUIClassName, map, null,OprtState.ADDNEW);
		//开始展现 UI
		uiWindow.show();
		//		super.actionVoucher_actionPerformed(e);
	}
	/**
	 * 加载员工
	 */
	protected void loadPersonnel() throws BOSException, SQLException, EASBizException{


		String companyID = SysContext.getSysContext().getCurrentFIUnit().getId().toString();
		StringBuffer sb=new StringBuffer();


		sb.append("select t1.fid,t5.fid id from T_SAL_PersonRelation t5");
		sb.append(" inner join  t_bd_person t1 on t5.FEASPersonID=t1.fid");
		sb.append(" inner join T_HR_BDEmployeeType t2 on t2.fid=t1.FEmployeeTypeID and t2.fname_l2 not in('离职')");
		sb.append(" where t5.FCompanyOrgID='").append(companyID).append("'");
		sb.append(" and t5.FBillStatus=2");

		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
		while(rs.next()){
			String personId = rs.getString("id");
			PersonRelationInfo personInfo = PersonRelationFactory.getRemoteInstance().getPersonRelationInfo(new ObjectUuidPK(personId));
			PersonInfo personInfos = PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(rs.getString("fid")));
			kdtPerson.addRow();
			kdtPerson.getRow(kdtPerson.getRowCount()-1).getCell("selected").setValue(true);
			kdtPerson.getRow(kdtPerson.getRowCount()-1).getCell("number").setValue(personInfos);
			kdtPerson.getRow(kdtPerson.getRowCount()-1).getCell("name").setValue(personInfo.getEASPersonName());
			kdtPerson.getRow(kdtPerson.getRowCount()-1).getCell("shrPersonNum").setValue(personInfo.getShrPerson());
			kdtPerson.getRow(kdtPerson.getRowCount()-1).getCell("shrPersonName").setValue(personInfo.getShrPersonName());

		}
	}

	protected com.kingdee.bos.dao.IObjectValue createNewData() 
	{

		if(!isEntityCompany()){
			MsgBox.showInfo("当前财务组织不是有效的实体财务组织");
			SysUtil.abort();
		}

		com.kingdee.eas.custom.salaryvoucher.SalaryVoucherInfo objectValue = new com.kingdee.eas.custom.salaryvoucher.SalaryVoucherInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		//当前财务组织
		objectValue.setCompanyOrg(SysContext.getSysContext().getCurrentFIUnit());
		return objectValue;
	}

	/**
	 * 查询当前的财务组织是否是实体财务组织
	 */
	protected Boolean isEntityCompany(){
		CompanyOrgUnitInfo company = SysContext.getSysContext().getCurrentFIUnit();
		if(company==null)
			return false;
		String str="select FIsBizUnit from T_ORG_Company where fid='"+company.getId().toString()+"'";
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
			if(rs.next())
				if(rs.getInt("FIsBizUnit")==0)
					return false;
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;

	}

}