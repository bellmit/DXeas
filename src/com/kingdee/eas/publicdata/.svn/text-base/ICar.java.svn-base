package com.kingdee.eas.publicdata;

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

public interface ICar extends IDataBase
{
    public CarInfo getCarInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CarInfo getCarInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CarInfo getCarInfo(String oql) throws BOSException, EASBizException;
    public CarCollection getCarCollection() throws BOSException;
    public CarCollection getCarCollection(EntityViewInfo view) throws BOSException;
    public CarCollection getCarCollection(String oql) throws BOSException;
    public void review(CarInfo model) throws BOSException;
    public void unreview(CarInfo model) throws BOSException;
    public void audit(CarInfo model) throws BOSException, EASBizException;
    public void unAudit(CarInfo model) throws BOSException, EASBizException;
}