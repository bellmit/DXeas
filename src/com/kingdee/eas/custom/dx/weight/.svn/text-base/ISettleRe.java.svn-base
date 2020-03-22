package com.kingdee.eas.custom.dx.weight;

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

public interface ISettleRe extends ICoreBillBase
{
    public SettleReCollection getSettleReCollection() throws BOSException;
    public SettleReCollection getSettleReCollection(EntityViewInfo view) throws BOSException;
    public SettleReCollection getSettleReCollection(String oql) throws BOSException;
    public SettleReInfo getSettleReInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SettleReInfo getSettleReInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SettleReInfo getSettleReInfo(String oql) throws BOSException, EASBizException;
    public void audit(SettleReInfo model) throws BOSException;
    public void unAudit(SettleReInfo model) throws BOSException;
}