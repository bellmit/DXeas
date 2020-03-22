package com.kingdee.eas.WSInterface.basedataFacade;

import java.util.Enumeration;
import java.util.List;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.BOSObjectFactory;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.metadata.access.MetaDataAccessFactory;
import com.kingdee.bos.metadata.access.entity.EntitySelect;
import com.kingdee.bos.metadata.access.entity.SimpleEntity;
import com.kingdee.bos.metadata.access.entity.SimpleProperty;
import com.kingdee.bos.metadata.access.entity.SimplePropertyCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SelectorItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.eas.WSInterface.common.DataInfoCache;
import com.kingdee.eas.WSInterface.common.MultiLangUtils;
import com.kingdee.eas.base.permission.IUser;
import com.kingdee.eas.base.permission.UserCollection;
import com.kingdee.eas.base.permission.UserFactory;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.CurrencyInfo;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.IMultiMeasureUnit;
import com.kingdee.eas.basedata.master.material.MaterialCollection;
import com.kingdee.eas.basedata.master.material.MaterialCompanyInfoCollection;
import com.kingdee.eas.basedata.master.material.MaterialCompanyInfoFactory;
import com.kingdee.eas.basedata.master.material.MaterialCompanyInfoInfo;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitCollection;
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitFactory;
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.IOrgUnitRelation;
import com.kingdee.eas.basedata.org.OrgUnitCollection;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgUnitRelationFactory;
import com.kingdee.eas.basedata.scm.common.RowTypeInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.framework.CoreBillBaseInfo;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.framework.DataBaseInfo;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.eas.framework.IDataBase;

// Referenced classes of package com.kingdee.eas.wmWs.app.basedata:
//            DataInfoCache

public class WmBaselImportUtils
{

    public WmBaselImportUtils()
    {
    }

    public static List setInfoByNumber(Context ctx, CoreBaseInfo info, List errorMsg)
        throws BOSException
    {
        return setDataInfoByNumber(ctx, info, errorMsg);
    }

    public static List setDataInfoByNumber(Context ctx, CoreBaseInfo info, List errorMsg)
        throws BOSException
    {
        for(Enumeration keys = info.keys(); keys.hasMoreElements();)
        {
            String key = (String)keys.nextElement();
            Object obj = info.get(key);
            if(obj != null && (obj instanceof MaterialInfo))
                setMaterial(ctx, info, errorMsg, key, obj);
            else
            if(obj != null && (obj instanceof DataBaseInfo))
                setDataBaseInfo(ctx, info, errorMsg, key, obj);
            else
            if(obj != null && (obj instanceof CoreBillBaseInfo))
                setCoreBillInfo(ctx, info, errorMsg, key, obj);
            else
            if(obj != null && (obj instanceof UserInfo))
                setUserInfo(ctx, info, errorMsg, key, obj);
            else
            if(obj != null && (obj instanceof IObjectCollection))
                setCollection(ctx, errorMsg, obj);
        }

        return errorMsg;
    }

    private static String getOql(DataBaseInfo lInfo, String number)
    {
        StringBuffer sb = new StringBuffer();
        if(lInfo instanceof CurrencyInfo)
            sb.append("select id,number,name,precision where number='").append(number).append("'");
        else
        if(lInfo instanceof RowTypeInfo)
            sb.append("select id,number,name,isHasMaterialNumber,precision,destinationtype where number='").append(number).append("'");
        else
            sb.append("select id,number,name where number='").append(number).append("'");
        return sb.toString();
    }

    public static void setDataBaseInfo(Context ctx, CoreBaseInfo info, List errorMsg, String key, Object obj)
        throws BOSException
    {
        DataBaseInfo lInfo = (DataBaseInfo)obj;
        lInfo.setId(null);
        String number = lInfo.getNumber();
        if(lInfo.getId() != null || number == null || number.trim().length() <= 0)
            return;
        String mapKey = (new StringBuilder(String.valueOf(number))).append(lInfo.getClass().toString()).toString();
        if(DataInfoCache.getInstance().containsKey(mapKey))
        {
            info.put(key, DataInfoCache.getInstance().get(mapKey));
            return;
        }
        IDataBase iDataBase = (IDataBase)BOSObjectFactory.createBOSObject(ctx, lInfo.getBOSType());
        String oql = getOql(lInfo, number);
        DataBaseCollection databaseCol = iDataBase.getDataBaseCollection(oql);
        if(databaseCol != null && databaseCol.size() > 0)
        {
            lInfo = databaseCol.get(0);
            DataInfoCache.getInstance().put(mapKey, lInfo);
        } else
        {
            lInfo = null;
            errorMsg.add((new StringBuilder("\u7F16\u7801")).append(number).append(" \u4E0D\u662F\u4E00\u4E2A\u6B63\u786E\u7684 ").append(getAliasName(ctx, info, key)).append(" .").toString());
        }
        info.put(key, lInfo);
    }

    public static void setCollection(Context ctx, List errorMsg, Object obj)
        throws BOSException
    {
        IObjectCollection collection = (IObjectCollection)obj;
        for(int i = 0; i < collection.size(); i++)
        {
            CoreBaseInfo entryInfo = (CoreBaseInfo)collection.getObject(i);
            setDataInfoByNumber(ctx, entryInfo, errorMsg);
        }

    }

    public static void setCoreBillInfo(Context ctx, CoreBaseInfo info, List errorMsg, String key, Object obj)
        throws BOSException
    {
        CoreBillBaseInfo lInfo = (CoreBillBaseInfo)obj;
        if(lInfo.getId() != null)
            return;
        ICoreBillBase iCoreBillBase = (ICoreBillBase)BOSObjectFactory.createBOSObject(ctx, lInfo.getBOSType());
        String number = lInfo.getNumber();
        CoreBillBaseCollection databaseCol = iCoreBillBase.getCoreBillBaseCollection((new StringBuilder("select id,number where number='")).append(number).append("'").toString());
        if(databaseCol != null && databaseCol.size() > 0)
        {
            lInfo = databaseCol.get(0);
        } else
        {
            lInfo = null;
            errorMsg.add((new StringBuilder("\u7F16\u7801")).append(number).append(" \u4E0D\u662F\u4E00\u4E2A\u6B63\u786E\u7684 ").append(getAliasName(ctx, info, key)).append(" .").toString());
        }
        info.put(key, lInfo);
    }

    public static void setUserInfo(Context ctx, CoreBaseInfo info, List errorMsg, String key, Object obj)
        throws BOSException
    {
        UserInfo lInfo = (UserInfo)obj;
        String number = lInfo.getNumber();
        if(lInfo.getId() != null || number == null || number.trim().length() <= 0)
            return;
        String mapKey = (new StringBuilder(String.valueOf(number))).append(lInfo.getClass().toString()).toString();
        if(DataInfoCache.getInstance().containsKey(mapKey))
        {
            info.put(key, DataInfoCache.getInstance().get(mapKey));
            return;
        }
        IUser iuser = UserFactory.getLocalInstance(ctx);
        UserCollection userCol = iuser.getUserCollection((new StringBuilder("select id,number ,name where number='")).append(number).append("'").toString());
        if(userCol != null && userCol.size() > 0)
        {
            lInfo = userCol.get(0);
            DataInfoCache.getInstance().put(mapKey, lInfo);
        } else
        {
            lInfo = null;
            errorMsg.add((new StringBuilder("\u7F16\u7801")).append(number).append(" \u4E0D\u662F\u4E00\u4E2A\u6B63\u786E\u7684 ").append(getAliasName(ctx, info, key)).append(" .").toString());
        }
        info.put(key, lInfo);
    }

    public static void setMaterial(Context ctx, CoreBaseInfo info, List errorMsg, String key, Object obj)
        throws BOSException
    {
        MaterialInfo lInfo = (MaterialInfo)obj;
        String number = lInfo.getNumber();
        if(lInfo.getId() != null || number == null || number.trim().length() <= 0)
            return;
        String mapKey = (new StringBuilder(String.valueOf(number))).append(lInfo.getClass().toString()).toString();
        if(DataInfoCache.getInstance().containsKey(mapKey))
        {
            info.put(key, DataInfoCache.getInstance().get(mapKey));
            return;
        }
        EntityViewInfo viewInfo = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
        SelectorItemCollection sic = new SelectorItemCollection();
        sic.add(new SelectorItemInfo(" id"));
        sic.add(new SelectorItemInfo(" name"));
        sic.add(new SelectorItemInfo(" number"));
        sic.add(new SelectorItemInfo(" model"));
        sic.add(new SelectorItemInfo(" pricePrecision"));
        sic.add(new SelectorItemInfo(" baseunit.id"));
        sic.add(new SelectorItemInfo(" assistUnit.id"));
        sic.add(new SelectorItemInfo(" materialGroup.name"));
        filter.getFilterItems().add(new FilterItemInfo("number", number, CompareType.EQUALS));
        viewInfo.setFilter(filter);
        viewInfo.setSelector(sic);
        MaterialCollection collection = MaterialFactory.getLocalInstance(ctx).getMaterialCollection(viewInfo);
        if(collection != null && collection.size() > 0)
        {
            lInfo = collection.get(0);
            DataInfoCache.getInstance().put(mapKey, lInfo);
        } else
        {
            lInfo = null;
            errorMsg.add((new StringBuilder("\u7F16\u7801")).append(number).append(" \u4E0D\u662F\u4E00\u4E2A\u6B63\u786E\u7684 ").append(getAliasName(ctx, info, key)).append(" .").toString());
        }
        info.put(key, lInfo);
    }

    public static String getAliasName(Context ctx, CoreBaseInfo info, String key)
        throws BOSException
    {
        String aliasName = "";
        EntitySelect select = new EntitySelect(info.getBOSType());
        select.propertySelect().select(key, "alias");
        SimpleEntity entity = MetaDataAccessFactory.getLocalInstance(ctx).select(select);
        SimpleProperty propertyObject = entity.property(key);
        aliasName = propertyObject.getString("alias_l2");
        return aliasName;
    }

    public static String getResource(String key, Object params[])
    {
        String resource = "";
        return resource;
    }

    public static MultiMeasureUnitInfo getMultiMeasureUnit(Context ctx, MaterialInfo material, MeasureUnitInfo unit, List errorMsg)
        throws BOSException
    {
        MultiMeasureUnitInfo mmu = null;
        if(material != null && unit != null)
        {
            String key = (new StringBuilder(String.valueOf(material.getId().toString()))).append(unit.getId().toString()).toString();
            if(DataInfoCache.getInstance().containsKey(key))
            {
                mmu = (MultiMeasureUnitInfo)DataInfoCache.getInstance().get(key);
            } else
            {
                mmu = getMultiMeasureUnitInfo(ctx, material.getId().toString(), unit.getId().toString());
                if(mmu != null)
                    DataInfoCache.getInstance().put(key, mmu);
                else
                    errorMsg.add((new StringBuilder("\u8BA1\u91CF\u5355\u4F4D")).append(unit.getNumber()).append("\u4E0D\u5B58\u5728\u4E8E\u7269\u6599\u7684").append(material.getNumber()).append("\u591A\u8BA1\u91CF\u5355\u4F4D\u7EC4\u91CC\u9762").toString());
            }
        }
        return mmu;
    }

    private static MultiMeasureUnitInfo getMultiMeasureUnitInfo(Context ctx, String materialId, String unitId)
        throws BOSException
    {
        MultiMeasureUnitInfo mmu = null;
        IMultiMeasureUnit imultiUnit = MultiMeasureUnitFactory.getLocalInstance(ctx);
        String oql = (new StringBuilder(" select material.id, measureUnit.id, qtyPrecision,baseConvsRate where measureUnit.id ='")).append(unitId).append("' and material.id ='").append(materialId).append("'").toString();
        MultiMeasureUnitCollection mulUnits = imultiUnit.getMultiMeasureUnitCollection(oql);
        if(mulUnits != null && mulUnits.size() > 0)
            mmu = mulUnits.get(0);
        return mmu;
    }

    public static MaterialCompanyInfoInfo getMaterialCompanyInfo(Context ctx, MaterialInfo material, CompanyOrgUnitInfo cou, List errorMsg)
        throws BOSException
    {
        MaterialCompanyInfoInfo materialcompanyInfo = null;
        if(material != null && cou != null)
        {
            String key = (new StringBuilder(String.valueOf(material.getId().toString()))).append(cou.getId().toString()).toString();
            if(DataInfoCache.getInstance().containsKey(key))
            {
                materialcompanyInfo = (MaterialCompanyInfoInfo)DataInfoCache.getInstance().get(key);
            } else
            {
                materialcompanyInfo = getMaterialCompanyInfo(ctx, material.getId().toString(), cou.getId().toString());
                if(materialcompanyInfo != null)
                    DataInfoCache.getInstance().put(key, materialcompanyInfo);
            }
        }
        return materialcompanyInfo;
    }

    private static MaterialCompanyInfoInfo getMaterialCompanyInfo(Context ctx, String materialid, String couID)
        throws BOSException
    {
        MaterialCompanyInfoInfo materialcompanyInfo = null;
        EntityViewInfo viewInfo = new EntityViewInfo();
        FilterInfo filter = new FilterInfo();
        filter.getFilterItems().add(new FilterItemInfo("mateial", materialid, CompareType.EQUALS));
        filter.getFilterItems().add(new FilterItemInfo("company", couID, CompareType.EQUALS));
        viewInfo.setFilter(filter);
        SelectorItemCollection sic = new SelectorItemCollection();
        sic.add(new SelectorItemInfo("standardCost"));
        MaterialCompanyInfoCollection con = MaterialCompanyInfoFactory.getLocalInstance(ctx).getMaterialCompanyInfoCollection(viewInfo);
        if(con != null && con.size() >= 1)
            materialcompanyInfo = con.get(0);
        return materialcompanyInfo;
    }

    public static CompanyOrgUnitInfo getCompanyInfo(Context ctx, OrgUnitInfo orgInfo, int orgType)
        throws BOSException, EASBizException
    {
        CompanyOrgUnitInfo couInfo = null;
        if(orgInfo == null)
            return null;
        IOrgUnitRelation iOrgRelation = OrgUnitRelationFactory.getLocalInstance(ctx);
        OrgUnitCollection orgCollection = iOrgRelation.getToUnit(orgInfo.getId().toString(), orgType, 1);
        if(orgCollection != null && orgCollection.size() > 0)
            couInfo = (CompanyOrgUnitInfo)orgCollection.get(0);
        return couInfo;
    }

    public static void getbillMetas(Context ctx, String bosType)
    {
        SimplePropertyCollection properties = MultiLangUtils.getAllProperties(ctx, BOSObjectType.create(bosType));
        for(int i = 0; i < properties.size(); i++)
        {
            SimpleProperty sp = properties.get(i);
            String sline = (new StringBuilder(String.valueOf(sp.getName()))).append("; ").append(sp.getAlias()).append("; ").append(sp.getString("description")).toString();
            if(sp.isOwnProperty())
                sline = (new StringBuilder(String.valueOf(sline))).append("; ").append(sp.getDataType().getJavaTypeName()).toString();
            else
                sline = (new StringBuilder(String.valueOf(sline))).append("; ").append(sp.getRefTypeInfo()).toString();
            System.out.println(sline);
        }

    }

    public static void outputBillMetas(Context ctx)
    {
        System.out.println("com.kingdee.eas.scm.sm.pur.app.PurOrder");
        getbillMetas(ctx, "3171BFAD");
        System.out.println("com.kingdee.eas.scm.sm.pur.app.PurOrderEntry");
        getbillMetas(ctx, "26041CC5");
        System.out.println("com.kingdee.eas.scm.sm.pur.app.PurOrderExpenseEntry");
        getbillMetas(ctx, "D414BF47");
        System.out.println("PurRequest");
        getbillMetas(ctx, "25428F2E");
        System.out.println("PurRequestEntry");
        getbillMetas(ctx, "2B7DD5E4");
        System.out.println("PurRequestEntryML");
        getbillMetas(ctx, "435FF683");
        System.out.println("SaleOrder");
        getbillMetas(ctx, "C48A423A");
        System.out.println("SaleOrderEntry");
        getbillMetas(ctx, "88882A58");
        System.out.println("TransferOrderBill");
        getbillMetas(ctx, "5C2A1F0C");
        System.out.println("TransferOrderBillEntry");
        getbillMetas(ctx, "ACCB80C6");
        System.out.println("StockTransferBill");
        getbillMetas(ctx, "2239F30A");
        System.out.println("StockTransferBillEntry");
        getbillMetas(ctx, "18167B88");
        System.out.println("PurInWarehsBill");
        getbillMetas(ctx, "783061E3");
        System.out.println("PurInWarehsEntry");
        getbillMetas(ctx, "8E088616");
        System.out.println("SaleIssueBill");
        getbillMetas(ctx, "CC3E933B");
        System.out.println("SaleIssueEntry");
        getbillMetas(ctx, "BBC07FBE");
        System.out.println("OtherInWarehsBill");
        getbillMetas(ctx, "A4D04D23");
        System.out.println("OtherInWarehsBillEntry");
        getbillMetas(ctx, "F56602D6");
        System.out.println("OtherIssueBill");
        getbillMetas(ctx, "A4D04D24");
        System.out.println("OtherIssueBillEntry");
        getbillMetas(ctx, "F56602D7");
        System.out.println("com.kingdee.eas.fi.ar.OtherBill");
        getbillMetas(ctx, "FC910EF3");
        System.out.println("com.kingdee.eas.fi.ar.app.OtherBillPlan");
        getbillMetas(ctx, "1EE05CBC");
        System.out.println("com.kingdee.eas.fi.ar.app.OtherBillentry");
        getbillMetas(ctx, "BC91693F");
        System.out.println("com.kingdee.eas.fi.ap.app.OtherBill");
        getbillMetas(ctx, "48DA3A71");
        System.out.println("com.kingdee.eas.fi.ap.app.OtherBillExpApportion");
        getbillMetas(ctx, "87E4684C");
        System.out.println("com.kingdee.eas.fi.ap.app.OtherBillPlan");
        getbillMetas(ctx, "838B993A");
        System.out.println("com.kingdee.eas.fi.ap.app.OtherBillentry");
        getbillMetas(ctx, "ED4DBC81");
    }
}
