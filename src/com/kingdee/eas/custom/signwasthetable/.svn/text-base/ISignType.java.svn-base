package com.kingdee.eas.custom.signwasthetable;

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

public interface ISignType extends IDataBase
{
    public SignTypeInfo getSignTypeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public SignTypeInfo getSignTypeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public SignTypeInfo getSignTypeInfo(String oql) throws BOSException, EASBizException;
    public SignTypeCollection getSignTypeCollection() throws BOSException;
    public SignTypeCollection getSignTypeCollection(EntityViewInfo view) throws BOSException;
    public SignTypeCollection getSignTypeCollection(String oql) throws BOSException;
    public void audit(SignTypeInfo model) throws BOSException, EASBizException;
    public void unAudit(SignTypeInfo model) throws BOSException, EASBizException;
}