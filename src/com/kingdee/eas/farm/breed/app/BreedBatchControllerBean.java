package com.kingdee.eas.farm.breed.app;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.farm.breed.BreedBatchCollection;
import com.kingdee.eas.farm.breed.BreedBatchEntryCollection;
import com.kingdee.eas.farm.breed.BreedBatchEntryInfo;
import com.kingdee.eas.farm.breed.BreedBatchFactory;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.farm.breed.BreedFacadeFactory;
import com.kingdee.eas.farm.breed.HenhouseType;
import com.kingdee.eas.farm.breed.business.CCBreedPlanEntryFactory;
import com.kingdee.eas.farm.breed.business.CCBreedPlanEntryInfo;
import com.kingdee.eas.farm.breed.business.CCBreedPlanFactory;
import com.kingdee.eas.farm.breed.business.CCBreedPlanInfo;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.DateCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BreedBatchControllerBean extends AbstractBreedBatchControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.app.BreedBatchControllerBean");

    
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
    	BreedBatchInfo billInfo = (BreedBatchInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) || BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) )){
    		billInfo.setBaseStatus( BillBaseStatusEnum.TEMPORARILYSAVED);
    		// У�� �ɱ������Ƿ��Ѿ��������������ã�����Ѿ������������� �ύ
    		String costObjectID = (billInfo.getCostObject()==null?"":billInfo.getCostObject().getId().toString());
			String fid = (billInfo.getId()==null?"":billInfo.getId().toString());
			checkBatchCostObject(ctx,costObjectID,fid);
			
			// У����ֳ�ƻ��Ƿ�������������
			String breedPlanID = (billInfo.getBreedPlan()==null?"":billInfo.getBreedPlan().getId().toString());
			checkBatchPlanUsedStatus(ctx,breedPlanID,fid);
			// �˶����μƻ��Ƿ�ѡ��
			if(StringUtils.isNotBlank(breedPlanID)){
				checkBatchPlanMatchState(ctx,billInfo,breedPlanID);
			}
    		return super._save(ctx, model);
    	}else{
//    		throw new FarmException("ֻ�ܱ��������򱣴�״̬�ĵ���");
    		throw  new EASBizException(new NumericExceptionSubItem("001","ֻ�ܱ��������򱣴�״̬�ĵ���"));
    	}
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		BreedBatchInfo billInfo = (BreedBatchInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()))){
    		billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);
    		// У�� �ɱ������Ƿ��Ѿ��������������ã�����Ѿ������������� �ύ
    		String costObjectID = (billInfo.getCostObject()==null?"":billInfo.getCostObject().getId().toString());
			String fid = (billInfo.getId()==null?"":billInfo.getId().toString());
			checkBatchCostObject(ctx,costObjectID,fid);
			// У����ֳ�ƻ��Ƿ�������������
			String breedPlanID = (billInfo.getBreedPlan()==null?"":billInfo.getBreedPlan().getId().toString());
			checkBatchPlanUsedStatus(ctx,breedPlanID,fid);
			// �˶����μƻ��Ƿ�ѡ��
			if(StringUtils.isNotBlank(breedPlanID)){
				checkBatchPlanMatchState(ctx,billInfo,breedPlanID);
			}
    		return super._submit(ctx, model);
    	}else{
//    		throw new FarmException("ֻ�ܱ��������򱣴�״̬�ĵ���");
    		throw  new EASBizException(new NumericExceptionSubItem("001","ֻ�ܱ��������򱣴�״̬�ĵ���"));
    	}
	}
	/**
	 * У�� ��ֳ�ƻ��Ƿ������������ã�����Ѿ��������� ����
	 * @param ctx
	 * @param costObjectID
	 * @param batchID
	 * @throws EASBizException 
	 * @throws BOSException 
	 */
	private void checkBatchPlanUsedStatus(Context ctx, String planID, String batchID) throws EASBizException, BOSException{
		StringBuilder sb  = new StringBuilder("");
		sb.append("select fid from ct_fm_breedbatch where cfbreedplanid='");
		sb.append(planID);
		sb.append("' ");
		if(StringUtils.isNotBlank(batchID)){
			sb.append(" and fid <> '");
			sb.append(batchID);
			sb.append("' ");
		}
		
		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		try{
			if(rs.next()){
				throw new EASBizException(new NumericExceptionSubItem("001","��ֳ�ƻ��Ѿ��������������ã������ظ�����"));
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
	}

	/**
	 * У�� ��ֳ���κ� ��ֳ�ƻ��Ƿ�ƥ��
	 * Ŀǰ��ʱ����Ϊ  ���� ���� �������ƫ��ܳ���20��
	 * @param billInfo
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public void checkBatchPlanMatchState(Context ctx, BreedBatchInfo billInfo,String breedPlanID) throws EASBizException, BOSException{
		int maxDiffDays = 0;
		// �Ƚ����μ���id�� ���������ݴ�map
		Map<String,Date> batchInDate = new HashMap<String, Date>();
		BreedBatchEntryCollection entryColl = billInfo.getEntrys();
		if(entryColl != null && entryColl.size() > 0){
			for(int i = 0; i < entryColl.size(); i++){
				BreedBatchEntryInfo entryInfo = entryColl.get(i);
				if(entryInfo.getHenHouse() != null && entryInfo.getIncoopDate() != null){
					batchInDate.put(entryInfo.getHenHouse().getId().toString(), entryInfo.getIncoopDate());
				}
			}
		}
		
		CCBreedPlanInfo planInfo = CCBreedPlanFactory.getLocalInstance(ctx).getCCBreedPlanInfo(new ObjectUuidPK(breedPlanID));
		if(planInfo != null && planInfo.getEntrys() != null && planInfo.getEntrys().size() > 0){
			for(int i = 0; i < planInfo.getEntrys().size(); i++){
				CCBreedPlanEntryInfo planEntryInfo = planInfo.getEntrys().get(i);
				if(planEntryInfo.getHenHouse() == null){
					planEntryInfo = CCBreedPlanEntryFactory.getLocalInstance(ctx).getCCBreedPlanEntryInfo(new ObjectUuidPK(planEntryInfo.getId()));
					
				}
				// ��ȡmap���ݴ�� �������� �������� ��������������
				Date planDate = planEntryInfo.getIncoopDate();
				if(planEntryInfo.getHenHouse() != null && planDate != null){
					Date batchDate = batchInDate.get(planEntryInfo.getHenHouse().getId().toString());
					int  diffDays = DateCommon.dateDiff(batchDate, planDate);
					
					if(diffDays > 20){
						throw  new EASBizException(new NumericExceptionSubItem("001","��ֳ�������Ӧ��ֳ�ƻ�������ϸ������ڹ�������ϸ�˶��Ƿ�ѡ����ֳ�ƻ���"));
						
					}
//					if(diffDays > maxDiffDays ){
//						maxDiffDays = diffDays;
//						
//						
//					}
				}
				
			}
		}
	}
	/**
	 * У�� �ɱ������Ƿ������������ã�����Ѿ��������� ����
	 * @param ctx
	 * @param costObjectID
	 * @param batchID
	 * @throws EASBizException 
	 * @throws BOSException 
	 */
	private void checkBatchCostObject(Context ctx, String costObjectID, String batchID) throws EASBizException, BOSException{
		StringBuilder sb  = new StringBuilder("");
		sb.append("select fid from ct_fm_breedbatch where cfcostobjectid='");
		sb.append(costObjectID);
		sb.append("' ");
		if(StringUtils.isNotBlank(batchID)){
			sb.append(" and fid <> '");
			sb.append(batchID);
			sb.append("' ");
		}
		
		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		try{
			if(rs.next()){
				throw new EASBizException(new NumericExceptionSubItem("001","�ɱ������Ѿ��������������ã������ظ�����"));
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
			throw new BOSException(sqle);
		}
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		BreedBatchInfo billInfo = BreedBatchFactory.getLocalInstance(ctx).getBreedBatchInfo(pk);
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()))){
    		// У�鵱ǰ�����Ƿ��Ѿ������� �ձ� 
    		boolean isused = BreedFacadeFactory.getLocalInstance(ctx).isBatchGeneratedDailyInfos(billInfo.getId().toString(), billInfo.getHouseType().getValue());
    		if(isused){
//    			throw new FarmException("��ǰ��ֳ�����Ѿ�����ձ���Ϣ������ɾ��");
    			throw  new EASBizException(new NumericExceptionSubItem("001","��ǰ��ֳ�����Ѿ�����ձ���Ϣ������ɾ��"));
    		}
    		super._delete(ctx, pk);
    		
    	}else{
//    		throw new FarmException("ֻ��ɾ�������򱣴�״̬�ĵ���");
    		throw  new EASBizException(new NumericExceptionSubItem("001","ֻ��ɾ�������򱣴�״̬�ĵ���"));
    	}
		
	}
	/**
     * ���
     */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		BreedBatchInfo billInfo = (BreedBatchInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("�Ѿ��������ε��ݣ��������");
			}
			String costObjectID = billInfo.getCostObject().getId().toString();
			String fid = billInfo.getId().toString();
			try {
				checkBatchCostObject(ctx,costObjectID,fid);
			} catch (EASBizException e) {
				e.printStackTrace();
				throw new FarmException(e.getMessage());
			}
			// ���µ���״̬
			AppCommon.updateModelStatus(ctx, "CT_FM_BreedBatch", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
			
		}else{
			throw new FarmException("ֻ������ύ״̬�ĵ���");
		}
		
	}


	/**
	 * �����
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException {
		
		BreedBatchInfo billInfo = (BreedBatchInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("�Ѿ��������ε��ݣ����ܷ����");
			}else{
				// У�鵱ǰ�����Ƿ��Ѿ������� �ձ�  
				// 20151221 ����У���Ƿ�������ε��ݣ����Ǹ�Ϊͨ��Ȩ�޿���
//				boolean isused = BreedFacadeFactory.getLocalInstance(ctx).isBatchGeneratedDailyInfos(billInfo.getId().toString(), billInfo.getHouseType().getValue());
//				if(isused){
//					throw new FarmException("��ǰ��ֳ�����Ѿ�����ձ���Ϣ�����ܷ����");
//				}
			}
			
			
			// ���µ���״̬
			AppCommon.updateModelStatus(ctx, "CT_FM_BreedBatch", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);
			
		}else{
			throw new FarmException("ֻ�ܷ�������״̬�ĵ���");
		}
	}

	/**
	 * ���� ��ֳ���η�¼��  �Ƿ���ȫ����״̬ ������
	 */
	@Override
	protected void _updateBatchMarket(Context ctx, IObjectValue model)
			throws BOSException {
		BreedBatchInfo billInfo = (BreedBatchInfo)model;
		if(billInfo != null){
			BreedFacadeFactory.getLocalInstance(ctx).updateBatchOutState(billInfo.getId().toString());
		}
	}
	
	
	
	
	
	
}