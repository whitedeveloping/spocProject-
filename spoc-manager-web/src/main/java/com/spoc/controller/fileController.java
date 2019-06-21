package com.spoc.controller;

import com.spoc.pojo.FileEntity;
import com.spoc.service.uploadService;
import com.spoc.utils.FileUploadTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
public class fileController {
	@Autowired
	private uploadService fileservice;

	/*
	 * 查询所有
	 * 
	 * */
	@RequestMapping(value="/result",method=RequestMethod.GET)
	public String result(Model model) {
		List<FileEntity> entity = fileservice.findAll();
		model.addAttribute("entity", entity);
		return "result";
	}
	/*
	 * 上传文件
	 * 
	 * */
	@RequestMapping(value = "/upload")
	@ResponseBody
	public void upload(@RequestParam(value = "file", required = false) MultipartFile multipartFile,
						 HttpServletRequest request, HttpServletResponse response ,ModelMap map) {
		String message = "";
		FileEntity entity = new FileEntity();
		FileUploadTool fileUploadTool = new FileUploadTool();
		System.out.println("-----");
		System.out.println(multipartFile.getName()+"   "+multipartFile.toString());
		try {
			entity = fileUploadTool.createFile(multipartFile,request);
			PrintWriter out = response.getWriter();
			if (entity != null) {
				fileservice.saveFile(entity);
				message = "上传成功";
				map.put("entity", entity);
				map.put("result", message);
				out.print("<script language=\"javascript\">alert('上传成功！');window.location.href='http://localhost:8081/'</script>");

			} else {
				message = "上传失败";
				map.put("result", message);
				out.print("<script language=\"javascript\" >alert('上传失败！');window.location.href='http://localhost:8081/'</script>");
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/play")
	public ModelAndView show(HttpServletRequest request,HttpServletResponse response,ModelMap map){
		String tempId = request.getParameter("fileId");
		int fileId = 0;
		if(null !=tempId){
			fileId = Integer.parseInt(tempId);
		}
		try{
			FileEntity fileEntity = fileservice.findByid(fileId);
			if (fileEntity ==null){
				request.getRequestDispatcher("show-error").forward(request,response);
			}
			System.out.println(fileEntity.toString());
			map.put("fileEntity", fileEntity);
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ModelAndView("/item-show", map);




	}


}
