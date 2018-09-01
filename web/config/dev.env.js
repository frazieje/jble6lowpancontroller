'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  SCANNER_PORT: "8089",
  SHOVEL_PORT: "8081",
  DEV_SERVER_URL: "'http://192.168.2.49'",
  USE_DEV_SERVER: "true"
})
