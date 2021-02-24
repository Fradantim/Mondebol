package com.fradantim.mondebol.service;

import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

@Service
public class MondebolService {

	public String getMondebol() {
		return Faker.instance().pokemon().name();
	}
}
