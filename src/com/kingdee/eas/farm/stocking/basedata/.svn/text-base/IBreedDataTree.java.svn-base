package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ITreeBase;
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

public interface IBreedDataTree extends ITreeBase
{
    public BreedDataTreeInfo getBreedDataTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BreedDataTreeInfo getBreedDataTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BreedDataTreeInfo getBreedDataTreeInfo(String oql) throws BOSException, EASBizException;
    public BreedDataTreeCollection getBreedDataTreeCollection() throws BOSException;
    public BreedDataTreeCollection getBreedDataTreeCollection(EntityViewInfo view) throws BOSException;
    public BreedDataTreeCollection getBreedDataTreeCollection(String oql) throws BOSException;
}