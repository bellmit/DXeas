package com.kingdee.eas.custom.szcount;

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

public interface ISzProdCount extends ICoreBillBase
{
    public SzProdCountCollection getSzProdCountCollection() throws BOSException;
    public SzProdCountCollection getSzProdCountCollection(EntityViewInfo view) throws BOSException;
    public SzProdCountCollection getSzProdCountCollection(String oql) throws BOSException;
    public SzProdCountInfo getSzProdCountInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SzProdCountInfo getSzProdCountInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SzProdCountInfo getSzProdCountInfo(String oql) throws BOSException, EASBizException;
    public void audit(SzProdCountInfo model) throws BOSException;
    public void unaudit(SzProdCountInfo model) throws BOSException;
}