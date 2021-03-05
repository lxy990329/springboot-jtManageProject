package com.jt.service;

import java.util.Date;

import com.jt.pojo.Item;
import com.jt.pojo.ItemDesc;
import com.jt.vo.EasyUITable;
import com.jt.vo.SysResult;

public interface ItemService {
	EasyUITable findItemByPage(int page,int rows);

	void saveItem(Item item, ItemDesc itemDesc);

	void updateItem(Item item, ItemDesc itemDesc);

	void deleteItem(long[] ids);

	void updateStatus(int status,Long[] ids);

	ItemDesc findItemDescById(Long itemId);
	
}
