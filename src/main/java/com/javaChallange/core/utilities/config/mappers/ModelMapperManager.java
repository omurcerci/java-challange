package com.javaChallange.core.utilities.config.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelMapperManager {
	@Autowired
	private ModelMapper modelMapper;

	public ModelMapper forResponse() {
		this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);

		return this.modelMapper;
	}

	public ModelMapper forRequest() {
		// TODO Auto-generated method stub
		return null;
	}
}
