package com.kingdee.eas.custom.salaryvoucher;

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

public interface IConnectServer extends IDataBase
{
    public ConnectServerInfo getConnectServerInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ConnectServerInfo getConnectServerInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ConnectServerInfo getConnectServerInfo(String oql) throws BOSException, EASBizException;
    public ConnectServerCollection getConnectServerCollection() throws BOSException;
    public ConnectServerCollection getConnectServerCollection(EntityViewInfo view) throws BOSException;
    public ConnectServerCollection getConnectServerCollection(String oql) throws BOSException;
    public void audit(ConnectServerInfo model) throws BOSException;
    public void unAudit(ConnectServerInfo model) throws BOSException;
}