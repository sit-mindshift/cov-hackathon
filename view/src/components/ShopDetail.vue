<template>
  <div>
    <head-line>Shop Detail </head-line>
    <b-table striped hover :items="shopDetail" :fields="fields" >
    </b-table>
  </div>
</template>

<script lang="ts">
  import { Component, Vue } from 'vue-property-decorator';
  import HeadLine from '@/components/HeadLine.vue'
  import shops, {Shop} from '../store/models/shop';
  import router from '@/router';

  @Component({
    components: { HeadLine }
  })
  export default class extends Vue {
    id: string = router.currentRoute.params.id;
    fields: String[] =
      ['type', 'zipcode', 'city', 'street', 'openinghours'];

    get shopDetail() {
      return shops.getShopById(this.id);
    }
  }
</script>

<style scoped>
</style>
