/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.im.InputContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.service.job.wrapper.SqlExecutor;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.workflow.report.IProcessInstanceListUIFacade.InitData;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTSortManager;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTDataRequestEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTDataRequestListener;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.swing.KDDatePicker;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.KDTimePicker;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.base.permission.client.longtime.ILongTimeTask;
import com.kingdee.eas.base.permission.client.longtime.LongTimeDialog;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo;
import com.kingdee.eas.farm.feemanager.basedata.DriverInfo;
import com.kingdee.eas.farm.stocking.basedata.BreedDataInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.publicdata.CarEntryCollection;
import com.kingdee.eas.publicdata.CarEntryInfo;
import com.kingdee.eas.publicdata.CarFactory;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * output class name
 */
public class CarSendManageUI extends AbstractCarSendManageUI
{
	private static final Logger logger = CoreUIObject.getLogger(CarSendManageUI.class);
	private F7ContextManager f7Manager;
	private CompanyOrgUnitInfo company=null;
	private String curCompanyID=null;
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * output class constructor
	 */
	public CarSendManageUI() throws Exception
	{
		super();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.kdtEntrys.checkParsed();
		f7Manager = new F7ContextManager(this, OrgType.Storage);
		company=SysContext.getSysContext().getCurrentFIUnit();
		curCompanyID=company.getId().toString();
		initUI();
		initControl();
		initData();
		execQuery();
	}


	private void initData() {
		// TODO Auto-generated method stub
		if(getUIContext().get("info")!=null){
			CCarSendBillInfo info=(CCarSendBillInfo) getUIContext().get("info");
			pkBizDate.setValue(info.getBizDate());
			prmtBreedData.setValue(info.getBreedData());
			prmtCustomer.setValue(info.getCustomer());
		}

	}

	private void initUI() {
		// TODO Auto-generated method stub
		this.setPreferredSize(new Dimension(1150,700));

		KDFormattedTextField kdtEntrys_seq_TextField = new KDFormattedTextField();
		kdtEntrys_seq_TextField.setVisible(true);
		kdtEntrys_seq_TextField.setEditable(true);
		kdtEntrys_seq_TextField.setHorizontalAlignment(2);
		kdtEntrys_seq_TextField.setDataType(0);
		KDTDefaultCellEditor kdtEntrys_seq_CellEditor = new KDTDefaultCellEditor(kdtEntrys_seq_TextField);
		this.kdtEntrys.getColumn("seq").setEditor(kdtEntrys_seq_CellEditor);

		KDFormattedTextField kdtEntrys_qty_TextField = new KDFormattedTextField();
		kdtEntrys_qty_TextField.setVisible(true);
		kdtEntrys_qty_TextField.setEditable(true);
		kdtEntrys_qty_TextField.setHorizontalAlignment(2);
		kdtEntrys_qty_TextField.setDataType(0);
		KDTDefaultCellEditor kdtEntrys_qty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qty_TextField);
		this.kdtEntrys.getColumn("qty").setEditor(kdtEntrys_qty_CellEditor);


		final KDBizPromptBox kdtEntrys_car_PromptBox = new KDBizPromptBox();
		kdtEntrys_car_PromptBox.setQueryInfo("com.kingdee.eas.publicdata.app.CarQuery");
		kdtEntrys_car_PromptBox.setVisible(true);
		kdtEntrys_car_PromptBox.setEditable(true);
		kdtEntrys_car_PromptBox.setDisplayFormat("$number$");
		kdtEntrys_car_PromptBox.setEditFormat("$number$");
		kdtEntrys_car_PromptBox.setCommitFormat("$number$");
		KDTDefaultCellEditor kdtEntrys_car_CellEditor = new KDTDefaultCellEditor(kdtEntrys_car_PromptBox);
		this.kdtEntrys.getColumn("car").setEditor(kdtEntrys_car_CellEditor);
		ObjectValueRender kdtEntrys_car_OVR = new ObjectValueRender();
		kdtEntrys_car_OVR.setFormat(new BizDataFormat("$number$"));
		this.kdtEntrys.getColumn("car").setRenderer(kdtEntrys_car_OVR);
		kdtEntrys_car_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.CarListUI kdtEntrys_car_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_car_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_car_PromptBox_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.CarListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_car_PromptBox_F7ListUI));
					kdtEntrys_car_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_car_PromptBox.setSelector(kdtEntrys_car_PromptBox_F7ListUI);
				}
			}
		});

		final KDBizPromptBox kdtEntrys_driver_PromptBox = new KDBizPromptBox();
		kdtEntrys_driver_PromptBox.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");
		kdtEntrys_driver_PromptBox.setVisible(true);
		kdtEntrys_driver_PromptBox.setEditable(true);
		kdtEntrys_driver_PromptBox.setDisplayFormat("$number$");
		kdtEntrys_driver_PromptBox.setEditFormat("$number$");
		kdtEntrys_driver_PromptBox.setCommitFormat("$number$");
		KDTDefaultCellEditor kdtEntrys_driver_CellEditor = new KDTDefaultCellEditor(kdtEntrys_driver_PromptBox);
		this.kdtEntrys.getColumn("driver").setEditor(kdtEntrys_driver_CellEditor);
		ObjectValueRender kdtEntrys_driver_OVR = new ObjectValueRender();
		kdtEntrys_driver_OVR.setFormat(new BizDataFormat("$drivername$"));
		this.kdtEntrys.getColumn("driver").setRenderer(kdtEntrys_driver_OVR);
		kdtEntrys_driver_PromptBox.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI kdtEntrys_driver_PromptBox_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (kdtEntrys_driver_PromptBox_F7ListUI == null) {
					try {
						kdtEntrys_driver_PromptBox_F7ListUI = new com.kingdee.eas.farm.feemanager.basedata.client.DriverListUI();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(kdtEntrys_driver_PromptBox_F7ListUI));
					kdtEntrys_driver_PromptBox_F7ListUI.setF7Use(true,ctx);
					kdtEntrys_driver_PromptBox.setSelector(kdtEntrys_driver_PromptBox_F7ListUI);
				}
			}
		});

		f7Manager.registerBizCustomerF7(prmtCustomer, null, null, company);
		prmtCustomer.setDisplayFormat("$name$");

		// prmtbreedData		
		this.prmtBreedData.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.BreedDataQuery");		
		this.prmtBreedData.setVisible(true);		
		this.prmtBreedData.setEditable(true);		
		this.prmtBreedData.setDisplayFormat("$name$");		
		this.prmtBreedData.setEditFormat("$number$");		
		this.prmtBreedData.setCommitFormat("$number$");		
		this.prmtBreedData.setRequired(false);		
		prmtBreedData.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI prmtbreedData_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtbreedData_F7ListUI == null) {
					try {
						prmtbreedData_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.BreedDataListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								FilterInfo filter=new FilterInfo();
								filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
								return filter;
							}
						};
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtbreedData_F7ListUI));
					prmtbreedData_F7ListUI.setF7Use(true,ctx);
					prmtBreedData.setSelector(prmtbreedData_F7ListUI);
				}
			}
		});

		KDDatePicker kdtEntrys_arriveTime_DatePicker = new KDDatePicker();
		kdtEntrys_arriveTime_DatePicker.setVisible(true);
		kdtEntrys_arriveTime_DatePicker.setEditable(true);
		kdtEntrys_arriveTime_DatePicker.setTimeEnabled(true);
		KDTDefaultCellEditor kdtEntrys_arriveTime_CellEditor = new KDTDefaultCellEditor(kdtEntrys_arriveTime_DatePicker);
		this.kdtEntrys.getColumn("arriveTime").setEditor(kdtEntrys_arriveTime_CellEditor);
		this.kdtEntrys.getColumn("arriveTime").getStyleAttributes().setNumberFormat("yyyy-MM-dd HH:mm:ss");

	}


	private void initControl() {
		// TODO Auto-generated method stub
		KDTSortManager sm = new KDTSortManager(kdtEntrys){
			@Override
			public void sort(int colIndex, int sortType) {
				// TODO Auto-generated method stub
				for(int i=0;i<kdtEntrys.getRowCount();i++){
					if(kdtEntrys.getCell(i,"car").getValue()!=null){
						CarInfo car=(CarInfo) kdtEntrys.getCell(i,"car").getValue();
						car.setDisplayFormat(((IPropertyContainer)kdtEntrys.getCell(i,"car").getValue()).getString("number"));	
					}if(kdtEntrys.getCell(i,"driver").getValue()!=null){
						DriverInfo driver=(DriverInfo) kdtEntrys.getCell(i,"driver").getValue();
						driver.setDisplayFormat(((IPropertyContainer)kdtEntrys.getCell(i,"driver").getValue()).getString("driverName"));	
					}
				}
				super.sort(colIndex, sortType);
			}
		};		
		sm.setSortAuto(true); 
		sm.setClickCount(2); 
		for(int i=0;i<kdtEntrys.getColumnCount();i++){
			this.kdtEntrys.getColumn(i).setSortable(true); 
		} 

		kdtEntrys.addKDTMouseListener(new KDTMouseListener(){
			@Override
			public void tableClicked(KDTMouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getClickCount()==2){
					SelectorItemCollection slor=new SelectorItemCollection();
					slor.add("*");
					slor.add("breedData.*");
					slor.add("customer.*");
					try {
						CCarSendBillInfo cCarSendInfo = CCarSendBillFactory.getRemoteInstance().getCCarSendBillInfo(new ObjectUuidPK((String)kdtEntrys.getCell(e.getRowIndex(),"fid").getValue()),slor);
						prmtBreedData.setValue(cCarSendInfo.getBreedData());
						prmtCustomer.setValue(cCarSendInfo.getCustomer());
						pkBizDate.setValue(cCarSendInfo.getBizDate());
					} catch (EASBizException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});

		kdtEntrys.addKDTEditListener(new KDTEditAdapter(){	
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);
				kdtEntrys_EditStoped(e.getRowIndex(), e.getColIndex());
			}

			public void editStarting(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStarting(e);

				String carID=kdtEntrys.getCell(e.getRowIndex(),"car").getValue()==null?null:((IPropertyContainer)kdtEntrys.getCell(e.getRowIndex(),"car").getValue()).getString("id");
				StockingComm.setDriverFilter((KDBizPromptBox)kdtEntrys.getColumn("driver").getEditor().getComponent(), curCompanyID, carID);

				String driverID=kdtEntrys.getCell(e.getRowIndex(),"driver").getValue()==null?null:((IPropertyContainer)kdtEntrys.getCell(e.getRowIndex(),"driver").getValue()).getString("id");
				StockingComm.setCarFilter((KDBizPromptBox)kdtEntrys.getColumn("car").getEditor().getComponent(), curCompanyID, driverID);
			}
		});


		cmbCancel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				disposeUIWindow();
			}
		});

		cmbOK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				verifyInput();
				dealWork();
			}
		});

		btnQuery.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				execQuery();
			}
		});
	}

	private void execQuery() {
		// TODO Auto-generated method stub
		if(pkBizDate.getValue()==null){
			MsgBox.showWarning("业务日期不能为空!");
			SysUtil.abort();
		}
		Date bizDate=(Date) pkBizDate.getValue();
		String dateStr=sdf.format(bizDate);
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" /*dialect*/ ")
		.append(" select fid from CT_FM_CCarSendBill ")
		.append(" where 1=1 ")
		.append(" and to_char(fbizdate,'yyyy-mm-dd')='"+dateStr+"' ");
		if(prmtBreedData.getValue()!=null){
			sqlBuf.append(" and CFBreedDataID ='"+((IPropertyContainer)prmtBreedData.getValue()).getString("id")+"' ");
		}
		if(prmtCustomer.getValue()!=null){
			sqlBuf.append(" and CFCustomerID='"+((IPropertyContainer)prmtCustomer.getValue()).getString("id")+"' ");
		}
		sqlBuf.append(" order by cffarmerID,cffarmID,CFSeq,cfbillStatus");
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sqlBuf.toString()).executeSQL();
			kdtEntrys.removeRows();
			while (rs.next()) {
				String id=rs.getString("fid");
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add("*");
				slor.add("farmer.*");
				slor.add("farm.*");
				slor.add("car.*");
				slor.add("driver.*");
				slor.add("breedData.*");
				slor.add("customer.*");
				CCarSendBillInfo cCarSendInfo=CCarSendBillFactory.getRemoteInstance().getCCarSendBillInfo(new ObjectUuidPK(id),slor);
				IRow row = kdtEntrys.addRow();
				row.getCell("fid").setValue(id);
				row.getCell("farmer").setValue(cCarSendInfo.getFarmer());
				row.getCell("farm").setValue(cCarSendInfo.getFarm());
				row.getCell("car").setValue(cCarSendInfo.getCar());
				row.getCell("driver").setValue(cCarSendInfo.getDriver());
				row.getCell("arriveTime").setValue(cCarSendInfo.getArriveTime());
				row.getCell("qty").setValue(cCarSendInfo.getDeliverQty());
				if(cCarSendInfo.getArriveTime()!=null){
					SimpleDateFormat sdf=new SimpleDateFormat("HH.mm");
					row.getCell("time").setValue(sdf.format(cCarSendInfo.getArriveTime()));
				}
				row.getCell("breedData").setValue(cCarSendInfo.getBreedData());
				row.getCell("customer").setValue(cCarSendInfo.getCustomer());
				row.getCell("driverPhone").setValue(cCarSendInfo.getDriverPhone());
				row.getCell("billStatus").setValue(cCarSendInfo.getBillStatus().getAlias());
				row.getCell("seq").setValue(cCarSendInfo.getSeq());
				if(cCarSendInfo.getBillStatus()==BillBaseStatusEnum.AUDITED){
					row.getStyleAttributes().setBackground(new Color(158,204,171));
					row.getStyleAttributes().setLocked(true);
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


	private void verifyInput() {
		// TODO Auto-generated method stub
		if(kdtEntrys.getRowCount()<=0){
			MsgBox.showWarning("未查询到派车单,无法更新");
			SysUtil.abort();
		}
		for(int i=0;i<kdtEntrys.getRowCount();i++){
			if(kdtEntrys.getCell(i, "seq").getValue()==null){
				MsgBox.showWarning("第"+(i+1)+"行分录顺序号未填写!");
				SysUtil.abort();
			}
		}
	}

	private void dealWork() {
		// TODO Auto-generated method stub
		if(MsgBox.showConfirm2("将以修改后的信息更新分录对应的派车单,是否继续?")==MsgBox.YES){
			LongTimeDialog dialog = new LongTimeDialog((Dialog) SwingUtilities.getWindowAncestor(this)); //进度栏
			dialog.setLongTimeTask(new ILongTimeTask(){		
				public void afterExec(Object obj) throws Exception {}
				public Object exec() throws Exception {
					Object obj = "success";  
					for(int i=0;i<kdtEntrys.getRowCount();i++){
						Map map=new HashMap<String, Object>();
						String carID=kdtEntrys.getCell(i, "car").getValue()==null?null:((IPropertyContainer)kdtEntrys.getCell(i, "car").getValue()).getString("id");
						String driverID=kdtEntrys.getCell(i, "driver").getValue()==null?null:((IPropertyContainer)kdtEntrys.getCell(i, "driver").getValue()).getString("id");
						BigDecimal qty=UIRuleUtil.getBigDecimal(kdtEntrys.getCell(i, "qty").getValue());
						map.put("seq", kdtEntrys.getCell(i, "seq").getValue());
						Date arriveTime=(Date) kdtEntrys.getCell(i, "arriveTime").getValue();
						map.put("carID", carID);
						map.put("driverID", driverID);
						map.put("arriveTime", arriveTime);
						map.put("qty", qty);
						CCarSendBillInfo cCarSendInfo=CCarSendBillFactory.getRemoteInstance().getCCarSendBillInfo(new ObjectUuidPK((String)kdtEntrys.getCell(i, "fid").getValue()));
						if(cCarSendInfo.getBillStatus()!=BillBaseStatusEnum.AUDITED){
							CCarSendBillFactory.getRemoteInstance().manageSendCar(cCarSendInfo, map);
						}
					}
					MsgBox.showInfo("执行成功,点击确定退出");		
					disposeUIWindow();
					return obj;
				}
			});
			Component[] cps=dialog.getContentPane().getComponents();  
			for(Component cp:cps){  
				if(cp instanceof JLabel){  
					((JLabel) cp).setText("正在执行中，请稍等......");  
				}  
			}  
			dialog.show();  
		}
	}

	private void kdtEntrys_EditStoped(int rowIndex,int colIndex){
		// TODO Auto-generated method stub		
		if(kdtEntrys.getColumnKey(colIndex).equalsIgnoreCase("car")){
			if(kdtEntrys.getCell(rowIndex, colIndex).getValue()!=null){
				SelectorItemCollection slor =new SelectorItemCollection();
				slor.add("*");
				slor.add("Entry.*");
				slor.add("Entry.driver.*");
				try {
					CarInfo car=CarFactory.getRemoteInstance().getCarInfo(new ObjectUuidPK(((IPropertyContainer)kdtEntrys.getCell(rowIndex, colIndex).getValue()).getString("id")), slor);
					CarEntryCollection carEntry=car.getEntry();
					for(int i=0;i<carEntry.size();i++){
						CarEntryInfo entry =carEntry.get(i);
						if(entry.isIsDefault()){
							kdtEntrys.getCell(rowIndex, "driver").setValue(entry.getDriver());
							kdtEntrys.getCell(rowIndex, "driverPhone").setValue(entry.getDriver().getDriverphone());
							break;
						}
					}
				} catch (EASBizException e1) {
					e1.printStackTrace();
				} catch (BOSException e1) {
					e1.printStackTrace();
				}
			}else{
				kdtEntrys.getCell(rowIndex, "driver").setValue(null);
				kdtEntrys.getCell(rowIndex, "driverPhone").setValue(null);
			}
		}

		if(kdtEntrys.getColumnKey(colIndex).equalsIgnoreCase("driver")){
			if(kdtEntrys.getCell(rowIndex, colIndex).getValue()!=null){
				try {
					kdtEntrys.getCell(rowIndex, "driverPhone").setValue((String) UIRuleUtil.getProperty((IObjectValue) kdtEntrys.getCell(rowIndex, "driver").getValue(), "driverphone"));
					String driverID=((IPropertyContainer)kdtEntrys.getCell(rowIndex, "driver").getValue()).getString("id");
					String sql="select distinct t1.fid fid from CT_PUB_Car t1 inner join T_PUB_CarEntry t2 on t1.fid=t2.fparentid where t2.FDriverID='"+driverID+"' and t1.CFBaseStatus=2";
					IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
					if(rs.next()){
						CarInfo carInfo=CarFactory.getRemoteInstance().getCarInfo(new ObjectUuidPK(rs.getString("fid")));
						kdtEntrys.getCell(rowIndex, "car").setValue(carInfo);
					}
				} catch (EASBizException e1) {
					e1.printStackTrace();
				} catch (BOSException e1) {
					e1.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else{
				kdtEntrys.getCell(rowIndex, "driverPhone").setValue(null);
			}
		}

		if(kdtEntrys.getColumnKey(colIndex).equalsIgnoreCase("time")&&pkBizDate.getValue()!=null){
			Date billDate=(Date)pkBizDate.getValue();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdfTime=new SimpleDateFormat("HH:mm");
			SimpleDateFormat sdfN=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try {
				if(kdtEntrys.getCell(rowIndex, "time").getValue()!=null){
					String timeStr=(String) kdtEntrys.getCell(rowIndex, "time").getValue();
					timeStr=timeStr.replace(".", ":");
					if(timeStr.indexOf(":")<0){
						throw new ParseException(timeStr, colIndex);
					}else{
						int hour=Integer.parseInt(timeStr.substring(0, timeStr.indexOf(":"))) ;
						int min=Integer.parseInt(timeStr.substring(timeStr.indexOf(":")+1,timeStr.length())) ;
						if(hour<0||hour>23||min<0||min>59){
							throw new NumberFormatException();
						}
					}
					Date time=sdfTime.parse(timeStr);
					timeStr=sdfTime.format(time);
					Date arriveTime=kdtEntrys.getCell(rowIndex, "arriveTime").getValue()==null?billDate:(Date)kdtEntrys.getCell(rowIndex, "arriveTime").getValue();
					String arriveTimeStr=sdf.format(arriveTime);
					arriveTimeStr=arriveTimeStr+" "+timeStr;
					arriveTime=sdfN.parse(arriveTimeStr);
					kdtEntrys.getCell(rowIndex, "arriveTime").setValue(arriveTime); 
				}else{
					kdtEntrys.getCell(rowIndex, "arriveTime").setValue(sdf.parse(sdf.format(billDate)));	
				}
			}catch (NumberFormatException e) {
				MsgBox.showWarning("格式错误");
				return;
			}catch (ParseException e) {
				MsgBox.showWarning("格式错误");
				return;
			} 
		}

	}

}