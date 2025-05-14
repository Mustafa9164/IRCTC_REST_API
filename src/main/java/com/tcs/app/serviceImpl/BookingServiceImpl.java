package com.tcs.app.serviceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.tcs.app.request.Passenger;
import com.tcs.app.response.Ticket;
import com.tcs.app.service.BookinfService;

@Service
public class BookingServiceImpl implements BookinfService {
	
	private Map<Integer, Ticket> ticketMap=new HashMap<>();
	private Integer ticketNum=1;

	@Override
	public Ticket bookTicket(Passenger passenger) {
		
		Ticket t=new Ticket();
		BeanUtils.copyProperties(passenger, t);
		t.setTicketCost(550.00);
		t.setStatus("CONFIRMED");
		t.setTicketNum(ticketNum);
		ticketMap.put(ticketNum, t);
		ticketNum++;
		return t;
		
	}


	@Override
	public Ticket getTicket(Integer ticketId) {
		if(ticketMap.containsKey(ticketId)) {
			return ticketMap.get(ticketId);
		}
		return null;
	}



}
