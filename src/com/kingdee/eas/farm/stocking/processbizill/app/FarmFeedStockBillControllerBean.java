package com.kingdee.eas.farm.stocking.processbizill.app;

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

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyInfo;
import com.kingdee.eas.farm.stocking.processbizill.FarmFeedStockBillCollection;
import com.kingdee.eas.farm.stocking.processbizill.FarmFeedStockBillEntryFactory;
import com.kingdee.eas.farm.stocking.processbizill.FarmFeedStockBillFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.farm.stocking.processbizill.FarmFeedStockBillInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.EntryBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.basedata.assistant.BillStateEnum;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FarmFeedStockBillControllerBean extends AbstractFarmFeedStockBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.stocking.processbizill.app.FarmFeedStockBillControllerBean");

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
		//定义一个Info，里面有我们所填的信息
		FarmFeedStockBillInfo info=(FarmFeedStockBillInfo)model;
		//获取单据状态
        info.setBaseStatus(EntryBaseStatusEnum.AUDITED);
        //获得审核时间
//		info.getContauditTime();
		//获取审核人
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		try {
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		//定义一个Info，里面有我们所填的信息
		FarmFeedStockBillInfo info=(FarmFeedStockBillInfo)model;
		info.setBaseStatus(EntryBaseStatusEnum.TEMPORARILYSAVED);
//		info.setContauditTime(null);
		info.setAuditor(null);
		try {
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmFeedStockBillInfo info=(FarmFeedStockBillInfo)model;
		if(info.getBaseStatus()==null||info.getBaseStatus().getValue()==-1||info.getBaseStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBaseStatus(EntryBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmFeedStockBillInfo info=(FarmFeedStockBillInfo)model;
		if(info.getBaseStatus()==null||info.getBaseStatus().getValue()==-1||info.getBaseStatus().equals(BillBaseStatusEnum.ADD)||info.getBaseStatus().getValue()==1) {
			info.setBaseStatus(EntryBaseStatusEnum.SUBMITED);
		}
		this._save(ctx, model);
//		this._audit(ctx, model);
		return super._submit(ctx, model);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		// TODO Auto-generated method stub
		FarmFeedStockBillInfo info=FarmFeedStockBillFactory.getLocalInstance(ctx).getFarmFeedStockBillInfo(pk);
		if (info.getBaseStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		super._delete(ctx, pk);
	}
}