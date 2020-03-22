package com.kingdee.eas.custom.shr;

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

public interface IMyTest extends ICoreBillBase
{
    public MyTestCollection getMyTestCollection() throws BOSException;
    public MyTestCollection getMyTestCollection(EntityViewInfo view) throws BOSException;
    public MyTestCollection getMyTestCollection(String oql) throws BOSException;
    public MyTestInfo getMyTestInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MyTestInfo getMyTestInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MyTestInfo getMyTestInfo(String oql) throws BOSException, EASBizException;
}