package com.avozdedeus.avozdedeusjpc.tuner;

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
public final class AfinadorViewModel_Factory implements Factory<AfinadorViewModel> {
  @Override
  public AfinadorViewModel get() {
    return newInstance();
  }

  public static AfinadorViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AfinadorViewModel newInstance() {
    return new AfinadorViewModel();
  }

  private static final class InstanceHolder {
    static final AfinadorViewModel_Factory INSTANCE = new AfinadorViewModel_Factory();
  }
}
