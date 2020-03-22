package com.kingdee.eas.farm.foodtrac.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.farm.breed.BreedStoorgSetInfo;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyCollection;
import com.kingdee.eas.farm.breed.business.CommecialChilkenDailyInfo;
import com.kingdee.eas.scm.im.inv.ManufactureRecBillCollection;
import com.kingdee.eas.scm.im.inv.StockTransferBillCollection;
/**
 * 单个批号的追溯信息
 * @author USER
 *
 */
public class FoodBatchTracInfo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1777182190723734813L;

	// 条码信息
	private BarCodeInfo barCodeInfo;
	/**
	 * 批次编码  年月日+养殖场代码
	 */
	private String batchNumber;
	// 批次所在日期
	private Date batchDate;
	// 养殖场信息
	private  BreedStoorgSetInfo breedStoorgSetInfo;
	// 对应养殖批次
	private BreedBatchInfo batchInfo;
	// 批次对应鸡舍
	private List<HenhouseInfo> henhouses;
	// 日报信息
	private CommecialChilkenDailyCollection dailyInfos;
	// 饲料调拨单
	private StockTransferBillCollection fodderStockTransferBills;
	
	// 鸡苗
	private ManufactureRecBillCollection batchRecBills;
	
	/**
	 * 构造函数 传入 条码信息
	 * @param ctx
	 * @param batchCode
	 * @throws BOSException
	 */
	public FoodBatchTracInfo(Context ctx,String batchCode) throws BOSException{
		this.barCodeInfo = new BarCodeInfo(ctx,batchCode);
//		this.setBatchNumber(barCodeInfo.getBarcode());
		this.setBatchDate(barCodeInfo.getProductDate());
		
	}
	/**
	 * 获得JSON格式的追溯结果
	 * 
	 * @return
	 */
	public String getBatchTracInfo_JSON(){
		Gson gson = new Gson();
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("productNumber", this.getBarCodeInfo().getProductNumber());
		resultMap.put("productName", this.getBarCodeInfo().getProductName());
		resultMap.put("productDate", this.getBarCodeInfo().getProductDateStr());
		resultMap.put("productModel", this.getBarCodeInfo().getModel());
		if(this.getBatchInfo() != null){
			resultMap.put("farmName", this.getBreedStoorgSetInfo().getName());
			resultMap.put("farmAddress", this.getBreedStoorgSetInfo().getAddress());
			
			
			resultMap.put("breedBatchNumber", this.getBatchNumber());
			
			
			
			// 日报和调拨信息按照日期排序存储
			LinkedHashMap<String,String> dailyInfos = new LinkedHashMap<String, String>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			// 添加日报明细
			for(int i = 0; this.getDailyInfos() != null && i < this.getDailyInfos().size(); i++){
				CommecialChilkenDailyInfo dailyInfo = this.getDailyInfos().get(i);
				if(dailyInfo != null){
					Date bizdate = dailyInfo.getBizDate();
					String dateStr = sdf.format(bizdate);
					String detailInfo = dailyInfos.get(dateStr);
					if(StringUtils.isBlank(detailInfo)){
						detailInfo = "";
					}
					detailInfo = detailInfo + "【养殖日志】"+ dailyInfo.getBreedLog();
					
					dailyInfos.put(dateStr, detailInfo);
					
				}
			}
			// TODO 添加饲料调拨信息
			// TODO 添加 鸡苗信息
			// TODO 其他需要追溯的信息
			
			resultMap.put("dailyInfos", dailyInfos);
		}
		
		String result = gson.toJson(resultMap);
		
		
		return result;
	}

	public String getBatchNumber() {
		if(org.apache.commons.lang.StringUtils.isNotBlank(batchNumber)){
			return batchNumber;
		}else if(batchInfo != null){
			return batchInfo.getNumber();
		}else {
			return batchNumber;
		}
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public Date getBatchDate() {
		return batchDate;
	}

	public void setBatchDate(Date batchDate) {
		this.batchDate = batchDate;
	}

	public BreedBatchInfo getBatchInfo() {
		return batchInfo;
	}

	public void setBatchInfo(BreedBatchInfo batchInfo) {
		this.batchInfo = batchInfo;
		
	}

	public List<HenhouseInfo> getHenhouses() {
		return henhouses;
	}

	public void setHenhouses(List<HenhouseInfo> henhouses) {
		this.henhouses = henhouses;
	}
	
	public void setBarCodeInfo(BarCodeInfo barCodeInfo) {
		this.barCodeInfo = barCodeInfo;
	}

	public BarCodeInfo getBarCodeInfo() {
		return barCodeInfo;
	}
	public void setBreedStoorgSetInfo(BreedStoorgSetInfo breedStoorgSetInfo) {
		this.breedStoorgSetInfo = breedStoorgSetInfo;
	}
	public BreedStoorgSetInfo getBreedStoorgSetInfo() {
		return breedStoorgSetInfo;
	}
	public CommecialChilkenDailyCollection getDailyInfos() {
		return dailyInfos;
	}
	public void setDailyInfos(CommecialChilkenDailyCollection dailyInfos) {
		this.dailyInfos = dailyInfos;
	}
	public StockTransferBillCollection getFodderStockTransferBills() {
		return fodderStockTransferBills;
	}
	public void setFodderStockTransferBills(
			StockTransferBillCollection fodderStockTransferBills) {
		this.fodderStockTransferBills = fodderStockTransferBills;
	}
	public ManufactureRecBillCollection getBatchRecBills() {
		return batchRecBills;
	}
	public void setBatchRecBills(ManufactureRecBillCollection batchRecBills) {
		this.batchRecBills = batchRecBills;
	}
	
	
	
	
}
