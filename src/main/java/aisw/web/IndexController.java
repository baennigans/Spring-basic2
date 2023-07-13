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

	public List<News> getNewList() ... {
		// 뉴스 정보 받아올 url 입력
		String url = "http://172.31.9.169:8080/index";
		//RestTemplate으로 JSON 결과값 받아오기
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(url,  HttpMethod.GET, null, String.class);
		// 결과값 중 JSON 데이터만 가져와기
		String responseBody = null;
		if (response.getStatusCode().is2xxSuccessful()) {
			responseBody = response.getBody();
			System.out.println(responseBody);
		} else {
			System.out.println("fail : " + response.getStatusCode());
		}
		// JSON 데이터를 VO로 mapping하기 (상대방 JSON 데이터에 맞는 VO를 생성해야 함
		List<News> newsList = null;
		ObjectMapper mapper = new ObjectMapper();
		newsList = mapper.readValue(responseBody, new TypeReference<List<News>>() {});
						
		return newsList;
		}	
}