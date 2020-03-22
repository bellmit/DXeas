package com.kingdee.eas.custom.erp2tax.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.erp2tax.MaterialTaxCodeCollection;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.erp2tax.MaterialTaxCodeInfo;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface MaterialTaxCodeController extends DataBaseController
{
    public MaterialTaxCodeInfo getMaterialTaxCodeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public MaterialTaxCodeInfo getMaterialTaxCodeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public MaterialTaxCodeInfo getMaterialTaxCodeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public MaterialTaxCodeCollection getMaterialTaxCodeCollection(Context ctx) throws BOSException, RemoteException;
    public MaterialTaxCodeCollection getMaterialTaxCodeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public MaterialTaxCodeCollection getMaterialTaxCodeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}