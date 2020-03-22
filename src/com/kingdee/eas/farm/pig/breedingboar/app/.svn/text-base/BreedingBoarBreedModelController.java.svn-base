package com.kingdee.eas.farm.pig.breedingboar.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.farm.pig.breedingboar.BreedingBoarBreedModelInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.farm.pig.breedingboar.BreedingBoarBreedModelCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BreedingBoarBreedModelController extends CoreBillBaseController
{
    public BreedingBoarBreedModelCollection getBreedingBoarBreedModelCollection(Context ctx) throws BOSException, RemoteException;
    public BreedingBoarBreedModelCollection getBreedingBoarBreedModelCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BreedingBoarBreedModelCollection getBreedingBoarBreedModelCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public BreedingBoarBreedModelInfo getBreedingBoarBreedModelInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BreedingBoarBreedModelInfo getBreedingBoarBreedModelInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BreedingBoarBreedModelInfo getBreedingBoarBreedModelInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}