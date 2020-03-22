package com.kingdee.eas.custom.wages;

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

public interface IWagesPersonInfo extends ICoreBillBase
{
    public WagesPersonInfoCollection getWagesPersonInfoCollection() throws BOSException;
    public WagesPersonInfoCollection getWagesPersonInfoCollection(EntityViewInfo view) throws BOSException;
    public WagesPersonInfoCollection getWagesPersonInfoCollection(String oql) throws BOSException;
    public WagesPersonInfoInfo getWagesPersonInfoInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WagesPersonInfoInfo getWagesPersonInfoInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WagesPersonInfoInfo getWagesPersonInfoInfo(String oql) throws BOSException, EASBizException;
    public void audit(WagesPersonInfoInfo model) throws BOSException;
    public void unaudit(WagesPersonInfoInfo model) throws BOSException;
}