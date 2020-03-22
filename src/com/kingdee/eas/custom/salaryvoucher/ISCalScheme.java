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

public interface ISCalScheme extends IDataBase
{
    public SCalSchemeInfo getSCalSchemeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SCalSchemeInfo getSCalSchemeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SCalSchemeInfo getSCalSchemeInfo(String oql) throws BOSException, EASBizException;
    public SCalSchemeCollection getSCalSchemeCollection() throws BOSException;
    public SCalSchemeCollection getSCalSchemeCollection(EntityViewInfo view) throws BOSException;
    public SCalSchemeCollection getSCalSchemeCollection(String oql) throws BOSException;
    public void getSCalScheme(SCalSchemeInfo model) throws BOSException;
}