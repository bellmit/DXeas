package com.kingdee.eas.outinterface.farm.duck.busniess;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

/**
 * 商品禽工具列
 * @author alex_dai
 *
 */
public class DuckBusinessUtils {

	/**
	 * 根据养户Id获取管理员
	 * @param ctx
	 * @param farmerId
	 * @return
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	public static PersonInfo getManagerPersonByFarmer(Context ctx,String farmerId) throws BOSException, EASBizException {
		if(StringUtils.isEmpty(farmerId)) {
			return null;
		}
		StringBuffer sql=new StringBuffer();
		sql.append(" select distinct tmain.FPersonID")
		.append(" from T_FM_PersonFarmerRange tmain")
		.append(" inner join T_FM_PersonFarmerRangeEntry tentry on tentry.fparentid=tmain.fid")
		.append(" where tmain.FBaseStatus=3")
		.append(" and tentry.FFarmerID=?")
		.append(" ");
		IRowSet rs = DbUtil.executeQuery(ctx, sql.toString(),new String[]{farmerId});
		try {
			if(rs.next()){
				return PersonFactory.getLocalInstance(ctx).getPersonInfo(new ObjectUuidPK(rs.getString("FPersonId")));
			}
		} catch (SQLException e) {
			throw new BOSException(e);
		}
		return null;
	}
	
	/**
	 * 计算日期差
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getDayDiff(Date startDate,Date endDate) {
		Calendar cal=Calendar.getInstance();
		cal.setTime(startDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		startDate=cal.getTime();
		
		cal.setTime(endDate);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		endDate=cal.getTime();
		
		//得到相差的天数 betweenDate
		long betweenDate = (endDate.getTime() - startDate.getTime())/(60*60*24*1000);
		return (int) betweenDate;
	}
	
}
