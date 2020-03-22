package com.kingdee.eas.custom.foodtrac.app;

import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.axis.encoding.Base64;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.jdbc.rowset.impl.SerialBlob;

public class traceFacadeControllerBean extends AbstracttraceFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.foodtrac.app.traceFacadeControllerBean");
    protected String _getDataFromJsonCondition(Context ctx, String queryStr)throws BOSException
    {
    	JSONObject resultObj=new JSONObject();//结果jsonobj
    	JSONObject jsonObject=JSONObject.fromObject(queryStr);
    	String batchCode="";
        String type="";
    	if(jsonObject.containsKey("batchCode")){
    		batchCode=jsonObject.getString("batchCode");
    	}
    	resultObj.put("batchCode", batchCode);
    	//解析条码number   _021_070106-0002_16062202
    	String[] batchCodeArray=batchCode.split("_");
    	String orgNum=batchCodeArray[1];
    	String materialNum=batchCodeArray[2];
    	String productDate=batchCodeArray[3];
    	
    	if(jsonObject.containsKey("type")){
            type=jsonObject.getString("type");
            if(type.equalsIgnoreCase("co")){
                //获取国家检验信息图片
                resultObj.put("photo",getAttachmentPhoto(ctx,materialNum,"co",productDate));
            }else if(type.equalsIgnoreCase("th")){
                //第三方检验信息图片
                resultObj.put("photo",getAttachmentPhoto(ctx,materialNum,"th",productDate));
            }else if(type.equalsIgnoreCase("le")){
                //出厂检验信息图片
                resultObj.put("photo",getAttachmentPhoto(ctx,materialNum,"le",productDate));
            }else if(type.equalsIgnoreCase("company")){
            	//获取公司信息附件图片
            	resultObj.put("photo", getAttachmentPhoto(ctx, orgNum, type, productDate));
            }else if(type.equalsIgnoreCase("base")){
            //获取物料信息
                JSONObject materialObject=getMaterialInfo(ctx, materialNum);
                materialObject.put("productDate", productDate);//生产日期批号
                resultObj.put("material", materialObject);
                //公司信息
                JSONObject companyObject=getCompanyInfo(ctx, orgNum);
                resultObj.put("company", companyObject);
                //原料信息
                JSONObject rawMaterialObj=getRawMaterialInfo(ctx, materialNum);
                resultObj.put("rawmaterial", rawMaterialObj);
                //产品类别信息
                JSONObject productCategoryInfo=getProductCategoryInfo(ctx, materialNum);
                resultObj.put("productcategory", productCategoryInfo);
                //产品加工工艺
                JSONObject processTechInfo=getProcesstechInfo(ctx, materialNum);
                resultObj.put("processtech", processTechInfo);
                //国家检验信息
                JSONObject countryCheck=getCountrycheck(ctx, materialNum);
                resultObj.put("countrycheck", countryCheck);
                //第三方检验信息
                JSONObject thirdPartyCheck=getThirdpartycheck(ctx, materialNum);
                resultObj.put("thirdpartycheck", thirdPartyCheck);
                //出厂检验信息
                JSONObject leaveCheck=getLeaveCheck(ctx, materialNum,productDate);
                resultObj.put("leavecheck", leaveCheck);
            }
    	}
    	return resultObj.toString();
    }
    
    //根据传入sql 获取图片分录jsonobject
    public JSONArray getPicEntrys(Context ctx,String picsql){
    	JSONArray picArray=new JSONArray();
    	JSONObject pictempobj=new JSONObject();
        try{
         //--------获取图片分录开始--------
        	IRowSet picrs=null;
            picrs=DbUtil.executeQuery(ctx,picsql);
            while(picrs.next()){
                pictempobj.clear();
                pictempobj.put("seq",picrs.getString("seq"));
                pictempobj.put("picname",picrs.getString("picname"));
                pictempobj.put("picpath",picrs.getString("picpath"));
                picArray.add(pictempobj);
            }
            //--------获取图片分录结束---------
            }catch (BOSException e) {
            	pictempobj.put("errorMsg", e.getMessage());
            picArray.add(pictempobj);
            e.printStackTrace();
        } catch (SQLException e) {
        	pictempobj.put("errorsqlMsg", e.getMessage());
            picArray.add(pictempobj);
            e.printStackTrace();
        }
            return picArray;
    }

    //获取公司信息
    public JSONObject getCompanyInfo(Context ctx,String orgNum){
    	JSONObject object=new JSONObject();
    	StringBuffer sql=new StringBuffer();
    	sql.append(" select fcompanyname,fcompanynumber,fnewbusiness,fnewaddress,fnewdesc");
        sql.append(" from T_ZS_Companyinfo where fcompanynumber='");
    	sql.append(orgNum);
    	sql.append("'");
        //------获取图片sql拼装开始---
        StringBuffer picsql=new StringBuffer();
        picsql.append(" select b.fseq seq,b.fpicname picname,b.fpicpath picpath from T_ZS_Companyinfo a inner join T_ZS_CompanyinfoPicentrys b on a.fid=b.fparentid");
        picsql.append(" where a.fcompanynumber='");
        picsql.append(orgNum);
        picsql.append("'");
        //------获取图片sql拼装结束---
    	IRowSet rs=null;
    	try {
			rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				object.put("fcompanyname", rs.getString("fcompanyname"));
				object.put("fcompanynumber", rs.getString("fcompanynumber"));
				object.put("fnewbusiness", rs.getString("fnewbusiness"));
				object.put("fnewaddress", rs.getString("fnewaddress"));
				object.put("fnewdesc", rs.getString("fnewdesc"));
			}
            //-----获取图片分录开始-----
           JSONArray picArray= getPicEntrys(ctx,picsql.toString());
            object.put("pic",picArray);
            //-----获取图片分录结束------
		} catch (BOSException e) {
			object.put("errorMsg", e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			object.put("errorsqlMsg", e.getMessage());
			e.printStackTrace();
		}
    	
		return object;
    }
    //获取物料信息
    public JSONObject getMaterialInfo(Context ctx,String materialnum){
    	JSONObject object=new JSONObject();
    	StringBuffer sql=new StringBuffer();
    	sql.append(" select fnumber,fname_l2 fname,fmodel from t_bd_material where fnumber='");
    	sql.append(materialnum);
    	sql.append("'");

    	IRowSet rs=null;
    	try {
			rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				object.put("fnumber", rs.getString("fnumber"));
				object.put("fmaterialname", rs.getString("fname"));
				object.put("fmodel", rs.getString("fmodel"));
			}
		} catch (BOSException e) {
			object.put("errorMsg", e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			object.put("errorsqlMsg", e.getMessage());
			e.printStackTrace();
		}
		return object;
    }
    //获取原料信息
    public JSONObject getRawMaterialInfo(Context ctx,String materialnum){
    	
    	JSONObject object=new JSONObject();
    	StringBuffer sql=new StringBuffer();
    	sql.append(" select r.fnewdesc fdesc from T_ZS_Rawmaterialinfo r");
    	sql.append(" inner join T_BD_Material m on m.fid=r.fmaterialid");
    	sql.append(" where m.fnumber='");
    	sql.append(materialnum);
    	sql.append("'");
    	//------获取图片sql拼装开始---
        StringBuffer picsql=new StringBuffer();
        picsql.append(" select b.fseq seq,b.fpicname picname,b.fpicpath picpath from T_ZS_Rawmaterialinfo a inner join T_ZS_RawmaterialinfoPicentrys b on a.fid=b.fparentid");
        picsql.append(" inner join T_BD_Material m on m.fid=a.fmaterialid");
        picsql.append(" where m.fnumber='");
        picsql.append(materialnum);
        picsql.append("'");
        //------获取图片sql拼装结束---
        IRowSet rs=null;

    	try {
			rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				object.put("fdesc", rs.getString("fdesc"));
			}
            //-----获取图片分录开始-----
           JSONArray picArray= getPicEntrys(ctx,picsql.toString());
            object.put("pic",picArray);
            //-----获取图片分录结束------
		} catch (BOSException e) {
			object.put("errorMsg", e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			object.put("errorsqlMsg", e.getMessage());
			e.printStackTrace();
		}
		return object;
    	
    }
    //获取产品类别信息
    public JSONObject getProductCategoryInfo(Context ctx,String materialnum){

    	
    	JSONObject object=new JSONObject();
    	StringBuffer sql=new StringBuffer();
    	sql.append(" select p.fcategorynumber fnumber,p.fcategoryname fname,p.fnewdesc fdesc from T_ZS_ProductCategoryInfo p");
    	sql.append(" inner join T_ZS_ProductCategoryInfoentry pe on p.fid=pe.fparentid");
    	sql.append(" inner join t_bd_material m on m.fid=pe.fmaterialnumberid");
    	sql.append(" where m.fnumber='");
    	sql.append(materialnum);
    	sql.append("'");

    	IRowSet rs=null;
    	try {
			rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				object.put("fnumber", rs.getString("fnumber"));
				object.put("fname", rs.getString("fname"));
				object.put("fdesc", rs.getString("fdesc"));
			}
		} catch (BOSException e) {
			object.put("errorMsg", e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			object.put("errorsqlMsg", e.getMessage());
			e.printStackTrace();
		}
		return object;
    	
    
    }
    //获取产品加工工艺
    public JSONObject getProcesstechInfo(Context ctx,String materialnum){
    	
    	JSONObject object=new JSONObject();
    	StringBuffer sql=new StringBuffer();
    	sql.append(" select p.fnewdesc fdesc from T_ZS_processtech p");
    	sql.append(" inner join T_BD_Material m on m.fid=p.fmaterialid");
    	sql.append(" where m.fnumber='");
    	sql.append(materialnum);
    	sql.append("'");
        //------获取图片sql拼装开始---
        StringBuffer picsql=new StringBuffer();
        picsql.append(" select b.fseq seq,b.fpicname picname,b.fpicpath picpath from T_ZS_processtech a inner join T_ZS_processtechPicentrys b on a.fid=b.fparentid");
        picsql.append(" inner join T_BD_Material m on m.fid=a.fmaterialid");
        picsql.append(" where m.fnumber='");
        picsql.append(materialnum);
        picsql.append("'");
        //------获取图片sql拼装结束---
    	IRowSet rs=null;
    	try {
			rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				object.put("fdesc", rs.getString("fdesc"));
			}
            //-----获取图片分录开始-----
           JSONArray picArray= getPicEntrys(ctx,picsql.toString());
            object.put("pic",picArray);
            //-----获取图片分录结束------
		} catch (BOSException e) {
			object.put("errorMsg", e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			object.put("errorsqlMsg", e.getMessage());
			e.printStackTrace();
		}
		return object;
    	
    }
    //获取国家检验信息
    public JSONObject getCountrycheck(Context ctx,String materialnum){
    	
    	JSONObject object=new JSONObject();
    	StringBuffer sql=new StringBuffer();
    	sql.append(" select r.fnewdesc fdesc from T_ZS_Countrycheck r");
    	sql.append(" inner join T_BD_Material m on m.fid=r.fmaterialid");
    	sql.append(" where m.fnumber='");
    	sql.append(materialnum);
    	sql.append("'");
        //------获取图片sql拼装开始---
        StringBuffer picsql=new StringBuffer();
        picsql.append(" select b.fseq seq,b.fpicname picname,b.fpicpath picpath from T_ZS_Countrycheck a inner join T_ZS_CountrycheckPicentrys b on a.fid=b.fparentid");
        picsql.append(" inner join T_BD_Material m on m.fid=a.fmaterialid");
        picsql.append(" where m.fnumber='");
        picsql.append(materialnum);
        picsql.append("'");
        //------获取图片sql拼装结束---
    	IRowSet rs=null;
    	try {
			rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				object.put("fdesc", rs.getString("fdesc"));
			}
            //-----获取图片分录开始-----
           JSONArray picArray= getPicEntrys(ctx,picsql.toString());
            object.put("pic",picArray);
            //-----获取图片分录结束------
		} catch (BOSException e) {
			object.put("errorMsg", e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			object.put("errorsqlMsg", e.getMessage());
			e.printStackTrace();
		}
		return object;
    	
    }
    //获取第三方检验信息
    public JSONObject getThirdpartycheck(Context ctx,String materialnum){
    	
    	JSONObject object=new JSONObject();
    	StringBuffer sql=new StringBuffer();
    	sql.append(" select r.fnewdesc fdesc from T_ZS_Thirdpartycheck r");
    	sql.append(" inner join T_BD_Material m on m.fid=r.fmaterialid");
    	sql.append(" where m.fnumber='");
    	sql.append(materialnum);
    	sql.append("'");
        //------获取图片sql拼装开始---
        StringBuffer picsql=new StringBuffer();
        picsql.append(" select b.fseq seq,b.fpicname picname,b.fpicpath picpath from T_ZS_Thirdpartycheck a inner join T_ZS_ThirdpartycheckPicentrys b on a.fid=b.fparentid");
        picsql.append(" inner join T_BD_Material m on m.fid=a.fmaterialid");
        picsql.append(" where m.fnumber='");
        picsql.append(materialnum);
        picsql.append("'");
        //------获取图片sql拼装结束---
    	IRowSet rs=null;
    	try {
			rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				object.put("fdesc", rs.getString("fdesc"));
			}
            //-----获取图片分录开始-----
           JSONArray picArray= getPicEntrys(ctx,picsql.toString());
            object.put("pic",picArray);
            //-----获取图片分录结束------
		} catch (BOSException e) {
			object.put("errorMsg", e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			object.put("errorsqlMsg", e.getMessage());
			e.printStackTrace();
		}
		return object;
    	
    }
    //获取出厂检验信息
    public JSONObject getLeaveCheck(Context ctx,String materialnum,String productDate){

    	JSONObject object=new JSONObject();
    	StringBuffer sql=new StringBuffer();
    	sql.append(" select p.fproductdate fproductdate,p.fnewdesc fdesc  from T_ZS_Leavecheck p");
    	sql.append(" inner join T_BD_Material m on m.fid=p.fmaterialid");
    	sql.append(" where m.fnumber='");
    	sql.append(materialnum);
    	sql.append("' and p.fproductdate='");
        sql.append(productDate);
        sql.append("'");
        //------获取图片sql拼装开始---
        StringBuffer picsql=new StringBuffer();
        picsql.append(" select b.fseq seq,b.fpicname picname,b.fpicpath picpath from T_ZS_Leavecheck a inner join T_ZS_LeavecheckPicentrys b on a.fid=b.fparentid");
        picsql.append(" inner join T_BD_Material m on m.fid=a.fmaterialid");
        picsql.append(" where m.fnumber='");
        picsql.append(materialnum);
        picsql.append("'  and a.fproductdate='");
        picsql.append(productDate);
        picsql.append("'");
        //------获取图片sql拼装结束---
    	IRowSet rs=null;
    	try {
			rs=DbUtil.executeQuery(ctx, sql.toString());
			if(rs.next()){
				object.put("fproductdate", rs.getString("fproductdate"));
				object.put("fdesc", rs.getString("fdesc"));
			}
            //-----获取图片分录开始-----
            JSONArray picArray= getPicEntrys(ctx,picsql.toString());
            object.put("pic",picArray);
            //-----获取图片分录结束------
		} catch (BOSException e) {
			object.put("errorMsg", e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			object.put("errorsqlMsg", e.getMessage());
			e.printStackTrace();
		}
		return object;
    	
    
    }
    //根据图片number获取附件图片
    public JSONObject getAttachmentPhoto(Context ctx,String materialnum,String type,String productDate){
    	JSONObject object=new JSONObject();
    	
    	StringBuffer sql=new StringBuffer();
        String tablename="";
        if(type.equalsIgnoreCase("co")){
            //国家
            tablename="T_ZS_Countrycheck";
        }else if(type.equalsIgnoreCase("th")){
            //第三方
            tablename="T_ZS_Thirdpartycheck";
        }else if(type.equalsIgnoreCase("le")){
            //出厂检验
            tablename="T_ZS_Leavecheck";
        } 
        
        if(type.equalsIgnoreCase("company")){
        	sql.append(" select a.ffile from T_BAS_Attachment a");
        	sql.append(" inner join T_BAS_BoAttchAsso b on a.fid=b.fattachmentid");
			sql.append(" inner join  T_ZS_Companyinfo c  on c.fid=b.fboid");
			sql.append(" where c.fcompanynumber='");
			sql.append(materialnum);//实际为公司number
			sql.append("'");
        }else{
        	sql.append(" select a.ffile from T_BAS_Attachment a");
        	sql.append(" inner join T_BAS_BoAttchAsso b on a.fid=b.fattachmentid");
        	sql.append(" inner join ");
        	sql.append(tablename);
        	sql.append(" c on c.fid=b.fboid");
        	sql.append(" inner join T_BD_Material m on m.fid=c.fmaterialid");
        	sql.append(" where m.fnumber='");
        	sql.append(materialnum);
        	sql.append("'");
        	if(type.equalsIgnoreCase("le")) {
        		sql.append(" and c.fproductdate ='").append(productDate).append("'");
        	} 	
        }
        
       
    	IRowSet rs=null;  
    	try {
    		rs=DbUtil.executeQuery(ctx, sql.toString());
            int i=0;
			while(rs.next()){
				Object object2=rs.getObject("ffile");
				SerialBlob blob=(SerialBlob) object2;			
				byte[] b = blob.getBytes((long)1, (int)blob.length());
				String c=new String(Base64.encode(b));
				object.put(i++,c);
			}
    	} catch (SQLException e) {
			object.put("errorsqlMsg", e.getMessage());
			e.printStackTrace();
		} catch (BOSException e) {
			object.put("errorMsg", e.getMessage());
			e.printStackTrace();
		}  
    	
    	return object;	//{"0":"sdfljkj","1":"jsido","2":"sjdlfj"}
    }
  
}