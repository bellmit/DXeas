package com.kingdee.eas.farm.hatch;

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

public interface IImmuneBill extends ICoreBillBase
{
    public ImmuneBillCollection getImmuneBillCollection() throws BOSException;
    public ImmuneBillCollection getImmuneBillCollection(EntityViewInfo view) throws BOSException;
    public ImmuneBillCollection getImmuneBillCollection(String oql) throws BOSException;
    public ImmuneBillInfo getImmuneBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ImmuneBillInfo getImmuneBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ImmuneBillInfo getImmuneBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(ImmuneBillInfo model) throws BOSException, EASBizException;
    public void unAudit(ImmuneBillInfo model) throws BOSException, EASBizException;
}