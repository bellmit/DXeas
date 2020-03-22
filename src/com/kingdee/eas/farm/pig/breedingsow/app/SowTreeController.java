package com.kingdee.eas.farm.pig.breedingsow.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.pig.breedingsow.SowTreeInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.farm.pig.breedingsow.SowTreeCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SowTreeController extends TreeBaseController
{
    public SowTreeInfo getSowTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SowTreeInfo getSowTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SowTreeInfo getSowTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public SowTreeCollection getSowTreeCollection(Context ctx) throws BOSException, RemoteException;
    public SowTreeCollection getSowTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SowTreeCollection getSowTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}