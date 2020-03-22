/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.base.permission.UserFactory;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.PositionFactory;
import com.kingdee.eas.basedata.org.PositionInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.wages.AppraisalclientFactory;
import com.kingdee.eas.custom.wages.AppraisalclientInfo;
import com.kingdee.eas.custom.wages.BasicPostInfo;
import com.kingdee.eas.custom.wages.ClaimMethod;
import com.kingdee.eas.custom.wages.HospitalFactory;
import com.kingdee.eas.custom.wages.HospitalInfo;
import com.kingdee.eas.custom.wages.InjuryinsuranceEntry;
import com.kingdee.eas.custom.wages.InjuryinsuranceEntryInfo;
import com.kingdee.eas.custom.wages.InsuranceTypeFactory;
import com.kingdee.eas.custom.wages.InsuranceTypeInfo;
import com.kingdee.eas.custom.wages.byThePieceUnit;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.multiDetail.DetailPanel;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.excel.ExcelReadUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.util.KDTableUtil;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.KDButton;
import com.kingdee.bos.ctrl.swing.KDPanel;

/**
 * output class name
 */
public class InjuryinsuranceEditUI extends AbstractInjuryinsuranceEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(InjuryinsuranceEditUI.class);

	/**
	 * output class constructor
	 */
	public InjuryinsuranceEditUI() throws Exception
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
	/* (non-Javadoc)
	 * @see com.kingdee.eas.framework.client.CoreBillEditUI#onLoad()
	 */
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		intUI();
		importEx.setEnabled(true);
		addButtonToHMDEntry(kdtEntrys,importEx,5);

	}
	private void addButtonToHMDEntry(KDTable table, KDButton button,int width) {  
		if (table.getParent() == null || table.getParent().getParent() == null)  
			return;  
		// 隐藏按钮  
		Component c = table.getParent().getParent();  
		if (c instanceof DetailPanel) {  
			JPanel panel = (JPanel) c;  
			JPanel controlPanel = null;  
			// 获取controlPanel  
			Component[] components = panel.getComponents();  
			for (int i = 0; i < components.length; i++) {  
				Component component = components[i];  
				if ("controlPanel".equals(component.getName())) {  
					controlPanel = (KDPanel) component;  
				}  
			}  
			// 获取btn  
			if (controlPanel != null) {  
				Rectangle rect = table.getBounds();  
				int x = rect.width - (button.getWidth() +86+ width);  
				controlPanel.add(button, new com.kingdee.bos.ctrl.swing.KDLayout.Constraints(x, 3, button.getWidth(), 19, 9));  
			}  
		}  

	} 
	private void intUI() {
		// TODO Auto-generated method stub	  
		CompanyOrgUnitInfo company = SysContext.getSysContext().getCurrentFIUnit(); 
		//		 	//Person
		KDBizPromptBox prmtPerson = (KDBizPromptBox) kdtEntrys.getColumn("person").getEditor().getComponent(); // 人员F7  
		EntityViewInfo view2 = new EntityViewInfo(); // 新定义视图  
		FilterInfo filter2 = new FilterInfo(); // 设置过滤条件  
		filter2.getFilterItems().add(new FilterItemInfo("CU2.longNumber", "%"+company.getNumber()+"%",CompareType.LIKE)); // 按照当前单位登记过滤  
		//filter.getFilterItems().add(new FilterItemInfo("bizStatus", BizStatusEnum.NORMAL_VALUE)); // 添加正常状态筛选条件  
		view2.setFilter(filter2); // 设置过滤条件  
		prmtPerson.setEntityViewInfo(view2); // 重新设定视图  
		//prmtHfPerson.setEnabledMultiSelection(true); //F7多选  
		kdtEntrys_detailPanel.getAddNewLineButton().addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				if(kdtEntrys.getRowCount() > 1){
					IRow row = kdtEntrys.getRow(kdtEntrys.getRowCount() - 1);
					IRow oldRow = kdtEntrys.getRow(kdtEntrys.getRowCount() - 2);
					copyDataFromOldRowToNewRow(oldRow,row);
				}
			}});
		kdtEntrys_detailPanel.getInsertLineButton().addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				IRow row = KDTableUtil.getSelectedRow(kdtEntrys);
				if(row == null){
					if(kdtEntrys.getRowCount() > 1){
						row = kdtEntrys.getRow(kdtEntrys.getRowCount() - 1);
						IRow oldRow = kdtEntrys.getRow(kdtEntrys.getRowCount() - 2);
						copyDataFromOldRowToNewRow(oldRow,row);
					}
				}else if(row.getRowIndex() != 0){
					IRow oldRow = kdtEntrys.getRow(row.getRowIndex() - 1);
					copyDataFromOldRowToNewRow(oldRow,row);
				}
			}});
		
		
		 final KDBizPromptBox kdtEntrys_cuser_PromptBox = new KDBizPromptBox();
	        kdtEntrys_cuser_PromptBox.setQueryInfo("com.kingdee.eas.base.permission.app.F7AllUserQuery");
	        kdtEntrys_cuser_PromptBox.setVisible(true);
	        kdtEntrys_cuser_PromptBox.setEditable(true);
	        kdtEntrys_cuser_PromptBox.setDisplayFormat("$name$");
	        kdtEntrys_cuser_PromptBox.setEditFormat("$number$");
	        kdtEntrys_cuser_PromptBox.setCommitFormat("$number$");
	        KDTDefaultCellEditor kdtEntrys_cuser_CellEditor = new KDTDefaultCellEditor(kdtEntrys_cuser_PromptBox);
	        this.kdtEntrys.getColumn("cuser").setEditor(kdtEntrys_cuser_CellEditor);
	        ObjectValueRender kdtEntrys_cuser_OVR = new ObjectValueRender();
	        kdtEntrys_cuser_OVR.setFormat(new BizDataFormat("$name$"));
	        this.kdtEntrys.getColumn("cuser").setRenderer(kdtEntrys_cuser_OVR);
	        
	        

	}

	/**
	 * 复制上一行的数据到新增的行
	 * @param oldRow
	 * @param row
	 */
	protected void copyDataFromOldRowToNewRow(IRow oldRow, IRow row) {
		// TODO Auto-generated method stub
		for(int i = 0, size = kdtEntrys.getColumnCount(); i < size; i++){
			if(i != kdtEntrys.getColumnIndex("id")){
				row.getCell(i).setValue(oldRow.getCell(i).getValue());
			}
		}
	}
	@Override
	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		// TODO Auto-generated method stub
		super.kdtEntrys_Changed(rowIndex, colIndex);	
		kdtEntrys.getCell(rowIndex,"cuser").setValue((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		kdtEntrys.getCell(rowIndex,"sjfzr").setValue(((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser())).getName());

		
		kdtEntrys.getCell(rowIndex,"company").setValue(this.prmtcompanyOrg.getValue());


	}


	@Override
	public void actionAddLine_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAddLine_actionPerformed(e);
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
		if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
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
		if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止刪除！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
	}


	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.SUBMITED)) {
			MsgBox.showWarning("单据尚未提交，禁止审核！");
			SysUtil.abort();
		}
		super.actionAudit_actionPerformed(e);
		this.editData.setBillStatus(BillBaseStatusEnum.AUDITED);
		//this.setDataObject(this.getBizInterface().getValue(new ObjectUuidPK(this.editData.getId())));
		this.loadData();
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}

	/**
	 * output actionUnaudit_actionPerformed
	 */
	public void actionUnaudit_actionPerformed(ActionEvent e) throws Exception
	{
		if(!FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
		}
		super.actionUnaudit_actionPerformed(e);
		//this.setDataObject(this.editData);
		this.loadData();
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}


	@Override
	public void actionImportEx_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionImportEx_actionPerformed(e);
		Map<Integer,Map<Integer,Object>> excelValues = ExcelReadUtil.getExcelData();
		if(excelValues != null){
			kdtEntrys.removeRows();
			PersonInfo p = new PersonInfo();
			BasicPostInfo b = new BasicPostInfo();
			PositionInfo pt = new PositionInfo();
			CompanyOrgUnitInfo cp = new CompanyOrgUnitInfo();
			HospitalInfo hp = new HospitalInfo();
			InsuranceTypeInfo inty = new InsuranceTypeInfo();
			AppraisalclientInfo aci = new AppraisalclientInfo();
			for(int i = 2; i <= excelValues.size(); i++){
				Map<Integer,Object> rowValues = new HashMap<Integer, Object>(); 
				rowValues = excelValues.get(i);
				if(rowValues.values() == null) continue;
				IRow row = kdtEntrys.addRow();
				String personid = "";
				String ptid = "";
				String companyid = "";
				String hospid = "";
				String InsuranceType = "";
				String getAppraisalclientID = "";
				for (Integer in : rowValues.keySet()) {
					//map.keySet()返回的是所有key的值					
					Object obj = rowValues.get(in);//得到每个key对应value的值
					switch(in){
					case 1://员工编码
						if(obj != null){
							personid = getPersonID(obj.toString());
							p = PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(personid));
							row.getCell(in).setValue(p);
							if(p.getId()!=null){
								row.getCell(in+1).setValue(p.getName());
								//row.getCell(in+5).setValue(p.getState());
							}
						}
						break;
					case 2:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 3:
						if(obj != null){
							if(getCompanyID(obj.toString())!=null){
								companyid = getCompanyID(obj.toString()); 
								cp = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(companyid));
								row.getCell(in).setValue(cp);	
							}
							
						}
						break;
					case 4:
//						if(obj != null){
//							ptid = getPositionID(obj.toString());
//							pt = PositionFactory.getRemoteInstance().getPositionInfo(new ObjectUuidPK(ptid));
//							row.getCell(in).setValue(pt);
//						}
						break;
					case 5:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 6:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 7:
						if(obj != null){
							if(getHosptiID(obj.toString())!=null){
								hospid =getHosptiID(obj.toString());
								hp = HospitalFactory.getRemoteInstance().getHospitalInfo(new ObjectUuidPK(hospid));
								row.getCell(in).setValue(hp);

							}
													}
						break;
					case 8:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 9:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 10:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 11:
						if(obj != null){
							if(getInsuranceTypeID(obj.toString())!=null){
								InsuranceType = getInsuranceTypeID(obj.toString());
								inty = InsuranceTypeFactory.getRemoteInstance().getInsuranceTypeInfo(new ObjectUuidPK(InsuranceType));
								row.getCell(in).setValue(inty);
							}
							
						}
						break;
					case 12:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 13:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 14:
						if(obj != null){
							if(getAppraisalclientID(obj.toString())!=null){
								getAppraisalclientID = getAppraisalclientID(obj.toString());
								aci = AppraisalclientFactory.getRemoteInstance().getAppraisalclientInfo(new ObjectUuidPK(getAppraisalclientID));
								row.getCell(in).setValue(aci);
							}
						
						}
						break;
					case 15:
						if(obj != null){
							row.getCell(in).setValue(obj);
						}
						break;
					case 16:
						if(obj != null){
							if(getuserID(obj.toString())!=null){
								String Userid = getuserID(obj.toString());
								UserInfo uinfo = UserFactory.getRemoteInstance().getUserInfo(Userid);
								row.getCell(in).setValue((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
							}
							
						}
						break;
					case 17:
						//理赔方式 下拉列表
						if(obj != null){
							String objS = (String)obj;
							if(objS.equals("公司赔付")){
								row.getCell(in+1).setValue(ClaimMethod.getEnumList().get(0));
							}else if(objS.equals("个人赔付")){
								row.getCell(in+1).setValue(ClaimMethod.getEnumList().get(1));
							}else{
								row.getCell(in+1).setValue(null);
							}
							//row.getCell(in).setValue(obj);
						}
						break;
					case 18:
						if(obj != null){
							row.getCell(in+1).setValue(obj);
						}
						break;
					case 19:
						if(obj != null){
							row.getCell(in+1).setValue(obj);
						}
						break;
					case 20:
						if(obj != null){
							row.getCell(in+1).setValue(obj);
						}
						break;
					case 21:
						if(obj != null){
							row.getCell(in+1).setValue(obj);
						}
						break;
					
					
					}	
				}
			}
		}
	}
	//用户名获取用户id
	private String getPersonID(String personnumber) throws BOSException, SQLException{
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select FID from ").append(sp);
		sql.append("T_BD_Person ").append(sp);
		//sql.append("inner join T_BD_Person  t2  on t2.FID = t1.FPersonID").append(sp);
		sql.append("where FNumber ='").append(personnumber).append("'").append(sp);
		//System.out.println("获取用户id"+sql.toString());
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		String personID = null ;
		while(rs.next()){
			personID = rs.getString("FID");
		}
		return personID;
	}
	//用户名获取职位id
	private String getPositionID(String personnumber) throws BOSException, SQLException{
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select FPositionID from ").append(sp);
		sql.append("T_ORG_PositionMember ").append(sp);
		//sql.append("inner join T_BD_Person  t2  on t2.FID = t1.FPersonID").append(sp);
		sql.append("where FPersonID ='").append(personnumber).append("'").append(sp);
		System.out.println("获取职位id"+sql.toString());
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		String personID = null ;
		while(rs.next()){
			personID = rs.getString("FPositionID");
		}
		return personID;
	}
	//obj名获取公司id
	private String getCompanyID(String personnumber) throws BOSException, SQLException{
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select fid from ").append(sp);
		sql.append("T_ORG_Company ").append(sp);
		//sql.append("inner join T_BD_Person  t2  on t2.FID = t1.FPersonID").append(sp);
		sql.append("where FName_l2 ='").append(personnumber).append("'").append(sp);
		System.out.println("获取公司id"+sql.toString());
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		String personID = null ;
		while(rs.next()){
			personID = rs.getString("fid");
		}
		return personID;
	}
	//obj名获取医院id
	private String getHosptiID(String personnumber) throws BOSException, SQLException{
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select fid from ").append(sp);
		sql.append("CT_WAG_Hospital ").append(sp);
		//sql.append("inner join T_BD_Person  t2  on t2.FID = t1.FPersonID").append(sp);
		sql.append("where FName_l2 ='").append(personnumber).append("'").append(sp);
		System.out.println("获取医院id"+sql.toString());
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		String personID = null ;
		while(rs.next()){
			personID = rs.getString("fid");
		}
		return personID;
	}
	//obj名获取险种id
	private String getInsuranceTypeID(String personnumber) throws BOSException, SQLException{
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select fid from ").append(sp);
		sql.append("CT_WAG_InsuranceType ").append(sp);
		//sql.append("inner join T_BD_Person  t2  on t2.FID = t1.FPersonID").append(sp);
		sql.append("where FName_l2 ='").append(personnumber).append("'").append(sp);
		System.out.println("获取险种id"+sql.toString());
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		String personID = null ;
		while(rs.next()){
			personID = rs.getString("fid");
		}
		return personID;
	}
	//obj名获取委托鉴定方id
	private String getAppraisalclientID(String personnumber) throws BOSException, SQLException{
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select fid from ").append(sp);
		sql.append("CT_WAG_Appraisalclient ").append(sp);
		//sql.append("inner join T_BD_Person  t2  on t2.FID = t1.FPersonID").append(sp);
		sql.append("where FName_l2 ='").append(personnumber).append("'").append(sp);
		System.out.println("获取鉴定方id"+sql.toString());
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		String personID = null ;
		while(rs.next()){
			personID = rs.getString("fid");
		}
		return personID;
	}
	//obj名获取userid
	private String getuserID(String personnumber) throws BOSException, SQLException{
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("select fid from ").append(sp);
		sql.append("T_PM_User ").append(sp);
		//sql.append("inner join T_BD_Person  t2  on t2.FID = t1.FPersonID").append(sp);
		sql.append("where FName_l2 ='").append(personnumber).append("'").append(sp);
		System.out.println("获取userid"+sql.toString());
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		String personID = null ;
		while(rs.next()){
			personID = rs.getString("fid");
		}
		return personID;
	}
	
	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.wages.InjuryinsuranceFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{
		InjuryinsuranceEntryInfo info = new InjuryinsuranceEntryInfo();
		if(table.getRowCount()>0){
			info = (InjuryinsuranceEntryInfo) table.getRow(0).getDataStyle().getUserObject();
			return info;
		}else{
			return null;
		}

	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.wages.InjuryinsuranceInfo objectValue = new com.kingdee.eas.custom.wages.InjuryinsuranceInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		objectValue.setCompanyOrg(SysContext.getSysContext().getCurrentFIUnit());
		return objectValue;
	}

}