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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.util.*;

public interface IApplicationOfSocialSecurity extends ICoreBillBase
{
    public ApplicationOfSocialSecurityCollection getApplicationOfSocialSecurityCollection() throws BOSException;
    public ApplicationOfSocialSecurityCollection getApplicationOfSocialSecurityCollection(EntityViewInfo view) throws BOSException;
    public ApplicationOfSocialSecurityCollection getApplicationOfSocialSecurityCollection(String oql) throws BOSException;
    public ApplicationOfSocialSecurityInfo getApplicationOfSocialSecurityInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ApplicationOfSocialSecurityInfo getApplicationOfSocialSecurityInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ApplicationOfSocialSecurityInfo getApplicationOfSocialSecurityInfo(String oql) throws BOSException, EASBizException;
    public void audit(ApplicationOfSocialSecurityInfo model) throws BOSException, EASBizException;
    public void unAudit(ApplicationOfSocialSecurityInfo model) throws BOSException, EASBizException;
    public void setSIStatus(ApplicationOfSocialSecurityInfo model) throws BOSException;
}