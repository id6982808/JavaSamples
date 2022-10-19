package com.gradleproject.demo_gradle.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.gradleproject.demo_gradle.dto.RestResponseDtoForZipCode;

@Component
public class RestClient {

        private final String sampleUri = "https://zipcloud.ibsnet.co.jp/api/search?zipcode=7830060";
        
        private RestTemplate restTemplateJson;
        
        @Autowired
        private RestTemplate restTemplate;

        public RestClient(RestTemplateBuilder restTemplateBuilder, ResponseHeaderInterceptor interceptor) {
        	restTemplateJson = restTemplateBuilder.additionalInterceptors(interceptor).build();
        }

        public RestResponseDtoForZipCode sampleRequest() {
        	URI targetUri = UriComponentsBuilder.fromUriString(sampleUri).build().toUri();
        	RestResponseDtoForZipCode result = restTemplateJson.getForObject(targetUri, RestResponseDtoForZipCode.class);
        	return result;
        }
        
        /***
         * JSON取得用テンプレート
         * @return
         */
        public RestTemplate getRestTemplateJson() {
        	return this.restTemplateJson;
        }
        
        /***
         * 文字列取得用テンプレート
         * @return
         */
        public RestTemplate getRestTemplate() {
        	return this.restTemplate;
        }
}
