package com.kingdee.eas.farm.breed;

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

public interface IBreedArea extends ICoreBillBase
{
    public BreedAreaCollection getBreedAreaCollection() throws BOSException;
    public BreedAreaCollection getBreedAreaCollection(EntityViewInfo view) throws BOSException;
    public BreedAreaCollection getBreedAreaCollection(String oql) throws BOSException;
    public BreedAreaInfo getBreedAreaInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BreedAreaInfo getBreedAreaInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BreedAreaInfo getBreedAreaInfo(String oql) throws BOSException, EASBizException;
}