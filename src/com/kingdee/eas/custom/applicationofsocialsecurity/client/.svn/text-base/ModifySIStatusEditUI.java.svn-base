/**
 * output package name
 */
package com.kingdee.eas.custom.applicationofsocialsecurity.client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventListener;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.bi.model.commonui.propsheet.beans.value.StringValue;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.reportone.forapp.eas.EasResource;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.EASResource;
import com.kingdee.eas.basedata.person.Genders;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurity;
import com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurityEntryInfo;
import com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurityInfo;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionFactory;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionInfo;
import com.kingdee.eas.custom.applicationofsocialsecurity.socialSecurityFacadeFactory;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
@SuppressWarnings("unchecked")
public class ModifySIStatusEditUI extends AbstractModifySIStatusEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(ModifySIStatusEditUI.class);

	DataBaseConnectionInfo dataBaseConnectionInfo=null;
	ApplicationOfSocialSecurityInfo info=null;
	private String shrPersonNum="";


	/**
	 * output class constructor
	 */
	public ModifySIStatusEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		super.loadFields();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
	}


	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		if(this.getUIContext().get("srcBillInfo")!=null)
			info=(ApplicationOfSocialSecurityInfo)this.getUIContext().get("srcBillInfo");

		try {
			if(info!=null)
				loadPersonFromApplicationOfSocialSecurity();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		setUI();
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
		return com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusFactory.getRemoteInstance();
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
		com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusInfo objectValue = new com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		objectValue.setBizDate(new Date());
		objectValue.setCreator(SysContext.getSysContext().getCurrentUserInfo());

		return objectValue;
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();


		CoreBaseCollection coll = DataBaseConnectionFactory.getRemoteInstance().getCollection("where billStatus=3");
		if(coll.size()==0)
			commUtils.giveUserTipsAndRetire("没有启用的数据库连接配置");
		dataBaseConnectionInfo = (DataBaseConnectionInfo)coll.get(0);

		ArrayList<String> listStatus = socialSecurityFacadeFactory.getRemoteInstance().getSHRSIStatus(dataBaseConnectionInfo);
		if(listStatus.size()>0)
			for(String i:listStatus)
				cBoxSSStatus.addItem(i);
		cBoxSSStatus.addItem("");
		cBoxSSStatus.addItem("空");

		ArrayList<String> companyName =socialSecurityFacadeFactory.getRemoteInstance().getCompanyNameFromSHR(dataBaseConnectionInfo);
		for(String i:companyName)
			cBoxCompany.addItem(i);
		cBoxCompany.addItem("");

	}

	/**
	 * 
	 * @param obj
	 */
	private void setKdtEntrys(HashMap<String, Object> obj) {
		// TODO Auto-generated method stub
		kdtEntrys.getStyleAttributes().setLocked(true);
		kdtEntrys.getColumn("isSelected").getStyleAttributes().setLocked(false);

		for(int i=0;i<obj.size()-1;i++){
			if(obj.get(String.valueOf(i))!=null)
				kdtEntrysAddRow((ApplicationOfSocialSecurityEntryInfo)obj.get(String.valueOf(i)));
		}
	}


	/**
	 * 分录添加字段
	 * @param object
	 */
	private void kdtEntrysAddRow(ApplicationOfSocialSecurityEntryInfo info) {
		// TODO Auto-generated method stub
		if(info==null)
			return;
		kdtEntrys.addRow();

		kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "isSelected").setValue(false);
		kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "shrPersonNum").setValue(info.getShrPersonCode());
		kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "shrPersonName").setValue(info.getPersonName());
		kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "department").setValue(info.getDepartment());
		kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "position").setValue(info.getPosition());
		kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "gender").setValue(info.getGender());
		kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "enterDate").setValue(info.getEnterDate());
		kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "srcSIStatus").setValue(info.getSrcSIStatus());
		kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "contact").setValue(info.getContact());
	}


	/**
	 * 分录添加字段
	 * @param object
	 * @throws ParseException 
	 */
	private void kdtEntrysModifyRow(String [] str,int rowIndex) throws ParseException{

		kdtEntrys.getCell(rowIndex, "isSelected").setValue(false);

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");


		if(!str[1].equals("0000"))
			kdtEntrys.getCell(rowIndex,"shrPersonName").setValue(str[1]);//编码
		else
			kdtEntrys.getCell(rowIndex, "shrPersonName").setValue(null);

		if(!str[0].equals("0000"))
			kdtEntrys.getCell(rowIndex,"shrPersonNum").setValue(str[0]);//姓名
		else
			kdtEntrys.getCell(rowIndex, "shrPersonNum").setValue(null);

		if(!str[2].equals("0000"))
			kdtEntrys.getCell(rowIndex,"empType").setValue(str[2]);//用工关系状态
		else
			kdtEntrys.getCell(rowIndex, "empType").setValue(null);

		if(!str[10].equals("0000"))
			kdtEntrys.getCell(rowIndex,"srcSIStatus").setValue(str[10]);//原社保状态
		else
			kdtEntrys.getCell(rowIndex, "srcSIStatus").setValue(null);


		if(!str[3].equals("0000"))
			kdtEntrys.getCell(rowIndex,"enterDate").setValue(sdf.parse(str[3]));//入职日期
		else
			kdtEntrys.getCell(rowIndex, "enterDate").setValue(null);

		if(!str[7].equals("0000")){
			if(str[7].equals("男"))
				kdtEntrys.getCell(rowIndex,"gender").setValue(Genders.Male);
			if(str[7].equals("女"))
				kdtEntrys.getCell(rowIndex,"gender").setValue(Genders.Female);//性别
		}


		if(!str[11].equals("0000"))
			kdtEntrys.getCell(rowIndex,"company").setValue(str[11]);//公司
		else
			kdtEntrys.getCell(rowIndex, "company").setValue(null);

		if(!str[4].equals("0000"))
			kdtEntrys.getCell(rowIndex,"department").setValue(str[4]);//部门
		else
			kdtEntrys.getCell(rowIndex, "department").setValue(null);


		if(!str[5].equals("0000"))
			kdtEntrys.getCell(rowIndex,"position").setValue(str[5]);//岗位
		else
			kdtEntrys.getCell(rowIndex, "position").setValue(null);


		if(!str[8].equals("0000"))
			kdtEntrys.getCell(rowIndex,"contact").setValue(str[8]);//联系方式
		else
			kdtEntrys.getCell(rowIndex, "contact").setValue(null);
	}
	/**
	 * 界面设置
	 */
	private void setUI() {
		// TODO Auto-generated method stub

		btnAddNew.setVisible(false);
		btnAddNew.setVisible(false);
		btnSubmit.setVisible(false);
		btnCopy.setVisible(false);
		btnAttachment.setVisible(false);
		btnRemove.setVisible(false);
		btnPrint.setVisible(false);
		btnPrintPreview.setVisible(false);
		btnFirst.setVisible(false);
		btnUndoAll.setVisible(false);
		btnLast.setVisible(false);
		btnNext.setVisible(false);
		btnPre.setVisible(false);
		btnWorkFlowG.setVisible(false);
		btnCreateFrom.setVisible(false);
		btnCreateTo.setVisible(false);
		btnAuditResult.setVisible(false);
		btnAddNew.setVisible(false);
		btnMultiapprove.setVisible(false);
		btnNextPerson.setVisible(false);
		btnAddNew.setVisible(false);
		toolBar.remove(btnAuditResult);
		btnSave.setEnabled(false);
		btnEdit.setEnabled(false);


		btnUnDoSelected.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_undo"));


		kdtEntrys.getColumn("isSelected").setWidth(60);
		chkisIn.setSelected(true);

		kdtEntrys.getStyleAttributes().setLocked(true);
		kdtEntrys.getColumn("isSelected").getStyleAttributes().setLocked(false);
		kdtEntrys.getColumn("shrPersonNum").getStyleAttributes().setLocked(false);
		kdtEntrys.getColumn("company").setWidth(170);





		if(info!=null){
			kdtEntrys.getColumn("shrPersonNum").getStyleAttributes().setLocked(true);
			kdtEntrys_detailPanel.getAddNewLineButton().setEnabled(false);
			kdtEntrys_detailPanel.getInsertLineButton().setEnabled(false);
			kdtEntrys_detailPanel.getRemoveLinesButton().setEnabled(false);
			btnFilter.setEnabled(false);

			//			DataChangeListener[] dcls = btnFilter.getmouse(DataChangeListener.class);
			//			for(int i = 0; dcls.length > 0 && i<dcls.length; i++){
			//				prmtpresentedPerson.removeDataChangeListener(dcls[i]);
			//			}
			MouseListener[] ss = null;
			if(btnFilter.getMouseListeners()!=null)
				ss=btnFilter.getMouseListeners();
			for(int i=0;i<ss.length;i++)
				btnFilter.removeMouseListener(ss[i]);
		}


	}

	//确认
	@Override
	protected void btnConfirm_mouseClick(MouseEvent e) throws Exception {
		// TODO Auto-generated method stub

		//校验
		int number=0;
		for(int i=0;i<kdtEntrys.getRowCount();i++)
			if(kdtEntrys.getCell(i, "isSelected").getValue().equals(true))
				++number;
		if(number==0)
			commUtils.giveUserTipsAndRetire("请选择分录行");



		//获得选中的社保状态的ID

		String personNum = "";
		if(cBoxSSStatus.getSelectedItem().equals("")||cBoxSSStatus.getSelectedItem().equals("空"))
			commUtils.giveUserTipsAndRetire("该社保状态不符合条件");
		String SIStatusName = (String) cBoxSSStatus.getSelectedItem();
		String SIStatusID = socialSecurityFacadeFactory.getRemoteInstance().getSIStatusIDBaseOnHisName(SIStatusName, dataBaseConnectionInfo);
		if(SIStatusID==null||SIStatusID.equals(""))
			commUtils.giveUserTipsAndRetire("获取社保状态的ID失败");



		int countNeedntModify=0;
		int countNeedModify=0;
		int countModifyCorrect=0;
		int countSelected=0;

		HashMap<String,String> map=null;
		String returnStr="";
		//修改数据
		for(int i=0;i<kdtEntrys.getRowCount();i++)
			if(kdtEntrys.getCell(i, "isSelected").getValue().equals(true)){


				countSelected++;//选中行数统计

				if(kdtEntrys.getCell(i, "desSIStatus").getValue()!=null&&!((String)kdtEntrys.getCell(i, "desSIStatus").getValue()).equals("")){
					if(SIStatusName.equals((String)kdtEntrys.getCell(i, "desSIStatus").getValue())){
						countNeedntModify++;
						continue;
					}
					else
						countNeedModify++;
				}
				else
					if(kdtEntrys.getCell(i, "srcSIStatus").getValue()!=null&&!kdtEntrys.getCell(i, "srcSIStatus").getValue().equals(""))
						if(kdtEntrys.getCell(i, "srcSIStatus").getValue().toString().equals(SIStatusName)){
							countNeedntModify++;
							continue;
						}
						else
							countNeedModify++;



				if(kdtEntrys.getCell(i, "shrPersonNum").getValue()!=null)
					personNum=(String)kdtEntrys.getCell(i, "shrPersonNum").getValue();
				else
					continue;
				//更新状态
				socialSecurityFacadeFactory.getRemoteInstance().updateSIStatusBaseOnPersonNumAndSIStatusID(SIStatusID, personNum, dataBaseConnectionInfo);

				//获取修改后的社保状态
				map = socialSecurityFacadeFactory.getRemoteInstance().getInfoOfPersonBaseOnNumberOrName(personNum, null, dataBaseConnectionInfo);
				returnStr=map.get(personNum);
				String []str=returnStr.split("_");
				//如果修改后的社保状态和传入的社保状态不相等，则  将目标社保状态设置为   修改后的社保状态
				if(kdtEntrys.getCell(i, "srcSIStatus").getValue()!=null&&kdtEntrys.getCell(i, "srcSIStatus").getValue().equals(str[11]))
					kdtEntrys.getCell(i, "desSIStatus").setValue(null);
				else{

					if(str[11].equals(SIStatusName)){
						kdtEntrys.getCell(i, "desSIStatus").setValue(str[11]);
						countModifyCorrect++;
					}
				}
			}


		String result="";
		if(countSelected==countNeedntModify)
			result="选中的数据中没有需要修改的数据";
		else{
			result="操作结束,本次操作共选中";
			result+=String.valueOf(countSelected)+"条记录";

			if(countModifyCorrect>0)
				result+=",成功修改"+String.valueOf(countModifyCorrect)+"条";
			if(countNeedntModify>0)
				result+=","+String.valueOf(countNeedntModify)+"条记录不需要修改";
		}




		MsgBox.showInfo(result);		
		super.btnConfirm_mouseClick(e);
		reloadData();
	}
	/**
	 * 过滤符合条件的sHR的人员
	 */
	@Override
	protected void btnFilter_mouseClick(MouseEvent e) throws Exception {
		// TODO Auto-generated method stub

		kdtEntrys.removeRows();

		//从界面上获取参数
		boolean isIn=chkisIn.isSelected();//是否在职
		String company=null;//公司
		String SIStatus=null;//社保状态
		Date dateBegin=null;//入职开始日期
		Date dateEnd=null;//入职结束日期
		String name=null;
		String number=null;

		if(!cBoxCompany.getSelectedItem().equals(""))
			company=cBoxCompany.getSelectedItem().toString();

		if(!cBoxSSStatus.getSelectedItem().equals(""))
			SIStatus=cBoxSSStatus.getSelectedItem().toString();

		if(pkenterDateFrom.getValue()!=null)
			dateBegin=(Date)pkenterDateFrom.getValue();
		if(pkenterDateTo.getValue()!=null)
			dateEnd=(Date)pkenterDateTo.getValue();
		if(txtpersonNum.getStringValue()!=null&&!txtpersonNum.getStringValue().equals("")){
			if(txtpersonNum.getStringValue().indexOf("--")>=0||txtpersonNum.getStringValue().indexOf("'")>=0||txtpersonNum.getStringValue().indexOf(";")>=0)
				commUtils.giveUserTipsAndRetire("请不要输入非法字符");
			number=txtpersonNum.getStringValue();
		}
		if(txtpersonName.getStringValue()!=null&&!txtpersonName.getStringValue().equals("")){
			if(txtpersonName.getStringValue().indexOf("--")>=0||txtpersonName.getStringValue().indexOf("'")>=0||txtpersonName.getStringValue().indexOf(";")>=0)
				commUtils.giveUserTipsAndRetire("请不要输入非法字符");
			name=txtpersonName.getStringValue();
		}
		if(pkenterDateFrom.getValue()!=null&&pkenterDateTo.getValue()!=null)
			if(dateBegin.after(dateEnd))
				commUtils.giveUserTipsAndRetire("入职日期从不能晚于日期到");

		ArrayList<String> list=new ArrayList<String>();
		list=socialSecurityFacadeFactory.getRemoteInstance().getPersonInfoByFilterItem(dateBegin,dateEnd,dataBaseConnectionInfo,isIn,company,SIStatus,name,number);
		if(list.size()==0)
			commUtils.giveUserTipsAndRetire("未获取到符合条件的数据");

		displayPersonInformat(list);

		super.btnFilter_mouseClick(e);
	}

	/**
	 * 部署选中
	 */
	@Override
	public void actionUndoSelected_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		//校验
		int number=0;
		for(int i=0;i<kdtEntrys.getRowCount();i++)
			if(kdtEntrys.getCell(i, "isSelected").getValue().equals(true))
				++number;
		if(number==0)
			commUtils.giveUserTipsAndRetire("请选择分录行");



		String personNum="";
		String SIStatusID =""; 
		String SIStatusName="";
		HashMap<String,String> map=new HashMap<String, String>();
		String returnStr="";


		int countSelectedNum=0;
		int countNoNeedModify=0;
		int countModifyCorrect=0;



		//修改数据
		for(int i=0;i<kdtEntrys.getRowCount();i++){
			if(kdtEntrys.getCell(i, "isSelected").getValue().equals(false))
				continue;

			countSelectedNum++;//选中的行数

			if(kdtEntrys.getCell(i, "desSIStatus").getValue()==null){
				countNoNeedModify++;
				continue;
			}

			if(kdtEntrys.getCell(i, "shrPersonNum").getValue()!=null)
				personNum=(String)kdtEntrys.getCell(i, "shrPersonNum").getValue();
			else
				continue;
			if(kdtEntrys.getCell(i, "srcSIStatus").getValue()!=null)
				SIStatusName=(String)kdtEntrys.getCell(i, "srcSIStatus").getValue();
			else
				continue;
			//更新状态
			SIStatusID=socialSecurityFacadeFactory.getRemoteInstance().getSIStatusIDBaseOnHisName(SIStatusName, dataBaseConnectionInfo);
			socialSecurityFacadeFactory.getRemoteInstance().updateSIStatusBaseOnPersonNumAndSIStatusID(SIStatusID, personNum, dataBaseConnectionInfo);

			//获取修改后的社保状态
			map = socialSecurityFacadeFactory.getRemoteInstance().getInfoOfPersonBaseOnNumberOrName(personNum, null, dataBaseConnectionInfo);
			returnStr=map.get(personNum);
			String []str=returnStr.split("_");
			//如果修改后的社保状态和传入的社保状态不相等，则  将目标社保状态设置为   修改后的社保状态
			if(kdtEntrys.getCell(i, "srcSIStatus").getValue()==null&&(str[11]==null||str[11].equals("0000"))){
				kdtEntrys.getCell(i, "desSIStatus").setValue(null);countModifyCorrect++;
			}
			else if(kdtEntrys.getCell(i, "srcSIStatus").getValue().equals(str[11])){kdtEntrys.getCell(i, "desSIStatus").setValue(null);countModifyCorrect++;}
			else
				kdtEntrys.getCell(i, "desSIStatus").setValue(str[11]);

		}
		String result="";
		if(countNoNeedModify==countSelectedNum)
			result="选中的分录中没有需要修改的数据";
		else{
			result+="操作结束，本次共选中"+String.valueOf(countSelectedNum)+"条数据";
			result+=","+String.valueOf(countModifyCorrect)+"条数据修改成功";
			if(countNoNeedModify>0)
				result+=","+String.valueOf(countNoNeedModify)+"条数据不需要修改";
		}
		MsgBox.showInfo(result);
		super.actionUndoSelected_actionPerformed(e);
	}
	//反选
	@Override
	protected void btnFselect_mouseClick(MouseEvent e) throws Exception {
		// TODO Auto-generated method stub
		for(int i=0;i<kdtEntrys.getRowCount();i++)
			if(kdtEntrys.getCell(i, "isSelected").getValue().equals(true))
				kdtEntrys.getCell(i, "isSelected").setValue(false);
			else
				kdtEntrys.getCell(i, "isSelected").setValue(true);
		super.btnFselect_mouseClick(e);
	}
	/**
	 * 全选
	 */
	@Override
	protected void btnSelectAll_mouseClick(MouseEvent e) throws Exception {
		// TODO Auto-generated method stub
		for(int i=0;i<kdtEntrys.getRowCount();i++)
			kdtEntrys.getCell(i, "isSelected").setValue(true);
		super.btnSelectAll_mouseClick(e);
	}
	//全不选
	@Override
	protected void btnSelectNull_mouseClick(MouseEvent e) throws Exception {
		// TODO Auto-generated method stub
		for(int i=0;i<kdtEntrys.getRowCount();i++)
			if(kdtEntrys.getCell(i, "isSelected").getValue().equals(true))
				kdtEntrys.getCell(i, "isSelected").setValue(false);
		super.btnSelectNull_mouseClick(e);
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
	 * 展示获取的相关数据
	 * @param list
	 * @throws ParseException 
	 */
	private void displayPersonInformat(ArrayList<String> list) throws ParseException {
		// TODO Auto-generated method stub
		String []str=new String[12];;
		for(int i=0;i<list.size();i++){
			str=list.get(i).split("_");
			kdtEntrys.addRow();
			kdtEntrysModifyRow(str,kdtEntrys.getRowCount()-1);
		}
	}

	@Override
	protected void kdtEntrys_editStopp(KDTEditEvent e) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<String>();
		if(kdtEntrys.getColumn(e.getColIndex()).getKey().equals("shrPersonNum")){
			if(kdtEntrys.getCell(e.getRowIndex(), e.getColIndex()).getValue()==null)
				commUtils.giveUserTipsAndRetire("员工编码不能为空");
			if(!kdtEntrys.getCell(e.getRowIndex(), e.getColIndex()).getValue().toString().equals(shrPersonNum)){
				list = socialSecurityFacadeFactory.getRemoteInstance().getPersonInfoByFilterItem(null,null,dataBaseConnectionInfo,true,null,null,null,kdtEntrys.getCell(e.getRowIndex(), e.getColIndex()).getValue().toString());
				if(list.size()>0){
					kdtEntrysModifyRow(list.get(0).split("_"),e.getRowIndex());
					return;
				}
				else{
					list=socialSecurityFacadeFactory.getRemoteInstance().getPersonInfoByFilterItem(null,null,dataBaseConnectionInfo,false,null,null,null,kdtEntrys.getCell(e.getRowIndex(), e.getColIndex()).getValue().toString());
					if(list.size()>0){
						kdtEntrysModifyRow(list.get(0).split("_"),e.getRowIndex());
						return;
					}
				}
				MsgBox.showInfo("未找到SHR中该编码对应的人员");
				kdtEntrys.getCell(e.getRowIndex(), e.getColIndex()).setValue(shrPersonNum);
			}
		}
		super.kdtEntrys_editStopp(e);
	}

	/**
	 * 分录编辑事件处理
	 */
	@Override
	protected void kdtEntrys_editStartin(KDTEditEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(kdtEntrys.getColumn(e.getColIndex()).getKey().equals("shrPersonNum"))
			if(kdtEntrys.getCell(e.getRowIndex(), e.getColIndex()).getValue()!=null)
				shrPersonNum=kdtEntrys.getCell(e.getRowIndex(), e.getColIndex()).getValue().toString();
		super.kdtEntrys_editStartin(e);
	}

	/**
	 * 从社保申请单加载员工
	 * @throws BOSException 
	 * @throws EASBizException 
	 * @throws ParseException 
	 */
	private void loadPersonFromApplicationOfSocialSecurity() throws EASBizException, BOSException, ParseException {
		// TODO Auto-generated method stub

		ArrayList<String>list=new ArrayList<String>();
		for(int i=0;i<info.getEntrys().size();i++){
			if(info.getEntrys().get(i).getShrPersonCode()!=null){
				list = socialSecurityFacadeFactory.getRemoteInstance().getPersonInfoByFilterItem(null,null,dataBaseConnectionInfo,true,null,null,null,info.getEntrys().get(i).getShrPersonCode());
				if(list.size()>0){
					kdtEntrys.addRow();
					kdtEntrysModifyRow(list.get(0).split("_"),kdtEntrys.getRowCount()-1);
					continue;
				}
				else{
					list=socialSecurityFacadeFactory.getRemoteInstance().getPersonInfoByFilterItem(null,null,dataBaseConnectionInfo,false,null,null,null,info.getEntrys().get(i).getShrPersonCode());
					if(list.size()>0){
						kdtEntrys.addRow();
						kdtEntrysModifyRow(list.get(0).split("_"),kdtEntrys.getRowCount()-1);
						continue;
					}
				}
			}
		}
	}
}