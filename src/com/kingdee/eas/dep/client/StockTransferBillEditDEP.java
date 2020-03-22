package com.kingdee.eas.dep.client;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.farm.breed.BreedFacadeFactory;
import com.kingdee.eas.scm.im.inv.StockTransferBillInfo;
import com.kingdee.eas.scm.im.inv.client.StockTransferBillEditUI;

/**
 * 库存调拨单 dep扩展接口
 * @author USER
 *
 */
public class StockTransferBillEditDEP {
	
	protected StockTransferBillEditUI ui;
	// 界面 对象
	protected StockTransferBillInfo editData;
	
	
	/**
	 * 设置签程f7
	 * @param param
	 * @throws BOSException 
	 */
	public void setSigntableF7(UIParam param) throws BOSException{
		if(param.getKDBizPromptBox("prmtSignTable") != null){
			param.getKDBizPromptBox("prmtSignTable").setQueryInfo("com.kingdee.eas.custom.signwasthetable.app.SignWasTheTableSaleReturnQuery");
			param.getKDBizPromptBox("prmtSignTable").setDisplayFormat("$number$");
			param.getKDBizPromptBox("prmtSignTable").setEditFormat("$number$");
			param.getKDBizPromptBox("prmtSignTable").setCommitFormat("$number$");
			
			EntityViewInfo evi = new EntityViewInfo();
	        FilterInfo fi = new FilterInfo();
//	        materialFI.getFilterItems().add(new FilterItemInfo("materialGroup.longNumber","02!0201!020102%",CompareType.LIKE));
	        fi.getFilterItems().add(new FilterItemInfo("CU.id",SysContext.getSysContext().getCurrentCtrlUnit().getId().toString(),CompareType.EQUALS));
	        
	        evi.setFilter(fi);
	        // 设置物料过滤条件
//			m7.setBaseFilter(towerFI);
	        param.getKDBizPromptBox("prmtSignTable").setEntityViewInfo(evi);
			
		}
	
	}
	/**
	 * 成本对象
	 * @param param
	 * @throws BOSException 
	 */
	public void updateCostObject(UIParam param) throws BOSException{
		this.updateCostObjectInfo(param);
	}
	
	
	/**
	 * 设置成本对象
	 * @param param
	 * @throws BOSException 
	 */
	private void updateCostObjectInfo(UIParam param) throws BOSException{
		ui = (StockTransferBillEditUI) param.getUI();
		editData = (StockTransferBillInfo) ui.getEditData();
		if (param.getKDBizPromptBox("prmtMoveInStorageOrgUnit").getData() == null) {
			param.getKDBizPromptBox("prmtcostObject").setValue(null);
		}else{
			StorageOrgUnitInfo issueStoOrgInfo = (StorageOrgUnitInfo) param.getKDBizPromptBox("prmtMoveOutStorageOrgUnit").getData();
			if(issueStoOrgInfo != null && "饲料厂".equals(issueStoOrgInfo.getName())){
				StorageOrgUnitInfo farmInfo = (StorageOrgUnitInfo) param.getKDBizPromptBox("prmtMoveInStorageOrgUnit").getData();
				CostObjectInfo coInfo = BreedFacadeFactory.getRemoteInstance().getFarmLatestCostObject(farmInfo.getId().toString());
				// 设置渠道的 成本对象
				param.getKDBizPromptBox("prmtcostObject").setValue(coInfo);
				editData.put("costObject", coInfo);
			}
		}
		
	}
}
