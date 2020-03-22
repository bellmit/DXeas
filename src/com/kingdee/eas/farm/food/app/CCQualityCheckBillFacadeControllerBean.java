package com.kingdee.eas.farm.food.app;

import org.apache.log4j.Logger;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBill;
import com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillFactory;
import com.kingdee.eas.custom.ccchargeback.CcChargeBackBizBillInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class CCQualityCheckBillFacadeControllerBean extends AbstractCCQualityCheckBillFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.food.app.CCQualityCheckBillFacadeControllerBean");
    private static String sp="\r\n";
    protected ArrayList _getQualityCheckInfoByBizDate(Context ctx, Date bizDate,String stoOrgUnitID)throws BOSException, EASBizException
    {
    	ArrayList<CcChargeBackBizBillInfo> qcInfos=new ArrayList<CcChargeBackBizBillInfo>();
    	
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	String bizDateStr = sdf.format(bizDate);
		StringBuffer sb=new StringBuffer();
		sb.append("select FID").append(sp);
		sb.append("from T_CCC_CcChargeBackBizBill t1").append(sp);
		sb.append(" where to_char(t1.FBizDate,'yyyy-MM-dd')='").append(bizDateStr).append("'").append(sp);
		sb.append(" and t1.FBillStatus=4").append(sp);
		sb.append(" and t1.FStoOrgUnitID='").append(stoOrgUnitID).append("'").append(sp);
		
		IRowSet rs = DbUtil.executeQuery(ctx,sb.toString());
		try {
			while(rs.next())
				qcInfos.add(CcChargeBackBizBillFactory.getLocalInstance(ctx).getCcChargeBackBizBillInfo(new ObjectUuidPK(rs.getString("FID"))));
			return qcInfos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
}