package com.kingdee.eas.farm.feedfactory;

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

public interface IPurFright extends ICoreBillBase
{
    public PurFrightCollection getPurFrightCollection() throws BOSException;
    public PurFrightCollection getPurFrightCollection(EntityViewInfo view) throws BOSException;
    public PurFrightCollection getPurFrightCollection(String oql) throws BOSException;
    public PurFrightInfo getPurFrightInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PurFrightInfo getPurFrightInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PurFrightInfo getPurFrightInfo(String oql) throws BOSException, EASBizException;
    public void audit(PurFrightInfo model) throws BOSException;
    public void unAudit(PurFrightInfo model) throws BOSException;
}