package com.inno.portpolio.question.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.inno.portpolio.common.enumpkg.ServiceResult;
import com.inno.portpolio.paging.BootstrapPaginationRenderer;
import com.inno.portpolio.paging.vo.PaginationInfo;
import com.inno.portpolio.paging.vo.SearchVO;
import com.inno.portpolio.question.service.QuestionService;
import com.inno.portpolio.question.vo.QuestionVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
/**
* @author 연구개발 5팀 사원 김재성
* @since 2024. 03. 11.
* @version 1.0
* @see javax.servlet.http.HttpServlet 
* <pre>
* [[개정이력(Modification Information)]]
*    수정일            수정자               수정내용
* ------------     --------    ----------------------
* 2024.03.11.        김재성       최초작성
* 2024.03.13.        김재성       등록 추가
* Copyright (c) 2024 by INNOVATION-T All right reserved
* </pre>
*/
@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/question")
public class QuestionController {
	
	private final QuestionService questionService;
	
	@GetMapping("/main")
	public String maingPage() {
		return "question/questionDiffrerntMain";
	}
	
	@PostMapping("/list")
	@ResponseBody
	public PaginationInfo<QuestionVO> questionList(
			 @ModelAttribute("simpleCondition") SearchVO simpleCondition
			,@RequestParam(value="page", required = false, defaultValue = "1") int currentPage
			,Model model
			
		) {
		
		PaginationInfo<QuestionVO> paging = new PaginationInfo<QuestionVO>();
		
		paging.setSimpleCondition(simpleCondition);
		paging.setCurrentPage(currentPage);
		paging.setRenderer(new BootstrapPaginationRenderer());
		
		PaginationInfo<QuestionVO> pagination = questionService.retrieveDifferentQuestionList(paging);
		
		log.info(" 컨트롤러 단에서 넘겨주는 데이터 pagination : {}" , pagination);
		
//		PageCreate pageCreate = new PageCreate();
//		
//		pageCreate.setPaging(pageVO);
//		pageCreate.setArticleTotalCount(questionService.retrieveQuestionTotalRecord(pageVO));
//		
//		List<QuestionVO> questionList = questionService.retrieveQuestionList(pageVO) ;
//		
//		log.info("QnA 게시판 페이징 목록 회신 데이터 : {}" , questionList);
//		
//		pageVO.setPageCnt((pageVO.getPageNum()-1) * pageVO.getCountPerPage());
//		
//		model.addAttribute("questionList", questionList);
		model.addAttribute("pagination", pagination);
		
		
		return pagination;
//		return "question/questionDiffrerntMain";
//		return "question/questionMain";
	}
	
	@GetMapping("/questionInsertForm")
	public String questionInsertForm() {
		return "/question/qnaForm";
	}
	
	@PostMapping("/add")
	public String insertQusetion(
			 @ModelAttribute QuestionVO question
			,Authentication auth
		){
		
		String userId = auth.getName();
		question.setUserId(userId);
		
		log.info("파일 리스트 확인 : {}", question.getFileList());
		
		ServiceResult result;
		String viewName =null;
		
		try {
			result = questionService.createQuestion(question);
			
			if(result.equals(ServiceResult.OK)) {
				viewName = "redirect:/question/main";
			}else {
				viewName = "redirect:/question/questionInsertForm";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return viewName;
	}
	
	
	
}
