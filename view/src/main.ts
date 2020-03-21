import Vue from 'vue';
import App from './App.vue';
import router from './router';
import Vuex from 'vuex';
import BootstrapVue from 'bootstrap-vue';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import store from '@/store/store';
import {setupInterceptors} from '@/utils/HttpInterceptor';
import VueMapkit from 'vue-mapkit'

Vue.use(VueMapkit, {
    authorizationCallback(done: any) {
      done("eyJhbGciOiJFUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6IjhKOFZBNVU4OTYifQ.eyJpc3MiOiJNUzVCOUxRVExEIiwiaWF0IjoxNTg0ODA1Nzg2LjI4NSwiZXhwIjoxNjAwNTg0NTg2LjI4NSwib3JpZ2luIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgxIn0.HsLp1QojMOSzv9ymCq7p8MDxQGcbhcuBoHynAA7Xgudvb09tCHwOJB1qWFiKjktXiU-tbNToYGz91odXxyDLBw")
    },
    // you can use options from mapkit documentation as well
    language: 'de',
})

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
