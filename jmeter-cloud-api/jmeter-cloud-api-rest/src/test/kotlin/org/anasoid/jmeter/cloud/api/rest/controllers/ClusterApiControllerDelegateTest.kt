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
 * @author : anasoid
 * Date :   7/28/23
 */

package org.anasoid.jmeter.cloud.api.rest.controllers

import org.anasoid.jmeter.cloud.api.rest.AbstractSpringBootTest
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.security.test.context.support.WithMockUser

/**
 * ClusterApiControllerDelegateTest test class.
 */
@AutoConfigureMockMvc
class ClusterApiControllerDelegateTest : AbstractSpringBootTest() {

    @Test
    @WithMockUser
    fun getClusterStatus() {
        webClient.get().uri(moduleConfig.mapping + "/cluster/status")
            .exchange()
            .expectStatus().isAccepted
            .expectBody(String::class.java).isEqualTo("\"running\"")
    }
}
