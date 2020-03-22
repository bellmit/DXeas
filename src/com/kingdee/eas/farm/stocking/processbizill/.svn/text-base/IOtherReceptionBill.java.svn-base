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

public interface IOtherReceptionBill extends ICoreBillBase
{
    public OtherReceptionBillCollection getOtherReceptionBillCollection() throws BOSException;
    public OtherReceptionBillCollection getOtherReceptionBillCollection(EntityViewInfo view) throws BOSException;
    public OtherReceptionBillCollection getOtherReceptionBillCollection(String oql) throws BOSException;
    public OtherReceptionBillInfo getOtherReceptionBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public OtherReceptionBillInfo getOtherReceptionBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public OtherReceptionBillInfo getOtherReceptionBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(OtherReceptionBillInfo model) throws BOSException;
    public void unAudit(OtherReceptionBillInfo model) throws BOSException;
}