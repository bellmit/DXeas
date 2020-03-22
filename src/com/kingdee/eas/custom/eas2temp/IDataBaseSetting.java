package com.kingdee.eas.custom.eas2temp;

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

public interface IDataBaseSetting extends IDataBase
{
    public DataBaseSettingInfo getDataBaseSettingInfo(IObjectPK pk) throws BOSException, EASBizException;
    public DataBaseSettingInfo getDataBaseSettingInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException;
    public DataBaseSettingInfo getDataBaseSettingInfo(String oql) throws BOSException, EASBizException;
    public DataBaseSettingCollection getDataBaseSettingCollection() throws BOSException;
    public DataBaseSettingCollection getDataBaseSettingCollection(EntityViewInfo view) throws BOSException;
    public DataBaseSettingCollection getDataBaseSettingCollection(String oql) throws BOSException;
    public void importMaterial(DataBaseSettingInfo model) throws BOSException;
    public void bakmaterial(DataBaseSettingInfo model) throws BOSException;
}