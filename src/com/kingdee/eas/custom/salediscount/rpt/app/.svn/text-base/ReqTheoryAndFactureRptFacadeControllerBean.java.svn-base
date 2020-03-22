package com.kingdee.eas.custom.salediscount.rpt.app;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import com.kingdee.bos.*;
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

import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.report.app.CommRptBaseControllerBean;
import com.kingdee.eas.framework.report.util.RptCellFormatter;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.util.RptRowSet;
import com.kingdee.eas.framework.report.util.RptTableColumn;
import com.kingdee.eas.framework.report.util.RptTableHeader;
import com.kingdee.eas.util.app.DbUtil;

public class ReqTheoryAndFactureRptFacadeControllerBean extends AbstractReqTheoryAndFactureRptFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.salediscount.rpt.app.ReqTheoryAndFactureRptFacadeControllerBean");
    
    

    @Override
	protected RptParams _createTempTable(Context ctx, RptParams params) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
    	return params;
		
	}
//    /**
//     * 获取 创建临时表语句
//     * @param ctx
//     * @return
//     */
//	private String getGreateTempTableSql(Context ctx){
//		StringBuilder sb = new StringBuilder();
//		sb.append("");
//	}
    
    public RptTableHeader Header(){
    	//构造表头
    	RptTableHeader header=new RptTableHeader();
    	RptTableColumn col=null;
    	
    	String format=RptCellFormatter.getNumberFormat(2,true); 
    	
    	//5
    	col=new RptTableColumn("materialNumber");
    	col.setWidth(130);    	
    	col.setAligment(RptTableColumn.HALIGN_LEFT);
    	//col.setFormatPattern(format);
    	header.addColumn(col);
    	//6
    	col=new RptTableColumn("materialName");
    	col.setWidth(180);    	
    	col.setAligment(RptTableColumn.HALIGN_LEFT);
//    	col.setFormatPattern(format);
    	header.addColumn(col);
//    	//7
    	col=new RptTableColumn("unit");
    	col.setWidth(85);  
//    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_LEFT);
    	header.addColumn(col);
    	//7+1
    	col=new RptTableColumn("qty");
    	col.setWidth(100);  
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	//7+2 厂价
    	col=new RptTableColumn("pfqty");
    	col.setWidth(100); 
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	
    	//7+2 立折
    	col=new RptTableColumn("cy");
    	col.setWidth(100); 
    	col.setFormatPattern(format);
    	col.setAligment(RptTableColumn.HALIGN_RIGHT);
    	header.addColumn(col);
    	
    	
    	
    	
    	
    	

    	header.setLabels(new Object[][]{
			{"物料编码","物料名称",
				"计量单位","实际领用数量","理论耗用量","差异"}});
    	return header;
    }
	
	
	protected RptParams _init(Context ctx, RptParams params) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		RptParams pp=new RptParams();
    	pp.setString("title","报表");    	
        return pp;
	}


	@Override
	protected RptParams _query(Context ctx, RptParams params, int from, int len) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		
		Object[] cu=(Object[]) params.getObject("CU");
		// 公司ID
		String CompanyID = params.getString("companyID");
		// 客户ID	
		String customerID = params.getString("customerID"); 
		// 开始日期
		String beginDate = params.getString("beginDate"); 
		// 结束日期
		String endDate = params.getString("endDate"); 
		
		
			
		sb.append("select tm.fnumber materialNumber, max(tm.fname_l2) materiaName,max(mu.fname_l2) unit,");
		sb.append(" sum(te.fqty) qty,sum(cfpfqty) pfqty, sum(te.fqty)-sum(cfpfqty) cy ");
		sb.append(" from t_im_materialreqbill t inner join t_im_materialreqbillentry te on t.fid = te.fparentid ");
		sb.append(" inner join t_bd_material tm on te.fmaterialid = tm.fid ");
		sb.append(" inner join t_bd_measureunit mu on te.funitid = mu.fid ");
		
		sb.append(" where t.FStorageOrgUnitID ='");
		sb.append(CompanyID);
		sb.append("' and t.FBizDate >={d'");
    	sb.append(beginDate);
    	sb.append("'} and t.fbizDate <={d'");
    	sb.append(endDate);
    	sb.append("'}  group by tm.fnumber order by tm.fnumber ");
    	
    	
			
			
		
		RptRowSet rs=this.executeQuery(sb.toString(),null,ctx);
    	RptParams pp=new RptParams();
    	pp.setObject("header", Header());
    	pp.setObject("rowset",rs);
    	return pp;
	}
}