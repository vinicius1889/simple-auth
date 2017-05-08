package br.com.icarros.service;

import br.com.icarros.beans.HazelCastBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hazelcast.core.IMap;
import br.com.icarros.enums.EnumsCollectionsMap;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HazelCastService {




    public IMap getMap(EnumsCollectionsMap mapName){
        return HazelCastBean.getHazelCastClient().getMap(mapName.toString());
    }

    public void put(IMap map,String key, Object item) throws JsonProcessingException {
        String json = new ObjectMapper().writeValueAsString(item);
        map.put(key,json);
    }

    public Object get(IMap map, String key, Class classe) throws IOException {
        String json = (String) map.get(key);
        return new ObjectMapper().readValue(json,classe);
    }


}
