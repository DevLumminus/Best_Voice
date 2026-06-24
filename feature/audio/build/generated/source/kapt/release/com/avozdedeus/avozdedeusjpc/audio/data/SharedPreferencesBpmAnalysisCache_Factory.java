package com.avozdedeus.avozdedeusjpc.audio.data;

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
public final class SharedPreferencesBpmAnalysisCache_Factory implements Factory<SharedPreferencesBpmAnalysisCache> {
  private final Provider<Context> contextProvider;

  public SharedPreferencesBpmAnalysisCache_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public SharedPreferencesBpmAnalysisCache get() {
    return newInstance(contextProvider.get());
  }

  public static SharedPreferencesBpmAnalysisCache_Factory create(
      Provider<Context> contextProvider) {
    return new SharedPreferencesBpmAnalysisCache_Factory(contextProvider);
  }

  public static SharedPreferencesBpmAnalysisCache newInstance(Context context) {
    return new SharedPreferencesBpmAnalysisCache(context);
  }
}
