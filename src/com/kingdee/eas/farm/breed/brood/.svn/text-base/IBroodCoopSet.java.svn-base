package com.kingdee.eas.farm.breed.brood;

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

public interface IBroodCoopSet extends ICoreBillBase
{
    public BroodCoopSetCollection getBroodCoopSetCollection() throws BOSException;
    public BroodCoopSetCollection getBroodCoopSetCollection(EntityViewInfo view) throws BOSException;
    public BroodCoopSetCollection getBroodCoopSetCollection(String oql) throws BOSException;
    public BroodCoopSetInfo getBroodCoopSetInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BroodCoopSetInfo getBroodCoopSetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BroodCoopSetInfo getBroodCoopSetInfo(String oql) throws BOSException, EASBizException;
}