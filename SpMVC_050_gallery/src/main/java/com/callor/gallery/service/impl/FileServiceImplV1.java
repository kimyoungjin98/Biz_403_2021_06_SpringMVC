package com.callor.gallery.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.service.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("fileServiceV1")
@RequiredArgsConstructor
public class FileServiceImplV1 implements FileService{

//	protected final ServletContext context;
	
	@Autowired
	private ResourceLoader resLoader;
	
	@Override
	public String fileUp(MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		
		// 파일이름 추출
		String originalFileName = file.getOriginalFilename();
		
		// 이름이 비어있으면 return null
		if(originalFileName.isEmpty()) {
			return null;
		}
		log.debug("파일이름 {}",originalFileName);
		
		Resource res = resLoader.getResource("/files");
		
		String filePath = res.getURI().getPath();
		
		String strUUID = UUID.randomUUID().toString();
		strUUID += originalFileName;
		
		File uploadPathAndFile = new File(filePath, strUUID);
		
		// file 에 담긴 파일정보를 사용하여 
		// uploadPathAndFile에 전송하라(복사하라, 업로드하라)
		file.transferTo(uploadPathAndFile);
				
		return strUUID;
	}

	@Override
	public List<String> filesUp(MultipartHttpServletRequest files) throws IOException {
		// TODO Auto-generated method stub
		
		List<String> fileNames = new ArrayList<String>();
		String tagName = "m_file";
		
		List<MultipartFile> fileList = files.getFiles(tagName);
		for(MultipartFile file : fileList) {
			
			String fileName = this.fileUp(file);
			fileNames.add(fileName);
			
		}
		
		return fileNames;
	}

}
