package com.kingdee.eas.custom.wages.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.custom.wages.PersonTaxCollection;
import com.kingdee.eas.custom.wages.ScoreStandardInfo;
import com.kingdee.eas.framework.app.DataBaseControllerBean;
import com.kingdee.eas.custom.wages.PersonTaxInfo;
import com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PersonTaxControllerBean extends AbstractPersonTaxControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.wages.app.PersonTaxControllerBean");
    @Override
	protected void _approve(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
    	PersonTaxInfo info=(PersonTaxInfo) model;
    	info.setBaseStatus(UsedStatusEnum.APPROVED);
		super._approve(ctx, model);
		try {
			super.save(ctx, info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateOtherDataStatus(ctx,model);
	}
	
	@Override
	protected void _unApprove(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		PersonTaxInfo info=(PersonTaxInfo) model;
    	info.setBaseStatus(UsedStatusEnum.UNAPPROVE);
		super._unApprove(ctx, model);
		try {
			super.save(ctx, info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 把其他资料状态改为未核准
	 * @param ctx
	 * @param model
	 * @throws BOSException 
	 */
	private void updateOtherDataStatus(Context ctx,IObjectValue model) throws BOSException {
		PersonTaxInfo info=(PersonTaxInfo) model;
		
		StringBuffer sql=new StringBuffer();
		sql.append(" update CT_WAG_PersonTax set CFBaseStatus='1'")
		.append(" where CFCompanyID=?")
		.append(" and fid!=?")
		;
		DbUtil.execute(ctx, sql.toString(), new Object[]{info.getCompany().getId().toString(),info.getId().toString()});
	}
}