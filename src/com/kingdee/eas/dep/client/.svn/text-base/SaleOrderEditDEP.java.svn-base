package com.kingdee.eas.dep.client;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.derby.tools.sysinfo;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.ctrl.kdf.table.KDTable;
import com.kingdee.bos.ctrl.kdf.table.event.KDTEditEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeEvent;
import com.kingdee.bos.ctrl.swing.event.DataChangeListener;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.basedata.assistant.MeasureUnitFactory;
import com.kingdee.eas.basedata.assistant.MeasureUnitInfo;
import com.kingdee.eas.basedata.master.cssp.CustomerInfo;
import com.kingdee.eas.basedata.master.material.IMultiMeasureUnit;
import com.kingdee.eas.basedata.master.material.MaterialFactory;
import com.kingdee.eas.basedata.master.material.MaterialInfo;
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitFactory;
import com.kingdee.eas.basedata.master.material.MultiMeasureUnitInfo;
import com.kingdee.eas.basedata.org.SaleOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.client.SysContext;
import com.kingdee.eas.custom.salediscount.CustomerBalanceInfo;
import com.kingdee.eas.custom.salediscount.SaleDiscountFacadeFactory;
import com.kingdee.eas.ep.client.UIParam;
import com.kingdee.eas.scm.sd.sale.SaleOrderInfo;
import com.kingdee.eas.scm.sd.sale.client.SaleOrderEditUIPIEx;
import com.kingdee.eas.util.SysUtil;
import com.kingdee.eas.util.client.MsgBox;
import com.kingdee.eas.weighbridge.CommSqlFacadeFactory;
import com.kingdee.eas.wlhlcomm.SalePriceFacadeFactory;
import com.kingdee.jdbc.rowset.IRowSet;

public class SaleOrderEditDEP {
	
	protected SaleOrderEditUIPIEx ui;
	// 界面 对象
	protected SaleOrderInfo editData;
//	
//	/**
//	   * 分录更新
//	   * @param param
//	   * @param rowIndex
//	   * @param colIndex
//	   * @throws Exception
//	   */
//	public void PropertyChange(UIParam param,KDTPropertyChangeEvent pe,int rowIndex,int colIndex) throws Exception{
//		
//		String fieldName = param.getKDTable("kdtEntries").getColumnKey(colIndex);
//		 if(!"basePrice".equalsIgnoreCase(fieldName) && !"taxPrice".equalsIgnoreCase(fieldName) && !"baseQty".equalsIgnoreCase(fieldName)){
//			 return;
//		 }
//		
//		 
//		
//		
//		ui = (SaleOrderEditUIPIEx) param.getUI();
//		editData = (SaleOrderInfo) ui.getEditData();
//		
//		Object oldValue = pe.getOldValue();
//		Object newValue = pe.getNewValue();
//	
//		
////		System.out.println(fieldName + ":oldValue:" + (oldValue==null?"NULL":oldValue.toString()+ ":Date:") + new Date());
////		System.out.println(fieldName + ":newValue:" + (newValue==null?"NULL":newValue.toString()+ ":Date:") + new Date());
//		
//		if(oldValue != null && newValue != null){
//			
//			
//			// 值未改变不触发
//			if(oldValue.equals(newValue)) return;
//			
//			if(oldValue instanceof BigDecimal && newValue instanceof BigDecimal){
//				// 新旧值之间差值如果小于0.00001 则不触发事件
//				BigDecimal oldDBValue = (BigDecimal) oldValue;
//				BigDecimal newDBValue = (BigDecimal) newValue;
//				
//				BigDecimal subValue = newDBValue.subtract(oldDBValue);
//				subValue = subValue.abs();
//				if(!newDBValue.equals(subValue) &&  subValue.compareTo(new BigDecimal("0.00001")) < 0){
//					// 变化幅度很小的情况下 设置为原值
////					param.getKDTable("kdtEntries").getCell(rowIndex, colIndex).setValue(oldValue);
//					
//					return;
//				}
//			}
//		}
//		
//		// 先调用标准产品功能 后再执行
////			ui.pr(e);
//		
////			// loadfied执行完成后才调用 事件
////			String loadFieldsEnd = (String)param.getUIContext().get("loadFieldsEnd");
////			if("0".equals(loadFieldsEnd)){
////				return;
////			}
//        
//        
//        if(ui.getEntryEditTimes() > 0){
//	        // 熟食 含税单价问题
//	        if("basePrice".equalsIgnoreCase(fieldName)){
//	        	
//	        	updatePrice(param,rowIndex,colIndex);
//	        }else if("taxPrice".equalsIgnoreCase(fieldName)){
//      
//	        	BigDecimal basePrice = (BigDecimal)param.getKDTable("kdtEntries").getCell(rowIndex,"basePrice").getValue();
//	        	
//	        	
//	        	BigDecimal taxPrice = (BigDecimal)param.getKDTable("kdtEntries").getCell(rowIndex,"taxPrice").getValue();
//	        	if(taxPrice != null){
//	        		BigDecimal exchangeRate = getExchangeRate(param, rowIndex);
//	        		BigDecimal baseUnitPrice = taxPrice.divide(exchangeRate,6,RoundingMode.HALF_UP);
//	        		
//	        		if(basePrice == null){
//	        			basePrice = new BigDecimal("0.00");
//	        		}
//	        		
//	        		if(baseUnitPrice == null){
//	        			baseUnitPrice = new BigDecimal("0.00");
//	        		}
//	        		if(!basePrice.equals(baseUnitPrice)){
//		        		// 设置基本含税单价
//		        		param.getKDTable("kdtEntries").getCell(rowIndex,"basePrice").setValue(baseUnitPrice);
//	        		}
//	        	}
//	        }
//	        // 基本数量修改
//	        else if("baseQty".equalsIgnoreCase(fieldName)){
//	        	
//	        	if(param.getKDTable("kdtEntries").getRow(rowIndex).getCell("baseUnit").getValue()==null||
//	        			param.getKDTable("kdtEntries").getRow(rowIndex).getCell("unit").getValue()==null) {
//					return;
//				}
//	        	BigDecimal baseQty=BigDecimal.ZERO;
//				if(param.getKDTable("kdtEntries").getRow(rowIndex).getCell("baseQty").getValue()!=null)
//					baseQty=new java.math.BigDecimal(param.getKDTable("kdtEntries").getRow(rowIndex).getCell("baseQty").getValue().toString());
//				MeasureUnitInfo  unit=(MeasureUnitInfo) param.getKDTable("kdtEntries").getRow(rowIndex).getCell("unit").getValue();
//				
//				BigDecimal coeff = new BigDecimal("1");
//				if(unit != null){
//					coeff=unit.getCoefficient();
//				}
//				if(coeff == null){
//					unit = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK(unit.getId()));
//					coeff = unit.getCoefficient();
//				}
//				if(coeff==null||coeff.compareTo(java.math.BigDecimal.ZERO)==0) {
//					return;
//				}
//				// 原数据
//				BigDecimal oldQty = (BigDecimal) param.getKDTable("kdtEntries").getCell(pe.getRowIndex(), "qty").getValue();
//				if(oldQty == null){
//					oldQty = new BigDecimal("0.00");
//				}
//				
//				//基本计量单位*换算系数
//				BigDecimal qty=baseQty.divide(coeff,4,java.math.BigDecimal.ROUND_HALF_UP);
//				if(qty == null){
//					qty = new BigDecimal("0.00");
//				}
//				if(!oldQty.equals(qty)){
//					param.getKDTable("kdtEntries").getRow(rowIndex).getCell("qty").setValue(qty);
//					
//					BigDecimal subValue = oldQty.subtract(qty);
//					subValue = subValue.abs();
//					// 值变化较小时 不更新
//					if(!qty.equals(subValue) &&  subValue.compareTo(new BigDecimal("0.00001")) < 0){
//						qty = oldQty;
//					}
//					
//					// wgj add  触发数量更改重算
//					
////					KDTEditEvent editEvent=new KDTEditEvent(param.getKDTable("kdtEntries"), oldQty, qty, rowIndex, param.getKDTable("kdtEntries").getCell(rowIndex,"qty").getColumnIndex(), false, 1);
//					
//					ui.getUiHelper().calByEntryQtyChange(rowIndex, colIndex);
////					ui.kdtEntries_Changed(editEvent);
//			
//				}
////				ui.kdtEntries_Changed(editEvent);
//				//com.kingdee.eas.util.client.MsgBox.showInfo("aa2");
//	        }
//		
//        }
//        
//        
//
//
//        
//        
//	}
//
//	
//	
	/**
	   * 分录更新 设置 分录编辑的次数
	   * @param param
	   * @param rowIndex
	   * @param colIndex
	   * @throws Exception
	   */
	public void updateEntryEditTimes(UIParam param) throws Exception{
		ui = (SaleOrderEditUIPIEx) param.getUI();

		editData = (SaleOrderInfo) ui.getEditData();
		
		// 设置加载次数
//		ui.setEntryEditTimes(ui.getEntryEditTimes() + 1);
		
		
	}
	/**
	   * 分录更新 (即将废弃)
	   * @param param
	   * @param rowIndex
	   * @param colIndex
	   * @throws Exception
	   */
	public void kdtEntries_Changed(UIParam param,KDTEditEvent e,int rowIndex,int colIndex) throws Exception{
		
		
		ui = (SaleOrderEditUIPIEx) param.getUI();
		editData = (SaleOrderInfo) ui.getEditData();
		// 先调用标准产品功能 后再执行
		ui.kdtEntries_Changed(e);
		
//			// loadfied执行完成后才调用 事件
//			String loadFieldsEnd = (String)param.getUIContext().get("loadFieldsEnd");
//			if("0".equals(loadFieldsEnd)){
//				return;
//			}
        String fieldName = param.getKDTable("kdtEntries").getColumnKey(colIndex);
       
        //  含税单价问题
        if("basePrice".equalsIgnoreCase(fieldName)){
        	updatePrice(param,e,rowIndex,colIndex);
        }else {
    
        	BigDecimal taxPrice = (BigDecimal)param.getKDTable("kdtEntries").getCell(rowIndex,"taxPrice").getValue();
        	if(taxPrice != null){
        		BigDecimal exchangeRate = getExchangeRate(param, rowIndex);
        		BigDecimal baseUnitPrice = taxPrice.divide(exchangeRate,6,RoundingMode.HALF_UP);
        		// 设置基本含税单价
        		param.getKDTable("kdtEntries").getCell(rowIndex,"basePrice").setValue(baseUnitPrice);
        	}
        }
        // 基本数量修改
        if("baseQty".equalsIgnoreCase(fieldName)){
        	
        	if(param.getKDTable("kdtEntries").getRow(rowIndex).getCell("baseUnit").getValue()==null||
        			param.getKDTable("kdtEntries").getRow(rowIndex).getCell("unit").getValue()==null) {
				return;
			}
        	BigDecimal baseQty=BigDecimal.ZERO;
			if(param.getKDTable("kdtEntries").getRow(rowIndex).getCell("baseQty").getValue()!=null)
				baseQty=new java.math.BigDecimal(param.getKDTable("kdtEntries").getRow(rowIndex).getCell("baseQty").getValue().toString());
			MeasureUnitInfo  unit=(MeasureUnitInfo) param.getKDTable("kdtEntries").getRow(rowIndex).getCell("unit").getValue();
			
			BigDecimal coeff = new BigDecimal("1");
			if(unit != null){
				coeff=unit.getCoefficient();
			}
			if(coeff == null){
				unit = MeasureUnitFactory.getRemoteInstance().getMeasureUnitInfo(new ObjectUuidPK(unit.getId()));
				coeff = unit.getCoefficient();
			}
			if(coeff==null||coeff.compareTo(java.math.BigDecimal.ZERO)==0) {
				return;
			}
			// 原数据
			BigDecimal oldQty = (BigDecimal) param.getKDTable("kdtEntries").getCell(e.getRowIndex(), "qty").getValue();
			if(oldQty == null){
				oldQty = new BigDecimal("0.00");
			}
			
			//基本计量单位*换算系数
			BigDecimal qty=baseQty.divide(coeff,4,java.math.BigDecimal.ROUND_HALF_UP);
			if(qty == null){
				qty = new BigDecimal("0.00");
			}
			
			BigDecimal qtySubValue = oldQty.subtract(qty);
			if(!oldQty.equals(qty) && (qtySubValue.compareTo(new BigDecimal("0.01")) > 0 || qtySubValue.compareTo(new BigDecimal("-0.01")) < 0)){
				param.getKDTable("kdtEntries").getRow(rowIndex).getCell("qty").setValue(qty);
				
				BigDecimal subValue = oldQty.subtract(qty);
				subValue = subValue.abs();
				// 值变化较小时 不更新
				if(!qty.equals(subValue) &&  subValue.compareTo(new BigDecimal("0.01")) > 0){
					qty = oldQty;
				}
				
				// wgj add  触发数量更改重算
				
				KDTEditEvent editEvent=new KDTEditEvent(param.getKDTable("kdtEntries"), oldQty, qty, rowIndex, param.getKDTable("kdtEntries").getCell(rowIndex,"qty").getColumnIndex(), false, 1);
				
				
				ui.kdtEntries_Changed(editEvent);
				// 判断是否已经设置了 销售价格，如果没有设置，那么自动取出设置到售价上
				BigDecimal taxPrice = (BigDecimal) param.getKDTable("kdtEntries").getCell(rowIndex,"taxPrice").getValue();
				if(taxPrice == null || taxPrice.compareTo(BigDecimal.ZERO) == 0){
					if(SysContext.getSysContext().getCurrentSaleUnit() != null &&
							param.getKDBizPromptBox("prmtOrderCustomer").getValue() != null &&
							param.getKDTable("kdtEntries").getCell(rowIndex,"material") != null && 
							param.getKDTable("kdtEntries").getRow(rowIndex).getCell("unit") != null){
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						Date bizdate = param.getKDDatePicker("pkBizDate").getSqlDate();
						if(bizdate == null ){
							bizdate = new Date();
						}
					
				
						String bizDateStr = sdf.format(bizdate);
						CustomerInfo currCustomerInfo = (CustomerInfo) param.getKDBizPromptBox("prmtOrderCustomer").getValue();
						MaterialInfo materialInfo = (MaterialInfo) param.getKDTable("kdtEntries").getCell(rowIndex,"material").getValue();
						MeasureUnitInfo unitInfo = (MeasureUnitInfo)param.getKDTable("kdtEntries").getCell(rowIndex,"unit").getValue();
						MeasureUnitInfo baseUnitInfo = (MeasureUnitInfo)param.getKDTable("kdtEntries").getCell(rowIndex,"baseUnit").getValue();
						BigDecimal price = SalePriceFacadeFactory.getRemoteInstance().getMaterialPolicyPrice(
								SysContext.getSysContext().getCurrentSaleUnit().getId().toString(),
								currCustomerInfo.getId().toString(), 
								materialInfo.getId().toString(),
								bizDateStr, 
								baseQty, 
								"gw5fUwEOEADgAAsRwKgSOFuCXFc=");
						if(price != null){
							param.getKDTable("kdtEntries").getCell(rowIndex,"basePrice").setValue(price);
						}
						
					}
				}else{
					BigDecimal basePrice = (BigDecimal) param.getKDTable("kdtEntries").getCell(rowIndex,"basePrice").getValue();
					if(basePrice == null || taxPrice.compareTo(BigDecimal.ZERO) == 0){
					// 获得转换系数
					BigDecimal exchangeRate = getExchangeRate(param, rowIndex);
					
					basePrice = taxPrice.divide(exchangeRate,6,RoundingMode.HALF_UP);
					
					param.getKDTable("kdtEntries").getCell(rowIndex,"basePrice").setValue(basePrice);
					}
					
				}
				updatePrice(param,null,rowIndex,param.getKDTable("kdtEntries").getCell(rowIndex,"basePrice").getColumnIndex());
//				ui.getUiHelper().calEntryPriceByTaxPrice(rowIndex, 0);
//				ui.getUiHelper().calByEntryTaxPriceChange(rowIndex, colIndex);
//				afterChangeUnitQty(param,editEvent,qty,rowIndex,"qty");
			}
//			ui.kdtEntries_Changed(editEvent);
			//com.kingdee.eas.util.client.MsgBox.showInfo("aa2");
        }
        
        
        
        
//	        else if("amount".equalsIgnoreCase(fieldName) ||
//	        		"material".equalsIgnoreCase(fieldName)  ||
//	        		"price".equalsIgnoreCase(fieldName) ||
//	        		"taxRate".equalsIgnoreCase(fieldName) ||
//	        		"amount".equalsIgnoreCase(fieldName) || 
//	        		"tax".equalsIgnoreCase(fieldName)|| 
//	        		"unit".equalsIgnoreCase(fieldName) || 
//	        		"taxAmount".equalsIgnoreCase(fieldName)){
//	        	
//	        	ui.getUiHelper().calEntryTaxPrice(rowIndex, 0);
//	        	BigDecimal taxPrice = (BigDecimal)param.getKDTable("kdtEntries").getCell(rowIndex,"taxPrice").getValue();
//	        	if(taxPrice != null){
//	        		BigDecimal exchangeRate = getExchangeRate(param, rowIndex);
//	        		BigDecimal baseUnitPrice = taxPrice.divide(exchangeRate,6,RoundingMode.HALF_UP);
//	        		// 设置基本含税单价
//	        		param.getKDTable("kdtEntries").getCell(rowIndex,"basePrice").setValue(baseUnitPrice);
//	        	}
//	        }
        
	        
        
        
        
	}
	
//	/**
//	 * 
//	 * @return
//	 */
//	private BigDecimal getMaterialBasePrice(){
//		
//	}
	
	/**
	 * 根据基本含税单价计算单价和其他字段
	 * @param param
	 * @param rowIndex
	 * @param colIndex
	 * @throws Exception 
	 */
	private void updatePrice(UIParam param,KDTEditEvent e, int rowIndex, int colIndex) throws Exception {
		ui = (SaleOrderEditUIPIEx) param.getUI();
		editData = (SaleOrderInfo) ui.getEditData();
//		Object oldValue = e.getOldValue();
		BigDecimal basePrice = (BigDecimal)param.getKDTable("kdtEntries").getCell(rowIndex,"basePrice").getValue();
		if(basePrice == null){
			basePrice = BigDecimal.ZERO;
		}
		// 获得转换系数
		BigDecimal exchangeRate = getExchangeRate(param, rowIndex);
		
		BigDecimal taxPrice = basePrice.multiply(exchangeRate);
		if(taxPrice == null){
			taxPrice = new BigDecimal("0.00");
		}
		BigDecimal oldTaxPrice = (BigDecimal)param.getKDTable("kdtEntries").getCell(rowIndex,"taxPrice").getValue();
		if(oldTaxPrice == null){
			oldTaxPrice = new BigDecimal("0.00");
		}
		if(oldTaxPrice != null && !oldTaxPrice.equals(taxPrice)){
			
			
			BigDecimal subValue = oldTaxPrice.subtract(taxPrice);
			subValue = subValue.abs();
			// 值变化较小时 不更新
			if(!taxPrice.equals(subValue) &&  subValue.compareTo(new BigDecimal("0.00001")) < 0){
				taxPrice = oldTaxPrice;
			}
			
			/********************************20160220 增加最低限价控制***************************************/
			
//			MaterialInfo materialInfo = (MaterialInfo) param.getKDTable("kdtEntries").getRow(rowIndex).getCell("material").getValue();
//			MeasureUnitInfo baseUnitInfo = (MeasureUnitInfo) param.getKDTable("kdtEntries").getRow(rowIndex).getCell("baseUnit").getValue();
//			SaleOrgUnitInfo saleOrg = editData.getSaleOrgUnit();
//			if(materialInfo != null && baseUnitInfo != null && saleOrg != null){
//				MaterialBasePriceInfo basePriceInfo = ToolFacadeFactory.getRemoteInstance().getMaterialBasePrice(saleOrg.getId().toString(),null,materialInfo.getId().toString(),  baseUnitInfo.getId().toString(), null);
//				
//				if(basePriceInfo != null){
//					basePriceInfo = MaterialBasePriceFactory.getRemoteInstance().getMaterialBasePriceInfo(new ObjectUuidPK(basePriceInfo.getId()));
//					// 获得最低限价
//					BigDecimal floorPrice = basePriceInfo.getFloorPrice();
//					if(floorPrice != null && floorPrice.compareTo(basePrice) > 0){
//						MsgBox.showInfo("基本单价不能小于最低限价"+floorPrice.toPlainString());
//						
//						BigDecimal basePriceEven = oldTaxPrice.divide(exchangeRate,6,RoundingMode.HALF_UP);
//						param.getKDTable("kdtEntries").getCell(rowIndex,"basePrice").setValue(basePriceEven);
//						taxPrice = oldTaxPrice;
//					}
//				}
//			
//			}
			/********************************20160220 增加最低限价控制***************************************/
			
			// 设置基本含税单价
//			param.getKDTable("kdtEntries").getCell(rowIndex,"basePrice").setValue(oldValue);
			param.getKDTable("kdtEntries").getCell(rowIndex,"taxPrice").setValue(taxPrice);
			
			

//			ui.getUiHelper().calEntryActualPrice(rowIndex, 0);
//			ui.getUiHelper().calEntryActualTaxPrice(rowIndex, 0);
//			ui.getUiHelper().calEntryTaxAmount(rowIndex, colIndex);
//			ui.getUiHelper().calEntryAmount(rowIndex, rowIndex);
//			ui.getUiHelper().calByEntryTaxPriceChange(rowIndex, colIndex);
//			ui.getUiHelper().calByEntryQtyChange(rowIndex, colIndex);
//			ui.getui
//			ui.kdtEntries_Changed(editEvent);
		}

		KDTEditEvent editEvent=new KDTEditEvent(param.getKDTable("kdtEntries"), null, taxPrice, rowIndex, param.getKDTable("kdtEntries").getCell(rowIndex,"taxPrice").getColumnIndex(), false, 1);
		ui.kdtEntries_Changed(editEvent);
//			
//			IMacthUiIsOK mui = (IMacthUiIsOK)ui.getUIWindow().getUIObject();
//			mui.destroyWindow();
		
	}
	/**
	 * 获得指定行的  计量单位和基本计量单位间的换算系数
	 * @param param
	 * @param rowIndex
	 * @param colIndex
	 * @return 如果 计量单位和基本计量单位有一个为空则返回0，否则返回他们间由计量单位换算为基本计量单位的系数
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private BigDecimal getExchangeRate(UIParam param, int rowIndex) throws BOSException, EASBizException{
		ui = (SaleOrderEditUIPIEx) param.getUI();
		editData = (SaleOrderInfo) ui.getEditData();
		// 换算率缓存
//		Map<String,BigDecimal> unitTransMap = ui.getUnitTransMap();
//		if(unitTransMap == null){
//			unitTransMap = new HashMap<String,BigDecimal>();
//		}
		BigDecimal exchangeRate = new BigDecimal("1.00");
		MaterialInfo materialInfo = (MaterialInfo) param.getKDTable("kdtEntries").getCell(rowIndex,"material").getValue();
		MeasureUnitInfo unitInfo = (MeasureUnitInfo)param.getKDTable("kdtEntries").getCell(rowIndex,"unit").getValue();
		MeasureUnitInfo baseUnitInfo = (MeasureUnitInfo)param.getKDTable("kdtEntries").getCell(rowIndex,"baseUnit").getValue();
		if(unitInfo != null && baseUnitInfo != null && materialInfo!= null && !unitInfo.getId().toString().equals(baseUnitInfo.getId().toString())){
			String materialID = materialInfo.getId().toString();
			// 如果缓存中已经存在  则直接返回缓存数据
//			BigDecimal unitTransRate = unitTransMap.get(unitInfo.getId().toString() + baseUnitInfo.getId().toString());
//			if(unitTransRate != null) return unitTransRate;
			
			
			IMultiMeasureUnit multiUnit = MultiMeasureUnitFactory.getRemoteInstance();
			
//				MultiMeasureUnitInfo multiUnifInfo = multiUnit.getMultiUnit(materialID, baseUnitInfo.getId().toString());
			
			MultiMeasureUnitInfo othermultiUnifInfo = multiUnit.getMultiUnit(materialID, unitInfo.getId().toString());
			
			if ((othermultiUnifInfo != null)) {
				
//					BigDecimal baseExchangeRate1 = multiUnifInfo.getBaseConvsRate();
				exchangeRate= othermultiUnifInfo.getBaseConvsRate();
//					if (baseExchangeRate1 == null) {
//						baseExchangeRate1 = new BigDecimal("1.00");
//					}
				if (exchangeRate == null) {
					exchangeRate = new BigDecimal("1.00");
				}
				
			}
			
			
			// 增加到缓存
//			unitTransMap.put(unitInfo.getId().toString() + baseUnitInfo.getId().toString(), exchangeRate);
//			ui.setUnitTransMap(unitTransMap);
		}
		return exchangeRate;
	}
	
	
	/**
	 * 修改订货客户或者 销售组织后重新计算客户可用折让余额
	 * @param param
	 * @throws BOSException 
	 */
	public void updateCanUseDis(UIParam param) throws BOSException{
		ui = (SaleOrderEditUIPIEx) param.getUI();
		editData = (SaleOrderInfo) ui.getEditData();
		
		CustomerInfo orderCustomer = (CustomerInfo) param.getKDBizPromptBox("prmtOrderCustomer").getValue();
		SaleOrgUnitInfo saleOrgUnitInfo = (SaleOrgUnitInfo) param.getKDBizPromptBox("prmtSaleOrgUnit").getValue();
		
		BigDecimal canUseDis = BigDecimal.ZERO;
		if(orderCustomer != null || saleOrgUnitInfo != null){
			CustomerBalanceInfo cusBalance = SaleDiscountFacadeFactory.getRemoteInstance().getCustomerBalanceInfo(saleOrgUnitInfo.getId().toString(), orderCustomer.getId().toString());
			if(cusBalance != null && cusBalance.getNowBalance() != null){
				canUseDis = cusBalance.getNowBalance();
			}
		}
		
		param.getKDFormattedTextField("txtcanUseDis").setValue(canUseDis);
		
	}

	/**
	 * 校验 使用余额是否大于可用余额
	 * @param param
	 */
	public void checkUseDisAmount(UIParam param){
		BigDecimal canUseAmount = param.getKDFormattedTextField("txtcanUseDis").getBigDecimalValue();
		BigDecimal useDis = param.getKDFormattedTextField("txtuseDis").getBigDecimalValue();
		if(useDis != null){
			if(canUseAmount != null){
				if(useDis.compareTo(canUseAmount) > 0){
					MsgBox.showInfo("使用余额不能大于当前客户的可用余额");
					SysUtil.abort();
				}
			}else{
				MsgBox.showInfo("当前客户可用余额为空，不能使用折让余额");
				SysUtil.abort();
			}
		}
	}
	/**
	 * 根据各个分录的 销量 基本数量拆分 使用折让金额到 分录中，尾差 放到最后一行分录
	 * @param param
	 * @throws ParseException 
	 */
	public void splitUseDisToEntry(UIParam param) throws ParseException{
		param.getKDFormattedTextField("txtuseDis").commitEdit();
		BigDecimal useDis = param.getKDFormattedTextField("txtuseDis").getBigDecimalValue();
		useDis = (useDis == null?BigDecimal.ZERO:useDis);
		if(useDis != null ){
			// 价税合计
			BigDecimal txtTotalTaxAmount = param.getKDFormattedTextField("txtTotalTaxAmount").getBigDecimalValue();
			if(txtTotalTaxAmount != null && txtTotalTaxAmount.compareTo(BigDecimal.ZERO) > 0){
				
				BigDecimal hasSplitAmount = BigDecimal.ZERO;
				// 拆分比例
				BigDecimal splitRate = useDis.divide(txtTotalTaxAmount, 6, RoundingMode.HALF_UP);
				KDTable entryTable = param.getKDTable("kdtEntries");
				
				// 记录最后一笔非0的分摊
				BigDecimal lastSplitDis = BigDecimal.ZERO;
				int lastSplitSeq = -1;
				// 逐行分摊金额
				for(int i = 0; i < entryTable.getRowCount(); i++){
					BigDecimal taxAmount = (BigDecimal) entryTable.getRow(i).getCell("taxAmount").getValue();
					BigDecimal afterDisAmount = taxAmount.multiply(new BigDecimal(1));
					
					if(taxAmount != null){
						BigDecimal entryDis = taxAmount.multiply(splitRate);
						// 取两位有效数字
						entryDis = entryDis.setScale(2,RoundingMode.HALF_UP);
						hasSplitAmount = hasSplitAmount.add(entryDis);
						// 保存分录分摊折让
						entryTable.getRow(i).getCell("dis").setValue(entryDis);
						
						if(entryDis != null && entryDis.compareTo(BigDecimal.ZERO) > 0){
							lastSplitDis = entryDis;
							lastSplitSeq = i;
						}
						
						// 计算折让后价税合计、这让后单价
						afterDisAmount = afterDisAmount.subtract(entryDis);
						entryTable.getRow(i).getCell("afterDisAmount").setValue(afterDisAmount);
						BigDecimal afterDisBasePrice = BigDecimal.ZERO;
						BigDecimal baseQty = (BigDecimal) entryTable.getRow(i).getCell("baseQty").getValue();
						if(baseQty != null && baseQty.compareTo(BigDecimal.ZERO) > 0){
							afterDisBasePrice = afterDisAmount.divide(baseQty,6, RoundingMode.HALF_UP);
						}
						
						entryTable.getRow(i).getCell("afterDisBasePrice").setValue(afterDisBasePrice);
						
						
					}
				}
				
				// 如果分摊后有差额 则累计到最后一行有折让的分录中，并重新计算单价
				if(hasSplitAmount != null && hasSplitAmount.compareTo(useDis) != 0){
					BigDecimal remainDis = useDis.subtract(hasSplitAmount);
					if(lastSplitSeq != -1){
						BigDecimal dis = (BigDecimal) entryTable.getRow(lastSplitSeq).getCell("dis").getValue();
						if(dis != null && dis.compareTo(BigDecimal.ZERO) != 0){
							dis = dis.add(remainDis);
							entryTable.getRow(lastSplitSeq).getCell("dis").setValue(dis);
							BigDecimal baseQty = (BigDecimal) entryTable.getRow(lastSplitSeq).getCell("baseQty").getValue();
							BigDecimal taxAmount = (BigDecimal) entryTable.getRow(lastSplitSeq).getCell("taxAmount").getValue();
							BigDecimal afterDisAmount = taxAmount.multiply(new BigDecimal(1));
							
							// 重新计算折让后金额
							afterDisAmount = afterDisAmount.subtract(dis);
							entryTable.getRow(lastSplitSeq).getCell("afterDisAmount").setValue(afterDisAmount);
							BigDecimal afterDisBasePrice = BigDecimal.ZERO;
							
						
							
							if(baseQty != null && baseQty.compareTo(BigDecimal.ZERO) > 0){
								afterDisBasePrice = afterDisAmount.divide(baseQty,6, RoundingMode.HALF_UP);
							}
							
							entryTable.getRow(lastSplitSeq).getCell("afterDisBasePrice").setValue(afterDisBasePrice);
						}
					}
					
				}
			}
			
		
			
		}
		
	}
	
	/**
	 * 
	 * @param param
	 */
	public void addUpdateCanUseDisListener(final UIParam param){
		
		
		 param.getKDBizPromptBox("prmtOrderCustomer").addDataChangeListener(new DataChangeListener(){
				public void dataChanged(DataChangeEvent e) {
					try {
						updateCanUseDis(param);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
	        	
	        });
		 
		 
		 param.getKDBizPromptBox("prmtSaleOrgUnit").addDataChangeListener(new DataChangeListener(){
				public void dataChanged(DataChangeEvent e) {
					try {
						updateCanUseDis(param);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
	        	
	        });
		 
		
		
	}
	/**
	 * 遍历分录上的物料，查询可用库存并提醒
	 * @param param
	 * @throws ParseException 
	 */
	public void EntryMaterial(UIParam param) throws ParseException{
		
	
		KDTable entryTable = param.getKDTable("kdtEntries");
		// 逐行分摊金额
		for(int i = 0; i < entryTable.getRowCount(); i++){
			if(entryTable.getRow(i).getCell("material").getValue()!=null){
				String mid = ((MaterialInfo)entryTable.getRow(i).getCell("material").getValue()).getId().toString();
				try {
					MaterialInfo material = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(mid));
					if(material.getName().toString().contains("鲜")){
						System.out.println("鲜品不参与库存校验");
					}else{
						String AllQty = getMaterialQty(mid);
						String HisQty = getMaterialHisQty(mid);
						BigDecimal BAllQty = new BigDecimal(AllQty);
						BigDecimal BHisQty = new BigDecimal(HisQty);
						BAllQty = BAllQty.subtract(BHisQty);
						if(entryTable.getRow(i).getCell("qty").getValue()!=null){
							BigDecimal Qty = (BigDecimal) entryTable.getRow(i).getCell("qty").getValue();
							BAllQty = BAllQty.subtract(Qty);
							if(BAllQty.compareTo(BigDecimal.ZERO)<0){
								MsgBox.showInfo("第 "+i+1+"行物料可用库存不足，建议检查库存日报表！");
							}
						}
					}
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BOSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		
		
		
	}
	private String getMaterialHisQty(String mid) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("/*dialect*/").append(sp);
		sql.append("select ").append(sp);
		sql.append("nvl(sum(t2.FQty),0) FQty").append(sp);
		sql.append("from ").append(sp);
		sql.append("T_SD_SaleOrder t1").append(sp);
		sql.append("inner join T_SD_SaleOrderEntry t2 on t2.FPARENTID = t1.FID").append(sp);
		sql.append("inner join T_BD_Material t3 on t3.FID = T2.FMaterialID").append(sp);
		sql.append("where").append(sp);
		sql.append("to_char(t1.FBIZDATE,'yyyy-MM-dd')= to_char(SYSDATE,'yyyy-MM-dd')").append(sp);
		sql.append("and t1.FBaseStatus=4").append(sp);
		sql.append("and t3.FID='"+mid+"'").append(sp);
		IRowSet rs;
		String price = "0";
		try {
			rs = CommSqlFacadeFactory.getRemoteInstance().executeQuery(sql.toString());
			while(rs.next()){
				price = rs.getString("FQty");
				return price;
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}
	private String getMaterialQty(String mid) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		String sp = "\n";
		sql.append("/*dialect*/").append(sp);
		sql.append("select ").append(sp);
		sql.append("sum(nvl(t2.FCurStoreQty,0))+nvl(tt2.weight,0)		allWgt	").append(sp);
		sql.append("from").append(sp);
		sql.append("T_BD_Material				t1").append(sp);
		sql.append("left join T_IM_Inventory			t2 on t2.FMaterialID = t1.FID").append(sp);
		sql.append("left join T_BD_MeasureUnit 		t3 on t3.fid=t2.FUnitID ").append(sp);
		sql.append("left join T_DB_LOCATION    		t4 on t4.fid=t2.FLocationID ").append(sp);
		sql.append("inner join T_BD_MaterialGroup t6 on t6.FID = t1.FMaterialGroupID").append(sp);
		sql.append("left join T_BD_MaterialGroup t7 on t7.FID = t6.FParentID").append(sp);
		sql.append("left join T_BD_MaterialGroup t8 on t8.FID = t7.FParentID").append(sp);
		sql.append("left join ").append(sp);
		sql.append("(").append(sp);
		sql.append("select ").append(sp);
		sql.append("t1.FID				materialID,").append(sp);
		sql.append("sum(t2.CFWeight)			weight").append(sp);
		sql.append("from").append(sp);
		sql.append("T_BD_Material						t1").append(sp);
		sql.append("inner join CT_SZC_SzSemiProductEntry			t2	on t2.CFMaterialID = t1.FID").append(sp);
		sql.append("inner join CT_SZC_SzSemiProduct				t3	on t3.FID = t2.FParentID").append(sp);
		sql.append("where t3.CFCount = '0'").append(sp);
		sql.append("and to_char(t3.FBIZDATE,'yyyy-MM-dd')= to_char(SYSDATE,'yyyy-MM-dd')").append(sp);
		sql.append("and t1.FID = '"+mid+"'").append(sp);
		sql.append("group by t1.FID").append(sp);
		
		sql.append(")				tt2	on tt2.materialID = t1.FID").append(sp);
		sql.append("where  (t2.fbaseQty<>0 or tt2.weight <>0)").append(sp);
		sql.append("and t1.FID  = '"+mid+"'").append(sp);
		sql.append("group by nvl(tt2.weight,0)").append(sp);
	//	sql.append("order by t1.fnumber").append(sp);
		IRowSet rs;
		String price = "0";
		try {
			rs = CommSqlFacadeFactory.getRemoteInstance().executeQuery(sql.toString());
			while(rs.next()){
				price = rs.getString("allWgt");
				return price;
			}
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}
	
	
	
	
	
}
