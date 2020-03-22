/**
 * output package name
 */
package com.kingdee.eas.custom.salepayment.client;

import java.awt.Toolkit;

import org.apache.log4j.Logger;

import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;

/**
 * output class name
 */
public class AreaSetEditUI extends AbstractAreaSetEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(AreaSetEditUI.class);
    
    /**
     * output class constructor
     */
    public AreaSetEditUI() throws Exception
    {
        super();
    }
    /**
     * 界面初始化
     */
    @Override
	public void onLoad() throws Exception {
		super.onLoad();
		// 设置全屏
		this.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		
//		this.btnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_audit"));
//		this.btnUnAudit.setIcon(com.kingdee.eas.util.client.EASResource.getIcon("imgTbtn_unaudit"));
//		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		
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
        return com.kingdee.eas.custom.salepayment.AreaSetFactory.getRemoteInstance();
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.salepayment.AreaSetInfo objectValue = new com.kingdee.eas.custom.salepayment.AreaSetInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
        objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
//        objectValue.setBaseStatus(BillBaseStatusEnum.ADD);
        return objectValue;
    }
	@Override
	protected void applyDefaultValue(IObjectValue vo) {
		
		super.applyDefaultValue(vo);
		
		
	}
    
    
    
    

}