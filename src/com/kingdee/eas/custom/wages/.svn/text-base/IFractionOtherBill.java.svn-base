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

public interface IFractionOtherBill extends ICoreBillBase
{
    public FractionOtherBillCollection getFractionOtherBillCollection() throws BOSException;
    public FractionOtherBillCollection getFractionOtherBillCollection(EntityViewInfo view) throws BOSException;
    public FractionOtherBillCollection getFractionOtherBillCollection(String oql) throws BOSException;
    public FractionOtherBillInfo getFractionOtherBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FractionOtherBillInfo getFractionOtherBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FractionOtherBillInfo getFractionOtherBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(FractionOtherBillInfo model) throws BOSException;
    public void unaudit(FractionOtherBillInfo model) throws BOSException;
}