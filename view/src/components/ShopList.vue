<template>
  <div>
      All Shops:
    {{allShops}}

      <p>{{msg}}</p>
  </div>

</template>

<script lang="ts">
  import { Component, Vue } from 'vue-property-decorator';
  import shops, {Shop} from '../store/models/shop';

  @Component({
  })
  export default class extends Vue {
    private allShops: Shop[] = shops.allShops;
    private msg: String = "halloooooo";
  }
</script>

<style scoped>
</style>
