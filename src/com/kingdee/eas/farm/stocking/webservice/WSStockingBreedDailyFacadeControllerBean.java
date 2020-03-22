package com.kingdee.eas.farm.stocking.webservice;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.assistant.IMeasureUnit;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commonld.comm.WebServiceComm;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.IFarmHouseEntry;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchFactory;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.common.BatchLastBean;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDaily;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyAssEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEnviInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyImmuneEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailySendEggEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyTransEntryInfo;
import com.kingdee.jdbc.rowset.IRowSet;

public class WSStockingBreedDailyFacadeControllerBean extends AbstractWSStockingBreedDailyFacadeControllerBean
{
	//��ֳ�ձ���Ψһ��ʶ������ֳ�ձ���entity��Ѱ��
	private static final String bosType = "2859A756";
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.stocking.webservice.WSStockingBreedDailyFacadeControllerBean");
	protected String _getDailyInitBillInfo(Context ctx, String param)throws BOSException{   //��ȡ����
		JSONObject paramJson = JSONObject.fromObject(param);
		JSONObject resultjSon = new JSONObject();
		//�������Σ�����
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

		//����һ��SelectorItemCollection������ȡ�����е�ĳЩ�ֶε���ϸ��Ϣ
		SelectorItemCollection slor=new SelectorItemCollection();
		slor.add("*");
		slor.add("farmer.*");
		slor.add("farm.*");
		slor.add("house.*");
		StockingBatchInfo batchInfo = null;
		try {
			batchInfo = StockingBatchFactory.getLocalInstance(ctx).getStockingBatchInfo(new ObjectUuidPK(batchID),slor);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		// ��ֳ��
		JSONObject farmerJson = new JSONObject();
		farmerJson.put("name",batchInfo.getFarmer().getName());
		farmerJson.put("number",batchInfo.getFarmer().getNumber());
		farmerJson.put("id",batchInfo.getFarmer().getId().toString());
		resultjSon.put("farmer",farmerJson);
		//��ֳ��
		JSONObject farmJson = new JSONObject();
		farmJson.put("name",batchInfo.getFarm().getName());
		farmJson.put("number",batchInfo.getFarm().getNumber());
		farmJson.put("id",batchInfo.getFarm().getId().toString());
		resultjSon.put("farm",farmJson);



		//������
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


		//��ι��Ϣ
		getBreedFodderStandard(ctx,resultjSon,batchInfo,batchInfo.getCompany().getString("id"),batchInfo.getBreedData().getString("id"), week, weekDay);


		// ������Ϣ
		getBreedEntry(ctx,bizDate,resultjSon,batchInfo,batchInfo.getCompany().getString("id"),batchInfo.getBreedData().getString("id"), week, weekDay);


		//���߱�׼
		getBreedDrugStandard(ctx,resultjSon,batchInfo, batchInfo.getBreedData().getString("id"), week, weekDay);


		// ����
		setEggEntry(ctx,resultjSon,batchInfo, batchInfo.getBreedData().getString("id"), week, weekDay);

		return resultjSon.toString();
	}
	/**
	 * ͨ����ֳ��¼
	 * @param bizDate 
	 * @param breedDataID
	 * @param week
	 * @param weekDay
	 */
	private void getBreedEntry(Context ctx,Date bizDate, JSONObject resultjSon, StockingBatchInfo batchInfo, String companyID,String breedDataID,int week,int weekDay) {
		try {
			if(batchInfo.getId()==null){
				return;
			}
			String batchID=batchInfo.getString("id");

			int count=0;

			LinkedList<FarmHouseEntryInfo> houseEntryList=getHouseIDListByBatch(ctx,batchInfo);
			count=houseEntryList.size()<=0?1:houseEntryList.size();
			JSONArray elementArray = new JSONArray();
			JSONObject elementJson  =new JSONObject();;
			//�����¼
			if(batchInfo.getFarm()!=null) {
				BatchLastBean bean;
				String billID=null;
				JSONObject childJson = null;
				for(int index=0;index<count;index++) {
					if(houseEntryList.size()>0) {
						//��������
						childJson = new JSONObject();
						childJson.put("number",houseEntryList.get(index).getNumber());
						childJson.put("name",houseEntryList.get(index).getName());
						childJson.put("id",houseEntryList.get(index).getString("id"));
						elementJson.put("house",childJson);

						bean=StockingComm.getEntryHouseBatchBean(ctx,billID,batchInfo.getCompany().getString("id"),bizDate, batchID, houseEntryList.get(index).getString("id"));
					}else{
						bean=StockingComm.getEntryHouseBatchBean(ctx,billID,batchInfo.getCompany().getString("id"),bizDate, batchID, null);
					}
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

	@Override
	protected String _createNewBill(Context ctx, String param) {
		// TODO Auto-generated method stub
		//������һ��JSONObject����
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
	//�õ��༭�������ϸ��Ϣ
	protected String _getBillDetailInfo(Context ctx, String param) {
		// TODO Auto-generated method stub
		slorList = new String[]{"*","company.*","farmer.*","farm.*","StockingBatch.*","handler.*","auditor.*","creator.*","lastUpdateUser.*","cu.*"
				,"eggEntry.*","eggEntry.material.*","EggEntry.unit.*","EggEntry.house.*"
				,"entrys.*","entrys.material.*","entrys.unit.*","entrys.house.*"
				,"AssEntrys.*","AssEntrys.house.*","AssEntrys.customer.*"
				,"ImmuneEntrys.*","ImmuneEntrys.VaccineMaterial.*","ImmuneEntrys.house"
				,"TransEntry.*","TransEntry.house.*","TransEntry.FromStockingBatch.*","TransEntry.FromFarmers.*","TransEntry.fromfarm.*","TransEntry.fromHouse.*"
				,"Envi.*","Envi.house.*","SendEggEntry.*","SendEggEntry.house.*","SendEggEntry.material*"};
		return super._getBillDetailInfo(ctx, param);
	}
	@Override
	//����ҵ�����ں�����ID��ȡ��ֳ�ձ����б����
	protected String _getBillList(Context ctx, String param) {
		// TODO Auto-generated method stub

		return super._getBillList(ctx, param);
	}

	@Override
	protected void afterCreateNewBill(Context ctx, IObjectPK pk,
			JSONObject entryJson) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		super.afterCreateNewBill(ctx, pk, entryJson);
		IStockingBreedDaily instance = StockingBreedDailyFactory.getLocalInstance(ctx);
		StockingBreedDailyInfo info = instance.getStockingBreedDailyInfo(pk);

		// ��ι��¼
		for(int i = info.getEntrys().size()-1;i>=0;i--)
			info.getEntrys().remove(info.getEntrys().get(i));
		JSONArray array = null;
		StockingBreedDailyEntryInfo entryInfo;
		array = entryJson.getJSONArray("entrys");
		for(int i=0;i<array.size();i++){
			JSONObject elem= (JSONObject) array.get(i);
			Iterator keys = elem.keys();
			entryInfo = new StockingBreedDailyEntryInfo();
			while(keys.hasNext()){
				String key = UIRuleUtil.getString(keys.next());
				if(elem.get(key) instanceof JSONObject)
					entryInfo.put(key,((JSONObject)elem.get(key)).getString("id"));
				else
					entryInfo.put(key,elem.get(key));
			}
			info.getEntrys().add(entryInfo);
		}


		//������Ϣ��¼
		for(int i = info.getAssEntrys().size()-1;i>=0;i--)
			info.getAssEntrys().remove(info.getAssEntrys().get(i));
		StockingBreedDailyAssEntryInfo entryAssInfo;
		array = entryJson.getJSONArray("AssEntrys");
		for(int i=0;i<array.size();i++){
			JSONObject elem= (JSONObject) array.get(i);
			Iterator keys = elem.keys();
			entryAssInfo = new StockingBreedDailyAssEntryInfo();
			while(keys.hasNext()){
				String key = UIRuleUtil.getString(keys.next());
				if(elem.get(key) instanceof JSONObject)
					entryAssInfo.put(key,((JSONObject)elem.get(key)).getString("id"));
				else
					entryAssInfo.put(key,elem.get(key));
			}
			info.getAssEntrys().add(entryAssInfo);
		}

		//������Ϣ��¼
		for(int i = info.getImmuneEntrys().size()-1;i>=0;i--)
			info.getImmuneEntrys().remove(info.getImmuneEntrys().get(i));
		StockingBreedDailyImmuneEntryInfo entryImmueInfo;
		array = entryJson.getJSONArray("ImmuneEntrys");
		for(int i=0;i<array.size();i++){
			JSONObject elem= (JSONObject) array.get(i);
			Iterator keys = elem.keys();
			entryImmueInfo = new StockingBreedDailyImmuneEntryInfo();
			while(keys.hasNext()){
				String key = UIRuleUtil.getString(keys.next());
				if(elem.get(key) instanceof JSONObject)
					entryImmueInfo.put(key,((JSONObject)elem.get(key)).getString("id"));
				else
					entryImmueInfo.put(key,elem.get(key));
			}
			info.getImmuneEntrys().add(entryImmueInfo);
		}

		//������Ϣ��¼
		for(int i = info.getEggEntry().size()-1;i>=0;i--)
			info.getEggEntry().remove(info.getEggEntry().get(i));
		StockingBreedDailyEggEntryInfo entryEggInfo;
		array = entryJson.getJSONArray("EggEntry");
		for(int i=0;i<array.size();i++){
			JSONObject elem= (JSONObject) array.get(i);
			Iterator keys = elem.keys();
			entryEggInfo = new StockingBreedDailyEggEntryInfo();
			while(keys.hasNext()){
				String key = UIRuleUtil.getString(keys.next());
				if(elem.get(key) instanceof JSONObject)
					entryEggInfo.put(key,((JSONObject)elem.get(key)).getString("id"));
				else
					entryEggInfo.put(key,elem.get(key));
			}
			info.getEggEntry().add(entryEggInfo);
		}

		//ת����Ϣ��¼
		for(int i = info.getTransEntry().size()-1;i>=0;i--)
			info.getTransEntry().remove(info.getTransEntry().get(i));
		StockingBreedDailyTransEntryInfo entryTransInfo;
		array = entryJson.getJSONArray("TransEntry");
		for(int i=0;i<array.size();i++){
			JSONObject elem= (JSONObject) array.get(i);
			Iterator keys = elem.keys();
			entryTransInfo = new StockingBreedDailyTransEntryInfo();
			while(keys.hasNext()){
				String key = UIRuleUtil.getString(keys.next());
				if(elem.get(key) instanceof JSONObject)
					entryTransInfo.put(key,((JSONObject)elem.get(key)).getString("id"));
				else
					entryTransInfo.put(key,elem.get(key));
			}
			info.getTransEntry().add(entryTransInfo);
		}

		//������Ϣ��¼
		for(int i = info.getEnvi().size()-1;i>=0;i--)
			info.getEnvi().remove(info.getEnvi().get(i));
		StockingBreedDailyEnviInfo entryEnviInfo;
		array = entryJson.getJSONArray("Envi");
		for(int i=0;i<array.size();i++){
			JSONObject elem= (JSONObject) array.get(i);
			Iterator keys = elem.keys();
			entryEnviInfo = new StockingBreedDailyEnviInfo();
			while(keys.hasNext()){
				String key = UIRuleUtil.getString(keys.next());
				if(elem.get(key) instanceof JSONObject)
					entryEnviInfo.put(key,((JSONObject)elem.get(key)).getString("id"));
				else
					entryEnviInfo.put(key,elem.get(key));
			}
			info.getEnvi().add(entryEnviInfo);
		}

		//��Ʒ������Ϣ��¼
		StockingBreedDailySendEggEntryInfo entrySendEggInfo;
		array = entryJson.getJSONArray("SendEggEntry");
		for(int i=0;i<array.size();i++){
			JSONObject elem= (JSONObject) array.get(i);
			Iterator keys = elem.keys();
			entrySendEggInfo = new StockingBreedDailySendEggEntryInfo();
			while(keys.hasNext()){
				String key = UIRuleUtil.getString(keys.next());
				if(elem.get(key) instanceof JSONObject)
					entrySendEggInfo.put(key,((JSONObject)elem.get(key)).getString("id"));
				else
					entrySendEggInfo.put(key,elem.get(key));
			}
			info.getSendEggEntry().add(entrySendEggInfo);
		}

		StockingBreedDailyFactory.getLocalInstance(ctx).save(info);
	}


	@Override
	protected void beforeCreateNewBill(Context ctx, JSONObject dataJson,
			JSONObject entryJson) {
		// TODO Auto-generated method stub
		String [] entrysArray = new String[]{"entrys","AssEntrys","ImmuneEntrys","SendEggEntry","TransEntry","EggEntry","Envi"};
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

	/**
	 * ͨ����ֳƷ�ֺ�ҵ�����ڻ�ȡ���ϱ�׼
	 * @param ctx 
	 * @param batchInfo 
	 * @param resultjSon 
	 * @param resultjSon2 
	 * @param breedDataID
	 * @param week
	 * @param weekDay
	 */
	private void getBreedFodderStandard(Context ctx, JSONObject resultjSon, StockingBatchInfo batchInfo, String companyID,String breedDataID,int week,int weekDay) {
		try {
			if(StringUtils.isEmpty(companyID)||StringUtils.isEmpty(breedDataID)) {
				return;
			}
			//�����¼
			LinkedList<FarmHouseEntryInfo> houseEntryList=getHouseIDListByBatch(ctx,batchInfo);
			//��ȡ��ι�淶
			HashMap<MaterialInfo, BigDecimal> map = StockingComm.getBreedFodderStandard(ctx, companyID, breedDataID, week,weekDay);
			int count=0;
			JSONObject childJson = null;
			JSONObject elementJson = new JSONObject();
			JSONArray elementArray = new JSONArray();
			count=houseEntryList.size()<=0?1:houseEntryList.size();
			for (Map.Entry<MaterialInfo,BigDecimal> entry : map.entrySet()) { 
				for(int i=0;i<count;i++) {
					if(houseEntryList.size()>0) {
						//��������
						childJson = new JSONObject();
						childJson.put("number",houseEntryList.get(i).getNumber());
						childJson.put("name",houseEntryList.get(i).getName());
						childJson.put("id",houseEntryList.get(i).getString("id"));
						elementJson.put("house",childJson);
					}

					childJson = new JSONObject();
					childJson.put("number",(entry.getKey()).getNumber());
					childJson.put("name",(entry.getKey()).getName());
					childJson.put("id",(entry.getKey()).getString("id"));
					elementJson.put("material",childJson);

					elementJson.put("materialName",entry.getKey().getName());
					elementJson.put("materialModel",entry.getKey().getModel());

					childJson = new JSONObject();
					childJson.put("number",(entry.getKey().getBaseUnit()).getNumber());
					childJson.put("name",(entry.getKey().getBaseUnit()).getName());
					childJson.put("id",(entry.getKey().getBaseUnit()).getString("id"));
					elementJson.put("unit",childJson);
					elementJson.put("unitQty",StockingComm.getUnitQty(ctx, batchInfo.getCompany().getString("id"), entry.getKey().getString("id")));

					elementArray.add(elementJson);
				}
			}
			resultjSon.put("entrys",elementArray);

		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	/**
	 * �������λ�ȡ
	 * @param batchInfo 
	 * @return
	 */
	private LinkedList<FarmHouseEntryInfo> getHouseIDListByBatch(Context ctx,StockingBatchInfo batchInfo) {
		LinkedList<FarmHouseEntryInfo> list=new LinkedList<FarmHouseEntryInfo>();

		//û�������������
		if(!batchInfo.getFarm().isIsHouseManager()) {//sysSetting.isIsHouseManager(
			return list;
		}
		String batchID=null;
		if(batchInfo!=null) {
			batchID=(batchInfo).getString("id");

			try{
				IFarmHouseEntry ifs = FarmHouseEntryFactory.getLocalInstance(ctx);
				for(String id: StockingComm.getHouseSetByBatchID(ctx,batchID)){
					list.add(ifs.getFarmHouseEntryInfo(new ObjectUuidPK(id)));
				}
			}catch(Exception err) {
				err.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * ͨ����ֳƷ�ֺ�ҵ�����ڻ�ȡ ����
	 * @param elementJson 
	 * @param breedDataID
	 * @param week
	 * @param weekDay
	 */
	private void getBreedDrugStandard(Context ctx,JSONObject resultJson, StockingBatchInfo batchInfo,String breedDataID,int week,int weekDay) {
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
			.append(" and FBaseStatus=3")//����״̬
			.append(" and (")
			//��ʼ���վ����ڵ�ǰ
			.append(" (FWeek<=").append(week).append(" and FDays<=").append(weekDay).append(" ")
			//����ͬ�ܣ��մ��ڵ�ǰ��
			.append(" and ((FEndWeek=").append(week).append(" and FEndDays>=").append(weekDay).append(" )")
			//�ܴ��ڵ�ǰ��
			.append(" or FEndWeek>").append(week).append(" ))")
			//0�� ���������ж�
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
			LinkedList<FarmHouseEntryInfo> houseEntryList=getHouseIDListByBatch(ctx,batchInfo);
			count=houseEntryList.size()<=0?1:houseEntryList.size();
			JSONObject childJson = null;
			JSONArray elementArray = new JSONArray();
			JSONObject elementJson = new JSONObject();
			while(rs.next()) {

				for(int i=0;i<count;i++) {
					if(houseEntryList.size()>0) {
						//��������
						childJson = new JSONObject();
						childJson.put("number",houseEntryList.get(i).getNumber());
						childJson.put("name",houseEntryList.get(i).getName());
						childJson.put("id",houseEntryList.get(i).getString("id"));
						elementJson.put("house",childJson);
					}
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
			resultJson.put("immuneEntry",elementArray);
			rs.close();
		}catch(Exception err) {
			err.printStackTrace();
		}
	}

	private void setEggEntry(Context ctx,JSONObject resultJson,StockingBatchInfo batchInfo,String companyID,int week,int weekDay) {
		//���� 
		int dayAge=(week-1)*7+weekDay-1;

		String curCompanyID = batchInfo.getCompany().getString("id");

		StringBuffer sql=new StringBuffer();
		sql.append(" select top 1 tentry.fid")
		.append(" from T_FM_BreedStandard tmain ")
		.append(" inner join T_FM_BreedStandardLayEggEntry tentry on tentry.fparentid=tmain.fid")
		.append(" where tmain.FCompanyID='").append(curCompanyID).append("'")
		.append(" and FBreedDataID='").append(batchInfo.getBreedData().getString("id")).append("'")
		.append(" and FBaseStatus=3")//����״̬
		.append(" and (")
		//��ʼ���վ����ڵ�ǰ
		.append(" (CFWeek<=").append(week).append(" and CFDays<=").append(weekDay).append(" ")
		//����ͬ�ܣ��մ��ڵ�ǰ��
		.append(" and ((FEndWeek=").append(week).append(" and FEndDays>=").append(weekDay).append(" )")
		//�ܴ��ڵ�ǰ��
		.append(" or FEndWeek>").append(week).append(" ))")
		//0�� ���������ж�
		.append(" or (CFWeek=0 and CFDays<=").append(dayAge).append(" and FEndWeek=0 and FEndDays>=").append(dayAge).append(")")
		.append(" )")
		.append(" order by tentry.FSeq");
		IRowSet rs;
		try {
			rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
			//û�в����淶���˳�
			if(rs.size()<=0) {
				return;
			}
		} catch (BOSException e) {
			e.printStackTrace();
		}


		LinkedList<FarmHouseEntryInfo> houseEntryList=getHouseIDListByBatch(ctx,batchInfo);

		int count=houseEntryList.size()<=0?1:houseEntryList.size();
		String batchID=null;
		if(batchInfo!=null) {
			batchID=(batchInfo).getString("id");
		}
		ArrayList<String> list = StockingComm.getEggListByStockingBatchID(ctx, batchID,true);
		if(list!=null){
			try{
				IMaterial ims = MaterialFactory.getLocalInstance(ctx);
				MaterialInfo mInfo;
				SelectorItemCollection slor=new SelectorItemCollection();
				slor.add(new SelectorItemInfo("*"));
				slor.add(new SelectorItemInfo("baseUnit.*"));
				JSONObject childJson = null;
				JSONArray elementArray = new JSONArray();
				JSONObject elementJson = new JSONObject();
				for(String materialID:list) {
					for(int i=0;i<count;i++) {

						if(houseEntryList.size()>0) {
							//��������
							childJson = new JSONObject();
							childJson.put("number",houseEntryList.get(i).getNumber());
							childJson.put("name",houseEntryList.get(i).getName());
							childJson.put("id",houseEntryList.get(i).getString("id"));
							elementJson.put("house",childJson);
						}

						mInfo=ims.getMaterialInfo(new ObjectUuidPK(materialID),slor);
						childJson = new JSONObject();
						childJson.put("number",mInfo.getNumber());
						childJson.put("name",mInfo.getName());
						childJson.put("id",mInfo.getString("id"));
						elementJson.put("material",childJson);

						elementJson.put("materialName",mInfo.getName());
						elementJson.put("model",mInfo.getModel());

						childJson = new JSONObject();
						childJson.put("number",mInfo.getBaseUnit().getNumber());
						childJson.put("name",mInfo.getBaseUnit().getName());
						childJson.put("id",mInfo.getBaseUnit().getString("id"));
						elementJson.put("unit",childJson);


						elementArray.add(elementJson);
					}
				}
				resultJson.put("eggEntry",elementArray);
			}catch(Exception err) {
				logger.error(err);
				err.printStackTrace();
			}
		}

	}
}