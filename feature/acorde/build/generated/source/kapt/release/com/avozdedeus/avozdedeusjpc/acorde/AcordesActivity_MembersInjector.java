package com.avozdedeus.avozdedeusjpc.acorde;

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
public final class AcordesActivity_MembersInjector implements MembersInjector<AcordesActivity> {
  private final Provider<AppNavigator> appNavigatorProvider;

  public AcordesActivity_MembersInjector(Provider<AppNavigator> appNavigatorProvider) {
    this.appNavigatorProvider = appNavigatorProvider;
  }

  public static MembersInjector<AcordesActivity> create(
      Provider<AppNavigator> appNavigatorProvider) {
    return new AcordesActivity_MembersInjector(appNavigatorProvider);
  }

  @Override
  public void injectMembers(AcordesActivity instance) {
    injectAppNavigator(instance, appNavigatorProvider.get());
  }

  @InjectedFieldSignature("com.avozdedeus.avozdedeusjpc.acorde.AcordesActivity.appNavigator")
  public static void injectAppNavigator(AcordesActivity instance, AppNavigator appNavigator) {
    instance.appNavigator = appNavigator;
  }
}
