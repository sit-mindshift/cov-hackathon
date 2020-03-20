<template>
    <b-navbar class="navbar" toggleable="sm" type="dark" variant="success">

        <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>

        <b-navbar-brand href="#">Shop Safe</b-navbar-brand>

        <b-collapse is-nav id="nav_collapse">

            <b-navbar-nav>
                <b-nav-item href="/">Stores</b-nav-item>
            </b-navbar-nav>
        </b-collapse>
    </b-navbar>

</template>

<script lang="ts">
  import {Component, Vue} from 'vue-property-decorator';

  @Component
  export default class NavBar extends Vue {
  }
</script>

<style scoped>
    .navbar {
        margin-bottom: 1rem;
    }
</style>
