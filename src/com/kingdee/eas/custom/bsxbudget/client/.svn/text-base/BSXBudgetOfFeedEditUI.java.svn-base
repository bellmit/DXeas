/**
 * output package name
 */
package com.kingdee.eas.custom.bsxbudget.client;

import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
import com.kingdee.eas.custom.bsxbudget.BSXBudgetFoodFactory;
import com.kingdee.eas.custom.bsxbudget.BSXBudgetFoodInfo;
import com.kingdee.eas.custom.bsxbudget.budgetCommUtils.BSXBudgetCommUtils;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.im.inv.client.TxtFileFilter;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;

/**
 * output class name
 */
public class BSXBudgetOfFeedEditUI extends AbstractBSXBudgetOfFeedEditUI
{
	@Override
	protected void txtratioOfNo1_dataChange(DataChangeEvent e) throws Exception {

		calculateTotalQtyOfNo1();
		calculateTotalQtyOfNo3();
		calculateTotalQtyOfNo2();
		calculateTotalQtyOfNo4();
		calculateTotalCostOfNo1();
		calculateTotalCostOfNo2();
		calculateTotalCostOfNo3();
		calculateTotalCostOfNo4();
		calculateTotalCostOfForage();
		calculateStandardCostOfAverage();
		//饲料单位成本
		calculateAverageCostOfFeedstuff();
		calculateRevenueOfChickens();
		calculateTotalCostOfCC();
		calculateAverageCostOfCC();
		calculateTotalCost();
		calculateTotalRevenue();
		calculateProfit();
		super.txtratioOfNo1_dataChange(e);
	}
	@Override
	protected void txtratioOfNo2_dataChange(DataChangeEvent e) throws Exception {

		calculateTotalQtyOfNo1();
		calculateTotalQtyOfNo3();
		calculateTotalQtyOfNo2();
		calculateTotalQtyOfNo4();
		calculateTotalCostOfNo1();
		calculateTotalCostOfNo2();
		calculateTotalCostOfNo3();
		calculateTotalCostOfNo4();
		calculateTotalCostOfForage();
		calculateStandardCostOfAverage();
		//饲料单位成本
		calculateAverageCostOfFeedstuff();
		calculateRevenueOfChickens();
		calculateTotalCostOfCC();
		calculateAverageCostOfCC();
		calculateTotalCost();
		calculateTotalRevenue();
		calculateProfit();
		super.txtratioOfNo2_dataChange(e);
	}
	@Override
	protected void txtratioOfNo3_dataChange(DataChangeEvent e) throws Exception {

		calculateTotalQtyOfNo1();
		calculateTotalQtyOfNo3();
		calculateTotalQtyOfNo2();
		calculateTotalQtyOfNo4();
		calculateTotalCostOfNo1();
		calculateTotalCostOfNo2();
		calculateTotalCostOfNo3();
		calculateTotalCostOfNo4();
		calculateTotalCostOfForage();
		calculateStandardCostOfAverage();
		//饲料单位成本
		calculateAverageCostOfFeedstuff();
		calculateRevenueOfChickens();
		calculateTotalCostOfCC();
		calculateAverageCostOfCC();
		calculateTotalCost();
		calculateTotalRevenue();
		calculateProfit();
		super.txtratioOfNo3_dataChange(e);
	}
	@Override
	protected void txtratioOfNo4_dataChange(DataChangeEvent e) throws Exception {

		calculateTotalQtyOfNo1();
		calculateTotalQtyOfNo3();
		calculateTotalQtyOfNo2();
		calculateTotalQtyOfNo4();
		calculateTotalCostOfNo1();
		calculateTotalCostOfNo2();
		calculateTotalCostOfNo3();
		calculateTotalCostOfNo4();
		calculateTotalCostOfForage();
		calculateStandardCostOfAverage();
		//饲料单位成本
		calculateAverageCostOfFeedstuff();
		calculateRevenueOfChickens();
		calculateTotalCostOfCC();
		calculateAverageCostOfCC();
		calculateTotalCost();
		calculateTotalRevenue();
		calculateProfit();
		super.txtratioOfNo4_dataChange(e);
	}

	private static final Logger logger = CoreUIObject.getLogger(BSXBudgetOfFeedEditUI.class);

	/**
	 * output class constructor
	 */
	public BSXBudgetOfFeedEditUI() throws Exception
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
		return com.kingdee.eas.custom.bsxbudget.BSXBudgetOfFeedFactory.getRemoteInstance();
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

		super.onLoad();
		this.btnAudit.setIcon(EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(EASResource.getIcon("imgTbtn_unaudit"));
		actionGetLairageQty.setVisible(false);
		txtlairageQty.setEnabled(true);
		this.setUITitle("养殖公司预算");
	}

	/**
	 * 根据期间从食品厂预算获得毛鸡收购总成本
	 * @param fiscalPeriod         会计期间
	 * @return 
	 */ 
	private BigDecimal txtPriceOfWholeChicken(PeriodInfo fiscalPeriod) {

		if(fiscalPeriod==null)
			return null;
		try {
			CoreBaseCollection coll = BSXBudgetFoodFactory.getRemoteInstance().getCollection(" where period='"+fiscalPeriod.getId().toString()+"'");
			BSXBudgetFoodInfo info = null;
			if(coll.size()>0){
				info = (BSXBudgetFoodInfo)coll.get(0);
				return info.getPricePerKG();
			}
		} catch (BOSException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.bsxbudget.BSXBudgetOfFeedInfo objectValue = new com.kingdee.eas.custom.bsxbudget.BSXBudgetOfFeedInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());

		//毛鸡收购价格
		try {
			PeriodInfo fiscalPeriod = com.kingdee.eas.custom.bsxbudget.BSXBudgetFacadeFactory.getRemoteInstance().getCurrentPeriod();
			if(fiscalPeriod!=null)
				objectValue.setPeriod(fiscalPeriod);
			if(txtPriceOfWholeChicken(fiscalPeriod)!=null)
				objectValue.setPriceOfWholeChicken(txtPriceOfWholeChicken(fiscalPeriod));
		} catch (BOSException e) {
			e.printStackTrace();
		}
		return objectValue;
	}

	/**
	 * 获取入栏数量
	 */
	@Override
	public void actionGetLairageQty_actionPerformed(ActionEvent e)
	throws Exception {

		actionGetLairageQty();



		super.actionGetLairageQty_actionPerformed(e);
	}
	/**
	 * 获得商品鸡入栏数量 按钮事件处理
	 */
	protected void btnGetLairageQty_mouseClick(MouseEvent e) throws Exception {

		actionGetLairageQty();
	}
	/**
	 * 从食品厂预算中获取毛鸡收购价格
	 */
	@Override
	protected void btnPriceOfChicken_mouseClick(MouseEvent e) throws Exception {

		if(prmtperiod.getValue()==null){
			MsgBox.showInfo("期间字段为空");
			abort();
		}
		if(txtPriceOfWholeChicken(((PeriodInfo)prmtperiod.getValue()))!=null)
			txtpriceOfWholeChicken.setValue(txtPriceOfWholeChicken(((PeriodInfo)prmtperiod.getValue())));
		else{
			txtpriceOfWholeChicken.setValue(null);
			MsgBox.showInfo("没有找到当前期间的毛鸡收购价格");
			abort();
		}
		calculateRevenueOfChickens();
		calculateTotalRevenue();
		calculateProfit();
		super.btnPriceOfChicken_mouseClick(e);
	}
	protected void actionGetLairageQty()
	throws Exception {

		if(prmtperiod.getValue()==null||txtfeedPeriod.getIntegerValue()==null||txtfeedPeriod.getIntegerValue()<=0){
			MsgBox.showInfo("期间或饲喂周期不能为空且饲喂周期必须大于0");
			abort();
		}

		//获得入栏日期的日期范围

		Calendar calBegin=Calendar.getInstance();
		Calendar calEnd=Calendar.getInstance();
		calBegin.setTime(((PeriodInfo)prmtperiod.getValue()).getBeginDate());
		calEnd.setTime(((PeriodInfo)prmtperiod.getValue()).getEndDate());
		calBegin.add(Calendar.DATE, -txtfeedPeriod.getIntegerValue());
		calEnd.add(Calendar.DATE, -txtfeedPeriod.getIntegerValue());

		Date beginDateBeforeFormat = calBegin.getTime();
		Date endDateBeforeFormat=calEnd.getTime();//获得date类型日期
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String beginDate = sdf.format(beginDateBeforeFormat);
		String endDate=sdf.format(endDateBeforeFormat);//格式化



		//获取存栏量
		BigDecimal qty = com.kingdee.eas.custom.bsxbudget.BSXBudgetFacadeFactory.getRemoteInstance().getLairageQty(beginDate, endDate);
		if(qty==null){
			MsgBox.showInfo("没有找到入栏数据,请检查期间和饲喂周期是否填写正确");
			abort();
		}
		txtlairageQty.setValue(qty);

		modifyDatasBasedOnQty(qty);
	}
	/**
	 * 会计期间事件处理
	 */
	@Override
	protected void prmtperiod_dataChange(DataChangeEvent e) throws Exception {

		if(prmtperiod.getValue()==null)
			return;
		if(txtPriceOfWholeChicken(((PeriodInfo)prmtperiod.getValue()))!=null)
			txtpriceOfWholeChicken.setValue(txtPriceOfWholeChicken(((PeriodInfo)prmtperiod.getValue())));
		else
			txtpriceOfWholeChicken.setValue(null);

		calculateTotalRevenue();
		calculateProfit();
		super.prmtperiod_dataChange(e);
	}
	/**
	 * 根据入栏数量修改相关信息
	 * @param qty
	 */
	private void modifyDatasBasedOnQty(BigDecimal qty) {

		if(qty==null)
			return;

		calculateSlaughterQty();
		calculateTotalWeight();
		calculateForageConsumption();
		calculateTotalQtyOfNo1();
		calculateTotalQtyOfNo2();
		calculateTotalQtyOfNo3();
		calculateTotalQtyOfNo4();
		calculateTotalCostOfNo1();
		calculateTotalCostOfNo2();
		calculateTotalCostOfNo3();
		calculateTotalCostOfNo4();
		calculateTotalCostOfForage();
		calculateStandardCostOfAverage();
		//饲料单位成本
		calculateAverageCostOfFeedstuff();
		calculateRevenueOfChickens();

		calculateTotalCostOfChicks();
		calculateTotalCostOfMedicine();
		calculateAverageCostOfCC();

		calculateTotalCostOfCC();
		calculateTotalCost();
		calculateTotalRevenue();
		calculateProfit();
	}

	/**
	 * 1号料单位标准成本事件处理
	 */
	@Override
	protected void txtstandardCostOfNo1_dataChange(DataChangeEvent e)
	throws Exception {

		//饲料总成本
		calculateTotalCostOfNo1();
		calculateTotalCostOfForage();
		//平均标准成本
		calculateStandardCostOfAverage();

		//饲料单位成本
		calculateAverageCostOfFeedstuff();

		//商品鸡总成本及商品鸡单位成本及预计总成本
		calculateTotalCostOfCC();
		calculateAverageCostOfCC();
		calculateTotalCost();
		calculateTotalRevenue();
		calculateProfit();
		super.txtstandardCostOfNo1_dataChange(e);
	}


	/**
	 * 2号料单位标准成本事件处理
	 */
	@Override
	protected void txtstandardCostOfNo2_dataChange(DataChangeEvent e)
	throws Exception {

		calculateTotalCostOfNo2();
		calculateTotalCostOfForage();
		calculateStandardCostOfAverage();
		//饲料单位成本
		calculateAverageCostOfFeedstuff();
		calculateRevenueOfChickens();
		calculateTotalCostOfCC();
		calculateAverageCostOfCC();
		calculateTotalCost();
		calculateTotalRevenue();
		calculateProfit();
		super.txtstandardCostOfNo2_dataChange(e);
	}



	/**
	 * 3号料单位标准成本事件处理
	 */
	@Override
	protected void txtstandardCostOfNo3_dataChange(DataChangeEvent e)
	throws Exception {

		calculateTotalCostOfNo3();
		calculateTotalCostOfForage();
		calculateStandardCostOfAverage();
		//饲料单位成本
		calculateAverageCostOfFeedstuff();
		calculateRevenueOfChickens();
		calculateTotalCostOfCC();
		calculateAverageCostOfCC();
		calculateTotalCost();
		calculateTotalRevenue();
		calculateProfit();
		super.txtstandardCostOfNo3_dataChange(e);
	}

	/**
	 * 4号料单位标准成本事件处理
	 */
	@Override
	protected void txtstandardCostOfNo4_dataChange(DataChangeEvent e)
	throws Exception {

		calculateTotalCostOfNo4();
		calculateTotalCostOfForage();
		calculateStandardCostOfAverage();
		//饲料单位成本
		calculateAverageCostOfFeedstuff();
		calculateRevenueOfChickens();
		calculateTotalCostOfCC();
		calculateAverageCostOfCC();
		calculateTotalCost();
		calculateTotalRevenue();
		calculateProfit();
		super.txtstandardCostOfNo4_dataChange(e);
	}

	/**
	 * 其他费用事件处理
	 */
	@Override
	protected void txtfeeOfOthers_dataChange(DataChangeEvent e)
	throws Exception {

		calculateTotalCostOfCC();
		calculateAverageCostOfCC();
		calculateTotalCost();
		calculateTotalRevenue();
		calculateProfit();
		super.txtfeeOfOthers_dataChange(e);
	}
	/**
	 * 鸡只均重事件处理
	 */
	@Override
	protected void txtaverageWeight_dataChange(DataChangeEvent e)
	throws Exception {

		calculateForageConsumptionPerChickens();
		calculateTotalWeight();
		calculateForageConsumption();
		calculateTotalQtyOfNo1();
		calculateTotalQtyOfNo3();
		calculateTotalQtyOfNo2();
		calculateTotalQtyOfNo4();
		calculateTotalCostOfNo1();
		calculateTotalCostOfNo2();
		calculateTotalCostOfNo3();
		calculateTotalCostOfNo4();
		calculateTotalCostOfForage();
		calculateStandardCostOfAverage();
		//饲料单位成本
		calculateAverageCostOfFeedstuff();
		calculateRevenueOfChickens();
		calculateTotalCostOfCC();
		calculateAverageCostOfCC();
		calculateTotalCost();
		calculateTotalRevenue();
		calculateProfit();
		super.txtaverageWeight_dataChange(e);
	}

	/**
	 * 成活率事件处理
	 */
	@Override
	protected void txtsurvivalRate_dataChange(DataChangeEvent e)
	throws Exception {

		calculateSlaughterQty();
		calculateTotalWeight();
		calculateForageConsumption();
		calculateTotalQtyOfNo1();
		calculateTotalQtyOfNo3();
		calculateTotalQtyOfNo2();
		calculateTotalQtyOfNo4();
		calculateTotalCostOfNo1();
		calculateTotalCostOfNo2();
		calculateTotalCostOfNo3();
		calculateTotalCostOfNo4();
		calculateTotalCostOfForage();
		calculateStandardCostOfAverage();
		//饲料单位成本
		calculateAverageCostOfFeedstuff();
		calculateRevenueOfChickens();
		calculateTotalCostOfCC();
		calculateAverageCostOfCC();
		calculateTotalCost();
		calculateTotalRevenue();
		calculateProfit();
		super.txtsurvivalRate_dataChange(e);
	}


	@Override
	protected void txtfeedToMeatRatio_dataChange(DataChangeEvent e)
	throws Exception {

		calculateForageConsumptionPerChickens();
		//		calculateTotalWeight();
		calculateForageConsumption();
		calculateTotalQtyOfNo1();
		calculateTotalQtyOfNo3();
		calculateTotalQtyOfNo2();
		calculateTotalQtyOfNo4();
		calculateTotalCostOfNo1();
		calculateTotalCostOfNo2();
		calculateTotalCostOfNo3();
		calculateTotalCostOfNo4();
		calculateTotalCostOfForage();
		calculateStandardCostOfAverage();
		//饲料单位成本
		calculateAverageCostOfFeedstuff();
		calculateRevenueOfChickens();
		calculateTotalCostOfCC();
		calculateAverageCostOfCC();
		calculateTotalCost();
		calculateTotalRevenue();
		calculateProfit();
		super.txtfeedToMeatRatio_dataChange(e);
	}

	/**
	 * 预计其他成本事件处理
	 */
	@Override
	protected void txtcostOfOthers_dataChange(DataChangeEvent e)
	throws Exception {

		calculateTotalCost();
		calculateProfit();
		super.txtcostOfOthers_dataChange(e);
	}

	//财务费用事件处理
	@Override
	protected void txtfeeOfFinance_dataChange(DataChangeEvent e)
	throws Exception {

		//预计总费用
		calculateTotalFee();
		//养殖公司利润
		calculateProfit();
		super.txtfeeOfFinance_dataChange(e);
	}

	//管理费用事件处理
	@Override
	protected void txtfeeOfManage_dataChange(DataChangeEvent e)
	throws Exception {


		calculateTotalCost();
		calculateTotalFee();
		calculateProfit();

		super.txtfeeOfManage_dataChange(e);
	}


	/**
	 * 鸡苗单位成本处理
	 */

	@Override
	protected void txtaverageCostOfChicks_dataChange(DataChangeEvent e)
	throws Exception {

		calculateTotalCostOfChicks();


		calculateTotalCostOfCC();
		calculateAverageCostOfCC();
		calculateTotalCost();
		calculateTotalRevenue();
		calculateProfit();
		super.txtaverageCostOfChicks_dataChange(e);
	}
	/**
	 * 药品单位成本事件处理
	 */
	@Override
	protected void txtaverageCostOfmedicine_dataChange(DataChangeEvent e)
	throws Exception {

		calculateTotalCostOfMedicine();
		calculateTotalCostOfCC();
		calculateAverageCostOfCC();
		calculateTotalCost();
		calculateTotalRevenue();
		calculateProfit();
		super.txtaverageCostOfmedicine_dataChange(e);
	}

	/**
	 * 预计其他收入事件处理
	 */
	@Override
	protected void txtrevenueOfOthers_dataChange(DataChangeEvent e)
	throws Exception {

		//预计总收入
		calculateTotalRevenue();
		calculateProfit();
		super.txtrevenueOfOthers_dataChange(e);
	}
	/**
	 * 养殖公司利润
	 */
	private void calculateProfit() {

		BigDecimal sum=BigDecimal.ZERO;
		if(txtpredictedTotalRevenue.getBigDecimalValue()!=null)
			sum=txtpredictedTotalRevenue.getBigDecimalValue();
		if(txtpredictedTotalCost.getBigDecimalValue()!=null)
			sum=sum.subtract(txtpredictedTotalCost.getBigDecimalValue());
		if(txtpredictTotalFee.getBigDecimalValue()!=null)
			sum=sum.subtract(txtpredictTotalFee.getBigDecimalValue());
		txtpredictedProfit.setValue(sum);
	}
	/**
	 * 预计总成本
	 */
	private void calculateTotalCost() {

		//预计总成本
		BigDecimal sum = BigDecimal.ZERO;
		if(txtcostOfOthers.getBigDecimalValue()!=null)
			sum=sum.add(txtcostOfOthers.getBigDecimalValue());
		if(txtmainCost.getBigDecimalValue()!=null)
			sum=sum.add(txtmainCost.getBigDecimalValue());


		txtpredictedTotalCost.setValue(sum);
	}

	/**
	 * 预计总费用
	 */
	private void calculateTotalFee(){
		BigDecimal sum = BigDecimal.ZERO;
		if(txtfeeOfFinance.getBigDecimalValue()!=null)
			sum=sum.add(txtfeeOfFinance.getBigDecimalValue());
		if(txtfeeOfManage.getBigDecimalValue()!=null)
			sum=sum.add(txtfeeOfManage.getBigDecimalValue());
		txtpredictTotalFee.setValue(sum);
	}



	/**
	 * 预计毛鸡收入
	 */
	private void calculateRevenueOfChickens() {

		if(txttotalWeight.getBigDecimalValue()!=null&&txtpriceOfWholeChicken.getBigDecimalValue()!=null){
			BigDecimal product = txttotalWeight.getBigDecimalValue().multiply(txtpriceOfWholeChicken.getBigDecimalValue());
			txtrevenueOfChickens.setValue(product);
		}
	}

	/**
	 * 预计总收入
	 */
	private void calculateTotalRevenue() {

		BigDecimal sum = BigDecimal.ZERO;
		if(txtrevenueOfOthers.getBigDecimalValue()!=null)
			sum=sum.add(txtrevenueOfOthers.getBigDecimalValue());
		if(txtrevenueOfChickens.getBigDecimalValue()!=null)
			sum=sum.add(txtrevenueOfChickens.getBigDecimalValue());
		txtpredictedTotalRevenue.setValue(sum);
	}
	/**
	 * 计算饲料总成本
	 */
	protected void calculateTotalCostOfForage(){
		//饲料总成本
		BigDecimal sum = BigDecimal.ZERO;
		if(txttotalCostOfNo2.getBigDecimalValue()!=null)
			sum=txttotalCostOfNo2.getBigDecimalValue().add(sum);
		if(txttotalCostOfNo1.getBigDecimalValue()!=null)
			sum=sum.add(txttotalCostOfNo1.getBigDecimalValue());
		if(txttotalCostOfNo3.getBigDecimalValue()!=null)
			sum=sum.add(txttotalCostOfNo3.getBigDecimalValue());
		if(txttotalCostOfNo4.getBigDecimalValue()!=null)
			sum=sum.add(txttotalCostOfNo4.getBigDecimalValue());
		txttotalCost.setValue(sum);
	}

	/**
	 * 出栏数量
	 */
	private void calculateSlaughterQty() {
		if(txtsurvivalRate.getBigDecimalValue()!=null&&txtlairageQty.getBigDecimalValue()!=null){//出栏数量
			int integerValue=BSXBudgetCommUtils.translateFromBigdecimalToInteger(txtsurvivalRate.getBigDecimalValue().multiply(new BigDecimal("0.01")).multiply(txtlairageQty.getBigDecimalValue()));
			txtslaughterQty.setValue(integerValue);
		}
	}

	/**
	 * 鸡只总重
	 */
	private void calculateTotalWeight() {
		if(txtaverageWeight.getBigDecimalValue()!=null&&txtslaughterQty.getBigDecimalValue()!=null)//鸡只总重
			txttotalWeight.setValue(txtslaughterQty.getBigDecimalValue().multiply(txtaverageWeight.getBigDecimalValue()));
	}
	/**
	 * 饲料消耗总量
	 */
	private void calculateForageConsumption() {
		if(txtslaughterQty.getBigDecimalValue()!=null&&txtaveFeedConsumption.getBigDecimalValue()!=null)//饲料消耗总量
			txtforageConsumption.setValue(txtslaughterQty.getBigDecimalValue().multiply(txtaveFeedConsumption.getBigDecimalValue()));
	}
	/**
	 * 1号饲料消耗量
	 */
	private void calculateTotalQtyOfNo1() {
		if(txtratioOfNo1.getBigDecimalValue()!=null&&txtforageConsumption.getBigDecimalValue()!=null)//1号料消耗总量
			txttotalQtyOfNo1.setValue(txtratioOfNo1.getBigDecimalValue().multiply(txtforageConsumption.getBigDecimalValue()).multiply(new BigDecimal("0.01")));
	}
	/**
	 * 2号饲料消耗量
	 */
	private void calculateTotalQtyOfNo2() {
		if(txtratioOfNo2.getBigDecimalValue()!=null&&txtforageConsumption.getBigDecimalValue()!=null)//2号料消耗总量
			txttotalQtyOfNo2.setValue(txtratioOfNo2.getBigDecimalValue().multiply(txtforageConsumption.getBigDecimalValue()).multiply(new BigDecimal("0.01")));
	}
	/**
	 * 3号饲料消耗量
	 */
	private void calculateTotalQtyOfNo3() {
		if(txtratioOfNo3.getBigDecimalValue()!=null&&txtforageConsumption.getBigDecimalValue()!=null)//3号料消耗总量
			txttotalQtyOfNo3.setValue(txtratioOfNo3.getBigDecimalValue().multiply(txtforageConsumption.getBigDecimalValue()).multiply(new BigDecimal("0.01")));
	}
	/**
	 * 4号饲料消耗量
	 */
	private void calculateTotalQtyOfNo4() {
		if(txtratioOfNo4.getBigDecimalValue()!=null&&txtforageConsumption.getBigDecimalValue()!=null)//4号料消耗总量
			txttotalQtyOfNo4.setValue(txtratioOfNo4.getBigDecimalValue().multiply(txtforageConsumption.getBigDecimalValue()).multiply(new BigDecimal("0.01")));
	}
	/**
	 * 1号饲料消耗成本
	 */
	private void calculateTotalCostOfNo1() {
		if(txtstandardCostOfNo1.getBigDecimalValue()!=null&&txttotalQtyOfNo1.getBigDecimalValue()!=null)//1号料总成本
			txttotalCostOfNo1.setValue(txtstandardCostOfNo1.getBigDecimalValue().multiply(txttotalQtyOfNo1.getBigDecimalValue()));
	}
	/**
	 * 2号饲料消耗成本
	 */
	private void calculateTotalCostOfNo2() {
		if(txtstandardCostOfNo2.getBigDecimalValue()!=null&&txttotalQtyOfNo2.getBigDecimalValue()!=null)//2号料总成本
			txttotalCostOfNo2.setValue(txtstandardCostOfNo2.getBigDecimalValue().multiply(txttotalQtyOfNo2.getBigDecimalValue()));
	}
	/**
	 * 3号饲料消耗成本
	 */
	private void calculateTotalCostOfNo3() {
		if(txtstandardCostOfNo3.getBigDecimalValue()!=null&&txttotalQtyOfNo3.getBigDecimalValue()!=null)//3号料总成本
			txttotalCostOfNo3.setValue(txtstandardCostOfNo3.getBigDecimalValue().multiply(txttotalQtyOfNo3.getBigDecimalValue()));
	}
	/**
	 * 4号饲料消耗成本
	 */
	private void calculateTotalCostOfNo4() {
		if(txtstandardCostOfNo4.getBigDecimalValue()!=null&&txttotalQtyOfNo4.getBigDecimalValue()!=null)//4号料总成本
			txttotalCostOfNo4.setValue(txtstandardCostOfNo4.getBigDecimalValue().multiply(txttotalQtyOfNo4.getBigDecimalValue()));
	}
	private void calculateStandardCostOfAverage() {
		//平均标准成本
		if(txttotalCost.getBigDecimalValue()!=null&&txtforageConsumption.getBigDecimalValue()!=null&&!BigDecimal.ZERO.equals(txtforageConsumption.getBigDecimalValue()))
			txtstandardCostOfAverage.setValue(txttotalCost.getBigDecimalValue().divide(txtforageConsumption.getBigDecimalValue(),6,BigDecimal.ROUND_HALF_EVEN));
	}
	private void calculateAverageCostOfFeedstuff() {
		//饲料单位成本
		if(txttotalCost.getBigDecimalValue()!=null&&txtlairageQty.getBigDecimalValue()!=null&&!BigDecimal.ZERO.equals(txtlairageQty.getBigDecimalValue())){
			txtaverageCostOfFeedstuff.setValue(txttotalCost.getBigDecimalValue().divide(txtlairageQty.getBigDecimalValue(),6,BigDecimal.ROUND_HALF_EVEN));
		}
	}
	/**
	 * 商品鸡总成本
	 */
	private void calculateTotalCostOfCC() {
		//商品鸡总成本及商品鸡单位成本及预计总成本
		BigDecimal sum = BigDecimal.ZERO;
		if(txttotalCostOfChicks.getBigDecimalValue()!=null)
			sum=sum.add(txttotalCostOfChicks.getBigDecimalValue());
		if(txttotalCost.getBigDecimalValue()!=null)
			sum=sum.add(txttotalCost.getBigDecimalValue());
		if(txtfeeOfOthers.getBigDecimalValue()!=null)
			sum=sum.add(txtfeeOfOthers.getBigDecimalValue());
		if(txttotalCostOfMedicine.getBigDecimalValue()!=null)
			sum=sum.add(txttotalCostOfMedicine.getBigDecimalValue());
		txtmainCost.setValue(sum);
		txttotalCostOfCC.setValue(sum);


	}

	/**
	 * 只耗料量
	 */
	private void calculateForageConsumptionPerChickens() {

		if(txtaverageWeight.getBigDecimalValue()!=null&&txtfeedToMeatRatio.getBigDecimalValue()!=null)
			txtaveFeedConsumption.setValue(txtaverageWeight.getBigDecimalValue().multiply(txtfeedToMeatRatio.getBigDecimalValue()));
	}
	//鸡苗总成本
	private void calculateTotalCostOfChicks() {

		if(txtaverageCostOfChicks.getBigDecimalValue()!=null&&txtslaughterQty.getBigDecimalValue()!=null)
			txttotalCostOfChicks.setValue(txtaverageCostOfChicks.getBigDecimalValue().multiply(txtlairageQty.getBigDecimalValue()));
	}
	//药品总成本
	private void calculateTotalCostOfMedicine() {

		if(txtaverageCostOfmedicine.getBigDecimalValue()!=null&&txtslaughterQty.getBigDecimalValue()!=null)
			txttotalCostOfMedicine.setValue(txtaverageCostOfmedicine.getBigDecimalValue().multiply(txtlairageQty.getBigDecimalValue()));
	}

	//商品鸡单位成本
	private void calculateAverageCostOfCC() {

		if(txttotalCostOfCC.getBigDecimalValue()!=null&&txtlairageQty.getBigDecimalValue()!=null&&!BigDecimal.ZERO.equals(txtlairageQty.getBigDecimalValue()))
			txtaverageCost.setValue(txttotalCostOfCC.getBigDecimalValue().divide(txtlairageQty.getBigDecimalValue(),6,BigDecimal.ROUND_HALF_EVEN));
	}

	/**
	 * 校验饲料比例是否合计为100%
	 */
	private void valiateHundred(){
		BigDecimal rate=BigDecimal.ZERO;
		if(txtratioOfNo1.getBigDecimalValue()!=null)
			rate=rate.add(txtratioOfNo1.getBigDecimalValue());
		if(txtratioOfNo2.getBigDecimalValue()!=null)
			rate=rate.add(txtratioOfNo2.getBigDecimalValue());
		if(txtratioOfNo3.getBigDecimalValue()!=null)
			rate=rate.add(txtratioOfNo3.getBigDecimalValue());
		if(txtratioOfNo4.getBigDecimalValue()!=null)
			rate=rate.add(txtratioOfNo4.getBigDecimalValue());
		if(rate.compareTo(new BigDecimal("100"))!=0)
			if(MsgBox.showConfirm2(null, "当前饲料耗用比例的累计和不等于100%，确定保存吗")!=0)
				abort();
	}
	@Override
	public void actionSave_actionPerformed(ActionEvent e) throws Exception {

		valiateHundred();
		super.actionSave_actionPerformed(e);
	}
	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {

		valiateHundred();
		super.actionSubmit_actionPerformed(e);
	}
	@Override
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionAudit_actionPerformed(e);
		MsgBox.showInfo("审核成功");
		reloadData();
	}
	@Override
	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionUnAudit_actionPerformed(e);
		MsgBox.showInfo("反审核成功");
		reloadData();
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
	@Override
	protected void txtlairageQty_dataChang(DataChangeEvent e) throws Exception {
		// TODO Auto-generated method stub
		modifyDatasBasedOnQty(txtlairageQty.getBigDecimalValue());
		super.txtlairageQty_dataChang(e);
	}

}