/**
 * output package name
 */
package com.kingdee.eas.farm.breed.client;

import java.awt.event.*;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.breed.BreedStoorgSetInfo;
import com.kingdee.eas.farm.breed.parentFacadeFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class HouseFieldEditUI extends AbstractHouseFieldEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(HouseFieldEditUI.class);
    // ��ǰ��ֳ��
    private BreedStoorgSetInfo currFarm;
    /**
     * output class constructor
     */
    public HouseFieldEditUI() throws Exception
    {
        super();
    	// ��ǰ ��ֳ��
		StorageOrgUnitInfo currStoorg = SysContext.getSysContext().getCurrentStorageUnit();
		if(currStoorg == null){
			MsgBox.showInfo("��ǰδ���κο����֯");
			SysUtil.abort();
		}
		currFarm = parentFacadeFactory.getRemoteInstance().getFarmByStoOrgID(currStoorg.getId().toString());
		if(currStoorg == null){
			MsgBox.showInfo("��ǰδ���κ���ֳ���������л�����Ӧ��ֳ����������ز���");
			SysUtil.abort();
		}
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
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.breed.HouseFieldFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.HouseFieldInfo objectValue = new com.kingdee.eas.farm.breed.HouseFieldInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }
    /**
     * ���� Ĭ�� ֵ
     */
	@Override
	protected void applyDefaultValue(IObjectValue vo) {
		super.applyDefaultValue(vo);
		
		
	}
	
	/**
	 * ��ʼ�� 
	 */
	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		// ��ʼ�� �������
		initCompo();
	}
	
	/**
	 * ��ʼ�� �������
	 */
	private void initCompo(){
//		this
		this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedStoorgSetQuery");
    	this.prmthenhouse.setQueryInfo("com.kingdee.eas.farm.breed.app.HenhouseF7Query");
    	
	}
}