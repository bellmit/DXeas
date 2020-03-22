package com.kingdee.eas.farm.carnivorous.basedata.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

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

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.farm.carnivorous.basedata.FeedCostPriceEntryCollection;
import com.kingdee.eas.farm.carnivorous.basedata.FeedCostPriceEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FeedCostPriceFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FeedCostPriceInfo;
import com.kingdee.eas.farm.carnivorous.basedata.MarginPolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.MarginPolicyInfo;

import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.carnivorous.basedata.FeedCostPriceCollection;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FeedCostPriceControllerBean extends AbstractFeedCostPriceControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.basedata.app.FeedCostPriceControllerBean");

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub

		FeedCostPriceInfo info = (FeedCostPriceInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
			throw new EASBizException(new NumericExceptionSubItem("001","�����Ѻ�׼����ã�"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);

		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub

		FeedCostPriceInfo info = (FeedCostPriceInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
			throw new EASBizException(new NumericExceptionSubItem("001","�����Ѻ�׼����ã�"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);

		return super._submit(ctx, model);
	}

	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		FeedCostPriceInfo info = (FeedCostPriceInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","������δ��׼��"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.frozen);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		FeedCostPriceInfo info = (FeedCostPriceInfo) model;
		//У��ͬһ��ֳ��������ֻ����һ�ź�׼�ĵ���
		checkBillOne(ctx,info);
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","������δ���ã�"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, pk, info);
	}



	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FeedCostPriceInfo info = FeedCostPriceFactory.getLocalInstance(ctx).getFeedCostPriceInfo(pk);
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","�����Ѿ���׼����ã�"));
		}
		super._delete(ctx, pk);
	}
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
		FeedCostPriceInfo info = (FeedCostPriceInfo) model;

		//У��ͬһ��ֳ��������ֻ����һ�ź�׼�ĵ���
		checkBillOne(ctx,info);

		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.unApprove) ) {
			try {
				throw new EASBizException(new NumericExceptionSubItem("001","δ��׼���ϲ���ִ�д˲�����"));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		try {
			this._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * У��ͬһ��ֳ��������ֻ����һ�ź�׼�ĵ���
	 * @param ctx
	 * @param info
	 * @throws BOSException 
	 */
	private void checkBillOne(Context ctx, FeedCostPriceInfo info) throws BOSException {
		// TODO Auto-generated method stub

		FeedCostPriceEntryCollection entryCol = info.getEntrys();
		FeedCostPriceEntryInfo entryInfo = null;
		for(int i=0,size=entryCol.size();i<size;i++){
			entryInfo = entryCol.get(i);
			StringBuffer sq = new StringBuffer();
			sq.append("select t1.fid entryid from CT_FM_FeedCostPrice t1 inner join CT_FM_FeedCostPriceEntry t2 on t2.fparentid=t1.fid where t1.CFBaseStatus=2 and t2.CFFarmID='"+entryInfo.getFarm().getId()+"'");
			IRowSet rs  = null;
			String entryid = null;
			try {
				rs = DbUtil.executeQuery(ctx,sq.toString());
				if(rs.next()){
					entryid = rs.getString("entryid");
					if(entryid != null){
						throw new BOSException("����ֳ������µ������˷Ѽ۸�ά���Ѿ����ڣ������ظ���׼��");
					}
				}
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new BOSException(e.getMessage());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
		FeedCostPriceInfo info = (FeedCostPriceInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			try {
				throw new EASBizException(new NumericExceptionSubItem("001","������δ��׼���Ѿ����ã�"));
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		try {
			this._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}