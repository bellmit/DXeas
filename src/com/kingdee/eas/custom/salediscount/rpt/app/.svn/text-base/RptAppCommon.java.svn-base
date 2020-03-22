package com.kingdee.eas.custom.salediscount.rpt.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.base.codingrule.CodingRuleManagerFactory;
import com.kingdee.eas.base.codingrule.ICodingRuleManager;
import com.kingdee.eas.base.permission.UserFactory;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.PeriodFactory;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.org.IOrgSwitchFacade;
import com.kingdee.eas.basedata.org.OrgSwitchFacadeFactory;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.TableManagerFacadeFactory;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.db.SQLUtils;


public class RptAppCommon 
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.jack.app.LHCommonFacadeControllerBean");
   
    public boolean CopyPriceItem(Context ctx,String FPeriodID,String FNextPeriodID)
			throws BOSException, EASBizException {
		String FCUID = ctx.get("CurCompanyId").toString();
		String FdbType = ctx.get("dbType").toString();
		try {
			List params = new ArrayList();
			StringBuffer StrRs = new StringBuffer();
			StrRs = new StringBuffer();
			StrRs.append("Select * from T_LHZ_PriceItem");
			StrRs.append(" where FControlUnitID='" + FCUID + "' ");
			StrRs.append(" and FPeriodID='" + FPeriodID + "'");
			IRowSet rs = com.kingdee.eas.util.app.DbUtil.executeQuery(ctx, StrRs.toString(),params.toArray());
			int i=0;
			while(rs.next()) {
				i=i+1;
				String fCustomerId = rs.getString("FCustomerId").toString();
				//copyPriceItemOne(ctx,fCustomerId,fCustomerId,FPeriodID,FNextPeriodID,FCUID,i);
			}
			rs.close();
		} catch (SQLException e) {
			// return false;
			throw new BOSException("sql Execute Error :", e);
		} 
		return true;
	}
    /**
     * 算本期支付数
     */
    public String CustomerBal(Context ctx,String FCreatorID,String FPeriodID,boolean fisyr) throws BOSException {
		boolean FStatus=false;
		String FCUID = ctx.get("CurCompanyId").toString();
		String FdbType = ctx.get("dbType").toString();
		StringBuffer sql=new StringBuffer();
		List params = new ArrayList();
		IRowSet rs=null;
		String dpBeginDate="";
		String dpEndDate="";
		String tablename="";
		try {
			tablename=TableManagerFacadeFactory.getLocalInstance(ctx).getTableName("JackA");
			sql=new StringBuffer();
			sql.append(" /*dialect*/create table "+tablename+"(");
			sql.append(" FID            VARCHAR2(44), ");
			sql.append(" FCONTROLUNITID VARCHAR2(44), ");
			sql.append(" FCUSTOMERID    VARCHAR2(44), ");
			sql.append(" FMATERIALID    VARCHAR2(44), ");
			sql.append(" FAMOUNT        NUMBER(28,2), ");
			sql.append(" FAmountA        NUMBER(28,2) default 0, ");
			sql.append(" FSTATUS        NUMBER(10) default 0 ");
			sql.append(" ) ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
			
			sql=new StringBuffer();
			sql.append(" insert into t_lhz_table(fname,fdate)values('"+tablename+"',getdate())  ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
			
			sql=new StringBuffer();
			sql.append(" Select * ");
			sql.append(" from t_BD_Period where FID='"+FPeriodID+"' ");
			rs=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString(), params.toArray());
			if(rs.next()){
				dpBeginDate=rs.getString("FBeginDate").toString();
				dpEndDate=rs.getString("FEndDate").toString();
			}
			dpBeginDate=dpBeginDate.substring(0,10);
			dpEndDate=dpEndDate.substring(0,10);
			dpEndDate=dpEndDate+" 23:59:59";
			
			//删除T_LHZ_BalDetail
			//sql=new StringBuffer();
			//sql.append("Delete T_LHZ_BalDetail where FControlUnitID='"+FCUID+"'");
			//com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());
			
			//插入T_LHZ_BalDetail
			String tablenameA=this.v_SD_SaleOrderJ(ctx, FCUID, dpBeginDate, dpEndDate);
			sql=new StringBuffer();
			sql.append("Insert Into "+tablename+"(");
			sql.append(" FID,FControlUnitID,FCustomerID,FAmount,");
			sql.append(" FMaterialID,FStatus )");
			sql.append(" Select dbo.newbosid('CC2A8A17'),t1.FControlUnitID,t1.FCustomerID,sum(t1.FDisAmount), ");
			sql.append(" t1.FMaterialID,1 ");
			sql.append(" from "+tablenameA+" t1  ");
			sql.append(" group by t1.FControlUnitID,t1.FCustomerID,t1.FMaterialID ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());
			com.kingdee.eas.util.app.DbUtil.execute(ctx, "drop table "+tablenameA+" ");
		} catch (SQLException er) {
			// return false;
			throw new BOSException("sql Execute Error :", er);
		} finally {
			FStatus=true;

		}
		return tablename;
	}
	public boolean UpdateCustomerBal(Context ctx,String FCreatorID,String FPeriodID) throws BOSException {
		boolean FStatus=false;
		String FCUID = ctx.get("CurCompanyId").toString();
		StringBuffer sql=new StringBuffer();
		List params = new ArrayList();
		IRowSet rs=null;
		String dpBeginDate="";
		String dpEndDate="";
		String fPeriodIDA="";
		String fcuid =ctx.get("CurCompanyId").toString();
		try {
			
			sql=new StringBuffer();
			sql.append(" select distinct t2.FID FPeriodID,t2.FBeginDate,t2.FendDate ");
			//sql.append(" from t_lhz_balInit t1 ");
			sql.append(" from t_lhz_customerbal t1 ");
			sql.append(" inner join t_bd_period t2 on t2.fid=t1.fperiodid ");
			sql.append(" where t1.fcontrolunitid='"+fcuid+"' ");
			rs=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString(), params.toArray());
			if(rs.next()){
				dpBeginDate=rs.getString("FBeginDate").toString();
				dpEndDate=rs.getString("FEndDate").toString();
				fPeriodIDA=rs.getString("FPeriodID").toString();
			}
			rs.close();
			dpBeginDate=dpBeginDate.substring(0,10);
			dpEndDate=dpEndDate.substring(0,10); 
			
			boolean fisyr=false;
			params = new ArrayList();
			sql=new StringBuffer();
			sql.append("Select * from t_LHZ_Inv where FControlUnitID='"+fcuid+"' ");
			rs = com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString(), params.toArray());
			if(rs.next()){
				if(rs.getString("FStatus").equals("0")){
					fisyr=false;
				}else{
					fisyr=true;
				}
			}
			
			RptAppCommon aa=new RptAppCommon();
			//FStatus=aa.CustomerBack(ctx,FCreatorID,fPeriodIDA);
			String rpttablename=aa.CustomerBal(ctx,FCreatorID,fPeriodIDA,fisyr);
			
			sql=new StringBuffer();
			sql.append("insert into T_LHZ_CustomerBal(");
			sql.append(" FID,FControlUnitID,FPeriodID,FCustomerID,");
			sql.append(" FMaterialID,FBegBal,FForecast,FDisPro,");
			sql.append(" FUseAmount,FReturnAmount");
			sql.append(" )");
			sql.append(" Select dbo.newbosid('CC2A8A17'),FControlUnitID,'"+fPeriodIDA+"',FCustomerID,");
			sql.append(" FMaterialID,0,0,0,");
			sql.append(" 0,0");
			sql.append(" from "+rpttablename+" ");
			sql.append(" where FControlUnitID='"+FCUID+"' ");
			sql.append(" and Not Exists( ");
			sql.append(" Select * from T_LHZ_CustomerBal ");
			sql.append(" where T_LHZ_CustomerBal.FControlUnitID="+rpttablename+".FControlUnitID ");
			sql.append(" and T_LHZ_CustomerBal.FCustomerID="+rpttablename+".FCustomerID  ");
			sql.append(" and T_LHZ_CustomerBal.FMaterialID="+rpttablename+".FMaterialID  ");
			sql.append(" ) ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());
			
			
			
			sql=new StringBuffer();
			sql.append("/*dialect*/update T_LHZ_CustomerBal set FUseAmount=0,");
			sql.append(" FForecast=0,FReturnAmount=FBegBal");
			sql.append(" where FControlUnitID='"+FCUID+"' ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());
			
			sql=new StringBuffer();
			sql.append(" Select * from  "+rpttablename+" where FAmount<0 or FAmount>0 and FControlUnitID='"+FCUID+"' ");
			rs=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx, sql.toString());
			//更新客户销售折扣
			while(rs.next()){
				sql=new StringBuffer();
				sql.append(" update T_LHZ_CustomerBal set FUseAmount='"+rs.getString("FAmount")+"'");
				sql.append(" where FControlUnitID='"+FCUID+"'");
				sql.append(" and FCustomerID='"+rs.getString("FCustomerID")+"' ");
				sql.append(" and FMaterialID='"+rs.getString("FMaterialID")+"' ");
				com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());
			}
			rs.close();
			com.kingdee.eas.util.app.DbUtil.execute(ctx, "drop table "+rpttablename+" ");
			
			//更新剩余折让金额
			sql=new StringBuffer();
			sql.append(" update T_LHZ_CustomerBal set FReturnAmount");
			sql.append(" =isnull(FBegBal,0)+isnull(FForecast,0)*isnull(FDisPro,0)/100-isnull(FUseAmount,0)");
			sql.append(" where FControlUnitID='"+FCUID+"'");
			com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());
			
			//更新本期预估
			//sql=new StringBuffer();
			//sql.append("/*dialect*/update T_LHZ_CustomerBal t1 set FForecast=");
			//sql.append(" (Select nvl(t2.FAmount,0) from  t_LHZ_BackJack t2  ");
			//sql.append(" where t2.FControlUnitID=t1.FControlUnitID");
			//sql.append(" and t2.FCustomerID=t1.FCustomerID  ");
			//sql.append(" and t2.FMaterialID=t1.FMaterialID  ");
			//sql.append(" and t2.FStatus=0 ) ");
			//sql.append(" where t1.FControlUnitID='"+FCUID+"' ");
			//sql.append(" and Exists ");
			
			//sql.append(" (Select t2.FAmount from  t_LHZ_BackJack t2  ");
			//sql.append(" where t2.FControlUnitID=t1.FControlUnitID");
			//sql.append(" and t2.FCustomerID=t1.FCustomerID  ");
			//sql.append(" and t2.FMaterialID=t1.FMaterialID  ");
			//sql.append(" and t2.FStatus=0 ) ");
			//com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());
			//更新本期预估
			
			
			
			sql=new StringBuffer();
			sql.append("/*dialect*/update T_LHZ_CustomerBal t1 set FDisItemId=");
			sql.append(" (");
			sql.append(" Select t2.FDisItemId  ");
			sql.append(" from  t_lhz_materialdisitem t2 ");
			sql.append(" where t2.FControlUnitID=t1.FControlUnitID");
			sql.append(" and t2.FMaterialID=t1.FMaterialID  ");
			sql.append(" ) ");
			
			sql.append(" where t1.FControlUnitID='"+FCUID+"' ");
			sql.append(" and Exists ");
			
			sql.append(" (");
			sql.append(" Select t2.FDisItemId  ");
			sql.append(" from  t_lhz_materialdisitem t2 ");
			sql.append(" where t2.FControlUnitID=t1.FControlUnitID");
			sql.append(" and t2.FMaterialID=t1.FMaterialID  ");
			sql.append(" ) ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx, sql.toString());
			
			
		} catch (BOSException e) {
			// return false;
			throw new BOSException("sql Execute Error :", e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new BOSException("sql Execute Error :", e);
		} finally {
			FStatus=true;
		}
		return FStatus;
	}
	/**
	 * 销售订单和销售退货申请单取数
	 * @param ctx
	 * @param FCUID
	 * @param FdpBeginDate
	 * @param FdpEndDate
	 * @param StrTable
	 * @throws BOSException
	 */
	public void saleOrderRpt(Context ctx,String FCUID,
			String FdpBeginDate,String FdpEndDate,
			String ordertable,String tablename,
			String FPeriodNumber,boolean ispersonA,boolean fisyr) throws BOSException {
		StringBuffer sql=new StringBuffer();
		sql=new StringBuffer();
		sql.append("Delete "+tablename+" where FControlUnitID='"+FCUID+"'");
		com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
					
		if(ordertable.equals("V_SD_SaleOrderJ")){
			String tablenameA=this.v_SD_SaleOrderJ(ctx, FCUID, FdpBeginDate, FdpEndDate);
			sql=new StringBuffer();
			sql.append(" insert into "+tablename+"( ");
			sql.append(" FControlUnitID,FAreaID,FSalePersonID,");
			sql.append(" FCustomerID,FMaterialID,FQty, ");
			sql.append(" FAmount,FDisAmount,FPeriodNumber,");
			sql.append(" FStatus,FLz,Fcxfy ");
			sql.append(" )");
			if(ispersonA==false){
				sql.append(" Select t1.FControlUnitID,t1.FSaleGroupID,t1.FSalePersonID, ");
			}else{
				sql.append(" Select t1.FControlUnitID,t1.FSaleGroupAID,t1.FSalePersonAID, ");
			}
			if(fisyr==false){
				sql.append(" t1.FCustomerID,t1.FMaterialID,sum(t1.FBaseQty) FQty, ");
			}else{
				sql.append(" t1.FCustomerBID,t1.FMaterialID,sum(t1.FBaseQty) FQty, ");
			}
			sql.append(" sum(t1.FAmount),sum(t1.FDISAMOUNT),"+FPeriodNumber+",");
			sql.append(" 0,sum(t1.FLZ),sum(t1.fcxfy) ");
			sql.append(" from "+tablenameA+" t1 ");
			if(ispersonA==false){
				sql.append(" Group by t1.FControlUnitID,t1.FSaleGroupID,t1.FSalePersonID,");
			}else{
				sql.append(" Group by t1.FControlUnitID,t1.FSaleGroupAID,t1.FSalePersonAID,");
			}
			if(fisyr==false){
				sql.append(" t1.FCustomerID,t1.FMaterialID");
			}else{
				sql.append(" t1.FCustomerbID,t1.FMaterialID");
			}
			com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
			
			sql=new StringBuffer();
			sql.append(" insert "+tablename);//统计 返点总计和结算金额总计
			sql.append(" (FControlUnitId,fdisamountall,fjsje)");
			sql.append(" select FControlUnitId,Fdisamountall,Fjsje from "+tablenameA);
			sql.append(" where FControlUnitId='abcdefghijklmn'");
			com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
			
			
			com.kingdee.eas.util.app.DbUtil.execute(ctx,"drop table "+tablenameA+"");
		}else if(ordertable.equals("V_IM_SaleIssueJ")){
			sql=new StringBuffer();
			sql.append(" insert into  "+tablename+"( ");
			sql.append(" FControlUnitID,FAreaID,FSalePersonID, ");
			sql.append(" FCustomerID,FMaterialID,FQty, ");
			sql.append(" FAmount,FDisAmount,FPeriodNumber,");
			sql.append(" FStatus,FLz");
			sql.append(" )");
			sql.append(" Select t1.FControlUnitID,t2.FSaleGroupID,t2.FSalePersonID,");
			if(fisyr==false){
				sql.append("  t1.FCustomerID,t2.FMaterialID,sum(t2.FBaseQty) FQty,  ");
			}else{
				sql.append(" t1.CFCustomerBID,t2.FMaterialID,sum(t2.FBaseQty) FQty,  ");
			}
			sql.append(" Sum(t2.FAmount),Sum(t1.CFDisAmount),"+FPeriodNumber+", ");
			sql.append(" 0,0");
			sql.append(" from T_IM_SaleIssueBill t1  ");
			sql.append(" inner join T_IM_SaleIssueentry t2 on t2.FParentID=t1.FID ");
			sql.append(" where t1.FControlUnitID='"+FCUID+"' ");
			sql.append(" and (t1.FBizDate>= {ts '"+ FdpBeginDate +"'} and t1.FBizDate<= {ts '"+ FdpEndDate +"'}) ");
			sql.append(" and  ( t1.FBaseStatus=1 or t1.FBaseStatus=2 ");
			sql.append(" or t1.FBaseStatus=4 or t1.FBaseStatus=5 ");
			sql.append(" or t1.FBaseStatus=6 or t1.FBaseStatus=7 ");
			sql.append(" or t1.FBaseStatus=0");
			sql.append(" ) ");
			//sql.append(" and t1.ftransactiontypeid in ( select fid from t_scm_transactiontype where fnumber in('203','204','233','254') ) ");
			//254 手工销售出库 204 普通销售出库
			sql.append(" group by t1.FControlUnitID,t2.FSaleGroupID,t2.FSalePersonID, ");
			if(fisyr==false){
				sql.append(" t1.FCustomerID,t2.FMaterialID ");
			}else{
				sql.append(" t1.CFCustomerbID,t2.FMaterialID ");
			}
			com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
		}else{
			sql=new StringBuffer();
			sql.append(" insert into "+tablename+"( ");
			sql.append(" FControlUnitID,FAreaID,FSalePersonID, ");
			sql.append(" FCustomerID,FMaterialID,FQty, ");
			sql.append(" FAmount,FDisAmount,FPeriodNumber,");
			sql.append(" FStatus,FLz");
			sql.append(" )");
			sql.append(" Select t1.FControlUnitID,t2.CFSaleGroupID,t2.CFSalePersonID,");
			if(fisyr==false){
				sql.append(" t1.Fasstactid,t2.FMaterialID,sum(t2.FBaseQty) FQty,  ");
			}else{
				sql.append(" t1.CFCustomerbID,t2.FMaterialID,sum(t2.FBaseQty) FQty,  ");
			}
			sql.append(" Sum(t2.FAmount),Sum(t2.CFDisAmountA),"+FPeriodNumber+", ");
			sql.append(" 0,0");
			sql.append(" from T_AR_OtherBill  t1  ");
			sql.append(" inner join T_AR_OtherBillentry t2 on t2.FParentID=t1.FID ");
			sql.append(" where t1.FControlUnitID='"+FCUID+"' ");
			sql.append(" and (t1.FBizDate>= {ts '"+ FdpBeginDate +"'} and t1.FBizDate<= {ts '"+ FdpEndDate +"'}) ");
			//StrRs.append(" and (t1.FBillStatus in(3,-3,-2,-1)) ");
			sql.append(" group by t1.FControlUnitID,t2.CFSaleGroupID,t2.CFSalePersonID, ");
			if(fisyr==false){
				sql.append(" t1.Fasstactid,t2.FMaterialID ");
			}else{
				sql.append(" t1.CFCustomerbID,t2.FMaterialID");
			}
			com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
		}
		
		
		if(ispersonA==true){
			sql=new StringBuffer();
			sql.append("/*dialect*/update "+tablename+" t1 set FSalePersonID=");
			sql.append(" (Select t2.fpersonid  ");
			sql.append(" from AAAreaECView t2 ");
			sql.append(" where t2.FControlUnitID=t1.FControlUnitID ");
			sql.append(" and t2.FSaleGroupID=t1.FAreaID  ");
			sql.append(" and t2.FCustomerID=t1.FCustomerID  ");
			sql.append(" ) ");
			sql.append(" where t1.FControlUnitID='"+FCUID+"' ");
			sql.append(" and Exists ");
			sql.append(" (Select t2.fpersonid  ");
			sql.append(" from AAAreaECView t2 ");
			sql.append(" where t2.FControlUnitID=t1.FControlUnitID ");
			sql.append(" and t2.FSaleGroupID=t1.FAreaID  ");
			sql.append(" and t2.FCustomerID=t1.FCustomerID  ");
			sql.append(" ) ");
			//DbUtil.execute(ctx,StrRs.toString());
			//batchStatement.execute(sql.toString());
			//batchStatement.executeBatch();
			
			
			sql=new StringBuffer();
			sql.append(" insert into "+tablename+"( ");
			sql.append(" FControlUnitID,FAreaID,FSalePersonID,");
			sql.append(" FCustomerID,FMaterialID,FQty, ");
			sql.append(" FAmount,FDisAmount,FStatus,Flz,");
			sql.append(" FPeriodNumber");
			sql.append(" )");
			sql.append(" Select t1.FControlUnitID,t1.FAreaID,t1.FSalePersonID, ");
			sql.append(" t1.FCustomerID,t1.FMaterialID,sum(t1.FQty),");
			sql.append(" sum(t1.FAmount),sum(t1.FDisAmount),1,0,");
			sql.append(" "+FPeriodNumber+"");
			sql.append(" from "+tablename+" t1 ");
			sql.append(" where t1.FControlUnitID='"+FCUID+"' ");
			sql.append(" and t1.FStatus=0 ");
			sql.append(" Group by t1.FControlUnitID,t1.FAreaID,t1.FSalePersonID,t1.FCustomerID,t1.FMaterialID ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
			
			
			sql=new StringBuffer();
			sql.append("Delete "+tablename+" where FControlUnitID='"+FCUID+"' and FStatus=0 ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
			
		} 
	}
	/**
	 * 销售出库单取数
	 * @param ctx
	 * @param FCUID
	 * @param FdpBeginDate
	 * @param FdpEndDate
	 * @param StrTable
	 * @throws BOSException
	 */
	public void saleIssueBillRptA(Context ctx,String FCUID,
			String FdpBeginDate,String FdpEndDate,
			String FPeriodNumber,String StrTable,boolean fStatus,boolean fisyr) throws BOSException {
//    	Connection con = null;
//		Statement batchStatement = null;
		StringBuffer sql=new StringBuffer();
		try {
//			con = getConnection(ctx);
//			batchStatement = con.createStatement();
//			
			sql=new StringBuffer();
			sql.append("Delete "+StrTable+" where FControlUnitID='"+FCUID+"'");
//			batchStatement.addBatch(sql.toString());
//			batchStatement.executeBatch();
			DbUtil.execute(ctx, sql.toString());
			//插入T_RPT_SaleOrder	
			sql=new StringBuffer();
			sql.append(" insert into "+StrTable+"( ");
			sql.append(" FControlUnitID,FAreaID,FSalePersonID, ");
			sql.append(" FCustomerID,FMaterialID,FQty, ");
			sql.append(" FAmount,FDisAmount,FStatus,");
			sql.append(" FPeriodNumber");
			sql.append(" )");
			sql.append(" Select t1.FControlUnitID,t2.FSaleGroupID,t2.FSalePersonID,");
			if(fisyr==false){
				sql.append("  t1.FCustomerID,t2.FMaterialID,sum(t2.FBaseQty) FQty,  ");
			}else{
				sql.append(" t1.CFCustomerBID,t2.FMaterialID,sum(t2.FBaseQty) FQty,  ");
			}
			sql.append(" Sum(t2.FAmount),Sum(t2.CFDisAmountA),0, ");
			sql.append(" "+FPeriodNumber+"");
			sql.append(" from T_IM_SaleIssueBill t1  ");
			sql.append(" inner join T_IM_SaleIssueentry t2 on t2.FParentID=t1.FID ");
			sql.append(" where t1.FControlUnitID='"+FCUID+"' ");
			sql.append(" and (t1.FBizDate>= {ts '"+ FdpBeginDate +"'} and t1.FBizDate<= {ts '"+ FdpEndDate +"'}) ");
			sql.append(" and (t1.FBaseStatus not in(3,-3,-2,-1)) ");
			sql.append(" and t1.ftransactiontypeid in ( select fid from t_scm_transactiontype where fnumber in('203','204','233','254') ) ");
			//254 手工销售出库 204 普通销售出库
			sql.append(" group by t1.FControlUnitID,t2.FSaleGroupID,t2.FSalePersonID, ");
			if(fisyr==false){
				sql.append(" t1.FCustomerID,t2.FMaterialID ");
			}else{
				sql.append(" t1.CFCustomerbID,t2.FMaterialID ");
			}
			DbUtil.execute(ctx, sql.toString());
			
			if(fStatus==true){
				sql=new StringBuffer();
				sql.append("/*dialect*/update "+StrTable+" t1 set FSalePersonID=");
				sql.append(" (Select t2.fpersonid  ");
				sql.append(" from AAAreaECView t2 ");
				sql.append(" where t2.FControlUnitID=t1.FControlUnitID ");
				sql.append(" and t2.FSaleGroupID=t1.FAreaID  ");
				sql.append(" and t2.FCustomerID=t1.FCustomerID  ");
				sql.append(" ) ");
				sql.append(" where t1.FControlUnitID='"+FCUID+"' ");
				sql.append(" and Exists ");
				sql.append(" (Select t2.fpersonid  ");
				sql.append(" from AAAreaECView t2 ");
				sql.append(" where t2.FControlUnitID=t1.FControlUnitID ");
				sql.append(" and t2.FSaleGroupID=t1.FAreaID  ");
				sql.append(" and t2.FCustomerID=t1.FCustomerID  ");
				sql.append(" ) ");
				DbUtil.execute(ctx,sql.toString());
			}
		
			sql=new StringBuffer();
			sql.append(" insert into "+StrTable+"( ");
			sql.append(" FControlUnitID,FAreaID,FSalePersonID,");
			sql.append(" FCustomerID,FMaterialID,FQty, ");
			sql.append(" FAmount,FDisAmount,FStatus,");
			sql.append(" FPeriodNumber");
			sql.append(" )");
			sql.append(" Select t1.FControlUnitID,t1.FAreaID,t1.FSalePersonID, ");
			sql.append(" t1.FCustomerID,t1.FMaterialID,sum(t1.FQty),");
			sql.append(" sum(t1.FAmount),sum(t1.FDisAmount),1,");
			sql.append(" "+FPeriodNumber+"");
			sql.append(" from "+StrTable+" t1 ");
			sql.append(" where t1.FControlUnitID='"+FCUID+"' ");
			sql.append(" and t1.FStatus=0 ");
			sql.append(" Group by t1.FControlUnitID,t1.FAreaID,t1.FSalePersonID,t1.FCustomerID,t1.FMaterialID ");
			DbUtil.execute(ctx, sql.toString());
			
			sql=new StringBuffer();
			sql.append("Delete "+StrTable+" where FControlUnitID='"+FCUID+"' and FStatus=0 ");
			DbUtil.execute(ctx, sql.toString());
			
		} catch (Exception er) {
			throw new BOSException("sql Execute Error :", er);
		} finally {
			
		}
	}
	public void otherBillRpt(Context ctx,String FCUID,
			String FdpBeginDate,String FdpEndDate,
			String FPeriodNumber,String StrTable,boolean fStatus,boolean fisyr) throws BOSException {
//    	Connection con = null;
//		Statement batchStatement = null;
		StringBuffer sql=new StringBuffer();
		try {
//			con = getConnection(ctx);
//			batchStatement = con.createStatement();
			
			sql=new StringBuffer();
			sql.append("Delete "+StrTable+" where FControlUnitID='"+FCUID+"'");
			DbUtil.execute(ctx, sql.toString());
			
			//插入T_RPT_SaleOrder	
			sql=new StringBuffer();
			sql.append(" insert into "+StrTable+"( ");
			sql.append(" FControlUnitID,FAreaID,FSalePersonID, ");
			sql.append(" FCustomerID,FMaterialID,FQty, ");
			sql.append(" FAmount,FDisAmount,FStatus,");
			sql.append(" FPeriodNumber");
			sql.append(" )");
			sql.append(" Select t1.FControlUnitID,t2.CFSaleGroupID,t2.CFSalePersonID,");
			if(fisyr==false){
				sql.append(" t1.Fasstactid,t2.FMaterialID,sum(t2.FBaseQty) FQty,  ");
			}else{
				sql.append(" t1.CFCustomerbID,t2.FMaterialID,sum(t2.FBaseQty) FQty,  ");
			}
			sql.append(" Sum(t2.FAmount),Sum(t2.CFDisAmountA),0, ");
			sql.append(" "+FPeriodNumber+"");
			sql.append(" from T_AR_OtherBill  t1  ");
			sql.append(" inner join T_AR_OtherBillentry t2 on t2.FParentID=t1.FID ");
			sql.append(" where t1.FControlUnitID='"+FCUID+"' ");
			sql.append(" and (t1.FBizDate>= {ts '"+ FdpBeginDate +"'} and t1.FBizDate<= {ts '"+ FdpEndDate +"'}) ");
			//StrRs.append(" and (t1.FBillStatus in(3,-3,-2,-1)) ");
			sql.append(" group by t1.FControlUnitID,t2.CFSaleGroupID,t2.CFSalePersonID, ");
			if(fisyr==false){
				sql.append(" t1.Fasstactid,t2.FMaterialID ");
			}else{
				sql.append(" t1.CFCustomerbID,t2.FMaterialID");
			}
			DbUtil.execute(ctx, sql.toString());
			if(fStatus==true){
				sql=new StringBuffer();
				sql.append("/*dialect*/update "+StrTable+" t1 set FSalePersonID=");
				sql.append(" (Select t2.fpersonid  ");
				sql.append(" from AAAreaECView t2 ");
				sql.append(" where t2.FControlUnitID=t1.FControlUnitID ");
				sql.append(" and t2.FSaleGroupID=t1.FAreaID  ");
				sql.append(" and t2.FCustomerID=t1.FCustomerID  ");
				sql.append(" ) ");
				sql.append(" where t1.FControlUnitID='"+FCUID+"' ");
				sql.append(" and Exists ");
				sql.append(" (Select t2.fpersonid  ");
				sql.append(" from AAAreaECView t2 ");
				sql.append(" where t2.FControlUnitID=t1.FControlUnitID ");
				sql.append(" and t2.FSaleGroupID=t1.FAreaID  ");
				sql.append(" and t2.FCustomerID=t1.FCustomerID  ");
				sql.append(" ) ");
				DbUtil.execute(ctx,sql.toString());
			}
			
			sql=new StringBuffer();
			sql.append(" insert into "+StrTable+"( ");
			sql.append(" FControlUnitID,FAreaID,FSalePersonID,");
			sql.append(" FCustomerID,FMaterialID,FQty, ");
			sql.append(" FAmount,FDisAmount,FStatus,");
			sql.append(" FPeriodNumber");
			sql.append(" )");
			sql.append(" Select t1.FControlUnitID,t1.FAreaID,t1.FSalePersonID, ");
			sql.append(" t1.FCustomerID,t1.FMaterialID,sum(t1.FQty),");
			sql.append(" sum(t1.FAmount),sum(t1.FDisAmount),1,");
			sql.append(" "+FPeriodNumber+"");
			sql.append(" from "+StrTable+" t1 ");
			sql.append(" where t1.FControlUnitID='"+FCUID+"' ");
			sql.append(" and t1.FStatus=0 ");
			sql.append(" Group by t1.FControlUnitID,t1.FAreaID,t1.FSalePersonID,t1.FCustomerID,t1.FMaterialID ");
			DbUtil.execute(ctx, sql.toString());
			
			sql=new StringBuffer();
			sql.append("Delete "+StrTable+" where FControlUnitID='"+FCUID+"' and FStatus=0 ");
			DbUtil.execute(ctx, sql.toString());
			
		} catch (Exception er) {
			throw new BOSException("sql Execute Error :", er);
		} finally {
//			SQLUtils.cleanup(batchStatement, con);
//			SQLUtils.cleanup(con);
		}
	}
	
	protected boolean isCodeRuleEnable(Context ctx, IObjectValue objValue,
			String companyId) throws EASBizException, BOSException {
		ICodingRuleManager codeRuleMgr = CodingRuleManagerFactory
				.getLocalInstance(ctx);
		return codeRuleMgr.isExist(objValue, companyId);
	}

	// 得到自动编码
	protected String getAutoCode(Context ctx, IObjectValue objValue,
			String companyId) throws EASBizException, BOSException {
		IOrgSwitchFacade orgSwitch = OrgSwitchFacadeFactory
				.getLocalInstance(ctx);
		orgSwitch.orgSwitch(companyId);
		ICodingRuleManager codeRuleMgr = CodingRuleManagerFactory
				.getLocalInstance(ctx);
		;
		if (codeRuleMgr.isUseIntermitNumber(objValue, companyId)) {
			return codeRuleMgr.readNumber(objValue, companyId);
		} else {
			return codeRuleMgr.getNumber(objValue, companyId);
		}
	}
	protected boolean _AA(Context ctx) throws BOSException, EASBizException {
		// TODO 自动生成方法存根
		return false;
	}
	/**
	 *计算出客户的销售情况,供销售报表使用
     * @throws SQLException 
	 */
	public String rptCustomerBack(Context ctx,RptParams params,
			String FCUID,String FPeriodNumber,
			String FdpBeginDate,String FdpEndDate,
			String rpttablename,boolean ispersonA) throws BOSException, SQLException {
		
		StringBuffer sql=new StringBuffer();
		FdpBeginDate=FdpBeginDate.substring(0,10);
		FdpEndDate=FdpEndDate.substring(0,10);
		FdpEndDate=FdpEndDate+" 23:59:59";
		
		//插入T_BRPT_PSaleContrast
		boolean FisSaleOrder;
		boolean FisSaleIssue;
		boolean FisOtherBill;
		FisSaleOrder=params.getBoolean("FisSaleOrder");//
		FisSaleIssue=params.getBoolean("FisSaleIssue");//
		FisOtherBill=params.getBoolean("FisOtherBill");//
		boolean fisyr=false;
		
//		int fisyhl=0;
//		fisyhl=params.getInt("Fisyhl");
//		
//		sql = new StringBuffer();
//		sql.append("Select * from t_LHZ_Inv where FControlUnitID='"+FCUID+"' ");
//		IRowSet rs = com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
//		if(rs.next()){
//			if(rs.getString("FStatus").equals("0")){
//				fisyr=false;
//			}else{
//				if(fisyhl==16){
//					fisyr=false;
//				}else{
//					fisyr=true;
//				}
//			}
//		}
		fisyr=false;
		String tablename=TableManagerFacadeFactory.getLocalInstance(ctx).getTableName("Jack");
		RptAppCommon aa=new RptAppCommon();
		aa.createRptSql(ctx, tablename);
		if(FisSaleOrder==true){
			aa.saleOrderRpt(ctx,FCUID,FdpBeginDate,FdpEndDate,"V_SD_SaleOrderJ",tablename,FPeriodNumber,ispersonA,fisyr);
		}else if(FisSaleIssue==true){
			aa.saleOrderRpt(ctx,FCUID,FdpBeginDate,FdpEndDate,"V_IM_SaleIssueJ",tablename,FPeriodNumber,ispersonA,fisyr);
		}else{
			aa.saleOrderRpt(ctx,FCUID,FdpBeginDate,FdpEndDate,"V_AR_OtherBillJ",tablename,FPeriodNumber,ispersonA,fisyr);
		}
		
		if(!rpttablename.equals("")){
			sql=new StringBuffer();
			sql.append(" insert into "+rpttablename+"( ");
			sql.append(" FControlUnitID,FAreaID,FSalePersonID,FCustomerID,FMaterialID");
			sql.append(" ) ");
			sql.append(" Select  FControlUnitID,FAreaID,FSalePersonID,FCustomerID,FMaterialID ");
			sql.append(" from "+tablename+" ");
			sql.append(" where FControlUnitID='"+FCUID+"' ");
			sql.append(" and Not Exists( ");
			sql.append(" Select * from "+rpttablename+" ");
			sql.append(" where "+rpttablename+".FControlUnitID="+tablename+".FControlUnitID ");
			sql.append(" and "+rpttablename+".FAreaID="+tablename+".FAreaID ");
			sql.append(" and "+rpttablename+".FSalePersonID="+tablename+".FSalePersonID ");
			sql.append(" and "+rpttablename+".FCustomerID="+tablename+".FCustomerID ");
			sql.append(" and "+rpttablename+".FMaterialID="+tablename+".FMaterialID ");
			sql.append(" ) ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
		}
		return tablename;
	}
	/**
	 * 销售订单和销售退货申请单取数
	 * @param ctx
	 * @param FCUID
	 * @param FdpBeginDate
	 * @param FdpEndDate
	 * @param StrTable
	 * @throws BOSException
	 */
	public void saleOrderRptA(Context ctx,String FCUID,
			String FdpBeginDate,String FdpEndDate,
			String ordertable,String StrTable,
			String FPeriodNumber,boolean fStatus,boolean fisyr) throws BOSException {
//    	Connection con = null;
//		Statement batchStatement = null;
		StringBuffer sql=new StringBuffer();
		try {
//			con = getConnection(ctx);
//			batchStatement = con.createStatement();
			
			sql=new StringBuffer();
			sql.append("Delete "+StrTable+" where FControlUnitID='"+FCUID+"'");
			DbUtil.execute(ctx, sql.toString());
				
			sql=new StringBuffer();
			sql.append(" insert into "+StrTable+"( ");
			sql.append(" FControlUnitID,FAreaID,FSalePersonID, ");
			sql.append(" FCustomerID,FMaterialID,FQty, ");
			sql.append(" FAmount,FDisAmount,FStatus,");
			sql.append(" FPeriodNumber");
			sql.append(" )");
			sql.append(" Select t1.FControlUnitID,t1.FSaleGroupID,t1.FSalePersonID,");
			if(fisyr==false){
//				sql.append(" t1.ForderCustomerID,t2.FMaterialID,sum(t2.cfnodsqty) FQty, ");
				sql.append(" t1.ForderCustomerID,t2.FMaterialID,sum(t2.fbaseqty) FQty, ");
			}else{
//				sql.append(" t1.CFCustomerBID,t2.FMaterialID,sum(t2.cfnodsqty) FQty, ");
				sql.append(" t1.CFCustomerBID,t2.FMaterialID,sum(t2.fbaseqty) FQty, ");
			}
			sql.append(" Sum(t2.FAmount),Sum(t2.CFDisAmountA),0, ");
			sql.append(" "+FPeriodNumber+"");
			sql.append(" from t_SD_SaleOrder t1  ");
			sql.append(" inner join t_SD_SaleOrderentry t2 on t2.FParentID=t1.FID ");
			sql.append(" where t1.FControlUnitID='"+FCUID+"' ");
			sql.append(" and (t1.FBizDate>= {ts '"+ FdpBeginDate +"'} and t1.FBizDate<= {ts '"+ FdpEndDate +"'}) ");
			sql.append(" and (t1.FBaseStatus not in(3,-3,-2,-1)) ");
			sql.append(" group by t1.FControlUnitID,t1.FSaleGroupID,t1.FSalePersonID,");
			if(fisyr==false){
				sql.append(" t1.FOrderCustomerID,t2.FMaterialID");
			}else{
				sql.append(" t1.CFCustomerbID,t2.FMaterialID");
			}
			DbUtil.execute(ctx, sql.toString());
			
			sql=new StringBuffer();
			sql.append(" insert into "+StrTable+"( ");
			sql.append(" FControlUnitID,FAreaID,FSalePersonID, ");
			sql.append(" FCustomerID,FMaterialID,FQty, ");
			sql.append(" FAmount,FDisAmount,FStatus,");
			sql.append(" FPeriodNumber");
			sql.append(" )");
			sql.append(" Select t1.FControlUnitID,t1.FSaleGroupID,t1.FSalePersonID,");
			if(fisyr==false){
//				sql.append(" t1.FReturnsCustomerID,t2.FMaterialID,sum(-1*t2.cfnodsqty) FQty, ");
				sql.append(" t1.FReturnsCustomerID,t2.FMaterialID,sum(-1*t2.fbaseqty) FQty, ");
			}else{
//				sql.append(" t1.CFCustomerBID,t2.FMaterialID,sum(-1*t2.cfnodsqty) FQty, ");
				sql.append(" t1.CFCustomerBID,t2.FMaterialID,sum(-1*t2.fbaseqty) FQty, ");
			}
			sql.append(" Sum(-1*t2.FAmount),Sum(-1*t2.CFDisAmountA),0, ");
			sql.append(" "+FPeriodNumber+"");
			sql.append(" from T_SD_SaleReturns t1  ");
			sql.append(" inner join T_SD_SaleReturnsentry t2 on t2.FParentID=t1.FID ");
			sql.append(" where t1.FControlUnitID='"+FCUID+"' ");
			sql.append(" and (t1.FBizDate>= {ts '"+ FdpBeginDate +"'} and t1.FBizDate<= {ts '"+ FdpEndDate +"'}) ");
			sql.append(" and (t1.FBaseStatus not in(3,-3,-2,-1)) ");
			sql.append(" group by t1.FControlUnitID,t1.FSaleGroupID,t1.FSalePersonID,");
			if(fisyr==false){
				sql.append(" t1.FReturnsCustomerID,t2.FMaterialID ");
			}else{
				sql.append(" t1.CFCustomerbID,t2.FMaterialID ");
			}
			DbUtil.execute(ctx, sql.toString());
			
			if(fStatus==true){
				sql=new StringBuffer();
				sql.append("/*dialect*/update "+StrTable+" t1 set FSalePersonID=");
				sql.append(" (Select t2.fpersonid  ");
				sql.append(" from AAAreaECView t2 ");
				sql.append(" where t2.FControlUnitID=t1.FControlUnitID ");
				sql.append(" and t2.FSaleGroupID=t1.FAreaID  ");
				sql.append(" and t2.FCustomerID=t1.FCustomerID  ");
				sql.append(" ) ");
				sql.append(" where t1.FControlUnitID='"+FCUID+"' ");
				sql.append(" and Exists ");
				sql.append(" (Select t2.fpersonid  ");
				sql.append(" from AAAreaECView t2 ");
				sql.append(" where t2.FControlUnitID=t1.FControlUnitID ");
				sql.append(" and t2.FSaleGroupID=t1.FAreaID  ");
				sql.append(" and t2.FCustomerID=t1.FCustomerID  ");
				sql.append(" ) ");
				//DbUtil.execute(ctx,StrRs.toString());
				DbUtil.execute(ctx, sql.toString());
			}
			sql=new StringBuffer();
			sql.append(" insert into "+StrTable+"( ");
			sql.append(" FControlUnitID,FAreaID,FSalePersonID,");
			sql.append(" FCustomerID,FMaterialID,FQty, ");
			sql.append(" FAmount,FDisAmount,FStatus,");
			sql.append(" FPeriodNumber");
			sql.append(" )");
			sql.append(" Select t1.FControlUnitID,t1.FAreaID,t1.FSalePersonID, ");
			sql.append(" t1.FCustomerID,t1.FMaterialID,sum(t1.FQty),");
			sql.append(" sum(t1.FAmount),sum(t1.FDisAmount),1,");
			sql.append(" "+FPeriodNumber+"");
			sql.append(" from "+StrTable+" t1 ");
			sql.append(" where t1.FControlUnitID='"+FCUID+"' ");
			sql.append(" and t1.FStatus=0 ");
			sql.append(" Group by t1.FControlUnitID,t1.FAreaID,t1.FSalePersonID,t1.FCustomerID,t1.FMaterialID ");
			DbUtil.execute(ctx, sql.toString());
			
			
			sql=new StringBuffer();
			sql.append("Delete "+StrTable+" where FControlUnitID='"+FCUID+"' and FStatus=0 ");
			DbUtil.execute(ctx, sql.toString());
			
			
		} catch (Exception er) {
			throw new BOSException("sql Execute Error :", er);
		} finally {
//			SQLUtils.cleanup(batchStatement, con);
//			SQLUtils.cleanup(con);
		}
	}
	public String createrptsql(String tablename){
		StringBuffer sql=new StringBuffer();
		sql.append("  Create table "+tablename+"(  ");
		sql.append("  FCONTROLUNITID VARCHAR2(44),");
		sql.append("  FAREAID        VARCHAR2(44),");
		sql.append("  FSALEPERSONID  VARCHAR2(44),");
		sql.append("  FCUSTOMERID    VARCHAR2(44),");
		sql.append("  FMATERIALID    VARCHAR2(44),");
		sql.append("  FDATE          VARCHAR2(44) default '' not null, ");
		sql.append("  FPERIODNUMBER  NUMBER(10) default 0, ");
		sql.append("  FQTY           NUMBER(28,2), ");
		sql.append("  FAMOUNT        NUMBER(28,2) default 0, ");
		sql.append("  FDISAMOUNT     NUMBER(28,2) default 0, ");
		sql.append("  FSTATUS        NUMBER(10) default 0 ");
		sql.append("  FLZ     NUMBER(28,2) default 0, ");
		sql.append("  ) ");
		return sql.toString();
	}
  public void createRptSql(Context ctx,String tablename) throws BOSException{
		StringBuffer sql=new StringBuffer();
		sql.append("/*dialect*/create table "+tablename+"(  ");
		sql.append("  FCONTROLUNITID   VARCHAR2(44), ");
		sql.append("  FAREAID          VARCHAR2(44), ");
		sql.append("  FSALEPERSONID    VARCHAR2(44), ");
		sql.append("  FCUSTOMERID      VARCHAR2(44), ");
		sql.append("  FCUSTOMERBID      VARCHAR2(44), ");
		sql.append("  FMATERIALGROUPID VARCHAR2(44), ");
		sql.append("  FMATERIALID      VARCHAR2(44), ");
		sql.append("  FDATE            VARCHAR2(44) default '', ");
		sql.append("  FPERIODNUMBER    VARCHAR2(44) default '', ");
		sql.append("  FMONTHQTY        NUMBER(28,2) default 0, ");
		sql.append("  FLASTMONTHQTY    NUMBER(28,2) default 0, ");
		sql.append("  FADDQTY          NUMBER(28,2) default 0, ");
		sql.append("  FQTYGROWTH       NUMBER(28,4) default 0, ");
		sql.append("  FMONTHAMOUNT     NUMBER(28,2) default 0, ");
	    sql.append("  FLASTMONTHAMOUNT NUMBER(28,2) default 0, ");
		sql.append("  FADDAMOUNT       NUMBER(28,2) default 0, ");
		sql.append("  FAMOUNTGROWTH    NUMBER(28,4) default 0, ");
		sql.append("  FMONTHPRICE      NUMBER(28,4) default 0, ");
		sql.append("  FLASTMONTHPRICE  NUMBER(28,4) default 0, ");
		sql.append("  FDAYQTY          NUMBER(28,4) default 0,");
		sql.append("  FQTY             NUMBER(28,2) default 0, ");
		sql.append("  FAMOUNT          NUMBER(28,2) default 0, ");
		sql.append("  FDISAMOUNT       NUMBER(28,2) default 0, ");
		
		sql.append("  FRETRUNQTY       NUMBER(28,2) default 0, ");
		sql.append("  FRETRUNAMOUNT       NUMBER(28,2) default 0, ");
		sql.append("  FLz      NUMBER(28,2) default 0, ");
		
		sql.append("  FbnQTY             NUMBER(28,2) default 0, ");
		sql.append("  FgroupQTY             NUMBER(28,2) default 0, ");
		sql.append("  FgroupbnQTY             NUMBER(28,2) default 0, ");
		sql.append("  FDISAMOUNTall       NUMBER(28,2) default 0, ");//订单返点
		sql.append("  Fjsje       NUMBER(28,2) default 0, ");//订单结算金额
		sql.append("  Fcxfy       NUMBER(28,2) default 0, ");//订单促销费用
		sql.append("  Fgroupid      VARCHAR2(44), ");
		sql.append("  Fyzzc      VARCHAR2(44) ,");
		
		sql.append("  FSTATUS          NUMBER(10) default 0 ");
		sql.append("  ) ");
//		sql.append(" tablespace EAS_D_LHJT_Temp2");
//		sql.append(" pctfree 10");
//		sql.append(" initrans 1");
//		sql.append(" maxtrans 255");
//		sql.append(" storage");
//		sql.append("  ( ");
//		sql.append("   initial 64K");
//		sql.append("   minextents 1");
//		sql.append("   maxextents unlimited");
//		sql.append("  ) ");
		com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
		sql=new StringBuffer();
		sql.append(" insert into t_lhz_table(fname,fdate)values('"+tablename+"',getdate())  ");
		com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
  }
  public String aasaleorderreturn(String fcuid){
	  StringBuffer sql=new StringBuffer();
	  sql.append("Select ");
	  sql.append("t1.fid, ");
	  sql.append(" t1.fcontrolunitid,t1.FBizDate FDate,t1.FBaseStatus, ");
	  sql.append(" t1.fordercustomerid fcustomerid,t2.FisPresent,t2.fmaterialid, ");
//	  sql.append(" t2.cfnodsqty  fqty,t2.Cfdisamounta ");
	  sql.append(" t2.fbaseqty  fqty,t2.Cfdisamounta ");
	  sql.append(" from t_sd_saleOrder t1 ");
	  sql.append(" inner join t_sd_saleorderentry t2 on t2.fparentid=t1.fid ");
	  sql.append(" where t1.fcontrolunitid='"+fcuid+"'");
	  sql.append(" and ( t1.FBaseStatus=1 or t1.FBaseStatus=2 ");
	  sql.append(" or t1.FBaseStatus=4 or t1.FBaseStatus=5 ");
	  sql.append(" or t1.FBaseStatus=6 or t1.FBaseStatus=7  ");
	  sql.append(" ) ");
	  sql.append(" union all ");
	  sql.append(" Select ");
	  sql.append(" t1.fid, ");
	  sql.append(" t1.fcontrolunitid,t1.FBizDate FDate,t1.FBaseStatus, ");
	  sql.append(" t1.FReturnsCustomerID fcustomerid,t2.FisPresent,t2.fmaterialid, ");
//	  sql.append(" -1*t2.cfnodsqty fqty, -1*t2.Cfdisamounta fdisamounta ");
	  sql.append(" -1*t2.fbaseqty fqty, -1*t2.Cfdisamounta fdisamounta ");
	  sql.append(" from t_sd_salereturns t1 ");
	  sql.append(" inner join t_sd_salereturnsentry t2 on t2.fparentid=t1.fid ");
	  sql.append(" where t1.fcontrolunitid='"+fcuid+"'");
	  sql.append(" and ( t1.FBaseStatus=1 or t1.FBaseStatus=2 ");
	  sql.append(" or t1.FBaseStatus=4 or t1.FBaseStatus=5 ");
	  sql.append(" or t1.FBaseStatus=6 or t1.FBaseStatus=7  ");
	  sql.append(" or t1.FBaseStatus=0 ");
	  sql.append(" ) ");
	  return "";
  }
  public String v_SD_SaleOrderJ(Context ctx,String cuid,String dpBeginDate,String dpEndDate) throws BOSException{
	StringBuffer sql=new StringBuffer();
	String tablename=TableManagerFacadeFactory.getLocalInstance(ctx).getTableName("JackA");;
	sql=new StringBuffer();
	sql.append("/*dialect*/create table "+tablename+"(  ");
	sql.append("  FCONTROLUNITID   VARCHAR2(44), ");
	sql.append("  fsalegroupid          VARCHAR2(44), ");
	sql.append("  fsalegroupAid          VARCHAR2(44), ");
	sql.append("  FSALEPERSONID    VARCHAR2(44), ");
	sql.append("  FSALEPERSONAID    VARCHAR2(44), ");
	sql.append("  FCUSTOMERID      VARCHAR2(44), ");
	sql.append("  FCUSTOMERBID      VARCHAR2(44), ");
	sql.append("  FMATERIALID      VARCHAR2(44), ");
	sql.append("  FisPresent    VARCHAR2(44) default '', ");
	sql.append("  FAmount        NUMBER(28,2) default 0, ");
	sql.append("  FQty    NUMBER(28,2) default 0, ");
	sql.append("  FBaseQty          NUMBER(28,2) default 0, ");
	sql.append("  FDISAMOUNT       NUMBER(28,2) default 0, ");
	sql.append("  FLZ NUMBER(28,2) default 0,");
	sql.append("  FdisamountAll NUMBER(28,2) default 0,");
	sql.append("  Fjsje NUMBER(28,2) default 0,");
	sql.append("  Fcxfy NUMBER(28,2) default 0 ");
	sql.append("  ) ");
//	sql.append(" tablespace EAS_D_LHJT_Temp2");
//	sql.append(" pctfree 10");
//	sql.append(" initrans 1");
//	sql.append(" maxtrans 255");
//	sql.append(" storage");
//	sql.append("  ( ");
//	sql.append("   initial 64K");
//	sql.append("   minextents 1");
//	sql.append("   maxextents unlimited");
//	sql.append("  ) ");
	com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
	
	sql=new StringBuffer();
	sql.append(" insert into "+tablename+"( ");
	sql.append(" FControlUnitID,fsalegroupid,FSalePersonID,");
	sql.append(" fsalegroupAid,fsalepersonaid,fcustomerid,");
	sql.append(" fcustomerbid,fmaterialid,FisPresent,");
	sql.append(" FAmount,fqty,FBaseQty,FDisAmount,FLz, fcxfy ");
	sql.append(" )");
	sql.append(" Select ");
	sql.append(" t1.fcontrolunitid,t1.fsalegroupid,t1.fsalepersonid, ");
	sql.append(" t1.cfsalegroupAid fsalegroupAid,t1.cfsalepersonaid fsalepersonaid,t1.fordercustomerid fcustomerid,");
	sql.append(" t1.cfcustomerbid fcustomerbid,t2.fmaterialid,  t2.FisPresent,");
	//sql.append(" t2.famount,t2.fqty fqty, t2.FBaseQty FBaseQty,t2.Cfdisamounta ");
//	sql.append(" t2.famount,t2.fqty fqty, t2.cfnodsqty FBaseQty,t1.CFDisAmount,t2.cflz,(t2.fbaseqty*t2.CFpromotionFee)/1000 fcxfy");
	sql.append(" t2.famount,t2.fqty fqty, t2.fbaseqty FBaseQty,t1.CFDisAmount,t2.cflz,(t2.fbaseqty*t2.CFpromotionFee)/1000 fcxfy");
	sql.append(" from t_sd_saleOrder t1 ");
	sql.append(" inner join t_sd_saleorderentry t2 on t2.fparentid=t1.fid ");
	sql.append(" where t1.FControlUnitID='"+cuid+"' ");
	sql.append(" and (t1.FBizDate>= {ts '"+ dpBeginDate +"'} and t1.FBizDate<= {ts '"+ dpEndDate +"'}) ");
	sql.append(" and  ( t1.FBaseStatus=1 or t1.FBaseStatus=2 ");
	sql.append(" or t1.FBaseStatus=4 or t1.FBaseStatus=5 ");
	sql.append(" or t1.FBaseStatus=6 or t1.FBaseStatus=7 ");
	sql.append(" or t1.FBaseStatus=0");
	sql.append(" ) ");
	com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
	
	sql=new StringBuffer();
	sql.append(" insert into "+tablename+"( ");
	sql.append(" FControlUnitID,fsalegroupid,FSalePersonID,");
	sql.append(" fsalegroupAid,fsalepersonaid,fcustomerid,");
	sql.append(" fcustomerbid,fmaterialid,FisPresent,");
	sql.append(" FAmount,fqty,FBaseQty,FDisAmount,FLz,Fcxfy ");
	sql.append(" )");
	sql.append(" Select ");
	sql.append(" t1.fcontrolunitid,t1.fsalegroupid,t1.fsalepersonid, ");
	sql.append(" t1.cfsalegroupAid fsalegroupAid,t1.cfsalepersonaid fsalepersonaid,t1.FReturnsCustomerID fcustomerid,");
	sql.append(" t1.cfcustomerbid fcustomerbid,t2.fmaterialid, t2.FisPresent, ");
	sql.append(" -1*t2.famount famount, ");
	sql.append(" -1*t2.fqty fqty, ");
//	sql.append(" -1*t2.cfnodsqty FBaseQty, ");
	sql.append(" -1*t2.fbaseqty FBaseQty, ");
	//sql.append(" -1*t2.Cfdisamounta cfdisamounta ");
	sql.append(" -1*t1.CfDisAmount,-1*t2.cflz,0 ");
	sql.append(" from t_sd_salereturns t1 ");
	sql.append(" inner join t_sd_salereturnsentry t2 on t2.fparentid=t1.fid ");
	sql.append(" where t1.FControlUnitID='"+cuid+"' ");
	sql.append(" and (t1.FBizDate>= {ts '"+ dpBeginDate +"'} and t1.FBizDate<= {ts '"+ dpEndDate +"'}) ");
	sql.append(" and  ( t1.FBaseStatus=1 or t1.FBaseStatus=2 ");
	sql.append(" or t1.FBaseStatus=4 or t1.FBaseStatus=5 ");
	sql.append(" or t1.FBaseStatus=6 or t1.FBaseStatus=7 ");
	sql.append(" or t1.FBaseStatus=0");
	sql.append(" ) ");
	com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
	
	sql=new StringBuffer();//统计 销售订单上返点和结算金额用
	sql.append(" insert into "+tablename+"( ");
	sql.append(" FControlUnitID,FdisamountAll,fjsje");
	sql.append(" )");
	sql.append(" Select ");
	sql.append(" 'abcdefghijklmn',sum(t1.cfdisamount),sum(t1.cfjsje)");
	sql.append(" from t_sd_saleOrder t1 ");
	//sql.append(" inner join t_sd_saleorderentry t2 on t2.fparentid=t1.fid ");
	sql.append(" where t1.FControlUnitID='"+cuid+"' ");
	sql.append(" and (t1.FBizDate>= {ts '"+ dpBeginDate +"'} and t1.FBizDate<= {ts '"+ dpEndDate +"'}) ");
	sql.append(" and  ( t1.FBaseStatus=1 or t1.FBaseStatus=2 ");
	sql.append(" or t1.FBaseStatus=4 or t1.FBaseStatus=5 ");
	sql.append(" or t1.FBaseStatus=6 or t1.FBaseStatus=7 ");
	sql.append(" or t1.FBaseStatus=0");
	sql.append(" ) ");
	com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
	
	return tablename;
  }
}