#!/bin/bash
./gradlew clean build bintrayUpload -PbintrayUser=chrisjyoon -PbintrayKey=3010a84261bc27bc8c1ba067e64aeb2e2cac81c0 -PdryRun=false
