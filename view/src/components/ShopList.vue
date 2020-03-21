<template>
  <div>
    <head-line>All Shops</head-line>
    <Map/>
    <b-table striped hover :items="shopList" :fields="fields" @row-clicked="openDetailView"></b-table>
  </div>
</template>

<script lang="ts">
  import { Component, Vue } from 'vue-property-decorator';
  import HeadLine from '@/components/HeadLine.vue'
  import shops, {Shop} from '../store/models/shop';
  import router from '@/router';
  import Map from './Map.vue';

@Component({ 
  components: {
    HeadLine,
    Map
  } 
})
  export default class extends Vue {
    shopId: number = 0;
    fields: String[] =
      ['type', 'zipcode', 'city', 'street', 'openinghours'];

    get shopList() {
      return shops.allShops;
    }

    public openDetailView(record: any, index: any){
      this.shopId = shops.allShops[index].id;
      router.push({ name: "Detail", params: { id: this.shopId } })
    }
  }
</script>

<style scoped>
</style>
