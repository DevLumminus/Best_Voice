package com.avozdedeus.avozdedeusjpc.audio.data

import com.avozdedeus.avozdedeusjpc.audio.analysis.DefaultOnsetAnalyzer
import com.avozdedeus.avozdedeusjpc.audio.analysis.AudioKeyAnalyzer
import com.avozdedeus.avozdedeusjpc.audio.analysis.DefaultAudioKeyAnalyzer
import com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetAnalyzer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AudioDataModule {
    @Binds
    @Singleton
    abstract fun bindAudioSessionStore(
        repository: AudioSessionRepository
    ): AudioSessionStore

    @Binds
    @Singleton
    internal abstract fun bindOnsetAnalyzer(
        impl: DefaultOnsetAnalyzer
    ): OnsetAnalyzer

    @Binds
    @Singleton
    internal abstract fun bindAudioKeyAnalyzer(
        impl: DefaultAudioKeyAnalyzer
    ): AudioKeyAnalyzer

    @Binds
    @Singleton
    abstract fun bindBpmAnalysisCacheStore(
        impl: SharedPreferencesBpmAnalysisCache
    ): BpmAnalysisCacheStore
}
