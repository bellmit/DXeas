/**
 * output package name
 */
package com.kingdee.eas.farm.breed.client;

import java.awt.event.*;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.breed.BreedStoorgSetInfo;
import com.kingdee.eas.farm.breed.DisableState;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.farm.breed.parentFacadeFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;

/**
 * output class name
 */
public class HenhouseEditUI extends AbstractHenhouseEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(HenhouseEditUI.class);
    // ��ǰ��ֳ��
    private BreedStoorgSetInfo currFarm;
    /**
     * output class constructor
     */
    public HenhouseEditUI() throws Exception
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
        this.setUITitle("����");
    }
    
    /**
     * �����ʼ�����
     */
    @Override
	public void onLoad() throws Exception {
		// 
		super.onLoad();
		//��ʼ�����
		initUIComp();
		if(this.editData != null && this.editData.getId() != null && this.editData.getDeletedStatus() == null){
			if("EDIT".equals(this.getOprtState()) || "VIEW".equals(this.getOprtState())){
//				this.btnCancelCancel.setEnabled(true);
			}
		}
	}
    /**
     * ��ʼ�� ����ؼ�
     */
    private void  initUIComp(){
    	// f
    	this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedStoorgSetQuery");
    	this.prmtbreedArea.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedAreaQuery");
    	
    	
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
        return com.kingdee.eas.farm.breed.HenhouseFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
        return null;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.HenhouseInfo objectValue = new com.kingdee.eas.farm.breed.HenhouseInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setDeletedStatus(DisableState.Enable);
        return objectValue;
    }
    /**
     * �ֿ�仯ʱ ͬ������ �����֯
     * 
     */
	@Override
	protected void prmtwarehouse_dataChanged(DataChangeEvent e)
			throws Exception {
		WarehouseInfo wsInfo = (WarehouseInfo) this.prmtwarehouse.getValue();
		if(wsInfo != null){
			StorageOrgUnitInfo stoInfo = wsInfo.getStorageOrg();
			if(stoInfo != null){
				stoInfo = StorageOrgUnitFactory.getRemoteInstance().getStorageOrgUnitInfo(new ObjectUuidPK(stoInfo.getId()));
			}
//			this.prmtchickenFarm.setValue(stoInfo);
		}
	}
	/**
	 * ���ò���
	 */
	@Override
	public void actionCancel_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionCancel_actionPerformed(e);
	}
	/**
	 * ����
	 */
	@Override
	public void actionCancelCancel_actionPerformed(ActionEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		super.actionCancelCancel_actionPerformed(e);
	}

	/**
	 * 
	 */
	@Override
	protected void initDataStatus() {
		super.initDataStatus();
		// ���ý���    �ɼ�
		this.actionCancel.setVisible(true);
		this.actionCancelCancel.setVisible(true);

		
	}
	/**
	 * ɾ��У��
	 */
	@Override
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception {
		try{
			super.actionRemove_actionPerformed(e);
		}catch(FarmException fe){
			MsgBox.showInfo(fe.getMessage());
		}
	}

	@Override
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		super.actionSubmit_actionPerformed(e);
	}

	@Override
	protected void applyDefaultValue(IObjectValue vo) {
		// TODO Auto-generated method stub
		super.applyDefaultValue(vo);
	}

	@Override
	protected void beforeStoreFields(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		super.beforeStoreFields(arg0);
	}

	/**
	 * ��ֳ�� �仯
	 */
	@Override
	protected void prmtbreedArea_dataChanged(DataChangeEvent e)
			throws Exception {
		super.prmtbreedArea_dataChanged(e);
	}
	/**
	 * ��ֳ���仯
	 */
	@Override
	protected void prmtfarm_dataChanged(DataChangeEvent e) throws Exception {
		
		super.prmtfarm_dataChanged(e);
	}

	@Override
	protected void recycleNumberByOrg(IObjectValue editData, String orgType,
			String number) {
		super.recycleNumberByOrg(editData, orgType, number);
	}

	@Override
	protected void setAutoNumberByOrg(String orgType) {
		
		super.setAutoNumberByOrg(orgType);
	}
	
	
}