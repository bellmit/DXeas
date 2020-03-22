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

public interface IInjuryinsurance extends ICoreBillBase
{
    public InjuryinsuranceCollection getInjuryinsuranceCollection() throws BOSException;
    public InjuryinsuranceCollection getInjuryinsuranceCollection(EntityViewInfo view) throws BOSException;
    public InjuryinsuranceCollection getInjuryinsuranceCollection(String oql) throws BOSException;
    public InjuryinsuranceInfo getInjuryinsuranceInfo(IObjectPK pk) throws BOSException, EASBizException;
    public InjuryinsuranceInfo getInjuryinsuranceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public InjuryinsuranceInfo getInjuryinsuranceInfo(String oql) throws BOSException, EASBizException;
    public void audit(InjuryinsuranceInfo model) throws BOSException;
    public void unaudit(InjuryinsuranceInfo model) throws BOSException;
}