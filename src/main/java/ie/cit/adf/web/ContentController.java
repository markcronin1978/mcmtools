package ie.cit.adf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentController {

	@RequestMapping(value="/")    //this URL comes from the spring-infrastructure.xml file
	public String content(Model model) {
		return "content";
	}
	
}