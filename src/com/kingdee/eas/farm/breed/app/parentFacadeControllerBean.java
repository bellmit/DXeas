package com.kingdee.eas.farm.breed.app;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.BreedBatchFactory;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.farm.breed.BreedModelFactory;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import com.kingdee.eas.farm.breed.BreedStoorgSetFactory;
import com.kingdee.eas.farm.breed.BreedStoorgSetInfo;
import com.kingdee.eas.farm.breed.ParentBreedBatchFactory;
import com.kingdee.eas.farm.breed.ParentBreedBatchInfo;
import com.kingdee.eas.farm.breed.comm.BreedBatchDetailInfo;
import com.kingdee.eas.farm.breed.comm.ParentBreedBatchDetailInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.jdbc.rowset.IRowSet;

public class parentFacadeControllerBean extends AbstractparentFacadeControllerBean
{
 
	private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.app.parentFacadeControllerBean");
	
	/**
	 * ���ݿ����֯ID��ö�Ӧ�� ��ֳ������ 
	 * 
	 */
    @Override
	protected BreedStoorgSetInfo _getFarmByStoOrgID(Context ctx, String stoOrgID)
			throws BOSException {
		String sql = "select fid from CT_FM_BreedStoorgSet where CFStoOrgID=?";
		Object[] args = {stoOrgID};
		IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
		if(rs.size() == 0){
			throw new BOSException("�����֯�����ڶ�Ӧ����ֳ������");
		}
		if(rs.size() > 1){
			throw new BOSException("�����֯���ڶ�����ֳ�����ã�����ϵ����Ա�˶�");
		}
		try{
			if(rs.next()){
				String fid = rs.getString("fid");
				return BreedStoorgSetFactory.getLocalInstance(ctx).getBreedStoorgSetInfo(new ObjectUuidPK(fid));
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		} catch (EASBizException e) {
			e.printStackTrace();
			throw new BOSException(e);
			
		}
		return super._getFarmByStoOrgID(ctx, stoOrgID);
	}

    
    /**
	 * ����������Ϣ��ö�Ӧ�� ���ε�ǰ����
	 */
	@Override
	protected ParentBreedBatchDetailInfo _getBreedBatchDetailInfos(Context ctx,
			String batchID, Date bizDate) throws BOSException {
		ParentBreedBatchInfo batchInfo = null;
		 
		ParentBreedBatchDetailInfo result = null;
		
		try {
			batchInfo = ParentBreedBatchFactory.getLocalInstance(ctx).getParentBreedBatchInfo(new ObjectUuidPK(batchID));
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new FarmException(e);
		}
		
		// �������λ�ö�Ӧ��������
		if(batchInfo != null){
			result =  new ParentBreedBatchDetailInfo(ctx,batchInfo,bizDate);
			// TODO
			return result;
		}else{
			return null;
		}
		
	}

	/**
	 * �������������Ϣ
	 */
	@Override
	protected HashMap _getBatchWeekages(Context ctx, String parentBatchID,
			Date bizDate) throws BOSException {

		HashMap<String, Integer>  ageInfos = new HashMap<String, Integer>();
		if(StringUtils.isNotBlank(parentBatchID)){
			try{
				
				ParentBreedBatchInfo batchInfo = ParentBreedBatchFactory.getLocalInstance(ctx).getParentBreedBatchInfo(new ObjectUuidPK(parentBatchID));
				if(batchInfo != null){
					int initWeek = batchInfo.getWeek();
					int initDay = batchInfo.getWeekDay();
					Date initDate = batchInfo.getBizDate();
					if(initDate == null){
						throw new BOSException("��ֳ���ε�ҵ������Ϊ�գ��޷�����");
					}
					Date nowDate = bizDate;
					if(nowDate == null) nowDate = new Date();
					
					long diff = nowDate.getTime() - initDate.getTime();
				    long days = diff / (1000 * 60 * 60 * 24);
				    // �������ڵ���ǰ�����ڲ�������ζ���ʱ�� ���� �����ǰ������
				    int daysInt = (int) days;
				    
				    daysInt = daysInt + (initWeek-1) * 7 + initDay;
				    // TODO ����֤׼ȷ��
				    int currDay = daysInt%7;
				    int currWeek = daysInt/7 +1;
				    if(daysInt != 0 && currDay == 0) {
				    	currDay = 7;
				    	currWeek = currWeek -1;
				    }
				   
				    
				    
				    ageInfos.put("currWeek", Integer.valueOf(currWeek));
				    ageInfos.put("currDay", Integer.valueOf(currDay));
				}
			}catch(EASBizException e){
				e.printStackTrace();
				throw new BOSException(e);
			}
		}else{
			
		}
		return ageInfos;
	
	}

	/**
	 * �����ֳ�淶
	 */
	@Override
	protected BreedModelInfo _getBreedModel(Context ctx, String henhouseType,
			String companyID, boolean isMoulting) throws BOSException {

		String sql = "select fid from CT_FM_BreedModel where CFHouseType = ? and cfcompanyid=? and CFIsMoulting=? and CFDeletedStatus=1 ";//CFDisableState=1
		Object[] args = {henhouseType,companyID,isMoulting};
		IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
		
		if(rs.size() > 1){
			throw new FarmException("ָ���������ڲ�ֹһ�����õ� �����淶������ϵ����Ա����");
		}else{
			try{
				if(rs.next()){
					String fid = rs.getString("fid");
					return BreedModelFactory.getLocalInstance(ctx).getBreedModelInfo(new ObjectUuidPK(fid));
				}else{
					sql = "select fid from CT_FM_BreedModel where CFHouseType = ?  and CFIsMoulting=? and CFDeletedStatus=1 ";//CFDisableState=1
					Object[] args1 = {henhouseType,isMoulting};
					IRowSet rs1 = DbUtil.executeQuery(ctx, sql, args1);
					
					if(rs1.size() > 1){
						throw new FarmException("���Ŵ��ڲ�ֹһ����˾Ϊ�������õ� �����淶������ϵ����Ա����");
					}else{
						if(rs1.next()){
							String fid = rs1.getString("fid");
							return BreedModelFactory.getLocalInstance(ctx).getBreedModelInfo(new ObjectUuidPK(fid));
						}else{
							throw new FarmException("��ǰ��˾�ͼ��ž������ڶ�Ӧ �����淶������ϵ����Ա����");
						}
					}
				}
			}catch(SQLException sqle){
				sqle.printStackTrace();
				throw new BOSException(sqle);
			} catch (EASBizException e) {
				e.printStackTrace();
				throw new BOSException(e);
			}
		}
		
	
	}

	/**
	 * �ж������Ƿ���ת����
	 */
	@Override
	protected boolean _isBatchBroodFixed(Context ctx, String batchID,
			Date bizDate) throws BOSException {
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sb.append("select max(CFIsTransBrood) isFixed from CT_FM_LayEggDaily where CFParentBatchID ='");
		sb.append(batchID);
		sb.append("' and FBizDate <{ ts '");
		sb.append(sdf.format(bizDate));
		sb.append("'}");
		
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			if(rs.next()){
				Boolean isfixed = rs.getBoolean("isFixed");
				return isfixed;
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
		return false;
	}


	/**
	 * �ж������Ƿ���ת����
	 */
	@Override
	protected boolean _isBatchFixed(Context ctx, String batchID, Date bizDate)
			throws BOSException {
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sb.append("select max(CFIsFixed) isFixed from CT_FM_LayEggDaily where CFParentBatchID ='");
		sb.append(batchID);
		sb.append("' and FBizDate <{ ts '");
		sb.append(sdf.format(bizDate));
		sb.append("'}");
		
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
			if(rs.next()){
				Boolean isfixed = rs.getBoolean("isFixed");
				return isfixed;
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
		return false;
	}
	
	
	
	
}