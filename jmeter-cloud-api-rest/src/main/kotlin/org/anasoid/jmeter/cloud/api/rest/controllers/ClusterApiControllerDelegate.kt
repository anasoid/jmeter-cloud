package org.anasoid.jmeter.cloud.api.rest.controllers

import org.anasoid.jmeter.cloud.api.rest.generated.apis.ClusterApiDelegate
import org.anasoid.jmeter.cloud.api.rest.generated.models.ClusterStatus
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class ClusterApiControllerDelegate : ClusterApiDelegate {

    override suspend fun getClusterStatus(): ResponseEntity<ClusterStatus> {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(ClusterStatus.running);
    }
}