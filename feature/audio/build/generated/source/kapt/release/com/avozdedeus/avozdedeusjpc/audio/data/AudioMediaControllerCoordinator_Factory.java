package com.avozdedeus.avozdedeusjpc.audio.data;

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
public final class AudioMediaControllerCoordinator_Factory implements Factory<AudioMediaControllerCoordinator> {
  private final Provider<AudioSessionRepository> sessionRepositoryProvider;

  public AudioMediaControllerCoordinator_Factory(
      Provider<AudioSessionRepository> sessionRepositoryProvider) {
    this.sessionRepositoryProvider = sessionRepositoryProvider;
  }

  @Override
  public AudioMediaControllerCoordinator get() {
    return newInstance(sessionRepositoryProvider.get());
  }

  public static AudioMediaControllerCoordinator_Factory create(
      Provider<AudioSessionRepository> sessionRepositoryProvider) {
    return new AudioMediaControllerCoordinator_Factory(sessionRepositoryProvider);
  }

  public static AudioMediaControllerCoordinator newInstance(
      AudioSessionRepository sessionRepository) {
    return new AudioMediaControllerCoordinator(sessionRepository);
  }
}
