package com.kingdee.eas.farm.pig.ccpig.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.pig.ImmuneMode;
import com.kingdee.eas.farm.pig.PigFarmType;
import com.kingdee.eas.farm.pig.PigHouseInfo;
import com.kingdee.eas.farm.pig.immuneSourceType;
import com.kingdee.eas.farm.pig.bean.CCPigBatchDetailInfo;
import com.kingdee.eas.farm.pig.bean.CCPigBatchNormalInfo;
import com.kingdee.eas.farm.pig.bean.ImmunePlanDetailInfo;
import com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelEntryCollection;
import com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelEntryInfo;
import com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelFactory;
import com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelImmuneEntryCollection;
import com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelImmuneEntryInfo;
import com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;


public class CCPigFacadeControllerBean extends AbstractCCPigFacadeControllerBean
{
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8927009264171180618L;
	
	private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.pig.ccpig.app.CCPigFacadeControllerBean");

    /**
     * ���ָ����ֳ�� ��ǰ������ ��Ʒ������ 
     * ��ȡ �������������� ��ϸ
     * 
     * TODO  ��ʱ��Ϊ ��ֳ��������һ������ ���Ը÷��� ��ͣ
     */
	@Override
	protected CCPigBatchNormalInfo _getFarmBreedCCPigBatch(Context ctx, String farmID, Date bizDate)
			throws BOSException {
		List<CCPigBatchDetailInfo> batchDetails = new ArrayList<CCPigBatchDetailInfo>();
		// ��ȡ��ֳ���ڵ�ǰ���� �� ������ϸ�б�
//		String sql = "select t";
		// TODO ������ͣʹ�ã�����ʵ��
		return null;
	}

	/**
	 * ��� ��ֳ��  ָ������ĳ��� ��ʼ �������
	 */
	@Override
	protected CCPigBatchNormalInfo _getFarmBreedCCPigBatch(Context ctx, String farmID,
			String batchID, Date bizDate) throws BOSException {
		// ������� ������Ϣ
		CCPigBatchNormalInfo normalInfo  = getBatchNormalInfo(ctx, farmID, batchID, bizDate);
		if(normalInfo != null){
			// ������ϸ��Ϣ
			List<CCPigBatchDetailInfo> batchDetails = getBatchDetailInfos(ctx, normalInfo);
			
			normalInfo.setBatchDetails(batchDetails);
		}
		return normalInfo;
	}
	/**
	 * ��ȡ���� ���� ��ϸ
	 * ���������
	 * @param normalInfo
	 * @return
	 * @throws BOSException 
	 */
	public List<CCPigBatchDetailInfo> getBatchDetailInfos(Context ctx, CCPigBatchNormalInfo normalInfo) throws BOSException{
		
		// ������ϸ��Ϣ 
		List<CCPigBatchDetailInfo> batchDetails = new ArrayList<CCPigBatchDetailInfo>();
		
		if(normalInfo != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String nowDateStr = sdf.format(normalInfo.getNowDate());
			
			StringBuilder sb = new StringBuilder();
			
			sb.append(" 		select max(t.fid) batchID, ");
			sb.append(" 	       max(te.cfinitqty) initQty, ");
			sb.append(" 	       max(te.cfincoopdate) incoopdate, ");
			sb.append(" 	       max(te.cfmarketqty) marketqty, ");
			sb.append(" 	       max(te.cfremark) remark, ");
			sb.append(" 		   tph.fid pighouseID, ");
			sb.append(" 	       max(tph.fnumber) pighouseNumber, ");
			sb.append(" 	       max(tph.fname_l2) pighouseName ");
//			sb.append(" 	       sum(tdde.cfdeathqty) dcPigQty ");
			sb.append(" 	from CT_PIG_CCPigBatch t ");
			sb.append(" 	inner join CT_PIG_CCPigBatchEntry te on t.fid = te.fparentid ");
			sb.append(" 	inner join ct_pig_pighouse tph on te.cfpighouseid = tph.fid ");
//			sb.append(" 	left join CT_PIG_CCPigDaily td on td.CFPigBatchID = t.fid ");
//			sb.append(" 	left join CT_PIG_CCPigDailyDCEntrys tdde on tdde.fparentid = td.fid and tdde.fpighouseid = te.cfpighouseid and tdde.cfpigbatchid = t.fid ");
			sb.append(" where t.fid='");
			sb.append(normalInfo.getBatchID());
//			sb.append("' and (td.fbizdate <=to_date('");
//			sb.append(nowDateStr);
//			sb.append("','yyyy-mm-dd') or td.fbizdate is null) group by tph.fid ");
			sb.append("' group by tph.fid ");
			
			
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			try{
				// ÿ�� ��һ����¼
				while(rs.next()){
					// ������ϸ��Ϣ
					CCPigBatchDetailInfo batchDetail = new CCPigBatchDetailInfo();
					String  batchID = rs.getString("batchID");
					String  pighouseID = rs.getString("pighouseID");
					String  pighouseNumber = rs.getString("pighouseNumber");
					String  pighouseName = rs.getString("pighouseName");
					Date  incoopdate = rs.getDate("incoopdate");
					int  initQty = rs.getInt("initQty");
					int  marketqty = rs.getInt("marketqty");
//					int  dcPigQty = rs.getInt("dcPigQty");
					
					// ��ȡ������
					StringBuilder dsql = new StringBuilder("select sum(te.FDeathQty) deathQty from CT_PIG_CCPigDailyDCEntrys te inner join CT_PIG_CCPigDaily t on te.fparentid = t.fid where te.FPigHouseID = '");
					dsql.append(pighouseID);
					dsql.append("' and t.CFPigBatchID ='");
					dsql.append(normalInfo.getBatchID());
					dsql.append("' and t.fbizdate <= { ts '");
					dsql.append(nowDateStr);
					dsql.append(" 23:59:59'} ");
					
					int deadthQty = 0;
					try{
						IRowSet drs = DbUtil.executeQuery(ctx, dsql.toString());
						if(drs.next()){
							deadthQty = drs.getInt("deathQty");
						}
					}catch(SQLException sqle){
						throw new BOSException(sqle);
					}
					
					// ��ȡ��̭��
					StringBuilder csql = new StringBuilder("select sum(te.FCullQty) cullQty from T_PIG_CCPigDailyCullEntrys te inner join CT_PIG_CCPigDaily t on te.fparentid = t.fid where te.FPigHouseID = '");
					csql.append(pighouseID);
					dsql.append("' and t.CFPigBatchID ='");
					dsql.append(normalInfo.getBatchID());
					csql.append("' and t.fbizdate <= {ts '");
					csql.append(nowDateStr);
					csql.append(" 23:59:59'}  ");
					
					int cullQty = 0;
					try{
						IRowSet crs = DbUtil.executeQuery(ctx, csql.toString());
						if(crs.next()){
							cullQty = crs.getInt("cullQty");
						}
					}catch(SQLException sqle){
						throw new BOSException(sqle);
					}
					
					
					// ������
					StringBuilder osql = new StringBuilder("select sum(te.CFQty) outQty from CT_PIG_CCPigDailyOutEntrys te inner join CT_PIG_CCPigDaily t on te.fparentid = t.fid where te.CFPigHouseID = '");
					osql.append(pighouseID);
					osql.append("' and t.CFPigBatchID ='");
					osql.append(normalInfo.getBatchID());
					osql.append("' and t.fbizdate <= { ts'");
					osql.append(nowDateStr);
					osql.append(" 23:59:59'} ");
					
					int outQty = 0;
					try{
						IRowSet crs = DbUtil.executeQuery(ctx, osql.toString());
						if(crs.next()){
							outQty = crs.getInt("outQty");
						}
					}catch(SQLException sqle){
						throw new BOSException(sqle);
					}
					
					
					
					
					batchDetail.setBatchID(batchID);
					batchDetail.setIncoopDate(incoopdate);
					batchDetail.setInitQty(initQty);
//					batchDetail.setMarketQty(marketqty);
					batchDetail.setDeathQty(deadthQty);
					batchDetail.setCullQty(cullQty);
					batchDetail.setMarketQty(outQty);
					PigHouseInfo pighouseInfo = new PigHouseInfo();
					pighouseInfo.setId(BOSUuid.read(pighouseID));
					pighouseInfo.setNumber(pighouseNumber);
					pighouseInfo.setName(pighouseName);
					
					batchDetail.setPigHouse(pighouseInfo);
					// ���ӵ���ϸ��
					batchDetails.add(batchDetail);
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
				throw new BOSException(sqle);
			}
		}
		
		return batchDetails;
	}
	
//	/**
//	 * ��ȡ���� ���� ��ϸ
//	 * ���������
//	 * @param normalInfo
//	 * @return
//	 * @throws BOSException 
//	 */
//	public List<CCPigBatchDetailInfo> getBatchDetailInfos(Context ctx, CCPigBatchNormalInfo normalInfo) throws BOSException{
//		
//		// ������ϸ��Ϣ 
//		List<CCPigBatchDetailInfo> batchDetails = new ArrayList<CCPigBatchDetailInfo>();
//		
//		if(normalInfo != null){
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			String nowDateStr = sdf.format(normalInfo.getNowDate());
//			
//			StringBuilder sb = new StringBuilder("/*dialect*/");
//			
//			sb.append(" 		select max(t.fid) batchID, ");
//			sb.append(" 	       max(te.cfinitqty) initQty, ");
//			sb.append(" 	       max(te.cfincoopdate) incoopdate, ");
//			sb.append(" 	       max(te.cfmarketqty) marketqty, ");
//			sb.append(" 	       max(te.cfremark) remark, ");
//			sb.append(" 		   tph.fid pighouseID, ");
//			sb.append(" 	       max(tph.fnumber) pighouseNumber, ");
//			sb.append(" 	       max(tph.fname_l2) pighouseName, ");
//			sb.append(" 	       sum(tdde.cfdeathqty) dcPigQty ");
//			sb.append(" 	from CT_PIG_CCPigBatch t ");
//			sb.append(" 	inner join CT_PIG_CCPigBatchEntry te on t.fid = te.fparentid ");
//			sb.append(" 	inner join ct_pig_pighouse tph on te.cfpighouseid = tph.fid ");
//			sb.append(" 	left join CT_PIG_CCPigDaily td on td.CFPigBatchID = t.fid ");
//			sb.append(" 	left join CT_PIG_CCPigDailyDCEntrys tdde on tdde.fparentid = td.fid and tdde.fpighouseid = te.cfpighouseid and tdde.cfpigbatchid = t.fid ");
//			sb.append(" where t.fid='");
//			sb.append(normalInfo.getBatchID());
//			sb.append("' and (td.fbizdate <=to_date('");
//			sb.append(nowDateStr);
//			sb.append("','yyyy-mm-dd') or td.fbizdate is null) group by tph.fid ");
//			
//			
//			
//			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
//			try{
//				// ÿ�� ��һ����¼
//				while(rs.next()){
//					// ������ϸ��Ϣ
//					CCPigBatchDetailInfo batchDetail = new CCPigBatchDetailInfo();
//					String  batchID = rs.getString("batchID");
//					String  pighouseID = rs.getString("pighouseID");
//					String  pighouseNumber = rs.getString("pighouseNumber");
//					String  pighouseName = rs.getString("pighouseName");
//					Date  incoopdate = rs.getDate("incoopdate");
//					int  initQty = rs.getInt("initQty");
//					int  marketqty = rs.getInt("marketqty");
//					int  dcPigQty = rs.getInt("dcPigQty");
//					
//					batchDetail.setBatchID(batchID);
//					batchDetail.setIncoopDate(incoopdate);
//					batchDetail.setInitQty(initQty);
//					batchDetail.setMarketQty(marketqty);
//					batchDetail.setDcQty(dcPigQty);
//					batchDetail.setNowQty(initQty - marketqty- dcPigQty);
//					
//					PigHouseInfo pighouseInfo = new PigHouseInfo();
//					pighouseInfo.setId(BOSUuid.read(pighouseID));
//					pighouseInfo.setNumber(pighouseNumber);
//					pighouseInfo.setName(pighouseName);
//					
//					batchDetail.setPigHouse(pighouseInfo);
//					// ���ӵ���ϸ��
//					batchDetails.add(batchDetail);
//				}
//			}catch(SQLException sqle){
//				sqle.printStackTrace();
//				throw new BOSException(sqle);
//			}
//		}
//		
//		return batchDetails;
//	}
	
	
	/**
	 * �����������ʱ������Ϣ
	 * @param ctx
	 * @param farmID
	 * @param batchID
	 * @param bizDate
	 * @return
	 * @throws BOSException 
	 */
	private CCPigBatchNormalInfo getBatchNormalInfo(Context ctx, String farmID, String batchID, Date bizDate) throws BOSException{
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String bizDateStr = sdf.format(bizDate);
		// ��ȡ��ֳ���ڵ�ǰ���� �� ������ϸ�б�
		StringBuilder sql = new StringBuilder("");
		sql.append(" select t.fid batchID, ");
		sql.append("     t.fbizdate bizdate, ");
		sql.append("     t.CFDAYS initDays, ");
		
        sql.append("      t.fnumber batchNumber, ");
        sql.append("     tpf.fid farmID, ");
        sql.append("     tpf.fnumber farmNumber, ");
        sql.append("     tpf.fname_l2 farmName, ");
        sql.append("     tpf.cfstoorgunitid stoOrgID, ");
        sql.append("       t.cfcostobjectid costObjectID, ");
        sql.append("       tc.fnumber costObjectNumber, ");
        sql.append("       tc.fname_l2 costObjectName, ");
        sql.append("       t.cfinitallqty initAllQty, ");
        sql.append("        t.cfaveweight aveWeight, ");
        sql.append("      t.cfbasestatus ");
        sql.append(" from CT_PIG_CCPigBatch t  ");
	// --inner join CT_PIG_CCPigBatchEntry te on t.fid = te.fparentid
	    sql.append(" inner join ct_pig_pigfarm tpf on t.cfpigfarmid = tpf.fid ");
	// --inner join ct_pig_pighouse tph on te.cfpighouseid = tph.fid
	    sql.append(" inner join t_bd_costobject tc on t.cfcostobjectid = tc.fid ");

	
		sql.append(" where t.cfpigfarmid = '");
		sql.append(farmID);
		sql.append("' and t.fid='");
		sql.append(batchID);
		sql.append("' and t.cfbasestatus < 5 ");
//		sql.append(" and t.fbizdate < to_date('");
//		sql.append(bizDateStr);
//		sql.append("','yyyy-mm-dd') ");
//		sql.append(" and t.fbizdate > to_date('");
//		sql.append(bizDateStr);
//		sql.append("','yyyy-mm-dd')-180 ");
		
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		try{
			if(rs.next()){
				Date incoopDate = rs.getDate("bizdate");
				int incoopDays = rs.getInt("initDays");
				String batchNumber = rs.getString("batchNumber");
				String farmNumber = rs.getString("farmNumber");
				String farmName = rs.getString("farmName");
				String stoOrgID = rs.getString("stoOrgID");
				String costObjectID = rs.getString("costObjectID");
				String costObjectNumber = rs.getString("costObjectNumber");
				String costObjectName = rs.getString("costObjectName");
				int initAllQty = rs.getInt("initAllQty");
				BigDecimal aveWeight = rs.getBigDecimal("aveWeight");
				int baseStatus = rs.getInt("cfbasestatus");
				
				CCPigBatchNormalInfo normalBeanInfo = new CCPigBatchNormalInfo();
				
				normalBeanInfo.setBatchID(batchID);
				normalBeanInfo.setBatchNumber(batchNumber);
				
				normalBeanInfo.setBatchName(costObjectName);
				normalBeanInfo.setFarmID(farmID);
				normalBeanInfo.setFarmNumber(farmNumber);
				normalBeanInfo.setFarmName(farmName);
				
				normalBeanInfo.setStoOrgID(stoOrgID);
				normalBeanInfo.setCostObjectID(costObjectID);
				normalBeanInfo.setCostObjectNumber(costObjectNumber);
				normalBeanInfo.setCostObjectName(costObjectName);
				
				normalBeanInfo.setIncoopDate(incoopDate);
				normalBeanInfo.setIncoopDays(incoopDays);
				normalBeanInfo.setNowDate(bizDate);
				normalBeanInfo.setInitAllQty(initAllQty);
				normalBeanInfo.setAveWeight(aveWeight);
				normalBeanInfo.setBaseStatus(BillBaseStatusEnum.getEnum(baseStatus));
				
				
				return normalBeanInfo;
				
			}
		}catch(SQLException sqle){
			
			throw new BOSException(sqle);
		}
		
		return null;

	}

	/**
	 * ��õ�ǰ���õ� ��Ʒ����ֳ�淶
	 */
	@Override
	protected CCPigBreedModelInfo _getAvailableBreedModel(Context ctx,
			Date bizDate,String farmID) throws BOSException {
		if(bizDate != null){
			StringBuilder sb = new StringBuilder();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sb.append("select fid from CT_PIG_CCPigBreedModel where CFBeginDate<= {d '");
			sb.append(sdf.format(bizDate));
			sb.append("'} and CFEndDate >={d '");
			sb.append(sdf.format(bizDate));
			sb.append("'} and fid in ( select te.fparentid from T_PIG_CCPBMFE te where te.FFarmFactoryID = '");
			sb.append(farmID);
			sb.append("') and FDeletedStatus=1 ");
			try{
				IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
				if(rs.next()){
					String fid = rs.getString("fid");
					return CCPigBreedModelFactory.getLocalInstance(ctx).getCCPigBreedModelInfo(new ObjectUuidPK(fid));
				}
			}catch(EASBizException easbize){
				throw new BOSException(easbize);
			} catch (SQLException e) {
				
				e.printStackTrace();
				throw new BOSException(e);
			}
		}
		return null;
	}

	/**
	 * ��� ��ֳ�淶��Ӧ����� ��ι�淶��ϸ
	 */
	@Override
	protected CCPigBreedModelEntryInfo _getModelBreedEntryInfo(Context ctx,
			CCPigBreedModelInfo modelInfo, int days) throws BOSException {
		if(modelInfo != null && days > 0){
			CCPigBreedModelEntryCollection modelEntrys = modelInfo.getEntrys();
			if(modelEntrys != null && modelEntrys.size() > 0){
				for(int i = 0; i < modelEntrys.size(); i++){
					// ��ι�淶��ϸ
					CCPigBreedModelEntryInfo entryInfo = modelEntrys.get(i);
					if(entryInfo.getDays() == days){
						return entryInfo;
					}
				}
			}
		}else{
			return null;
		}
		return null;
	}

	/**
	 * �����ֳ�淶��Ӧ�����  ���߹淶 ��ϸ
	 */
	@Override
	protected List<ImmunePlanDetailInfo> _getModelImmunePlans(Context ctx,
			CCPigBreedModelInfo modelInfo, Date bizDate, int days) throws BOSException {
		// ���
		List<ImmunePlanDetailInfo> immuneList = new ArrayList<ImmunePlanDetailInfo>();
		try{
			if(modelInfo != null && days > 0){
	//			CCPigBreedModelEntryCollection modelEntrys = modelInfo.getEntrys();
				
				CCPigBreedModelImmuneEntryCollection immuneEntry = modelInfo.getImmuneEntrys();
				if(immuneEntry != null && immuneEntry.size() > 0){
					for(int i = 0; i < immuneEntry.size(); i++){
						// ���߹淶��ϸ
						CCPigBreedModelImmuneEntryInfo entryInfo = immuneEntry.get(i);
						int beginDays = entryInfo.getBeginDays();
						int endDays = entryInfo.getEndDays();
						
						if(days >= beginDays && days <= endDays){
							ImmunePlanDetailInfo detailInfo = new ImmunePlanDetailInfo();
							MaterialInfo materialInfo = new MaterialInfo();
							materialInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(entryInfo.getImmuneMaterial().getId()));
							MeasureUnitInfo unitInfo = new MeasureUnitInfo();
							unitInfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(entryInfo.getImmuneMaterial().getBaseUnit().getId()));
							
							// ����
	//						materialInfo.setId(BOSUuid.read(materialID));
	//						materialInfo.setNumber(materialNumber);
	//						materialInfo.setName(materialName);
							// ������λ
	//						unitInfo.setId(BOSUuid.read(unitID));
	//						unitInfo.setNumber(unitNumber);
	//						unitInfo.setName(unitName);
							// ������ϸ��Ϣ
							detailInfo.setActiveDate(null);
							detailInfo.setDisableDate(null);
							
							// ��������ڼ�
							Calendar cal = Calendar.getInstance();
							cal.setTime(bizDate);
							// ��������
							cal.add(Calendar.DATE, -days);
							cal.add(Calendar.DATE, beginDays);
							Date immuneBeginDate = cal.getTime();
							// ���߽�������
							cal.add(Calendar.DATE, endDays-beginDays);
							Date immuneEndDate = cal.getTime();
							
							detailInfo.setSourceEntryID(entryInfo.getId().toString());
							detailInfo.setSourceType(immuneSourceType.BatchImmune);
							detailInfo.setImmuneBeginDate(immuneBeginDate);
							detailInfo.setImmuneEndDate(immuneEndDate);
							detailInfo.setImmuneMaterial(materialInfo);
							detailInfo.setImmuneMode(entryInfo.getImmuneMode());
							detailInfo.setPigFarmType(PigFarmType.CommPig);
							detailInfo.setQtyPer(entryInfo.getQtyPer());
							detailInfo.setUnit(unitInfo);
							
							immuneList.add(detailInfo);
							
						}
					}
				}
			}
		}catch(EASBizException bize){
			throw new BOSException(bize);
		}
		return immuneList;
	}

	/**
	 * ��� �ƶ����������  �����Ҫ����������Ϣ
	 * 
	 */
	@Override
	protected List _getModelRecentImmunePlans(Context ctx,
			CCPigBreedModelInfo modelInfo, 
			Date bizDate, 
			int batchDays) throws BOSException {
		
		// Ŀ������
//		int aimDays = batchDays + recentDays;
		
		// ���
		List<ImmunePlanDetailInfo> immuneList = new ArrayList<ImmunePlanDetailInfo>();
		try{
			if(modelInfo != null && batchDays > 0){
	//			CCPigBreedModelEntryCollection modelEntrys = modelInfo.getEntrys();
				
				CCPigBreedModelImmuneEntryCollection immuneEntry = modelInfo.getImmuneEntrys();
				if(immuneEntry != null && immuneEntry.size() > 0){
					for(int i = 0; i < immuneEntry.size(); i++){
						// ���߹淶��ϸ
						CCPigBreedModelImmuneEntryInfo entryInfo = immuneEntry.get(i);
						int beginDays = entryInfo.getBeginDays();
						int endDays = entryInfo.getEndDays();
						// ��ǰ��������
//						int aheadDays = entryInfo.getWarnAheadDays();
						// Ԥ����ǰ����
						int warnBeforeDays = entryInfo.getWarnAheadDays();
						// Ŀ������
						int aimDays = batchDays + warnBeforeDays;
						
						if(aimDays >= beginDays && aimDays <= endDays && batchDays < beginDays){
							ImmunePlanDetailInfo detailInfo = new ImmunePlanDetailInfo();
							MaterialInfo materialInfo = new MaterialInfo();
							materialInfo = MaterialFactory.getLocalInstance(ctx).getMaterialInfo(new ObjectUuidPK(entryInfo.getImmuneMaterial().getId()));
							MeasureUnitInfo unitInfo = new MeasureUnitInfo();
							unitInfo = MeasureUnitFactory.getLocalInstance(ctx).getMeasureUnitInfo(new ObjectUuidPK(materialInfo.getBaseUnit().getId()));
							
							// ����
	//						materialInfo.setId(BOSUuid.read(materialID));
	//						materialInfo.setNumber(materialNumber);
	//						materialInfo.setName(materialName);
							// ������λ
	//						unitInfo.setId(BOSUuid.read(unitID));
	//						unitInfo.setNumber(unitNumber);
	//						unitInfo.setName(unitName);
							// ������ϸ��Ϣ
							detailInfo.setActiveDate(null);
							detailInfo.setDisableDate(null);
							
							// ��������ڼ�
							Calendar cal = Calendar.getInstance();
							cal.setTime(bizDate);
							// ��������
							cal.add(Calendar.DATE, -batchDays);
							cal.add(Calendar.DATE, beginDays);
							Date immuneBeginDate = cal.getTime();
							// ���߽�������
							cal.add(Calendar.DATE, endDays-beginDays);
							Date immuneEndDate = cal.getTime();
							
							detailInfo.setSourceEntryID(entryInfo.getId().toString());
							detailInfo.setSourceType(immuneSourceType.BatchImmune);
							detailInfo.setImmuneBeginDate(immuneBeginDate);
							detailInfo.setImmuneEndDate(immuneEndDate);
							detailInfo.setImmuneMaterial(materialInfo);
							detailInfo.setImmuneMode(entryInfo.getImmuneMode());
							detailInfo.setPigFarmType(PigFarmType.CommPig);
							detailInfo.setQtyPer(entryInfo.getQtyPer());
							detailInfo.setUnit(unitInfo);
							
							immuneList.add(detailInfo);
							
						}
					}
				}
			}
		}catch(EASBizException bize){
			throw new BOSException(bize);
		}
		return immuneList;
	}
    
    
}