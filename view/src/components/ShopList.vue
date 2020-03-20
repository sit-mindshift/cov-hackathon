<template>
  <div>
    <h2>All Shops</h2>
    <b-table striped hover :items="allShops"></b-table>
  </div>
</template>

<script lang="ts">
  import { Component, Vue } from 'vue-property-decorator';
  import shops, {Shop} from '../store/models/shop';

  @Component({
  })
  export default class extends Vue {
    private allShops: Shop[] = shops.allShops;
  }
</script>

<style scoped>
</style>
