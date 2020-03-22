package com.kingdee.eas.farm.carnivorous.basedata.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

import com.kingdee.bos.*;
import com.kingdee.bos.ui.face.UIRuleUtil;
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

import com.kingdee.eas.framework.app.DataBaseControllerBean;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;

import com.kingdee.eas.farm.carnivorous.basedata.BrowerItemFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BrowerItemInfo;
import com.kingdee.eas.farm.carnivorous.basedata.BrowerItemNewFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BrowerItemNewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.farm.carnivorous.basedata.BrowerItemNewCollection;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.fi.newrpt.app.DbUtil;
//import com.kingdee.eas.rptclient.gr.rptclient.util.DbUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BrowerItemNewControllerBean extends AbstractBrowerItemNewControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.basedata.app.BrowerItemNewControllerBean");


	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		BrowerItemNewInfo info = (BrowerItemNewInfo ) model;		
		if(info.getBillStatue()!=null&&!FarmBaseStatusEnum.unApprove.equals(info.getBillStatue())) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已核准或禁用！"));
		}

		info.setBillStatue(FarmBaseStatusEnum.unApprove);
		return super._save(ctx, model);
	}

	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		BrowerItemNewInfo info = (BrowerItemNewInfo ) model;	
		if(info.getBillStatue()!=null&&!FarmBaseStatusEnum.unApprove.equals(info.getBillStatue())) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已核准或禁用！"));
		}

		info.setBillStatue(FarmBaseStatusEnum.unApprove);
		return super._submit(ctx, model);
	}


	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		BrowerItemNewInfo info = (BrowerItemNewInfo) model;
		if (!info.getBillStatue().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}

		info.setBillStatue(FarmBaseStatusEnum.frozen);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		BrowerItemNewInfo info = (BrowerItemNewInfo) model;
		if (!info.getBillStatue().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未禁用！"));
		}

		info.setBillStatue(FarmBaseStatusEnum.approve);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BrowerItemNewInfo info = (BrowerItemNewInfo) model;
		if (!info.getBillStatue().equals(FarmBaseStatusEnum.unApprove)) {
			throw new EASBizException(new NumericExceptionSubItem("001","未核准资料才能执行此操作！"));
		}

		info.setBillStatue(FarmBaseStatusEnum.approve);
		this._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BrowerItemNewInfo info = (BrowerItemNewInfo) model;
		if (!info.getBillStatue().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}
		info.setBillStatue(FarmBaseStatusEnum.unApprove);
		this._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BrowerItemNewInfo info = BrowerItemNewFactory.getLocalInstance(ctx).getBrowerItemNewInfo(pk);
		if (info.getBillStatue().equals(FarmBaseStatusEnum.approve) || info.getBillStatue().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","已经核准或禁用，不能删除！"));
		}
		//校验养殖户借款单是否引用了 该借款项目
		try {
			checkBorrowBill(ctx,info);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super._delete(ctx, pk);
	}
	/**
	 * 校验养殖户借款单是否引用了 该借款项目
	 * @param ctx
	 * @param info
	 * @throws BOSException 
	 * @throws SQLException 
	 * @throws EASBizException 
	 */
	private void checkBorrowBill(Context ctx, BrowerItemNewInfo info) throws BOSException, SQLException, EASBizException {
		// TODO Auto-generated method stub
		String s1 = "/*dialect*/ select t1.fid billid from CT_FM_FarmerBorrowNew t1 where t1.CFBrowerItemID ='"+info.getId()+"'";
		IRowSet r1 = DbUtil.executeQuery(ctx, s1);
		String billid = null;
		if(r1.next()){
			billid = UIRuleUtil.getString(r1.getString("billid"));
			if(UIRuleUtil.isNotNull(billid)){
				throw new EASBizException(new NumericExceptionSubItem("001","存在养殖户借款单引用了该借款项目！"));
			}
		}



	}


}