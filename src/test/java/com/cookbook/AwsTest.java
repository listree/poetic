
package com.cookbook;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.PutObjectResult;

import java.io.File;

/**
 * Run localstack, See https://github.com/localstack/localstack
 */
public class AwsTest {

    public static final void main(String[] args) {
        AmazonS3 s3Client = getClientS3();
        String bucketName = "mybucket3";
        Bucket s3Bucket = s3Client.createBucket(bucketName);
        System.out.println(s3Client.listBuckets());
        System.out.println(s3Client.getBucketAcl(bucketName));

        PutObjectResult putResult = s3Client.putObject(bucketName, "jenkins.json", new File("/tmp/jenkins.json"));
        System.out.println(putResult);
    }

    public static AmazonS3 getClientS3() {
        AwsClientBuilder.EndpointConfiguration s3Endpoint =
            new AwsClientBuilder.EndpointConfiguration("http://localhost:4566", "us-east-1"); //"eu-west-3"
        BasicAWSCredentials s3Credentials = new BasicAWSCredentials("test", "test" );
        AWSStaticCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(s3Credentials);
        
        AmazonS3ClientBuilder builder = AmazonS3ClientBuilder.standard()
            .withCredentials(credentialsProvider)
            .withEndpointConfiguration(s3Endpoint);

        builder.setForceGlobalBucketAccessEnabled(true);
        builder.setPathStyleAccessEnabled(true);

        return builder.build();
    }
}
