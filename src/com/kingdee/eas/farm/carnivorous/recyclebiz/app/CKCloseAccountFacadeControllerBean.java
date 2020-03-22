package com.kingdee.eas.farm.carnivorous.recyclebiz.app;

import org.apache.log4j.Logger;

import javax.ejb.*;
import java.rmi.RemoteException;
import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
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

import java.lang.String;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.util.NumericExceptionSubItem;

public class CKCloseAccountFacadeControllerBean extends AbstractCKCloseAccountFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.recyclebiz.app.CKCloseAccountFacadeControllerBean");

	//判断该期间是否为最近一次关账期间
	protected boolean _checkIsClosed(Context ctx, String companyID,
			String periodID) throws BOSException, EASBizException {
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" select t1.* FROM CT_FM_ClosingRecord t1 ")
		.append(" inner join T_BD_Period t2 on t1.cfperiodid=t2.fid  ")
		.append(" where  CFCompanyID='"+companyID+"'  and CFPeriodID='"+periodID+"'  ");
//		.append(" and t2.FBeginDate in (SELECT max(t2.FBeginDate) FROM CT_FM_ClosingRecord t1 ")
//		.append(" inner join T_BD_Period t2 on t1.cfperiodid=t2.fid where  CFCompanyID='"+companyID+"'  ) ");
		if(DbUtil.executeQuery(ctx, sqlBuf.toString()).size()>0){
			return true;
		}
		return false;
	}

	@Override
	protected void _closeAccount(Context ctx, String companyID, String periodID)
	throws BOSException, EASBizException {
		if(_checkIsClosed(ctx, companyID, periodID)){
			throw new EASBizException(new NumericExceptionSubItem("001","该公司所选期间已执行过关账!"));
		}
		String sql="insert into CT_FM_ClosingRecord (cfid,CFCompanyID,CFPeriodID) values('"+BOSUuid.create("C9486FE9")+"','"+companyID+"','"+periodID+"')";
		DbUtil.execute(ctx, sql);
	}

	@Override
	protected void _unCloseAccount(Context ctx, String companyID, String periodID)
	throws BOSException, EASBizException {
		if(!_checkIsClosed(ctx, companyID, periodID)){
			throw new EASBizException(new NumericExceptionSubItem("001","该公司所选期间未执行过关账,无需反关账!"));
		}
		String sql="delete from CT_FM_ClosingRecord where CFCompanyID='"+companyID+"' and CFPeriodID='"+periodID+"'";
		DbUtil.execute(ctx, sql);
	}
}