package com.kingdee.eas.custom.wages;

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

public interface IWageOrganization extends IDataBase
{
    public WageOrganizationInfo getWageOrganizationInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WageOrganizationInfo getWageOrganizationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WageOrganizationInfo getWageOrganizationInfo(String oql) throws BOSException, EASBizException;
    public WageOrganizationCollection getWageOrganizationCollection() throws BOSException;
    public WageOrganizationCollection getWageOrganizationCollection(EntityViewInfo view) throws BOSException;
    public WageOrganizationCollection getWageOrganizationCollection(String oql) throws BOSException;
}