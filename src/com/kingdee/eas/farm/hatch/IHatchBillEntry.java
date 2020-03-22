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

public interface IHatchBillEntry extends ICoreBillEntryBase
{
    public HatchBillEntryInfo getHatchBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public HatchBillEntryInfo getHatchBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public HatchBillEntryInfo getHatchBillEntryInfo(String oql) throws BOSException, EASBizException;
    public HatchBillEntryCollection getHatchBillEntryCollection() throws BOSException;
    public HatchBillEntryCollection getHatchBillEntryCollection(EntityViewInfo view) throws BOSException;
    public HatchBillEntryCollection getHatchBillEntryCollection(String oql) throws BOSException;
}