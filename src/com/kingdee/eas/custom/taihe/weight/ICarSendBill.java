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

public interface ICarSendBill extends IWlhlBillBase
{
    public CarSendBillCollection getCarSendBillCollection() throws BOSException;
    public CarSendBillCollection getCarSendBillCollection(EntityViewInfo view) throws BOSException;
    public CarSendBillCollection getCarSendBillCollection(String oql) throws BOSException;
    public CarSendBillInfo getCarSendBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CarSendBillInfo getCarSendBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CarSendBillInfo getCarSendBillInfo(String oql) throws BOSException, EASBizException;
}