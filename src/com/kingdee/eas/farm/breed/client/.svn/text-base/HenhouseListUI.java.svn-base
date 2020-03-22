/**
 * output package name
 */
package com.kingdee.eas.farm.breed.client;

import java.awt.event.*;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.barcode.pda.BarcodePdaBasedataFacadeFactory;
import com.kingdee.eas.barcode.pda.IBarcodePdaBasedataFacade;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.breed.BreedStoorgSetInfo;
import com.kingdee.eas.farm.breed.parentFacadeFactory;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.FarmException;

/**
 * output class name
 */
public class HenhouseListUI extends AbstractHenhouseListUI
{
    private static final Logger logger = CoreUIObject.getLogger(HenhouseListUI.class);
    // 当前养殖场
    private BreedStoorgSetInfo currFarm;
    /**
     * output class constructor
     */
    public HenhouseListUI() throws Exception
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
        this.setFilterForQuery(this.getFilterInfo());
        this.setUITitle("禽舍管理");
    }

    @Override
    public FilterInfo getFilterInfo(){
    	FilterInfo filterInfo  = new FilterInfo();
//    	StorageOrgUnitInfo stoInfo = SysContext.getSysContext().getCurrentStorageUnit();
    	CtrlUnitInfo currCU = SysContext.getSysContext().getCurrentCtrlUnit();
    	if(currCU == null){
    		SysUtil.abort();
    	}
    	
    	filterInfo.getFilterItems().add(new FilterItemInfo("CU.id",currCU.getId().toString(),CompareType.EQUALS));
    	// 如果当前在养殖场，则过滤 养殖场
    	if(currFarm != null){
    		filterInfo.getFilterItems().add(new FilterItemInfo("farm.id",currFarm.getId().toString(),CompareType.EQUALS));
    	}
    	
    	return filterInfo;
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
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.breed.HenhouseInfo objectValue = new com.kingdee.eas.farm.breed.HenhouseInfo();
		
        return objectValue;
    }

    /**
     * 不进行组织隔离
     */
	@Override
	protected boolean isIgnoreCUFilter() {
		
		return false;
	}

	/**
	 * 删除
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
	public void actionPrint_actionPerformed(ActionEvent e) throws Exception {
		IBarcodePdaBasedataFacade barcodeFacade = BarcodePdaBasedataFacadeFactory.getRemoteInstance();
		
		String params = "<barcode><Header>UWBCDtRequest</Header><Type>string</Type><CsName>com.kingdee.eas.barcode.pda.app.BarcodePdaBasedataFacadeControllerBean</CsName><Function>requestLicenseOrReleaseLicense</Function><Params><P type = \"System.String\">6f7604df-4d95-4b49-a62b-e0ea757206e8</P><P type = \"System.Boolean\">True</P></Params><Return>string</Return><Tailer>UWBCEnd</Tailer></barcode>";
		String result = barcodeFacade.getMethod(params);
		System.out.println(result);
		params = "<barcode><Header>UWBCDtRequest</Header><Type>string</Type><CsName>com.kingdee.eas.barcode.pda.app.BarcodePdaBasedataFacadeControllerBean</CsName><Function>getMenuConfig</Function><Return>string</Return><Tailer>UWBCEnd</Tailer></barcode>";
		result = barcodeFacade.getMethod(params);
		System.out.println(result);
	}
	
	
	
}