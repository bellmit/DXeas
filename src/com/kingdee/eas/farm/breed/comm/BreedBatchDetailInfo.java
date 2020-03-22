package com.kingdee.eas.farm.breed.comm;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.BreedBatchEntryCollection;
import com.kingdee.eas.farm.breed.BreedBatchEntryFactory;
import com.kingdee.eas.farm.breed.BreedBatchEntryInfo;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.farm.breed.BreedFacadeFactory;
import com.kingdee.eas.farm.breed.BreedModelEntryInfo;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import com.kingdee.eas.farm.breed.ChikenType;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.farm.breed.IBreedBatchEntry;
import com.kingdee.eas.farm.breed.IBreedFacade;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.eas.wlhlcomm.IToolFacade;
import com.kingdee.eas.wlhlcomm.ToolFacadeFactory;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

/**
 * ��ֳ������ϸ��Ϣ
 * @author USER
 *
 */
public class BreedBatchDetailInfo implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2671324606152652200L;
	private Context ctx;
	// ������Ϣ
	private BreedBatchInfo batchInfo; 
	// ��ǰ��������
	private int currentWeek;
	// ��ǰ���� �� �ĵڼ���
	private int currentDay;
	// ��Ʒ�� ����
	private int days;
	// ��Ӧ����ֳ�淶
	private BreedModelInfo breedModelInfo;
	// �������
	private HenhouseType houseType;
	// ��ǰ���� ���ձ���ϸ�б�
	private Map<String,Object> dailyInfos;
	
	private BreedModelEntryInfo breedModelEntryInfo;
	
	// 
	
	/**
	 * ��������������Ϣ
	 * @throws BOSException 
	 */
	public BreedBatchDetailInfo(Context ctx,BreedBatchInfo batchInfo,Date bizDate) throws BOSException{
		this.ctx = ctx;
		if(batchInfo == null || batchInfo.getId() == null){
			throw new FarmException("������Ϣ����Ϊ��");
		}else{
			this.setBatchInfo(batchInfo);
			
			IBreedFacade breedFacade = null;
			if(ctx == null){
				breedFacade = BreedFacadeFactory.getRemoteInstance();
			}else{
				breedFacade = BreedFacadeFactory.getLocalInstance(ctx);
			}
			houseType = batchInfo.getHouseType();
			// ���� ��ֳ�淶
			setBreedModelInfo();
			if(this.getBreedModelInfo() != null){
				// ���ɼ� �� ������ �������䣬��Ʒ����������
				if(HenhouseType.CC.equals(batchInfo.getHouseType())){
					// �����Ϊ����¼����  �������
//					Date inDate = batchInfo.getBizDate();
//					Date nowDate = bizDate;
//					if(nowDate == null) nowDate = new Date();
//					long diff = nowDate.getTime() - inDate.getTime();
//				    long days = diff / (1000 * 60 * 60 * 24);
//				    // �������ڵ���ǰ�����ڲ�������ζ���ʱ�� ���� �����ǰ������
//				    int daysInt = (int) days ;
//				    
//				    this.setDays(daysInt);
				}else{
					Date inDate = batchInfo.getBizDate();
					int week = batchInfo.getWeek();
					int day = batchInfo.getWeekDay();
					
					HashMap weekInfo = breedFacade.getBatchWeekages(batchInfo.getId().toString(),bizDate);
					Integer currWeek = (Integer) weekInfo.get("currWeek");
					Integer currDay = (Integer) weekInfo.get("currDay");
					// �������� ����
					this.setCurrentWeek(currWeek);
					this.setCurrentDay(currDay);
				}
				
				if(HenhouseType.CC.equals(batchInfo.getHouseType())){
					breedModelEntryInfo = breedFacade.getBreedModelEntryInfo(this.getBreedModelInfo().getId().toString(), 0,this.getDays());
				}else{
					breedModelEntryInfo = breedFacade.getBreedModelEntryInfo(this.getBreedModelInfo().getId().toString(), this.getCurrentWeek(),0);
				}
				
			}else{
				throw new FarmException("û�в�ѯ��������������ֳ�淶��������ϵ����Աά����ֳ�淶��Ϣ");
			}
		}
	}
	
	/**
	 * ��ü��� ��ǰ������
	 * key ����ID��
	 * value ����������ϸ��Ϣ
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public Map<String,BreedBatchEntryDetailInfo> getHenhouseBreedingStock(Context ctx,Date bizDate) throws BOSException, EASBizException{
		// map ��Ϊ����ֵ key����id
		Map<String,BreedBatchEntryDetailInfo> result = new HashMap<String, BreedBatchEntryDetailInfo>();
		// ��ֳ������Ϣ
		BreedBatchInfo bbInfo = this.getBatchInfo();
		if(bbInfo != null){
			BreedBatchEntryCollection entryColl = bbInfo.getEntrys();
			for(int i = 0; i < entryColl.size(); i++){
				BreedBatchEntryInfo batchEntryInfo = entryColl.get(i);
				if(batchEntryInfo != null){
					IBreedBatchEntry breedBE = null;
					if(ctx == null){
						breedBE = BreedBatchEntryFactory.getRemoteInstance();
					}else{
						breedBE = BreedBatchEntryFactory.getLocalInstance(ctx);
					}
					batchEntryInfo = breedBE.getBreedBatchEntryInfo(new ObjectUuidPK(batchEntryInfo.getId()));
					
					
					
					// ÿ����¼����һ����ϸ 
					BreedBatchEntryDetailInfo entryDetailInfo = new BreedBatchEntryDetailInfo();
					entryDetailInfo.setHenhouse(batchEntryInfo.getHenHouse());
					entryDetailInfo.setInitQty(batchEntryInfo.getInitQty());
					entryDetailInfo.setNowQty(batchEntryInfo.getInitQty());
					entryDetailInfo.setHenInitQty(batchEntryInfo.getHenQty());
					entryDetailInfo.setHenNowQty(batchEntryInfo.getHenQty());
					entryDetailInfo.setCockInitQty(batchEntryInfo.getCockQty());
					entryDetailInfo.setCockNowQty(batchEntryInfo.getCockQty());
					/** wgj 20150608 ���� ͳ�Ʊ�� ��¼�߼� BEGIN **/
					IBreedFacade breedFacade = null;
					if(ctx == null){
						breedFacade = BreedFacadeFactory.getRemoteInstance();
					}else{
						breedFacade = BreedFacadeFactory.getLocalInstance(ctx);
					}
					HenhouseType currhouseType = bbInfo.getHouseType();
					
					// ���ɺ� ��Ʒ�� 
					if(HenhouseType.CC.equals(currhouseType) || HenhouseType.Brood.equals(currhouseType)){
						int addQty = breedFacade.getBatchEntryEditInfos(bbInfo.getId().toString(), 
								batchEntryInfo.getHenHouse().getId().toString(),
								bizDate, batchEntryInfo.getChikenType().getValue());
						
//						entryDetailInfo.setInitQty(batchEntryInfo.getInitQty() + addQty);
						entryDetailInfo.setNowQty(batchEntryInfo.getInitQty() + addQty);
						
						
					}
					// ������
					if(HenhouseType.LayEgg.equals(currhouseType)){
						int addHenQty =  breedFacade.getBatchEntryEditInfos(bbInfo.getId().toString(), 
								batchEntryInfo.getHenHouse().getId().toString(),
								bizDate, ChikenType.LAYEGGHEN_VALUE);
						int addCockQty =  breedFacade.getBatchEntryEditInfos(bbInfo.getId().toString(), 
								batchEntryInfo.getHenHouse().getId().toString(),
								bizDate, ChikenType.LAYEGGCOCK_VALUE);
						
//						entryDetailInfo.setHenInitQty(batchEntryInfo.getHenQty());
						entryDetailInfo.setHenNowQty(batchEntryInfo.getHenQty() + addHenQty);
//						entryDetailInfo.setCockInitQty(batchEntryInfo.getCockQty());
						entryDetailInfo.setCockNowQty(batchEntryInfo.getCockQty() + addCockQty);
					}
					
					/** wgj 20150608 ���� ͳ�Ʊ�� ��¼�߼� END   **/
					result.put(batchEntryInfo.getHenHouse().getId().toString(), entryDetailInfo);
				}
				
			}
			
			// ͳ��������Ϣ  �������ǰ��������  ���� map����
			StringBuffer sql = new StringBuffer();
			HenhouseType type = bbInfo.getHouseType();
			if(HenhouseType.CC.equals(type)){
				sql.append("select te.CFHenhouseID,sum(te.CFCullAndDeath) cull,0,0,0,0,0,sum(te.CFMarketQty) marketQty,sum(CFTRANSQTY) transQty from CT_FM_CommecialCDAE te inner join CT_FM_CommecialChilkenDaily t on te.fparentid = t.fid ");
			}else if(HenhouseType.Brood.equals(type)){
				sql.append("select te.CFHenhouseID,sum(te.CFCullQty) cull,sum(te.CFDeathQty) death,0,0,0,0,sum(te.CFMarketQty) marketQty,0 from CT_FM_BroodDailyAssEntry te inner join CT_FM_BroodDaily t on te.fparentid = t.fid ");
			}else {
				sql.append("select te.CFHenhouseID,0,0,sum(te.CFHenCull)+sum(te.CFHenBatchCull) hencull, sum(te.CFHenDeath) henDeath,sum(te.CFCockCull) + sum(te.CFCockBatchCull) cockCull,sum(te.CFCockDeath) cockDeath,0,0 from CT_FM_LayEDCDE te inner join CT_FM_LayEggDaily t on te.fparentid = t.fid ");
			}
			
			sql.append(" where t.cfbreedbatchid ='");
			sql.append(bbInfo.getId().toString());
			sql.append("' and t.fbizdate <= {ts'");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sql.append(sdf.format(bizDate));
			
			sql.append("'} group by te.CFHenhouseID ");
			IToolFacade toolFacade = null;
			if(ctx == null){
				toolFacade = ToolFacadeFactory.getRemoteInstance();
			}else{
				toolFacade = ToolFacadeFactory.getLocalInstance(ctx);
			}
			IRowSet rs = (IRowSet) toolFacade.executeQuery(sql.toString());
			try{
				while(rs.next()){
					String fid = rs.getString("CFHenhouseID");
					int cull = rs.getInt(2);
					int death = rs.getInt(3);
					int henCull = rs.getInt(4);
					int henDeath = rs.getInt(5);
					int cockCull = rs.getInt(6);
					int cockDeath = rs.getInt(7);
					int marketQty = rs.getInt(8);
					int transQty = rs.getInt(9);
					
					BreedBatchEntryDetailInfo entryDetailInfo = result.get(fid);
					if(entryDetailInfo != null){
						entryDetailInfo.setCulledQty(cull);
						entryDetailInfo.setDeadQty(death);
						entryDetailInfo.setNowQty(entryDetailInfo.getNowQty()-cull-death-marketQty+transQty);
						entryDetailInfo.setHenCulledQty(henCull);
						entryDetailInfo.setHenDeadQty(henDeath);
						entryDetailInfo.setHenNowQty(entryDetailInfo.getHenNowQty() -henCull -henDeath);
						entryDetailInfo.setCockCulledQty(cockCull);
						entryDetailInfo.setCockDeadQty(cockDeath);
						entryDetailInfo.setCockNowQty(entryDetailInfo.getCockNowQty() - cockCull - cockDeath);
						entryDetailInfo.setMarketQty(marketQty);
					}
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
				throw new EASBizException(new NumericExceptionSubItem("001",sqle.getMessage()));

			}
			
		}
		
		
		return result;
	}
	/**
	 * ������� ��ֳ�淶
	 * @param ctx
	 * @return
	 * @throws BOSException 
	 */
	private BreedModelInfo setBreedModelInfo() throws BOSException{
		if(this.getBatchInfo() == null){
			return null;
		}else if(houseType == null){
			return null;
		}else{
			IBreedFacade breedFacade = null;
			if(ctx == null){
				breedFacade = BreedFacadeFactory.getRemoteInstance();
			}else{
				breedFacade = BreedFacadeFactory.getLocalInstance(ctx);
			}
			this.breedModelInfo =  breedFacade.getBreedModelByHouseType(houseType.getValue());
			return breedModelInfo;
		}
		
	}
	
	
	
	public BreedBatchInfo getBatchInfo() {
		return batchInfo;
	}
	public void setBatchInfo(BreedBatchInfo batchInfo) {
		this.batchInfo = batchInfo;
	}
	public int getCurrentWeek() {
		return currentWeek;
	}
	public void setCurrentWeek(int currentWeek) {
		this.currentWeek = currentWeek;
	}
	public int getCurrentDay() {
		return currentDay;
	}
	public void setCurrentDay(int currentDay) {
		this.currentDay = currentDay;
	}
	
	public Map<String, Object> getDailyInfos() {
		return dailyInfos;
	}
	public void setDailyInfos(Map<String, Object> dailyInfos) {
		this.dailyInfos = dailyInfos;
	}

	public BreedModelInfo getBreedModelInfo() {
		return breedModelInfo;
	}

	public BreedModelEntryInfo getBreedModelEntryInfo() {
		return breedModelEntryInfo;
	}



	public int getDays() {
		return days;
	}



	public void setDays(int days) {
		this.days = days;
	}
	
	
}
