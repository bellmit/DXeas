package com.kingdee.eas.custom.dep.client;


/**
 * 调拨入库单
 * @author Administrator
 *
 */
public class MoveInWarehsBillEditDep {
//
//	// 编辑界面
//	protected MoveInWarehsBillEditUIPIEx ui;
//	// 界面 对象
//	protected MoveInWarehsBillInfo editData;
//	
//	/**
//	 * onload后 设置界面 空间 内容；添加监听
//	 * @param param
//	 */
//	public void afterOnload(final UIParam param){
//		
//		ui = (MoveInWarehsBillEditUIPIEx) param.getUI();
//		editData = (MoveInWarehsBillInfo) ui.getEditData();
//		
//		//KDTable增加表格编辑事件监听
//		param.getKDTable("detailTable").addKDTEditListener(new KDTEditAdapter(){
//			public void editStopped(KDTEditEvent e) {
//				try {
//					tableValueChanged(param,e);
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
//			}});
//	}
//	
//	/**
//	 * 表格编辑事件
//	 * @param param
//	 * @param selectRow
//	 * @param selectCol
//	 * @throws Exception
//	 */
//	public void tableValueChanged(UIParam param, KDTEditEvent e) throws Exception {
//		
//		 ui = (MoveInWarehsBillEditUIPIEx) param.getUI();
//		 editData = (MoveInWarehsBillInfo) ui.getEditData();
//		 
//		 
//		
//		 KDTable detailTable = param.getKDTable("detailTable");
//		 
//		 int selectRow = e.getRowIndex();
//		 int selectCol = e.getColIndex();
//		 
//		 IRow curRow = detailTable.getRow(selectRow);
//		 String colName = detailTable.getColumnKey(selectCol);
//		 if (("lot".equals(colName)) && (detailTable.getCell(selectRow, selectCol).getValue() != null) ) {
//			   MaterialInfo info=(MaterialInfo)detailTable.getRow(selectRow).getCell("materialNum").getValue();
//			   if(info.getId()!=null){
//				   setKDTable(detailTable, selectRow, "materialNum"); 
//			   }
//		        //UIHelper.registerTrackNumberF7(getMainOrgUnit(), null, this.kdtEntry, "projectNumCol", "trackNumCol", false);
//		 }
//		 if (("materialNum".equals(colName)) && (detailTable.getCell(selectRow, selectCol).getValue() != null)) {
//			   if(detailTable.getRow(selectRow).getCell("lot").getValue()!=null){
//				   setKDTable(detailTable, selectRow, "materialNum");
//			   }
//		 }else if("materialNum".equals(colName)) {
//			 detailTable.getRow(selectRow).getCell("materialAlias").setValue("");
//		 }
//	}
//	public void setKDTable(KDTable kdtable,int selectRow,String mcolName) throws EASBizException, BOSException, SQLException{
//		   String lot=(String)kdtable.getRow(selectRow).getCell("lot").getValue();
//		   MaterialInfo info=(MaterialInfo)kdtable.getRow(selectRow).getCell(mcolName).getValue();
//		   String materialId=info.getId().toString();
//		   String materialAlias = info.getAlias();
//		   kdtable.getRow(selectRow).getCell("materialAlias").setValue(materialAlias);
//		   
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
//	    			   kdtable.getRow(selectRow).getCell("supplier").setValue(supinfo);
//	    		   }
//	    	   }
//	       }else{
//	    	   //this.kdtEntry.getRow(selectRow).getCell("manufactureDate").setValue(new Date());
//	    	   //this.kdtEntry.getRow(selectRow).getCell("expirationDate").setValue(new Date()); 
//	    	   //this.kdtEntry.getRow(selectRow).getCell("checkInforM").setValue("待检");
//	       }
//	 }
}
