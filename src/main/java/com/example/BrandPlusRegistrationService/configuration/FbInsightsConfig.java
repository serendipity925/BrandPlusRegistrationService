package com.example.BrandPlusRegistrationService.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FbInsightsConfig {
    @Bean
    @ConfigurationProperties(prefix="facebook-insights")
    public FbUrlConfig getFbInsightConfig(){ return new FbUrlConfig();}

    @Data
    public static class FbUrlConfig{
        public String base;
        public String insightTag;
        public String fields;
        public String mediaTagFields;
        public String demographics;
        public String periodTag;
        public String sinceTag;
        public String untilTag;
        public String accessTokenTag;

        public String getFbInsightUrl(String pageID, Long since, Long until, String accessToken){
            String url = this.base + pageID + this.insightTag + this.fields +
                    this.periodTag + "day" + this.sinceTag + since.toString() +
                    this.untilTag + until.toString() + this.accessTokenTag +
                    accessToken;
            return url;
        }

        public String getFbDemographicsUrl(String pageID, Long since, Long until, String accessToken){
            String url = this.base + pageID + this.insightTag + this.demographics +
                    this.periodTag + "day" + this.sinceTag + since.toString() +
                    this.untilTag + until.toString() + this.accessTokenTag +
                    accessToken;
            return url;
        }

        public String getFbMediaCommentsUrl(String pageID, String accessToken){
            String url = this.base + pageID + this.mediaTagFields + this.accessTokenTag
                    + accessToken;
            return url;
        }
    }
}
