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
public final class OnsetAnalysisSessionCache_Factory implements Factory<OnsetAnalysisSessionCache> {
  private final Provider<Context> contextProvider;

  public OnsetAnalysisSessionCache_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public OnsetAnalysisSessionCache get() {
    return newInstance(contextProvider.get());
  }

  public static OnsetAnalysisSessionCache_Factory create(Provider<Context> contextProvider) {
    return new OnsetAnalysisSessionCache_Factory(contextProvider);
  }

  public static OnsetAnalysisSessionCache newInstance(Context context) {
    return new OnsetAnalysisSessionCache(context);
  }
}
