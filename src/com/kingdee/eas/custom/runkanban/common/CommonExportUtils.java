package com.kingdee.eas.custom.runkanban.common;

import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class CommonExportUtils {

	public static String getDataFromJsonCondition(Context ctx, String userNum,
			 String queryType, String paramStr) {
		String result="";
		//养殖场——商品鸡场——全部数据
		if(queryType.equalsIgnoreCase("FFCCAD")){
			//FeedFactoryCommicalChickenAllData
			result=CommicalChicken.FFCCAD(ctx,paramStr);
		}
		//养殖场——种鸡场——全部数据
		if(queryType.equalsIgnoreCase("FFBHAD")){
			//FeedFactoryBreedingHenAllData
			result=BreedingHen.FFBHAD(ctx,paramStr);
		}
		//养殖场——孵化场——全部数据
		if(queryType.equalsIgnoreCase("FFHAD")){
			//FeedFactoryHatchAllData
			result=Hatch.FFHAD(ctx,paramStr);
		}
        //食品厂-全部数据
		if(queryType.equalsIgnoreCase("FFAD")){
			//FoodFactoryAllData
			result=Food.FFAD(ctx,paramStr);
		}
		//饲料厂-全部数据
		if(queryType.equalsIgnoreCase("FMAD")){
			//FeedMillAllData
			result=Fodder.FMAD(ctx,paramStr);
		}
		//养殖场-商品鸡场各场存栏量明细
		if(queryType.equalsIgnoreCase("FFCCBSD")){
			result=CommicalChicken.BreedingstockDetails(ctx,paramStr);
		}
		//养殖场-育成存栏与初始入栏母鸡批次汇总,育成场明细数据
		if(queryType.equalsIgnoreCase("HatchFactoryDetailsData")){
			result=BreedingHen.HatchFactoryDetailsData(ctx,paramStr);
		}
		//养殖场-产蛋数据按年月日统计批次汇总，产蛋场明细数据
		if(queryType.equalsIgnoreCase("LayEggsFactoryDetailsData")){
			result=BreedingHen.LayEggsFactoryDetailsData(ctx,paramStr);
		}
		//养殖场-商品鸡本月截止到今天的出栏数量汇总
		if(queryType.equalsIgnoreCase("CCMonthMarketSummary")){
			result=CommicalChicken.ccCurrentMonthMarketSummary(ctx, paramStr);
		}
		//养殖场-商品鸡批次汇总全部数据
		if(queryType.equalsIgnoreCase("BreedBatchSummaryAllData")){
			result=CommicalChicken.BreedBatchSummaryAllData(ctx, paramStr);
		}
		//养殖场-鸡场养殖只数统计(出栏数据统计)
		if(queryType.equalsIgnoreCase("farmBreedQtyStatistic")){
			result=CommicalChicken.farmBreedQtyStatistic(ctx, paramStr);
		}
		
		
		//食品厂库存冷冻冰鲜汇总
		if(queryType.equalsIgnoreCase("foodInventorySummary")){
			result=Food.foodInventorySummary(ctx, paramStr);
		}
		//食品厂库存明细分类合计
		if(queryType.equalsIgnoreCase("foodInventoryDetails")){
			result=Food.foodInventoryDetails(ctx, paramStr);
		}
		
		//食品厂-月销量统计-按物料大类（冰鲜冷冻类）
		if(queryType.equalsIgnoreCase("foodMonthSaleSummary")){
			result=Food.foodMonthSaleSummary(ctx,paramStr);
		}
		//食品厂-月销量统计-按物料小类（腿类翅类）
		if(queryType.equalsIgnoreCase("foodMonthSaleDetails")){
			result=Food.foodMonthSaleDetails(ctx,paramStr);
		}
		
		
		return result;
	}
	
	

}
