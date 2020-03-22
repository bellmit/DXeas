package com.kingdee.eas.custom.rentalapplicationform;

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

public interface IRentalApplicationOfBusinessCar extends ICoreBillBase
{
    public RentalApplicationOfBusinessCarCollection getRentalApplicationOfBusinessCarCollection() throws BOSException;
    public RentalApplicationOfBusinessCarCollection getRentalApplicationOfBusinessCarCollection(EntityViewInfo view) throws BOSException;
    public RentalApplicationOfBusinessCarCollection getRentalApplicationOfBusinessCarCollection(String oql) throws BOSException;
    public RentalApplicationOfBusinessCarInfo getRentalApplicationOfBusinessCarInfo(IObjectPK pk) throws BOSException, EASBizException;
    public RentalApplicationOfBusinessCarInfo getRentalApplicationOfBusinessCarInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public RentalApplicationOfBusinessCarInfo getRentalApplicationOfBusinessCarInfo(String oql) throws BOSException, EASBizException;
    public void audit(RentalApplicationOfBusinessCarInfo model) throws BOSException, EASBizException;
    public void unAudit(RentalApplicationOfBusinessCarInfo model) throws BOSException, EASBizException;
}