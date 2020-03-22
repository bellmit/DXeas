package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IInjuryinsuranceEntry extends ICoreBillEntryBase
{
    public InjuryinsuranceEntryInfo getInjuryinsuranceEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public InjuryinsuranceEntryInfo getInjuryinsuranceEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public InjuryinsuranceEntryInfo getInjuryinsuranceEntryInfo(String oql) throws BOSException, EASBizException;
    public InjuryinsuranceEntryCollection getInjuryinsuranceEntryCollection() throws BOSException;
    public InjuryinsuranceEntryCollection getInjuryinsuranceEntryCollection(EntityViewInfo view) throws BOSException;
    public InjuryinsuranceEntryCollection getInjuryinsuranceEntryCollection(String oql) throws BOSException;
}