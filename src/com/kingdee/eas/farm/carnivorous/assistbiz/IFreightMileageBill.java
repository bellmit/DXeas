package com.kingdee.eas.farm.carnivorous.assistbiz;

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

public interface IFreightMileageBill extends IDataBase
{
    public FreightMileageBillInfo getFreightMileageBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public FreightMileageBillInfo getFreightMileageBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public FreightMileageBillInfo getFreightMileageBillInfo(String oql) throws BOSException, EASBizException;
    public FreightMileageBillCollection getFreightMileageBillCollection() throws BOSException;
    public FreightMileageBillCollection getFreightMileageBillCollection(EntityViewInfo view) throws BOSException;
    public FreightMileageBillCollection getFreightMileageBillCollection(String oql) throws BOSException;
    public void audit(FreightMileageBillInfo model) throws BOSException, EASBizException;
    public void unAudit(FreightMileageBillInfo model) throws BOSException, EASBizException;
}