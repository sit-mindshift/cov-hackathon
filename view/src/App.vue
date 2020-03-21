<template>
  <div id="app">
      <navbar></navbar>
      <main id="app-main-content">
        <router-view/>
      </main>
  </div>
</template>

<script>
  import {Component, Vue} from 'vue-property-decorator';
  import Navbar from './components/Navbar';

  @Component({
    components: {
      Navbar,
    },
  })
  export default class App extends Vue {
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
