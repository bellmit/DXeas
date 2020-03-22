package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ICarSendPlan extends IWlhlBillBase
{
    public CarSendPlanCollection getCarSendPlanCollection() throws BOSException;
    public CarSendPlanCollection getCarSendPlanCollection(EntityViewInfo view) throws BOSException;
    public CarSendPlanCollection getCarSendPlanCollection(String oql) throws BOSException;
    public CarSendPlanInfo getCarSendPlanInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CarSendPlanInfo getCarSendPlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CarSendPlanInfo getCarSendPlanInfo(String oql) throws BOSException, EASBizException;
}