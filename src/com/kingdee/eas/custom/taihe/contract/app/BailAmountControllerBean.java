package com.kingdee.eas.custom.taihe.contract.app;

import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.metadata.MetaDataLoaderFactory;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.entity.EntityObjectInfo;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.util.BOSUuid;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.ServerUtils;

public class BailAmountControllerBean extends AbstractBailAmountControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.taihe.contract.app.BailAmountControllerBean");

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		audit(ctx, model, null);
		super._save(ctx, model);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
	EASBizException {
		// TODO Auto-generated method stub
		
		delete(ctx, pk, null);
		super._delete(ctx, pk);
	}


	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		submit(ctx, model, null);
		return super._submit(ctx, model);
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		save(ctx, model, null);
		return super._save(ctx, model);
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		unAudit(ctx, model, null);
		super._save(ctx, model);
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
		
		model.setInt("billStatus", 1);
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
		model.setInt("billStatus", 2);
		
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
}