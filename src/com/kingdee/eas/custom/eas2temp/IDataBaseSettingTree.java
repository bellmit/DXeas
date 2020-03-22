package com.kingdee.eas.custom.eas2temp;

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

public interface IDataBaseSettingTree extends ITreeBase
{
    public DataBaseSettingTreeInfo getDataBaseSettingTreeInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DataBaseSettingTreeInfo getDataBaseSettingTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DataBaseSettingTreeInfo getDataBaseSettingTreeInfo(String oql) throws BOSException, EASBizException;
    public DataBaseSettingTreeCollection getDataBaseSettingTreeCollection() throws BOSException;
    public DataBaseSettingTreeCollection getDataBaseSettingTreeCollection(EntityViewInfo view) throws BOSException;
    public DataBaseSettingTreeCollection getDataBaseSettingTreeCollection(String oql) throws BOSException;
}