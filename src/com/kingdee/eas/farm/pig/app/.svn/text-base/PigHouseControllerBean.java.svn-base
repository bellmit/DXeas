package com.kingdee.eas.farm.pig.app;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.pig.DisableState;
import com.kingdee.eas.farm.pig.PigHouseInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class PigHouseControllerBean extends AbstractPigHouseControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.pig.app.PigHouseControllerBean");
    
    
    @Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model)
			throws BOSException, EASBizException {
		super._cancel(ctx, pk, model);
	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model)
			throws BOSException, EASBizException {
		super._cancelCancel(ctx, pk, model);
	}

	/**
	 * 删除
	 */
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		// 判断禽舍是否已经 有过养殖批次 ，如果已经有过那么  则不允许删除
		String sql = "select 1 from CT_PIG_CCPigDailyEntry where CFPigHouseID =? ";
		String[] args = {pk.toString()};
		
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
			if(rs.next()){
				throw  new EASBizException(new NumericExceptionSubItem("001","当前猪舍已经被【商品猪日报】引用，不能删除。"));
				
			}else{
//				// 校验 禽舍 是否 被育成 或者 产蛋 、养殖 禽舍 引用，被引用 则 不能删除
//				sql = "select 1 from CT_FM_BroodCoopSet where CFHenhouseID =? ";
//				String[] args1 = {pk.toString()};
//				IRowSet rs1 = DbUtil.executeQuery(ctx, sql, args);
//				if(rs1.next()){
//					throw  new EASBizException(new NumericExceptionSubItem("001","当前禽舍已经被【育成禽舍设置】引用，不能删除。"));
//				}else{
//					sql = "select 1 from CT_FM_LayEggHouseSet where CFHenhouseID =? ";
//					String[] args2 = {pk.toString()};
//					IRowSet rs2 = DbUtil.executeQuery(ctx, sql, args);
//					if(rs2.next()){
//						throw  new EASBizException(new NumericExceptionSubItem("001","当前禽舍已经被【产蛋禽舍设置】引用，不能删除。"));
//					}else{
////						sql = "select 1 from CT_FM_LayEggHouseSet where CFHenhouseID =? ";
////						String[] args3 = {pk.toString()};
////						IRowSet rs3 = DbUtil.executeQuery(ctx, sql, args);
////						if(rs2.next()){
////							throw new FarmException("当前禽舍已经被【商品禽舍设置】引用，不能删除。");
////						}
//					}
//				}
				
			}
		}catch(BOSException e){
			e.printStackTrace();
			throw new BOSException(e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BOSException(e);
		}
		super._delete(ctx, pk);
	}

	/**
	 * 保存时 如果 状态为空 则默认为 启用
	 */
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		setDefaultInfos(model);
		return super._save(ctx, model);
	}

	/**
	 * 状态默认启用
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		setDefaultInfos(model);
		return super._submit(ctx, model);
	}
	
	/**
	 * 设置默认值
	 * @param model
	 * @return
	 */
	private PigHouseInfo setDefaultInfos(IObjectValue model){
		PigHouseInfo houseInfo = (PigHouseInfo) model;
		
		if(houseInfo.getDeletedStatus() == null){
			houseInfo.setDeletedStatus(DisableState.Enable);
		}
		
		if(houseInfo.getPigFarm() != null && houseInfo.getPigFarm().getStoOrgUnit() != null && houseInfo.getStoOrg() == null){
			houseInfo.setStoOrg(houseInfo.getPigFarm().getStoOrgUnit());
		}
		return houseInfo;
	}

}