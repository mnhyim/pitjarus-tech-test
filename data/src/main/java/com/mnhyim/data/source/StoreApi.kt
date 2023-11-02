package com.mnhyim.data.source

import com.mnhyim.data.dto.LoginRequest
import com.mnhyim.data.dto.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface StoreApi {

    @POST
    fun userLogin(@Body requestBody: LoginRequest): LoginResponse

}