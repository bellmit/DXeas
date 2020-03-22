/**
 * output package name
 */
package com.kingdee.eas.custom.dx.baseset.client;

import java.awt.Component;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ui.face.CoreUIObject;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.eas.base.permission.client.longtime.ILongTimeTask;
import com.kingdee.eas.base.permission.client.longtime.LongTimeDialog;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.material.IMaterial;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.framework.*;
import com.kingdee.eas.framework.client.multiDetail.DetailPanel;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.wlhlcomm.excel.ExcelReadUtil;
import com.kingdee.bos.ctrl.kdf.table.IRow;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.swing.KDWorkButton;

/**
 * output class name
 */
public class ChangepackingEditUI extends AbstractChangepackingEditUI
{
    private static final Logger logger = CoreUIObject.getLogger(ChangepackingEditUI.class);
    
    /**
     * output class constructor
     */
    public ChangepackingEditUI() throws Exception
    {
        super();
    }
    /**
     * output loadFields method
     */
    public void loadFields()
    {
        super.loadFields();
        addTableQuerySearchPanel(kdtEntry);
    }
  /* (non-Javadoc)
	 * @see com.kingdee.eas.custom.wlhllicensemanager.client.WlhlCoreBillEditUI#onLoad()
	 */
	@Override
	public void onLoad() throws Exception {
		// TODO Auto-generated method stub
		super.onLoad();
		
		//getRealWeight();
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
				if(excelValues != null){
					MaterialInfo info  = new MaterialInfo();
					MeasureUnitInfo minfo = new MeasureUnitInfo();
					//BasicPostInfo b = new BasicPostInfo();
					IMaterial iMaterial = MaterialFactory.getRemoteInstance();
					CoreBaseCollection coll = null;
					int size = excelValues.size();
					if(size > 0){
						kdtEntry.removeRows();
					}
					for(int i = 2; i <= size; i++){
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
								row = kdtEntry.addRow();
								begin = false;
							}
							switch(in){
							case 1://物料名称
								if(obj != null){
									try {
										coll = iMaterial.getCollection("where number='" + UIRuleUtil.getString(obj) + "'");
										if(coll.size() > 0){
											row.getCell("materialNum").setValue((MaterialInfo)coll.get(0));
											row.getCell("materialName").setValue(((MaterialInfo)coll.get(0)).getString("name"));
											row.getCell("model").setValue(((MaterialInfo)coll.get(0)).getString("model"));

											//String mg = ((MaterialInfo)coll.get(0)).getString("materialGroup");
											}
									} catch (BOSException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
								}
								break;
							case 2:
								if(obj != null){
									row.getCell(4).setValue(obj);
								}
								break;
							case 3:
								if(obj != null){
									try {
										coll = iMaterial.getCollection("where number='" + UIRuleUtil.getString(obj) + "'");
										if(coll.size() > 0){
											row.getCell("packMaterial").setValue((MaterialInfo)coll.get(0));
											row.getCell("packMaterialName").setValue(((MaterialInfo)coll.get(0)).getString("name"));
											row.getCell("packMaterialMod").setValue(((MaterialInfo)coll.get(0)).getString("model"));

											//String mg = ((MaterialInfo)coll.get(0)).getString("materialGroup");
																				}
									} catch (BOSException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
								}
								break;
							case 4:
								if(obj != null){
									row.getCell(8).setValue(obj);
								}
								break;
							case 5:
								if(obj != null){
									try {
										coll = iMaterial.getCollection("where number='" + UIRuleUtil.getString(obj) + "'");
										if(coll.size() > 0){
											row.getCell("packMtwo").setValue((MaterialInfo)coll.get(0));
											row.getCell("packMtwoName").setValue(((MaterialInfo)coll.get(0)).getString("name"));
											row.getCell("packMtwomod").setValue(((MaterialInfo)coll.get(0)).getString("model"));
											//String mg = ((MaterialInfo)coll.get(0)).getString("Model");
																				}
									} catch (BOSException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
								}
								break;
							case 6:
								if(obj != null){
									row.getCell(12).setValue(obj);
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

    /**
     * output storeFields method
     */
    public void storeFields()
    {
        super.storeFields();
    }

   

    /**
     * output getBizInterface method
     */
    protected com.kingdee.eas.framework.ICoreBase getBizInterface() throws Exception
    {
        return com.kingdee.eas.custom.dx.baseset.ChangepackingFactory.getRemoteInstance();
    }

    /**
     * output createNewDetailData method
     */
    protected IObjectValue createNewDetailData(KDTable table)
    {
		
        return null;
    }

    /**
     * output createNewData method
     */
    protected com.kingdee.bos.dao.IObjectValue createNewData()
    {
        com.kingdee.eas.custom.dx.baseset.ChangepackingInfo objectValue = new com.kingdee.eas.custom.dx.baseset.ChangepackingInfo();
        objectValue.setCreator((com.kingdee.eas.base.permission.UserInfo)(com.kingdee.eas.common.client.SysContext.getSysContext().getCurrentUser()));
		
        return objectValue;
    }

}