package com.kingdee.eas.custom.tocloud;

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

public interface IBaseDataRel extends IDataBase
{
    public BaseDataRelInfo getBaseDataRelInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BaseDataRelInfo getBaseDataRelInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BaseDataRelInfo getBaseDataRelInfo(String oql) throws BOSException, EASBizException;
    public BaseDataRelCollection getBaseDataRelCollection() throws BOSException;
    public BaseDataRelCollection getBaseDataRelCollection(EntityViewInfo view) throws BOSException;
    public BaseDataRelCollection getBaseDataRelCollection(String oql) throws BOSException;
    public void audit(BaseDataRelInfo model) throws BOSException;
    public void unAudit(BaseDataRelInfo model) throws BOSException;
}