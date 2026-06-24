package com.avozdedeus.avozdedeusjpc.audio.presentation;

import com.avozdedeus.avozdedeusjpc.audio.analysis.AudioKeyAnalyzer;
import com.avozdedeus.avozdedeusjpc.audio.analysis.OnsetAnalyzer;
import com.avozdedeus.avozdedeusjpc.audio.data.AudioSessionStore;
import com.avozdedeus.avozdedeusjpc.audio.data.BpmAnalysisCacheStore;
import com.avozdedeus.avozdedeusjpc.core.common.prefs.UserUiPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class AudioViewModel_Factory implements Factory<AudioViewModel> {
  private final Provider<AudioSessionStore> audioSessionRepositoryProvider;

  private final Provider<OnsetAnalyzer> onsetAnalyzerProvider;

  private final Provider<BpmAnalysisCacheStore> bpmAnalysisCacheProvider;

  private final Provider<AudioKeyAnalyzer> audioKeyAnalyzerProvider;

  private final Provider<UserUiPreferences> userUiPreferencesProvider;

  public AudioViewModel_Factory(Provider<AudioSessionStore> audioSessionRepositoryProvider,
      Provider<OnsetAnalyzer> onsetAnalyzerProvider,
      Provider<BpmAnalysisCacheStore> bpmAnalysisCacheProvider,
      Provider<AudioKeyAnalyzer> audioKeyAnalyzerProvider,
      Provider<UserUiPreferences> userUiPreferencesProvider) {
    this.audioSessionRepositoryProvider = audioSessionRepositoryProvider;
    this.onsetAnalyzerProvider = onsetAnalyzerProvider;
    this.bpmAnalysisCacheProvider = bpmAnalysisCacheProvider;
    this.audioKeyAnalyzerProvider = audioKeyAnalyzerProvider;
    this.userUiPreferencesProvider = userUiPreferencesProvider;
  }

  @Override
  public AudioViewModel get() {
    return newInstance(audioSessionRepositoryProvider.get(), onsetAnalyzerProvider.get(), bpmAnalysisCacheProvider.get(), audioKeyAnalyzerProvider.get(), userUiPreferencesProvider.get());
  }

  public static AudioViewModel_Factory create(
      Provider<AudioSessionStore> audioSessionRepositoryProvider,
      Provider<OnsetAnalyzer> onsetAnalyzerProvider,
      Provider<BpmAnalysisCacheStore> bpmAnalysisCacheProvider,
      Provider<AudioKeyAnalyzer> audioKeyAnalyzerProvider,
      Provider<UserUiPreferences> userUiPreferencesProvider) {
    return new AudioViewModel_Factory(audioSessionRepositoryProvider, onsetAnalyzerProvider, bpmAnalysisCacheProvider, audioKeyAnalyzerProvider, userUiPreferencesProvider);
  }

  public static AudioViewModel newInstance(AudioSessionStore audioSessionRepository,
      OnsetAnalyzer onsetAnalyzer, BpmAnalysisCacheStore bpmAnalysisCache,
      AudioKeyAnalyzer audioKeyAnalyzer, UserUiPreferences userUiPreferences) {
    return new AudioViewModel(audioSessionRepository, onsetAnalyzer, bpmAnalysisCache, audioKeyAnalyzer, userUiPreferences);
  }
}
