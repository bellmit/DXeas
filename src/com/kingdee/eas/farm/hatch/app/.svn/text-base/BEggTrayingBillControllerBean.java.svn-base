package com.kingdee.eas.farm.hatch.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

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
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.hatch.BEggCandlingBillCollection;
import com.kingdee.eas.farm.hatch.BEggCandlingBillFactory;
import com.kingdee.eas.farm.hatch.BEggCandlingBillInfo;
import com.kingdee.eas.farm.hatch.BEggTrayingBillCollection;
import com.kingdee.eas.farm.hatch.BEggTrayingBillFactory;
import com.kingdee.eas.farm.hatch.BEggTrayingBillInfo;
import com.kingdee.eas.farm.hatch.BHatchBabyBillInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.eas.wlhlcomm.FarmException;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.util.StringUtils;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BEggTrayingBillControllerBean extends AbstractBEggTrayingBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.hatch.app.BEggTrayingBillControllerBean");

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		// TODO Auto-generated method stub
		String sql="select * from T_BOT_Relation where FDestObjectID='"+pk.toString()+"' and FSrcEntityID='D54999A2'";
		IRowSet rs = DbUtil.executeQuery(ctx, sql);
		String srcBillID="";
		try {
			if(rs.next()){
				srcBillID = rs.getString("FSrcObjectID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super._delete(ctx, pk);
		
		if(StringUtils.isEmpty(srcBillID))
			return;
		sql="select * from T_BOT_Relation where FSrcObjectID='"+srcBillID+"' and FDestEntityID='92957B02' order by FDate desc";
		rs = DbUtil.executeQuery(ctx, sql);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if(rs.next()){
				BEggTrayingBillCollection collBEggTraying = BEggTrayingBillFactory.getLocalInstance(ctx).getBEggTrayingBillCollection("where id='"+rs.getString("FDestObjectID")+"'");
				if(collBEggTraying.size()>0){
					String str = "update CT_FM_BEggCandlingBill set FIsTraying=1";
					if(collBEggTraying.get(0).getBizDate()!=null)
						str+=",FTrayingDate={ts '"+sdf.format(collBEggTraying.get(0).getBizDate())+"'}";
					str+=" where  fid ='"+srcBillID+"'";
					DbUtil.execute(ctx, str);
				}
				else
					DbUtil.execute(ctx, "update CT_FM_BEggCandlingBill set FIsTraying=0,FTrayingDate='' where  fid ='"+srcBillID+"'");
			}else
				DbUtil.execute(ctx, "update CT_FM_BEggCandlingBill set FIsTraying=0,FTrayingDate='' where  fid ='"+srcBillID+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException,
			EASBizException {
		// TODO Auto-generated method stub
		BEggTrayingBillInfo billInfo = (BEggTrayingBillInfo)model;
		
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.SUBMITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new EASBizException(new NumericExceptionSubItem("01","已经存在下游单据，不能审核"));
			}
			
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_FM_BEggTrayingBill", billInfo.getId().toString(), BillBaseStatusEnum.AUDITED);
			
		}else{
			throw new EASBizException(new NumericExceptionSubItem("01","只能审核提交状态的单据"));
		}
		
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub

		
		BEggTrayingBillInfo billInfo = (BEggTrayingBillInfo)model;
		
		if(billInfo != null && billInfo.getBaseStatus() != null && BillBaseStatusEnum.AUDITED.equals(billInfo.getBaseStatus())){
			boolean exist = AppCommon.existDestBill(ctx, this.getBOSType().toString(), billInfo.getId().toString());
			if(exist){
				throw new EASBizException(new NumericExceptionSubItem("01","已经存在下游单据，不能反审核"));
			}
			// 更新单据状态
			AppCommon.updateModelStatus(ctx, "CT_FM_BEggTrayingBill", billInfo.getId().toString(), BillBaseStatusEnum.TEMPORARILYSAVED);
			
		}else{
			throw new EASBizException(new NumericExceptionSubItem("01","只能反审核审核状态的单据"));
		}
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// 状态设置为保存
		BEggTrayingBillInfo info =  (BEggTrayingBillInfo)model;
		if(!BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) &&
				!BillBaseStatusEnum.ADD.equals(info.getBaseStatus())	&& 
				!info.getBaseStatus().NULL.equals(info.getBaseStatus()) && 
				info.getBaseStatus() != null ){
			throw new EASBizException(new NumericExceptionSubItem("001","只能保存暂存或者新增状态的单据"));
			
		}
		info.setBizDate(DateUtilsComm.clearDateHMS(info.getBizDate()));
		info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub

		BEggTrayingBillInfo info = (BEggTrayingBillInfo)model;
    	if(info != null  && 
    			(BillBaseStatusEnum.ADD.equals(info.getBaseStatus()) ||
    						BillBaseStatusEnum.TEMPORARILYSAVED.equals(info.getBaseStatus()) ||
    						BillBaseStatusEnum.SUBMITED.equals(info.getBaseStatus()) || 
    						BillBaseStatusEnum.NULL.equals(info.getBaseStatus()) || 
    						info.getBaseStatus() == null)){
    		info.setBaseStatus( BillBaseStatusEnum.SUBMITED);
    		info.setBizDate(DateUtilsComm.clearDateHMS(info.getBizDate()));
    		return super._submit(ctx, model);
    	}else{
    		throw new EASBizException(new NumericExceptionSubItem("001","只能提交新增或保存状态的单据"));
			
    	}
	}

	@Override
	protected void _adjust(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
		
	}
}