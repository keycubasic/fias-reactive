package org.keycube.fiasservice.mapper;

import static org.junit.jupiter.api.Assertions.*;

import io.quarkus.test.junit.QuarkusTest;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.keycube.fiasservice.dadata.pojo.DaDataData;
import org.keycube.fiasservice.dadata.pojo.DaDataResponse;
import org.keycube.fiasservice.dadata.pojo.DaDataSuggestion;
import org.keycube.fiasservice.internal.pojo.InternalResponse;

@QuarkusTest
class FiasMapperTest {

  @Inject FiasMapper mapper;

  @Test
  void daDataResponseToInternalResponse() {
    DaDataResponse daDataResponse = new DaDataResponse();
    List<DaDataSuggestion> daDataSuggestions = new ArrayList<>();
    DaDataSuggestion daDataSuggestion = new DaDataSuggestion();
    DaDataData daDataData = new DaDataData();
    daDataData.setBlockType("к");
    daDataData.setBlock("9");
    daDataSuggestion.setData(daDataData);
    daDataSuggestions.add(daDataSuggestion);
    daDataResponse.setSuggestions(daDataSuggestions);

    InternalResponse internalResponse = mapper.daDataResponseToInternalResponse(daDataResponse);

    assertEquals(internalResponse.getSuggestions().get(0).getData().getBuild(), "9");
  }
}
