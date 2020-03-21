<template>
  <div id="app">
      <navbar></navbar>
    <main id="app-main-content">
      <Loader :visible="loading"/>
      <router-view/>
    </main>
  </div>
</template>

<script lang="ts">
  import {Component, Vue} from 'vue-property-decorator';
  import Navbar from './components/Navbar.vue';
  import Loader from './components/Loader.vue';
  import shops from './store/models/shop';
  import loading from './store/models/loading';

  @Component({
    components: {
      Navbar,
      Loader,
    },
  })
  export default class App extends Vue {
    public beforeCreate() {
      shops.dispatchReadShopList();
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
