package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ITranOut extends ICoreBillBase
{
    public TranOutCollection getTranOutCollection() throws BOSException;
    public TranOutCollection getTranOutCollection(EntityViewInfo view) throws BOSException;
    public TranOutCollection getTranOutCollection(String oql) throws BOSException;
    public TranOutInfo getTranOutInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TranOutInfo getTranOutInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TranOutInfo getTranOutInfo(String oql) throws BOSException, EASBizException;
    public void audit(TranOutInfo model) throws BOSException, EASBizException;
    public void unAudit(TranOutInfo model) throws BOSException, EASBizException;
}