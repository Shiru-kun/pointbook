package com.mz.cth.Pointbook.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mz.cth.PointBook.modelEnum.Status;
import com.mz.cth.Pointbook.model.PointBook;
import com.mz.cth.Pointbook.model.User;
import com.mz.cth.Pointbook.service.PointService;
import com.mz.cth.Pointbook.service.UserService;

@Controller
@RequestMapping("pointbook")
public class PointController {

	@Autowired
	PointService pointBookService;
	@Autowired
	UserService userService;

	private final String HOME = "/PointClock/pointbook";
	private final String HISTORY = "/PointClock/pointhistory";

	@GetMapping("/home")
	public ModelAndView home(ModelAndView model) {
		model = new ModelAndView(HOME);

		return model;
	}

	@PostMapping("/reg")
	public @ResponseBody boolean save(@RequestParam("lat") double lat, @RequestParam("longit") double longit) {
		System.err.println(lat + "  " + longit + " date" + LocalDateTime.now());
		boolean coordinatesMatch = (lat == -25.9683353 && longit == 32.593817);
		// -25.9530206 32.5711991
		boolean inWorkSaved = false;
		if (coordinatesMatch) {
			User user = new User("Focas");
			Status status = null;
			PointBook pointBook = new PointBook(status.IN, LocalDateTime.now(), user);

			if (userService.save(user) && pointBookService.save(pointBook)) {
				inWorkSaved = true;
			}
			return (coordinatesMatch && inWorkSaved);

		} else {
			return (coordinatesMatch && inWorkSaved);
		}
	}
	@PostMapping("/out")
	public @ResponseBody boolean  saveOut(@RequestParam("lat") double lat, @RequestParam("longit") double longit) {
		System.err.println(lat + "  " + longit + " date" + LocalDateTime.now());
		boolean coordinatesMatch = (lat == -25.9683353 && longit == 32.593817);
		// -25.9530206 32.5711991
		boolean inWorkSaved = false;
		if (coordinatesMatch) {
			User user = new User("Focas");
			Status status = null;
			PointBook pointBook = new PointBook(status.OUT, LocalDateTime.now(), user);

			if (userService.save(user) && pointBookService.save(pointBook)) {
				inWorkSaved = true;
			}
			return (coordinatesMatch && inWorkSaved);

		} else {
			return (coordinatesMatch && inWorkSaved);
		}
	}

	
	@GetMapping("/history")
	public ModelAndView history(ModelAndView model) {
		model = new ModelAndView(HISTORY);
		model.addObject(new PointBook());
		model.addObject(new User());
        model.addObject("points", pointBookService.findAll());
		return model;
	}
	
}
