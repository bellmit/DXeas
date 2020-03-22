/**
 * output package name
 */
package com.kingdee.eas.farm.breed.layegg.client;

import java.awt.event.*;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
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
public class ParentEggDailyListUI extends AbstractParentEggDailyListUI
{
    private static final Logger logger = CoreUIObject.getLogger(ParentEggDailyListUI.class);
    
    // 当前养殖场
    private BreedStoorgSetInfo currFarm;
    /**
     * output class constructor
     */
    public ParentEggDailyListUI() throws Exception
    {
        super();
        
        // 当前 养殖场
		StorageOrgUnitInfo currStoorg = SysContext.getSysContext().getCurrentStorageUnit();
		if(currStoorg == null){
			MsgBox.showInfo("当前未在任何库存组织");
			SysUtil.abort();
		}
		try{
			currFarm = parentFacadeFactory.getRemoteInstance().getFarmByStoOrgID(currStoorg.getId().toString());
		}catch(BOSException bose){
			MsgBox.showInfo(bose.getMessage());
			SysUtil.abort();
		}
		if(currStoorg == null){
			MsgBox.showInfo("当前未在任何养殖场，请先切换到对应养殖场后再做相关操作");
			SysUtil.abort();
		}
        // 默认过滤条件
		this.setFilterForQuery(this.getFilterInfo());
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.breed.layegg.ParentEggDailyFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.layegg.ParentEggDailyInfo objectValue = new com.kingdee.eas.farm.breed.layegg.ParentEggDailyInfo();
		
        return objectValue;
    }
    /**
     * 界面初始化 
     */
    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		// 设置全屏
//		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
		
    }
    /**
     * 设置默认过滤条件
     */
    @Override
    public FilterInfo getFilterInfo(){
    	FilterInfo filterInfo  = new FilterInfo();
    	StorageOrgUnitInfo stoInfo = SysContext.getSysContext().getCurrentStorageUnit();
    	if(stoInfo == null){
    		SysUtil.abort();
    	}
    	
    	filterInfo.getFilterItems().add(new FilterItemInfo("stoOrg.longNumber",stoInfo.getLongNumber()+"%" ,CompareType.LIKE));
    	
    	
    	return filterInfo;
    }


}