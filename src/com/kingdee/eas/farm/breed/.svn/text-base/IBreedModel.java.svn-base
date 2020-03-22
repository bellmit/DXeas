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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IBreedModel extends IDataBase
{
    public BreedModelInfo getBreedModelInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BreedModelInfo getBreedModelInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BreedModelInfo getBreedModelInfo(String oql) throws BOSException, EASBizException;
    public BreedModelCollection getBreedModelCollection() throws BOSException;
    public BreedModelCollection getBreedModelCollection(EntityViewInfo view) throws BOSException;
    public BreedModelCollection getBreedModelCollection(String oql) throws BOSException;
}