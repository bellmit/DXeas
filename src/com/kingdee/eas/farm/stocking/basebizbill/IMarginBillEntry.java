package com.kingdee.eas.farm.stocking.basebizbill;

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

public interface IMarginBillEntry extends ICoreBillEntryBase
{
    public MarginBillEntryInfo getMarginBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MarginBillEntryInfo getMarginBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MarginBillEntryInfo getMarginBillEntryInfo(String oql) throws BOSException, EASBizException;
    public MarginBillEntryCollection getMarginBillEntryCollection() throws BOSException;
    public MarginBillEntryCollection getMarginBillEntryCollection(EntityViewInfo view) throws BOSException;
    public MarginBillEntryCollection getMarginBillEntryCollection(String oql) throws BOSException;
}