package com.kingdee.eas.farm.stocking.dep.client;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.farm.stocking.common.StockingClientComm;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.fi.cas.client.CasReceivingBillUI;

/**
 * ���� �տDEP
 * @author dai_andong
 *
 */
public class ReceivingBillEditUIDep {
	private CasReceivingBillUI ui;
	public void afterOnload(final UIParam pluginCtx) {
		if(pluginCtx.getKDBizPromptBox("prmtstockingBatch")==null) {
			return;
		}
		if(!(pluginCtx.getUI() instanceof CasReceivingBillUI)) {
			return;
		}
		ui=(CasReceivingBillUI) pluginCtx.getUI();
		pluginCtx.getKDBizPromptBox("prmtCostCenter").addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				setBatchFilter(pluginCtx.getKDBizPromptBox("prmtstockingBatch"),(CostCenterOrgUnitInfo) e.getNewValue());
			}});
		
		setBatchFilter(pluginCtx.getKDBizPromptBox("prmtstockingBatch"), null);
	}
	
	private void setBatchFilter(KDBizPromptBox prmtBatch,CostCenterOrgUnitInfo costCentorInfo) {
		String farmerID=null;String companyID=null;
		if(StringUtils.isEmpty(companyID)) {
			companyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		}
		if(costCentorInfo!=null) {
			String costCenterID = costCentorInfo.getString("id");
			farmerID=StockingComm.getFarmerIDByCostCenterID(null, companyID, costCenterID);
		}
		StockingClientComm.setStockingBatchFilter(prmtBatch, companyID, farmerID, null);
	}
}
