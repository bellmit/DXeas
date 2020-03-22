package com.kingdee.eas.custom.taihe.door.app;

import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class DoorWsFacadeControllerBean extends AbstractDoorWsFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.taihe.door.app.DoorWsFacadeControllerBean");

    /**
     * 校验接口
     */
	@Override
	protected String _verify(Context ctx, String jsonStr) throws BOSException,EASBizException {
		JSONObject json=JSONObject.parseObject(jsonStr);
		String number=json.getString("number");//应收单号
		String carNum=json.getString("carNumber");//车牌号
		String result="false";
		IRowSet rs=null;;
		System.out.println("········【门禁】······车牌号:"+carNum+"，单据号:"+number);
		if(StringUtils.isNotEmpty(number)) {
			StringBuffer sql=new StringBuffer();
			sql.append(" select distinct tsale.fid from t_ar_otherbill tother ")
			.append(" inner join t_ar_otherbillEntry tentry on tentry.fparentid=tother.fid")
			.append(" inner join t_sd_saleOrder tsale on tsale.fid=tentry.fcorebillid")
			.append(" where tother.fnumber='"+number+"' and tother.FBillStatus=3")
			.append(" and (tsale.cfisfinishoutdoor=0 or tsale.cfisfinishoutdoor=1)")
			;
			rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.size()>0) {
				result= "success";
			}
		} else 	if(StringUtils.isNotEmpty(carNum)) {
			StringBuffer sql=new StringBuffer();
			sql.append(" select distinct tsale.fid from t_ar_otherbill tother ")
			.append(" inner join t_ar_otherbillEntry tentry on tentry.fparentid=tother.fid")
			.append(" inner join t_sd_saleOrder tsale on tsale.fid=tentry.fcorebillid")
			.append(" where tsale.cflicensePlateNum='"+carNum+"' and tother.FBillStatus=3")
			.append(" and (tsale.cfisfinishoutdoor=0 or tsale.cfisfinishoutdoor is null)")
			;
			rs = DbUtil.executeQuery(ctx, sql.toString());
			if(rs.size()>0) {
				result= "success";
			}
		}
		if(rs!=null) {
			try {
				String ids="";
				while(rs.next()) {
					if(ids.length()>0) {
						ids+=",";
					}
					ids="'"+rs.getString("fid")+"'";
				}
				//更新销售订单为已出门
				if(ids.length()>0) {
					DbUtil.execute(ctx, "update t_sd_saleOrder set  cfisfinishoutdoor=1 where fid in ("+ids+")");
					System.out.println("········【开门成功】······车牌号:"+carNum+"，单据号:"+number);
				}
			} catch (SQLException e) {
				throw new BOSException(e);
			}
		}
		return result;
	}
    
    
}