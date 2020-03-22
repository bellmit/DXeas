/**
 * output package name
 */
package com.kingdee.eas.custom.bsxbudget.client;

import java.awt.Toolkit;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.EventListener;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;

/**
 * output class name
 */
public class BSXBudgetFoodEditUI extends AbstractBSXBudgetFoodEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(BSXBudgetFoodEditUI.class);

	/**
	 * output class constructor
	 */
	public BSXBudgetFoodEditUI() throws Exception
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
	 * output storeFields method
	 */
	public void storeFields()
	{
		super.storeFields();
	}

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
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.bsxbudget.BSXBudgetFoodFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{

		return null;
	}

	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setUITitle("食品公司预算");
	}


	/**
	 * 根据会计期间获得毛鸡收购总重量
	 * @param periodInfo   会计期间
	 */
	private BigDecimal getTotalWeight(PeriodInfo periodInfo){
		if(periodInfo==null){
			MsgBox.showWarning("会计期间为空");
			abort();
		}
		try {
			BigDecimal totalWeight=com.kingdee.eas.custom.bsxbudget.BSXBudgetFacadeFactory.getRemoteInstance().getTotalWeightFromBugetFeed(periodInfo);
			if(totalWeight!=null)
				return totalWeight;
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.bsxbudget.BSXBudgetFoodInfo objectValue = new com.kingdee.eas.custom.bsxbudget.BSXBudgetFoodInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));

		objectValue.setBizDate(new Date());

				//加载当前会计期间
				PeriodInfo periodInfo = null;
				try {
					periodInfo = com.kingdee.eas.custom.bsxbudget.BSXBudgetFacadeFactory.getRemoteInstance().getCurrentPeriod();
					if(periodInfo==null)
						MsgBox.showInfo("自动获取当前会计期间失败，请手工填写当前会计期间");
					else
						objectValue.setPeriod(periodInfo);
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


		return objectValue;
	}

	/**以下方法均是不得已而为之，属性更新方法对于运算顺序，没有较好的适应，所以从父类方法粘贴至此并修改*/


	@Override
	protected void btnGetTotalWeight_mouseClicke(MouseEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(prmtperiod.getValue()==null){
			MsgBox.showInfo("期间为空");
			abort();
		}
		PeriodInfo periodInfo=(PeriodInfo) prmtperiod.getValue();
		if(periodInfo!=null){
			String[] amt;
			try {
				amt = com.kingdee.eas.custom.bsxbudget.BSXBudgetFacadeFactory.getRemoteInstance().getInventoryValue(periodInfo);
				if(amt[0]!=null&&amt[1]!=null){
					txtstockAmtAtMonthBegin.setValue(new BigDecimal(amt[1]));
					txtstockAtMonthBegin.setValue(new BigDecimal(amt[0]));
				}
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		//从养殖预算中干活去收购毛鸡总重量
		if(null!=getTotalWeight(periodInfo)){
			txttotalWeight.setValue(getTotalWeight(periodInfo));
			txttotolCost.setValue(getTotalCostByPurchaseChicken());
			txtyield.setValue(getYieldWeight());
			txtexpectedRec.setValue(getYieldWeight());
			txtpredictRecAmt.setValue(getInInventoryAmt());
			txtexpectedSaleCost.setValue(getSalesCost());
			txtexpectedsalesCostPerKG.setValue(getSalesCostPerUnit());
			txtsaleProfit.setValue(getSalesProfit());
			txtcompanyProfit.setValue(getCompanyProfit());
		}
		else{
			MsgBox.showInfo("未获取到当前期间养殖预算的毛鸡收购重量");
		}
		super.btnGetTotalWeight_mouseClicke(e);
	}



	/**
	 * 预计销量事件处理
	 */
	@Override
	protected void txtexpectedSalesAmt_dataChange(DataChangeEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		txtexpectedSalesRevenue.setValue(getSalesRevenue());
		txtsaleProfit.setValue(getSalesProfit());//销售毛利		
		txtcompanyProfit.setValue(getCompanyProfit());//公司利润
		super.txtexpectedSalesAmt_dataChange(e);
	}
	/**
	 * 销售收入
	 */
	private BigDecimal getSalesRevenue(){
		BigDecimal sum = BigDecimal.ZERO;
		if(txtexpectedSalesAmt.getBigDecimalValue()!=null)
			sum=txtexpectedSalesAmt.getBigDecimalValue();
		else
			return null;
		if(txtexpectedPricePerTon.getBigDecimalValue()!=null)
			sum=txtexpectedPricePerTon.getBigDecimalValue().multiply(sum);
		else
			return null;
		return sum;
	}
	/**
	 * 销售毛利
	 */
	private BigDecimal getSalesProfit(){
		BigDecimal sum = BigDecimal.ZERO;
		if(txtexpectedSalesRevenue.getBigDecimalValue()!=null)
			sum=sum.add(txtexpectedSalesRevenue.getBigDecimalValue());
		if(txtexpectedSaleCost.getBigDecimalValue()!=null)
			sum=sum.subtract(txtexpectedSaleCost.getBigDecimalValue());
		return sum;
	}
	/**
	 * 预计入库价值
	 * @return
	 */
	private BigDecimal getInInventoryAmt(){
		BigDecimal sum = BigDecimal.ZERO;
		if(txttotolCost.getBigDecimalValue()!=null)
			sum=txttotolCost.getBigDecimalValue();
		if(txtproductCost.getBigDecimalValue()!=null)
			sum=(sum.multiply(new BigDecimal("0.87"))).add(txtproductCost.getBigDecimalValue());
		return sum;
	}
	/**
	 * 食品公司利润
	 * @return
	 */
	private BigDecimal getCompanyProfit(){
		BigDecimal sum = BigDecimal.ZERO;
		if(txtexpectedSalesRevenue.getBigDecimalValue()!=null)
			sum=sum.add(txtexpectedSalesRevenue.getBigDecimalValue());
		if(txtexpectedSaleCost.getBigDecimalValue()!=null)
			sum=sum.subtract(txtexpectedSaleCost.getBigDecimalValue());
		if(txtFIFee.getBigDecimalValue()!=null)
			sum=sum.subtract(txtFIFee.getBigDecimalValue());
		if(txtsaleFee.getBigDecimalValue()!=null)
			sum=sum.subtract(txtsaleFee.getBigDecimalValue());
		if(txtmanageFee.getBigDecimalValue()!=null)
			sum=sum.subtract(txtmanageFee.getBigDecimalValue());
		return sum;
	}
	/**
	 * 毛鸡收购总成本
	 * @return
	 */
	private BigDecimal getTotalCostByPurchaseChicken(){
		if(txtpricePerKG.getBigDecimalValue()!=null&&txttotalWeight.getBigDecimalValue()!=null)
			return txtpricePerKG.getBigDecimalValue().multiply(txttotalWeight.getBigDecimalValue());
		else
			return null;
	}
	/**
	 * 销售成本
	 * @return
	 */
	private BigDecimal getSalesCost(){
		BigDecimal sum = BigDecimal.ZERO;
		if(txttotolCost.getBigDecimalValue()!=null)
			sum=txttotolCost.getBigDecimalValue();
		if(txtproductCost.getBigDecimalValue()!=null)
			sum=(sum.multiply(new BigDecimal("0.87"))).add(txtproductCost.getBigDecimalValue());
		if(txtstockAmtAtMonthBegin.getBigDecimalValue()!=null)
			sum=sum.add(txtstockAmtAtMonthBegin.getBigDecimalValue());
		return sum;
	}
	/**
	 * 单位销售成本
	 * @return
	 */
	private BigDecimal getSalesCostPerUnit(){
		BigDecimal totalWeight = BigDecimal.ZERO;
		if(txtyield.getBigDecimalValue()!=null)
			totalWeight=totalWeight.add(txtyield.getBigDecimalValue());
		if(txtstockAtMonthBegin.getBigDecimalValue()!=null)
			totalWeight=totalWeight.add(txtstockAtMonthBegin.getBigDecimalValue());
		if(txtexpectedSaleCost.getBigDecimalValue()!=null&&totalWeight.compareTo(BigDecimal.ZERO)!=0)
			return txtexpectedSaleCost.getBigDecimalValue().divide(totalWeight,2,BigDecimal.ROUND_HALF_EVEN);
		return null;
	}
	/**
	 * 毛鸡出成
	 * @return
	 */
	private BigDecimal getYieldWeight(){
		if(txttotalWeight.getBigDecimalValue()!=null&&txtyieldRate.getBigDecimalValue()!=null)
			return txttotalWeight.getBigDecimalValue().multiply(txtyieldRate.getBigDecimalValue()).multiply(new BigDecimal("0.01"));
		return null;
	}

	/**
	 * 预计吨平均售价事件处理
	 */
	@Override
	protected void txtexpectedPricePerTon_dataChange(DataChangeEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		txtexpectedSalesRevenue.setValue(getSalesRevenue());//销售收入
		txtsaleProfit.setValue(getSalesProfit());//销售毛利		
		txtcompanyProfit.setValue(getCompanyProfit());//公司利润
		super.txtexpectedPricePerTon_dataChange(e);
	}
	/**
	 * 单位毛鸡收购价格（公斤）事件处理
	 */
	@Override
	protected void txtpricePerKG_dataChange(DataChangeEvent e) throws Exception {
		// TODO Auto-generated method stub
		txttotolCost.setValue(getTotalCostByPurchaseChicken());//毛鸡收购总成本
		txtpredictRecAmt.setValue(getInInventoryAmt());//预计入库价值
		txtexpectedSaleCost.setValue(getSalesCost());//预计销售成本
		txtexpectedsalesCostPerKG.setValue(getSalesCostPerUnit());//预计单位销售成本
		txtsaleProfit.setValue(getSalesProfit());//销售毛利
		txtcompanyProfit.setValue(getCompanyProfit());//销售利润

		super.txtpricePerKG_dataChange(e);
	}
	/**
	 * 出成比率事件处理
	 */
	@Override
	protected void txtyieldRate_dataChange(DataChangeEvent e) throws Exception {
		// TODO Auto-generated method stub
		txtyield.setValue(getYieldWeight());//毛鸡出成
		txtexpectedRec.setValue(txtyield.getBigDecimalValue());//入库数量
		txtpredictRecAmt.setValue(getInInventoryAmt());
		txtexpectedsalesCostPerKG.setValue(getSalesCostPerUnit());//预计单位销售成本				
		super.txtyieldRate_dataChange(e);
	}
	/**
	 * 生产成本事件处理
	 */
	public void txtproductCost_Changed() throws Exception	{
		txtpredictRecAmt.setValue(getInInventoryAmt());//预计入库价值
		txtexpectedSaleCost.setValue(getSalesCost());//销售成本
		txtexpectedsalesCostPerKG.setValue(getSalesCostPerUnit());//预计单位销售成本	
		txtsaleProfit.setValue(getSalesProfit());//销售毛利
		txtcompanyProfit.setValue(getCompanyProfit());//公司利润
	}

	/**
	 * 财务费用事件处理
	 */
	@Override
	protected void txtFIFee_dataChange(DataChangeEvent e) throws Exception {
		// TODO Auto-generated method stub
		//公司利润
		txtcompanyProfit.setValue(getCompanyProfit());
		super.txtFIFee_dataChange(e);
	}

	/**
	 * 管理费用事件处理
	 */
	@Override
	protected void txtmanageFee_dataChange(DataChangeEvent e) throws Exception {
		// TODO Auto-generated method stub
		//公司利润
		txtcompanyProfit.setValue(getCompanyProfit());
		super.txtmanageFee_dataChange(e);
	}

	/**
	 * 销售费用处理
	 */
	@Override
	protected void txtsaleFee_dataChange(DataChangeEvent e) throws Exception {
		// TODO Auto-generated method stub
		//公司利润
		txtcompanyProfit.setValue(getCompanyProfit());
		super.txtsaleFee_dataChange(e);
	}

	/**
	 * 重载单据内容
	 * @throws Exception 
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void reloadData() throws EASBizException, BOSException, Exception{

		if ((this.editData == null) || (this.editData.getId() == null)) {
			return;
		}
		IObjectPK pk = new ObjectUuidPK(this.editData.getId());
		setDataObject(getValue(pk));
		EventListener[] lsts = removeDetailTableListener(KDTPropertyChangeListener.class);
		loadFields();
		restoreDetailTableListener(KDTPropertyChangeListener.class, lsts);
		initOldData(this.editData);
		setSave(true);
		setSaved(true);
		// 中断
		SysUtil.abort();
	}
	/**
	 * 审核
	 */
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		MsgBox.showInfo("审核成功");
		reloadData();
	}
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSave_actionPerformed(e);
	}
	/**
	 * 提交
	 */
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
		reloadData();
	}
	/**
	 * 反审核
	 */
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		MsgBox.showInfo("反审核成功");
		reloadData();
	}

}