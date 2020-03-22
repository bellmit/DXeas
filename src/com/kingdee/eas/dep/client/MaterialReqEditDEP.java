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
 * ���ϳ��ⵥ �༭������չ
 * @author USER
 *
 */
public class MaterialReqEditDEP {
	// EditUI
	protected MaterialReqBillEditUI ui;
	
	// ���� ����
	protected MaterialReqBillInfo editData;
	
	
	/**
	 * У����ת�� ���ϳ�ʱ���� ��ͬ���
	 * �����ת�� ���� ����ѡ�� ���ۺ�ͬ
	 * @param param 
	 */
	public void checkTransReqContract(UIParam param){
		ui = (MaterialReqBillEditUI) param.getUI();
		editData = (MaterialReqBillInfo) ui.getEditData();
		
		// �����ж��Ƿ��д���ת�����ϵ����������� ��У�������д���ۺ�ͬ
		SaleContractInfo contractInfo = (SaleContractInfo) param.getKDBizPromptBox("prmtsaleContract").getValue();
		if(contractInfo == null){
			KDTable entryTable = param.getKDTable("kdtEntry");
			
			// ���з�̯���
			for(int i = 0; i < entryTable.getRowCount(); i++){
				WarehouseInfo warehouseInfo = (WarehouseInfo) entryTable.getCell(i, "warehouse").getValue();
				
				if(warehouseInfo != null){
					if(BSXConstant.ZZK_ID.equals(warehouseInfo.getId().toString())){
						MsgBox.showInfo("��¼�д��ڡ��ֿ⡿Ϊ��ת������ݣ�����ͷ�еġ� ���ۺ�ͬ������Ϊ��");
						SysUtil.abort();
					}
				}
			}
		}
		
	}
	
}
