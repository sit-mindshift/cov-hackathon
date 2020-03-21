<template>
  <div class="home">
    <b-container>
      <ShopList/>
    </b-container>
  </div>
</template>

<script lang="ts">
  import {Component, Vue} from 'vue-property-decorator';
  import ShopList from '../components/ShopList.vue';

  @Component({
    components: {
      ShopList,
    },
  })
  export default class Home extends Vue {}
</script>
