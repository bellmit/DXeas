package com.kingdee.eas.farm.feedfactory;

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

public interface IQualityCheckBill extends ICoreBillBase
{
    public QualityCheckBillCollection getQualityCheckBillCollection() throws BOSException;
    public QualityCheckBillCollection getQualityCheckBillCollection(EntityViewInfo view) throws BOSException;
    public QualityCheckBillCollection getQualityCheckBillCollection(String oql) throws BOSException;
    public QualityCheckBillInfo getQualityCheckBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public QualityCheckBillInfo getQualityCheckBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public QualityCheckBillInfo getQualityCheckBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(QualityCheckBillInfo model) throws BOSException;
    public void unAudit(QualityCheckBillInfo model) throws BOSException;
}