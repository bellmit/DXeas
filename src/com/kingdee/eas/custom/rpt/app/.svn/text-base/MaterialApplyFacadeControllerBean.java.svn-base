package com.kingdee.eas.custom.rpt.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

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
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.framework.report.app.CommRptBaseControllerBean;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class MaterialApplyFacadeControllerBean extends AbstractMaterialApplyFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.rpt.app.MaterialApplyFacadeControllerBean");
	protected static String sp="\r\n";

	@Override
	protected RptParams _query(Context ctx, RptParams params)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		if (null == params) {
			throw new EASBizException(new NumericExceptionSubItem("0003","请先设置过滤条件.."));
		}
		getAgeOfDaysRange(ctx,params);
		getMaterialApplyData(ctx,params);
		return params;
	}

	private void getMaterialApplyData(Context ctx, RptParams params) throws BOSException {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		sb.append("SELECT").append(sp);
		sb.append("t7.CFName                              henHouseName,").append(sp);
		sb.append("t5.FName_l2                            materialName,").append(sp);
		sb.append("t6.CFBeginDays                         startDate,").append(sp);
		sb.append("t6.CFEndDays                           endDate").append(sp);


		sb.append("FROM").append(sp);
		sb.append("CT_FM_MaterialApplyBill                  t1").append(sp);
		sb.append("inner join T_ORG_Storage                 t2  on t2.FID=t1.CFStoOrgID").append(sp);
		sb.append("inner join CT_FM_BreedBatch              t3  on t3.FID=t1.CFBreedBatchID").append(sp);
		sb.append("inner join CT_FM_MaterialApplyBillEntry  t4  on t1.FID=t4.FParentID").append(sp);   
		sb.append("inner join T_BD_Material                 t5  on t5.FID=t4.CFMaterialID").append(sp);
		sb.append("inner join CT_FM_MaterialABHE            t6  on t4.FID=t6.FParentID").append(sp);
		sb.append("inner join CT_FM_Henhouse                t7  on t7.FID=t6.CFHenhouseID").append(sp);


		sb.append("where t2.FName_l2='").append(params.getObject("stoOrgUnit")).append("'").append(sp);
		sb.append("and t3.FID='").append(((BreedBatchInfo)params.getObject("breedBatch")).getId().toString()).append("'").append(sp);
		sb.append("and t1.CFBaseStatus=4").append(sp);
		sb.append("order by length(t7.CFName),t7.CFName,t6.CFBeginDays").append(sp);


		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		params.setObject("data", rs);
	}

	/**
	 * 获取年龄范围
	 * @param ctx
	 * @param params
	 * @return
	 * @throws BOSException 
	 */
	private Object getAgeOfDaysRange(Context ctx, RptParams params) throws BOSException {
		// TODO Auto-generated method stub


		StringBuffer sb=new StringBuffer();
		sb.append("select min(CFBeginDays) minDays,max(CFEndDays) maxDays from ");
		sb.append("CT_FM_MaterialApplyBill t1").append(sp);
		sb.append("inner join CT_FM_MaterialApplyBillEntry t2 on t1.FID=t2.FParentID").append(sp);
		sb.append("inner join CT_FM_MaterialABHE t3 on t2.FID=t3.FParentID").append(sp);
		sb.append("where t1.CFBreedBatchID='").append(((BreedBatchInfo)params.getObject("breedBatch")).getId().toString()).append("'").append(sp);
		sb.append("and t1.CFBaseStatus=4");

		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		try {
			while(rs.next()){
				params.setObject("minDays", rs.getInt("minDays"));
				params.setObject("maxDays", rs.getInt("maxDays"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}