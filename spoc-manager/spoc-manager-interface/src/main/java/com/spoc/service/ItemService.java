package com.spoc.service;


import com.common.pojo.EasyUIDataGridResult;
import com.spoc.pojo.TbItem;

public interface ItemService {
    TbItem getItemById(Long itemId);
    EasyUIDataGridResult getItemList(int page,int rows);
}
