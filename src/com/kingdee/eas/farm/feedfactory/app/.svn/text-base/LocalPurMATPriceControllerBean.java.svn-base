package com.kingdee.eas.farm.feedfactory.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

import com.kingdee.eas.custom.wlhllicensemanager.app.WlhlDataBaseControllerBean;
import com.kingdee.eas.farm.feedfactory.LocalPurMATPriceEntryInfo;
import com.kingdee.eas.farm.feedfactory.LocalPurMATPriceInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseCollection;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo;

import java.lang.String;
import com.kingdee.eas.farm.feedfactory.LocalPurMATPriceCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LocalPurMATPriceControllerBean extends AbstractLocalPurMATPriceControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.feedfactory.app.LocalPurMATPriceControllerBean");
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 核准
	 */
	@Override
	protected void _approve(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		LocalPurMATPriceInfo info=(LocalPurMATPriceInfo) model;
		if(info.getBaseStatus().equals(UsedStatusEnum.APPROVED)||info.getBaseStatus().equals(UsedStatusEnum.ENABLED)) {
			throw new EASBizException(new NumericExceptionSubItem("","资料已经核准或启用！"));
		}
		beforeApprove(ctx, info);
		super._approve(ctx, info);
		afterApprove(ctx, info);
	}


	private void beforeApprove(Context ctx,LocalPurMATPriceInfo info) throws EASBizException {
		for(int i=0;i<info.getEntry().size();i++){
			LocalPurMATPriceEntryInfo entry = info.getEntry().get(i);
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append(" /*dialect*/select t1.fid fid,t2.CFMaterialName materialName from CT_FM_LocalPurMATPrice t1 ")
			.append(" inner join  CT_FM_LocalPurMATPriceEntry t2 on t1.fid=t2.fparentid ")
			.append(" where t1.FBaseStatus=2 ")
			.append(" and to_char(t1.CFBeginDate,'yyyy-MM-dd')= '").append(sdf.format(info.getBeginDate())).append("'")
			.append(" and t2.CFMaterialID='"+entry.getMaterial().getId().toString()+"' ");
			if(info.getId()!=null){
				sqlBuf.append(" and t1.fid<>'"+info.getId().toString()+"'");
			}			
			sqlBuf.append(" and t1.CFCompanyID ='"+info.getCompany().getId().toString()+"'");
			try {
				IRowSet rs = DbUtil.executeQuery(ctx, sqlBuf.toString());
				if(rs.next()){
					throw new EASBizException(new NumericExceptionSubItem("001","当前公司物料:"+rs.getString("materialName")+"\n已维护了相同生效日期的资料,操作失败请修改!"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void afterApprove(Context ctx,LocalPurMATPriceInfo info) throws EASBizException {
		Calendar cal=Calendar.getInstance();
		cal.setTime(info.getBeginDate());
		cal.add(Calendar.DATE, -1);
		for(int i=0;i<info.getEntry().size();i++){
			LocalPurMATPriceEntryInfo entry = info.getEntry().get(i);
			StringBuffer sqlBuf = new StringBuffer();
			sqlBuf.append(" /*dialect*/select t1.fid fid from CT_FM_LocalPurMATPrice t1 ")
			.append(" inner join  CT_FM_LocalPurMATPriceEntry t2 on t1.fid=t2.fparentid ")
			.append(" where t1.FBaseStatus=2 ")
			.append(" and to_char(t1.CFBeginDate,'yyyy-MM-dd')< '").append(sdf.format(info.getBeginDate())).append("'")
			.append(" and t2.CFMaterialID='"+entry.getMaterial().getId().toString()+"' ");
			if(info.getId()!=null){
				sqlBuf.append(" and t1.fid<>'"+info.getId().toString()+"'");
			}			
			sqlBuf.append(" and t1.CFCompanyID ='"+info.getCompany().getId().toString()+"' order by t1.CFBeginDate desc");
			try {
				IRowSet rs = DbUtil.executeQuery(ctx, sqlBuf.toString());
				if(rs.next()){
					String id = rs.getString("fid");
					String sql="/*dialect*/update CT_FM_LocalPurMATPrice set cfenddate=to_date('"+sdf.format(cal.getTime())+"','yyyy-mm-dd') where fid ='"+id+"'";
					DbUtil.execute(ctx, sql);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}