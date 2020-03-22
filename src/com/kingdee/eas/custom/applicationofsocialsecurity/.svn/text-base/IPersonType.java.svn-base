package com.kingdee.eas.custom.applicationofsocialsecurity;

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

public interface IPersonType extends IDataBase
{
    public PersonTypeInfo getPersonTypeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PersonTypeInfo getPersonTypeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PersonTypeInfo getPersonTypeInfo(String oql) throws BOSException, EASBizException;
    public PersonTypeCollection getPersonTypeCollection() throws BOSException;
    public PersonTypeCollection getPersonTypeCollection(EntityViewInfo view) throws BOSException;
    public PersonTypeCollection getPersonTypeCollection(String oql) throws BOSException;
    public void audit(PersonTypeInfo model) throws BOSException;
    public void unAudit(PersonTypeInfo model) throws BOSException;
}