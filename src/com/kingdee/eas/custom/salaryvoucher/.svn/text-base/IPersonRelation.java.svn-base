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

public interface IPersonRelation extends IDataBase
{
    public PersonRelationInfo getPersonRelationInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PersonRelationInfo getPersonRelationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PersonRelationInfo getPersonRelationInfo(String oql) throws BOSException, EASBizException;
    public PersonRelationCollection getPersonRelationCollection() throws BOSException;
    public PersonRelationCollection getPersonRelationCollection(EntityViewInfo view) throws BOSException;
    public PersonRelationCollection getPersonRelationCollection(String oql) throws BOSException;
    public void audit(PersonRelationInfo model) throws BOSException;
    public void unAudit(PersonRelationInfo model) throws BOSException;
}