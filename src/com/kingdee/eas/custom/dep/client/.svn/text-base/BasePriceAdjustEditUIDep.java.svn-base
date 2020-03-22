package com.kingdee.eas.custom.dep.client;

import java.math.BigDecimal;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditAdapter;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialGroupInfo;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.scm.sd.sale.IMaterialBasePriceAdjust;
import com.kingdee.eas.scm.sd.sale.MaterialBasePriceAdjustEntry;
import com.kingdee.eas.scm.sd.sale.MaterialBasePriceAdjustEntryCollection;
import com.kingdee.eas.scm.sd.sale.MaterialBasePriceAdjustEntryInfo;
import com.kingdee.eas.scm.sd.sale.MaterialBasePriceAdjustFactory;
import com.kingdee.eas.scm.sd.sale.MaterialBasePriceAdjustInfo;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.eas.scm.sd.sale.client.MaterialBasePriceAdjustEditUI;
import com.kingdee.eas.scm.sd.sale.client.SaleOrderEditUIPIEx;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.jdbc.rowset.IRowSet;

public class BasePriceAdjustEditUIDep {
	private KDTable table;
	protected MaterialBasePriceAdjustEditUI ui;
	protected MaterialBasePriceAdjustInfo editData;
	
	/**
	 * onload后置脚本调用方法
	 * @throws BOSException 
	 */
	public void afterOnLoad(final UIParam param) throws Exception{
		table = param.getKDTable("kdtEntries");
		//即时库存
		if(table.getColumn("justNowInventory")!=null) {
			table.addKDTEditListener(new KDTEditAdapter(){
				public void editStopped(KDTEditEvent e) {
					if(table.getColumnKey(e.getColIndex()).equals("newPrice")) {
						MaterialInfo mInfo=(MaterialInfo) table.getCell(e.getRowIndex(),"material").getValue();
						if(mInfo!=null) {
							try {
								mInfo=MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(mInfo.getId()));
								//设置物料分类
								String displayName=null;
								if(mInfo.getMaterialGroup()!=null) {
									displayName=((MaterialGroupInfo)UIRuleUtil.getProperty(mInfo, "materialGroup")).getDisplayName();
								}
								table.getCell(e.getRowIndex(), table.getColumnIndex("materialGroup")).setValue(displayName);
								//设置即时库存
								if(SysContext.getSysContext().getCurrentStorageUnit()!=null) {
									String sql="select isnull(sum(FCurStoreQty),0) FQty from t_im_inventory where FStorageOrgUnitID='"+SysContext.getSysContext().getCurrentStorageUnit().getString("id")+"' and FMaterialId='"+mInfo.getString("id")+"'";
									IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
									if(rs.next()) {
										table.getCell(e.getRowIndex(), table.getColumnIndex("justNowInventory")).setValue(rs.getBigDecimal("FQty"));
									}
								}
							} catch (Exception err) {
								MsgBox.showError(err.getMessage());
								SysUtil.abort();
							}
						}else {
							table.getCell(e.getRowIndex(), table.getColumnIndex("materialGroup")).setValue(null);
							table.getCell(e.getRowIndex(), table.getColumnIndex("justNowInventory")).setValue(null);
						}
						
						BigDecimal diffPrice=UIRuleUtil.getBigDecimal(table.getCell(e.getRowIndex(), "newPrice").getValue()).subtract(UIRuleUtil.getBigDecimal(table.getCell(e.getRowIndex(), "oldPrice").getValue()));
						table.getCell(e.getRowIndex(), table.getColumnIndex("diffPrice")).setValue(diffPrice);
					}
					//yumingxu
//					if(table.getColumnKey(e.getColIndex()).equals("material")) {
//					String id =((MaterialInfo[]) table.getCell(e.getRowIndex(),e.getColIndex()).getValue()).get.getId().toString();
//					
//					MaterialInfo mInfo=null;
//					try {
//						mInfo = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(id));
//					} catch (EASBizException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					} catch (BOSException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					if(mInfo!=null) {
//						try {
//							mInfo=MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(mInfo.getId()));
//							//设置物料分类
//							String displayName=null;
//							if(mInfo.getMaterialGroup()!=null) {
//								displayName=((MaterialGroupInfo)UIRuleUtil.getProperty(mInfo, "materialGroup")).getDisplayName();
//							}
//							table.getCell(e.getRowIndex(), table.getColumnIndex("materialGroup")).setValue(displayName);
//							//设置即时库存
//							if(SysContext.getSysContext().getCurrentStorageUnit()!=null) {
//								String sql="select isnull(sum(FCurStoreQty),0) FQty from t_im_inventory where FStorageOrgUnitID='"+SysContext.getSysContext().getCurrentStorageUnit().getString("id")+"' and FMaterialId='"+mInfo.getString("id")+"'";
//								IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
//								if(rs.next()) {
//									table.getCell(e.getRowIndex(), table.getColumnIndex("justNowInventory")).setValue(rs.getBigDecimal("FQty"));
//								}
//							}
//						} catch (Exception err) {
//							MsgBox.showError(err.getMessage());
//							SysUtil.abort();
//						}
//					}else {
//						table.getCell(e.getRowIndex(), table.getColumnIndex("materialGroup")).setValue(null);
//						table.getCell(e.getRowIndex(), table.getColumnIndex("justNowInventory")).setValue(null);
//					}
//					
//					BigDecimal diffPrice=UIRuleUtil.getBigDecimal(table.getCell(e.getRowIndex(), "newPrice").getValue()).subtract(UIRuleUtil.getBigDecimal(table.getCell(e.getRowIndex(), "oldPrice").getValue()));
//					table.getCell(e.getRowIndex(), table.getColumnIndex("diffPrice")).setValue(diffPrice);
//				}
				}});
		}
	}
	//保存后方法调用
	//yumingxu
	public void afterSave(final UIParam param) throws Exception{
		ui = (MaterialBasePriceAdjustEditUI) param.getUI();
		editData = (MaterialBasePriceAdjustInfo) ui.getEditData();
		table = param.getKDTable("kdtEntries");
		MaterialBasePriceAdjustEntryCollection entry =  editData.getEntries();
		for(int i=0;i<entry.size();i++){
			MaterialBasePriceAdjustEntryInfo entryinfo = entry.get(i);
			MaterialInfo mInfo=entryinfo.getMaterial();
			if(mInfo!=null) {
				mInfo=MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(mInfo.getId()));
				//设置物料分类
				String displayName=null;
				if(mInfo.getMaterialGroup()!=null) {
					displayName=((MaterialGroupInfo)UIRuleUtil.getProperty(mInfo, "materialGroup")).getDisplayName();
				}
				table.getCell(i, table.getColumnIndex("materialGroup")).setValue(displayName);
				if(SysContext.getSysContext().getCurrentStorageUnit()!=null) {
					String sql="select isnull(sum(FCurStoreQty),0) FQty from t_im_inventory where FStorageOrgUnitID='"+SysContext.getSysContext().getCurrentStorageUnit().getString("id")+"' and FMaterialId='"+mInfo.getString("id")+"'";
					IRowSet rs = SQLExecutorFactory.getRemoteInstance(sql).executeSQL();
					if(rs.next()) {
						table.getCell(i, table.getColumnIndex("justNowInventory")).setValue(rs.getBigDecimal("FQty"));
					}
				}	
			}else {
				table.getCell(i, table.getColumnIndex("materialGroup")).setValue(null);
				table.getCell(i, table.getColumnIndex("justNowInventory")).setValue(null);
			}
			
			BigDecimal diffPrice=UIRuleUtil.getBigDecimal(table.getCell(i, "newPrice").getValue()).subtract(UIRuleUtil.getBigDecimal(table.getCell(i, "oldPrice").getValue()));
			table.getCell(i, table.getColumnIndex("diffPrice")).setValue(diffPrice);
		}
		IMaterialBasePriceAdjust im = MaterialBasePriceAdjustFactory.getRemoteInstance();
		im.save(editData);
	}
	
}
