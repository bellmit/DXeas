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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IPostAllocation extends ICoreBillBase
{
    public PostAllocationCollection getPostAllocationCollection() throws BOSException;
    public PostAllocationCollection getPostAllocationCollection(EntityViewInfo view) throws BOSException;
    public PostAllocationCollection getPostAllocationCollection(String oql) throws BOSException;
    public PostAllocationInfo getPostAllocationInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PostAllocationInfo getPostAllocationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PostAllocationInfo getPostAllocationInfo(String oql) throws BOSException, EASBizException;
    public void audit(PostAllocationInfo model) throws BOSException;
    public void unaudit(PostAllocationInfo model) throws BOSException;
}