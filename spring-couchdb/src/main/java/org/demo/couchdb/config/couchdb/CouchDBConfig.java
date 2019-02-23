package org.demo.couchdb.config.couchdb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

import java.util.List;

import static java.util.Collections.singletonList;

@Configuration
@EnableCouchbaseRepositories
public class CouchDBConfig extends AbstractCouchbaseConfiguration {

    @Value("${couchbase.ip}")
    private String bootstrapHosts;

    @Value("${couchbase.bucket}")
    private String bucketName;

    @Value("${couchbase.password}")
    private String bucketPassword;

    @Override
    protected List<String> getBootstrapHosts() {
        return singletonList(bootstrapHosts);
    }

    @Override
    protected String getBucketName() {
        return bucketName;
    }

    @Override
    protected String getBucketPassword() {
        return bucketPassword;
    }

}