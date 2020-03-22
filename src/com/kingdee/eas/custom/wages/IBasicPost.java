package com.kingdee.eas.custom.wages;

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

public interface IBasicPost extends IDataBase
{
    public BasicPostInfo getBasicPostInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BasicPostInfo getBasicPostInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BasicPostInfo getBasicPostInfo(String oql) throws BOSException, EASBizException;
    public BasicPostCollection getBasicPostCollection() throws BOSException;
    public BasicPostCollection getBasicPostCollection(EntityViewInfo view) throws BOSException;
    public BasicPostCollection getBasicPostCollection(String oql) throws BOSException;
}