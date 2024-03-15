package com.inno.portpolio.common.file.service;

import java.util.List;

import com.inno.portpolio.common.file.vo.AttachmentFileVO;
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
public interface AttachmentFileService {
	
	/**
	 * 파일 조회 해오기
	 * @param atchmnflNo
	 * @return
	 */
	public List<AttachmentFileVO> selectAttachmentFile(String atchmnflNo);
	
	public void firstCreateAttachmentFile(AttachmentFileVO attachmentFile);
	
	public void afterCreateAttachmentFile(AttachmentFileVO attachmentFile);
	
	public void deleteAttachmentFile(AttachmentFileVO attachmentFile);
}
