package com.kingdee.eas.WSInterface.billFacade;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.eas.common.EASBizException;
import java.util.List;

public interface IBillSupport
{

    public abstract void setContext(Context context);

    public abstract boolean isSupportSubmit();

    public abstract boolean isSupportAudit();

    public abstract List save(AbstractObjectCollection abstractobjectcollection)
        throws EASBizException, BOSException;

    public abstract List submit(AbstractObjectCollection abstractobjectcollection)
        throws EASBizException, BOSException;

    public abstract List audit(List list)
        throws EASBizException, BOSException;

    public abstract Class getInfoClass();
}