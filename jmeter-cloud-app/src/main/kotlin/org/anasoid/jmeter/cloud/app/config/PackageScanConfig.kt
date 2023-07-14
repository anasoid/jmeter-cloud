package org.anasoid.jmeter.cloud.app.config

import org.anasoid.jmeter.cloud.public.rest.config.PackageScanConfig
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(value = [PackageScanConfig::class])
class PackageScanConfig {


}