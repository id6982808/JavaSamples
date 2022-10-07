package com.gradleproject.demo_gradle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gradleproject.demo_gradle.entities.Comment;
import com.gradleproject.demo_gradle.repository.CommentRepository;

@Controller
public class CommentController {
	
	@Autowired
	private CommentRepository repository;
	
	@GetMapping("/comment")
	public String getAllComments(@ModelAttribute Comment comment, Model model) {
		model.addAttribute("comments", repository.findAll());
		return "comment_list";
	}
	
	@PostMapping("/comment/add")
	public String addComment(@Validated @ModelAttribute Comment comment, BindingResult result, Model model) {
		model.addAttribute("comments", repository.findAll());
		if (result.hasErrors()) {
			return "comment_list";
		}
		
		repository.save(comment);
		return "redirect:/comment";
	}
	
	@GetMapping("/comment/delete")
	public String deleteComment(@Validated @ModelAttribute Comment comment, BindingResult result, Model model) {
		model.addAttribute("comments", repository.findAll());
		repository.deleteById(comment.getId());
		return "redirect:/comment";
	}
}
