package com.kingdee.eas.custom.settlebill.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.settlebill.CarcassRateTreeInfo;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.custom.settlebill.CarcassRateTreeCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CarcassRateTreeController extends TreeBaseController
{
    public CarcassRateTreeInfo getCarcassRateTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CarcassRateTreeInfo getCarcassRateTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CarcassRateTreeInfo getCarcassRateTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public CarcassRateTreeCollection getCarcassRateTreeCollection(Context ctx) throws BOSException, RemoteException;
    public CarcassRateTreeCollection getCarcassRateTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CarcassRateTreeCollection getCarcassRateTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}