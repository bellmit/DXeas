/**
 * output package name
 */
package com.kingdee.eas.custom.wages.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectStringPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commonld.CommFacade;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.custom.wages.BasicPostEntryInfo;
import com.kingdee.eas.custom.wages.BasicPostFactory;
import com.kingdee.eas.custom.wages.BasicPostInfo;
import com.kingdee.eas.custom.wages.MonthWagesEntryCollection;
import com.kingdee.eas.custom.wages.MonthWagesEntryInfo;
import com.kingdee.eas.custom.wages.WageOrganizationFactory;
import com.kingdee.eas.custom.wages.WageOrganizationInfo;
import com.kingdee.eas.custom.wages.getWorkmonthFacade;
import com.kingdee.eas.custom.wages.getWorkmonthFacadeFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.hr.base.EmployeePropertFactory;
import com.kingdee.eas.hr.base.EmployeePropertInfo;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class MonthWagesEditUI extends AbstractMonthWagesEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(MonthWagesEditUI.class);
    
    /**
     * output class constructor
     */
    public MonthWagesEditUI() throws Exception
    {
        super();
    }
	public void onLoad() throws Exception {
		super.onLoad();
		calculation.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				if(pkBizDate.getValue()!=null&&prmtcompany.getValue()!=null){
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
					SimpleDateFormat formatters = new SimpleDateFormat("yyyy-MM-dd");
					Date date = (Date) pkBizDate.getValue();
					String dateString = formatter.format(date);
					String LastDate = getEndDateOfMonth(formatters.format(date)); 
					String FirstDate = getFirstDateOfMonth(formatters.format(date),date); 
					//System.out.println("本月第一天为："+FirstDate+",本月最后一天为"+LastDate);

					
					String companyID = ((IPropertyContainer) prmtcompany.getValue()).getString("ID");
					kdtEntry.removeRows();
					//获取应出勤天数
					getworkDays(dateString,companyID);
					//获取当前月份所有员工详细信息
					getAllperson(dateString,companyID,LastDate,FirstDate);
				}else{
					MsgBox.showWarning("请先填写完成：业务日期，公司，分值。");
				}
			}
			public void mouseEntered(MouseEvent e) {
			}
			public void mouseExited(MouseEvent e) {
			}
			public void mousePressed(MouseEvent e) {
			}
			public void mouseReleased(MouseEvent e) {
			}
			
		});
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
	 * 获取一个月的最后一天 
	 *  
	 * @param dat 
	 * @return 
	 */  
	public static String getEndDateOfMonth(String dat) {// yyyy-MM-dd  
	    String str = dat.substring(0, 8);  
	    String month = dat.substring(5, 7);  
	    int mon = Integer.parseInt(month);  
	    if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8  
	            || mon == 10 || mon == 12) {  
	        str += "31";  
	    } else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {  
	        str += "30";  
	    } else {  
	        if (isLeapYear(dat)) {  
	            str += "29";  
	        } else {  
	            str += "28";  
	        }  
	    }  
	    return str;  
	}  
	/** 
	 * 获取一个月的第一天 
	 *  
	 * @param dat 
	 * @return 
	 */  
	public static String getFirstDateOfMonth(String dat,Date date) {// yyyy-MM-dd 
		SimpleDateFormat formatters = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cale = null;
		cale = Calendar.getInstance();
		cale.setTime(date);
		cale.add(Calendar.MONTH, 0);
		cale.set(Calendar.DAY_OF_MONTH, 1);
		return dat = formatters.format(cale.getTime());
		
	}  
	/** 
	 * 判断是否润年 
	 *  
	 * @param ddate 
	 * @return 
	 */  
	public static boolean isLeapYear(String ddate) {  
	    /** 
	     * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年 
	     * 3.能被4整除同时能被100整除则不是闰年 
	     */  
	    Date d = strToDate(ddate);  
	    GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();  
	    gc.setTime(d);  
	    int year = gc.get(Calendar.YEAR);  
	    if ((year % 400) == 0)  
	        return true;  
	    else if ((year % 4) == 0) {  
	        if ((year % 100) == 0)  
	            return false;  
	        else  
	            return true;  
	    } else  
	        return false;  
	}  
	/** 
	 * 将短时间格式字符串转换为时间 yyyy-MM-dd 
	 *  
	 * @param strDate 
	 * @return 
	 */  
	public static Date strToDate(String strDate) {  
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
	    ParsePosition pos = new ParsePosition(0);  
	    Date strtodate = formatter.parse(strDate, pos);  
	    return strtodate;  
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
        com.kingdee.eas.custom.wages.MonthWagesInfo objectValue = new com.kingdee.eas.custom.wages.MonthWagesInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        return objectValue;
    }
    //获取本月应出勤天数
    private void getworkDays(String dateString, String companyID) {
		StringBuffer sb = new StringBuffer();
		String sp = "\n";
		
		sb.append("/*dialect*/").append(sp);
		sb.append("select").append(sp);
		sb.append("sum(workDays) workDays").append(sp);
		sb.append("from(").append(sp);
		sb.append("select case when CFHalfWorkDay = 1 then 0.5").append(sp);
		sb.append("else 1 end workDays").append(sp);
		sb.append("from CT_SZC_FreshDaily where FProductType = '0' and to_char(FbizDate,'yyyy-MM')  = '").append(dateString).append("' and CFCompanyID = '").append(companyID).append("' and FBillStatus = '4'").append(sp);
		sb.append(")").append(sp);
		try {
			//System.out.println(sb.toString());
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			if(rs.next()){
				//txtworkDays.setText(rs.getString("workdays"));
				//this.txtworkDay.setText(rs.getString("workdays"));
				this.txtworkDayss.setText(rs.getString("workdays"));
				//editData.setWorkDayss(new BigDecimal(rs.getString("workdays")));
				this.txtDescription.setText(rs.getString("workdays"));
				//this.contworkDay.get
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
    //获取考勤管理内所有员工信息
	private void getAllperson(String dateString, String companyID,String FirstDate,String LastDate) {
		StringBuffer sb = new StringBuffer();
		String sp = "\n";
		sb.append("/*dialect*/").append(sp);
		sb.append("	select ").append(sp);
		sb.append("personName,personID,nvl(lifeSubsidy,0)	生活补助,nvl(attendance,0)	全勤奖,oneDay,count(personID)/2 工作天数,nvl(EmployerInsur,0) EmployerInsur,nvl(Fiverisks,0) Fiverisks").append(sp);
		sb.append("	from (").append(sp);
		sb.append("select ").append(sp);
		sb.append("to_char(t1.FBizDate,'yyyy-MM-dd')	fbizDate,").append(sp);
		//sb.append("t1.CFtheGroupID	theGroupID,").append(sp);
		sb.append("t2.CFPersonName	personName,").append(sp);
		sb.append("t2.CFPersonNumID	personID,").append(sp);
		sb.append("t4.CFlifeSubsidy	lifeSubsidy,").append(sp);
		sb.append("t4.CFattendance	attendance,").append(sp);
		sb.append("t4.CFEmployerInsur EmployerInsur,").append(sp);
		sb.append("t4.CFFiverisks Fiverisks,").append(sp);
		//sb.append("to_char(t5.FEnrollDate,'yyyy-MM-dd')	inDate,").append(sp);
		sb.append("nvl(t4.CFoneDay,0)	oneDay").append(sp);
		sb.append("from ").append(sp);
		sb.append("CT_WAG_AttendanceBill			t1").append(sp);
		sb.append("inner join CT_WAG_AttendanceBillEntry	t2	on t2.FParentID = t1.FID").append(sp);
		sb.append("inner join CT_WAG_WageOrganization		t4	on t4.FID = t1.CFtheGroupID").append(sp);
		
		//sb.append("inner join T_HR_EmpEnrollBizBillEntry    t5  on t5.FPersonID = t2.CFPersonNumID").append(sp);
		
		sb.append("where t2.CFPersonNumID is not null ").append(sp);
		sb.append("and to_char(t1.FBizDate,'yyyy-MM') = '").append(dateString).append("'").append(sp);
		sb.append("and t1.CFCompanyID = '").append(companyID).append("'").append(sp);
		sb.append("and FBillStatus ='4'").append(sp);
		sb.append("order by fbizDate,CFPersonName").append(sp);
		sb.append(")").append(sp);
		sb.append("group by personName,personID,lifeSubsidy,attendance,oneDay,EmployerInsur,Fiverisks").append(sp);
		sb.append("order by  personName").append(sp);
		//System.out.println(sb.toString());
		//执行sql获取全部当月全部出勤的员工，生活补助，全勤奖，工作天数。
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			while(rs.next()){
				
				IRow row = kdtEntry.addRow();
				String personID = rs.getString("personID");
				double workDays = Double.parseDouble(rs.getString("工作天数"));
				int lifeSubsidy = Integer.valueOf(rs.getString("生活补助")).intValue();
				//String indate = rs.getString("inDate");
				String attendance =rs.getString("全勤奖");
				double oneday = Double.valueOf(attendance);
				//查询员工是否辞职
				String personEmp = foundPersonleave(personID,dateString);
				//全勤奖跟应出勤天数判断
				if(personEmp.equals("自动离职")){
					row.getCell("attendanceWages").setValue(0);
				}else{
					if(workDays>=Double.parseDouble(txtworkDayss.getText())){
						if(rs.getString("oneday").equals("1")){
							row.getCell("attendanceWages").setValue(oneday*workDays);
						}else{
							row.getCell("attendanceWages").setValue(attendance);
						}
							
					}else{
						row.getCell("attendanceWages").setValue(0);
					}
				}
				
				//入职日期
				getPersonIndate(row,personID,dateString);
				
				//雇主责任险
				row.getCell("EmployerInsurance").setValue(rs.getString("EmployerInsur"));
				BigDecimal Fiverisks = new BigDecimal(rs.getString("Fiverisks"));
				//根据员工ID获取员工Info
				PersonInfo personInfo = PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(personID));
				row.getCell("person").setValue(personInfo);
				row.getCell("personName").setValue(personInfo.getName());
				row.getCell(8).setValue(personInfo.getIdCardNO());
				row.getCell(9).setValue(personInfo.getCell());
				//根据员工ID获取员工岗位Info
				BasicPostInfo bpInfo = getPersonPost(rs.getString("personID"),companyID);
				if(bpInfo ==null){
//					MsgBox.showWarning(personInfo.getName()+"此员工没有岗位，请查实后再计算工资");
//					break;
					System.out.println(personInfo.getName()+"此员工没有岗位，请查实后再计算工资");
					row.getCell("basicWages").setValue(0);
				}else{
					row.getCell("personPost").setValue(bpInfo);
					//所属班组
					row.getCell("theGroup").setValue(gettheGroup(bpInfo.getTheGroup().getId().toString()));
					//获取员工岗位的基本工资
					if(bpInfo.getBasicWages()!=null){
						BigDecimal basicWages = bpInfo.getBasicWages();
						basicWages = basicWages.multiply(new BigDecimal(workDays));
						basicWages = basicWages.divide(new BigDecimal(this.txtworkDayss.getText()), 2, BigDecimal.ROUND_HALF_UP);
						row.getCell("basicWages").setValue(basicWages);
					}else{
						row.getCell("basicWages").setValue(0);
					}
					if(bpInfo.getEntry()!=null){
						for(int i = 0;i<bpInfo.getEntry().size();i++){
							BasicPostEntryInfo bpeInfo = bpInfo.getEntry().get(i);
							if(bpeInfo.getPerson().getId().toString().equals(personInfo.getId().toString())){
								row.getCell(7).setValue(bpeInfo.getBankcar());
							}
						}
					}
				}
				//row.getCell("personPost").setValue(bpInfo);
				
				
				
				//工作天数
				//row.getCell("workDays").setValue(workDays);
				row.getCell("workDay").setValue(workDays);
				//生活补助= 工作天数*生活补助				//详细工作天数getWorkDays()
				if(personEmp.equals("自动离职")){
					row.getCell("lifeWages").setValue(0);
				}else{
//					row.getCell("lifeWages").setValue(getWorkDays(personID,dateString)*lifeSubsidy);
					row.getCell("lifeWages").setValue(workDays*lifeSubsidy);
				}
				//获取当前员工分数工资
				getFractionWages(row,personID,dateString,companyID);
				//获取当前员工奖罚工资
				getJFWages(row,personID,dateString);
				
				//获取当前员工工龄奖
				if(personEmp.equals("自动离职")){
					row.getCell("seniorityWages").setValue(0);
				}else{
					getGLJWages(row,personID,dateString);
				}
				getyglx(row,personID,dateString);
				
				
				//获取当前员工计件工资
				getByTheJobWages(row,personID,dateString);
				//获取当前员工调整工资
				getTZWages(row,personID,dateString);
				//补贴单
				getBySocialwelfare(row,personID,dateString);
				//获取当前员工岗位补助
				if(personEmp.equals("自动离职")){
					row.getCell("postWages").setValue(0);
				}else{
					getGWBZWages(row,personID,dateString);
				}
				//获取当前员工介绍费
				if(personEmp.equals("正常")){
					getJSFWages(row,personID,dateString);
				}else{
					row.getCell("introduceWages").setValue(0);
				}
				
				//计算总工资
				double aa=
				Double.parseDouble(row.getCell("fractionWages").getValue().toString())+
				Double.parseDouble(row.getCell("bythejobWages").getValue().toString())+
				Double.parseDouble(row.getCell("sanctionWages").getValue().toString())+
				Double.parseDouble(row.getCell("seniorityWages").getValue().toString())+
				Double.parseDouble(row.getCell("attendanceWages").getValue().toString())+
				Double.parseDouble(row.getCell("lifeWages").getValue().toString())+
				Double.parseDouble(row.getCell("introduceWages").getValue().toString())+
				Double.parseDouble(row.getCell("postWages").getValue().toString())+
				Double.parseDouble(row.getCell("basicWages").getValue().toString())+
				Double.parseDouble(row.getCell("adjustmentWages").getValue().toString());
				aa = new BigDecimal(aa).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();  
				row.getCell("allWags").setValue(aa);
				BigDecimal sumWage = new BigDecimal(aa);
				sumWage = sumWage.add(new BigDecimal(row.getCell("Welfare").getValue().toString()));
				BigDecimal DKGS = new BigDecimal(getWorkmonthFacadeFactory.getRemoteInstance().getdkgs(sumWage.toString(), companyID));
				row.getCell("PersonTax").setValue(DKGS);
				//实发工资 = 应发工资-雇主责任险-五险-个人所得税
				BigDecimal Payroll = new BigDecimal(aa);
				Payroll = Payroll.subtract(new BigDecimal(row.getCell("EmployerInsurance").getValue().toString()));
				Payroll = Payroll.subtract(Fiverisks);
				Payroll = Payroll.subtract(DKGS);
				row.getCell("Payroll").setValue(Payroll);
				
			}
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
	}
	//获取员工入职时间
	private void getPersonIndate(IRow row, String personID, String dateString) {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sb = new StringBuffer();
    	String sp = "\n";
    	sb.append("/*dialect*/").append(sp);
    	sb.append("select ").append(sp);
    	sb.append("to_char(t1.FEnterDate,'yyyy-MM-dd')	inDate").append(sp);
    	sb.append("from ").append(sp);
    	sb.append("T_HR_PersonPosition			t1").append(sp);
    	//sb.append("inner join CT_WAG_Qualityawardticketentry 	t2 on t2.FParentID = t1.FID ").append(sp);
    	sb.append("where t1.FPersonID = '").append(personID).append("'").append(sp);
    	sb.append("and  rownum=1").append(sp);
    	
    	IRowSet rs;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			//	System.out.println(sb.toString());
			if(rs.next()){
				Date timeofentry;
				try {
					timeofentry = format.parse(rs.getString("inDate"));
					row.getCell("inDate").setValue(timeofentry);
					//row.getCell("sanctionWages").setValue(rs.getString("Amount"));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
	private String foundPersonleave(String personID, String dateString) {
		String personemp = "正常";
		StringBuffer sb = new StringBuffer();
    	String sp = "\n";
    	sb.append(" /*dialect*/").append(sp);
    	sb.append("select t2.FName_l2 from ").append(sp);
    	sb.append("T_HR_ResignBizBillentry 			t1").append(sp);
    	sb.append("inner join T_HR_BDEmployeeType		t2	on t2.FID = t1.FEMPTypeID").append(sp);
    	sb.append("where t1.FpersonID ='").append(personID).append("' and to_char(t1.FBizDate,'yyyy-MM') = '").append(dateString).append("'").append(sp);
    	try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			if(rs.next()){
				personemp = rs.getString("FName_l2");
				//已离职的反写介绍费分录
				String sql = "update CT_WAG_MiddlemanFeeBillentry set CFStopPoint = 1 where  CFPersonID = '"+personID+"'";
				CommFacadeFactory.getRemoteInstance().excuteUpdateSql(sql);
				
			}
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
		return personemp;
		
	}
	//获取员工实际工作天数
	private int getWorkDays(String personID, String dateString) {
		StringBuffer sb = new StringBuffer();
    	String sp = "\n";
    	sb.append(" /*dialect*/").append(sp);
    	sb.append("	select count(*) days").append(sp);
    	sb.append("	from (").append(sp);
    	sb.append("	select ").append(sp);
    	sb.append("	distinct").append(sp);
    	sb.append("	to_char(t1.FBizDate,'yyyy-MM-dd')	fbizDate,").append(sp);
    	sb.append("t2.CFPersonName	personName").append(sp);
		sb.append("	from ").append(sp);
		sb.append("	CT_WAG_AttendanceBill			t1").append(sp);
		sb.append("inner join CT_WAG_AttendanceBillEntry	t2	on t2.FParentID = t1.FID").append(sp);
		sb.append("	inner join CT_WAG_WageOrganization		t4	on t4.FID = t1.CFtheGroupID").append(sp);
		sb.append("	where t2.CFPersonNumID is not null ").append(sp);
		sb.append("	and to_char(t1.FBizDate,'yyyy-MM') = '").append(dateString).append("'").append(sp);
		sb.append("	and t2.CFPersonNumID = '").append(personID).append("'").append(sp);
		sb.append("and FBillStatus ='4'").append(sp);
		sb.append("order by fbizDate,CFPersonName)").append(sp);
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			if(rs.next()){
				return Integer.valueOf(rs.getString("days")).intValue();
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	//获取员工基础岗位
    private BasicPostInfo getPersonPost(String string,String companyID) {
    	BasicPostInfo reBPInfo = null;
    	StringBuffer sb = new StringBuffer();
    	String sp = "\n";
    	sb.append("select t1.FID FID from ").append(sp);
    	sb.append("	CT_WAG_BasicPost 			t1").append(sp);
    	sb.append("	inner join CT_WAG_BasicPostEntry		t2	on t2.FParentID = t1.FID").append(sp);
    	sb.append("	where t2.CFPersonID = '").append(string).append("'").append(sp);
    	sb.append("	and t1.CFCompanyID = '").append(companyID).append("'").append(sp);
    	try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			if(rs.next()){
				reBPInfo = BasicPostFactory.getRemoteInstance().getBasicPostInfo(new ObjectUuidPK(rs.getString("FID")));
				
			}else{
				return reBPInfo;
			}
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
    	
    	return reBPInfo;
    }
  //获取员工班组
    private WageOrganizationInfo gettheGroup(String string) {
    	WageOrganizationInfo reBPInfo = null;
    	StringBuffer sb = new StringBuffer();
    	String sp = "\n";
    	sb.append("select t1.FID FID from ").append(sp);
    	sb.append("	CT_WAG_WageOrganization 			t1").append(sp);
    	//sb.append("	inner join CT_WAG_BasicPostEntry		t2	on t2.FParentID = t1.FID").append(sp);
    	sb.append("	where t1.FID = '").append(string).append("'").append(sp);
    	try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			if(rs.next()){
				reBPInfo = WageOrganizationFactory.getRemoteInstance().getWageOrganizationInfo(new ObjectUuidPK(rs.getString("FID")));
				
			}else{
				return reBPInfo;
			}
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
    	
    	return reBPInfo;
    }
    //获取当前员工分数工资
    private void getFractionWages(IRow row, String personID, String dateString,String companyID) {
    	StringBuffer sb = new StringBuffer();
    	String sp = "\n";
//    	sb.append("/*dialect*/").append(sp);
//    	sb.append("select ").append(sp);
//    	sb.append("nvl(sum(CFFraction),0)	fractionWages ").append(sp);
//    	sb.append("from ").append(sp);
//    	sb.append("CT_WAG_FractionBill			t1").append(sp);
//    	sb.append("inner join CT_WAG_FractionBillentry 	t2 on t2.FParentID = t1.FID ").append(sp);
//    	sb.append("where t2.CFPersonID = '").append(personID).append("'").append(sp);
//    	sb.append("and to_char(t1.FBizDate,'yyyy-MM') = '").append(dateString).append("'").append(sp);
//    	sb.append("and FBillStatus = '4'").append(sp);
    	
//    	sb.append("/*dialect*/").append(sp);
//    	sb.append("select sum(fractionWages) fractionWages from (").append(sp);
//    	sb.append("select ").append(sp);
//    	sb.append("nvl(sum(t2.CFFraction),0)	fractionWages ").append(sp);
//    	sb.append("from ").append(sp);
//    	sb.append("CT_WAG_FractionBill			t1").append(sp);
//    	sb.append("inner join CT_WAG_FractionBillentry 	t2 on t2.FParentID = t1.FID ").append(sp);
//    	sb.append("and  to_char(t1.FBizDate,'yyyy-MM') = '").append(dateString).append("'").append(sp);
//    	sb.append("and t2.CFPersonID = '").append(personID).append("'").append(sp);
//    	sb.append("and FBillStatus = '4'").append(sp);
//    	sb.append("union all").append(sp);
//    	sb.append("select nvl(sum(t2.CFScore),0) fractionWages from  CT_WAG_FractionOtherBill t1").append(sp);
//    	sb.append("inner join CT_WAG_FractionOtherBillEntry t2 on t2.FParentID = t1.FID ").append(sp);
//    	sb.append("where to_char(t1.FBizDate,'yyyy-MM') = '").append(dateString).append("'").append(sp);
//    	sb.append("and t2.CFPersonID = '").append(personID).append("'").append(sp);
//    	sb.append(")").append(sp);
    	sb.append("/*dialect*/").append(sp);
    	sb.append("select sum(fractionWages) fractionWages,sum(Score) Score from (").append(sp);
    	sb.append("select ").append(sp);
    	sb.append("nvl(sum(t2.CFFraction),0)	fractionWages, ").append(sp);
    	sb.append("nvl(t5.CFScore,0) Score ").append(sp);
    	sb.append("from ").append(sp);
    	sb.append("CT_WAG_FractionBill			t1").append(sp);
    	sb.append("inner join CT_WAG_FractionBillentry 	t2 on t2.FParentID = t1.FID ").append(sp);
    	
    	sb.append("and t1.CFCompanyID  = '"+companyID+"'").append(sp);
    	
      	sb.append("inner join CT_WAG_BasicPostEntry t6 on t6.CFPersonID = t2.CFPersonID ").append(sp);
    	sb.append("inner join CT_WAG_BasicPost t3 on t3.FID = t6.FParentID ").append(sp);
    	sb.append("inner join CT_WAG_WageOrganization t4 on t4.FID = t3.CFTheGroupID ").append(sp);
    	sb.append("and  to_char(t1.FBizDate,'yyyy-MM') = '").append(dateString).append("'").append(sp);
    	sb.append("and t2.CFPersonID = '").append(personID).append("'").append(sp);
    	sb.append("and FBillStatus = '4'").append(sp);
    	sb.append("inner  join CT_WAG_ScoreStandard  t5 on t5.CFTheGroupID = t4.FID ").append(sp);
    	sb.append("and t5.CFCompanyID  = '"+companyID+"'").append(sp);

    	
    	sb.append("group by t5.CFScore,t4.FName_l2  ").append(sp);
    	sb.append("union all").append(sp);
    	sb.append("select nvl(sum(t2.CFScore),0) fractionWages,0 Score from  CT_WAG_FractionOtherBill t1").append(sp);
    	sb.append("inner join CT_WAG_FractionOtherBillEntry t2 on t2.FParentID = t1.FID ").append(sp);
    	sb.append("where to_char(t1.FBizDate,'yyyy-MM') = '").append(dateString).append("'").append(sp);
    	sb.append("and t2.CFPersonID = '").append(personID).append("'").append(sp);
    	sb.append(")").append(sp);
    	try {
    		System.out.println(sb.toString());
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			if(rs.next()){
//				double score = Double.parseDouble(txtscore.getText()) ;
				double score = Double.parseDouble(rs.getString("Score"));
				row.getCell("fractionQty").setValue(rs.getString("fractionWages"));
				row.getCell("fractionWages").setValue(Double.parseDouble(rs.getString("fractionWages"))*score);
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  //获取当前员工奖罚工资
    private void getJFWages(IRow row, String personID, String dateString) {
    	StringBuffer sb = new StringBuffer();
    	String sp = "\n";
    	sb.append("/*dialect*/").append(sp);
    	sb.append("select ").append(sp);
    	sb.append("nvl(sum(t2.CFAmount),0) Amount").append(sp);
    	sb.append("from ").append(sp);
    	sb.append("CT_WAG_Qualityawardticket			t1").append(sp);
    	sb.append("inner join CT_WAG_Qualityawardticketentry 	t2 on t2.FParentID = t1.FID ").append(sp);
    	sb.append("where CFpersonID = '").append(personID).append("'").append(sp);
    	sb.append("and to_char(t1.CFStartDate,'yyyy-MM') = '").append(dateString).append("'").append(sp);
    	sb.append("and CFBillStatus = '4'").append(sp);
    	IRowSet rs;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			if(rs.next()){
				row.getCell("sanctionWages").setValue(rs.getString("Amount"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
  //获取当前员工用工类型
    private void getyglx(IRow row, String personID, String dateString) {
    	StringBuffer sb = new StringBuffer();
    	String sp = "\n";
    	sb.append("/*dialect*/").append(sp);
    	sb.append("select  nvl(cfworknatureid,0) worknatureid  from t_bd_person ").append(sp);
    	sb.append("where fid = '").append(personID).append("'").append(sp);
    	IRowSet rs;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			if(rs.next()){
				if(rs.getString("worknatureid").equals("0")){
					row.getCell("worknature").setValue(null);
				}else{
					EmployeePropertInfo info = EmployeePropertFactory.getRemoteInstance().getEmployeePropertInfo(new ObjectStringPK(rs.getString("worknatureid")));
					row.getCell("worknature").setValue(info);
				}
			}
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
		
	}
	//获取当前员工工龄奖
    private void getGLJWages(IRow row, String personID, String dateString){
    	StringBuffer sb = new StringBuffer();
    	String sp = "\n";
    	sb.append("/*dialect*/").append(sp);
    	sb.append("select").append(sp);
    	sb.append("nvl(sum(t2.CFMoneys),0)	moneys from ").append(sp);
    	sb.append("CT_WAG_SeniorityBonus 			t1").append(sp);
    	sb.append("inner join CT_WAG_SeniorityBonusEntry	t2	on t2.FParentID = t1.FID").append(sp);
    	sb.append("where CFpersonID = '").append(personID).append("'").append(sp);
    	sb.append("and to_char(t1.FBizDate,'yyyy-MM') = '").append(dateString).append("'").append(sp);
    	sb.append("and FBillStatus = '4'").append(sp);
    	IRowSet rs;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			if(rs.next()){
				row.getCell("seniorityWages").setValue(rs.getString("moneys"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //获取当前员工计件工资
    private void getByTheJobWages(IRow row, String personID, String dateString){
    	StringBuffer sb = new StringBuffer();
    	String sp = "\n";
    	sb.append("/*dialect*/").append(sp);
    	sb.append("select nvl(sum(t2.CFPieceMoney),0)	PieceMoney	 from ").append(sp);
    	sb.append("CT_WAG_ByThePieceBill 			t1").append(sp);
    	sb.append("inner join CT_WAG_ByThePieceBillEntry	t2 on t2.FParentID = t1.FID").append(sp);
    	sb.append("where t2.CFpersonID = '").append(personID).append("'").append(sp);
    	sb.append("and to_char(t1.FBizDate,'yyyy-MM') = '").append(dateString).append("'").append(sp);
    	sb.append("and FBillStatus = '4'").append(sp);
    	IRowSet rs;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			if(rs.next()){
				row.getCell("bythejobWages").setValue(rs.getString("PieceMoney"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
  //获取当前员工补贴单
    private void getBySocialwelfare(IRow row, String personID, String dateString){
    	StringBuffer sb = new StringBuffer();
    	String sp = "\n";
    	sb.append("/*dialect*/").append(sp);
    	sb.append("select nvl(sum(t2.CFAmount),0) Amount	 from ").append(sp);
    	sb.append(" CT_WAG_Socialwelfare 	t1").append(sp);
    	sb.append("inner join CT_WAG_SocialwelfareEntry	t2 on t2.FParentID = t1.FID").append(sp);
    	sb.append("where t2.CFpersonID = '").append(personID).append("'").append(sp);
    	sb.append("and to_char(t1.FBizDate,'yyyy-MM') = '").append(dateString).append("'").append(sp);
    	sb.append("and CFBillStatus = '4'").append(sp);
    	IRowSet rs;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			//System.out.println(sb);
			if(rs.next()){
				row.getCell("Welfare").setValue(rs.getString("Amount"));
				//System.out.println("-----"+row.getCell("houseamount").toString());
				//row.getCell("houseamount").setValue(rs.getString("houseamount"));
				//row.getCell("traiamount").setValue(rs.getString("traamount"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //获取当前员工调整工资
    private void getTZWages(IRow row, String personID, String dateString){
    	StringBuffer sb = new StringBuffer();
    	String sp = "\n";
    	sb.append("/*dialect*/").append(sp);
    	sb.append("select nvl(sum(t2.CFAdjustmentWages),0)+nvl(sum(t2.CFHouse),0)+nvl(sum(t2.CFTrai),0)	AdjustmentWages,nvl(sum(t2.CFHouse),0) houseamount,nvl(sum(t2.CFTrai),0) traamount	 from ").append(sp);
    	sb.append(" CT_WAG_Adjustmoney 	t1").append(sp);
    	sb.append("inner join CT_WAG_AdjustmoneyEntry	t2 on t2.FParentID = t1.FID").append(sp);
    	sb.append("where t2.CFpersonID = '").append(personID).append("'").append(sp);
    	sb.append("and to_char(t1.FBizDate,'yyyy-MM') = '").append(dateString).append("'").append(sp);
    	sb.append("and CFBillStatus = '4'").append(sp);
    	IRowSet rs;
		try {
			rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			//System.out.println(sb);
			if(rs.next()){
				row.getCell("adjustmentWages").setValue(rs.getString("AdjustmentWages"));
				//System.out.println("-----"+row.getCell("houseamount").toString());
				//row.getCell("houseamount").setValue(rs.getString("houseamount"));
				//row.getCell("traiamount").setValue(rs.getString("traamount"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    //获取当前员工岗位补助
	private void getGWBZWages(IRow row, String personID, String dateString) {
		// TODO Auto-generated method stub
		java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM");
		Date date = null;
		try {
			date = formatter.parse(dateString);
			String yearMonth = formatter.format(date);
			StringBuffer sb = new StringBuffer();
	    	String sp = "\n";
	    	sb.append("/*dialect*/").append(sp);
//	    	sb.append("select t2.CFAllMoney/t2.CFAllMonth postWages from CT_WAG_PostSubsidy 	t1").append(sp);
	    	sb.append("select nvl(sum(t2.CFPostWages),0) postWages from CT_WAG_PostSubsidy 	t1").append(sp);
	    	sb.append("inner join CT_WAG_PostSubsidyEntry	t2	on t2.FParentID = t1.FID").append(sp);
//	    	sb.append("where to_char(t2.CFStartMonth,'yyyy-MM')  <= '").append(yearMonth).append("'").append(sp);
//	    	sb.append("and  to_char(t2.CFEndMonth,'yyyy-MM')>= '").append(yearMonth).append("'").append(sp);
	    	sb.append("where to_char(t1.FBizDate,'yyyy-MM')  = '").append(yearMonth).append("'").append(sp);
	    	sb.append("and t1.FBillStatus = '4'").append(sp);
	    	sb.append("and t2.CFpersonID = '").append(personID).append("'").append(sp);
	    	IRowSet	rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
	    	//System.out.println("岗位补助"+sb);
			if(rs.next()){
				row.getCell("postWages").setValue(rs.getString("postWages"));
			}else{
				row.getCell("postWages").setValue(0);
			}
			} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取当前员工介绍费
	private void getJSFWages(IRow row, String personID, String dateString) {
		// TODO Auto-generated method stub
		java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM");
		Date date = null;
		try {
			date = formatter.parse(dateString);
			String yearMonth = formatter.format(date);
			StringBuffer sb = new StringBuffer();
	    	String sp = "\n";
	    	sb.append("/*dialect*/").append(sp);
//	    	sb.append("select t2.CFAllMoney/t2.CFAllMonth midWages from CT_WAG_MiddlemanFeeBill t1").append(sp);
	    	sb.append("select nvl(sum(t2.CFMidWages),0) midWages from CT_WAG_MiddlemanFeeBill t1").append(sp);
	    	
	    	sb.append("inner join CT_WAG_MiddlemanFeeBillentry	t2	on	t2.FParentID = t1.FID").append(sp);
//	    	sb.append("where to_char(t2.CFStratMonth,'yyyy-MM')  <= '").append(yearMonth).append("'").append(sp);
//	    	sb.append("and  to_char(t2.CFEndMonth,'yyyy-MM')>= '").append(yearMonth).append("'").append(sp);
	    	sb.append("where to_char(t1.FBizDate,'yyyy-MM')  = '").append(yearMonth).append("'").append(sp);
	    	sb.append("and t1.FBillStatus = '4'").append(sp);
	    	sb.append("and t2.CFpersonID = '").append(personID).append("'").append(sp);
	    	sb.append("and (t2.CFStopPoint = '0' or t2.CFStopPoint is null)");
	    	IRowSet	rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
	    	//System.out.println("介绍费"+sb);
			if(rs.next()){
				row.getCell("introduceWages").setValue(rs.getString("midWages"));
			}else{
				row.getCell("introduceWages").setValue(0);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 /**
     * output actionSubmit_actionPerformed
     */
    public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
    {
    	BigDecimal sumWages = new BigDecimal("0");
    	int m = 0;
    	StringBuffer personname = new StringBuffer();
		MonthWagesEntryCollection infoec = editData.getEntry();
		for(int i=0;i<infoec.size();i++){
			MonthWagesEntryInfo infoe = infoec.get(i);
			sumWages = infoe.getAllWags();
			BigDecimal cywages = sumWages.subtract(new BigDecimal("10000"));
			if(cywages.intValue()>0){
				personname.append(infoe.getPersonName()+" ");
				m = 1;
			}
		}
    	if(m==1){
    		MsgBox.showWarning("用户："+personname.toString()+"总工资超过10000元！");
    	}
        super.actionSubmit_actionPerformed(e);
    }
    
}