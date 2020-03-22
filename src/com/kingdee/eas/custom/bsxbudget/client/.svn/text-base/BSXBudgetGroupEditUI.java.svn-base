/**
 * output package name
 */
package com.kingdee.eas.custom.bsxbudget.client;

import java.awt.event.*;
import java.math.BigDecimal;
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
import com.kingdee.eas.custom.bsxbudget.BSXBudgetOfFeedFactory;
import com.kingdee.eas.custom.bsxbudget.BSXBudgetOfFeedInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTPropertyChangeListener;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;

/**
 * output class name
 */
public class BSXBudgetGroupEditUI extends AbstractBSXBudgetGroupEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(BSXBudgetGroupEditUI.class);
	private   BSXBudgetFoodInfo budgetFood;
	private   BSXBudgetOfFeedInfo budgetFeed;



	/**
	 * output class constructor
	 */
	public BSXBudgetGroupEditUI() throws Exception
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
		return com.kingdee.eas.custom.bsxbudget.BSXBudgetGroupFactory.getRemoteInstance();
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
	}

	/**
	 * 根据获得的养殖场预算info填充相关数据
	 */
	private void fillInfomationAboutBudgetOfFeed() {
		// TODO Auto-generated method stub
		if(budgetFeed==null)
			clearCostAndRevenue();
		else{
			txtrevenueFeed.setValue(budgetFeed.getPredictedTotalRevenue());//收入
			txtcostFeed.setValue(budgetFeed.getPredictedTotalCost());//成本
		}
	}
	/**
	 * 根据获得的食品厂预算info填充相关数据
	 */
	private void fillInfomationAboutBudgetOfFood() {
		// TODO Auto-generated method stub
		if(budgetFood==null)
			clearCostAndRevenue();
		else{
			txtRevenueFood.setValue(budgetFood.getExpectedSalesRevenue());
			txtcostFood.setValue(budgetFood.getExpectedSaleCost());
		}


	}

	/**
	 * 期间字段的事件处理
	 */
	@Override
	protected void prmtperiod_dataChange(DataChangeEvent e) throws Exception {
		// TODO Auto-generated method stub
		if(prmtperiod.getValue()==null)
			return;
		getRevenueAndCostBasedOnperiod();
		super.prmtperiod_dataChange(e);
	}

	/**
	 * 获取养殖和食品公司收入和成本   按钮事件处理
	 */
	@Override
	protected void btnGetCostAndRevenue_mouseClick(MouseEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		if(prmtperiod.getValue()==null){
			MsgBox.showInfo("期间为空");
			abort();
		}
		getRevenueAndCostBasedOnperiod();
		super.btnGetCostAndRevenue_mouseClick(e);
	}
	/**
	 * 根据会计期间获得养殖和食品的收入和成本
	 */
	private void getRevenueAndCostBasedOnperiod() {
		// TODO Auto-generated method stub
		PeriodInfo periodInfo = (PeriodInfo)prmtperiod.getValue();
		//获取当前会计期间的食品厂预算
		if(periodInfo!=null){
			CoreBaseCollection collFood;
			try {
				collFood = BSXBudgetFoodFactory.getRemoteInstance().getCollection("where period='"+periodInfo.getId().toString()+"'");
				if(collFood.size()>0){
					budgetFood = (BSXBudgetFoodInfo)collFood.get(0);
				}else
					budgetFood=null;
				fillInfomationAboutBudgetOfFood();
				//根据获得的info填充相关数据
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


			//获取当前会计期间的养殖场预算
			CoreBaseCollection collFeed;
			try {
				collFeed = BSXBudgetOfFeedFactory.getRemoteInstance().getCollection("where period='"+periodInfo.getId().toString()+"'");
				if(collFeed.size()>0){
					budgetFeed = (BSXBudgetOfFeedInfo)collFeed.get(0);
					//根据获得的info填充相关数据
					fillInfomationAboutBudgetOfFeed();
				}
			} catch (BOSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(txtrevenueFeed.getBigDecimalValue()!=null&&txtRevenueFood.getBigDecimalValue()!=null){
			//集团收入
			txtrevenueGroup.setValue(txtrevenueFeed.getBigDecimalValue().add(txtRevenueFood.getBigDecimalValue()));
		}
		if(txtcostFeed.getBigDecimalValue()!=null&&txtcostFood.getBigDecimalValue()!=null){
			//集团成本
			txtcostGroup.setValue(txtcostFeed.getBigDecimalValue().add(txtcostFood.getBigDecimalValue()));
		}
		calculateTotalFeeOfGroup();
		calculateTotalProfitOfGroup();
	}
	/**
	 * 财务费用的事件处理
	 */
	@Override
	protected void txtFIFee_dataChange(DataChangeEvent e) throws Exception {
		// TODO Auto-generated method stub
		calculateTotalFeeOfGroup();
		calculateTotalProfitOfGroup();
		super.txtFIFee_dataChange(e);
	}
	/**
	 * 集团总利润
	 */
	private void calculateTotalProfitOfGroup() {
		// TODO Auto-generated method stub
		BigDecimal result=BigDecimal.ZERO;
		if(txtcostGroup.getBigDecimalValue()!=null&&txtrevenueGroup.getBigDecimalValue()!=null)
			result=txtrevenueGroup.getBigDecimalValue().subtract(txtcostGroup.getBigDecimalValue());
		if(txtgroupFee.getBigDecimalValue()!=null)
			result=result.subtract(txtgroupFee.getBigDecimalValue());
		txtprofit.setValue(result);
	}
	/**
	 * 集团总费用
	 */
	private void calculateTotalFeeOfGroup() {
		// TODO Auto-generated method stub
		BigDecimal sum = BigDecimal.ZERO;
		if(txtFIFee.getBigDecimalValue()!=null)
			sum=sum.add(txtFIFee.getBigDecimalValue());
		if(txtmanageFee.getBigDecimalValue()!=null)
			sum=sum.add(txtmanageFee.getBigDecimalValue());
		txtgroupFee.setValue(sum);
	}
	/**
	 * 管理费用的事件处理
	 */
	@Override
	protected void txtmanageFee_dataChange(DataChangeEvent e) throws Exception {
		// TODO Auto-generated method stub
		calculateTotalFeeOfGroup();
		calculateTotalProfitOfGroup();
		super.txtmanageFee_dataChange(e);
	}


	private void clearCostAndRevenue(){
		txtRevenueFood.setValue(null);
		txtcostFood.setValue(null);
		txtrevenueGroup.setValue(null);
		txtcostGroup.setValue(null);
		txtprofit.setValue(null);
	}
	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.bsxbudget.BSXBudgetGroupInfo objectValue = new com.kingdee.eas.custom.bsxbudget.BSXBudgetGroupInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setBizDate(new Date());
		return objectValue;
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

}