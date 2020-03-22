/**
 * output package name
 */
package com.kingdee.eas.farm.feedfactory.client;

import java.awt.event.*;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.util.F7ContextManager;

/**
 * output class name
 */
public class LocalPurMATPriceEditUI extends AbstractLocalPurMATPriceEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(LocalPurMATPriceEditUI.class);
    
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private F7ContextManager f7Manager;
	/**
	 * output class constructor
	 */
	public LocalPurMATPriceEditUI() throws Exception{
		super();
	}

	@Override
	public void onLoad() throws Exception {
		super.onLoad();
		setOrgF7(prmtcompany,com.kingdee.eas.basedata.org.OrgType.getEnum("Company"));
		CompanyOrgUnitInfo company = SysContext.getSysContext().getCurrentFIUnit();
		f7Manager = new F7ContextManager(this, OrgType.Company);		
		f7Manager.registerBizMaterialF7((KDBizPromptBox) this.kdtEntry.getColumn("material").getEditor().getComponent(), null, null, company,false);
		f7Manager.registerBizSupplierF7((KDBizPromptBox) this.kdtEntry.getColumn("supplier").getEditor().getComponent(), null, null, company);
	}

	protected void setOrgF7(KDBizPromptBox f7,com.kingdee.eas.basedata.org.OrgType orgType) throws Exception
	{
		com.kingdee.eas.basedata.org.client.f7.NewOrgUnitFilterInfoProducer oufip = new com.kingdee.eas.basedata.org.client.f7.NewOrgUnitFilterInfoProducer(orgType);
		oufip.getModel().setIsCUFilter(true);
		f7.setFilterInfoProducer(oufip);
	}

	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.farm.feedfactory.LocalPurMATPriceFactory.getRemoteInstance();
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.farm.feedfactory.LocalPurMATPriceInfo objectValue = new com.kingdee.eas.farm.feedfactory.LocalPurMATPriceInfo();
		objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		return objectValue;
	}
}