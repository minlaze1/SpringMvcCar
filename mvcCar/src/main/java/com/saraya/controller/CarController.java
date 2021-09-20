package com.saraya.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.saraya.model.Car;
import com.saraya.service.CarService;

@Controller
public class CarController {

	@Autowired
	CarService cs;
	@RequestMapping(value="/list-car", method=RequestMethod.GET)
	public String ShowList(ModelMap model) {
		model.addAttribute("cars", cs.getAllCars());
		return "carList";
	}
	
	//------------------ADDING METHOD----------------------------
	
	@RequestMapping(value="/add-car", method=RequestMethod.GET)
			public String addCarForm(ModelMap model) {
		model.addAttribute("vehicle", new Car());
		return "addCar";
	}
	
	@RequestMapping(value="/add-car", method=RequestMethod.POST)
	public String carAdded(ModelMap model, @Valid Car c, BindingResult result) {
		if(result.hasErrors())
			return "addCar";
		cs.addCar(c.getYear(), c.getMake(), c.getModel(), c.getImage());
		model.clear();
		return "redirect:/list-car";
	}
	
	//----------------------------------------------------------------
	
	
	
	//--------------UPDATE METHOD-----------------------------
	
	@RequestMapping(value="/update-car", method=RequestMethod.GET)
	public String updateCarForm(ModelMap model, @RequestParam int id) {
		model.addAttribute("vehicle", cs.findById(id));
		return "addCar";
	}
	//-------------------------------------------------
	@RequestMapping(value="/update-car", method=RequestMethod.POST)
	public String carListUpdate(ModelMap model, @Valid Car c,
			BindingResult result) {
		
		if(result.hasErrors())
			return "addCar";
		
		cs.updateByCar(c);
		model.clear();
		return "redirect:/list-car";
	}
	//-----------------------------------------------------
	
	@RequestMapping(value="/delete-car", method=RequestMethod.GET)
	public String deleteList(ModelMap model, @RequestParam int id ) {
		cs.deleteCar(id);
		model.clear();
		return "redirect:/list-car";
		
	}
}
