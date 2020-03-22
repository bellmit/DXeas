package com.kingdee.eas.farm.carnivorous.recyclebiz.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;
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
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillCollection;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CCarSendBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CKCloseAccountFacadeFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ChickenRecBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.ICCarSendBill;
import com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.PreHouseWgtBillInfo;
import com.kingdee.eas.farm.carnivorous.recyclebiz.SaleBizType;
import com.kingdee.eas.farm.feemanager.basedata.DriverFactory;
import com.kingdee.eas.farm.feemanager.basedata.DriverInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.publicdata.CarFactory;
import com.kingdee.eas.publicdata.CarInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CCarSendBillControllerBean extends AbstractCCarSendBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.recyclebiz.app.CCarSendBillControllerBean");

	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		CCarSendBillInfo info = CCarSendBillFactory.getLocalInstance(ctx).getCCarSendBillInfo(new ObjectUuidPK(((CCarSendBillInfo) model).getId()));
//		if(info.getSaleType()==SaleBizType.inner){
//			if(info.getDriver()==null||info.getCar()==null){
//				throw new EASBizException(new NumericExceptionSubItem("001","内销派车单司机车辆不能为空"));
//			}
//		}
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有提交的单子才可以执行此操作"));
	
		checkIsSettled(ctx, info);
		checkIsGuanZhang(ctx, info);
		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		info.setAuditTime(new java.util.Date());
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));

		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}


	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		CCarSendBillInfo info = CCarSendBillFactory.getLocalInstance(ctx).getCCarSendBillInfo(new ObjectUuidPK(((CCarSendBillInfo) model).getId()));
		if(DbUtil.executeQuery(ctx, "select * from T_BOT_Relation where FSrcObjectID='"+info.getString("id")+"'").size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","有下游单据的单据禁止反审核"));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作"));
		checkIsSettled(ctx, info);
		checkIsGuanZhang(ctx, info);
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		info.setAuditTime(null);
		info.setAuditor(null);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}


	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CCarSendBillInfo info = (CCarSendBillInfo) model;
		if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增或者保存的单子才可以执行此操作"));
		checkIsSettled(ctx, info);
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		CCarSendBillInfo info = (CCarSendBillInfo) model;
		if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增、保存或提交的单子才可以执行此操作"));
		checkIsSettled(ctx, info);
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED); 
		}
		super._update(ctx,new ObjectUuidPK( info.getId()), info);
		_audit(ctx, info);
		info = CCarSendBillFactory.getLocalInstance(ctx).getCCarSendBillInfo(new ObjectUuidPK(info.getId()));
		return super._submit(ctx, info);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CCarSendBillInfo info = CCarSendBillFactory.getLocalInstance(ctx).getCCarSendBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		StringBuffer sql1 = new StringBuffer();
		sql1.append(" select distinct t2.FSRCOBJECTID FSRCOBJECTID from CT_FM_ChickenRecBill t1 ")
		.append(" inner join T_BOT_Relation t2 on t2.FSrcObjectID=t1.fid ")
		.append(" where  t2.FDESTOBJECTID = '"+info.getId().toString()+"' ");
		IRowSet rs = DbUtil.executeQuery(ctx, sql1.toString());
		try {
			if(rs.next()){
				String  chickenRecID=rs.getString("FSRCOBJECTID");
				StringBuffer sql2 = new StringBuffer();
				sql2.append(" select distinct t2.FDESTOBJECTID FDESTOBJECTID from CT_FM_ChickenRecBill t1 ")
				.append(" inner join T_BOT_Relation t2 on t2.FSrcObjectID=t1.fid ")
				.append(" where  t2.FSRCOBJECTID = '"+chickenRecID+"' ")
				.append(" and t2.FDESTOBJECTID<>'"+info.getId().toString()+"' ");				
				if(DbUtil.executeQuery(ctx, sql2.toString()).size()==0){
					DbUtil.execute(ctx,"update CT_FM_ChickenRecBill set CFIsHasPaiChe='0' where fid ='"+chickenRecID+"'");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		super._delete(ctx, pk);
	}

	private void checkIsSettled(Context ctx,CCarSendBillInfo info) throws EASBizException {
		// TODO Auto-generated method stub
//		Boolean isHasSettled = StockingComm.checkIsHasSettled(ctx, info.getBatchContract().getId().toString());
//		if(isHasSettled){
//			throw new EASBizException(new NumericExceptionSubItem("001","该批次已完全回收结算,操作失败!"));
//		}
	}
	
	private void checkIsGuanZhang(Context ctx,CCarSendBillInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		boolean isGuanZhang=false;
		String companyID = info.getFICompany().getId().toString();
		PeriodInfo period=DateUtilsComm.getPeriodInfoByDate(ctx,info.getBizDate());
		String periodID=period==null?"":period.getId().toString();
		try {
			isGuanZhang= CKCloseAccountFacadeFactory.getLocalInstance(ctx).checkIsClosed(companyID, periodID);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isGuanZhang){
			throw new EASBizException(new NumericExceptionSubItem("001","业务日期对应期间内该公司已执行了关账操作,当前操作失败!"));
		}
	}
	
	@Override
	protected void _manageSendCar(Context ctx, IObjectValue model, Map map)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		super._manageSendCar(ctx, model, map);
		CCarSendBillInfo info = (CCarSendBillInfo) model;
		if(map.get("carID")!=null){
			String carID=(String) map.get("carID");
			CarInfo car=CarFactory.getLocalInstance(ctx).getCarInfo(new ObjectUuidPK(carID));
			info.setCar(car);
		}else{
			info.setCar(null);
		}
		if(map.get("driverID")!=null){
			String driverID=(String) map.get("driverID");
			DriverInfo driver=DriverFactory.getLocalInstance(ctx).getDriverInfo(new ObjectUuidPK(driverID));
			info.setDriver(driver);
			info.setDriverPhone(driver.getDriverphone());
		}else{
			info.setDriver(null);
			info.setDriverPhone(null);
		}
		Date arriveTime=(Date) map.get("arriveTime");
		info.setArriveTime(arriveTime);
		info.setSeq((Integer)map.get("seq"));
		info.setDeliverQty(((BigDecimal)map.get("qty")).intValue());
		if(info.getBillStatus()==BillBaseStatusEnum.SUBMITED){
			_submit(ctx,info);
		}else{
			_save(ctx,info);
		}

	}
}