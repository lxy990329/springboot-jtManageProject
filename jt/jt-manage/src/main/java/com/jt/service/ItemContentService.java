package com.jt.service;

import java.util.List;

import com.jt.pojo.Item;
import com.jt.pojo.ItemContent;
import com.jt.pojo.ItemContentCategory;
import com.jt.pojo.ItemDesc;
import com.jt.vo.EasyUITable;
import com.jt.vo.EasyUITree;
import com.jt.vo.Result;

public interface ItemContentService {

	EasyUITable findItemByPage(Long categoryId, int page, int rows);

	List<EasyUITree> findItemCatList(Long parentId);

	Result saveItem(ItemContentCategory itemContentCategory);

	Result updateItem(ItemContentCategory itemContentCategory);

	Result deleteItem(Long id);

	void saveContent(ItemContent content);

	void updateContent(ItemContent content);

	void deleteContent(Long[] ids);


}
