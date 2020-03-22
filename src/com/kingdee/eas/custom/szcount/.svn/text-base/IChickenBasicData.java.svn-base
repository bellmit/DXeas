package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlDataBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IChickenBasicData extends IWlhlDataBase
{
    public ChickenBasicDataInfo getChickenBasicDataInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ChickenBasicDataInfo getChickenBasicDataInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ChickenBasicDataInfo getChickenBasicDataInfo(String oql) throws BOSException, EASBizException;
    public ChickenBasicDataCollection getChickenBasicDataCollection() throws BOSException;
    public ChickenBasicDataCollection getChickenBasicDataCollection(EntityViewInfo view) throws BOSException;
    public ChickenBasicDataCollection getChickenBasicDataCollection(String oql) throws BOSException;
}