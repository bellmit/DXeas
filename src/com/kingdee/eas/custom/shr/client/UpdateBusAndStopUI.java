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
	String dbIP;//���ݿ�IP
	Number dbPort;//���ݿ�˿�
	String userPassword;//�û�����
	String userName;//�û���
	String dbName;//���ݿ�����
	//���������֡�ͨ�ڳ���վ�㡢���������顢���š���ְ���ڡ����֤�������飬�ֱ��������ְԱ����Ϣ
	ArrayList<String> number=new ArrayList<String>();
	ArrayList<String> bus=new ArrayList<String>();
	ArrayList<String> stop=new ArrayList<String>();
	ArrayList<String> name=new ArrayList<String>();
	ArrayList<String> className=new ArrayList<String>();
	ArrayList<String> department=new ArrayList<String>();
	ArrayList<String> enterDate=new ArrayList<String>();
	ArrayList<String> IDCardNum=new ArrayList<String>();
	//����������ArrayList����������   վ��  ��    ͨ�ڳ�    �Ļ�������
	ArrayList<String> stopList=new ArrayList<String>();
	ArrayList<String> busList=new ArrayList<String>();



	//���Ӻͽ�����Ķ���
	Connection conn=null;
	java.sql.ResultSet rs=null;
	PreparedStatement pre=null;

	String stringRefresh=null;



	//step1:���ؽ����ʱ�򣬰�Ա����ͨ�ڳ���վ�������������ϴ��������뵽 ���������б�����
	//step2�������ѯ��ʱ�򣬽��б�ķ�������������ɸѡ����
	//step3���޸ĳ��ε�ʱ�򣬽���̨���ݿ��е���ֵ���иı�

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		//����ȫ��
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		//��û���������Ϣ���೵��վ�㣩
		getInformation();

		kdtPerson.checkParsed();
		//��������յ�ѡ��������ݹ���ʱ���Է��ص���ʼ״̬������ѡ����ˣ�
		busList.add("");
		stopList.add("");
		//��ȡͨ�ڳ���վ��Ļ���������Ϣ

		//��ʼ���ڵ����ڿؼ���ʼ����ֵΪ2000��1��1��
		this.DatePickerFrom.setDatePattern("yyyy-MM-dd");
		java.util.Date date = DateUtil.getDate(2000,1,1);
		this.DatePickerFrom.setValue(date);
		//�����������ݽ�������
		Collections.sort(busList);
		Collections.sort(stopList);

		//�ڲ�ѯ���ֺ��޸Ĳ��ֵ������б��ﶼ�����϶�Ӧ�Ļ�������
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
		kdtPerson.setAutoResize(true);//�����п�����Ӧ���Ŀ��
		//������߽�������		
		TableSorter sorter=new TableSorter(kdtPerson);		
		sorter.setOrder(0);
		//����ĳЩ�в��ɱ༭
		kdtPerson.getColumn("number").getStyleAttributes().setLocked(true);
		kdtPerson.getColumn("name").getStyleAttributes().setLocked(true);
		kdtPerson.getColumn("class").getStyleAttributes().setLocked(true);
		kdtPerson.getColumn("bus").getStyleAttributes().setLocked(true);
		kdtPerson.getColumn("stop").getStyleAttributes().setLocked(true);
		kdtPerson.getColumn("enterDate").getStyleAttributes().setLocked(true);
		kdtPerson.getColumn("IDCardNum").getStyleAttributes().setLocked(true);


		//�ͷ��ڴ�
		if(stopList!=null)
			stopList.clear();
		if(busList!=null)
			busList.clear();
		if(enterDate!=null)
			enterDate.clear();
		if(className!=null)
			className.clear();


		//����һ������Ϊ��ѡ��
		KDCheckBox kdtPerson_isMarketed_CheckBox = new KDCheckBox();
		kdtPerson_isMarketed_CheckBox.setName("kdtPerson_isMarketed_CheckBox");
		KDTDefaultCellEditor kdtPerson_isMarketed_CellEditor = new KDTDefaultCellEditor(kdtPerson_isMarketed_CheckBox);
		this.kdtPerson.getColumn("isSelected").setEditor(kdtPerson_isMarketed_CellEditor);
	}
	/** override
	 * @operation �޸�Ա��ͨ����Ϣ
	 *�޸�ʱ��Ҫע������1.������ͬʱ�޸�Ա���ĳ��κ�վ��
	 *  2.�޸�ʱ����ѡ��վ�����ͨ�ڳ�
	 * @status 0
	 */
	@Override
	protected void confirm_mouseClicke(MouseEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.cBoxBus.getSelectedItem().equals("")&&this.cBoxStop.getSelectedItem().equals(""))
		{
			MsgBox.showInfo("��ѡ��Ҫ����ĳ��λ���վ����Ϣ");
			return;
		}
		ArrayList<Integer> rowNum=new ArrayList<Integer>();
		for(int i=0;i<kdtPerson.getRowCount();i++)
			if(this.kdtPerson.getRow(i).getCell("isSelected").getValue()!=null)
				if(this.kdtPerson.getRow(i).getCell("isSelected").getValue().equals(true))
					rowNum.add(i);
		if(rowNum.size()==0)
		{
			MsgBox.showInfo("��ѡ����Ҫ�޸ĵ�Ա��");
			return;
		}
		//����һ���ַ�����������ű�ѡ���Ա���ı��룬�����ʽΪ('num1','num2','num3'...),��;��sql���in()
		String fnumber="(";
		for(int i=0;i<rowNum.size();i++)
		{
			if(i>0)
				fnumber+=",";
			String temp=kdtPerson.getRow(rowNum.get(i)).getCell("number").getValue().toString();
			fnumber+="'"+temp+"'";
		}
		fnumber+=")";
		//ִ�и���
		updateBusOrStop(fnumber);
		RecordChange(rowNum);
		//ˢ�½���
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
	 *@operation  ��¼�޸���Ϣ���ò���������ˢ�½���֮ǰ
	 *@param
	 *@return
	 *@throws Exception
	 *@status 0
	 */
	public void RecordChange(ArrayList<Integer> rowNum)
	{   
		//ʵ��˼�룺���ȷ�����Ժ󣬽��б��е����ݶ��Ǳ���е����ݼ��ؽ���������pre�ֶ��У����ؼ��е�ֵ���ص�after
		//������һ��bool���ͣ��趨Ϊÿ��һ�ŵ��ݴ洢�޸���Ϣ��exist true��ʾ�����Ѿ��������õ���
		boolean isExist=false;
		//�����������ȡ�õ��ݵ�id

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
            //���޸ĵ�Ա���ı�ź�����¼��
			rbcInfo.setNumber(kdtPerson.getRow(rowNum.get(i)).getCell("number").getValue().toString());
			rbcInfo.setName(kdtPerson.getRow(rowNum.get(i)).getCell("name").getValue().toString());
			//¼��ǰ�ĳ��κ�վ��
			rbcInfo.setPreBus(kdtPerson.getRow(rowNum.get(i)).getCell("bus").getValue().toString());
			rbcInfo.setPreStop(kdtPerson.getRow(rowNum.get(i)).getCell("stop").getValue().toString());
			
			//¼���޸ĺ�ĳ��κ�վ��
			if(this.cBoxBus.getSelectedItem()!=null)
				rbcInfo.setAfterBus(this.cBoxBus.getSelectedItem().toString());			
			if(this.cBoxStop.getSelectedItem()!=null)
				rbcInfo.setAfterStop(this.cBoxStop.getSelectedItem().toString());
			
			//�����Ա���ڲ���ʱ���κ�վ�㶼û�з����仯ʱ���˼�¼��������
			if(rbcInfo.getPreBus().equals(rbcInfo.getAfterBus())&&rbcInfo.getPreStop().equals(rbcInfo.getAfterStop()))
				continue;
			
			//¼���޸�����Ϣ
			rbcInfo.setOperator(SysContext.getSysContext().getCurrentUserInfo().getPerson());
			
//			//¼���޸��˵���Ϣ
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
	 * ˢ�½������
	 * ��ѯ����
	 */
	public void refreshUI(Boolean b)
	{

		//û������������˳�
		if(!checkSearch())
			return;
		//ÿһ�����²�ѯʱ����ձ��
		if(kdtPerson.getRowCount()>0)
			kdtPerson.removeRows();
		//ÿһ�����²�ѯʱ��ɾ����ʾ�ֶδ�ŵ�ArrayList�ڵ���������
		number.clear();
		name.clear();
		stop.clear();
		bus.clear();
		className.clear();
		enterDate.clear();
		IDCardNum.clear();
		//���Ա����Ϣ��ArrayList�������
		getPersonInfo(conn,b);
		if(number.size()==0)
		{
			return;
		}
		//��������������Ա��Ϣ����table��
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
	 *@operation ���²���������Ա���İ೵����վ����Ϣ
	 *@param Ա������ļ���
	 *@status 0 :����������������ϵ�����carInfo��busStop����������ʽ��������ͬ
	 */
	public void updateBusOrStop(String fnumber)
	{
		StringBuffer buffer=new StringBuffer();
		buffer.append("update t_bd_person set cf");
		if(!this.cBoxBus.getSelectedItem().equals("")&&!this.cBoxStop.getSelectedItem().equals(""))
		{
			//��ɫ��ʾ�������ݿ��sql���


						buffer.append("busid=(select t2.fid from ct_mp_carinfo t2 where t2.fname_l2='");
//			buffer.append("busid=(select t2.fid from ct_mp_bus t2 where t2.fname_l2='");
			buffer.append(this.cBoxBus.getSelectedItem().toString()).append("'),");
						buffer.append("cfstopid=(select t2.fid from ct_mp_busstop t2 where t2.fname_l2='");
//			buffer.append("cfstopid=(select t2.fid from ct_mp_stop t2 where t2.fname_l2='");
			buffer.append(this.cBoxStop.getSelectedItem().toString()).append("')");
		}

		//�೵��Ϣ
		else if(!this.cBoxBus.getSelectedItem().equals(""))
		{
						buffer.append("busid=(select t2.fid from ct_mp_carinfo t2 where t2.fname_l2='");
//			buffer.append("busid=(select t2.fid from ct_mp_bus t2 where t2.fname_l2='");
			buffer.append(this.cBoxBus.getSelectedItem().toString()).append("')");
		}
		//վ����Ϣ
		else if(!this.cBoxStop.getSelectedItem().equals(""))
		{
						buffer.append("stopid=(select t2.fid from ct_mp_busstop t2 where t2.fname_l2='");
//			buffer.append("stopid=(select t2.fid from ct_mp_stop t2 where t2.fname_l2='");

			buffer.append(this.cBoxStop.getSelectedItem().toString()).append("')");
		}
		//ͨ��Ա�������ҵ���Ӧ��ְԱ
		buffer.append(" where fnumber in").append(fnumber);		
		//ִ�и���
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
	 * ˢ�²������б�ȡֵ
	 */
	protected void btnFilter_mouseClicke(java.awt.event.MouseEvent e) throws Exception
	{
		//ͨ��  ���� ���Թ��˳�ͨ����Ϣ��ȫ����
		refreshUI(false);
		super.btnFilter_mouseClicke(e);
	}
	/**
	 * ȫѡ
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
		//�����б���ڰ�ť��Ϊ��ѡ
		for(int i=0;i<kdtPerson.getRowCount();i++)
			kdtPerson.getRow(i).getCell("isSelected").setValue(false);
		this.repaint();//ˢ��
		super.clearAll_mouseClicke(e);
	}
	/**
	 *@status 1
	 *@operation ��ѯ�����˵ĺϸ��Լ��
	 *@param 
	 *@return
	 *@throws Exception
	 */
	public Boolean checkSearch()
	{
		if(this.DatePickerFrom.getSqlDate()==null&&this.DatePickerTo.getSqlDate()!=null)
		{
			MsgBox.showInfo("��������ʼ����!");
			return false;
		}
		if(this.DatePickerTo.getSqlDate()==null&&this.DatePickerFrom.getSqlDate()!=null)
		{
			MsgBox.showInfo("�������������!");
			return false;
		}
		if(this.cboxBusList.getSelectedItem().equals("")&&this.cboxStopList.getSelectedItem().equals("")&&this.textName.getStringValue()==null)
			if(this.textNumber.getStringValue()==null&&this.DatePickerFrom.getSqlDate()==null&&this.DatePickerTo.getSqlDate()==null)
			{
				MsgBox.showInfo("����ѡ��һ����Ϊ��������!");
				return false;
			}
		return true;
	}
	/**
	 * ��ó�����վ��Ļ���������������
	 */
	@SuppressWarnings("unchecked")
	protected void getInformation()
	{	
		//��ѯ����
		String sqlForBus = "select * from ct_mp_carinfo";
//		String sqlForBus = "select * from ct_mp_bus";			
		try {
			busList=com.kingdee.eas.custom.shr.shrBaseDataQueryFacadeFactory.getRemoteInstance().queryForBusList(sqlForBus);
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//��ȡվ����Ϣ������ȡվ�����ƣ������浽վ��������
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
		//		//�ͷ�������Դ��seq:rsBus��rsStop
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
	 * ���Զ���sql�����������prepareStatement��ѯԱ��Ҫ��ʾ����Ϣ
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
	 *@operation ��ȡ��õ�sql���
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


		//����ʳƷ������
		buffer.append(" and t8.fdisplayName_l2 like '����ı�Ȫ��ũ����չ���޹�˾_����������ϿʳƷ���޹�˾%'");

		buffer.append(" where t2.fname_l2='ͨ��'");
		buffer.append(" and t3.fname_l2 not in('��ְ') ");


		buffer.append(" and t8.fdisplayName_l2 like '����ı�Ȫ��ũ����չ���޹�˾_����������ϿʳƷ���޹�˾%'");
		return buffer;
	}
	/**
	 * �Զ����sql��ѯ���
	 * ��sHR���������ϻ�ȡԱ����Ϣ
	 * ������������������ְԱ����������ͨ����Ա
	 */
	public  String sqlForPerson()
	{
		StringBuffer buffer=getStringBuffer();
		if(!cboxBusList.getSelectedItem().equals(""))//����ͨ�ڳ�����
			buffer.append(" and t5.fname_l2='").append(cboxBusList.getSelectedItem().toString()).append("'");


		if(!cboxStopList.getSelectedItem().equals(""))//����վ�����
			buffer.append(" and t4.fname_l2='").append(cboxStopList.getSelectedItem().toString()).append("'");


		if(textNumber.getStringValue()!=null)//����Ա����Ź���
			buffer.append(" and t1.fnumber like '%").append(textNumber.getStringValue()).append("%'");


		if(textName.getStringValue()!=null)//������������
			buffer.append(" and t1.fname_l2 like '%").append(textName.getStringValue()).append("%'");

		//�������֤�������
		if(this.textIDCardNum.getStringValue()!=null)
			buffer.append(" and t1.FIDCardNO like'%").append(this.textIDCardNum.getStringValue()).append("%'");

		//������ְ���ڹ��ˣ���д���ھ���һ���ĸ�ʽ
		if(this.DatePickerFrom.getSqlDate()!=null&&this.DatePickerTo.getSqlDate()!=null)
		{
			buffer.append(" and t7.fenterdate between {ts '").append(this.DatePickerFrom.getSqlDate()).append("'}");
			buffer.append(" and {ts '").append(this.DatePickerTo.getSqlDate()).append("'}");
		}
		return buffer.toString();		
	}
	/**
	 * 
	 *@operation  ���� ͨ�ڳ�����վ����Ϣ��ȫ���� ��sql���
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