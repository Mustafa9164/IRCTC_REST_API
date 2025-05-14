package com.tcs.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tcs.app.request.Passenger;
import com.tcs.app.response.Ticket;
import com.tcs.app.service.BookinfService;

@RestController
public class BookingRestController {
	
	@Autowired
	private BookinfService service;
	
	//method to book ticket 
	
	@PostMapping( 
			value = "/ticket",
			consumes = {"application/json"},
			produces = {"application/json"}
			)
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger){
		Ticket ticket = service.bookTicket(passenger);
		return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
	}
	
	
//	@GetMapping(value = "ticket/id", produces = "application/json")
//	public ResponseEntity<Ticket> getTicket(@RequestParam int id){
//		Ticket ticket = service.getTicket(id);
//		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
//	}
	
	@GetMapping(value = "ticket/{id}", produces = "application/json")
	public Ticket getTicket(@PathVariable Integer id){
		return service.getTicket(id);
	}
	
	//method to get ticket 

}
