package org.anasoid.jmeter.cloud.api.rest.config

import jakarta.validation.constraints.NotBlank
import org.anasoid.jmeter.cloud.rest.common.config.AbstractRestModuleConfig
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties("jmeter.cloud.module.api")
@Component
open class ModuleConfig : AbstractRestModuleConfig() {




}