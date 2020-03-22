package com.kingdee.eas.farm.carnivorous.basedata.app;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

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
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.DataBaseControllerBean;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.farm.carnivorous.basedata.FarmCollection;
import com.kingdee.eas.farm.carnivorous.basedata.FarmFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFarmEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.util.app.PinYinHelper;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.HanYuPinYinUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FarmControllerBean extends AbstractFarmControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.basedata.app.FarmControllerBean");
	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		FarmInfo info = (FarmInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}
		if (info.isIsAllot()) {
			throw new EASBizException(new NumericExceptionSubItem("001","已分配的养殖场不能禁用"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.frozen);
		//		setZhuJiMa(info);
		this._update(ctx, pk, info);
	}

	/**
	 * 设置助记码
	 * @param info
	 */
	private void setZhuJiMa(FarmInfo info) {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(info.getMnemonicCode())){
			info.setMnemonicCode(HanYuPinYinUtil.getInstance().getPinYinSpellingHead(info.getName()));
		}
	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		FarmInfo info = (FarmInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未禁用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, pk, info);

		//		boolean flag = false;
		//		if(info.getFarmer()!=null){
		//			for(int i=0;i<info.getFarmer().getFarmEntry().size();i++){
		//				if(info.getFarmer().getFarmEntry().get(i).getFarm().getId()==info.getId())
		//					flase=true;
		//			}
		//		}
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmInfo info = (FarmInfo) model;
		Repeatability(info, ctx);
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
			throw new EASBizException(new NumericExceptionSubItem("001","未核准资料才能执行此操作！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, new ObjectUuidPK(info.getId()), info);
		//		try {
		//			if(info.getFarmer()!=null&&info.getId()!=null){
		//				IRowSet rs = DbUtil.executeQuery(ctx, "select * from CT_FM_Farmer t1 inner join CT_FM_FarmerFarmEntry t2 on t1.FID=t2.FParentID where FFarmID=? and t1.FID=?",new String[]{info.getString("id"),info.getFarmer().getString("id")});
		//				if(rs.size()==0){
		//
		//					SelectorItemCollection slor=new SelectorItemCollection();
		//					FarmerInfo farmerInfo = FarmerFactory.getLocalInstance(ctx).getFarmerInfo(new ObjectUuidPK(info.getFarmer().getString("id")),slor);
		//					BOSUuid entryID = BOSUuid.create("3E0B37D7");
		//					String str = "insert into CT_FM_FarmerFarmEntry (FID,FSeq,FFarmID,FParentID) values('";
		//					str+=entryID+"',"+(farmerInfo.getFarmEntry().size()+1)+",'"+info.getId().toString()+"','"+farmerInfo.getId().toString()+"')";
		//					DbUtil.execute(ctx, str);
		//				}
		//			}
		//		} catch (EASBizException e) {
		//			e.printStackTrace();
		//		}
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmInfo info = (FarmInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}
		if (info.isIsAllot()) {
			throw new EASBizException(new NumericExceptionSubItem("001","已分配的养殖场不能反核准"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		try {
			this._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 重复性校验
	 * @param ctx
	 * @param info
	 * @throws EASBizException 
	 */
	private void Repeatability(FarmInfo info,Context ctx) throws EASBizException {
		// TODO Auto-generated method stub
		String sql = "select fname_l2 from CT_FM_Farm where fid != '"+info.getId().toString()+"' and fname_l2 = '"+info.getName()+"'";
		try {
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
			if(rs.size()>0){
				throw new EASBizException(new NumericExceptionSubItem("001","该养殖场已录入！"));
			}	
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmInfo info = FarmFactory.getLocalInstance(ctx).getFarmInfo(pk);
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已经核准或禁用！"));
		}
		if (info.isIsAllot()) {
			throw new EASBizException(new NumericExceptionSubItem("001","已分配的养殖场不能删除"));
		}
		checkIsUsed(ctx, info);
		super._delete(ctx, pk);
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmInfo info=(FarmInfo) model;;
		//		setZhuJiMa(info);
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		IObjectPK pk = super._save(ctx, model);
		return pk;
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmInfo info=(FarmInfo) model;;
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		//		setZhuJiMa(info);
		return super._submit(ctx, model);
	}

	private void checkIsUsed(Context ctx,FarmInfo info) throws EASBizException {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM CT_FM_FarmerFarmEntry where FFarmID='"+info.getId().toString()+"'";
		try {
			if(DbUtil.executeQuery(ctx, sql).size()>0){
				throw new EASBizException(new NumericExceptionSubItem("001","已被养殖户引用,请先删除对应养殖户下该养殖场分录行"));
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}