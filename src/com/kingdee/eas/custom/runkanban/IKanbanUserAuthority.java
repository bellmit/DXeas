package com.kingdee.eas.custom.runkanban;

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

public interface IKanbanUserAuthority extends ICoreBillBase
{
    public KanbanUserAuthorityCollection getKanbanUserAuthorityCollection() throws BOSException;
    public KanbanUserAuthorityCollection getKanbanUserAuthorityCollection(EntityViewInfo view) throws BOSException;
    public KanbanUserAuthorityCollection getKanbanUserAuthorityCollection(String oql) throws BOSException;
    public KanbanUserAuthorityInfo getKanbanUserAuthorityInfo(IObjectPK pk) throws BOSException, EASBizException;
    public KanbanUserAuthorityInfo getKanbanUserAuthorityInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public KanbanUserAuthorityInfo getKanbanUserAuthorityInfo(String oql) throws BOSException, EASBizException;
}