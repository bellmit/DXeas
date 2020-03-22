package com.kingdee.eas.farm.stocking.basedata.app;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeFactory;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeGroupInfo;
import com.kingdee.eas.basedata.master.auxacct.GeneralAsstActTypeInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.stocking.basedata.BaseSysSettingInfo;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.farm.stocking.basedata.FarmersFactory;
import com.kingdee.eas.farm.stocking.basedata.FarmersInfo;
import com.kingdee.eas.farm.stocking.common.StockingComm;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.wlhlcomm.AppCommon;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class FarmersControllerBean extends AbstractFarmersControllerBean {
	private static Logger logger = Logger.getLogger("com.kingdee.eas.farm.stocking.basedata.app.FarmersControllerBean");

	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		FarmersInfo info = (FarmersInfo) model;
		if(StringUtils.isNotEmpty(info.getString("mobileTel"))){
			info.setMobileTel(StringUtils.upperCase(info.getString("mobileTel").trim()));
		}
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未启用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		FarmersInfo info = (FarmersInfo) model;
		if(StringUtils.isNotEmpty(info.getString("mobileTel"))){
			info.setMobileTel(StringUtils.upperCase(info.getString("mobileTel").trim()));
		}
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已经启用！"));
		}

		info.setBaseStatus(FarmBaseStatusEnum.enable);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmersInfo info = (FarmersInfo) model;
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已经核准或启用！"));
		}
		if(StringUtils.isNotEmpty(info.getString("mobileTel"))){
			info.setMobileTel(StringUtils.upperCase(info.getString("mobileTel").trim()));
		}
		Repeatability(info,ctx);
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		info.setGeneralAsstActType(createAsstAct(ctx, info));
		try {
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			info.setAuditTime(new java.util.Date());
			this._update(ctx, new ObjectUuidPK(info.getId()), info);
			String sql = "update T_FM_Farm set CFIsAllot = '1' where fid = '"+info.getFarmEntry().get(0).getFarm().getId().toString()+"'";
			DbUtil.execute(ctx,sql);
		} catch (EASBizException e) {
			throw new EASBizException(new NumericExceptionSubItem("",e.getMessage()));
		}
	}
	/**
	 * 重复性校验
	 * @param ctx
	 * @param info
	 * @throws EASBizException 
	 */
	private void Repeatability(FarmersInfo info,Context ctx) throws EASBizException {
		// TODO Auto-generated method stub
		String sql = "select fname_l2 from T_FM_Farmers where fid != '"+info.getId().toString()+"' and fname_l2 = '"+info.getName()+"'";
		try {
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
			if(rs.size()>0){
				throw new EASBizException(new NumericExceptionSubItem("001","该养殖户已录入！"));
			}	
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	/**
	 * 创建自定义核算项目
	 * @param ctx
	 * @param info
	 */
	private GeneralAsstActTypeInfo createAsstAct(Context ctx,FarmersInfo info) throws BOSException, EASBizException  {
		if(info.getGeneralAsstActType()!=null) {
			return info.getGeneralAsstActType();
		}
		SelectorItemCollection selector=new SelectorItemCollection();
		selector.add("*");
		selector.add("FarmEntry.*");
		selector.add("FarmEntry.farm.*");
		info=getFarmersInfo(ctx, new ObjectUuidPK(info.getId()), selector);
		ArrayList<String> stoOrgList=new ArrayList<String>();
		String orgId;
		for(int index=0;index<info.getFarmEntry().size();index++) {
			if(info.getFarmEntry().get(index).getFarm()!=null&&info.getFarmEntry().get(index).getFarm().getStorageOrgUnit()!=null) {
				orgId=info.getFarmEntry().get(index).getFarm().getStorageOrgUnit().getString("id");
				if(!stoOrgList.contains(orgId)) {
					stoOrgList.add(orgId);
				}
			}
		}
		BaseSysSettingInfo sysSetting ;
		ArrayList<String> settingList=new ArrayList<String>();
		for(String orgId0:stoOrgList) {
			sysSetting= StockingComm.getSysSettingByOrgId(ctx, orgId0);
			if(sysSetting!=null&&sysSetting.isIsCreateFarmerAsst()) {
				if(settingList.contains(sysSetting.getString("id"))) {
					continue;
				}
				settingList.add(sysSetting.getString("id"));
				
				GeneralAsstActTypeGroupInfo asstactGroupInfo = sysSetting.getFarmerAsstActGroup();
				GeneralAsstActTypeInfo actInfo=new GeneralAsstActTypeInfo();
				//actInfo.setId(BOSUuid.create(actInfo.getBOSType()));
				//actInfo.setNumber(info.getNumber());
				//AppCommon ac = AppCommon.getInstance(ctx);
		    	//String number = ac.getAutoCode(ctx,actInfo,"at4AAAAAAHDM567U");
		    	//actInfo.setNumber(number);
				actInfo.setNumber(info.getNumber());
				System.out.println(info.getName());
				actInfo.setName(info.getName());
				actInfo.setCU(info.getCU());
				actInfo.setCreatorCompany(info.getCompany());
				CtrlUnitInfo ctinfo = CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(new ObjectUuidPK("00000000-0000-0000-0000-000000000000CCE7AED4"));
				//actInfo.setCU(ctinfo);
				
				//actInfo.setCreatorCompany(CompanyOrgUnitFactory.getLocalInstance(ctx).getCompanyOrgUnitInfo(new ObjectUuidPK("00000000-0000-0000-0000-000000000000CCE7AED4")));
				
				actInfo.setGroup(asstactGroupInfo);
				
				GeneralAsstActTypeFactory.getLocalInstance(ctx).addnew(actInfo);
				return actInfo;
//				break;
			}
		}
		return null;
	}
	

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmersInfo info = (FarmersInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准或已经启用！"));
		}
		if(StringUtils.isNotEmpty(info.getString("mobileTel"))){
			info.setMobileTel(StringUtils.upperCase(info.getString("mobileTel").trim()));
		}
		info.setBaseStatus(FarmBaseStatusEnum.unApprove);
		//删除自定义核算项目
		//deleteAsstAct(ctx,info);
		//info.setGeneralAsstActType(null);
		try {
			info.setAuditor(null);
			info.setAuditTime(null);
			this._update(ctx, new ObjectUuidPK(info.getId()), info);
			if(info.getFarmEntry().get(0).getFarm().equals(null)){
				
			}else{
				String sql = "update T_FM_Farm set CFIsAllot = '0' where fid = '"+info.getFarmEntry().get(0).getFarm().getId().toString()+"'";
				DbUtil.execute(ctx,sql);
			}
		} catch (EASBizException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 删除自定义核算项目
	 * @param ctx
	 * @param info
	 */
	private GeneralAsstActTypeInfo deleteAsstAct(Context ctx,FarmersInfo info) throws BOSException, EASBizException  {
		if(info.getGeneralAsstActType()!=null) {
			GeneralAsstActTypeInfo actInfo=info.getGeneralAsstActType();
			GeneralAsstActTypeFactory.getLocalInstance(ctx).delete(actInfo.getId().toString());
			return null;
		}
		return null;
		
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
//		FarmersInfo info = FarmersFactory.getLocalInstance(ctx).getFarmersInfo(pk);
//		if (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.enable)) {
//			throw new EASBizException(new NumericExceptionSubItem("001","资料已经核准或启用！"));
//		}
//		String sql = "select * from T_BD_GeneralAsstActType where fid ='"+info.getGeneralAsstActType().getId().toString()+"'";
//		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
//		if(rs.size()>0){
//			throw new EASBizException(new NumericExceptionSubItem("001","已绑定自定义核算项目！"));
//		}
		super._delete(ctx, pk);
	}

	@Override
	protected IObjectPK _addnew(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmersInfo	farmersInfo= (FarmersInfo)model;
		if(StringUtils.isNotEmpty(farmersInfo.getString("mobileTel"))){
			farmersInfo.setMobileTel(StringUtils.upperCase(farmersInfo.getString("mobileTel").trim()));
		}
		return super._addnew(ctx, model);
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmersInfo	farmersInfo= (FarmersInfo)model;
		if(StringUtils.isNotEmpty(farmersInfo.getString("mobileTel"))){
			farmersInfo.setMobileTel(StringUtils.upperCase(farmersInfo.getString("mobileTel").trim()));
		}
		if(farmersInfo.getFarmEntry().size()<1){
			throw new EASBizException(new NumericExceptionSubItem("001","养殖场分录不能为空！"));
		}
		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmersInfo	farmersInfo= (FarmersInfo)model;
		if(StringUtils.isNotEmpty(farmersInfo.getString("mobileTel"))){
			farmersInfo.setMobileTel(StringUtils.upperCase(farmersInfo.getString("mobileTel").trim()));
		}
		return super._submit(ctx, model);
	}

}