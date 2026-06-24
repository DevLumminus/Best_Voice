package com.avozdedeus.avozdedeusjpc.core.common.prefs;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class SharedPreferencesUserUiPreferences_Factory implements Factory<SharedPreferencesUserUiPreferences> {
  private final Provider<Context> contextProvider;

  public SharedPreferencesUserUiPreferences_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public SharedPreferencesUserUiPreferences get() {
    return newInstance(contextProvider.get());
  }

  public static SharedPreferencesUserUiPreferences_Factory create(
      Provider<Context> contextProvider) {
    return new SharedPreferencesUserUiPreferences_Factory(contextProvider);
  }

  public static SharedPreferencesUserUiPreferences newInstance(Context context) {
    return new SharedPreferencesUserUiPreferences(context);
  }
}
