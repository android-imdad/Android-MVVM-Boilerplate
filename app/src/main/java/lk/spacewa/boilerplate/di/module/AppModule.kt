package lk.spacewa.boilerplate.di.module

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import lk.spacewa.boilerplate.BuildConfig
import lk.spacewa.boilerplate.data.AppDataManager
import lk.spacewa.boilerplate.data.DataManager
import lk.spacewa.boilerplate.data.local.prefs.PreferencesHelper
import lk.spacewa.boilerplate.data.local.prefs.PreferencesHelperImpl
import lk.spacewa.boilerplate.di.ApiInfo
import lk.spacewa.boilerplate.di.PreferenceInfo
import lk.spacewa.boilerplate.utils.AppConstants
import lk.spacewa.boilerplate.utils.rx.AppSchedulerProvider
import lk.spacewa.boilerplate.utils.rx.SchedulerProvider
import javax.inject.Singleton

/**
 * Created by Imdad on 05/11/20.
 */
@Module
@InstallIn(ApplicationComponent::class)
class AppModule {


    @Provides
    @ApiInfo
    fun provideApiKey(): String {
        return BuildConfig.API_KEY
    }


    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }


    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    }

    @Provides
    @PreferenceInfo
    fun providePreferenceName(): String? {
        return AppConstants.PREF_NAME
    }

    @Provides
    @Singleton
    fun providePreferencesHelper(preferencesHelperImpl: PreferencesHelperImpl): PreferencesHelper {
        return preferencesHelperImpl
    }

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }
}