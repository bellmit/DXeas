package com.kingdee.eas.farm.stocking.dep.client;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.ctrl.swing.event.SelectorEvent;
import com.kingdee.bos.ctrl.swing.event.SelectorListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.common.StockingComm;



/**
 * 成本对象编辑界面dep
 * @author dai_andong
 *
 */
public class CostObjectEditUIDep {
	public void afterOnLoad(final UIParam pluginCtx) {
		//放养批次不为空
		if(pluginCtx.getKDBizPromptBox("stockingBatch")!=null) {
			pluginCtx.getKDBizPromptBox("company").addDataChangeListener(new DataChangeListener(){
				public void dataChanged(DataChangeEvent e) {
					String companyID=null;
					if(e.getNewValue()!=null) {
						companyID=((IObjectValue) e.getNewValue()).getString("id");
					}
					setStockingBatchFilter(pluginCtx.getKDBizPromptBox("stockingBatch"), companyID);
				}});
		}
	}
	/**
	 * 给放养批次设置过滤条件
	 * @param prmtstockingBatch
	 * @param companyID
	 */
	public static void setStockingBatchFilter( final KDBizPromptBox prmtstockingBatch, final String companyID) {
		 // prmtstockingBatch	
		
		 SelectorListener[] ls = prmtstockingBatch.getSelectorListeners();
		 for(int i=0;i<ls.length;i++) {
			 prmtstockingBatch.removeSelectorListener(ls[i]);
		 }
        prmtstockingBatch.setQueryInfo("com.kingdee.eas.farm.stocking.basedata.app.StockingBatchQuery");		
        prmtstockingBatch.setVisible(true);		
        prmtstockingBatch.setEditable(true);		
        prmtstockingBatch.setDisplayFormat("$number$");		
        prmtstockingBatch.setEditFormat("$number$");		
        prmtstockingBatch.setCommitFormat("$number$");		
        prmtstockingBatch.setRequired(true);
        		prmtstockingBatch.addSelectorListener(new SelectorListener() {
			com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI prmtstockingBatch_F7ListUI = null;
			public void willShow(SelectorEvent e) {
				if (prmtstockingBatch_F7ListUI == null) {
					try {
						prmtstockingBatch_F7ListUI = new com.kingdee.eas.farm.stocking.basedata.client.StockingBatchListUI(){
							@Override
							protected FilterInfo getDefaultFilterForQuery() {
								FilterInfo filter=new FilterInfo();
								if(StringUtils.isNotEmpty(companyID)) {
									filter.getFilterItems().add(new FilterItemInfo("company.id",companyID,CompareType.EQUALS));
								}
								filter.getFilterItems().add(new FilterItemInfo("baseStatus",FarmBaseStatusEnum.ENABLE_VALUE,CompareType.EQUALS));
								//是否完全出栏
								filter.getFilterItems().add(new FilterItemInfo("isAllOut",0,CompareType.EQUALS));
								//产蛋成本对象为空
								filter.getFilterItems().add(new FilterItemInfo("eggCostItem.id",null,CompareType.EQUALS));
								return filter;
							}
							@Override
							protected boolean isIgnoreCUFilter() {
								// TODO Auto-generated method stub
								if(StringUtils.isEmpty(companyID)) {
									return true;
								}
								return false;
							}
							@Override
							protected boolean isIgnoreTreeCUFilter() {
								// TODO Auto-generated method stub
								if(StringUtils.isEmpty(companyID)) {
									return true;
								}
								return false;
							}
						};
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					HashMap ctx = new HashMap();
					ctx.put("bizUIOwner",javax.swing.SwingUtilities.getWindowAncestor(prmtstockingBatch_F7ListUI));
					prmtstockingBatch_F7ListUI.setF7Use(true,ctx);
					prmtstockingBatch.setSelector(prmtstockingBatch_F7ListUI);
				}
			}
		});
	}
}
