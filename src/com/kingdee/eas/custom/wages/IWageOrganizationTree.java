package com.kingdee.eas.custom.wages;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IWageOrganizationTree extends ITreeBase
{
    public WageOrganizationTreeInfo getWageOrganizationTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WageOrganizationTreeInfo getWageOrganizationTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WageOrganizationTreeInfo getWageOrganizationTreeInfo(String oql) throws BOSException, EASBizException;
    public WageOrganizationTreeCollection getWageOrganizationTreeCollection() throws BOSException;
    public WageOrganizationTreeCollection getWageOrganizationTreeCollection(EntityViewInfo view) throws BOSException;
    public WageOrganizationTreeCollection getWageOrganizationTreeCollection(String oql) throws BOSException;
}