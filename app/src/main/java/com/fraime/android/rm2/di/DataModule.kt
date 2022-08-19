package com.fraime.android.rm2.di

import com.fraime.android.rm2.data.repository.CharacterRepositoryImpl
import com.fraime.android.rm2.data.storage.CharacterStorage
import com.fraime.android.rm2.data.storage.network.retrofit.RetrofitStorage
import com.fraime.android.rm2.domain.repository.CharacterRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideCharacterRepository(characterStorage: CharacterStorage) : CharacterRepository {
        return CharacterRepositoryImpl(characterStorage = characterStorage )
    }

    @Provides
    fun provideCharacterStorage() : CharacterStorage {
        return RetrofitStorage()
    }
}