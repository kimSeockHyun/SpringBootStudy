package com.example.service.freeBoard;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.example.model.FreeBoard;
import com.example.repository.FreeBoardRepository;

public class FreeBoardListService {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private FreeBoardRepository freeBoardRepository;
	
	
	
	public String freeBoardList(int PageNum) throws Exception{
		
		
		int pageSize = 10 ;
		PageRequest pageRequest = PageRequest.of(PageNum-1, pageSize, Sort.Direction.DESC, "freeId");
		Page<FreeBoard> freeBoardPage = freeBoardRepository.findAll(pageRequest);
		
		
		if(freeBoardPage.getSize() == 0) {
			session.setAttribute("boardList", new ArrayList<FreeBoard>());
			return "freeBoard";
		}
	
		List<FreeBoard> freeBoardList = freeBoardPage.getContent();
		session.setAttribute("boardList", freeBoardList);
		return "freeBoard";
	}
}
