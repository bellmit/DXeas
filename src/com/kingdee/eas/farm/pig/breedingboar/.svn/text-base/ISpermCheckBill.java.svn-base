package com.kingdee.eas.farm.pig.breedingboar;

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

public interface ISpermCheckBill extends ICoreBillBase
{
    public SpermCheckBillCollection getSpermCheckBillCollection() throws BOSException;
    public SpermCheckBillCollection getSpermCheckBillCollection(EntityViewInfo view) throws BOSException;
    public SpermCheckBillCollection getSpermCheckBillCollection(String oql) throws BOSException;
    public SpermCheckBillInfo getSpermCheckBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SpermCheckBillInfo getSpermCheckBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SpermCheckBillInfo getSpermCheckBillInfo(String oql) throws BOSException, EASBizException;
}