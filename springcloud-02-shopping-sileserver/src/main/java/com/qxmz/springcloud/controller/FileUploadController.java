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

	// �������ļ�application.properties���ָ����ֵ����������Ӧ�ĳ�Ա����
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
		rv.setMessage("�û�ͷ���ϴ�ʧ��");
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
		rv.setMessage("��ƷͼƬ�ϴ�ʧ��");
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
			//��url�л����ƷͼƬ������
			int indexOf = goodsImg.lastIndexOf("/");
			if(indexOf != -1) {
				String fileName = goodsImg.substring(indexOf + 1);
				//System.out.println(fileName);
				File file = new File(this.goodsPath + fileName);
				//�ж��ļ���Ŀ¼�Ƿ����
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
			//��url�л����ƷͼƬ������
			int indexOf = userImg.lastIndexOf("/");
			if(indexOf != -1) {
				String fileName = userImg.substring(indexOf + 1);
				//System.out.println(fileName);
				File file = new File(this.userPath + fileName);
				//�ж��ļ���Ŀ¼�Ƿ����
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
	 * �ϴ��ļ�
	 * 
	 * @param path �ϴ��ļ�·��
	 * @param file �ϴ����ļ�
	 * @return �ɹ�����java.util.map���͵�ʵ�������򷵻�null
	 * @throws IOException 
	 */
	private Map<String, Object> uploadFile(String path, MultipartFile file) throws IOException {
		// ����µ��ļ���
		String fileName = UploadUtils.getFileName();

		// ����ļ���չ��
		String extendedName = UploadUtils.getExendedName(file.getOriginalFilename());
		
		//�ϴ��ļ�
		// ���ļ�ת��Ϊ�ֽ����͵�����
		byte[] bytes = file.getBytes();
		// ����file��Ķ��󣬲������ϴ�·��
		File saveFile = new File(path + fileName + extendedName);
		// �ϴ��ļ�
		FileCopyUtils.copy(bytes, saveFile);
		
		Map<String, Object> map = new HashMap<>();
		map.put("fileName", fileName);
		map.put("extendedName", extendedName);
		return map;
	}
}
