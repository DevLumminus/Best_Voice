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
public final class DefaultAudioKeyAnalyzer_Factory implements Factory<DefaultAudioKeyAnalyzer> {
  private final Provider<Context> applicationProvider;

  public DefaultAudioKeyAnalyzer_Factory(Provider<Context> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public DefaultAudioKeyAnalyzer get() {
    return newInstance(applicationProvider.get());
  }

  public static DefaultAudioKeyAnalyzer_Factory create(Provider<Context> applicationProvider) {
    return new DefaultAudioKeyAnalyzer_Factory(applicationProvider);
  }

  public static DefaultAudioKeyAnalyzer newInstance(Context application) {
    return new DefaultAudioKeyAnalyzer(application);
  }
}
