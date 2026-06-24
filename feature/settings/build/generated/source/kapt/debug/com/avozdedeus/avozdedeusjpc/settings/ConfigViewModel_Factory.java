package com.avozdedeus.avozdedeusjpc.settings;

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
public final class ConfigViewModel_Factory implements Factory<ConfigViewModel> {
  private final Provider<UserUiPreferences> userUiPreferencesProvider;

  public ConfigViewModel_Factory(Provider<UserUiPreferences> userUiPreferencesProvider) {
    this.userUiPreferencesProvider = userUiPreferencesProvider;
  }

  @Override
  public ConfigViewModel get() {
    return newInstance(userUiPreferencesProvider.get());
  }

  public static ConfigViewModel_Factory create(
      Provider<UserUiPreferences> userUiPreferencesProvider) {
    return new ConfigViewModel_Factory(userUiPreferencesProvider);
  }

  public static ConfigViewModel newInstance(UserUiPreferences userUiPreferences) {
    return new ConfigViewModel(userUiPreferences);
  }
}
