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

public interface ITheLifeFeeOfFemaleDuck extends ICoreBillBase
{
    public TheLifeFeeOfFemaleDuckCollection getTheLifeFeeOfFemaleDuckCollection() throws BOSException;
    public TheLifeFeeOfFemaleDuckCollection getTheLifeFeeOfFemaleDuckCollection(EntityViewInfo view) throws BOSException;
    public TheLifeFeeOfFemaleDuckCollection getTheLifeFeeOfFemaleDuckCollection(String oql) throws BOSException;
    public TheLifeFeeOfFemaleDuckInfo getTheLifeFeeOfFemaleDuckInfo(IObjectPK pk) throws BOSException, EASBizException;
    public TheLifeFeeOfFemaleDuckInfo getTheLifeFeeOfFemaleDuckInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public TheLifeFeeOfFemaleDuckInfo getTheLifeFeeOfFemaleDuckInfo(String oql) throws BOSException, EASBizException;
    public void audit(TheLifeFeeOfFemaleDuckInfo model) throws BOSException, EASBizException;
    public void unAudit(TheLifeFeeOfFemaleDuckInfo model) throws BOSException, EASBizException;
}