package com.kingdee.eas.custom.wages;

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

public interface IProControlWithhold extends ICoreBillBase
{
    public ProControlWithholdCollection getProControlWithholdCollection() throws BOSException;
    public ProControlWithholdCollection getProControlWithholdCollection(EntityViewInfo view) throws BOSException;
    public ProControlWithholdCollection getProControlWithholdCollection(String oql) throws BOSException;
    public ProControlWithholdInfo getProControlWithholdInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ProControlWithholdInfo getProControlWithholdInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ProControlWithholdInfo getProControlWithholdInfo(String oql) throws BOSException, EASBizException;
    public void audit(ProControlWithholdInfo model) throws BOSException;
    public void unaudit(ProControlWithholdInfo model) throws BOSException;
}