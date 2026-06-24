package com.avozdedeus.avozdedeusjpc.about;

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
public final class SobreActivity_MembersInjector implements MembersInjector<SobreActivity> {
  private final Provider<AppNavigator> appNavigatorProvider;

  public SobreActivity_MembersInjector(Provider<AppNavigator> appNavigatorProvider) {
    this.appNavigatorProvider = appNavigatorProvider;
  }

  public static MembersInjector<SobreActivity> create(Provider<AppNavigator> appNavigatorProvider) {
    return new SobreActivity_MembersInjector(appNavigatorProvider);
  }

  @Override
  public void injectMembers(SobreActivity instance) {
    injectAppNavigator(instance, appNavigatorProvider.get());
  }

  @InjectedFieldSignature("com.avozdedeus.avozdedeusjpc.about.SobreActivity.appNavigator")
  public static void injectAppNavigator(SobreActivity instance, AppNavigator appNavigator) {
    instance.appNavigator = appNavigator;
  }
}
