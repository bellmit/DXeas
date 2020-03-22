package com.kingdee.eas.farm.hatch;

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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IHatchBillCoefficient extends IDataBase
{
    public HatchBillCoefficientInfo getHatchBillCoefficientInfo(IObjectPK pk) throws BOSException, EASBizException;
    public HatchBillCoefficientInfo getHatchBillCoefficientInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public HatchBillCoefficientInfo getHatchBillCoefficientInfo(String oql) throws BOSException, EASBizException;
    public HatchBillCoefficientCollection getHatchBillCoefficientCollection() throws BOSException;
    public HatchBillCoefficientCollection getHatchBillCoefficientCollection(EntityViewInfo view) throws BOSException;
    public HatchBillCoefficientCollection getHatchBillCoefficientCollection(String oql) throws BOSException;
}