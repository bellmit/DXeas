/**
 * output package name
 */
package com.kingdee.eas.farm.feemanager.basebizbill.client;

import java.awt.Color;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.kdf.table.ICell;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTIndexColumn;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.foot.KDTFootManager;
import com.kingdee.bos.ctrl.kdf.util.style.Styles.HorizontalAlignment;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.FrameWorkClientUtils;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;

/**
 * output class name
 */
public class TransportationrecordListUI extends AbstractTransportationrecordListUI
{
    private static final Logger logger = CoreUIObject.getLogger(TransportationrecordListUI.class);
    
    /**
     * output class constructor
     */
    public TransportationrecordListUI() throws Exception
    {
        super();
        
        CompanyOrgUnitInfo currAdminOrg = SysContext.getSysContext().getCurrentFIUnit();
    	if(currAdminOrg == null){
    		MsgBox.showError("非财务组织无法访问");
    		SysUtil.abort();
    	}
        this.setFilterForQuery(this.getFilterInfo());
    }

    /**
     * 设置默认过滤条件
     * 组织过滤：财务组织
     * @return
     */
    public FilterInfo getFilterInfo(){
    	FilterInfo filterInfo  = new FilterInfo();
    	CompanyOrgUnitInfo companyOrgUnitInfo = SysContext.getSysContext().getCurrentFIUnit();
    	filterInfo.getFilterItems().add(new FilterItemInfo("companyOrgUnit.id",companyOrgUnitInfo.getId().toString(),CompareType.EQUALS));
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
        return com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo objectValue = new com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo();
		
        return objectValue;
    }

}