<template>
  <div class="home">
    <b-form>
      <b-container>
        <ShopDetail/>
      </b-container>
      <b-container>
        <b-row>
          <b-col><label>Choose a date</label></b-col>
          <b-col cols="8"><b-form-datepicker v-model="selectedDate" class="mb-2"></b-form-datepicker></b-col>
        </b-row>
      </b-container>
    </b-form>
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
    public selectedDate: string = "";
  }
</script>
