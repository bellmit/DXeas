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

public interface IBreedBatchEntry extends ICoreBillEntryBase
{
    public BreedBatchEntryInfo getBreedBatchEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BreedBatchEntryInfo getBreedBatchEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BreedBatchEntryInfo getBreedBatchEntryInfo(String oql) throws BOSException, EASBizException;
    public BreedBatchEntryCollection getBreedBatchEntryCollection() throws BOSException;
    public BreedBatchEntryCollection getBreedBatchEntryCollection(EntityViewInfo view) throws BOSException;
    public BreedBatchEntryCollection getBreedBatchEntryCollection(String oql) throws BOSException;
}