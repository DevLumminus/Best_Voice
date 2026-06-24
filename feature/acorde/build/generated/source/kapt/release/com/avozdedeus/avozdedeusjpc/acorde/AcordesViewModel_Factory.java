package com.avozdedeus.avozdedeusjpc.acorde;

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
public final class AcordesViewModel_Factory implements Factory<AcordesViewModel> {
  @Override
  public AcordesViewModel get() {
    return newInstance();
  }

  public static AcordesViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static AcordesViewModel newInstance() {
    return new AcordesViewModel();
  }

  private static final class InstanceHolder {
    static final AcordesViewModel_Factory INSTANCE = new AcordesViewModel_Factory();
  }
}
