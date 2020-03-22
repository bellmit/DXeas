package com.kingdee.eas.farm.pig.breedingboar;

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

public interface ISpermCheckBillEntry extends ICoreBillEntryBase
{
    public SpermCheckBillEntryInfo getSpermCheckBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SpermCheckBillEntryInfo getSpermCheckBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SpermCheckBillEntryInfo getSpermCheckBillEntryInfo(String oql) throws BOSException, EASBizException;
    public SpermCheckBillEntryCollection getSpermCheckBillEntryCollection() throws BOSException;
    public SpermCheckBillEntryCollection getSpermCheckBillEntryCollection(EntityViewInfo view) throws BOSException;
    public SpermCheckBillEntryCollection getSpermCheckBillEntryCollection(String oql) throws BOSException;
}