<template>
  <div>
    <h2>All Shops</h2>
    <b-table striped hover :items="shopList" :fields="fields"></b-table>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import shops, {Shop} from '../store/models/shop';

@Component({
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
