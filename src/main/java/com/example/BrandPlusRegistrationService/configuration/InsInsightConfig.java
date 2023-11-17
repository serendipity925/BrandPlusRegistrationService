package com.example.BrandPlusRegistrationService.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsInsightConfig {
    @Bean
    @ConfigurationProperties(prefix="ins-insights")
    public InsUrlConfig getInsUrlConfig(){ return new InsUrlConfig();}

    @Data
    public static class InsUrlConfig{
        public String base;
        public String mediaTag;
        public String insightTag;
        public String basicInfoFields;
        public String profileInfoFields;
        public String fields;
        public String demographics;
        public String periodTag;
        public String defaultPeriod;
        public String demographicsPeriod;
        public String sinceTag;
        public String untilTag;
        public String accessTokenTag;
        public String commentsTag;
        public String commentsFields;

        public String getInsInsightUrl(String insID, Long since, Long until, String accessToken){
            String url = this.base + insID + this.insightTag + this.fields +
                    this.periodTag + this.defaultPeriod + this.sinceTag + since.toString() +
                    this.untilTag + until.toString() + this.accessTokenTag +
                    accessToken;
            return url;
        }

        public String getInsDemographicsUrl(String insID, String accessToken){
            String url = this.base + insID + this.insightTag + this.demographics +
                    this.periodTag + this.demographicsPeriod +
                    this.accessTokenTag + accessToken;
            return url;
        }

        public String getMediaUrl(String insID, String accessToken){
            String url = this.base + insID + this.mediaTag + this.accessTokenTag + accessToken;
            return url;
        }

        public String getBasicInfoUrl(String mediaID, String accessToken){
            String url = this.base + mediaID + this.basicInfoFields + this.accessTokenTag + accessToken;
            return url;
        }

        public String getProfileInfoUrl(String insID, String accessToken){
            String url = this.base + insID + this.profileInfoFields + this.accessTokenTag + accessToken;
            return url;
        }

        public String getCommentsUrl(String mediaID, String accessToken){
            String url = this.base + mediaID + this.commentsTag + this.commentsFields + this.accessTokenTag + accessToken;
            return url;
        }
    }
}
