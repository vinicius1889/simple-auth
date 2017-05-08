package br.com.icarros.beans;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

/**
 * Created by vinicius on 07/05/17.
 */
public class HazelCastBean {

    private static ClientConfig config;

    static {
        config = new ClientConfig();
        config.addAddress("172.17.0.1:5702");
    }


    public static HazelcastInstance getHazelCastClient(){
        return HazelcastClient.newHazelcastClient(HazelCastBean.config);
    }

}


