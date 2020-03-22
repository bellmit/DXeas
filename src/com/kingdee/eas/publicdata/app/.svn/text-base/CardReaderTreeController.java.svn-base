package com.kingdee.eas.publicdata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.publicdata.CardReaderTreeCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.publicdata.CardReaderTreeInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CardReaderTreeController extends TreeBaseController
{
    public CardReaderTreeInfo getCardReaderTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CardReaderTreeInfo getCardReaderTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CardReaderTreeInfo getCardReaderTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public CardReaderTreeCollection getCardReaderTreeCollection(Context ctx) throws BOSException, RemoteException;
    public CardReaderTreeCollection getCardReaderTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CardReaderTreeCollection getCardReaderTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}