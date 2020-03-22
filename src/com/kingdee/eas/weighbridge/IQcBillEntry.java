package com.kingdee.eas.weighbridge;

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

public interface IQcBillEntry extends ICoreBillEntryBase
{
    public QcBillEntryInfo getQcBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public QcBillEntryInfo getQcBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public QcBillEntryInfo getQcBillEntryInfo(String oql) throws BOSException, EASBizException;
    public QcBillEntryCollection getQcBillEntryCollection() throws BOSException;
    public QcBillEntryCollection getQcBillEntryCollection(EntityViewInfo view) throws BOSException;
    public QcBillEntryCollection getQcBillEntryCollection(String oql) throws BOSException;
}