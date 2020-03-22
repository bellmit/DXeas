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

public interface IParentBreedBatchEntry extends ICoreBillEntryBase
{
    public ParentBreedBatchEntryInfo getParentBreedBatchEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ParentBreedBatchEntryInfo getParentBreedBatchEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ParentBreedBatchEntryInfo getParentBreedBatchEntryInfo(String oql) throws BOSException, EASBizException;
    public ParentBreedBatchEntryCollection getParentBreedBatchEntryCollection() throws BOSException;
    public ParentBreedBatchEntryCollection getParentBreedBatchEntryCollection(EntityViewInfo view) throws BOSException;
    public ParentBreedBatchEntryCollection getParentBreedBatchEntryCollection(String oql) throws BOSException;
}