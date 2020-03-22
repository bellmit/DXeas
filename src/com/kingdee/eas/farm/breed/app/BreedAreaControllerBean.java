package com.kingdee.eas.farm.breed.app;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class BreedAreaControllerBean extends AbstractBreedAreaControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.app.BreedAreaControllerBean");
    

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
		String sql = "select 1 from CT_FM_Henhouse where CFBreedAreaID =? ";
		String[] args = {pk.toString()};
		
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
			if(rs.next()){
				throw  new EASBizException(new NumericExceptionSubItem("001","当前区已经在 禽舍引用，不能删除。"));
				
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