package com.javaChallange.core.utilities.config.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	ModelMapper forResponse();

	ModelMapper forRequest();

}
