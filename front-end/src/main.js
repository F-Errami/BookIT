import { createApp } from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import { loadFonts } from './plugins/webfontloader'
import router from './router';
import axios from 'axios';
loadFonts()



const app = createApp(App);

app.use(vuetify);


// Create Axios instance
const http = axios.create({
    baseURL: 'http://localhost:8081' // Backend URL
});

// Assign Axios instance to app.config.globalProperties
app.config.globalProperties.$http = http;
app.use(router);

app.mount('#app');
