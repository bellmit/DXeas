package com.kingdee.eas.farm.foodtrac.app;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.farm.breed.BreedFacadeFactory;
import com.kingdee.eas.farm.breed.BreedStoorgSetInfo;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.IBreedFacade;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyCollection;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyFactory;
import com.kingdee.eas.farm.foodtrac.bean.BarCodeInfo;
import com.kingdee.eas.farm.foodtrac.bean.FoodBatchTracInfo;
import com.kingdee.eas.scm.im.inv.StockTransferBillCollection;
import com.kingdee.eas.scm.im.inv.StockTransferBillInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.jdbc.rowset.IRowSet;

public class traceFacadeControllerBean extends AbstracttraceFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.foodtrac.app.traceFacadeControllerBean");

    /**
     * 获取批号生产明细
     */
	@Override
	protected String _getBatchDetailInfos(Context ctx, String batchCode)
			throws BOSException {
		FoodBatchTracInfo traeInfo = this.searchBatchTracInfos(ctx, batchCode);
		
		
		return traeInfo.getBatchTracInfo_JSON();
	}
    
    
	/**
	 * 查询批次明细信息
	 * @param ctx
	 * @param batchNumber
	 * @return
	 * @throws BOSException 
	 */
	private FoodBatchTracInfo searchBatchTracInfos(Context ctx,String batchCode) throws BOSException{
		
		IBreedFacade breedFacade = BreedFacadeFactory.getLocalInstance(ctx);
		
		// 追溯结果
		FoodBatchTracInfo batchTracInfo = new FoodBatchTracInfo(ctx,batchCode);
		// 条码信息
		BarCodeInfo barCodeInfo = batchTracInfo.getBarCodeInfo();
		// 生产日期
		Date productDate = batchTracInfo.getBarCodeInfo().getProductDate();
		
		// 获得 养殖场编号对应的养殖场、库存组织
		BreedStoorgSetInfo farmOrgInfo = AppCommon.getFarmOrgByCode(ctx, batchTracInfo.getBarCodeInfo().getFarmCode());
		
		if(farmOrgInfo != null){
			batchTracInfo.setBreedStoorgSetInfo(farmOrgInfo);
			// 获取 养殖场库存组织   id\number\name 
			StorageOrgUnitInfo stoOrgInfo = farmOrgInfo.getStoOrg();
			
			// 设置批次
			BreedBatchInfo breedBatch = breedFacade.getBreedBatchByOrgAndOutDate(stoOrgInfo.getId().toString(), productDate);
			batchTracInfo.setBatchInfo(breedBatch);
			if(breedBatch != null){
				// 鸡舍信息
				List<HenhouseInfo> henhouseInfos = getHenhouseInfos(ctx,breedBatch.getId().toString(),productDate);
				batchTracInfo.setHenhouses(henhouseInfos);
				// 获取日报信息
				CommecialChilkenDailyCollection dailyColl = getCCDailyInfos(ctx,breedBatch.getId().toString());
				
				batchTracInfo.setDailyInfos(dailyColl);
				
				// 饲料调拨信息
				StockTransferBillCollection transferCol = getFolderTransferCol(ctx,breedBatch.getCostObject().getId().toString());
				batchTracInfo.setFodderStockTransferBills(transferCol);
				
				
				
			}
			
		}
		
		return batchTracInfo;
		
	}

	/**
	 * 获取饲料调拨信息
	 * 
	 * @param ctx
	 * @param string
	 * @return
	 * @throws BOSException 
	 */
	private StockTransferBillCollection getFolderTransferCol(Context ctx,
			String costobjectid) throws BOSException {
		// 饲料调拨信息 获取调拨单 重量 数量  日期
		
		StringBuilder sb = new StringBuilder();
		sb.append("select t.fid,t.fbizdate,t.fnumber from T_IM_StockTransferBill t where t.cfcostobjectid=?");
		Object[] args = {costobjectid};
		StockTransferBillCollection transCol = new StockTransferBillCollection();
		try{
			IRowSet rs = DbUtil.executeQuery(ctx,sb.toString(), args);
			while(rs.next()){
				String fid = rs.getString("fid");
				Date bizdate = rs.getDate("fbizdate");
				String number = rs.getString("fnumber");
				StockTransferBillInfo info = new StockTransferBillInfo();
				info.setId(BOSUuid.read(fid));
				info.setNumber(number);
				info.setBizDate(bizdate);
				
				transCol.add(info);
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
		
		return transCol;
	}


	/**
	 * 根据批次ID获取所有日报列表
	 * @param ctx
	 * @param string
	 * @return
	 * @throws BOSException 
	 */
	private CommecialChilkenDailyCollection getCCDailyInfos(Context ctx,
			String batchID) throws BOSException {
		
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo fi = new FilterInfo();
		fi.getFilterItems().add(new FilterItemInfo("breedBatch.id",batchID,CompareType.EQUALS));
		
		SorterItemCollection sorterCol = new SorterItemCollection();
		// 按日期排序
		sorterCol.add(new SorterItemInfo("bizdate"));
		
		evi.setSorter(sorterCol);
		evi.setFilter(fi);
		
		CommecialChilkenDailyCollection dailyInfos = CommecialChilkenDailyFactory.getLocalInstance(ctx).getCommecialChilkenDailyCollection(evi);
		return dailyInfos;
	}


	/**
	 * 根据宰杀日期 和批次获得当天出库的批次 鸡舍
	 * @param ctx
	 * @param breedBatch
	 * @param productDate
	 * @return
	 * @throws BOSException 
	 */
	private List<HenhouseInfo> getHenhouseInfos(Context ctx,
			String  batchId, Date productDate) throws BOSException {
		// 结果集
		List<HenhouseInfo> henhouses = new ArrayList<HenhouseInfo>();
		
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select te.cfhenhouseid, ");
		sql.append("    th.fnumber henhouseNumber, ");
        sql.append("    th.cfname henhouseName ");

        sql.append(" from ct_fm_commecialchilkendaily t  ");
		sql.append(" inner join ct_fm_commecialcdae te on te.fparentid = t.fid ");
		sql.append(" inner join ct_fm_henhouse th on te.cfhenhouseid = th.fid ");
		sql.append(" where te.CFMarketQty >0 and t.to_char(t.fbizdate,'yyyy-mm-dd') = ? and t.cfbreedbatchid=?");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Object[] args = {sdf.format(productDate),batchId};
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString(),args);
			
			while(rs.next()){
				String cfhenhouseid = rs.getString("cfhenhouseid");
				String henhouseNumber = rs.getString("henhouseNumber");
				String henhouseName = rs.getString("henhouseName");
				
				HenhouseInfo info = new HenhouseInfo();
				info.setId(BOSUuid.read(cfhenhouseid));
				info.setNumber(henhouseNumber);
				info.setName(henhouseName);
				
				henhouses.add(info);
				
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
		
		return henhouses;
	}

//	/**
//	 * 根据 批次信息获得对应的 出雏单  列表信息
//	 */
//	@Override
//	protected List<HatchBabyBillInfo> _getBatchHatchBills(Context ctx, BreedBatchInfo batchInfo)
//			throws BOSException {
//		ArrayList<HatchBabyBillInfo> hatchInfos = new ArrayList<HatchBabyBillInfo>();
//		// 从批次明细获得 入栏日期和 养殖场，然后 返回对应的 出雏单
//		if(batchInfo != null){
//			StorageOrgUnitInfo farmInfo = batchInfo.getStoOrg();
//			
//			// 查询批次 入栏日期
//			StringBuilder sb = new StringBuilder();
//			sb.append("select distinct te.CFIncoopDate from  CT_FM_BreedBatchEntry te where te.fparentid='");
//			sb.append(batchInfo.getId().toString());
//			sb.append("'");
//			
//			
//			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
//			List<Date> incoopDates = new ArrayList<Date>();
//			try{
//				while(rs.next()){
//					Date incoopDate = rs.getDate("CFIncoopDate");
//					// 逐个日期 获得对应的入栏日期
//					incoopDates.add(incoopDate);
//					
//				}
//				StringBuilder dateStr = new StringBuilder("(");
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				for(int i = 0; i < incoopDates.size(); i++){
//					dateStr.append("'").append(sdf.format(incoopDates.get(i))).append("',");
//					
//				}
//				String dateTJ = dateStr.toString();
//				if(dateStr.length() > 1) {
//					dateTJ = dateTJ.substring(0, dateTJ.length() - 1);
//				}
//				dateTJ = dateTJ + ")";
//				
//				// 如果存在出雏单信息则 根据 养殖场和入栏日期查询出雏单，获得满足条件的出雏信息
//				StringBuilder hsql = new StringBuilder();
//				hsql.append("select fid from CT_FM_HatchBabyBill where  CFCommercialStoorg ='");
//				hsql.append(farmInfo.getId().toString());
//				hsql.append("' and to_char(FBizDate,'yyyy-mm-dd') in ");
//				hsql.append(dateTJ);
//				
//				IRowSet hatchRS = DbUtil.executeQuery(ctx, hsql.toString());
//				while(hatchRS.next()){
//					String fid = hatchRS.getString("fid");
//					
//					hatchInfos.add(HatchBabyBillFactory.getLocalInstance(ctx).getHatchBabyBillInfo(new ObjectUuidPK(fid)));
//				}
//				
//			}catch(SQLException sqle){
//				throw new BOSException(sqle);
//			} catch (EASBizException e) {
//				
//				e.printStackTrace();
//				throw new BOSException(e);
//			}
//		}
//		
//		return hatchInfos;
//	}

}