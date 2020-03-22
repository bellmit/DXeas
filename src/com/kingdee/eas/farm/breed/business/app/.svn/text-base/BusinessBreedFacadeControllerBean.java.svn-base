package com.kingdee.eas.farm.breed.business.app;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.rpt.app.CCProductPlanRptBean;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.DateCommon;
import com.kingdee.jdbc.rowset.IRowSet;

public class BusinessBreedFacadeControllerBean extends AbstractBusinessBreedFacadeControllerBean
{
    

	private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.business.app.BusinessBreedFacadeControllerBean");

    /**
     * 设置批次转栏汇总到对应鸡舍 bean中
     */
	@Override
	protected List _getBatchHouseAllAdjustInfos(Context ctx, String batchID,
			List rptBeans) throws BOSException {
		String sql = "select te.CFHenhouseID,sum(te.CFTransQty) allTransQty from CT_FM_CommecialChilkenDaily t inner join CT_FM_CommecialCDAE te on t.fid = te.fparentid where t.CFBreedBatchID=? ";
		String[] args = {batchID};
		
		try{
			IRowSet rs = DbUtil.executeQuery(ctx, sql,args);
			while(rs.next()){
				String houseId = rs.getString("CFHenhouseID");
				int allTransQty = rs.getInt("allTransQty");
				
				for(int i = 0; rptBeans != null  && i < rptBeans.size(); i++){
					CCProductPlanRptBean rptBean = (CCProductPlanRptBean) rptBeans.get(i);
					if(rptBean != null && StringUtils.isNotBlank(rptBean.getHenhouseID())){
						if(houseId.equals(rptBean.getHenhouseID())){
							// 更新 转栏数量和 累计入栏数
							rptBean.setAllAdjustQty(allTransQty);
							rptBean.setActualAllInhouseQty(rptBean.getInhouseQty()+allTransQty);
						}
					}
				}
				
			}
		}catch(SQLException sqle){
			throw new BOSException(sqle);
		}
		
		return rptBeans;
	}
    
    /**
     * 更新 免疫分录历史数据 日龄信息
     */
    @Deprecated
	@Override
	protected void _updateImmDaysOldData(Context ctx) throws BOSException {
		String sql = "/*dialect*/select te.fid,te.cfhenhouseid,te.cfhenhouseid,tbe.CFIncoopDate,t.fbizdate, to_char(t.fbizdate,'yyyy-mm-dd') bizdate,to_char(tbe.cfincoopdate,'yyyy-mm-dd') incoopdate from CT_FM_CommecialCDIE te inner join CT_FM_CommecialChilkenDaily t on te.fparentid = t.fid inner join CT_FM_BreedBatch tb on t.CFBreedBatchID= tb.fid inner join CT_FM_BreedBatchEntry tbe on tb.fid = tbe.fparentid and te.cfhenhouseid = tbe.cfhenhouseid where t.fbizdate < to_date('2015-09-20','yyyy-mm-dd') ";
	
		IRowSet rs = DbUtil.executeQuery(ctx, sql);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try{
			while(rs.next()){
				String tefid = rs.getString("fid");
				String bizdate = rs.getString("bizdate");
				
				String incoopdate = rs.getString("incoopdate");
				
				Date bizdateD = sdf.parse(bizdate);
				Date incoopdateD = sdf.parse(incoopdate);
				
				int days = DateCommon.dateDiff(incoopdateD, bizdateD);
				
				String upsql = "update CT_FM_CommecialCDIE set CFDays= "+days+" where fid='"+tefid+"'";
				DbUtil.execute(ctx, upsql);
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	@Override
	protected void _getCCBreedPlan(Context ctx) throws BOSException {
		// TODO Auto-generated method stub
		
	}
}