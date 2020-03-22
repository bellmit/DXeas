package com.kingdee.eas.farm.food;

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
import com.kingdee.eas.scm.im.inv.IInvBillBaseEntry;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ICManufactureBillEntry extends IInvBillBaseEntry
{
    public CManufactureBillEntryInfo getCManufactureBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CManufactureBillEntryInfo getCManufactureBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CManufactureBillEntryInfo getCManufactureBillEntryInfo(String oql) throws BOSException, EASBizException;
    public CManufactureBillEntryCollection getCManufactureBillEntryCollection() throws BOSException;
    public CManufactureBillEntryCollection getCManufactureBillEntryCollection(EntityViewInfo view) throws BOSException;
    public CManufactureBillEntryCollection getCManufactureBillEntryCollection(String oql) throws BOSException;
}