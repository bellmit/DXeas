package com.kingdee.eas.custom.salediscount.rpt.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.report.util.RptCellFormatter;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptRowSet;
import com.kingdee.eas.framework.report.util.RptTableColumn;
import com.kingdee.eas.framework.report.util.RptTableHeader;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.db.SQLUtils;

public class AreaEmpCRptFacadeControllerBean extends AbstractAreaEmpCRptFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.jrpt.app.AreaEmpCRptFacadeControllerBean");
    /**
     * 初始化数据
     */
    protected RptParams _init(Context ctx, RptParams params)throws BOSException, EASBizException
    {
    	RptParams pp=new RptParams();
    	pp.setString("title",params.getString("init_title")+"BBB");    	
        return pp;
    }
    /**
     * 创建临时表(非必要)
     */
    protected RptParams _createTempTable(Context ctx, RptParams params)throws BOSException, EASBizException
	{

    	String FCUID=params.getString("FCUID");//组织单元
		int FisArea=0;
		int FisEmp=0;
		int FisCustomer=0;
	
		FisArea=params.getInt("FisArea");
		FisEmp=params.getInt("FisEmp");
		FisCustomer=params.getInt("FisCustomer");
		List list = new ArrayList();
		
    	//删除旧临时表(结构可能与新查询不同,本例子临时表结构不变)
    	dropTable(params.getString("tempTable"),ctx);
    	
    	String tempTable=this.getTempTableName("tempTable",ctx);
    	
    	String MidSql="";
    	String EndSql="";
    	StringBuffer StrSql=new StringBuffer();

    	String rpttablename=insertRpt(ctx,params);
    	
  
    	StrSql=new StringBuffer();
    	StrSql.append(" Select distinct t1.FMaterialID,t2.fname_l2,t2.FNumber from "+rpttablename+" t1 ");
		StrSql.append(" inner join t_BD_Material t2 on t2.fid=t1.FMaterialID ");
    	StrSql.append(" where t1.FControlUnitID='"+FCUID+"' ");
    	StrSql.append(" order by t2.fnumber ");
		IRowSet rsa=null;
		rsa = com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,StrSql.toString(),list.toArray());
		
		StrSql=new StringBuffer();
		StrSql.append(" Select t1.FControlUnitID,");
		if(FisArea==32){
			StrSql.append(" t2.FNumber FAreaNumber,t2.FName_L2 FAreaName,");//t2 显示区域
		}else{
			StrSql.append(" 'AAAAAAAAAAAA' FAreaNumber,'AAAAAAAAAAAA' FAreaName,");//t2 显示区域
		}
		
		if(FisEmp==32){
			StrSql.append(" t3.FNumber FEmpNumber,t3.FName_L2 FEmpName, ");//t3 显示职员
		}else{
			StrSql.append(" 'AAAAAAAAAAAA' FEmpNumber,'AAAAAAAAAAAA' FEmpName, ");//t3 显示职员
		}
		
		if(FisCustomer==32){
			StrSql.append(" t4.FNumber FCustomerNumber,t4.FName_L2 FCustomerName,");//t4 显示客户
		}else{
			StrSql.append(" 'AAAAAAAAAAAA' FCustomerNumber,'AAAAAAAAAAAA' FCustomerName,");//t4 显示客户
		}
    	StrSql.append(" 1 FLevel,0 FStatus,");//显示级次
    	try {
			while(rsa.next()){
				String FColumnName="";
				int m=0;
				FColumnName=rsa.getString("FNumber").toString();
				m=FColumnName.indexOf("-",1);
				FColumnName=FColumnName.substring(0,m)+FColumnName.substring(m+1);
				MidSql=" sum(  ";
				MidSql=MidSql+" (case when FMaterialID='" +rsa.getString("FMaterialID").toString() + "'  ";
				MidSql=MidSql+" then t1.FQty else 0 end ) ";
				MidSql=MidSql+" )";
				MidSql=MidSql+" as F" +FColumnName + ", ";
				EndSql=EndSql+MidSql;
			}
			rsa.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		StrSql.append(EndSql);
		EndSql="";
		EndSql=EndSql+StrSql.toString();
		EndSql=EndSql+"Sum(FQty) FQty ";
		EndSql=EndSql+" into "+tempTable +"  ";
		EndSql=EndSql+" from "+rpttablename+" t1 ";
		EndSql=EndSql+" left join T_BD_SaleGroup t2 on t2.FID=t1.FAreaID ";
		EndSql=EndSql+" left join t_BD_Person t3 on t3.FID=t1.FSalePersonID ";
		EndSql=EndSql+" left join t_BD_Customer t4 on t4.FID=t1.FCustomerID ";
		EndSql=EndSql+" where t1.FControlUnitID='"+FCUID+"' ";
		CustomerInfo FBeginCustomer=(CustomerInfo)params.getObject("FBeginCustomer");
    	CustomerInfo FEndCustomer=(CustomerInfo)params.getObject("FEndCustomer");
    	PersonInfo FBeginEmp=(PersonInfo)params.getObject("FBeginEmp");
    	PersonInfo FEndEmp=(PersonInfo)params.getObject("FEndEmp");
		if(FBeginCustomer!=null&FEndCustomer!=null){
			EndSql=EndSql+"  and (t4.FNumber>='"+FBeginCustomer.getNumber().toString()+"'";
			EndSql=EndSql+"  and t4.FNumber<='"+FEndCustomer.getNumber().toString()+"')";
		}
		if(FBeginEmp!=null&FEndEmp!=null){
			EndSql=EndSql+"  and (t3.FNumber>='"+FBeginEmp.getNumber().toString()+"'";
			EndSql=EndSql+"  and t3.FNumber<='"+FEndEmp.getNumber().toString()+"')";
		}
		EndSql=EndSql+" Group by ";
    	if(FisArea==32){
    		EndSql=EndSql+" t2.FNumber ,t2.FName_L2 ,";//t2 显示区域
		}
		
		if(FisEmp==32){
			EndSql=EndSql+" t3.FNumber ,t3.FName_L2 , ";//t3 显示职员
		}
		
		if(FisCustomer==32){
			EndSql=EndSql+" t4.FNumber ,t4.FName_L2 ,";//t4 显示客户
		}

    	EndSql=EndSql+" t1.FControlUnitID ";//t6 显示产品
    	
    	//创建临时表
    	executeCreateAsSelectInto(EndSql,null,ctx); 	
    	insertRptTotal(ctx,params,tempTable,rpttablename);
    	
    	//com.kingdee.eas.util.app.DbUtil.execute(ctx,"drop table "+rptname+" ");
    	//设置返回数据
    	int FLevel=0;
    	FLevel=params.getInt("FLevel");
    	if(FLevel>0){
    		//
    		FLevel=FLevel+1;
    	}else{
    		FLevel=1;
    	}
    	
    	RptParams result=new RptParams();
    	result.setString("tempTable",tempTable); 
    	
    	String countSql="select count(1) cc from "+tempTable+" where FLevel<="+String.valueOf(FLevel)+"";
    	RptRowSet rs = this.executeQuery(countSql,null,ctx);
    	rs.next();
    	int count=rs.getInt(0);
    	result.setInt("verticalCount",count);
    	result.setString("rptname", rpttablename);
    	try {
			result.setObject("header",this.Header(ctx,params,rpttablename));
		} catch (BOSException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
    	return result;
    }
    /**
     * 分页查询数据
     * 在这里查询必要的数据
     */
    protected RptParams _query(Context ctx, RptParams params, int from, int len)throws BOSException, EASBizException
    {
    	List list=new ArrayList();
    	String rpttablename=params.getString("rptname");
    	StringBuffer StrSql=new StringBuffer();
    	StrSql.append(" Select distinct t1.FMaterialID,t2.fname_l2,t2.fnumber from "+rpttablename+" t1 ");
		StrSql.append(" inner join t_BD_Material t2 on t2.fid=t1.FMaterialID ");
    	StrSql.append(" where t1.FControlUnitID='"+params.getString("FCUID")+"' ");
    	StrSql.append(" order by t2.fnumber ");
		IRowSet rsa = com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,StrSql.toString(),list.toArray());
		
		int FLevel=0;
    	FLevel=params.getInt("FLevel");
    	if(FLevel>0){
    		//
    		FLevel=FLevel+1;
    	}else{
    		FLevel=1;
    	}
    	
    	int FisArea=params.getInt("FisArea");
    	int FisEmp=params.getInt("FisEmp");
    	int FisCustomer=params.getInt("FisCustomer");
		
		StrSql=new StringBuffer();
		StrSql.append(" Select ");
		if(FisArea==32){
			StrSql.append(" FAreaNumber,FAreaName,");
		}
		if(FisEmp==32){
			StrSql.append(" FEmpNumber,FEmpName,");
		}
		if(FisCustomer==32){
			StrSql.append(" FCustomerNumber,FCustomerName, ");
		}
		String StrCol="";
		try {
			while(rsa.next()){
				String FColumnName="";
				int m=0;
				FColumnName=rsa.getString("FNumber").toString();
				m=FColumnName.indexOf("-",1);
				FColumnName=FColumnName.substring(0,m)+FColumnName.substring(m+1);
				StrCol=StrCol+"F"+FColumnName+",";
			}
			rsa.close();
		} catch (SQLException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		StrSql.append(StrCol.toString());
		StrSql.append(" FQty,FLevel ");
		StrSql.append(" from "+params.getString("tempTable")+"  ");
		StrSql.append(" where FLevel<="+String.valueOf(FLevel)+"");
		StrSql.append(" order by FStatus,FAreaName,FEmpName,FCustomerName");
    	RptRowSet rs=this.executeQuery(StrSql.toString(),null,from,len,ctx);
    	RptParams pp=new RptParams();
    	pp.setObject("rowset",rs);
    	
    	//删除临时表
    	com.kingdee.eas.util.app.DbUtil.execute(ctx,"drop table "+rpttablename+" ");
    	return pp;
    }
    public RptTableHeader Header(Context ctx,RptParams params,String rpttablename) throws BOSException, SQLException{
    	//构造表头
    	RptTableHeader header=new RptTableHeader();
    	RptTableColumn col=null;
    	String format="";
    	List list = new ArrayList();
    	int FisArea=0;
		int FisEmp=0;
		int FisCustomer=0;
		int i=0;
    	FisArea=params.getInt("FisArea");
    	if(FisArea==32){
    		i=i+2;
    	}
		FisEmp=params.getInt("FisEmp");
		if(FisEmp==32){
    		i=i+2;
    	}
		FisCustomer=params.getInt("FisCustomer");
		if(FisCustomer==32){
    		i=i+2;
    	}
    	StringBuffer StrSql=new StringBuffer();
    	StrSql.append(" Select distinct t1.FMaterialID,t2.fname_l2,t2.fnumber from "+rpttablename+" t1 ");
		StrSql.append(" inner join t_BD_Material t2 on t2.fid=t1.FMaterialID ");
    	StrSql.append(" where t1.FControlUnitID='"+params.getString("FCUID")+"' ");
    	StrSql.append(" order by t2.fnumber ");
   
		IRowSet rsa=null;
		rsa = com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,StrSql.toString(),list.toArray());
		int j=rsa.size();
		j=j+i+2;
		Object[][] obj=new Object[1][j];
		i=0;
		if(FisArea==32){
			//FAreaNumber
	    	col=new RptTableColumn("FAreaNumber");    	
	    	col.setWidth(120);
	    	col.setAligment(RptTableColumn.HALIGN_LEFT);
	    	header.addColumn(col);
	    	
	    	//FAreaName
	    	col=new RptTableColumn("FAreaName");    	
	    	col.setWidth(120);
	    	col.setAligment(RptTableColumn.HALIGN_LEFT);
	    	header.addColumn(col);
	    	obj[0][i]="区域代码";
	    	obj[0][i+1]="区域名称";
	    	i=i+2;
		}
    	
    	if(FisEmp==32){
			//FEmpNumber
	    	col=new RptTableColumn("FEmpNumber");    	
	    	col.setWidth(120);
	    	col.setAligment(RptTableColumn.HALIGN_LEFT);
	    	//col.setHided(FStatus);
	    	header.addColumn(col);
	    	
	    	//FEmpName
	    	col=new RptTableColumn("FEmpName");
	    	col.setWidth(120);    	
	    	col.setAligment(RptTableColumn.HALIGN_LEFT);
	    	//col.setHided(FStatus);
	    	header.addColumn(col);
	    	obj[0][i]="业务员代码";
			obj[0][i+1]="业务员名称";
	    	i=i+2;
		}
    	
    	if(FisCustomer==32){
    		//FCustomerNumber
	    	col=new RptTableColumn("FCustomerNumber");    	
	    	col.setWidth(120);
	    	col.setAligment(RptTableColumn.HALIGN_LEFT);
	    	header.addColumn(col);
	    	
	    	//FCustomName
	    	col=new RptTableColumn("FCustomerName");
	    	col.setWidth(120);    	
	    	col.setAligment(RptTableColumn.HALIGN_LEFT);
	    	header.addColumn(col);
	    	obj[0][i]="客户编码";
			obj[0][i+1]="客户名称";
	    	i=i+2;
		}
		while(rsa.next()){
			String FColumnName="";
			int m=0;
			FColumnName=rsa.getString("FNumber").toString();
			m=FColumnName.indexOf("-",1);
			FColumnName=FColumnName.substring(0,m)+FColumnName.substring(m+1);
			col=new RptTableColumn("F"+FColumnName);
	    	col.setWidth(120);
	    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
	    	format=RptCellFormatter.getNumberFormat(2,true);
	    	col.setFormatPattern(format);
	    	header.addColumn(col);
	    	obj[0][i]=rsa.getString("Fname_l2").toString();
	    	i=i+1;
		}
		rsa.close();
		   	
    	//FQty
    	col=new RptTableColumn("FQty");
    	col.setWidth(120);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	format=RptCellFormatter.getNumberFormat(2,true);
    	col.setFormatPattern(format);
    	header.addColumn(col);
    	
    	col=new RptTableColumn("FLevel");
    	col.setWidth(120);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	col.setHided(true);
    	header.addColumn(col);
    	
    	obj[0][i]="总量";
    	obj[0][i+1]="级次";
    	header.setLabels(obj);
    	
    	//header.setLabels({"","",""},true);
    	//自动融合表头,表头行数没限制,只要数组二维长度与列数量相等就可以了.
    	//header.setLabels(
    			//{"融合块","融合块","融合块","测试","测试"},
				//{"科目编码","科目名称","级别","方向","是否现金流量"}},true);
    	return header;
    }
   
	public String insertRpt(Context ctx,RptParams params) throws BOSException {
    	Connection con = null;
		Statement batchStatement = null;
		
		List list = new ArrayList();
		String FCUID="";//组织单元
		String FdpBeginDate="";
		String FdpEndDate="";

		StringBuffer StrRs=new StringBuffer();
		String rpttablename="";
		try {
			con = getConnection(ctx);
			batchStatement = con.createStatement();
			FCUID=((CompanyOrgUnitInfo)params.getObject("FOrgUnitInfo")).getId().toString();
			boolean ispersonA=false;//params.getBoolean("ispersonA");//按照业务员A
			//删除数据
			rpttablename=this.getTempTableName("Jack",ctx);
			RptAppCommon aa=new RptAppCommon();
			aa.createRptSql(ctx, rpttablename);

			FdpBeginDate=params.getString("FdpBeginDate").toString();
			FdpEndDate=params.getString("FdpEndDate").toString();
			FdpBeginDate=FdpBeginDate.substring(0,10);
			FdpEndDate=FdpEndDate.substring(0,10);
			String tablename=aa.rptCustomerBack(ctx,params,FCUID,"0",FdpBeginDate, FdpEndDate,rpttablename,ispersonA);
			rpttablename=tablename;
            //更新物料组别
		} catch (SQLException er) {
			// return false;
			throw new BOSException("sql Execute Error :", er);
		} finally {
			SQLUtils.cleanup(batchStatement, con);
			SQLUtils.cleanup(con);

		}
		return rpttablename;
	}
	 public int insertRptTotal(Context ctx, RptParams params,String tempTable,String rptname) throws BOSException{
	    	List list=new ArrayList();
	    	StringBuffer StrSql=new StringBuffer();
	    	String FCUID=params.getString("FCUID");
	    	int nrow=2;
	    	int FisArea=params.getInt("FisArea");
	    	int FisEmp=params.getInt("FisEmp");
			int FisCustomer=params.getInt("FisCustomer");
			
			StrSql.append(" Select distinct t1.FMaterialID,t2.fname_l2,t2.fnumber from "+rptname+" t1 ");
			StrSql.append(" inner join t_BD_Material t2 on t2.fid=t1.FMaterialID ");
	    	StrSql.append(" where t1.FControlUnitID='"+FCUID+"' ");
	    	StrSql.append(" order by t2.fnumber ");
			IRowSet rsa = com.kingdee.eas.util.app.DbUtil.executeQuery(ctx,StrSql.toString(),list.toArray());
			
			StrSql=new StringBuffer();
			StrSql.append(" Insert into "+tempTable+"( ");
			StrSql.append(" FControlUnitID,FAreaNumber,FAreaName,FEmpNumber,FEmpName,");
			StrSql.append(" FCustomerNumber,FCustomerName, ");
			String StrCol="";
			String StrColA="";
			try {
				while(rsa.next()){
					String FColumnName="";
					int m=0;
					FColumnName=rsa.getString("FNumber").toString();
					m=FColumnName.indexOf("-",1);
					FColumnName=FColumnName.substring(0,m)+FColumnName.substring(m+1);
					StrCol=StrCol+"F"+FColumnName+",";
					StrColA=StrColA+"Sum(F"+FColumnName+"),";
				}
				rsa.close();
			} catch (SQLException e) {
				// TODO 自动生成 catch 块
				e.printStackTrace();
			}
			StrSql.append(StrCol.toString());
			StrSql.append(" FQty,FLevel,FStatus ");
			StrSql.append(" )");
			

			if(FisArea==32){
				StringBuffer Sql=new StringBuffer();
				Sql.append(StrSql.toString());
				Sql.append(" Select ");
				Sql.append(" FControlUnitID,'0',isnull(FAreaName,'')||'合计','0','0',");
				Sql.append(" '0','0', ");
				Sql.append(StrColA.toString());
				Sql.append(" Sum(FQty),"+Integer.toString(nrow)+",0 ");
				Sql.append(" from "+tempTable+" " );
				Sql.append(" where FControlUnitID='"+FCUID+"' and FLevel=1 ");
				Sql.append(" Group by FControlUnitID,FAreaNumber,FAreaName ");
				com.kingdee.eas.util.app.DbUtil.execute(ctx,Sql.toString());
				nrow=nrow+1;
	    	}
	    	
			if(FisEmp==32){
				StringBuffer Sql=new StringBuffer();
				Sql.append(StrSql.toString());
				Sql.append(" Select ");
				Sql.append(" FControlUnitID,FAreaNumber,FAreaName,'0',isnull(FEmpName,'')||'合计',");
				Sql.append(" '0','0', ");
				Sql.append(StrColA.toString());
				Sql.append(" Sum(FQty),"+Integer.toString(nrow)+",0 ");
				Sql.append(" from "+tempTable+" " );
				Sql.append(" where FControlUnitID='"+FCUID+"' and FLevel=1 ");
				Sql.append(" Group by FControlUnitID,FAreaNumber,FAreaName,FEmpNumber,FEmpName ");
				com.kingdee.eas.util.app.DbUtil.execute(ctx,Sql.toString());
				nrow=nrow+1;		
			}
			
			if(FisCustomer==32){
				StringBuffer Sql=new StringBuffer();
				Sql.append(StrSql.toString());
				Sql.append(" Select ");
				Sql.append(" FControlUnitID,FAreaNumber,FAreaName,FEmpNumber,FEmpName,");
				Sql.append(" '0',isnull(FCustomerName,'')||'合计', ");
				Sql.append(StrColA.toString());
				Sql.append(" Sum(FQty),"+Integer.toString(nrow)+",0 ");
				Sql.append(" from "+tempTable+" " );
				Sql.append(" where FControlUnitID='"+FCUID+"' and FLevel=1 ");
				Sql.append(" Group by FControlUnitID,FAreaNumber,FAreaName,FEmpNumber,FEmpName,FCustomerNumber,FCustomerName ");
				com.kingdee.eas.util.app.DbUtil.execute(ctx,Sql.toString());
				nrow=nrow+1;		
			}
	    	StringBuffer Sql=new StringBuffer();
			Sql.append(" Insert into "+tempTable+"( ");
			Sql.append(" FControlUnitID,FAreaNumber,FAreaName,FEmpNumber,FEmpName,");
			Sql.append(" FCustomerNumber,FCustomerName, ");
			Sql.append(StrCol.toString());
			Sql.append(" FQty,FLevel,FStatus ");
			Sql.append(" )");
			Sql.append(" Select FControlUnitID,");
			Sql.append(" '','总合计',");
			Sql.append(" '','总合计',");
			Sql.append(" '','总合计',");
			Sql.append(StrColA.toString());
			Sql.append(" Sum(FQty),1,1 ");
			Sql.append(" from "+tempTable+" " );
			Sql.append(" where FControlUnitID='"+FCUID+"' and FLevel=1 ");
			Sql.append(" Group by FControlUnitID ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx,Sql.toString());
	    	return nrow;
	    	
	    }
}