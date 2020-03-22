package com.kingdee.eas.farm.foodtrac;

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

public interface IFarmCode extends IDataBase
{
    public FarmCodeInfo getFarmCodeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FarmCodeInfo getFarmCodeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FarmCodeInfo getFarmCodeInfo(String oql) throws BOSException, EASBizException;
    public FarmCodeCollection getFarmCodeCollection() throws BOSException;
    public FarmCodeCollection getFarmCodeCollection(EntityViewInfo view) throws BOSException;
    public FarmCodeCollection getFarmCodeCollection(String oql) throws BOSException;
}