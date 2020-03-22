package com.kingdee.eas.custom.ccchargeback.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

import bos.org.apache.commons.dbutils.DbUtils;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.bi.model.DB.DBUtil;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import java.lang.String;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class ccCheckBillFacadeControllerBean extends AbstractccCheckBillFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.ccchargeback.app.ccCheckBillFacadeControllerBean");

	@Override
	protected String _getLairageQtyByHenhouseId(Context ctx, String henHouseID)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		if(henHouseID==null||henHouseID.equals(""))
			return null;

		StringBuffer sb=getStringBufferGetLairageDateByHenhouseID(henHouseID);
		IRowSet rs = null;
		rs=DbUtil.executeQuery(ctx, sb.toString());
		try {
			if(rs.next()){
				String lastDay=rs.getString("incoopDate");
				sb=getStringBufferGetLairageQtyByLairageDate(henHouseID,lastDay);
				rs=DbUtil.executeQuery(ctx, sb.toString());
				if(rs.next())
					return String.valueOf(rs.getInt("CFInitQty"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	private StringBuffer getStringBufferGetLairageQtyByLairageDate(
			String henHouseID, String lastDay) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		sb.append("select t1.CFHenHouseID henHouseID,t1.CFInitQty ");
		sb.append(" from CT_FM_BreedBatchEntry           t1 ");
		sb.append(" inner join CT_FM_BreedBatch          t2  on t2.FID=t1.FParentID and t2.CFBaseStatus in (2,4)");
		sb.append(" where t1.CFHenHouseID='").append(henHouseID).append("'");
		sb.append(" and t1.CFIncoopDate={ts '").append(lastDay.substring(0, 10)).append("'}");
		return sb;
	}
	/**
	 * 根据鸡舍ID获取当前批次入栏日期的StringBuffer
	 * @return
	 */
	private StringBuffer getStringBufferGetLairageDateByHenhouseID(String henHouseID) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		sb.append("select t1.CFHenHouseID henHouseID,max(CFIncoopDate) incoopDate");
		sb.append(" from CT_FM_BreedBatchEntry           t1 ");
		sb.append(" inner join CT_FM_BreedBatch          t2  on t2.FID=t1.FParentID and t2.CFBaseStatus in (2,4)");
		sb.append(" where t1.CFHenHouseID='").append(henHouseID).append("'");
		sb.append(" group by t1.CFHenHouseID");
		return sb;
	}

}