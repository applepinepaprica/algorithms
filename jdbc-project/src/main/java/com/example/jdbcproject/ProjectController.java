package com.example.jdbcproject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProjectController {

	@Autowired
	LineService lineService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(@RequestParam(required = false)Integer id, 
				@RequestParam(required = false) String value, 
				Model model) {
		model.addAttribute("line", new Line());
		model.addAttribute("searchLine", new Line());
		model.addAttribute("lines", lineService.getLines(id, value));

		return "index";
	}

	@RequestMapping(value = { "/addLine" }, method = RequestMethod.POST)
	public String addLine(Line line, Model model) {
		lineService.insertLine(line);
		return "redirect:/";
	}	
}