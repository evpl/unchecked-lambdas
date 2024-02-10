/*
 * Copyright 2024 Evgenii Plugatar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.plugatar.uncheckedlambdas;

/**
 * Utility class. Contains methods for unchecked performing lambdas.
 * <p>
 * Methods:
 * <ul>
 * <li>{@link #unchecked(ThRunnable)}</li>
 * <li>{@link #unchecked(Object, ThConsumer)}</li>
 * <li>{@link #unchecked(Object, Object, ThBiConsumer)}</li>
 * <li>{@link #unchecked(Object, Object, Object, ThTriConsumer)}</li>
 * <li>{@link #uncheckedRes(ThSupplier)}</li>
 * <li>{@link #uncheckedRes(Object, ThFunction)}</li>
 * <li>{@link #uncheckedRes(Object, Object, ThBiFunction)}</li>
 * <li>{@link #uncheckedRes(Object, Object, Object, ThTriFunction)}</li>
 * </ul>
 */
public final class UncheckedLambdas {

  /**
   * Utility class ctor.
   */
  private UncheckedLambdas() {
  }

  /**
   * Performs given runnable.
   *
   * @param runnable the runnable
   * @throws NullPointerException if {@code runnable} arg is null
   */
  public static void unchecked(final ThRunnable<?> runnable) {
    if (runnable == null) { throw new NullPointerException("runnable arg is null"); }
    runnable.asUnchecked().run();
  }

  /**
   * Performs given consumer on the given argument.
   *
   * @param t        the consumer argument
   * @param consumer the consumer
   * @param <T>      the type of the argument
   * @throws NullPointerException if {@code consumer} arg is null
   */
  public static <T> void unchecked(final T t,
                                   final ThConsumer<? super T, ?> consumer) {
    if (consumer == null) { throw new NullPointerException("consumer arg is null"); }
    consumer.asUnchecked().accept(t);
  }

  /**
   * Performs given consumer on the given arguments.
   *
   * @param t          the first argument
   * @param u          the second argument
   * @param biConsumer the consumer
   * @param <T>        the type of the first argument
   * @param <U>        the type of the second argument
   * @throws NullPointerException if {@code biConsumer} arg is null
   */
  public static <T, U> void unchecked(final T t,
                                      final U u,
                                      final ThBiConsumer<? super T, ? super U, ?> biConsumer) {
    if (biConsumer == null) { throw new NullPointerException("biConsumer arg is null"); }
    biConsumer.asUnchecked().accept(t, u);
  }

  /**
   * Performs given consumer on the given arguments.
   *
   * @param t           the first argument
   * @param u           the second argument
   * @param v           the third argument
   * @param triConsumer the consumer
   * @param <T>         the type of the first argument
   * @param <U>         the type of the second argument
   * @param <V>         the type of the third argument
   * @throws NullPointerException if {@code triConsumer} arg is null
   */
  public static <T, U, V> void unchecked(final T t,
                                         final U u,
                                         final V v,
                                         final ThTriConsumer<? super T, ? super U, ? super V, ?> triConsumer) {
    if (triConsumer == null) { throw new NullPointerException("triConsumer arg is null"); }
    triConsumer.asUnchecked().accept(t, u, v);
  }

  /**
   * Performs given supplier.
   *
   * @param supplier the supplier
   * @param <R>      the type of supplier result
   * @return supplier result
   * @throws NullPointerException if {@code supplier} arg is null
   */
  public static <R> R uncheckedRes(final ThSupplier<? extends R, ?> supplier) {
    if (supplier == null) { throw new NullPointerException("supplier arg is null"); }
    return supplier.asUnchecked().get();
  }

  /**
   * Performs given function on the given argument.
   *
   * @param t        the argument
   * @param function the function
   * @param <T>      the type of the argument
   * @param <R>      the type of function result
   * @return function result
   * @throws NullPointerException if {@code function} arg is null
   */
  public static <T, R> R uncheckedRes(final T t,
                                      final ThFunction<? super T, ? extends R, ?> function) {
    if (function == null) { throw new NullPointerException("function arg is null"); }
    return function.asUnchecked().apply(t);
  }

  /**
   * Performs given function on the given arguments.
   *
   * @param t          the first argument
   * @param u          the second argument
   * @param biFunction the function
   * @param <T>        the type of the first argument
   * @param <U>        the type of the second argument
   * @param <R>        the type of function result
   * @return function result
   * @throws NullPointerException if {@code biFunction} arg is null
   */
  public static <T, U, R> R uncheckedRes(final T t,
                                         final U u,
                                         final ThBiFunction<? super T, ? super U, ? extends R, ?> biFunction) {
    if (biFunction == null) { throw new NullPointerException("biFunction arg is null"); }
    return biFunction.asUnchecked().apply(t, u);
  }

  /**
   * Performs given function on the given arguments.
   *
   * @param t           the first argument
   * @param u           the second argument
   * @param v           the third argument
   * @param triFunction the function
   * @param <T>         the type of the first argument
   * @param <U>         the type of the second argument
   * @param <V>         the type of the third argument
   * @param <R>         the type of function result
   * @return function result
   * @throws NullPointerException if {@code triFunction} arg is null
   */
  public static <T, U, V, R> R uncheckedRes(final T t,
                                            final U u,
                                            final V v,
                                            final ThTriFunction<? super T, ? super U, ? super V, ? extends R, ?> triFunction) {
    if (triFunction == null) { throw new NullPointerException("triFunction arg is null"); }
    return triFunction.asUnchecked().apply(t, u, v);
  }
}
