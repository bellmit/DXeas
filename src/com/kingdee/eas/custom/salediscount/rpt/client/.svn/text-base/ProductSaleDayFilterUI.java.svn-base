package com.kingdee.eas.custom.salediscount.rpt.client;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.eas.basedata.master.auxacct.AsstActTypeFactory;
import com.kingdee.eas.basedata.master.auxacct.AsstActTypeInfo;
import com.kingdee.eas.basedata.master.auxacct.AsstActTypeSysEnum;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.person.client.PersonF7UI;
import com.kingdee.eas.basedata.person.client.PersonPromptBox;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.fi.arap.client.util.ArApBillUIUtil;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
//产品销量日报表
public class ProductSaleDayFilterUI extends AbstractProductSaleDayFilterUI {

	public ProductSaleDayFilterUI() throws Exception {
		super();
		// TODO 自动生成构造函数存根
	}
	public void onLoad() throws Exception {
		super.onLoad();
		this.SetPrmtF7();
		this.SetDate();
		String FCUID;
		FCUID = SysContext.getSysContext().getCurrentFIUnit().getId()
				.toString();
		if (FCUID.equals("00000000-0000-0000-0000-000000000000CCE7AED4")) {
			MsgBox.showInfo("当前公司为虚体，不允许使用该功能。请选择实体公司！");
			SysUtil.abort();
		}
	}
	
    protected void dpDate_dataChanged(DataChangeEvent e) throws Exception {
		Date FDate=(Date)this.dpDate.getValue();
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");         
		int FYear=FDate.getYear()+1900;
		int FMonth=FDate.getMonth()+1;
		int FBeginDay=FDate.getDay();
		int FEndDay=0;
		Date FBeignDateA=null;
		Date FEndDateA=null;
		Date FLastBeignDateA=null;
		Date FLastEndDateA=null;
		String FBeignDate= String.valueOf(FYear)+"-"+String.valueOf(FMonth)+"-01"; 
		String FEndDate= String.valueOf(FYear)+"-"+String.valueOf(FMonth)+"-"+getEndDateOfMonth(String.valueOf(FYear),String.valueOf(FMonth));
		String FLastBeignDate="";
		String FLastEndDate="";
		if(FMonth==1){
			FLastBeignDate= String.valueOf(FYear-1)+"-12-01"; 
			FLastEndDate= String.valueOf(FYear)+"-12-31";
		}else{
			FLastBeignDate= String.valueOf(FYear)+"-"+String.valueOf(FMonth-1)+"-01"; 
			FLastEndDate= String.valueOf(FYear)+"-"+String.valueOf(FMonth-1)+"-"+getEndDateOfMonth(String.valueOf(FYear),String.valueOf(FMonth-1));
		}
		try { 
			FBeignDateA=format1.parse(FBeignDate);
			FEndDateA=format1.parse(FEndDate);
			FLastBeignDateA=format1.parse(FLastBeignDate);
			FLastEndDateA=format1.parse(FLastEndDate);
			} catch (Exception ex) { 

			} 
		this.dpLastEndDate.setDatePattern("yyyy-MM-dd");
		this.dpBeginDate.setValue(FBeignDateA);
		this.dpProxBeginDate.setValue(FEndDateA);
		this.dpLastBeginDate.setValue(FLastBeignDateA);
		this.dpLastEndDate.setValue(FLastEndDateA);
		//this.dpBeginDate.setValue()
		super.dpDate_dataChanged(e);
	}
    public static String getEndDateOfMonth(String FYear,String FMonth) {// yyyy-MM-dd
    	   int mon = Integer.parseInt(FMonth);
    	   String str="";
    	   if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12) {
    	    str= "31";
    	   } else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {
    	    str = "30";
    	   } else {
    	    if (isLeapYear(FYear)) {
    	     str = "29";
    	    } else {
    	     str= "28";
    	    }
    	   }
    	   return str;
    	}
    public static boolean isLeapYear(String FYear) {

    	   /**
    	    * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
    	    * 3.能被4整除同时能被100整除则不是闰年
    	    */
    	   SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
    	   String dateStringToParse =FYear+"-01-01";
    	   Date d = null;
			try {
				d = bartDateFormat.parse(dateStringToParse);
			} catch (ParseException e) {
				// TODO 自动生成 catch 块
				e.printStackTrace();
			} 
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

	protected void dpBeginDate_dataChanged(DataChangeEvent e) throws Exception {
		Date FDate=(Date)this.dpBeginDate.getValue();
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");         
		int FYear=FDate.getYear()+1900;
		int FMonth=FDate.getMonth()+1;
		int FBeginDay=FDate.getDay();
		String FEndDate= String.valueOf(FYear)+"-"+String.valueOf(FMonth)+"-"+getEndDateOfMonth(String.valueOf(FYear),String.valueOf(FMonth));
		Date FEndDateA=null;
		try { 
			FEndDateA=format1.parse(FEndDate);
			} catch (Exception ex) { 

			} 
		this.dpProxBeginDate.setValue(FEndDateA);
		super.dpBeginDate_dataChanged(e);
	}
	protected void dpLastBeginDate_dataChanged(DataChangeEvent e) throws Exception {
		Date FDate=(Date)this.dpLastBeginDate.getValue();
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");         
		int FYear=FDate.getYear()+1900;
		int FMonth=FDate.getMonth()+1;
		int FBeginDay=FDate.getDay();
		String FLastEndDate= String.valueOf(FYear)+"-"+String.valueOf(FMonth)+"-"+getEndDateOfMonth(String.valueOf(FYear),String.valueOf(FMonth));
		Date FLastEndDateA=null;
		try { 
				FLastEndDateA=format1.parse(FLastEndDate);
			} catch (Exception ex) { 
				
			}
		this.dpLastEndDate.setValue(FLastEndDateA);
		super.dpLastBeginDate_dataChanged(e);
	}
	/**
     * 设置F7
     */
    public void SetPrmtF7()throws Exception{
    	//公司
		
		CompanyF7 org = new CompanyF7(this);
		org.disablePerm();
		org.setIsCUFilter(true);
		this.prmtCompany.setSelector(org);
		this.prmtCompany.setData(SysContext.getSysContext().getCurrentCompany());
		
		//业务员
		HashMap map = new HashMap();
		map.put(PersonF7UI.ALL_ADMIN, "YES");
		
		this.prmtBeginEmp.setSelector(new PersonPromptBox(this, map));
		prmtBeginEmp.setEditable(true);
		prmtBeginEmp.setDisplayFormat("$name$");
		prmtBeginEmp.setEditFormat("$number$");
		prmtBeginEmp.setCommitFormat("$name$");
		this.prmtBeginEmp.setVisible(true);
        this.prmtBeginEmp.setEditable(true);
        this.prmtBeginEmp.setRequired(true);
        this.prmtBeginEmp.setEnabled(true);
        
		this.prmtEndEmp.setSelector(new PersonPromptBox(this, map));
		prmtEndEmp.setEditable(true);
		prmtEndEmp.setDisplayFormat("$name$");
		prmtEndEmp.setEditFormat("$number$");
		prmtEndEmp.setCommitFormat("$name$");
		this.prmtEndEmp.setVisible(true);
        this.prmtEndEmp.setEditable(true);
        this.prmtEndEmp.setRequired(true);
        this.prmtEndEmp.setEnabled(true);
		//客户
		String currentCompanyId = SysContext.getSysContext().getCurrentFIUnit().getId().toString();
		AsstActTypeInfo	asstActTypeInfo= AsstActTypeFactory.getRemoteInstance().getAsstActType(AsstActTypeSysEnum.CUSTOMER);
		ArApBillUIUtil.setAsstActSelector(this,prmtBeginCustomer,asstActTypeInfo);
		this.prmtBeginCustomer.setCommitFormat("$name$");
		this.prmtBeginCustomer.setEnabledMultiSelection(false);
		
		ArApBillUIUtil.setAsstActSelector(this,prmtEndCustomer,asstActTypeInfo);
		this.prmtEndCustomer.setCommitFormat("$name$");
		this.prmtEndCustomer.setEnabledMultiSelection(false);
		
		this.chkisMaterialGroup.setSelected(true);
		
		this.cmbLevel.setVisible(true);
	    //this.cmbLevel.addItems(EnumUtils.getEnumList("com.kingdee.eas.custom.lhzr.Level").toArray());
	    this.cmbLevel.addItem("0");
	    this.cmbLevel.addItem("1");
	    this.cmbLevel.addItem("2");
	    this.cmbLevel.addItem("3");
	    this.cmbLevel.setRequired(false);
	    this.cmbLevel.setEnabled(true);
	    this.cmbLevel.setForeground(new java.awt.Color(0,0,0));
	  
	    this.cmbLevelA.addItem("3");
	    this.cmbLevelA.addItem("2");
	    this.cmbLevelA.addItem("1");
	    this.cmbLevelA.setRequired(false);
	    this.cmbLevelA.setEnabled(true);
	    this.cmbLevelA.setForeground(new java.awt.Color(0,0,0));
	    
		Date today = null;
		try {
			today = SCMClientUtils.getServerDate();
		} catch (Exception e) {
			super.handUIException(e);
			//e.printStackTrace();
		}
		//统计当天日期
		this.dpDate.setDatePattern("yyyy-MM-dd");
		this.dpDate.setValue(today);
		
		//上月开始日期
		this.dpLastBeginDate.setDatePattern("yyyy-MM-dd");
		this.dpLastBeginDate.setValue(today);
		//this.dpLastBeginDate.setVisible(false);
		//上月截止日期
		this.dpLastEndDate.setDatePattern("yyyy-MM-dd");
		this.dpLastEndDate.setValue(today);
		//this.dpLastEndDate.setVisible(false);
		
		//本月开始日期
		this.dpBeginDate.setDatePattern("yyyy-MM-dd");
		this.dpBeginDate.setValue(today);
		//this.dpBeginDate.setVisible(false);
		
		//下月开始日期
		this.dpProxBeginDate.setDatePattern("yyyy-MM-dd");
		this.dpProxBeginDate.setValue(today);
		//this.dpProxBeginDate.setVisible(false);
		
		//this.kDLabelContainer4.setVisible(false);
		//this.kDLabelContainer5.setVisible(false);
		//this.kDLabelContainer6.setVisible(false);
		//this.kDLabelContainer7.setVisible(false);
		this.rbtnSaleOrder.setSelected(true);
    }
	public boolean verify() {
		if(this.prmtCompany.getData()==null){
			MsgBox.showWarning("请选择公司！");
			SysUtil.abort();
		}
		if(this.prmtBeginEmp.getData()==null){
			if(this.prmtEndEmp.getData()!=null){
				MsgBox.showWarning("请选择起始职员！");
				SysUtil.abort();
			}
		}else{
			if(this.prmtEndEmp.getData()==null){
				MsgBox.showWarning("请选择截止职员！");
				SysUtil.abort();
			}
		}
		
		if(this.prmtBeginCustomer.getData()==null){
			if(this.prmtEndCustomer.getData()!=null){
				MsgBox.showWarning("请选择起始客户！");
				SysUtil.abort();
			}
		}else{
			if(this.prmtEndCustomer.getData()==null){
				MsgBox.showWarning("请选择截止客户！");
				SysUtil.abort();
			}
		}
		if(this.chkisArea.getSelected()==16&&this.chkisEmp.getSelected()==16){
			if(this.chkisCustomer.getSelected()==16&&this.chkisMaterial.getSelected()==16){
				if(this.chkisMaterialGroup.getSelected()==16){
					MsgBox.showWarning("请至少选择一个显示类别！");
					SysUtil.abort();
				}
			}
		}
		return true;
	}
	public void onInit(RptParams arg0) throws Exception {
		//ktTitle.setText("初始化参数:"+initParams.getString("title"));

	}

	public RptParams getCustomCondition() {
		RptParams pp = new RptParams();	
		String FCUID="";
		if(this.prmtCompany.getData()!=null){
			FCUID=((OrgUnitInfo)this.prmtCompany.getData()).getId().toString() ;
		}else{
			MsgBox.showWarning("请选择公司！");
			SysUtil.abort();
		}
		pp.setString("FCUID",FCUID);
		pp.setString("FdpDate",this.dpDate.getText());
		pp.setString("FdpLastBeginDate",this.dpLastBeginDate.getText());
		pp.setString("FdpLastEndDate",this.dpLastEndDate.getText());
		pp.setString("FdpBeginDate",this.dpBeginDate.getText());
		pp.setString("FdpProxBeginDate",this.dpProxBeginDate.getText());
		
		pp.setInt("FisArea",this.chkisArea.getSelected());
		pp.setInt("FisEmp",this.chkisEmp.getSelected());
		pp.setInt("FisCustomer",this.chkisCustomer.getSelected());
		pp.setInt("FisMaterialGroup",this.chkisMaterialGroup.getSelected());
		pp.setInt("FisMaterial",this.chkisMaterial.getSelected());
		
		//预混料
		pp.setInt("Fisyhl",this.chkisyhl.getSelected());
		
		pp.setInt("FLevel",this.cmbLevel.getSelectedIndex());
		pp.setInt("FLevelA",Integer.parseInt(this.cmbLevelA.getSelectedItem().toString()));
		pp.setBoolean("FisSaleOrder",this.rbtnSaleOrder.isSelected());
		pp.setBoolean("FisSaleIssue",this.rbtnSaleIssue.isSelected());
		pp.setBoolean("FisOtherBill",this.rbtnOtherBill.isSelected());
		
		pp.setObject("FCUIDO",this.prmtCompany.getData());
		//业务员
		pp.setObject("FBeginEmp",this.prmtBeginEmp.getData());
		pp.setObject("FEndEmp",this.prmtEndEmp.getData());
		//客户
		pp.setObject("FBeginCustomer",this.prmtBeginCustomer.getData());
		pp.setObject("FEndCustomer",this.prmtEndCustomer.getData());
		
		
		pp.setObject("FdpDateO",this.dpDate.getValue());
		
		return pp;
	}

	public void setCustomCondition(RptParams params) {
		this.prmtCompany.setData(params.getObject("FCUIDO"));
		//业务员
		this.prmtBeginEmp.setData(params.getObject("FBeginEmp"));
		this.prmtEndEmp.setData(params.getObject("FEndEmp"));
		//客户
		this.prmtBeginCustomer.setData(params.getObject("FBeginCustomer"));
		this.prmtEndCustomer.setData(params.getObject("FEndCustomer"));
		
		this.dpDate.setValue(params.getObject("FdpDateO"));

	}
	public void SetDate(){
		Date FDate=(Date)this.dpDate.getValue();
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");         
		int FYear=FDate.getYear()+1900;
		int FMonth=FDate.getMonth()+1;
		int FBeginDay=FDate.getDay();
		int FEndDay=0;
		Date FBeignDateA=null;
		Date FEndDateA=null;
		Date FLastBeignDateA=null;
		Date FLastEndDateA=null;
		String FBeignDate= String.valueOf(FYear)+"-"+String.valueOf(FMonth)+"-01"; 
		String FEndDate= String.valueOf(FYear)+"-"+String.valueOf(FMonth)+"-"+getEndDateOfMonth(String.valueOf(FYear),String.valueOf(FMonth));
		String FLastBeignDate="";
		String FLastEndDate="";
		if(FMonth==1){
			FLastBeignDate= String.valueOf(FYear-1)+"-12-01"; 
			FLastEndDate= String.valueOf(FYear)+"-12-31";
		}else{
			FLastBeignDate= String.valueOf(FYear)+"-"+String.valueOf(FMonth-1)+"-01"; 
			FLastEndDate= String.valueOf(FYear)+"-"+String.valueOf(FMonth-1)+"-"+getEndDateOfMonth(String.valueOf(FYear),String.valueOf(FMonth-1));
		}
		try { 
			FBeignDateA=format1.parse(FBeignDate);
			FEndDateA=format1.parse(FEndDate);
			FLastBeignDateA=format1.parse(FLastBeignDate);
			FLastEndDateA=format1.parse(FLastEndDate);
			} catch (Exception ex) { 

			} 
		this.dpLastEndDate.setDatePattern("yyyy-MM-dd");
		this.dpBeginDate.setValue(FBeignDateA);
		this.dpProxBeginDate.setValue(FEndDateA);
		this.dpLastBeginDate.setValue(FLastBeignDateA);
		this.dpLastEndDate.setValue(FLastEndDateA);
	}

}
