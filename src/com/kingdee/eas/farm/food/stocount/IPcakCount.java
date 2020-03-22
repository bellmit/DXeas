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

public interface IPcakCount extends ICoreBillBase
{
    public PcakCountCollection getPcakCountCollection() throws BOSException;
    public PcakCountCollection getPcakCountCollection(EntityViewInfo view) throws BOSException;
    public PcakCountCollection getPcakCountCollection(String oql) throws BOSException;
    public PcakCountInfo getPcakCountInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PcakCountInfo getPcakCountInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PcakCountInfo getPcakCountInfo(String oql) throws BOSException, EASBizException;
    public void audit(PcakCountInfo model) throws BOSException;
    public void unaudit(PcakCountInfo model) throws BOSException;
}