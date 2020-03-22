package com.kingdee.eas.custom.signwasthetable;

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

public interface ICmChange extends ICoreBillBase
{
    public CmChangeCollection getCmChangeCollection() throws BOSException;
    public CmChangeCollection getCmChangeCollection(EntityViewInfo view) throws BOSException;
    public CmChangeCollection getCmChangeCollection(String oql) throws BOSException;
    public CmChangeInfo getCmChangeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CmChangeInfo getCmChangeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CmChangeInfo getCmChangeInfo(String oql) throws BOSException, EASBizException;
}