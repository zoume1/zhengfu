// see http://vuejs-templates.github.io/webpack for documentation.
var path = require('path')

module.exports = {
  build: {
    env: require('./prod.env'),
    index: path.resolve(__dirname, '../dist/index.html'),
    assetsRoot: path.resolve(__dirname, '../dist/app'),
    assetsSubDirectory: 'static',
    assetsPublicPath: './',
    productionSourceMap: false,
    useEslint: true,
    productionGzip: false,
    productionGzipExtensions: ['js', 'css'],
    bundleAnalyzerReport: process.env.npm_config_report
  },
  dev: {
    env: require('./dev.env'),
    port: 8084,
    proxyTable: {
      '/lp': {
        // target: 'http://www.lpsgsl.com',
        target: 'http://localhost:4444',
        changeOrigin: true,
        pathRewrite: {
          '^/lp': 'lp'
        }
      }
    }
  }
}
