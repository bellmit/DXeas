package com.kingdee.eas.farm.stocking.processbizill;

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

public interface IOtherPayment extends ICoreBillBase
{
    public OtherPaymentCollection getOtherPaymentCollection() throws BOSException;
    public OtherPaymentCollection getOtherPaymentCollection(EntityViewInfo view) throws BOSException;
    public OtherPaymentCollection getOtherPaymentCollection(String oql) throws BOSException;
    public OtherPaymentInfo getOtherPaymentInfo(IObjectPK pk) throws BOSException, EASBizException;
    public OtherPaymentInfo getOtherPaymentInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public OtherPaymentInfo getOtherPaymentInfo(String oql) throws BOSException, EASBizException;
    public void audit(OtherPaymentInfo model) throws BOSException;
    public void unAudit(OtherPaymentInfo model) throws BOSException;
    public void calFemalAmount(OtherPaymentInfo model) throws BOSException;
}