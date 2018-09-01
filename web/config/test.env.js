'use strict'
const merge = require('webpack-merge')
const devEnv = require('./dev.env')

module.exports = merge(devEnv, {
  NODE_ENV: '"testing"',
  SCANNER_PORT: "8089",
  SHOVEL_PORT: "8081",
  USE_DEV_SERVER: "true",
  DEV_SERVER_URL: "'http:192.168.2.48'"
})
