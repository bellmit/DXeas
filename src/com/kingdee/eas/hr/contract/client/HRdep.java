package com.kingdee.eas.hr.contract.client;

import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.dep.client.BSXConstant;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.scm.im.inv.SaleIssueBillInfo;
import com.kingdee.eas.scm.im.inv.client.SaleIssueBillEditUI;
import com.kingdee.eas.scm.sd.sale.SaleContractInfo;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

public class HRdep {
	protected SaleIssueBillEditUI ui;
	// ���� ����
	protected SaleIssueBillInfo editData;
	/**
	 * У����ת�� ���ϳ�ʱ���� ��ͬ���
	 * �����ת�� ���� ����ѡ�� ���ۺ�ͬ
	 * @param param 
	 */
	public void checkTransReqContract(UIParam param){
		ui = (SaleIssueBillEditUI) param.getUI();
		editData = (SaleIssueBillInfo) ui.getEditData();
		
		// �����ж��Ƿ��д���ת�����ϵ����������� ��У�������д���ۺ�ͬ
		SaleContractInfo contractInfo = (SaleContractInfo) param.getKDBizPromptBox("prmtsaleContract").getValue();
		if(contractInfo == null){
			KDTable entryTable = param.getKDTable("detailTable");
			
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
