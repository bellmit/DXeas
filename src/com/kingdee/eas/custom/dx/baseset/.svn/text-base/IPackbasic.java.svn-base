package com.kingdee.eas.custom.dx.baseset;

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

public interface IPackbasic extends IWlhlBillBase
{
    public PackbasicCollection getPackbasicCollection() throws BOSException;
    public PackbasicCollection getPackbasicCollection(EntityViewInfo view) throws BOSException;
    public PackbasicCollection getPackbasicCollection(String oql) throws BOSException;
    public PackbasicInfo getPackbasicInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PackbasicInfo getPackbasicInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PackbasicInfo getPackbasicInfo(String oql) throws BOSException, EASBizException;
    public void getData(PackbasicInfo model) throws BOSException;
}