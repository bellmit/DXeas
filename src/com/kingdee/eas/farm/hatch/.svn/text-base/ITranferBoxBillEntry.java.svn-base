package com.kingdee.eas.farm.hatch;

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

public interface ITranferBoxBillEntry extends ICoreBillEntryBase
{
    public TranferBoxBillEntryInfo getTranferBoxBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TranferBoxBillEntryInfo getTranferBoxBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TranferBoxBillEntryInfo getTranferBoxBillEntryInfo(String oql) throws BOSException, EASBizException;
    public TranferBoxBillEntryCollection getTranferBoxBillEntryCollection() throws BOSException;
    public TranferBoxBillEntryCollection getTranferBoxBillEntryCollection(EntityViewInfo view) throws BOSException;
    public TranferBoxBillEntryCollection getTranferBoxBillEntryCollection(String oql) throws BOSException;
}