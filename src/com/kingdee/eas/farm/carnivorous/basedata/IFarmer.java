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

public interface IFarmer extends IDataBase
{
    public FarmerInfo getFarmerInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FarmerInfo getFarmerInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FarmerInfo getFarmerInfo(String oql) throws BOSException, EASBizException;
    public FarmerCollection getFarmerCollection() throws BOSException;
    public FarmerCollection getFarmerCollection(EntityViewInfo view) throws BOSException;
    public FarmerCollection getFarmerCollection(String oql) throws BOSException;
    public void audit(FarmerInfo model) throws BOSException, EASBizException;
    public void unAudit(FarmerInfo model) throws BOSException, EASBizException;
}