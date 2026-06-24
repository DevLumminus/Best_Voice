package com.avozdedeus.avozdedeusjpc.home;

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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<AppNavigator> appNavigatorProvider;

  public MainActivity_MembersInjector(Provider<AppNavigator> appNavigatorProvider) {
    this.appNavigatorProvider = appNavigatorProvider;
  }

  public static MembersInjector<MainActivity> create(Provider<AppNavigator> appNavigatorProvider) {
    return new MainActivity_MembersInjector(appNavigatorProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectAppNavigator(instance, appNavigatorProvider.get());
  }

  @InjectedFieldSignature("com.avozdedeus.avozdedeusjpc.home.MainActivity.appNavigator")
  public static void injectAppNavigator(MainActivity instance, AppNavigator appNavigator) {
    instance.appNavigator = appNavigator;
  }
}
