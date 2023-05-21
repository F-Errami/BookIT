const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
    css: {
        loaderOptions: {
            sass: {
                implementation: require('sass'),
                sassOptions: {
                    // Additional options for Sass
                },
            },
        },
    },
  pluginOptions: {
    vuetify: {
			// https://github.com/vuetifyjs/vuetify-loader/tree/next/packages/vuetify-loader
		}
  }
})
