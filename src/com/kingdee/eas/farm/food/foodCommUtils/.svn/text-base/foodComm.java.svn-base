package com.kingdee.eas.farm.food.foodCommUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.commons.collections.map.LinkedMap;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.BreedBatch;
import com.kingdee.eas.farm.breed.BreedBatchFactory;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.farm.breed.BreedStoorgSetFactory;
import com.kingdee.eas.farm.breed.BreedStoorgSetInfo;
import com.kingdee.eas.farm.breed.HenhouseFactory;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.food.ISlaughterPlan;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.util.NumericExceptionSubItem;
//import com.mycompany.internal.edu.emory.mathcs.backport.java.util.Arrays;

public class foodComm {

	/**
	 * 获取两个日期相差的天数
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int getDiffBetweenTwoDays(Date beginDate,Date endDate){
		Calendar calbegin = Calendar.getInstance();
		Calendar calend=Calendar.getInstance();
		calbegin.setTime(beginDate);
		calend.setTime(endDate);		
		return Integer.parseInt(String.valueOf((calend.getTimeInMillis()-calbegin.getTimeInMillis())/(24*3600*1000)));		
	}


	/**
	 * 将字符串数组的值用'_'连接起来,从而获得key
	 * @param str
	 * @return
	 */
	public static String getKey(String [] str){
		String string="";
		for(int i=0;i<str.length;i++){
			string=string+str[i];
			if(i!=str.length-1)
				string=string+"_";
		}
		return string;
	}

	/**
	 * 将字符串数组的值用'_'连接起来,从而获得value
	 * @param str
	 * @return
	 */
	public static String getValue(String [] str){
		String string="";
		for(int i=0;i<str.length;i++){
			string=string+str[i];
			if(i!=str.length-1)
				string=string+"_";
		}
		return string;
	}

	/**
	 * 字符串转日期
	 * @param str
	 * @return
	 * @throws EASBizException
	 */
	public static Date getDateByString(String str) throws EASBizException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		if(str.equals(""))
			return null;
		else
			try{
				return sdf.parse(str);
			}catch(Exception e){
				throw new EASBizException(new NumericExceptionSubItem("001","字符串转日期错误"));
			}
	}

	/**
	 * 根据id获取养殖场
	 * @param id
	 * @return
	 * @throws BOSException
	 */
	public static StorageOrgUnitInfo getStorageOrgUnitInfoByID(String id) throws BOSException{
		if(id.equals(""))
			return null;
		CoreBaseCollection coll = StorageOrgUnitFactory.getRemoteInstance().getCollection("where id='"+id+"'");
		if(coll.size()==0)
			return null;
		return (StorageOrgUnitInfo)coll.get(0);
	}

	/**
	 * 根据number获取养殖场
	 * @param id
	 * @return
	 * @throws BOSException
	 */
	public static StorageOrgUnitInfo getStorageOrgUnitInfoByNumber(String number) throws BOSException{
		if(number.equals(""))
			return null;
		CoreBaseCollection coll = StorageOrgUnitFactory.getRemoteInstance().getCollection(" where number='"+number+"'");
		if(coll.size()==0)
			return null;
		return (StorageOrgUnitInfo)coll.get(0);
	}

	/**
	 * 根据id获取鸡舍
	 * @param id
	 * @return
	 * @throws BOSException
	 */
	public static HenhouseInfo getHenHouseInfoByID(String id) throws BOSException{
		if(id.equals(""))
			return null;
		CoreBaseCollection coll = HenhouseFactory.getRemoteInstance().getCollection("where id='"+id+"'");
		if(coll.size()==0)
			return null;
		return (HenhouseInfo)coll.get(0);
	}

	/**
	 * 根据id获取养殖批次
	 * @param id
	 * @return
	 * @throws BOSException
	 */
	public static BreedBatchInfo getBreedBatchInfoByID(String id) throws BOSException{
		if(id.equals(""))
			return null;
		CoreBaseCollection coll = BreedBatchFactory.getRemoteInstance().getCollection("where id='"+id+"'");
		if(coll.size()==0)
			return null;
		return (BreedBatchInfo)coll.get(0);
	}

	/**
	 * bigdecimal转整型  四舍五入
	 * @param value
	 * @return
	 */
	public static  int translateFromBigdecimalToInteger(BigDecimal value){
		String valueString = value.toString();
		if(valueString.indexOf(".")<0)
			return Integer.valueOf(valueString);
		else{
			if(Integer.valueOf(valueString.substring(valueString.indexOf(".")+1,valueString.indexOf(".")+2))>=5)
				return Integer.valueOf(valueString.substring(0,valueString.indexOf(".")))+1;
			else
				return 
				Integer.valueOf(valueString.substring(0,valueString.indexOf(".")));
		}
	}

	/**
	 * 根据养殖场或养殖场的id获得养殖场的编号
	 * @param obj
	 * @throws BOSException 
	 */
	public static String getFeedFactoryNumber(Object obj) throws BOSException{
		String id="";
		if(obj==null)
			return "";
		if(obj instanceof StorageOrgUnitInfo)
			id=((StorageOrgUnitInfo)obj).getId().toString();
		else if(obj instanceof String&&!obj.equals(""))
			id=(String)obj;
		else
			return "";
		CoreBaseCollection coll = BreedStoorgSetFactory.getRemoteInstance().getCollection(" where StoOrg='"+id+"'");
		if(coll.size()>0)
			return ((BreedStoorgSetInfo)coll.get(0)).getNumber().toString();
		return "";
	}

	/**
	 * 宰杀详情   结果示例：假设宝商3厂的编号BS003宰杀3个场，共商4场编号GS004宰杀2个场，则返回 BS003*3+GS004*2
	 * @param breedStorage
	 * @return
	 * @throws BOSException 
	 */
	@SuppressWarnings("unchecked")
	public static String getDetailsOfSlaughter(String breedStorage) throws BOSException {
		// TODO Auto-generated method stub

		String result="";

		ArrayList<String> list=new ArrayList<String>();
		if(breedStorage.equals(""))
			return "";
		String str[]=breedStorage.split("_");
		for(int i=0;i<str.length;i++){
			str[i]=getFeedFactoryNumber(str[i]);
		}
//		list.addAll(Arrays.asList(str));
		Map<String,Integer> hash=new HashMap<String,Integer>();
		for (int i = 0; i < list.size(); i++) {  
			try {  

				if (!hash.isEmpty() && hash.containsKey(list.get(i))) {  
					hash.put(list.get(i).toString(), hash.get(list.get(i)) + 1);  
				} else {  
					hash.put(list.get(i).toString(), 1);  
				}  
			} catch (Exception e) {  

			}  
		}  
		Set<String> set = hash.keySet();  
		for (String key : set) {  
			if(result.equals(""))
				result+=key + "*" + hash.get(key);
			else
				result+="+"+key + "*" + hash.get(key);
		}  
		return result;
	}

	/**
	 * 获取宰杀详情
	 * @param map
	 * @return
	 */
	public static String getDetailsOfSlaughter(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		String str="";
		for(Map.Entry<String, Integer> entry: map.entrySet()){
			if(entry.getValue()<=0)
				continue;
			if(str.equals(""))
				str+=entry.getKey()+"*"+entry.getValue();
			else
				str+="+"+entry.getKey()+"*"+entry.getValue();
		}
		return str;
	}

	/**
	 * 1223排序            按入栏日期 养殖场  下一个入栏日期先排已排过的养殖场
	 * @param mapHavntLocked
	 * @return
	 */
	public static LinkedHashMap<String,String> sortTwoDimension(LinkedHashMap<String,String> mapHavntLocked){
		LinkedHashMap<String,String> resultMap=new LinkedHashMap<String,String>();


		ArrayList<String[]> arrayListBeforeSort=new ArrayList<String[]>();
		ArrayList<String[]> arrayListAfterSort=new ArrayList<String[]>();
		if(mapHavntLocked.size()==0)
			return null;
		String strKeyOne="";//入栏日期
		String strKeyTwo="";//商品鸡场
		Iterator<Entry<String, String>> it = mapHavntLocked.entrySet().iterator();  
		while(it.hasNext()){  
			Entry<String, String> entry=it.next();
			arrayListBeforeSort.add(entry.getKey().split("_"));
		}

		ArrayList<Integer> numbers=new ArrayList<Integer>();

		for(int i=0;i<arrayListBeforeSort.size();i++){
			if(inNumbers(i,numbers))
				continue;
			if(strKeyOne.equals("")){
				arrayListAfterSort.add(arrayListBeforeSort.get(i));
				strKeyOne=arrayListBeforeSort.get(i)[0];
				strKeyTwo=arrayListBeforeSort.get(i)[1];
				continue;
			}
			if(!strKeyOne.equals(arrayListBeforeSort.get(i)[0])){
				for(int j=i;j<arrayListBeforeSort.size();j++)
					if(arrayListBeforeSort.get(j)[1].equals(strKeyTwo)&&arrayListBeforeSort.get(j)[0].equals(arrayListBeforeSort.get(i)[0])){
						arrayListAfterSort.add(arrayListBeforeSort.get(j));
						numbers.add(j);						
					}
				arrayListAfterSort.add(arrayListBeforeSort.get(i));
			}
			else
				arrayListAfterSort.add(arrayListBeforeSort.get(i));
			strKeyOne=arrayListBeforeSort.get(i)[0];
			strKeyTwo=arrayListBeforeSort.get(i)[1];
		}
		for(int i=0;i<arrayListAfterSort.size();i++){
			resultMap.put(getKey(arrayListAfterSort.get(i)),"00_00_00");
		}
		return resultMap;

	}

	/**
	 * 判断一个整数是否存在于数组里
	 * @param i
	 * @param numbers 
	 * @return
	 */
	public static boolean inNumbers(int seq, ArrayList<Integer> numbers) {
		// TODO Auto-generated method stub
		for(int i=0;i<numbers.size();i++)
			if(seq==numbers.get(i))
				return true;
		return false;
	}
	
	/**
	 * 获得某个期间的上一个期间
	 * @param periodInfo
	 * @throws BOSException 
	 */
	public static PeriodInfo getUpperPeriodInfo(PeriodInfo periodInfo) throws BOSException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(periodInfo==null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(periodInfo.getBeginDate());
		cal.add(Calendar.DATE, -1);
		Date lastDateOfUpperPeriod=cal.getTime();
		CoreBaseCollection coll = PeriodFactory.getRemoteInstance().getCollection(" where beginDate<{ts '"+sdf.format(lastDateOfUpperPeriod)+"'} and endDate>={ts '"+sdf.format(lastDateOfUpperPeriod)+"'}");
		if(coll.size()==0)
			return null;
		PeriodInfo fiscalPeriodInfo = (PeriodInfo)coll.get(0);
		return fiscalPeriodInfo;
	}
}
