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
package io.knotx.databridge.adapter.http;

import io.knotx.adapter.common.configuration.ServiceAdapterOptions;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true, publicConverter = false)
class DataSourceAdapterOptions extends ServiceAdapterOptions {

  private static final String DEFAULT_ADDRESS = "knotx.databridge.adapter.http";

  private int cacheTtl;
  private int cacheSize;

  public DataSourceAdapterOptions() {
    init();
  }

  public DataSourceAdapterOptions(DataSourceAdapterOptions other) {
    this.cacheTtl = other.cacheTtl;
    this.cacheSize = other.cacheSize;
  }


  public DataSourceAdapterOptions(JsonObject json) {
    super(json);
    init();
    DataSourceAdapterOptionsConverter.fromJson(json, this);
  }

  private void init() {
    cacheTtl = 0;
    cacheSize = 0;
    setAddress(DEFAULT_ADDRESS);

  }

  int getCacheTtl() {
    return cacheTtl;
  }

  void setCacheTtl(int cacheTtl) {
    this.cacheTtl = cacheTtl;
  }

  int getCacheSize() {
    return cacheSize;
  }

  void setCacheSize(int cacheSize) {
    this.cacheSize = cacheSize;
  }

}
