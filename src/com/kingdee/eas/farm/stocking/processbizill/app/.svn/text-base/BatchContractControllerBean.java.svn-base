package com.kingdee.eas.farm.stocking.processbizill.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.PersonFarmerRelationEntryInfo;
import com.kingdee.eas.farm.stocking.basedata.PersonFarmerRelationFactory;
import com.kingdee.eas.farm.stocking.basedata.PersonFarmerRelationInfo;
import com.kingdee.eas.farm.stocking.processbizill.BatchContractFactory;
import com.kingdee.eas.farm.stocking.processbizill.BatchContractInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class BatchContractControllerBean extends AbstractBatchContractControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.stocking.processbizill.app.BatchContractControllerBean");
    protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
    {
    	try {
    		BatchContractInfo info = (BatchContractInfo) model;
    		
    		if(info.getPerson()!=null) {
    			//删除过去的记录
    			StringBuffer sql=new StringBuffer();
    			sql.append(" delete from T_FM_PersonFarmerRelationEntry ")
    			.append(" where ffarmerid='").append(info.getFarmer().getId()).append("'")
    			.append(" and fparentid in (")
    			.append(" select fid from T_FM_PersonFarmerRelation ")
	    		.append(" where FCompanyID='").append(info.getCompany().getString("id")).append("'")
    			.append(" )")
    			;
    			DbUtil.execute(ctx, sql.toString());
    			
    			//新增记录
	    		sql.setLength(0);
	    		sql.append(" select fid from T_FM_PersonFarmerRelation ")
	    		.append(" where FCompanyID='").append(info.getCompany().getString("id")).append("'")
	    		.append(" and fpersonid='").append(info.getPerson().getString("id")).append("'");
	    		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
	    		PersonFarmerRelationInfo frInfo;
	    		if(rs.next()) {
	    			frInfo=PersonFarmerRelationFactory.getLocalInstance(ctx).getPersonFarmerRelationInfo(new ObjectUuidPK(rs.getString("fid")));
	    		}else{
	    			frInfo=new PersonFarmerRelationInfo();
	    			frInfo.setCompany(info.getCompany());
	    			frInfo.setPerson(info.getPerson());
	    			frInfo.setBaseStatus(FarmBaseStatusEnum.enable);
	    		}
	    		PersonFarmerRelationEntryInfo frEntryInfo=new PersonFarmerRelationEntryInfo();
	    		frEntryInfo.setFarmer(info.getFarmer());
	    		frEntryInfo.setFarmerName(info.getFarmer().getName());
	    		frInfo.getEntry().add(frEntryInfo);
	    		PersonFarmerRelationFactory.getLocalInstance(ctx).save(frInfo);
	    		
    		}
    		
			info.setBillStatus(BillBaseStatusEnum.AUDITED);
			info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
    }
    
    protected void _unAudit(Context ctx, IObjectValue model)throws BOSException,EASBizException
    {
    	try {
    		BatchContractInfo info = (BatchContractInfo) model;
    		
    		StringBuffer sql=new StringBuffer();
    		sql.append(" select '批次'||':'||fnumber fname from t_fm_stockingBatch where FBatchContractID='").append(info.getString("id")).append("'")
    		.append(" union all")
    		.append(" select '种苗领用'||':'||fnumber fname from T_FM_BreedSeedBill where CFBatchContractID='").append(info.getString("id")).append("'");
    		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
    		if(rs.next()) {
    			throw new Exception("合同已经被\""+rs.getString("fname")+"\"引用，禁止反审核！");
    		}
    		
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			info.setAuditTime(null);
			info.setAuditor(null);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new EASBizException(new NumericExceptionSubItem("001",ex.getMessage()));
		}
    }
    
    
    
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
    	BatchContractInfo info = (BatchContractInfo) model;
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
    		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
    	}
		return super._save(ctx, info);
	}
    
    @Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
    	BatchContractInfo info = (BatchContractInfo) model;
    	if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
    		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
    	}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BatchContractInfo info = BatchContractFactory.getLocalInstance(ctx).getBatchContractInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		super._delete(ctx, pk);
	}
    protected void _isTemplate(Context ctx, IObjectValue model)throws BOSException
    {
    }

	@Override
	protected void _isInit(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
		
	}
}