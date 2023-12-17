package com.github.cms.config;


import com.alibaba.fastjson2.serializer.SerializerFeature;
import com.alibaba.fastjson2.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 16/9/10.
 */
@Configuration
public class JSONSerializeConfig {

    @Bean
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(supportedMediaTypes);
        converter.setFeatures(
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullNumberAsZero
        );
        return converter;
    }


}
