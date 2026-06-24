package com.avozdedeus.avozdedeusjpc.help;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class HelpViewModel_Factory implements Factory<HelpViewModel> {
  @Override
  public HelpViewModel get() {
    return newInstance();
  }

  public static HelpViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static HelpViewModel newInstance() {
    return new HelpViewModel();
  }

  private static final class InstanceHolder {
    static final HelpViewModel_Factory INSTANCE = new HelpViewModel_Factory();
  }
}
