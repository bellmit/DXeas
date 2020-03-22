package com.kingdee.eas.farm.breed.layegg.app;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.BreedFacadeFactory;
import com.kingdee.eas.farm.breed.BreedModelEntryCollection;
import com.kingdee.eas.farm.breed.BreedModelEntryFactory;
import com.kingdee.eas.farm.breed.BreedModelEntryInfo;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import com.kingdee.eas.farm.breed.BreedModelLayEggEntryCollection;
import com.kingdee.eas.farm.breed.BreedModelLayEggEntryFactory;
import com.kingdee.eas.farm.breed.BreedModelLayEggEntryInfo;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.farm.breed.comm.BreedCommonUtil;
import com.kingdee.eas.farm.breed.comm.LayEggStandardDetail;
import com.kingdee.eas.farm.breed.layegg.EggConveyorFactory;
import com.kingdee.eas.farm.breed.layegg.EggConveyorInfo;
import com.kingdee.eas.farm.breed.layegg.LayEggHouseSetFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingFacadeFactory;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class LayEggFacadeControllerBean extends AbstractLayEggFacadeControllerBean
{


	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.breed.layegg.app.LayEggFacadeControllerBean");

	/**
	 * 根据鸡舍id获得对应的  产蛋设置信息
	 */
	@Override
	protected Object _getHouseLayEggSet(Context ctx, String henhouseID)
	throws BOSException {
		String sql = "select fid from CT_FM_LayEggHouseSet where CFHenhouseID =?  ";
		String[] args = {henhouseID};

		try{
			IRowSet rs  = DbUtil.executeQuery(ctx, sql, args);
			if(rs.next()){
				String fid = rs.getString("fid");

				return LayEggHouseSetFactory.getLocalInstance(ctx).getLayEggHouseSetInfo(new ObjectUuidPK(fid));

			}

			return null;
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		} catch (EASBizException e) {
			//			e.printStackTrace();
			throw new BOSException(e);
		}
	}

	/**
	 * 根据库存组织id获得 对应的所有 传送带
	 */
	@Override
	protected List _getConveyors(Context ctx, String stoOrgID)
	throws BOSException {
		String sql = "select fid from CT_FM_EggConveyor where CFStorageOrgID =? order by fnumber";
		String[] args = {stoOrgID};
		List conveyor = new ArrayList();
		try{
			IRowSet rs  = DbUtil.executeQuery(ctx, sql, args);
			while(rs.next()){
				String fid = rs.getString("fid");

				EggConveyorInfo conveyorInfo = EggConveyorFactory.getLocalInstance(ctx).getEggConveyorInfo(new ObjectUuidPK(fid));
				// 所有 设置都添加到里面
				conveyor.add(conveyorInfo);

			}

			return conveyor;
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		} catch (EASBizException e) {
			//			e.printStackTrace();
			throw new BOSException(e);
		}
	}

	/**
	 * 获得指定类型 产蛋鸡养殖规范 的 产蛋 规范
	 * 
	 * Key  周龄
	 * Value  产蛋计划  分录 
	 */
	@Override
	protected Map _getLayeggStandard(Context ctx, String henType)
	throws BOSException {
		Map<String,BreedModelLayEggEntryInfo> standards = new HashMap<String, BreedModelLayEggEntryInfo>();
		// TODO 加载明细信息
		if("1".equals(henType)){
			BreedModelInfo breedModelInfo = BreedFacadeFactory.getLocalInstance(ctx).getBreedModelByHouseType(HenhouseType.LAYEGG_VALUE);
			if(breedModelInfo != null){
				BreedModelLayEggEntryCollection layEggStandards = breedModelInfo.getLayEggEntrys();
				// 产蛋计划分录
				if(layEggStandards != null && layEggStandards.size() > 0){
					for(int i = 0; i < layEggStandards.size(); i++){

						BreedModelLayEggEntryInfo layStandard = layEggStandards.get(i);
						try{
							layStandard = BreedModelLayEggEntryFactory.getLocalInstance(ctx).getBreedModelLayEggEntryInfo(new ObjectUuidPK(layStandard.getId()));

							//							LayEggStandardDetail detail = new LayEggStandardDetail();
							standards.put(BreedCommonUtil.getWeekDayStr(layStandard.getWeek(), layStandard.getDays()), layStandard);
						}catch(EASBizException e){
							e.printStackTrace();
							throw new BOSException(e);
						}
					}
				}
			}
		}
		return standards;
	}



	/**
	 * 获得指定类型养殖场 的 喂饲 规范
	 * Key  周日龄
	 * henType='1'产蛋厂
	 * henType='2'商品鸡场
	 */
	@Override
	protected Map _getFeedStandard(Context ctx, String henType) throws BOSException {
		// TODO Auto-generated method stub
		Map<String,BreedModelEntryInfo> standards = new HashMap<String, BreedModelEntryInfo>();
		// TODO 加载明细信息
		BreedModelInfo breedModelInfo=null;
		//产蛋厂饲喂规范
		if("1".equals(henType))
			breedModelInfo = BreedFacadeFactory.getLocalInstance(ctx).getBreedModelByHouseType(HenhouseType.LAYEGG_VALUE);
		//商品鸡场饲喂规范
		else if("3".equals(henType))
			breedModelInfo = BreedFacadeFactory.getLocalInstance(ctx).getBreedModelByHouseType(HenhouseType.CC_VALUE);
		if(breedModelInfo != null){
			BreedModelEntryCollection feedStandards = breedModelInfo.getEntrys();
			if(feedStandards != null && feedStandards.size() > 0){
				for(int i = 0; i < feedStandards.size(); i++){
					BreedModelEntryInfo feedStandard = feedStandards.get(i);
					try{
						feedStandard = BreedModelEntryFactory.getLocalInstance(ctx).getBreedModelEntryInfo(new ObjectUuidPK(feedStandard.getId()));
						if("1".equals(henType))
							standards.put(BreedCommonUtil.getWeekStr(feedStandard.getWeek()), feedStandard);
						//if("3".equals(henType))
						//	standards.put(BreedCommonUtil.getWeekDayStr(feedStandard.getWeek(),feedStandard.getWeekDay()), feedStandard);
					}catch(EASBizException e){
						e.printStackTrace();
						throw new BOSException(e);
					}
				}
			}
		}		
		return standards;
	}

	/**
	 * 
	 */
	protected void _getLayEggPlanEntryInfos(Context ctx) throws BOSException {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 判断指定批次是否 已经定栏
	 */
	@Override
	protected boolean _isBatchFixed(Context ctx, String batchID, Date bizDate)
			throws BOSException {
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sb.append("select max(CFIsFixed) isFixed from CT_FM_LayEggDaily where CFParentBatchID ='");
		sb.append(batchID);
		sb.append("' and FBizDate <{ ts '");
		sb.append(sdf.format(bizDate));
		sb.append("'}");
		
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			if(rs.next()){
				Boolean isfixed = rs.getBoolean("isFixed");
				return isfixed;
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
		return false;
	}

	@Override
	protected void _toStockDaily(Context ctx) throws BOSException {
		// TODO Auto-generated method stub
		String Layeggid = "";
		LayeggtoStockDaily(Layeggid);
		StockingFacadeFactory.getLocalInstance(ctx).Internal2StockingDaily("lwwAAAAACUzM567U");
		super._toStockDaily(ctx);
	}

	private void LayeggtoStockDaily(String Layeggid) {
		// TODO Auto-generated method stub
		System.out.println("转换开始");
		
		
		
		
		
	}




}