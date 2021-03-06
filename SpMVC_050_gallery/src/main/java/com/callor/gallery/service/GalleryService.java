package com.callor.gallery.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.model.GalleryFilesDTO;

public interface GalleryService {

	public int insert(GalleryDTO galleryDTO) throws Exception;

	public void input(GalleryDTO gaDTO, MultipartFile one_file, MultipartHttpServletRequest m_file) throws IOException;

	public List<GalleryDTO> selectAll() throws Exception;

	public List<GalleryFilesDTO> findByGalleryFiles(Long g_seq);

	public GalleryDTO findByGallery(Long g_seq);

	public int delete(Long g_seq);
	
}
