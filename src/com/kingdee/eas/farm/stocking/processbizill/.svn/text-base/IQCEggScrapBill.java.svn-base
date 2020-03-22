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

public interface IQCEggScrapBill extends ICoreBillBase
{
    public QCEggScrapBillCollection getQCEggScrapBillCollection() throws BOSException;
    public QCEggScrapBillCollection getQCEggScrapBillCollection(EntityViewInfo view) throws BOSException;
    public QCEggScrapBillCollection getQCEggScrapBillCollection(String oql) throws BOSException;
    public QCEggScrapBillInfo getQCEggScrapBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public QCEggScrapBillInfo getQCEggScrapBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public QCEggScrapBillInfo getQCEggScrapBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(QCEggScrapBillInfo model) throws BOSException, EASBizException;
    public void unAudit(QCEggScrapBillInfo model) throws BOSException, EASBizException;
}