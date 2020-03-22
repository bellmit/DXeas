package com.kingdee.eas.custom.echickeninterface.billFacade;

import java.util.List;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.eas.common.EASBizException;

public interface IBillSupport {
	public abstract void setContext(Context context);

	public abstract boolean isSupportSbumit();

	public abstract boolean isSupportAudit();

	public abstract List save(AbstractObjectCollection abstractObjectCollection)
			throws EASBizException, BOSException;

	public abstract List submit(
			AbstractObjectCollection abstractObjectCollection)
			throws EASBizException, BOSException;

	public abstract List audit(List list);

	public abstract Class getInfoClass();
}
