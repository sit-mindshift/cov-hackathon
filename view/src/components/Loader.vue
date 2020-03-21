<template>
  <div class="loader">
    <b-spinner v-if="visible" variant="success" label="Spinning"></b-spinner>
  </div>
</template>
<script lang="ts">
import {Component, Prop, Vue} from 'vue-property-decorator';

@Component({})
export default class Loader extends Vue {
  @Prop() public visible: boolean = false;
}
</script>
<style scoped>
  .loader {
    position: absolute;
    left: 50%;
    top: 50%;
  }
</style>