package com.example.BrandPlusRegistrationService.repository;

import com.example.BrandPlusRegistrationService.model.AuthResponse;
import com.example.BrandPlusRegistrationService.model.AuthenticationApiResponse.AuthenticationApiData;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface TtkAuthMyBatisRepository {
    @Select("select * from tiktok_auth")
    public List<AuthResponse> findAll();

    @Select("SELECT * FROM tiktok_auth WHERE business_id = #{businessId} AND user_id = #{email}")
    public AuthResponse findByBusinessId(@NotBlank String businessId, @NotBlank String email);

    @Delete("DELETE FROM tiktok_auth WHERE business_id = #{businessId} AND user_id = #{email}")
    public int deleteBySymbolStartEnd(@NotBlank String businessId, @NotBlank String email);

    @Insert("INSERT INTO tiktok_auth(business_id, access_token, access_time_stamp, refresh_token, ref_time_stamp,user_id) " +
            " VALUES (#{authData.businessId}, #{authData.accessToken}, #{authData.expiresIn}, #{authData.refreshToken}, #{authData.refreshTokenExpiresIn}, #{email})")
    public int insert(@Param("authData") @NotNull AuthenticationApiData authData, @Param("email") @NotBlank String email);

    @Update("UPDATE tiktok_auth SET access_token=#{authData.accessToken}, access_time_stamp=#{authData.expiresIn}, refresh_token=#{authData.refreshToken}, ref_time_stamp=#{authData.refreshTokenExpiresIn} WHERE business_id=#{authData.businessId} AND user_id=#{email}")
    public int updateAccessToken(@Param("authData")@NotNull AuthenticationApiData authData, @Param("email")@NotBlank String email);

    @Select("SELECT COUNT(*) FROM tiktok_auth WHERE business_id = #{businessId} AND user_id=#{email}")
    public int countByBusinessId(@NotBlank String businessId, @NotBlank String email);

    @Select("SELECT access_time_stamp FROM tiktok_auth WHERE business_id = #{businessId} AND user_id=#{email}")
    public Long getAccessExpiryByBusinessId(@NotBlank String businessId, @NotBlank String email);

    @Select("SELECT ref_time_stamp FROM tiktok_auth WHERE business_id = #{businessId} AND user_id=#{email}")
    public Long getRefreshExpiryByBusinessId(@NotBlank String businessId, @NotBlank String email);









}
