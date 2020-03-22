package com.kingdee.eas.farm.stocking.basedata;

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

public interface IPersonFarmerRelationTree extends ITreeBase
{
    public PersonFarmerRelationTreeInfo getPersonFarmerRelationTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PersonFarmerRelationTreeInfo getPersonFarmerRelationTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PersonFarmerRelationTreeInfo getPersonFarmerRelationTreeInfo(String oql) throws BOSException, EASBizException;
    public PersonFarmerRelationTreeCollection getPersonFarmerRelationTreeCollection() throws BOSException;
    public PersonFarmerRelationTreeCollection getPersonFarmerRelationTreeCollection(EntityViewInfo view) throws BOSException;
    public PersonFarmerRelationTreeCollection getPersonFarmerRelationTreeCollection(String oql) throws BOSException;
}