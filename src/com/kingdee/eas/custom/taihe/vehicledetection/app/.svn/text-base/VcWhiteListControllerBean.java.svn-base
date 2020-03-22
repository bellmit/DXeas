package com.kingdee.eas.custom.taihe.vehicledetection.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.basedata.master.material.UsedStatusEnum;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.taihe.vehicledetection.VcWhiteListFactory;
import com.kingdee.eas.custom.taihe.vehicledetection.VcWhiteListInfo;

public class VcWhiteListControllerBean extends AbstractVcWhiteListControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.taihe.vehicledetection.app.VcWhiteListControllerBean");

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		VcWhiteListInfo info=(VcWhiteListInfo) model;
		info.setBaseStatus(UsedStatusEnum.UNAPPROVE);
		SelectorItemCollection slor=new SelectorItemCollection();
		slor.add("baseStatus");
		try {
			VcWhiteListFactory.getLocalInstance(ctx).updatePartial(info, slor);
		} catch (EASBizException e) {
			throw new BOSException(e);
		}
	}
	
	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
		VcWhiteListInfo info=(VcWhiteListInfo) model;
		info.setBaseStatus(UsedStatusEnum.UNAPPROVE);
		SelectorItemCollection slor=new SelectorItemCollection();
		slor.add("baseStatus");
		try {
			VcWhiteListFactory.getLocalInstance(ctx).updatePartial(info, slor);
		} catch (EASBizException e) {
			throw new BOSException(e);
		}
	}
}