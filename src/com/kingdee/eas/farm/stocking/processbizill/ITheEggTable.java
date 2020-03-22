package com.kingdee.eas.farm.stocking.processbizill;

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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface ITheEggTable extends ICoreBillBase
{
    public TheEggTableCollection getTheEggTableCollection() throws BOSException;
    public TheEggTableCollection getTheEggTableCollection(EntityViewInfo view) throws BOSException;
    public TheEggTableCollection getTheEggTableCollection(String oql) throws BOSException;
    public TheEggTableInfo getTheEggTableInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TheEggTableInfo getTheEggTableInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TheEggTableInfo getTheEggTableInfo(String oql) throws BOSException, EASBizException;
    public void audit(TheEggTableInfo model) throws BOSException, EASBizException;
    public void unAudit(TheEggTableInfo model) throws BOSException, EASBizException;
    public void showPriceCol(TheEggTableInfo model) throws BOSException;
    public void viewAllBill(TheEggTableInfo model) throws BOSException;
}