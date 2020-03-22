<template>
    <b-navbar class="navbar" toggleable="sm" type="dark" variant="success">
        <b-navbar-brand href="#">
            <img class="brand-logo" src="img/logo.png" alt="Shop Safe / Save Lifes">
            <span class="brand-name">Shop Safe / Save Lifes</span>
        </b-navbar-brand>
        <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>
        <b-collapse is-nav id="nav_collapse">
            <b-navbar-nav>
                <b-nav-item to="/">Stores</b-nav-item>
                <b-nav-item to="/profile">My Profile</b-nav-item>
                <b-nav-item to="/codes">My Codes</b-nav-item>
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
        padding-left: 5rem;
    }
    .brand-logo {
        position: absolute;
        top: 0;
        left: 0;
        border-style: solid;
        border-width: thick;
        border-color: #28a745 !important;
        z-index: 5;
        height: 5rem;
    }

    @media (min-width: 800px) {
        .navbar {
            padding-left: 11rem;
        }

        .brand-logo {
            height: 11rem;
        }
    }


    .brand-name {
        font-weight: bold;
        margin-left: 1rem;
    }
</style>
