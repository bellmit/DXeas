package com.kingdee.eas.dep.client;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.basedata.assistant.client.CostObjectEditUI;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.util.SysUtil;

/**
 * �ɱ�����༭������չ
 * @author USER
 *
 */
public class CostObjectEditDEP {

	protected CostObjectEditUI ui;
	protected CostObjectInfo editData;
	/**
	 * ��ֳ��ѡ�к���±�ע ��ϢΪ��ֳ������
	 * @param param
	 * @throws Exception
	 */
	public void stoOrgChanged(UIParam param) throws Exception{
		// ѡ�гɱ�����󣬽��ɱ��������Ƹ��µ���ע��
		if(param.getKDBizPromptBox("prmtstoOrg") != null){
			StorageOrgUnitInfo currCB = (StorageOrgUnitInfo) param.getKDBizPromptBox("prmtstoOrg").getValue();
			if(currCB != null){
				String cbName = currCB.getName();
	//			param.getKDTextArea("").setText(cbName);
				param.getKDBizMultiLangArea("kDBizMultiLangArea1").setSelectedItemData(cbName);
			}else{
				param.getKDBizMultiLangArea("kDBizMultiLangArea1").setSelectedItemData("");
			}
		}
	}
	
	

	/**
	 * onload���ýű����÷���
	 * ���� ���� f7 ��������
	 * @throws BOSException 
	 */
	public void afterOnLoad(UIParam param) throws Exception{
		
		ui = (CostObjectEditUI) param.getUI();
		
		KDBizPromptBox batchF7 = param.getKDBizPromptBox("prmtparentBreedBatch");
		if(batchF7 != null){
			batchF7.setQueryInfo("com.kingdee.eas.farm.breed.app.F7ParentBreedBatchQuery");		
	        batchF7.setEditable(true);		
	        batchF7.setDisplayFormat("$number$");		
	        batchF7.setEditFormat("$number$");		
	        batchF7.setCommitFormat("$number$");	
	        
	        EntityViewInfo evi = new EntityViewInfo();
	        FilterInfo filterInfo  = new FilterInfo();
	    	StorageOrgUnitInfo stoInfo = SysContext.getSysContext().getCurrentStorageUnit();
	    	CtrlUnitInfo currCU = SysContext.getSysContext().getCurrentCtrlUnit();
	    	if(currCU == null){
	    		SysUtil.abort();
	    	}
	    	filterInfo.getFilterItems().add(new FilterItemInfo("CU.id",currCU.getId().toString(),CompareType.EQUALS));
	    	evi.setFilter(filterInfo);
	        batchF7.setEntityViewInfo(evi);	
		}
		
	}
}
