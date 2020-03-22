package com.kingdee.eas.farm.breed;

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

public interface IHenhouseEntry extends ICoreBillEntryBase
{
    public HenhouseEntryInfo getHenhouseEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public HenhouseEntryInfo getHenhouseEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public HenhouseEntryInfo getHenhouseEntryInfo(String oql) throws BOSException, EASBizException;
    public HenhouseEntryCollection getHenhouseEntryCollection() throws BOSException;
    public HenhouseEntryCollection getHenhouseEntryCollection(EntityViewInfo view) throws BOSException;
    public HenhouseEntryCollection getHenhouseEntryCollection(String oql) throws BOSException;
}