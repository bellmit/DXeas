package com.kingdee.eas.custom.settlebill;

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

public interface ICarcassRate extends IDataBase
{
    public CarcassRateInfo getCarcassRateInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CarcassRateInfo getCarcassRateInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CarcassRateInfo getCarcassRateInfo(String oql) throws BOSException, EASBizException;
    public CarcassRateCollection getCarcassRateCollection() throws BOSException;
    public CarcassRateCollection getCarcassRateCollection(EntityViewInfo view) throws BOSException;
    public CarcassRateCollection getCarcassRateCollection(String oql) throws BOSException;
}