package com.avozdedeus.avozdedeusjpc.audio.analysis;

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
public final class DefaultOnsetAnalyzer_Factory implements Factory<DefaultOnsetAnalyzer> {
  private final Provider<Context> applicationProvider;

  private final Provider<OnsetAnalysisSessionCache> sessionCacheProvider;

  public DefaultOnsetAnalyzer_Factory(Provider<Context> applicationProvider,
      Provider<OnsetAnalysisSessionCache> sessionCacheProvider) {
    this.applicationProvider = applicationProvider;
    this.sessionCacheProvider = sessionCacheProvider;
  }

  @Override
  public DefaultOnsetAnalyzer get() {
    return newInstance(applicationProvider.get(), sessionCacheProvider.get());
  }

  public static DefaultOnsetAnalyzer_Factory create(Provider<Context> applicationProvider,
      Provider<OnsetAnalysisSessionCache> sessionCacheProvider) {
    return new DefaultOnsetAnalyzer_Factory(applicationProvider, sessionCacheProvider);
  }

  public static DefaultOnsetAnalyzer newInstance(Context application,
      OnsetAnalysisSessionCache sessionCache) {
    return new DefaultOnsetAnalyzer(application, sessionCache);
  }
}
