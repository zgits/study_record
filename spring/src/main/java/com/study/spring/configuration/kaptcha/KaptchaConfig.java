package com.study.spring.configuration.kaptcha;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;


@Configuration
public class KaptchaConfig {



    @Bean
    public DefaultKaptcha getDefaultKaptcha(){
        com.google.code.kaptcha.impl.DefaultKaptcha defaultKaptcha = new com.google.code.kaptcha.impl.DefaultKaptcha();
        Properties properties = new Properties();
//        图片边框
        properties.put("kaptcha.border", "no");
        properties.put("kaptcha.textproducer.font.color", "black");
//        图片高宽
        properties.put("kaptcha.image.width", "150");
        properties.put("kaptcha.image.height", "40");
//        字体大小
        properties.put("kaptcha.textproducer.font.size", "30");
//        存在session中的key
        properties.put("kaptcha.session.key", "verifyCode");
//        验证码长度
        properties.put("kaptcha.textproducer.char.length", "5");
//        文字间隔
        properties.put("kaptcha.textproducer.char.space", "5");
//        图片样式
        properties.put("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.FishEyeGimpy");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);

        return defaultKaptcha;
    }
}
