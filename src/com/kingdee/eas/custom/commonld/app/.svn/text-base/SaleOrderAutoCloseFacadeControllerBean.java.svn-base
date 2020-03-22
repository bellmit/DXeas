	package com.kingdee.eas.custom.commonld.app;
	
	import org.apache.log4j.Logger;
	import javax.ejb.*;
	import java.rmi.RemoteException;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.LinkedHashMap;
	import java.util.List;
	import java.util.Map;
	import java.util.Map.Entry;
	
	import com.kingdee.bos.*;
	import com.kingdee.bos.util.BOSObjectType;
	import com.kingdee.bos.util.BOSUuid;
	import com.kingdee.bos.metadata.IMetaDataPK;
	import com.kingdee.bos.metadata.rule.RuleExecutor;
	import com.kingdee.bos.metadata.MetaDataPK;
	//import com.kingdee.bos.metadata.entity.EntityViewInfo;
	import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
	import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
	//import com.kingdee.bos.dao.IObjectPK;
	import com.kingdee.bos.dao.IObjectValue;
	import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
	import com.kingdee.bos.service.ServiceContext;
	import com.kingdee.bos.service.IServiceContext;
	
	
	
	
	import com.kingdee.eas.common.EASBizException;
	import com.kingdee.eas.scm.common.BillBaseStatusEnum;
	import com.kingdee.eas.scm.sd.sale.SaleOrderEntryInfo;
import com.kingdee.eas.scm.sd.sale.SaleOrderFactory;
	import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
	import com.kingdee.eas.util.SysUtil;
	import com.kingdee.eas.util.app.DbUtil;
	import com.kingdee.eas.util.client.MsgBox;
	import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.UuidException;
	
	public class SaleOrderAutoCloseFacadeControllerBean extends AbstractSaleOrderAutoCloseFacadeControllerBean
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1014097306325382278L;
		private static Logger logger =
			Logger.getLogger("com.kingdee.eas.custom.commonld.app.SaleOrderAutoCloseFacadeControllerBean");

		/*筛选出距现在时间超过三天且销售组织为食品事业部且单据状态为新增、保存、提交的销售订单，并更改为关闭状态*/
		protected void _closeSaleOrder(Context ctx) throws BOSException,
		EASBizException {
			Map<String,SaleOrderInfo> saleOrderMap = new LinkedHashMap<String,SaleOrderInfo>();
			StringBuffer selectSql = new StringBuffer();
			selectSql.append("select * from T_SD_SaleOrder s1 left join T_ORG_Sale xszz  on s1.FSaleOrgUnitID=xszz.fid ")
			.append("where (s1.fbaseStatus='0' or s1.fbaseStatus='1' or s1.fbaseStatus='2' or s1.fbaseStatus='3') and s1.fbizdate <= sysDate -3 ")
			.append("and (s1.FSaleOrgUnitID in ('75QAAAAAAeTM567U','75QAAAAAMorM567U','75QAAAAAMsLM567U','75QAAAAAMlLM567U','75QAAAAAAajM567U'))");
			IRowSet rs=DbUtil.executeQuery(ctx, selectSql.toString());
			if(rs.size() < 1){
				//			throw new BOSException("没有过期的单据");
			}
			try {
				while(rs.next()){
					SaleOrderInfo info =new SaleOrderInfo();
					try {
						info.setId(BOSUuid.read(rs.getString("FID")));
						info.setBizDate(rs.getDate("FBIZDATE"));
						info.setBaseStatus(BillBaseStatusEnum.getEnum(rs.getInt("fbaseStatus")));
						saleOrderMap.put(rs.getString("FID"), info);
					} catch (UuidException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}		
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Iterator iter= saleOrderMap.entrySet().iterator();  
			while(iter.hasNext()){
				Map.Entry entry = (Map.Entry) iter.next(); 
				SaleOrderInfo info =(SaleOrderInfo) entry.getValue();
				BOSUuid uuid=info.getId();
				ObjectUuidPK pk = new ObjectUuidPK(uuid);
				SaleOrderFactory.getLocalInstance(ctx).autoClose(pk);
			}	
			super._closeSaleOrder(ctx);
		}
	
	
	
	
	}