/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.recyclebiz.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemCollection;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.IQueryExecutor;
import com.kingdee.bos.dao.query.QueryExecutorFactory;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitFactory;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.CodingUtil;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.basedata.PunishType;
import com.kingdee.eas.farm.carnivorous.basedata.RandPPolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.RandPPolicyInfo;
import com.kingdee.eas.farm.carnivorous.basedata.RandPScope;
import com.kingdee.eas.farm.carnivorous.basedata.RewardAndPunishItemFactory;
import com.kingdee.eas.farm.carnivorous.basedata.RewardAndPunishItemInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyAwardsEntryCollection;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyAwardsEntryFactory;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyAwardsEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo;
import com.kingdee.eas.farm.carnivorous.basedata.recType;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillQCEntryCollection;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillQCEntryFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillQCEntryInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType;
import com.kingdee.eas.fi.gl.common.toolkit.dbmono.SqlExecutor;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.batchHandler.UtilRequest;
import com.kingdee.eas.framework.client.multiDetail.DetailPanelEvent;
import com.kingdee.eas.framework.client.multiDetail.IDetailPanelListener;
import com.kingdee.eas.publicdata.CarEntryCollection;
import com.kingdee.eas.publicdata.CarEntryInfo;
import com.kingdee.eas.publicdata.CarFactory;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.InStorageBillFactory;
import com.kingdee.eas.weighbridge.InStorageBillInfo;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.eas.wlhlcomm.impl.DetailPanelBackListener;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.data.datasource.BOSQueryDataSource;
import com.kingdee.bos.ctrl.kdf.data.impl.BOSQueryDelegate;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTMouseListener;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.report.forapp.kdnote.client.KDNoteHelper;
/**
 * output class name
 */
public class CSlaughterBillEditUI extends AbstractCSlaughterBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(CSlaughterBillEditUI.class);
	private String curCompanyID;//当前财务组织
	private CompanyOrgUnitInfo company;
	private boolean isLoadField=false;
	private F7ContextManager f7Manager;
	/**
	 * output class constructor
	 */
	public CSlaughterBillEditUI() throws Exception
	{
		super();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		company=SysContext.getSysContext().getCurrentFIUnit();
		f7Manager = new F7ContextManager(this, OrgType.Storage);		
		kdtQCEntrys.getColumn("actualRate").getStyleAttributes().setNumberFormat("#.000");
		initControl();
	}

	public void loadFields(){
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

		String suID = txtF7id.getText();
		if (!StringUtils.isEmpty(suID)) {
			String[] supplier = suID.split(";");
			Object[] obj = new Object[supplier.length];
			for (int i = 0; i < obj.length; i++){
				String id = supplier[i];
				try {
					InStorageBillInfo instorInfo = InStorageBillFactory.getRemoteInstance().getInStorageBillInfo(new ObjectUuidPK(id));
					if (instorInfo != null) {
						obj[i] = instorInfo;
					}
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			prmtchicWeighr.setValue(obj);

		}


	}


	@Override
	public void actionPrintPreview_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		if (editData.getId() != null) {
			String id = editData.getId().toString();
			DataProvider data = new DataProvider(id);
			KDNoteHelper appHlp = new KDNoteHelper();
			appHlp.printPreview("/bim/farm/carnivorous/recyclebiz/CSlaughterBill", data, javax.swing.SwingUtilities.getWindowAncestor(this));
		} else {
			MsgBox.showWarning("请先保存单据!");
		}
	}

	@Override
	public void actionPrint_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		if (editData.getId() != null) {
			String id = editData.getId().toString();
			DataProvider data = new DataProvider(id);
			KDNoteHelper appHlp = new KDNoteHelper();
			appHlp.print("/bim/farm/carnivorous/recyclebiz/CSlaughterBill", data, javax.swing.SwingUtilities.getWindowAncestor(this));
		} else {
			MsgBox.showWarning("请先保存单据!");
		}
	}





	public class DataProvider implements BOSQueryDelegate {
		private String billId;

		public DataProvider(String billId) {
			this.billId = billId;
		}
		public IRowSet execute(BOSQueryDataSource ds) {
			IRowSet rs = null;
			try {
				IQueryExecutor iqec = null;
				FilterInfo filterInfo = new FilterInfo();
				EntityViewInfo viewInfo = new EntityViewInfo();
				if (ds.getID().equals("CSlaughterBillNewQuery")) {
					iqec = QueryExecutorFactory.getRemoteInstance(new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.app",
					"CSlaughterBillNewQuery"));
					filterInfo.getFilterItems().add(new FilterItemInfo("id", this.billId, CompareType.EQUALS));
					viewInfo.setFilter(filterInfo);
					iqec.setObjectView(viewInfo);
					iqec.option().isAutoTranslateBoolean = true;
					iqec.option().isAutoTranslateEnum = true;
					rs = iqec.executeQuery();
				} else if (ds.getID().equals("CSlaughterBillQuery")) {
					iqec = QueryExecutorFactory.getRemoteInstance(new MetaDataPK("com.kingdee.eas.farm.carnivorous.recyclebiz.app",
					"CSlaughterBillQuery"));
					filterInfo.getFilterItems().add(new FilterItemInfo("id", this.billId, CompareType.EQUALS));
					viewInfo.setFilter(filterInfo);
					iqec.setObjectView(viewInfo);
					iqec.option().isAutoTranslateBoolean = true;
					iqec.option().isAutoTranslateEnum = true;
					rs = iqec.executeQuery();
				}  
				else {
					logger.info("==============其他执行，ds.getID()====" + ds.getID());
				}

			} catch (Exception err) {
				handleException(err);
			} 
			int rowcount = rs.size();
			logger.info("rs.size====" + rowcount);
			return rs;
		}
	}

	/**
	 * 保存和提交时计算A鸡重量 = 该批次合同对应毛鸡过磅单的毛鸡净重-返死鸡重量-扣罚总重-B鸡重量
	 */
	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.beforeStoreFields(arg0);

		StringBuffer strID=new StringBuffer();
		StringBuffer strName=new StringBuffer();
		List<String> idList = new ArrayList<String>();
		StringBuffer s2 = new StringBuffer();
		if(!StringUtils.isEmpty(prmtchicWeighr.getText())){
			Object[] obj = (Object[]) prmtchicWeighr.getData();
			s2.append("(");
			for(int i = 0; i < obj.length; i++) {
				InStorageBillInfo suInfo = (InStorageBillInfo) obj[i];
				strID.append(suInfo.getId().toString()+";");
				strName.append(suInfo.getNumber()+",");
				s2.append("'");
				s2.append(suInfo.getId().toString());
				if(i == obj.length - 1){
					s2.append("'");
				}else{
					s2.append("',");
				}
				idList.add(suInfo.getId().toString());
			}
			s2.append(")");
			txtF7id.setText(strID.substring(0, strID.length()-1));
			txtF7Number.setText(strName.substring(0,strName.length()-1));
		}

		String s1 = "/*dialect*/ select sum(t2.CFSuttle) suttle from CT_WHB_InStorageBill t1" +
		" inner join CT_WHB_InStorageBillEntry t2 on t2.fparentid = t1.fid" +
		" where t1.fid in "+s2.toString();
		IRowSet r1 = SQLExecutorFactory.getRemoteInstance(s1).executeSQL();
		BigDecimal suttle = BigDecimal.ZERO;
		if(r1.next()){
			suttle = UIRuleUtil.getBigDecimal(r1.getBigDecimal("suttle"));
		}

		BigDecimal BWeight = UIRuleUtil.getBigDecimal(txtBWeight.getValue());
		BigDecimal returnWeight = UIRuleUtil.getBigDecimal(txtreturnWeight.getValue());
		BigDecimal punishWgt = UIRuleUtil.getBigDecimal(txtpunishWgt.getValue());

		//设置A重量 = 毛鸡过磅单净重 - B鸡重量 - 返死鸡重量 - 扣罚总重量
		txtAWeight.setValue(suttle.subtract(BWeight).subtract(returnWeight).subtract(punishWgt));
		//设置结算重量
		txtsettleWeight.setValue(suttle.subtract(returnWeight).subtract(punishWgt));


	}

	private void initControl() {

		// prmtdriver		
		this.prmtdriver.setQueryInfo("com.kingdee.eas.farm.feemanager.basedata.app.DriverQuery");		
		this.prmtdriver.setVisible(true);		
		this.prmtdriver.setEditable(true);		
		this.prmtdriver.setDisplayFormat("$drivername$");		
		this.prmtdriver.setEditFormat("$drivername$");		
		this.prmtdriver.setCommitFormat("$drivername$");		
		this.prmtdriver.setRequired(false);




		//毛鸡过磅单设置多选
		// prmtchicWeighr		
		this.prmtchicWeighr.setQueryInfo("com.kingdee.eas.weighbridge.app.oneInStorageBillQuery");		
		this.prmtchicWeighr.setVisible(true);		
		this.prmtchicWeighr.setEditable(true);		
		this.prmtchicWeighr.setDisplayFormat("$number$;$number$");		
		this.prmtchicWeighr.setEditFormat("$number$;$number$");		
		this.prmtchicWeighr.setCommitFormat("$number$;$number$");
		this.prmtchicWeighr.setEnabledMultiSelection(true);
		this.prmtchicWeighr.setRequired(false);
		//毛鸡过磅单设置过滤
		EntityViewInfo viewInfo = new EntityViewInfo();
		FilterInfo filterInfo = new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("billStatus","4,6",CompareType.INCLUDE));
		viewInfo.setFilter(filterInfo);
		this.prmtchicWeighr.setEntityViewInfo(viewInfo);

		//回收只数添加监听事件
		txtreceQty.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//				calcAQty();
			}

		});

		//回收只数和B鸡只数添加监听事件
		txtreceQty.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub
				calcAQty();
			}

		});
		//B鸡只数添加监听事件
		txtBQty.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub
				calcAQty();
			}

		});
		txtBQty.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//				calcAQty();
			}

		});
		/**
		 * 毛鸡过磅单添加监听事件
		 */
		prmtchicWeighr.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent arg0) {

				StringBuffer strID=new StringBuffer();
				StringBuffer strName=new StringBuffer();
				List<String> idList = new ArrayList<String>();
				StringBuffer s2 = new StringBuffer();
				if(!StringUtils.isEmpty(prmtchicWeighr.getText())){
					Object[] obj = (Object[]) prmtchicWeighr.getData();
					s2.append("(");
					for(int i = 0; i < obj.length; i++) {
						InStorageBillInfo suInfo = (InStorageBillInfo) obj[i];
						strID.append(suInfo.getId().toString()+";");
						strName.append(suInfo.getNumber()+",");
						s2.append("'");
						s2.append(suInfo.getId().toString());
						if(i == obj.length - 1){
							s2.append("'");
						}else{
							s2.append("',");
						}
						idList.add(suInfo.getId().toString());
					}
					s2.append(")");
					txtF7id.setText(strID.substring(0, strID.length()-1));
					txtF7Number.setText(strName.substring(0,strName.length()-1));
				}

				//自动带出B鸡重量-残鸡重量，B鸡只数--残鸡只数，返死鸡重量--死鸡重量，死鸡只数--死鸡只数
				String s1 = "/*dialect*/ select sum(t3.dNetWgt) dNetWgt,sum(t3.qty) qty from ( select t2.CFNetWgt dNetWgt,0 qty" +
				" from CT_WHB_InStorageBill t1 inner join CT_WHB_InStorageBillDEntry t2 on t2.fparentid = t1.fid" +
				" where t1.fid in" +s2.toString()+" union all select  t2.CFNetWgt reNetWgt,0 qty from CT_WHB_InStorageBill t1" +
				" inner join CT_WHB_InStorageBillReEntry t2 on t2.fparentid = t1.fid " +
				" where t1.fid in "+s2.toString()+"  union all select t2.CFNetWgt smartNetWgt,0 qty from CT_WHB_InStorageBill t1" +
				" inner join CT_WHB_InStorageBillSmartEntry t2 on t2.fparentid = t1.fid where t1.fid in " +s2.toString()+" " +
				" union all select  0 smartNetWgt,sum(nvl(t1.CFDeathQty,0)) + sum(nvl(t1.CFWrongQty,0)) + sum(nvl(t1.CFSmartQty,0))  qty" +
				" from CT_WHB_InStorageBill t1 where t1.fid in" +s2.toString()+") t3";
				IRowSet r1;
				BigDecimal deathQty = BigDecimal.ZERO;
				BigDecimal deathWgt = BigDecimal.ZERO;
				try {
					r1 = SQLExecutorFactory.getRemoteInstance(s1).executeSQL();
					if(r1.next()){
						deathQty = UIRuleUtil.getBigDecimal(r1.getBigDecimal("qty"));
						deathWgt = UIRuleUtil.getBigDecimal(r1.getBigDecimal("dNetWgt"));
					}
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                //死鸡只数
				txtdeathQty.setValue(deathQty);
				//死鸡重量
				txtreturnWeight.setValue(deathWgt);
			}

		});


		DataChangeListener numChangeListener=new DataChangeListener() {
			public void dataChanged(DataChangeEvent e) {
				calData();
			}
		};
		txtpreHouseTare.addDataChangeListener(numChangeListener);
		txtpreHouseGross.addDataChangeListener(numChangeListener);
		txtpreHouseQty.addDataChangeListener(numChangeListener);
		txtcarcassQty.addDataChangeListener(numChangeListener);
		txtcarcassWgt.addDataChangeListener(numChangeListener);
		txtincompleteWgt.addDataChangeListener(numChangeListener);
		txtincompleteQty.addDataChangeListener(numChangeListener);
		txtcompanyGross.addDataChangeListener(numChangeListener);
		txtcompanyTare.addDataChangeListener(numChangeListener);

		//车辆添加监听事件
		this.prmtcar.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub

				if(prmtcar.getValue() != null){
					try {
						SelectorItemCollection slor =new SelectorItemCollection();
						slor.add("*");
						slor.add("Entry.*");
						slor.add("Entry.driver.*");
						CarInfo carInfo=CarFactory.getRemoteInstance().getCarInfo(new ObjectUuidPK(((IPropertyContainer)prmtcar.getValue()).getString("id")), slor);
						CarEntryCollection carEntry=carInfo.getEntry();
						for(int i=0;i<carEntry.size();i++){
							CarEntryInfo entry =carEntry.get(i);
							if(entry.isIsDefault()){
								prmtdriver.setValue(entry.getDriver());
								txtdriverPhone.setText(entry.getDriver().getDriverphone());
								break;
							}
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

		});



		this.prmtfarmer.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub
				setFilter();
				otherData(e);

			}

		});


		this.prmtfarm.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub
				setFilter();
				otherData(e);
				if(prmtfarm.getValue() != null){
					//根据养殖场自动带出该养殖场未结算的的批次合同
					try {
						FarmInfo farm = (FarmInfo) prmtfarm.getValue();
						farm = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(farm.getId()));
						if(farm.getCostCenter() != null){
							CostCenterOrgUnitInfo costCenInfo = CostCenterOrgUnitFactory.getRemoteInstance().getCostCenterOrgUnitInfo(new ObjectUuidPK(farm.getCostCenter(). getId()));
							prmtcostCenter.setValue(costCenInfo);
						}
						String s1 = "/*dialect*/ select fid contractStr  from T_FM_BatchContractBill  where CFIsRecSettled != 1 and FFarmID ='"+farm.getId()+"'";
						IRowSet r1;
						r1 = SQLExecutorFactory.getRemoteInstance(s1).executeSQL();
						String contractStr = null;
						if(r1.next()){
							contractStr = UIRuleUtil.getString(r1.getString("contractStr"));
							BatchContractBillInfo  contractInfo = BatchContractBillFactory.getRemoteInstance().getBatchContractBillInfo(new ObjectUuidPK(contractStr));
							//							editData.setBatchContract(contractInfo);
							prmtbatchContract.setValue(contractInfo);
						}
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (EASBizException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (SQLException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}

				}

				prmtchicWeighr.setQueryInfo("com.kingdee.eas.weighbridge.app.oneInStorageBillQuery");		
				prmtchicWeighr.setVisible(true);		
				prmtchicWeighr.setEditable(true);		
				prmtchicWeighr.setDisplayFormat("$number$;$number$");		
				prmtchicWeighr.setEditFormat("$number$;$number$");		
				prmtchicWeighr.setCommitFormat("$number$;$number$");
				prmtchicWeighr.setEnabledMultiSelection(true);
				prmtchicWeighr.setRequired(false);

			}

		});

		this.prmtbatchContract.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent e) {
				// TODO Auto-generated method stub
				setFilter();
				//批次改变带出其他数据
				otherData(e);

				if(prmtbatchContract.getValue()!= null){

					BatchContractBillInfo batchContractInfo = (BatchContractBillInfo) prmtbatchContract.getValue();

					// prmtchicWeighr		
					prmtchicWeighr.setQueryInfo("com.kingdee.eas.weighbridge.app.InStorageBillQuery");		
					prmtchicWeighr.setVisible(true);		
					prmtchicWeighr.setEditable(true);		
					prmtchicWeighr.setDisplayFormat("$number$;$number$");		
					prmtchicWeighr.setEditFormat("$number$;$number$");		
					prmtchicWeighr.setCommitFormat("$number$;$number$");
					prmtchicWeighr.setEnabledMultiSelection(true);
					prmtchicWeighr.setRequired(false);
					//毛鸡过磅单设置过滤
					EntityViewInfo evi=new EntityViewInfo();
					FilterInfo filter=new FilterInfo();
					filter.getFilterItems().add(new FilterItemInfo("batchContract.id",batchContractInfo.getId().toString(),CompareType.EQUALS));
					filter.getFilterItems().add(new FilterItemInfo("billStatus","4,6",CompareType.INCLUDE));
					filter.setMaskString("#0 and #1");
					evi.setFilter(filter);
					prmtchicWeighr.setEntityViewInfo(evi);
				}
				//毛鸡过磅单设置多选
				// prmtchicWeighr		
				prmtchicWeighr.setQueryInfo("com.kingdee.eas.weighbridge.app.oneInStorageBillQuery");		
				prmtchicWeighr.setVisible(true);		
				prmtchicWeighr.setEditable(true);		
				prmtchicWeighr.setDisplayFormat("$number$;$number$");		
				prmtchicWeighr.setEditFormat("$number$;$number$");		
				prmtchicWeighr.setCommitFormat("$number$;$number$");
				prmtchicWeighr.setEnabledMultiSelection(true);
				prmtchicWeighr.setRequired(false);
			}

		});

		kdtQCEntrys.addKDTMouseListener(new KDTMouseListener(){
			public void tableClicked(KDTMouseEvent e) {
				int rowIndex = e.getRowIndex();
				int colIndex = e.getColIndex();
				kdtQCEntrys.getColumn("actualWgt").getStyleAttributes().setLocked(true);
				kdtQCEntrys.getColumn("punishWgt").getStyleAttributes().setLocked(true);
				kdtQCEntrys.getColumn("actualRate").getStyleAttributes().setLocked(true);
				kdtQCEntrys.getColumn("punishAmt").getStyleAttributes().setLocked(true);
				if(kdtQCEntrys.getCell(rowIndex, "randPType").getValue()!=null){
					if(kdtQCEntrys.getCell(rowIndex, "randPType").getValue()==PunishType.forAmount){
						kdtQCEntrys.getColumn("actualRate").getStyleAttributes().setLocked(false);
						kdtQCEntrys.getColumn("punishAmt").getStyleAttributes().setLocked(false);
					}else{
						kdtQCEntrys.getColumn("actualWgt").getStyleAttributes().setLocked(false);
						kdtQCEntrys.getColumn("punishWgt").getStyleAttributes().setLocked(false);
					}
				}
			}			
		});

		kdtQCEntrys.addKDTEditListener(new KDTEditAdapter(){
			public void editStopped(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStopped(e);
				kdtEntrys_EditStopped(e.getRowIndex(),e.getColIndex());

				//计算B鸡重量
				BigDecimal BWeight = BigDecimal.ZERO;
				RewardAndPunishItemInfo randxInfo = null;
				for(int i =0,size = kdtQCEntrys.getRowCount();i<size;i++){
					randxInfo = (RewardAndPunishItemInfo) kdtQCEntrys.getCell(i,"QCItem").getValue();
					if(randxInfo.getRectype().equals(recType.PB)){
						BWeight = BWeight.add(UIRuleUtil.getBigDecimal(kdtQCEntrys.getCell(i, "punishWgt").getValue()));
					}
				}
				txtBWeight.setValue(BWeight);
			}
			public void editStarting(KDTEditEvent e) {
				// TODO Auto-generated method stub
				super.editStarting(e);
			}
		});

		kdtQCEntrys_detailPanel.addRemoveListener(new DetailPanelBackListener(){
			@Override
			public void afterEvent(DetailPanelEvent event) throws Exception {
				// TODO Auto-generated method stub
				super.afterEvent(event);
				calData();
			}
		});

		//销售类型添加监听事件
		saleType.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StockingComm.setCustomerFilterBySale(prmtcustomer, saleType.getSelectedItem()==null?null:(SaleBizType) saleType.getSelectedItem());
			}
		});



		setFilter();
	}

	/**
	 * 计算A鸡只数
	 * @param e
	 */
	protected void calcAQty() {
		txtAQty.setValue(UIRuleUtil.getBigDecimal(txtreceQty.getValue()).subtract(UIRuleUtil.getBigDecimal(txtBQty.getValue())));
	}

	/**
	 * 养殖户，养殖场，批次改变带出其他数据
	 * @param e
	 */
	protected void otherData(DataChangeEvent e) {
		// TODO Auto-generated method stub
		try {
			FarmerInfo farmerInfo = null;
			if(prmtfarmer.getValue() != null){
				farmerInfo = (FarmerInfo) prmtfarmer.getValue();
				farmerInfo = FarmerFactory.getRemoteInstance().getFarmerInfo(new ObjectUuidPK(farmerInfo.getId()));
				txtfarmerPhone.setText(farmerInfo.getMobileTel());
			}

			FarmInfo farmInfo = null;
			if(prmtfarm.getValue() != null){
				farmInfo = (FarmInfo) prmtfarm.getValue();
				farmInfo = FarmFactory.getRemoteInstance().getFarmInfo(new ObjectUuidPK(farmInfo.getId()));
				txtfarmAddress.setText(farmInfo.getAddress());
				farmType.setSelectedItem(farmInfo.getFaemsType());


			}

			if(prmtbatchContract.getValue() != null){
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
				String batchID=StockingComm.getBatchIDByContractID(null, contractID);
				if(StringUtils.isNotEmpty(batchID)) {
					this.prmtbatch.setValue(BatchFactory.getRemoteInstance().getBatchInfo(new ObjectUuidPK(batchID)));
				}else {
					this.prmtbatch.setValue(null);
				}

				pkinDate.setValue(contractInfo.getActualBreedDate());
				editData.setBatchQty(UIRuleUtil.getBigDecimal(contractInfo.getActualFemaleQty()));
				prmtperson.setValue(contractInfo.getPerson());



				kdtQCEntrys.removeRows();

				//根据批次合同对应的结算政策里面的奖惩政策分录里面的奖惩项目知道婆娘个设置到屠宰单的分录中 
				SettlePolicyInfo setIngo = contractInfo.getSettlementPolicy();
				SettlePolicyAwardsEntryCollection setEntryColl = setIngo.getAwardsEntry();
				//结算政策的奖惩的奖惩政策分录
				SettlePolicyAwardsEntryInfo setEntryInfo = null;
				//奖惩政策
				RandPPolicyInfo randInfo = null;
				for(int i=0,size = setEntryColl.size();i<size;i++){
					setEntryInfo = setEntryColl.get(i);
					setEntryInfo = SettlePolicyAwardsEntryFactory.getRemoteInstance().getSettlePolicyAwardsEntryInfo(new ObjectUuidPK(setEntryInfo.getId()));
					randInfo = RandPPolicyFactory.getRemoteInstance().getRandPPolicyInfo(new ObjectUuidPK(setEntryInfo.getRandPPolicy().getId()));
					RewardAndPunishItemInfo itemInfo = RewardAndPunishItemFactory.getRemoteInstance().getRewardAndPunishItemInfo(new ObjectUuidPK(randInfo.getRandPItem().getId()));
					kdtQCEntrys.addRow();
					kdtQCEntrys.getCell(i,"QCItem").setValue(itemInfo);
					kdtQCEntrys.getCell(i,"randPType").setValue(itemInfo.getPunishType());
				}
			}




		} catch (EASBizException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 


	}

	private void kdtEntrys_EditStopped(int rowIndex,int colIndex) {
		// TODO Auto-generated method stub	
		if(kdtQCEntrys.getCell(rowIndex, "randPType").getValue()!=null){
			if(kdtQCEntrys.getCell(rowIndex, "randPType").getValue()==PunishType.forAmount){
				kdtQCEntrys.getCell(rowIndex,"actualWgt").setValue(null);
				kdtQCEntrys.getCell(rowIndex,"punishWgt").setValue(null);
			}else{
				kdtQCEntrys.getCell(rowIndex,"actualRate").setValue(null);
				kdtQCEntrys.getCell(rowIndex,"punishAmt").setValue(null);
			}
		}else{
			kdtQCEntrys.getCell(rowIndex,"actualWgt").setValue(null);
			kdtQCEntrys.getCell(rowIndex,"punishWgt").setValue(null);
			kdtQCEntrys.getCell(rowIndex,"actualRate").setValue(null);
			kdtQCEntrys.getCell(rowIndex,"punishAmt").setValue(null);
		}





		calData();
	}

	private void calData() {
		// TODO Auto-generated method stub
		if(oprtState.equalsIgnoreCase("view")){
			return;
		}
		BigDecimal companyGross = UIRuleUtil.getBigDecimal(txtcompanyGross.getBigDecimalValue());
		BigDecimal companyTare = UIRuleUtil.getBigDecimal(txtcompanyTare.getBigDecimalValue());
		BigDecimal companySuttle = companyGross.subtract(companyTare);
		txtcompanySuttle.setValue(companySuttle);

		BigDecimal preHouseTare=UIRuleUtil.getBigDecimal(txtpreHouseTare.getBigDecimalValue());
		BigDecimal preHouseGross=UIRuleUtil.getBigDecimal(txtpreHouseGross.getBigDecimalValue());
		BigDecimal preHouseSuttle=preHouseGross.subtract(preHouseTare);
		txtpreHouseSuttle.setValue(preHouseSuttle);
		BigDecimal preHouseQty=UIRuleUtil.getBigDecimal(txtpreHouseQty.getBigDecimalValue());
		BigDecimal carcassQty=UIRuleUtil.getBigDecimal(txtcarcassQty.getBigDecimalValue());
		BigDecimal carcassWgt=UIRuleUtil.getBigDecimal(txtcarcassWgt.getBigDecimalValue());
		BigDecimal incompleteWgt=UIRuleUtil.getBigDecimal(txtincompleteWgt.getBigDecimalValue());
		BigDecimal incompleteQty=UIRuleUtil.getBigDecimal(txtincompleteQty.getBigDecimalValue());

		BigDecimal recQty=incompleteQty.add(carcassQty);
		txtrecQty.setValue(recQty.intValue());

		BigDecimal incompleteRate=preHouseSuttle.signum()==0?BigDecimal.ZERO:incompleteWgt.multiply(new BigDecimal(100)).divide(preHouseSuttle,2,RoundingMode.HALF_UP);
		txtincompleteRate.setValue(incompleteRate);

		int diffQty=recQty.subtract(preHouseQty).intValue();
		txtdiffQty.setValue(diffQty);

		calDataByJB();
		BigDecimal punishAmt=BigDecimal.ZERO;
		BigDecimal punishWgt=BigDecimal.ZERO;
		RewardAndPunishItemInfo randxInfo = null;
		for(int i=0;i<kdtQCEntrys.getRowCount();i++){
			punishAmt=UIRuleUtil.getBigDecimal(kdtQCEntrys.getCell(i,"punishAmt").getValue()).add(punishAmt);
			randxInfo = (RewardAndPunishItemInfo) kdtQCEntrys.getCell(i,"QCItem").getValue();
			//非B鸡类型奖惩项目
			if(!randxInfo.getRectype().equals(recType.PB)){
				punishWgt=UIRuleUtil.getBigDecimal(kdtQCEntrys.getCell(i,"punishWgt").getValue()).add(punishWgt);
			}
		}
		txtpunishAmt.setValue(punishAmt);
		//设置扣罚总重量
		txtpunishWgt.setValue(punishWgt);

		BigDecimal settleWgt=preHouseSuttle.subtract(punishWgt);
		txtsettleWgt.setValue(settleWgt);

		//毛鸡均重
		//		BigDecimal recSuttle = UIRuleUtil.getBigDecimal(txtrecSuttle.getBigDecimalValue());
		BigDecimal recSuttle = BigDecimal.ZERO;
		BigDecimal cAverageWgt=recQty.signum()==0?BigDecimal.ZERO:recSuttle.divide(recQty,2,RoundingMode.HALF_UP);
		txtcAverageWgt.setValue(cAverageWgt);
		//出肉率系数	
		BigDecimal dressingPercent = BigDecimal.ZERO;
		if(prmtFICompany.getValue()!=null&&prmtcustomer.getValue()!=null&&prmtbreedData.getValue()!=null){
			curCompanyID=((IPropertyContainer) this.prmtFICompany.getValue()).getString("id");
			String customerID=((IPropertyContainer) this.prmtcustomer.getValue()).getString("id");
			String breedDataID=((IPropertyContainer) this.prmtbreedData.getValue()).getString("id");
			dressingPercent=StockingComm.getDressingPercent(null, curCompanyID, customerID, breedDataID);
		}
		txtdressingPercent.setValue(dressingPercent);
		//出肉率
		BigDecimal meatRate=recSuttle.signum()==0?BigDecimal.ZERO:carcassWgt.multiply(dressingPercent).multiply(new BigDecimal(100)).divide(recSuttle,4,RoundingMode.HALF_UP);
		txtmeatRate.setValue(meatRate);
	}

	private void calDataByJB() {
		// TODO Auto-generated method stub
		try {
			storeFields();
			CSlaughterBillInfo cslInfo=editData;
			CSlaughterBillQCEntryCollection entrys = cslInfo.getQCEntrys();
			BigDecimal multiPunishWgt=BigDecimal.ZERO;
			for(int i=0;i<entrys.size();i++){
				CSlaughterBillQCEntryInfo entry=entrys.get(i);
				//					CSlaughterBillQCEntryFactory.getRemoteInstance().getCSlaughterBillQCEntryInfo(new ObjectUuidPK(entrys.get(i).getId()));
				String sql="select distinct t3.FFormulaTxt,t3.CFQCPWgtMultiple from T_FM_SettlePolicy t1 inner join T_FM_SettlePolicyAwardsEntry t2 on t2.fparentid=t1.fid " +
				" inner join CT_FM_RandPPolicy t3 on t3.fid=t2.CFRandPPolicyID " +
				" inner join CT_FM_RewardAndPunishItem t4 on t3.CFRandPItemID=t4.fid" +
				" where t1.fid='"+((IPropertyContainer)prmtsettlePolicy.getValue()).getString("id")+"'" +
				" and t4.fid='"+entry.getQCItem().getId().toString()+"' and t3.FCalType=5";
				IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
				if(rs.size()!=1){
					//					MsgBox.showWarning("未查询到自定义公式或查询到多个公式,请核查奖惩政策");
					//					SysUtil.abort();
				}else if(rs.next()){
					//计算脚本
					CoreBaseCollection cols=new CoreBaseCollection();
					cols.add(cslInfo);
					cols.add(entry);
					String jsTxt=rs.getString("FFormulaTxt");
					BigDecimal QCPWgtMultiple=UIRuleUtil.getBigDecimal(rs.getBigDecimal("CFQCPWgtMultiple"));
					jsTxt=StockingComm.getCalDealedFormulaTxt(jsTxt);
					BigDecimal value=StockingComm.getCalResultByJsTxt(null, cols, jsTxt);
					RewardAndPunishItemInfo item = entry.getQCItem();
					if(item.getPunishType()==PunishType.forAmount){
						value=value.setScale(2,RoundingMode.HALF_UP);//setScale用法  保留两位小数四舍五入
						entry.setPunishAmt(value);
					}else{
						value=value.setScale(2,RoundingMode.HALF_UP);
						entry.setPunishWgt(value);
						multiPunishWgt=multiPunishWgt.add(QCPWgtMultiple.signum()==0?BigDecimal.ZERO:value.divide(QCPWgtMultiple,2,RoundingMode.HALF_UP));
					}
				}
			}
			loadFields();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		f7Manager.registerBizCustomerF7(prmtcustomer, null, null, company);

		String farmerID="";
		String farmID="";

		farmerID=prmtfarmer.getValue()==null?"":((FarmerInfo)prmtfarmer.getValue()).getId().toString();
		farmID=prmtfarm.getValue()==null?"":((FarmInfo)prmtfarm.getValue()).getId().toString();

		//批次过滤
		StockingComm.setStockingBatchFilter(prmtbatch,curCompanyID,farmerID,farmID,true,false);
		//养殖户过滤
		StockingComm.setFarmerFilter(prmtfarmer, curCompanyID,false);
		//养殖场过滤
		StockingComm.setFarmFilter(prmtfarm, curCompanyID, farmerID,true);
		//合同过滤
		StockingComm.setBatchContractFilter(prmtbatchContract, curCompanyID,farmerID,farmID,true,true);


		//客户过滤
		StockingComm.setCustomerFilterBySale(prmtcustomer, saleType.getSelectedItem()==null?null:(SaleBizType) saleType.getSelectedItem());
		//车辆过滤
		StockingComm.setCarFilter(prmtcar, curCompanyID,null);
		//奖惩项目过滤
		String policyID ="";
		if(prmtsettlePolicy.getValue()!=null){
			policyID = ((IPropertyContainer)prmtsettlePolicy.getValue()).getString("id");	
		}	
		StockingComm.setRPItemFilterByBillType((KDBizPromptBox) kdtQCEntrys.getColumn("QCItem").getEditor().getComponent(),policyID, RandPScope.forQC);
		//运费计算点过滤
		StockingComm.setCalUnitFilter(prmtcalUnit, curCompanyID);
		//抓鸡队过滤
		StockingComm.setCatchCKTeamFilter(prmtcatchCKTeam, curCompanyID);
	}

	@Override
	protected void verifyInput(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.verifyInput(e);
		for(int i=0;i<kdtQCEntrys.getRowCount();i++){
			String itemIDi=((IPropertyContainer)kdtQCEntrys.getCell(i, "QCItem").getValue()).getString("id");
			for(int j=i+1;j<kdtQCEntrys.getRowCount();j++){
				String itemIDj=((IPropertyContainer)kdtQCEntrys.getCell(j, "QCItem").getValue()).getString("id");
				if(itemIDi.equals(itemIDj)){
					MsgBox.showWarning("分录项目重复!");
					SysUtil.abort();
				}
			}
		}			
	}

	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
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
		editData.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		editData.setNumber(CodingUtil.getNewNumberByCodingRule(null, editData));
		setOprtState("ADDNEW");
		setDataObject(editData);
		loadFields();
		showCopyAddNew();
		actionCopy.setEnabled(false);
		chkMenuItemSubmitAndAddNew.setVisible(true);
		setDefaultFocused();
		isLoadField=false;

		setMakeRelations(null);

	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillFactory.getRemoteInstance();
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
		com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillInfo objectValue = new com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillInfo();
		if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));

		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		return objectValue;
	}

	@Override
	public void storeFields() {
		// TODO Auto-generated method stub

		StringBuffer strID=new StringBuffer();
		StringBuffer strName=new StringBuffer();


		super.storeFields();

	}

}