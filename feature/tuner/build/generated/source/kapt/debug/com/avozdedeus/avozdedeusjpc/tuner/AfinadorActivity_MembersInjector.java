package com.avozdedeus.avozdedeusjpc.tuner;

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
public final class AfinadorActivity_MembersInjector implements MembersInjector<AfinadorActivity> {
  private final Provider<AppNavigator> appNavigatorProvider;

  public AfinadorActivity_MembersInjector(Provider<AppNavigator> appNavigatorProvider) {
    this.appNavigatorProvider = appNavigatorProvider;
  }

  public static MembersInjector<AfinadorActivity> create(
      Provider<AppNavigator> appNavigatorProvider) {
    return new AfinadorActivity_MembersInjector(appNavigatorProvider);
  }

  @Override
  public void injectMembers(AfinadorActivity instance) {
    injectAppNavigator(instance, appNavigatorProvider.get());
  }

  @InjectedFieldSignature("com.avozdedeus.avozdedeusjpc.tuner.AfinadorActivity.appNavigator")
  public static void injectAppNavigator(AfinadorActivity instance, AppNavigator appNavigator) {
    instance.appNavigator = appNavigator;
  }
}
