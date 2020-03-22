package com.kingdee.eas.farm.stocking.hatch;

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

public interface IEggReceiveBillEntry extends ICoreBillEntryBase
{
    public EggReceiveBillEntryInfo getEggReceiveBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public EggReceiveBillEntryInfo getEggReceiveBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public EggReceiveBillEntryInfo getEggReceiveBillEntryInfo(String oql) throws BOSException, EASBizException;
    public EggReceiveBillEntryCollection getEggReceiveBillEntryCollection() throws BOSException;
    public EggReceiveBillEntryCollection getEggReceiveBillEntryCollection(EntityViewInfo view) throws BOSException;
    public EggReceiveBillEntryCollection getEggReceiveBillEntryCollection(String oql) throws BOSException;
}