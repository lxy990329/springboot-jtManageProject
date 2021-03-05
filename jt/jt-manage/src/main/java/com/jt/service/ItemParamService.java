package com.jt.service;

import com.jt.pojo.ItemParam;
import com.jt.vo.EasyUITable;

public interface ItemParamService {
	EasyUITable findItemParamByPage(int page, int rows);
	
	void saveItemParam(ItemParam itemParam,Long itemCatId);
	
	void deleteItemParams(Long[] ids);
	
	void updateItemParam(ItemParam itemParam);
}
