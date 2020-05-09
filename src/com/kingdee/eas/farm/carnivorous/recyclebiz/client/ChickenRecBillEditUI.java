/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.ISQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.CodingUtil;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.ListenerUtil;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType;
import com.kingdee.eas.farm.feemanager.basedata.DriverFactory;
import com.kingdee.eas.farm.feemanager.basedata.DriverInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.publicdata.CarEntryCollection;
import com.kingdee.eas.publicdata.CarEntryInfo;
import com.kingdee.eas.publicdata.CarFactory;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.eas.wlhlcomm.client.UITools;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.KDTBasicUI;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.BeforeActionEvent;
import com.kingdee.bos.ctrl.kdf.table.event.BeforeActionListener;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class ChickenRecBillEditUI extends AbstractChickenRecBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(ChickenRecBillEditUI.class);
	private String curCompanyID;//当前财务组织
	private CompanyOrgUnitInfo company;
	private boolean isLoadField=false;
	private F7ContextManager f7Manager;
	/**
	 * output class constructor
	 */
	public ChickenRecBillEditUI() throws Exception
	{
		super();
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub

		super.onLoad();
		setUITitle("毛鸡回收单");


		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		company=SysContext.getSysContext().getCurrentFIUnit();
		f7Manager = new F7ContextManager(this, OrgType.Storage);
		initControl();

		kDTabbedPane1.add(kDPanel2, resHelper.getString("kDPanel2.constraints"));
		kDTabbedPane1.add(kDPanel1, resHelper.getString("kDPanel1.constraints"));
		kDTabbedPane1.add(kDPanel3, resHelper.getString("kDPanel3.constraints"));
	}
	public void loadFields()
	{
		isLoadField=true;
		super.loadFields();
		isLoadField=false;

		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			this.actionAudit.setEnabled(false);
			this.actionUnAudit.setEnabled(true);
		}else if (this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)){
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(false);
		}else {
			this.actionAudit.setEnabled(true);
			this.actionUnAudit.setEnabled(true);
		}


		//设置分录显示合计行
		UITools.apendFootRow(kdtEntry, new String[]{"chickenQty"});
		UITools.apendFootRow(kdtWeigntEntry, new String[]{"chickenQty","houseWeight","houseSkinWeight","houseNetWeight","saleQty","saleAmount"});
		UITools.apendFootRow(kdtButcherEntry, new String[]{"carcassQty","carcassWeight","reducedWeight","saleQty","saleAmount"});



	}

	private void initControl() {
		// TODO Auto-generated method stub
		this.prmtFICompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setFilter();			
			}});

		this.prmtfarmer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(prmtfarmer.getValue()!=null){
					if(!isLoadField) {
						isLoadField=true;
						String farmerID=null,farmID=null;
						StockingComm.setFarmInfoByFarmer(prmtfarmer, prmtfarm);
						farmerID=((IPropertyContainer)prmtfarmer.getValue()).getString("id");
						try {
							FarmerInfo farmer=FarmerFactory.getRemoteInstance().getFarmerInfo(new ObjectUuidPK(farmerID));
							txtfarmerPhone.setText(farmer.getMobileTel());
						} catch (EASBizException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (BOSException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(prmtfarm.getValue()!=null){
							farmID=((IPropertyContainer)prmtfarm.getValue()).getString("id");
							//							prmtbatchContract.setValue(StockingComm.getLastBatchContractInfo(null, farmerID, farmID));
						}	
						isLoadField=false;
					}}else{
						prmtfarm.setValue(null);
						txtfarmerPhone.setText(null);
					}
				setFilter();
			}});

		this.prmtfarm.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(prmtfarm.getValue()!=null){
					if(!isLoadField){
						isLoadField=true;
						prmtfarmer.setValue(StockingComm.getFarmerInfoByFarm(null, prmtfarm));
						isLoadField=false;
					}
					String farmerID = null;
					if(prmtfarmer.getValue()!=null){
						String farmID=((IPropertyContainer)prmtfarm.getValue()).getString("id");
						farmerID=((IPropertyContainer)prmtfarmer.getValue()).getString("id");
						try {
							FarmInfo  farm=FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(farmID));
							txtfarmAddress.setText(farm.getAddress());
							farmType.setSelectedItem(farm.getFaemsType());
						} catch (EASBizException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (BOSException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//						prmtbatchContract.setValue(StockingComm.getLastBatchContractInfo(null, farmerID, farmID));

					}
				}else{
					prmtbatchContract.setValue(null);
					txtfarmAddress.setText(null);
					farmType.setSelectedItem(null);
				}
				setFilter();
			}});

		this.prmtbatch.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				batch_changed(e);
			}});

		prmtbatchContract.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				try {
					prmtbatchContract_Changed(arg0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});

		//modified by zz
		//		saleType.addItemListener(new ItemListener(){
		//			public void itemStateChanged(ItemEvent e) {
		//				// TODO Auto-generated method stub
		//				prmtcustomer.setValue(null);
		//				setFilter();
		//			}
		//		});

		this.pkBizDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				if(pkBizDate.getValue()!=null&&pkinDate.getValue()!=null){
					int dayAge=DateUtilsComm.getDiffBetweenTwoDays(DateUtilsComm.clearDateHMS((Date)pkinDate.getValue()),DateUtilsComm.clearDateHMS((Date) pkBizDate.getValue()));
					txtfeedDays.setValue(dayAge+1);
				}
			}});

		setFilter();


		this.kdtEntry.addKDTEditListener(new KDTEditAdapter(){


			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				//派车信息分录添加监听事件，实时计算"本车只数"合计数
				if("chickenQty".equalsIgnoreCase(kdtEntry.getColumn(e.getColIndex()).getKey())){
					chickenQtyAll(e);
				}

				//选中车辆自动带出司机和司机的联系方式
				if("car".equalsIgnoreCase(kdtEntry.getColumn(e.getColIndex()).getKey())){
					if(kdtEntry.getCell(e.getRowIndex(),"car").getValue() != null){
						gainDriver(e);
					}
				}



			}

		});

		//棚前过磅信息添加监听事件
		kdtWeigntEntry.addKDTEditListener(new KDTEditAdapter(){

			public void editStopped(KDTEditEvent arg0) {
				// TODO Auto-generated method stub
				//字段改变添加监听事件
				if(kdtWeigntEntry.getCell(arg0.getRowIndex(),"houseWeight").getValue() != null
						&& kdtWeigntEntry.getCell(arg0.getRowIndex(),"houseSkinWeight").getValue() != null){
					weightEntryChange(arg0);
				}
				//计算销售金额
				if("saleChicPrice".equalsIgnoreCase(kdtWeigntEntry.getColumn(arg0.getColIndex()).getKey())
						|| "saleQty".equalsIgnoreCase(kdtWeigntEntry.getColumn(arg0.getColIndex()).getKey())
						|| "punishAmt".equalsIgnoreCase(kdtWeigntEntry.getColumn(arg0.getColIndex()).getKey())){
					if(kdtWeigntEntry.getCell(arg0.getRowIndex(),"saleChicPrice").getValue() != null
							&& kdtWeigntEntry.getCell(arg0.getRowIndex(),"saleQty").getValue() != null){
						weightSaleEntryChange(arg0);
					}
				}
				//计算销售单价
				if("saleAmount".equalsIgnoreCase(kdtWeigntEntry.getColumn(arg0.getColIndex()).getKey())){
					if(kdtWeigntEntry.getCell(arg0.getRowIndex(),"saleAmount").getValue() != null
							&& kdtWeigntEntry.getCell(arg0.getRowIndex(),"saleQty").getValue() != null){
						aleEntryChange(arg0);
					}

				}


				//选中车辆自动带出司机和司机的联系方式
				if("carcar".equalsIgnoreCase(kdtWeigntEntry.getColumn(arg0.getColIndex()).getKey())){
					if(kdtWeigntEntry.getCell(arg0.getRowIndex(),"carcar").getValue() != null){
						gainHOuseDriver(arg0);
					}
				}


				UITools.apendFootRow(kdtWeigntEntry, new String[]{"chickenQty","houseWeight","houseSkinWeight","houseNetWeight","saleQty","saleAmount"});
			}

			//计算销售金额
			private void weightSaleEntryChange(KDTEditEvent arg0) {
				// TODO Auto-generated method stub

				BigDecimal saleChicPrice = UIRuleUtil.getBigDecimal(kdtWeigntEntry.getCell(arg0.getRowIndex(),"saleChicPrice").getValue());
				BigDecimal saleQty = UIRuleUtil.getBigDecimal(kdtWeigntEntry.getCell(arg0.getRowIndex(),"saleQty").getValue());
				BigDecimal punishAmt = UIRuleUtil.getBigDecimal(kdtWeigntEntry.getCell(arg0.getRowIndex(),"punishAmt").getValue());
				BigDecimal houseNetWeight = (saleChicPrice.multiply(saleQty).subtract(punishAmt)).divide(BigDecimal.ONE,1,BigDecimal.ROUND_HALF_UP);
				kdtWeigntEntry.getCell(arg0.getRowIndex(),"saleAmount").setValue(houseNetWeight);
			}

			//计算销售单价
			private void aleEntryChange(KDTEditEvent arg0) {
				// TODO Auto-generated method stub

				BigDecimal saleAmount = UIRuleUtil.getBigDecimal(kdtWeigntEntry.getCell(arg0.getRowIndex(),"saleAmount").getValue());
				BigDecimal saleQty = UIRuleUtil.getBigDecimal(kdtWeigntEntry.getCell(arg0.getRowIndex(),"saleQty").getValue());
				BigDecimal punishAmt = UIRuleUtil.getBigDecimal(kdtWeigntEntry.getCell(arg0.getRowIndex(),"punishAmt").getValue());
				BigDecimal houseNetWeight = (saleAmount.add(punishAmt)).divide(saleQty,3,BigDecimal.ROUND_HALF_UP);
				kdtWeigntEntry.getCell(arg0.getRowIndex(),"saleChicPrice").setValue(houseNetWeight);
			}




		});

		//屠宰信息添加监听事件
		kdtButcherEntry.addKDTEditListener(new KDTEditAdapter(){

			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				if("carcassQty".equalsIgnoreCase(kdtButcherEntry.getColumn(e.getColIndex()).getKey())
						|| "carcassWeight".equalsIgnoreCase(kdtButcherEntry.getColumn(e.getColIndex()).getKey())
						|| "reducedWeight".equalsIgnoreCase(kdtButcherEntry.getColumn(e.getColIndex()).getKey())
						|| "saleChickPrice".equalsIgnoreCase(kdtButcherEntry.getColumn(e.getColIndex()).getKey())
						|| "saleQty".equalsIgnoreCase(kdtButcherEntry.getColumn(e.getColIndex()).getKey())){
					if(kdtButcherEntry.getCell(e.getRowIndex(),"saleChickPrice").getValue() != null
							&& kdtButcherEntry.getCell(e.getRowIndex(),"saleQty").getValue() != null){
						butcherEntryChange(e);
					}
					UITools.apendFootRow(kdtButcherEntry, new String[]{"carcassQty","carcassWeight","reducedWeight","saleQty","saleAmount"});
				}
			}

		});
	}

	/**
	 * 棚前信息选中车辆自动带出司机和司机的联系方式
	 * @param arg0
	 */
	protected void gainHOuseDriver(KDTEditEvent e) {
		// TODO Auto-generated method stub
		String carid = ((CarInfo) kdtWeigntEntry.getCell(e.getRowIndex(),"carcar").getValue()).getId().toString();;
		String sql = "select t3.fid driverid, t3.fname_l2 from CT_PUB_Car t1 inner join T_PUB_CarEntry t2 on t2.fparentid=t1.fid" +
		" inner join CT_FM_Driver t3 on t3.fid=t2.FDriverID  where t2.FIsDefault=1  and t1.fid='"+carid+"'";
		ISQLExecutor executor = SQLExecutorFactory.getRemoteInstance(sql);
		try {
			IRowSet rs = executor.executeSQL();
			String driverid = null;
			DriverInfo driverInfo = null;
			if(rs.next()){
				driverid = rs.getString("driverid");
				driverInfo = DriverFactory.getRemoteInstance().getDriverInfo(new ObjectUuidPK(driverid));
				kdtWeigntEntry.getCell(e.getRowIndex(),"driver").setValue(driverInfo);
				kdtWeigntEntry.getCell(e.getRowIndex(),"telephone").setValue(driverInfo.getDriverphone());
			}
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (EASBizException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	}
	/**
	 * 选中车辆自动带出司机和司机的联系方式
	 * @param e
	 */
	protected void gainDriver(KDTEditEvent e) {
		// TODO Auto-generated method stub
		String carid = ((CarInfo) kdtEntry.getCell(e.getRowIndex(),"car").getValue()).getId().toString();;
		String sql = "select t3.fid driverid, t3.fname_l2 from CT_PUB_Car t1 inner join T_PUB_CarEntry t2 on t2.fparentid=t1.fid" +
		" inner join CT_FM_Driver t3 on t3.fid=t2.FDriverID  where t2.FIsDefault=1  and t1.fid='"+carid+"'";
		ISQLExecutor executor = SQLExecutorFactory.getRemoteInstance(sql);
		try {
			IRowSet rs = executor.executeSQL();
			String driverid = null;
			DriverInfo driverInfo = null;
			if(rs.next()){
				driverid = rs.getString("driverid");
				driverInfo = DriverFactory.getRemoteInstance().getDriverInfo(new ObjectUuidPK(driverid));
				kdtEntry.getCell(e.getRowIndex(),"driver").setValue(driverInfo);
				kdtEntry.getCell(e.getRowIndex(),"telephone").setValue(driverInfo.getDriverphone());
			}
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (EASBizException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

	}
	/**
	 * 屠宰信息添加监听事件
	 * @param e
	 */
	protected void butcherEntryChange(KDTEditEvent arg0) {
		// TODO Auto-generated method stub
		BigDecimal saleChicPrice = (BigDecimal) kdtButcherEntry.getCell(arg0.getRowIndex(),"saleChickPrice").getValue();
		BigDecimal saleQty = (BigDecimal) kdtButcherEntry.getCell(arg0.getRowIndex(),"saleQty").getValue();
		BigDecimal houseNetWeight = saleChicPrice.multiply(saleQty);
		kdtButcherEntry.getCell(arg0.getRowIndex(),"saleAmount").setValue(houseNetWeight);
	}
	/**
	 * 棚前信息添加监听事件
	 * @param arg0
	 */
	protected void weightEntryChange(KDTEditEvent arg0) {
		// TODO Auto-generated method stub

		BigDecimal houseWeight = (BigDecimal) kdtWeigntEntry.getCell(arg0.getRowIndex(),"houseWeight").getValue();
		BigDecimal houseSkinWeight = (BigDecimal) kdtWeigntEntry.getCell(arg0.getRowIndex(),"houseSkinWeight").getValue();
		BigDecimal houseNetWeight = (houseWeight.subtract(houseSkinWeight)).divide(BigDecimal.ONE,1,BigDecimal.ROUND_HALF_UP);
		this.kdtWeigntEntry.getCell(arg0.getRowIndex(),"houseNetWeight").setValue(houseNetWeight);
		this.kdtWeigntEntry.getCell(arg0.getRowIndex(),"saleQty").setValue(houseNetWeight);
		
		UITools.apendFootRow(kdtWeigntEntry, new String[]{"houseWeight","houseSkinWeight","houseNetWeight"});

	}
	/**
	 * 派车信息的“本车只数”实时计算合计数
	 * @param e
	 */
	protected void chickenQtyAll(KDTEditEvent e) {
		// TODO Auto-generated method stub

		BigDecimal smallEggQty=UIRuleUtil.getBigDecimal(kdtEntry.getCell(e.getRowIndex(),"chickenQty").getValue());
		UITools.apendFootRow(kdtEntry, new String[]{"chickenQty"});
	}
	/**
	 * 批次改变
	 */
	private void batch_changed(DataChangeEvent e) {
		isLoadField=true;
		if(e.getNewValue()!=null) {
			try {
				pkinDate.setValue(UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "inDate"));
				txtbatchQty.setValue(UIRuleUtil.getProperty((IObjectValue) e.getNewValue(), "femaleQty"));
			} catch (DataAccessException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			} catch (BOSException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}		
		}else{
			pkinDate.setValue(null);
			txtbatchQty.setValue(null);
		}
		isLoadField=false;
	}




	public void prmtbatchContract_Changed(DataChangeEvent arg0) throws Exception {
		if(prmtbatchContract.getValue()!=null){
			String contractID=((IPropertyContainer) prmtbatchContract.getValue()).getString("id");
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("breedData.*");
			slor.add("farmer.*");
			slor.add("farm.*");
			slor.add("person.*");
			slor.add("batch.*");
			slor.add("settlementPolicy.*");
			BatchContractBillInfo contractInfo = BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(contractID),slor );
			prmtsettlePolicy.setValue(contractInfo.getSettlementPolicy());
			prmtbreedData.setValue(contractInfo.getBreedData());
			prmtperson.setValue(contractInfo.getPerson());
			prmtfarm.setValue(contractInfo.getFarm());
			prmtfarmer.setValue(contractInfo.getFarmer());
			if(pkBizDate.getValue()!=null&&contractInfo.getActualBreedDate()!=null){
				int dayAge=DateUtilsComm.getDiffBetweenTwoDays(DateUtilsComm.clearDateHMS(contractInfo.getActualBreedDate()),DateUtilsComm.clearDateHMS((Date) pkBizDate.getValue()));
				txtfeedDays.setValue(dayAge+1);
			}
			String batchID=StockingComm.getBatchIDByContractID(null, contractID);
			isLoadField=true;
			if(StringUtils.isNotEmpty(batchID)) {
				this.prmtbatch.setValue(BatchFactory.getRemoteInstance().getBatchInfo(new ObjectUuidPK(batchID)));
			}else {
				this.prmtbatch.setValue(null);
			}
			isLoadField=false;
		}else{
			this.prmtbatch.setValue(null);
			prmtsettlePolicy.setValue(null);
			prmtperson.setValue(null);
			prmtbreedData.setValue(null);
			txtfeedDays.setValue(null);
		}
		setFilter();
	}

	/**
	 * 设置过滤条件
	 * @param companyID
	 */
	private void setFilter() {
		if(this.prmtFICompany.getValue()!=null) {
			curCompanyID=((IPropertyContainer) this.prmtFICompany.getValue()).getString("id");
			try {
				company=CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitInfo(new ObjectUuidPK(curCompanyID));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				e.printStackTrace();
			}
		}else{
			curCompanyID=null;
		}
		//modified by zz
		//		f7Manager.registerBizCustomerF7(prmtcustomer, null, null, company);

		String farmerID="";
		String farmID="";

		farmerID=prmtfarmer.getValue()==null?"":((FarmerInfo)prmtfarmer.getValue()).getId().toString();
		farmID=prmtfarm.getValue()==null?"":((FarmInfo)prmtfarm.getValue()).getId().toString();

		//养殖户过滤
		StockingComm.setFarmerFilter(prmtfarmer, curCompanyID,false);
		//养殖场过滤
		StockingComm.setFarmFilter(prmtfarm, curCompanyID, farmerID,true);
		//合同过滤
		StockingComm.setBatchContractFilter(prmtbatchContract, curCompanyID,farmerID,farmID,true);
		//		//客户过滤 modified by zz
		//		StockingComm.setCustomerFilterBySale(prmtcustomer, saleType.getSelectedItem()==null?null:(SaleBizType) saleType.getSelectedItem());
	}


	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}

	public void actionEdit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionEdit_actionPerformed(e);
	}

	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止修改！");
			SysUtil.abort();
		}
		super.actionRemove_actionPerformed(e);
	}
	/**
	 * output actionAudit_actionPerformed
	 */
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if(this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据已经审核，禁止再次审核！");
			SysUtil.abort();
		}
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			MsgBox.showWarning("单据尚未提交，禁止审核！");
			SysUtil.abort();
		}

		if(WorkFlowUtil.checkBillInWorkflow(null,editData.getId().toString())){
			MsgBox.showWarning("当前单据尚在工作流执行过程,不能执行该操作");
			SysUtil.abort();
		}

		super.actionAudit_actionPerformed(e);

		this.doAfterSave(new ObjectUuidPK(editData.getId()));

		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}

	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	/**
	 * output actionUnAudit_actionPerformed
	 */
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception
	{
		if(!this.editData.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			MsgBox.showWarning("单据尚未审核，禁止反审核！");
			SysUtil.abort();
		}
		super.actionUnAudit_actionPerformed(e);
		this.doAfterSave(new ObjectUuidPK(editData.getId()));
		setOprtState(STATUS_VIEW);
		lockUIForViewStatus();
		setNextMessageText("反审核成功");
		setShowMessagePolicy(0);
		setIsShowTextOnly(false);
		showMessage();
	}
	@Override
	public void actionCopy_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		//		super.actionCopy_actionPerformed(e);
		if(!UtilRequest.isPrepare("ActionCopy", this))
			checkModified();
		if(editData != null && !OprtState.VIEW.equals(getOprtState()))
		{
			IObjectValue objectValue = (IObjectValue)getUIContext().get("CURRENT.VO");
			if(objectValue != null)
				try
			{
					String id = idList.getID(idList.getCurrentIndex());
					setOprtState("RELEASEALL");
					pubFireVOChangeListener(id);
			}
			catch(Throwable E) { }
		}
		ObjectValueUtil.copy(editData);
		unLockUI();
		setFieldsNull(editData);
		editData.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		//        editData.setNumber(null);
		//		editData.setFarmer(null);
		editData.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		editData.setNumber(CodingUtil.getNewNumberByCodingRule(null, editData));
		//		editData.setBizDate(new java.util.Date());
		setOprtState("ADDNEW");
		setDataObject(editData);
		loadFields();
		showCopyAddNew();
		//		editData.setPerson(null);
		actionCopy.setEnabled(false);
		chkMenuItemSubmitAndAddNew.setVisible(true);
		setDefaultFocused();
		isLoadField=false;

		setMakeRelations(null);

	}



	@Override
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);
		//	if(saleType.getSelectedItem()==SaleBizType.out&&UIRuleUtil.getBigDecimal(txtoutSalePrice.getBigDecimalValue()).signum()==0){
		//		MsgBox.showWarning("外销单据的外销价格不能为空或0");
		//		SysUtil.abort();
		//	}

	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo();
		if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));

		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		return objectValue;
	}

	//分录添加监听事件
	@Override
	public void kdtWeigntEntry_Changed(int rowIndex, int colIndex)
	throws Exception {
		// TODO Auto-generated method stub
		super.kdtWeigntEntry_Changed(rowIndex, colIndex);

		//根据车主自动带出车辆
		if(kdtWeigntEntry.getCell(rowIndex, "carleader").getValue() != null){
			String carleader = UIRuleUtil.getString(kdtWeigntEntry.getCell(rowIndex, "carleader").getValue());
			String s1 = "/*dialect*/ select fid carid  from CT_PUB_Car where fcarowner ='"+carleader+"'";
			IRowSet r1 = SQLExecutorFactory.getRemoteInstance(s1).executeSQL();
			if(r1.next()){
				String carid = UIRuleUtil.getString(r1.getString("carid"));
				CarInfo carInfo = CarFactory.getRemoteInstance().getCarInfo(new ObjectUuidPK(carid));
				kdtWeigntEntry.getCell(rowIndex, "carcar").setValue(carInfo);
			}
		}


		//销售客户设置批量填充
		if(rowIndex == 0 && "customer".equalsIgnoreCase(kdtWeigntEntry.getColumn(colIndex).getKey())){
			saleCustomer(rowIndex, colIndex);
		}
		if("carcass".equalsIgnoreCase(kdtWeigntEntry.getColumn(colIndex).getKey())){
			isNewBatchListen(rowIndex, colIndex);
		}
		if("houseNetWeight".equalsIgnoreCase(kdtWeigntEntry.getColumn(colIndex).getKey())){
			isNewBatchListen(rowIndex, colIndex);
		}
		if("carcessReduceWeight".equalsIgnoreCase(kdtWeigntEntry.getColumn(colIndex).getKey())){
			isNewBatchListen(rowIndex, colIndex);
		}

		if("houseSkinWeight".equalsIgnoreCase(kdtWeigntEntry.getColumn(colIndex).getKey())){
			isNewBatchListen(rowIndex, colIndex);
		}

		//计算均重
		BigDecimal chickenQty = UIRuleUtil.getBigDecimal(kdtWeigntEntry.getCell(rowIndex, "chickenQty").getValue());
		BigDecimal houseNetWeight = UIRuleUtil.getBigDecimal(kdtWeigntEntry.getCell(rowIndex, "houseNetWeight").getValue());
		if(chickenQty.compareTo(BigDecimal.ZERO) > 0){
			BigDecimal avgWgt = houseNetWeight.divide(chickenQty,2,BigDecimal.ROUND_DOWN);
			avgWgt = avgWgt.multiply(new BigDecimal("2"));
			kdtWeigntEntry.getCell(rowIndex, "avgWgt").setValue(avgWgt);
		}else{
			kdtWeigntEntry.getCell(rowIndex, "avgWgt").setValue(BigDecimal.ZERO);
		}


	}


	/**
	 * 分录的胴体字段添加监听事件
	 * 勾选胴体时 销售数量取值为：胴体折算后毛鸡重量
	 * 不勾选胴体时 销售数量为：棚前净重
	 * @param rowIndex
	 * @param colIndex
	 */
	private void isNewBatchListen(int rowIndex, int colIndex) {
		// TODO Auto-generated method stub
		BigDecimal houseNetWeight = UIRuleUtil.getBigDecimal(kdtWeigntEntry.getCell(rowIndex, "houseNetWeight").getValue());
		kdtWeigntEntry.getCell(rowIndex, "houseNetWeight").setValue(houseNetWeight.divide(BigDecimal.ONE,1,BigDecimal.ROUND_HALF_UP));
		
		BigDecimal saleQty = BigDecimal.ZERO;
		if(kdtWeigntEntry.getCell(rowIndex, "carcass").getValue().toString().equalsIgnoreCase("true")
				&& (BigDecimal) kdtWeigntEntry.getCell(rowIndex, "carcessReduceWeight").getValue() != null){
			saleQty = (BigDecimal) kdtWeigntEntry.getCell(rowIndex, "carcessReduceWeight").getValue();
		}else if(kdtWeigntEntry.getCell(rowIndex, "carcass").getValue().toString().equalsIgnoreCase("false")
				&& kdtWeigntEntry.getCell(rowIndex, "houseNetWeight").getValue() != null){
			saleQty =  new BigDecimal(kdtWeigntEntry.getCell(rowIndex, "houseNetWeight").getValue().toString());
		}
		kdtWeigntEntry.getCell(rowIndex, "saleQty").setValue(saleQty);
		BigDecimal saleChicPrice = UIRuleUtil.getBigDecimal(kdtWeigntEntry.getCell(rowIndex, "saleChicPrice").getValue());
		kdtWeigntEntry.getCell(rowIndex, "saleAmount").setValue(saleChicPrice.multiply(saleQty).divide(BigDecimal.ONE,1,BigDecimal.ROUND_HALF_UP));
	
	}
	/**
	 * 销售客户设置批量填充
	 * @param rowIndex
	 * @param colIndex
	 */
	private void saleCustomer(int rowIndex, int colIndex) {
		// TODO Auto-generated method stub

		CustomerInfo customerInfo = null;
		if(kdtWeigntEntry.getRowCount() > 0){
			if(kdtWeigntEntry.getCell(0,"customer").getValue() != null){ 
				try {
					customerInfo = CustomerFactory.getRemoteInstance().getCustomerInfo(new ObjectUuidPK(((CustomerInfo) kdtWeigntEntry.getCell(0,"customer").getValue()).getId()));
					for(int i=0,size=kdtWeigntEntry.getRowCount();i<size;i++){
						kdtWeigntEntry.getCell(i,"customer").setValue(customerInfo);
					}
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub

		super.beforeStoreFields(arg0);
	}







}