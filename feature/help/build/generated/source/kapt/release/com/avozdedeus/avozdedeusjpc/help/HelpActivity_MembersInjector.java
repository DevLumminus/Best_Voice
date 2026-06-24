package com.avozdedeus.avozdedeusjpc.help;

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
public final class HelpActivity_MembersInjector implements MembersInjector<HelpActivity> {
  private final Provider<AppNavigator> appNavigatorProvider;

  public HelpActivity_MembersInjector(Provider<AppNavigator> appNavigatorProvider) {
    this.appNavigatorProvider = appNavigatorProvider;
  }

  public static MembersInjector<HelpActivity> create(Provider<AppNavigator> appNavigatorProvider) {
    return new HelpActivity_MembersInjector(appNavigatorProvider);
  }

  @Override
  public void injectMembers(HelpActivity instance) {
    injectAppNavigator(instance, appNavigatorProvider.get());
  }

  @InjectedFieldSignature("com.avozdedeus.avozdedeusjpc.help.HelpActivity.appNavigator")
  public static void injectAppNavigator(HelpActivity instance, AppNavigator appNavigator) {
    instance.appNavigator = appNavigator;
  }
}
