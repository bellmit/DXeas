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
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ICarExcuteCircs extends ICoreBillBase
{
    public CarExcuteCircsCollection getCarExcuteCircsCollection() throws BOSException;
    public CarExcuteCircsCollection getCarExcuteCircsCollection(EntityViewInfo view) throws BOSException;
    public CarExcuteCircsCollection getCarExcuteCircsCollection(String oql) throws BOSException;
    public CarExcuteCircsInfo getCarExcuteCircsInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CarExcuteCircsInfo getCarExcuteCircsInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CarExcuteCircsInfo getCarExcuteCircsInfo(String oql) throws BOSException, EASBizException;
    public void audit(CarExcuteCircsInfo model) throws BOSException;
    public void unAudit(CarExcuteCircsInfo model) throws BOSException;
}