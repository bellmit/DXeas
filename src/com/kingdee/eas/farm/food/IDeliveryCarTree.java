package com.kingdee.eas.farm.food;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ITreeBase;
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

public interface IDeliveryCarTree extends ITreeBase
{
    public DeliveryCarTreeInfo getDeliveryCarTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DeliveryCarTreeInfo getDeliveryCarTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DeliveryCarTreeInfo getDeliveryCarTreeInfo(String oql) throws BOSException, EASBizException;
    public DeliveryCarTreeCollection getDeliveryCarTreeCollection() throws BOSException;
    public DeliveryCarTreeCollection getDeliveryCarTreeCollection(EntityViewInfo view) throws BOSException;
    public DeliveryCarTreeCollection getDeliveryCarTreeCollection(String oql) throws BOSException;
}