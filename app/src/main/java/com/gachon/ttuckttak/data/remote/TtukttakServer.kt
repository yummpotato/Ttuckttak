package com.gachon.ttuckttak.data.remote

import com.gachon.ttuckttak.base.BaseResponse
import com.gachon.ttuckttak.data.remote.dto.LoginRes
import com.gachon.ttuckttak.data.remote.service.LoginService
import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TtukttakServer {
    // Todo: URL 작성
    private const val URL = ""

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .client(OkHttpClient.Builder().build())
        .build()

    private val loginService: LoginService = retrofit.create(LoginService::class.java)

    suspend fun loginWithKakao(authorizationCode: String): BaseResponse<LoginRes> = withContext(Dispatchers.IO) {
        loginService.kakaoLogin(accessToken = authorizationCode)
    }

    suspend fun loginWithGoogle(authorizationCode: String): BaseResponse<LoginRes> = withContext(Dispatchers.IO) {
        loginService.googleLogin(accessToken = authorizationCode)
    }

}