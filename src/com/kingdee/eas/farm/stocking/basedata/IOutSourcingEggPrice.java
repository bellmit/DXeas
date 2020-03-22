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

public interface IOutSourcingEggPrice extends IDataBase
{
    public OutSourcingEggPriceInfo getOutSourcingEggPriceInfo(IObjectPK pk) throws BOSException, EASBizException;
    public OutSourcingEggPriceInfo getOutSourcingEggPriceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public OutSourcingEggPriceInfo getOutSourcingEggPriceInfo(String oql) throws BOSException, EASBizException;
    public OutSourcingEggPriceCollection getOutSourcingEggPriceCollection() throws BOSException;
    public OutSourcingEggPriceCollection getOutSourcingEggPriceCollection(EntityViewInfo view) throws BOSException;
    public OutSourcingEggPriceCollection getOutSourcingEggPriceCollection(String oql) throws BOSException;
    public void audit(OutSourcingEggPriceInfo model) throws BOSException, EASBizException;
    public void unAudit(OutSourcingEggPriceInfo model) throws BOSException, EASBizException;
}