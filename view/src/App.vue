<template>
  <div id="app">
      <navbar></navbar>
      <main id="app-main-content">
        <Loader :visible="loading"/>

        <!-- normal router view for logged in users -->
        <template v-if="userIsLoggedIn">
          <router-view/>
        </template>

        <!-- login screen -->
        <template v-else>
          <Login/>
        </template>

      </main>
  </div>
</template>

<script lang="ts">
import {Component, Vue} from 'vue-property-decorator';
import Navbar from './components/Navbar.vue';
import Loader from './components/Loader.vue';
import shops from './store/models/shop';
import loading from './store/models/loading';
import user from './store/models/user';
const Login = () => import('./views/Login.vue');


@Component({
  components: {
    Navbar,
    Loader,
    Login,
  },
})
export default class App extends Vue {

  public created() {
    this.getLocation();
  }

  // super scuffed
  get userIsLoggedIn(): boolean {
    return user.state.isLoggedIn;
  }

  public getLocation() {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition((position) => {
        user.changePosition({
            latitude: position.coords.latitude,
            longitude: position.coords.longitude,
          });
        shops.dispatchReadShopList();
      },
      );
    }
  }

  get loading() {
    return loading.state.loading;
  }
}
</script>

<style>
*, *:before, *:after {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
#app {
  font-family: "Montserrat", Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
#app-main-content {
  padding: 1rem;
  width: 100%;
  margin: 0 auto;
}
</style>
