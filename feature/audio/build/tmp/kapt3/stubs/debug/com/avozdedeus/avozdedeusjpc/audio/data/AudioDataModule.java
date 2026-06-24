package com.avozdedeus.avozdedeusjpc.audio.data;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H!\u00a2\u0006\u0002\b\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u000eH\'J\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0011H!\u00a2\u0006\u0002\b\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/avozdedeus/avozdedeusjpc/audio/data/AudioDataModule;", "", "()V", "bindAudioKeyAnalyzer", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/AudioKeyAnalyzer;", "impl", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/DefaultAudioKeyAnalyzer;", "bindAudioKeyAnalyzer$audio_debug", "bindAudioSessionStore", "Lcom/avozdedeus/avozdedeusjpc/audio/data/AudioSessionStore;", "repository", "Lcom/avozdedeus/avozdedeusjpc/audio/data/AudioSessionRepository;", "bindBpmAnalysisCacheStore", "Lcom/avozdedeus/avozdedeusjpc/audio/data/BpmAnalysisCacheStore;", "Lcom/avozdedeus/avozdedeusjpc/audio/data/SharedPreferencesBpmAnalysisCache;", "bindOnsetAnalyzer", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/OnsetAnalyzer;", "Lcom/avozdedeus/avozdedeusjpc/audio/analysis/DefaultOnsetAnalyzer;", "bindOnsetAnalyzer$audio_debug", "audio_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class AudioDataModule {
    
    public AudioDataModule() {
        super();
    }
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.avozdedeus.avozdedeusjpc.audio.data.AudioSessionStore bindAudioSessionStore(@org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.data.AudioSessionRepository repository);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetAnalyzer bindOnsetAnalyzer$audio_debug(@org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.analysis.DefaultOnsetAnalyzer impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.avozdedeus.avozdedeusjpc.audio.analysis.AudioKeyAnalyzer bindAudioKeyAnalyzer$audio_debug(@org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.analysis.DefaultAudioKeyAnalyzer impl);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.avozdedeus.avozdedeusjpc.audio.data.BpmAnalysisCacheStore bindBpmAnalysisCacheStore(@org.jetbrains.annotations.NotNull()
    com.avozdedeus.avozdedeusjpc.audio.data.SharedPreferencesBpmAnalysisCache impl);
}