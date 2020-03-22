package com.kingdee.eas.custom.wlhllicensemanager.app;

import java.util.Date;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.util.NumericExceptionSubItem;

public abstract class WlhlDataBaseControllerBean extends AbstractWlhlDataBaseControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.wlhllicensemanager.app.WlhlDataBaseControllerBean");
    /**
     * ��׼
     */
	@Override
	protected void _approve(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		WlhlDataBaseInfo info=(WlhlDataBaseInfo) model;
		if(info.getBaseStatus().equals(UsedStatusEnum.APPROVED)||info.getBaseStatus().equals(UsedStatusEnum.ENABLED)) {
			throw new EASBizException(new NumericExceptionSubItem("","�����Ѿ���׼�����ã�"));
		}
		info.setBaseStatus(UsedStatusEnum.APPROVED);
		info.setApprover(ContextUtil.getCurrentUserInfo(ctx));
		info.setApproveTime(new Date());
		SelectorItemCollection selector=new SelectorItemCollection();
		selector.add("baseStatus");
		selector.add("approver");
		selector.add("approveTime");
		super._updatePartial(ctx, info, selector);
	}
	/**
	 * ����׼
	 */
	@Override
	protected void _unApprove(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		WlhlDataBaseInfo info=(WlhlDataBaseInfo) model;
		if(info.getBaseStatus().equals(UsedStatusEnum.ENABLED)) {
			throw new EASBizException(new NumericExceptionSubItem("","�����Ѿ����ã�"));
		}
		if(!info.getBaseStatus().equals(UsedStatusEnum.APPROVED)) {
			throw new EASBizException(new NumericExceptionSubItem("","������δ��׼��"));
		}
		info.setBaseStatus(UsedStatusEnum.UNAPPROVE);
		info.setApprover(null);
		info.setApproveTime(null);
		SelectorItemCollection selector=new SelectorItemCollection();
		selector.add("baseStatus");
		selector.add("approver");
		selector.add("approveTime");
		super._updatePartial(ctx, info, selector);
	}
	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		WlhlDataBaseInfo info=(WlhlDataBaseInfo) getValue(ctx, pk);
		if(info.getBaseStatus().equals(UsedStatusEnum.APPROVED)||info.getBaseStatus().equals(UsedStatusEnum.ENABLED)) {
			throw new EASBizException(new NumericExceptionSubItem("","�����Ѿ���׼�����ã���ֹɾ����"));
		}
		if(checkHasUsed(ctx, pk)) {
			throw new EASBizException(new NumericExceptionSubItem("001",info.getNumber()+" �����Ѿ����ã���ֹɾ����"));
		}
		super._delete(ctx, pk);
	}
	
	/**
	 * ����Ƿ�����
	 * @param ctx
	 * @param pk
	 * @return
	 */
	protected boolean checkHasUsed(Context ctx,IObjectPK pk) throws BOSException, EASBizException {
		return false;
	}
	
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		WlhlDataBaseInfo info=(WlhlDataBaseInfo) model;
		if(info.getBaseStatus().equals(UsedStatusEnum.APPROVED)||info.getBaseStatus().equals(UsedStatusEnum.ENABLED)) {
			throw new EASBizException(new NumericExceptionSubItem("","�����Ѿ���׼�����ã�"));
		}
		info.setBaseStatus(UsedStatusEnum.UNAPPROVE);
		return super._save(ctx, info);
	}
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		WlhlDataBaseInfo info=(WlhlDataBaseInfo) model;
		if(info.getBaseStatus().equals(UsedStatusEnum.APPROVED)||info.getBaseStatus().equals(UsedStatusEnum.ENABLED)) {
			throw new EASBizException(new NumericExceptionSubItem("","�����Ѿ���׼�����ã�"));
		}
		info.setBaseStatus(UsedStatusEnum.UNAPPROVE);
		return super._submit(ctx, info);
	}
	
	
    
}