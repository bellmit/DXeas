package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEmploySecurityEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractEmploySecurityEntryInfo()
    {
        this("id");
    }
    protected AbstractEmploySecurityEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.custom.wages.EmploySecurityInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.EmploySecurityInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.EmploySecurityInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s �籣���property 
     */
    public String getSbbh()
    {
        return getString("sbbh");
    }
    public void setSbbh(String item)
    {
        setString("sbbh", item);
    }
    /**
     * Object:��¼'s �α��·�property 
     */
    public String getCbyf()
    {
        return getString("cbyf");
    }
    public void setCbyf(String item)
    {
        setString("cbyf", item);
    }
    /**
     * Object:��¼'s ���֤��property 
     */
    public String getCard()
    {
        return getString("card");
    }
    public void setCard(String item)
    {
        setString("card", item);
    }
    /**
     * Object:��¼'s �ɷѻ���property 
     */
    public String getJfjs()
    {
        return getString("jfjs");
    }
    public void setJfjs(String item)
    {
        setString("jfjs", item);
    }
    /**
     * Object:��¼'s �ɷ��·�property 
     */
    public String getJfyf()
    {
        return getString("jfyf");
    }
    public void setJfyf(String item)
    {
        setString("jfyf", item);
    }
    /**
     * Object:��¼'s ������λ����property 
     */
    public String getSydwbl()
    {
        return getString("sydwbl");
    }
    public void setSydwbl(String item)
    {
        setString("sydwbl", item);
    }
    /**
     * Object:��¼'s ���ϵ�λ����property 
     */
    public String getYldwbl()
    {
        return getString("yldwbl");
    }
    public void setYldwbl(String item)
    {
        setString("yldwbl", item);
    }
    /**
     * Object:��¼'s ҽ�Ƶ�λ����property 
     */
    public String getYiliaodwbl()
    {
        return getString("yiliaodwbl");
    }
    public void setYiliaodwbl(String item)
    {
        setString("yiliaodwbl", item);
    }
    /**
     * Object:��¼'s ���˵�λ����property 
     */
    public String getGrdwbl()
    {
        return getString("grdwbl");
    }
    public void setGrdwbl(String item)
    {
        setString("grdwbl", item);
    }
    /**
     * Object:��¼'s ���˵�λ����property 
     */
    public String getGsdwbl()
    {
        return getString("gsdwbl");
    }
    public void setGsdwbl(String item)
    {
        setString("gsdwbl", item);
    }
    /**
     * Object:��¼'s ʧҵ��λ����property 
     */
    public String getShiyedwbl()
    {
        return getString("shiyedwbl");
    }
    public void setShiyedwbl(String item)
    {
        setString("shiyedwbl", item);
    }
    /**
     * Object:��¼'s ���˴��ҽ��property 
     */
    public String getGrdeyl()
    {
        return getString("grdeyl");
    }
    public void setGrdeyl(String item)
    {
        setString("grdeyl", item);
    }
    /**
     * Object:��¼'s ��λ���ҽ��property 
     */
    public String getDwdeyl()
    {
        return getString("dwdeyl");
    }
    public void setDwdeyl(String item)
    {
        setString("dwdeyl", item);
    }
    /**
     * Object:��¼'s ���˲�����������property 
     */
    public String getGrbjwnyl()
    {
        return getString("grbjwnyl");
    }
    public void setGrbjwnyl(String item)
    {
        setString("grbjwnyl", item);
    }
    /**
     * Object:��¼'s ��λԤ����property 
     */
    public String getDwyjf()
    {
        return getString("dwyjf");
    }
    public void setDwyjf(String item)
    {
        setString("dwyjf", item);
    }
    /**
     * Object:��¼'s ����Ԥ����property 
     */
    public String getGryjf()
    {
        return getString("gryjf");
    }
    public void setGryjf(String item)
    {
        setString("gryjf", item);
    }
    /**
     * Object:��¼'s ��λ����property 
     */
    public String getDwjn()
    {
        return getString("dwjn");
    }
    public void setDwjn(String item)
    {
        setString("dwjn", item);
    }
    /**
     * Object:��¼'s ʧҵ���˱���property 
     */
    public String getSygrbl()
    {
        return getString("sygrbl");
    }
    public void setSygrbl(String item)
    {
        setString("sygrbl", item);
    }
    /**
     * Object:��¼'s ���ϸ��˱���property 
     */
    public String getYlgrbl()
    {
        return getString("ylgrbl");
    }
    public void setYlgrbl(String item)
    {
        setString("ylgrbl", item);
    }
    /**
     * Object:��¼'s ����property 
     */
    public String getDepartment()
    {
        return getString("department");
    }
    public void setDepartment(String item)
    {
        setString("department", item);
    }
    /**
     * Object:��¼'s ��λproperty 
     */
    public String getPost()
    {
        return getString("post");
    }
    public void setPost(String item)
    {
        setString("post", item);
    }
    /**
     * Object:��¼'s ��ͬ����ʱ��property 
     */
    public String getHtdqsj()
    {
        return getString("htdqsj");
    }
    public void setHtdqsj(String item)
    {
        setString("htdqsj", item);
    }
    /**
     * Object:��¼'s ��ͬ��ʼʱ��property 
     */
    public String getHtkssj()
    {
        return getString("htkssj");
    }
    public void setHtkssj(String item)
    {
        setString("htkssj", item);
    }
    /**
     * Object: ��¼ 's Ա������ property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object:��¼'s Ա������property 
     */
    public String getPersonnumber()
    {
        return getString("personnumber");
    }
    public void setPersonnumber(String item)
    {
        setString("personnumber", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("77D8211C");
    }
}