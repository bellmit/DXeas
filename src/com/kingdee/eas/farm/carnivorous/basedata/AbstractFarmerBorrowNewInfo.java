package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmerBorrowNewInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFarmerBorrowNewInfo()
    {
        this("id");
    }
    protected AbstractFarmerBorrowNewInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:养殖户借款单's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: 养殖户借款单 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:养殖户借款单's 单据状态property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object: 养殖户借款单 's 借款项目 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BrowerItemNewInfo getBrowerItem()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BrowerItemNewInfo)get("browerItem");
    }
    public void setBrowerItem(com.kingdee.eas.farm.carnivorous.basedata.BrowerItemNewInfo item)
    {
        put("browerItem", item);
    }
    /**
     * Object: 养殖户借款单 's 养殖户 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo getFarmer()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object:养殖户借款单's 金额property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:养殖户借款单's 业务类型property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.isBorrow getIsBorrow()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.isBorrow.getEnum(getString("isBorrow"));
    }
    public void setIsBorrow(com.kingdee.eas.farm.carnivorous.basedata.isBorrow item)
    {
		if (item != null) {
        setString("isBorrow", item.getValue());
		}
    }
    /**
     * Object: 养殖户借款单 's 地区 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeInfo getFarmerTree()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeInfo)get("farmerTree");
    }
    public void setFarmerTree(com.kingdee.eas.farm.carnivorous.basedata.FarmerTreeInfo item)
    {
        put("farmerTree", item);
    }
    /**
     * Object:养殖户借款单's 银行卡号property 
     */
    public String getAccountNum()
    {
        return getString("accountNum");
    }
    public void setAccountNum(String item)
    {
        setString("accountNum", item);
    }
    /**
     * Object:养殖户借款单's 备注property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object:养殖户借款单's 单批还款金额property 
     */
    public java.math.BigDecimal getOneBatch()
    {
        return getBigDecimal("oneBatch");
    }
    public void setOneBatch(java.math.BigDecimal item)
    {
        setBigDecimal("oneBatch", item);
    }
    /**
     * Object: 养殖户借款单 's 批次合同 property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo getBatchContract()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo)get("batchContract");
    }
    public void setBatchContract(com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo item)
    {
        put("batchContract", item);
    }
    /**
     * Object: 养殖户借款单 's 养殖场 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.carnivorous.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object:养殖户借款单's 是否生成凭证property 
     */
    public boolean isIsVoucher()
    {
        return getBoolean("isVoucher");
    }
    public void setIsVoucher(boolean item)
    {
        setBoolean("isVoucher", item);
    }
    /**
     * Object: 养殖户借款单 's 凭证 property 
     */
    public com.kingdee.eas.fi.gl.VoucherInfo getVoucher()
    {
        return (com.kingdee.eas.fi.gl.VoucherInfo)get("voucher");
    }
    public void setVoucher(com.kingdee.eas.fi.gl.VoucherInfo item)
    {
        put("voucher", item);
    }
    /**
     * Object:养殖户借款单's 是否代还property 
     */
    public boolean isIsRe()
    {
        return getBoolean("isRe");
    }
    public void setIsRe(boolean item)
    {
        setBoolean("isRe", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A6258D66");
    }
}