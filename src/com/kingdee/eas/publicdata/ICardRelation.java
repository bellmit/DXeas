package com.kingdee.eas.publicdata;

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

public interface ICardRelation extends IDataBase
{
    public CardRelationInfo getCardRelationInfo(IObjectPK pk) throws BOSException, EASBizException;
    public CardRelationInfo getCardRelationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public CardRelationInfo getCardRelationInfo(String oql) throws BOSException, EASBizException;
    public CardRelationCollection getCardRelationCollection() throws BOSException;
    public CardRelationCollection getCardRelationCollection(EntityViewInfo view) throws BOSException;
    public CardRelationCollection getCardRelationCollection(String oql) throws BOSException;
}