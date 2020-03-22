/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionFactory;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionInfo;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.wages.BasicPostFactory;
import com.kingdee.eas.custom.wages.BasicPostInfo;
import com.kingdee.eas.custom.wages.IgetSHRinfoFacade;
import com.kingdee.eas.custom.wages.MonthlysalarybillCollection;
import com.kingdee.eas.custom.wages.MonthlysalarybillEntryInfo;
import com.kingdee.eas.custom.wages.MonthlysalarybillFactory;
import com.kingdee.eas.custom.wages.UnitOfMetering;
import com.kingdee.eas.custom.wages.WageOrganizationFactory;
import com.kingdee.eas.custom.wages.WageOrganizationInfo;
import com.kingdee.eas.custom.wages.getSHRinfoFacade;
import com.kingdee.eas.custom.wages.getSHRinfoFacadeFactory;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;

/**
 * output class name
 */
public class MonthlysalarybillEditUI extends AbstractMonthlysalarybillEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(MonthlysalarybillEditUI.class);
    
    /**
     * output class constructor
     */
    public MonthlysalarybillEditUI() throws Exception
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
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 获取本季度所有需要发放工资的人员信息
	 */
	@Override
	public void actionGetPerson_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionGetPerson_actionPerformed(e);
		if(pkbegindate.getValue()==null||pkenddate.getValue()==null){
			MsgBox.showWarning("请先选择核算期间！");
			return;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		//((KDComboBox)kdtEntrys.getColumn("meteunit").getEditor().getComponent()).setSelectedItem(UnitOfMetering.OUTPUT_VALUE);
		IRowSet rs = getExeQueryRowSet();
		kdtEntrys.removeRows();
		PersonInfo p = new PersonInfo();
		BasicPostInfo b = new BasicPostInfo();
		WageOrganizationInfo w = new WageOrganizationInfo();
		while(rs.next()){
			kdtEntrys.addRow();
			String id = rs.getString("person"); //ID  
			IObjectPK pk = new ObjectStringPK(id); //主键 
			p = PersonFactory.getRemoteInstance().getPersonInfo(pk);
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "person").setValue(p);
			String pid = rs.getString("post"); //ID  
			IObjectPK pk1 = new ObjectStringPK(pid); //主键 
			b = BasicPostFactory.getRemoteInstance().getBasicPostInfo(pk1);
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "post").setValue(b);
			String wid = rs.getString("fromgroup"); //ID  
			IObjectPK pk2 = new ObjectStringPK(wid); //主键 
			w = WageOrganizationFactory.getRemoteInstance().getWageOrganizationInfo(pk2);
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "fromgroup").setValue(w);
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "personnumber").setValue(rs.getString("personcard"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "attendanceday").setValue(rs.getString("attendanceday"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "basicwages").setValue(rs.getString("basicwages"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "actualattenday").setValue(rs.getString("actualattenday"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "absenteeismday").setValue(rs.getString("absenteeismday"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "leaveday").setValue(rs.getString("leaveday"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "overtimeH").setValue(rs.getString("overtimeH"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "overtimeD").setValue(rs.getString("overtimeD"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "yieldwages").setValue(rs.getString("yieldwages"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "socialsecurity").setValue(rs.getString("socialsecurity"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "banknumber").setValue(rs.getString("banknumber"));
			Date timeofentry = format.parse(rs.getString("timeofentry"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "timeofentry").setValue(timeofentry);
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "fullworkwages").setValue("0");
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "assessmentwages").setValue("0");
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "checkworkwages").setValue("0");
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "subsidywages").setValue("0");
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "recruitwages").setValue(rs.getString("recruitwages"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "qualitydebit").setValue(rs.getString("qualitydebit"));
			
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "notificationwages").setValue(rs.getString("notificationwages"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "repairmonth").setValue("0");
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "jgzbx").setValue(rs.getString("jkzbx"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "persontax").setValue("0");
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "Deductedloss").setValue("0");
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "Accidentinsurance").setValue(rs.getString("Accidentinsurance"));
			kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "adjustAmount").setValue(rs.getString("adjustAmount"));
		}	
	}
	/**
	 *<p>Custom: 北三峡</p>
	 *<p>Company: 青岛未来互连</p>
	 * @author 于明旭
	 * 获取本季度所有需要发放工资的人员信息SQL
	 */
    private IRowSet getExeQueryRowSet() throws BOSException {
//    	String id = this.prmtWageOrganization.getData().toString();
    	StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("/*dialect*/").append(sp);
		sql.append("Select").append(sp);
		sql.append("t2.CFPersonID person,").append(sp);
		sql.append("t2.CFPersonnumber CFPersonnumber,").append(sp);
		sql.append("t4.Fidcardno personcard,").append(sp);
		sql.append("t2.CFFrompostID post,").append(sp);
		sql.append("t3.Fid fromgroup,").append(sp);
		sql.append("t3.FName_l2 postname,").append(sp);
		sql.append("t3.CFAttendanceDay attendanceday,").append(sp);
		sql.append("t5.CFPostSalary  basicwages,").append(sp);
		sql.append("t11.银行卡号  banknumber,").append(sp);
		sql.append("t11.入职日期  timeofentry,").append(sp);
		sql.append("nvl(t12.招聘奖励,0) recruitwages,").append(sp);
		sql.append("nvl(t12.健康证报销,0) jkzbx,").append(sp);
		sql.append("nvl(t13.奖罚金额,0) notificationwages,").append(sp);
		sql.append("nvl(t14.扣款金额,0) qualitydebit,").append(sp);
		sql.append("nvl(t15.调整金额,0) adjustAmount,").append(sp);
		sql.append("t10.今日出勤   actualattenday,").append(sp);
		sql.append("sum(t2.CFIsAbsenteeism) absenteeismday,").append(sp);
		sql.append("sum(t2.CFIsLeave) leaveday,").append(sp);
		sql.append("nvl(sum(t2.CFOvertime)*t3.CFOvertimeH,0) overtimeH,").append(sp);
		sql.append("nvl(sum(t2.CFOverday)*t3.CFOvertimeD,0) overtimeD,").append(sp);
		sql.append("sum(t2.CFDaywages) yieldwages,").append(sp);
		sql.append("nvl(t9.CFGryjf,0) socialsecurity,").append(sp);
		sql.append("(case when nvl(t9.CFGryjf,0)=0 then 27 else 0 end) Accidentinsurance").append(sp);
		sql.append("from CT_WAG_DailyOutPut t1").append(sp);
		sql.append("left join CT_WAG_DailyOutPutEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("left join CT_WAG_WageOrganization  t3 on t3.Fid = t1.CFWageOrganization").append(sp);
		sql.append("left join T_BD_Person t4 on t4.Fid = t2.CFPersonID").append(sp);
		sql.append("left join CT_WAG_BasicPost t5 on t5.fid = t2.CFFrompostID").append(sp);
		
		sql.append("left join (select t1.CFPersonid,sum(t1.CFIsAbsenteeism) CFIsAbsenteeism,sum(t1.CFIsLeave) CFIsLeave  ").append(sp);
		sql.append("from CT_WAG_DailyOutPutEntry t1").append(sp);
		sql.append("inner join  CT_WAG_DailyOutPut t2 on t2.FID = t1.FParentID").append(sp);
		sql.append("where").append(sp);
		sql.append("to_char(t2.fbizdate,'yyyy-MM-dd') >= '"+pkbegindate.getText()+"'").append(sp);
		sql.append("and to_char(t2.fbizdate,'yyyy-MM-dd') <= '"+pkenddate.getText()+"'").append(sp);
		sql.append("group by  t1.CFPersonid").append(sp);
		sql.append(") t6 on t6.CFPersonid = t2.CFPersonid").append(sp);
		//社保福利
		sql.append("left join (select t7.fbizdate,t8.CFperson,t8.CFDwjn,t8.CFGryjf from CT_WAG_EmploySecurity t7").append(sp);
		sql.append("inner join CT_WAG_EmploySecurityEntry t8 on t8.FParentID = t7.FID").append(sp);
		sql.append("where").append(sp);
		sql.append("to_char(t7.fbizdate,'yyyy-MM-dd') >= '"+pkbegindate.getText()+"'").append(sp);
		sql.append("and to_char(t7.fbizdate,'yyyy-MM-dd') <= '"+pkenddate.getText()+"'").append(sp);
		sql.append(") t9 on t9.CFperson = t4.FName_l2").append(sp);
		//出勤计算
		sql.append("left join (select sum(今日出勤) 今日出勤,员工编号,CFPersonnumber from (").append(sp);
		sql.append("select (case when sum(t2.CFDaywages） = 0 then '0' else (case when t2.CFIsHelfday = 1 then '0.5' else '1' end ) end) 今日出勤,t2.CFPersonID 员工编号,t2.CFPersonnumber,to_char(t1.FBizdate,'yyyy-MM-dd')").append(sp);
		sql.append("from CT_WAG_DailyOutPut t1").append(sp);
		sql.append("left join CT_WAG_DailyOutPutEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("where").append(sp);
		sql.append("to_char(t1.fbizdate,'yyyy-MM-dd') >= '"+pkbegindate.getText()+"'").append(sp);
		sql.append("and to_char(t1.fbizdate,'yyyy-MM-dd') <= '"+pkenddate.getText()+"'").append(sp);
		sql.append("group by t2.CFPersonID,t2.CFPersonnumber,to_char(t1.FBizdate,'yyyy-MM-dd'),t2.CFIsHelfday) group by 员工编号,CFPersonnumber").append(sp);
		sql.append(") t10 on  t10.员工编号 = t2.CFPersonID").append(sp);
		//shr信息
		sql.append("left join ( select t2.CFPersonID fid,t2.CFPerson 员工姓名,t2.CFPersonnumber 员工编码,t2.CFBankcard 银行卡号,t2.CFEnterdate 入职日期   from  CT_WAG_WagesPersonInfo t1").append(sp);
		sql.append("inner join CT_WAG_WagesPersonInfoEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append(") t11 on t11.fid = t2.CFPersonID").append(sp);
		
		//HR信息
		sql.append("left join ( select t2.CFPersonID fid,t2.CFPersonID 员工id,t2.CFPersonnumber 员工编码,t2.CFAmount 招聘奖励,t2.CFHealthCar 健康证报销   from  CT_WAG_HRwages t1").append(sp);
		sql.append("inner join CT_WAG_HRwagesEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("where").append(sp);
		sql.append("to_char(t1.fbizdate,'yyyy-MM-dd') >= '"+pkbegindate.getText()+"'").append(sp);
		sql.append("and to_char(t1.fbizdate,'yyyy-MM-dd') <= '"+pkenddate.getText()+"'").append(sp);
		sql.append(") t12 on t12.fid = t2.CFPersonID").append(sp);
		
		//奖罚信息
		sql.append("left join ( select t2.CFPersonID 员工id,t2.CFPersonnumber 员工编码,sum(t2.CFAmount) 奖罚金额   from  CT_WAG_Qualityawardticket t1").append(sp);
		sql.append("inner join CT_WAG_QualityawardticketEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("where").append(sp);
		sql.append("to_char(t1.fbizdate,'yyyy-MM-dd') >= '"+pkbegindate.getText()+"'").append(sp);
		sql.append("and to_char(t1.fbizdate,'yyyy-MM-dd') <= '"+pkenddate.getText()+"'").append(sp);
		sql.append("group by t2.CFPersonID,t2.CFPersonnumber").append(sp);
		sql.append(") t13 on t13.员工id = t2.CFPersonID").append(sp);
		
		//品控扣款信息
		sql.append("left join ( select t2.CFPersonID 员工id,t2.CFPersonnumber 员工编码,sum(t2.CFAmount) 扣款金额   from  CT_WAG_ProControlWithhold t1").append(sp);
		sql.append("inner join CT_WAG_ProControlWithholdEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("where").append(sp);
		sql.append("to_char(t1.fbizdate,'yyyy-MM-dd') >= '"+pkbegindate.getText()+"'").append(sp);
		sql.append("and to_char(t1.fbizdate,'yyyy-MM-dd') <= '"+pkenddate.getText()+"'").append(sp);
		sql.append("group by t2.CFPersonID,t2.CFPersonnumber").append(sp);
		sql.append(") t14 on t14.员工id = t2.CFPersonID").append(sp);
		
		//调整单信息
		sql.append("left join ( select t2.CFPersonID 员工id,t2.CFPersonnumber 员工编码,sum(t2.CFAmount) 调整金额   from  CT_WAG_Adjustmoney t1").append(sp);
		sql.append("inner join CT_WAG_AdjustmoneyEntry t2 on t2.FParentID = t1.FID").append(sp);
		sql.append("where").append(sp);
		sql.append("to_char(t1.fbizdate,'yyyy-MM-dd') >= '"+pkbegindate.getText()+"'").append(sp);
		sql.append("and to_char(t1.fbizdate,'yyyy-MM-dd') <= '"+pkenddate.getText()+"'").append(sp);
		sql.append("group by t2.CFPersonID,t2.CFPersonnumber").append(sp);
		sql.append(") t15 on t15.员工id = t2.CFPersonID").append(sp);
		
		sql.append("where").append(sp);
		sql.append("to_char(t1.fbizdate,'yyyy-MM-dd') >= '"+pkbegindate.getText()+"'").append(sp);
		sql.append("and to_char(t1.fbizdate,'yyyy-MM-dd') <= '"+pkenddate.getText()+"'").append(sp);
		sql.append("group by t2.CFPersonID,t2.CFPersonnumber,t3.CFAttendanceDay,t2.CFFrompostID,t3.Fid,t3.FName_l2,t5.CFPostSalary,t3.CFOvertimeH,t3.CFOvertimeD,t6.CFIsAbsenteeism,t6.CFIsLeave,t9.CFGryjf,t4.Fidcardno,t10.今日出勤,t11.银行卡号,t11.入职日期,t12.招聘奖励,t12.健康证报销,t13.奖罚金额,t14.扣款金额,t15.调整金额").append(sp);
    	System.out.println(sql.toString());
		IRowSet rs =SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		return rs;
    }
	/* (non-Javadoc)
	 * @see com.kingdee.eas.framework.client.CoreBillEditUI#onLoad()
	 */
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		this.pkBizDate.setValue(new Date());
		
		this.kdtEntrys_detailPanel.addAddListener(new IDetailPanelListener(){

			
			public void afterEvent(DetailPanelEvent arg0) throws Exception {
				// TODO Auto-generated method stub
				//setLineValue(arg0); 
			}

			private void setLineValue(DetailPanelEvent arg0) {
				// TODO Auto-generated method stub
				MonthlysalarybillEntryInfo objectvalue = (MonthlysalarybillEntryInfo) arg0.getObjectValue();
				//BOSUuid entryid = objectvalue.getId();
				objectvalue.put("yieldwages", new BigDecimal("0"));
				objectvalue.put("fullworkwages", new BigDecimal("0"));
				objectvalue.put("assessmentwages", new BigDecimal("0"));
				objectvalue.put("basicwages", new BigDecimal("0"));
				objectvalue.put("checkworkwages", new BigDecimal("0"));
				objectvalue.put("overtimeH", new BigDecimal("0"));
				objectvalue.put("overtimeD", new BigDecimal("0"));
				objectvalue.put("temwages", new BigDecimal("0"));
				objectvalue.put("nightwages", new BigDecimal("0"));
				objectvalue.put("subsidywages", new BigDecimal("0"));
				objectvalue.put("recruitwages", new BigDecimal("0"));
				objectvalue.put("qualitydebit", new BigDecimal("0"));
				objectvalue.put("notificationwages", new BigDecimal("0"));
				objectvalue.put("repairmonth", new BigDecimal("0"));
				objectvalue.put("jgzbx", new BigDecimal("0"));
				objectvalue.put("deductedloss", new BigDecimal("0"));
				objectvalue.put("accidentinsurance", new BigDecimal("0"));
				objectvalue.put("persontax", new BigDecimal("0"));
			}

			
			public void beforeEvent(DetailPanelEvent arg0) throws Exception {
				// TODO Auto-generated method stub
				setLineValue(arg0); 
			}
			
		});
		super.onLoad();
	}
	/* (non-Javadoc)
	 * @see com.kingdee.eas.custom.wages.client.AbstractMonthlysalarybillEditUI#onShow()
	 */
	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		this.audit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.unaudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		super.onShow();
	}
	
	/* (non-Javadoc)
	 * @see com.kingdee.eas.framework.client.CoreBillEditUI#actionPassHistory_actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPassHistory_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.actionPassHistory_actionPerformed(e);
		refreshCurPage();
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
	/* (non-Javadoc)
	 * @see com.kingdee.eas.custom.wages.client.AbstractMonthlysalarybillEditUI#actionWagecalculation_actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionWagecalculation_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		if(FarmCommUtils.checkBillStatus(this.editData.getBillStatus(),BillBaseStatusEnum.TEMPORARILYSAVED)) {
			super.actionWagecalculation_actionPerformed(e);
			MsgBox.showWarning("计算完成！");
			refreshCurPage();
    	}else{
    		commUtils.giveUserTipsAndRetire("只能在保存状态下计算！");
    	}
		refreshCurPage();
	}
	/**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }
    /**
	 * 校验是否已经存在
	 * @param arg0 
	 */
	private void checkIsExist(DataChangeEvent arg0) {
		// TODO Auto-generated method stub
		if(prmtperiod.getValue()==null)
			return;
		PeriodInfo periodInfo = (PeriodInfo)prmtperiod.getValue();
		String str="where period='"+periodInfo.getId().toString()+"'";
		if(editData.getId()!=null)
			str=str+" and id<>"+editData.getId().toString()+"'";

		try {
			MonthlysalarybillCollection coll = MonthlysalarybillFactory.getRemoteInstance().getMonthlysalarybillCollection(str);
			if(coll.size()>0){
				prmtperiod.setValue(arg0.getOldValue());
				commUtils.giveUserTipsAndRetire("该期间的月工资单据已存在，请在原单据上修改", "warning");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
//	//获取银行卡信息
//	private JSONArray getBankCarData(String params) throws BOSException{
//		//数据库连接配置
//		String [] result=new String[2];
//		Connection conn=null;
//		CoreBaseCollection coll = DataBaseConnectionFactory.getRemoteInstance().getCollection("where billStatus=3");
//		if(coll.size()==0)
//			commUtils.giveUserTipsAndRetire("没有启用的sHR数据库连接配置");
//		DataBaseConnectionInfo dataBaseConnectionInfo = (DataBaseConnectionInfo) coll.get(0);
//		String[] connStr=new String[5];
//		connStr[0]=dataBaseConnectionInfo.getIP();
//		connStr[1]=dataBaseConnectionInfo.getPort();
//		connStr[2]=dataBaseConnectionInfo.getDataBaseName();
//		connStr[3]=dataBaseConnectionInfo.getUserName();
//		connStr[4]=dataBaseConnectionInfo.getPassword();
//
//		conn = getDataBaseConnection(connStr);
//		if(conn==null){
//			result[0]="更新失败";
//			result[1]="数据库连接失败";
//		}
//		ArrayList<String> leavePersonNum=getCard(conn);
//		return null;
//	}
//	/**
//	 * 连接外部数据库
//	 * @param str
//	 * @return
//	 */
//	public static Connection getDataBaseConnection(String [] str){
//		Connection conn=null;
//		if(str.length==5){
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
//				String url = "jdbc:oracle:thin:@"+str[0]+":"+str[1]+":"+str[2]; // orcl为数据库的SID
//				String user = str[3];
//				String password = str[4];
//				conn = DriverManager.getConnection(url, user, password);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} catch (InstantiationException e) {
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				//throw new BOSException("",e);
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//			return conn;
//		}
//		return null;
//	}
//	
//	private ArrayList<String> getCard(Connection conn) {
//		// TODO Auto-generated method stub
//		Statement state = null;
//		ResultSet rs = null ;
//
//		StringBuffer sb=new StringBuffer();
//		ArrayList<String> arrayList=new ArrayList<String>();
//		String sp = "\n";
//		sb.append("SELECT t1.FNumber FNumber,t1.FName_l2 FName_l2,t2.FEnterDate EnterDate").append(sp);
//		sb.append("FROM   T_BD_PERSON t1 ").append(sp);
//		sb.append("inner join T_HR_PersonPosition t2  on t2.fpersonid=t1.fid ").append(sp);
//		sb.append("inner join T_ORG_Admin   t3  on t2.fpersondep=t3.fid ").append(sp);
//		//sb.append("inner join T_HR_BDEmployeeType         t15  on t15.fid=t1.FEmployeeTypeID").append(sp);
//		//sb.append("where t15.FName_l2='离职'");
//
//		try {
//			state = conn.createStatement();
//			rs = state.executeQuery(sb.toString());
//			while(rs.next())
//				arrayList.add(rs.getString("FNumber"));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{
//			try {
//				if(rs!=null)
//					rs.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			try {
//				if(state!=null)
//					state.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return arrayList;
//	}
//	
	
	
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
     * output actionPageSetup_actionPerformed
     */
    public void actionPageSetup_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPageSetup_actionPerformed(e);
    }

    /**
     * output actionExitCurrent_actionPerformed
     */
    public void actionExitCurrent_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExitCurrent_actionPerformed(e);
    }

    /**
     * output actionHelp_actionPerformed
     */
    public void actionHelp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHelp_actionPerformed(e);
    }

    /**
     * output actionAbout_actionPerformed
     */
    public void actionAbout_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAbout_actionPerformed(e);
    }

    /**
     * output actionOnLoad_actionPerformed
     */
    public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionOnLoad_actionPerformed(e);
    }

    /**
     * output actionSendMessage_actionPerformed
     */
    public void actionSendMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMessage_actionPerformed(e);
    }

    /**
     * output actionCalculator_actionPerformed
     */
    public void actionCalculator_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCalculator_actionPerformed(e);
    }

    /**
     * output actionExport_actionPerformed
     */
    public void actionExport_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExport_actionPerformed(e);
    }

    /**
     * output actionExportSelected_actionPerformed
     */
    public void actionExportSelected_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelected_actionPerformed(e);
    }

    /**
     * output actionRegProduct_actionPerformed
     */
    public void actionRegProduct_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRegProduct_actionPerformed(e);
    }

    /**
     * output actionPersonalSite_actionPerformed
     */
    public void actionPersonalSite_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPersonalSite_actionPerformed(e);
    }

    /**
     * output actionProcductVal_actionPerformed
     */
    public void actionProcductVal_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionProcductVal_actionPerformed(e);
    }

    /**
     * output actionExportSave_actionPerformed
     */
    public void actionExportSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSave_actionPerformed(e);
    }

    /**
     * output actionExportSelectedSave_actionPerformed
     */
    public void actionExportSelectedSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExportSelectedSave_actionPerformed(e);
    }

    /**
     * output actionKnowStore_actionPerformed
     */
    public void actionKnowStore_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionKnowStore_actionPerformed(e);
    }

    /**
     * output actionAnswer_actionPerformed
     */
    public void actionAnswer_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAnswer_actionPerformed(e);
    }

    /**
     * output actionRemoteAssist_actionPerformed
     */
    public void actionRemoteAssist_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoteAssist_actionPerformed(e);
    }

    /**
     * output actionPopupCopy_actionPerformed
     */
    public void actionPopupCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupCopy_actionPerformed(e);
    }

    /**
     * output actionHTMLForMail_actionPerformed
     */
    public void actionHTMLForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForMail_actionPerformed(e);
    }

    /**
     * output actionExcelForMail_actionPerformed
     */
    public void actionExcelForMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForMail_actionPerformed(e);
    }

    /**
     * output actionHTMLForRpt_actionPerformed
     */
    public void actionHTMLForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionHTMLForRpt_actionPerformed(e);
    }

    /**
     * output actionExcelForRpt_actionPerformed
     */
    public void actionExcelForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionExcelForRpt_actionPerformed(e);
    }

    /**
     * output actionLinkForRpt_actionPerformed
     */
    public void actionLinkForRpt_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLinkForRpt_actionPerformed(e);
    }

    /**
     * output actionPopupPaste_actionPerformed
     */
    public void actionPopupPaste_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPopupPaste_actionPerformed(e);
    }

    /**
     * output actionToolBarCustom_actionPerformed
     */
    public void actionToolBarCustom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionToolBarCustom_actionPerformed(e);
    }

    /**
     * output actionCloudFeed_actionPerformed
     */
    public void actionCloudFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudFeed_actionPerformed(e);
    }

    /**
     * output actionCloudShare_actionPerformed
     */
    public void actionCloudShare_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudShare_actionPerformed(e);
    }

    /**
     * output actionCloudScreen_actionPerformed
     */
    public void actionCloudScreen_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCloudScreen_actionPerformed(e);
    }

    /**
     * output actionXunTongFeed_actionPerformed
     */
    public void actionXunTongFeed_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionXunTongFeed_actionPerformed(e);
    }

    /**
     * output actionSave_actionPerformed
     */
    public void actionSave_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSave_actionPerformed(e);
    }

    /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmit_actionPerformed(e);
    }

    /**
     * output actionCancel_actionPerformed
     */
    public void actionCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancel_actionPerformed(e);
    }

    /**
     * output actionCancelCancel_actionPerformed
     */
    public void actionCancelCancel_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCancelCancel_actionPerformed(e);
    }

    /**
     * output actionFirst_actionPerformed
     */
    public void actionFirst_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionFirst_actionPerformed(e);
    }

    /**
     * output actionPre_actionPerformed
     */
    public void actionPre_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPre_actionPerformed(e);
    }

    /**
     * output actionNext_actionPerformed
     */
    public void actionNext_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNext_actionPerformed(e);
    }

    /**
     * output actionLast_actionPerformed
     */
    public void actionLast_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLast_actionPerformed(e);
    }

    /**
     * output actionPrint_actionPerformed
     */
    public void actionPrint_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrint_actionPerformed(e);
    }

    /**
     * output actionPrintPreview_actionPerformed
     */
    public void actionPrintPreview_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionPrintPreview_actionPerformed(e);
    }

    /**
     * output actionCopy_actionPerformed
     */
    public void actionCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopy_actionPerformed(e);
    }

    /**
     * output actionAddNew_actionPerformed
     */
    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddNew_actionPerformed(e);
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
    		MsgBox.showWarning("单据已经审核，禁止删除！");
    		SysUtil.abort();
    	}
        super.actionRemove_actionPerformed(e);
    }

    /**
     * output actionAttachment_actionPerformed
     */
    public void actionAttachment_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAttachment_actionPerformed(e);
    }

    /**
     * output actionSubmitOption_actionPerformed
     */
    public void actionSubmitOption_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSubmitOption_actionPerformed(e);
    }

    /**
     * output actionReset_actionPerformed
     */
    public void actionReset_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionReset_actionPerformed(e);
    }

    /**
     * output actionMsgFormat_actionPerformed
     */
    public void actionMsgFormat_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMsgFormat_actionPerformed(e);
    }

    /**
     * output actionAddLine_actionPerformed
     */
    public void actionAddLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddLine_actionPerformed(e);
    }

    /**
     * output actionCopyLine_actionPerformed
     */
    public void actionCopyLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyLine_actionPerformed(e);
    }

    /**
     * output actionInsertLine_actionPerformed
     */
    public void actionInsertLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionInsertLine_actionPerformed(e);
    }

    /**
     * output actionRemoveLine_actionPerformed
     */
    public void actionRemoveLine_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemoveLine_actionPerformed(e);
    }

    /**
     * output actionCreateFrom_actionPerformed
     */
    public void actionCreateFrom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateFrom_actionPerformed(e);
    }

    /**
     * output actionCopyFrom_actionPerformed
     */
    public void actionCopyFrom_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopyFrom_actionPerformed(e);
    }

    /**
     * output actionAuditResult_actionPerformed
     */
    public void actionAuditResult_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAuditResult_actionPerformed(e);
    }

    /**
     * output actionTraceUp_actionPerformed
     */
    public void actionTraceUp_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTraceUp_actionPerformed(e);
    }

    /**
     * output actionTraceDown_actionPerformed
     */
    public void actionTraceDown_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionTraceDown_actionPerformed(e);
    }

    /**
     * output actionViewSubmitProccess_actionPerformed
     */
    public void actionViewSubmitProccess_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewSubmitProccess_actionPerformed(e);
    }

    /**
     * output actionViewDoProccess_actionPerformed
     */
    public void actionViewDoProccess_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewDoProccess_actionPerformed(e);
    }

    /**
     * output actionMultiapprove_actionPerformed
     */
    public void actionMultiapprove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionMultiapprove_actionPerformed(e);
    }

    /**
     * output actionNextPerson_actionPerformed
     */
    public void actionNextPerson_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNextPerson_actionPerformed(e);
    }

    /**
     * output actionStartWorkFlow_actionPerformed
     */
    public void actionStartWorkFlow_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionStartWorkFlow_actionPerformed(e);
    }

    /**
     * output actionVoucher_actionPerformed
     */
    public void actionVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionVoucher_actionPerformed(e);
    }

    /**
     * output actionDelVoucher_actionPerformed
     */
    public void actionDelVoucher_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionDelVoucher_actionPerformed(e);
    }

    /**
     * output actionWorkFlowG_actionPerformed
     */
    public void actionWorkFlowG_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkFlowG_actionPerformed(e);
    }

    /**
     * output actionCreateTo_actionPerformed
     */
    public void actionCreateTo_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCreateTo_actionPerformed(e);
    }

    /**
     * output actionSendingMessage_actionPerformed
     */
    public void actionSendingMessage_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendingMessage_actionPerformed(e);
    }

    /**
     * output actionSignature_actionPerformed
     */
    public void actionSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSignature_actionPerformed(e);
    }

    /**
     * output actionWorkflowList_actionPerformed
     */
    public void actionWorkflowList_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionWorkflowList_actionPerformed(e);
    }

    /**
     * output actionViewSignature_actionPerformed
     */
    public void actionViewSignature_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionViewSignature_actionPerformed(e);
    }

    /**
     * output actionSendMail_actionPerformed
     */
    public void actionSendMail_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionSendMail_actionPerformed(e);
    }

    /**
     * output actionLocate_actionPerformed
     */
    public void actionLocate_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionLocate_actionPerformed(e);
    }

    /**
     * output actionNumberSign_actionPerformed
     */
    public void actionNumberSign_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionNumberSign_actionPerformed(e);
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

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.wages.MonthlysalarybillFactory.getRemoteInstance();
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
        com.kingdee.eas.custom.wages.MonthlysalarybillInfo objectValue = new com.kingdee.eas.custom.wages.MonthlysalarybillInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setBizDate(new Date());
//        try {
//			IgetSHRinfoFacade isk = getSHRinfoFacadeFactory.getRemoteInstance();
//			isk.getPersonInfo();
//		} catch (BOSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
        objectValue.setBillStatus(BillBaseStatusEnum.ADD);
        return objectValue;
    }

}