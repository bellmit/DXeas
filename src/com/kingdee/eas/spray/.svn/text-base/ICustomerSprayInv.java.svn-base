package com.kingdee.eas.spray;

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

public interface ICustomerSprayInv extends ICoreBillBase
{
    public CustomerSprayInvCollection getCustomerSprayInvCollection() throws BOSException;
    public CustomerSprayInvCollection getCustomerSprayInvCollection(EntityViewInfo view) throws BOSException;
    public CustomerSprayInvCollection getCustomerSprayInvCollection(String oql) throws BOSException;
    public CustomerSprayInvInfo getCustomerSprayInvInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CustomerSprayInvInfo getCustomerSprayInvInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CustomerSprayInvInfo getCustomerSprayInvInfo(String oql) throws BOSException, EASBizException;
}