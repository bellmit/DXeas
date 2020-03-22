package com.kingdee.eas.farm.food.comm;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.weighbridge.CommSqlFacadeFactory;
import com.kingdee.eas.weighbridge.ICommSqlFacade;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class FarmCommUtils {
    private static final Logger logger = CoreUIObject.getLogger(FarmCommUtils.class);
	/**
	 * 对比单据状态
	 * @param nowStatus
	 * @param orderStatus
	 * @return
	 */
	public static Boolean checkBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum nowStatus,com.kingdee.eas.scm.common.BillBaseStatusEnum orderStatus) {
		if(nowStatus.equals(orderStatus)) {
			return true;
		}
		
		return false;
	}
	/**
	 * 检查是否存在下游单据
	 * @param ctx
	 * @param pk
	 * @param coreBillInfo
	 * @throws BOSException
	 * @throws EASBizException
	 */
	public static void isExitBTPBill(Context ctx, IObjectPK pk, CoreBillBaseInfo coreBillInfo) throws BOSException,
			EASBizException {
		IBTPManager iBTPManager;
		if(ctx!=null)
			iBTPManager= BTPManagerFactory.getLocalInstance(ctx);
		else 
			iBTPManager= BTPManagerFactory.getRemoteInstance();
		if (!(iBTPManager.ifHaveDestBills(pk.toString()))) {
			/*try {
				if (coreBillInfo instanceof CoreBillBaseInfo) {
					iBTPManager.removeAllSRCRelation(coreBillInfo);
				}
			} catch (BTPException ex) {
				throw new BTPException(BTPException.RELATIONDELETEERROR, ex);
			}*/

		} else {
			throw new BillBaseException(new NumericExceptionSubItem("001","单据存在下游单据"));
		}
	}
	/**
	 * 根据组织委托关系得到 被委托组织ID
	 *     //无=-1,行政组织=0,财务组织=1,销售组织=2,采购组织=3,库存组织=4,成本中心=5,利润中心=6,合并范围=8,管理单元=10,HR组织=16,发运组织=24,质检组织=32
	 * @throws BOSException 
	 * @throws SQLException 
	 */
	public static String  getFromOrgIDByRelation(Context ctx,String fromOrgID,int fromType,int toType) throws BOSException, SQLException {
		StringBuffer sql=new StringBuffer();
		sql.append(" select t1.FToUnitID");
		sql.append(" from T_ORG_UnitRelation t1");
		sql.append(" inner join T_ORG_TypeRelation t2 on t2.fid=t1.FTypeRelationID");
		sql.append(" where t2.FToType=? and t2.FFromType=?");
		//sql.append(" and t2.FExistReverseDelegate=0");//反向委托
		sql.append(" and t1.FFromUnitID=?");
		ICommSqlFacade is;
		if(ctx==null)
			is= CommSqlFacadeFactory.getRemoteInstance();
		else
			is=CommSqlFacadeFactory.getLocalInstance(ctx);
		IRowSet rs=is.executeQuery(sql.toString(),new Object[]{toType,fromType,fromOrgID});
		while(rs.next()) {
			return rs.getString("FToUnitID");
		}
		rs.close();
		return "testID";
	}
	/**
	 * 根据组织委托关系得到 委托组织ID
	 *     //无=-1,行政组织=0,财务组织=1,销售组织=2,采购组织=3,库存组织=4,成本中心=5,利润中心=6,合并范围=8,管理单元=10,HR组织=16,发运组织=24,质检组织=32
	 * @throws BOSException 
	 * @throws SQLException 
	 */
	public static ArrayList<String>  getToOrgIDByRelation(Context ctx,String toOrgID,int fromType,int toType) throws BOSException {
		ArrayList<String> list=null;
		StringBuffer sql=new StringBuffer();
		sql.append(" select t1.FFromUnitID");
		sql.append(" from T_ORG_UnitRelation t1");
		sql.append(" inner join T_ORG_TypeRelation t2 on t2.fid=t1.FTypeRelationID");
		sql.append(" where t2.FToType=? and t2.FFromType=?");
		//sql.append(" and t2.FExistReverseDelegate=0");//反向委托
		sql.append(" and t1.FToUnitID=?");
		ICommSqlFacade is;
		if(ctx==null)
			is= CommSqlFacadeFactory.getRemoteInstance();
		else
			is=CommSqlFacadeFactory.getLocalInstance(ctx);
		IRowSet rs=is.executeQuery(sql.toString(),new Object[]{toType,fromType,toOrgID});
		if(rs.size()>0) 
			list=new ArrayList<String>();
		try {
			while(rs.next()) {
				list.add(rs.getString("FFromUnitID"));
			}
			rs.close();
		}catch(Exception e){
			throw new BOSException(e);
		}
		return list;
	}
	
}
