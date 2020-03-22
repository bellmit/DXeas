package com.kingdee.eas.farm.carnivorous.assistbiz.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

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
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillFactory;
import com.kingdee.eas.farm.carnivorous.assistbiz.CKFreightBillInfo;
import com.kingdee.eas.farm.carnivorous.assistbiz.CKGrowthFreightBillEntryInfo;
import com.kingdee.eas.farm.carnivorous.assistbiz.FreightMileageBillEntryInfo;
import com.kingdee.eas.farm.carnivorous.assistbiz.FreightTypeEnum;
import com.kingdee.eas.farm.carnivorous.assistbiz.ICKFreightBill;
import com.kingdee.eas.farm.carnivorous.assistbiz.MonthFreightCalBillCollection;
import java.lang.String;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.carnivorous.assistbiz.MonthFreightCalBillInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.carnivorous.recyclebiz.CSlaughterBillInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.Result;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MonthFreightCalBillControllerBean extends AbstractMonthFreightCalBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.assistbiz.app.MonthFreightCalBillControllerBean");
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		MonthFreightCalBillInfo info=(MonthFreightCalBillInfo) model;
		String fid=null;
		if(info.getId()!=null){
			fid=info.getId().toString();
		}
		Boolean hasMonthFreight = StockingComm.isHasMonthFreight(ctx, info.getFICompany().getId().toString(), info.getPeriod().getId().toString(), info.getBreedData().getId().toString(), info.getCustomer().getId().toString(), fid);
		if(hasMonthFreight){
			throw new EASBizException(new NumericExceptionSubItem("001","已存在同一客户/品种/年月的月运费核算记录,操作失败!"));
		}
		return super._save(ctx, model);
	}

	@Override
	protected void _monthCal(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		MonthFreightCalBillInfo info=(MonthFreightCalBillInfo) model;
		String breedDataID=info.getBreedData().getId().toString();
		String customerID=info.getCustomer().getId().toString();
		ICKFreightBill iCKFreightBill = CKFreightBillFactory.getLocalInstance(ctx);
		//月平均出肉率
		BigDecimal monthAvgFmRate = info.getMonthAvgFmRate();
		//出肉率调整系数
		BigDecimal fmAdjustRate = UIRuleUtil.getBigDecimal(info.getFmAdjustRate());
		//出肉率系数
		BigDecimal fmRateCoe = UIRuleUtil.getBigDecimal(info.getFmRateCoe());
		String sql="/*dialect*/SELECT fid FROM CT_FM_CKFreightBill where CFFICompanyID='"+info.getFICompany().getId().toString()+"' and CFBreedDataID='"+breedDataID+"' and CFCustomerID='"+customerID+"' and to_char(FBizDate,'yyyyMM')='"+info.getPeriod().getNumber()+"' and cfbillStatus=4";
		IRowSet rs = DbUtil.executeQuery(ctx, sql);
		try {
			while(rs.next()){
				CKFreightBillInfo ckFreightBillInfo=CKFreightBillFactory.getLocalInstance(ctx).getCKFreightBillInfo(new ObjectUuidPK(rs.getString("fid")));
				ckFreightBillInfo.setMonthAveFmRate(monthAvgFmRate);
				ckFreightBillInfo.setDressingPercent(fmAdjustRate);
				if(ckFreightBillInfo.getDateCKFreight()==null){
					throw new EASBizException(new NumericExceptionSubItem("001","编号为:"+ckFreightBillInfo.getNumber()+"的毛鸡运费单未执行过日运费计算,操作失败!"));
				}
				BigDecimal distance = UIRuleUtil.getBigDecimal(ckFreightBillInfo.getDistance());
				CKGrowthFreightBillEntryInfo growthFreightEntry = StockingComm.getCKGrowthFreightEntryInfo(ctx, ckFreightBillInfo.getBatchContract(), ckFreightBillInfo.getAverageWgt(), distance);
				if(growthFreightEntry==null){
					throw new EASBizException(new NumericExceptionSubItem("001","编号为:"+ckFreightBillInfo.getNumber()+"的毛鸡运费单查询出多条满足条件的毛鸡增幅运费表记录,请核查!"));
				}
				ckFreightBillInfo.setFmRateCoe(fmRateCoe);
				//月增幅运费
				BigDecimal growthFreight = growthFreightEntry.getGrowthFreight();
				ckFreightBillInfo.setGrowthFreight(growthFreight);
				//标准出肉率
				BigDecimal fmRateStd = growthFreightEntry.getFmRateStd();
				//最高出肉率
				BigDecimal maxFmRate = growthFreightEntry.getMaxFmRate();
				//月实际出肉率(废弃)
				BigDecimal monthActualFmRate = monthAvgFmRate.add(fmAdjustRate);
				//实际出肉率
				BigDecimal actualFmRate = UIRuleUtil.getBigDecimal(ckFreightBillInfo.getActualFmRate());
				
				//月计算用出肉率
				BigDecimal monthCalFmRate = BigDecimal.ZERO;
				if(actualFmRate.compareTo(maxFmRate.add(fmAdjustRate))<=0){
					monthCalFmRate=actualFmRate;
				}else{
					monthCalFmRate=maxFmRate.add(fmAdjustRate);
				}
				ckFreightBillInfo.setMonthCalFmRate(monthCalFmRate);
				//胴体重量
				BigDecimal carcassWgt = UIRuleUtil.getBigDecimal(ckFreightBillInfo.getCarcassWgt());
				//毛鸡市场价
				BigDecimal marketPrice = StockingComm.getPriceFromDailyOutSalebill(ctx, ckFreightBillInfo.getBizDate(), ckFreightBillInfo.getBreedData().getId().toString(), ckFreightBillInfo.getAverageWgt());
				if(marketPrice==null){
					throw new EASBizException(new NumericExceptionSubItem("001","日期 "+sdf.format(ckFreightBillInfo.getBizDate())+" 的外卖毛鸡价格未维护!"));
				}
				ckFreightBillInfo.setMarketPrice(marketPrice);
				//回收净重
				BigDecimal recSuttle = UIRuleUtil.getBigDecimal(ckFreightBillInfo.getRecSuttle());		
				//实际毛鸡运费
				BigDecimal ckFreight=fmRateStd.signum()==0?recSuttle.multiply(marketPrice).negate():recSuttle.multiply(monthCalFmRate).divide(fmRateStd.add(fmAdjustRate),20,RoundingMode.HALF_UP).multiply((marketPrice.add(growthFreight))).subtract(recSuttle.multiply(marketPrice)).setScale(2,RoundingMode.HALF_UP);
				ckFreightBillInfo.setActualCKFreight(ckFreight);

				//派车与拉鸡只数差异扣补
				BigDecimal pldiffAmt = UIRuleUtil.getBigDecimal(ckFreightBillInfo.getPldiffAmount());
				//高速费
				BigDecimal highWayFee = UIRuleUtil.getBigDecimal(ckFreightBillInfo.getHighWayFee());
				//其他扣补
				BigDecimal otherKbAmt = UIRuleUtil.getBigDecimal(ckFreightBillInfo.getOtherKbAmt());
				//翅淤血扣补
				BigDecimal cyxKbAmt = UIRuleUtil.getBigDecimal(ckFreightBillInfo.getCyxKbAmt());
				//总运输费用
				BigDecimal allFreight = ckFreight.add(pldiffAmt).add(highWayFee).add(otherKbAmt).add(cyxKbAmt);
				ckFreightBillInfo.setAllFreight(allFreight);
				iCKFreightBill.update(new ObjectUuidPK(ckFreightBillInfo.getId()), ckFreightBillInfo);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}