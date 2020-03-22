package com.kingdee.eas.custom.wages.farm;

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

public interface IWagesFarmOrganTree extends ITreeBase
{
    public WagesFarmOrganTreeInfo getWagesFarmOrganTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public WagesFarmOrganTreeInfo getWagesFarmOrganTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public WagesFarmOrganTreeInfo getWagesFarmOrganTreeInfo(String oql) throws BOSException, EASBizException;
    public WagesFarmOrganTreeCollection getWagesFarmOrganTreeCollection() throws BOSException;
    public WagesFarmOrganTreeCollection getWagesFarmOrganTreeCollection(EntityViewInfo view) throws BOSException;
    public WagesFarmOrganTreeCollection getWagesFarmOrganTreeCollection(String oql) throws BOSException;
}