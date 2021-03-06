/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.streaming.runtime.operators;

import org.apache.flink.annotation.Internal;

/**
 * This interface must be implemented by objects that are triggered by the timer service available
 * to stream operators in {@link org.apache.flink.streaming.api.environment.StreamExecutionEnvironment}.
 */
@Internal
public interface Triggerable {

	/**
	 * This method is invoked with the timestamp for which the trigger was scheduled.
	 * <p>
	 * If the triggering is delayed for whatever reason (trigger timer was blocked, JVM stalled due
	 * to a garbage collection), the timestamp supplied to this function will still be the original
	 * timestamp for which the trigger was scheduled.
	 * 
	 * @param timestamp The timestamp for which the trigger event was scheduled.
	 */
	void trigger(long timestamp) throws Exception ;
}
