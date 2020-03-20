<template>
  <div class="home">
    <ShopList/>
  </div>
</template>

<script>
  import {Component, Vue} from 'vue-property-decorator';
  import ShopList from '../components/ShopList.vue';

  @Component({
    components: {
      ShopList,
    },
  })
  export default class Home extends Vue {}
</script>
