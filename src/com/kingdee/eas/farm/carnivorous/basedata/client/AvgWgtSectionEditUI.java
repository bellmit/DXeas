/**
 * output package name
 */
package com.kingdee.eas.farm.carnivorous.basedata.client;

import java.awt.event.*;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.base.form.SqlExecutorFacade;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class AvgWgtSectionEditUI extends AbstractAvgWgtSectionEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AvgWgtSectionEditUI.class);
    
    /**
     * output class constructor
     */
    public AvgWgtSectionEditUI() throws Exception
    {
        super();
    }
   
    @Override
    protected void beforeStoreFields(ActionEvent e) throws Exception {
    	super.beforeStoreFields(e);
    	String breedDataID = ((IPropertyContainer)prmtbreedData.getValue()).getString("id");
    	String id=null;
    	if(editData.getId()!=null){
    		id=editData.getId().toString();
    	}
    	StringBuffer sql=new StringBuffer();
    	sql.append("select fid from  CT_FM_AvgWgtSection where CFBreedDataID='"+breedDataID+"'");
    	if(StringUtils.isNotBlank(id)){
    		sql.append(" and fid <> '"+id+"'");
    	}
    	IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
    	if(rs.next()){
    		MsgBox.showWarning("同一品种已维护该资料,操作失败!");
    		abort();
    	}
    }

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.farm.carnivorous.basedata.AvgWgtSectionFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.farm.carnivorous.basedata.AvgWgtSectionInfo objectValue = new com.kingdee.eas.farm.carnivorous.basedata.AvgWgtSectionInfo();
				if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")).getBoolean("isBizUnit"))
			objectValue.put("FICompany",com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Company")));
 
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }

}