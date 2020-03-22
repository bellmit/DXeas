package com.kingdee.eas.custom.salepayment;

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

public interface IAreaSet extends IDataBase
{
    public AreaSetInfo getAreaSetInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AreaSetInfo getAreaSetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AreaSetInfo getAreaSetInfo(String oql) throws BOSException, EASBizException;
    public AreaSetCollection getAreaSetCollection() throws BOSException;
    public AreaSetCollection getAreaSetCollection(EntityViewInfo view) throws BOSException;
    public AreaSetCollection getAreaSetCollection(String oql) throws BOSException;
}