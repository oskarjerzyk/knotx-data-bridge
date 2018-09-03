/*
 * Copyright (C) 2018 Knot.x Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.knotx.databridge.http.common.post;

import static io.knotx.databridge.http.common.post.UrlEncodedBodyBuilder.encodeBody;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import io.vertx.reactivex.core.MultiMap;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

public class UrlEncodedBodyBuilderTest {

  private final static MultiMap oneField = MultiMap.caseInsensitiveMultiMap()
      .add("field1", "value 1");

  private final static MultiMap twoFields = MultiMap.caseInsensitiveMultiMap()
      .add("field1", "value1").add("field2", "value two");

  private final static MultiMap threeFields = MultiMap.caseInsensitiveMultiMap()
      .add("field1", "value1").add("field2", "value2").add("field three", "value three");

  @Test
  public void whenEmptyMultiMap_expectEmptyBodyString() {
    assertThat(encodeBody(null), equalTo(StringUtils.EMPTY));
    assertThat(encodeBody(MultiMap.caseInsensitiveMultiMap()),
        equalTo(StringUtils.EMPTY));
  }

  @Test
  public void whenOneField_expectBodyStringWithOnePair() {
    assertThat(encodeBody(oneField), equalTo("field1=value%201"));
  }

  @Test
  public void whenTwoFields_expectBodyStringWithTwoPairs() {
    assertThat(encodeBody(twoFields), equalTo("field1=value1&field2=value%20two"));
  }

  @Test
  public void whenThreeFields_expectBodyStringWithThreePairs() {
    assertThat(encodeBody(threeFields),
        equalTo("field1=value1&field2=value2&field%20three=value%20three"));
  }
}
