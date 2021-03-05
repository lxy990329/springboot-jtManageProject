package com.jt.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import com.jt.service.FileService;
import com.jt.vo.FileImage;

@RestController
public class fileController {
	@Autowired
	private FileService fileService;
	/**
	 * 业务：实现文件上传的入门案例
	 * url:http://localhost:8091/file
	 * 请求参数：fileImage 参数的名称必须与页面提交时的name属性保持一致
	 * 返回值：文件上传成功
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/file")
	public String file(MultipartFile fileImage) throws IllegalStateException, IOException {
		//获取文件名称
		String fileName=fileImage.getOriginalFilename();
		//准备文件存储目录
		String dirPath="D:/InstallationPackage/tool/tool/images";
		File dirFile=new File(dirPath);
		//如果文件目录不存在，则需要新建文件目录
		if(!dirFile.exists()) {
			//可以创建多级目录
			dirFile.mkdir();
		}
		//利用工具API实现文件上传
		File file=new File(dirPath+"/"+fileName);
		//将流数据输出到指定位置
		fileImage.transferTo(file);

		return "文件上传成功";
		
	}
	/**
	 * url:
	 * 参数：uploadFile
	 * 返回值类型：FIleImage
	 */
	@RequestMapping("/pic/upload")
	public FileImage upload(MultipartFile uploadFile) {
		return fileService.upload(uploadFile);
	}
	
	
	
	
	
	
	
	
}
