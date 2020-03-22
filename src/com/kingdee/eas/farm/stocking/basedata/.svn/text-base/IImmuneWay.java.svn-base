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

public interface IImmuneWay extends IDataBase
{
    public ImmuneWayInfo getImmuneWayInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ImmuneWayInfo getImmuneWayInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ImmuneWayInfo getImmuneWayInfo(String oql) throws BOSException, EASBizException;
    public ImmuneWayCollection getImmuneWayCollection() throws BOSException;
    public ImmuneWayCollection getImmuneWayCollection(EntityViewInfo view) throws BOSException;
    public ImmuneWayCollection getImmuneWayCollection(String oql) throws BOSException;
}