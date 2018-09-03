package cn.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.taotao.pojo.TbItem;
import cn.taotao.service.ItemService;

public class ItemController {
//	注入service
	@Autowired
	private ItemService itemService;
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItem(@PathVariable Long itemId){
		TbItem tbItem=itemService.geTbItem(itemId);
		return tbItem;
	}

}
