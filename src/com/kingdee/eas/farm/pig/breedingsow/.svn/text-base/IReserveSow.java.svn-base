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

public interface IReserveSow extends ICoreBillBase
{
    public ReserveSowCollection getReserveSowCollection() throws BOSException;
    public ReserveSowCollection getReserveSowCollection(EntityViewInfo view) throws BOSException;
    public ReserveSowCollection getReserveSowCollection(String oql) throws BOSException;
    public ReserveSowInfo getReserveSowInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ReserveSowInfo getReserveSowInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ReserveSowInfo getReserveSowInfo(String oql) throws BOSException, EASBizException;
}