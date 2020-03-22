package com.kingdee.eas.farm.carnivorous.feedbiz;

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

public interface ICTransFodderBill extends ICoreBillBase
{
    public CTransFodderBillCollection getCTransFodderBillCollection() throws BOSException;
    public CTransFodderBillCollection getCTransFodderBillCollection(EntityViewInfo view) throws BOSException;
    public CTransFodderBillCollection getCTransFodderBillCollection(String oql) throws BOSException;
    public CTransFodderBillInfo getCTransFodderBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CTransFodderBillInfo getCTransFodderBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CTransFodderBillInfo getCTransFodderBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(CTransFodderBillInfo model) throws BOSException, EASBizException;
    public void unAudit(CTransFodderBillInfo model) throws BOSException, EASBizException;
}