package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IQualityCheckBillEntry extends ICoreBillEntryBase
{
    public QualityCheckBillEntryInfo getQualityCheckBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public QualityCheckBillEntryInfo getQualityCheckBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public QualityCheckBillEntryInfo getQualityCheckBillEntryInfo(String oql) throws BOSException, EASBizException;
    public QualityCheckBillEntryCollection getQualityCheckBillEntryCollection() throws BOSException;
    public QualityCheckBillEntryCollection getQualityCheckBillEntryCollection(EntityViewInfo view) throws BOSException;
    public QualityCheckBillEntryCollection getQualityCheckBillEntryCollection(String oql) throws BOSException;
}