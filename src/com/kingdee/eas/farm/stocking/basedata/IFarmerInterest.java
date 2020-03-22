package com.kingdee.eas.farm.stocking.basedata;

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

public interface IFarmerInterest extends IDataBase
{
    public FarmerInterestInfo getFarmerInterestInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FarmerInterestInfo getFarmerInterestInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FarmerInterestInfo getFarmerInterestInfo(String oql) throws BOSException, EASBizException;
    public FarmerInterestCollection getFarmerInterestCollection() throws BOSException;
    public FarmerInterestCollection getFarmerInterestCollection(EntityViewInfo view) throws BOSException;
    public FarmerInterestCollection getFarmerInterestCollection(String oql) throws BOSException;
}