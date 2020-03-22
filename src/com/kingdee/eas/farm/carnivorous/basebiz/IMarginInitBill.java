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

public interface IMarginInitBill extends ICoreBillBase
{
    public MarginInitBillCollection getMarginInitBillCollection() throws BOSException;
    public MarginInitBillCollection getMarginInitBillCollection(EntityViewInfo view) throws BOSException;
    public MarginInitBillCollection getMarginInitBillCollection(String oql) throws BOSException;
    public MarginInitBillInfo getMarginInitBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MarginInitBillInfo getMarginInitBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MarginInitBillInfo getMarginInitBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(MarginInitBillInfo model) throws BOSException, EASBizException;
    public void unAudit(MarginInitBillInfo model) throws BOSException, EASBizException;
}