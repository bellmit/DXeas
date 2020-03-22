package com.kingdee.eas.farm.pig.breedingboar;

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

public interface ICollectSpermBIll extends ICoreBillBase
{
    public CollectSpermBIllCollection getCollectSpermBIllCollection() throws BOSException;
    public CollectSpermBIllCollection getCollectSpermBIllCollection(EntityViewInfo view) throws BOSException;
    public CollectSpermBIllCollection getCollectSpermBIllCollection(String oql) throws BOSException;
    public CollectSpermBIllInfo getCollectSpermBIllInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CollectSpermBIllInfo getCollectSpermBIllInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CollectSpermBIllInfo getCollectSpermBIllInfo(String oql) throws BOSException, EASBizException;
}