package com.gachon.ttuckttak.repository.user

import androidx.lifecycle.LiveData
import com.gachon.ttuckttak.data.local.entity.Diagnosis
import com.gachon.ttuckttak.data.local.entity.UserProfile
import com.gachon.ttuckttak.data.remote.dto.view.UserInfoRes

interface LocalUserDataSource {

    suspend fun saveRegistrationEmail(email: String)

    suspend fun getRegistrationEmail(): String?

    suspend fun savePasswordResetEmail(email: String)

    suspend fun getPasswordResetEmail(): String?

    fun getUserProfile(): LiveData<UserProfile>

    suspend fun updateUserInfo(data: UserInfoRes)

    fun getPushStatus(): LiveData<Boolean>

    fun getNightPushStatus(): LiveData<Boolean>

    suspend fun updateLocalPushStatus(targetValue: Boolean)

    suspend fun updateLocalNightPushStatus(targetValue: Boolean)

    // Diagnosis
    fun getRecentDiagnosis(): LiveData<Diagnosis>

    fun getLatestDiagnosis(): LiveData<List<Diagnosis>>
}