package aisw.web;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import aisw.web.entity.Notice;
import aisw.web.service.NoticeService;

@Controller
public class IndexController {
	@Autowired
	private NoticeService noticeService;

	@RequestMapping("/index")
	public String index(Model model) throws ClassNotFoundException, SQLException {
		List<Notice> list = noticeService.getList(1, "TITLE", "");
		model.addAttribute("list", list);

		return "index";
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		
//		ModelAndView mv = new ModelAndView("index");
//		List<Notice> list = noticeService.getList(1, "TITLE", "");
//		mv.addObject("list", list);
//
//		return mv;
//	}

}