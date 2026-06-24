package com.avozdedeus.avozdedeusjpc.audio;

import com.avozdedeus.avozdedeusjpc.audio.data.AudioSessionRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;

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
public final class AudioPlaybackService_MembersInjector implements MembersInjector<AudioPlaybackService> {
  private final Provider<AudioSessionRepository> audioSessionRepositoryProvider;

  public AudioPlaybackService_MembersInjector(
      Provider<AudioSessionRepository> audioSessionRepositoryProvider) {
    this.audioSessionRepositoryProvider = audioSessionRepositoryProvider;
  }

  public static MembersInjector<AudioPlaybackService> create(
      Provider<AudioSessionRepository> audioSessionRepositoryProvider) {
    return new AudioPlaybackService_MembersInjector(audioSessionRepositoryProvider);
  }

  @Override
  public void injectMembers(AudioPlaybackService instance) {
    injectAudioSessionRepository(instance, audioSessionRepositoryProvider.get());
  }

  @InjectedFieldSignature("com.avozdedeus.avozdedeusjpc.audio.AudioPlaybackService.audioSessionRepository")
  public static void injectAudioSessionRepository(AudioPlaybackService instance,
      AudioSessionRepository audioSessionRepository) {
    instance.audioSessionRepository = audioSessionRepository;
  }
}
