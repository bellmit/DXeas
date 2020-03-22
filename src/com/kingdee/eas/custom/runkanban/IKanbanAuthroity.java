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
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IKanbanAuthroity extends IDataBase
{
    public KanbanAuthroityInfo getKanbanAuthroityInfo(IObjectPK pk) throws BOSException, EASBizException;
    public KanbanAuthroityInfo getKanbanAuthroityInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public KanbanAuthroityInfo getKanbanAuthroityInfo(String oql) throws BOSException, EASBizException;
    public KanbanAuthroityCollection getKanbanAuthroityCollection() throws BOSException;
    public KanbanAuthroityCollection getKanbanAuthroityCollection(EntityViewInfo view) throws BOSException;
    public KanbanAuthroityCollection getKanbanAuthroityCollection(String oql) throws BOSException;
}