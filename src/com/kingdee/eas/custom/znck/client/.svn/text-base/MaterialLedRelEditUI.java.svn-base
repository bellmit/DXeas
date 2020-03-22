/**
 * output package name
 */
package com.kingdee.eas.custom.znck.client;

import java.awt.event.*;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.util.client.EASResource;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.KDTable;

/**
 * output class name
 */
public class MaterialLedRelEditUI extends AbstractMaterialLedRelEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(MaterialLedRelEditUI.class);
    
    /**
     * output class constructor
     */
    public MaterialLedRelEditUI() throws Exception
    {
        super();
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
        return com.kingdee.eas.custom.znck.MaterialLedRelFactory.getRemoteInstance();
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
        com.kingdee.eas.custom.znck.MaterialLedRelInfo objectValue = new com.kingdee.eas.custom.znck.MaterialLedRelInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		// 初始化物料F7
		initContol();
	}
	
	/**
	 * 初始化控件
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void initContol() throws EASBizException, BOSException {
		
		
		
		F7ContextManager f7Manager = new F7ContextManager(this, OrgType.Storage);
		OrgUnitInfo orgInfo =SysContext.getSysContext().getCurrentStorageUnit();
		//更改物料F7
       
        f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("material").getEditor().getComponent(), null, null, orgInfo,false);
	}

}