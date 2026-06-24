package com.avozdedeus.avozdedeusjpc.audio;

import com.avozdedeus.avozdedeusjpc.audio.data.AudioMediaControllerCoordinator;
import com.avozdedeus.avozdedeusjpc.core.navigation.AppNavigator;
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
public final class AudioActivity_MembersInjector implements MembersInjector<AudioActivity> {
  private final Provider<AppNavigator> appNavigatorProvider;

  private final Provider<AudioMediaControllerCoordinator> audioMediaControllerCoordinatorProvider;

  public AudioActivity_MembersInjector(Provider<AppNavigator> appNavigatorProvider,
      Provider<AudioMediaControllerCoordinator> audioMediaControllerCoordinatorProvider) {
    this.appNavigatorProvider = appNavigatorProvider;
    this.audioMediaControllerCoordinatorProvider = audioMediaControllerCoordinatorProvider;
  }

  public static MembersInjector<AudioActivity> create(Provider<AppNavigator> appNavigatorProvider,
      Provider<AudioMediaControllerCoordinator> audioMediaControllerCoordinatorProvider) {
    return new AudioActivity_MembersInjector(appNavigatorProvider, audioMediaControllerCoordinatorProvider);
  }

  @Override
  public void injectMembers(AudioActivity instance) {
    injectAppNavigator(instance, appNavigatorProvider.get());
    injectAudioMediaControllerCoordinator(instance, audioMediaControllerCoordinatorProvider.get());
  }

  @InjectedFieldSignature("com.avozdedeus.avozdedeusjpc.audio.AudioActivity.appNavigator")
  public static void injectAppNavigator(AudioActivity instance, AppNavigator appNavigator) {
    instance.appNavigator = appNavigator;
  }

  @InjectedFieldSignature("com.avozdedeus.avozdedeusjpc.audio.AudioActivity.audioMediaControllerCoordinator")
  public static void injectAudioMediaControllerCoordinator(AudioActivity instance,
      AudioMediaControllerCoordinator audioMediaControllerCoordinator) {
    instance.audioMediaControllerCoordinator = audioMediaControllerCoordinator;
  }
}
