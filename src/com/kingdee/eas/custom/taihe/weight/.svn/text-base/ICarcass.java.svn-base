package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ICarcass extends IWlhlBillBase
{
    public CarcassCollection getCarcassCollection() throws BOSException;
    public CarcassCollection getCarcassCollection(EntityViewInfo view) throws BOSException;
    public CarcassCollection getCarcassCollection(String oql) throws BOSException;
    public CarcassInfo getCarcassInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CarcassInfo getCarcassInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CarcassInfo getCarcassInfo(String oql) throws BOSException, EASBizException;
}