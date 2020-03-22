package com.kingdee.eas.custom.mobileRPT;

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

public interface IRPTRole extends IDataBase
{
    public RPTRoleInfo getRPTRoleInfo(IObjectPK pk) throws BOSException, EASBizException;
    public RPTRoleInfo getRPTRoleInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public RPTRoleInfo getRPTRoleInfo(String oql) throws BOSException, EASBizException;
    public RPTRoleCollection getRPTRoleCollection() throws BOSException;
    public RPTRoleCollection getRPTRoleCollection(EntityViewInfo view) throws BOSException;
    public RPTRoleCollection getRPTRoleCollection(String oql) throws BOSException;
    public void sendMessage(RPTRoleInfo model) throws BOSException;
}