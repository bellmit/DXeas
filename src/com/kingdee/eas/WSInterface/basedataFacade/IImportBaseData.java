package com.kingdee.eas.WSInterface.basedataFacade;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.common.EASBizException;

public interface IImportBaseData
{

    public abstract String importing(Context context, String s, String s1, int i)
        throws BOSException, EASBizException;
}
