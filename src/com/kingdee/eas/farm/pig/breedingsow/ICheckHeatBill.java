package com.kingdee.eas.farm.pig.breedingsow;

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

public interface ICheckHeatBill extends ICoreBillBase
{
    public CheckHeatBillCollection getCheckHeatBillCollection() throws BOSException;
    public CheckHeatBillCollection getCheckHeatBillCollection(EntityViewInfo view) throws BOSException;
    public CheckHeatBillCollection getCheckHeatBillCollection(String oql) throws BOSException;
    public CheckHeatBillInfo getCheckHeatBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CheckHeatBillInfo getCheckHeatBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CheckHeatBillInfo getCheckHeatBillInfo(String oql) throws BOSException, EASBizException;
}