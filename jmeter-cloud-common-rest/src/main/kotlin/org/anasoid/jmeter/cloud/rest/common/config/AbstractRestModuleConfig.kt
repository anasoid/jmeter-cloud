package org.anasoid.jmeter.cloud.rest.common.config

import jakarta.validation.constraints.NotBlank

abstract class AbstractRestModuleConfig {

    @NotBlank
    var mapping: String = ""

}