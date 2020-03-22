package com.kingdee.eas.custom.salaryvoucher;

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

public interface ICmpItem extends IDataBase
{
    public CmpItemInfo getCmpItemInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CmpItemInfo getCmpItemInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CmpItemInfo getCmpItemInfo(String oql) throws BOSException, EASBizException;
    public CmpItemCollection getCmpItemCollection() throws BOSException;
    public CmpItemCollection getCmpItemCollection(EntityViewInfo view) throws BOSException;
    public CmpItemCollection getCmpItemCollection(String oql) throws BOSException;
    public void updateCmpItem(CmpItemInfo model) throws BOSException;
}