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

public interface IRoadLine extends IDataBase
{
    public RoadLineInfo getRoadLineInfo(IObjectPK pk) throws BOSException, EASBizException;
    public RoadLineInfo getRoadLineInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public RoadLineInfo getRoadLineInfo(String oql) throws BOSException, EASBizException;
    public RoadLineCollection getRoadLineCollection() throws BOSException;
    public RoadLineCollection getRoadLineCollection(EntityViewInfo view) throws BOSException;
    public RoadLineCollection getRoadLineCollection(String oql) throws BOSException;
    public void audit(RoadLineInfo model) throws BOSException, EASBizException;
    public void unAudit(RoadLineInfo model) throws BOSException, EASBizException;
}