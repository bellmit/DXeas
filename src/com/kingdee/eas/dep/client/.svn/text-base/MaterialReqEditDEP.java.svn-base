package com.kingdee.eas.dep.client;

import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.scm.im.inv.MaterialReqBillInfo;
import com.kingdee.eas.scm.im.inv.client.MaterialReqBillEditUI;
import com.kingdee.eas.scm.sd.sale.SaleContractInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * 领料出库单 编辑界面扩展
 * @author USER
 *
 */
public class MaterialReqEditDEP {
	// EditUI
	protected MaterialReqBillEditUI ui;
	
	// 界面 对象
	protected MaterialReqBillInfo editData;
	
	
	/**
	 * 校验中转库 领料出时设置 合同情况
	 * 如果中转库 出库 必须选择 销售合同
	 * @param param 
	 */
	public void checkTransReqContract(UIParam param){
		ui = (MaterialReqBillEditUI) param.getUI();
		editData = (MaterialReqBillInfo) ui.getEditData();
		
		// 逐行判断是否有从中转库领料的情况，如果有 则校验必须填写销售合同
		SaleContractInfo contractInfo = (SaleContractInfo) param.getKDBizPromptBox("prmtsaleContract").getValue();
		if(contractInfo == null){
			KDTable entryTable = param.getKDTable("kdtEntry");
			
			// 逐行分摊金额
			for(int i = 0; i < entryTable.getRowCount(); i++){
				WarehouseInfo warehouseInfo = (WarehouseInfo) entryTable.getCell(i, "warehouse").getValue();
				
				if(warehouseInfo != null){
					if(BSXConstant.ZZK_ID.equals(warehouseInfo.getId().toString())){
						MsgBox.showInfo("分录中存在【仓库】为中转库的数据，单据头中的【 销售合同】不能为空");
						SysUtil.abort();
					}
				}
			}
		}
		
	}
	
}
