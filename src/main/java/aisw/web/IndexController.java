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
		// ���� ���� �޾ƿ� url �Է�
		String url = "http://172.31.9.169:8080/index";
		//RestTemplate���� JSON ����� �޾ƿ���
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(url,  HttpMethod.GET, null, String.class);
		// ����� �� JSON �����͸� �����ͱ�
		String responseBody = null;
		if (response.getStatusCode().is2xxSuccessful()) {
			responseBody = response.getBody();
			System.out.println(responseBody);
		} else {
			System.out.println("fail : " + response.getStatusCode());
		}
		// JSON �����͸� VO�� mapping�ϱ� (���� JSON �����Ϳ� �´� VO�� �����ؾ� ��
		List<News> newsList = null;
		ObjectMapper mapper = new ObjectMapper();
		newsList = mapper.readValue(responseBody, new TypeReference<List<News>>() {});
						
		return newsList;
		}	
}