package com.kingdee.eas.farm.carnivorous.basebiz.app;

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

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.carnivorous.basebiz.MarginInitBillCollection;
import com.kingdee.eas.farm.carnivorous.basebiz.MarginInitBillEntryCollection;
import com.kingdee.eas.farm.carnivorous.basebiz.MarginInitBillEntryInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.farm.carnivorous.basebiz.MarginInitBillInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.ServerUtils;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MarginInitBillControllerBean extends AbstractMarginInitBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.basebiz.app.MarginInitBillControllerBean");

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		model = ServerUtils.audit(ctx, model, null);
		MarginInitBillInfo info=(MarginInitBillInfo) model;
		checkISOnlyOne(ctx, info);
		updateFarmerMarginForAudit(ctx, info);

		super._save(ctx, model);
	}


	private void updateFarmerMarginForAudit(Context ctx, MarginInitBillInfo info) {
		// TODO Auto-generated method stub
		try {
			for(int i=0;i<info.getEntrys().size();i++){
				MarginInitBillEntryInfo entry = info.getEntrys().get(i);
				BigDecimal totalMargin = entry.getTotalMargin()==null?BigDecimal.ZERO:entry.getTotalMargin();
				BigDecimal occupyMargin = entry.getOccupyMargin()==null?BigDecimal.ZERO:entry.getOccupyMargin();
				BigDecimal enableMargin = entry.getEnableMargin()==null?BigDecimal.ZERO:entry.getEnableMargin();
				
				String sql="update CT_FM_Farmer set cftotalMargin=isnull(cftotalMargin,0)+("+totalMargin+"),cfoccupyMargin=isnull(cfoccupyMargin,0)+("+occupyMargin+"),cfenableMargin=isnull(cfenableMargin,0)+("+enableMargin+") where fid='"+entry.getFarmer().getId().toString()+"'";
				DbUtil.execute(ctx, sql);	
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		model = ServerUtils.unAudit(ctx, model, null);
		MarginInitBillInfo info=(MarginInitBillInfo) model;
		updateFarmerMarginForUnAudit(ctx, info);
		super._save(ctx, model);
	}


	private void updateFarmerMarginForUnAudit(Context ctx, MarginInitBillInfo info) {
		try {
			for(int i=0;i<info.getEntrys().size();i++){
				MarginInitBillEntryInfo entry = info.getEntrys().get(i);
				BigDecimal totalMargin = entry.getTotalMargin()==null?BigDecimal.ZERO:entry.getTotalMargin();
				BigDecimal occupyMargin = entry.getOccupyMargin()==null?BigDecimal.ZERO:entry.getOccupyMargin();
				BigDecimal enableMargin = entry.getEnableMargin()==null?BigDecimal.ZERO:entry.getEnableMargin();
				String sql="update CT_FM_Farmer set cftotalMargin=isnull(cftotalMargin,0)-("+totalMargin+"),cfoccupyMargin=isnull(cfoccupyMargin,0)-("+occupyMargin+"),cfenableMargin=isnull(cfenableMargin,0)-("+enableMargin+") where fid='"+entry.getFarmer().getId().toString()+"'";
				
				DbUtil.execute(ctx, sql);	
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
	EASBizException {
		// TODO Auto-generated method stub
		ServerUtils.delete(ctx, pk, null);
		MarginInitBillInfo info=getMarginInitBillInfo(ctx, pk);
		MarginInitBillEntryCollection entrys=info.getEntrys();
		for(int i=0;i<entrys.size();i++){
			if(entrys.get(i).getUnLockedOpMargin()!=null&&entrys.get(i).getUnLockedOpMargin().signum()>0){
				throw new EASBizException(new NumericExceptionSubItem("001","该初始化单部分分录占用金额已被解锁，不能删除!"));
			}
		}
		if(WorkFlowUtil.checkBillInWorkflow(ctx,pk.toString())){
			throw new EASBizException(new NumericExceptionSubItem("001","当前单据尚在工作流执行过程,不能执行该操作"));
		}
		super._delete(ctx, pk);
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		if(model.getInt("billStatus")!=-1&&model.getInt("billStatus")!=0&&model.getInt("billStatus")!=1)
			throw new EASBizException(ServerUtils.CHECKSAVE);
		MarginInitBillInfo info=(MarginInitBillInfo) model;
		checkISOnlyOne(ctx, info);
		model.setDate("bizDate", DateUtilsComm.clearDateHMS(model.getDate("bizDate")));
		model.setInt("billStatus", 1);
		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		if(model.getInt("billStatus")!=-1&&model.getInt("billStatus")!=0&&model.getInt("billStatus")!=1&&model.getInt("billStatus")!=2)
			throw new EASBizException(ServerUtils.CHECKSUBMIT);
		MarginInitBillInfo info=(MarginInitBillInfo) model;
		checkISOnlyOne(ctx, info);

		model.setDate("bizDate", DateUtilsComm.clearDateHMS(model.getDate("bizDate")));
		model.setInt("billStatus", 2);
		return super._submit(ctx, model);
	}

	private void checkISOnlyOne(Context ctx, MarginInitBillInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		String sql="select *from CT_FM_MarginInitBill where CFBillStatus='4' and CFFICompanyID='"+info.getFICompany().getId().toString()+"'";
		IRowSet rs;
		try {
			rs = DbUtil.executeQuery(ctx, sql);
			if(rs.next()){
				throw new EASBizException(new NumericExceptionSubItem("001","该公司已维护了一张初始化单，不能重复维护"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}