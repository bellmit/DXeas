package com.kingdee.eas.farm.breed.app;

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

import com.kingdee.eas.farm.breed.BreedStoorgSetCollection;
import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.farm.breed.BreedStoorgSetInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BreedStoorgSetControllerBean extends AbstractBreedStoorgSetControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.app.BreedStoorgSetControllerBean");
    

	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		super._cancel(ctx, pk, model);
	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		super._cancelCancel(ctx, pk, model);
	}

	/**
	 * 删除
	 */
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		// 判断鸡舍是否已经 有过养殖批次 ，如果已经有过那么  则不允许删除
		String sql = "select 1 from CT_FM_ParentBreedBatch where CFfarmID =? ";
		String[] args = {pk.toString()};
		
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
			if(rs.next()){
				throw  new EASBizException(new NumericExceptionSubItem("001","当前养殖场基础设置已经被【养殖批次】引用，不能删除。"));
				
			}
		}catch(BOSException e){
			e.printStackTrace();
			throw new FarmException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FarmException(e);
		}
		super._delete(ctx, pk);
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		
		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		
		return super._submit(ctx, model);
	}
}