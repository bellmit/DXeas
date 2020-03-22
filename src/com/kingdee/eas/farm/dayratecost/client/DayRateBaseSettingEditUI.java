/**
 * output package name
 */
package com.kingdee.eas.farm.dayratecost.client;

import org.apache.log4j.Logger;

import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.assistant.CostItemFactory;
import com.kingdee.eas.basedata.master.material.MaterialCostCollection;
import com.kingdee.eas.basedata.master.material.MaterialCostFactory;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.util.PropertyContainer;

/**
 * output class name
 */
public class DayRateBaseSettingEditUI extends AbstractDayRateBaseSettingEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(DayRateBaseSettingEditUI.class);
    private String curCompanyID;//当前财务组织
    private F7ContextManager f7Manager;
    private OrgUnitInfo orgInfo = null;//库存组织
    private boolean isLoadFileds=false;
    
    /**
     * output class constructor
     */
    public DayRateBaseSettingEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
    	isLoadFileds=true;
        super.loadFields();
        isLoadFileds=false;
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
        return com.kingdee.eas.farm.dayratecost.DayRateBaseSettingFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.dayratecost.DayRateBaseSettingInfo objectValue = new com.kingdee.eas.farm.dayratecost.DayRateBaseSettingInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
        objectValue.setNumber("001");
        objectValue.setName("养殖成本计算系统基础设置");
        return objectValue;
    }
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		curCompanyID=SysContext.getSysContext().getCurrentFIUnit().getString("id");
		super.onLoad();
		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curCompanyID));
		f7Manager = new F7ContextManager(this, OrgType.Company);
		CompanyF7 cf7=new CompanyF7();
		cf7.setIsCUFilter(true);
		prmtcompany.setSelector(cf7);
		
		f7Manager.registerBizMaterialF7( prmtseedMateiral, null, null, orgInfo,false);
		
		this.prmtseedMateiral.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				material_changed(e);
			}});
		prmtseedCostItem.setQueryInfo("com.kingdee.eas.basedata.assistant.app.CostItemTreeListQuery");
		
		this.prmtcurrentPeriod.setEnabled(true);
		this.prmtintPeroid.setEnabled(true);
	}
	
    /**
     * 物料改变
     * @param e
     */
	private void material_changed(DataChangeEvent e) {
		if(isLoadFileds) {
			return;
		}
		try {
			if(e.getNewValue()==null) {
				prmtseedCostItem.setValue(null);
			}else {
				MaterialCostCollection cols = MaterialCostFactory.getRemoteInstance().getMaterialCostCollection("where OrgUnit.id='"+curCompanyID+"' and material.id='"+((PropertyContainer) e.getNewValue()).getString("id")+"'");
				if(cols!=null&&cols.size()>0) {
					prmtseedCostItem.setValue(CostItemFactory.getRemoteInstance().getCostItemInfo(new ObjectUuidPK( cols.get(0).getDefaultCostItem().getId())));
				}
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
    

}