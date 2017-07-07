package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.beans.Person;

@Controller
public class PersonController {

	@Autowired
	com.service.SpringJdbcService Service;

	@RequestMapping(value = "/searchJdbcContact", method = RequestMethod.GET)
	public ModelAndView searchContact() {
		ModelAndView mav = new ModelAndView("JdbcSearch");
		Person bean = new Person();

		mav.addObject("searchUserGet", bean);
		return mav;
	}

	@RequestMapping(value = "/searchJdbcContact", method = RequestMethod.POST)
	public ModelAndView searchContact(@ModelAttribute("searchlist2") Person vngmem) {
		ModelAndView mav = new ModelAndView("JdbcSearchResult");

		Person bean1 = null;
		try {
			bean1 = Service.searchMemDts(vngmem);
		} catch (Exception e) {
		}

		mav.addObject("searchResultPost", bean1);
		return mav;
	}

	@RequestMapping(value = "/insertJdbcContact", method = RequestMethod.GET)
	public ModelAndView insertMemDtls() {
		ModelAndView mav = new ModelAndView("JdbcInsert");
System.out.println("insertMemDtls:GET");
		Person bean = new Person();
		mav.addObject("insertUser", bean);
		mav.addObject("status", "success");
		return mav;
	}

	@RequestMapping(value = "/insertJdbcContact", method = RequestMethod.POST)
	public ModelAndView insertContact(@ModelAttribute("insertUser") Person vngmem) {
		ModelAndView mav = new ModelAndView("JdbcInsert");
		System.out.println("insertMemDtls:POST");
		try {
			Service.insertMemDts(vngmem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("searchResultPost", vngmem);
		return mav;
	}
}
