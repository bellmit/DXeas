/**
 * output package name
 */
package com.kingdee.eas.custom.settlebill.client;

import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.Map;

import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.ListenerUtil;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.settlebill.SettleBillFacdeFactory;
import com.kingdee.eas.custom.settlebill.SettleBillFactory;
import com.kingdee.eas.custom.taihe.contract.BatchContractFactory;
import com.kingdee.eas.custom.taihe.contract.BatchContractInfo;
import com.kingdee.eas.custom.taihe.contract.SuccessiveContractCollection;
import com.kingdee.eas.custom.taihe.contract.SuccessiveContractFactory;
import com.kingdee.eas.custom.taihe.weight.CarSendBillInfo;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * output class name
 */
public class SettleBillEditUI extends AbstractSettleBillEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(SettleBillEditUI.class);

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
		ListenerUtil.F7RemoveDateChangeListener(prmtsendCars);
		super.loadFields();
		prmtsendCars.addDataChangeListener(new DataChangeListener(){

			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				if(prmtsendCars.getValue()!=null){
					CarSendBillInfo carSendBillInfo = (CarSendBillInfo)prmtsendCars.getValue();
//					if(carSendBillInfo.getBatchContract()!=null){
//						pkBizDate.setValue(carSendBillInfo.getRecycleDate());
//						BatchContractInfo batchContractInfo;
//						try {
//							SelectorItemCollection slor=new SelectorItemCollection();
//							slor.add("*");
//							slor.add("contractType.*");
//							batchContractInfo = BatchContractFactory.getRemoteInstance().getBatchContractInfo(new ObjectUuidPK(carSendBillInfo.getBatchContract().getString("id")),slor);
//							prmtbatchContract.setValue(batchContractInfo);
//							prmtcontractType.setValue(batchContractInfo.getContractType());
//							if(UIRuleUtil.isNotNull(batchContractInfo.getSuccessiveContract())){
//								SuccessiveContractCollection coll = SuccessiveContractFactory.getRemoteInstance().getSuccessiveContractCollection("where number='"+batchContractInfo.getSuccessiveContract()+"'");
//								if(coll.size()>0)
//									prmtseriousContract.setValue(coll.get(0));
//							}
//						} catch (EASBizException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						} catch (BOSException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
				}
			}});
	}
	/**
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();

		//数字字段具有显示
		KDFormattedTextField [] amtFields={txtfeedBaseQty,txtchickQty,txtfeedToMeat,txtsurvivalRate,txtmedicineUsage,txtdisinfectant,txtfeedingAmt,txtmedicineAmt,txtotherAmt,txtunitWeight,txttotalAmt,txtunitAmt,txtrebackCostAmt,txtrebackCostPrice,txtgrossDuckSalePrice,txtunitEatQty,txtyieldRate,txtchickAmt,txtchickCostAmt,txtdrugCostAmt,txtfeedCostAmt};
		for(int i=0;i<amtFields.length;i++)
			amtFields[i].setHorizontalAlignment(SwingConstants.RIGHT);

		String[] qtyFields={"quantity","weight"};
		for(int i=0;i<qtyFields.length;i++)
			kdtEntrys.getColumn(qtyFields[i]).getStyleAttributes().setHorizontalAlign(HorizontalAlignment.RIGHT);

		setPreferredSize(this.getToolkit().getScreenSize());

		btnVoucher.setVisible(true);
		btnDelVoucher.setVisible(true);
		btnTraceUp.setVisible(true);
		btnTraceDown.setVisible(true);

		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));


	}



	/**
	 * output actionSave_actionPerformed
	 */
	public void actionSave_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionSave_actionPerformed(e);
	}
	protected void refreshCurPage() throws EASBizException, BOSException, Exception {
		if (editData.getId() != null) {
			com.kingdee.bos.dao.IObjectPK iObjectPk = new ObjectUuidPK(editData.getId());
			IObjectValue iObjectValue = getValue(iObjectPk);
			setDataObject(iObjectValue);
			setSave(true);
		}
	}  
	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
	{
		super.actionSubmit_actionPerformed(e);
		refreshCurPage();
		MsgBox.showInfo("提交成功");
	}

	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		refreshCurPage();
		MsgBox.showInfo("审核成功");
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		refreshCurPage();
		MsgBox.showInfo("反审核成功");
	}

	/**
	 * output actionEdit_actionPerformed
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception
	{
		if(editData.getBillStatus().equals(com.kingdee.eas.custom.settlebill.billStatus.AUDIT))
			commUtils.giveUserTipsAndRetire("单据状态禁止编辑");
		super.actionEdit_actionPerformed(e);
	}


	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.settlebill.SettleBillFactory.getRemoteInstance();
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
		com.kingdee.eas.custom.settlebill.SettleBillInfo objectValue = new com.kingdee.eas.custom.settlebill.SettleBillInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		return objectValue;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void actionGetCostAmt_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		CompanyOrgUnitInfo company =null;
		AdminOrgUnitInfo admin = null;
		String lot=""; 
		if(prmtdepartment.getValue()!=null)
			company=(CompanyOrgUnitInfo) prmtdepartment.getValue();
		else
			commUtils.giveUserTipsAndRetire("部门不能为空");
		if(prmtfarmer.getValue()!=null)
			admin=(AdminOrgUnitInfo) prmtfarmer.getValue();
		else
			commUtils.giveUserTipsAndRetire("养殖户不能为空");
		if(prmtsendCars.getValue()!=null)
			admin=(AdminOrgUnitInfo) prmtsendCars.getValue();
		else
			commUtils.giveUserTipsAndRetire("派车单号不能为空");

		Map<String,BigDecimal[]> bigDecimalValues = SettleBillFacdeFactory.getRemoteInstance().getCostAmtOfMLY(company, lot, admin);
		if(bigDecimalValues==null)
			commUtils.giveUserTipsAndRetire("没有获取到相关的数据");
		if(bigDecimalValues.get("鸭苗成本")!=null){
			txtchickCostAmt.setValue(bigDecimalValues.get("鸭苗成本")[0]);
			txtchickQty.setValue(bigDecimalValues.get("鸭苗成本")[1]);
		}
		if(bigDecimalValues.get("饲料成本")!=null){
			txtfeedCostAmt.setValue(bigDecimalValues.get("饲料成本")[0]);
			txtfeedBaseQty.setValue(bigDecimalValues.get("饲料成本")[1]);
		}
		if(bigDecimalValues.get("药品成本")!=null)
			txtdrugCostAmt.setValue(bigDecimalValues.get("药品成本")[0]);
		if(editData.getId()!=null){
			SettleBillFactory.getRemoteInstance().save(editData);
		}
		commUtils.giveUserTipsAndRetire("金额和数量已获取并保存");
		super.actionGetCostAmt_actionPerformed(e);
	}
	/**
	 * 校验凭证标志
	 */
	@Override
	public void actionCheckVoucher_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		if(editData.getId()!=null){
			String str = "select * from T_BOT_Relation where FSrcObjectID='"+editData.getId().toString()+"'";
			str+=" and FDestEntityID='2652E01E'";
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(str).executeSQL();
			if(rs.size()==0){
				str="update T_SET_SettleBill set FFivouchered=0 where FID='"+editData.getId().toString()+"'";
				SettleBillFacdeFactory.getRemoteInstance().updateVoucherFlag(str);
			}
		}
	}

}