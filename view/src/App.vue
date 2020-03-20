<template>
  <div id="app">
      <navbar></navbar>
      <router-view/>
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
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
