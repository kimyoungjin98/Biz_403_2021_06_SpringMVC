package com.callor.gallery.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.gallery.model.FileDTO;
import com.callor.gallery.model.GalleryDTO;
import com.callor.gallery.model.GalleryFilesDTO;
import com.callor.gallery.persistance.ext.FileDao;
import com.callor.gallery.persistance.ext.GalleryDao;
import com.callor.gallery.service.FileService;
import com.callor.gallery.service.GalleryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service("galleryServiceV1")
public class GalleryServiceImplV1 implements GalleryService {

	protected final GalleryDao gaDao;
	protected final FileDao fDao;

	@Qualifier("fileServiceV2")
	protected final FileService fService;

	/*
	 * @Autowired가 설정된 변수, method, 객체 등을 만나면 Spring framework는 변수를 초기화, method를 실행하여
	 * 또 변수 초기화 이미 생성되어 준비된 객체에 주입 등을 수행한다
	 */
//	@Autowired
//	public void create_table(GalleryDao gDao) {
//		
//		Map<String, String> maps = new HashMap<String, String>();
//		gaDao.create_table(maps);
//		fDao.create_table(maps);
//		
//	}

	@Override
	public int insert(GalleryDTO galleryDTO) throws Exception {
		// TODO Auto-generated method stub

		return 0;
	}

	@Override
	public void input(GalleryDTO gaDTO, MultipartFile one_file, MultipartHttpServletRequest m_file) throws IOException {
		// TODO Auto-generated method stub

		// GalleryDTO에 담긴 데이터를 tbl_gallery table에 insert하기
		// mapper에서 insert를 수행한 후 새로 생성된 g_seq 값을
		// selectKey 하여 gaDTO의 g_seq 변수에 담아놓은 상태이다

		String strUUID = fService.fileUp(one_file);
		gaDTO.setG_image(strUUID);

		log.debug("insert 전 seq {}", gaDTO.getG_seq());

		gaDao.insert(gaDTO);

		log.debug("insert 후 seq {}", gaDTO.getG_seq());

		// 갤러리 게시판의 seq 값과 파일들을 묶음으로 insert하기 위한 준비
		Long g_seq = gaDTO.getG_seq();

		List<FileDTO> files = new ArrayList<FileDTO>();

		// 업로드된 멀티파일을 서버에 업로드 하고
		// 원래 파일이름과 UUID가 첨가된 파일이름을 추출하여
		// FileDTO에 담고
		// 다시 List에 담아 놓는다

		List<MultipartFile> mFiles = m_file.getFiles("m_file");
		for (MultipartFile file : mFiles) {

			String fileOriginName = file.getOriginalFilename();
			String fileUUName = fService.fileUp(file);

			FileDTO fDto = FileDTO.builder().file_gseq(g_seq).file_original(fileOriginName).file_upname(fileUUName)
					.build();
			files.add(fDto);
		}

		log.debug("이미지들 {} ", files.toString());

		fDao.insertWithList(files);
	}

	@Override
	public List<GalleryDTO> selectAll() throws Exception {
		// TODO Auto-generated method stub

		List<GalleryDTO> gaList = gaDao.selectAll();

		return gaList;
	}

	@Override
	public List<GalleryFilesDTO> findByGalleryFiles(Long g_seq) {

		List<GalleryFilesDTO> gfList = gaDao.findByGalleryFiles(g_seq);
		/*
		 * Dao로부터 select를 한 후에 데이터 검증을 하기 위해 사용하는 코드 gfList 데이터가 조회되지 않으면 null이 발생할 수
		 * 있다. -> if(gfList != null) 으로 exception 방지 -> gfList.size() > 0 를 추가하면 더 안전한
		 * 코드
		 */
		if (gfList != null && gfList.size() > 0) {
			log.debug(gfList.toString());
		} else {
			log.debug("조회된 데이터가 없음");
		}
		return gfList;
	}

	@Override
	public GalleryDTO findByGallery(Long g_seq) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public int delete(Long g_seq) {
		// TODO Auto-generated method stub
		return 0;
	}

}
