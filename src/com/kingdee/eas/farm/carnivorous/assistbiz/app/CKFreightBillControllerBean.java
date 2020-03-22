package com.kingdee.eas.farm.carnivorous.assistbiz.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.kingdee.bos.*;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.ctrl.reportone.r1.form.engine.x.widget.WBillList;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.fm.common.FMIsqlFacadeFactory;
import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillCollection;
import com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillFactory;
import com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillInfo;
import com.kingdee.eas.farm.carnivorous.assistbiz.CKGrowthFreightBillEntryInfo;
import com.kingdee.eas.farm.carnivorous.assistbiz.FreightMileageBillEntryInfo;
import com.kingdee.eas.farm.carnivorous.assistbiz.FreightTypeEnum;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillFactory;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillInfo;
import com.kingdee.eas.farm.feemanager.basedata.CarriageFormatInfo;
import com.kingdee.eas.farm.stocking.common.BotpCommUtils;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.WorkFlowUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CKFreightBillControllerBean extends AbstractCKFreightBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.assistbiz.app.CKFreightBillControllerBean");
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException{
		CKFreightBillInfo info = CKFreightBillFactory.getLocalInstance(ctx).getCKFreightBillInfo(new ObjectUuidPK(((CKFreightBillInfo) model).getId()));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有提交的单子才可以执行此操作"));
		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		info.setAuditTime(new java.util.Date());
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException{
		CKFreightBillInfo info = CKFreightBillFactory.getLocalInstance(ctx).getCKFreightBillInfo(new ObjectUuidPK(((CKFreightBillInfo) model).getId()));
		if(DbUtil.executeQuery(ctx, "select * from T_BOT_Relation where FSrcObjectID='"+info.getString("id")+"'").size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","有下游单据的单据禁止反审核"));
		if(info.getBillStatus()==null||!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED))
			throw new EASBizException(new NumericExceptionSubItem("001","只有审核的单子才可以执行此操作"));

		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		info.setAuditTime(null);
		info.setAuditor(null);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CKFreightBillInfo info = (CKFreightBillInfo) model;
		if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增或者保存的单子才可以执行此操作"));
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		CKFreightBillInfo info = (CKFreightBillInfo) model;
		if(info.getBillStatus()!=null&&info.getBillStatus().getValue()!=-1&&!info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)&&!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)&&!info.getBillStatus().equals(BillBaseStatusEnum.ADD))
			throw new EASBizException(new NumericExceptionSubItem("001","只有新增、保存或提交的单子才可以执行此操作"));
		if(info.getBillStatus()==null||info.getBillStatus().getValue()==-1||info.getBillStatus().equals(BillBaseStatusEnum.ADD)||info.getBillStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBillStatus(BillBaseStatusEnum.SUBMITED); 
		}
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
		_audit(ctx, info);
		info=CKFreightBillFactory.getLocalInstance(ctx).getCKFreightBillInfo(new ObjectUuidPK(info.getId()));
		return super._submit(ctx, info);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		CKFreightBillInfo info = CKFreightBillFactory.getLocalInstance(ctx).getCKFreightBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，禁止删除！"));
		}
		if(WorkFlowUtil.checkBillInWorkflow(ctx,pk.toString())){
			throw new EASBizException(new NumericExceptionSubItem("001","当前单据尚在工作流执行过程,不能执行该操作"));
		}
		Map changeKeyValue=new HashMap<String, String>();
		changeKeyValue.put("CFHasFreightBill", "'0'");
		BotpCommUtils.updateSrcPorpert(ctx,new CSlaughterBillInfo().getBOSType(), new CKFreightBillInfo().getBOSType(), info.getId().toString(), changeKeyValue);
		super._delete(ctx, pk);
	}

	@Override
	protected void _calFreight(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		CKFreightBillInfo info = (CKFreightBillInfo) model;
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核，操作失败！"));
		}	
		//回收净重
		BigDecimal recSuttle = UIRuleUtil.getBigDecimal(info.getRecSuttle());	
		//回收只数
		BigDecimal recQty = UIRuleUtil.getBigDecimal(info.getRecQty());	
		//毛鸡均重
		BigDecimal averageWgt = recQty.signum()==0?BigDecimal.ZERO:recSuttle.divide(recQty,10,RoundingMode.HALF_UP);
		info.setAverageWgt(averageWgt);

		FreightMileageBillEntryInfo freightMileEntry = StockingComm.getFreightMileageEntryInfo(ctx, info.getBatchContract().getId().toString(), FreightTypeEnum.recCK, info.getCalUnit().getId().toString());
		//运输距离
		BigDecimal distance = freightMileEntry.getDistance();
		info.setDistance(distance);

		CKGrowthFreightBillEntryInfo growthFreightEntry = StockingComm.getCKGrowthFreightEntryInfo(ctx, info.getBatchContract(), info.getAverageWgt(), distance);
		if(growthFreightEntry==null){
			throw new EASBizException(new NumericExceptionSubItem("001","查询出多条满足条件的毛鸡增幅运费表记录,请核查!"));
		}
		//增幅运费
		BigDecimal growthFreight = growthFreightEntry.getGrowthFreight();
		info.setGrowthFreight(growthFreight);
		//标准出肉率
		BigDecimal fmRateStd = growthFreightEntry.getFmRateStd();
		info.setFmRateStd(fmRateStd);
		//最高出肉率
		BigDecimal maxFmRate = growthFreightEntry.getMaxFmRate();
		info.setMaxFmRate(maxFmRate);
		//实际出肉率
		BigDecimal actualFmRate = UIRuleUtil.getBigDecimal(info.getActualFmRate());
		//计算用日出肉率
		BigDecimal fmRateForCal=BigDecimal.ZERO;
        if(actualFmRate.compareTo(maxFmRate)>0){
			fmRateForCal=maxFmRate;
		}else{
			fmRateForCal=actualFmRate;
		}
		info.setDateFmRate(fmRateForCal);
		//胴体重量
		BigDecimal carcassWgt = UIRuleUtil.getBigDecimal(info.getCarcassWgt());
		//毛鸡市场价
		BigDecimal marketPrice = StockingComm.getPriceFromDailyOutSalebill(ctx, info.getBizDate(), info.getBreedData().getId().toString(), info.getAverageWgt());
		if(marketPrice==null){
			throw new EASBizException(new NumericExceptionSubItem("001","日期 "+sdf.format(info.getBizDate())+" 的外卖毛鸡价格未维护!"));
		}
		info.setMarketPrice(marketPrice);
	
		//毛鸡运费
		BigDecimal ckFreight=fmRateStd.signum()==0?recSuttle.multiply(marketPrice).negate():recSuttle.multiply(fmRateForCal).divide(fmRateStd,20,RoundingMode.HALF_UP).multiply((marketPrice.add(growthFreight))).subtract(recSuttle.multiply(marketPrice)).setScale(2,RoundingMode.HALF_UP);
		info.setDateCKFreight(ckFreight);
		//派车与拉鸡只数差异
		BigDecimal pldiffQty = UIRuleUtil.getBigDecimal(info.getPldiffQty());
		//派车与拉鸡只数差异扣补
		BigDecimal pldiffAmt = pldiffQty.multiply(averageWgt).multiply(growthFreight);
		info.setPldiffAmount(pldiffAmt);
		
		//翅淤血比例
		BigDecimal cyxRate = getCYXRate(ctx, info);
		info.setCyxRate(cyxRate);
		//翅淤血扣补
		BigDecimal cyxKbAmt = StockingComm.getCyxKb(ctx, info.getBatchContract(),  cyxRate);
		info.setCyxKbAmt(cyxKbAmt);		
		_update(ctx, new ObjectUuidPK(info.getId()), info);
	}


	private BigDecimal getCYXRate(Context ctx,CKFreightBillInfo info) {
		// TODO Auto-generated method stub
		BigDecimal cyxRate=BigDecimal.ZERO;
		String sql="select t2.FSrcObjectID fid from CT_FM_CKFreightBill t1 inner join T_BOT_Relation t2 on (t1.fid=t2.FDestObjectID and t2.FSrcEntityID='"+new CSlaughterBillInfo().getBOSType().toString()+"') and t1.fid='"+info.getId().toString()+"'";
		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sql);
			if(rs.next()){
				String cSlaughterBillID=rs.getString("fid");
				//				CSlaughterBillInfo cSlaughterBillInfo=CSlaughterBillFactory.getLocalInstance(ctx).getCSlaughterBillInfo(new ObjectUuidPK(cSlaughterBillID));
				StringBuffer sqlBuf = new StringBuffer();
				sqlBuf.append(" /*dialect*/select sum(nvl(t2.CFActualRate,0)) rate from CT_FM_CSlaughterBill  t1  ")
				.append(" inner join CT_FM_CSlaughterBillQCEntrys t2 on t1.fid=t2.fparentid  ")
				.append(" inner join CT_FM_RewardAndPunishItem t3 on t3.fid=t2.CFQCItemID ")
				.append(" where t3.fnumber='1002' and t1.fid='"+cSlaughterBillID+"' ")
				.append(" group by t2.CFQCItemID ");
				IRowSet rs2 = DbUtil.executeQuery(ctx, sqlBuf.toString());
				if(rs2.next()){
					cyxRate=rs2.getBigDecimal("rate");
				}
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cyxRate;
	}
}