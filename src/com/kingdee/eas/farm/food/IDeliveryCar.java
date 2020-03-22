package com.kingdee.eas.farm.food;

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

public interface IDeliveryCar extends IDataBase
{
    public DeliveryCarInfo getDeliveryCarInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DeliveryCarInfo getDeliveryCarInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DeliveryCarInfo getDeliveryCarInfo(String oql) throws BOSException, EASBizException;
    public DeliveryCarCollection getDeliveryCarCollection() throws BOSException;
    public DeliveryCarCollection getDeliveryCarCollection(EntityViewInfo view) throws BOSException;
    public DeliveryCarCollection getDeliveryCarCollection(String oql) throws BOSException;
}