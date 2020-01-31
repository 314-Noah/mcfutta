package de.noah.mcfutta.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClientURI;

@Configuration
public class MongoConfig {

    @Autowired
    private Environment env;

    @Bean
    public MongoDbFactory mongoDbFactory() {
        return new SimpleMongoDbFactory(
        		new MongoClientURI(
        			    "mongodb://password_manager:kCivDfSCXkPalgdt@noahcluster-shard-00-00-uqr8c.azure.mongodb.net:27017,"
        			    + "noahcluster-shard-00-01-uqr8c.azure.mongodb.net:27017,noahcluster-shard-00-02-uqr8c.azure.mongodb.net:"
        			    + "27017/test?ssl=true&replicaSet=NoahCluster-shard-0&authSource=admin&retryWrites=true&w=majority"));

    }

	@Bean
	public MongoTemplate mongoTemplate() {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

		return mongoTemplate;

    }

}
