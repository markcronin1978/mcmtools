package ie.cit.adf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContentController {
	
	/**
	 * this URL comes from the beans.xml file
	 * @param model
	 * @return content view
	 */
	@RequestMapping(value="/")   
	public String content(Model model) {
		return "content";
	}
	
}