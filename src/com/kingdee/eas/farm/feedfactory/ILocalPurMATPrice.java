package com.kingdee.eas.farm.feedfactory;

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

public interface ILocalPurMATPrice extends IDataBase
{
    public LocalPurMATPriceInfo getLocalPurMATPriceInfo(IObjectPK pk) throws BOSException, EASBizException;
    public LocalPurMATPriceInfo getLocalPurMATPriceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public LocalPurMATPriceInfo getLocalPurMATPriceInfo(String oql) throws BOSException, EASBizException;
    public LocalPurMATPriceCollection getLocalPurMATPriceCollection() throws BOSException;
    public LocalPurMATPriceCollection getLocalPurMATPriceCollection(EntityViewInfo view) throws BOSException;
    public LocalPurMATPriceCollection getLocalPurMATPriceCollection(String oql) throws BOSException;
    public void audit(LocalPurMATPriceInfo model) throws BOSException, EASBizException;
    public void unAudit(LocalPurMATPriceInfo model) throws BOSException, EASBizException;
}