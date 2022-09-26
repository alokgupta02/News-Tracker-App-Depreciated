package com.company.app.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.company.app.dto.NewsDTO;
import com.company.app.entity.News;
import com.company.app.service.NewsService;
import com.company.app.service.ReporterService;
import com.company.app.service.TeamMemberService;

@Controller
public class NewsController {

	@Autowired
	private NewsService newsService;

	@Autowired
	private TeamMemberService teamMemberService;

	@Autowired
	private ReporterService reporterService;

	@GetMapping("/admin/news")
	public String viewNews(Model model) {
		model.addAttribute("listNews", newsService.getAllNews());
		return "news";
	}

	@GetMapping("/admin/news/add")
	public String addNews(Model model) {
		model.addAttribute("newsDTO", new NewsDTO());
		model.addAttribute("reportersList", reporterService.getAllReporter());
		return "add_news";
	}

	@PostMapping("/admin/news/save")
	public String saveNews(@ModelAttribute("news") News news, @ModelAttribute("newsDTO") NewsDTO newsDTO) {
		news.setReporter(reporterService.findReporterById(newsDTO.getReporterId()).get());
		newsService.addNews(news);
		return "redirect:/admin/news";
	}

	@GetMapping("/admin/news/edit/{id}")
	public String editNews(@PathVariable int id, Model model) throws NoSuchElementException{
		int teamId = 1;
		News news = newsService.findNewsById(id).get();
		NewsDTO newsDTO = new NewsDTO();

		newsDTO.setId(news.getId());
		newsDTO.setSlug(news.getSlug());
		newsDTO.setFormat(news.getFormat());
		newsDTO.setState(news.getState());
		newsDTO.setDistrict(news.getDistrict());
		newsDTO.setPriority(news.getPriority());
		newsDTO.setStatus(news.getStatus());
		newsDTO.setRemarks(news.getRemarks());
		newsDTO.setReporterId(news.getReporter().getId());

		if (news.getInput() != null) {
			newsDTO.setInput(news.getInput().getId());
		}
		if (news.getOutput() != null) {
			newsDTO.setOutput(news.getOutput().getId());
		}

		model.addAttribute("inputList", teamMemberService.findByTeam(teamId));
		teamId = 2;
		model.addAttribute("outputList", teamMemberService.findByTeam(teamId));
		model.addAttribute("reportersList", reporterService.getAllReporter());
		model.addAttribute("newsDTO", newsDTO);

		return "add_news";
	}

	@GetMapping("/admin/news/delete/{id}")
	public String deleteNews(@PathVariable int id) throws EmptyResultDataAccessException{
		this.newsService.deleteNews(id);
		return "redirect:/admin/news";
	}
}