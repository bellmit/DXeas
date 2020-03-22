package com.kingdee.eas.farm.carnivorous.webservice;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import com.kingdee.bos.*;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.basedata.assistant.IMeasureUnit;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commonld.app.WebServiceFacadeControllerBean;
import com.kingdee.eas.custom.commonld.comm.WebServiceComm;
import com.kingdee.eas.farm.carnivorous.basedata.BatchFactory;
import com.kingdee.eas.farm.carnivorous.basedata.BatchInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.IStockingDaily;
import com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyAssEntryInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyEntryInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyEnviInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyFactory;
import com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyImmuneEntryInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.common.BatchLastBean;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class WSStockingDailyFacadeControllerBean extends AbstractWSStockingDailyFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.carnivorous.webservice.WSStockingDailyFacadeControllerBean");

    private static final String bosType = "CA396C89";
	@Override
	protected String _createNewBill(Context ctx, String param) {
		// TODO Auto-generated method stub
		//定义了一个JSONObject对象
		JSONObject json = JSONObject.fromObject(param);
		if(!json.containsKey("bosType")){
			json.put("bosType",bosType);
		}
		return super._createNewBill(ctx, param);
	}

	@Override
	protected String _deleteBill(Context ctx, String param) {
		// TODO Auto-generated method stub
		return super._deleteBill(ctx, param);
	}

	@Override
/*
 * 获取单据的详细信息
 */
	protected String _getBillDetailInfo(Context ctx, String param) {
		// TODO Auto-generated method stub
		slorList = new String[]{"*","company.*","farmer.*","farm.*","batch.*","handler.*","auditor.*","creator.*","lastUpdateUser.*","cu.*"
//				,"eggEntry.*","eggEntry.material.*","EggEntry.unit.*","EggEntry.house.*"
				,"entrys.*","entrys.material.*","entrys.unit.*","entrys.house.*"
				,"AssEntrys.*","AssEntrys.house.*","AssEntrys.customer.*"
				,"ImmuneEntrys.*","ImmuneEntrys.VaccineMaterial.*","ImmuneEntrys.house.*"};
		return super._getBillDetailInfo(ctx, param);
	}

	@Override
	protected String _getBillList(Context ctx, String param) {
		// TODO Auto-generated method stub
		return super._getBillList(ctx, param);
	}

	@Override
	protected void afterCreateNewBill(Context ctx, IObjectPK pk,
			JSONObject entryJson) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		super.afterCreateNewBill(ctx, pk, entryJson);
		IStockingDaily instance = StockingDailyFactory.getLocalInstance(ctx);
		StockingDailyInfo info = instance.getStockingDailyInfo(pk);
		// 饲喂分录
		for(int i = info.getEntrys().size()-1;i>=0;i--)
			info.getEntrys().remove(info.getEntrys().get(i));
		JSONArray array = null;
		StockingDailyEntryInfo entryInfo;
		array = entryJson.getJSONArray("entrys");
		for(int i=0;i<array.size();i++){
			JSONObject elem= (JSONObject) array.get(i);
			Iterator keys = elem.keys();
			entryInfo = new StockingDailyEntryInfo();
			while(keys.hasNext()){
				String key = UIRuleUtil.getString(keys.next());
				if(elem.get(key) instanceof JSONObject)
					entryInfo.put(key,((JSONObject)elem.get(key)).getString("id"));
				else
					entryInfo.put(key,elem.get(key));
			}
			info.getEntrys().add(entryInfo);
		}


		//死淘信息分录
		for(int i = info.getAssEntrys().size()-1;i>=0;i--)
			info.getAssEntrys().remove(info.getAssEntrys().get(i));
		StockingDailyAssEntryInfo entryAssInfo;
		array = entryJson.getJSONArray("AssEntrys");
		for(int i=0;i<array.size();i++){
			JSONObject elem= (JSONObject) array.get(i);
			Iterator keys = elem.keys();
			entryAssInfo = new StockingDailyAssEntryInfo();
			while(keys.hasNext()){
				String key = UIRuleUtil.getString(keys.next());
				if(elem.get(key) instanceof JSONObject)
					entryAssInfo.put(key,((JSONObject)elem.get(key)).getString("id"));
				else
					entryAssInfo.put(key,elem.get(key));
			}
			info.getAssEntrys().add(entryAssInfo);
		}

		//免疫信息分录
		for(int i = info.getImmuneEntrys().size()-1;i>=0;i--)
			info.getImmuneEntrys().remove(info.getImmuneEntrys().get(i));
		StockingDailyImmuneEntryInfo entryImmueInfo;
		array = entryJson.getJSONArray("ImmuneEntrys");
		for(int i=0;i<array.size();i++){
			JSONObject elem= (JSONObject) array.get(i);
			Iterator keys = elem.keys();
			entryImmueInfo = new StockingDailyImmuneEntryInfo();
			while(keys.hasNext()){
				String key = UIRuleUtil.getString(keys.next());
				if(elem.get(key) instanceof JSONObject)
					entryImmueInfo.put(key,((JSONObject)elem.get(key)).getString("id"));
				else
					entryImmueInfo.put(key,elem.get(key));
			}
			info.getImmuneEntrys().add(entryImmueInfo);
		}
		//环控信息分录
		for(int i = info.getEnvi().size()-1;i>=0;i--)
			info.getEnvi().remove(info.getEnvi().get(i));
		StockingDailyEnviInfo entryEnviInfo;
		array = entryJson.getJSONArray("Envi");
		for(int i=0;i<array.size();i++){
			JSONObject elem= (JSONObject) array.get(i);
			Iterator keys = elem.keys();
			entryEnviInfo = new StockingDailyEnviInfo();
			while(keys.hasNext()){
				String key = UIRuleUtil.getString(keys.next());
				if(elem.get(key) instanceof JSONObject)
					entryEnviInfo.put(key,((JSONObject)elem.get(key)).getString("id"));
				else
					entryEnviInfo.put(key,elem.get(key));
			}
			info.getEnvi().add(entryEnviInfo);
		}
      
		instance.save(info);
	}

	@Override
	protected void beforeCreateNewBill(Context ctx, JSONObject dataJson,
			JSONObject entryJson) {
		// TODO Auto-generated method stub
		String [] entrysArray = new String[]{"entrys","AssEntrys","ImmuneEntrys","Envi"};
		for(int i = 0;i < entrysArray.length;i++){
			if(dataJson.containsKey(entrysArray[i]))
				entryJson.put(entrysArray[i],dataJson.getJSONArray(entrysArray[i]));
			else
				entryJson.put(entrysArray[i],new JSONArray());

			dataJson.put(entrysArray[i],new JSONArray());
		}
		super.beforeCreateNewBill(ctx, dataJson, entryJson);
	}

	@Override
	protected String beforeDealWithBill(String param) {
		// TODO Auto-generated method stub
		return WebServiceComm.setBosType(param, bosType);
	}

	@Override
	protected void initSlorList(String[] slorArray2) {
		// TODO Auto-generated method stub
		super.initSlorList(slorArray2);
	}

	@Override
	protected String _getDailyInitBillInfo(Context ctx, String param)
			throws BOSException {
		// TODO Auto-generated method stub
		JSONObject paramJson = JSONObject.fromObject(param);
		JSONObject resultjSon = new JSONObject();
		//传入批次，日期
		String batchID = paramJson.getString("stockingBatch");
		String bizDateStr = paramJson.getString("bizDate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date bizDate = null;
		try {
			bizDate = sdf.parse(bizDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//定义一个SelectorItemCollection用来获取批次中的某些字段的详细信息
		SelectorItemCollection slor=new SelectorItemCollection();
		slor.add("*");
		slor.add("farmer.*");
		slor.add("farm.*");
		slor.add("house.*");
		BatchInfo batchInfo = null;
		try {
			batchInfo = BatchFactory.getLocalInstance(ctx).getBatchInfo(new ObjectUuidPK(batchID),slor);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		// 养殖户
		JSONObject farmerJson = new JSONObject();
		farmerJson.put("name",batchInfo.getFarmer().getName());
		farmerJson.put("number",batchInfo.getFarmer().getNumber());
		farmerJson.put("id",batchInfo.getFarmer().getId().toString());
		resultjSon.put("farmer",farmerJson);
		//养殖场
		JSONObject farmJson = new JSONObject();
		farmJson.put("name",batchInfo.getFarm().getName());
		farmJson.put("number",batchInfo.getFarm().getNumber());
		farmJson.put("id",batchInfo.getIdentity().toString());
		resultjSon.put("farm",farmJson);



		//周日龄
		int[] result = new int[2];
		try {
			result = StockingComm.getBreedWeekAndDay(bizDate, batchInfo.getInDate());
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int week=result[0];
		int weekDay=result[1];
		resultjSon.put("week",week);
		resultjSon.put("weekDay",weekDay);


		//饲喂信息
		getBreedFodderStandard(ctx,resultjSon,batchInfo,batchInfo.getCompany().getString("id"),batchInfo.getBreedData().getString("id"), bizDate);


		// 死淘信息
		getBreedEntry(ctx,bizDate,resultjSon,batchInfo,batchInfo.getCompany().getString("id"),batchInfo.getBreedData().getString("id"), week, weekDay);


		//免疫标准
		getBreedDrugStandard(ctx,resultjSon,batchInfo, batchInfo.getBreedData().getString("id"), week, weekDay);


		return resultjSon.toString();
	}

	private void getBreedDrugStandard(Context ctx, JSONObject resultjSon,
			BatchInfo batchInfo, String breedDataID, int week, int weekDay) {
		
		// TODO Auto-generated method stub

		try {
			String companyID = batchInfo.getCompany().getString("id");
			if(StringUtils.isEmpty(batchInfo.getCompany().getString("id"))||StringUtils.isEmpty(breedDataID)) {
				return;
			}

			int dayAge=(week-1)*7+weekDay-1;
			StringBuffer sql=new StringBuffer();
			sql.append(" select tentry.FMaterialID,tentry.FUnitID,tentry.FQty")
			.append(" from T_FM_BreedStandard tmain ")
			.append(" inner join T_FM_BreedStandardDrugEntry tentry on tentry.fparentid=tmain.fid")
			.append(" where tmain.FCompanyID='").append(companyID).append("'")
			.append(" and FBreedDataID='").append(breedDataID).append("'")
			.append(" and FBaseStatus=3")//启用状态
			.append(" and (")
			//起始周日均大于当前
			.append(" (FWeek<=").append(week).append(" and FDays<=").append(weekDay).append(" ")
			//结束同周，日大于当前日
			.append(" and ((FEndWeek=").append(week).append(" and FEndDays>=").append(weekDay).append(" )")
			//周大于当前周
			.append(" or FEndWeek>").append(week).append(" ))")
			//0周 进行日龄判断
			.append(" or (FWeek=0 and FDays<=").append(dayAge).append(" and FEndWeek=0 and FEndDays>=").append(dayAge).append(")")
			.append(" )")
			.append(" order by tentry.FSeq")
			.append(" ");
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
			MaterialInfo mInfo;
			IMaterial ims = MaterialFactory.getLocalInstance(ctx);
			IMeasureUnit ius = MeasureUnitFactory.getLocalInstance(ctx);
			SelectorItemCollection slor=new SelectorItemCollection();
			slor.add("*");
			slor.add("baseUnit.*");
			FarmHouseEntryInfo fheInfo=new FarmHouseEntryInfo();

			int count=0;
//			LinkedList<FarmHouseEntryInfo> houseEntryList=getHouseIDListByBatch(ctx,batchInfo);
//			count=houseEntryList.size()<=0?1:houseEntryList.size();
			JSONObject childJson = null;
			JSONArray elementArray = new JSONArray();
			JSONObject elementJson = new JSONObject();
			while(rs.next()) {

				for(int i=0;i<count;i++) {
//					if(houseEntryList.size()>0) {
//						//设置棚舍
//						childJson = new JSONObject();
//						childJson.put("number",houseEntryList.get(i).getNumber());
//						childJson.put("name",houseEntryList.get(i).getName());
//						childJson.put("id",houseEntryList.get(i).getString("id"));
//						elementJson.put("house",childJson);
//					}
					if(StringUtils.isNotEmpty(rs.getString("FMaterialID"))){
						mInfo=ims.getMaterialInfo(new ObjectUuidPK(rs.getString("FMaterialID")),slor);
						childJson = new JSONObject();
						childJson.put("number",mInfo.getNumber());
						childJson.put("name",mInfo.getName());
						childJson.put("id",mInfo.getString("id"));
						elementJson.put("vaccineMaterial",childJson);
					}
					if(StringUtils.isNotEmpty(rs.getString("FUnitID"))){
						MeasureUnitInfo measureUnitInfo = ius.getMeasureUnitInfo(new ObjectUuidPK(rs.getString("FUnitID")));
						childJson = new JSONObject();
						childJson.put("number",measureUnitInfo.getNumber());
						childJson.put("name",measureUnitInfo.getName());
						childJson.put("id",measureUnitInfo.getString("id"));
						elementJson.put("vaccineUnit",childJson);
					}
					elementJson.put("vaccineGetQty",rs.getBigDecimal("FQty"));
					elementArray.add(elementJson);
				}
			}
			resultjSon.put("immuneEntry",elementArray);
			rs.close();
		}catch(Exception err) {
			err.printStackTrace();
		}
	
		
		
	}

	private void getBreedEntry(Context ctx, Date bizDate,
			JSONObject resultjSon, BatchInfo batchInfo, String string,
			String string2, int week, int weekDay) {
		// TODO Auto-generated method stub

		try {
			if(batchInfo.getId()==null){
				return;
			}
			String batchID=batchInfo.getString("id");

			int count=0;

//			LinkedList<FarmHouseEntryInfo> houseEntryList=getHouseIDListByBatch(ctx,batchInfo);
//			count=houseEntryList.size()<=0?1:houseEntryList.size();
			JSONArray elementArray = new JSONArray();
			JSONObject elementJson  =new JSONObject();;
			//棚舍分录
			if(batchInfo.getFarm()!=null) {
				BatchLastBean bean;
				String billID=null;
				JSONObject childJson = null;
				for(int index=0;index<count;index++) {
//					if(houseEntryList.size()>0) {
						//设置棚舍
//						childJson = new JSONObject();
//						childJson.put("number",houseEntryList.get(index).getNumber());
//						childJson.put("name",houseEntryList.get(index).getName());
//						childJson.put("id",houseEntryList.get(index).getString("id"));
//						elementJson.put("house",childJson);
//
//						bean=StockingComm.getEntryHouseBatchBean(ctx,billID,batchInfo.getCompany().getString("id"),bizDate, batchID, houseEntryList.get(index).getString("id"));
//					}else{
						bean=StockingComm.getEntryHouseBatchBean(ctx,billID,batchInfo.getCompany().getString("id"),bizDate, batchID, null);
//					}
					if(bean==null) {
						continue;
					}
					elementJson.put("week",bean.getWeek());
					elementJson.put("weekDays",bean.getWeekDays());
					elementJson.put("breekingStock",bean.getLaskStock());
					elementJson.put("femaleBreedkingStock",bean.getFemaleLaskStock());


					elementArray.add(elementJson);
				}
			}
			resultjSon.put("assEntry",elementArray);
		}catch(Exception err) {
			err.printStackTrace();
		}
	
		
	}

	private void getBreedFodderStandard(Context ctx, JSONObject resultjSon,
			BatchInfo batchInfo, String companyID, String breedDataID,
			Date bizDate) {
		// TODO Auto-generated method stub

		try {
			if(StringUtils.isEmpty(companyID)||StringUtils.isEmpty(breedDataID)) {
				return;
			}
			//棚舍分录
//			LinkedList<FarmHouseEntryInfo> houseEntryList=getHouseIDListByBatch(ctx,batchInfo);
			//获取饲喂规范
//			HashMap<MaterialInfo, BigDecimal> map = StockingComm.getBreedFodderStandard(ctx, companyID, breedDataID, week,weekDay);
			
			StringBuffer sb = new StringBuffer();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sb.append("select").append("\n")
			.append(" distinct t2.FID,t2.FName_l2 materialName,t2.FModel,t2.CFUNITQTY").append("\n") 
			.append(" from ").append("\n") 
			.append("T_FM_FeedStd                  t1").append("\n") 
			.append("inner join T_FM_FeedStdEntry  t4 on t1.FID=t4.FParentID").append("\n") 
			.append("inner join T_BD_Material      t2 on t2.FID=t4.FMaterialID").append("\n") 
			.append("inner join T_ORG_Company      t3 on t3.FID=t1.CFCompanyID").append("\n") 
			.append("where t1.CFBeginDate<={d '").append(sdf .format(bizDate)).append("'} and (t1.CFEndDate is null or t1.CFEndDate>={d '").append(sdf.format(bizDate)).append("'})").append("\n") 
			.append(" and t3.FID='").append(companyID).append("'").append("\n");
			int count=0;
			JSONObject childJson = null;
			JSONObject elementJson = new JSONObject();
			JSONArray elementArray = new JSONArray();
//			count=houseEntryList.size()<=0?1:houseEntryList.size();
			String materialID;
			MaterialInfo materialInfo;
			//设置显示其他项
			SelectorItemCollection slor;
			IMaterial iMaterial = MaterialFactory.getLocalInstance(ctx);
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			while(rs.next()){//查询结果有多条记录用while(rs.next())，查询结果只有一条记录用if(rs.next())
				elementJson = new JSONObject();
				elementJson.put("materialName",rs.getString("materialName"));
				elementJson.put("materialModel",rs.getString("FModel"));
				elementJson.put("unitQty",rs.getString("CFUNITQTY"));
				materialID = rs.getString("FID");
				slor = new SelectorItemCollection();
				slor.add("*");
				slor.add("baseUnit.*");
				materialInfo = iMaterial.getMaterialInfo(new ObjectUuidPK(materialID), slor );
				elementJson.put("materialID",materialInfo.getString("id"));
				elementJson.put("materialNum",materialInfo.getString("number"));
				elementJson.put("unitID",materialInfo.getBaseUnit().getString("id"));
				elementJson.put("unitName",materialInfo.getBaseUnit().getString("name"));
				elementJson.put("unitNum",materialInfo.getBaseUnit().getString("number"));
				elementArray.add(elementJson);
			}
			resultjSon.put("entrys",elementArray);

		}catch(Exception err) {
			err.printStackTrace();
		}
	
		
	}
}