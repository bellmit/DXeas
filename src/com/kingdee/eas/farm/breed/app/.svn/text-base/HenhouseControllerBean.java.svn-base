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

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.HenhouseCollection;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class HenhouseControllerBean extends AbstractHenhouseControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.app.HenhouseControllerBean");

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
		String sql = "select 1 from CT_FM_BreedBatchEntry where CFHenHouseID =? ";
		String[] args = {pk.toString()};
		
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
			if(rs.next()){
				throw  new EASBizException(new NumericExceptionSubItem("001","当前鸡舍已经被【养殖批次】引用，不能删除。"));
				
			}else{
				// 校验 鸡舍 是否 被育成 或者 产蛋 、养殖 鸡舍 引用，被引用 则 不能删除
				sql = "select 1 from CT_FM_BroodCoopSet where CFHenhouseID =? ";
				String[] args1 = {pk.toString()};
				IRowSet rs1 = DbUtil.executeQuery(ctx, sql, args);
				if(rs1.next()){
					throw  new EASBizException(new NumericExceptionSubItem("001","当前鸡舍已经被【育成鸡舍设置】引用，不能删除。"));
				}else{
					sql = "select 1 from CT_FM_LayEggHouseSet where CFHenhouseID =? ";
					String[] args2 = {pk.toString()};
					IRowSet rs2 = DbUtil.executeQuery(ctx, sql, args);
					if(rs2.next()){
						throw  new EASBizException(new NumericExceptionSubItem("001","当前鸡舍已经被【产蛋鸡舍设置】引用，不能删除。"));
					}else{
//						sql = "select 1 from CT_FM_LayEggHouseSet where CFHenhouseID =? ";
//						String[] args3 = {pk.toString()};
//						IRowSet rs3 = DbUtil.executeQuery(ctx, sql, args);
//						if(rs2.next()){
//							throw new FarmException("当前鸡舍已经被【商品鸡舍设置】引用，不能删除。");
//						}
					}
				}
				
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
		// 校验
		checkLayeggConviyer(ctx, model);
		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// 校验
		checkLayeggConviyer(ctx, model);
		return super._submit(ctx, model);
	}
    
    /**
     * 鸡舍 保存或者提交时校验必填项 
     * @param ctx
     * @param henhouseInfo
     * @throws EASBizException 
     */
	private void checkLayeggConviyer(Context ctx, IObjectValue model) throws EASBizException{
		
		HenhouseInfo henhouseInfo = (HenhouseInfo)model;
		
		if(henhouseInfo != null ){
			if(henhouseInfo.getHouseType() != null){
				
				
				// 产蛋鸡舍
				if(HenhouseType.LayEgg.equals(henhouseInfo.getHouseType())){
					if(henhouseInfo.getConveyor() == null){
						throw  new EASBizException(new NumericExceptionSubItem("001","产蛋鸡舍传送带不能为空不能为空"));
					}
				}
			}else{
				throw  new EASBizException(new NumericExceptionSubItem("001","鸡舍类别不能为空"));
			}
		}
	}
	
	
	
}