package com.kingdee.eas.farm.pig.breedingsow;

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

public interface ISowRentoutBillEntry extends ICoreBillEntryBase
{
    public SowRentoutBillEntryInfo getSowRentoutBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SowRentoutBillEntryInfo getSowRentoutBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SowRentoutBillEntryInfo getSowRentoutBillEntryInfo(String oql) throws BOSException, EASBizException;
    public SowRentoutBillEntryCollection getSowRentoutBillEntryCollection() throws BOSException;
    public SowRentoutBillEntryCollection getSowRentoutBillEntryCollection(EntityViewInfo view) throws BOSException;
    public SowRentoutBillEntryCollection getSowRentoutBillEntryCollection(String oql) throws BOSException;
}