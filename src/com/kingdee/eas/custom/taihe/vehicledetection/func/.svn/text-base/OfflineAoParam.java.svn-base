package com.kingdee.eas.custom.taihe.vehicledetection.func;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Structure;

/**
 * ”Ô“Ù…Ë÷√
 * @author dai_andong
 *
 */
public class OfflineAoParam extends Structure {
	public int u32Mode=0;
	public int u32Broadcast_order=0;
	public int[] u32Reserved=new int[15];
	
	 public static class ByReference extends OfflineAoParam implements Structure.ByReference{              
     }  
       
     public static class ByValue extends OfflineAoParam implements Structure.ByValue{  
     }  
	@Override
	protected List getFieldOrder() {
		return Arrays.asList(new String[]{"u32Mode", "u32Broadcast_order", "u32Reserved", });  
	}
}
