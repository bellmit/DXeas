package com.kingdee.eas.farm.stocking.processbizill.app;

import org.apache.log4j.Logger;
import javax.ejb.*;

import java.math.BigDecimal;
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
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo;
import com.kingdee.eas.farm.stocking.processbizill.IStockingBreedDaily;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyAssEntryCollection;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyAssEntryInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyFactory;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.ToolFacadeFactory;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

import java.util.Date;
import java.util.HashMap;

public class StockingBatchDailyFacadeControllerBean extends AbstractStockingBatchDailyFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.stocking.processbizill.app.StockingBatchDailyFacadeControllerBean");

	
	/**
	 * 纠正批次的数据
	 */
	@Override
	protected HashMap _correctBatchStocking(Context ctx, HashMap param)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		HashMap<Object,Object> result=new HashMap<Object, Object>();
		
		//批次
		StockingBatchInfo batchInfo=null;
		if(UIRuleUtil.isNull(param.get("stockingBatch")))
			throw new EASBizException(new NumericExceptionSubItem("001","批次为空"));
		else
			batchInfo=(StockingBatchInfo)param.get("stockingBatch");

		
		//开始日期
		Date beginDate=null;
		if(param.containsKey("beginDate")&&UIRuleUtil.isNotNull(param.containsKey("beginDate")))
			beginDate=(Date)param.get("beginDate");
		
		try {
			correctStock(ctx,beginDate,batchInfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new EASBizException(new NumericExceptionSubItem("001",e.getCause().getMessage()+"\n"+e.getStackTrace()[0].getClassName()+"\n"+e.getStackTrace()[0].getLineNumber()+"\n"));
		}
		return result;
	}
	
	
	
	/**
	 * 手动校正存栏量 保证数据库存栏准确
	 * @param ctx 
	 * @param date
	 * @throws BOSException
	 * @throws SQLException
	 * @throws EASBizException
	 */
    private void correctStock(Context ctx, Date date,StockingBatchInfo sbInfo) throws BOSException, SQLException, EASBizException{
    	
    	
    		//遍历获取当前批次所有日报
    		StringBuffer sql= new StringBuffer();
    		
    		if(date != null){//单据改动自动校正时
    			SimpleDateFormat smt= new SimpleDateFormat("yyyy-MM-dd");
        		String sDate=smt.format(date);
    			sql.append("selelct fid from T_FM_StockingBreedDaily where CFStockingBatchID='").append(sbInfo.getId()).append("' and fbizdate>={d '")
    				.append(sDate).append("'} ");
    		}else{//手动校正时
    			sql.append("select fid from T_FM_StockingBreedDaily where CFStockingBatchID='").append(sbInfo.getId()).append("'");
    			//.append("' and fbizdate>={d '2017-08-26'} ");
    		}
    		
    		IRowSet rs=DbUtil.executeQuery(ctx, sql.toString());
    		
    		
    		
    		Date nowDate;
    		String sDate;
    		String nowBillId;
    		String companyid;
    		String batchid="";//批次号
    		
    		String  houseid="";//棚舍号
    		BigDecimal nowGnum=BigDecimal.ZERO;//公
    		BigDecimal nowMnum=BigDecimal.ZERO;//母
    		
    		StockingBreedDailyInfo nowInfo;
    		SimpleDateFormat smt= new SimpleDateFormat("yyyy-MM-dd");
    		StockingBreedDailyAssEntryCollection collection;
    		StockingBreedDailyAssEntryInfo aseInfo;
    		StringBuffer	sn=new StringBuffer();
    		IStockingBreedDaily iStockingBreedDaily = StockingBreedDailyFactory.getLocalInstance(ctx);
    		
    		while(rs.next()){
    		nowBillId=rs.getString("fid");
    		//日报
    		nowInfo=iStockingBreedDaily.getStockingBreedDailyInfo(new ObjectUuidPK(nowBillId));
    		
    		companyid=SysContextConstant.CUR_COMPANY;
    		
    		nowDate=nowInfo.getBizDate();//日期
    		System.out.println(nowDate);
    		sDate=smt.format(nowDate);
    		
    		
    		
    		
    		batchid="";//批次号
    		if(nowInfo.getStockingBatch() != null){
    			batchid=nowInfo.getStockingBatch().getId().toString();
    		}
    		
    		houseid="";//棚舍号
    		nowGnum=BigDecimal.ZERO;//公
    		nowMnum=BigDecimal.ZERO;//母
    		
    		collection=nowInfo.getAssEntrys();
    		for (int i = 0; i < collection.size(); i++) {
    			aseInfo=collection.get(i);//当前分录INFO
    			if(aseInfo.getHouse()  != null){
    				houseid=aseInfo.getHouse().getId().toString();
    			}
    			//重新计算存栏
    			sn.setLength(0);
    			
    			sn.append("/*dialect*/ SELECT max(nvl(tDaily.FFemaleQty, 0))-max(nvl(tDaily.FOccurQty,0)) FLastStock, max(nvl(tDaily.FQty,0))-max(nvl(tDaily.OccurQty, 0)) FGLastStock ")
    			   .append(" FROM T_FM_StockingBatch tmain INNER JOIN    (SELECT fbatchid,  	houseid   ,   	 nvl(max(FQty), 0) FQty,         nvl(max(FFemaleQty), 0) FFemaleQty, ")
    			   .append(" nvl(sum(OccurQty), 0) OccurQty,        nvl(sum(FOccurQty), 0) FOccurQty     FROM  (SELECT tmain.fid fbatchid,		tbe.FHouseID  houseid,        sum(tbe.fqty) FQty,        sum(tbe.FFemaleQty) FFemaleQty, ")
    			   .append("   0 OccurQty,        0 FOccurQty        FROM t_fm_stockingbatch tmain        INNER JOIN T_FM_StockingBatchHouseEntry tbe ")
    			   .append("    ON tbe.fparentid=tmain.fid        WHERE tmain.fid='").append(batchid).append("' and tbe.FHouseID='").append(houseid).append("'    GROUP BY  tmain.fid ,tbe.FHouseID ")
    			    .append(" UNION        all")
    			    .append(" SELECT tmain.cfstockingbatchID fbatchid,	te.FHouseID  houseid,        0,        0,         nvl(sum(te.CFDeathQty),0)+nvl(sum(te.CFCullQty),0)+nvl(sum(FMarkedQty), 0) OccurQty, ")
    			    .append("   nvl(sum(te.FFemaleDeathQty), 0)+nvl(sum(te.FFemaleCullQty),0)+nvl(sum(CFFemaleMarkedQty), 0) FOccurQty         FROM T_FM_StockingBreeddaily tmain ")
    			    .append("    INNER JOIN T_FM_StockingBDAE te            ON te.fparentid=tmain.fid ")
    			    .append(" WHERE tmain.fcompanyid='").append(companyid).append("' and te.FHouseID='").append(houseid).append("'                AND tmain.cfstockingbatchID='").append(batchid).append("' ")
    			    .append("  AND tmain.FBizDate<=to_date(substr('").append(sDate).append("',1,10),'yyyy-MM-dd')                AND CFBaseStatus=4 group by tmain.cfstockingbatchID,te.FHouseID ")
    			    .append("    UNION        all ")
    			    .append(" SELECT tmain.cfstockingbatchID fbatchid,	te.FHouseID  houseid,        0,        0,         (-1)*nvl(FTransQty,0) OccurQty, ")
    			    .append(" (-1)*nvl(FTransFemaleQty, 0) FOccurQty        FROM T_FM_StockingBreeddaily tmain        INNER JOIN T_FM_StockingBDTE te ")
    			    .append("      ON te.fparentid=tmain.fid        WHERE tmain.fcompanyid='").append(companyid).append("' ")
    			    .append("  AND tmain.cfstockingbatchID='").append(batchid).append("'  and te.FHouseID='").append(houseid).append("'  ")
    			    .append("     AND tmain.FBizDate<=to_date(substr('").append(sDate).append("',1,10),'yyyy-MM-dd')                AND CFBaseStatus=4 ")
    			    .append("    UNION        all ")
    			    .append(" SELECT te.CFFromStockingBatc fbatchid,		te.CFFromHouseID  houseid,        0,        0,         nvl(FTransQty, 0) OccurQty, ")
    			    .append("  nvl(FTransFemaleQty,  0) FOccurQty        FROM T_FM_StockingBreeddaily tmain        INNER JOIN T_FM_StockingBDTE te            ON te.fparentid=tmain.fid ")
    			    .append(" WHERE tmain.fcompanyid='").append(companyid).append("'                 AND tmain.FBizDate<=to_date(substr('").append(sDate).append("',1,10),'yyyy-MM-dd')   ")
    			    .append("   AND CFBaseStatus=4   AND te.cFFromStockingBatc='").append(batchid).append("' and te.CFFromHouseID='").append(houseid).append("' ) tpp ")
    			    .append("   GROUP BY  fbatchid ,houseid) tDaily       ON (tdaily.fbatchid=tmain.fid) ");
    			    
    			    IRowSet snrs=DbUtil.executeQuery(ctx, sn.toString());
    			if(snrs.next()){
    				if(snrs.getString("FLastStock")!=null){
    					nowMnum=snrs.getBigDecimal("FLastStock");
    				}
    				if(snrs.getString("FLastStock")!=null){
    					nowGnum=snrs.getBigDecimal("FGLastStock");
    				}
    			}
    			
    			//更新计算后存栏
    			StringBuffer su=new StringBuffer();
    			su.append("update T_FM_StockingBDAE set FFemaleBreedkingStock='").append(nowMnum).append("',CFBreekingStock='")
    			.append(nowGnum).append("' where fid='").append(aseInfo.getId().toString()).append("'");
    			
    			DbUtil.execute(ctx,su.toString());
			}
    		}
    }
}