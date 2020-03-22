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

public interface IBirdsRecycleBill extends ICoreBillBase
{
    public BirdsRecycleBillCollection getBirdsRecycleBillCollection() throws BOSException;
    public BirdsRecycleBillCollection getBirdsRecycleBillCollection(EntityViewInfo view) throws BOSException;
    public BirdsRecycleBillCollection getBirdsRecycleBillCollection(String oql) throws BOSException;
    public BirdsRecycleBillInfo getBirdsRecycleBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BirdsRecycleBillInfo getBirdsRecycleBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BirdsRecycleBillInfo getBirdsRecycleBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(BirdsRecycleBillInfo model) throws BOSException;
    public void unAudit(BirdsRecycleBillInfo model) throws BOSException;
}