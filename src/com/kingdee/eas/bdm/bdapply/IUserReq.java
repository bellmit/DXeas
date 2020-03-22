package com.kingdee.eas.bdm.bdapply;

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

public interface IUserReq extends ICoreBillBase
{
    public UserReqCollection getUserReqCollection() throws BOSException;
    public UserReqCollection getUserReqCollection(EntityViewInfo view) throws BOSException;
    public UserReqCollection getUserReqCollection(String oql) throws BOSException;
    public UserReqInfo getUserReqInfo(IObjectPK pk) throws BOSException, EASBizException;
    public UserReqInfo getUserReqInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public UserReqInfo getUserReqInfo(String oql) throws BOSException, EASBizException;
    public void audit(UserReqInfo model) throws BOSException;
    public void unAudit(UserReqInfo model) throws BOSException;
}