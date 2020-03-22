/**
 * output package name
 */
package com.kingdee.eas.custom.lhsm.client;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.extendcontrols.BizDataFormat;
import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTDefaultCellEditor;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditListener;
import com.kingdee.bos.ctrl.kdf.util.render.ObjectValueRender;
import com.kingdee.bos.ctrl.kdf.util.style.Styles;
import com.kingdee.bos.ctrl.swing.KDFormattedTextField;
import com.kingdee.bos.ctrl.swing.KDFrame;
import com.kingdee.bos.ctrl.swing.KDTextArea;
import com.kingdee.bos.ctrl.swing.KDWorkButton;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.metadata.bot.BOTRelationFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemCollection;
import com.kingdee.bos.metadata.entity.SorterItemInfo;
import com.kingdee.bos.metadata.query.util.CompareType;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.base.permission.client.longtime.ILongTimeTask;
import com.kingdee.eas.base.permission.client.longtime.LongTimeDialog;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.assistant.PaymentTypeFactory;
import com.kingdee.eas.basedata.assistant.PaymentTypeInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerFactory;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MaterialSalesCollection;
import com.kingdee.eas.basedata.master.material.MaterialSalesFactory;
import com.kingdee.eas.basedata.master.material.MaterialSalesInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitCollection;
import com.kingdee.eas.basedata.org.CompanyOrgUnitFactory;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.org.OrgType;
import com.kingdee.eas.basedata.org.OrgUnitInfo;
import com.kingdee.eas.basedata.org.SaleOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.client.f7.CompanyF7;
import com.kingdee.eas.basedata.person.IPerson;
import com.kingdee.eas.basedata.person.PersonFactory;
import com.kingdee.eas.basedata.person.PersonInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseFactory;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import com.kingdee.eas.basedata.scm.sd.sale.SaleGroupFactory;
import com.kingdee.eas.basedata.scm.sd.sale.SaleGroupInfo;
import com.kingdee.eas.basedata.scm.sd.sale.SalePersonInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.commld.ClientUtils;
import com.kingdee.eas.custom.commld.ListenerUtil;
import com.kingdee.eas.custom.commld.UIUtil;
import com.kingdee.eas.custom.commld.commUtils;
import com.kingdee.eas.custom.lhsm.ForecastEnum;
import com.kingdee.eas.custom.lhsm.ForecastOrderFacadeFactory;
import com.kingdee.eas.custom.lhsm.SaleForecastEntryInfo;
import com.kingdee.eas.fi.ar.OtherBillFactory;
import com.kingdee.eas.fi.ar.OtherBillInfo;
import com.kingdee.eas.fi.cas.ReceivingBillFactory;
import com.kingdee.eas.fi.cas.ReceivingBillInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.client.multiDetail.DetailPanel;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.scm.common.client.SCMClientHelper;
import com.kingdee.eas.scm.common.client.SCMClientUtils;
import com.kingdee.eas.scm.common.util.F7ContextManager;
import com.kingdee.eas.scm.im.inv.SaleIssueBillFactory;
import com.kingdee.eas.scm.im.inv.SaleIssueBillInfo;
import com.kingdee.eas.scm.sm.pur.util.PurUtil;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.excel.ExcelReadUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.IPropertyContainer;

/**
 * output class name
 */
public class SaleForecastEditUI extends AbstractSaleForecastEditUI
{
	private static final Logger logger = CoreUIObject.getLogger(SaleForecastEditUI.class);
	//protected F7ContextManager f7Manager = null;
	private static final BigDecimal ZERO = new BigDecimal("0.00");
	private static final BigDecimal ONE = new BigDecimal("1.00");
	String orgID;
	private F7ContextManager f7Manager;
	private OrgUnitInfo orgInfo = null;//库存组织
	/**
	 * output class constructor
	 */
	public SaleForecastEditUI() throws Exception
	{
		super();
		Dimension dd = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension((int)(dd.getWidth()*0.8),(int)(dd.getHeight()*0.8)));
	}

	public void onLoad() throws Exception {

		orgID = SysContext.getSysContext().getCurrentFIUnit().getId().toString();
		super.onLoad();
		String curStorageOrgUnitID="1231";
		if(SysContext.getSysContext().getCurrentStorageUnit()!=null) {
			curStorageOrgUnitID=SysContext.getSysContext().getCurrentStorageUnit().getString("id");
		}
		orgInfo = StorageOrgUnitFactory.getRemoteInstance().getOrgUnitInfo(new ObjectUuidPK(curStorageOrgUnitID));
		f7Manager = new F7ContextManager(this, OrgType.Storage);
		chkMenuItemSubmitAndAddNew.setSelected(false);
		initcontrol();
		initAction();
		//		setSalePersonF7();
		setFilter();
	}
	
	
	//分录新增按钮
	private void addTableQuerySearchPanel(final KDTable table) {
		KDWorkButton jb=new KDWorkButton("EXCEL导入");
		jb.setBounds(152,0,100, 27);
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					getExcelMassage();
				} catch (BOSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});

		JPanel controlPanel = (JPanel) table.getParent().getParent();
		if(controlPanel instanceof DetailPanel ){
			for(int index=0;index<controlPanel.getComponentCount();index++) {
				if(controlPanel.getComponent(index).getName().equalsIgnoreCase("controlPanel")) {
					JPanel  d = (JPanel )controlPanel.getComponent(index);
					Rectangle rect = table.getBounds();
					int x = rect.width - (jb.getWidth() + 86 + 30);
					d.add(jb,new com.kingdee.bos.ctrl.swing.KDLayout.Constraints(x-215, 5, jb.getWidth(), 19, 9));
					break;
				}
			}
		}
	}
	
	//导入excel文件至单据分录
	private void getExcelMassage() throws BOSException{
		Map<Integer,Map<Integer,Object>> excelValues = ExcelReadUtil.getExcelData();
		if(excelValues != null && excelValues.size() > 0){
			queryData(excelValues);
		}
	}
	
	private void queryData(final Map<Integer, Map<Integer, Object>> excelValues) {
		// TODO Auto-generated method stub
		LongTimeDialog dialog = new LongTimeDialog( (Frame) SwingUtilities.getWindowAncestor(this)); 
		dialog.setLongTimeTask(new ILongTimeTask() {
			public Object exec() throws Exception { 
				Object result = "12345"; 
				CompanyOrgUnitCollection companyll;
				companyll = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitCollection("where id='"+((IPropertyContainer)prmtsaleOrgUnit.getValue()).getString("id")+"'");
				WarehouseInfo hoseinfo = WarehouseFactory.getRemoteInstance().getWarehouseInfo(new ObjectUuidPK("EDLeiBK3SEuFiwDKxs5Curvp+K4="));
				if(excelValues != null){
					MaterialInfo info  = new MaterialInfo();
					MeasureUnitInfo minfo = new MeasureUnitInfo();
					//BasicPostInfo b = new BasicPostInfo();
					IMaterial iMaterial = MaterialFactory.getRemoteInstance();
					CoreBaseCollection coll = null;
					int size = excelValues.size();
					if(size > 0){
						kdtEntrys.removeRows();
					}
					for(int i = 1; i <= size; i++){
						Map<Integer,Object> rowValues = new HashMap<Integer, Object>(); 
						rowValues = excelValues.get(i);
						if(rowValues.values() == null) continue;
						IRow row = null;
						String personid = "";
						boolean begin = true;
						for (Integer in : rowValues.keySet()) {
							//map.keySet()返回的是所有key的值
//							if(in == 1){
//								continue;
//							}
							Object obj = rowValues.get(in);//得到每个key对应value的值
							if(begin&&rowValues.get(2)!=null){
								row = kdtEntrys.addRow();
								begin = false;
							}
							switch(in){
							case 1://物料编码
								if(obj != null){
									try {
										coll = iMaterial.getCollection("where number='" + UIRuleUtil.getString(obj) + "'");
										if(coll.size() > 0){
											row.getCell(in).setValue((MaterialInfo)coll.get(0));
											row.getCell(in+1).setValue(((MaterialInfo)coll.get(0)).getString("name"));
											MaterialInfo minfos = (MaterialInfo)coll.get(0);
											row.getCell(in+3).setValue(hoseinfo);
											MeasureUnitInfo meaba = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK(minfos.getBaseUnit().getId().toString()));
											MeasureUnitInfo meaass = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK(minfos.getAssistUnit().getId().toString()));

											row.getCell(in+4).setValue(meaba);
											row.getCell(in+5).setValue(meaba);
											row.getCell(in+7).setValue(meaass);
											row.getCell(in+20).setValue(companyll.size()>0 ? companyll.get(0) : null);

										}
									} catch (BOSException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
								}
								break;
							case 2:
								
								break;
							case 3:
								if(obj != null){
									row.getCell(in).setValue(obj);
								}
								break;	
							
							}	
						}
					}
				}
				return result; 
			} 

			public void afterExec(Object result) throws Exception {
				MsgBox.showInfo("导入完成");
			} 
		}); 
		Component[] cps=dialog.getContentPane().getComponents(); 
		for(Component cp:cps){ 
			if(cp instanceof JLabel){ 
				((JLabel) cp).setText("数据导入中..."); 
			} 
		} 
		dialog.show(); 
	}
	@Override
	public void onShow() throws Exception {
		// TODO Auto-generated method stub
		super.onShow();
		
		getDetailTable().getColumn("qty").getStyleAttributes().setNumberFormat("0.##");
		getDetailTable().getColumn("price").getStyleAttributes().setNumberFormat("0.##");
		getDetailTable().getColumn("basePrice").getStyleAttributes().setNumberFormat("0.##");
		getDetailTable().getColumn("qtya").getStyleAttributes().setNumberFormat("0.##");
		getDetailTable().getColumn("qtyb").getStyleAttributes().setNumberFormat("0.##");
	}

	public void initcontrol(){

		CompanyF7 cf7=new CompanyF7();
		this.prmtcompany.setSelector(cf7);

//		btnUnAudit.setVisible(false);

		this.prmtcompany.setEnabled(true);
		this.prmtsaleOrgUnit.setEnabled(true);

		f7Manager.registerBizMaterialF7( (KDBizPromptBox) this.kdtEntrys.getColumn("materialNumber").getEditor().getComponent(), null, null, orgInfo,false);
		f7Manager.registerMeasureUnitF7(kdtEntrys, "materialNumber", "measureUnit");

		f7Manager.registerBizCustomerF7(prmtcustomer, null, null, orgInfo);
		contsaleCustomer.setBoundLabelText("结账客户");

		((KDBizPromptBox)kdtEntrys.getColumn("company").getEditor().getComponent()).setSelector(cf7);

		this.prmtcustomer.setQueryInfo("com.kingdee.eas.basedata.master.cssp.app.F7CustomerSaleQuery");		
		this.prmtcustomer.setEditable(true);		
		this.prmtcustomer.setDisplayFormat("$name$");		
		this.prmtcustomer.setEditFormat("$number$");		
		this.prmtcustomer.setCommitFormat("$name$;$mnemonicCode$");		
		this.prmtcustomer.setRequired(true);

		KDBizPromptBox kdtEntrys_materialNumber_PromptBox = new KDBizPromptBox();
		kdtEntrys_materialNumber_PromptBox.setQueryInfo("com.kingdee.eas.basedata.master.material.app.F7MaterialGroupQuery");
		kdtEntrys_materialNumber_PromptBox.setVisible(true);
		kdtEntrys_materialNumber_PromptBox.setEditable(true);
		kdtEntrys_materialNumber_PromptBox.setDisplayFormat("$name$");
		kdtEntrys_materialNumber_PromptBox.setEditFormat("$name$");
		kdtEntrys_materialNumber_PromptBox.setCommitFormat("$name$");
		KDTDefaultCellEditor kdtEntrys_materialNumber_CellEditor = new KDTDefaultCellEditor(kdtEntrys_materialNumber_PromptBox);
		this.kdtEntrys.getColumn("materialGroup").setEditor(kdtEntrys_materialNumber_CellEditor);
		ObjectValueRender kdtEntrys_materialNumber_OVR = new ObjectValueRender();
		kdtEntrys_materialNumber_OVR.setFormat(new BizDataFormat("$name$"));
		this.kdtEntrys.getColumn("materialGroup").setRenderer(kdtEntrys_materialNumber_OVR);

		KDFormattedTextField kdtEntrys_qty_TextField = new KDFormattedTextField();
		kdtEntrys_qty_TextField.setName("kdtEntrys_qty_TextField");
		kdtEntrys_qty_TextField.setVisible(true);
		kdtEntrys_qty_TextField.setEditable(true);
		kdtEntrys_qty_TextField.setHorizontalAlignment(2);
		kdtEntrys_qty_TextField.setDataType(1);
		kdtEntrys_qty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
		kdtEntrys_qty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
		kdtEntrys_qty_TextField.setPrecision(2);
		KDTDefaultCellEditor kdtEntrys_qty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qty_TextField);
		this.kdtEntrys.getColumn("qty").setEditor(kdtEntrys_qty_CellEditor);
		KDFormattedTextField kdtEntrys_price_TextField = new KDFormattedTextField();
		kdtEntrys_price_TextField.setName("kdtEntrys_price_TextField");
		kdtEntrys_price_TextField.setVisible(true);
		kdtEntrys_price_TextField.setEditable(true);
		kdtEntrys_price_TextField.setHorizontalAlignment(2);
		kdtEntrys_price_TextField.setDataType(1);
		kdtEntrys_price_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
		kdtEntrys_price_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
		kdtEntrys_price_TextField.setPrecision(2);
		KDTDefaultCellEditor kdtEntrys_price_CellEditor = new KDTDefaultCellEditor(kdtEntrys_price_TextField);
		this.kdtEntrys.getColumn("price").setEditor(kdtEntrys_price_CellEditor);
		KDFormattedTextField kdtEntrys_basePrice_TextField = new KDFormattedTextField();
		kdtEntrys_basePrice_TextField.setName("kdtEntrys_basePrice_TextField");
		kdtEntrys_basePrice_TextField.setVisible(true);
		kdtEntrys_basePrice_TextField.setEditable(true);
		kdtEntrys_basePrice_TextField.setHorizontalAlignment(2);
		kdtEntrys_basePrice_TextField.setDataType(1);
		kdtEntrys_basePrice_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
		kdtEntrys_basePrice_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
		kdtEntrys_basePrice_TextField.setPrecision(2);
		KDTDefaultCellEditor kdtEntrys_basePrice_CellEditor = new KDTDefaultCellEditor(kdtEntrys_basePrice_TextField);
		this.kdtEntrys.getColumn("basePrice").setEditor(kdtEntrys_basePrice_CellEditor);
		KDFormattedTextField kdtEntrys_baseQty_TextField = new KDFormattedTextField();
		kdtEntrys_baseQty_TextField.setName("kdtEntrys_baseQty_TextField");
		kdtEntrys_baseQty_TextField.setVisible(true);
		kdtEntrys_baseQty_TextField.setEditable(true);
		kdtEntrys_baseQty_TextField.setHorizontalAlignment(2);
		kdtEntrys_baseQty_TextField.setDataType(1);
		kdtEntrys_baseQty_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
		kdtEntrys_baseQty_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
		kdtEntrys_baseQty_TextField.setPrecision(2);
		KDTDefaultCellEditor kdtEntrys_baseQty_CellEditor = new KDTDefaultCellEditor(kdtEntrys_baseQty_TextField);
		this.kdtEntrys.getColumn("baseQty").setEditor(kdtEntrys_baseQty_CellEditor);
		KDFormattedTextField kdtEntrys_amount_TextField = new KDFormattedTextField();
		kdtEntrys_amount_TextField.setName("kdtEntrys_amount_TextField");
		kdtEntrys_amount_TextField.setVisible(true);
		kdtEntrys_amount_TextField.setEditable(true);
		kdtEntrys_amount_TextField.setHorizontalAlignment(2);
		kdtEntrys_amount_TextField.setDataType(1);
		kdtEntrys_amount_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
		kdtEntrys_amount_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
		kdtEntrys_amount_TextField.setPrecision(2);
		KDTDefaultCellEditor kdtEntrys_amount_CellEditor = new KDTDefaultCellEditor(kdtEntrys_amount_TextField);
		this.kdtEntrys.getColumn("amount").setEditor(kdtEntrys_amount_CellEditor);
		KDFormattedTextField kdtEntrys_qtya_TextField = new KDFormattedTextField();
		kdtEntrys_qtya_TextField.setName("kdtEntrys_qtya_TextField");
		kdtEntrys_qtya_TextField.setVisible(true);
		kdtEntrys_qtya_TextField.setEditable(true);
		kdtEntrys_qtya_TextField.setHorizontalAlignment(2);
		kdtEntrys_qtya_TextField.setDataType(1);
		kdtEntrys_qtya_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
		kdtEntrys_qtya_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
		kdtEntrys_qtya_TextField.setPrecision(2);
		KDTDefaultCellEditor kdtEntrys_qtya_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qtya_TextField);
		this.kdtEntrys.getColumn("qtya").setEditor(kdtEntrys_qtya_CellEditor);
		KDFormattedTextField kdtEntrys_qtyb_TextField = new KDFormattedTextField();
		kdtEntrys_qtyb_TextField.setName("kdtEntrys_qtyb_TextField");
		kdtEntrys_qtyb_TextField.setVisible(true);
		kdtEntrys_qtyb_TextField.setEditable(true);
		kdtEntrys_qtyb_TextField.setHorizontalAlignment(2);
		kdtEntrys_qtyb_TextField.setDataType(1);
		kdtEntrys_qtyb_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
		kdtEntrys_qtyb_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
		kdtEntrys_qtyb_TextField.setPrecision(2);
		KDTDefaultCellEditor kdtEntrys_qtyb_CellEditor = new KDTDefaultCellEditor(kdtEntrys_qtyb_TextField);
		this.kdtEntrys.getColumn("qtyb").setEditor(kdtEntrys_qtyb_CellEditor);

		KDFormattedTextField kdtEntrys_internalCost_TextField = new KDFormattedTextField();
		kdtEntrys_internalCost_TextField.setName("kdtEntrys_internalCost_TextField");
		kdtEntrys_internalCost_TextField.setVisible(true);
		kdtEntrys_internalCost_TextField.setEditable(true);
		kdtEntrys_internalCost_TextField.setHorizontalAlignment(2);
		kdtEntrys_internalCost_TextField.setDataType(1);
		kdtEntrys_internalCost_TextField.setMinimumValue(new java.math.BigDecimal("-1.0E18"));
		kdtEntrys_internalCost_TextField.setMaximumValue(new java.math.BigDecimal("1.0E18"));
		kdtEntrys_internalCost_TextField.setPrecision(2);
		KDTDefaultCellEditor kdtEntrys_internalCost_CellEditor = new KDTDefaultCellEditor(kdtEntrys_internalCost_TextField);
		this.kdtEntrys.getColumn("internalCost").setEditor(kdtEntrys_internalCost_CellEditor);


		btnAudit.setIcon(ClientUtils.AuditIcon);
		btnUnAudit.setIcon(ClientUtils.UnAuditIcon);
		contLastUpdateTime.setVisible(true);
		contAuditor.setVisible(true);
		contauditTime.setVisible(true);
		contCreateTime.setVisible(true);
		contCreator.setVisible(true);
		contLastUpdateUser.setVisible(true);
		getDetailTable().getColumn("baseQty").getStyleAttributes().setHided(true);
		getDetailTable().getColumn("baseUnit").getStyleAttributes().setHided(true);
		getDetailTable().getColumn("assistUnitQty").getStyleAttributes().setLocked(false);
		
		UIUtil.setQualityPhaseDisplayFormat(new KDTable[]{getDetailTable()}, Styles.HorizontalAlignment.RIGHT);


		if(oprtState.equals("ADDNEW")){
			IRow row = kdtEntrys.addRow();
			row.getCell("company").setValue(SysContext.getSysContext().getCurrentFIUnit());
		}


		btnProgressView.registerKeyboardAction(new ActionListener(){

			public void actionPerformed(ActionEvent paramActionEvent) {
				// TODO Auto-generated method stub
				detailMouseClickGetQtyAndNewPrice();
			}}, KeyStroke.getKeyStroke(KeyEvent.VK_F6,0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		
		
		KDBizPromptBox prmtMaterial = (KDBizPromptBox) kdtEntrys.getColumn("materialNumber").getEditor().getComponent(); // 人员F7  
	    EntityViewInfo view1 = new EntityViewInfo(); // 新定义视图  
	    SorterItemCollection sc = new SorterItemCollection();
	    SorterItemInfo sii = new SorterItemInfo("name");
	    sii.setSortType(com.kingdee.bos.metadata.data.SortType.DESCEND);
	    sc.add(sii);
	    view1.setSorter(sc);
	    prmtMaterial.setEntityViewInfo(view1); // 重新设定视图  
	}
	public void initAction()throws  Exception {

		kdtEntrys_detailPanel.getAddNewLineButton().addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				// 新增的分录行默认带上表头销售组织
				if(UIRuleUtil.isNotNull(prmtsaleOrgUnit.getValue())){
					CompanyOrgUnitCollection coll;
					try {
						coll = CompanyOrgUnitFactory.getRemoteInstance().getCompanyOrgUnitCollection("where id='"+((IPropertyContainer)prmtsaleOrgUnit.getValue()).getString("id")+"'");
						kdtEntrys.getCell(kdtEntrys.getRowCount()-1, "company").setValue(coll.size()>0 ? coll.get(0) : null);
					} catch (BOSException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}});

		kdtEntrys_detailPanel.getInsertLineButton().addMouseListener(new MouseAdapter(){

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				// 新增的分录行默认带上表头销售组织
				if(UIRuleUtil.isNotNull(prmtsaleOrgUnit.getValue())){
					CompanyOrgUnitCollection coll;
				}
			}});

		kdtEntrys.addKDTEditListener(new KDTEditAdapter() {
			public void editStopped(KDTEditEvent e) {
				try {
					kdtEntrys_Changed(e.getRowIndex(),e.getColIndex());
				}
				catch (Exception exc) {
					handUIException(exc);
				}
			}
		});
		this.prmtsalePerson.addDataChangeListener( new DataChangeListener() {
			public void dataChanged(DataChangeEvent e){
				try{
					prmtSalePerson_dataChanged(e);
				}catch(Exception exc){
					handUIException(exc);
				}
			}
		});
		prmtcompany.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent paramDataChangeEvent) {
				// TODO Auto-generated method stub
				if(prmtcompany.getValue() != null){
					String id = ((IPropertyContainer)prmtcompany.getValue()).getString("id");
					try {
						prmtsaleOrgUnit.setValue(SaleOrgUnitFactory.getRemoteInstance().getSaleOrgUnitInfo(new ObjectUuidPK(id)));
					} catch (EASBizException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BOSException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}});
		this.prmtsaleGroup.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				try {
					prmtsaleGroup_Changed();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		prmtsaleOrgUnit.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				setFilter();
			}});

		this.prmtcustomer.addDataChangeListener(new DataChangeListener(){
			public void dataChanged(DataChangeEvent arg0) {
				// TODO Auto-generated method stub
				try {
					prmtOrderCustomer_Changed();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//			
		});


		this.kdtEntrys.getColumn("qty").getStyleAttributes().setNumberFormat("%r{#,##0.0000}f");
		this.kdtEntrys.getColumn("qtya").getStyleAttributes().setNumberFormat("%r{#,##0.0000}f");
		this.kdtEntrys.getColumn("qtyb").getStyleAttributes().setNumberFormat("%r{#,##0.0000}f");
		this.kdtEntrys.getColumn("baseQty").getStyleAttributes().setNumberFormat("%r{#,##0.0000}f");
		this.kdtEntrys.getColumn("price").getStyleAttributes().setNumberFormat("%r{#,##0.000000}f");
		this.kdtEntrys.getColumn("basePrice").getStyleAttributes().setNumberFormat("%r{#,##0.000000}f");
		//this.f7Manager = new F7ContextManager(this, getMainBizOrgType());

		StringBuffer sql=new StringBuffer();

		/* Set materialsID = new LinkedHashSet();
		sql=new StringBuffer();
		sql.append(" select fnumber,cforgidid fid from ct_czc_ssorglist  where cfstatus=1  ");
		IRowSet rs=SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
		while(rs.next()){
			String  companyid=rs.getString("fid");
			materialsID.add(companyid);
		}*/

		// 销售组F7
		FilterInfo filterInfo=new FilterInfo();
		//		filterInfo.getFilterItems().add(new FilterItemInfo("saleOrg.id",materialsID,CompareType.INCLUDE));//默认诸城
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filterInfo);

		this.prmtsaleGroup.setQueryInfo("com.kingdee.eas.basedata.scm.sd.sale.app.F7SaleGroupQuery");		
		this.prmtsaleGroup.setEditable(true);		
		this.prmtsaleGroup.setDisplayFormat("$name$");		
		this.prmtsaleGroup.setEditFormat("$number$");		
		this.prmtsaleGroup.setCommitFormat("$number$");		
		this.prmtsaleGroup.setVisible(true);		
		this.prmtsaleGroup.setEnabled(true);		
		this.prmtsaleGroup.setForeground(new java.awt.Color(0,0,0));		
		this.prmtsaleGroup.setRequired(false);
		prmtsaleGroup.setEntityViewInfo(evi);


		// 销售员 
		this.prmtsalePerson.setQueryInfo("com.kingdee.eas.custom.lhsm.app.F7SalePersonQuery");		
		//this.prmtsalePerson.setQueryInfo("com.kingdee.eas.basedata.scm.sd.sale.app.F7SalePersonQuery");		
		this.prmtsalePerson.setCommitFormat("$person.number$");		
		this.prmtsalePerson.setEditFormat("$number$");		
		this.prmtsalePerson.setDisplayFormat("$name$");		
		this.prmtsalePerson.setEditable(true);		
		this.prmtsalePerson.setRequired(true);
		evi = new EntityViewInfo();
		filterInfo = new FilterInfo();


		String personID = "";
		if(SysContext.getSysContext().getCurrentUserInfo().getPerson()!=null) {
			personID=SysContext.getSysContext().getCurrentUserInfo().getPerson().getString("id");
		}
		String cuID = SysContext.getSysContext().getCurrentCtrlUnit().getString("id");
		StringBuffer sb = new StringBuffer();
		sb.append("/*dialect*/select t2.FDescription_l2 description,t1.FPersonID,t6.FID saleGroupID,t3.FID salePersonID  from ").append("\n");
		sb.append("T_ORG_PositionMember       t1").append("\n");
		sb.append("inner join T_ORG_Position  t2 on t2.FID=t1.FPositionID").append("\n");
		sb.append("inner join T_ORG_Admin     t4 on t4.FID=t2.FAdminOrgUnitID").append("\n");
		sb.append("inner join T_ORG_CtrlUnit  t5 on t5.FID is not null").append("\n");
		sb.append("      and t4.FLongNumber like t5.FLongNumber||'%'").append("\n");
		sb.append("left  join T_BD_SalePerson t3 on t3.FPersonID=t1.FPersonID").append("\n");
		sb.append("left  join T_BD_SaleGroup  t6 on t6.FID=t3.FSaleGroupID ").append("\n");
		sb.append("where t1.FPersonID='").append(personID).append("' and t5.FID='").append(cuID).append("' and t6.FSaleOrgID=t5.FID \n");
		IRowSet rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
		if(rs.next()){
			if(StringUtils.isEmpty(rs.getString("description")) && StringUtils.isEmpty(rs.getString("FPersonID"))){
				commUtils.giveUserTipsAndRetire("当前用户既不是销售员,也不是销管");
			}else{
				if(StringUtils.isNotEmpty(rs.getString("salePersonID"))){
					if(oprtState.equals("ADDNEW") && StringUtils.isNotBlank(rs.getString("saleGroupID"))){
						prmtsalePerson.setValue(PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(rs.getString("FPersonID"))));
						prmtsaleGroup.setValue(SaleGroupFactory.getRemoteInstance().getSaleGroupInfo(new ObjectUuidPK(rs.getString("saleGroupID"))));
					}
					prmtsaleGroup.setEnabled(false);
					prmtsalePerson.setEnabled(false);
				}else{
//					String split = rs.getString("description").replace(";", "','");
//					split = "('"+split+"')";
//					sb.setLength(0);
//					sb.append("select t1.FPersonID  from ").append("\n");
//					sb.append("T_ORG_PositionMember       t1").append("\n");
//					sb.append("inner join T_ORG_Position  t2 on t2.FID=t1.FPositionID").append("\n");
//					sb.append("inner join T_ORG_Admin     t4 on t4.FID=t2.FAdminOrgUnitID").append("\n");
//					sb.append("inner join T_ORG_CtrlUnit  t5 on t5.FID is not null").append("\n");
//					sb.append("      and t4.FLongNumber like concat(t5.FLongNumber,'%')").append("\n");
//					sb.append("inner join T_BD_SalePerson t3 on t3.FPersonID=t1.FPersonID").append("\n");
//					sb.append(" where t2.FNumber in ").append(split);
//
//
//					rs = SQLExecutorFactory.getRemoteInstance(sb.toString()).executeSQL();
//					HashSet<String> set =new HashSet<String>();
//					set.add("123");
//					while(rs.next()){
//						set.add(rs.getString("FPersonID"));
//					}
					evi = new EntityViewInfo();
					FilterInfo filter = new FilterInfo();
					filter.getFilterItems().add(new FilterItemInfo("saleOrg.id",SysContext.getSysContext().getCurrentSaleUnit().getString("id"),CompareType.EQUALS));
					evi.setFilter(filter );
					prmtsalePerson.setEntityViewInfo(evi);
				}
			}
		}else{
			FilterInfo filter = new FilterInfo();
			filter.getFilterItems().add(new FilterItemInfo("saleOrg.id",SysContext.getSysContext().getCurrentSaleUnit().getString("id"),CompareType.EQUALS));
			evi.setFilter(filter );
			prmtsalePerson.setEntityViewInfo(evi);
		}





		prmtcompany.setEntityViewInfo(evi);

	}

	private void setFilter() {
		String saleOrgUnitID = "13312";
		if(prmtsaleOrgUnit.getValue()!=null) {
			saleOrgUnitID=((IPropertyContainer) prmtsaleOrgUnit.getValue()).getString("id");
		}

		// 销售组F7
		FilterInfo filterInfo=new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("saleOrg.id",saleOrgUnitID,CompareType.EQUALS));//默认诸城
		EntityViewInfo evi=new EntityViewInfo();
		evi.setFilter(filterInfo);
		prmtsaleGroup.setEntityViewInfo(evi);


		KDBizPromptBox KDBizPromptBox = (KDBizPromptBox)kdtEntrys.getColumn("wareHouse").getEditor().getComponent();
		evi = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		filter.getFilterItems().add(new FilterItemInfo("STORAGEORG.NAME",SysContext.getSysContext().getCurrentStorageUnit().getName(),CompareType.EQUALS));
		evi.setFilter(filter );
		KDBizPromptBox.setEntityViewInfo(evi);
	}
	public void prmtsaleGroup_Changed()throws Exception {
		//		if(this.prmtsaleGroup.getValue()!=null){
		//			SaleGroupInfo salegroup=(SaleGroupInfo)this.prmtsaleGroup.getValue();
		//			FilterInfo filterInfo=new FilterInfo();
		//			//filterInfo.getFilterItems().add(new FilterItemInfo("saleOrg.id","JRQpNwEcEADgAJCkwKgHBMznrtQ=",CompareType.EQUALS));//默认为诸城
		//			filterInfo.getFilterItems().add(new FilterItemInfo("saleGroup.id",salegroup.getId().toString(),CompareType.EQUALS));
		//			//filterInfo.setMaskString("#0 or #1");
		//			EntityViewInfo evi=new EntityViewInfo();
		//			evi.setFilter(filterInfo);
		//			prmtsalePerson.setEntityViewInfo(evi);
		//		}
	}
	protected void prmtSalePerson_dataChanged(DataChangeEvent e){
		if(!(prmtsalePerson.getData() instanceof SalePersonInfo))
			return;
		try
		{
			SalePersonInfo salePersonInfo = (SalePersonInfo)prmtsalePerson.getData();
			SCMClientHelper scmClientHelper = new SCMClientHelper(this);
			scmClientHelper.initSalePersonDisplay(prmtsalePerson);
			IPerson iPerson = PersonFactory.getRemoteInstance();

			PersonInfo aPersonInfo = (PersonInfo)prmtsalePerson.getData();
			SaleGroupInfo aSaleGroupInfo=null;
			PersonInfo personinfo = null;
			if(salePersonInfo != null){
				aSaleGroupInfo = salePersonInfo.getSaleGroup();
				if(aSaleGroupInfo != null){
					aSaleGroupInfo = SaleGroupFactory.getRemoteInstance().getSaleGroupInfo(new ObjectUuidPK(aSaleGroupInfo.getId().toString()));
					prmtsaleGroup.setValue(aSaleGroupInfo);
				}
			}

		}catch(BOSException e1){
			handUIException(e1);
		}catch(EASBizException e1){
			handUIException(e1);
		}
	}
	public void prmtOrderCustomer_Changed()throws Exception {
		String FCUID;
		FCUID= SysContext.getSysContext().getCurrentCtrlUnit().getId().toString();
		this.txtlinkman.setText("");
		this.txtlinkmanTel.setText("");
		this.txtsendAddress.setText("");
		if(this.prmtcustomer.getData()!=null){
			CustomerInfo info = (CustomerInfo) this.prmtcustomer.getData();
			if (info.getId().toString() != null && info.getId().toString() != "") {
				StringBuffer sql=new StringBuffer();
				sql=new StringBuffer();
				sql.append("Select FBillingOrgUnitID,isnull(t3.fcontactperson,'') fcontactperson,isnull(t3.fmobile,'') fmobile,t6.FPersonID,t7.FSaleGroupID,"); 
				//				sql.append(" isnull(t4.faddress_l2,'') faddress ");
				sql.append(" isnull(t5.FName_l2,'') faddress ");
				sql.append(" from T_BD_CustomerSaleInfo t1 ");
				sql.append(" inner join t_BD_Customer t2 on t2.FID=t1.FCustomerID ");
				sql.append(" left join t_bd_customerlinkman t3 on t3.fcustomersaleid=t1.fid ");
				sql.append(" left join t_bd_customerdlvaddress t4 on t4.fcustomersaleinfoid=t1.fid ");
				sql.append(" left join T_BD_Province           t5 on t2.FProvince=t5.fid ");
				
				sql.append(" left join T_BD_CustomerSaler       t6 on t1.Fid=t6.FCustomerSaleID ");
				sql.append(" left join T_BD_SalePerson       t7 on t7.FPersonID=t6.FPersonID ");
				
				sql.append(" where t1.FControlUnitID='" + FCUID + "' ");
				sql.append(" and t2.FID='" + info.getId().toString() + "'");
				IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();

				if (rs.next()) {
					this.txtlinkman.setText(rs.getString("fcontactperson"));
					this.txtlinkmanTel.setText(rs.getString("fmobile"));
					this.txtsendAddress.setText(rs.getString("faddress"));
					if(StringUtils.isNotEmpty(rs.getString("FBillingOrgUnitID"))){
						CustomerInfo customerInfo = CustomerFactory.getRemoteInstance().getCustomerInfo(new ObjectUuidPK(rs.getString("FBillingOrgUnitID")));
						prmtsaleCustomer.setValue(customerInfo);
					}
					if(StringUtils.isNotEmpty(rs.getString("FPersonID"))){
						PersonInfo personInfo = PersonFactory.getRemoteInstance().getPersonInfo(new ObjectUuidPK(rs.getString("FPersonID")));
						prmtsalePerson.setValue(personInfo);
					}
					if(StringUtils.isNotEmpty(rs.getString("FSaleGroupID"))){
						SaleGroupInfo saleGroupInfo = SaleGroupFactory.getRemoteInstance().getSaleGroupInfo(new ObjectUuidPK(rs.getString("FSaleGroupID")));
						prmtsaleGroup.setValue(saleGroupInfo);
					}
				}
				
				
				
				
			}
		}
	}
	public void kdtEntrys_Changed(int rowIndex, int colIndex) throws Exception {
		String cuid = SysContext.getSysContext().getCurrentCtrlUnit().getId().toString();
		if(kdtEntrys.getCell(rowIndex, "materialNumber").getValue()== null){
			return;
		}
		String fieldName = kdtEntrys.getColumnKey(colIndex);
		if("materialNumber".equalsIgnoreCase(fieldName)){
			if(kdtEntrys.getCell(rowIndex, "materialNumber").getValue() != null){
				MaterialInfo materinfo = (MaterialInfo)kdtEntrys.getCell(rowIndex, "materialNumber").getValue();
				SelectorItemCollection slor = new SelectorItemCollection();
				slor.add("*");
				slor.add("materialGroup.*");
				slor.add("assistUnit.*");

				materinfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(materinfo.getId().toString()),slor );
				if(materinfo.getAssistUnit() == null || materinfo.getAssistUnit().getId() == null){
					kdtEntrys.getRow(rowIndex).getCell("materialNumber").setValue(null);
					kdtEntrys.getRow(rowIndex).getCell("materialName").setValue(null);
					MsgBox.showInfo("该物料的辅助计量单位为空");
					return;
				}

				IRowSet rs = SQLExecutorFactory.getRemoteInstance("select FDefaultWarehouseID from T_BD_MaterialInventory where FOrgUnit='"+cuid+"' and FMaterialID='"+materinfo.getString("id")+"' and FDefaultWarehouseID is not null").executeSQL();
				if(rs.next()){
					kdtEntrys.getCell(rowIndex, "wareHouse").setValue(WarehouseFactory.getRemoteInstance().getWarehouseInfo(new ObjectUuidPK(rs.getString("FDefaultWarehouseID"))));
				}

				ObjectUuidPK objectUuidpk = new ObjectUuidPK(materinfo.getId());
				FilterInfo filterinfo = new FilterInfo();
				filterinfo.getFilterItems().add(new FilterItemInfo("CU.id", cuid));
				filterinfo.getFilterItems().add(new FilterItemInfo("material.id", materinfo.getId()));
				filterinfo.setMaskString("#0 and #1");
				EntityViewInfo evi = new EntityViewInfo();

				StringBuffer sql = new StringBuffer();
				sql.append("select t4.FID from T_BD_Material  t1").append("\n");
				sql.append("inner join T_BD_MaterialGroupDetial t2 on t1.FID=t2.FMaterialID").append("\n");
				sql.append("inner join T_BD_MaterialGroupStandard t3 on t3.FID=t2.FMaterialGroupStandardID").append("\n");
				sql.append("inner join T_BD_MaterialGroup         t4 on t4.FID=t2.FMaterialGroupID").append("\n");
				sql.append("where t1.fid ='").append(materinfo.getString("id")).append("' and t3.FNumber in ('price','PRICE')").append("\n");
				rs = SQLExecutorFactory.getRemoteInstance(sql.toString()).executeSQL();
				if(rs.next()){
					kdtEntrys.getRow(rowIndex).getCell("materialGroupB").setValue(MaterialGroupFactory.getRemoteInstance().getMaterialGroupInfo(new ObjectUuidPK(rs.getString("fid"))));
				}

				evi.setFilter(filterinfo);
				kdtEntrys.getRow(rowIndex).getCell("materialGroup").setValue(materinfo.getMaterialGroup());
				//规格单位
				kdtEntrys.getRow(rowIndex).getCell("model").setValue(materinfo.getModel());
				MaterialSalesCollection mInvc = MaterialSalesFactory.getRemoteInstance().getMaterialSalesCollection(evi);
				if (mInvc.size() > 0) {
					MaterialSalesInfo materialInvInfo = (MaterialSalesInfo) mInvc.get(0);
					objectUuidpk = new ObjectUuidPK(materialInvInfo.getUnit().getId().toString());
					MeasureUnitInfo unitinfo = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(objectUuidpk);
					kdtEntrys.getRow(rowIndex).getCell("measureUnit").setValue(unitinfo);

					objectUuidpk = new ObjectUuidPK(materinfo.getBaseUnit().getId());
					unitinfo = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(objectUuidpk);
					kdtEntrys.getRow(rowIndex).getCell("baseUnit").setValue(unitinfo);
					kdtEntrys.getRow(rowIndex).getCell("materialName").setValue(materinfo.getName());
					if(materinfo.getAssistUnit()!=null && materinfo.getAssistUnit().getId()!=null){
						unitinfo = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK(materinfo.getAssistUnit().getId().toString()));
						kdtEntrys.getRow(rowIndex).getCell("assistUnit").setValue(unitinfo);
					}
					calPremiumAndSettlePrice(rowIndex,true);
				}else{
					kdtEntrys.getRow(rowIndex).getCell("materialNumber").setValue(null);
					kdtEntrys.getRow(rowIndex).getCell("materialName").setValue(null);
					MsgBox.showInfo(PurUtil.getUIResource("ORDERENTRY_STORAGEORGNOTINMATERIAL"));
					return;
				}
			}
		}else if("qty".equalsIgnoreCase(fieldName)){
			if(kdtEntrys.getCell(rowIndex, "qty").getValue() != null){
				calEntryBaseQtyByQty(rowIndex,colIndex,kdtEntrys);
				calEntryAmount(rowIndex,colIndex,kdtEntrys);
				calTotalmount();
			}
		}else if("assistUnitQty".equalsIgnoreCase(fieldName)){
			if(kdtEntrys.getCell(rowIndex, "assistUnitQty").getValue() != null){
				if(kdtEntrys.getCell(rowIndex, "assistUnit").getValue() != null){
					String measureID = ((IPropertyContainer)kdtEntrys.getCell(rowIndex, "assistUnit").getValue()).getString("id");
					SelectorItemCollection slor = new SelectorItemCollection();
					slor.add("*");
					MeasureUnitInfo unitInfo = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK(measureID),slor );
					BigDecimal baseQty = UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "assistUnitQty").getValue()).multiply(unitInfo.getCoefficient());
					kdtEntrys.getCell(rowIndex, "qty").setValue(baseQty);
					KDTEditEvent kdte = new KDTEditEvent(getDetailTable(), BigDecimal.ZERO, baseQty, rowIndex, getDetailTable().getColumnIndex("qty"), false, 1);  
		            Object[] listeners = getDetailTable().getListenerList().getListenerList();  
		            for (int i = listeners.length - 2; i >= 0; i -= 2) {  
		                if (listeners[i] == KDTEditListener.class) {  
		                    ((KDTEditListener) listeners[(i + 1)]).editStopped(kdte);  
		                }  
		            }  
				}
			}
		}else if("price".equalsIgnoreCase(fieldName)){
			if(kdtEntrys.getCell(rowIndex, "price").getValue() != null){
				calEntryBasePriceByPrice(rowIndex,colIndex,kdtEntrys);
				calEntryAmount(rowIndex,colIndex,kdtEntrys);
				//calTotalmount();
			}
			//calPremiumAndSettlePrice(rowIndex,false);
		}else if("basePrice".equalsIgnoreCase(fieldName)){
			if(kdtEntrys.getCell(rowIndex, "basePrice").getValue() != null){
				calEntryPriceByBasePrice(rowIndex,colIndex,kdtEntrys);
				calEntryAmount(rowIndex,colIndex,kdtEntrys);	
				//calTotalmount();
			}
			//calPremiumAndSettlePrice(rowIndex,false);
		}else if("baseQty".equalsIgnoreCase(fieldName)){
			if(kdtEntrys.getCell(rowIndex, "baseQty").getValue() != null){
				calEntryQtyByBaseQty(rowIndex,colIndex,kdtEntrys);
				calEntryAmount(rowIndex,colIndex,kdtEntrys);
				//calTotalmount();
			}
		}else if("internalCost".equalsIgnoreCase(fieldName)){
			calPremiumAndSettlePrice(rowIndex,false);
		}
	}
	private void calEntryBaseQtyByQty(int rowIndex, int colIndex,KDTable kdtable) {
		BigDecimal qty = SCMClientUtils.castToBigDecimalForCell(kdtable, rowIndex, "qty");
		if(qty == null){
			qty = ZERO;
		}

		MeasureUnitInfo unitinfo =(MeasureUnitInfo)kdtable.getCell(rowIndex, "measureUnit").getValue();
		MeasureUnitInfo baseunitinfo =(MeasureUnitInfo)kdtable.getCell(rowIndex, "baseUnit").getValue();
		if(unitinfo!=null&&baseunitinfo!=null){	
			BigDecimal coefficient=unitinfo.getCoefficient();
			if(coefficient==null)coefficient=new BigDecimal("1");
			BigDecimal baseqty=qty.multiply(coefficient);
			baseqty = baseqty.setScale(2, 4);
			kdtable.getCell(rowIndex, "baseQty").setValue(baseqty);
			kdtEntrys.getCell(rowIndex, "qtyb").setValue(baseqty);
		}
		MeasureUnitInfo assistUnitInfo =(MeasureUnitInfo)kdtable.getCell(rowIndex, "assistUnit").getValue();
		if(assistUnitInfo!=null)
			kdtEntrys.getRow(rowIndex).getCell("assistUnitQty").setValue(qty.divide(assistUnitInfo.getCoefficient(),2,BigDecimal.ROUND_HALF_UP));
	}
	private void calEntryBasePriceByPrice(int rowIndex, int colIndex,KDTable kdtable) {
		BigDecimal price = SCMClientUtils.castToBigDecimalForCell(kdtable, rowIndex, "price");
		if(price == null){
			price = ZERO;
		}

		MeasureUnitInfo unitinfo =(MeasureUnitInfo)kdtable.getCell(rowIndex, "measureUnit").getValue();
		MeasureUnitInfo baseunitinfo =(MeasureUnitInfo)kdtable.getCell(rowIndex, "baseUnit").getValue();
		if(unitinfo!=null&&baseunitinfo!=null){	
			BigDecimal coefficient=unitinfo.getCoefficient();
			if(coefficient==null)coefficient=new BigDecimal("1");
			BigDecimal baseprice=price.divide(coefficient,4,6);
			baseprice = baseprice.setScale(6, 6);
			kdtable.getCell(rowIndex, "basePrice").setValue(baseprice);
		}
		calPremiumAndSettlePrice(rowIndex,false);
	}
	/**
	 * 计算单价的溢价和净价
	 * @param rowIndex
	 * @param isMaterial   物料
	 */
	private void calPremiumAndSettlePrice(int rowIndex, boolean isMaterial) {
		// TODO Auto-generated method stub
		if(kdtEntrys.getCell(rowIndex, "materialNumber").getValue()!=null){
			String materialID = ((IPropertyContainer)kdtEntrys.getCell(rowIndex, "materialNumber").getValue()).getString("id");
			String saleOrgNum = ClientUtils.getCurrentSaleUnit().getString("number");
			JSONObject json = new JSONObject();
			json.put("saleOrgNum",saleOrgNum);
			json.put("materialID",materialID);
			try {
				String resultJson = ForecastOrderFacadeFactory.getRemoteInstance().getMaterialByOrg(json.toString());
				if(StringUtils.isNotBlank(resultJson)){
					JSONObject values = JSONObject.fromObject(resultJson);
					BigDecimal price = BigDecimal.ZERO;
					if(values.getJSONArray("data").size() != 0)
						price = UIRuleUtil.getBigDecimal(((JSONObject) values.getJSONArray("data").get(0)).get("price"));
					if(isMaterial){
						kdtEntrys.getCell(rowIndex, "price").setValue(price);
						kdtEntrys.getCell(rowIndex, "srcPrice").setValue(price);
						calEntryBasePriceByPrice(rowIndex, kdtEntrys.getColumnIndex("price"), kdtEntrys);
					}else{
						kdtEntrys.getCell(rowIndex, "suttlePrice").setValue(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "price").getValue()).subtract(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "internalCost").getValue())));
						kdtEntrys.getCell(rowIndex, "premium").setValue(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "suttlePrice").getValue()).subtract(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "srcPrice").getValue())));
						kdtEntrys.getCell(rowIndex, "premiumAmount").setValue(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "premium").getValue()).multiply(UIRuleUtil.getBigDecimal(kdtEntrys.getCell(rowIndex, "qty").getValue())));
					}
				}
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void calEntryPriceByBasePrice(int rowIndex, int colIndex,KDTable kdtable) {
		BigDecimal baseprice = SCMClientUtils.castToBigDecimalForCell(kdtable, rowIndex, "basePrice");
		if(baseprice == null){
			baseprice = ZERO;
		}

		MeasureUnitInfo unitinfo =(MeasureUnitInfo)kdtable.getCell(rowIndex, "measureUnit").getValue();
		MeasureUnitInfo baseunitinfo =(MeasureUnitInfo)kdtable.getCell(rowIndex, "baseUnit").getValue();
		if(unitinfo!=null&&baseunitinfo!=null){	
			BigDecimal coefficient=unitinfo.getCoefficient();
			if(coefficient==null)coefficient=new BigDecimal("1");
			BigDecimal price=baseprice.multiply(coefficient);
			price = price.setScale(6, 6);
			kdtable.getCell(rowIndex, "price").setValue(price);
		}
		calPremiumAndSettlePrice(rowIndex,false);
		kdtable.getCell(rowIndex, "premium").setValue(UIRuleUtil.getBigDecimal(kdtable.getCell(rowIndex, "price").getValue()).subtract(UIRuleUtil.getBigDecimal(kdtable.getCell(rowIndex, "srcPrice").getValue())));
		kdtable.getCell(rowIndex, "suttlePrice").setValue(UIRuleUtil.getBigDecimal(kdtable.getCell(rowIndex, "price").getValue()).subtract(UIRuleUtil.getBigDecimal(kdtable.getCell(rowIndex, "internalCost").getValue())));
	}
	private void calEntryQtyByBaseQty(int rowIndex, int colIndex,KDTable kdtable) {
		BigDecimal baseqty = SCMClientUtils.castToBigDecimalForCell(kdtable, rowIndex, "baseQty");
		if(baseqty == null){
			baseqty = ZERO;
		}
		kdtEntrys.getCell(rowIndex, "qtyb").setValue(baseqty);

		MeasureUnitInfo unitinfo =(MeasureUnitInfo)kdtable.getCell(rowIndex, "measureUnit").getValue();
		MeasureUnitInfo baseunitinfo =(MeasureUnitInfo)kdtable.getCell(rowIndex, "baseUnit").getValue();
		if(unitinfo!=null&&baseunitinfo!=null){	
			BigDecimal coefficient=unitinfo.getCoefficient();
			if(coefficient==null)coefficient=new BigDecimal("1");
			if(coefficient.compareTo(new BigDecimal("0"))==0){
				coefficient=new BigDecimal("1");
			}
			BigDecimal qty=baseqty.divide(coefficient,4,4);
			qty = qty.setScale(4, 4);
			kdtable.getCell(rowIndex, "qty").setValue(qty);
		}
	}
	private void calEntryAmount(int rowIndex, int colIndex,KDTable kdtable) {
		int amtPrecision=2;
		BigDecimal qty = SCMClientUtils.castToBigDecimalForCell(kdtable, rowIndex, "qty");
		if(qty == null)
			qty = ZERO;
		BigDecimal price = SCMClientUtils.castToBigDecimalForCell(kdtable, rowIndex, "price");
		if(price == null)
			price = ZERO;
		BigDecimal amount = qty.multiply(price);
		amount = amount.setScale(amtPrecision, 4);
		kdtable.getCell(rowIndex, "amount").setValue(amount);

	}
	private void calTotalmount() {
		int nrowA=this.kdtEntrys.getBody().size();
		BigDecimal totalAmount=BigDecimal.ZERO;
		BigDecimal totalQty=BigDecimal.ZERO;
		for (int i= 0; i<nrowA; i++) {
			if(kdtEntrys.getRow(i).getCell("amount").getValue()!=null){
				BigDecimal amount=(BigDecimal)kdtEntrys.getRow(i).getCell("amount").getValue();
				totalAmount=totalAmount.add(amount);
			}
			if(kdtEntrys.getRow(i).getCell("baseQty").getValue()!=null){
				BigDecimal qty=(BigDecimal)kdtEntrys.getRow(i).getCell("baseQty").getValue();
				totalQty=totalQty.add(qty);
			}
		}
		this.txttotalQty.setValue(totalQty);
		this.txttotalAmount.setValue(totalAmount);
	}
	/**
	 * output loadFields method
	 */
	public void loadFields()
	{
		ListenerUtil.F7RemoveDateChangeListener(prmtcustomer);
		super.loadFields();
		setCanUseBale();
		setDepartmentFilter();
		
		addTableQuerySearchPanel(kdtEntrys);

		if(editData.getState().equals(ForecastEnum.AUDIT) 
				|| editData.getState().equals(ForecastEnum.Close)
				|| editData.getState().equals(ForecastEnum.OVER)
				|| editData.getState().equals(ForecastEnum.SUBJECT)){
			btnEdit.setEnabled(false);
		}else if(oprtState.equalsIgnoreCase("VIEW")){
			btnEdit.setEnabled(true);
		}else
			btnEdit.setEnabled(false);


	}


	/**
	 * 设置部门过滤
	 */
	private void setDepartmentFilter() {
		// TODO Auto-generated method stub
		EntityViewInfo evi = new EntityViewInfo();
		FilterInfo filter = new FilterInfo();
		String FUserID = SysContext.getSysContext().getCurrentUserInfo().getString("id");
		filter.getFilterItems().add(new FilterItemInfo("id","select FOrgID from T_PM_OrgRange where FUserID='"+FUserID +"' and FType=20 group by FOrgID",CompareType.INNER));
		evi.setFilter(filter );
		prmtdepartment.setEntityViewInfo(evi);
	}

	private void setCanUseBale() {
		// TODO Auto-generated method stub
		if(editData.getId() != null){
			prmtcustomer.setEnabled(false);
			prmtsaleCustomer.setEnabled(false);
			prmtsalePerson.setEnabled(false);
			prmtsaleGroup.setEnabled(false);
			prmtcompany.setEnabled(false);
			prmtsaleOrgUnit.setEnabled(false);
			prmtdepartment.setEnabled(false);
		}else{
			prmtcustomer.setEnabled(true);
			prmtsaleCustomer.setEnabled(true);
			prmtsalePerson.setEnabled(true);
			prmtsaleGroup.setEnabled(true);
			prmtcompany.setEnabled(true);
			prmtsaleOrgUnit.setEnabled(true);
			prmtdepartment.setEnabled(true);
		}
	}

	/**
	 * output actionSave_actionPerformed
	 */
	public void actionSave_actionPerformed(ActionEvent e) throws Exception
	{
		if(editData == null && editData.getId() == null){
			//SysUtil.abort();
		} else{
			ForecastEnum baseStatus = editData.getState();
			if(baseStatus != null){
				int baseStatusValue = Integer.parseInt(baseStatus.getValue());
				if(baseStatusValue == 3){
					MsgBox.showError("已经审核，不能再提交！！");
					SysUtil.abort();
				}
			}
		}
		this.editData.setState(ForecastEnum.SAVE);
		super.actionSave_actionPerformed(e);
		refreshCurPage();
		//        this.setOprtState("VIEW");
	}

	/**
	 * output actionSubmit_actionPerformed
	 */
	public void actionSubmit_actionPerformed(ActionEvent e) throws Exception
	{
		if(editData == null && editData.getId() == null){
			//SysUtil.abort();
		} else{
			ForecastEnum baseStatus = editData.getState();
			if(baseStatus != null){
				int baseStatusValue = Integer.parseInt(baseStatus.getValue());
				if(baseStatusValue == 3){
					MsgBox.showError("已经审核，不能再提交！！");
					SysUtil.abort();
				}
			}
		}
		checkHeader();
		checkEntrys();
		this.editData.setState(ForecastEnum.SUBMIT);
		//    	this.editData.set
		//    	for(int i = 0; i < this.editData.getEntrys().size(); i++){
		//    		SaleForecastEntryInfo currEntry = editData.getEntrys().get(i);
		//    		currEntry.setQtyb(currEntry.getQty());
		//    	}
		super.actionSubmit_actionPerformed(e);
		refreshCurPage();
		this.setOprtState("VIEW");
	}
	protected void checkCanEdit() throws Exception{
		if(editData == null && editData.getId() == null){
			SysUtil.abort();
		} else{
			ForecastEnum baseStatus = editData.getState();
			if(baseStatus != null){
				int baseStatusValue = Integer.parseInt(baseStatus.getValue());
				if(baseStatusValue == 3){
					MsgBox.showError("已经审核，不能修改！");
					SysUtil.abort();
				}
			}
		}
	}
	public void actionAudit_actionPerformed(ActionEvent e) throws Exception {
		if(editData == null && editData.getId() == null){
			SysUtil.abort();
		} else{

			if(!this.state.getSelectedItem().toString().equals("提交")){
				MsgBox.showError("非提交状态单据禁止审核！");
				SysUtil.abort();
			}
		}
		super.actionAudit_actionPerformed(e);
//		refreshCurPage();
		doAfterSave(new ObjectUuidPK(editData.getId()));
		MsgBox.showInfo("审核完成");
		this.setOprtState("VIEW");
		lockUIForViewStatus();
	}

	public void actionUnAudit_actionPerformed(ActionEvent e) throws Exception {
		super.actionUnAudit_actionPerformed(e);
		doAfterSave(new ObjectUuidPK(editData.getId()));
		MsgBox.showInfo("反审核完成");
		this.setOprtState("VIEW");
		lockUIForViewStatus();
		/*
		if(editData == null && editData.getId() == null){
			SysUtil.abort();
		} else{
			if(!this.state.getSelectedItem().toString().equals("审核")){
				MsgBox.showError("非审核状态，不能反审核！");
				SysUtil.abort();
			}
		}
		super.actionUnAudit_actionPerformed(e);
		refreshCurPage();
		this.setOprtState("EDIT");
		this.btnSave.setEnabled(true);
		this.btnSubmit.setEnabled(true);
		this.btnEdit.setEnabled(true);
		this.actionEdit.setEnabled(true);
		 */
		}



	/**
	 * output actionEdit_actionPerformed
	 */
	public void actionEdit_actionPerformed(ActionEvent e) throws Exception
	{
		if(getOprtState().equals("VIEW"))
			checkCanEdit();
		super.actionEdit_actionPerformed(e);
		setCanUseBale();
	}

	/**
	 * output actionRemove_actionPerformed
	 */
	public void actionRemove_actionPerformed(ActionEvent e) throws Exception
	{
		if(editData == null && editData.getId() == null){
			SysUtil.abort();
		} else{
			ForecastEnum baseStatus = editData.getState();
			if(baseStatus != null){
				int baseStatusValue = Integer.parseInt(baseStatus.getValue());
				if(baseStatusValue==3||baseStatusValue==5){
					MsgBox.showError("已经审核或者分配，不能删除！");
					SysUtil.abort();
				}
			}
		}
		super.actionRemove_actionPerformed(e);
	}



	/**
	 * output getBizInterface method
	 */
	protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
	{
		return com.kingdee.eas.custom.lhsm.SaleForecastFactory.getRemoteInstance();
	}

	/**
	 * output createNewDetailData method
	 */
	protected IObjectValue createNewDetailData(KDTable table)
	{
		SaleForecastEntryInfo entryInfo=new SaleForecastEntryInfo();
		if(table.getRowCount()>1){
			CompanyOrgUnitInfo companyinfo=(CompanyOrgUnitInfo)table.getRow(0).getCell("company").getValue();
			//this.kdtEntrys.getRow(i).getCell("company").getValue() 
			entryInfo.setCompany(companyinfo);
		}


		return entryInfo;
	}

	/**
	 * output createNewData method
	 */
	protected com.kingdee.bos.dao.IObjectValue createNewData()
	{
		com.kingdee.eas.custom.lhsm.SaleForecastInfo objectValue = new com.kingdee.eas.custom.lhsm.SaleForecastInfo();
		if (com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Sale")) != null && com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentOrgUnit(com.kingdee.eas.basedata.org.OrgType.getEnum("Sale")).getBoolean("isBizUnit"))
			objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		objectValue.setCU(SysContext.getSysContext().getCurrentCtrlUnit());
		objectValue.setCompany(SysContext.getSysContext().getCurrentFIUnit());
		objectValue.setSaleOrgUnit(SysContext.getSysContext().getCurrentSaleUnit());
		objectValue.setDepartment(SysContext.getSysContext().getCurrentAdminUnit());
		Date today = null;
		try {
			today = SCMClientUtils.getServerDate();
		} catch (Exception e) {
			super.handUIException(e);
			//e.printStackTrace();
		}
		objectValue.setBizDate(today);
		objectValue.setBeginDate(today);
		objectValue.setEndDate(today);
		objectValue.setState(ForecastEnum.ADDNEW);
		ObjectUuidPK pk=new ObjectUuidPK("40b75328-7f57-463f-8d19-280574ef24bf6BCA0AB5");
		PaymentTypeInfo payinfo=null;
		try {
			payinfo = PaymentTypeFactory.getRemoteInstance().getPaymentTypeInfo(pk);
			objectValue.setPayType(payinfo);

			UserInfo userinfo=SysContext.getSysContext().getCurrentUserInfo();
			if(userinfo.getPerson()!=null){
				pk=new ObjectUuidPK(userinfo.getPerson().getId());
				PersonInfo personinfo=PersonFactory.getRemoteInstance().getPersonInfo(pk);
				objectValue.setSalePerson(personinfo);
			}
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return objectValue;
	}
	/**
	 * 提交前检查表头
	 * <p>Title: checkHeader</p>
	 * <p>Description: </p>
	 *
	 */
	protected void checkHeader(){
		if(this.prmtpayType.getValue() == null){
			MsgBox.showInfo("付款类型不能为空。");
			this.prmtpayType.setFocusable(true);

			SysUtil.abort();
		}
		//    	if(this.prmtcompany.getValue() == null){
		//    		MsgBox.showInfo("销售组织不能为空。");
		//    		this.prmtcompany.setFocusable(true);
		//    		
		//    		SysUtil.abort();
		//    	}
		if(this.prmtsaleGroup.getValue() == null){
			MsgBox.showInfo("销售组不能为空。");
			this.prmtsaleGroup.setFocusable(true);

			SysUtil.abort();
		}
		if(this.prmtsalePerson.getValue() == null){
			MsgBox.showInfo("销售员不能为空。");
			this.prmtsalePerson.setFocusable(true);

			SysUtil.abort();
		}
		if(this.wayOfTakingDelivery.getSelectedItem() == null){
			MsgBox.showInfo("交货方式不能为空。");
			this.wayOfTakingDelivery.setFocusable(true);

			SysUtil.abort();
		}
		if(this.prmtcustomer.getValue() == null){
			MsgBox.showInfo("购货客户不能为空。");
			this.prmtcustomer.setFocusable(true);

			SysUtil.abort();
		}
	}

	/**
	 * 提交前检查分录
	 * <p>Title: checkEntrys</p>
	 * <p>Description: </p>
	 *
	 */
	protected void checkEntrys(){
		if(this.kdtEntrys.getBody().size()<=0){
			MsgBox.showInfo("请至少填写一条分录再提交预报单。");
			SysUtil.abort();
		}
		for(int i=0;i<this.kdtEntrys.getBody().size();i++){
			Object material=this.kdtEntrys.getRow(i).getCell("materialNumber").getValue();
			if(material==null){
				MsgBox.showInfo("第"+String.valueOf(i+1)+"物料不能为空！");
				SysUtil.abort();
			}
			BigDecimal price=(BigDecimal)this.kdtEntrys.getRow(i).getCell("price").getValue();
			if(price==null)price=BigDecimal.ZERO;
			if(price.compareTo(new BigDecimal("0"))<=0){
				MsgBox.showInfo("第"+String.valueOf(i+1)+"单价必须大于0！");
				SysUtil.abort();
			}

			BigDecimal baseqty=(BigDecimal)this.kdtEntrys.getRow(i).getCell("baseQty").getValue();
			if(baseqty==null)baseqty=BigDecimal.ZERO;
			if(baseqty.compareTo(new BigDecimal("0"))<=0){
				MsgBox.showInfo("第"+String.valueOf(i+1)+"数量必须大于0！");
				SysUtil.abort();
			}
			if(this.kdtEntrys.getRow(i).getCell("company").getValue() == null){
				MsgBox.showInfo("第"+String.valueOf(i+1)+"意向公司不能为空！");
				SysUtil.abort();
			}

		}
	}
	protected void refreshCurPage()throws EASBizException, BOSException, Exception{
		if(editData.getId() != null){
			IObjectPK iObjectPk = new ObjectUuidPK(editData.getId());
			IObjectValue iObjectValue = getValue(iObjectPk);
			setDataObject(iObjectValue);
			loadFields();
			setSave(true);
		}

	}

	@Override
	public void actionProgressView_actionPerformed(ActionEvent e)
	throws Exception {
		// TODO Auto-generated method stub
		super.actionProgressView_actionPerformed(e);
		detailMouseClickGetQtyAndNewPrice();
	}
	private void detailMouseClickGetQtyAndNewPrice() {
		// TODO Auto-generated method stub
		final KDFrame fram=new KDFrame();
		fram.setSize(400,250);
		int x = Toolkit.getDefaultToolkit().getScreenSize().width - 300;
		int y = Toolkit.getDefaultToolkit().getScreenSize().height - 300;
		fram.setLocation(x-100, y-7);


		//基本信息以textArea展示
		fram.setTitle("进度查询");
		KDTextArea txtArea=new KDTextArea();
		txtArea.setEnabled(false);
		txtArea.setBackground(new Color(222,243,255));
		txtArea.setFont(new Font("宋体",Font.BOLD,12));
		txtArea.setText("当前预报单进度");
		txtArea.setSize(50, 80);

		//饲料以KDTable展示
		final KDTable table1=new KDTable();
		table1.setSize(100,170);
		table1.setBackground(new Color(222,243,255));
		table1.addHeadRow();

		table1.addColumns(4);

		table1.getColumn(0).setKey("billType");
		table1.getHeadRow(0).getCell("billType").setValue("单据类型");
		table1.getColumn("billType").setWidth(60);

		table1.getColumn(1).setKey("billNum");
		table1.getHeadRow(0).getCell("billNum").setValue("单据编号");
		table1.getColumn("billNum").setWidth(120);

		table1.getColumn(2).setKey("billStatus");
		table1.getHeadRow(0).getCell("billStatus").setValue("状态");
		table1.getColumn("billStatus").setWidth(50);

		table1.getColumn(3).setKey("srcBillNum");
		table1.getHeadRow(0).getCell("srcBillNum").setValue("上游单据号");
		table1.getColumn("srcBillNum").setWidth(120);



		table1.setEnabled(false);
		final KDTable table = table1;

		fram.add(BorderLayout.NORTH,txtArea);
		fram.add(BorderLayout.CENTER,table);
		fram.setVisible(true);

		// 查询销售订单
		if(editData.getId() == null){
			fram.dispose();
			return;
		}
		String sql = "select t2.FID,t2.Fnumber,t2.FBaseStatus from CT_LHS_SALEFORECASTENTRY2 t1 inner join t_sd_saleorder t2 on t2.FID=t1.fsaleorderid where t1.fparentID='"+editData.getString("id")+"' and t1.fsaleorderid is not null";
		try {
			IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
			ArrayList<String> orderNumList = new ArrayList<String>();
			while(rs.next()){
				if(orderNumList.contains(rs.getString("Fnumber")))
					continue;
				else
					orderNumList.add(rs.getString("Fnumber"));
				IRow addRow = table.addRow();
				addRow.getCell("billType").setValue("销售订单");
				addRow.getCell("billNum").setValue(rs.getString("Fnumber"));
				addRow.getCell("billStatus").setValue(BillBaseStatusEnum.getEnum(rs.getInt("FBaseStatus")).getAlias());
				addRow.getCell("srcBillNum").setValue(editData.getNumber());
				ArrayList obj = BOTRelationFactory.getRemoteInstance().getDestObjIdByDestType(rs.getString("FID"), "CC3E933B");
				if(obj.size() > 0){
					String id = obj.get(0).toString();
					SaleIssueBillInfo info = SaleIssueBillFactory.getRemoteInstance().getSaleIssueBillInfo(new ObjectUuidPK(id));
					addRow = table.addRow();
					addRow.getCell("billType").setValue("销售出库");
					addRow.getCell("billNum").setValue(info.getNumber());
					addRow.getCell("billStatus").setValue(info.getBaseStatus().getAlias());
					addRow.getCell("srcBillNum").setValue(rs.getString("Fnumber"));


					obj = BOTRelationFactory.getRemoteInstance().getDestObjIdByDestType(id, "FC910EF3");
					if(obj.size() > 0){
						id = obj.get(0).toString();
						OtherBillInfo otherInfo = OtherBillFactory.getRemoteInstance().getOtherBillInfo(new ObjectUuidPK(id));
						addRow = table.addRow();
						addRow.getCell("billType").setValue("应收单");
						addRow.getCell("billNum").setValue(otherInfo.getNumber());
						addRow.getCell("billStatus").setValue(otherInfo.getBillStatus().getAlias());
						addRow.getCell("srcBillNum").setValue(info.getNumber());


						obj = BOTRelationFactory.getRemoteInstance().getDestObjIdByDestType(id, "FA44FD5B");
						if(obj.size() > 0){
							id = obj.get(0).toString();
							ReceivingBillInfo ReceivingBill = ReceivingBillFactory.getRemoteInstance().getReceivingBillInfo(new ObjectUuidPK(id));
							addRow = table.addRow();
							addRow.getCell("billType").setValue("收款单");
							addRow.getCell("billNum").setValue(ReceivingBill.getNumber());
							addRow.getCell("billStatus").setValue(ReceivingBill.getBillStatus().getAlias());
							addRow.getCell("srcBillNum").setValue(otherInfo.getNumber());
						}
					}
				}



			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void setTableToSumField() {
		// TODO Auto-generated method stub
		setTableToSumField(getDetailTable(), new String[]{"qty","qtyA","qtyB","amount","premiumAmount"});
	}
}