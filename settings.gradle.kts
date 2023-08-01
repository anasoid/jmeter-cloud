/*
 * Copyright 2023-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * @author : anas
 * Date :   08-Jun-2023
 */

plugins {
    // Apply the foojay-resolver plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.4.0"
}

rootProject.name = "jmeter-cloud"
include(
    "jmeter-cloud-app",
    "jmeter-cloud-cluster:jmeter-cloud-cluster-rest",
    "jmeter-cloud-api:jmeter-cloud-api-rest",
    "jmeter-cloud-common:jmeter-cloud-core",
    "jmeter-cloud-common:jmeter-cloud-common-rest",
    "jmeter-cloud-common:jmeter-cloud-utilities"
)

include("BuildUtils:code-coverage-report")
