package com.kingdee.eas.custom.wages.farm;

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

public interface IBasicPostFarm extends IDataBase
{
    public BasicPostFarmInfo getBasicPostFarmInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BasicPostFarmInfo getBasicPostFarmInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BasicPostFarmInfo getBasicPostFarmInfo(String oql) throws BOSException, EASBizException;
    public BasicPostFarmCollection getBasicPostFarmCollection() throws BOSException;
    public BasicPostFarmCollection getBasicPostFarmCollection(EntityViewInfo view) throws BOSException;
    public BasicPostFarmCollection getBasicPostFarmCollection(String oql) throws BOSException;
}