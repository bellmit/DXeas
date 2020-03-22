package com.kingdee.eas.custom.szcount.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

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

import com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillFactory;
import com.kingdee.eas.farm.stocking.basebizbill.FarmerApplyBillInfo;
import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.custom.szcount.SzSemiProductFactory;
import com.kingdee.eas.custom.szcount.SzSemiProductInfo;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.custom.szcount.SzSemiProductCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SzSemiProductControllerBean extends AbstractSzSemiProductControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.szcount.app.SzSemiProductControllerBean");
    @Override
    protected void _unaudit(Context ctx, IObjectValue model)throws BOSException
    {
    	SzSemiProductInfo info = (SzSemiProductInfo) model;
    	try {
    		
			info.setStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			info.setAuditTime(null);
			info.setAuditor(null);
			StringBuffer sb = new StringBuffer();
			String sp = "\n";
			sb.append("").append(sp);
			sb.append("select t3.* from ").append(sp);
			sb.append("CT_SZC_SzSemiProduct 		t1").append(sp);
			sb.append("inner join T_BOT_Relation		t2	on t2.FSrcObjectID = t1.FID").append(sp);
			sb.append("inner join T_IM_ManufactureRecBill	t3	on t3.FID = t2.FDestObjectID").append(sp);
			sb.append("where t1.fid ='").append(info.getId()).append("'").append(sp);
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
			if(rs.next()){
				throw new EASBizException(new NumericExceptionSubItem("001","单据已生成下游单据，禁止反审核！"));
			}else{
				super._update(ctx, new ObjectUuidPK(info.getId()), info);
			}
			
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
    }
    @Override
    protected void _audit(Context ctx, IObjectValue model)throws BOSException
    {
    	SzSemiProductInfo info = (SzSemiProductInfo) model;
    	if(!info.getStatus().equals(BillBaseStatusEnum.SUBMITED)) {
    		return;
    	}
    	try {
    	info.setStatus(BillBaseStatusEnum.AUDITED);
		info.setAuditTime(new java.util.Date());
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SzSemiProductInfo info = (SzSemiProductInfo) model;
		if(info.getStatus()==null||info.getStatus().getValue()==-1||info.getStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		SzSemiProductInfo info = (SzSemiProductInfo) model;
		if(info.getStatus()==null||info.getStatus().getValue()==-1||info.getStatus().equals(BillBaseStatusEnum.ADD)||info.getStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setStatus(BillBaseStatusEnum.SUBMITED);
		}
		return super._submit(ctx, info);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		/*String rssql = "select FID from CT_SZC_SzSemiProductEntry";
		IRowSet rsrs = SQLExecutorFactory.getLocalInstance(ctx, rssql).executeSQL();
		try {
			while(rsrs.next()){
				StringBuffer zanyong = new StringBuffer();
				String sp = "\n";
				zanyong.append("/*dialect").append(sp);
				zanyong.append("update CT_SZC_SzSemiProductEntry a ").append(sp);
				zanyong.append("set  a.CFCostObjectID = (").append(sp);
				zanyong.append("select t3.FID FID from ").append(sp);
				zanyong.append("CT_SZC_SzSemiProduct t1").append(sp);
				zanyong.append("inner join CT_SZC_SzSemiProductEntry 	t2	on t2.FParentID = t1.FID ").append(sp);
				zanyong.append("inner join T_BD_CostObject			t3	on t3.FControlUnitID = t1.FControlUnitID ").append(sp);
				zanyong.append("and t3.Fnumber = t2.CFmaterialNumber").append(sp);
				zanyong.append("where t2.fid ='").append(rsrs.getString("FID")).append("')").append(sp);
				zanyong.append("where a.fid in (").append(sp);
				zanyong.append("select t2.FID qwqwqw from ").append(sp);
				zanyong.append("CT_SZC_SzSemiProduct t1").append(sp);
				zanyong.append("inner join CT_SZC_SzSemiProductEntry 	t2	on t2.FParentID = t1.FID ").append(sp);
				zanyong.append("inner join T_BD_CostObject			t3	on t3.FControlUnitID = t1.FControlUnitID ").append(sp);
				zanyong.append("and t3.Fnumber = t2.CFmaterialNumber").append(sp);
				zanyong.append("where t2.fid ='").append(rsrs.getString("FID")).append("')").append(sp);
				//SQLExecutorFactory.getLocalInstance(ctx, zanyong.toString());
				DbUtil.execute(ctx, zanyong.toString());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		SzSemiProductInfo info = SzSemiProductFactory.getLocalInstance(ctx).getSzSemiProductInfo(pk);
		if (info.getStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		
		super._delete(ctx, pk);
	}
	
	
	
}