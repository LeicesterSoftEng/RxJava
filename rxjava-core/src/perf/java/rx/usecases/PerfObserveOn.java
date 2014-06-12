/**
 * Copyright 2014 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package rx.usecases;

import org.openjdk.jmh.annotations.GenerateMicroBenchmark;

import rx.schedulers.Schedulers;

public class PerfObserveOn {

    @GenerateMicroBenchmark
    public void observeOnComputation(UseCaseInput input) throws InterruptedException {
        input.observable.observeOn(Schedulers.computation()).subscribe(input.observer);
        input.awaitCompletion();
    }

    @GenerateMicroBenchmark
    public void observeOnNewThread(UseCaseInput input) throws InterruptedException {
        input.observable.observeOn(Schedulers.newThread()).subscribe(input.observer);
        input.awaitCompletion();
    }

    @GenerateMicroBenchmark
    public void observeOnImmediate(UseCaseInput input) throws InterruptedException {
        input.observable.observeOn(Schedulers.immediate()).subscribe(input.observer);
        input.awaitCompletion();
    }

}
