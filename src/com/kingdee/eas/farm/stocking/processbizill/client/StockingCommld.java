package com.kingdee.eas.farm.stocking.processbizill.client;

import java.util.Date;

import com.kingdee.eas.farm.stocking.basedata.FarmStageEnum;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;

public class StockingCommld {

	/**
	 * 根据批次和日期获取批次在改日期的阶段
	 * @param stockingBatchInfo
	 * @param bizDate
	 * @return
	 */
	public static FarmStageEnum getCurrentBreedState(
			StockingBatchInfo stockingBatchInfo, Date bizDate) {
		// TODO Auto-generated method stub
		FarmStageEnum currentState=FarmStageEnum.brood;
		if(stockingBatchInfo.getBreedDate()!=null&&!stockingBatchInfo.getBreedDate().after(bizDate)) {
			currentState=FarmStageEnum.breed;
		}
		if(stockingBatchInfo.getMatureDate()!=null&&stockingBatchInfo.getMatureDate().after(bizDate)) {
			currentState=FarmStageEnum.eggs;
		}
		if(stockingBatchInfo.getBreedDate()==null&&stockingBatchInfo.getMatureDate()==null) {
			currentState=FarmStageEnum.brood;
		}
		return currentState;
	}

	/**
	 * 获取当前批次是否在改日期之前转正
	 * @param batchInfo
	 * @param bizDate
	 * @return
	 */
	public static boolean getIsFormalBatch(
			StockingBatchInfo batchInfo, Date bizDate) {
		// TODO Auto-generated method stub
		if(batchInfo.getFormalDate()!=null&&!batchInfo.getFormalDate().after(bizDate))
			return true;
		else
			return false;
	}

}
