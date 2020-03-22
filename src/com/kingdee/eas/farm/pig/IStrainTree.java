package com.kingdee.eas.farm.pig;

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

public interface IStrainTree extends ITreeBase
{
    public StrainTreeInfo getStrainTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public StrainTreeInfo getStrainTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public StrainTreeInfo getStrainTreeInfo(String oql) throws BOSException, EASBizException;
    public StrainTreeCollection getStrainTreeCollection() throws BOSException;
    public StrainTreeCollection getStrainTreeCollection(EntityViewInfo view) throws BOSException;
    public StrainTreeCollection getStrainTreeCollection(String oql) throws BOSException;
}