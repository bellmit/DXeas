package com.kingdee.eas.farm.carnivorous.basedata;

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

public interface IPersonFarmerRangeTree extends ITreeBase
{
    public PersonFarmerRangeTreeInfo getPersonFarmerRangeTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public PersonFarmerRangeTreeInfo getPersonFarmerRangeTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public PersonFarmerRangeTreeInfo getPersonFarmerRangeTreeInfo(String oql) throws BOSException, EASBizException;
    public PersonFarmerRangeTreeCollection getPersonFarmerRangeTreeCollection() throws BOSException;
    public PersonFarmerRangeTreeCollection getPersonFarmerRangeTreeCollection(EntityViewInfo view) throws BOSException;
    public PersonFarmerRangeTreeCollection getPersonFarmerRangeTreeCollection(String oql) throws BOSException;
}