package org.keycube.fiasservice.mapper;

import org.keycube.fiasservice.dadata.pojo.DaDataResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.keycube.fiasservice.internal.pojo.InternalResponse;

@Mapper(componentModel = "cdi")
public interface FiasMapper {

  FiasMapper MAPPER = Mappers.getMapper(FiasMapper.class);

  // TODO: Описать формулы java(expression). Пока реализовано через Getters в DaDataData
  // @Mapping(target = "suggestions.data.build", expression = "java(expression)")
  // @Mapping(target = "suggestions.data.struct", expression = "java(expression)")
  @Mapping(target = "resultSource", ignore = true)
  InternalResponse daDataResponseToInternalResponse(DaDataResponse daDataResponse);
}
