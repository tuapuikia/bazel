// Copyright 2017 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.google.devtools.build.lib.rules.platform;

import com.google.common.collect.ImmutableList;
import com.google.devtools.build.lib.analysis.TransitiveInfoCollection;
import com.google.devtools.build.lib.events.Location;
import com.google.devtools.build.lib.packages.SkylarkClassObjectConstructor;
import com.google.devtools.build.lib.packages.ToolchainConstructor;
import com.google.devtools.build.lib.syntax.Environment;
import com.google.devtools.build.lib.syntax.EvalException;
import com.google.devtools.build.lib.syntax.FuncallExpression;
import com.google.devtools.build.lib.syntax.FunctionSignature;
import com.google.devtools.build.lib.syntax.SkylarkList;
import com.google.devtools.build.lib.syntax.SkylarkType;
import javax.annotation.Nullable;

/** Skylark value that can be used to create toolchains. */
// TODO(katre): Remove this entirely.
public class SkylarkToolchainConstructor extends SkylarkClassObjectConstructor
    implements ToolchainConstructor {

  private static final String EXEC_COMPATIBLE_WITH = "exec_compatible_with";
  private static final String TARGET_COMPATIBLE_WITH = "target_compatible_with";
  private static final String TOOLCHAIN_DATA = "toolchain_data";

  private static final FunctionSignature.WithValues<Object, SkylarkType> SIGNATURE =
      FunctionSignature.WithValues.create(
          FunctionSignature.of(
              /*numMandatoryPositionals=*/ 0,
              /*numOptionalPositionals=*/ 0,
              /*numMandatoryNamedOnly*/ 0,
              /*starArg=*/ false,
              /*kwArg=*/ true,
              /*names=*/ EXEC_COMPATIBLE_WITH,
              TARGET_COMPATIBLE_WITH,
              TOOLCHAIN_DATA),
          /*defaultValues=*/ ImmutableList.<Object>of(
              SkylarkList.MutableList.EMPTY, SkylarkList.MutableList.EMPTY),
          /*types=*/ ImmutableList.<SkylarkType>of(
              SkylarkType.Combination.of(
                  SkylarkType.LIST, SkylarkType.Simple.of(TransitiveInfoCollection.class)),
              SkylarkType.Combination.of(
                  SkylarkType.LIST, SkylarkType.Simple.of(TransitiveInfoCollection.class)),
              SkylarkType.DICT));

  public SkylarkToolchainConstructor(Location location) {
    super(
        "<no name>", // name is set on export.
        SIGNATURE,
        location);
  }

  @Override
  @Nullable
  protected Object call(Object[] args, @Nullable FuncallExpression ast, @Nullable Environment env)
      throws EvalException, InterruptedException {

    return null;
  }
}
