package com.kingdee.eas.farm.food.stocount;

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

public interface IProdCount extends ICoreBillBase
{
    public ProdCountCollection getProdCountCollection() throws BOSException;
    public ProdCountCollection getProdCountCollection(EntityViewInfo view) throws BOSException;
    public ProdCountCollection getProdCountCollection(String oql) throws BOSException;
    public ProdCountInfo getProdCountInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ProdCountInfo getProdCountInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ProdCountInfo getProdCountInfo(String oql) throws BOSException, EASBizException;
    public void audit(ProdCountInfo model) throws BOSException;
    public void unaudit(ProdCountInfo model) throws BOSException;
}