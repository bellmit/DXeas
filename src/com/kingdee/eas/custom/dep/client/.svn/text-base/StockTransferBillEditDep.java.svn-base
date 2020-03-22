package com.kingdee.eas.custom.dep.client;


/**
 * 库存调拨单 编辑 dep
 * @author Administrator
 *
 */
public class StockTransferBillEditDep {
//
//	// 编辑界面
//	protected StockTransferBillEditUIPIEx ui;
//	// 界面 对象
//	protected StockTransferBillInfo editData;
//	
//	
//	/**
//	 * 自动调拨 后处理
//	 * @param param
//	 * @param e
//	 * @throws Exception
//	 */
////	public void afterActionAutoTransfer(UIParam param)throws Exception   {
////		ui = (StockTransferBillEditUIPIEx) param.getUI();
////		 editData = (StockTransferBillInfo) ui.getEditData();
////		 
////		 if ((editData != null) && (editData.getId() != null)){
////			 String id=editData.getId().toString();
////		        StringBuffer sql=new StringBuffer();
////		        sql.append(" select t1.FDESTENTITYID,t2.fsrcentryid,t2.fdestentryid,t3.CFSupplierAID  ");
////		        sql.append(" from t_bot_relation t1 ");
////		        sql.append(" inner join t_bot_relationentry t2 on t2.fkeyid=t1.fid ");
////		        sql.append(" inner join t_im_stocktransferbillentry  t3 on t3.fid=t2.fsrcentryid ");
////		        sql.append(" where t1.fsrcobjectid='"+id+"' ");
////		        sql.append(" and isnull(t3.CFSupplierAID,'0')<>'0' ");
////		        IRowSet rs=JackFacadeFactory.getRemoteInstance().GetSqlData(sql.toString());
////		        while(rs.next()){
////		        	String destentityid=rs.getString("FDESTENTITYID");
////		        	
////		        	String srcentryid=rs.getString("fsrcentryid");
////		        	String destentryid=rs.getString("fdestentryid");
////		        	String supplierid=rs.getString("CFSupplierAID");
////		        	if(destentityid.equals("E3DAFF63")){
////			        	sql=new StringBuffer();
////			        	sql.append(" update t_im_moveinwarehsbillentry  set fsupplierid='"+supplierid+"' ");//调拨入库单 E3DAFF63
////			        	sql.append(" where fid='"+destentryid+"'");
////			        	JackFacadeFactory.getRemoteInstance().ExecProc(sql.toString());
////		        	}else{
////		        		sql=new StringBuffer();
////			        	sql.append(" update t_im_moveissuebillentry  set fsupplierid='"+supplierid+"' ");//调拨出库单 71D272F1
////			        	sql.append(" where fid='"+destentryid+"'");
////			        	JackFacadeFactory.getRemoteInstance().ExecProc(sql.toString());
////		        	}
////		        }
////		  }
////	}
//	/**
//	 * 表格编辑事件 
//	 * @param param
//	 * @param e
//	 * @throws Exception
//	 */
//	public void tableValueChanged(UIParam param, KDTEditEvent e) throws Exception {
//		// TODO Auto-generated method stub
//		 ui = (StockTransferBillEditUIPIEx) param.getUI();
//		 editData = (StockTransferBillInfo) ui.getEditData();
//		 
//		 KDTable detailTable = param.getKDTable("detailTable");
//		 int selectRow = e.getRowIndex();
//		 int selectCol = e.getColIndex();
//		 
//		
//		 IRow curRow = detailTable.getRow(selectRow);
//		
//		 KDTable kDTable = (KDTable)e.getSource();
//		 String colName = kDTable.getColumnKey(e.getColIndex());
//		 if (("lot".equals(colName)) &&(e.getValue() != null) ) {
//			   MaterialInfo info=(MaterialInfo)detailTable.getRow(selectRow).getCell("materialNum").getValue();
//			   if(info.getId()!=null){
//				   setKDTable(detailTable,selectRow,"materialNum"); 
//			   }
//		        //UIHelper.registerTrackNumberF7(getMainOrgUnit(), null, this.kdtEntry, "projectNumCol", "trackNumCol", false);
//		 }
//		 if (("materialNum".equals(colName)) && (e.getValue() != null)){
//			 MaterialInfo info=(MaterialInfo)e.getValue();
//			 detailTable.getRow(selectRow).getCell("materialAlias").setValue(info.getAlias());
//			 
//			   if(detailTable.getRow(selectRow).getCell("lot").getValue()!=null){
//				   setKDTable(detailTable,selectRow,"materialNum");
//			       
//			   }
//		 }else if("materialNum".equals(colName)) {
//			 detailTable.getRow(selectRow).getCell("materialAlias").setValue("");
//		 }
//	}
//	
//	 public void setKDTable(KDTable kdtable,int selectRow,String mcolName) throws EASBizException, BOSException, SQLException{
//		   String lot=(String)kdtable.getRow(selectRow).getCell("lot").getValue();
//		   MaterialInfo info=(MaterialInfo)kdtable.getRow(selectRow).getCell(mcolName).getValue();
//		   String materialId=info.getId().toString();
//		   String materialAlias = info.getAlias();
//		   kdtable.getRow(selectRow).getCell("materialAlias").setValue(materialAlias);
//		   
//	       StringBuffer sql=new StringBuffer();
//	       sql.append(" select t1.fsupplierid, t2.CFmanufactureDate,t2.CFexpirationDate,t2.CFcheckInforM  ");
//	       sql.append(" from t_im_PurInWarehsbill t1 ");
//	       sql.append(" inner join t_im_PurInWarehsentry t2 on t2.fparentid=t1.fid ");
//	       sql.append(" where t2.FMATERIALID='"+materialId+"'");
//	       sql.append(" and t2.FLot='"+lot+"' ");
//	       IRowSet rs=JackFacadeFactory.getRemoteInstance().GetSqlData(sql.toString());
//	       if(rs.next()){
//	    	   kdtable.getRow(selectRow).getCell("manufactureDate").setValue(rs.getDate("CFmanufactureDate"));
//	    	   kdtable.getRow(selectRow).getCell("expirationDate").setValue(rs.getDate("CFexpirationDate"));
//	    	   if(rs.getString("CFcheckInforM")!=null){
//	    		   String checkinfor=rs.getString("CFcheckInforM");
//	    		   if(checkinfor.equals("0")){
//	    			   kdtable.getRow(selectRow).getCell("checkInforM").setValue("不合格");
//	    		   }else if(checkinfor.equals("1")){
//	    			   kdtable.getRow(selectRow).getCell("checkInforM").setValue("合格");
//	    		   }else if(checkinfor.equals("2")){
//	    			   kdtable.getRow(selectRow).getCell("checkInforM").setValue("待检");
//	    		   }
//	    	   }else{
//	    		   kdtable.getRow(selectRow).getCell("checkInforM").setValue("待检");
//	    	   }
//	    	   
//	    	   if(rs.getString("fsupplierid")!=null){
//	    		   String supplierId=rs.getString("fsupplierid");
//	    		   if(!supplierId.equals("")){
//	    			   ObjectUuidPK pk=new ObjectUuidPK(supplierId);
//	    			   SupplierInfo supinfo=SupplierFactory.getRemoteInstance().getSupplierInfo(pk);
//	    			   kdtable.getRow(selectRow).getCell("supplier").setValue(supinfo); //supplierA
//	    			   kdtable.getRow(selectRow).getCell("supplierA").setValue(supinfo); //supplierA
//	    		   }
//	    	   }
//	       }else{
//	    	   //this.kdtEntry.getRow(selectRow).getCell("manufactureDate").setValue(new Date());
//	    	   //this.kdtEntry.getRow(selectRow).getCell("expirationDate").setValue(new Date()); 
//	    	   //this.kdtEntry.getRow(selectRow).getCell("checkInforM").setValue("待检");
//	       }
//	 }
//	 /**
//	 * 初始化时添加  计算投料量事件
//	 */
//	public void afterOnload(UIParam param){
//		 ui = (StockTransferBillEditUIPIEx) param.getUI();
//		 editData = (StockTransferBillInfo) ui.getEditData();
//		 
//	}
//	 /**
//		 * 根据选中的猪苗日龄和 数量 生成分录 
//		 * @param e
//		 * @throws Exception
//		 */
//		public void actionGetPiggyEntrys(UIParam param,ActionEvent e) throws Exception {
//			
//			 ui = (StockTransferBillEditUIPIEx) param.getUI();
//			 editData = (StockTransferBillInfo) ui.getEditData();
//			 
//			 KDTable detailTable = param.getKDTable("detailTable");
//
//			if(ui.STATUS_EDIT.equals(ui.getOprtState()) || ui.STATUS_ADDNEW.equals(ui.getOprtState())){
//				// 确认猪苗日龄
//				if (param.getKDBizPromptBox("prmtpiggyAge").getValue() == null) {
//					MsgBox.showWarning("请选择猪苗日龄");
//					return;
//				}
//				// 猪苗头数
//				if(param.getKDFormattedTextField("txtpiggyQty").getBigDecimalValue() == null){
//					MsgBox.showWarning("请输入猪苗头数");
//					return;
//				}
//				// 分录中含有内容时  确认后重新插入
//				if(detailTable.getRowCount() >0 &&  MsgBox.showConfirm2("分录中包含数据，按猪苗日龄获取投料量将删除现有分录重新获取，是否确认？") == MsgBox.NO){
//					return;
//				}
//				// 猪苗日龄
//				PiggyAgeInfo piggyAgeInfo = (PiggyAgeInfo)param.getKDBizPromptBox("prmtpiggyAge").getValue();
//				if(piggyAgeInfo != null){
//					PiggyFeedingStandardInfo standardInfo = this.getPiggyAgeFeelings(piggyAgeInfo);
//					if(standardInfo != null){
//						PiggyFeedingStandardEntryCollection entryColl = standardInfo.getEntrys();
//						if(entryColl != null && entryColl.size() > 0){
//							
//
//							IRow row;
//							ICell cell;
////							BigDecimal per = new BigDecimal(this.kdsquantity.getValue().toString());
//							detailTable.removeRows();
//							int materialcol = detailTable.getColumnIndex("materialNum");
//							int qtycol = detailTable.getColumnIndex("qty");
//							
//							int unitcol = detailTable.getColumnIndex("unit");
//							int baseUnit= detailTable.getColumnIndex("baseUnit"); //基本计量单位
//							int baseQty = detailTable.getColumnIndex("baseQty"); //基本单位数量 
//							for (int i = 0; i < entryColl.size(); i++) {
//								// 从标准分录中获取物料设置
//								PiggyFeedingStandardEntryInfo entryInfo = entryColl.get(i);
//								entryInfo = PiggyFeedingStandardEntryFactory.getRemoteInstance().getPiggyFeedingStandardEntryInfo(new ObjectUuidPK(entryInfo.getId()));
//								MaterialInfo materialInfo = entryInfo.getMaterial();
//								BigDecimal qty = entryInfo.getQtyPer();
//								if(materialInfo == null){
//									continue;
//								}
//								MaterialInfo material = MaterialFactory.getRemoteInstance().getMaterialInfo(new ObjectUuidPK(
//										materialInfo.getId()));
//								BigDecimal perQty = qty;// perQty
//								// 头数
//								BigDecimal tQty = param.getKDFormattedTextField("txtpiggyQty").getBigDecimalValue();
//								IMeasureUnit iMeasureUnit = MeasureUnitFactory.getRemoteInstance();
//								if (material != null) {
//									// materialReqBillEntryInfo.setMaterial(material);
//									ui.insertLine(i);
//									row = detailTable.getRow(i);
//									
////									detailTable.getRow(i).getCell("productName").setValue(material);
//									
//									if(material.getBaseUnit().getId()!=null){
//										MeasureUnitInfo measureUnitInfo = iMeasureUnit.getMeasureUnitInfo(new ObjectUuidPK(material.getBaseUnit().getId()));
//										row.getCell("baseUnit").setValue(material.getBaseUnit());//计量单位
//									}
////									CostObjectInfo costobjectInfo = InvClientUtils.getDefaultCostObject(cou,materialInfo,"");
////									
////					                if(costobjectInfo != null)
////					                {
////					                    detailTable.getRow(i).getCell("costObject").setValue(costobjectInfo);
////					                    detailTable.getRow(i).getCell("costObjectName").setValue(costobjectInfo.getName());                    
////					                }
//									
//									row.getCell("materialNum").setValue(material);//产品代码
//									row.getCell("materialAlias").setValue(material.getAlias());  // 别名
//									row.getCell("materialName").setValue(material.getName());
//									row.getCell("lot").getStyleAttributes().setLocked(true);
////									detailTable.getRow(i).getCell("assistantAttr").getStyleAttributes().setLocked(true);
//									ui.afterInsertMaterialInfo(i);
//									KDTEditEvent KDE=new KDTEditEvent(detailTable, null, material, i, materialcol, false, 1);
//									ui.tableValueChanged(KDE);
//									
////									CostItemInfo costItemInfo = InvClientUtils.getDefaultCostItem(cou, material);
////					                if(costItemInfo != null)
////					                {
////					                    detailTable.getRow(i).getCell("costItem").setValue(costItemInfo);
////					                    detailTable.getRow(i).getCell("costItemName").setValue(costItemInfo.getName());                	
////					                }
//									MeasureUnitInfo measureUnitInfo = iMeasureUnit.getMeasureUnitInfo(new ObjectUuidPK(material.getBaseUnit().getId()));
//									row.getCell("unit").setValue(measureUnitInfo);//计量单位
//									
//									KDE=new KDTEditEvent(detailTable, null, measureUnitInfo, i, unitcol, false, 1);
////									this.tableValueChanged(KDE);
//									row.getCell("baseUnit").setValue(material.getBaseUnit());//计量单位
////									this.afterUnitChanged(i,measureUnitInfo);
//									
//									row.getCell("baseQty").setValue(perQty.multiply(tQty));//数量
//									row.getCell("qty").setValue(perQty.multiply(tQty));//数量
////									row.getCell("receiptQty").setValue(perQty.multiply(tQty));//数量
//									//detailTable.getRow(i).getCell("pfQty").setValue(perQty.multiply(per).divide(productQty));//配方数量
////									this.afterQtyChanged(i);
//									KDE=new KDTEditEvent(detailTable, null, perQty.multiply(tQty), i,qtycol, false, 1);
////									this.tableValueChanged(KDE);
//									
//									IWarehouse iWarehouse = WarehouseFactory.getRemoteInstance();
////									if(entryArray.get(i).getDefaultWarehouse()!=null){
////										WarehouseInfo warehouseInfo = iWarehouse.getWarehouseInfo(new ObjectUuidPK(entryArray.get(i).getDefaultWarehouse().getId()));
////										detailTable.getRow(i).getCell("warehouse").setValue(warehouseInfo);//仓库
////									}
//									//this.tableValueChanged(e);	
//								}
//							}
//							
//							
//						}else{
//							MsgBox.showWarning("该日龄投料标准没有分录");
//							return;
//						}
//					}else{
//						MsgBox.showWarning("该日龄没有设置投料标准");
//						return;
//					}
//					
//					
//					
//				}
//				
//			}else{
//				MsgBox.showInfo("非编辑状态不能更新");
//				return;
//			}
//			
//			
//		}
//	 
//	 /**
//		 * 根据日龄获取指定的投料标准分录
//		 * @param piggyAgeInfo
//		 * @return
//		 * @throws BOSException 
//		 * @throws EASBizException 
//		 * @throws SQLException 
//		 */
//		private PiggyFeedingStandardInfo getPiggyAgeFeelings(PiggyAgeInfo piggyAgeInfo) throws EASBizException, BOSException, SQLException{
//			if(piggyAgeInfo != null){
//				StringBuilder sb = new StringBuilder();
//				sb.append("select t.fid from CT_IV_PiggyFeedingStandard t where t.CFPiggyAgeID = '");
//				sb.append(piggyAgeInfo.getId().toString());
//				sb.append("'");
//				IRowSet rs = JackFacadeFactory.getRemoteInstance().GetSqlData(sb.toString());
//				if(rs.next()){
//					String fid = rs.getString("fid");
//					
//					return PiggyFeedingStandardFactory.getRemoteInstance().getPiggyFeedingStandardInfo(new ObjectUuidPK(fid)); 
//				}
//			}
//			
//			return null;
//		}
//	
//	
}
