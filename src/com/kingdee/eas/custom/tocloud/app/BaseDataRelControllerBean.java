package com.kingdee.eas.custom.tocloud.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.itrus.util.SystemUtils;
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

import com.kingdee.eas.framework.app.DataBaseControllerBean;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.scm.common.BizTypeFactory;
import com.kingdee.eas.basedata.scm.common.BizTypeInfo;
import com.kingdee.eas.custom.tocloud.BaseDataRelCollection;
import com.kingdee.eas.custom.tocloud.BaseDataRelEntryCollection;
import com.kingdee.eas.custom.tocloud.BaseDataRelEntryInfo;
import com.kingdee.eas.custom.tocloud.TargetSystemFactory;
import com.kingdee.eas.custom.tocloud.TargetSystemInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.ncm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.client.MsgBox;
//import com.kingdee.eas.rptclient.gr.rptclient.util.DbUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.custom.tocloud.BaseDataRelInfo;
import com.kingdee.eas.custom.tocloud.utils.BaseDataUtil;
import com.kingdee.jdbc.rowset.IRowSet;

public class BaseDataRelControllerBean extends AbstractBaseDataRelControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.tocloud.app.BaseDataRelControllerBean");

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {

		BaseDataRelInfo info = (BaseDataRelInfo)model;
		info.setStatus(BillBaseStatusEnum.AUDITED);
		try {
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw  new BOSException(e);
		}
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {

		BaseDataRelInfo info = (BaseDataRelInfo)model;
		if(info.getStatus()==null||info.getStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {

		BaseDataRelInfo info = (BaseDataRelInfo)model;
		if(info.getStatus()==null||info.getStatus().equals(BillBaseStatusEnum.ADD)||info.getStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setStatus(BillBaseStatusEnum.SUBMITED);
		}

		checkUniqueness(ctx,info);

		//点击提交，就会把分录中源系统和目标系统的编码放到一个Map中，
		//以后可以通过eas的编码直接获得cloud里面的编码
		addElementToMap(ctx,info);

		return super._submit(ctx, model);
	}

	/**
	 * 往Map中缓存键值对
	 * @param ctx
	 * @param info
	 */
	private void addElementToMap(Context ctx, BaseDataRelInfo info) {
		// TODO Auto-generated method stub

		BaseDataRelEntryCollection basedataColl = info.getEntry();

		StringBuffer baseDataMapKey = new StringBuffer();
		String KEY_SPLIT_VALUE = "-";
		
		Map<String,String> baseDataMap = new HashMap<String,String>();
		for(int i=0,length=basedataColl.size();i<length;i++){
			BaseDataRelEntryInfo basedataInfo = basedataColl.get(i);
			baseDataMapKey.setLength(0);
			baseDataMapKey.append(info.getTargetSystem().getId().toString());
			baseDataMapKey.append(KEY_SPLIT_VALUE);
			baseDataMapKey.append(info.getBaseDataType().getId().toString());
			baseDataMapKey.append(KEY_SPLIT_VALUE);
			baseDataMapKey.append(basedataInfo.getSrcNumber());
			baseDataMap.put(baseDataMapKey.toString(), basedataInfo.getTargetNumber());
		}
	}

	private void checkUniqueness(Context ctx, BaseDataRelInfo info) throws BOSException{
		// TODO Auto-generated method stub

		TargetSystemInfo targetInfo = null;
		BizTypeInfo bizTypeInfo = null;

		try {
			targetInfo = TargetSystemFactory.getLocalInstance(ctx).getTargetSystemInfo(new ObjectUuidPK(info.getTargetSystem().getId()));
			bizTypeInfo = BizTypeFactory.getLocalInstance(ctx).getBizTypeInfo(new ObjectUuidPK(info.getBaseDataType().getId()));
		} catch (EASBizException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		StringBuffer sq = new StringBuffer();
		sq.append("/*dialect*/  select  t1.fid billid  from CT_CLD_BaseDataRel  t1 ");
		sq.append("where t1.CFStatus=4  and  t1.CFTargetSystemID='");
		sq.append(targetInfo.getId().toString());
		sq.append("'");sq.append("\n");
		sq.append("and t1.CFBaseDataTypeID='");
		sq.append(info.getBaseDataType().getId());
		sq.append("'");

		try {
			IRowSet rs = DbUtil.executeQuery(ctx, sq.toString());
			if(rs.next()){
				String billid = rs.getString("billid");
				throw new BOSException("该目标系统："+targetInfo.getName().toString()+"， 和业务类型："+info.getBaseDataType().getName().toString()+"，对应的基础资料映射已经存在，请勿重复提交！");
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BOSException(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException {

		BaseDataRelInfo info = (BaseDataRelInfo)model;
		info.setStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		try {
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw  new BOSException(e);
		}
	}

}