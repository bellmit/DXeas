package com.kingdee.eas.farm.stocking.basedata.app;

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
import com.kingdee.eas.farm.stocking.basedata.StockingBRelationInfo;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basedata.StockingBRelationCollection;
import com.kingdee.eas.farm.stocking.processbizill.TranOutEntryCollection;
import com.kingdee.eas.farm.stocking.processbizill.TranOutEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.TranOutInfo;
import com.kingdee.eas.farm.stocking.processbizill.wzBillBaseStatus;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class StockingBRelationControllerBean extends AbstractStockingBRelationControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.stocking.basedata.app.StockingBRelationControllerBean");

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		StockingBRelationInfo info = (StockingBRelationInfo)model;
		info.setBaseStatus(wzBillBaseStatus.audit);
		try {
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw  new BOSException(e);
		}
		super._audit(ctx, model);
	}
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StockingBRelationInfo info = (StockingBRelationInfo)model;
		if(info.getBaseStatus()==null||info.getBaseStatus().equals(wzBillBaseStatus.add)) {
			info.setBaseStatus(wzBillBaseStatus.save);
		}
		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StockingBRelationInfo info = (StockingBRelationInfo)model;
		if(info.getBaseStatus()==null||info.getBaseStatus().equals(wzBillBaseStatus.add)||info.getBaseStatus().equals(wzBillBaseStatus.save)) {
			info.setBaseStatus(wzBillBaseStatus.submit);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		}
		return super._submit(ctx, model);
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		StockingBRelationInfo info = (StockingBRelationInfo)model;
		info.setBaseStatus(wzBillBaseStatus.save);
		try {
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw  new BOSException(e);
		}
		super._unAudit(ctx, model);
	}

}