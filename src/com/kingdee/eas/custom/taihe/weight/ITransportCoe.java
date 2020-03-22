package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlDataBase;
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

public interface ITransportCoe extends IWlhlDataBase
{
    public TransportCoeInfo getTransportCoeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TransportCoeInfo getTransportCoeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TransportCoeInfo getTransportCoeInfo(String oql) throws BOSException, EASBizException;
    public TransportCoeCollection getTransportCoeCollection() throws BOSException;
    public TransportCoeCollection getTransportCoeCollection(EntityViewInfo view) throws BOSException;
    public TransportCoeCollection getTransportCoeCollection(String oql) throws BOSException;
}