/**
 * output package name
 */
package com.kingdee.eas.custom.shr.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.util.backport.Collections;
import com.kingdee.bos.bi.model.DB.DBUtil;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTSelectManager;
import com.kingdee.bos.ctrl.swing.KDCheckBox;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.base.message.util.DateUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.shr.RecordBusChangeEntryCollection;
import com.kingdee.eas.custom.shr.RecordBusChangeEntryFactory;
import com.kingdee.eas.custom.shr.RecordBusChangeEntryInfo;
import com.kingdee.eas.custom.shr.RecordBusChangeFactory;
import com.kingdee.eas.custom.shr.RecordBusChangeInfo;
import com.kingdee.eas.fi.newrpt.client.designer.TableSorter;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class UpdateBusAndStopUI extends AbstractUpdateBusAndStopUI
{
	private static final Logger logger = CoreUIObject.getLogger(UpdateBusAndStopUI.class);
	/**
	 * output class constructor
	 */
	public UpdateBusAndStopUI() throws Exception
	{
		super();
	}

	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}
	String dbIP;//数据库IP
	Number dbPort;//数据库端口
	String userPassword;//用户密码
	String userName;//用户名
	String dbName;//数据库名称
	//定义了数字、通勤车、站点、姓名、班组、部门、入职日期、身份证号码数组，分别接收来自职员的信息
	ArrayList<String> number=new ArrayList<String>();
	ArrayList<String> bus=new ArrayList<String>();
	ArrayList<String> stop=new ArrayList<String>();
	ArrayList<String> name=new ArrayList<String>();
	ArrayList<String> className=new ArrayList<String>();
	ArrayList<String> department=new ArrayList<String>();
	ArrayList<String> enterDate=new ArrayList<String>();
	ArrayList<String> IDCardNum=new ArrayList<String>();
	//定义了两个ArrayList，用来保存   站点  和    通勤车    的基础资料
	ArrayList<String> stopList=new ArrayList<String>();
	ArrayList<String> busList=new ArrayList<String>();



	//连接和结果集的定义
	Connection conn=null;
	java.sql.ResultSet rs=null;
	PreparedStatement pre=null;

	String stringRefresh=null;



	//step1:加载界面的时候，把员工的通勤车和站点两个基础资料带进来加入到 两个下拉列表里面
	//step2：点击查询的时候，将列表的符合条件的数据筛选出来
	//step3：修改车次的时候，将后台数据库中的数值进行改变

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		//设置全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		//获得基础资料信息（班车、站点）
		getInformation();

		kdtPerson.checkParsed();
		//添加两个空的选项，用来数据过滤时可以返回到初始状态（即该选项不过滤）
		busList.add("");
		stopList.add("");
		//获取通勤车和站点的基础资料信息

		//开始日期的日期控件初始化数值为2000年1月1日
		this.DatePickerFrom.setDatePattern("yyyy-MM-dd");
		java.util.Date date = DateUtil.getDate(2000,1,1);
		this.DatePickerFrom.setValue(date);
		//对下拉的内容进行排序
		Collections.sort(busList);
		Collections.sort(stopList);

		//在查询部分和修改部分的下拉列表里都增加上对应的基础资料
		for(int i=0;i<busList.size();i++)
		{
			this.cboxBusList.addItem(busList.get(i));
			this.cBoxBus.addItem(busList.get(i));			
		}

		for(int i=0;i<stopList.size();i++)
		{
			this.cboxStopList.addItem(stopList.get(i));
			this.cBoxStop.addItem(stopList.get(i));			
		}

		kdtPerson.getColumn("isSelected").setWidth(15);
		kdtPerson.getColumn("IDCardNum").setWidth(180);
		kdtPerson.getSelectManager().setSelectMode(KDTSelectManager.MULTIPLE_ROW_SELECT);
		kdtPerson.setAutoResize(true);//设置列宽自适应表格的宽度
		//升序或者降序排序		
		TableSorter sorter=new TableSorter(kdtPerson);		
		sorter.setOrder(0);
		//设置某些列不可编辑
		kdtPerson.getColumn("number").getStyleAttributes().setLocked(true);
		kdtPerson.getColumn("name").getStyleAttributes().setLocked(true);
		kdtPerson.getColumn("class").getStyleAttributes().setLocked(true);
		kdtPerson.getColumn("bus").getStyleAttributes().setLocked(true);
		kdtPerson.getColumn("stop").getStyleAttributes().setLocked(true);
		kdtPerson.getColumn("enterDate").getStyleAttributes().setLocked(true);
		kdtPerson.getColumn("IDCardNum").getStyleAttributes().setLocked(true);


		//释放内存
		if(stopList!=null)
			stopList.clear();
		if(busList!=null)
			busList.clear();
		if(enterDate!=null)
			enterDate.clear();
		if(className!=null)
			className.clear();


		//表格第一列设置为复选框
		KDCheckBox kdtPerson_isMarketed_CheckBox = new KDCheckBox();
		kdtPerson_isMarketed_CheckBox.setName("kdtPerson_isMarketed_CheckBox");
		KDTDefaultCellEditor kdtPerson_isMarketed_CellEditor = new KDTDefaultCellEditor(kdtPerson_isMarketed_CheckBox);
		this.kdtPerson.getColumn("isSelected").setEditor(kdtPerson_isMarketed_CellEditor);
	}
	/** override
	 * @operation 修改员工通勤信息
	 *修改时需要注意的事项：1.不允许同时修改员工的车次和站点
	 *  2.修改时必须选择站点或者通勤车
	 * @status 0
	 */
	@Override
	protected void confirm_mouseClicke(MouseEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.cBoxBus.getSelectedItem().equals("")&&this.cBoxStop.getSelectedItem().equals(""))
		{
			MsgBox.showInfo("请选择要导入的车次或者站点信息");
			return;
		}
		ArrayList<Integer> rowNum=new ArrayList<Integer>();
		for(int i=0;i<kdtPerson.getRowCount();i++)
			if(this.kdtPerson.getRow(i).getCell("isSelected").getValue()!=null)
				if(this.kdtPerson.getRow(i).getCell("isSelected").getValue().equals(true))
					rowNum.add(i);
		if(rowNum.size()==0)
		{
			MsgBox.showInfo("请选择需要修改的员工");
			return;
		}
		//定义一个字符串，用来存放被选择的员工的编码，保存格式为('num1','num2','num3'...),用途：sql语句in()
		String fnumber="(";
		for(int i=0;i<rowNum.size();i++)
		{
			if(i>0)
				fnumber+=",";
			String temp=kdtPerson.getRow(rowNum.get(i)).getCell("number").getValue().toString();
			fnumber+="'"+temp+"'";
		}
		fnumber+=")";
		//执行更新
		updateBusOrStop(fnumber);
		RecordChange(rowNum);
		//刷新界面
		this.repaint();
		this.updateUI();
		refreshUI(true);
		for(int i=0;i<rowNum.size();i++)
		{
			kdtPerson.getRow(rowNum.get(i)).getCell("isSelected").setValue(true);
		}

		super.confirm_mouseClicke(e);
	}
	/**
	 * 
	 *@operation  记录修改信息，该操作发生在刷新界面之前
	 *@param
	 *@return
	 *@throws Exception
	 *@status 0
	 */
	public void RecordChange(ArrayList<Integer> rowNum)
	{   
		//实现思想：点击确定键以后，将列表中的数据而非表格中的数据加载进来，填入pre字段中，将控件中的值加载到after
		//定义了一个bool类型，设定为每日一张单据存储修改信息，exist true表示今日已经创建过该单据
		boolean isExist=false;
		//如果创建过，取该单据的id

		RecordBusChangeInfo recordChange=null;
		if(!isExist().equals(""))
			isExist=true;
		if(isExist){			
			try {
				recordChange= RecordBusChangeFactory.getRemoteInstance().getRecordBusChangeInfo(new ObjectUuidPK(isExist()));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			recordChange=new RecordBusChangeInfo();
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
			Date date=new Date();
			recordChange.setNumber(format.format(date));
			recordChange.setBizDate(date);
		}
		RecordBusChangeEntryCollection entry = recordChange.getEntrys();
		for(int i=0;i<rowNum.size();i++)
		{
			RecordBusChangeEntryInfo rbcInfo=new RecordBusChangeEntryInfo();
            //将修改的员工的编号和姓名录入
			rbcInfo.setNumber(kdtPerson.getRow(rowNum.get(i)).getCell("number").getValue().toString());
			rbcInfo.setName(kdtPerson.getRow(rowNum.get(i)).getCell("name").getValue().toString());
			//录入前的车次和站点
			rbcInfo.setPreBus(kdtPerson.getRow(rowNum.get(i)).getCell("bus").getValue().toString());
			rbcInfo.setPreStop(kdtPerson.getRow(rowNum.get(i)).getCell("stop").getValue().toString());
			
			//录入修改后的车次和站点
			if(this.cBoxBus.getSelectedItem()!=null)
				rbcInfo.setAfterBus(this.cBoxBus.getSelectedItem().toString());			
			if(this.cBoxStop.getSelectedItem()!=null)
				rbcInfo.setAfterStop(this.cBoxStop.getSelectedItem().toString());
			
			//如果该员工在操作时车次和站点都没有发生变化时，此记录不被保存
			if(rbcInfo.getPreBus().equals(rbcInfo.getAfterBus())&&rbcInfo.getPreStop().equals(rbcInfo.getAfterStop()))
				continue;
			
			//录入修改人信息
			rbcInfo.setOperator(SysContext.getSysContext().getCurrentUserInfo().getPerson());
			
//			//录入修改人的信息
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			rbcInfo.setTime(format.format(new Date()));


			entry.add(rbcInfo);
		}
			try {
				RecordBusChangeFactory.getRemoteInstance().save(recordChange);
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public String isExist()
	{
		StringBuffer buffer=new StringBuffer();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date date=new Date();
		buffer.append("select * from T_SHR_RecordBusChange where fnumber='").append(format.format(date)).append("'");
		String str=null;
		try {
		 str= com.kingdee.eas.custom.shr.shrBaseDataQueryFacadeFactory.getRemoteInstance().queryForOtherPerson(buffer.toString());
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;		
	}

	/**
	 * output Search_mouseClicke method
	 */
	protected void Search_mouseClicke(java.awt.event.MouseEvent e) throws Exception
	{
		refreshUI(true);
		super.Search_mouseClicke(e);
	}


	/**
	 * 刷新界面操作
	 * 查询操作
	 */
	public void refreshUI(Boolean b)
	{

		//没设过滤条件则退出
		if(!checkSearch())
			return;
		//每一次重新查询时，清空表格
		if(kdtPerson.getRowCount()>0)
			kdtPerson.removeRows();
		//每一次重新查询时，删除显示字段存放的ArrayList内的所有数据
		number.clear();
		name.clear();
		stop.clear();
		bus.clear();
		className.clear();
		enterDate.clear();
		IDCardNum.clear();
		//存放员工信息的ArrayList获得数据
		getPersonInfo(conn,b);
		if(number.size()==0)
		{
			return;
		}
		//将符合条件的人员信息带入table中
		for(int i=0;i<number.size();i++)
		{
			kdtPerson.addRow();
			kdtPerson.getRow(i).getCell("number").setValue(number.get(i));
			kdtPerson.getRow(i).getCell("name").setValue(name.get(i));
			kdtPerson.getRow(i).getCell("bus").setValue(bus.get(i));
			kdtPerson.getRow(i).getCell("stop").setValue(stop.get(i));
			kdtPerson.getRow(i).getCell("enterDate").setValue(enterDate.get(i));
			kdtPerson.getRow(i).getCell("class").setValue(className.get(i));
			kdtPerson.getRow(i).getCell("IDCardNum").setValue(IDCardNum.get(i));
			kdtPerson.getRow(i).getCell("isSelected").setValue(false);
		}

	}
	/**
	 *@operation 更新操作，更新员工的班车或者站点信息
	 *@param 员工编码的集合
	 *@status 0 :这里的两个基础资料的名字carInfo和busStop命名均和正式库命名不同
	 */
	public void updateBusOrStop(String fnumber)
	{
		StringBuffer buffer=new StringBuffer();
		buffer.append("update t_bd_person set cf");
		if(!this.cBoxBus.getSelectedItem().equals("")&&!this.cBoxStop.getSelectedItem().equals(""))
		{
			//灰色表示测试数据库的sql语句


						buffer.append("busid=(select t2.fid from ct_mp_carinfo t2 where t2.fname_l2='");
//			buffer.append("busid=(select t2.fid from ct_mp_bus t2 where t2.fname_l2='");
			buffer.append(this.cBoxBus.getSelectedItem().toString()).append("'),");
						buffer.append("cfstopid=(select t2.fid from ct_mp_busstop t2 where t2.fname_l2='");
//			buffer.append("cfstopid=(select t2.fid from ct_mp_stop t2 where t2.fname_l2='");
			buffer.append(this.cBoxStop.getSelectedItem().toString()).append("')");
		}

		//班车信息
		else if(!this.cBoxBus.getSelectedItem().equals(""))
		{
						buffer.append("busid=(select t2.fid from ct_mp_carinfo t2 where t2.fname_l2='");
//			buffer.append("busid=(select t2.fid from ct_mp_bus t2 where t2.fname_l2='");
			buffer.append(this.cBoxBus.getSelectedItem().toString()).append("')");
		}
		//站点信息
		else if(!this.cBoxStop.getSelectedItem().equals(""))
		{
						buffer.append("stopid=(select t2.fid from ct_mp_busstop t2 where t2.fname_l2='");
//			buffer.append("stopid=(select t2.fid from ct_mp_stop t2 where t2.fname_l2='");

			buffer.append(this.cBoxStop.getSelectedItem().toString()).append("')");
		}
		//通过员工编码找到对应的职员
		buffer.append(" where fnumber in").append(fnumber);		
		//执行更新
		String updateStr=buffer.toString();
		try {
			com.kingdee.eas.custom.shr.shrBaseDataQueryFacadeFactory.getRemoteInstance().excuteBusAndStop(updateStr);
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.repaint();
	}
	/**
	 * 刷新操作，列表取值
	 */
	protected void btnFilter_mouseClicke(java.awt.event.MouseEvent e) throws Exception
	{
		//通过  其它 可以过滤出通勤信息不全的人
		refreshUI(false);
		super.btnFilter_mouseClicke(e);
	}
	/**
	 * 全选
	 */
	protected void selectAll_mouseClicke(java.awt.event.MouseEvent e) throws Exception
	{
		this.selectAll.setSelected(false);
		this.clearAll.setSelected(false);
		for(int i=0;i<kdtPerson.getRowCount();i++)            
			kdtPerson.getRow(i).getCell("isSelected").setValue(true);
		this.repaint();
		super.selectAll_mouseClicke(e);
	}

	/**
	 * output clearAll_mouseClicke method
	 */
	protected void clearAll_mouseClicke(java.awt.event.MouseEvent e) throws Exception
	{
		this.selectAll.setSelected(false);
		this.clearAll.setSelected(false);
		//将所有表格内按钮置为不选
		for(int i=0;i<kdtPerson.getRowCount();i++)
			kdtPerson.getRow(i).getCell("isSelected").setValue(false);
		this.repaint();//刷新
		super.clearAll_mouseClicke(e);
	}
	/**
	 *@status 1
	 *@operation 查询，过滤的合格性检查
	 *@param 
	 *@return
	 *@throws Exception
	 */
	public Boolean checkSearch()
	{
		if(this.DatePickerFrom.getSqlDate()==null&&this.DatePickerTo.getSqlDate()!=null)
		{
			MsgBox.showInfo("请输入起始日期!");
			return false;
		}
		if(this.DatePickerTo.getSqlDate()==null&&this.DatePickerFrom.getSqlDate()!=null)
		{
			MsgBox.showInfo("请输入结束日期!");
			return false;
		}
		if(this.cboxBusList.getSelectedItem().equals("")&&this.cboxStopList.getSelectedItem().equals("")&&this.textName.getStringValue()==null)
			if(this.textNumber.getStringValue()==null&&this.DatePickerFrom.getSqlDate()==null&&this.DatePickerTo.getSqlDate()==null)
			{
				MsgBox.showInfo("至少选择一项作为过滤条件!");
				return false;
			}
		return true;
	}
	/**
	 * 获得车辆和站点的基础资料用来过滤
	 */
	@SuppressWarnings("unchecked")
	protected void getInformation()
	{	
		//查询车次
		String sqlForBus = "select * from ct_mp_carinfo";
//		String sqlForBus = "select * from ct_mp_bus";			
		try {
			busList=com.kingdee.eas.custom.shr.shrBaseDataQueryFacadeFactory.getRemoteInstance().queryForBusList(sqlForBus);
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//获取站点信息：仅获取站点名称，并保存到站点数组中
					String sqlForStop = "select * from ct_mp_busstop";
//		String sqlForStop = "select * from ct_mp_stop";


		try {
			stopList=com.kingdee.eas.custom.shr.shrBaseDataQueryFacadeFactory.getRemoteInstance().queryForStopList(sqlForStop);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//			rsStop = conn.prepareStatement(sqlForStop).executeQuery();
		//			while(rsStop.next())
		//			{
		//				stopList.add(rsStop.getString("fname_l2"));
		//			}
		//		} catch (Exception e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		//		//释放连接资源：seq:rsBus、rsStop
		//		finally
		//		{
		//			try{
		//				if(rsBus!=null)
		//					rsBus.close();
		//				if(rsStop!=null)
		//					rsStop.close();
		//				conn.close();
		//			}
		//			catch (Exception e)
		//			{
		//				e.printStackTrace();
		//			}
		//
		//		}
	}
	/**
	 * 将自定义sql引入进来，用prepareStatement查询员工要显示的信息
	 * */
	@SuppressWarnings("unchecked")
	public void getPersonInfo(Connection conn,Boolean boole)
	{	
		String str=null;
		if(boole)
			str=sqlForPerson();
		else
			str=FilterPersonInfo();
		ArrayList<ArrayList<String>> list=null;
		int num=0;
		try {
			list=com.kingdee.eas.custom.shr.shrBaseDataQueryFacadeFactory.getRemoteInstance().queryForEmpInfo(str);
			while(num<list.get(0).size()&&list.get(0).size()!=0)
			{
				number.add(list.get(0).get(num));
				name.add(list.get(1).get(num));
				enterDate.add(list.get(2).get(num));
				IDCardNum.add(list.get(3).get(num));
				bus.add(list.get(4).get(num));
				stop.add(list.get(5).get(num));				
				className.add(list.get(6).get(num));
				num++;
			};
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 *@operation 获取最常用的sql语句
	 *@param
	 *@return  StringBuffer
	 *@throws Exception
	 *@status 1
	 */
	public StringBuffer getStringBuffer()
	{
		StringBuffer buffer=new StringBuffer();
		buffer.append("select t1.fnumber,t1.fname_l2,t4.fname_l2  stop,t5.fname_l2 bus,t8.fname_l2 class,to_char(t7.fenterdate,'yyyy-mm-dd') enterDate,t1.FIDCardNO IDCardNum  from t_bd_person t1");
		buffer.append(" inner join ct_mp_accommodationType t2");
		buffer.append(" on t1.cfaccommodationTyp=t2.fid");
		buffer.append(" inner join T_HR_BDEmployeeType t3 on t3.fid=t1.femployeeTypeId");
				buffer.append(" left join ct_mp_busstop t4 on t4.fid=t1.cfstopid");
//		buffer.append(" left join ct_mp_stop t4 on t4.fid=t1.cfstopid");
				buffer.append(" left join ct_mp_carinfo t5 on t5.fid=t1.cfbusid");
//		buffer.append(" left join ct_mp_bus t5 on t5.fid=t1.cfbusid");
		buffer.append(" left join T_HR_PersonPosition t7 on t7.fpersonid=t1.fid");
		buffer.append(" left join T_ORG_Admin t8  on t7.fpersondep=t8.fid ");	


		//过滤食品厂的人
		buffer.append(" and t8.fdisplayName_l2 like '北大荒宝泉岭农牧发展有限公司_黑龙江北三峡食品有限公司%'");

		buffer.append(" where t2.fname_l2='通勤'");
		buffer.append(" and t3.fname_l2 not in('离职') ");


		buffer.append(" and t8.fdisplayName_l2 like '北大荒宝泉岭农牧发展有限公司_黑龙江北三峡食品有限公司%'");
		return buffer;
	}
	/**
	 * 自定义的sql查询语句
	 * 在sHR测试帐套上获取员工信息
	 * 过滤条件：必须是在职员工，必须是通勤人员
	 */
	public  String sqlForPerson()
	{
		StringBuffer buffer=getStringBuffer();
		if(!cboxBusList.getSelectedItem().equals(""))//根据通勤车过滤
			buffer.append(" and t5.fname_l2='").append(cboxBusList.getSelectedItem().toString()).append("'");


		if(!cboxStopList.getSelectedItem().equals(""))//根据站点过滤
			buffer.append(" and t4.fname_l2='").append(cboxStopList.getSelectedItem().toString()).append("'");


		if(textNumber.getStringValue()!=null)//根据员工编号过滤
			buffer.append(" and t1.fnumber like '%").append(textNumber.getStringValue()).append("%'");


		if(textName.getStringValue()!=null)//根据姓名过滤
			buffer.append(" and t1.fname_l2 like '%").append(textName.getStringValue()).append("%'");

		//根据身份证号码过滤
		if(this.textIDCardNum.getStringValue()!=null)
			buffer.append(" and t1.FIDCardNO like'%").append(this.textIDCardNum.getStringValue()).append("%'");

		//根据入职日期过滤，填写日期具有一定的格式
		if(this.DatePickerFrom.getSqlDate()!=null&&this.DatePickerTo.getSqlDate()!=null)
		{
			buffer.append(" and t7.fenterdate between {ts '").append(this.DatePickerFrom.getSqlDate()).append("'}");
			buffer.append(" and {ts '").append(this.DatePickerTo.getSqlDate()).append("'}");
		}
		return buffer.toString();		
	}
	/**
	 * 
	 *@operation  过滤 通勤车或者站点信息不全的人 的sql语句
	 *@param
	 *@return
	 *@throws Exception
	 *@status 0
	 */
	public String FilterPersonInfo()
	{
		StringBuffer buffer=getStringBuffer();
		buffer.append(" and (t1.cfbusid is null or t1.cfstopid is null)");
		return buffer.toString();
	}



}