package com.kingdee.eas.farm.stocking.processbizill;

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

public interface ITransBirdsBill extends ICoreBillBase
{
    public TransBirdsBillCollection getTransBirdsBillCollection() throws BOSException;
    public TransBirdsBillCollection getTransBirdsBillCollection(EntityViewInfo view) throws BOSException;
    public TransBirdsBillCollection getTransBirdsBillCollection(String oql) throws BOSException;
    public TransBirdsBillInfo getTransBirdsBillInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TransBirdsBillInfo getTransBirdsBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TransBirdsBillInfo getTransBirdsBillInfo(String oql) throws BOSException, EASBizException;
    public void audit(TransBirdsBillInfo model) throws BOSException;
    public void unAudit(TransBirdsBillInfo model) throws BOSException;
}