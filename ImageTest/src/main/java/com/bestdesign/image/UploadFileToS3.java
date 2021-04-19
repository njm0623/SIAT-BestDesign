package com.bestdesign.image;

import java.io.File;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

public class UploadFileToS3 {
    public static void main(String[] args)throws Exception {
    	uploadToBucket();
    }

    public static void uploadToBucket() throws Exception {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(Credentials.access_key_id, Credentials.secret_access_key);

        AmazonS3Client s3Client = new AmazonS3Client(awsCreds);
        
        s3Client.withRegion(Regions.AP_NORTHEAST_2);
        
        String BucketName = "bestdesign";
        
        String filepath = "C:\\Users\\njk28\\Desktop\\tyche.1.1.4.zip";
        String fileName = "tyche.1.1.4.zip";
        File file = new File(filepath);

        PutObjectRequest putRequest1 = new PutObjectRequest(BucketName, fileName, file);
        PutObjectResult response1 = s3Client.putObject(putRequest1);
        if (response1.getSSEAlgorithm() == null) {
        	System.out.println("파일 업로드 성공!");
        }
        else {
        	System.out.println("오류 발생!\n" + response1.getSSEAlgorithm());
        }
    }
}