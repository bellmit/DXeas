package com.kingdee.eas.farm.food;

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

public interface IFuleDaliy extends ICoreBillBase
{
    public FuleDaliyCollection getFuleDaliyCollection() throws BOSException;
    public FuleDaliyCollection getFuleDaliyCollection(EntityViewInfo view) throws BOSException;
    public FuleDaliyCollection getFuleDaliyCollection(String oql) throws BOSException;
    public FuleDaliyInfo getFuleDaliyInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FuleDaliyInfo getFuleDaliyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FuleDaliyInfo getFuleDaliyInfo(String oql) throws BOSException, EASBizException;
    public void audit(FuleDaliyInfo model) throws BOSException;
    public void unAudit(FuleDaliyInfo model) throws BOSException;
}