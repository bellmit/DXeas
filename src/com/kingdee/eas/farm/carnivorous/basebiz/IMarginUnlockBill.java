package com.kingdee.eas.farm.carnivorous.basebiz;

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

public interface IMarginUnlockBill extends ICoreBillBase
{
    public MarginUnlockBillCollection getMarginUnlockBillCollection() throws BOSException;
    public MarginUnlockBillCollection getMarginUnlockBillCollection(EntityViewInfo view) throws BOSException;
    public MarginUnlockBillCollection getMarginUnlockBillCollection(String oql) throws BOSException;
    public MarginUnlockBillInfo getMarginUnlockBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MarginUnlockBillInfo getMarginUnlockBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MarginUnlockBillInfo getMarginUnlockBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(MarginUnlockBillInfo model) throws BOSException, EASBizException;
    public void unAudit(MarginUnlockBillInfo model) throws BOSException, EASBizException;
}