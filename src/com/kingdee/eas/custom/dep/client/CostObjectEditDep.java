package com.kingdee.eas.custom.dep.client;

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
 * �ɱ����� �༭ dep
 * @author Administrator
 *
 */
public class CostObjectEditDep {

	// �༭����
	protected CostObjectEditUI ui;
	// ���� ����
	protected CostObjectInfo editData;
	
	


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
