package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IStockingBRelationTree extends ITreeBase
{
    public StockingBRelationTreeInfo getStockingBRelationTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public StockingBRelationTreeInfo getStockingBRelationTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public StockingBRelationTreeInfo getStockingBRelationTreeInfo(String oql) throws BOSException, EASBizException;
    public StockingBRelationTreeCollection getStockingBRelationTreeCollection() throws BOSException;
    public StockingBRelationTreeCollection getStockingBRelationTreeCollection(EntityViewInfo view) throws BOSException;
    public StockingBRelationTreeCollection getStockingBRelationTreeCollection(String oql) throws BOSException;
}