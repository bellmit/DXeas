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
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.report.util.RptCellFormatter;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptRowSet;
import com.kingdee.eas.framework.report.util.RptTableColumn;
import com.kingdee.eas.framework.report.util.RptTableHeader;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.db.SQLUtils;
//
public class ProductSaleDayRptFacadeControllerBean extends AbstractProductSaleDayRptFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.brpt.app.ProductSaleDayRptFacadeControllerBean");
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
    	//删除旧临时表(结构可能与新查询不同,本例子临时表结构不变)
    	dropTable(params.getString("tempTable"),ctx);
    	
    	String tempTable=this.getTempTableName("tempTable",ctx);
    	
    	String rptname=insertRpt(ctx,params);
    	
    	executeCreateAsSelectInto(this.strSql(ctx,params,tempTable,rptname),null,ctx);
    	this.insertRptTotal(ctx,params,tempTable);//添加总计
    	
    	//删除临时表
    	com.kingdee.eas.util.app.DbUtil.execute(ctx,"drop table "+rptname+" ");
    	//创建临时表
    	//设置返回数据
    	int FLevel=0;
    	FLevel=params.getInt("FLevel");
    	if(FLevel>0){
    		FLevel=FLevel+1;
    	}else{
    		FLevel=1;
    	}
    	String countSql="select count(1) cc from "+tempTable+" where FLevel<="+String.valueOf(FLevel)+"";
    	RptRowSet rs = this.executeQuery(countSql,null,ctx);
    	rs.next();
    	int count=rs.getInt(0);
    	
    	RptParams result=new RptParams();
    	result.setString("tempTable",tempTable);    	
    	result.setObject("header",this.header(params));
    	result.setInt("verticalCount",count);
    	return result;
    } 
    /**
     * 分页查询数据
     * 在这里查询必要的数据
     */
    protected RptParams _query(Context ctx, RptParams params, int from, int len)throws BOSException, EASBizException
    {
    	String FCUID=params.getString("FCUID");
    	int FLevel=0;
    	FLevel=params.getInt("FLevel");
    	if(FLevel>0){
    		FLevel=FLevel+1;
    	}else{
    		FLevel=1;
    	}
    	int FisArea=0;
		int FisEmp=0;
		int FisCustomer=0;
		int FisMaterialGroup=0;
		int FisMaterial=0;
		FisArea=params.getInt("FisArea");
		FisEmp=params.getInt("FisEmp");
		FisCustomer=params.getInt("FisCustomer");
		FisMaterialGroup=params.getInt("FisMaterialGroup");
		FisMaterial=params.getInt("FisMaterial");
		
    	StringBuffer StrSql = new StringBuffer();
    	StrSql = new StringBuffer();
    	StrSql.append(" Select ");
    	if(FisArea==32){
    		StrSql.append(" t1.FAreaNumber,t1.FAreaName,");
    	}
    	if(FisEmp==32){
    		StrSql.append(" t1.FEmpNumber,t1.FEmpName,");
    	}
    	if(FisCustomer==32){
    		StrSql.append(" t1.FCustomerNumber,t1.FCustomerName,tbc.fname_l2 channelType, ");
    	}
    	if(FisMaterialGroup==32){
    		StrSql.append(" t1.FMGroupNumber,t1.FMGroupName,");
    	}
    	if(FisMaterial==32){
    		StrSql.append(" t1.FMaterialNumber,t1.FMaterialName,t1.FMaterialMode,");
    	}
		StrSql.append(" t1.FQty,t1.FAmount,t1.FMonthQty,t1.FLastMonthQty,t1.FAddQty,");
		StrSql.append(" t1.FMonthAmount,t1.FLastMonthAmount,t1.FAddAmount,t1.FLevel,t1.fcxfy " );
		StrSql.append(" from "+params.getString("tempTable")+" t1 ");
		StrSql.append(" left join t_bd_customer tc on t1.FCustomerNumber = tc.fnumber 	 ");
		StrSql.append(" left join T_BD_CustomerSaleInfo tcs on t1.FControlUnitID = tcs.FSaleOrgID and tc.fid = tcs.FCustomerID	 ");
		StrSql.append(" left join T_BD_ChannelType tbc on tcs.FChannelTypeID = tbc.fid ");
		StrSql.append(" where t1.FControlUnitID='"+FCUID+"' ");
		StrSql.append(" and t1.FLevel<="+Integer.toString(FLevel)+"");
		StrSql.append(" order by t1.FStatus,t1.FAreaName,t1.FEmpName,t1.FCustomerName,t1.FMGroupName,t1.FMaterialName");
		RptRowSet rs=this.executeQuery(StrSql.toString(),null,from,len,ctx);
    	RptParams result=new RptParams();
    	result.setObject("rowset",rs);
   
    	return result;
    }
    public String strSql(Context ctx, RptParams params,String tempTable,String rptname) throws BOSException{
    	StringBuffer StrSql=new StringBuffer();
    	String FCUID=params.getString("FCUID");
    	
    	int FisArea=params.getInt("FisArea");
    	int FisEmp=params.getInt("FisEmp");
		int FisMaterialGroup=params.getInt("FisMaterialGroup");
		int FisMaterial=params.getInt("FisMaterial");
		int FisCustomer=params.getInt("FisCustomer");
		
		CustomerInfo FBeginCustomer=(CustomerInfo)params.getObject("FBeginCustomer");
    	CustomerInfo FEndCustomer=(CustomerInfo)params.getObject("FEndCustomer");
    	PersonInfo FBeginEmp=(PersonInfo)params.getObject("FBeginEmp");
    	PersonInfo FEndEmp=(PersonInfo)params.getObject("FEndEmp");
    	
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
    	
    	if(FisMaterialGroup==32){
    		StrSql.append(" t4.FNumber FMGroupNumber,t4.FName_L2 FMGroupName,");//t5 显示产品类别
    	}else{
    		StrSql.append(" 'AAAAAAAAAAAA' FMGroupNumber,'AAAAAAAAAAAA' FMGroupName,");//t5 显示产品类别
    	}
    	
    	if(FisMaterial==32){
    		StrSql.append(" t5.FNumber FMaterialNumber,t5.FName_L2 FMaterialName,t5.fmodel FMaterialMode,");//t5 显示产品
    	}else{
    		StrSql.append(" 'AAAAAAAAAAAA' FMaterialNumber,'AAAAAAAAAAAA' FMaterialName,'AAAAAAAAAAAA' FMaterialMode,");//t5 显示产品
    	}
    	
    	if(FisCustomer==32){
    		StrSql.append(" t6.FNumber FCustomerNumber,t6.FName_L2 FCustomerName, ");//t5 显示客户
    	}else{
    		StrSql.append(" 'AAAAAAAAAAAA' FCustomerNumber,'AAAAAAAAAAAA' FCustomerName, ");//t4 显示客户
    	}
    	
    	StrSql.append(" sum(t1.FQty) FQty,sum(t1.FAmount) FAmount,");
    	StrSql.append(" sum(t1.FMonthQty) FMonthQty,sum(t1.FLastMonthQty) FLastMonthQty,(sum(t1.FMonthQty)-sum(t1.FLastMonthQty)) FAddQty, ");
    	StrSql.append(" sum(t1.FMonthAmount) FMonthAmount,sum(t1.FLastMonthAmount) FLastMonthAmount,(sum(t1.FMonthAmount)-sum(t1.FLastMonthAmount)) FAddAmount ");
    	StrSql.append(" ,1 FLevel,0 FStatus,sum(t1.fcxfy) fcxfy  ");
    	StrSql.append(" into "+tempTable+"");
    	StrSql.append(" from "+rptname+" t1 ");
    	StrSql.append(" Left join T_BD_SaleGroup t2 on t2.FID=t1.FAreaID ");
    	StrSql.append(" left join t_BD_Person t3 on t3.FID=t1.FSalePersonID ");
    	StrSql.append(" left join t_LHZ_DisItemTree t4 on t4.FID=t1.FMaterialGroupID ");
    	StrSql.append(" inner  join t_BD_Material t5 on t5.FID=t1.FMaterialID ");
    	StrSql.append(" inner join t_BD_Customer t6 on t6.FID=t1.FCustomerID ");
//    	StrSql.append(" left join T_BD_CustomerSaleInfo tcs on t1.FControlUnitID = tcs.FSaleOrgID and t6.fid = tcs.FCustomerID	 ");
//		StrSql.append(" left join T_BD_ChannelType tbc on tcs.FChannelTypeID = tbc.fid ");
    	
    	StrSql.append(" where t1.FControlUnitID='"+FCUID+"' ");
    	if(FBeginCustomer!=null&FEndCustomer!=null){
			StrSql.append(" and (t6.FNumber>='"+FBeginCustomer.getNumber().toString()+"'");
			StrSql.append(" and t6.FNumber<='"+FEndCustomer.getNumber().toString()+"')");
		}
		if(FBeginEmp!=null&FEndEmp!=null){
			StrSql.append(" and (t3.FNumber>='"+FBeginEmp.getNumber().toString()+"'");
			StrSql.append(" and t3.FNumber<='"+FEndEmp.getNumber().toString()+"')");
		}
    	StrSql.append(" Group by ");
    	if(FisArea==32){
    		StrSql.append(" t2.FNumber,t2.FName_L2,");//t2 显示区域
    	}
    	
		if(FisEmp==32){
			StrSql.append(" t3.FNumber,t3.FName_L2, ");//t3 显示职员 		
		}
		
		if(FisMaterialGroup==32){
			StrSql.append(" t4.FNumber,t4.FName_L2 ,");//t4 显示产品类别	
		}
    	
		if(FisMaterial==32){
			StrSql.append(" t5.FNumber,t5.FName_L2 ,t5.fmodel,");//t4 显示产品  		
		}
		
		if(FisCustomer==32){
    		StrSql.append(" t6.FNumber ,t6.FName_L2 ,");//t5 显示客户
    	}
		StrSql.append(" t1.FControlUnitID ");//t4 显示产品类别或者产品
		
    	return StrSql.toString();
    	
    }
    
    public int insertRptTotal(Context ctx,RptParams params,String tempTable)throws BOSException{
    	int nrow=2;
    	int FisArea=params.getInt("FisArea");
    	int FisEmp=params.getInt("FisEmp");
		int FisMaterialGroup=params.getInt("FisMaterialGroup");
		int FisMaterial=params.getInt("FisMaterial");
		int FisCustomer=params.getInt("FisCustomer");
		String FCUID=params.getString("FCUID");

		StringBuffer StrSql=new StringBuffer();
		StrSql.append(" Insert into "+tempTable+"( ");
		StrSql.append(" FControlUnitID,FAreaNumber,FAreaName,FEmpNumber,FEmpName,");
		StrSql.append(" FCustomerNumber,FCustomerName, ");
		StrSql.append(" FMGroupNumber,FMGroupName,FMaterialNumber,FMaterialName,");
		StrSql.append(" FQty,FAmount,FMonthQty,FLastMonthQty,FAddQty,");
		StrSql.append(" FMonthAmount,FLastMonthAmount,FAddAmount,");
		StrSql.append(" FLevel,FStatus,fcxfy  ");
		StrSql.append(" )");
		if(FisArea==32){
			StringBuffer Sql=new StringBuffer();
			Sql.append(StrSql.toString());
			Sql.append(" Select ");
			Sql.append(" FControlUnitID,0,isnull(FAreaName,'')||'合计',0,0,");
			Sql.append(" 0,0, ");
			Sql.append(" 0,0,0,0,");
			Sql.append(" sum(FQty),sum(FAmount),sum(FMonthQty),sum(FLastMonthQty),sum(FMonthQty)-sum(FLastMonthQty),");
			Sql.append(" Sum(FMonthAmount),Sum(FLastMonthAmount),Sum(FMonthAmount)-Sum(FLastMonthAmount),");
			Sql.append(" "+Integer.toString(nrow)+",0,sum(fcxfy)   ");
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
			Sql.append(" FControlUnitID,FAreaNumber,FAreaName,0,isnull(FEmpName,'')||'合计',");
			Sql.append(" 0,0, ");
			Sql.append(" 0,0,0,0,");
			Sql.append(" sum(FQty),sum(FAmount),sum(FMonthQty),sum(FLastMonthQty),sum(FMonthQty)-sum(FLastMonthQty),");
			Sql.append(" Sum(FMonthAmount),Sum(FLastMonthAmount),Sum(FMonthAmount)-Sum(FLastMonthAmount),");
			Sql.append(" "+Integer.toString(nrow)+",0,sum(fcxfy) ");
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
			Sql.append(" 0,isnull(FCustomerName,'')||'合计', ");
			Sql.append(" 0,0,0,0,");
			Sql.append(" sum(FQty),sum(FAmount),sum(FMonthQty),sum(FLastMonthQty),sum(FMonthQty)-sum(FLastMonthQty),");
			Sql.append(" Sum(FMonthAmount),Sum(FLastMonthAmount),Sum(FMonthAmount)-Sum(FLastMonthAmount),");
			Sql.append(" "+Integer.toString(nrow)+",0 ,sum(fcxfy) ");
			Sql.append(" from "+tempTable+" " );
			Sql.append(" where FControlUnitID='"+FCUID+"' and FLevel=1 ");
			Sql.append(" Group by FControlUnitID,FAreaNumber,FAreaName,FEmpNumber,FEmpName,FCustomerNumber,FCustomerName ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx,Sql.toString());
			nrow=nrow+1;		
		}
		
		if(FisMaterialGroup==32){
			StringBuffer Sql=new StringBuffer();
			Sql.append(StrSql.toString());
			Sql.append(" Select ");
			Sql.append(" FControlUnitID,FAreaNumber,FAreaName,FEmpNumber,FEmpName,");
			Sql.append(" FCustomerNumber,FCustomerName, ");
			Sql.append(" 0,isnull(FMGroupName,'')||'合计',0,0,");
			Sql.append(" sum(FQty),sum(FAmount),sum(FMonthQty),sum(FLastMonthQty),sum(FMonthQty)-sum(FLastMonthQty),");
			Sql.append(" Sum(FMonthAmount),Sum(FLastMonthAmount),Sum(FMonthAmount)-Sum(FLastMonthAmount),");
			Sql.append(" "+Integer.toString(nrow)+",0,sum(fcxfy)  ");
			Sql.append(" from "+tempTable+" " );
			Sql.append(" where FControlUnitID='"+FCUID+"' and FLevel=1 ");
			Sql.append(" Group by FControlUnitID,FAreaNumber,FAreaName,FEmpNumber,FEmpName,FCustomerNumber,FCustomerName,FMGroupNumber,FMGroupName ");
			com.kingdee.eas.util.app.DbUtil.execute(ctx,Sql.toString());
			nrow=nrow+1;	
		}
    	
		//if(FisMaterial==32){
			//nrow=nrow+1;
		//}
		
		StrSql=new StringBuffer();
		StrSql.append(" Insert into "+tempTable+"( ");
		StrSql.append(" FControlUnitID,FAreaNumber,FAreaName,FEmpNumber,FEmpName,");
		StrSql.append(" FCustomerNumber,FCustomerName,");
		StrSql.append(" FMGroupNumber,FMGroupName,FMaterialNumber,FMaterialName,");
		StrSql.append(" FQty,FAmount,FMonthQty,FLastMonthQty,FAddQty,");
		StrSql.append(" FMonthAmount,FLastMonthAmount,FAddAmount,");
		StrSql.append(" FLevel,FStatus,fcxfy ");
		StrSql.append(" )");
    	StringBuffer Sql=new StringBuffer();
		Sql.append(StrSql.toString());
		Sql.append(" Select ");
		Sql.append(" FControlUnitID,0,'总合计',0,'总合计',");
		Sql.append(" 0,'总合计', ");
		Sql.append(" 0,'总合计',0,'总合计',");
		Sql.append(" sum(FQty),sum(FAmount),sum(FMonthQty),sum(FLastMonthQty),sum(FMonthQty)-sum(FLastMonthQty),");
		Sql.append(" Sum(FMonthAmount),Sum(FLastMonthAmount),Sum(FMonthAmount)-Sum(FLastMonthAmount),");
		Sql.append(" 1,1,sum(fcxfy)  ");
		Sql.append(" from "+tempTable+" " );
		Sql.append(" where FControlUnitID='"+FCUID+"' and FLevel=1 ");
		Sql.append(" Group by FControlUnitID ");
		com.kingdee.eas.util.app.DbUtil.execute(ctx,Sql.toString());
    	return nrow;
    	
    }
    public RptTableHeader header(RptParams params){
    	
    	
    	RptTableHeader header=new RptTableHeader();
    	RptTableColumn col=null;
    	String format="";
    	int FisArea=0;
		int FisEmp=0;
		int FisCustomer=0;
		int FisMaterialGroup=0;
		int FisMaterial=0;
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
    		i=i+3;
    	}
		FisMaterialGroup=params.getInt("FisMaterialGroup");
		if(FisMaterialGroup==32){
			i=i+2;
		}
		FisMaterial=params.getInt("FisMaterial");
		if(FisMaterial==32){
    		i=i+3;
    	}
		
		
		int j=0;
		j=i+10;
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
	    	
	    	//FCustomName
	    	col=new RptTableColumn("channelType");
	    	col.setWidth(80);    	
	    	col.setAligment(RptTableColumn.HALIGN_CENTER);
	    	header.addColumn(col);
	    	obj[0][i]="客户编码";
			obj[0][i+1]="客户名称";
			obj[0][i+2]="渠道类型";
	    	i=i+3;
		}
    	
    	if(FisMaterialGroup==32){
    		//FCustomerNumber
	    	col=new RptTableColumn("FMGroupNumber");    	
	    	col.setWidth(120);
	    	col.setAligment(RptTableColumn.HALIGN_LEFT);
	    	header.addColumn(col);
	    	
	    	//FCustomName
	    	col=new RptTableColumn("FMGroupName");
	    	col.setWidth(120);    	
	    	col.setAligment(RptTableColumn.HALIGN_LEFT);
	    	header.addColumn(col);
	    	obj[0][i]="类别编码";
			obj[0][i+1]="类别名称";
	    	i=i+2;
		}
    	
    	if(FisMaterial==32){
			//FMaterialNumber
	    	col=new RptTableColumn("FMaterialNumber");    	
	    	col.setWidth(120);
	    	col.setAligment(RptTableColumn.HALIGN_LEFT);
	    	header.addColumn(col);
	    	
	    	//FMaterialName
	    	col=new RptTableColumn("FMaterialName");
	    	col.setWidth(120);    	
	    	col.setAligment(RptTableColumn.HALIGN_LEFT);
	    	header.addColumn(col);
	    	
	    	//FMaterialName
	    	col=new RptTableColumn("FMaterialMode");
	    	col.setWidth(120);    	
	    	col.setAligment(RptTableColumn.HALIGN_LEFT);
	    	header.addColumn(col);
	    	
	    	
	    	obj[0][i]="产品编码";
			obj[0][i+1]="产品名称";
			obj[0][i+2]="规格型号";
	    	i=i+3;
		} 		
		  	
    	
    	//FQty
    	col=new RptTableColumn("FQty");
    	col.setWidth(120);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	format=RptCellFormatter.getNumberFormat(2,true);
    	col.setFormatPattern(format);
    	header.addColumn(col); 
    	
    	
    	//FAmount
    	col=new RptTableColumn("FAmount");
    	col.setWidth(120);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	format=RptCellFormatter.getNumberFormat(2,true);
    	col.setFormatPattern(format);
    	header.addColumn(col);
    	
    	//FMonthQty
    	col=new RptTableColumn("FMonthQty");
    	col.setWidth(120);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	format=RptCellFormatter.getNumberFormat(2,true);
    	col.setFormatPattern(format);
    	header.addColumn(col); 
    	
    	
    	//FLastMonthQty
    	col=new RptTableColumn("FLastMonthQty");
    	col.setWidth(120);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	format=RptCellFormatter.getNumberFormat(2,true);
    	col.setFormatPattern(format);
    	header.addColumn(col);
    	
    	//FAddQty
    	col=new RptTableColumn("FAddQty");
    	col.setWidth(120);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	format=RptCellFormatter.getNumberFormat(2,true);
    	col.setFormatPattern(format);
    	header.addColumn(col); 
    	
    	//FMonthAmount
    	col=new RptTableColumn("FMonthAmount");
    	col.setWidth(120);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	format=RptCellFormatter.getNumberFormat(2,true);
    	col.setFormatPattern(format);
    	header.addColumn(col); 
    	
    	
    	//FLastMonthAmount
    	col=new RptTableColumn("FLastMonthAmount");
    	col.setWidth(120);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	format=RptCellFormatter.getNumberFormat(2,true);
    	col.setFormatPattern(format);
    	header.addColumn(col);
    	
    	//FAddAmount
    	col=new RptTableColumn("FAddAmount");
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
    	
    	col=new RptTableColumn("fcxfy");
    	col.setWidth(120);    	
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	col.setHided(false);
    	header.addColumn(col);
    	
		obj[0][i]="当日销量";
    	obj[0][i+1]="当日销额";
    	obj[0][i+2]="当月销量";
    	obj[0][i+3]="上月销量";
    	obj[0][i+4]="增加销量";
    	obj[0][i+5]="当月销额";
    	obj[0][i+6]="上月销额";
    	obj[0][i+7]="增加销额";
    	obj[0][i+8]="状态";
    	obj[0][i+9]="促销费用";
    	//自动融合表头,表头行数没限制,只要数组二维长度与列数量相等就可以了.
    	//header.setLabels(new Object[][]{
    			//{"融合块","融合块","融合块","测试","测试"},
				//{"科目编码","科目名称","级别","方向","是否现金流量"}},true);
    	header.setLabels(obj);
    	return header;
    }
    
    
	/**
	 *插入数据
	 */
	public String insertRpt(Context ctx,RptParams params) throws BOSException {
    	Connection con = null;
		Statement batchStatement = null;
		
		String FCUID="";//
		String FdpDate="";//
		String FdpLastBeginDate="";//
		String FdpLastEndDate="";//
		String FdpBeginDate="";//
		String FdpProxBeginDate="";//
		StringBuffer StrRs=new StringBuffer();
		String rpttablename="";
		try {
			con = getConnection(ctx);
			batchStatement = con.createStatement();
			
			FCUID=params.getString("FCUID");
			FdpDate=params.getString("FdpDate");
			FdpLastBeginDate=params.getString("FdpLastBeginDate");//
			FdpLastEndDate=params.getString("FdpLastEndDate");//
			FdpBeginDate=params.getString("FdpBeginDate");//
			FdpProxBeginDate=params.getString("FdpProxBeginDate");//
			boolean ispersonA=false;//params.getBoolean("ispersonA");//按照业务员A
			
			//删除数据
			rpttablename=this.getTempTableName("Jack",ctx);
			RptAppCommon aa=new RptAppCommon();
			aa.createRptSql(ctx, rpttablename);
			
			//算当日销量
			String tablename=aa.rptCustomerBack(ctx,params, FCUID,"0",FdpDate,FdpDate,rpttablename,ispersonA);
			StrRs=new StringBuffer();
			StrRs.append("/*dialect*/update "+rpttablename+" t1 set (FQty,FAmount)=");
			StrRs.append(" (Select t2.FQty,t2.FAmount  ");
			StrRs.append(" from "+tablename+" t2 ");
			StrRs.append(" where t2.FControlUnitID=t1.FControlUnitID ");
			StrRs.append(" and t2.FAreaID=t1.FAreaID ");
			StrRs.append(" and t2.FSalePersonID=t1.FSalePersonID  ");
			StrRs.append(" and t2.FCustomerID=t1.FCustomerID  ");
			StrRs.append(" and t2.FMaterialID=t1.FMaterialID ) ");
			StrRs.append(" where t1.FControlUnitID='"+FCUID+"' ");
			StrRs.append(" and Exists ");
			StrRs.append(" (Select t2.FQty  ");
			StrRs.append(" from "+tablename+" t2 ");
			StrRs.append(" where t2.FControlUnitID=t1.FControlUnitID ");
			StrRs.append(" and t2.FAreaID=t1.FAreaID ");
			StrRs.append(" and t2.FSalePersonID=t1.FSalePersonID  ");
			StrRs.append(" and t2.FCustomerID=t1.FCustomerID  ");
			StrRs.append(" and t2.FMaterialID=t1.FMaterialID ) ");	
			batchStatement.addBatch(StrRs.toString());
			batchStatement.executeBatch();
			com.kingdee.eas.util.app.DbUtil.execute(ctx,"drop table "+tablename+" ");
			//算当日销量
			
			
			//算本月的
			tablename=aa.rptCustomerBack(ctx,params, FCUID,"0",FdpBeginDate,FdpProxBeginDate,rpttablename,ispersonA);
			StrRs=new StringBuffer();
			StrRs.append("/*dialect*/update "+rpttablename+" t1 set (FMonthQty,FMonthAmount)=");
			StrRs.append(" (Select t2.FQty,t2.FAmount  ");
			StrRs.append(" from "+tablename+" t2 ");
			StrRs.append(" where t2.FControlUnitID=t1.FControlUnitID ");
			StrRs.append(" and t2.FAreaID=t1.FAreaID ");
			StrRs.append(" and t2.FSalePersonID=t1.FSalePersonID  ");
			StrRs.append(" and t2.FCustomerID=t1.FCustomerID  ");
			StrRs.append(" and t2.FMaterialID=t1.FMaterialID ) ");
			StrRs.append(" where t1.FControlUnitID='"+FCUID+"' ");
			StrRs.append(" and Exists ");
			StrRs.append(" (Select 1  ");
			StrRs.append(" from "+tablename+" t2 ");
			StrRs.append(" where t2.FControlUnitID=t1.FControlUnitID ");
			StrRs.append(" and t2.FAreaID=t1.FAreaID ");
			StrRs.append(" and t2.FSalePersonID=t1.FSalePersonID  ");
			StrRs.append(" and t2.FCustomerID=t1.FCustomerID  ");
			StrRs.append(" and t2.FMaterialID=t1.FMaterialID ) ");
			batchStatement.addBatch(StrRs.toString());
			batchStatement.executeBatch();
			com.kingdee.eas.util.app.DbUtil.execute(ctx,"drop table "+tablename+" ");
			//算本月的
			
			//算上月
			tablename=aa.rptCustomerBack(ctx,params, FCUID,"0",FdpLastBeginDate,FdpLastEndDate,rpttablename,ispersonA);//FdpLastBeginDate
			StrRs=new StringBuffer();
			StrRs.append("/*dialect*/update "+rpttablename+" t1 set (FLastMonthQty,FLastMonthAmount)=");
			StrRs.append(" (Select t2.FQty,t2.FAmount  ");
			StrRs.append(" from "+tablename+" t2 ");
			StrRs.append(" where t2.FControlUnitID=t1.FControlUnitID ");
			StrRs.append(" and t2.FAreaID=t1.FAreaID ");
			StrRs.append(" and t2.FSalePersonID=t1.FSalePersonID  ");
			StrRs.append(" and t2.FCustomerID=t1.FCustomerID  ");
			StrRs.append(" and t2.FMaterialID=t1.FMaterialID ) ");
			StrRs.append(" where t1.FControlUnitID='"+FCUID+"' ");
			StrRs.append(" and Exists ");
			StrRs.append(" (Select t2.FQty  ");
			StrRs.append(" from "+tablename+" t2 ");
			StrRs.append(" where t2.FControlUnitID=t1.FControlUnitID ");
			StrRs.append(" and t2.FAreaID=t1.FAreaID ");
			StrRs.append(" and t2.FSalePersonID=t1.FSalePersonID  ");
			StrRs.append(" and t2.FCustomerID=t1.FCustomerID  ");
			StrRs.append(" and t2.FMaterialID=t1.FMaterialID ) ");
			batchStatement.addBatch(StrRs.toString());
			batchStatement.executeBatch();
			com.kingdee.eas.util.app.DbUtil.execute(ctx,"drop table "+tablename+" ");
			//算上月	
			
			//更新物料组别
			StrRs=new StringBuffer();
			StrRs.append("/*dialect*/update "+rpttablename+" t1 set ");  
			StrRs.append(" FMaterialGroupID= ");
        	StrRs.append(" ( ");
        	StrRs.append(" Select t2.FDisItemID ");
        	StrRs.append(" from AAMaterialDisItem t2 ");
        	//StrRs.append(" where  t2.FControlUnitID=t1.FControlUnitID ");
        	StrRs.append(" where t2.FMaterialID=t1.FMaterialID ");
        	StrRs.append(" )");
        	StrRs.append(" where t1.FControlUnitID='"+FCUID+"' ");
        	StrRs.append(" and Exists ");
        	StrRs.append(" ( ");
        	StrRs.append(" Select t2.FDisItemID ");
        	StrRs.append(" from AAMaterialDisItem t2 ");
        	//StrRs.append(" where  t2.FControlUnitID=t1.FControlUnitID ");
        	StrRs.append(" where t2.FMaterialID=t1.FMaterialID ");
        	StrRs.append(" )");
			batchStatement.execute(StrRs.toString());
			batchStatement.executeBatch();
			
			int FLevelA=0;
	    	FLevelA=params.getInt("FLevelA");
			for(int i=2;i>=FLevelA;i--){
				StrRs=new StringBuffer();
				StrRs.append("/*dialect*/update "+rpttablename+" t1 set ");  
				StrRs.append(" FMaterialGroupID= ");
	        	StrRs.append(" ( ");
	        	StrRs.append(" Select nvl(t2.FParentID,t2.FID) ");
	        	StrRs.append(" from t_lhz_DisItemTree t2 ");
	        	//StrRs.append(" where  t2.FControlUnitID=t1.FControlUnitID ");
	        	StrRs.append(" where t2.FID=t1.FMaterialGroupID ");
	        	StrRs.append(" )");
	        	StrRs.append(" where t1.FControlUnitID='"+FCUID+"' ");
	        	StrRs.append(" and Exists ");
	        	StrRs.append(" ( ");
	        	StrRs.append(" Select nvl(t2.FParentID,t2.FID) ");
	        	StrRs.append(" from t_lhz_DisItemTree t2 ");
	        	//StrRs.append(" where  t2.FControlUnitID=t1.FControlUnitID ");
	        	StrRs.append(" where t2.FID=t1.FMaterialGroupID ");
	        	StrRs.append(" )");
				batchStatement.execute(StrRs.toString());
				batchStatement.executeBatch();
			}
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

}