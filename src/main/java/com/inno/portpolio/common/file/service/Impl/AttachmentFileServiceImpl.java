package com.inno.portpolio.common.file.service.Impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.inno.portpolio.common.file.mapper.AttachmentFileMapper;
import com.inno.portpolio.common.file.service.AttachmentFileService;
import com.inno.portpolio.common.file.vo.AttachmentFileVO;

import lombok.extern.slf4j.Slf4j;
/**
* @author 연구개발 5팀 사원 김재성
* @since 2024. 03. 13.
* @version 1.0
* @see javax.servlet.http.HttpServlet 
* <pre>
* [[개정이력(Modification Information)]]
*    수정일            수정자               수정내용
* ------------     --------    ----------------------
* 2024.03.13.        김재성       최초 작성
* Copyright (c) 2024 by INNOVATION-T All right reserved
* </pre>
*/
@Service
@Slf4j
public class AttachmentFileServiceImpl implements AttachmentFileService {
	
	@Autowired
	private AttachmentFileMapper attachmentFileMapper;
	
	@Override
	public void firstCreateAttachmentFile(AttachmentFileVO attachmentFile) {
		
		attachmentFileMapper.firstInsertAttachmentFile(attachmentFile);
		
	}
	@Override
	public void afterCreateAttachmentFile(AttachmentFileVO attachmentFile) {
		
		attachmentFileMapper.afterInsertAttachmentFile(attachmentFile);
		
	}

	@Override
	public void deleteAttachmentFile(AttachmentFileVO attachmentFile) {
		
		attachmentFileMapper.deleteAttachmentFile(attachmentFile);
	}
	
	@Override
	public List<AttachmentFileVO> selectAttachmentFile(String atchmnflNo) {
		
		return attachmentFileMapper.selectAttachmentFile(atchmnflNo);
	}

}
