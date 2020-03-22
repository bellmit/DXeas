package com.kingdee.eas.farm.dayratecost.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.db.TempTablePool;
import com.kingdee.bos.framework.ejb.EJBFactory;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.basedata.assistant.IPeriod;
import com.kingdee.eas.basedata.assistant.PeriodException;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.assistant.PeriodUtils;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.dayratecost.DayRateBaseSettingCollection;
import com.kingdee.eas.farm.dayratecost.DayRateBaseSettingFactory;
import com.kingdee.eas.farm.dayratecost.DayRateBaseSettingInfo;
import com.kingdee.eas.farm.dayratecost.DayratecostCalTypeEnum;
import com.kingdee.eas.farm.dayratecost.bean.DayRateCalVerigyBean;
import com.kingdee.eas.farm.dayratecost.comm.DayrateUtils;
import com.kingdee.eas.farm.hatch.EggSourceType;
import com.kingdee.eas.farm.stocking.basedata.FarmStageEnum;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class DayrateCalFacadeControllerBean extends AbstractDayrateCalFacadeControllerBean
{
    private static Logger logger = Logger.getLogger("com.kingdee.eas.farm.dayratecost.app.DayrateCalFacadeControllerBean");
	private SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd");
	private Calendar cal=Calendar.getInstance();
	/**
	 * 初始化检查
	 * @param ctx
	 * @param companyID
	 * @throws EASBizException 
	 * @throws BOSException 
	 * @throws EASBizException 
	 * @throws BOSException 
	 */
	private void checkInit(Context ctx,String companyID) throws EASBizException, BOSException  {
		DayRateBaseSettingCollection bsCol = DayRateBaseSettingFactory.getLocalInstance(ctx).getDayRateBaseSettingCollection("where company.id='"+companyID+"'");
		if(bsCol==null||bsCol.size()<=0) {
			throw new EASBizException(new NumericExceptionSubItem("001","请设置好系统参数！"));
		}
		
		SelectorItemCollection slor=new SelectorItemCollection();
		slor.add("*");
		slor.add("curPeriod.*");
		DayRateBaseSettingInfo bsInfo = DayRateBaseSettingFactory.getLocalInstance(ctx).getDayRateBaseSettingInfo(new ObjectUuidPK(bsCol.get(0).getId()),slor);
		if(!bsInfo.isIsInit()) {
			throw new EASBizException(new NumericExceptionSubItem("001","请先初始化系统！"));
		}
		//需要执行的期间
		/*String opPeriodNum=bizDateString.substring(0, 4)+bizDateString.substring(5, 7);
		if(opPeriodNum.equals(bsInfo.getCurrentPeriod().getPeriodNumber())) {
			throw new Exception("非当前期间"+bsInfo.getCurrentPeriod().getPeriodNumber()+"不允许执行日成本计算！");
		}*/
	}
	
    protected Object _exeCalDayrate(Context ctx, String jsonStr)throws BOSException, EASBizException
    {
    	try {
    		JSONObject jo=JSONObject.fromObject(jsonStr);
    		String companyID=jo.getString("companyID");//公司
    		String periodID=jo.getString("periodID");//计算日期
    		DayratecostCalTypeEnum calType=DayratecostCalTypeEnum.getEnum(jo.getInt("calType"));//计算类型
    		Boolean isBeginFirst=jo.getBoolean("isBeginFirst");//是否从月初开始计算
    		
    		//初始化检查
    		checkInit(ctx, companyID);
    		
    		Date[] dateRange = StockingComm.getDateRangeByPeriod(ctx, companyID, periodID);
    		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    		String beginDateStr=sdf.format(dateRange[0]);
    		String endDateStr=sdf.format(dateRange[1]);
    	
    		//校验
    		HashMap<String,DayRateCalVerigyBean> result=verifyData(ctx, companyID, beginDateStr,endDateStr,isBeginFirst);
    		if(result.size()<=0){
    			//校验通过执行日成本计算
//        		exeDayrateCal(ctx, companyID, bizDateString,isBeginFirst);
    			//全部计算
    			if(calType.equals(DayratecostCalTypeEnum.all)) {
    				calEggsCost(ctx, companyID, periodID, beginDateStr, endDateStr);
    			}else if(calType.equals(DayratecostCalTypeEnum.dayrate)) {//育成日成本计算
        				
    			}
    			else if(calType.equals(DayratecostCalTypeEnum.eggCost)) {//产蛋成本计算
    				calEggsCost(ctx, companyID, periodID, beginDateStr, endDateStr);
    			}
    		}
    		return result;
    		
    	}catch(Exception err) {
    		throw new EASBizException(new NumericExceptionSubItem("001",err.getMessage()));
    	}
    }
    /**
     * 日成本计算校验
     * @param ctx
     * @param companyID
     * @param bizDateString
     * @param isBeginFirst
     * @return
     * @throws Exception
     */
    private LinkedHashMap <String,DayRateCalVerigyBean> verifyData(Context ctx,String companyID,String beginDateStr,String endDateStr,boolean isBeginFirst)throws Exception {
    	
    	//结果
    	LinkedHashMap<String,DayRateCalVerigyBean> result=new LinkedHashMap<String,DayRateCalVerigyBean>();

		//获取填写日报的批次
		StringBuffer sql=new StringBuffer();
		sql.append(" /*dialect*/select ")
		.append(" * ")
		.append(" from (")
		.append(" select tb.fid FbatchID,tb.fnumber FBatchNum,thouse.fid FhenhouseID,thouse.cfname FHenhouseName,tmain.fid FDailyBillID,tmain.fnumber FDailyBillNum,")
		.append(" tdate.fday FbizDate,tmain.CFBaseStatus,tfarm.fid FFarmID,tfarm.fname_l2 FFarmName,tentry.fid FDailyEntryID,")
		.append(" tfarmer.fid ffarmerid,tfarmer.fname_l2 ffarmername")
		.append(" from t_fm_stockingBatch tb")
		.append(" inner join T_FM_StockingBatchHouseEntry tbe on tbe.fparentid=tb.fid")
		//获取日期列表
		.append(" inner join (SELECT TO_CHAR(TO_DATE('"+beginDateStr+"','YYYY-MM-DD')+ROWNUM-1  ,'YYYY-MM-DD') Fday from dual")
		.append(" CONNECT BY ROWNUM<=trunc(to_date('"+endDateStr+"', 'yyyy-mm-dd')-to_date('"+beginDateStr+"', 'yyyy-mm-dd'))+1) tdate on 1=1")
		.append(" inner join t_fm_farmer tfarmer on tfarmer.fid=tb.ffarmerid")
		.append(" inner join t_fm_farm tfarm on tfarm.fid=tb.ffarmid")
		.append(" inner join CT_FM_FarmHouseEntry thouse on thouse.fid=tbe.FhouseID")
		.append(" left join  T_FM_StockingBreedDaily tmain on (tmain.CFStockingBatchID=tb.fid and to_char(tmain.FbizDate,'yyyy-MM-dd')=tdate.Fday ")
		.append(" and tmain.FbizDate<(to_date('").append(endDateStr).append("','yyyy-MM-dd')+1)")
		.append(" and tmain.fcompanyid='").append(companyID).append("'")
		.append(")")
		.append(" left join T_FM_StockingBDAE tentry on (tentry.fparentid=tmain.fid and tentry.fhouseid=tbe.fhouseid)")
		.append(" where tb.FCompanyID='").append(companyID).append("'")
		.append(" and tfarm.fishousemanager=1")//启动棚舍管理
		.append(" union all")
		.append(" select tb.fid FbatchID,tb.fnumber FBatchNum,thouse.fid FhenhouseID,thouse.cfname FHenhouseName,tmain.fid FDailyBillID,tmain.fnumber FDailyBillNum,")
		.append(" tdate.fday FbizDate,tmain.CFBaseStatus,tfarm.fid FFarmID,tfarm.fname_l2 FFarmName,tentry.fid FDailyEntryID,")
		.append(" tfarmer.fid ffarmerid,tfarmer.fname_l2 ffarmername")
		.append(" from t_fm_stockingBatch tb")
		//获取日期列表
		.append(" inner join (SELECT TO_CHAR(TO_DATE('"+beginDateStr+"','YYYY-MM-DD')+ROWNUM-1  ,'YYYY-MM-DD') Fday from dual")
		.append(" CONNECT BY ROWNUM<=trunc(to_date('"+endDateStr+"', 'yyyy-mm-dd')-to_date('"+beginDateStr+"', 'yyyy-mm-dd'))+1) tdate on 1=1")
		.append(" inner join t_fm_farmer tfarmer on tfarmer.fid=tb.ffarmerid")
		.append(" inner join t_fm_farm tfarm on tfarm.fid=tb.ffarmid")
		.append(" left join  T_FM_StockingBreedDaily tmain on (tmain.CFStockingBatchID=tb.fid and to_char(tmain.FbizDate,'yyyy-MM-dd')=tdate.Fday ")
		.append(" and tmain.FbizDate<(to_date('").append(endDateStr).append("','yyyy-MM-dd')+1)")
		.append(" and tmain.fcompanyid='").append(companyID).append("'")
		.append(")")
		.append(" left join T_FM_StockingBDAE tentry on (tentry.fparentid=tmain.fid and tentry.fseq=1)")
		.append(" where tb.FCompanyID='").append(companyID).append("'")
		.append(" and (tfarm.fishousemanager=0 or tfarm.fishousemanager is null)")//不启动棚舍管理
		.append(" ) ttemp")
		.append(" order by tb.fnumber,thouse.fnumber,tdate.fday")
		;
		
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		String dailyBillID,dailyEntryID;//日报Id
//		String costObjectID;//批次成本对象
		LinkedList<String> verifyMsg=new LinkedList<String>();
		DayRateCalVerigyBean bean;
		String mapKey;
		while(rs.next()) {
			dailyBillID=rs.getString("FDailyBillID");
			dailyEntryID=rs.getString("FDailyEntryID");
//			costObjectID=rs.getString("FCostObjectID");
			
			mapKey=rs.getString("FBatchID")+"||"+rs.getString("FhouseID")!=null?rs.getString("FhouseID"):"";
			
			verifyMsg.clear();
			if(StringUtils.isEmpty(dailyEntryID)) {
				verifyMsg.add("日期："+rs.getString("FBizDate")+" 尚未填写日报！");
			}else{
				if(rs.getInt("CFBaseStatus")!=BillBaseStatusEnum.AUDITED_VALUE) {
					verifyMsg.add("日报："+rs.getString("FDailyBillNum")+" 尚未审核！");
				}else {
					//检查下游单据
//					verifyMsg=checkNextBill(ctx, dailyBillID,rs.getString("FDailyBillNum"),costObjectID);
				}
			}
			if(verifyMsg.size()>0) {
				if(result.containsKey(mapKey)) {
					bean=result.get(mapKey);
				}else{
					bean=new DayRateCalVerigyBean();
					bean.setBatchID(rs.getString("FBatchID"));
					bean.setBatchNum(rs.getString("FBatchNum"));
//					bean.setCostObjectID(costObjectID);
					bean.setHenhouseID(rs.getString("FHenhouseID"));
					bean.setHenhouseName(rs.getString("FHenhouseName"));
					bean.setFarmID(rs.getString("FFarmID"));
					bean.setFarmName(rs.getString("FFarmName"));
					bean.setVeriyMsgs(new LinkedList<String>());
					result.put(mapKey, bean);
				}
				for(String msg:verifyMsg) {
					bean.getVeriyMsgs().add(msg);
				}
			}
		}
		return result;
    }
    
    /**
     * 校验日报的下游单据
     * @param ctx
     * @param dailyBillID
     * @return
     */
    private LinkedList<String> checkNextBill(Context ctx,String dailyBillID,String dailyBillNum,String costObjectID) throws Exception {
    	LinkedList<String> verifyMsg=new LinkedList<String>();;
    	StringBuffer sql=new StringBuffer();
    	//领料出库单
    	sql.append(" select treq.fnumber,treq.FBaseStatus,tentry.fseq,tentry.fcostobjectid,count(*) fcount")
    	.append(" from T_IM_MaterialReqBill treq")
    	.append(" inner join T_IM_MaterialReqBillEntry tentry on tentry.fparentid=treq.fid")
    	.append(" inner join t_bot_relation tr on tr.fdestObjectID=treq.fid")
    	.append(" where tr.fsrcObjectID='").append(dailyBillID).append("'")
    	.append(" group by treq.fnumber,treq.FBaseStatus,tentry.fseq,tentry.fcostobjectid")
    	;
    	IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
    	if(rs.size()<=0) {
    		verifyMsg.add("日报： "+dailyBillNum+" 不存在对应的领料出单！");
    	}else{
    		String numberContinue="";
    		while(rs.next()) {
    			//如果已经校验为未审核，则跳出校验下一个单据
    			if(numberContinue.equals(rs.getString("number"))) {
    				continue;
    			}
    			//审核或关系
    			if(rs.getInt("FBaseStatus")!=4&&rs.getInt("FBaseStatus")!=5) {
    				verifyMsg.add("日报： "+dailyBillNum+" 对应的领料出库单： "+rs.getString("fnumber")+" 尚未审核或关闭！");
    				numberContinue=rs.getString("fnumber");
    				continue;
    			}
    			//成本对象不一致
    			if(!rs.getString("fcostobjectid").equals(costObjectID)) {
    				verifyMsg.add("日报： "+dailyBillNum+"对应的领料出库单： "+rs.getString("fnumber")+" ,第"+rs.getInt("fseq")+"行分录成本对象与批次成本对象不一致！");
    			}
    		}
    	}
    	//生产入库单
    	/*sql.setLength(0);
    	sql.append(" select treq.fnumber,treq.FBaseStatus")
    	.append(" from T_IM_ManufactureRecBill treq")
    	.append(" inner join t_bot_relation tr on tr.fdestObjectID=treq.fid")
    	.append(" where tr.fsrcObjectID='").append(dailyBillID).append("")
    	.append(" ")
    	;
    	rs = DbUtil.executeQuery(ctx, sql.toString());
    	if(rs.size()<=0) {
    		verifyMsg.add("不存在生产入库单！");
    	}else{
    		while(rs.next()) {
    			//审核或关系
    			if(rs.getInt("FBaseStatus")!=4&&rs.getInt("FBaseStatus")!=5) {
    				verifyMsg.add("领料出库单"+rs.getString("fnumber")+"单尚未审核！");
    			}
    		}
    	}
    	//库存调拨单
    	sql.setLength(0);
    	sql.append(" select treq.fnumber,treq.FBaseStatus")
    	.append(" from T_IM_StockTransferBill treq")
    	.append(" inner join t_bot_relation tr on tr.fdestObjectID=treq.fid")
    	.append(" where tr.fsrcObjectID='").append(dailyBillID).append("")
    	.append(" ")
    	;
    	rs = DbUtil.executeQuery(ctx, sql.toString());
    	if(rs.size()<=0) {
    		verifyMsg.add("不存在库存调拨单！");
    	}else{
    		while(rs.next()) {
    			//审核或关系
    			if(rs.getInt("FBaseStatus")!=4&&rs.getInt("FBaseStatus")!=5) {
    				verifyMsg.add("库存调拨单"+rs.getString("fnumber")+"单尚未审核！");
    			}
    		}
    	}*/
    	return verifyMsg;
    }
    /**
     * 执行日成本计算
     */
    private void exeDayrateCal(Context ctx,String companyID,String bizDateString,boolean isBeginFirst) throws Exception {
    	DayRateBaseSettingInfo bdsInfo = DayrateUtils.getBaseSetting(ctx, companyID);
    	
    	String beginDateStr=bizDateString;
		if(isBeginFirst){
			//当月第一天
			cal.setTime(sdf.parse(bizDateString));
			cal.set(Calendar.DAY_OF_MONTH, 1);
			beginDateStr=sdf.format(cal.getTime());
		}
		
		PeriodInfo curPeriodInfo = PeriodUtils.getPeriodInfo(sdf.parse(bizDateString),new ObjectUuidPK( companyID));
    	//上期期间id
    	String perPeriodID=PeriodUtils.getPrePeriodInfo(curPeriodInfo).getId().toString();
    	String periodID=curPeriodInfo.getString("id");
		//插入期初养殖只数
		String dateFilter=" and to_char(fbizDate,'yyyy-MM-dd')='"+bizDateString+"'";
		
		//如果从第一天开始算，则全部重新计算
		if(isBeginFirst) {
			dateFilter=" and subStr(to_char(fbizDate,'yyyy-MM-dd'),0,7)='"+bizDateString.substring(0,7)+"'";
		}
		
		//删除当日的成本计算明细表
    	StringBuffer sql=new StringBuffer();
    	sql.append(" delete from T_FM_DayRateCostDetailDetail")
    	.append(" where fparentid in (")
    	.append(" select fid from T_FM_DayRateCostDetailEntry where fparentid in (")
    	.append(" select fid from T_FM_DayRateCostDetail where fcompanyid='").append(companyID).append("'")
    	.append(dateFilter)
    	.append(" )")
    	.append(" );")
    	.append(" delete from from T_FM_DayRateCostDetailEntry where fparentid in (")
    	.append(" select fid from T_FM_DayRateCostDetail where fcompanyid='").append(companyID).append("'")
    	.append(dateFilter)
    	.append(" );")
    	.append(" delete from T_FM_DayRateCostDetail where fcompanyid='").append(companyID).append("'")
    	.append(dateFilter)
    	;
    	DbUtil.execute(ctx, sql.toString());
		
		//临时表
		String tempTableName=TempTablePool.getInstance(ctx).createTempTableName();

		//临时表 -- 料的领用，领料出库单（料、药）
		sql.setLength(0);
		sql.append(" select tb.FControlUnitID FCompanyID,to_char(tmain.FbizDate,'yyyy-MM-dd') FbizDate,thouse.fid fhouseID,tmc.fid FCostItemID,tm.fid fmaterialid,")
    	.append(" tentry.funitid,tentry.fbaseunitid,tentry.fbaseQty,tentry.Fqty,tentry.FUnitActualCost,tentry.FActualCost,")
    	.append(" tentry.FCostObjectID,1 FbreedType,tb.fid FbatchID,0 FStatus")
    	.append(" into ").append(tempTableName)
    	.append(" from T_IM_MaterialReqBill tmain")
    	.append(" inner join T_IM_MaterialReqBillEntry tentry on tentry.fparentid=tmain.fid")
    	.append(" inner join t_bd_material tm on tm.fid=tentry.fmaterialID")
    	.append(" inner join t_bd_materialCost tmc on tmc.fmaterialid=tentry.fmaterialid")
		.append(" inner join CT_FM_LayEggDaily tbill on  tbill.fid=tmain.FSourcebillid ")//产蛋日报
		.append(" inner join CT_FM_LayEggDailyEntry tbillEntry on (tbillEntry.fparentid=tbill.fid and tbillEntry.fid=tentry.FSourceEntryID)")//产蛋日报分录
    	.append(" inner join  CT_FM_ParentBreedBatch tb on tbillEntryID.CFBreedBatchID=tb.fid ")
		.append(" inner join CT_FM_ParentBreedBatchEntry tbe on tbe.fparentid=tb.fid")
		.append(" inner join CT_FM_Henhouse thouse on thouse.fid=tbe.CFHenhouseID")
		.append(" where tb.FControlUnitID='").append(companyID).append("'");
		//从第一天开始
		if(isBeginFirst) {
			sql.append(" and tmain.FbizDate<={ts '").append(bizDateString).append(" 23:59:59'}")
			.append(" and to_char(tmain.FbizDate).subString(0,7)='").append(bizDateString.substring(0, 7));//当期月份1号至今天的业务日期
		}
		else{
			sql.append(" and to_char(tmain.FbizDate,'yyyy-MM-dd)='").append(bizDateString).append("'");
		}
		sql.append(");");
		//插入临时表--领料出库单（苗） 由批次推式生成
		sql.append(" union all");
		sql.append(" select tb.FControlUnitID FCompanyID,to_char(tmain.FbizDate,'yyyy-MM-dd') FbizDate,thouse.fid fhouseID,tmc.fid FCostItemID,tm.fid fmaterialid,")
    	.append(" tentry.funitid,tentry.fbaseunitid,tentry.fbaseQty,tentry.Fqty,tentry.FUnitActualCost,tentry.FActualCost,")
    	.append(" tentry.FCostObjectID,1 FbreedType,tb.fid FbatchID,0 FStatus")
    	.append(" from T_IM_MaterialReqBill tmain")
    	.append(" inner join T_IM_MaterialReqBillEntry tentry on tentry.fparentid=tmain.fid")
    	.append(" inner join t_bd_material tm on tm.fid=tentry.fmaterialID")
    	.append(" inner join t_bd_materialCost tmc on tmc.fmaterialid=tentry.fmaterialid")
    	.append(" inner join CT_FM_BreedBatch tb on tb.fid=tentry.fsourcebillid")
		.append(" inner join CT_FM_BreedBatchEntry tbe on (tbe.fparentid=tb.fid and tbe.fid=tentry.fsourceEntryID) ")
		.append(" inner join CT_FM_Henhouse thouse on thouse.fid=tbe.CFHenhouseID")
		.append(" where tb.FControlUnitID='").append(companyID).append("'");
		//从第一天开始
		if(isBeginFirst) {
			sql.append(" and tmain.FbizDate<={ts '").append(bizDateString).append(" 23:59:59'}")
			.append(" and to_char(tmain.FbizDate).subString(0,7)='").append(bizDateString.substring(0, 7));//当期月份1号至今天的业务日期
		}
		else{
			sql.append(" and to_char(tmain.FbizDate,'yyyy-MM-dd)='").append(bizDateString).append("'");
		}
		//创建临时表
		TempTablePool.getInstance(ctx).createTempTable(sql.toString());
		
		//插入转舍明细(在转入舍填写)
		//种苗对应物料、成本项目
		String seedMateiralID=bdsInfo.getSeedMateiral().getString("id");
		String seedCostItemID=bdsInfo.getSeedCostItem().getString("id");
		sql.setLength(0);
		//转出批次、舍，转入批次、舍，数量，物料，成本项目
		sql.append(" select tentry.CFFromBatchID,tentry.CFFromHenhouseID,tmain.CFHenhouseID,CFToHenhouseID,sum(CFTransHenQty+CFTransCockQty) FQty,")
		.append(" '").append(seedMateiralID).append("' FMaterialID,'").append(seedCostItemID).append("' FCostItemID,to_char(tmain.FBizDate,'yyyy-MM-dd') Fbizdate,")
		.append(" 0 FFromUnitCost,1 FbreedType,0 FStatus")//转出单位成本
		.append(" from CT_FM_LayEggDaily tmain")
		.append(" inner join CT_FM_LayEDTHE tentry on tentry.fparentid=tmain.fid")
		.append(" ")
		.append(" ")
		.append(" ")
		.append(" where tb.FControlUnitID='").append(companyID).append("'");
		//从第一天开始
		if(isBeginFirst) {
			sql.append(" and tmain.FbizDate<={ts '").append(bizDateString).append(" 23:59:59'}")
			.append(" and to_char(tmain.FbizDate).subString(0,7)='").append(bizDateString.substring(0, 7));//当期月份1号至今天的业务日期
		}
		else{
			sql.append(" and to_char(tmain.FbizDate,'yyyy-MM-dd)='").append(bizDateString).append("'");
		}
		sql.append(" group by  tentry.CFFromBatchID,tentry.CFFromHenhouseID,tmain.CFHenhouseID,CFToHenhouseID ");
		DbUtil.execute(ctx, sql.toString());
		
		//更新单位成本
		sql.setLength(0);
		//取期初余额
		sql.setLength(0);
		sql.append(" update tentry set tmain.FFromUnitCost=t2.FUnitCost")
		.append(" from ").append("temptable").append(" tmain ")
		.append(" inner join (")
		.append(" select FEndUnitCost from T_FM_DayRateCostDetailEntry tentryOld ")
		.append(" inner join T_FM_DayRateCostDetail tmainOld on tmainOld.fid=tentryOld.fparentID")
		.append(" where tmainOld.FCompanyID='").append(companyID).append("'")
		.append(" and tmainOld.FperiodID='").append(perPeriodID).append("'")
		.append(" and tmainOld.FbatchID=tmain.CFFromBatchID")
		.append(" and tmainOld.FOwnHenHouseID=tmain.CFFromHenhouseID")
		.append(" and tmainOld.FBreedType=tmain.FBreedType")
		.append(" ) ttemp on (ttemp.FCostItemID=tmain.FCostItemID)")
		.append(" where tmain.FcompanyID='").append("'").append("' and tmain.FStatus=0")
		.append(" and subStr(to_char(tmain.FbizDate,'yyyy-MM-dd'),9,2)='01'")//第一日
		.append(" and tmain.FPeriodID='").append(periodID).append("'")
		.append(" ;")
		//取上日成本
		.append(" update tentry set tmain.FbeginCost=")
		.append(" from ").append("temptable").append(" tmain ")
		.append(" inner join (")
		.append(" select FEndCost from T_FM_DayRateCostDetailEntry tentryOld ")
		.append(" inner join T_FM_DayRateCostDetail tmainOld on tmainOld.fid=tentryOld.fparentID")
		.append(" where tmainOld.FCompanyID='").append(companyID).append("'")
		.append(" and tmainOld.FperiodID='").append(periodID).append("'")
		.append(" and tmainOld.FbatchID=tmain.FBatchID")
		.append(" and tmainOld.FOwnHenHouseID=tmain.FOwnHenHouseID")
		.append(" and tmainOld.FBreedType=tmain.FBreedType")
		.append(" ) ttemp on (ttemp.FCostItemID=tentry.FCostItemID)")
		.append(" where tmain.FcompanyID='").append("'").append("' and tmain.FStatus=0")
		.append(" and subStr(to_char(tmain.FbizDate,'yyyy-MM-dd'),9,2)=!'01'")//非第一日
		.append(" and tmain.FPeriodID='").append(periodID).append("'")
		.append(" ;")
		.append(" ");
		DbUtil.execute(ctx, sql.toString());
		

    	//插入记录表头
    	sql.setLength(0);
    	sql.append(" /*dialecet*/ insert into T_FM_DayRateCostDetail (")
    	.append(" fid,FcompanyID,FbizDate,FperiodID,FBreedType,")
    	.append(" FCostCentorID,FOwnFarmID,FOwnhenhouseID,FbatchID,FWeek,")
    	.append(" FWeekDay,Fstatus)")
    	.append(" select distinct newbosid('18C12B75'),tdate.fday,'").append(periodID).append("',1,")
		.append(" thouse.CFCostCenterID,CFFarmID,thouse.fid,tb.fid,0,")
		.append(" 0,0")
		.append(" from CT_FM_ParentBreedBatch tb")
		.append(" inner join CT_FM_BreedStoorgSet tfarm on tfarm.fid=tb.CFFarmID")
		.append(" inner join CT_FM_ParentBreedBatchEntry tbe on tbe.fparentid=tb.fid")
		.append(" inner join CT_FM_Henhouse thouse on thouse.fid=tbe.CFHenhouseID")
//		.append(" inner join CT_FM_BroodDaily tmain on  tmain.CFBreedBatchID=tb.fid ")
		//获取日期列表
		.append(" inner join (SELECT TO_CHAR(TO_DATE('"+beginDateStr+"','YYYY-MM-dd')+ROWNUM-1  ,'YYYY-MM-dd') Fday from dual")
		.append(" CONNECT BY ROWNUM<=trunc(to_date('"+bizDateString+"', 'yyyy-mm-dd')-to_date('"+beginDateStr+"', 'yyyy-mm-dd'))+1) tdate on 1=1")
		.append(" where tb.FControlUnitID='").append(companyID).append("'")
		//尚未定栏--育成期  定栏日期<=业务日期或定栏日期为空
		.append(" and (tb.CFAdultDate is null or CFAdultDate<to_date('").append(bizDateString).append("','yyyy-MM-dd')+1");
    	//从第一天开始
//		if(isBeginFirst) {
//			sql.append(" and tmain.FbizDate<={ts '").append(bizDateString).append(" 23:59:59'}")
//			.append(" and to_char(tmain.FbizDate).subString(0,7)='").append(bizDateString.substring(0, 7));//当期月份1号至今天的业务日期
//		}
//		else{
//			sql.append(" and to_char(tmain.FbizDate,'yyyy-MM-dd)='").append(bizDateString).append("'");
//		}
		;
		DbUtil.execute(ctx, sql.toString());
		

		//更新期初养殖数量
    	updateInitBreedQty(ctx, companyID, periodID, perPeriodID);
    	//更新本期发生养殖数据
    	updateOccurBreedQty(ctx, companyID, periodID, perPeriodID);
		
		/**
		 * 插入分录
		 */
		sql.setLength(0);
		sql.append(" insert into T_FM_DayRateCostDetailEntry (")
		.append(" fid,fparentid,FCostItemID,FOccurCost")
		.append(" )")
		.append(" select newbosid('63E8CDFD'),tbill.fid,ttemp.FcostItemID,sum(ttemp.FActualCost)")
		.append(" from ").append(tempTableName).append(" ttemp")
		.append(" inner join T_FM_DayRateCostDetail tbill inner on (tbill.FCompanyID=ttemp.fcompanyID and tbill.fbizdate=ttemp.fbizDate and tbill.fbreedType=ttemp.fbreedtype and tbill.fbatchid=ttemp.fbatchid and tbill.fownhenhouseid=ttemp.fhouseid")
		.append(" where ttemp.fstatus=0")
		.append(" group by tbill.fid,ttemp.FcostItemID");
		DbUtil.execute(ctx, sql.toString());
		
		/**
		 * 插入明细
		 */
		sql.setLength(0);
		sql.append(" insert into T_FM_DayRateCostDetailDetail (")
		.append(" fid,fparentid,fbillID,FItemID,FCostObjectID,")
		.append(" FBaseUnitID,FUnitID,FBaseQty,FQty,FCost,FUnitCost")
		.append(" )")
		.append(" select newbosid('63E8CDFD'),tentry.fid,tentry.fparentid,ttemp.FMaterialID,tentry.FCostObjectID,")
		.append(" tentry.FBaseUnitID,tentry.FUnitID,sum(tentry.FBaseQty),sum(entry.FQty),sum(ttemp.FActualCost),avg(entry.FUnitActualCost)")
		.append(" from ").append(tempTableName).append(" ttemp")
		.append(" inner join T_FM_DayRateCostDetailEntry tEntry inner on (tentry.FCompanyID=ttemp.fcompanyID and tbill.fbizdate=ttemp.fbizDate and tbill.fbreedType=ttemp.fbreedtype and tbill.fbatchid=ttemp.fbatchid and tbill.fownhenhouseid=ttemp.fhouseid")
		.append(" where ttemp.fstatus=0")
		.append(" group by tbill.fid,ttemp.FcostItemID");
		DbUtil.execute(ctx, sql.toString());
		
		
		//删除临时表
		TempTablePool.getInstance(ctx).releaseTable(tempTableName);
		
    	
		//遍历更新期初
		sql.setLength(0);
		sql.append(" select to_char(tmain.FbizDate,'yyyy-MM-dd') FbizDate,to_char(tmain.FBizDate-1,'yyyy-MM-dd') FPerBizDate,tmain.fid fbillid,tentry.fid fentryid,tentry.FCostItemID")
		.append(" from T_FM_DayRateCostDetail tmain ")
		.append(" inner join T_FM_DayRateCostDetailEntry tentry on tentry.fparentid=tmain.fid")
		.append(" where tmain.FcompanyID='").append(companyID).append("'")
		.append(" and tmain.FStatus=0")
		.append(" order by tmain.FBatchID,tmain.FbizDate");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
		while(rs.next()) {
			//更新分录期初余额
			updateEntryInitBalance(ctx, companyID, rs.getString("FbizDate"),  rs.getString("FPerBizDate"),periodID,perPeriodID);
			//插入转舍明细及成本
			insertAndCalDetailTransUnitCost(ctx, companyID, rs.getString("FBatchID"), rs.getString("FHouseID"), rs.getString("FCostItemID"), rs.getString("FEntryID"),rs.getString("FbillID"), rs.getString("FbizDate"));
		}
		
		/**
		 * 更新发生及期末数量
		 */
		updateOccurAndBalance(ctx, companyID);
		/**
		 * 更新标识符为1
		 */
		DbUtil.execute(ctx, "update T_FM_DayRateCostDetail set FStatus=1 where FCompanyID='"+companyID+"' and FStauts=0");
    }
    
    /**
     * 插入及计算明细转舍成本
     * @param ctx
     * @param companyID
     * @param batchID
     * @param houseID
     * @param costItemID
     * @param entryID
     * @param bizDateStr
     * @throws Exception
     */
    private void insertAndCalDetailTransUnitCost(Context ctx,String companyID,String batchID,String houseID,String costItemID,String billID,String entryID,String bizDateStr) throws Exception {
    	StringBuffer sql=new StringBuffer();
    	sql.append(" insert into T_FM_DayRateCostDetail (")
    	.append(" fid,fparenti,fheadid")
    	.append(" )")
    	//转入--上期余额
    	.append(" select newbosid(''),'").append(entryID).append("','").append(billID).append("',ttemp.FQty,told.FEndUnitCost,'转入'")
    	.append(" from temptable").append(" ttemp")
    	.append(" inner join T_FM_DayRateInitBill told on (told.fownbatchid=ttemp.ftobatchid and told.fownhouse=ttemp.ftohouseid and told.fbizDate=ttemp.fbizdate-1)")
    	.append(" where told.fcompanyID='").append(companyID).append("'")
    	.append(" and sunString(to_char(").append(bizDateStr).append("','yyyy-MM-dd'),9,2)='01'")//第一日
    	.append(" union all")
    	//转入--上日余额
    	.append(" select newbosid('F4B2A0AE'),'").append(entryID).append("','").append(billID).append("',ttemp.FQty,told.FEndUnitCost,'转入'")
    	.append(" from temptable").append(" ttemp")
    	.append(" inner join T_FM_DayRateCostDetail told on (told.fownbatchid=ttemp.fbatchid and told.fownhouse=ttemp.fhouseid and told.fbizDate=ttemp.fbizdate-1)")
    	.append(" where told.fcompanyID='").append(companyID).append("'")
    	.append(" and sunString(to_char(").append(bizDateStr).append("','yyyy-MM-dd'),9,2)!='01'")//非第一日
    	.append(" ")
    	//转出--上期余额
    	.append(" select newbosid('F4B2A0AE'),'").append(entryID).append("','").append(billID).append("',(-1)*ttemp.FQty,told.FEndUnitCost,'转入'")
    	.append(" from temptable").append(" ttemp")
    	.append(" inner join T_FM_DayRateInitBill told on (told.fownbatchid=ttemp.ffrombatchid and told.fownhouse=ttemp.ffromhouseid and told.fbizDate=ttemp.fbizdate-1)")
    	.append(" where told.fcompanyID='").append(companyID).append("'")
    	.append(" and sunString(to_char(").append(bizDateStr).append("','yyyy-MM-dd'),9,2)='01'")//第一日
    	.append(" union all")
    	//转出--上日余额
    	.append(" select newbosid('F4B2A0AE'),'").append(entryID).append("','").append(billID).append("',(-1)*ttemp.FQty,told.FEndUnitCost,'转入'")
    	.append(" from temptable").append(" ttemp")
    	.append(" inner join T_FM_DayRateCostDetail told on (told.fownbatchid=ttemp.ffrombatchid and told.fownhouse=ttemp.ffromhouseid and told.fbizDate=ttemp.fbizdate-1)")
    	.append(" where told.fcompanyID='").append(companyID).append("'")
    	.append(" and sunString(to_char(").append(bizDateStr).append("','yyyy-MM-dd'),9,2)!='01'")//非第一日
    	.append(" ");
    	DbUtil.execute(ctx, sql.toString());
    }
    
    /**
     * 更新分录期初余额
     * @param ctx
     * @param companyID
     * @param bizDateString
     */
    private void updateEntryInitBalance(Context ctx,String companyID,String bizDateStr,String perBizDateStr,String periodID,String perPeriodID) throws Exception {

		StringBuffer sql=new StringBuffer();
    	//取期初余额--取上期末余额
		sql.append(" update tentry set tentry.FbeginCost=")
		.append(" from T_FM_DayRateCostDetailEntry tentry ")
		.append(" inner join T_FM_DayRateCostDetail tmain on tmain.Fid=tentry.Fparentid")
		.append(" inner join (")
		.append(" select FEndCost from T_FM_DayRateCostDetailEntry tentryOld ")
		.append(" inner join T_FM_DayRateCostDetail tmainOld on tmainOld.fid=tentryOld.fparentID")
		.append(" where tmainOld.FCompanyID='").append(companyID).append("'")
		.append(" and tmainOld.FperiodID='").append(perPeriodID).append("'")
		.append(" and tmainOld.FbatchID=tmain.FBatchID")
		.append(" and tmainOld.FOwnHenHouseID=tmain.FOwnHenHouseID")
		.append(" and tmainOld.FBreedType=tmain.FBreedType")
		.append(" ) ttemp on (ttemp.FCostItemID=tentry.FCostItemID)")
		.append(" where tmain.FcompanyID='").append("'").append("' and tmain.FStatus=0")
		.append(" and suString(to_char(tmain.FbizDate,'yyyy-MM-dd'),9,2)='01'")//第一日
		.append(" and tmain.FPeriodID='").append(periodID).append("'")
		.append(" ;")    	
		//更新期初成本 取上日余额
		.append(" update tentry set tentry.FbeginCost=")
		.append(" from T_FM_DayRateCostDetailEntry tentry ")
		.append(" inner join T_FM_DayRateCostDetail tmain on tmain.Fid=tentry.Fparentid")
		.append(" inner join (")
		.append(" select FEndCost from T_FM_DayRateInitBillEntry tentryOld ")
		.append(" inner join T_FM_DayRateInitBill tmainOld on tmainOld.fid=tentryOld.fparentID")
		.append(" where tmainOld.FCompanyID='").append(companyID).append("'")
		.append(" and tmainOld.FperiodID='").append(periodID).append("'")
		.append(" and to_char(tmainOld.FBizDate,'yyyy-MM-dd')='").append(perBizDateStr).append("'")
		.append(" and tmainOld.FbatchID=tmain.FBatchID")
		.append(" and tmainOld.FOwnHenHouseID=tmain.FOwnHenHouseID")
		.append(" and tmainOld.FBreedType=tmain.FBreedType")
		.append(" ) ttemp on (ttemp.FCostItemID=tentry.FCostItemID)")
		.append(" where tmain.FcompanyID='").append("'").append("' and tmain.FStatus=0")
		.append(" and suString(to_char(tmain.FbizDate,'yyyy-MM-dd'),9,2)!='01'")//非第一日
		.append(" and tmain.FPeriodID='").append(periodID).append("'")
		.append(" ;")
		;
		DbUtil.execute(ctx, sql.toString());
		
    }
    /**
     * 更新期末数量及余额
     * @param ctx
     * @param companyID
     * @throws BOSException
     */
    private void updateOccurAndBalance(Context ctx,String companyID) throws BOSException {
		//更新分录发生及期末余额
		StringBuffer sql=new StringBuffer();
		sql.append(" update tentry set tentry.FOccurCost=sum(tdetail.FOccurCost),tentry.FEndCost=tentry.FBeginCost-sum(tdetail.FCost)")
		.append(" from T_FM_DayRateCostDetailEntry tentry ")
		.append(" inner join T_FM_DayRateCostDetailDetail tdetail on tdetail.fparentid=tentry.fid")
		.append(" where tentry.fparentid in (")
		.append(" select fid from T_FM_DayRateCostDetail ")
		.append(" where fcompanyID='").append(companyID).append("'")
		.append(" and FStatus=0")
		.append(" )")
		.append(" ;")
		//更新单据头发生及余额
		.append(" update t1 set t1.FOccurCost=sum(t2.FOccurCost),t1.FEndCost=t1.FBeginCost-sum(t2.FOccurCost)")
		.append(" from T_FM_DayRateCostDetail t1 ")
		.append(" inner join T_FM_DayRateCostDetailEntry t2 on t2.fparentid=t1.fid")
		.append(" where FCompanyID='").append(companyID).append("'")
		.append(" and FStatus=0")
		.append(" ;")
		//更新单据头发生数量
		.append(" update t1 set t1.FOccurBreedQty=sum(t2.FQty),t1.fendBreedQty=t1.FOccurBreedQty-sum(t2.FQty)")
		.append(" from T_FM_DayRateCostDetail t1 ")
		.append(" inner join T_FM_DayRateCostDetail t2 on t2.fHeadID=t1.fid")
		.append(" where FCompanyID='").append(companyID).append("'")
		.append(" and FStatus=0")
		.append(" ;")
		//更新分录单位成本.append(" update t1.FEndUnitCost=t1.FEndCost/t2.FEndBreedQty")
		.append(" from T_FM_DayRateCostDetailEntry t1")
		.append(" inner join T_FM_DayRateCostDetail t2 on t2.fid=t1.fparentid")
		.append(" where FCompanyID='").append(companyID).append("'")
		.append(" and FStatus=0")
		.append(" ");
		DbUtil.execute(ctx, sql.toString());
    }
    
    /**
     * 更新期初养殖数量
     * @param ctx
     * @param companyID
     * @param bizDateStr
     * @param perBizDateStr
     * @throws Exception
     */
    private void updateInitBreedQty(Context ctx,String companyID,String periodID,String perPeriodID) throws Exception {
    	StringBuffer sql=new StringBuffer();
    	sql.append(" update t1  set t1.FBeginBreedQty=t2.FEndBreedQty")
    	.append(" from T_FM_DayRateCostDetail t1 ")
    	.append(" inner join T_FM_DayRateCostDetail t2 on (t2.FCompanyID=t1.FCompanyID and t2.FOwnHenhouseID=t1.FOwnHenhouseID and t2.FBatchID=t1.FBatchID and t2.FBreedType=t1.FBreedType)")
    	.append(" where t1.FcompanyID='").append("'").append("' and t1.FStatus=0")
		.append(" and to_char(t1.FbizDate,'yyyy-MM-dd').subString(8,2)!='01'")//非第一日
		.append(" and t1.FPeriodID='").append(periodID).append("'")
		.append(" and t2.FPeriodID='").append(perPeriodID).append("'")
    	.append(" ;")
    	.append(" update t1  set t1.FBeginBreedQty=t2.FEndBreedQty")
    	.append(" from T_FM_DayRateCostDetail t1 ")
    	.append(" inner join T_FM_DayRateInitBill t2 on (t2.FCompanyID=t1.FCompanyID and t2.FOwnHenhouseID=t1.FOwnHenhouseID and t2.FBatchID=t1.FBatchID and t2.FBreedType=t1.FBreedType)")
    	.append(" where t1.FcompanyID='").append("'").append("' and t1.FStatus=0")
		.append(" and to_char(t1.FbizDate,'yyyy-MM-dd').subString(8,2)='01'")//第一日
		.append(" and t1.FPeriodID='").append(periodID).append("'")
		.append(" and t2.FPeriodID='").append(perPeriodID).append("'")
		.append(" ;");
    	DbUtil.execute(ctx, sql.toString());
    }
    
    /**
     * 更新本期发生养殖数量
     * @param ctx
     * @param companyID
     * @param bizDateStr
     * @param perBizDateStr
     * @throws Exception
     */
    private void updateOccurBreedQty(Context ctx,String companyID,String periodID,String perPeriodID) throws Exception {
    	StringBuffer sql=new StringBuffer();
    	sql.append(" update t1  set t1.FBeginBreedQty=t2.FEndBreedQty")
    	.append(" from T_FM_DayRateCostDetail t1 ")
    	.append(" inner join T_FM_DayRateCostDetail t2 on (t2.FCompanyID=t1.FCompanyID and t2.FOwnHenhouseID=t1.FOwnHenhouseID and t2.FBatchID=t1.FBatchID and t2.FBreedType=t1.FBreedType)")
    	.append(" where t1.FcompanyID='").append("'").append("' and t1.FStatus=0")
		.append(" and to_char(t1.FbizDate,'yyyy-MM-dd').subString(8,2)!='01'")//非第一日
		.append(" and t1.FPeriodID='").append(periodID).append("'")
		.append(" and t2.FPeriodID='").append(perPeriodID).append("'")
    	.append(" ;")
    	.append(" update t1  set t1.FBeginBreedQty=t2.FEndBreedQty")
    	.append(" from T_FM_DayRateCostDetail t1 ")
    	.append(" inner join T_FM_DayRateInitBill t2 on (t2.FCompanyID=t1.FCompanyID and t2.FOwnHenhouseID=t1.FOwnHenhouseID and t2.FBatchID=t1.FBatchID and t2.FBreedType=t1.FBreedType)")
    	.append(" where t1.FcompanyID='").append("'").append("' and t1.FStatus=0")
		.append(" and to_char(t1.FbizDate,'yyyy-MM-dd').subString(8,2)='01'")//第一日
		.append(" and t1.FPeriodID='").append(periodID).append("'")
		.append(" and t2.FPeriodID='").append(perPeriodID).append("'")
		.append(" ;")
		//更新期末数量
    	.append(" update T_FM_DayRateCostDetail set FEndBreedQty=FBeginBreedQty-FOccurBreedQty")
    	.append(" where t1.FcompanyID='").append("'").append("' and t1.FStatus=0")
    	.append(" and t1.FPeriodID='").append(periodID).append("'")
    	.append(" ");
    	DbUtil.execute(ctx, sql.toString());
  
    }
	/**
	 * 计算苗、料、药
	 * @throws EASBizException 
	 */
	protected Object _exeCalBizData(Context ctx, Object param)	throws BOSException, EASBizException {
		//查询条件bean
		/*DayrateConditionBean conditonBean=(DayrateConditionBean) param;
		if(StringUtils.isEmpty(conditonBean.getCompanyID())) {
			throw new EASBizException(new NumericExceptionSubItem("001","组织不能为空！"));
		}
		if(StringUtils.isEmpty(conditonBean.getPeriodID())) {
			throw new EASBizException(new NumericExceptionSubItem("001","期间不能为空！"));
		}
		
		checkInit(ctx, conditonBean.getCompanyID());

		//根据期间获取日期范围
		Date[] dateRange=StockingComm.getDateRangeByPeriod(ctx, conditonBean.getCompanyID(), conditonBean.getPeriodID());
		if(dateRange==null) {
			throw new EASBizException(new NumericExceptionSubItem("001","尚未进行期间范围设置！"));
		}
		try {
			//批次临时表
			String batchTempTable=TempTablePool.getInstance(ctx).createTempTableName();
			
			StringBuffer sql=new StringBuffer();
			sql.append(" select distinct tbatch.fid fbatchID,tbatch.ffarmerid,tbatch.ffarmid,tbh.fhouseid ")
			.append(" into ").append(batchTempTable)
			.append(" from t_fm_stockingbatch tbatch")
			.append(" inner join t_fm_farm tfm on tfm.fid=tbatch.ffarmid")
			.append(" left  join T_FM_StockingBatchHouseEntry tbh on tbh.fparentid=tbatch.fid")
			.append(" where tbatch.fcompanyID='").append(conditonBean.getCompanyID()).append("'")
			.append(" and (tfm.FFarmType=").append(StockingFarmTypeEnum.COMPANY_VALUE)//公司自养
			.append(" or tfm.FFarmType=").append(StockingFarmTypeEnum.INVESTOR_VALUE).append(")")//股东自养
			.append(" and tbatch.fbaseStatus=").append(FarmBaseStatusEnum.ENABLE_VALUE)
			.append(" and exists (")
			//当前期间存在日报
			.append(" select 1 from T_FM_StockingBreedDaily td where td.fcompanyID='").append(conditonBean.getCompanyID()).append("'")
			.append(" and td.fbizDate>={d '").append(sdf.format(dateRange[0])).append("'}")
			.append(" and td.fbizDate<={d '").append(sdf.format(dateRange[1])).append("'}")
			.append(" and td.CFStockingBatchID=tbatch.fid")
			.append(" )")
			.append(" ");
			DbUtil.execute(ctx, sql.toString());
			
			//成本余额临时表--表体
			String costEntryTempTable=TempTablePool.getInstance(ctx).createTempTableName();
			sql.setLength(0);
			sql.append(" select * into ").append(costEntryTempTable)
			.append(" from T_FM_DayRateInitBillEntry ")
			.append(" where 1=0");
			DbUtil.execute(ctx, sql.toString());
			
			//临时表bean
			TempTableBean bean=new TempTableBean(ctx);
//			bean.setBatchTable(batchTempTable);
//			bean.setCostEntryTable(costEntryTempTable);
			
			//删除批次临时表
			TempTablePool.getInstance(ctx).releaseTable(batchTempTable);
			//删除成本余额临时表--表体
			TempTablePool.getInstance(ctx).releaseTable(batchTempTable);
		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.getMessage()));
		}
		*/
		return null;
	}
	/**
	 * 成本计算临时表
	 * @author dai_andong
	 *
	 */
	private class TempTableBean {
		private Context ctx;
		private TempTablePool is;
		private String batchTable;
		private String costTable;
		private String costEntryTable;//成本数据记录表
		private String bizDataDetailTable;//业务数据记录表
		public String getCostEntryTable() {
			return costEntryTable;
		}
		public String getBizDataDetailTable() {
			return bizDataDetailTable;
		}
		public TempTableBean(Context ctx) {
			this.ctx=ctx;
			is=TempTablePool.getInstance(ctx);
		}
		/**
		 * 创建表
		 * @throws Exception
		 */
		public void initTable() throws Exception{
			bizDataDetailTable=is.createTempTableName();
			StringBuffer sql=new StringBuffer();
			sql.append(" create table ").append(bizDataDetailTable).append(" (")
			.append(" breedStage int  defalut 0,")//养殖阶段
			.append(" bizDate datetime,")
			.append(" matureDate dateTime,")//定群时间
			.append(" batchid varchar(60),")
			.append(" houseid varchar(60),")
			.append(" lastStockQty int  defalut 0,")
			.append(" lastFemaleStockQty int  defalut 0,")
			.append(" allEggQty int  defalut 0,")
			.append(" unitEggQty int  defalut 0,")
			.append(" sumAllEggQty int  defalut 0,")//累计总产蛋量
			.append(" sumUnitEggQty int  defalut 0,")//累计只均产蛋量
			.append(" status int defalut 0")
			.append(" )")
			.append(" ");
			is.createTempTable(sql.toString());
			
			costEntryTable=is.createTempTableName();
			sql=new StringBuffer();
			sql.append(" create table ").append(costEntryTable).append(" (")
			.append(" breedStage int  defalut 0,")//养殖阶段
			.append(" batchid varchar(60),")
			.append(" houseid varchar(60),")
			.append(" costitemID varchar(60),")
			.append(" materialid varchar(60),")
			.append(" unitid varchar(60),")
			.append(" qty decimal(20,5)  defalut 0,")
			.append(" unitActualCost decimal(20,5)  defalut 0,")
			.append(" actualCost decimal(20,5)  defalut 0,")
			.append(" arPrice decimal(20,5)  defalut 0,")
			.append(" arAmount decimal(20,5) default 0,")
			.append(" status int defalut 0")
			.append(" )")
			.append(" ");
			is.createTempTable(sql.toString());
		}
		
		/**
		 * 释放表
		 */
		public void releaseTable() {
			is.releaseTable(bizDataDetailTable);
			is.releaseTable(costEntryTable);
		}
	
	}
	/**
	 * 计算产蛋期成本
	 * @param ctx
	 * @param companyID
	 * @param periodID
	 * @param beginDateStr
	 * @param endDateStr
	 * @throws EASBizException
	 */
	private void calEggsCost(Context ctx,String companyID,String periodID,String beginDateStr,String endDateStr) throws Exception {
		//结算单校验
		checkCalData(ctx, companyID, periodID);
		
	/*	//成本余额临时表--表体
		String costEntryTempTable=TempTablePool.getInstance(ctx).createTempTableName();
		StringBuffer sql=new StringBuffer();
		sql.append(" select * into ").append(costEntryTempTable)
		.append(" from T_FM_DayRateInitBillEntry ")
		.append(" where 1=0");
		DbUtil.execute(ctx, sql.toString());*/
		
		//临时表bean
		TempTableBean tableBean=new TempTableBean(ctx);
		tableBean.initTable();
		
		//计算苗、料、药 领料成本
		calDailyMaterialReqCostData(ctx, companyID, beginDateStr, endDateStr, tableBean);
		//计算苗、料、药应收金额
		calDailyMaterialReqArData(ctx, companyID, beginDateStr, endDateStr, tableBean);
		
		//设置费用分摊数据
		setFeeAllocationData(ctx, companyID, periodID, beginDateStr, endDateStr, tableBean);
		//设置生物资产折旧信息
		setFACurData(ctx, companyID, periodID, beginDateStr, endDateStr, tableBean);
		//设置业务数据 设置育成期冲回数据
		setBreedData(ctx, companyID, periodID, beginDateStr, endDateStr, tableBean);
		//设置种蛋结算信息--应付款
		setEggPaymentData(ctx, companyID, periodID, beginDateStr, endDateStr, tableBean);
		//设置结算奖惩信息--应付
		setSettleBillData(ctx, companyID, periodID, beginDateStr, endDateStr, tableBean);
		
		//处理临时表数据并生成成本计算记录
		dealTempDataAndCreateToCostRecord(ctx, companyID, periodID, beginDateStr, endDateStr, tableBean);
		
		tableBean.releaseTable();
	}
	/**
	 * 检查结算单、固定资产项目
	 * @param ctx
	 * @param companyID
	 * @param periodID
	 * @throws BOSException
	 * @throws EASBizException
	 * @throws SQLException
	 */
	private void checkCalData(Context ctx,String companyID,String periodID) throws BOSException, EASBizException, SQLException {
		StringBuffer sql=new StringBuffer();
		sql.append(" select count(*) fcount")
		.append(" from T_FM_StatementsBill tbill")
		.append(" where tbill.fcompanyID='").append(companyID).append("'")
		.append(" and tbill.fperiodid='").append(periodID).append("'")
		.append(" and tbill.fbillStatus=").append(BillBaseStatusEnum.AUDITED_VALUE);
		IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
		if(rs.next()&&rs.getInt("fcount")<=0) {
			throw new EASBizException(new NumericExceptionSubItem("001","尚未进行养殖结算!"));
		}
		sql.setLength(0);
		sql.append(" select count(*) fcount")//FDepreTerm本期折旧
		.append(" from T_FA_FaAccountBalance tbal")//固定资产余额表
		.append(" inner join T_FA_FaCurCard tcard on tcard.fid=tbal.FFaCurCardID")//固定资产卡片
		.append(" where tbal.FCompanyOrgUnitID='").append(companyID).append("'")
		.append(" and tbal.fperiodid='").append(periodID).append("'")
		.append(" ");
		 rs=DbUtil.executeQuery(ctx, sql.toString());
		if(rs.next()&&rs.getInt("fcount")<=0) {
			throw new EASBizException(new NumericExceptionSubItem("001","尚未进行生物资产折旧计算!"));
		}
	}
	
    /**
     * 计算苗、料、药 领料成本
     * @param ctx
     * @param conditonBean
     * @throws EASBizException 
     */
	private void calDailyMaterialReqCostData(Context ctx,String companyID,String beginDateStr,String endDateStr,TempTableBean tableBean) throws EASBizException {
		try {
			//获取采购入库单成本 需要在采购入单添加种苗领用单id 分录id
			StringBuffer sql=new StringBuffer();
			sql.append(" insert into ").append(tableBean.getCostEntryTable()).append("(")
			.append(" batchID,houseid,costitemid,materialid,unitid,unitActualCost,settleType")
			.append(" )");
			//插入料、药、数量
			sql.append(" select fstockingbatchid,fhouseid,FDefaultCostItemID,fmaterialid,funitid,sum(FQty) FQty,0 FUnitActualCost,0 FActualCost, from (");
			//料
			sql.append(" select tbill.fstockingbatchid,tentry.fhouseid,tm.FDefaultCostItemID,tentry.fmaterialid,tentry.funitid,isnull(CFDailyQtyAll,0)+isnull(FFemaleDailyQty) FQty ")
			.append(" from T_FM_StockingBreedDaily tbill")
			.append(" inner join T_FM_StockingBreedDailyEntry tentry on tentry.fparentid=tbill.fid")
			.append(" inner join T_BD_MaterialCost tm on tm.fmaterialid=tentry.FMaterialID")
			.append(" where tbilll.fcompanyid='").append(companyID).append("'")
			.append(" and tbill.fbizDate>={d '").append(beginDateStr).append("'")
			.append(" and tbill.fbizDate<={d '").append(endDateStr).append("'")
			.append(" and tbill.cfbasestatus=").append(BillBaseStatusEnum.AUDITED_VALUE)
			.append(" union all")
			//药
			.append(" select tbill.fstockingbatchid,tentry.fhouseid,tm.FDefaultCostItemID,tentry.CFVaccineMaterialI fmaterialid,tentry.CFVaccineUnit funitid,isnull(CFVaccineGetQty,0) FQty ")//CFVaccineUsedQty
			.append(" from T_FM_StockingBreedDaily tbill")
			.append(" inner join T_FM_StockingBDIE tentry on tentry.fparentid=tbill.fid")
			.append(" inner join T_BD_MaterialCost tm on tm.fmaterialid=tentry.FMaterialID")
			.append(" where tbill.fcompanyid='").append(companyID).append("'")
			.append(" and tbill.fbizDate>={d '").append(beginDateStr).append("'")
			.append(" and tbill.fbizDate<={d '").append(endDateStr).append("'")
			.append(" and tbill.cfbasestatus=").append(BillBaseStatusEnum.AUDITED_VALUE)
			.append(" ");
			sql.append(" ) ttemp group by fstockingbatchid,fhouseid,FDefaultCostItemID,fmaterialid,funitid");
			DbUtil.execute(ctx, sql.toString());
			
			//领料出库单---更新实际成本
			sql.append(" update ").append(tableBean.getCostEntryTable()).append(" t1 ").append(" set t1.FUnitActualCost=")
			.append(" select avg(tEntry.FUnitActualCost) FUnitActualCost")
			.append(" from T_IM_MaterialReqBill tbill")
			.append(" inner join T_IM_MaterialReqBillEntry tentry on tentry.fparentid=tbill.fid")
			.append(" inner join T_BD_MaterialCost tm on tm.fmaterialid=tmbillEntry.FMaterialID")
			.append(" where tbill.FCompanyID='").append(companyID).append("'")
			.append(" and tbill.FBillStatus=4")
			.append(" and tbill.FbizDate>={d '").append(beginDateStr).append("'}")
			.append(" and tbill.FbizDate<({d '").append(endDateStr).append("'}+1)")
			.append(" and tm.FDefaultCostItemID=t1.FDefaultCostItemID and t1.FmaterialID=tentry.fmaterialid and t1.funitID=tentry.funitID")
			.append(" group by tm.FDefaultCostItemID,tentry.fmaterialid,tentry.funitid;")
			.append(" update ").append(tableBean.getCostEntryTable()).append(" set FActualCost=FUnitActualCost*Fqty;")
			;
			DbUtil.execute(ctx, sql.toString());
		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.getMessage()));
		}
	}
	
	/**
     * 计算苗、料、药 应收金额
     * @param ctx
     * @param conditonBean
     * @throws EASBizException 
     */
	private void calDailyMaterialReqArData(Context ctx,String companyID,String beginDateStr,String endDateStr,TempTableBean tableBean) throws EASBizException {
		try {
			//通过饲料用单单取价格--尚未使用
			StringBuffer sql=new StringBuffer();
			sql.append(" select tentry.fstockingbatchid,tentry.")
			.append(" from T_FM_FodderReceiveBill tmain")
			.append(" inner join T_FM_FodderReceiveBillEntry tentry on tentry.fparentid=tmain.fid")
			.append(" where tmain.fcompanyid='").append(companyID).append("'")
			.append(" and tmain.fbizdate>={d '").append(beginDateStr).append("'}")
			.append(" and tmain.fbizDate<{d '").append(endDateStr).append("'")
			.append(" and fbillStatus=4")
			.append(" ");
			
			//通过结算政策取应收金额
			sql.setLength(0);
			sql.append(" update ").append(tableBean.getCostEntryTable()).append(" t1 set t1.arPrice=(")
			.append(" ttemp.fbaseprice")
			.append(" select * from (");
			sql.append(" select distinct tpe.materialID,tpe.FBasePrice")
			.append(" from ").append(tableBean.getCostEntryTable()).append(" ttemp")
			.append(" inner join t_fm_stockingbatch tb on tb.fid=ttemp.batchid")
			.append(" inner join t_fm_batchContract tc on tb.FBatchContractID=tc.fid")
			.append(" inner join T_FM_StatementsPolicy tp on tp.fid=tc.FSettlementPolicyI")
			.append(" inner join T_FM_StatementsPPE tpe on (tpe.fparentid=tp.fid and ttemp.FMaterialID)")
			.append(" ) t2 on t2.fmaterialid=t1.mateiralid")
			.append(" )")
			.append(" where exists (")
			.append(" select 1 from t_fm_stockingbatch tb where tb.fid=t1.batchid and tb.fbatchcontractid is not null and tb.fbatchcontractid!=''")
			.append(" )")
			.append(" ;")
			.append(" update ").append(tableBean.getCostEntryTable()).append(" set armount=fqty*arprice;");
			DbUtil.execute(ctx, sql.toString());
			;
			
		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.getMessage()));
		}
	}
	
	/**
	 * 设置固定资产信息
	 * @param ctx
	 * @param companyID
	 * @param beginDateStr
	 * @param endDateStr
	 * @param tableBean
	 * @throws EASBizException 
	 */
	private void setFACurData(Context ctx,String companyID,String periodID,String beginDateStr,String endDateStr,TempTableBean tableBean) throws EASBizException{
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" insert into ").append(tableBean.getCostEntryTable()).append("(")
			.append(" batchid,houseid,cositemid,factualCost,fstatus")
			.append(" )")
			.append(" select tbal.cfstockingbatchid,tbal.cfhouseid,FDepreTerm,0")//FDepreTerm本期折旧
			.append(" from T_FA_FaAccountBalance tbal")//固定资产余额表
			.append(" inner join T_FA_FaCurCard tcard on tcard.fid=tbal.FFaCurCardID")//固定资产卡片
			.append(" where tbal.FCompanyOrgUnitID='").append(companyID).append("'")
			.append(" and tbal.fperiodid='").append(periodID).append("'")
			.append(" ");
			DbUtil.execute(ctx, sql.toString());
		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.getMessage()));
		}
	}
	
	/**
	 * 设置费用分摊数据
	 * @param ctx
	 * @param companyID
	 * @param periodID
	 * @param beginDateStr
	 * @param endDateStr
	 * @param tableBean
	 * @throws EASBizException
	 */
	private void setFeeAllocationData(Context ctx,String companyID,String periodID,String beginDateStr,String endDateStr,TempTableBean tableBean) throws EASBizException{
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" insert into ").append(tableBean.getCostEntryTable()).append("(")
			.append(" batchid,houseid,cositemid,factualCost,fstatus")
			.append(" )");
			sql.append(" select tdetail.fstockingbatchid,tdetail.fhouseid,sum(FAlloctionAmount) FAmount,1")
			.append(" from T_FM_CostAllocation tmain")
			.append(" inner join T_FM_CostAllocationEntry tentry on tentry.fparentid=tmain.fid")
			.append(" inner join T_FM_CostAllocationDetail tdetail on tdetail.fparentid=tentry.fid")
			.append(" where tmain.fcompanyid='").append(companyID).append("'")
			.append(" and tmain.fperiodid='").append(periodID).append("'")
			.append(" and tmain.fbillStatus=").append(BillBaseStatusEnum.AUDITED_VALUE)
			;
			DbUtil.execute(ctx, sql.toString());
		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.getMessage()));
		}
	}
	
	/**
	 * 设置育成期冲回数据
	 * @param ctx
	 * @param companyID
	 * @param periodID
	 * @param beginDateStr
	 * @param endDateStr
	 * @param tableBean
	 * @throws EASBizException    
	 */
	private void setBreedData(Context ctx,String companyID,String periodID,String beginDateStr,String endDateStr,TempTableBean tableBean) throws EASBizException {
		try {
			//期间内总产蛋数
			StringBuffer sql=new StringBuffer();
			sql.append(" insert into ").append(tableBean.getBizDataDetailTable()).append("(")
			.append(" bizDate,matureDate,batchid,houseid,alleggQty,status")
			.append(" )");
			sql.append(" select tmain.fbizDate,tb.FmatureDate,tmain.cfstockingbatchid,isnull(tentry.fhouseid,'') FhouseID,sum(tentry.fallQty) FQty,99")
			.append(" from T_FM_StockingBreedDaily tmain ")
			.append(" inner join t_fm_stockingBatch tb on tb.fid=tmain.cfstockingbatchid")
			.append(" inner join T_FM_StockingBDEE tentry on tentry.fparentid=tmain.fid")
			.append(" where tmain.fcompanyid='").append(companyID).append("'")
			.append(" and tbill.fbizDate>={d '").append(beginDateStr).append("'}")
			.append(" and tbill.fbizDate<={d '").append(endDateStr).append("'}")
			.append(" and tbill.fbizDate>=tb.FmatureDate")//大于等于定群日期---产蛋期
			.append(" group by tmain.fbizDate,tmain.cfstockingbatchid,tentry.fhouseid");
			DbUtil.execute(ctx, sql.toString());
			
			//更新单只母禽产蛋量----该过程周期较长
			StringBuffer str=new StringBuffer();
			IRowSet rs=DbUtil.executeQuery(ctx, " select to_char(FbizDate,'yyyy-MM-dd'),batchID,houseID from "+tableBean.getBizDataDetailTable()+"' ");
			int[] lastStock;
			while(rs.next()) {
				//最后存栏数
				lastStock=DayrateUtils.getStockingLastStockBoth(ctx, companyID, rs.getString("bizDate"), rs.getString("batchID"), rs.getString("houseID"), DayrateUtils.LastStockCountType_Female);
				
				str.append("update ").append(tableBean.getBizDataDetailTable()).append(" set lastFemaleStockQty=").append(lastStock[0])
				.append(",lastFemaltStockQty=").append(lastStock[1])
				.append(" where batchid='").append( rs.getString("batchID")).append("' and bizDate='").append(rs.getString("bizDate")).append("'")
				.append(" and houseid='").append(rs.getString("houseID")).append("';");
			}
			DbUtil.execute(ctx, str.toString());
			
			//插入合计
			sql.setLength(0);
			sql.append(" insert into ").append(tableBean.getBizDataDetailTable()).append("(")
			.append(" batchID,houseID,lastStockQty,lastFemaltStockQty,allEggQty,status")
			.append(" )")
			.append(" select batchID,houseID,sum(lastStockQty,0),sum(lastFemaltStockQty,0),sum(allEggQty,0),1")
			.append(" from ").append(tableBean.getBizDataDetailTable())
			.append(" group by batchID,houseID")
			.append(" ;")
			.append(" delete from ").append(tableBean.getBizDataDetailTable()).append(" where status=0;")
			// 更新只均产蛋量
			.append(" update ").append(tableBean.getBizDataDetailTable()).append(" set unitEggQty=alleggQty/lastFemaleStockQty").append(";");
			DbUtil.execute(ctx, sql.toString());
			
			String prePeroidID=PeriodUtils.getPrePeriodInfo(new ObjectUuidPK(periodID)).getString("id");
			DayRateBaseSettingInfo bdInfo = DayrateUtils.getBaseSetting(ctx, companyID);
			int fullWorkQty=bdInfo.getFullWorkQty();//最高工作量
			
			//更新累计产蛋数
			sql.setLength(0);
			sql.append(" update ").append(tableBean.getBizDataDetailTable()).append(" t1 ")
			.append(" set (sumAllEggQty,sumUnitEggQty)=")
			.append(" select isnull(FSumWorkQty,0),isnull(FAvgSumWorkQty,0)")
			.append(" from T_FM_DayRateInitBill t2")
			.append(" where t2.fcompanyID='").append(companyID).append("'")
			.append(" and t2.fperiodid='").append(prePeroidID).append("'")
			.append(" and t2.fstockingbatchid=t1.batchid")
			.append(" and (t2.fhouseid='' or t2.fhouseid is null)")
			.append(" and (t1.houseid='' or t1.1houseid is null)")
			.append(" and if exists (")
			.append(" select 1 from T_FM_DayRateInitBill t3 ")
			.append(" where t3.fcompanyID='").append(companyID).append("'")
			.append(" and t3.fperiodid='").append(prePeroidID).append("'")
			.append(" and t3.fstockingbatchid=t1.batchid")
			.append(" )")
			.append(" ;")
			.append(" update ").append(tableBean.getBizDataDetailTable()).append(" t1 ")
			.append(" set (sumAllEggQty,sumUnitEggQty)=")
			.append(" select isnull(FSumWorkQty,0),isnull(FAvgSumWorkQty,0)")
			.append(" from T_FM_DayRateInitBill t2")
			.append(" where t2.fcompanyID='").append(companyID).append("'")
			.append(" and t2.fperiodid='").append(prePeroidID).append("'")
			.append(" and t2.fstockingbatchid=t1.fid")
			.append(" and t2.fhouseid=t1.houseid")
			.append(" and (t2.fhouseid!='' and t2.fhouseid is not null)")
			.append(" and (t1.houseid!='' and t1.houseid is not null)")
			.append(" and if exists (")
			.append(" select 1 from T_FM_DayRateInitBill t3 ")
			.append(" where t3.fcompanyID='").append(companyID).append("'")
			.append(" and t3.fperiodid='").append(prePeroidID).append("'")
			.append(" and t3.fstockingbatchid=t1.batchid")
			.append(" and t3.fhouseid=t1.houseid")
			.append(" )")
			.append(" ;")
			//更新累计单只产蛋数
			.append(" update ").append(tableBean.getBizDataDetailTable()).append(" set ")
			.append(" sumAllEggQty=isnull(sumAllEggQty,0)+isnull(alleggQty,0)),")
			.append(" sumUnitEggQty=(sumUnitEggQty,0)+isnull(unitEggQty,0),")
			.append(" where fcompanyID='").append(companyID).append("'")
			.append(" and fperiodid='").append(prePeroidID).append("'")
			.append(" update ").append(tableBean.getBizDataDetailTable()).append(" set sumUnitEggQty=0 where sumUnitEggQty<0");
			DbUtil.execute(ctx, sql.toString());
			
			//插入结算项目明细--分摊明细
			sql.setLength(0)
			;
			sql.append(" insert into ").append(tableBean.getCostEntryTable()).append(" (")
			.append(" batchid,houseid,costitemid,actualcost,fstatus")
			.append(" )")
			.append(" select ttemp.batchid,ttemp.fhouseid,null,")
			//当剩余只产蛋量（剩余工作量）<当前产蛋量时，
//			#####冲销金额=(工作量-已使用工作量)/工作量*未冲销金额；
//			冲销金额=总应收金额-未分摊金额；
//			否则，冲销金额=当期工作量/工作量*未冲销金额
			.append(" case when tmain.sumUnitEggQty>").append(fullWorkQty).append(" then tmain.FAllArAmount-tmain.FUnOffSetAmount")
			.append(" else tmain.FUnOffSetAmount*ttemp.unitEggQty/").append(fullWorkQty).append("end factualCost,3")
//			.append(" tmain.FUnOffSetAmount*ttemp.unitEggQty/").append(fullWorkQty).append("end factualCost,3")
			.append(" from ").append(tableBean.getBizDataDetailTable()).append(" ttemp")
			.append(" inner T_FM_DayRateCostDetail tmain on tmain.fstockingbatch=ttemp.batchid")
			.append(" where tmain.fcompayid='").append(companyID).append("'")
			.append(" and tmain.FIsStageBalance=1")//结算结算余额
			.append(" and tmain.FBreedStage=").append(FarmStageEnum.BREED_VALUE)//育成期
//			.append(" and tmain.fperodID='").append(prePeroidID).append("'")
			.append(" and tmain.FUnOffSetAmount>0")
			.append(" and (t2.fhouseid='' or t2.fhouseid is null)")
			.append(" and (t1.fhouseid='' or t2.fhouseid is null)")
			.append(" union all")
			.append(" select ttemp.batchid,ttemp.fhouseid,null,")
			.append(" case when tmain.sumUnitEggQty>").append(fullWorkQty).append(" then tmain.FAllArAmount-tmain.FUnOffSetAmount")
			.append(" else tmain.FUnOffSetAmount*ttemp.unitEggQty/").append(fullWorkQty).append("end factualCost,1")
			.append(" from ").append(tableBean.getBizDataDetailTable()).append(" ttemp")
			.append(" inner T_FM_DayRateCostDetail tmain on (tmain.fstockingbatch=ttemp.batchid and tmain.fhouseid=ttemp.houseid)")
			.append(" where tmain.fcompayid='").append(companyID).append("'")
			.append(" and tmain.FIsStageBalance=1")//结算结算余额
			.append(" and tmain.FBreedStage=").append(FarmStageEnum.BREED_VALUE)//育成期
//			.append(" and tmain.fperodID='").append(prePeroidID).append("'")
			.append(" and tmain.FUnOffSetAmount>0")
			.append(" and (t2.fhouseid!='' and t2.fhouseid is not null)")
			.append(" and (t1.fhouseid!='' and t2.fhouseid is not null)")
			.append(" ;")
			//更新负数成本为0
			.append(" update ").append(tableBean.getCostEntryTable()).append(" set actualcost=0 where actualcost<0 and status=3;");
			DbUtil.execute(ctx, sql.toString());
			
		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.getMessage()));
		}
	}
	
	/**
	 * 设置种蛋结算信息--应付款 
	 * @param ctx
	 * @param companyID
	 * @param periodID
	 * @param beginDateStr
	 * @param endDateStr
	 * @param tableBean
	 * @throws EASBizException
	 */
	private void setEggPaymentData(Context ctx,String companyID,String periodID,String beginDateStr,String endDateStr,TempTableBean tableBean) throws EASBizException {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" inser into ").append(tableBean.getCostEntryTable()).append(" (")
			.append(" batchID,houseiD,costItemID,FActualCost,fstatus")
			.append(" )");
			sql.append(" select tentry.fstockingbatchid,tentry.fhouseid,null,sum(tentry.famount) famount,1")
			.append(" from T_FM_EggSettleBill tbill")
			.append(" inner join T_FM_EggSettleBillEntry tentry on tentry.FparentID=tbill.fid")
			.append(" left join T_FM_SettlementItem tsi on tsi.fid=tentry.fsettleitemid")
			.append(" where tbill.FCompanyID='").append(companyID).append("'")
			.append(" and tbill.FEggSource=").append(EggSourceType.SUBCONTRACT_VALUE)//放养
			.append(" and tbill.FBillStatus=4")
			.append(" and tbill.FbizDate>={d '").append(beginDateStr).append("'}")
			.append(" and tbill.FbizDate<({d '").append(endDateStr).append("'}+1)")
			.append(" group by tentry.fstockingbatchid,tentry.fhouseid")
			.append(" ");
			DbUtil.execute(ctx, sql.toString());
		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.getMessage()));
		}
	}
	
	/**
	 * 设置结算单信息--奖惩金额、活禽回收金额
	 * @param ctx
	 * @param companyID
	 * @param periodID
	 * @param beginDateStr
	 * @param endDateStr
	 * @param tableBean
	 * @throws EASBizException
	 */
	private void setSettleBillData(Context ctx,String companyID,String periodID,String beginDateStr,String endDateStr,TempTableBean tableBean) throws EASBizException {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select tbill.ffarmerid,tbill.ffarmid,tbill.fstockingbatchid,FBirdsAmount,FAwardsAmount,FSubsidyAmount")//活禽回收金额，奖惩金额、补贴金额
			.append(" from T_FM_StatementsBill tbill")
			.append(" where tbill.fcompanyID='").append(companyID).append("'")
			.append(" and tbill.fperiodid='").append(periodID).append("'")
			.append(" and tbill.fbillStatus=").append(BillBaseStatusEnum.AUDITED_VALUE)
			.append(" ");
			DbUtil.execute(ctx, sql.toString());
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**处理临时表数据并生成成本计算记录
	 * @param ctx
	 * @param companyID
	 * @param periodID
	 * @param beginDateStr
	 * @param endDateStr
	 * @param tableBean
	 * @throws EASBizException
	 * @throws SQLException 
	 */
	private void dealTempDataAndCreateToCostRecord(Context ctx,String companyID,String periodID,String beginDateStr,String endDateStr,TempTableBean tableBean) throws EASBizException, SQLException {
		Connection conn = EJBFactory.getConnection(ctx);
		conn.setAutoCommit(false);
		try {
			//插入表头
			StringBuffer sql=new StringBuffer();
			sql.append(" insert into T_FM_DayRateInitBill (")
			.append(" fid,fbizDate,fbillstatus,fcompanyID,Fperiodid,")
			.append(" ffarmerID,ffarmID,fhouseID,FStockingBatchID,FBreedStage")
			.append(" )")
			.append(" select distinct newbosid('8E080BEE'),now(),4,'").append(companyID).append("','").append(periodID).append("',")
			.append(" tb.ffarmerid,tb.ffarmid,ttemp.fhouseid,tb.fid,").append(FarmStageEnum.EGGS_VALUE)
			.append(" from ").append(tableBean.getCostEntryTable()).append(" ttemp")
			.append(" inner join t_fm_stockingbatch tb on tb.fid=ttemp.batchID")
			.append(" where status=1");
//			DbUtil.execute(ctx, sql.toString());
			conn.createStatement().execute(sql.toString());
			
			//插入分录
			sql.setLength(0);
			sql.append(" insert into T_FM_DayRateInitBillEntry (")
			.append(" fid,FCostItem,FOccurQty,FOccurCost,FArAmount,")
			.append(" fparentid")
			.append(" )")
			.append(" select newbosid('56685124'),ttemp.costItemID,sum(ttemp.qty),sum(ttemp.actualQty),sum(ttemp.arAmount),")
			.append(" tmain.fid")
			.append(" from ").append(tableBean.getCostEntryTable()).append(" ttemp")
			.append(" inner join T_FM_DayRateInitBill tmain on (tmain.fstockingid=ttemp.batchid and tmain.fhouseid=ttemp.houseid)")
			.append(" where tmain.fcompanyID='").append(companyID).append("'")
			.append(" and tmain.fperiodid='").append(periodID).append("'")
			.append(" and (ttemp.houseid!='' and ttemp.houseid is not null)")
			.append(" and (tmain.houseid!='' and tmain.houseid is not null)")
			.append(" where status=1")
			.append(" union all")
			.append(" select newbosid('56685124'),ttemp.costItemID,sum(ttemp.qty),sum(ttemp.actualQty),sum(ttemp.arAmount),")
			.append(" tmain.fid")
			.append(" from ").append(tableBean.getCostEntryTable()).append(" ttemp")
			.append(" inner join T_FM_DayRateInitBill tmain on (tmain.fstockingid=ttemp.batchid and tmain.fhouseid=ttemp.houseid)")
			.append(" where tmain.fcompanyID='").append(companyID).append("'")
			.append(" and tmain.fperiodid='").append(periodID).append("'")
			.append(" and (ttemp.houseid='' or ttemp.houseid is null)")
			.append(" and (tmain.houseid='' or ttemp.houseid is null)")
			.append(" where status=1")
			.append(" ");
			conn.createStatement().execute(sql.toString());
			
			String prePeroidID=PeriodUtils.getPrePeriodInfo(new ObjectUuidPK(periodID)).getString("id");
			
			//更新对应信息
			sql.setLength(0);
			sql.append(" update T_FM_DayRateInitBill  t1 set (fbeginBreedQty,FBeginFemaleQty)=")
			.append(" select fendBreedQty,fendFemaleQty from T_FM_DayRateInitBill t2 ")
			.append(" where t1.fcompanyID='").append(companyID).append("'")
			.append(" and t1.fperiodid='").append(periodID).append("'")
			.append(" and t2.fcompanyID='").append(companyID).append("'")
			.append(" and t2.fperiodid='").append(prePeroidID).append("'")
			.append(" and exists (")
			.append(" select 1 from T_FM_DayRateInitBill t3 where t3.companyID=t1.fcompanyID")
			.append(" and t3.fstockingbatchid=t1.fstockingbatchid")
			.append(" and t3.fhouseid=t1.fhouseid")
			.append(" and t3.fhouseid!='' and t3.fhouseid is not null")
			.append(" )")
			.append(" where t3.fhouseid!='' and t3.fhouseid is not null")
			.append(" )")
			.append(" union all ")
			.append(" update T_FM_DayRateInitBill  t1 set (fbeginBreedQty,FBeginFemaleQty)=")
			.append(" select fendBreedQty,fendFemaleQty from T_FM_DayRateInitBill t2 ")
			.append(" where t1.fcompanyID='").append(companyID).append("'")
			.append(" and t1.fperiodid='").append(periodID).append("'")
			.append(" and t2.fcompanyID='").append(companyID).append("'")
			.append(" and t2.fperiodid='").append(prePeroidID).append("'")
			.append(" and exists (")
			.append(" select 1 from T_FM_DayRateInitBill t3 where t3.companyID=t1.fcompanyID")
			.append(" and t3.fstockingbatchid=t1.fstockingbatchid")
			.append(" and (t3.fhouseid='' or t3.fhouseid is  null)")
			.append(" )")
			.append(" where (t3.fhouseid='' or  t3.fhouseid is null)")
			.append(" );")
			//育成期余额
			.append(" union all ")
			.append(" update T_FM_DayRateInitBill  t1 set (fbeginBreedQty,FBeginFemaleQty)=")
			.append(" select fendBreedQty,fendFemaleQty from T_FM_DayRateCostDetail t2 ")
			.append(" where t1.fcompanyID='").append(companyID).append("'")
			.append(" and t1.fperiodid='").append(periodID).append("'")
			.append(" and t2.fcompanyID='").append(companyID).append("'")
			.append(" and t2.fperiodid='").append(prePeroidID).append("'")
			.append(" and exists (")
			.append(" select 1 from T_FM_DayRateCostDetail t3 where t3.companyID=t1.fcompanyID")
			.append(" and t3.fstockingbatchid=t1.fstockingbatchid")
			.append(" and t3.fhouseid=t1.fhouseid")
			.append(" and t3.fisStageBalance=1")
			.append(" and t3.fbreedStage=").append(FarmStageEnum.BREED_VALUE)
			.append(" and t3.fhouseid!='' and t3.fhouseid is not null")
			.append(" )")
			.append(" where t3.fhouseid!='' and t3.fhouseid is not null")
			.append(" and t2.fisStageBalance=1")
			.append(" and t2.fbreedStage=").append(FarmStageEnum.BREED_VALUE)
			.append(" union all ")
			.append(" update T_FM_DayRateInitBill  t1 set (fbeginBreedQty,FBeginFemaleQty)=")
			.append(" select fendBreedQty,fendFemaleQty from T_FM_DayRateCostDetail t2 ")
			.append(" where t1.fcompanyID='").append(companyID).append("'")
			.append(" and t1.fperiodid='").append(periodID).append("'")
			.append(" and t2.fcompanyID='").append(companyID).append("'")
			.append(" and t2.fperiodid='").append(prePeroidID).append("'")
			.append(" and exists (")
			.append(" select 1 from T_FM_DayRateCostDetail t3 where t3.companyID=t1.fcompanyID")
			.append(" and t3.fstockingbatchid=t1.fstockingbatchid")
			.append(" and (t3.fhouseid='' or t3.fhouseid is  null)")
			.append(" and t3.fisStageBalance=1")
			.append(" and t3.fbreedStage=").append(FarmStageEnum.BREED_VALUE)
			.append(" )")
			.append(" where (t3.fhouseid='' or  t3.fhouseid is null)")
			.append(" and t2.fisStageBalance=1")
			.append(" and t2.fbreedStage=").append(FarmStageEnum.BREED_VALUE)
			.append(" ;")
			;
			conn.createStatement().execute(sql.toString());
			
			/**
			 * 更新本期发生数量
			 */
			sql.setLength(0);
			sql.append(" update T_FM_DayRateInitBill t1 set (foccurBreedQty,FoccurFemaleQty,fworkQty)=(")
			.append(" select sum(lastStockQty),sum(lastFemaleStockQty),sum(sumAllEggQty)")
			.append(" from ").append(tableBean.getBizDataDetailTable()).append(" t2")
			.append(" where t2.batchid=t1.fstockingbatchid")
			.append(" and t2.status=1")
			.append(" where (t2.fhouseid='' or  t2.fhouseid is null)")
			.append(" )")
			.append(" where t1.fcompanyID='").append(companyID).append("'")
			.append(" and t1.fperiodid='").append(periodID).append("'")
			.append(" and (t1.fhouseid='' or  t1.fhouseid is null);")
			.append(" update T_FM_DayRateInitBill t1 set (foccurBreedQty,FoccurFemaleQty,fworkQty)=(")
			.append(" select sum(lastStockQty),sum(lastFemaleStockQty),sum(sumAllEggQty)")
			.append(" from ").append(tableBean.getBizDataDetailTable()).append(" t2")
			.append(" where t2.batchid=t1.fstockingbatchid")
			.append(" and t2.status=1")
			.append(" and t2.houseid=t1.fhouseid")
			.append(" and (t2.fhouseid!='' or  t2.fhouseid is not null)")
			.append(" )")
			.append(" where t1.fcompanyID='").append(companyID).append("'")
			.append(" and t1.fperiodid='").append(periodID).append("'")
			.append(" where (t1.fhouseid!='' or  t1.fhouseid is not null);")
			//更新期末数量、只均产蛋量
			.append(" update T_FM_DayRateInitBill set fendBreedQty=isnull(FBeginBreedQty,0)-isnull(FoccurBreedQty,0),")
			.append(" FEndFemaleQty=isnull(FBeginFemaleQty,0)-isnull(FOccurFemaleQty,0),FAvgWorkQty=isnull(FWorkQty)/FOccurFemaleQty")
			.append(" where t1.fcompanyID='").append(companyID).append("'")
			.append(" and t1.fperiodid='").append(periodID).append("'")
			;
			conn.createStatement().execute(sql.toString());
			
			//插入冲销明细--育成期末
			sql.setLength(0);
			sql.append(" insert into T_FM_DayRIBAOSD (")
			.append(" fid,fparentid,fbillid,fbizDate,fperiod,famount")
			.append(" )")
			.append(" select newbosid('6F9B8D03'),t2.fid,null,now(),'").append(periodID).append("',sum(t1.actualCost)")
			.append(" from ").append(tableBean.getCostEntryTable()).append(" t1")
			.append(" inner join T_FM_DayRateCostDetail t2 on (t2.fstockingbatchid=t1.batchid and t2.fhouseid=t1.houseid)")
			.append(" where t2.fcompanyID='").append(companyID).append("'")
			.append(" and t2.fisStagebalance=1")
			.append(" and (t1.houseid='' or t1.houseid is null)")
			.append(" group by t1.batchid,t1.houseid")
			.append(" ;")
			.append(" union all")
			.append(" select newbosid('6F9B8D03'),t2.fid,null,now(),'").append(periodID).append("',sum(t1.actualCost)")
			.append(" from ").append(tableBean.getCostEntryTable()).append(" t1")
			.append(" inner join T_FM_DayRateCostDetail t2 on (t2.fstockingbatchid=t1.batchid)")
			.append(" where t2.fcompanyID='").append(companyID).append("'")
			.append(" and t2.fisStagebalance=1")
			.append(" and (t1.houseid!='' and t1.houseid is not null)")
			.append(" group by t1.batchid,t1.houseid")
			.append(" ;")
			//更新已冲回和剩余冲回金额
			.append(" update T_FM_DayRateCostDetail t1 set foffsetArAmount=")
			.append(" select sum(famount) from T_FM_DayRIBAOSD t2 on t2.fparentid=t1.fid")
			.append(" where t1.fcompanyID='").append(companyID).append("'")
			.append(" and t2.fisStagebalance=1")
			.append(" and exists(")
			.append(" select 1 from ").append(tableBean.getCostEntryTable()).append(" t3")
			.append(" where t3.batchid=t1.fstockingbatchid")
			.append(" )")
			.append(" ;")
			.append(" update T_FM_DayRateCostDetail t1 set funoffsetArAmount=isnull(fallaramount,0)-isnull(foffsetamount,0)")
			.append(" where t1.fcompanyID='").append(companyID).append("'")
			.append(" and t2.fisStagebalance=1")
			.append(" and exists(")
			.append(" select 1 from ").append(tableBean.getCostEntryTable()).append(" t3")
			.append(" where t3.batchid=t1.fstockingbatchid")
			.append(" )")
			;
			conn.createStatement().execute(sql.toString());
			
			conn.commit();
		}catch(Exception err) {
			err.printStackTrace();
		}finally {
			conn.setAutoCommit(true);
		}
	}

	/**
	 * 结账
	 */
	protected void _exeClose(Context ctx, String companyID, String periodID)throws BOSException, EASBizException {
		DayRateBaseSettingInfo bdInfo = DayrateUtils.getBaseSetting(ctx, companyID);
		if(!bdInfo.isIsInit()){
			throw new EASBizException(new NumericExceptionSubItem("001","尚未完成初始化！"));
		}
		PeriodInfo nextPeriodInfo = PeriodUtils.getNextPeriodInfo(ctx,new ObjectUuidPK(periodID));
		//生成应收余额
//		createToArBalanceInfo(ctx, companyID, periodID);
		
		bdInfo.setCurrentPeriod(nextPeriodInfo);
		DayRateBaseSettingFactory.getLocalInstance(ctx).update(new ObjectUuidPK(bdInfo.getId()), bdInfo);
	}
	
	/**
	 * 将余额生成应付余额明细表--本期
	 * @param ctx
	 * @param companyID
	 * @param periodID
	 */
	private void createToArBalanceInfo(Context ctx,String companyID,String periodID) throws BOSException, EASBizException  {
		try{
			Date nowDate=new Date();
			String userID=ContextUtil.getCurrentUserInfo(ctx).getString("id");
			
			StringBuffer sql=new StringBuffer();
			sql.append(" insert into T_FM_ArAmountOffsetDetailBill (")
			.append(" fid,ffarmerid,ffarmid,fstockingbatchid,")
			.append(" FcompanyID,FperiodID,fbizDate,")
			.append(" FBreedStage,FBillStatus,FAllAramount,FOffsetAmount,FUnOffsetAmount,")
			.append(" FCreatorID,FCreatetime,FLastUpdateUserID,FLastUpdateTime,FAuditorID,FAuditoTime")
			.append(" )")
			.append(" select nebosid('6E8FC959'),ffarmerid,ffarmid,fstockingbatchID,?")
			.append(" ?,?,?")
			.append(" 2,4,isnull(sum(FAllAramout),0),0,isnull(sum(FAllAramout),0),")
			.append(" ?,?,?,?,?,?")
			.append(" ")
			;
			DbUtil.execute(ctx, sql.toString(),new Object[]{companyID,periodID,nowDate,userID,nowDate,userID,nowDate,userID,nowDate});
			
			/*sql.append(" select ffarmerid,ffarmid,fstockingbatchID,isnull(sum(FAllAramout),0) FAmount")
			.append(" from T_FM_DayRateCostDetail")
			.append(" where fcompanyiD='").append(companyID).append("'")
			.append(" and fperiodid='").append(periodID).append("'")
			.append(" and FIsStageBalance=1")//结算余额
			.append(" and FBreedStage=").append(FarmStageEnum.BREED_VALUE)
			;
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			CoreBaseCollection cols=new CoreBaseCollection();
			while(rs.next()) {
				if(rs.getBigDecimal("FAmount ").signum()<=0) {
					continue;
				}
				ArAmountOffsetDetailBillInfo info=new ArAmountOffsetDetailBillInfo();
				info.setString("company",companyID);
				info.setString("farmer","");
				info.setString("farm","");
				info.setString("stockingBatch","");
				info.setAllArAmount(rs.getBigDecimal("Famount"));
				info.setUnOffsetAmount(rs.getBigDecimal("Famount"));
				info.setOffsetAmount(BigDecimal.ZERO);
				info.setBreedStage(FarmStageEnum.breed);
			}
			if(cols.size()>0) {
				ArAmountOffsetDetailBillFactory.getLocalInstance(ctx).addnew(cols);
			}*/
		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.toString()));
		}
	}
	
	/**
	 * 检查本期的应收冲减余额
	 * @param ctx
	 * @param companyID
	 * @param periodID
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void checkCurrrentArBalanceInfo(Context ctx,String companyID,String prePeriodID) throws BOSException, EASBizException  {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select count(*) fCount")
			.append(" from T_FM_ArAmountOffsetDetailBill t1")
			.append(" where fcompanyID='").append(companyID).append("'")
			.append(" and fperiodid='").append(prePeriodID).append("'")
			.append(" and exists (")
			.append(" select 1 from T_FM_ArAODBE t2 wher t1.fparentid=t1.fid")
			.append(" )")
			.append(" ");
			IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()&&rs.getInt("fcount")>0) {
				throw new Exception("当前期间存在已经冲销应收余额的结算单！");
			}
		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.toString()));
		}
	}
	
	/**
	 * 删除应收冲减记录--上期
	 * @param ctx
	 * @param companyID
	 * @param periodID
	 * @throws EASBizException 
	 */
	private void deleteArAmountBalance(Context ctx,String companyID,String periodID) throws EASBizException {
		try {
			StringBuffer sql=new StringBuffer();
			sql.append(" select count(*) fCount")
			.append(" from T_FM_ArAmountOffsetDetailBill t1")
			.append(" where fcompanyID='").append(companyID).append("'")
			.append(" and fperiodid='").append(periodID).append("'")
			.append(" and (fisinit=0 or fisinit is null)")
			;
			DbUtil.execute(ctx, sql.toString());
		}catch(Exception err) {
			throw new EASBizException(new NumericExceptionSubItem("001",err.toString()));
		}
		
	}

	/**
	 * 反结账
	 */
	protected void _exeUnClose(Context ctx, String companyID, String periodID)	throws BOSException, EASBizException {
		DayRateBaseSettingInfo bdInfo = DayrateUtils.getBaseSetting(ctx, companyID);
		if(!bdInfo.isIsInit()){
			throw new EASBizException(new NumericExceptionSubItem("001","尚完成未初始化！"));
		}
		if(PeriodCompare(ctx,periodID, bdInfo.getIntPeroid().getString("id"))<=0) {
			throw new EASBizException(new NumericExceptionSubItem("001","当前期间<=初始化期间，不能反结账！"));
		}
		
		//应收冲减明细处理
//		checkCurrrentArBalanceInfo(ctx, companyID, periodID);
//		deleteArAmountBalance(ctx, companyID, periodID);
		
		bdInfo.setCurrentPeriod(PeriodUtils.getPrePeriodInfo(ctx,new ObjectUuidPK(periodID)));
		DayRateBaseSettingFactory.getLocalInstance(ctx).update(new ObjectUuidPK(bdInfo.getId()), bdInfo);
	}
	public int PeriodCompare(Context ctx,String sourceperiodInfoId, String targetperiodInfoId)
	/*      */     throws BOSException, EASBizException
	/*      */   {
	/*   90 */     if ((sourceperiodInfoId == null) || (targetperiodInfoId == null))
	/*      */     {
	/*   92 */       throw new PeriodException(PeriodException.PKNOTNULL);
	/*      */     }
	/*   94 */     PeriodInfo sourceperiodInfo = null;
	/*   95 */     PeriodInfo targetperiodInfo = null;
	/*   96 */     IPeriod iPeriod = PeriodFactory.getLocalInstance(ctx);
	/*   97 */     sourceperiodInfo = iPeriod.getPeriodInfo(new ObjectUuidPK(sourceperiodInfoId));
	/*   98 */     targetperiodInfo = iPeriod.getPeriodInfo(new ObjectUuidPK(targetperiodInfoId));
	/*      */ 
	/*  100 */     if (sourceperiodInfo.getPeriodYear() > targetperiodInfo.getPeriodYear())
	/*      */     {
	/*  102 */       return 1;
	/*      */     }
	/*  104 */     if (sourceperiodInfo.getPeriodYear() == targetperiodInfo.getPeriodYear())
	/*      */
	/*      */     {
	/*  107 */       if (sourceperiodInfo.getPeriodNumber() > targetperiodInfo.getPeriodNumber())
	/*      */
	/*      */       {
	/*  110 */         return 1;
	/*      */       }
	/*  112 */       if (sourceperiodInfo.getPeriodNumber() == targetperiodInfo.getPeriodNumber())
	/*      */       {
	/*  114 */         return 0;
	/*      */
	/*      */       }
	/*      */ 
	/*  118 */       return -1;
	/*      */
	/*      */
	/*      */     }
	/*      */ 
	/*  123 */     return -1;
	/*      */   }
	
}