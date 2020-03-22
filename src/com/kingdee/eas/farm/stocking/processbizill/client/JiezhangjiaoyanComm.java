package com.kingdee.eas.farm.stocking.processbizill.client;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.jdbc.rowset.IRowSet;

public class JiezhangjiaoyanComm {

	/**
	 * 当月饲料领用单是否都已生成领料出库单并审核
	 * @param companyInfo
	 * @param periodInfo
	 * @return
	 */
	//饲料领用单
	public static IRowSet checkHatchBill(CompanyOrgUnitInfo companyInfo,
			PeriodInfo periodInfo) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		String sp = "\n";
		sb.append("SELECT " ).append(sp).append(
		"t6.FName_l2  stoOrgUnitName," ).append(sp).append(
		"t1.FNumber   FNumber," ).append(sp).append(
		"t3.FBaseStatus  FBaseStatus," ).append(sp).append(
		"t3.FID	FID" ).append(sp).append(
		" from " ).append(sp).append(
		"T_FM_FodderReceiveBill             t1  " ).append(sp).append(
		"left join  T_BOT_Relation          t2  on   t2.FSrcObjectID=t1.FID " ).append(sp).append(
		"left join  T_IM_MaterialReqBill    t3  on t3.FID=t2.FDestObjectID " ).append(sp).append(
		"inner join T_BD_Period             t4  on t4.FNumber='"+periodInfo.getNumber()+"' " ).append(sp).append(
		"inner join T_ORG_Company           t5  on t5.FID='"+companyInfo.getId().toString()+"'").append(sp).append(
		"inner join T_ORG_Storage           t6  on t6.FID=t1.FStorageOrgUnitID").append(sp).append(
		"where t1.FBizDate>=t4.FBeginDate " ).append(sp).append(
		"and t1.FBizDate<t4.FEndDate+1 " ).append(sp).append(
		"and t2.FDestEntityID='500AB75E'").append(sp).append(
		"and (t3.FID is null or t3.FBaseStatus not in (4,7))");
		try {
			IRowSet rowSet = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			return rowSet;
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//药品处方单
	public static IRowSet checkDrugBill(CompanyOrgUnitInfo companyInfo,
			PeriodInfo periodInfo) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		String sp = "\n";
		sb.append("SELECT " ).append(sp).append(
		"t6.FName_l2  stoOrgUnitName," ).append(sp).append(
		"t1.FNumber   FNumber," ).append(sp).append(
		"t3.FBaseStatus  FBaseStatus," ).append(sp).append(
		"t3.FID	FID" ).append(sp).append(
		" from " ).append(sp).append(
		"T_FM_DrugReceptionBill             t1  " ).append(sp).append(
		"left join  T_BOT_Relation          t2  on   t2.FSrcObjectID=t1.FID " ).append(sp).append(
		"left join  T_IM_MaterialReqBill    t3  on t3.FID=t2.FDestObjectID " ).append(sp).append(
		"inner join T_BD_Period             t4  on t4.FNumber='"+periodInfo.getNumber()+"' " ).append(sp).append(
		"inner join T_ORG_Company           t5  on t5.FID='"+companyInfo.getId().toString()+"'").append(sp).append(
		"inner join T_ORG_Storage           t6  on t6.FID=t1.FStorageOrgUnitID").append(sp).append(
		"where t1.FBizDate>=t4.FBeginDate " ).append(sp).append(
		"and t1.FBizDate<t4.FEndDate+1 " ).append(sp).append(
		"and t2.FDestEntityID='500AB75E'").append(sp).append(
		"and (t3.FID is null or t3.FBaseStatus not in (4,7))");
		try {
			IRowSet rowSet = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			return rowSet;
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	// 种苗领用单
	public static IRowSet checkGermchitBill(CompanyOrgUnitInfo companyInfo,
			PeriodInfo periodInfo) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		String sp = "\n";
		sb.append("SELECT " ).append(sp).append(
		"t6.FName_l2  stoOrgUnitName," ).append(sp).append(
		"t1.FNumber   FNumber," ).append(sp).append(
		"t3.FBaseStatus  FBaseStatus," ).append(sp).append(
		"t3.FID	FID" ).append(sp).append(
		" from " ).append(sp).append(
		"T_FM_BreedSeedBill             t1  " ).append(sp).append(
		"left join  T_BOT_Relation          t2  on   t2.FSrcObjectID=t1.FID " ).append(sp).append(
		"left join  T_IM_MaterialReqBill    t3  on t3.FID=t2.FDestObjectID " ).append(sp).append(
		"inner join T_BD_Period             t4  on t4.FNumber='"+periodInfo.getNumber()+"' " ).append(sp).append(
		"inner join T_ORG_Company           t5  on t5.FID='"+companyInfo.getId().toString()+"'").append(sp).append(
		"inner join T_ORG_Storage           t6  on t6.FID=t1.FStorageOrgUnitID").append(sp).append(
		"where t1.FBizDate>=t4.FBeginDate " ).append(sp).append(
		"and t1.FBizDate<t4.FEndDate+1 " ).append(sp).append(
		"and t2.FDestEntityID='500AB75E'").append(sp).append(
		"and (t3.FID is null or t3.FBaseStatus not in (4,7))");
		try {
			IRowSet rowSet = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			return rowSet;
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//种蛋接收单
	public static IRowSet checkGermchitReceiveBill(CompanyOrgUnitInfo companyInfo,
			PeriodInfo periodInfo) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		String sp = "\n";
		sb.append("SELECT " ).append(sp).append(
		"t6.FName_l2  stoOrgUnitName," ).append(sp).append(
		"t1.FNumber   FNumber," ).append(sp).append(
		"t3.FBillStatus  FBillStatus," ).append(sp).append(
		"t3.FID	     FID" ).append(sp).append(
		" from " ).append(sp).append(
		"T_FM_EggReceiveBill                t1  " ).append(sp).append(
		"left join  T_BOT_Relation          t2  on   t2.FSrcObjectID=t1.FID " ).append(sp).append(
		"left join  T_FM_EggSettleBill      t3  on t3.FID=t2.FDestObjectID " ).append(sp).append(
		"inner join T_BD_Period             t4  on t4.FNumber='"+periodInfo.getNumber()+"' " ).append(sp).append(
		"inner join T_ORG_Company           t5  on t5.FID='"+companyInfo.getId().toString()+"'").append(sp).append(
		"inner join T_ORG_Storage           t6  on t6.FID=t1.FStorageOrgUnitID").append(sp).append(
		"where t1.FBizDate>=t4.FBeginDate " ).append(sp).append(
		"and t1.FBizDate<t4.FEndDate+1 " ).append(sp).append(
		"and t2.FDestEntityID='7DD0D62D'").append(sp).append(
		"and (t3.FID is null or t3.FBillStatus not in (4,7))");
		try {
			IRowSet rowSet = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			return rowSet;
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//种蛋接收单审核
	public static IRowSet checkHatcheggBalanceBill(CompanyOrgUnitInfo companyInfo,
			PeriodInfo periodInfo) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		String sp = "\n";
		sb.append("SELECT " ).append(sp).append(
		"t6.FName_l2  stoOrgUnitName," ).append(sp).append(
		"t1.FNumber   FNumber," ).append(sp).append(
		"t1.FBillStatus  FBillStatus" ).append(sp).append(
		" from " ).append(sp).append(
		"T_FM_EggSettleBill             t1  " ).append(sp).append(
		"inner join T_BD_Period             t4  on t4.FNumber='"+periodInfo.getNumber()+"' " ).append(sp).append(
		"inner join T_ORG_Company           t5  on t5.FID='"+companyInfo.getId().toString()+"'").append(sp).append(
		"inner join T_ORG_Storage           t6  on t6.FID=t1.FStorageOrgUnitID").append(sp).append(
		"where t1.FBizDate>=t4.FBeginDate " ).append(sp).append(
		"and t1.FBizDate<t4.FEndDate+1 " ).append(sp).append(
		"and t1.FBillStatus not in (4,7)");
		try {
			IRowSet rowSet = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			return rowSet;
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//固定资产折旧审核
	public static IRowSet checkAssetBill(CompanyOrgUnitInfo companyInfo,
			PeriodInfo periodInfo) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		String sp = "\n";
		sb.append("SELECT " ).append(sp).append(
		//"t6.FName_l2  stoOrgUnitName," ).append(sp).append(
		"t1.FNumber   FNumber," ).append(sp).append(
		"t1.FBizDate  bizDate" ).append(sp).append(
		" from " ).append(sp).append(
		"T_FA_FaCurCard                     t1  " ).append(sp).append(
		"inner join T_BD_Period             t4  on t4.FNumber='"+periodInfo.getNumber()+"' " ).append(sp).append(
		"inner join T_ORG_Company           t5  on t5.FID='"+companyInfo.getId().toString()+"'").append(sp).append(
		//"inner join T_ORG_Storage           t6  on t6.FID=t1.FStorageOrgUnitID").append(sp).append(
		"where t1.FBizDate>=t4.FBeginDate " ).append(sp).append(
		"and t1.FBizDate<t4.FEndDate+1 " ).append(sp).append(
		"and t1.FCheckedStatus not in(2)");
		try {
			IRowSet rowSet = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			return rowSet;
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//辅料领用单
	public static IRowSet checkAccessoryBill(CompanyOrgUnitInfo companyInfo,
			PeriodInfo periodInfo) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		String sp = "\n";
		sb.append("SELECT " ).append(sp).append(
		"t6.FName_l2  stoOrgUnitName," ).append(sp).append(
		"t1.FNumber   FNumber," ).append(sp).append(
		"t3.FBaseStatus  FBaseStatus," ).append(sp).append(
		"t3.FID	FID" ).append(sp).append(
		" from " ).append(sp).append(
		"T_FM_OtherReceptionBill            t1  " ).append(sp).append(
		"left join  T_BOT_Relation          t2  on   t2.FSrcObjectID=t1.FID " ).append(sp).append(
		"left join  T_IM_MaterialReqBill    t3  on t3.FID=t2.FDestObjectID " ).append(sp).append(
		"inner join T_BD_Period             t4  on t4.FNumber='"+periodInfo.getNumber()+"' " ).append(sp).append(
		"inner join T_ORG_Company           t5  on t5.FID='"+companyInfo.getId().toString()+"'").append(sp).append(
		"inner join T_ORG_Storage           t6  on t6.FID=t1.FStorageOrgUnitID").append(sp).append(
		"where t1.FBizDate>=t4.FBeginDate " ).append(sp).append(
		"and t1.FBizDate<t4.FEndDate+1 " ).append(sp).append(
		"and t2.FDestEntityID='500AB75E'").append(sp).append(
		"and (t3.FID is null or t3.FBaseStatus not in (4,7))");
		try {
			IRowSet rowSet = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			return rowSet;
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//费用分摊表
	public static IRowSet checkCostBill(CompanyOrgUnitInfo companyInfo,
			PeriodInfo periodInfo) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		String sp = "\n";
		sb.append("SELECT " ).append(sp).append(
		"t1.FBizDate  bizDate," ).append(sp).append(
		"t4.FNumber   FNumber," ).append(sp).append(
		"t1.FBillStatus   FBillStatus" ).append(sp).append(
		" from " ).append(sp).append(
		"T_FM_CostAllocation             t1  " ).append(sp).append(
		"inner join T_BD_Period             t4  on t4.fid=t1.FPeriodID" ).append(sp).append(
		"inner join T_ORG_Company           t5  on t5.FID='"+companyInfo.getId().toString()+"'").append(sp).append(
		"where t4.FNumber='"+periodInfo.getNumber()+"'" );
		try {
			IRowSet rowSet = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			return rowSet;
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	//奖惩政策
	public static IRowSet checkRewardsBill(CompanyOrgUnitInfo companyInfo,
			PeriodInfo periodInfo) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		String sp = "\n";
		sb.append("SELECT " ).append(sp).append(
		//"t6.FName_l2  stoOrgUnitName," ).append(sp).append(
		"t1.FName_l2   FName_l2," ).append(sp).append(
		"t1.FBeginDate   FBeginDate" ).append(sp).append(
		" from " ).append(sp).append(
		"T_FM_RewardsPolicy             t1  " ).append(sp).append(
		"inner join T_BD_Period             t4  on t4.FNumber='"+periodInfo.getNumber()+"' " ).append(sp).append(
		"inner join T_ORG_Company           t5  on t5.FID='"+companyInfo.getId().toString()+"'").append(sp).append(
		//"inner join T_ORG_Storage           t6  on t6.FID=t1.FStorageOrgUnitID").append(sp).append(
		"where t1.FBeginDate=t4.FBeginDate " ).append(sp).append(
		"and t1.FEndDate=t4.FEndDate " );
		try {
			IRowSet rowSet = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			return rowSet;
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//副产品价格维护
	public static IRowSet checkByproductBill(CompanyOrgUnitInfo companyInfo,
			PeriodInfo periodInfo) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		String sp = "\n";
		sb.append("SELECT " ).append(sp).append(
		//"t6.FName_l2  stoOrgUnitName," ).append(sp).append(
		"t1.FID" ).append(sp).append(
		" from " ).append(sp).append(
		"T_FM_CoProductPrice             t1  " ).append(sp).append(
		"inner join T_BD_Period             t4  on t4.FNumber='"+periodInfo.getNumber()+"' " ).append(sp).append(
		"inner join T_ORG_Company           t5  on t5.FID='"+companyInfo.getId().toString()+"'").append(sp).append(
		//"inner join T_ORG_Storage           t6  on t6.FID=t1.FStorageOrgUnitID").append(sp).append(
		"where t1.FEffectDate=t4.FBeginDate " ).append(sp).append(
		"and t1.CFUnEffectDate=t4.FEndDate " ).append(sp).append(
		"and t1.FBaseStatus in (3)");
		try {
			IRowSet rowSet = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
			return rowSet;
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
