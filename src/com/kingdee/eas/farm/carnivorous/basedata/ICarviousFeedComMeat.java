package com.kingdee.eas.farm.carnivorous.basedata;

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

public interface ICarviousFeedComMeat extends IDataBase
{
    public CarviousFeedComMeatInfo getCarviousFeedComMeatInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CarviousFeedComMeatInfo getCarviousFeedComMeatInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CarviousFeedComMeatInfo getCarviousFeedComMeatInfo(String oql) throws BOSException, EASBizException;
    public CarviousFeedComMeatCollection getCarviousFeedComMeatCollection() throws BOSException;
    public CarviousFeedComMeatCollection getCarviousFeedComMeatCollection(EntityViewInfo view) throws BOSException;
    public CarviousFeedComMeatCollection getCarviousFeedComMeatCollection(String oql) throws BOSException;
    public void audit(CarviousFeedComMeatInfo model) throws BOSException, EASBizException;
    public void unAudit(CarviousFeedComMeatInfo model) throws BOSException, EASBizException;
}