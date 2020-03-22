package com.kingdee.eas.farm.pig.breedingsow.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.farm.pig.breedingsow.FetationCheckTypeTreeInfo;
import com.kingdee.eas.farm.pig.breedingsow.FetationCheckTypeTreeCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
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

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface FetationCheckTypeTreeController extends TreeBaseController
{
    public FetationCheckTypeTreeInfo getFetationCheckTypeTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FetationCheckTypeTreeInfo getFetationCheckTypeTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FetationCheckTypeTreeInfo getFetationCheckTypeTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public FetationCheckTypeTreeCollection getFetationCheckTypeTreeCollection(Context ctx) throws BOSException, RemoteException;
    public FetationCheckTypeTreeCollection getFetationCheckTypeTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FetationCheckTypeTreeCollection getFetationCheckTypeTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}