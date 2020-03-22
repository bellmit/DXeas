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

public interface ISzSemiProduct extends ICoreBillBase
{
    public SzSemiProductCollection getSzSemiProductCollection() throws BOSException;
    public SzSemiProductCollection getSzSemiProductCollection(EntityViewInfo view) throws BOSException;
    public SzSemiProductCollection getSzSemiProductCollection(String oql) throws BOSException;
    public SzSemiProductInfo getSzSemiProductInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SzSemiProductInfo getSzSemiProductInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SzSemiProductInfo getSzSemiProductInfo(String oql) throws BOSException, EASBizException;
    public void audit(SzSemiProductInfo model) throws BOSException;
    public void unaudit(SzSemiProductInfo model) throws BOSException;
    public void countInterface(SzSemiProductInfo model) throws BOSException;
    public void allAudit(SzSemiProductInfo model) throws BOSException;
}