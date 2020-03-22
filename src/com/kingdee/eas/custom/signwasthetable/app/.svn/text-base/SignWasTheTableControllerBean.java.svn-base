package com.kingdee.eas.custom.signwasthetable.app;

import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.bot.BOTRelationCollection;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionFactory;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionInfo;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableFactory;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo;
import com.kingdee.eas.custom.signwasthetable.billStatus;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.NumericExceptionSubItem;

@SuppressWarnings("serial")
public class SignWasTheTableControllerBean extends AbstractSignWasTheTableControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.custom.signwasthetable.app.SignWasTheTableControllerBean");

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SignWasTheTableInfo info = (SignWasTheTableInfo) model;
		if(info.getPredictAmt()==null)
			throw new EASBizException(new NumericExceptionSubItem("001","预计金额不能为空"));
		try {
			info.setBillStatus(billStatus.save);
		} catch (Exception e) {
			throw new BOSException(e);
		}
		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SignWasTheTableInfo info = (SignWasTheTableInfo) model;
		if(info.getPredictAmt()==null)
			throw new EASBizException(new NumericExceptionSubItem("001","预计金额不能为空"));
		try {
			info.setBillStatus(billStatus.submit);

		} catch (Exception e) {
			throw new BOSException(e);
		}
		return super._submit(ctx, model);

	}

	@Override
	protected void _check(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub		
		SignWasTheTableInfo info = (SignWasTheTableInfo) model;
		UserInfo currentUser = (UserInfo) ctx.get(SysContextConstant.USERINFO);// 当前用户
		Date currentDate = new Date();// 当前日期
		info.setAuditors(currentUser); // 将当前用户的信息和当前时间默认填写到审核人和审核时间上
		info.setAuditTime(currentDate);
		try {
			info.setBillStatus(billStatus.Audit);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception e) {
			throw new BOSException(e);
		}	
	}

	@Override
	public void delete(Context arg0, IObjectPK arg1) throws BOSException,
	EASBizException {
		// TODO Auto-generated method stub

		if(arg1!=null){

			EntityViewInfo evi=new EntityViewInfo();
			FilterInfo fiterInfo=new FilterInfo();
			fiterInfo.getFilterItems().add(new FilterItemInfo("srcObjectID",arg1.toString(),CompareType.EQUALS));		
			evi.setFilter(fiterInfo);		
			BOTRelationCollection coll = BOTRelationFactory.getLocalInstance(arg0).getCollection(evi);
			if(coll.size()>0)
				throw new EASBizException(new NumericExceptionSubItem("001","当前单据存在下游单据"));
		}
		super.delete(arg0, arg1);
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SignWasTheTableInfo info = (SignWasTheTableInfo) model;


		EntityViewInfo evi=new EntityViewInfo();
		FilterInfo fiterInfo=new FilterInfo();
		fiterInfo.getFilterItems().add(new FilterItemInfo("srcObjectID",info.getId().toString(),CompareType.EQUALS));		
		evi.setFilter(fiterInfo);		
		BOTRelationCollection coll = BOTRelationFactory.getLocalInstance(ctx).getCollection(evi);
		if(coll.size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","存在下游单据的签呈禁止反审核"));



		try {
			info.setBillStatus(billStatus.save);
			info.setAuditors(null); // 将当前用户的信息和当前时间默认到保存时的状态
			info.setAuditTime(null);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception e) {
			throw new BOSException(e);
		}
	}

	/**
	 * @operation
	 *
	 */
	@Override
	protected void _btnRefresh(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub

	}

	protected void _toPayReq(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}

}