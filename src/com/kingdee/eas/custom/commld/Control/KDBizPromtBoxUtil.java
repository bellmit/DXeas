package com.kingdee.eas.custom.commld.Control;

import java.util.ArrayList;

import com.kingdee.bos.ctrl.extendcontrols.KDBizPromptBox;

public class KDBizPromtBoxUtil {


	/**
	 * 设置F7控件必录
	 * @param arrays
	 * @param flag
	 */
	public static void setKDBizPromtBoxRequired(ArrayList<KDBizPromptBox> arrays,boolean flag){
		for(int i=0;i<arrays.size();i++){
			if(flag){
				arrays.get(i).setRequired(true);
			}else{
				arrays.get(i).setRequired(false);
			}
			arrays.get(i).setValue(arrays.get(i).getValue());
		}
	}

	/**
	 * 设置F7控件必录
	 * @param arrays
	 * @param flag
	 */
	public static void setKDBizPromtBoxRequired(KDBizPromptBox f7,boolean flag){
		if(flag){
			f7.setRequired(true);
		}else{
			f7.setRequired(false);
		}
		f7.setValue(f7.getValue());
	}

}
