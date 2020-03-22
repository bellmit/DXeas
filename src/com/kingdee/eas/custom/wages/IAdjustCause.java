package com.kingdee.eas.custom.wages;

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

public interface IAdjustCause extends IDataBase
{
    public AdjustCauseInfo getAdjustCauseInfo(IObjectPK pk) throws BOSException, EASBizException;
    public AdjustCauseInfo getAdjustCauseInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public AdjustCauseInfo getAdjustCauseInfo(String oql) throws BOSException, EASBizException;
    public AdjustCauseCollection getAdjustCauseCollection() throws BOSException;
    public AdjustCauseCollection getAdjustCauseCollection(EntityViewInfo view) throws BOSException;
    public AdjustCauseCollection getAdjustCauseCollection(String oql) throws BOSException;
}