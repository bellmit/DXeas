package com.kingdee.eas.custom.eas2temp;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.lang.String;
import com.kingdee.bos.util.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.framework.CoreBaseCollection;

public interface IBarMaterialRel extends IDataBase
{
    public BarMaterialRelInfo getBarMaterialRelInfo(IObjectPK pk) throws BOSException, EASBizException;
    public BarMaterialRelInfo getBarMaterialRelInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public BarMaterialRelInfo getBarMaterialRelInfo(String oql) throws BOSException, EASBizException;
    public BarMaterialRelCollection getBarMaterialRelCollection() throws BOSException;
    public BarMaterialRelCollection getBarMaterialRelCollection(EntityViewInfo view) throws BOSException;
    public BarMaterialRelCollection getBarMaterialRelCollection(String oql) throws BOSException;
}