package com.kingdee.eas.delivery.basedata;

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

public interface IDeliveryLine extends IDataBase
{
    public DeliveryLineInfo getDeliveryLineInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DeliveryLineInfo getDeliveryLineInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DeliveryLineInfo getDeliveryLineInfo(String oql) throws BOSException, EASBizException;
    public DeliveryLineCollection getDeliveryLineCollection() throws BOSException;
    public DeliveryLineCollection getDeliveryLineCollection(EntityViewInfo view) throws BOSException;
    public DeliveryLineCollection getDeliveryLineCollection(String oql) throws BOSException;
}