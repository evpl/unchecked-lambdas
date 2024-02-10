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

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Tests for {@link UncheckedLambdas}.
 */
final class UncheckedLambdasTest {

  @Test
  void uncheckedRunnableMethodThrowsNPEForNullArg() {
    final ThRunnable<Throwable> lambda = null;

    assertThatThrownBy(() -> UncheckedLambdas.unchecked(lambda))
      .isInstanceOf(NullPointerException.class);
  }

  @Test
  void uncheckedConsumerMethodThrowsNPEForNullArg() {
    final Object arg = new Object();
    final ThConsumer<Object, Throwable> lambda = null;

    assertThatThrownBy(() -> UncheckedLambdas.unchecked(arg, lambda))
      .isInstanceOf(NullPointerException.class);
  }

  @Test
  void uncheckedBiConsumerMethodThrowsNPEForNullArg() {
    final Object arg1 = new Object();
    final Object arg2 = new Object();
    final ThBiConsumer<Object, Object, Throwable> lambda = null;

    assertThatThrownBy(() -> UncheckedLambdas.unchecked(arg1, arg2, lambda))
      .isInstanceOf(NullPointerException.class);
  }

  @Test
  void uncheckedTriConsumerMethodThrowsNPEForNullArg() {
    final Object arg1 = new Object();
    final Object arg2 = new Object();
    final Object arg3 = new Object();
    final ThTriConsumer<Object, Object, Object, Throwable> lambda = null;

    assertThatThrownBy(() -> UncheckedLambdas.unchecked(arg1, arg2, arg3, lambda))
      .isInstanceOf(NullPointerException.class);
  }

  @Test
  void uncheckedSupplierMethodThrowsNPEForNullArg() {
    final ThSupplier<Object, Throwable> lambda = null;

    assertThatThrownBy(() -> UncheckedLambdas.uncheckedRes(lambda))
      .isInstanceOf(NullPointerException.class);
  }

  @Test
  void uncheckedFunctionMethodThrowsNPEForNullArg() {
    final Object arg = new Object();
    final ThFunction<Object, Object, Throwable> lambda = null;

    assertThatThrownBy(() -> UncheckedLambdas.uncheckedRes(arg, lambda))
      .isInstanceOf(NullPointerException.class);
  }

  @Test
  void uncheckedBiFunctionMethodThrowsNPEForNullArg() {
    final Object arg1 = new Object();
    final Object arg2 = new Object();
    final ThBiFunction<Object, Object, Object, Throwable> lambda = null;

    assertThatThrownBy(() -> UncheckedLambdas.uncheckedRes(arg1, arg2, lambda))
      .isInstanceOf(NullPointerException.class);
  }

  @Test
  void uncheckedTriFunctionMethodThrowsNPEForNullArg() {
    final Object arg1 = new Object();
    final Object arg2 = new Object();
    final Object arg3 = new Object();
    final ThTriFunction<Object, Object, Object, Object, Throwable> lambda = null;

    assertThatThrownBy(() -> UncheckedLambdas.uncheckedRes(arg1, arg2, arg3, lambda))
      .isInstanceOf(NullPointerException.class);
  }
}
