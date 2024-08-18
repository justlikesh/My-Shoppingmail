package com.apple8._shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;


import java.time.Duration;

@Service
@RequiredArgsConstructor
public class S3Service {     // S3 라이브러리 사용법 이기때문에 복붙해서 쓰기

    @Value("${spring.cloud.aws.s3.bucket}")  // 버킷 이름은 application.properties 에 적어둠
    private String bucket;    // 이 변수에 버킷을 갖다쓰기 때문에 이변수를 갖다쓰면 버킷 명이 출력된다
    private final S3Presigner s3Presigner;

    String createPresignedUrl(String path) {
        var putObjectRequest = PutObjectRequest.builder()
                .bucket(bucket)      // 올릴 버킷 명
                .key(path)    // 경로, 파일 이름 적기 근데 파라미터로 자유롭게 쓸수잇게 함
                .build();
        var preSignRequest = PutObjectPresignRequest.builder()
                .signatureDuration(Duration.ofMinutes(3))     // URL 의 유효기간
                .putObjectRequest(putObjectRequest)
                .build();
        return s3Presigner.presignPutObject(preSignRequest).url().toString();   //presign URL을 하나 만들어서 return 해주는 함수
    }

}
