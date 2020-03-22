package com.kingdee.eas.farm.stocking.basedata;

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

public interface IInsteadSeedPriceData extends IDataBase
{
    public InsteadSeedPriceDataInfo getInsteadSeedPriceDataInfo(IObjectPK pk) throws BOSException, EASBizException;
    public InsteadSeedPriceDataInfo getInsteadSeedPriceDataInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public InsteadSeedPriceDataInfo getInsteadSeedPriceDataInfo(String oql) throws BOSException, EASBizException;
    public InsteadSeedPriceDataCollection getInsteadSeedPriceDataCollection() throws BOSException;
    public InsteadSeedPriceDataCollection getInsteadSeedPriceDataCollection(EntityViewInfo view) throws BOSException;
    public InsteadSeedPriceDataCollection getInsteadSeedPriceDataCollection(String oql) throws BOSException;
    public void audit(InsteadSeedPriceDataInfo model) throws BOSException, EASBizException;
    public void unAudit(InsteadSeedPriceDataInfo model) throws BOSException, EASBizException;
}