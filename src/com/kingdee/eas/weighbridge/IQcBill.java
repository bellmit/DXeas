package com.kingdee.eas.weighbridge;

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

public interface IQcBill extends ICoreBillBase
{
    public QcBillCollection getQcBillCollection() throws BOSException;
    public QcBillCollection getQcBillCollection(EntityViewInfo view) throws BOSException;
    public QcBillCollection getQcBillCollection(String oql) throws BOSException;
    public QcBillInfo getQcBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public QcBillInfo getQcBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public QcBillInfo getQcBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(QcBillInfo model) throws BOSException;
    public void unAudit(QcBillInfo model) throws BOSException;
}