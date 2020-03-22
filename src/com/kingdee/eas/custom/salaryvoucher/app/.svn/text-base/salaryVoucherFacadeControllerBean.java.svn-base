package com.kingdee.eas.custom.salaryvoucher.app;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.kingdee.bos.*;
import com.kingdee.bos.bi.model.DB.DBUtil;
import com.kingdee.bos.ctrl.analysis.web.ext.DateUtil;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.ISQLExecutor;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.cbos.process.vm.internal.f.tcf.Finally;
import com.kingdee.cbos.process.vm.internal.t.a.Decimal;
import com.kingdee.eas.base.forewarn.SimpleForewarnDeal;
import com.kingdee.eas.base.ssc.UserInfo;
import com.kingdee.eas.basedata.assistant.Period;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.assistant.VoucherType;
import com.kingdee.eas.basedata.assistant.VoucherTypeFactory;
import com.kingdee.eas.basedata.assistant.VoucherTypeInfo;
import com.kingdee.eas.basedata.master.account.AccountViewFactory;
import com.kingdee.eas.basedata.master.account.AccountViewInfo;
import com.kingdee.eas.basedata.org.AdminOrgUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitCollection;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.basedata.person.IPerson;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.EASDBException;
import com.kingdee.eas.common.TableManagerFacadeFactory;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.salaryvoucher.CmpItem;
import com.kingdee.eas.custom.salaryvoucher.CmpItemFactory;
import com.kingdee.eas.custom.salaryvoucher.CmpItemInfo;
import com.kingdee.eas.custom.salaryvoucher.ICmpItem;
import com.kingdee.eas.custom.salaryvoucher.SCalSchemeFactory;
import com.kingdee.eas.custom.salaryvoucher.SCalSchemeInfo;
import com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntry;
import com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryCmpItemInfo;
import com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryFactory;
import com.kingdee.eas.custom.salaryvoucher.SalaryVoucherEntryInfo;
import com.kingdee.eas.custom.salaryvoucher.SalaryVoucherInfo;
import com.kingdee.eas.custom.salaryvoucher.SalaryVoucherPersonInfo;
import com.kingdee.eas.fi.ar.ImportException;
import com.kingdee.eas.fi.gl.IWSVoucher;
import com.kingdee.eas.fi.gl.Voucher;
import com.kingdee.eas.fi.gl.VoucherInfo;
import com.kingdee.eas.fi.gl.WSVoucherCollection;
import com.kingdee.eas.fi.gl.WSVoucherFactory;
import com.kingdee.eas.fi.gl.WSVoucherInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;


public class salaryVoucherFacadeControllerBean extends AbstractsalaryVoucherFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.salaryvoucher.app.salaryVoucherFacadeControllerBean");

	Connection conn =null;
	Statement state=null;
	Connection conn2=null;
	int count=1;


	String VoucherCode="";//凭证编号编号

	String VoucherTypes="";//凭证类别


	/**
	 * 生成凭证的主方法
	 */
	@Override
	protected String[] _createSalaryVoucher(Context ctx,IObjectValue periodInfo, IObjectValue salaryVoucher,String[] conInfo)
	throws BOSException {
		// TODO Auto-generated method stub

		
		PeriodInfo pInfo = (PeriodInfo)periodInfo;
		SalaryVoucherInfo svInfo = (SalaryVoucherInfo)salaryVoucher;

		VoucherCode=createVoucherCode(ctx);//手动生成的凭证编号



		//创建一张临时表tempTable1，临时表中获取  某一期间的薪酬发放的基本数据：薪酬项目，职员，金额等
		String tempTable1=createTempTableBaseData(ctx);
		//		getSHRbaseInfo(ctx,tempTable1,pInfo,svInfo);
		if(tempTable1.equals("noData")){
			MsgBox.showInfo("没有当前选择期间的薪酬发放数据");
			return null;
		}


		//创建第二张临时表，整理tempTable1中的数据，并填充到表中
		String tempTable="";
		try {
			tempTable=createTempTable(ctx);
		} catch (EASDBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for(int i=0;i<svInfo.getEntrys().size();i++){
			if(svInfo.getEntrys().get(i).getAccounting()!=null){
				getSHRbaseInfo(ctx,tempTable1,pInfo,svInfo,i,conInfo);


				updateTempTable(ctx,pInfo,svInfo,tempTable1,tempTable,svInfo.getEntrys().get(i),VoucherCode);
			}

		}
		String[] msg = this._impVoucher(ctx, tempTable, VoucherCode, 0,svInfo,pInfo);
		return msg;
	}


	/**
	 * 根据初始临时表的数据更新 优化临时表的数据
	 * @param info     期间
	 * @param svInfo   模板
	 * @param tempTabel初始表
	 */
	private void updateTempTable(Context ctx, PeriodInfo info,
			SalaryVoucherInfo svInfo, String tempTabel,String tempTable,SalaryVoucherEntryInfo sveInfo,String voucherCode) {
		// TODO Auto-generated method stub



		String asstActType1="";
		String asstActType2="";

		if(sveInfo!=null&&sveInfo.getAssistActItem()!=null){
			for(int i=0;i<sveInfo.getAssistActItem().size();i++){
				if(sveInfo.getAssistActItem().get(i).getAssistActItemName().equals("行政组织")){
					if(i==0)
						asstActType1 = "行政组织";
					else if(i==1)
						asstActType2="行政组织";
				}
				else if(sveInfo.getAssistActItem().get(i).getAssistActItemName().equals("职员")){
					if(i==0)
						asstActType1 = "职员";
					else if(i==1)
						asstActType2="职员";
				}
				else if(sveInfo.getAssistActItem().get(i).getAssistActItemName().equals("员工性质")){
					if(i==0)
						asstActType1 ="员工性质";
					else if(i==1)
						asstActType2="员工性质";
				}
				else if(sveInfo.getAssistActItem().get(i).getAssistActItemName().equals("研发项目")){
					if(i==0)
						asstActType1 ="研发项目";
					else if(i==1)
						asstActType2="研发项目";
				}
			}
		}



		//查询出数据放入临时表
		StringBuffer sql = new StringBuffer();
		sql.append(" /*dialect*/insert into "+tempTable+" (");
		sql.append(" bizDate,voucherNumber,entrySeq,voucherAbstract,accountNumber,accountName,");//1*6
		sql.append(" entryDC,debitAmount,creditAmount,asstActType1,asstActNumber1,asstActName1,");//2*6
		sql.append(" asstActType2,asstActNumber2,asstActName2");
		sql.append(" )");


		//期间偏离值的处理
		//		int actYear = info.getPeriodYear();
		//		int actMonth = info.getPeriodNumber();
		//		int PeriodDeviationValue = svInfo.getPeriodDeviationValue();
		//		if(actMonth+PeriodDeviationValue<1){
		//			actMonth=13+PeriodDeviationValue;
		//			actYear-=1;
		//		}
		//		else if(actMonth+PeriodDeviationValue>12){
		//			actMonth=actMonth+PeriodDeviationValue-12;
		//			actYear+=1;
		//		}
		//		String actDate="";
		//		if(actMonth<10)
		//			actDate = String.valueOf(actYear)+"-0"+String.valueOf(actMonth)+"-"+"01";
		//		else
		//			actDate = String.valueOf(actYear)+"-"+String.valueOf(actMonth)+"-"+"01";
		//		sql.append("select '").append(actDate).append("','").append(voucherCode).append("',");



		sql.append("select to_char(sysdate,'yyyy-MM-dd'),'").append(voucherCode).append("',");
		sql.append(" t3.fseq,t3.FAbstactInfo,t6.fnumber,t6.fname_l2,");//1*6
		sql.append(" decode(t3.FDebitOrCredit,0,0,1,1,null),");

		if(asstActType2.equals("")){
			sql.append(" sum(decode(t3.FDebitOrCredit,1,t1.famount,0)),");
			sql.append(" sum(decode(t3.FDebitOrCredit,0,t1.famount,0)),");
		}
		else
		{
			sql.append(" sum(decode(t3.FDebitOrCredit,1,t1.famount,0))/2,");
			sql.append(" sum(decode(t3.FDebitOrCredit,0,t1.famount,0))/2,");
		}








		appendStringBuffer(asstActType1,sql,0);
		appendStringBuffer(asstActType2,sql,1);





		sql.append(" from T_SAL_SalaryVoucherEntry t3"); 
		sql.append(" inner join T_SAL_SalaryVoucherCmpItem t2 on t3.fid=t2.fparentid");
		sql.append(" and t3.fseq=").append(sveInfo.getSeq());
		sql.append(" and t3.fid='").append(sveInfo.getId().toString()).append("'");

		sql.append(" inner join ").append(tempTabel).append(" t1 on t2.FCmpItemCode=t1.fcmpitemnum");
		sql.append(" and t1.fseq=").append(sveInfo.getSeq());


		if(sveInfo.getScaleScheme()!=null){
			String scalSchemeID = sveInfo.getScaleScheme().getId().toString();
			SCalSchemeInfo scaleSchemeInfo;
			try {
				scaleSchemeInfo = SCalSchemeFactory.getLocalInstance(ctx).getSCalSchemeInfo(new ObjectUuidPK(scalSchemeID));
				sql.append(" and t1.fSCalSchemeID='").append(scaleSchemeInfo.getScalSchemeID()).append("'");
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}




		sql.append(" left join T_SAL_SalaryVAAI t4 on t4.fparentid=t3.fid");
		sql.append(" inner join T_BD_AccountView t6 on t6.fid=t3.FAccountingID");
		sql.append(" inner join T_SAL_PersonRelation  t8 on t8.FShrPerson=t1.fpersonNum");

		sql.append(" and t8.FCompanyOrgID='").append(svInfo.getCompanyOrg().getId().toString()).append("'");

		sql.append(" inner join t_org_admin  t9 on t9.fid=t8.FAdminOrgUnitID");
		sql.append(" inner join T_SAL_SalaryVoucherPerson  t10 on");
		sql.append(" t10.FShrPersonNum=t1.fpersonNum and t10.fparentid='").append(svInfo.getId().toString()).append("'");



		//		sql.append(" from ").append(tempTabel).append(" t1");
		//
		//		sql.append(" inner join T_SAL_CmpItem t5 on t5.fnumber=t1.fcmpitemnum and t1.fseq=").append(sveInfo.getSeq());
		//		sql.append(" inner join T_SAL_SalaryVoucherCmpItem t2 on t2.FCmpItemNumID=t5.fid ");
		//
		//
		//		sql.append(" and t2.fid in ('");
		//        for(int i=0;i<sveInfo.getCmpItem().size();i++){
		//        	sql.append(sveInfo.getCmpItem().get(i).getId().toString()).append("'");
		//        	if(i<sveInfo.getCmpItem().size()-1)
		//        		sql.append(",");
		//        	else
		//        		sql.append(")");
		//        }
		//		
		//
		//
		//
		//		sql.append(" inner join T_SAL_SalaryVoucherEntry   t3 on t3.fid=t2.fparentid and t3.fseq=").append(sveInfo.getSeq());
		//		sql.append(" and t3.fid='").append(sveInfo.getId().toString()).append("'");
		//		sql.append(" left join T_SAL_SalaryVAAI t4 on t4.fparentid=t3.fid");
		//		sql.append(" inner join T_BD_AccountView t6 on t6.fid=t3.FAccountingID");
		//		//		sql.append(" inner join t_bd_person t7 on t1.fpersonNum=t7.fnumber");
		//		//		sql.append(" inner join t_hr_personPosition t8 on t7.fid=t8.fpersonid");
		//		sql.append(" inner join T_SAL_PersonRelation  t8 on t8.FShrPerson=t1.fpersonNum");
		//		sql.append(" inner join t_org_admin  t9 on t9.fid=t8.FAdminOrgUnitID");
		//		sql.append(" inner join T_SAL_SalaryVoucherPerson  t10 on t10.FShrPersonNum=t1.fpersonNum");



		sql.append(" group by to_char(sysdate,'yyyy-MM-dd'),'").append(voucherCode).append("',");
		sql.append(" t3.fseq,t3.FAbstactInfo,t6.fnumber,t6.fname_l2,");//1*6
		sql.append(" decode(t3.FDebitOrCredit,0,0,1,1,null),");
		appendStringBuffer(asstActType1,sql,0);
		appendStringBuffer(asstActType2,sql,1);



		sql.append(" order by t3.fseq");
		try {
			DbUtil.execute(ctx, sql.toString());
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	protected void appendStringBuffer(String str,StringBuffer sb,int seq){
		if(!str.equals("")){
			if(str.equals("行政组织"))
				sb.append("'行政组织',t9.FNumber,t9.fname_l2");		
			else if(str.equals("职员"))
				sb.append("'职员',t8.FEASPersonNum,t8.FEASPersonName");
			else if(str.equals("研发项目"))
				sb.append("'研发项目',t10.FGreenDreamProjectCode,t8.FGreenDreamProjectName");
			else if(str.equals("员工性质"))
				sb.append("'员工性质',t8.FPersonNatureCode,t8.FPersonNatureName");

			if(seq==0)
				sb.append(",");
		}
		else{
			sb.append("null,null,null");
			if(seq==0)
				sb.append(",");
		}
	}








	/**
	 * 存放直接取到的薪酬发放结果的值得表
	 * 注：临时表1，最原始的表
	 */
	private String  createTempTableBaseData(Context ctx) throws BOSException{
		String tablename=TableManagerFacadeFactory.getLocalInstance(ctx).getTableName("VoucherTempTable1");
		StringBuffer sql=new StringBuffer();
		sql.append(" create  table " + tablename + "(");
		sql.append(" fseq int,");//来源凭证对应关系的分录号
		sql.append(" fpersonNum varchar(100),");
		sql.append(" fcmpItemNum varchar(100),");
		sql.append(" fperiodYear int,");
		sql.append(" fperiodNumber int,");
		sql.append(" famount decimal(28,10),");
		sql.append(" fVouchercmpItemEntryid varchar(100),");
		sql.append(" fSCalSchemeID varchar(100)");//计算规则
		sql.append(" )");
		com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
		return tablename;
	}

	/**
	 * 创建一张临时表，并查询出了一行行数据，插入到临时表中
	 * @param ctx
	 * @param tempTable    要插入数据的临时表表名
	 * @param periodInfo   会计期间
	 * @param svInfo       凭证对应关系单据info
	 * @param seq          当前的对应关系
	 * @return
	 * @throws BOSException
	 */
	protected String getSHRbaseInfo(Context ctx,String tempTable,PeriodInfo periodInfo,SalaryVoucherInfo svInfo,int seq,String[] conInfo) throws BOSException {
		try {


			Connection conn2=getConnection(ctx);//oracle本地数据库连接



			StringBuffer sql=new StringBuffer();
			sql.append(" insert into "+tempTable );
			sql.append(" values(?,?,?,?,?,?,?,?)");
			PreparedStatement statement=conn2.prepareStatement(sql.toString());

			getConnection(conInfo);//oracle连接sHR数据库
			StringBuffer sb=  new StringBuffer();

			sb.append("/*dialect*/ select ").append(seq+1).append(" as fseq,");



			sb.append(" '").append(svInfo.getEntrys().get(seq).getCmpItem().get(0).getId().toString()).append("' as svcmpitem,");


			sb.append(" t1.fpersonID personID,t5.fname_l2 personName,t5.fnumber personNum,");
			sb.append(" t4.fname_l2 cmpItemName,t4.fnumber cmpItemNum,t3.fSortSn sortSeq,");
			sb.append(" decode(t3.fsortsn,1,t1.s1,2,t1.s2,3,t1.s3,4,t1.s4,5,t1.s5,6,t1.s6,7,t1.s7,8,t1.s8,9,t1.s9,10,t1.s10,11,t1.s11,12,t1.s12,13,t1.s13,61,t1.s61,62,t1.s62,63,t1.s63,64,t1.s64) amount,");
			sb.append(" t2.fid");
			sb.append(" from t_hr_scmpcaltable t1");
			sb.append(" inner join T_HR_SCalScheme t2 on t2.fid=t1.FCalSchemeID");
			sb.append(" inner join T_HR_SCalSchemeItem t3 on t3.FCalSchemeID=t2.fid"); 
			sb.append(" inner join  T_HR_SCmpItem t4 on t3.FCmpItemID=t4.fid");
			sb.append(" inner join T_BD_Person t5 on t5.fid=t1.fpersonID");
			sb.append(" inner join T_HR_PersonPosition t6 on t6.FpersonID=t5.fid");
			//			sql.append(" inner join T_SAL_PersonRelation t7 on t7.FEASPersonNum=t5.fnumber");			
			sb.append(" where t1.s1 is not null");

			//期间匹配
			sb.append(" and t1.fperiodYear=").append(periodInfo.getPeriodYear());
			sb.append(" and t1.fperiodMonth=").append(periodInfo.getPeriodNumber());



			//员工匹配

			int ss=0;
			for(int i=0;i<svInfo.getPerson().size();i++){

				if(!svInfo.getPerson().get(i).getBoolean("selected")){
					if(ss==0)
					{sb.append(" and t5.fnumber not in (");sb.append("'").append(svInfo.getPerson().get(i).getShrPersonNum()).append("'");ss++;}
					else
						sb.append(",'").append(svInfo.getPerson().get(i).getShrPersonNum()).append("'");

				}					
			}
			if(ss!=0)
				sb.append(")");

			//薪酬项目匹配
			ICmpItem iCmpItem = CmpItemFactory.getLocalInstance(ctx);
			sb.append(" and t4.fnumber in (");
			for(int i=0;i<svInfo.getEntrys().get(seq).getCmpItem().size();i++){		
				String cmpItemID= svInfo.getEntrys().get(seq).getCmpItem().get(i).getCmpItemNum().getId().toString();
				CmpItemInfo cmpItem = iCmpItem.getCmpItemInfo(new ObjectUuidPK(cmpItemID));
				sb.append("'").append(cmpItem.getNumber()).append("'");
				if(i<svInfo.getEntrys().get(seq).getCmpItem().size()-1)
					sb.append(",");
				else
					sb.append(")");
			}

			sb.append(" order by t5.fnumber,t3.FSortSn");

			try {
				state=conn.prepareStatement(sb.toString());
				ResultSet rs = state.executeQuery(sb.toString());

				while(rs.next()) {
					if(rs.getString("personNum")==null)
						return "noData";
					statement.setInt(1, rs.getInt("fseq"));
					statement.setString(2,rs.getString("personNum"));
					statement.setString(3,rs.getString("cmpItemNum"));
					statement.setInt(4,periodInfo.getPeriodYear());
					statement.setInt(5,periodInfo.getPeriodNumber());
					statement.setBigDecimal(6,rs.getBigDecimal("amount"));
					statement.setString(7,rs.getString("svcmpitem"));
					statement.setString(8,rs.getString("fid"));
					statement.executeUpdate();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if(statement!=null)
				statement.close();
			closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempTable;
	}





	/**
	 * sql数据库连接
	 */
	public Connection getConnTl(Context ctx) throws BOSException {
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
			DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
			String url = "jdbc:jtds:sqlserver://192.168.0.250:1433/BailiAcc"; // orcl为数据库的SID
			String user = "sa";
			String password = "Admin_qdbaili";
			StringBuffer sql=new StringBuffer();
			sql.append(" select password from t_dai_password");
			IRowSet rs=com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,sql.toString());
			if(rs.next()){
				String pwd=rs.getString("password");
				if(pwd!=null&&!pwd.equals("")) {
					password=pwd;
				}
			}
			conn = DriverManager.getConnection(url, user, password);
		} catch (InstantiationException e) {
			new BOSException("错误：",e);
		} catch (IllegalAccessException e) {
			new BOSException("错误：",e);
		} catch (ClassNotFoundException e) {
			new BOSException("错误：",e);
		} catch (SQLException e) {
			throw new BOSException("错误：",e);
		}
		return conn;
	}

	/**
	 * 关闭连接
	 */
	public void closeConn() throws SQLException {
		if(state!=null)
			state.close();
		conn.close();
	}

	/**
	 * 根据员工的sHR编码获得员工的EAS信息
	 */
	protected String _getName(Context ctx, String number) throws BOSException {
		String name="";
		try {
			conn=this.getConnection(ctx);
			state=conn.createStatement();
			StringBuffer sql=new StringBuffer();
			sql.append(" select custName from tblcustinfo");
			sql.append(" where CustCode='"+number+"'");
			ResultSet rs=state.executeQuery(sql.toString());
			if(rs.next()) {
				name=rs.getString("custName");
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StringBuffer sb=new StringBuffer();
		sb.append(" select * from T_SAL_PersonRelation");
		sb.append(" where  fshrperson='").append(number).append("'");
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
		try {
			if(rs.getRow()>1){
				String str="当前系统中存在多个与sHR编码为"+number+"员工对应的人员";
				MsgBox.showInfo(str);
				return null;
			}
			if(rs.getRow()==0){
				String str="当前系统中不存在与sHR编码为"+number+"员工对应的人员";
				MsgBox.showInfo(str);
				return null;
			}
			if(rs.next()){
				name=rs.getString("FEASPersonname");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return name;
	}





	/**
	 * 根据已获得临时表等信息  引入凭证 接口
	 */
	protected String[] _impVoucher(Context ctx, String tablename,String voucherNumber,int flag,SalaryVoucherInfo svInfo,PeriodInfo pInfo) throws BOSException {
		String cuid=ContextUtil.getCurrentFIUnit(ctx).getId().toString();
		String msg[] = new String[2];
		String accNumberOld="";	 
		count=1;
		try {
			WSVoucherCollection WSVC = new WSVoucherCollection();
			WSVoucherInfo info = new WSVoucherInfo();
			StringBuffer sql = new StringBuffer();
			sql.append(" select distinct(*) from " + tablename );
			if(voucherNumber!=null&&!voucherNumber.equals("")) {
				sql.append(" where voucherNumber='"+voucherNumber+"'");
			}
			sql.append(" order by voucherNumber,entrySeq");
			IRowSet rs = com.kingdee.eas.util.app.DbUtil.executeQuery(ctx, sql.toString());
			while (rs.next()) {
				String accNumberNew=rs.getString("accountNumber");
				if(rs.getRow()==1) {
					accNumberOld=accNumberNew;
				}
				if(rs.getDouble("creditAmount")==0) {//为借方时才执行
					if(rs.getRow()!=1&&accNumberOld!=null&&accNumberNew!=null&&!accNumberOld.equals(accNumberNew)){//科目不同时，分录号加1
						accNumberOld=accNumberNew;
						count++;
					}
				}
				else {
					count++;
				}
				info = new WSVoucherInfo();
				buildBillHead(ctx, info, rs, cuid,flag,svInfo,pInfo);
				WSVC.add(info);
			}
			if (WSVC.size() > 0) {
				String[][] ls = null;
				IWSVoucher wsvoucher = WSVoucherFactory.getLocalInstance(ctx);
				ls = wsvoucher.importVoucher(WSVC, 0, 1);
				if (ls[0][4].equals("0000")) {
					msg[0]="凭证导入成功！";
					msg[1]=ls[0][6];
				} else {
					msg[0] = "凭证导入失败,错误代码:";
					msg[1] = ls[0][4] + ls[0][5];
				}
			} else {
				throw new BOSException("凭证导入错误 : 没有凭证信息", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}





	/**
	 * 填写会计凭证表头信息
	 */
	private void buildBillHead(Context ctx, WSVoucherInfo info, IRowSet rs, String cuid,int flag,SalaryVoucherInfo svInfo, PeriodInfo pInfo) throws BOSException, EASBizException, SQLException {
		ObjectUuidPK objectUuidpk = new ObjectUuidPK(cuid);// 需要修改
		CtrlUnitInfo cuInfo = CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(objectUuidpk);
		if (cuInfo == null) {
			throw new ImportException(ImportException.CURRENCYNOTEXIST);
		}

		String date = rs.getString("bizDate");
		if(!date.substring(4, 5).equals("-"))
			date=date.substring(0, 4)+"-"+date.substring(4, 6)+"-"+"01";

		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String currentdate = sdf.format(new Date());

		java.sql.Timestamp timeStamp = Timestamp.valueOf(currentdate + " 00:00:00");
		// 借 科目余额方向 -1贷;1借
		info.setCompanyNumber(cuInfo.getNumber());// companyNumber(公司编码)是

		info.setBookedDate(timeStamp); // bookedDate(记账日期)是
		info.setBizDate(timeStamp);// bizDate(业务日期)是


		int year = Integer.parseInt(date.substring(0, 4));
		int PeriodNumber = Integer.parseInt(date.substring(5, 7));



		info.setPeriodYear(year);// periodYear(会计期间-年)是


		info.setPeriodNumber(PeriodNumber);// periodNumber(会计期间-编码)是

		
		info.setVoucherType(svInfo.getVoucherType().getName());// voucherType(凭证字（凭证类型）)是

		info.setVoucherNumber(rs.getString("voucherNumber"));// voucherNumber(凭证号)是
		//
		//		if(flag==0) {
		//			info.setEntrySeq(count);// entrySeq(分录行号)是
		//		}
		//		else {
		info.setEntrySeq(rs.getInt("entryseq"));// entrySeq(分录行号)是  通联
		//		}

		String FAbstract = rs.getString("voucherAbstract");
		if (FAbstract == null)
			FAbstract = "";
		info.setVoucherAbstract(FAbstract);// voucherAbstract(摘要)否
		String AccountNumber=rs.getString("AccountNumber");
		info.setAccountNumber(AccountNumber);// accountNumber(科目)是

		info.setCurrencyNumber("BB01");//currencyNumber(币种)是
		// vouchers0.setLocalRate(1);//localRate(汇率)否

		int dc=rs.getInt("EntryDC");
		info.setEntryDC(dc);// entryDC(方向)是
		double FAmount = 0;
		if (dc == 1) {
			FAmount = rs.getDouble("debitAmount");
			info.setDebitAmount(FAmount);// debitAmount(借方金额)是
		} else {
			FAmount = rs.getDouble("creditAmount");
			info.setCreditAmount(FAmount);// creditAmount(贷方金额)是
		}

		info.setOriginalAmount(FAmount);// originalAmount(原币金额)是

		String username = ContextUtil.getCurrentUserInfo(ctx).getName();
		info.setCreator(username);// creator(制单人)是

		int AsstSeq=1;
		if(rs.getString("AsstSeq")!=null&&rs.getString("AsstSeq").equals(""))  {
			AsstSeq=Integer.valueOf(rs.getString("AsstSeq"));
		}
		info.setAsstSeq(AsstSeq);// asstSeq(辅助账行号)否


		String type1=rs.getString("asstActType1");
		String number1=rs.getString("asstActNumber1");
		String name1=rs.getString("asstActname1");
		if(number1!=null&&!number1.equals("")) {
			info.setAsstActType1(type1);//asstActType1(核算项目1)否    
			info.setAsstActNumber1(number1);//asstActNumber1(核算对象编码1)否
			info.setAsstActName1(name1);//asstActName1(核算对象名称1)否
		}
		String type2=rs.getString("asstActType2");
		String number2=rs.getString("asstActNumber2");
		String name2=rs.getString("asstActname2");
		if(number2!=null&&!number2.equals("")) {
			info.setAsstActType2(type2);//asstActType2(核算项目1)否   现金流量 
			info.setAsstActNumber2(number2);//asstActNumber2(核算对象编码1)否
			info.setAsstActName2(name2);//asstActName2(核算对象名称1)否
		}
	}

	/**
	 * 创建临时表
	 */
	public String createTempTable(Context ctx) throws BOSException, EASDBException {
		String tablename=TableManagerFacadeFactory.getLocalInstance(ctx).getTableName("Voucher");
		StringBuffer sql=new StringBuffer();
		sql.append(" /*dialect*/ create  table " + tablename + "(");
		sql.append(" companyNumber varchar(100),");
		sql.append(" bookedDate varchar(100),");
		sql.append(" bizDate varchar(100),");
		sql.append(" bizDateKeep varchar(100),");//记录时间
		sql.append(" periodYear int,");
		sql.append(" periodNumber int,");
		sql.append(" voucherType varchar(100),");
		sql.append(" attaches int,");
		sql.append(" description varchar(100),");
		sql.append(" SourceNumber varchar(100),");
		sql.append(" voucherNumber varchar(100),");
		sql.append(" entrySeq int,");
		sql.append(" voucherAbstract varchar(200),");
		sql.append(" accountNumber varchar(100),");
		sql.append(" accountName varchar(100),");
		sql.append(" currencyNumber varchar(100),");
		sql.append(" localRate decimal(28,10),");
		sql.append(" entryDC int,");
		sql.append(" originalAmount decimal(28,10),");
		sql.append(" qty decimal(28,10),");
		sql.append(" measurement varchar(100),");
		sql.append(" price decimal(28,10),");
		sql.append(" debitAmount decimal(28,10),");
		sql.append(" creditAmount decimal(28,10),");
		sql.append(" creator varchar(100),");
		sql.append(" auditor varchar(100),");
		sql.append(" asstSeq int default 1,");
		sql.append(" bizNumber varchar(100),");
		sql.append(" settlementNumber varchar(100),");
		sql.append(" settlementType varchar(100),");
		sql.append(" cussent int,");
		sql.append(" asstActType1 varchar(100),");
		sql.append(" asstActNumber1 varchar(100),");
		sql.append(" asstActName1 varchar(200),");
		sql.append(" asstActType2 varchar(100),");
		sql.append(" asstActNumber2 varchar(100),");
		sql.append(" asstActName2 varchar(200),");
		sql.append(" asstActType3 varchar(100),");
		sql.append(" asstActNumber3 varchar(100),");
		sql.append(" asstActName3 varchar(200),");
		sql.append(" asstActNumber4 varchar(100),");
		sql.append(" asstActName4 varchar(200),");
		sql.append(" asstActType4 varchar(100),");
		sql.append(" payNumber varchar(44),");
		sql.append(" payName varchar(60),");
		sql.append(" Rrowid varchar(60),");
		sql.append(" orderSeq varchar(60),");
		sql.append(" person_num varchar(100),");//员工
		sql.append(" person_name varchar(100),");//员工
		sql.append(" cmpitem_num varchar(100),");//薪酬项目
		sql.append(" cmpItem_name varchar(100),");//薪酬项目
		sql.append(" status int");
		sql.append(" )");
		com.kingdee.eas.util.app.DbUtil.execute(ctx,sql.toString());
		return tablename;
	}

	/**
	 * 手动生成凭证编号
	 */
	protected  String createVoucherCode(Context ctx){
		int code=1;
		String dateStr="";
		//构建
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
		dateStr=sdf.format(new java.util.Date());
		DecimalFormat sf=new DecimalFormat("0000");
		do
		{
			String VoucherCodeQuery="select * from t_gl_voucher where fnumber='"+dateStr+"-"+sf.format(code)+"'";		
			try {
				IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, VoucherCodeQuery).executeSQL();
				if(rs.next())
					code++;
				else
					return dateStr+"-"+sf.format(code);
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(1==2);
		return dateStr+"-"+sf.format(code);
	}



	/**
	 * 根据EAS人员编码获得sHR人员编码和姓名
	 */
	@Override
	protected String[] _getSHRPerson(Context ctx, String EASNumber,String[] conInfo )
	throws BOSException {
		// TODO Auto-generated method stub

		String[] personInfo=new String[2]; 
		getConnection(conInfo);		
		String str="select * from T_BD_Person where fnumber='"+EASNumber+"'";
		try {
			state=conn.prepareStatement(str);
			ResultSet rs = state.executeQuery(str);
			if(rs.next()){
				personInfo[0]=rs.getString("fnumber");
				personInfo[1]=rs.getString("fname_l2");
			};
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try {
			closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return personInfo;
	}





	/**
	 * 查看当前员工所属的行政组织是否是  明细行政组织
	 */
	@Override
	protected boolean _getbooleanAdminOrgUnit(Context ctx, String personNum)
	throws BOSException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select t3.FIsLeaf from t_bd_person t1");
		sb.append(" inner join  T_HR_PersonPosition t2 on t2.FpersonID=t1.fid");
		sb.append(" inner join t_org_admin t3 on t3.fid=t2.FPersonDep ");
		sb.append(" where t1.fnumber='").append(personNum).append("'");
		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		try {
			if(rs.next()){
				if(rs.getBoolean("fisLeaf"))
					return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 更新薪酬方案
	 */
	@Override
	protected void _updateSCalScheme(Context ctx,String[] conInfo) throws BOSException {
		// TODO Auto-generated method stub

		//删除原始数据
		String strD="delete T_SAL_SCalScheme";
		DbUtil.execute(ctx, strD);

		//添加新数据
		getConnection(conInfo);
		String str=" select * from T_HR_SCalScheme";
		try {
			state=conn.prepareStatement(str);
			ResultSet rs = state.executeQuery(str);
			while(rs.next()){
				SCalSchemeInfo info=new SCalSchemeInfo();
				info.setSCalSchemeCode(rs.getString("fnumber"));
				info.setScalSchemeName(rs.getString("fname_l2"));
				info.setNumber(rs.getString("fnumber"));
				info.setName(rs.getString("fname_l2"));
				info.setScalSchemeID(rs.getString("fid"));
				info.setPeriodMonth(rs.getInt("FPeriodMonth"));
				info.setPeriodYear(rs.getInt("FPeriodYear"));

				if(rs.getInt("FState")==1)
					info.setEnabled(true);
				else
					info.setEnabled(false);

				SCalSchemeFactory.getLocalInstance(ctx).save(info);
			}
			closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}






	@Override
	protected boolean _getConnection(Context ctx, String[] conInfo)
	throws BOSException {
		// TODO Auto-generated method stub
		Connection connection =null;
		//oracle数据连接(当前连接为10.200测试库)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			String url = "jdbc:oracle:thin:@"+conInfo[0]+":"+conInfo[1]+":"+conInfo[2]; // orcl为数据库的SID
			String user = conInfo[3];
			String password = conInfo[4];
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			//throw new BOSException("",e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		else
			return false;
	}


	/**
	 *更新EAs里面的薪酬项目
	 */
	@Override
	protected void _updateCmpItem(Context ctx, String[] conInfo)
	throws BOSException {
		// TODO Auto-generated method stub
		//删除原来的数据
		String strRemove = "delete T_SAL_CmpItem";
		DbUtil.execute(ctx, strRemove);

		AdminOrgUnitInfo adminOrgUnit = ContextUtil.getCurrentAdminUnit(ctx);
		getConnection(conInfo);//建立连接  conn
		if(conn!=null){
			String str = "select * from T_HR_SCmpItem";
			try {
				state=conn.prepareStatement(str);
				ResultSet rs = state.executeQuery(str);
				while(rs.next()){
					CmpItemInfo info=new CmpItemInfo();
					info.setNumber(rs.getString("fnumber"));
					info.setName(rs.getString("fname_l2"));
					info.setAdminOrgUnitID(adminOrgUnit);
					CmpItemFactory.getLocalInstance(ctx).save(info);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 根据数据库连接信息获得conn
	 */
	private void getConnection(String[] conInfo) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
			String url = "jdbc:oracle:thin:@"+conInfo[0]+":"+conInfo[1]+":"+conInfo[2]; // orcl为数据库的SID
			String user = conInfo[3];
			String password = conInfo[4];
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			//throw new BOSException("",e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}


	@Override
	protected String _getSHRAdmin(Context ctx, String adminCode,
			String[] conInfo) throws BOSException {
		// TODO Auto-generated method stub
		String str="select * from t_org_admin where fnumber='"+adminCode+"'";

		getConnection(conInfo);
		try {
			state=conn.prepareStatement(str);
			ResultSet rs = state.executeQuery(str);
			if(rs.next())
				return rs.getString("fname_l2");
			closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
