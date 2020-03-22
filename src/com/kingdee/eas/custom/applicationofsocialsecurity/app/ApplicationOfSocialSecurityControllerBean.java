package com.kingdee.eas.custom.applicationofsocialsecurity.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurityCollection;
import com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurityFactory;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionFactory;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionInfo;
import com.kingdee.eas.custom.applicationofsocialsecurity.IApplicationOfSocialSecurity;
import com.kingdee.eas.custom.applicationofsocialsecurity.billStatus;
import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.custom.applicationofsocialsecurity.ApplicationOfSocialSecurityInfo;
import com.kingdee.eas.custom.commld.MathUtilsComm;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ApplicationOfSocialSecurityControllerBean extends AbstractApplicationOfSocialSecurityControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.applicationofsocialsecurity.app.ApplicationOfSocialSecurityControllerBean");

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ApplicationOfSocialSecurityInfo info = (ApplicationOfSocialSecurityInfo)model;
		if(!info.getBillStatus().equals(billStatus.submit))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许审核"));
		info.setBillStatus(billStatus.audit);
		UserInfo user = (UserInfo)ctx.get(SysContextConstant.USERINFO);
		Date date = new Date();
		info.setAuditor(user);
		info.setAuditTime(date);
		super._save(ctx, model);
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ApplicationOfSocialSecurityInfo info = (ApplicationOfSocialSecurityInfo)model;
		if(!info.getBillStatus().equals(billStatus.audit))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许反审核"));
		info.setBillStatus(billStatus.save);
		info.setAuditor(null);
		info.setAuditTime(null);
		super._save(ctx, model);
	}
	/**
	 * 删除
	 */
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
	EASBizException {
		// TODO Auto-generated method stub
		ApplicationOfSocialSecurityInfo info = ApplicationOfSocialSecurityFactory.getLocalInstance(ctx).getApplicationOfSocialSecurityInfo(pk);
		if(!info.getBillStatus().equals(billStatus.save)&&!info.getBillStatus().equals(billStatus.submit)&&!info.getBillStatus().equals(billStatus.cancel))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许删除"));
		super._delete(ctx, pk);
	}

	/**
	 * 保存
	 */
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ApplicationOfSocialSecurityInfo info = (ApplicationOfSocialSecurityInfo)model;
		
		if(info.getEntrys().size()==0)
			throw new EASBizException(new NumericExceptionSubItem("001","单据没有分录，无法保存"));
		
		info.setNumber(checkNumberIsExist(info.getNumber(),info,ctx));
		if(!info.getBillStatus().equals(billStatus.save)&&!info.getBillStatus().equals(billStatus.submit)&&!info.getBillStatus().equals(billStatus.cancel))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许保存"));
		info.setBillStatus(billStatus.save);
		return super._save(ctx, model);
	}

	
	/**
	 * 提交
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ApplicationOfSocialSecurityInfo info = (ApplicationOfSocialSecurityInfo)model;
		
		if(info.getEntrys().size()==0)
			throw new EASBizException(new NumericExceptionSubItem("001","单据没有分录，无法提交"));
		
		info.setNumber(checkNumberIsExist(info.getNumber(),info,ctx));
		if(!info.getBillStatus().equals(billStatus.save)&&!info.getBillStatus().equals(billStatus.submit)&&!info.getBillStatus().equals(billStatus.cancel))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许提交"));
		info.setBillStatus(billStatus.submit);
		return super._submit(ctx, model);
	}

	/**
	 * 判断当前编码是否已被占用
	 * @param number
	 * @param applicationOfSocialSecurityInfo 
	 * @param ctx 
	 * @return
	 * @throws BOSException 
	 */
	private String checkNumberIsExist(String number, ApplicationOfSocialSecurityInfo applicationOfSocialSecurityInfo, Context ctx) throws BOSException {
		// TODO Auto-generated method stub
		String str=number;
		
		String filterStr="";
		filterStr="where number='"+number+"'";
		if(applicationOfSocialSecurityInfo.getId()!=null)
			filterStr+="and ID<>'"+applicationOfSocialSecurityInfo.getId().toString()+"'";
		CoreBaseCollection coll = ApplicationOfSocialSecurityFactory.getLocalInstance(ctx).getCollection(filterStr);
		if(coll.size()>0)
			str=getNumberByDate(ctx);
		return str;
	}

	/**
	 * 根据手动生成一个编码
	 * @param ctx 
	 * @return
	 * @throws BOSException 
	 */
	private String getNumberByDate(Context ctx) throws BOSException {
		// TODO Auto-generated method stub
		String str="SS-";
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		str+=sdf.format(date);
		IApplicationOfSocialSecurity IASS = ApplicationOfSocialSecurityFactory.getLocalInstance(ctx);
		int i=1;
		do{
			CoreBaseCollection coll = IASS.getCollection("where number='"+str+"-"+MathUtilsComm.getStringByNumber(4, i)+"'");
			if(coll.size()>0)
				i++;
			else
				return str+"-"+MathUtilsComm.getStringByNumber(4, i);
		}while(1==1);
	}

	@Override
	protected void _setSIStatus(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}

}