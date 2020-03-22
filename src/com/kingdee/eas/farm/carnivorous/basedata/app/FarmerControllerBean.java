package com.kingdee.eas.farm.carnivorous.basedata.app;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import com.kingdee.eas.basedata.org.CtrlUnitFactory;
import com.kingdee.eas.basedata.org.CtrlUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.carnivorous.basedata.FarmInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerCollection;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFarmEntryFactory;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerFarmEntryInfo;
import com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo;
import com.kingdee.eas.farm.carnivorous.basedata.SystemSettingInfo;
import com.kingdee.eas.farm.carnivorous.comm.StockingComm;
import com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class FarmerControllerBean extends AbstractFarmerControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.carnivorous.basedata.app.FarmerControllerBean");

	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		FarmerInfo info = (FarmerInfo) model;
		if(StringUtils.isNotEmpty(info.getString("mobileTel"))){
			info.setMobileTel(StringUtils.upperCase(info.getString("mobileTel").trim()));
		}
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.frozen);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		FarmerInfo info = (FarmerInfo) model;
		if(StringUtils.isNotEmpty(info.getString("mobileTel"))){
			info.setMobileTel(StringUtils.upperCase(info.getString("mobileTel").trim()));
		}
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未禁用！"));
		}
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmerInfo info = (FarmerInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.unApprove)) {
			throw new EASBizException(new NumericExceptionSubItem("001","未核准资料才能执行此操作！"));
		}
		if(StringUtils.isNotEmpty(info.getString("mobileTel"))){
			info.setMobileTel(StringUtils.upperCase(info.getString("mobileTel").trim()));
		}
		Repeatability(info,ctx);
		info.setBaseStatus(FarmBaseStatusEnum.approve);
		if(info.getGeneralAsstActType()==null||info.getGeneralAsstActType().toString()==null) {
			info.setGeneralAsstActType(createAsstAct(ctx, info));
		}
		try {
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			info.setAuditTime(new java.util.Date());
			this._update(ctx, new ObjectUuidPK(info.getId()), info);
			for(int i=0;i<info.getFarmEntry().size();i++){
				String sql = "update CT_FM_Farm set CFIsAllot = '1' where fid = '"+info.getFarmEntry().get(i).getFarm().getId().toString()+"'";
				DbUtil.execute(ctx,sql);	
			}
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
	private void Repeatability(FarmerInfo info,Context ctx) throws EASBizException {
		// TODO Auto-generated method stub
		String sql = "select fname_l2 from CT_FM_Farmer where fid != '"+info.getId().toString()+"' and fname_l2 = '"+info.getName()+"'";
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
	private GeneralAsstActTypeInfo createAsstAct(Context ctx,FarmerInfo info) throws BOSException, EASBizException  {
		if(info.getGeneralAsstActType()!=null&&info.getGeneralAsstActType().toString()!=null) {
			return info.getGeneralAsstActType();
		}
		
		String sql="select fid fid from T_BD_GeneralAsstActType  where fnumber='"+info.getNumber()+"'";
		IRowSet rs =  DbUtil.executeQuery(ctx, sql);
		try {
			if(rs.next()){
				GeneralAsstActTypeInfo actInfo=GeneralAsstActTypeFactory.getLocalInstance(ctx).getGeneralAsstActTypeInfo(new ObjectUuidPK(rs.getString("fid")));
				return actInfo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		SelectorItemCollection selector=new SelectorItemCollection();
		selector.add("*");
		selector.add("FarmEntry.*");
		selector.add("FarmEntry.farm.*");
		info=getFarmerInfo(ctx, new ObjectUuidPK(info.getId()), selector);
//		ArrayList<String> stoOrgList=new ArrayList<String>();
		String orgId;
//		for(int index=0;index<info.getFarmEntry().size();index++) {
//			if(info.getFarmEntry().get(index).getFarm()!=null&&info.getFarmEntry().get(index).getFarm().getStorageOrgUnit()!=null) {
//				orgId=info.getFarmEntry().get(index).getFarm().getStorageOrgUnit().getString("id");
//				if(!stoOrgList.contains(orgId)) {
//					stoOrgList.add(orgId);
//				}
//			}
//		}
		orgId=info.getCompany().getId().toString();
		SystemSettingInfo sysSetting ;
//		ArrayList<String> settingList=new ArrayList<String>();
	
//		for(String orgId0:stoOrgList) {
			sysSetting= StockingComm.getSystemSettingInfo(ctx, orgId);
			if(sysSetting!=null&&sysSetting.isIsCreateFarmerAsst()) {

//				settingList.add(sysSetting.getString("id"));
				SimpleDateFormat sdfTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String actInfoID=null;
				actInfoID=BOSUuid.create("F90B0133").toString();
				StringBuffer insertSql=new StringBuffer("/*dialect*/INSERT INTO T_BD_GeneralAsstActType (FCreatorCompanyID,FGroupID,FIsEnabled,FisCantAddLower,FIsLeaf,FLevel,FLongNumber,FDisplayName_l2,FName_l2,FNumber,FCreatorID,FCreateTime,FControlUnitID,FID) ");
				insertSql.append("VALUES ('").append(info.getCompany().getId().toString()).append("'")
				.append(",'").append(sysSetting.getFarmerAsstActGro().getId().toString()).append("'")
				.append(",1,0,1,1,'").append(info.getNumber()).append("'")
				.append(",'").append(info.getName()).append("'")
				.append(",'").append(info.getName()).append("'")
				.append(",'").append(info.getNumber()).append("'")
				.append(",'").append(ContextUtil.getCurrentUserInfo(ctx).getId().toString()).append("'")
				.append(",").append("to_date('"+sdfTime.format(new Date())+"','yyyy-MM-dd HH24:mi:ss')")
				.append(",'").append(info.getCU().getId().toString()).append("'")
				.append(",'").append(actInfoID).append("'")
				.append(")");
				DbUtil.execute(ctx, insertSql.toString());
		
				GeneralAsstActTypeInfo actInfo=GeneralAsstActTypeFactory.getLocalInstance(ctx).getGeneralAsstActTypeInfo(new ObjectUuidPK(actInfoID));
				
				
				
//				GeneralAsstActTypeGroupInfo asstactGroupInfo = sysSetting.getFarmerAsstActGro();
//				GeneralAsstActTypeInfo actInfo=new GeneralAsstActTypeInfo();
				
//				System.out.println(info.getName());
//				actInfo.setName(info.getName());
//				actInfo.setCU(info.getCU());
//				actInfo.setCreatorCompany(info.getCompany());
//				CtrlUnitInfo ctinfo = CtrlUnitFactory.getLocalInstance(ctx).getCtrlUnitInfo(new ObjectUuidPK("00000000-0000-0000-0000-000000000000CCE7AED4"));
//				actInfo.setGroup(asstactGroupInfo);
		
//				GeneralAsstActTypeFactory.getLocalInstance(ctx).save(actInfo);
				return actInfo;
//				break;
			}
//		}
		return null;
	}
	

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmerInfo info = (FarmerInfo) model;
		if (!info.getBaseStatus().equals(FarmBaseStatusEnum.approve)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
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
			if(info.getFarmEntry().size()>0){
				for(int i=0;i<info.getFarmEntry().size();i++){
					FarmerFarmEntryInfo entry = FarmerFarmEntryFactory.getLocalInstance(ctx).getFarmerFarmEntryInfo(new ObjectUuidPK(info.getFarmEntry().get(i).getId()));
					String sql = "update CT_FM_Farm set CFIsAllot = '0' where fid = '"+entry.getFarm().getId().toString()+"'";
					DbUtil.execute(ctx,sql);	
				}
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
	private GeneralAsstActTypeInfo deleteAsstAct(Context ctx,FarmerInfo info) throws BOSException, EASBizException  {
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
		FarmerInfo info = FarmerFactory.getLocalInstance(ctx).getFarmerInfo(pk);
		if (info.getBaseStatus().equals(FarmBaseStatusEnum.approve) || info.getBaseStatus().equals(FarmBaseStatusEnum.frozen)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已经核准或禁用！"));
		}
		if(info.getGeneralAsstActType()!=null){
			String sql = "select * from T_BD_GeneralAsstActType where fid ='"+info.getGeneralAsstActType().getId().toString()+"'";
			IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sql.toString()).executeSQL();
			if(rs.size()>0){
				throw new EASBizException(new NumericExceptionSubItem("001","已绑定自定义核算项目！"));
			}
		}
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" select fid from T_FM_BatchContractBill where FFarmerID='"+info.getId().toString()+"' ")
		.append(" union all ")
		.append(" select fid from CT_FM_ConFeedContract where FFarmerID='"+info.getId().toString()+"' ")
		.append(" union all ")
		.append(" select fid from CT_FM_MarginInitBillEntry where CFFarmerID='"+info.getId().toString()+"' ")
		.append(" union all ")
		.append(" select fid from CT_FM_MarginUnlockBill where CFFarmerID='"+info.getId().toString()+"' ")
		.append(" union all ")
		.append(" select fid from CT_FM_MaiginBill where CFFarmerID='"+info.getId().toString()+"' ");
		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sqlBuf.toString()).executeSQL();
		if(rs.size()>0){
			throw new EASBizException(new NumericExceptionSubItem("001","该养殖户已被其他单据引用,不能删除！"));
		}
		super._delete(ctx, pk);
	}

	@Override
	protected IObjectPK _addnew(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmerInfo	FarmerInfo= (FarmerInfo)model;
		if(StringUtils.isNotEmpty(FarmerInfo.getString("mobileTel"))){
			FarmerInfo.setMobileTel(StringUtils.upperCase(FarmerInfo.getString("mobileTel").trim()));
		}
		return super._addnew(ctx, model);
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmerInfo	FarmerInfo= (FarmerInfo)model;
		if(StringUtils.isNotEmpty(FarmerInfo.getString("mobileTel"))){
			FarmerInfo.setMobileTel(StringUtils.upperCase(FarmerInfo.getString("mobileTel").trim()));
		}
		if(FarmerInfo.getFarmEntry().size()<1){
			throw new EASBizException(new NumericExceptionSubItem("001","养殖场分录不能为空！"));
		}
		FarmerInfo.setBaseStatus(FarmBaseStatusEnum.unApprove);
		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FarmerInfo	FarmerInfo= (FarmerInfo)model;
		if(StringUtils.isNotEmpty(FarmerInfo.getString("mobileTel"))){
			FarmerInfo.setMobileTel(StringUtils.upperCase(FarmerInfo.getString("mobileTel").trim()));
		}
		FarmerInfo.setBaseStatus(FarmBaseStatusEnum.unApprove);
		return super._submit(ctx, model);
	}

}