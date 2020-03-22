package com.kingdee.eas.custom.signwasthetable.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
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

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.custom.signwasthetable.ContractCollection;
import com.kingdee.eas.custom.signwasthetable.ContractInfo;
import com.kingdee.eas.custom.signwasthetable.billStatus;

import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.custom.signwasthetable.ContractInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;


/**不足之处：理论上不需要提供校验，在前台界面校验必须完善*/


public class ContractControllerBean extends AbstractContractControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.signwasthetable.app.ContractControllerBean");


	/**
	 * 审核
	 * @throws EASBizException 
	 */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		//获取当前单据对象info
		ContractInfo info=(ContractInfo) model;
		//仅适合提交状态下的单据进行审核
		if(info.getContractStatus().equals(billStatus.submit)){
			info.setContractStatus(billStatus.Audit);
			//审核之后将当前用户和时间带出
			Object currentUser = ctx.get(SysContextConstant.USERINFO);
			info.setAuditor((com.kingdee.eas.base.permission.UserInfo) currentUser);
			info.setAuditTime(new java.util.Date());
			//保存
				super._update(ctx,new ObjectUuidPK(info.getId()),info);
		}

	}
	/**
	 * 保存操作
	 */
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ContractInfo info=(ContractInfo) model;
		if(info.getContractStatus().equals(billStatus.save)||info.getContractStatus().equals(billStatus.submit))
			info.setContractStatus(billStatus.save);

		return super._save(ctx, model);
	}
	/**
	 * 提交操作
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ContractInfo info=(ContractInfo) model;
		if(info.getContractStatus().equals(billStatus.save)||info.getContractStatus().equals(billStatus.submit))
			info.setContractStatus(billStatus.submit);

		return super._submit(ctx, model);
	}
    /**
     * 提交
     * @throws EASBizException 
     */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ContractInfo info=(ContractInfo) model;
		if(info.getContractStatus().equals(billStatus.Audit)){
			info.setContractStatus(billStatus.save);
			info.setAuditTime(null);
			info.setAuditor(null);
				super._update(ctx, new ObjectUuidPK(info.getId()), info);
		}

	}
	/**必须覆盖超类方法的部分功能
	 * 合同变更
	 */

	@Override
	protected void _cmChange(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub

	}
	/**必须覆盖超类方法的部分功能
	 * 生成付款申请单
	 */
	@Override
	protected void _toPayReq(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub

	}
	/**必须覆盖超类方法的部分功能
	 * 变更查看与上一个版本的区别
	 */
	@Override
	protected void _upVersion(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub

	}
	/**必须覆盖超类方法的部分功能
	 * 变更历史版本查看
	 */
	@Override
	protected void _viewHistory(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub

	}
	/**必须覆盖超类方法的部分功能
	 * 初始化单据：指的是  补以前的合同
	 */
	@Override
	protected void _initial(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub

	}
	/**必须覆盖超类方法的部分功能
	 * 刷新操作
	 */
	@Override
	protected void _refresh(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub

	}
	/**必须覆盖超类方法的部分功能
	 * 设置保证金天数和验收日期
	 */
	@Override
	protected void _setBailDays(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub

	}
	/**必须覆盖超类方法的部分功能
	 * 超额付款
	 */
	@Override
	protected void _overPay(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub

	}
	/**必须覆盖超类方法的部分功能
	 * 超额付款查看
	 */
	@Override
	protected void _overView(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub

	}

}