package com.kingdee.eas.custom.tocloud;

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

public interface IBaseDataRelTree extends ITreeBase
{
    public BaseDataRelTreeInfo getBaseDataRelTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BaseDataRelTreeInfo getBaseDataRelTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BaseDataRelTreeInfo getBaseDataRelTreeInfo(String oql) throws BOSException, EASBizException;
    public BaseDataRelTreeCollection getBaseDataRelTreeCollection() throws BOSException;
    public BaseDataRelTreeCollection getBaseDataRelTreeCollection(EntityViewInfo view) throws BOSException;
    public BaseDataRelTreeCollection getBaseDataRelTreeCollection(String oql) throws BOSException;
}