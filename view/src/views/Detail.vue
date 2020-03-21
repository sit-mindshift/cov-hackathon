<template>
  <div class="home">
    <b-container>
      <ShopDetail/>
    </b-container>
  </div>
</template>

<script lang="ts">
  import {Component, Vue} from 'vue-property-decorator';
  import ShopDetail from "@/components/ShopDetail.vue";

  @Component({
    components: {
      ShopDetail,
    },
  })
  export default class Detail extends Vue {
  }
</script>
