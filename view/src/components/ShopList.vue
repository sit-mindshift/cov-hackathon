<template>
  <div>
    <head-line>All Shops</head-line>
    <Map/>
    <div class="tablespace">
      <b-table class="shoplist-table" striped hover :items="shopList" :fields="fields" @row-clicked="openDetailView"></b-table>
    </div>
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
    Map,
  },
})
  export default class extends Vue {
    shopId: string = "0";
    fields: String[] =
      ['type', 'zipcode', 'city', 'street', 'openinghours'];

    get shopList() {
      return shops.allShops;
    }

    public openDetailView(record: any, index: number){
      this.shopId = shops.allShops[index].id;
      router.push({ name: "Detail", params: { id: this.shopId } })
    }
  }
</script>

<style scoped>
  .shoplist-table {
    cursor: pointer;
  }
  .tablespace {
    overflow-x: scroll;
    overflow-y: hidden;
  }
</style>
