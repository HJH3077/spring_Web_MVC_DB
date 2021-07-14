package com.ict.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ict.service.MyService;
import com.ict.vo.VO;

@Controller
public class MyController {
	@Autowired
	private MyService myService; // 인터페이스로 연결함

	@RequestMapping("list.do")
	public ModelAndView listCommand() {
		// 이제는 무조건 try ~ catch해야함 (dao, service에서 발생하는 오류가 controller로 오기때문에)
		try {
			ModelAndView mv = new ModelAndView("list");
			// list.jsp에 감, .jsp는 servlet-context.xml의 view resolver에 의해 앞 뒤에
			// 접두, 접미사가 붙어서 자동으로 /WEB-INF/views/ , list , .jsp 가 됨
			List<VO> list = myService.getList();
			mv.addObject("list", list);
			return mv;
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("error"); // 에러 발생 시 에러페이지로
		}
	}

	@RequestMapping("write.do")
	public ModelAndView writeCommand() {
		return new ModelAndView("write");
	}

	@RequestMapping("write_ok.do")
	public ModelAndView write_okCommand(VO vo) { // hidden으로 보내는게 아니므로 그냥 받으면 됨 
		try {
			myService.getInsert(vo);
			return new ModelAndView("redirect:list.do");
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("error");
		}
	}

	@RequestMapping("onelist.do")
	// 파라미터 값 idx를 받아 String idx에 저장
	public ModelAndView onelistCommand(@RequestParam("idx") String idx) {
		try {
			ModelAndView mv = new ModelAndView("onelist");
			VO vo = myService.getOneList(idx);
			mv.addObject("vo", vo);
			return mv;
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("error");
		}
	}

	@RequestMapping("del.do")
	// hidden으로 idx, pw를 보냈으니 이렇게 받아짐
	// public ModelAndView deleteCommand(@ModelAttribute("idx")String idx,
	// @ModelAttribute("pw")String pw)
	// 2개를 보냈으므로 VO로 받아보자
	public ModelAndView deleteCommand(@ModelAttribute("vo") VO vo) { // 파라미터 값 받아서 페이지에도 넘김
		return new ModelAndView("del");
	}

	@RequestMapping("del_ok.do")
	public ModelAndView delete_okCommand(@RequestParam("idx") String idx) { // 파라미터 값 받아서 여기서 처리
		try {
			myService.getDelete(idx);
			return new ModelAndView("redirect:list.do");
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("error");
		}
	}

	@RequestMapping("update.do") // onelist와 형태가 같으므로 같은 형식
	public ModelAndView updateCommand(@RequestParam("idx") String idx) {
		try {
			ModelAndView mv = new ModelAndView("update");
			VO vo = myService.getOneList(idx);
			mv.addObject("vo", vo);
			return mv;
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("error");
		}
	}
	
	@RequestMapping("update_ok.do")
	public ModelAndView update_okCommand(VO vo) {
		try {
			myService.getUpdate(vo);
			return new ModelAndView("redirect:onelist.do?idx=" + vo.getIdx());
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("error");
		}
	}
}
