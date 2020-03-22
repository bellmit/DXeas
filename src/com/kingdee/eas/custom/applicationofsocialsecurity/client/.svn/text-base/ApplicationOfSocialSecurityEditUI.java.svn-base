/**
 * output package name
 */
package com.kingdee.eas.custom.applicationofsocialsecurity.client;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JPanel;

import org.apache.log4j.Logger;
import org.hsqldb.DatabaseURL;

import ucar.nc2.units.DateUnit;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.IUIWindow;
import com.kingdee.bos.ui.face.UIFactory;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.hraux.DiplomaFactory;
import com.kingdee.eas.basedata.hraux.DiplomaInfo;
import com.kingdee.eas.basedata.person.Genders;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;
import com.kingdee.eas.common.client.UIFactoryName;
import com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurityFactory;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionFactory;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionInfo;
import com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurity;
import com.kingdee.eas.custom.applicationofsocialsecurity.socialSecurityFacadeFactory;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.MathUtilsComm;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.commld.jdbcUntils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.multiDetail.DetailPanel;
import com.kingdee.eas.hr.rec.GenderEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.ctrl.analysis.web.ext.DateUtil;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTActiveCellEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.KDPanel;
import com.kingdee.bos.ctrl.swing.KDWorkButton;


/**
 * output class name
 */
public class ApplicationOfSocialSecurityEditUI extends AbstractApplicationOfSocialSecurityEditUI
{



	private static final Logger logger = CoreUIObject.getLogger(ApplicationOfSocialSecurityEditUI.class);
	DataBaseConnectionInfo dataBaseConnectionInfo=null;
	String personNum="";
	String oldValue=null;
	String personName="";





	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();

		setUI();



		CoreBaseCollection coll = DataBaseConnectionFactory.getRemoteInstance().getCollection("where billStatus=3");
		if(coll.size()==0)
			commUtils.giveUserTipsAndRetire("没有启用的数据库连接配置");
		dataBaseConnectionInfo = (DataBaseConnectionInfo)coll.get(0);
	}

	/**
	 * 界面设置
	 */
	private void setUI() {
		// TODO Auto-generated method stub
		contLastUpdateUser.setVisible(true);
		contLastUpdateTime.setVisible(true);
		btnTraceDown.setVisible(true);
		btnModifyStatus.setIcon(EASResource.getIcon("imgTbtn_modifyattribute"));

		kdtEntrys.getColumn("idCardNo").setWidth(180);
		kdtEntrys.getColumn("department").setWidth(180);
		kdtEntrys.getColumn("position").setWidth(80);
		kdtEntrys.getColumn("gender").setWidth(50);
		kdtEntrys.getColumn("gender").getStyleAttributes().setHorizontalAlign(HorizontalAlignment.CENTER);
		kdtEntrys.getColumn("personName").setWidth(60);
		kdtEntrys.getColumn("shrPersonCode").setWidth(80);




		setPersonTypeFilterInfo();

		//修改图标
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));

		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

		if(txtNumber.getStringValue()==null||txtNumber.getStringValue().equals(""))
			txtNumber.setEnabled(true);
		else
			txtNumber.setEnabled(false);
	}


	/**
	 * 设置人员类别的过滤
	 */
	private void setPersonTypeFilterInfo() {
		// TODO Auto-generated method stub
		EntityViewInfo evi=new EntityViewInfo();
		FilterInfo filterInfo=new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("billStatus",3,CompareType.EQUALS));
		evi.setFilter(filterInfo);
		prmtpersonType.setEntityViewInfo(evi);

	}
	/**
	 * output class constructor
	 */
	public ApplicationOfSocialSecurityEditUI() throws Exception
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

	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		loadCurrentPersonsSIStatus();
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
		return com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurityFactory.getRemoteInstance();
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
		com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurityInfo objectValue = new com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurityInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		try {
			objectValue.setNumber(getNumberByDate());
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return objectValue;
	}
	/**
	 * 根据手动生成一个编码
	 * @return
	 * @throws BOSException 
	 */
	private String getNumberByDate() throws BOSException {
		// TODO Auto-generated method stub
		String str="SS-";
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		str+=sdf.format(date);
		IApplicationOfSocialSecurity IASS = ApplicationOfSocialSecurityFactory.getRemoteInstance();
		int i=1;
		do{
			CoreBaseCollection coll = IASS.getCollection("where number='"+str+"-"+MathUtilsComm.getStringByNumber(4, i)+"'");
			if(coll.size()>0)
				i++;
			else
				return str+"-"+MathUtilsComm.getStringByNumber(4, i);
		}while(1==1);
	}
	@Override
	protected void kdtEntrys_editStart(KDTEditEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(kdtEntrys.getCell(e.getRowIndex(), e.getColIndex()).getValue()!=null&&!kdtEntrys.getCell(e.getRowIndex(), e.getColIndex()).getValue().toString().equals(""))
			oldValue=kdtEntrys.getCell(e.getRowIndex(), e.getColIndex()).getValue().toString();
		super.kdtEntrys_editStart(e);
	}
	@SuppressWarnings("unchecked")
	@Override
	protected void kdtEntrys_editStopp(KDTEditEvent e) throws Exception {
		// TODO Auto-generated method stub

		if(kdtEntrys.getColumn("shrPersonCode").getColumnIndex()!=e.getColIndex())
			return;
		HashMap<String,String> personInfo=new HashMap<String,String>();
		//根据姓名查找shr中的员工
		if(kdtEntrys.getCell(e.getRowIndex(), e.getColIndex()).getValue()==null)
			return;
		else if("shrPersonCode".equals(kdtEntrys.getColumn(e.getColIndex()).getKey())){
			personNum=kdtEntrys.getCell(e.getRowIndex(),e.getColIndex()).getValue().toString();
			if(personNum.equals(oldValue))
				return;
			personInfo=socialSecurityFacadeFactory.getRemoteInstance().getInfoOfPersonBaseOnNumberOrName(personNum, null, dataBaseConnectionInfo);

			if(personInfo.size()==0)
				commUtils.giveUserTipsAndRetire("sHR系统中没有找到该编码对应的职员");
			Iterator<Entry<String, String>> iter = personInfo.entrySet().iterator();  
			Entry<String, String> entry;  
			if (iter.hasNext()) {  
				entry = iter.next();
				String [] str=entry.getValue().split("_");
				fillEntry(e.getRowIndex(),str);
			}
		}

		super.kdtEntrys_editStopp(e);
	}
	/**
	 * 根据员工的相关信息填写分录
	 * @param rowIndex
	 * @param str
	 * @throws ParseException 
	 * @throws BOSException 
	 */
	private void fillEntry(int rowIndex, String[] str) throws ParseException, BOSException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

		if(!str[0].equals("0000"))
			kdtEntrys.getCell(rowIndex,"personName").setValue(str[0]);//姓名
		else
			kdtEntrys.getCell(rowIndex,"personName").setValue(null);//姓名

		if(!str[1].equals("0000"))
			kdtEntrys.getCell(rowIndex,"enterDate").setValue(sdf.parse(str[1]));//入职日期
		else
			kdtEntrys.getCell(rowIndex,"enterDate").setValue(null);//入职日期

		if(!str[5].equals("0000")){
			if(str[5].equals("男"))
				kdtEntrys.getCell(rowIndex,"gender").setValue(Genders.Male);
			if(str[5].equals("女"))
				kdtEntrys.getCell(rowIndex,"gender").setValue(Genders.Female);//性别
		}
		if(!str[4].equals("0000"))
			kdtEntrys.getCell(rowIndex,"idCardNo").setValue(str[4]);//身份证号码
		else
			kdtEntrys.getCell(rowIndex,"idCardNo").setValue(null);

		if(!str[3].equals("0000"))
			kdtEntrys.getCell(rowIndex,"position").setValue(str[3]);//岗位
		else
			kdtEntrys.getCell(rowIndex,"position").setValue(null);

		if(!str[2].equals("0000"))
			kdtEntrys.getCell(rowIndex,"department").setValue(str[2]);//部门
		else
			kdtEntrys.getCell(rowIndex,"department").setValue(null);//部门

		if(!str[6].equals("0000"))
			kdtEntrys.getCell(rowIndex,"contact").setValue(str[6]);//联系方式
		else
			kdtEntrys.getCell(rowIndex,"contact").setValue(null);//联系方式

		if(!str[8].equals("0000"))
			kdtEntrys.getCell(rowIndex,"contractEffectDate").setValue(sdf.parse(str[8]));//合同生效日期
		else
			kdtEntrys.getCell(rowIndex,"contractEffectDate").setValue(null);//合同生效日期

		if(!str[9].equals("0000"))
			kdtEntrys.getCell(rowIndex,"endDate").setValue(sdf.parse(str[9]));//合同终止日期
		else
			kdtEntrys.getCell(rowIndex,"endDate").setValue(null);//合同终止日期

		if(!str[10].equals("0000"))
			kdtEntrys.getCell(rowIndex,"contractLimitAuto").setValue(new BigDecimal(str[10]));//合同期限
		else
			kdtEntrys.getCell(rowIndex,"contractLimitAuto").setValue(null);

		if(!str[7].equals("0000"))
			kdtEntrys.getCell(rowIndex,"diploma").setValue(getDiplomaByName(str[7]));//合同期限
		else
			kdtEntrys.getCell(rowIndex,"diploma").setValue(null);

		if(!str[11].equals("0000"))
			kdtEntrys.getCell(rowIndex,"srcSIStatus").setValue(str[11]);//合同期限
		else
			kdtEntrys.getCell(rowIndex,"srcSIStatus").setValue(null);
	}
	/**
	 * 根据学历名称获取学历F7
	 * @param string
	 * @return
	 * @throws BOSException 
	 */
	private Object getDiplomaByName(String string) throws BOSException {
		// TODO Auto-generated method stub
		CoreBaseCollection coll = DiplomaFactory.getRemoteInstance().getCollection(" where name='"+string+"'");
		if(coll.size()>0)
			return (DiplomaInfo)coll.get(0);
		return null;
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
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		MsgBox.showInfo("审核成功");
		reloadData();
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		MsgBox.showInfo("反审核成功");
		reloadData();
	}


	/**
	 * 打开转换的单据
	 */
	@Override
	public void actionSetSIStatus_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub

		if(!com.kingdee.eas.custom.applicationofsocialsecurity.billStatus.audit.equals(editData.getBillStatus()))
			commUtils.giveUserTipsAndRetire("单据尚未审核，该操作被禁止");

		String destBillEditUIClassName ="com.kingdee.eas.custom.applicationofsocialsecurity.client.ModifySIStatusEditUI";
		Map hashMap = new UIContext(this);

		hashMap.put("srcBillInfo", editData);

		IUIWindow uiWindow = null ;
		uiWindow = UIFactory.createUIFactory(UIFactoryName.NEWTAB).create(destBillEditUIClassName, hashMap, null,OprtState.ADDNEW);
		//开始展现UI
		uiWindow.show();


		super.actionSetSIStatus_actionPerformed(e);
	}


	/**
	 * 加载当前所有员工最新的社保状态
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	@SuppressWarnings("unchecked")
	private void loadCurrentPersonsSIStatus() throws EASBizException, BOSException {
		// TODO Auto-generated method stub
		HashMap<String,String> personInfo=new HashMap<String,String>();
		for(int i=0;i<kdtEntrys.getRowCount();i++){
			if(kdtEntrys.getCell(i,"shrPersonCode").getValue()==null)
				continue;
			else
				personInfo=socialSecurityFacadeFactory.getRemoteInstance().getInfoOfPersonBaseOnNumberOrName(kdtEntrys.getCell(i,"shrPersonCode").getValue().toString(), null, dataBaseConnectionInfo);

			if(personInfo.size()==0)
				continue;
			Iterator<Entry<String, String>> iter = personInfo.entrySet().iterator();  
			Entry<String, String> entry;  
			if (iter.hasNext()) {  
				entry = iter.next();
				String [] str=entry.getValue().split("_");
				if(!str[11].equals("0000")){
					if(kdtEntrys.getCell(i, "srcSIStatus").getValue()==null)
						kdtEntrys.getCell(i,"afterSIStatus").setValue(str[11]);
					else if(str[11].equals(kdtEntrys.getCell(i, "srcSIStatus").getValue()))
						kdtEntrys.getCell(i,"afterSIStatus").setValue(null);
					else
						kdtEntrys.getCell(i,"afterSIStatus").setValue(str[11]);
				}
			}
		}
	}
}
