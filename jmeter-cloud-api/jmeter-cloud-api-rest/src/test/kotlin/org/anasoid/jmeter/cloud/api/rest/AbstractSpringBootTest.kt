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
package org.anasoid.jmeter.cloud.api.rest

import org.anasoid.jmeter.cloud.api.rest.app.TestModuleApiRestApplication
import org.anasoid.jmeter.cloud.api.rest.config.ModuleConfig
import org.anasoid.jmeter.cloud.api.rest.config.PackageScanConfig
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Import
import org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(classes = [TestModuleApiRestApplication::class])
@AutoConfigureMockMvc
@Import(PackageScanConfig::class)
abstract class AbstractSpringBootTest {

    @Autowired
    protected lateinit var context: ApplicationContext

    protected lateinit var webClient: WebTestClient

    @Autowired
    protected lateinit var moduleConfig: ModuleConfig

    @BeforeEach
    fun setup() {
        this.webClient = WebTestClient
            .bindToApplicationContext(this.context) // add Spring Security test Support
            .apply(SecurityMockServerConfigurers.springSecurity())
            .configureClient()
            .build()
    }
}
