package com.kingdee.eas.wlhlcomm.function;

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

public interface IBillUpdateLogEntry extends ICoreBillEntryBase
{
    public BillUpdateLogEntryInfo getBillUpdateLogEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BillUpdateLogEntryInfo getBillUpdateLogEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BillUpdateLogEntryInfo getBillUpdateLogEntryInfo(String oql) throws BOSException, EASBizException;
    public BillUpdateLogEntryCollection getBillUpdateLogEntryCollection() throws BOSException;
    public BillUpdateLogEntryCollection getBillUpdateLogEntryCollection(EntityViewInfo view) throws BOSException;
    public BillUpdateLogEntryCollection getBillUpdateLogEntryCollection(String oql) throws BOSException;
}