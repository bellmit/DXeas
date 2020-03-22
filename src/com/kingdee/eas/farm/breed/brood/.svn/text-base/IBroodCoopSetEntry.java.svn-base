package com.kingdee.eas.farm.breed.brood;

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

public interface IBroodCoopSetEntry extends ICoreBillEntryBase
{
    public BroodCoopSetEntryInfo getBroodCoopSetEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BroodCoopSetEntryInfo getBroodCoopSetEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BroodCoopSetEntryInfo getBroodCoopSetEntryInfo(String oql) throws BOSException, EASBizException;
    public BroodCoopSetEntryCollection getBroodCoopSetEntryCollection() throws BOSException;
    public BroodCoopSetEntryCollection getBroodCoopSetEntryCollection(EntityViewInfo view) throws BOSException;
    public BroodCoopSetEntryCollection getBroodCoopSetEntryCollection(String oql) throws BOSException;
}