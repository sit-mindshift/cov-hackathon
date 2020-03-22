import Vue from 'vue';
import App from './App.vue';
import router from './router';
import Vuex from 'vuex';
import BootstrapVue from 'bootstrap-vue';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import store from '@/store/store';
import {setupInterceptors} from '@/utils/HttpInterceptor';
import VueMapkit from 'vue-mapkit';

Vue.use(VueMapkit, {
    authorizationCallback(done: any) {
      done()
    },
    // you can use options from mapkit documentation as well
    language: 'de',
});

Vue.use(BootstrapVue);
Vue.use(Vuex);

import './registerServiceWorker';

Vue.config.productionTip = false;

new Vue({
  router,
  created: () => {
    setupInterceptors(store);
  },
  render: (h) => h(App),
  store,
}).$mount('#app');
