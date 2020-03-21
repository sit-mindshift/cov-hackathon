<template>
  <div>
    <head-line>All Shops</head-line>
    <b-table striped hover :items="allShops"></b-table>
  </div>
</template>

<script lang="ts">
  import { Component, Vue } from 'vue-property-decorator';
  import HeadLine from '@/components/HeadLine.vue'
  import shops, {Shop} from '../store/models/shop';

  @Component({
    components: { HeadLine }
  })
  export default class extends Vue {
    private allShops: Shop[] = shops.allShops;
  }
</script>

<style scoped>
</style>
