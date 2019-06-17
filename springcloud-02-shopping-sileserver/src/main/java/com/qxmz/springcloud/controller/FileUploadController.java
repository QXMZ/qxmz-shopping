package com.qxmz.springcloud.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.qxmz.springcloud.common.UploadUtils;
import com.qxmz.springcloud.vo.ResultValue;

@RestController
public class FileUploadController {

	// 从配置文件application.properties获得指定的值，并赋给相应的成员变量
	@Value("${web.user-path}")
	private String userPath;

	@Value("${web.goods-path}")
	private String goodsPath;

	@RequestMapping(value = "/userUpload")
	public ResultValue userUpload(@RequestParam("userHphoto") MultipartFile file) {
		ResultValue rv = new ResultValue();
		try {
			Map<String,Object> map = this.uploadFile(userPath, file);
			if(map != null && map.size() > 0) {
				rv.setCode(0);
				rv.setDataMap(map);
				return rv;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("用户头像上传失败");
		return rv;
	}
	
	@RequestMapping(value = "/goodsUpload")
	public ResultValue goodsUpload(@RequestParam("goodsphoto") MultipartFile file) {
		ResultValue rv = new ResultValue();
		try {
			Map<String,Object> map = this.uploadFile(goodsPath, file);
			if(map != null && map.size() > 0) {
				rv.setCode(0);
				rv.setDataMap(map);
				return rv;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("商品图片上传失败");
		return rv;
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/delectGoodsImg")
	public ResultValue delectGoodsImg(@RequestParam("goodsImg") String goodsImg) {
		ResultValue rv = new ResultValue();
		try {
			//从url中获得商品图片的名字
			int indexOf = goodsImg.lastIndexOf("/");
			if(indexOf != -1) {
				String fileName = goodsImg.substring(indexOf + 1);
				//System.out.println(fileName);
				File file = new File(this.goodsPath + fileName);
				//判断文件或目录是否存在
				if(file.exists()){
					if(file.isFile()) {
						file.delete();
						rv.setCode(0);
						return rv;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}
	
	@RequestMapping(value="/delectUserImg")
	public ResultValue delectUserImg(@RequestParam("userImg") String userImg) {
		ResultValue rv = new ResultValue();
		try {
			//从url中获得商品图片的名字
			int indexOf = userImg.lastIndexOf("/");
			if(indexOf != -1) {
				String fileName = userImg.substring(indexOf + 1);
				//System.out.println(fileName);
				File file = new File(this.userPath + fileName);
				//判断文件或目录是否存在
				if(file.exists()){
					if(file.isFile()) {
						file.delete();
						rv.setCode(0);
						return rv;
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}
	
	
	/**
	 * 上传文件
	 * 
	 * @param path 上传文件路径
	 * @param file 上传的文件
	 * @return 成功返回java.util.map类型的实例，否则返回null
	 * @throws IOException 
	 */
	private Map<String, Object> uploadFile(String path, MultipartFile file) throws IOException {
		// 获得新的文件名
		String fileName = UploadUtils.getFileName();

		// 获得文件扩展名
		String extendedName = UploadUtils.getExendedName(file.getOriginalFilename());
		
		//上传文件
		// 将文件转换为字节类型的数组
		byte[] bytes = file.getBytes();
		// 创建file类的对象，并设置上传路径
		File saveFile = new File(path + fileName + extendedName);
		// 上传文件
		FileCopyUtils.copy(bytes, saveFile);
		
		Map<String, Object> map = new HashMap<>();
		map.put("fileName", fileName);
		map.put("extendedName", extendedName);
		return map;
	}
}
