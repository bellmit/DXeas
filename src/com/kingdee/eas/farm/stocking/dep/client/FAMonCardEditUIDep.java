package com.kingdee.eas.farm.stocking.dep.client;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.DataAccessException;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.fi.fa.manage.client.FaCurCardInitEditUI;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.util.NumericExceptionSubItem;
/**
 * 固定资产卡片初始化dep
 * @author 戴安东
 *
 */
public class FAMonCardEditUIDep {
	//销售订单
	private FaCurCardInitEditUI ui;
	private KDBizPromptBox prmtFarmer,prmtFarm,prmtHouse,prmtStockingBatch;
	private String curCompanyID;
	
	public void afterOnload(final UIParam pluginCtx) {
		ui=(FaCurCardInitEditUI) pluginCtx.getUI();
		
		prmtFarmer=pluginCtx.getKDBizPromptBox("prmtfarmer");
		prmtFarm=pluginCtx.getKDBizPromptBox("prmtfarm");
		prmtHouse=pluginCtx.getKDBizPromptBox("prmthouse");
		prmtStockingBatch=pluginCtx.getKDBizPromptBox("prmtstockingBatch");
		
		if(prmtFarmer!=null&&prmtFarm!=null&&prmtHouse!=null&&prmtStockingBatch!=null) {
			if(pluginCtx.getKDBizPromptBox("bizPromptCurCompany").getValue()!=null) {
				curCompanyID=((IPropertyContainer) pluginCtx.getKDBizPromptBox("bizPromptCurCompany").getValue()).getString("id");
			}else{
				curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
			}
			curCompanyID=null;
			prmtFarmer.addDataChangeListener(new DataChangeListener(){
				public void dataChanged(DataChangeEvent e) {
					farmer_changed();
					setFilter();
				}});
			prmtFarm.addDataChangeListener(new DataChangeListener(){
				public void dataChanged(DataChangeEvent e) {
					setFilter();
				}});
			prmtHouse.addDataChangeListener(new DataChangeListener(){
				public void dataChanged(DataChangeEvent e) {
					setFilter();
				}});
			prmtStockingBatch.addDataChangeListener(new DataChangeListener(){
				public void dataChanged(DataChangeEvent e) {
					batch_changed();
					setFilter();
				}});
			
			setFilter();
		}
	}
	/**
	 * 过滤条件
	 * @param table
	 */
	private void setFilter() {
		StockingClientComm.setFarmerFilter(prmtFarmer, curCompanyID,false);
		
		String farmerID=null,batchID=null,farmID=null,houseID=null;
		if(prmtStockingBatch.getValue()!=null) {
			batchID=((IPropertyContainer)prmtStockingBatch.getValue()).getString("id");
		}
		if(prmtFarmer.getValue()!=null) {
			farmerID=((IPropertyContainer)prmtFarmer.getValue()).getString("id");
		}
		if(prmtFarm.getValue()!=null) {
			farmID=((IPropertyContainer)prmtFarm.getValue()).getString("id");
		}
		if(prmtHouse.getValue()!=null) {
			houseID=((IPropertyContainer)prmtHouse.getValue()).getString("id");
		}
		
		StockingClientComm.setFarmFilter(prmtFarm, curCompanyID, farmerID);
		StockingClientComm.setStockingBatchFilter(prmtStockingBatch, curCompanyID,farmerID,farmID,houseID);
		
		EntityViewInfo ev=new EntityViewInfo();
		FilterInfo filter=new FilterInfo();
		if(StringUtils.isNotEmpty(curCompanyID)) {
			filter.getFilterItems().add(new FilterItemInfo("company.id",curCompanyID,CompareType.EQUALS));
		}
		filter.getFilterItems().add(new FilterItemInfo("parent.baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("parent.id",farmID,CompareType.EQUALS));
		filter.getFilterItems().add(new FilterItemInfo("id",StockingComm.getAllOutHouseIDsByBatchID(null, batchID, farmID),CompareType.INCLUDE));
		ev.setFilter(filter);
		prmtHouse.setEntityViewInfo(ev);
	}
	
	
	private void farmer_changed() {
		if(prmtFarmer.getValue()!=null) {
			try {
				prmtFarm.setValue(StockingComm.getFarmInfoByFarmerID(null,((IPropertyContainer)prmtFarmer.getValue()).getString("id")));
//				if(prmtHouse.getValue()!=null&&!((IObjectValue)UIRuleUtil.getProperty((IObjectValue) prmtHouse.getValue(), "parent")).getString("id").equals(((IPropertyContainer)prmtFarmer).getString("id"))) {
					prmtHouse.setValue(null);
//				}
//				if(prmtStockingBatch.getValue()!=null&&!((IObjectValue)UIRuleUtil.getProperty((IObjectValue) prmtStockingBatch.getValue(), "farmer")).getString("id").equals(((IPropertyContainer)prmtFarmer).getString("id"))) {
					prmtStockingBatch.setValue(null);
//				}
			}catch(Exception err) {
				err.printStackTrace();
			}
		}else {
			prmtFarm.setValue(null);
			prmtHouse.setValue(null);
			prmtStockingBatch.setValue(null);
		}
	}
	
	private void batch_changed() {
		if(prmtStockingBatch.getValue()!=null) {
			try {
				prmtFarmer.setValue(UIRuleUtil.getProperty((IObjectValue) prmtStockingBatch.getValue(), "farmer"));
//				prmtFarm.setValue(UIRuleUtil.getProperty((IObjectValue) prmtStockingBatch.getValue(), "farm"));
//				prmtHouse.setValue(null);
			}catch(Exception err) {
				err.printStackTrace();
			}
		}
	}
	/**
	 * 校验数据
	 * @throws BOSException 
	 * @throws DataAccessException 
	 * @throws EASBizException 
	 */
	public void verifyData(final UIParam pluginCtx) throws DataAccessException, BOSException, EASBizException {
		prmtFarmer=pluginCtx.getKDBizPromptBox("prmtfarmer");
		prmtFarm=pluginCtx.getKDBizPromptBox("prmtfarm");
		prmtHouse=pluginCtx.getKDBizPromptBox("prmthouse");
		prmtStockingBatch=pluginCtx.getKDBizPromptBox("prmtstockingBatch");
		
		if(prmtFarmer!=null&&prmtFarm!=null&&prmtHouse!=null&&prmtStockingBatch!=null) {
			if(prmtFarmer.getValue()==null) {
//				MsgBox.showWarning("养殖户不能为空！");
				throw new EASBizException(new NumericExceptionSubItem("001","养殖户不能为空！"));
			}
			if(prmtFarm.getValue()==null) {
//				MsgBox.showWarning("养殖场不能为空！");
//				SysUtil.abort();
				throw new EASBizException(new NumericExceptionSubItem("001","养殖场不能为空！"));
			}
			if(prmtStockingBatch.getValue()==null) {
//				MsgBox.showWarning("养殖批次不能为空！");
//				SysUtil.abort();
				throw new EASBizException(new NumericExceptionSubItem("001","养殖批次不能为空！"));
			}
			if(UIRuleUtil.getProperty((IObjectValue) prmtFarm.getValue(), "isHouseManager")!=null&&(Boolean) UIRuleUtil.getProperty((IObjectValue) prmtFarm.getValue(), "isHouseManager")&&prmtHouse.getValue()==null) {
//				MsgBox.showWarning("该养殖场已启用棚舍管理，棚舍不能为空！");
//				SysUtil.abort();
				throw new EASBizException(new NumericExceptionSubItem("001","该养殖场已启用棚舍管理，棚舍不能为空！"));
			}
		}
	}
}
