<template>
  <div>
    <head-line>All Shops</head-line>
    <b-table striped hover :items="shopList" :fields="fields"></b-table>
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
    fields: String[] =
      ['type', 'zipcode', 'city', 'street', 'openinghours'];

    get shopList() {
      return shops.allShops;
    }
  }
</script>

<style scoped>
</style>
