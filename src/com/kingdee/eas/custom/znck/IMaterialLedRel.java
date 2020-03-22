package com.kingdee.eas.custom.znck;

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

public interface IMaterialLedRel extends ICoreBillBase
{
    public MaterialLedRelCollection getMaterialLedRelCollection() throws BOSException;
    public MaterialLedRelCollection getMaterialLedRelCollection(EntityViewInfo view) throws BOSException;
    public MaterialLedRelCollection getMaterialLedRelCollection(String oql) throws BOSException;
    public MaterialLedRelInfo getMaterialLedRelInfo(IObjectPK pk) throws BOSException, EASBizException;
    public MaterialLedRelInfo getMaterialLedRelInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public MaterialLedRelInfo getMaterialLedRelInfo(String oql) throws BOSException, EASBizException;
}