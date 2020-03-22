package com.kingdee.eas.custom.taihe.vehicledetection;

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

public interface IVcWhiteList extends IDataBase
{
    public VcWhiteListInfo getVcWhiteListInfo(IObjectPK pk) throws BOSException, EASBizException;
    public VcWhiteListInfo getVcWhiteListInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public VcWhiteListInfo getVcWhiteListInfo(String oql) throws BOSException, EASBizException;
    public VcWhiteListCollection getVcWhiteListCollection() throws BOSException;
    public VcWhiteListCollection getVcWhiteListCollection(EntityViewInfo view) throws BOSException;
    public VcWhiteListCollection getVcWhiteListCollection(String oql) throws BOSException;
    public void audit(VcWhiteListInfo model) throws BOSException;
    public void unAudit(VcWhiteListInfo model) throws BOSException;
}