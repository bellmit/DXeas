package com.kingdee.eas.custom.commld;

import java.io.PrintStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.IMetaDataLoader;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.log.AppLogFactory;
import com.kingdee.eas.base.log.AppLogInfo;
import com.kingdee.eas.base.log.HisLog;
import com.kingdee.eas.base.log.HisLogFactory;
import com.kingdee.eas.base.log.HisLogInfo;
import com.kingdee.eas.base.log.ItemFactory;
import com.kingdee.eas.base.log.ItemInfo;
import com.kingdee.eas.base.log.LogInfo;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.eas.scm.cal.dbclean.app.SetInvStartPeriodTask;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.util.Uuid;

public class ServerUtils {
	public static final NumericExceptionSubItem CHECKSAVE = new NumericExceptionSubItem("775", "只能保存新增或保存状态的单据");
	public static final NumericExceptionSubItem CHECKSUBMIT = new NumericExceptionSubItem("776", "只能提交新增、保存或提交状态的单据");
	public static final NumericExceptionSubItem CHECKAUDIT = new NumericExceptionSubItem("777", "只能审核提交状态的单据");
	public static final NumericExceptionSubItem CHECKUNAUDIT = new NumericExceptionSubItem("778", "只能反审核已审核状态的单据");
	public static final NumericExceptionSubItem CHECKDELETE = new NumericExceptionSubItem("779", "单据状态禁止此操作");
	public static final NumericExceptionSubItem CHECKDOWNBILL = new NumericExceptionSubItem("878", "存在下游单据禁止此操作");
	/**
	 * 参数个数不匹配
	 * @param ctx
	 * @param tabelName
	 * @param fieldsName
	 * @param values
	 * @return
	 */
	public static boolean checkIsExisInDataBase(Context ctx,String tabelName,String[] fieldsName,Object[] values){
		if(fieldsName.length!=values.length){
			System.out.println("参数个数不匹配");
			return false;
		}
		String str="select * from "+tabelName+" where ";
		for(int i=0;i<fieldsName.length;i++)
			if(i==0)
				str=str+fieldsName[i]+"="+(values[i] instanceof Integer ?"":"'")+values[i]+(values[i] instanceof Integer ?"":"'");
			else 
				str=str+" and "+fieldsName[i]+"="+(values[i] instanceof Integer ?"":"'")+values[i]+(values[i] instanceof Integer ?"":"'");
		try {
			IRowSet rs;
			if(ctx!=null)
				rs=DbUtil.executeQuery(ctx, str);
			else
				rs=SQLExecutorFactory.getRemoteInstance(str).executeSQL();
			if(rs.size()>0)
				return true;
			else
				return false;
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 更新数据库字段的值
	 * @param ctx
	 * @param tableName
	 * @param phaseName
	 * @param valueName
	 * @return
	 */
	public static boolean updateInfo(Context ctx,String tableName,String[] phaseName,Object[] valueName,String whereSql){
		StringBuffer sb=new StringBuffer();
		String sp="\r\n";
		sb.append("update ").append(tableName).append(" set").append(sp);
		for(int i=0;i<phaseName.length;i++){
			sb.append(phaseName[i]).append("=");
			if(valueName[i]==null)
				sb.append("''");
			else if(valueName[i] instanceof Integer)
				sb.append(valueName[i]);
			else
				sb.append("'").append(valueName[i]).append("'");

			if(i<phaseName.length-1)
				sb.append(",");

		}
		sb.append(whereSql);

		try {
			DbUtil.execute(ctx, sb.toString());
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 更新数据库字段的值
	 * @param ctx
	 * @param tableName
	 * @param phaseName
	 * @param valueName
	 * @return
	 */
	public static boolean insertInfo(Context ctx,String tableName,String[] phaseName,Object[] valueName,HashMap<String,String> valueType){
		StringBuffer sb=new StringBuffer();
		StringBuffer sbPhase=new StringBuffer();
		StringBuffer sbValue=new StringBuffer();
		String sp="\r\n";
		sb.append("insert into ").append(tableName).append(sp);
		for(int i=0;i<phaseName.length;i++){
			sbPhase.append(phaseName[i]);
			if(valueType.get(phaseName[i])!=null&&!"string".equalsIgnoreCase(valueType.get(phaseName[i]))){
				if("Date".equalsIgnoreCase(valueType.get(phaseName[i])))
					sbValue.append("{ts '").append(valueName[i]).append("'}");
				if("int".equalsIgnoreCase(valueType.get(phaseName[i]))||"integer".equalsIgnoreCase(valueType.get(phaseName[i])))
					sbValue.append("").append(valueName[i]).append("");
			}else
				sbValue.append("'").append(valueName[i]).append("'");
			if(i<phaseName.length-1){
				sbPhase.append(",");
				sbValue.append(",");
			}
		}
		sb=sb.append("(").append(sbPhase).append(") values(").append(sbValue).append(")");

		try {
			DbUtil.execute(ctx, sb.toString());
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 当单据发生变化时，保留一条日志
	 * @return
	 */
	public static boolean saveHistoryWhenBillInfoChange(Context ctx,UserInfo userInfo,IObjectValue baseInfo,String methordName){
		String id=BOSUuid.create("AE602115").toString();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");


		BOSUuid uuid = BOSUuid.read(baseInfo.get("id").toString());
		BOSObjectType bosobjecttype = uuid.getType();
		IMetaDataLoader metadataloader = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx);
		EntityObjectInfo entity = metadataloader.getEntity(bosobjecttype);

		String hMethodAlias = methordName.equalsIgnoreCase("addnew")?"新增":
			(methordName.equalsIgnoreCase("edit")?"修改":
				(methordName.equalsIgnoreCase("remove")?"删除":
					(methordName.equalsIgnoreCase("audit")?"审核":
						(methordName.equalsIgnoreCase("unaudit")?"反审核":
							(methordName.equalsIgnoreCase("revoke")?"废弃":
								methordName)))));
		String[] phaseName={"FID","FUserID","FUserNumber","FUserName","FUserType_l2","FOccurTime","FClientIP","FClientName","FEntityId","FCUID","FCompanyName_l2","FEntityName","FEntityAlias_l2","FMethodName","FMethodAlias_l2","FInstanceId","FInstanceNo"};
		String[] valueName={id,userInfo.getId().toString(),userInfo.getNumber(),userInfo.getName(),userInfo.getType().toString(),sdf.format(new Date()),ctx.getClientHostIP(),ctx.getClientHostIP(),
				baseInfo.getBOSType().toString(),ContextUtil.getCurrentCtrlUnit(ctx).getId().toString(),((CompanyOrgUnitInfo)ctx.get("CompanyInfo")).getName(),entity.getFullName(),entity.getAlias(),methordName,hMethodAlias,baseInfo.getString("id"),StringUtils.isEmpty(baseInfo.getString("number"))?(StringUtils.isEmpty(baseInfo.getString("Number"))?null:baseInfo.getString("Number")):baseInfo.getString("number")};
		HashMap<String,String> valueType=new HashMap<String, String>();
		valueType.put("FOccurTime", "Date");
		insertInfo(ctx, "T_LOG_His", phaseName, valueName,valueType);
		return true;
	}

	/**
	 * 审核操作
	 * @param ctx
	 * @param model
	 * @return
	 * @throws EASBizException 
	 */
	public static IObjectValue audit(Context ctx, IObjectValue model,String[] destBillType) throws EASBizException {
		// TODO Auto-generated method stub

		//单据状态校验
		if(model.getInt("billStatus")!=2)
			throw new EASBizException(ServerUtils.CHECKAUDIT);

		//下游单据校验
		checkDownBill(ctx,model,destBillType);

		//设置值
		UserInfo user = (UserInfo)ctx.get(SysContextConstant.USERINFO);
		model.setBOSUuid("auditor", user.getId());
		model.setDate("auditTime", new Date());
		model.setInt("billStatus", 4);
		return model;
	}

	/**
	 * 教研下游单据是否存在
	 * @param ctx
	 * @param model
	 * @param destBillType
	 * @throws EASBizException
	 */
	private static void checkDownBill(Context ctx, IObjectValue model,
			String[] destBillType) throws EASBizException {
		// TODO Auto-generated method stub
		if(destBillType==null||destBillType.length==0)
			return;
		for(String i:destBillType){
			try {
				if(BOTRelationFactory.getLocalInstance(ctx).getDestObjIdByDestType(model.getString("id"), i).size()>0)
					throw new EASBizException(ServerUtils.CHECKDOWNBILL);
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 反审核操作
	 * @param ctx
	 * @param model
	 * @return
	 * @throws EASBizException 
	 */
	public static IObjectValue unAudit(Context ctx, IObjectValue model,String[] destBillType) throws EASBizException {
		// TODO Auto-generated method stub

		//单据状态校验
		if(model.getInt("billStatus")!=4)
			throw new EASBizException(ServerUtils.CHECKUNAUDIT);

		//下游单据校验
		checkDownBill(ctx,model,destBillType);

		//设置值
		model.setBOSUuid("auditor", null);
		model.setDate("auditTime", null);
		model.setInt("billStatus", 1);
		return model;
	}
	/**
	 * 删除
	 * @param ctx
	 * @param model
	 * @param object
	 * @return
	 * @throws EASBizException 
	 */
	public static void delete(Context ctx, Object obj,
			String[] destBillType) throws EASBizException {
		IObjectValue model = null;
		// TODO Auto-generated method stub
		if(obj instanceof IObjectValue)
			model=(IObjectValue) obj;
		else if(obj instanceof IObjectPK){
			BOSUuid uuid = BOSUuid.read(obj.toString());
			BOSObjectType type = uuid.getType();
			EntityObjectInfo info = MetaDataLoaderFactory.getLocalMetaDataLoader(ctx).getEntity(type);
			model=info;
		}
		//单据状态校验
		if(model.getInt("billStatus")==4)
			throw new EASBizException(ServerUtils.CHECKDELETE);

		//下游单据校验
		checkDownBill(ctx,model,destBillType);

	}
	/**
	 * 保存
	 * @param ctx
	 * @param model
	 * @param destBillType
	 * @throws EASBizException
	 */
	public static IObjectValue save(Context ctx, IObjectValue model, String[] destBillType) throws EASBizException {
		// TODO Auto-generated method stub
		//单据状态校验
		if(model.getInt("billStatus")!=0&&model.getInt("billStatus")!=1&&model.getInt("billStatus")!=-1)
			throw new EASBizException(ServerUtils.CHECKSAVE);

		//下游单据校验
		checkDownBill(ctx,model,destBillType);
		
		model.setInt("billStatus", 2);
		model.setDate("bizDate", DateUtilsComm.clearDateHMS(model.getDate("bizDate")));
		
		return model;
	}
	
	
	/**
	 * 提交
	 * @param ctx
	 * @param model
	 * @param destBillType
	 * @throws EASBizException
	 */
	public static IObjectValue submit(Context ctx, IObjectValue model, String[] destBillType) throws EASBizException {
		// TODO Auto-generated method stub
		//单据状态校验
		if(model.getInt("billStatus")!=0&&model.getInt("billStatus")!=1&&model.getInt("billStatus")!=2)
			throw new EASBizException(ServerUtils.CHECKSUBMIT);

		//下游单据校验
		checkDownBill(ctx,model,destBillType);
		
		model.setDate("bizDate", DateUtilsComm.clearDateHMS(model.getDate("bizDate")));
		model.setInt("billStatus", 3);
		
		return model;
	}
}
