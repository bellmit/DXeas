package com.kingdee.eas.spray;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ICustomerSprayInvEntry extends ICoreBillEntryBase
{
    public CustomerSprayInvEntryInfo getCustomerSprayInvEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CustomerSprayInvEntryInfo getCustomerSprayInvEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CustomerSprayInvEntryInfo getCustomerSprayInvEntryInfo(String oql) throws BOSException, EASBizException;
    public CustomerSprayInvEntryCollection getCustomerSprayInvEntryCollection() throws BOSException;
    public CustomerSprayInvEntryCollection getCustomerSprayInvEntryCollection(EntityViewInfo view) throws BOSException;
    public CustomerSprayInvEntryCollection getCustomerSprayInvEntryCollection(String oql) throws BOSException;
}