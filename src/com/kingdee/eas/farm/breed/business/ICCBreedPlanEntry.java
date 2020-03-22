package com.kingdee.eas.farm.breed.business;

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

public interface ICCBreedPlanEntry extends ICoreBillEntryBase
{
    public CCBreedPlanEntryInfo getCCBreedPlanEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CCBreedPlanEntryInfo getCCBreedPlanEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CCBreedPlanEntryInfo getCCBreedPlanEntryInfo(String oql) throws BOSException, EASBizException;
    public CCBreedPlanEntryCollection getCCBreedPlanEntryCollection() throws BOSException;
    public CCBreedPlanEntryCollection getCCBreedPlanEntryCollection(EntityViewInfo view) throws BOSException;
    public CCBreedPlanEntryCollection getCCBreedPlanEntryCollection(String oql) throws BOSException;
}