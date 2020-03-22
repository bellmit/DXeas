/**
 * output package name
 */
package com.kingdee.eas.farm.breed.client;

import java.awt.Toolkit;
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
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class BreedAreaEditUI extends AbstractBreedAreaEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(BreedAreaEditUI.class);
    
    // 当前养殖场
    private BreedStoorgSetInfo currFarm;
    /**
     * output class constructor
     */
    public BreedAreaEditUI() throws Exception
    {
        super();
    	// 当前 养殖场
		StorageOrgUnitInfo currStoorg = SysContext.getSysContext().getCurrentStorageUnit();
		if(currStoorg == null){
			MsgBox.showInfo("当前未在任何库存组织");
			SysUtil.abort();
		}
		currFarm = parentFacadeFactory.getRemoteInstance().getFarmByStoOrgID(currStoorg.getId().toString());
		if(currStoorg == null){
			MsgBox.showInfo("当前未在任何养殖场，请先切换到对应养殖场后再做相关操作");
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
        return com.kingdee.eas.farm.breed.BreedAreaFactory.getRemoteInstance();
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
        com.kingdee.eas.farm.breed.BreedAreaInfo objectValue = new com.kingdee.eas.farm.breed.BreedAreaInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }
    
    /**
     * 界面初始化
     */
	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		// 界面 全屏
		
		initComp();
	}
    
	/**
	 * 初始化界面 组件
	 */
    private void initComp(){
    	
    	// 设置全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		this.prmtfarm.setQueryInfo("com.kingdee.eas.farm.breed.app.F7BreedStoorgSetQuery");
		
		
		
    }
    

}