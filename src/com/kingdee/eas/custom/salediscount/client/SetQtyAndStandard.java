/**
 * output package name
 */
package com.kingdee.eas.custom.salediscount.client;

import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;

import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.eas.basedata.master.material.MaterialGroupInfo;
import com.kingdee.eas.basedata.master.material.client.MaterialGroupPromptBox;
import com.kingdee.eas.custom.salediscount.DiscountSetEntryInfo;

/**
 * output class name
 */
public class SetQtyAndStandard extends AbstractSetQtyAndStandard
{
    private static final Logger logger = CoreUIObject.getLogger(SetQtyAndStandard.class);
    
    /**
     * output class constructor
     */
    public SetQtyAndStandard() throws Exception
    {
        super();
        
     // 物料分类f7
		MaterialGroupPromptBox groupBox = new MaterialGroupPromptBox(this);
//	    KDBizPromptBox bizMaterialGroupBox = new KDBizPromptBox();
	    prmtMaterialGroup.setEditFormat("$number$");
	    prmtMaterialGroup.setDisplayFormat("$name$");
	    prmtMaterialGroup.setCommitFormat("$number$");
	    prmtMaterialGroup.setSelector(groupBox);
    }

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

    /**
     * output actionOnLoad_actionPerformed
     */
    public void actionOnLoad_actionPerformed(ActionEvent e) throws Exception
    {
        super.actionOnLoad_actionPerformed(e);
    }

	/**
	 * 关闭
	 */
	protected void btnClose_actionPerformed(ActionEvent e) throws Exception {
		this.uiWindow.close();
	}

	/**
	 * 确认
	 */
	protected void btnConfirm_actionPerformed(ActionEvent e) throws Exception {
		DiscountSetEntryInfo entryInfo = new DiscountSetEntryInfo();
		entryInfo.setQty1(this.ftfQty1.getBigDecimalValue());
		entryInfo.setQty2(this.ftfQty2.getBigDecimalValue());
		entryInfo.setStandard1(this.ftfStandard1.getBigDecimalValue());
		entryInfo.setStandard2(this.ftfStandard2.getBigDecimalValue());
		
		entryInfo.setSwQty1(this.ftfSwQty1.getBigDecimalValue());
		entryInfo.setSwQty2(this.ftfSwQty2.getBigDecimalValue());
		entryInfo.setSwStandard1(this.ftfSwStandard1.getBigDecimalValue()==null?-1:this.ftfSwStandard1.getBigDecimalValue().intValue());
		entryInfo.setSwStandard2(this.ftfSwStandard2.getBigDecimalValue()==null?-1:this.ftfSwStandard2.getBigDecimalValue().intValue());
		
		
		entryInfo.setQty3(this.ftfQty3.getBigDecimalValue());
		entryInfo.setStandard3(this.ftfStandard3.getBigDecimalValue());
		entryInfo.setSwQty3(this.ftfSwQty3.getBigDecimalValue());
		entryInfo.setSwStandard3(this.ftfSwStandard3.getBigDecimalValue()==null?-1:this.ftfSwStandard3.getBigDecimalValue().intValue());
		
		entryInfo.setQty4(this.ftfQty4.getBigDecimalValue());
		entryInfo.setStandard4(this.ftfStandard4.getBigDecimalValue());
		entryInfo.setSwQty4(this.ftfSwQty4.getBigDecimalValue());
		entryInfo.setSwStandard4(this.ftfSwStandard4.getBigDecimalValue()==null?-1:this.ftfSwStandard4.getBigDecimalValue().intValue());
		
		entryInfo.setQty5(this.ftfQty5.getBigDecimalValue());
		entryInfo.setStandard5(this.ftfStandard5.getBigDecimalValue());
		entryInfo.setSwQty5(this.ftfSwQty5.getBigDecimalValue());
		entryInfo.setSwStandard5(this.ftfSwStandard5.getBigDecimalValue()==null?-1:this.ftfSwStandard5.getBigDecimalValue().intValue());
		
		
		entryInfo.setAccumulaMaterialGroup((MaterialGroupInfo) this.prmtMaterialGroup.getValue());
		
		this.getUIContext().put("entryInfo", entryInfo);
	    this.getUIWindow().close();
	}

    
}