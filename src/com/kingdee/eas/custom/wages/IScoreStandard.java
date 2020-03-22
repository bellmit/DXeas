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

public interface IScoreStandard extends IDataBase
{
    public ScoreStandardInfo getScoreStandardInfo(IObjectPK pk) throws BOSException, EASBizException;
    public ScoreStandardInfo getScoreStandardInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public ScoreStandardInfo getScoreStandardInfo(String oql) throws BOSException, EASBizException;
    public ScoreStandardCollection getScoreStandardCollection() throws BOSException;
    public ScoreStandardCollection getScoreStandardCollection(EntityViewInfo view) throws BOSException;
    public ScoreStandardCollection getScoreStandardCollection(String oql) throws BOSException;
    public void approve(ScoreStandardInfo model) throws BOSException;
    public void unApprove(ScoreStandardInfo model) throws BOSException;
}