package com.mnhyim.data.source

import com.mnhyim.data.dto.LoginRequest
import com.mnhyim.data.dto.LoginResponse
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserApi {

    @POST("sariroti_md/index.php/login/loginTest")
    @FormUrlEncoded
    suspend fun userLogin(
        @Field("username") username: String,
        @Field("password") password: String,
    ): LoginResponse

}