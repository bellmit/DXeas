package com.kingdee.eas.farm.pig.breedingboar;

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

public interface ICollectSpermBIllEntry extends ICoreBillEntryBase
{
    public CollectSpermBIllEntryInfo getCollectSpermBIllEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CollectSpermBIllEntryInfo getCollectSpermBIllEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CollectSpermBIllEntryInfo getCollectSpermBIllEntryInfo(String oql) throws BOSException, EASBizException;
    public CollectSpermBIllEntryCollection getCollectSpermBIllEntryCollection() throws BOSException;
    public CollectSpermBIllEntryCollection getCollectSpermBIllEntryCollection(EntityViewInfo view) throws BOSException;
    public CollectSpermBIllEntryCollection getCollectSpermBIllEntryCollection(String oql) throws BOSException;
}