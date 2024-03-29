/*
 * Copyright 2024 Evgenii Plugatar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.plugatar.uncheckedlambdas;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for {@link ThFunction}.
 */
final class ThFunctionTest {

  @Test
  void asUncheckedMethodExceptionLambdaResult() {
    final Throwable throwable = new Throwable();
    final Object functionArg = new Object();
    final ThFunction<Object, Object, Throwable> originFunction = arg -> { throw throwable; };

    final ThFunction<Object, Object, RuntimeException> unchecked = originFunction.asUnchecked();
    assertThatThrownBy(() -> unchecked.apply(functionArg))
      .isSameAs(throwable);
  }

  @Test
  void asUncheckedMethodLambdaResult() {
    final Object functionArg = new Object();
    final AtomicReference<Object> sideEffect = new AtomicReference<>();
    final Object functionResult = new Object();
    final ThFunction<Object, Object, Throwable> originFunction = arg -> {
      sideEffect.set(arg);
      return functionResult;
    };

    final ThFunction<Object, Object, RuntimeException> unchecked = originFunction.asUnchecked();
    assertThat(unchecked.apply(functionArg))
      .isSameAs(functionResult);
    assertThat(sideEffect.get())
      .isSameAs(functionArg);
  }
}
