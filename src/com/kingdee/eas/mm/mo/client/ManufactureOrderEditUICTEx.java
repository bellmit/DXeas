package com.kingdee.eas.mm.mo.client;

import com.kingdee.bos.metadata.bot.BOTRelationCollection;

public class ManufactureOrderEditUICTEx extends ManufactureOrderEditUI {

	public ManufactureOrderEditUICTEx() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		if(this.getUIContext().containsKey("isTempMMPlanBill")) {
			this.setOprtState("EDIT");
		}
		super.onLoad();
		if(this.getUIContext().containsKey("isTempMMPlanBill")) {
			if(this.getUIContext().get("BOM")!=null) {
				this.prmtbom.setValue(this.getUIContext().get("BOM"));
			}
			/*this.txtqty.setValue(this.getUIContext().get("qty"));
			this.txtorderQty.setValue(this.getUIContext().get("qty"));
			txtdeliveryQty.setValue(this.getUIContext().get("qty"));*/
			this.setMakeRelations((BOTRelationCollection) this.getUIContext().get("relation"));
		}
		
	}
}
