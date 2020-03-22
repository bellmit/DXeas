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

public interface ISignWasTheTable extends ICoreBillBase
{
    public SignWasTheTableCollection getSignWasTheTableCollection() throws BOSException;
    public SignWasTheTableCollection getSignWasTheTableCollection(EntityViewInfo view) throws BOSException;
    public SignWasTheTableCollection getSignWasTheTableCollection(String oql) throws BOSException;
    public SignWasTheTableInfo getSignWasTheTableInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SignWasTheTableInfo getSignWasTheTableInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SignWasTheTableInfo getSignWasTheTableInfo(String oql) throws BOSException, EASBizException;
    public void check(SignWasTheTableInfo model) throws BOSException, EASBizException;
    public void deleteLine(SignWasTheTableInfo model) throws BOSException;
    public void listener(SignWasTheTableInfo model) throws BOSException;
    public void unAudit(SignWasTheTableInfo model) throws BOSException, EASBizException;
    public void btnRefresh(SignWasTheTableInfo model) throws BOSException;
}