package com.kingdee.eas.custom.shr;

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

public interface IWincosForSHR extends IDataBase
{
    public WincosForSHRInfo getWincosForSHRInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WincosForSHRInfo getWincosForSHRInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WincosForSHRInfo getWincosForSHRInfo(String oql) throws BOSException, EASBizException;
    public WincosForSHRCollection getWincosForSHRCollection() throws BOSException;
    public WincosForSHRCollection getWincosForSHRCollection(EntityViewInfo view) throws BOSException;
    public WincosForSHRCollection getWincosForSHRCollection(String oql) throws BOSException;
}