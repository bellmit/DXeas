package com.kingdee.eas.farm.breed.business.app;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.business.CCBreedPlanEntryCollection;
import com.kingdee.eas.farm.breed.business.CCBreedPlanEntryInfo;
import com.kingdee.eas.farm.breed.business.CCBreedPlanFactory;
import com.kingdee.eas.farm.breed.business.CCBreedPlanInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class CCBreedPlanControllerBean extends AbstractCCBreedPlanControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.business.app.CCBreedPlanControllerBean");
    
    
    
    

    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
    	CCBreedPlanInfo billInfo = (CCBreedPlanInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) || BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) )){
    		billInfo.setBaseStatus( BillBaseStatusEnum.TEMPORARILYSAVED);
    		
    		
    		
    		
    		// У��ƻ��ظ�����
    		checkIsExist(ctx,billInfo);
    		// У��ƻ��Ƿ��Ѿ������ã������ú����޸�
    		if(billInfo.getId() != null){
    			checkPlanRelated(ctx,billInfo.getId().toString());
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
		CCBreedPlanInfo billInfo = (CCBreedPlanInfo)model;
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()))){
    		
    		// У��ƻ��ظ�����
    		checkIsExist(ctx,billInfo);
    		// У��ƻ��Ƿ��Ѿ������ã������ú����޸�
    		if(billInfo.getId() != null){
    			checkPlanRelated(ctx,billInfo.getId().toString());
    		}
    		
    		billInfo.setBaseStatus( BillBaseStatusEnum.SUBMITED);
    		return super._submit(ctx, model);
    	}else{
//    		throw new FarmException("ֻ�ܱ��������򱣴�״̬�ĵ���");
    		throw  new EASBizException(new NumericExceptionSubItem("001","ֻ���ύ�����򱣴�״̬�ĵ���"));
    	}
	}

	/**
	 * У��ָ��������10�����Ƿ�����ֳ�ƻ� TODO ....
	 * @param ctx
	 * @param planID
	 * @param inhouseDate
	 * @throws EASBizException 
	 * @throws BOSException 
	 */
	private void checkIsExist(Context ctx, CCBreedPlanInfo billInfo) throws EASBizException, BOSException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		
		
		CCBreedPlanEntryCollection entryCol = billInfo.getEntrys();
		if(entryCol != null && entryCol.size() > 0){
			for(int i = 0; i < entryCol.size(); i++){
			CCBreedPlanEntryInfo entryInfo = entryCol.get(i);
			
			Date inhouseDate = entryInfo.getIncoopDate();
			if(inhouseDate == null){
				throw new EASBizException(new NumericExceptionSubItem("001","��¼�������ڲ���Ϊ��"));
			}
			
				cal.setTime(inhouseDate);
				cal.add(Calendar.DATE, -30);
				Date beginDate = cal.getTime();
				String beginDateStr = sdf.format(beginDate);
				cal.add(Calendar.DATE, 60);
				Date endDate = cal.getTime();
				
				
				String endDateStr = sdf.format(endDate);
				StringBuilder sb = new StringBuilder("select t.fid from CT_FM_CCBreedPlan t inner join CT_FM_CCBreedPlanentry te on t.fid = te.fparentid where ");
				sb.append(" te.CFINCOOPDATE >= {d '");
				sb.append(beginDateStr);
				sb.append("'} and te.CFINCOOPDATE <={d '");
				sb.append(endDateStr);
				sb.append("'} ");
				sb.append(" and t.CFStoOrgID='").append(billInfo.getStoOrg().getString("id")).append("'");//add by dai 20150824
				if(billInfo != null && billInfo.getId() != null ){
					sb.append(" and t.fid != '");
					sb.append(billInfo.getId().toString());
					sb.append("'");
				}
				
				IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
				try{
					if(rs.next()){
						throw new EASBizException(new NumericExceptionSubItem("001","��¼�����������ʱ�����Ѿ����������ƻ���ʱ��������"));
					}
				}catch(SQLException sqle){
					throw new BOSException(sqle);
				}
			}
		}else{
			throw new EASBizException(new NumericExceptionSubItem("001","�밴�ռƻ�������д��¼����������������ƻ�"));
		}
	}
	
	/**
	 * 
	 * @param ctx
	 * @param planID
	 * @throws EASBizException 
	 * @throws BOSException 
	 */
	public void checkPlanRelated(Context ctx,String planID) throws EASBizException, BOSException{
		// У��ƻ��Ƿ��Ѿ������ã������ú���ɾ��
		String sql = "select 1 from ct_fm_breedbatch where CFBREEDPLANID = ?";
		Object[] args = {planID};
		IRowSet rs = DbUtil.executeQuery(ctx, sql, args);
		try {
			if(rs.next()){
				throw  new EASBizException(new NumericExceptionSubItem("001","�Ѿ�����ֳ�������ã����ܲ���"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BOSException(e);
		}
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		CCBreedPlanInfo billInfo = CCBreedPlanFactory.getLocalInstance(ctx).getCCBreedPlanInfo(pk);
    	if(billInfo != null  && 
    			(BillBaseStatusEnum.ADD.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(billInfo.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus()))){
    		boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
    			throw  new EASBizException(new NumericExceptionSubItem("001","�Ѿ��������ε��ݣ�����ɾ��"));
    		}
			// У��ƻ��Ƿ��Ѿ������ã������ú���ɾ��
			checkPlanRelated(ctx,pk.toString());
		
			
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
		CCBreedPlanInfo billInfo = (CCBreedPlanInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("�Ѿ��������ε��ݣ��������");
			}
			// ���µ���״̬
			AppCommon.updateModelStatus(ctx, "CT_FM_CCBreedPlan", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
			
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
		
		CCBreedPlanInfo billInfo = (CCBreedPlanInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new FarmException("�Ѿ��������ε��ݣ����ܷ����");
			}
			
			
			// ���µ���״̬
			AppCommon.updateModelStatus(ctx, "CT_FM_CCBreedPlan", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);
			
		}else{
			throw new FarmException("ֻ�ܷ�������״̬�ĵ���");
		}
	}

	@Override
	protected void _getCCBreedPlan(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}
	
}