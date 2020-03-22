package com.kingdee.eas.farm.hatch;

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

public interface IHatchArea extends IDataBase
{
    public HatchAreaInfo getHatchAreaInfo(IObjectPK pk) throws BOSException, EASBizException;
    public HatchAreaInfo getHatchAreaInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public HatchAreaInfo getHatchAreaInfo(String oql) throws BOSException, EASBizException;
    public HatchAreaCollection getHatchAreaCollection() throws BOSException;
    public HatchAreaCollection getHatchAreaCollection(EntityViewInfo view) throws BOSException;
    public HatchAreaCollection getHatchAreaCollection(String oql) throws BOSException;
}