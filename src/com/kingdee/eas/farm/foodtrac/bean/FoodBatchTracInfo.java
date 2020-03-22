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
 * �������ŵ�׷����Ϣ
 * @author USER
 *
 */
public class FoodBatchTracInfo implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1777182190723734813L;

	// ������Ϣ
	private BarCodeInfo barCodeInfo;
	/**
	 * ���α���  ������+��ֳ������
	 */
	private String batchNumber;
	// ������������
	private Date batchDate;
	// ��ֳ����Ϣ
	private  BreedStoorgSetInfo breedStoorgSetInfo;
	// ��Ӧ��ֳ����
	private BreedBatchInfo batchInfo;
	// ���ζ�Ӧ����
	private List<HenhouseInfo> henhouses;
	// �ձ���Ϣ
	private CommecialChilkenDailyCollection dailyInfos;
	// ���ϵ�����
	private StockTransferBillCollection fodderStockTransferBills;
	
	// ����
	private ManufactureRecBillCollection batchRecBills;
	
	/**
	 * ���캯�� ���� ������Ϣ
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
	 * ���JSON��ʽ��׷�ݽ��
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
			
			
			
			// �ձ��͵�����Ϣ������������洢
			LinkedHashMap<String,String> dailyInfos = new LinkedHashMap<String, String>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			// ����ձ���ϸ
			for(int i = 0; this.getDailyInfos() != null && i < this.getDailyInfos().size(); i++){
				CommecialChilkenDailyInfo dailyInfo = this.getDailyInfos().get(i);
				if(dailyInfo != null){
					Date bizdate = dailyInfo.getBizDate();
					String dateStr = sdf.format(bizdate);
					String detailInfo = dailyInfos.get(dateStr);
					if(StringUtils.isBlank(detailInfo)){
						detailInfo = "";
					}
					detailInfo = detailInfo + "����ֳ��־��"+ dailyInfo.getBreedLog();
					
					dailyInfos.put(dateStr, detailInfo);
					
				}
			}
			// TODO ������ϵ�����Ϣ
			// TODO ��� ������Ϣ
			// TODO ������Ҫ׷�ݵ���Ϣ
			
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
