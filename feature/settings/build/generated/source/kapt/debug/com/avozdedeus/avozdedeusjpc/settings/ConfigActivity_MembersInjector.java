package com.avozdedeus.avozdedeusjpc.settings;

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
public final class ConfigActivity_MembersInjector implements MembersInjector<ConfigActivity> {
  private final Provider<AppNavigator> appNavigatorProvider;

  public ConfigActivity_MembersInjector(Provider<AppNavigator> appNavigatorProvider) {
    this.appNavigatorProvider = appNavigatorProvider;
  }

  public static MembersInjector<ConfigActivity> create(
      Provider<AppNavigator> appNavigatorProvider) {
    return new ConfigActivity_MembersInjector(appNavigatorProvider);
  }

  @Override
  public void injectMembers(ConfigActivity instance) {
    injectAppNavigator(instance, appNavigatorProvider.get());
  }

  @InjectedFieldSignature("com.avozdedeus.avozdedeusjpc.settings.ConfigActivity.appNavigator")
  public static void injectAppNavigator(ConfigActivity instance, AppNavigator appNavigator) {
    instance.appNavigator = appNavigator;
  }
}
