/**
 * output package name
 */
package com.kingdee.eas.custom.taihe.settle.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.swing.SwingConstants;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.master.cssp.SupplierFactory;
import com.kingdee.eas.basedata.master.cssp.SupplierInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.signwasthetable.ContractTypeFactory;
import com.kingdee.eas.custom.signwasthetable.ContractTypeInfo;
import com.kingdee.eas.custom.taihe.contract.BatchContractFactory;
import com.kingdee.eas.custom.taihe.contract.BatchContractInfo;
import com.kingdee.eas.custom.taihe.settle.CarcassDisrateCollection;
import com.kingdee.eas.custom.taihe.settle.CarcassDisrateFactory;
import com.kingdee.eas.custom.taihe.settle.CarcassDisrateInfo;
import com.kingdee.eas.custom.taihe.settle.ChickenDailyPriceCollection;
import com.kingdee.eas.custom.taihe.settle.ChickenDailyPriceFactory;
import com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyFactory;
import com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyInfo;
import com.kingdee.eas.custom.taihe.settle.SettleBillAssEntryInfo;
import com.kingdee.eas.custom.taihe.settle.StdCarassRateCollection;
import com.kingdee.eas.custom.taihe.settle.StdCarassRateFactory;
import com.kingdee.eas.custom.taihe.settle.StdCarassRateInfo;
import com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo;
import com.kingdee.eas.custom.taihe.weight.CarSendBillInfo;
import com.kingdee.eas.custom.taihe.weight.CarcassType;
import com.kingdee.eas.custom.taihe.weight.PurchaseType;
import com.kingdee.eas.custom.taihe.weight.TransportCoeCollection;
import com.kingdee.eas.custom.taihe.weight.TransportCoeFactory;
import com.kingdee.eas.custom.taihe.weight.TransportCoeInfo;
import com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class SettleBillEditUI extends AbstractSettleBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(SettleBillEditUI.class);
	private boolean isLoadField=false;
	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//��֯
	private static BigDecimal basketRate=new BigDecimal(12);
	protected static final BigDecimal stdCarcassRateDiff=new BigDecimal(0.01);//.setScale(2, BigDecimal.ROUND_HALF_UP);

	/**
	 * output class constructor
	 */
	public SettleBillEditUI() throws Exception
	{
		super();
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		isLoadField=true;
		super.loadFields();
		isLoadField=false;
		setFilter();
	}
	
	
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		
		//�Ƴ�����ҳǩ
		paneBIZLayerControl17.removeTabAt(0);
		
		CompanyF7 cf7=new CompanyF7();
		this.prmtcompany.setSelector(cf7);
		
		orgInfo = SysContext.getSysContext().getCurrentFIUnit();
		f7Manager = new F7ContextManager(this, OrgType.Company);
		f7Manager.registerBizSupplierF7(prmtpartyB, null, null, orgInfo);
		
		btnExecute.setIcon(EASResource.getIcon("imgTbtn_cal"));

		//�����ֶξ�����ʾ
		KDFormattedTextField [] amtFields={txtactualMiles,txtactualYieldRate,txtactulSettleFreAmt,txtcarcassSettleWgt,
				txtmarketPrice,txtpurchasePrice,txtqty,txtsafePrice,txtselfFrePrice,txtstdFrePrice,txtstdMiles,
				txtstdYeildRate,txtsuppFreAmt,txttotalSettleAmt,txttotalSettleWgt,txtyieldStd,txtactualFreAmt,txtpurchaseSettleAmt,
				txtchickenSzAmt,txtchickenSzQty,txtotherAmount,txtplusPrice,txtplusSettleWgt,txtchickenSzCoeff,txtawardsAmount,
				txtbasePrice,txthedingPrice,txtfixedCoeff,txtshareCoeff,txtchargeStd};
		for(int i=0;i<amtFields.length;i++)
			amtFields[i].setHorizontalAlignment(SwingConstants.RIGHT);
		
		txtstdYeildRate.setPrecision(4);
		txtactualYieldRate.setPrecision(4);

		KDTable[] tables={kdtEntrys,kdtAssEntrys,kdtOtherEntrys};
		for(int i=0;i<tables.length;i++)
			for(int j=0;j<tables[i].getColumnCount();j++)
				if(tables[i].getColumnKey(j).toString().endsWith("wgt")||tables[i].getColumnKey(j).toString().endsWith("qty")
						||tables[i].getColumnKey(j).toString().endsWith("Dis")||tables[i].getColumnKey(j).toString().endsWith("Wgt")
						||tables[i].getColumnKey(j).toString().endsWith("amount")||tables[i].getColumnKey(j).toString().endsWith("Rate")
						||tables[i].getColumnKey(j).toString().endsWith("price"))
					tables[i].getColumn(j).getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);

		btnVoucher.setVisible(true);
		btnDelVoucher.setVisible(true);
		btnTraceUp.setVisible(true);
		btnTraceDown.setVisible(true);
		
		kdtEntrys.getColumn("wghTime").getStyleAttributes().setNumberFormat("yyyy-MM-dd HH:mm:ss");
		
		prmtcarSendBill.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				sendCar_dataChanged(arg0);
			}
		}
		);
		pkrecycleDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				calDayAge();
				setPolicyFilter();
			}});
		pkinDate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				calDayAge();
			}})	;
		
		this.kdtOtherEntrys.addKDTEditListener(new KDTEditAdapter(){
			public void editStopped(KDTEditEvent e) {
				calOtherSumAmount();
			}});
		this.kdtAssEntrys.addKDTEditListener(new KDTEditAdapter(){
			public void editStopped(KDTEditEvent e) {
				kdtAssEntrys_editStoped(e.getRowIndex(),e.getColIndex());
			}});
		//ֻ��
		this.txtqty.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(isLoadField){
					return;
				}
			}});
		//�����ϵ��
		this.txtchickenSzCoeff.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(isLoadField){
					return;
				}
				calChickenSzAmt();
			}});
		//��ӿ۳����
		this.txtchickenSzAmt.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(isLoadField){
					return;
				}
				calChickenSzAmt();
			}});
		//�������
		this.txtchickenSzQty.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(isLoadField){
					return;
				}
				calChickenSzAmt();
			}});
		//�ۿ��׼
		this.txtchargeStd.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(isLoadField){
					return;
				}
				calChickenSzAmt();
			}});
		//��׼������
		txtstdYeildRate.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(isLoadField) {
					return;
				}
				calYeild();
			}});
		//ë������
		txttotalSettleWgt.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(isLoadField) {
					return;
				}
				calAcutalYeildRate();
				calPurchaseSettleAmt();
			}});
		//�����������
		txtcarcassSettleWgt.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(isLoadField) {
					return;
				}
				calFinalSettleAmt();
			}});
		
		//ë���ɹ����
		txtpurchasePrice.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(isLoadField) {
					return;
				}
				calChickenSzAmt();//�����
				calPurchaseSettleAmt();
			}});
		
		//�˷�
		txtactualFreAmt.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(isLoadField) {
					return;
				}
				calActulSettleFreAmt();
			}});
		//�����˷�
		txtselfFreAmt.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(isLoadField) {
					return;
				}
				calActulSettleFreAmt();
			}});
		//�����˷�
		txtsuppFreAmt.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(isLoadField) {
					return;
				}
				calActulSettleFreAmt();
			}});
		//���ͽ��
		txtawardsAmount.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				if(isLoadField) {
					return;
				}
				calFinalSettleAmt();
			}});
		prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setFilter();
			}})
		;
		
		prmtcontractType.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setPolicyFilter();
			}})
		;
		
		kdtOtherEntrys_detailPanel.getRemoveLinesButton().addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				calOtherSumAmount();
			}});
		
		prmtpartyB.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				supplierChanged();
				
			}});
		
//		//���ù�������
//		setFilter();
	}
	
	private void supplierChanged() {
//		if(prmtbatchContract.getValue()==null) {
			try {
//				if(prmtcompany.getValue()==null){
//					return;
//				}
				if(prmtpartyB.getValue()!=null){
					String companyID=prmtcompany.getValue()!=null?((IPropertyContainer) prmtcompany.getValue()).getString("id"):"123";
					String supplierID=((IPropertyContainer) prmtpartyB.getValue()).getString("id");
					StringBuffer sql=new StringBuffer();
					sql.append(" select ta.ftaxRegisterNo,tc.FPhone,tcb.FBank,tcb.FBankAccount ")
					.append(" from t_bd_supplier ta ")
					.append(" left join T_BD_SupplierCompanyInfo tc on tc.FSupplierID=ta.fid")
					.append(" left join  T_BD_SupplierCompanyBank tcb on tcb.FSupplierCompanyInfoID=tc.fid and tcb.fseq=1")
					.append(" where tc.FComOrgID='").append(companyID).append("'")
					.append(" and tc.FSupplierID='").append(supplierID).append("'")
					.append(" ");
					IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
					if(rs.next()) {
						txtiDCardNo.setText(rs.getString("ftaxRegisterNo"));
						txtaccountBank.setText(rs.getString("FBank"));
						txtbankAccount.setText(rs.getString("FBankAccount"));
					}
				}else{
					txtiDCardNo.setText(null);
					txtaccountBank.setText(null);
					txtbankAccount.setText(null);
				}
				
			}catch(Exception err) {
				err.printStackTrace();
			}
//		}
	}
	
	@Override
	public void prmtsettlePolicy_Changed() throws Exception {
		// TODO Auto-generated method stub
		if(isLoadField) {
			return;
		}
		super.prmtsettlePolicy_Changed();
	}
	private  void setFilter() {
		String companyID="";
		if(prmtcompany.getValue()!=null) {
			companyID=((IPropertyContainer) prmtcompany.getValue()).getString("id");
		}
		 EntityViewInfo ev=new EntityViewInfo();
		 FilterInfo filter=new FilterInfo();
		 filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
		 filter.getFilterItems().add(new FilterItemInfo("billStatus",BillBaseStatusEnum.AUDITED_VALUE,CompareType.EQUALS));
		 filter.getFilterItems().add(new FilterItemInfo("id","select distinct CFCarSendBillID from CT_SET_SettleBill "+(editData.getId()!=null?" where fid !='"+editData.getString("id")+"'":""),CompareType.NOTINNER));
		 Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MONTH,-1 );
		filter.getFilterItems().add(new FilterItemInfo("bizDate",cal.getTime(),CompareType.GREATER_EQUALS));
		 ev.setFilter(filter);
		 this.prmtcarSendBill.setEntityViewInfo(ev);
		
		 ev=new EntityViewInfo();
		 filter=new FilterInfo();
		 filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
		 filter.getFilterItems().add(new FilterItemInfo("billStatus",BillBaseStatusEnum.AUDITED_VALUE,CompareType.EQUALS));
		 ev.setFilter(filter);
		 prmtsuccessiveContract.setEntityViewInfo(ev);
		 prmtbatchContract.setEntityViewInfo(ev);
		 
		 setPolicyFilter();
		 
	}
	/**
	 * ���ý������ߡ��������߹�������
	 */
	private void setPolicyFilter() {
		String companyID="";
		if(prmtcompany.getValue()!=null) {
			companyID=((IPropertyContainer) prmtcompany.getValue()).getString("id");
		}
		String contractTypeID="";
		if(prmtcontractType.getValue()!=null) {
			contractTypeID=((IPropertyContainer) prmtcontractType.getValue()).getString("id");
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String recDate="1970-01-01";
		if(this.pkrecycleDate.getValue()!=null) {
			recDate=sdf.format(this.pkrecycleDate.getValue());
		}
		StringBuffer sql=new StringBuffer();
		sql.append(" select fid from T_SET_TaiHeSettlePolicy where fcompanyid='").append(companyID).append("'")
		.append(" and FBaseStatus=").append(UsedStatusEnum.APPROVED_VALUE)
		.append(" and FContractTypeID='").append(contractTypeID).append("'")
		.append(" and FEffectDate<={ts '").append(recDate).append(" 23:59:59'}")
		.append(" and FUnEffectDate>={ts '").append(recDate).append(" 00:00:00'}")
		;
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		 filter.getFilterItems().add(new FilterItemInfo("id",sql.toString(),CompareType.INNER));
		 ev.setFilter(filter);
		 this.prmtsettlePolicy.setEntityViewInfo(ev);
		 
		 sql.setLength(0);
		sql.append(" select fid from T_SET_SettleAwardPolicy where fcompanyid='").append(companyID).append("'")
		.append(" and FBaseStatus=").append(UsedStatusEnum.APPROVED_VALUE)
		.append(" and FContractTypeID='").append(contractTypeID).append("'")
		.append(" and FEffectDate<={ts '").append(recDate).append(" 23:59:59'}")
		.append(" and FUnEffectDate>={ts '").append(recDate).append(" 00:00:00'}")
		;
		ev=new EntityViewInfo();
		filter=new FilterInfo();
		 filter.getFilterItems().add(new FilterItemInfo("id",sql.toString(),CompareType.INNER));
		 ev.setFilter(filter);
		 this.prmtawardsPolicy.setEntityViewInfo(ev);
	}
	
	/**
	 * ���������˷�
	 */
	private void calSelfFreAmount() {
		BigDecimal selfPrice=this.txtselfFrePrice.getBigDecimalValue();
		BigDecimal actualMiles=this.txtactualMiles.getBigDecimalValue();
		if(selfPrice==null) {
			selfPrice=BigDecimal.ZERO;
		}
		if(actualMiles==null) {
			actualMiles=BigDecimal.ZERO;
		}
		this.txtselfFreAmt.setValue(selfPrice.multiply(actualMiles).setScale(2, BigDecimal.ROUND_HALF_UP));
		calActulSettleFreAmt();
	}
	                                      
	/**
	 * ����ʵ�ʽ����˷�
	 */
	private void calActulSettleFreAmt() {
		BigDecimal freAmt=this.txtactualFreAmt.getBigDecimalValue();
		if(freAmt==null) {
			freAmt=BigDecimal.ZERO;
		}
		//�����˷�
		BigDecimal suppAmt = txtsuppFreAmt.getBigDecimalValue();
		if(suppAmt==null) {
			suppAmt=BigDecimal.ZERO;
		}
		//�����˷�
		BigDecimal selfAmt=txtselfFreAmt.getBigDecimalValue();
		if(selfAmt==null) {
			selfAmt=BigDecimal.ZERO;
		}
		freAmt=freAmt.add(suppAmt).subtract(selfAmt).setScale(2, BigDecimal.ROUND_HALF_UP);
		this.txtactulSettleFreAmt.setValue(freAmt);
	}
	
	/**
	 * �����¼��Ϣ�޸�
	 * @param rowIndex
	 * @param colIndex
	 */
	private void kdtAssEntrys_editStoped(int rowIndex,int colIndex) {
		//�����ۺ�����
		if(kdtAssEntrys.getColumnKey(colIndex).equalsIgnoreCase("disRate")||kdtAssEntrys.getColumnKey(colIndex).equalsIgnoreCase("wgt")) {
			BigDecimal wgt=UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex, "wgt").getValue());
			BigDecimal rate=UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex, "disRate").getValue());
			kdtAssEntrys.getCell(rowIndex, "wgtAfterDis").setValue(wgt.multiply(rate).setScale(3,BigDecimal.ROUND_HALF_UP));
			
			calCarassSettleWgt();
		}
		if(kdtAssEntrys.getColumnKey(colIndex).equalsIgnoreCase("qty")) {
			BigDecimal sumQty=UIRuleUtil.getBigDecimal(this.kdtAssEntrys.getFootRow(0).getCell("qty").getValue());
			this.txtqty.setValue(sumQty);
//			this.txtbasketQty.setValue(sumQty.divide(basketRate,0,BigDecimal.ROUND_HALF_UP));
		}
		if(kdtAssEntrys.getColumnKey(colIndex).equalsIgnoreCase("disRate")||kdtAssEntrys.getColumnKey(colIndex).equalsIgnoreCase("wgt")||kdtAssEntrys.getColumnKey(colIndex).equalsIgnoreCase("settleRate")||kdtAssEntrys.getColumnKey(colIndex).equalsIgnoreCase("settleWgt")) {
			BigDecimal wgt=UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex, "wgtAfterDis").getValue());
			BigDecimal rate=UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex, "settleRate").getValue());
			if(rate.signum()>0){
				kdtAssEntrys.getCell(rowIndex, "settleWgt").setValue(wgt.divide(rate,4,BigDecimal.ROUND_HALF_UP));
			}else {
				kdtAssEntrys.getCell(rowIndex, "settleWgt").setValue(BigDecimal.ZERO);
			}
			calPurchaseSettleAmt();
		}
	}
	
	/**
	 * ���������������
	 */
	private void calCarassSettleWgt(){
		BigDecimal sumQty=BigDecimal.ZERO;
		for(int rowIndex=0;rowIndex<kdtAssEntrys.getRowCount();rowIndex++) {
			sumQty=sumQty.add(UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(rowIndex, "wgtAfterDis").getValue()));
		}
		this.txtcarcassSettleWgt.setValue(sumQty);
		calYeild();
		calAcutalYeildRate();
	}
	
	/**
	 * �������
	 */
	private void calYeild() {
		BigDecimal txtStdRate=this.txtstdYeildRate.getBigDecimalValue();
		if(txtStdRate==null) {
			txtStdRate=BigDecimal.ZERO;
		}
		if(txtStdRate.signum()<=0) {
			txtyieldStd.setValue(BigDecimal.ZERO);
			return;
		}
		BigDecimal txttotalSettleWgt=this.txttotalSettleWgt.getBigDecimalValue();
		if(txttotalSettleWgt==null) {
			txttotalSettleWgt=BigDecimal.ZERO;
		}
		//��׼����
		txtyieldStd.setValue(txttotalSettleWgt.multiply(txtStdRate).setScale(2,BigDecimal.ROUND_HALF_UP));
	}
	
	/**
	 * ����ʵ�ʳ�����
	 */
	private void calAcutalYeildRate() {	
		//����ǰ ȡʵ�ʳ�����,��ǰ����ʵ�ʳ�����
		if(!chkhouseBefore.isSelected()) {
			return;
		}
		BigDecimal wgt=txttotalSettleWgt.getBigDecimalValue();
		if(wgt==null) {
			wgt=BigDecimal.ZERO;
		}
		if(wgt.signum()<=0) {
			txtactualYieldRate.setValue(BigDecimal.ZERO);
			return;
		}
		
		BigDecimal cassWgt=txtcarcassSettleWgt.getBigDecimalValue();
		if(cassWgt==null) {
			cassWgt=BigDecimal.ZERO;
		}
	
		txtactualYieldRate.setValue(cassWgt.divide(wgt,4,BigDecimal.ROUND_HALF_UP));
	}
	
	
	/**
	 * ����ʵ�ʽ�����
	 */
	private void calOtherSumAmount() {
		BigDecimal sumOtherAmount=BigDecimal.ZERO;
		for(int index=0;index<kdtOtherEntrys.getRowCount();index++) {
			sumOtherAmount=sumOtherAmount.add(UIRuleUtil.getBigDecimal(kdtOtherEntrys.getCell(index, "amount").getValue()));
		}
		this.txtotherAmount.setValue(sumOtherAmount);
		calFinalSettleAmt();
	}
	
	public void sendCar_dataChanged(DataChangeEvent arg0) {
		// TODO Auto-generated method stub
		if(isLoadField) {
			return;
		}
//		if(prmtcarSendBill.getValue()!=null){
//			CarSendBillInfo carSendBillInfo = (CarSendBillInfo)prmtcarSendBill.getValue();
//			this.txtbasketQty.setValue(carSendBillInfo.getBasketQty());
//			if(carSendBillInfo.getBatchContract()!=null){
//				pkBizDate.setValue(carSendBillInfo.getRecycleDate());
//				BatchContractInfo batchContractInfo;
//				try {
//					SelectorItemCollection slor=new SelectorItemCollection();
//					slor.add("*");
//					slor.add("contractType.*");
//					slor.add("successiveContract.*");
//					batchContractInfo = BatchContractFactory.getRemoteInstance().getBatchContractInfo(new ObjectUuidPK(carSendBillInfo.getBatchContract().getString("id")),slor);
//					prmtbatchContract.setValue(batchContractInfo);
//					prmtcontractType.setValue(batchContractInfo.getContractType());
//					prmtsuccessiveContract.setValue(batchContractInfo.getSuccessiveContract());
//					
//				} catch (Exception e) {
//					handleException(e);
//				}
//			}else {
//				//Э�� 			�Ǻ�ͬ
//				try {
//					
//					String contractSql = "select FID from T_SIG_ContractType where FBillStatus = '1' and FName_l2 = 'Э��' ";
//					IRowSet rs = SQLExecutorFactory.getRemoteInstance(contractSql).executeSQL();
//					ContractTypeInfo cInfo = null;
//					if(rs.next()){
//						cInfo = ContractTypeFactory.getRemoteInstance().getContractTypeInfo(new ObjectUuidPK(rs.getString("FID")));
//					}
//					prmtbatchContract.setValue(null);
//					if(cInfo!=null){
//						prmtcontractType.setValue(cInfo);
//					}
//					
//					purchaseType.setSelectedItem(carSendBillInfo.getPurchaseType());
//					
//					prmtfarm.setValue(carSendBillInfo.getFarm());
//					txtfarmAddress.setText(carSendBillInfo.getFarmAddress());
//					txtfarmMnger.setText(carSendBillInfo.getFarmer());
//					SupplierInfo supplierInfo = SupplierFactory.getRemoteInstance().getSupplierInfo(new ObjectUuidPK(carSendBillInfo.getSupplier().getId()));
//					prmtpartyB.setValue(supplierInfo);
//					setPolicyFilter();
//				} catch (EASBizException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (BOSException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
//			//��һ�ι���ʱ��
//			pkrecycleDate.setValue(carSendBillInfo.getTareFirstTime());
//			//�չ�����
//			purchaseType.setSelectedItem(carSendBillInfo.getPurchaseType());
//			try {
//				prmtcar.setValue(UIRuleUtil.getProperty(carSendBillInfo,"car"));
//				prmtCarriageFormat.setValue(UIRuleUtil.getProperty(carSendBillInfo.getCar(), "CarSize"));
//			} catch (Exception e) {
//				handleException(e);
//			} 
//			chkhouseBefore.setSelected(carSendBillInfo.isHouseBefore());
//			calDayAge();
//		}
	}
	/**
	 * ��������
	 */
	private void calDayAge() {
		if(isLoadField) {
			return;
		}
		Date inDate=(Date) pkinDate.getValue();
		Date bizDate=(Date) pkrecycleDate.getValue();
		if(inDate==null||bizDate==null) {
			txtdayAge.setText("0");
			return;
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			inDate=sdf.parse(sdf.format(inDate));
			bizDate=sdf.parse(sdf.format(bizDate));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long timeDiff = bizDate.getTime()-inDate.getTime();
		timeDiff=timeDiff/1000/3600/24;
		txtdayAge.setText(String.valueOf( timeDiff));
	}
		
	@Override
	public void prmtbatchContract_Changed() throws Exception {
		// TODO Auto-generated method stub
		if(isLoadField) {
			return;
		}
		super.prmtbatchContract_Changed();
		if(prmtbatchContract.getValue()!=null) {
			if(prmtcompany.getValue()==null||
			!((IPropertyContainer) prmtcompany.getValue()).getString("id").equals(((IPropertyContainer) UIRuleUtil.getProperty((IObjectValue) prmtbatchContract.getValue(), "company")).getString("id"))
			) {
				if(MsgBox.showConfirm2("��ͬ��˾�뵱ǰ��˾��һ�£��Ƿ�����ͬ�ϵĽ������ߺͽ������ߣ�")!=MsgBox.YES){
					prmtsettlePolicy.setValue(null);
					prmtawardsPolicy.setValue(null);
				}
			}
		}
	}
	@Override
	public void prmtfarm_Changed() throws Exception {
		// TODO Auto-generated method stub
		if(isLoadField) {
			return;
		}
		super.prmtfarm_Changed();
	}
	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	@Override
	public void actionExecute_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionExecute_actionPerformed(e);
		if(pkrecycleDate.getValue()==null)
			commUtils.giveUserTipsAndRetire("�չ����ڲ���Ϊ��");
		if(prmtcompany.getValue()==null)
			commUtils.giveUserTipsAndRetire("��˾����Ϊ��");
		addWghData();
		//��ȡ��С������
		txtavgWgt.setValue(BigDecimal.ZERO);
		setStdCarcassRate();
		//��������������ʵ�ʳ��ɵ�
		calTotalSettleQtyAndAmount();
		//�ٸ���ƽ��ֻ��ȡ������
		setStdCarcassRate();
		setMarkedPrice();//�г�����
		calFreightAmount();//�����˷�
		calAwardAmt();//���㽱��
		calChickenSzAmt();//���㼦��ӽ��
		calFinalSettleAmt();//�������ս��
		//�������ƽ��ֻ��2018-01-04д
		if(txtchickenSzQty.getBigDecimalValue()!=null&&!txtchickenSzQty.getBigDecimalValue().equals(BigDecimal.ZERO)&&txtqty.getBigDecimalValue()!=null&&!txtqty.getBigDecimalValue().equals(BigDecimal.ZERO)){
			txtCSzAverageQty.setValue(txtchickenSzQty.getBigDecimalValue().divide(txtqty.getBigDecimalValue(),6,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(1000)));
		}
		MsgBox.showWarning("������ɣ�");
	}
	/**
	 * ���ñ�׼������
	 * @throws BOSException 
	 */
	private void setStdCarcassRate() throws BOSException {
		String companyID=((IPropertyContainer) prmtcompany.getValue()).getString("id");
		Date date=(Date)pkrecycleDate.getValue(); 
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String purType="123";
		if(this.purchaseType.getSelectedItem()!=null) {
			purType=((PurchaseType)this.purchaseType.getSelectedItem()).getValue();
		}
		StdCarassRateCollection cdpCols = StdCarassRateFactory.getRemoteInstance().getStdCarassRateCollection("where company='"+companyID+"' and baseStatus=2 "
				+" and effectDate<=('"+sdf.format(date)+" 23:59:59') and uneffectDate>=('"+sdf.format(date)+" 00:00:00')" +" and acquisitionType='"+purType+"'"		
				+" and houseBefore="+(chkhouseBefore.isSelected()?"1":"0")
		);
		if(!cdpCols.isEmpty()) {
//			txtstdYeildRate.setValue(cdpCols.get(0).getStdCarcassRate());
			
			//�޸ĸ���ƽ��ֻ��ȡ��׼������
			StdCarassRateInfo info = cdpCols.get(0);
			if(info.getEntry().size()<=0) {
				txtstdYeildRate.setValue(cdpCols.get(0).getStdCarcassRate());
				return;
			}
			BigDecimal avgWgt=UIRuleUtil.getBigDecimal(txtavgWgt.getBigDecimalValue());
			BigDecimal low,top;
			for(int index=0;index<info.getEntry().size();index++) {
				low=UIRuleUtil.getBigDecimal(info.getEntry().get(index).getLow());
				top=UIRuleUtil.getBigDecimal(info.getEntry().get(index).getTop());
				if(avgWgt.compareTo(low)>=0&&avgWgt.compareTo(top)<0) {
					txtstdYeildRate.setValue(info.getEntry().get(index).getRate());
					return;
				}
			}
		}
	}
	
	/**
	 * ȡ�г��۸�
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void setMarkedPrice() throws BOSException, EASBizException {
		if(prmtawardsPolicy.getValue()==null) {
			txtawardsAmount.setValue(BigDecimal.ZERO);
			return;
		}
		String companyID=((IPropertyContainer) prmtcompany.getValue()).getString("id");
		Date date=(Date)pkrecycleDate.getValue(); 
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		ChickenDailyPriceCollection cdpCols = ChickenDailyPriceFactory.getRemoteInstance().getChickenDailyPriceCollection("where company='"+companyID+"' and baseStatus=2 "
				+" and effectDate<=('"+sdf.format(date)+" 23:59:59') and uneffectDate>=('"+sdf.format(date)+" 00:00:00')"		
		);
		if(!cdpCols.isEmpty()) {
			txtmarketPrice.setValue(cdpCols.get(0).getPrice());
		}
	}
	
	/**
	 * ����ۿ��׼
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void calAwardAmt() throws BOSException, EASBizException {
		//ֱ��ȡ��������
		SettleAwardPolicyInfo tempInfo =(SettleAwardPolicyInfo) this.prmtawardsPolicy.getValue();
		if(tempInfo==null) {
			return;
		}
		
		SelectorItemCollection slor=new SelectorItemCollection();
		slor.add("*");
		slor.add("Entry.*");
		slor.add("AwardEntry.*");
		tempInfo=SettleAwardPolicyFactory.getRemoteInstance().getSettleAwardPolicyInfo(new ObjectUuidPK(tempInfo.getId()),slor);
		if(StringUtils.isNotBlank(tempInfo.getDAOImpl())) {
			try{
				Class cls = Class.forName(tempInfo.getDAOImpl());
				Method mtd = cls.getMethod("ExeCalSettleAmount",new Class[]{com.kingdee.eas.custom.taihe.settle.client.SettleBillEditUI.class});
				//ִ�н���
				mtd.invoke(cls.newInstance(),new Object[]{SettleBillEditUI.this});
			}catch(Exception err) {
				handleException(err);
			}
		}else {
			BigDecimal qty=txtqty.getBigDecimalValue();
			BigDecimal price=BigDecimal.ZERO;
			BigDecimal avgWgt=BigDecimal.ZERO;
			BigDecimal lowWgt,upperWgt;
			
			//���׺�ͬ
			if(tempInfo.getFlooredContractType()!=null&&((IPropertyContainer) prmtcontractType.getValue()).getString("id").equals(tempInfo.getFlooredContractType().getString("id"))) {
				BigDecimal safePrice=txtsafePrice.getBigDecimalValue();
				if(safePrice==null) {
					safePrice=BigDecimal.ZERO;
				}
				BigDecimal markedPrice=txtmarketPrice.getBigDecimalValue();
				if(markedPrice==null) {
					markedPrice=BigDecimal.ZERO;
				}
				//ȡ��Ľ��
				txtpurchasePrice.setValue(markedPrice.compareTo(safePrice)>0?markedPrice:safePrice);
				
				avgWgt=txtavgWgt.getBigDecimalValue();
				if(avgWgt==null) {
					avgWgt=BigDecimal.ZERO;
				}
				for(int index=0;index<tempInfo.getAwardEntry().size();index++) {
					//������Χ��
					lowWgt=tempInfo.getAwardEntry().get(index).getAvgWgtLower();
					upperWgt=tempInfo.getAwardEntry().get(index).getAvgWgtUpper();
					
					if(lowWgt==null) {
						lowWgt=BigDecimal.ZERO;
					}
					if(upperWgt==null) {
						upperWgt=new BigDecimal(99999);
					}
					//������Χ��
					if(lowWgt.compareTo(avgWgt)<0&&upperWgt.compareTo(avgWgt)>=0) {
						price=tempInfo.getAwardEntry().get(index).getAwardAmt();
						break;
					}
				}
				//���㽱�ͽ��
				txtawardsAmount.setValue(price.multiply(qty).setScale(2, BigDecimal.ROUND_HALF_UP));
			}
			//��ֵ��ͬ
			if(tempInfo.getFlooredContractType()!=null&&((IPropertyContainer) prmtcontractType.getValue()).getString("id").equals(tempInfo.getHedgingContractType().getString("id"))) {
				BigDecimal hedingPrice=txthedingPrice.getBigDecimalValue();//��ֵ�۸�
				if(hedingPrice==null) {
					hedingPrice=BigDecimal.ZERO;
				}
				BigDecimal markedPrice=txtmarketPrice.getBigDecimalValue();//�г��۸�
				if(markedPrice==null) {
					markedPrice=BigDecimal.ZERO;
				}
				//�г��۸�>��ֵ�۸�
				if(markedPrice.compareTo(hedingPrice)>0) {
					BigDecimal supplierProp=tempInfo.getSupplierProp();
					if(supplierProp==null) {
						supplierProp=BigDecimal.ZERO;
					}
					supplierProp=supplierProp.divide(new BigDecimal(100));//ԭ�ǳ���1000��2018-1-31��
					//��ֵ�۸���ϣ��г��۸��ȥ��ֵ�۸�
					price=hedingPrice.add(markedPrice.subtract(hedingPrice).multiply(supplierProp));
					txtpurchasePrice.setValue(price);
				}else {
					txtpurchasePrice.setValue(hedingPrice);
				}
			}
		}
	}
	
	/**
	 * �����չ����
	 */
	private void calPurchaseSettleAmt() {
		BigDecimal purchasePrice=txtpurchasePrice.getBigDecimalValue();
		BigDecimal settleWgt=txttotalSettleWgt.getBigDecimalValue();
		if(purchasePrice==null) {
			purchasePrice=BigDecimal.ZERO;
		}
		if(settleWgt==null) {
			settleWgt=BigDecimal.ZERO;
		}
		this.txtpurchaseSettleAmt.setValue(purchasePrice.multiply(settleWgt).setScale(2, BigDecimal.ROUND_HALF_UP));
		calFinalSettleAmt();
	}
	
	/**
	 * �������ս�����
	 */
	private void calFinalSettleAmt() {
		if(prmtsettlePolicy.getValue()!=null) {
			String DAOImplPatch=null;
			try {
				DAOImplPatch = (String) UIRuleUtil.getProperty((IObjectValue) prmtsettlePolicy.getValue(),"DAOImpl");
			} catch (Exception e) {
				e.printStackTrace();
			}
			//��������չ�� ��ִ�н���
			if(StringUtils.isBlank(DAOImplPatch)) {
				try {
					//�ű����������
					String jsTxt=(String) UIRuleUtil.getProperty((IObjectValue) prmtsettlePolicy.getValue(), "formulaTxt");
					if(StringUtils.isNotBlank(jsTxt)) {
						jsTxt=jsTxt.replaceAll("\n", " ");
						jsTxt=StockingComm.getCalDealedFormulaTxt(jsTxt);
						storeFields();
						CoreBaseCollection cols=new CoreBaseCollection();
						cols.add(editData);
						BigDecimal amount=StockingComm.getCalResultByJsTxt(null, cols, jsTxt);
						//������λ
						this.txttotalSettleAmt.setValue(amount.setScale(2, BigDecimal.ROUND_HALF_UP));
					}else {
						this.txttotalSettleAmt.setValue(BigDecimal.ZERO);
					}
				}catch(Exception err){
					handleException(err);
				}
			}else{
				try {
					Class cls = Class.forName(DAOImplPatch);
					Method mtd = cls.getMethod("ExeCalSettleAmount",new Class[]{com.kingdee.eas.custom.taihe.settle.client.SettleBillEditUI.class});
					//ִ�н���
					mtd.invoke(cls.newInstance(),new Object[]{SettleBillEditUI.this});
				} catch (Exception err) {
					handleException(err);
				}
			}
			
		}else {
			this.txttotalSettleAmt.setValue(BigDecimal.ZERO);
		}
	}
	
	/**
	 * ���㼦��ӽ��
	 */
	private void calChickenSzAmt() {
		//ֱ��ȡ��������
		SettleAwardPolicyInfo tempInfo =(SettleAwardPolicyInfo) this.prmtawardsPolicy.getValue();
		BigDecimal qty=txtqty.getBigDecimalValue();
		BigDecimal price=BigDecimal.ZERO;
		BigDecimal settleWgt=txtchickenSzQty.getBigDecimalValue();
		if(tempInfo!=null) {
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("chickenSzCoff");
			slor.add("Entry.*");
			slor.add("AwardEntry.*");
			try {
				tempInfo=SettleAwardPolicyFactory.getRemoteInstance().getSettleAwardPolicyInfo(new ObjectUuidPK(tempInfo.getId()),slor);
			} catch (Exception err) {
				handleException(err);
			}
			
			this.txtchickenSzCoeff.setValue(tempInfo!=null?tempInfo.getChickenSzCoff():BigDecimal.ZERO);
			

			if(qty==null) {
				qty=BigDecimal.ZERO;
			}
			if(settleWgt==null) {
				settleWgt=BigDecimal.ZERO;
			}
			BigDecimal avgWgt=BigDecimal.ZERO;
			if(qty.signum()>0){
				avgWgt=settleWgt.divide(qty,6,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(1000));
			}
			
			BigDecimal lowWgt,upperWgt;
			for(int index=0;index<tempInfo.getEntry().size();index++) {
				//������Χ��
				lowWgt=tempInfo.getEntry().get(index).getFloor();
				upperWgt=tempInfo.getEntry().get(index).getUp();
				
				if(lowWgt==null) {
					lowWgt=BigDecimal.ZERO;
				}
				if(upperWgt==null) {
					upperWgt=new BigDecimal(99999);
				}
				
				if(lowWgt.compareTo(avgWgt)<0&&upperWgt.compareTo(avgWgt)>=0) {
					price=tempInfo.getEntry().get(index).getAmt();
					break;
				}
			}
			if(price==null) {
				price=BigDecimal.ZERO;
			}
			//�ۿ��׼
			txtchargeStd.setValue(price.setScale(2,BigDecimal.ROUND_HALF_UP));
		}
		
		//�������
		BigDecimal wgt=this.txtchickenSzQty.getBigDecimalValue();
		if(wgt==null) {
			wgt=BigDecimal.ZERO;
		}
		//��ӿ���ϵ��
		BigDecimal coeff=this.txtchickenSzCoeff.getBigDecimalValue();
		if(coeff==null) {
			coeff=BigDecimal.ZERO;
		}
		if(qty==null) {
			qty=BigDecimal.ZERO;
		}
		//����ӣ������������/��ֻ��/1000)[������λС��] -���ϵ����* ��ֻ��*�ۿ��׼/1000
		BigDecimal amt=BigDecimal.ZERO;
//		if(qty.signum()>0) {
//			amt=wgt.multiply(new BigDecimal(1000)).divide(qty,2,BigDecimal.ROUND_HALF_UP).subtract(coeff);
//			//���ͽ��
//			BigDecimal chargeStd=txtchargeStd.getBigDecimalValue();
//			if(chargeStd==null) {
//				chargeStd=BigDecimal.ZERO;
//			}
//			amt=amt.multiply(qty).multiply(chargeStd).divide(new BigDecimal(1000),2,BigDecimal.ROUND_HALF_UP);
//		}
		
		/**
		 * �¿���ӱ�׼180508
		 * 1. ��Ҳ�����12g/ֻ
		 * 2. ��ֻ��ҳ���12g=(ʵ�ʿ���-12)*ֻ��*�չ��۸�*2*2
		 * �չ��۸�Ϊ����ë���չ��۸� Ԫ/kg
		 */
		//ƽ���������
		/*amt=BigDecimal.ZERO;
		if(qty.signum()>0){
			wgt=wgt.multiply(new BigDecimal(1000)).divide(qty,2,BigDecimal.ROUND_HALF_UP);
			wgt=wgt.subtract(new BigDecimal(12));
		}
		
		if(wgt.signum()>0&&qty.signum()>0){
			amt=wgt.multiply(qty).multiply(UIRuleUtil.getBigDecimal(txtpurchasePrice.getBigDecimalValue())).multiply(new BigDecimal(2)).multiply(new BigDecimal(2));
			amt=amt.divide(new BigDecimal(1000),2,BigDecimal.ROUND_HALF_UP);
		}*/
		
		/**
		 * ����ӱ�׼20180621
		 */
		amt=BigDecimal.ZERO;
		
		if(qty.signum()>0){
			wgt=wgt.multiply(new BigDecimal(1000)).divide(qty,3,BigDecimal.ROUND_HALF_UP);
		}else {
			wgt=BigDecimal.ZERO;
		}
		//��Ҫ�������
		boolean isNeedCalSzAmt=false;
		//Э�鼦
		if(purchaseType.getSelectedItem()==null) {
			MsgBox.showWarning("����д�չ����ͣ�");
			SysUtil.abort();
		}
		if(purchaseType.getSelectedItem().equals(PurchaseType.protocol)) {
			if(wgt.compareTo(new BigDecimal(15))>=0) {
				//isNeedCalSzAmt=true;
				//yumingxu20180622
//				BigDecimal avgWgt=UIRuleUtil.getBigDecimal(txtavgWgt.getBigDecimalValue());
//				
//				//ֻ��>2.5kg&&ƽ�����>=15
//				if(wgt.compareTo(new BigDecimal(15))>=0) {
//					//��ƽ����ӡ�15)*ֻ��*�չ��۸�*2	
					amt=wgt.subtract(new BigDecimal(15)).multiply(qty).multiply(UIRuleUtil.getBigDecimal(txtpurchasePrice.getBigDecimalValue())).multiply(new BigDecimal(2)).multiply(new BigDecimal(2));
					amt=amt.divide(new BigDecimal(1000),2,BigDecimal.ROUND_HALF_UP);
//				
//			}
				
			}
		}else {
			isNeedCalSzAmt=true;
		}

		
		if(isNeedCalSzAmt) {
			//ƽ��ֻ��
			BigDecimal avgWgt=UIRuleUtil.getBigDecimal(txtavgWgt.getBigDecimalValue());
			
			//ֻ��<=2.5kg&&ƽ�����>=12
			if(avgWgt.compareTo(new BigDecimal(2.5))<=0&&wgt.compareTo(new BigDecimal(12))>=0) {
				//��ƽ����ӡ�12)*ֻ��*�չ��۸�*2
				amt=wgt.subtract(new BigDecimal(12)).multiply(qty).multiply(UIRuleUtil.getBigDecimal(txtpurchasePrice.getBigDecimalValue())).multiply(new BigDecimal(2)).multiply(new BigDecimal(2));
				amt=amt.divide(new BigDecimal(1000),2,BigDecimal.ROUND_HALF_UP);
			}
			//ֻ��>2.5kg&&ƽ�����>=15
			else  if(avgWgt.compareTo(new BigDecimal(2.5))>0&&wgt.compareTo(new BigDecimal(15))>=0) {
				//��ƽ����ӡ�15)*ֻ��*�չ��۸�*2	
				amt=wgt.subtract(new BigDecimal(15)).multiply(qty).multiply(UIRuleUtil.getBigDecimal(txtpurchasePrice.getBigDecimalValue())).multiply(new BigDecimal(2)).multiply(new BigDecimal(2));
				amt=amt.divide(new BigDecimal(1000),2,BigDecimal.ROUND_HALF_UP);
			}
		}
		txtchickenSzAmt.setValue(amt.abs());
		
		calFinalSettleAmt();
	}
	
	
	/**
	 * ��ӹ�����¼��¼--�������
	 * @throws BOSException 
	 * @throws DataAccessException 
	 */
	private void addWghData() throws Exception {
		this.kdtAssEntrys.removeRows();
		kdtEntrys.removeRows();
		if(prmtcarSendBill.getValue()==null) {
			return;
		}
		if(prmtcarSendBill.getValue()!=null) {
			Date firstTime=(Date) UIRuleUtil.getProperty((IObjectValue) prmtcarSendBill.getValue(), "tareFirstTime");
			Date secondTime=(Date) UIRuleUtil.getProperty((IObjectValue) prmtcarSendBill.getValue(), "tareSecondTime");
			BigDecimal firstQty=(BigDecimal) UIRuleUtil.getProperty((IObjectValue) prmtcarSendBill.getValue(), "tareFirstQty");
			BigDecimal secondQty=(BigDecimal) UIRuleUtil.getProperty((IObjectValue) prmtcarSendBill.getValue(), "tareSecondQty");
			BigDecimal suttleQty=(BigDecimal) UIRuleUtil.getProperty((IObjectValue) prmtcarSendBill.getValue(), "tareWgt");
			IRow row1=null,row2=null;
			if(firstTime!=null) {
				row1=kdtEntrys.addRow();
				row1.getCell("wghTime").setValue(firstTime);
				row1.getCell("wgt").setValue(firstQty);
				
			}
			if(secondTime!=null) {
				row2=kdtEntrys.addRow();
				row2.getCell("wghTime").setValue(secondTime);
				row2.getCell("wgt").setValue(secondQty);	
			}
		}
		StringBuffer sql=new StringBuffer();
		sql.append(" select isnull(tbill.FChickenSZWgt,0) FChickenSZWgt,tentry.FCarcassType CFCarcassType,isnull(tentry.FWgt,0) CFSuttleWgt,isnull(tentry.FQty,0) CFQty from CT_WEI_Carcass tbill ")
		.append(" inner join T_WEI_CarcassEntrys tentry on tentry.fparentid=tbill.fid")
		.append(" where tbill.CFSendCarNumID='").append(((IPropertyContainer) prmtcarSendBill.getValue()).getString("id")).append("'")
		.append(" and tbill.FBillStatus=4")
		.append(" order by FbizDate desc")
		;
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		IRow row;
		BigDecimal sumQty=BigDecimal.ZERO;
		BigDecimal sumWgt=BigDecimal.ZERO;
		BigDecimal sumSzWgt=BigDecimal.ZERO;
		int colIndex=kdtAssEntrys.getColumnIndex("disRate");
		while(rs.next()) {
			/*row=kdtEntrys.addRow();
			row.getCell("billNum").setValue(rs.getString("fnumber"));
			row.getCell("billDate").setValue(rs.getDate("FbizDate"));
			row.getCell("wgtType").setValue(CarcassType.getEnum(rs.getString("CFCarcassType")));
			row.getCell("wgt").setValue(rs.getBigDecimal("CFSuttleWgt"));
			row.getCell("qty").setValue(rs.getBigDecimal("CFQty"));*/
			
			sumSzWgt=sumSzWgt.add(rs.getBigDecimal("FChickenSZWgt"));
			
			row=kdtAssEntrys.addRow();
			row.getCell("wgtType").setValue(CarcassType.getEnum(rs.getString("CFCarcassType")));
			row.getCell("wgt").setValue(rs.getBigDecimal("CFSuttleWgt"));
			row.getCell("qty").setValue(rs.getBigDecimal("CFQty"));
			
			row.setUserObject(new SettleBillAssEntryInfo());
			
			sumQty=sumQty.add(rs.getBigDecimal("CFQty"));
			sumWgt=sumWgt.add(rs.getBigDecimal("CFSuttleWgt"));//CFSuttleWgt
			
//			kdtAssEntrys_editStoped(row.getRowIndex(), colIndex);
		}
		this.txtqty.setValue(sumQty);
		this.txtcarcassSettleWgt.setValue(sumWgt);
		//��� ����
		if(UIRuleUtil.getBigDecimal(txtchickenSzQty.getBigDecimalValue()).signum()<=0) {
			txtchickenSzQty.setValue(sumSzWgt);
		}
		
		setTableToSumField();
		
		//����ʵ�ʳ�����
		this.txtcarcassSettleWgt.setValue(UIRuleUtil.getBigDecimal(kdtAssEntrys.getFootRow(0).getCell("wgtAfterDis").getValue()));
		calAcutalYeildRate();
		//����
//		this.txtbasketQty.setValue(sumQty.divide(basketRate,0,BigDecimal.ROUND_HALF_UP));
		
	}
	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.taihe.settle.SettleBillFactory.getRemoteInstance();
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
		com.kingdee.eas.custom.taihe.settle.SettleBillInfo objectValue = new com.kingdee.eas.custom.taihe.settle.SettleBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setBizDate(new Date());
		objectValue.setRecycleDate(new Date());
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		objectValue.setIsQualified(true);
		return objectValue;
	}
	@Override
	protected void setTableToSumField() {
		// TODO Auto-generated method stub
		setTableToSumField(kdtEntrys,new String[]{"wgt","qty"});
		setTableToSumField(kdtAssEntrys,new String[]{"wgt","qty","amount","wgtAfterDis","settleWgt"});
		setTableToSumField(kdtOtherEntrys,new String[]{"amount"});
	}
	@Override
	protected void setTableToSumField(KDTable arg0, String[] arg1) {
		// TODO Auto-generated method stub
		super.setTableToSumField(arg0, arg1);
	}

	/**
	 * �����ܵĽ����������
	 */
	private void calTotalSettleQtyAndAmount() {
		//��ȡ���ɱ�׼ϵ��--���ݻ�������
		Date date=(Date)pkrecycleDate.getValue();
		CompanyOrgUnitInfo companyOrgUnitInfo = (CompanyOrgUnitInfo)prmtcompany.getValue();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		CarcassDisrateCollection coll = null;
		try {
			coll = CarcassDisrateFactory.getRemoteInstance().getCarcassDisrateCollection("where company='"+companyOrgUnitInfo.getString("id")
					+"' and effectDate<=('"+sdf.format(date)+" 23:59:59') and uneffectDate>=('"+sdf.format(date)+" 00:00:00') and baseStatus=2 and purchaseType="
			 +((PurchaseType)this.purchaseType.getSelectedItem()).getValue()
			+" and houseBefore="+(chkhouseBefore.isSelected()?"1":"0") 
			);
		} catch (BOSException e) {
			commUtils.giveUserTipsAndRetire(e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber()+"\n"+e.getCause().getMessage());
		}
		if(coll.size()==0)
			commUtils.giveUserTipsAndRetire("û���ҵ���������ϵ��");

		CarcassDisrateInfo info = coll.get(0);
		HashMap<CarcassType,BigDecimal> map=new HashMap<CarcassType, BigDecimal>(); 
		for(int i=0;i<info.getDisRateEntry().size();i++){
			map.put(info.getDisRateEntry().get(i).getWgtType(), info.getDisRateEntry().get(i).getDisRate());
		}

		CarcassType carcassType = null;
		BigDecimal qty=BigDecimal.ZERO;
		BigDecimal wgt=BigDecimal.ZERO;
		BigDecimal avgWgt = BigDecimal.ZERO;
		BigDecimal afteWgtDis=BigDecimal.ZERO;
		BigDecimal rate,settleRate = BigDecimal.ZERO;//����ϵ�����������ϵ��
		BigDecimal sumWgt=BigDecimal.ZERO;
//		IRowSet rs;
		for(int i=0;i<kdtAssEntrys.getRowCount();i++){
			//�ۿ���
			if(kdtAssEntrys.getCell(i, "wgtType").getValue()!=null){
				carcassType = (CarcassType)kdtAssEntrys.getCell(i, "wgtType").getValue();
				if(map.containsKey(carcassType)){
					kdtAssEntrys.getCell(i, "disRate").setValue(map.get(carcassType));
				}else{
					continue;
				}
			}

			//�ۿۺ�����
			wgt=UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(i, "wgt").getValue());
			sumWgt=sumWgt.add(wgt);
//			qty=UIRuleUtil.getBigDecimal(kdtAssEntrys.getCell(i, "qty").getValue());
//			if(qty.compareTo(BigDecimal.ZERO)==0)
//				continue;
//			avgWgt=wgt.divide(qty,2,BigDecimal.ROUND_HALF_EVEN);
			
			rate=map.get(carcassType).setScale(10, BigDecimal.ROUND_HALF_UP);
			afteWgtDis = wgt.multiply(map.get(carcassType)).setScale(8, BigDecimal.ROUND_HALF_UP);
			kdtAssEntrys.getCell(i, "disRate").setValue(rate);
			kdtAssEntrys.getCell(i, "wgtAfterDis").setValue(afteWgtDis);
			//�˷�������ʹ�� Comments@20171107
			/*for(int index=0;index<info.getEntry().size();index++) {
				if(avgWgt.compareTo(info.getEntry().get(index).getAvgWgtCell())>=0&&avgWgt.compareTo(info.getEntry().get(index).getAvgWgtFloor())<=0) {
					settleRate=info.getEntry().get(index).getRate();
					kdtAssEntrys.getCell(i, "settleRate").setValue(settleRate);
					kdtAssEntrys.getCell(i, "settleWgt").setValue(afteWgtDis.divide(settleRate,4,BigDecimal.ROUND_HALF_UP));
					break;
				}
			}*/
		}
		//��������
		txtcarcassSettleWgt.setValue(UIRuleUtil.getBigDecimal(kdtAssEntrys.getFootRow(0).getCell("wgtAfterDis").getValue()));
		//��������--ë������ Comments@20171107
//		txttotalSettleWgt.setValue(UIRuleUtil.getBigDecimal(kdtAssEntrys.getFootRow(0).getCell("settleWgt").getValue()));
		
		//ë����������������1λС������λΪ���=��С��ë��/2+��ͷ+��β+�����أ�/ֻ�ض�Ӧ�ı�׼�����ʣ�ʵ�ʳ����ʣ�
	
		qty=UIRuleUtil.getBigDecimal(txtqty.getBigDecimalValue());
		BigDecimal  stdYeild=txtstdYeildRate.getBigDecimalValue();
		if(stdYeild==null) {
			stdYeild=BigDecimal.ZERO;
		}
		//ƽ��ֻ�أ�����3λС������λΪ���=����ǰ����/ֻ��[����ֻ��+С��ֻ��]/��׼������
		if(qty.signum()>0&&stdYeild.signum()>0) {
			avgWgt=sumWgt.divide(qty.multiply(stdYeild),3,BigDecimal.ROUND_HALF_UP);
		}else {
			avgWgt=BigDecimal.ZERO;
		}
		txtavgWgt.setValue(avgWgt);
		for(int index=0;index<info.getEntry().size();index++) {
			if(avgWgt.compareTo(info.getEntry().get(index).getAvgWgtCell())>=0&&avgWgt.compareTo(info.getEntry().get(index).getAvgWgtFloor())<0) {
				settleRate=info.getEntry().get(index).getRate();
				break;
			}
		}
		//����ǰ ȡʵ�ʳ�����
		if(!chkhouseBefore.isSelected()) {
			BigDecimal carcassSettleWgt=txtcarcassSettleWgt.getBigDecimalValue();
			if(carcassSettleWgt==null) {
				carcassSettleWgt=BigDecimal.ZERO;
			}
			if(settleRate!=null&&settleRate.signum()>0) {
				carcassSettleWgt=carcassSettleWgt.divide(settleRate,2,BigDecimal.ROUND_HALF_UP);
			}else {
				carcassSettleWgt=BigDecimal.ZERO;
			}
			txtactualYieldRate.setValue(settleRate);
			txttotalSettleWgt.setValue(carcassSettleWgt.setScale(2,BigDecimal.ROUND_HALF_UP));
		}
		
		calPurchaseSettleAmt();
	}
	/**
	 * �����˷�
	 */
	private void calFreightAmount() {
		// TODO Auto-generated method stub
		/*if(prmtsettlePolicy) {
			
		}*/
		//����
		BigDecimal basketQty = UIRuleUtil.getBigDecimal(txtbasketQty.getBigDecimalValue());
		//ʵ�����
		BigDecimal actualMiles = UIRuleUtil.getBigDecimal(txtactualMiles.getBigDecimalValue());
		/*//��׼���
		BigDecimal stdMiles = UIRuleUtil.getBigDecimal(txtstdMiles.getBigDecimalValue());
		
		if(actualMiles.compareTo(stdMiles)>0&&stdMiles.signum()>0) {
			actualMiles=stdMiles;
		}*/
		
		//��������
		BigDecimal wgt = UIRuleUtil.getBigDecimal(txttotalSettleWgt.getBigDecimalValue());

		//��������
		Date date=(Date)pkrecycleDate.getValue();
		CompanyOrgUnitInfo companyOrgUnitInfo = (CompanyOrgUnitInfo)prmtcompany.getValue();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		BigDecimal carcassPrice=BigDecimal.ZERO;//�����˷�-���嵥��
		//�˷�ϵ��
		try {
			TransportCoeCollection coll = TransportCoeFactory.getRemoteInstance()
			.getTransportCoeCollection("where company='"+companyOrgUnitInfo.getString("id")+"' and beginDate<=('"+sdf.format(date)+" 23:59:59') and endDate>=('"+sdf.format(date)+" 00:00:00') and baseStatus=2");
			if(coll.size()>0){
				TransportCoeInfo coeInfo = coll.get(0);
				txtactualFreAmt.setValue(getAmountByFrePolicy(coeInfo, actualMiles, basketQty, wgt));
				carcassPrice=coeInfo.getCarcassPrice();
			}
		} catch (BOSException e) {
			e.printStackTrace();
			commUtils.giveUserTipsAndRetire(e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber()+"\n"+e.getCause().getMessage());
		}
		calActulSettleFreAmt();
		
		//���㲹���˷�
		if(chkhouseBefore.isSelected()) {
			BigDecimal stdCarcassRate=txtstdYeildRate.getBigDecimalValue();
			BigDecimal actualCarcassRate=txtactualYieldRate.getBigDecimalValue();
			BigDecimal settleWgt=txttotalSettleWgt.getBigDecimalValue();
			if(stdCarcassRate==null) {
				stdCarcassRate=BigDecimal.ZERO;	
			}
			if(actualCarcassRate==null) {
				actualCarcassRate=BigDecimal.ZERO;	
			}
			if(settleWgt==null) {
				settleWgt=BigDecimal.ZERO;	
			}
			if(carcassPrice==null) {
				carcassPrice=BigDecimal.ZERO;
			}
			BigDecimal diffRate=actualCarcassRate.subtract(stdCarcassRate);
			if(diffRate.compareTo(stdCarcassRateDiff)>=0) {
				diffRate=stdCarcassRateDiff;
			}
			//�۲��˷�= �����嵥�ۡ�*ë��/100*�����ʲ�
			diffRate=(carcassPrice.multiply(settleWgt).multiply(diffRate)).setScale(2,BigDecimal.ROUND_HALF_UP);//.divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_UP);
			txtsuppFreAmt.setValue(diffRate);
		}
	}
	/**
	 * �����˷����ߣ���̻�ȡ�˷�
	 * @param miles
	 */
	private BigDecimal getAmountByFrePolicy(TransportCoeInfo coeInfo,BigDecimal miles,BigDecimal basketQty,BigDecimal wgt) {
		BigDecimal amount=BigDecimal.ZERO,currentMiles;
		BigDecimal topKm,lowKm;
		BigDecimal lowCage,topCage;
		BigDecimal calWgt;//��������
		wgt=wgt.divide(new BigDecimal(1000));
		for(int i=0;i<coeInfo.getEntry().size();i++){ 
			lowCage=UIRuleUtil.getBigDecimal(coeInfo.getEntry().get(i).getLowCage());
			topCage=UIRuleUtil.getBigDecimal(coeInfo.getEntry().get(i).getTopCage());
			//�����ڷ�Χ��
			if(lowCage.compareTo(basketQty)<0&&topCage.compareTo(basketQty)>=0){
				//						if((coeInfo.getEntry().get(i).getLowKm()==null||actualMiles.compareTo(coeInfo.getEntry().get(i).getLowKm())>=0)&&(coeInfo.getEntry().get(i).getTopKm()==null||actualMiles.compareTo(coeInfo.getEntry().get(i).getTopKm())<=0)){
				//������>=ʵ�����>������
				topKm=UIRuleUtil.getBigDecimal(coeInfo.getEntry().get(i).getTopKm());
				lowKm=UIRuleUtil.getBigDecimal(coeInfo.getEntry().get(i).getLowKm());
				if(topKm.compareTo(miles)>=0&&lowKm.compareTo(miles)<0){
					currentMiles=miles;//.subtract(UIRuleUtil.getBigDecimal(coeInfo.getEntry().get(i).getLowKm()));
					calWgt=UIRuleUtil.getBigDecimal(coeInfo.getEntry().get(i).getSafeTon());
					if(calWgt.compareTo(wgt)<0) {
						calWgt=wgt;
					}
					if(coeInfo.getEntry().get(i).isUseTon()){
						amount=coeInfo.getEntry().get(i).getFreightPrice().multiply(calWgt);
					}else if(coeInfo.getEntry().get(i).isUserKm()){
						amount=coeInfo.getEntry().get(i).getFreightPrice().multiply(currentMiles);
					}else if(coeInfo.getEntry().get(i).isUserTonKm()){
						amount=coeInfo.getEntry().get(i).getFreightPrice().multiply(currentMiles).multiply(calWgt);
					}
					break;
				}else{
					/*currentMiles=UIRuleUtil.getBigDecimal(coeInfo.getEntry().get(i).getTopKm()).subtract(UIRuleUtil.getBigDecimal(coeInfo.getEntry().get(i).getLowKm()));
					if(coeInfo.getEntry().get(i).isUseTon()){
						amount=amount.add(coeInfo.getEntry().get(i).getFreightPrice().multiply(wgt));
					}else if(coeInfo.getEntry().get(i).isUserKm()){
						amount=amount.add(coeInfo.getEntry().get(i).getFreightPrice().multiply(currentMiles));
					}else if(coeInfo.getEntry().get(i).isUserTonKm()){
						amount=amount.add(coeInfo.getEntry().get(i).getFreightPrice().multiply(currentMiles).multiply(wgt));
					}*/
				}
			}
		}
		return amount.setScale(2, BigDecimal.ROUND_HALF_UP);//.divide(new BigDecimal(1000),2,BigDecimal.ROUND_HALF_UP)
	}
}