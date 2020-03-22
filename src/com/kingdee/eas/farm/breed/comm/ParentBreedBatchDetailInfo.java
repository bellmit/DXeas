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
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.farm.breed.BreedFacadeFactory;
import com.kingdee.eas.farm.breed.BreedModelEntryInfo;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.farm.breed.IBreedFacade;
import com.kingdee.eas.farm.breed.IParentBreedBatchEntry;
import com.kingdee.eas.farm.breed.IParentBreedBatchTransEntry;
import com.kingdee.eas.farm.breed.IparentFacade;
import com.kingdee.eas.farm.breed.ParentBreedBatchEntryCollection;
import com.kingdee.eas.farm.breed.ParentBreedBatchEntryFactory;
import com.kingdee.eas.farm.breed.ParentBreedBatchEntryInfo;
import com.kingdee.eas.farm.breed.ParentBreedBatchInfo;
import com.kingdee.eas.farm.breed.ParentBreedBatchTransEntryCollection;
import com.kingdee.eas.farm.breed.ParentBreedBatchTransEntryFactory;
import com.kingdee.eas.farm.breed.ParentBreedBatchTransEntryInfo;
import com.kingdee.eas.farm.breed.parentFacadeFactory;
import com.kingdee.eas.util.app.ContextUtil;
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
public class ParentBreedBatchDetailInfo implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2671324606152652200L;
	private Context ctx;
	// ������Ϣ
	private ParentBreedBatchInfo batchInfo; 
	// ��ǰ��������
	private int currentWeek;
	// ��ǰ���� �� �ĵڼ���
	private int currentDay;
	// ��Ʒ�� ����
	private int days;
	// ��Ӧ����ֳ�淶
	private BreedModelInfo breedModelInfo;
	//	// �������
	//	private HenhouseType houseType;
	// ��ǰ���� ���ձ���ϸ�б�
	private Map<String,Object> dailyInfos;

	private BreedModelEntryInfo breedModelEntryInfo;

	// 

	/**
	 * ���췽����������������Ϣ
	 * @throws BOSException 
	 */
	public ParentBreedBatchDetailInfo(Context ctx,ParentBreedBatchInfo batchInfo,Date bizDate) throws BOSException{
		this.ctx = ctx;
		if(batchInfo == null || batchInfo.getId() == null){
			throw new FarmException("������Ϣ����Ϊ��");
		}else{
			this.setBatchInfo(batchInfo);

			IparentFacade parentFacade = null;
			if(ctx == null){
				parentFacade = parentFacadeFactory.getRemoteInstance();
			}else{
				parentFacade = parentFacadeFactory.getLocalInstance(ctx);
			}

			CompanyOrgUnitInfo currCompany;
			if(ctx == null){
				currCompany = SysContext.getSysContext().getCurrentFIUnit();
			}else{
				currCompany = ContextUtil.getCurrentFIUnit(ctx);
			}
			if(currCompany == null){
				throw new BOSException("��ǰ��֯�������κι�˾�����ܲ���");
			}
			String companyID = currCompany.getId().toString();
			// ���� ��ֳ�淶
			if(batchInfo.getBreedModel() != null){
				this.breedModelInfo = batchInfo.getBreedModel();
			}
			else{
				setBreedModelInfo(companyID,batchInfo.isIsMoultingBatch());
			}
			if(this.getBreedModelInfo() != null){

				Date inDate = batchInfo.getBizDate();
				int week = batchInfo.getWeek();
				int day = batchInfo.getWeekDay();

				HashMap weekInfo = parentFacade.getBatchWeekages(batchInfo.getId().toString(),bizDate);
				Integer currWeek = (Integer) weekInfo.get("currWeek");
				Integer currDay = (Integer) weekInfo.get("currDay");
				// �������� ����
				this.setCurrentWeek(currWeek);
				this.setCurrentDay(currDay);
				IBreedFacade breedFacade = null;
				if(ctx == null){
					breedFacade = BreedFacadeFactory.getRemoteInstance();
				}else{
					breedFacade = BreedFacadeFactory.getLocalInstance(ctx);
				}

				breedModelEntryInfo = breedFacade.getBreedModelEntryInfo(this.getBreedModelInfo().getId().toString(), this.getCurrentWeek(),0);


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
	public Map<String,ParentBreedBatchEntryDetailInfo> getHenhouseBreedingStock(Context ctx,Date bizDate) throws BOSException, EASBizException{
		// map ��Ϊ����ֵ key����id
		Map<String,ParentBreedBatchEntryDetailInfo> result = new HashMap<String, ParentBreedBatchEntryDetailInfo>();
		// ��ֳ������Ϣ
		ParentBreedBatchInfo bbInfo = this.getBatchInfo();
		if(bbInfo != null){
			ParentBreedBatchEntryCollection entryColl = bbInfo.getEntrys();
			for(int i = 0; i < entryColl.size(); i++){
				ParentBreedBatchEntryInfo batchEntryInfo = entryColl.get(i);
				if(batchEntryInfo != null){
					IParentBreedBatchEntry breedBE = null;
					if(ctx == null){
						breedBE = ParentBreedBatchEntryFactory.getRemoteInstance();
					}else{
						breedBE = ParentBreedBatchEntryFactory.getLocalInstance(ctx);
					}
					batchEntryInfo = breedBE.getParentBreedBatchEntryInfo(new ObjectUuidPK(batchEntryInfo.getId()));



					// ÿ����¼����һ����ϸ 
					ParentBreedBatchEntryDetailInfo entryDetailInfo = new ParentBreedBatchEntryDetailInfo();
					entryDetailInfo.setHenhouse(batchEntryInfo.getHenhouse());
					entryDetailInfo.setInitQty(batchEntryInfo.getHenInitQty());
					entryDetailInfo.setFixedInitQty(batchEntryInfo.getHenInitQty());
					entryDetailInfo.setNowQty(batchEntryInfo.getHenInitQty());
					entryDetailInfo.setHenInitQty(batchEntryInfo.getHenInitQty());
					entryDetailInfo.setHenFixedInitQty(batchEntryInfo.getHenInitQty());
					entryDetailInfo.setHenNowQty(batchEntryInfo.getHenInitQty());
					entryDetailInfo.setCockInitQty(batchEntryInfo.getCockInitQty());
					entryDetailInfo.setCockFixedInitQty(batchEntryInfo.getCockInitQty());
					entryDetailInfo.setCockNowQty(batchEntryInfo.getCockInitQty());

					// �ݴ� map
					result.put(batchEntryInfo.getHenhouse().getId().toString(), entryDetailInfo);
				}

			}


			// ת����ϸ���� ������
			ParentBreedBatchTransEntryCollection transEntryColl = bbInfo.getTransEntrys();
			for(int i = 0; i < transEntryColl.size(); i++){
				ParentBreedBatchTransEntryInfo transEntryInfo = transEntryColl.get(i);
				IParentBreedBatchTransEntry batchTransEntry = null;
				if(ctx != null){
					batchTransEntry = ParentBreedBatchTransEntryFactory.getLocalInstance(ctx);
				}else{
					batchTransEntry = ParentBreedBatchTransEntryFactory.getRemoteInstance();
				}
				transEntryInfo = batchTransEntry.getParentBreedBatchTransEntryInfo(new ObjectUuidPK(transEntryInfo.getId()));
				// ֻ���� ת������С��ҵ�����ڵ� ��¼
				Date transDate = transEntryInfo.getTransDate();
				if(transDate.after(bizDate)){
					continue;
				}

				if(transEntryInfo != null){
					// ��ȡ ת�������Ϣ ���ۼƵ� ���������Ϣ��
					Boolean isTransOut = transEntryInfo.isIsTransOut();
					HenhouseInfo currHenhouse = null;
					// ������ת �� ʱ ��¼
					HenhouseInfo transInHouse = transEntryInfo.getToHenhouse();
					HenhouseInfo transOutHouse = transEntryInfo.getFromHenhouse();
					// ������ר��
					boolean isFromOther  = transEntryInfo.isIsFromOtherBatch();
					int henTransOutQty = 0;
					int henTransInQty = 0;
					int henAsFixedInQty = 0;
					int henAsFixedOutQty = 0;


					int cockTransOutQty = 0;
					int cockTransInQty = 0;
					int cockAsFixedInQty = 0;
					int cockAsFixedOutQty = 0;

					int transEggOutQty = 0;
					int transEggInQty = 0;
					if(isTransOut){
						currHenhouse = transEntryInfo.getFromHenhouse();
						henTransOutQty = transEntryInfo.getTransHenQty();
						cockTransOutQty = transEntryInfo.getTransCockQty();
						henAsFixedOutQty = transEntryInfo.getHenAsFixedQty();
						cockAsFixedOutQty = transEntryInfo.getCockAsFixedQty();

						transEggOutQty = transEntryInfo.getAsTransEggQty();
					}else{
						currHenhouse = transEntryInfo.getToHenhouse();
						henTransInQty = transEntryInfo.getTransHenQty();
						cockTransInQty = transEntryInfo.getTransCockQty();

						henAsFixedInQty = transEntryInfo.getHenAsFixedQty();
						cockAsFixedInQty = transEntryInfo.getCockAsFixedQty();

						transEggInQty = transEntryInfo.getAsTransEggQty();
					}


					// if(
							// ��� �������Ѵ����� ȡ�� ���ӵ��������������û��������һ��
					// ���1  ������
					if(isFromOther &&  currHenhouse != null){
						ParentBreedBatchEntryDetailInfo entryDetailInfo = result.get(currHenhouse.getId().toString());

						if(entryDetailInfo == null){
							entryDetailInfo = new ParentBreedBatchEntryDetailInfo();
						}
						// ���ݵ�Ĭ�� nowqty��initqty��ʹ�� ��ĸ��
						entryDetailInfo.setNowQty(entryDetailInfo.getNowQty() + henTransInQty -henTransOutQty);
						entryDetailInfo.setHenhouse(currHenhouse);

						// ����
						entryDetailInfo.setCockFixedInitQty(entryDetailInfo.getCockFixedInitQty()+ cockAsFixedInQty - cockAsFixedOutQty);
						entryDetailInfo.setCockTransInAsInitQty(entryDetailInfo.getCockTransInAsInitQty() + cockAsFixedInQty );
						entryDetailInfo.setCockTransInQty(entryDetailInfo.getCockTransInQty() + cockTransInQty);
						entryDetailInfo.setCockTransOutAsInitQty(entryDetailInfo.getCockTransOutAsInitQty() + cockAsFixedOutQty);
						entryDetailInfo.setCockTransOutQty(entryDetailInfo.getCockTransOutQty() + cockTransOutQty);
						entryDetailInfo.setCockNowQty(entryDetailInfo.getCockNowQty() + cockTransInQty - cockTransOutQty);

						// ĸ
						entryDetailInfo.setHenTransInAsInitQty(entryDetailInfo.getHenTransInAsInitQty()+henAsFixedInQty);
						entryDetailInfo.setHenFixedInitQty(entryDetailInfo.getHenFixedInitQty() + henAsFixedInQty - henAsFixedOutQty);
						entryDetailInfo.setHenNowQty(entryDetailInfo.getHenNowQty() + henTransInQty - henTransOutQty);
						entryDetailInfo.setHenTransInAsInitQty(entryDetailInfo.getHenTransInAsInitQty() + henAsFixedInQty);
						entryDetailInfo.setHenTransInQty(entryDetailInfo.getHenTransInQty() + henTransInQty);

						entryDetailInfo.setHenTransOutAsInitQty(entryDetailInfo.getHenTransOutAsInitQty() + henAsFixedOutQty);
						entryDetailInfo.setHenTransOutQty(entryDetailInfo.getHenTransOutQty() + henTransOutQty);

						// �ۺ��ֵ����� 
						entryDetailInfo.setTransInEggQty(entryDetailInfo.getTransInEggQty() + transEggInQty);
						entryDetailInfo.setTransOutEggQty(entryDetailInfo.getTransOutEggQty() + transEggOutQty);

						// �ݴ� map
						result.put(currHenhouse.getId().toString(), entryDetailInfo);
					}else{
						// ���2 ��������
						if(transInHouse != null){
							ParentBreedBatchEntryDetailInfo inEntryDetailInfo = result.get(transInHouse.getId().toString());

							if(inEntryDetailInfo == null){
								inEntryDetailInfo = new ParentBreedBatchEntryDetailInfo();
							}
							// ���ݵ�Ĭ�� nowqty��initqty��ʹ�� ��ĸ��
							inEntryDetailInfo.setNowQty(inEntryDetailInfo.getNowQty() + transEntryInfo.getTransHenQty());
							inEntryDetailInfo.setHenhouse(transInHouse);


							// ����
							inEntryDetailInfo.setCockFixedInitQty(inEntryDetailInfo.getCockFixedInitQty()+ transEntryInfo.getCockAsFixedQty());
							inEntryDetailInfo.setCockTransInAsInitQty(inEntryDetailInfo.getCockTransInAsInitQty() + transEntryInfo.getCockAsFixedQty() );
							inEntryDetailInfo.setCockTransInQty(inEntryDetailInfo.getCockTransInQty() + transEntryInfo.getTransCockQty());
							inEntryDetailInfo.setCockTransOutAsInitQty(inEntryDetailInfo.getCockTransOutAsInitQty());
							inEntryDetailInfo.setCockTransOutQty(inEntryDetailInfo.getCockTransOutQty());
							inEntryDetailInfo.setCockNowQty(inEntryDetailInfo.getCockNowQty() + transEntryInfo.getTransCockQty());

							// ĸ
							inEntryDetailInfo.setHenTransInAsInitQty(inEntryDetailInfo.getHenTransInAsInitQty()+transEntryInfo.getHenAsFixedQty());
							inEntryDetailInfo.setHenFixedInitQty(inEntryDetailInfo.getHenFixedInitQty() + transEntryInfo.getHenAsFixedQty());
							inEntryDetailInfo.setHenNowQty(inEntryDetailInfo.getHenNowQty() + transEntryInfo.getTransHenQty());

							inEntryDetailInfo.setHenTransInQty(inEntryDetailInfo.getHenTransInQty() + transEntryInfo.getTransHenQty());

							inEntryDetailInfo.setHenTransOutAsInitQty(inEntryDetailInfo.getHenTransOutAsInitQty() );
							inEntryDetailInfo.setHenTransOutQty(inEntryDetailInfo.getHenTransOutQty() );

							// �ۺ��ֵ����� 
							inEntryDetailInfo.setTransInEggQty(inEntryDetailInfo.getTransInEggQty() + transEntryInfo.getAsTransEggQty());
							inEntryDetailInfo.setTransOutEggQty(inEntryDetailInfo.getTransOutEggQty() );

							// �ݴ� map
							result.put(transInHouse.getId().toString(), inEntryDetailInfo);
						}

						if(transOutHouse != null){
							// ���2 ��������
							ParentBreedBatchEntryDetailInfo outEntryDetailInfo = result.get(transOutHouse.getId().toString());

							if(outEntryDetailInfo == null){
								outEntryDetailInfo = new ParentBreedBatchEntryDetailInfo();
							}
							// ���ݵ�Ĭ�� nowqty��initqty��ʹ�� ��ĸ��
							outEntryDetailInfo.setNowQty(outEntryDetailInfo.getNowQty() - transEntryInfo.getTransHenQty());
							outEntryDetailInfo.setHenhouse(transOutHouse);


							// ����
							outEntryDetailInfo.setCockFixedInitQty(outEntryDetailInfo.getCockFixedInitQty()- transEntryInfo.getCockAsFixedQty());
							outEntryDetailInfo.setCockTransInAsInitQty(outEntryDetailInfo.getCockTransInAsInitQty() );
							outEntryDetailInfo.setCockTransInQty(outEntryDetailInfo.getCockTransInQty() );
							outEntryDetailInfo.setCockTransOutAsInitQty(outEntryDetailInfo.getCockTransOutAsInitQty() + transEntryInfo.getCockAsFixedQty());
							outEntryDetailInfo.setCockTransOutQty(outEntryDetailInfo.getCockTransOutQty()+ transEntryInfo.getTransCockQty());
							outEntryDetailInfo.setCockNowQty(outEntryDetailInfo.getCockNowQty() - transEntryInfo.getTransCockQty());

							// ĸ
							outEntryDetailInfo.setHenTransInAsInitQty(outEntryDetailInfo.getHenTransInAsInitQty());
							outEntryDetailInfo.setHenFixedInitQty(outEntryDetailInfo.getHenFixedInitQty());
							outEntryDetailInfo.setHenNowQty(outEntryDetailInfo.getHenNowQty() - transEntryInfo.getTransHenQty());

							outEntryDetailInfo.setHenTransInQty(outEntryDetailInfo.getHenTransInQty());

							outEntryDetailInfo.setHenTransOutAsInitQty(outEntryDetailInfo.getHenTransOutAsInitQty() +transEntryInfo.getHenAsFixedQty());
							outEntryDetailInfo.setHenTransOutQty(outEntryDetailInfo.getHenTransOutQty()  + transEntryInfo.getTransHenQty());

							// �ۺ��ֵ����� 
							outEntryDetailInfo.setTransInEggQty(outEntryDetailInfo.getTransInEggQty());
							outEntryDetailInfo.setTransOutEggQty(outEntryDetailInfo.getTransOutEggQty() + transEntryInfo.getAsTransEggQty() );

							// �ݴ� map
							result.put(transOutHouse.getId().toString(), outEntryDetailInfo);
						}
					}

				}


			}

			// ͳ��������Ϣ  �������ǰ��������  ���� map����
			StringBuffer sql = new StringBuffer();
			//			HenhouseType type = bbInfo.getHouseType();
			//			if(HenhouseType.CC.equals(type)){
			//				sql.append("select te.CFHenhouseID,sum(te.CFCullAndDeath) cull,0,0,0,0,0,sum(te.CFMarketQty) marketQty,sum(CFTRANSQTY) transQty from CT_FM_CommecialCDAE te inner join CT_FM_CommecialChilkenDaily t on te.fparentid = t.fid ");
			//			}else if(HenhouseType.Brood.equals(type)){
			//				sql.append("select te.CFHenhouseID,sum(te.CFCullQty) cull,sum(te.CFDeathQty) death,0,0,0,0,sum(te.CFMarketQty) marketQty,0 from CT_FM_BroodDailyAssEntry te inner join CT_FM_BroodDaily t on te.fparentid = t.fid ");
			//			}else {
			sql.append("select te.CFHenhouseID,0,0,sum(te.CFHenCull)+sum(te.CFHenBatchCull) hencull, sum(te.CFHenDeath) henDeath,sum(te.CFCockCull) + sum(te.CFCockBatchCull) cockCull,sum(te.CFCockDeath) cockDeath,0,0 from CT_FM_LayEDCDE te inner join CT_FM_LayEggDaily t on te.fparentid = t.fid ");
			//			}

			sql.append(" where t.cfparentbatchid ='");
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

					ParentBreedBatchEntryDetailInfo entryDetailInfo = result.get(fid);
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
	private BreedModelInfo setBreedModelInfo(String companyID,boolean isMoulding) throws BOSException{
		if(this.getBatchInfo() == null){
			return null;
		}else{
			IparentFacade breedFacade = null;
			if(ctx == null){
				breedFacade = parentFacadeFactory.getRemoteInstance();
			}else{
				breedFacade = parentFacadeFactory.getLocalInstance(ctx);
			}
			this.breedModelInfo =  breedFacade.getBreedModel(HenhouseType.LAYEGG_VALUE,companyID,isMoulding);
			return breedModelInfo;
		}

	}



	public ParentBreedBatchInfo getBatchInfo() {
		return batchInfo;
	}

	public void setBatchInfo(ParentBreedBatchInfo batchInfo) {
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
