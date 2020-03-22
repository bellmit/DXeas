package com.kingdee.eas.custom.applicationofsocialsecurity;

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

public interface IDataBaseConnection extends IDataBase
{
    public DataBaseConnectionInfo getDataBaseConnectionInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DataBaseConnectionInfo getDataBaseConnectionInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DataBaseConnectionInfo getDataBaseConnectionInfo(String oql) throws BOSException, EASBizException;
    public DataBaseConnectionCollection getDataBaseConnectionCollection() throws BOSException;
    public DataBaseConnectionCollection getDataBaseConnectionCollection(EntityViewInfo view) throws BOSException;
    public DataBaseConnectionCollection getDataBaseConnectionCollection(String oql) throws BOSException;
    public void audit(DataBaseConnectionInfo model) throws BOSException;
    public void unAudit(DataBaseConnectionInfo model) throws BOSException;
}