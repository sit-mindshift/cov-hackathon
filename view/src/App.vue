<template>
  <div id="app">
      <navbar></navbar>
      <main id="app-main-content">
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
  const Login = () => import('./views/Login.vue');

  @Component({
    components: {
      Navbar,
      Login,
    },
  })
  export default class App extends Vue {
    get userIsLoggedIn(): boolean {
      return true
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
  font-family: Avenir, Helvetica, Arial, sans-serif;
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
