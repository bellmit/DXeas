package com.kingdee.eas.WSInterface.basedataFacade;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.AbstractObjectCollection;
import com.kingdee.bos.orm.ORMCoreException;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBase;
import java.util.List;

public interface IBaseSupport
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

    public abstract ICoreBase getInterface()
        throws BOSException;

    public abstract List operationBill(int i, AbstractObjectCollection abstractobjectcollection, List list)
        throws BOSException, ORMCoreException, EASBizException;
}