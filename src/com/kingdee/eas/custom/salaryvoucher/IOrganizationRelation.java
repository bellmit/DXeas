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

public interface IOrganizationRelation extends IDataBase
{
    public OrganizationRelationInfo getOrganizationRelationInfo(IObjectPK pk) throws BOSException, EASBizException;
    public OrganizationRelationInfo getOrganizationRelationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public OrganizationRelationInfo getOrganizationRelationInfo(String oql) throws BOSException, EASBizException;
    public OrganizationRelationCollection getOrganizationRelationCollection() throws BOSException;
    public OrganizationRelationCollection getOrganizationRelationCollection(EntityViewInfo view) throws BOSException;
    public OrganizationRelationCollection getOrganizationRelationCollection(String oql) throws BOSException;
}