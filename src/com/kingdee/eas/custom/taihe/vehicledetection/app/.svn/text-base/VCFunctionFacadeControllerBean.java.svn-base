package com.kingdee.eas.custom.taihe.vehicledetection.app;

import java.sql.SQLException;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class VCFunctionFacadeControllerBean extends AbstractVCFunctionFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.taihe.vehicledetection.app.VCFunctionFacadeControllerBean");
    /**
     * 车辆识别
     */
    protected String _checkPermission(Context ctx, String param)throws BOSException, EASBizException
    {
    	JSONObject json=JSONObject.fromObject("param");
    	String carNum=json.getString("carNum");
    	int channelType=json.getInt("channelType");//出入口类型
    	
		json.put("canAcross", true);
		json.put("msg", "验证通过，可以通行！");
		
    	StringBuffer sql=new StringBuffer();
    	sql.append(" select ")
    	.append(" from ")
    	.append(" left join CT_PUB_Car tcar on tcar.fid=tmain.fcarid")
    	.append(" where tcar.fnumber='").append(carNum).append("'")
    	.append(" ");
    	IRowSet rs = DbUtil.executeQuery(ctx, sql.toString());
    	try {
			while(rs.next()) {
				if(rs.getInt("")==0) {
					json.put("canAcross",false);
					json.put("msg", "尚未付款，不能出场！");
				}
			}
			if(rs.size()<=0) {
				json.put("canAcross",false);
				json.put("msg", "未找到订单信息！");
			}
		} catch (SQLException e) {
			throw new BOSException(e);
		}
        return json.toString();
    }
}