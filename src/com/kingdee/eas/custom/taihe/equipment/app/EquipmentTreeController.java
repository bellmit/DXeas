package com.kingdee.eas.custom.taihe.equipment.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.taihe.equipment.EquipmentTreeInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.custom.taihe.equipment.EquipmentTreeCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface EquipmentTreeController extends TreeBaseController
{
    public EquipmentTreeInfo getEquipmentTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public EquipmentTreeInfo getEquipmentTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public EquipmentTreeInfo getEquipmentTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public EquipmentTreeCollection getEquipmentTreeCollection(Context ctx) throws BOSException, RemoteException;
    public EquipmentTreeCollection getEquipmentTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public EquipmentTreeCollection getEquipmentTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}