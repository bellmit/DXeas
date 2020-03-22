/**
 * output package name
 */
package com.kingdee.eas.farm.hatch.client;

import java.awt.event.*;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.farm.hatch.hatchFacadeFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.client.OprtState;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.common.client.UIContext;

/**
 * output class name
 */
public class IncubatorEditUI extends AbstractIncubatorEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(IncubatorEditUI.class);
    
    
    StorageOrgUnitInfo currStoOrg;  // 当前库存组织
    HatchBaseDataInfo hatchBaseInfo;  // 当前孵化场
    
    
    /**
     * output class constructor
     */
    public IncubatorEditUI() throws Exception
    {
        super();
        currStoOrg = SysContext.getSysContext().getCurrentStorageUnit();
//        try{
//	        currStoOrg = SysContext.getSysContext().getCurrentStorageUnit();
//	        if(currStoOrg == null){
//	        	MsgBox.showInfo("当前未在任何孵化场，不能操作孵化箱");
//	        	SysUtil.abort();
//	        }
//	        
//	        hatchBaseInfo = hatchFacadeFactory.getRemoteInstance().getHatchBaseData(currStoOrg);
//	        if(hatchBaseInfo == null){
//	        	MsgBox.showInfo("当前未在任何孵化场，不能操作孵化箱");
//	        	SysUtil.abort();
//	        }
//        }catch(BOSException bose){
//        	MsgBox.showInfo(bose.getMessage());
//        	SysUtil.abort();
//        }
    }
    
    
    /**
     * 界面初始化 时 操作
     * 
     */
    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		
		initUIComp();
	}
    /**
     * 初始化界面组件
     */
    private void initUIComp(){
    	this.prmthatchFactory.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7HatchBaseDataQuery");
    	this.prmthatchArea.setQueryInfo("com.kingdee.eas.farm.hatch.app.F7HatchAreaQuery");
    	EntityViewInfo evi = new EntityViewInfo();
    	FilterInfo fi = new FilterInfo();
//    	fi.getFilterItems().add(new  FilterItemInfo("hatchFactory.id",hatchBaseInfo.getId().toString(),CompareType.EQUALS));
//    	evi.setFilter(fi);
//    	this.prmthatchArea.setEntityViewInfo(evi);
    	
    	
    	EntityViewInfo eviSto = new EntityViewInfo();
    	FilterInfo fiSto = new FilterInfo();
    	fiSto.getFilterItems().add(new  FilterItemInfo("hatchFactory.name",currStoOrg.getName(),CompareType.EQUALS));
    	eviSto.setFilter(fiSto);
    	this.prmthatchFactory.setEntityViewInfo(eviSto);
    	this.prmthatchFactory.setHasQuickQueryPanel(true);
    	this.prmthatchFactory.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent e) {
				hatchFactory_changed(e);
			}

			});
//    	if(this.prmthatchFactory.getValue()!=null){
//    		HatchBaseDataInfo info = (HatchBaseDataInfo)this.prmthatchFactory.getValue();
//    		EntityViewInfo eviSto1 = new EntityViewInfo();
//        	FilterInfo fiSto1 = new FilterInfo();
//        	fiSto1.getFilterItems().add(new  FilterItemInfo("hatchFactory.name",info.getName(),CompareType.EQUALS));
//        	eviSto1.setFilter(fiSto1);
//        	this.prmthatchHouse.setEntityViewInfo(eviSto1);
//    	}
    	
    	
    	
    	
    }
    private void hatchFactory_changed(DataChangeEvent e) {
		// TODO Auto-generated method stub
    	
    	EntityViewInfo eviSto1 = new EntityViewInfo();
    	FilterInfo fiSto1 = new FilterInfo();
    	if(this.prmthatchFactory!=null){
    		HatchBaseDataInfo info = (HatchBaseDataInfo)this.prmthatchFactory.getValue();
			fiSto1.getFilterItems().add(new  FilterItemInfo("hatchFactory.name",info.getName(),CompareType.EQUALS));
        	eviSto1.setFilter(fiSto1);
        	this.prmthatchHouse.setEntityViewInfo(eviSto1);
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
     * output actionCopy_actionPerformed
     */
    public void actionCopy_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionCopy_actionPerformed(e);
    }

    /**
     * output actionAddNew_actionPerformed
     */
    public void actionAddNew_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionAddNew_actionPerformed(e);
    }

    /**
     * output actionEdit_actionPerformed
     */
    public void actionEdit_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionEdit_actionPerformed(e);
    }

    /**
     * output actionRemove_actionPerformed
     */
    public void actionRemove_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionRemove_actionPerformed(e);
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.hatch.IncubatorFactory.getRemoteInstance();
    }

    /**
     * output setDataObject method
     */
    public void setDataObject(IObjectValue dataObject) 
    {
        super.setDataObject(dataObject);
        if(STATUS_ADDNEW.equals(getOprtState())) {
            editData.put("treeid",(com.kingdee.eas.farm.hatch.IncubatorTreeInfo)getUIContext().get(UIContext.PARENTNODE));
        }
    }
    
    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.hatch.IncubatorInfo objectValue = new com.kingdee.eas.farm.hatch.IncubatorInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setHatchFactory(hatchBaseInfo);
        
        return objectValue;
    }

    
}